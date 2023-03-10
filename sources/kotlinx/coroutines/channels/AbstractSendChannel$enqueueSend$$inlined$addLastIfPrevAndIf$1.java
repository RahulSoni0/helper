package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, mo18301d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
/* compiled from: LockFreeLinkedList.kt */
public final class AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1 extends LockFreeLinkedListNode.CondAddOp {
    final /* synthetic */ LockFreeLinkedListNode $node;
    final /* synthetic */ AbstractSendChannel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, AbstractSendChannel abstractSendChannel) {
        super(lockFreeLinkedListNode2);
        this.$node = lockFreeLinkedListNode;
        this.this$0 = abstractSendChannel;
    }

    public Object prepare(LockFreeLinkedListNode lockFreeLinkedListNode) {
        Intrinsics.checkParameterIsNotNull(lockFreeLinkedListNode, "affected");
        if (this.this$0.isBufferFull()) {
            return null;
        }
        return LockFreeLinkedListKt.getCONDITION_FALSE();
    }
}
