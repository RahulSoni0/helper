package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.AbstractSendChannel;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0002J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0014¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\u001b\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a2\u0006\u0010\u0010\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0004\u001a\u00020\u00058DX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00058DX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00058DX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00058DX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006¨\u0006\u001c"}, mo18301d2 = {"Lkotlinx/coroutines/channels/ConflatedChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "()V", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "conflatePreviousSendBuffered", "", "node", "Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "offerInternal", "", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "onClosedIdempotent", "closed", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "sendConflated", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ReceiveOrClosed;", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
/* compiled from: ConflatedChannel.kt */
public class ConflatedChannel<E> extends AbstractChannel<E> {
    /* access modifiers changed from: protected */
    public final boolean isBufferAlwaysEmpty() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferAlwaysFull() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferEmpty() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferFull() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onClosedIdempotent(LockFreeLinkedListNode lockFreeLinkedListNode) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "closed");
        LockFreeLinkedListNode prevNode = lockFreeLinkedListNode.getPrevNode();
        if (!(prevNode instanceof AbstractSendChannel.SendBuffered)) {
            prevNode = null;
        }
        AbstractSendChannel.SendBuffered sendBuffered = (AbstractSendChannel.SendBuffered) prevNode;
        if (sendBuffered != null) {
            conflatePreviousSendBuffered(sendBuffered);
        }
    }

    private final ReceiveOrClosed<?> sendConflated(E e) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        AbstractSendChannel.SendBuffered sendBuffered = new AbstractSendChannel.SendBuffered(e);
        LockFreeLinkedListHead queue = getQueue();
        do {
            Object prev = queue.getPrev();
            if (prev != null) {
                lockFreeLinkedListNode = (LockFreeLinkedListNode) prev;
                if (lockFreeLinkedListNode instanceof ReceiveOrClosed) {
                    return (ReceiveOrClosed) lockFreeLinkedListNode;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!lockFreeLinkedListNode.addNext(sendBuffered, queue));
        conflatePreviousSendBuffered(sendBuffered);
        return null;
    }

    private final void conflatePreviousSendBuffered(AbstractSendChannel.SendBuffered<? extends E> sendBuffered) {
        for (LockFreeLinkedListNode prevNode = sendBuffered.getPrevNode(); prevNode instanceof AbstractSendChannel.SendBuffered; prevNode = prevNode.getPrevNode()) {
            if (!prevNode.remove()) {
                prevNode.helpRemove();
            }
        }
    }

    /* access modifiers changed from: protected */
    public Object offerInternal(E e) {
        ReceiveOrClosed<?> sendConflated;
        do {
            Object offerInternal = super.offerInternal(e);
            if (offerInternal == AbstractChannelKt.OFFER_SUCCESS) {
                return AbstractChannelKt.OFFER_SUCCESS;
            }
            if (offerInternal == AbstractChannelKt.OFFER_FAILED) {
                sendConflated = sendConflated(e);
                if (sendConflated == null) {
                    return AbstractChannelKt.OFFER_SUCCESS;
                }
            } else if (offerInternal instanceof Closed) {
                return offerInternal;
            } else {
                throw new IllegalStateException(("Invalid offerInternal result " + offerInternal).toString());
            }
        } while (!(sendConflated instanceof Closed));
        return sendConflated;
    }

    /* access modifiers changed from: protected */
    public Object offerSelectInternal(E e, SelectInstance<?> selectInstance) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        do {
            if (getHasReceiveOrClosed()) {
                obj = super.offerSelectInternal(e, selectInstance);
            } else {
                obj = selectInstance.performAtomicTrySelect(describeSendConflated(e));
                if (obj == null) {
                    obj = AbstractChannelKt.OFFER_SUCCESS;
                }
            }
            if (obj == SelectKt.getALREADY_SELECTED()) {
                return SelectKt.getALREADY_SELECTED();
            }
            if (obj == AbstractChannelKt.OFFER_SUCCESS) {
                return AbstractChannelKt.OFFER_SUCCESS;
            }
        } while (obj == AbstractChannelKt.OFFER_FAILED);
        if (obj instanceof Closed) {
            return obj;
        }
        throw new IllegalStateException(("Invalid result " + obj).toString());
    }
}
