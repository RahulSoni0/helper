package kotlinx.coroutines.channels;

import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.ConcurrentKt;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u00019B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"H\u0017J\u0018\u0010 \u001a\u00020#2\u000e\u0010!\u001a\n\u0018\u00010$j\u0004\u0018\u0001`%H\u0016J\u0012\u0010&\u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010'\u001a\u00020#H\u0002J\u0012\u0010(\u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010)\u001a\u00020\u0015H\u0002J\u0015\u0010*\u001a\u00028\u00002\u0006\u0010+\u001a\u00020\u0015H\u0002¢\u0006\u0002\u0010,J\u0015\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010/J!\u00100\u001a\u00020\t2\u0006\u0010.\u001a\u00028\u00002\n\u00101\u001a\u0006\u0012\u0002\b\u000302H\u0014¢\u0006\u0002\u00103J\u000e\u00104\u001a\b\u0012\u0004\u0012\u00028\u000005H\u0016J-\u00106\u001a\u00020#2\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001d2\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001dH\u0010R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8TX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178TX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00178TX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R*\u0010\u001b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d0\u001cj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d`\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, mo18301d2 = {"Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "E", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "capacity", "", "(I)V", "buffer", "", "", "[Ljava/lang/Object;", "bufferDebugString", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "getCapacity", "()I", "head", "", "isBufferAlwaysFull", "", "()Z", "isBufferFull", "size", "subscribers", "", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "Lkotlinx/coroutines/internal/SubscribersList;", "tail", "cancel", "cause", "", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "checkSubOffers", "close", "computeMinHead", "elementAt", "index", "(J)Ljava/lang/Object;", "offerInternal", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "updateHead", "addSub", "removeSub", "Subscriber", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
/* compiled from: ArrayBroadcastChannel.kt */
public final class ArrayBroadcastChannel<E> extends AbstractSendChannel<E> implements BroadcastChannel<E> {
    private final Object[] buffer;
    private final ReentrantLock bufferLock;
    private final int capacity;
    private volatile long head;
    private volatile int size;
    private final List<Subscriber<E>> subscribers;
    /* access modifiers changed from: private */
    public volatile long tail;

    /* access modifiers changed from: protected */
    public boolean isBufferAlwaysFull() {
        return false;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public ArrayBroadcastChannel(int i) {
        this.capacity = i;
        if (i < 1 ? false : true) {
            this.bufferLock = new ReentrantLock();
            this.buffer = new Object[i];
            this.subscribers = ConcurrentKt.subscriberList();
            return;
        }
        throw new IllegalArgumentException(("ArrayBroadcastChannel capacity must be at least 1, but " + i + " was specified").toString());
    }

    /* access modifiers changed from: protected */
    public boolean isBufferFull() {
        return this.size >= this.capacity;
    }

    public ReceiveChannel<E> openSubscription() {
        Subscriber subscriber = new Subscriber(this);
        updateHead$default(this, subscriber, (Subscriber) null, 2, (Object) null);
        return subscriber;
    }

    public boolean close(Throwable th) {
        if (!super.close(th)) {
            return false;
        }
        checkSubOffers();
        return true;
    }

    public void cancel(CancellationException cancellationException) {
        cancel(cancellationException);
    }

    /* access modifiers changed from: private */
    /* renamed from: cancelInternal */
    public final boolean cancel(Throwable th) {
        boolean close = close(th);
        for (Subscriber<E> cancelInternal$kotlinx_coroutines_core : this.subscribers) {
            cancelInternal$kotlinx_coroutines_core.cancelInternal$kotlinx_coroutines_core(th);
        }
        return close;
    }

    /* access modifiers changed from: protected */
    public Object offerInternal(E e) {
        Lock lock = this.bufferLock;
        lock.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            int i = this.size;
            if (i >= this.capacity) {
                Object obj = AbstractChannelKt.OFFER_FAILED;
                lock.unlock();
                return obj;
            }
            long j = this.tail;
            this.buffer[(int) (j % ((long) this.capacity))] = e;
            this.size = i + 1;
            this.tail = j + 1;
            Unit unit = Unit.INSTANCE;
            lock.unlock();
            checkSubOffers();
            return AbstractChannelKt.OFFER_SUCCESS;
        } finally {
            lock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public Object offerSelectInternal(E e, SelectInstance<?> selectInstance) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        Lock lock = this.bufferLock;
        lock.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            int i = this.size;
            if (i >= this.capacity) {
                Object obj = AbstractChannelKt.OFFER_FAILED;
                lock.unlock();
                return obj;
            } else if (!selectInstance.trySelect((Object) null)) {
                Object already_selected = SelectKt.getALREADY_SELECTED();
                lock.unlock();
                return already_selected;
            } else {
                long j = this.tail;
                this.buffer[(int) (j % ((long) this.capacity))] = e;
                this.size = i + 1;
                this.tail = j + 1;
                Unit unit = Unit.INSTANCE;
                lock.unlock();
                checkSubOffers();
                return AbstractChannelKt.OFFER_SUCCESS;
            }
        } finally {
            lock.unlock();
        }
    }

    private final void checkSubOffers() {
        boolean z = false;
        boolean z2 = false;
        for (Subscriber<E> checkOffer : this.subscribers) {
            if (checkOffer.checkOffer()) {
                z = true;
            }
            z2 = true;
        }
        if (z || !z2) {
            updateHead$default(this, (Subscriber) null, (Subscriber) null, 3, (Object) null);
        }
    }

    static /* synthetic */ void updateHead$default(ArrayBroadcastChannel arrayBroadcastChannel, Subscriber subscriber, Subscriber subscriber2, int i, Object obj) {
        if ((i & 1) != 0) {
            Subscriber subscriber3 = null;
            subscriber = null;
        }
        if ((i & 2) != 0) {
            Subscriber subscriber4 = null;
            subscriber2 = null;
        }
        arrayBroadcastChannel.updateHead(subscriber, subscriber2);
    }

    private final void updateHead(Subscriber<E> subscriber, Subscriber<E> subscriber2) {
        Send takeFirstSendOrPeekClosed;
        Object tryResumeSend;
        while (true) {
            Send send = null;
            Lock lock = this.bufferLock;
            lock.lock();
            if (subscriber != null) {
                try {
                    subscriber.subHead = this.tail;
                    boolean isEmpty = this.subscribers.isEmpty();
                    this.subscribers.add(subscriber);
                    if (!isEmpty) {
                        return;
                    }
                } finally {
                    lock.unlock();
                }
            }
            if (subscriber2 != null) {
                this.subscribers.remove(subscriber2);
                if (this.head != subscriber2.subHead) {
                    lock.unlock();
                    return;
                }
            }
            long computeMinHead = computeMinHead();
            long j = this.tail;
            long j2 = this.head;
            long coerceAtMost = RangesKt.coerceAtMost(computeMinHead, j);
            if (coerceAtMost <= j2) {
                lock.unlock();
                return;
            }
            int i = this.size;
            while (j2 < coerceAtMost) {
                Object[] objArr = this.buffer;
                int i2 = this.capacity;
                objArr[(int) (j2 % ((long) i2))] = null;
                boolean z = i >= i2;
                j2++;
                this.head = j2;
                i--;
                this.size = i;
                if (z) {
                    do {
                        takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
                        if (takeFirstSendOrPeekClosed == null) {
                            continue;
                        } else if (!(takeFirstSendOrPeekClosed instanceof Closed)) {
                            if (takeFirstSendOrPeekClosed == null) {
                                Intrinsics.throwNpe();
                            }
                            tryResumeSend = takeFirstSendOrPeekClosed.tryResumeSend((Object) null);
                        }
                    } while (tryResumeSend == null);
                    Object[] objArr2 = this.buffer;
                    int i3 = (int) (j % ((long) this.capacity));
                    if (takeFirstSendOrPeekClosed != null) {
                        objArr2[i3] = takeFirstSendOrPeekClosed.getPollResult();
                        this.size = i + 1;
                        this.tail = j + 1;
                        Unit unit = Unit.INSTANCE;
                        lock.unlock();
                        if (takeFirstSendOrPeekClosed == null) {
                            Intrinsics.throwNpe();
                        }
                        takeFirstSendOrPeekClosed.completeResumeSend(tryResumeSend);
                        checkSubOffers();
                        subscriber = null;
                        subscriber2 = null;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
                    }
                }
            }
            lock.unlock();
            return;
        }
    }

    private final long computeMinHead() {
        long j = LongCompanionObject.MAX_VALUE;
        for (Subscriber<E> subscriber : this.subscribers) {
            j = RangesKt.coerceAtMost(j, subscriber.subHead);
        }
        return j;
    }

    /* access modifiers changed from: private */
    public final E elementAt(long j) {
        return this.buffer[(int) (j % ((long) this.capacity))];
    }

    @Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0010¢\u0006\u0002\b\u0015J\u0006\u0010\u0016\u001a\u00020\bJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014J\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001fH\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8TX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0014\u0010\n\u001a\u00020\b8TX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\b8TX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\b8TX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\tR\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, mo18301d2 = {"Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "broadcastChannel", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel;)V", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "subHead", "", "subLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "cancelInternal", "cause", "", "cancelInternal$kotlinx_coroutines_core", "checkOffer", "clearBuffer", "", "needsToCheckOfferWithoutLock", "peekUnderLock", "", "pollInternal", "pollSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
    /* compiled from: ArrayBroadcastChannel.kt */
    private static final class Subscriber<E> extends AbstractChannel<E> implements ReceiveChannel<E> {
        private final ArrayBroadcastChannel<E> broadcastChannel;
        public volatile long subHead;
        private final ReentrantLock subLock = new ReentrantLock();

        /* access modifiers changed from: protected */
        public boolean isBufferAlwaysEmpty() {
            return false;
        }

        public Subscriber(ArrayBroadcastChannel<E> arrayBroadcastChannel) {
            Intrinsics.checkParameterIsNotNull(arrayBroadcastChannel, "broadcastChannel");
            this.broadcastChannel = arrayBroadcastChannel;
        }

        /* access modifiers changed from: protected */
        public boolean isBufferEmpty() {
            return this.subHead >= this.broadcastChannel.tail;
        }

        /* access modifiers changed from: protected */
        public boolean isBufferAlwaysFull() {
            throw new IllegalStateException("Should not be used".toString());
        }

        /* access modifiers changed from: protected */
        public boolean isBufferFull() {
            throw new IllegalStateException("Should not be used".toString());
        }

        public boolean cancelInternal$kotlinx_coroutines_core(Throwable th) {
            boolean close = close(th);
            if (close) {
                ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, (Subscriber) null, this, 1, (Object) null);
            }
            clearBuffer();
            return close;
        }

        private final void clearBuffer() {
            Lock lock = this.subLock;
            lock.lock();
            try {
                this.subHead = this.broadcastChannel.tail;
                Unit unit = Unit.INSTANCE;
            } finally {
                lock.unlock();
            }
        }

        public final boolean checkOffer() {
            Closed closed = null;
            Closed closed2 = null;
            boolean z = false;
            while (true) {
                if (!needsToCheckOfferWithoutLock() || !this.subLock.tryLock()) {
                    break;
                }
                try {
                    Object peekUnderLock = peekUnderLock();
                    if (peekUnderLock != AbstractChannelKt.POLL_FAILED) {
                        if (peekUnderLock instanceof Closed) {
                            closed = peekUnderLock;
                            break;
                        }
                        ReceiveOrClosed takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                        if (takeFirstReceiveOrPeekClosed == null) {
                            break;
                        } else if (takeFirstReceiveOrPeekClosed instanceof Closed) {
                            break;
                        } else {
                            Object tryResumeReceive = takeFirstReceiveOrPeekClosed.tryResumeReceive(peekUnderLock, (Object) null);
                            if (tryResumeReceive != null) {
                                this.subHead++;
                                z = true;
                                this.subLock.unlock();
                                if (takeFirstReceiveOrPeekClosed == null) {
                                    Intrinsics.throwNpe();
                                }
                                takeFirstReceiveOrPeekClosed.completeResumeReceive(tryResumeReceive);
                            }
                        }
                    }
                } finally {
                    this.subLock.unlock();
                }
            }
            this.subLock.unlock();
            if (closed != null) {
                close(closed.closeCause);
            }
            return z;
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0029  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x002e  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x003a  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x003d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object pollInternal() {
            /*
                r8 = this;
                java.util.concurrent.locks.ReentrantLock r0 = r8.subLock
                java.util.concurrent.locks.Lock r0 = (java.util.concurrent.locks.Lock) r0
                r0.lock()
                java.lang.Object r1 = r8.peekUnderLock()     // Catch:{ all -> 0x0044 }
                boolean r2 = r1 instanceof kotlinx.coroutines.channels.Closed     // Catch:{ all -> 0x0044 }
                r3 = 1
                if (r2 == 0) goto L_0x0011
                goto L_0x0015
            L_0x0011:
                java.lang.Object r2 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x0044 }
                if (r1 != r2) goto L_0x0017
            L_0x0015:
                r2 = 0
                goto L_0x001f
            L_0x0017:
                long r4 = r8.subHead     // Catch:{ all -> 0x0044 }
                r6 = 1
                long r4 = r4 + r6
                r8.subHead = r4     // Catch:{ all -> 0x0044 }
                r2 = 1
            L_0x001f:
                r0.unlock()
                boolean r0 = r1 instanceof kotlinx.coroutines.channels.Closed
                r4 = 0
                if (r0 != 0) goto L_0x0029
                r0 = r4
                goto L_0x002a
            L_0x0029:
                r0 = r1
            L_0x002a:
                kotlinx.coroutines.channels.Closed r0 = (kotlinx.coroutines.channels.Closed) r0
                if (r0 == 0) goto L_0x0033
                java.lang.Throwable r0 = r0.closeCause
                r8.close(r0)
            L_0x0033:
                boolean r0 = r8.checkOffer()
                if (r0 == 0) goto L_0x003a
                goto L_0x003b
            L_0x003a:
                r3 = r2
            L_0x003b:
                if (r3 == 0) goto L_0x0043
                kotlinx.coroutines.channels.ArrayBroadcastChannel<E> r0 = r8.broadcastChannel
                r2 = 3
                kotlinx.coroutines.channels.ArrayBroadcastChannel.updateHead$default(r0, r4, r4, r2, r4)
            L_0x0043:
                return r1
            L_0x0044:
                r1 = move-exception
                r0.unlock()
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber.pollInternal():java.lang.Object");
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: protected */
        public Object pollSelectInternal(SelectInstance<?> selectInstance) {
            Intrinsics.checkParameterIsNotNull(selectInstance, "select");
            Lock lock = this.subLock;
            lock.lock();
            try {
                Object peekUnderLock = peekUnderLock();
                boolean z = true;
                boolean z2 = false;
                if (!(peekUnderLock instanceof Closed)) {
                    if (peekUnderLock != AbstractChannelKt.POLL_FAILED) {
                        if (!selectInstance.trySelect((Object) null)) {
                            peekUnderLock = SelectKt.getALREADY_SELECTED();
                        } else {
                            this.subHead++;
                            z2 = true;
                        }
                    }
                }
                lock.unlock();
                Closed closed = (Closed) (!(peekUnderLock instanceof Closed) ? null : peekUnderLock);
                if (closed != null) {
                    close(closed.closeCause);
                }
                if (!checkOffer()) {
                    z = z2;
                }
                if (z) {
                    ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, (Subscriber) null, (Subscriber) null, 3, (Object) null);
                }
                return peekUnderLock;
            } catch (Throwable th) {
                lock.unlock();
                throw th;
            }
        }

        private final boolean needsToCheckOfferWithoutLock() {
            if (getClosedForReceive() != null) {
                return false;
            }
            if (!isBufferEmpty() || this.broadcastChannel.getClosedForReceive() != null) {
                return true;
            }
            return false;
        }

        private final Object peekUnderLock() {
            long j = this.subHead;
            Closed<?> closedForReceive = this.broadcastChannel.getClosedForReceive();
            if (j >= this.broadcastChannel.tail) {
                if (closedForReceive == null) {
                    closedForReceive = getClosedForReceive();
                }
                return closedForReceive != null ? closedForReceive : AbstractChannelKt.POLL_FAILED;
            }
            Object access$elementAt = this.broadcastChannel.elementAt(j);
            Closed<?> closedForReceive2 = getClosedForReceive();
            return closedForReceive2 != null ? closedForReceive2 : access$elementAt;
        }
    }

    /* access modifiers changed from: protected */
    public String getBufferDebugString() {
        return "(buffer:capacity=" + this.buffer.length + ",size=" + this.size + ')';
    }
}
