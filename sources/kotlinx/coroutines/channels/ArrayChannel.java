package kotlinx.coroutines.channels;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.AbstractSendChannel;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0015\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010!J!\u0010\"\u001a\u00020\b2\u0006\u0010 \u001a\u00028\u00002\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0014¢\u0006\u0002\u0010%J\n\u0010&\u001a\u0004\u0018\u00010\bH\u0014J\u0016\u0010'\u001a\u0004\u0018\u00010\b2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0014R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8TX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00128DX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013R\u0012\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, mo18301d2 = {"Lkotlinx/coroutines/channels/ArrayChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "capacity", "", "(I)V", "buffer", "", "", "[Ljava/lang/Object;", "bufferDebugString", "", "getBufferDebugString", "()Ljava/lang/String;", "getCapacity", "()I", "head", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "size", "cleanupSendQueueOnCancel", "", "ensureCapacity", "currentSize", "offerInternal", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "pollInternal", "pollSelectInternal", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
/* compiled from: ArrayChannel.kt */
public class ArrayChannel<E> extends AbstractChannel<E> {
    private Object[] buffer;
    private final int capacity;
    private int head;
    private final ReentrantLock lock;
    private volatile int size;

    /* access modifiers changed from: protected */
    public final boolean isBufferAlwaysEmpty() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferAlwaysFull() {
        return false;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public ArrayChannel(int i) {
        this.capacity = i;
        if (i < 1 ? false : true) {
            this.lock = new ReentrantLock();
            this.buffer = new Object[Math.min(i, 8)];
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i + " was specified").toString());
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: protected */
    public final boolean isBufferFull() {
        return this.size == this.capacity;
    }

    /* access modifiers changed from: protected */
    public Object offerInternal(E e) {
        ReceiveOrClosed takeFirstReceiveOrPeekClosed;
        Object tryResumeReceive;
        ReceiveOrClosed receiveOrClosed = null;
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            int i = this.size;
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            if (i < this.capacity) {
                this.size = i + 1;
                if (i == 0) {
                    do {
                        takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                        if (takeFirstReceiveOrPeekClosed != null) {
                            if (takeFirstReceiveOrPeekClosed instanceof Closed) {
                                this.size = i;
                                if (takeFirstReceiveOrPeekClosed == null) {
                                    Intrinsics.throwNpe();
                                }
                                lock2.unlock();
                                return takeFirstReceiveOrPeekClosed;
                            }
                            if (takeFirstReceiveOrPeekClosed == null) {
                                Intrinsics.throwNpe();
                            }
                            tryResumeReceive = takeFirstReceiveOrPeekClosed.tryResumeReceive(e, (Object) null);
                        }
                    } while (tryResumeReceive == null);
                    this.size = i;
                    Unit unit = Unit.INSTANCE;
                    lock2.unlock();
                    if (takeFirstReceiveOrPeekClosed == null) {
                        Intrinsics.throwNpe();
                    }
                    takeFirstReceiveOrPeekClosed.completeResumeReceive(tryResumeReceive);
                    if (takeFirstReceiveOrPeekClosed == null) {
                        Intrinsics.throwNpe();
                    }
                    return takeFirstReceiveOrPeekClosed.getOfferResult();
                }
                ensureCapacity(i);
                Object[] objArr = this.buffer;
                objArr[(this.head + i) % objArr.length] = e;
                Object obj = AbstractChannelKt.OFFER_SUCCESS;
                lock2.unlock();
                return obj;
            }
            Object obj2 = AbstractChannelKt.OFFER_FAILED;
            lock2.unlock();
            return obj2;
        } finally {
            lock2.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public Object offerSelectInternal(E e, SelectInstance<?> selectInstance) {
        Intrinsics.checkParameterIsNotNull(selectInstance, "select");
        ReceiveOrClosed receiveOrClosed = null;
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            int i = this.size;
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            if (i < this.capacity) {
                this.size = i + 1;
                if (i == 0) {
                    AbstractSendChannel.TryOfferDesc describeTryOffer = describeTryOffer(e);
                    Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(describeTryOffer);
                    if (performAtomicTrySelect == null) {
                        this.size = i;
                        ReceiveOrClosed receiveOrClosed2 = (ReceiveOrClosed) describeTryOffer.getResult();
                        Object obj = describeTryOffer.resumeToken;
                        if (DebugKt.getASSERTIONS_ENABLED()) {
                            if (!(obj != null)) {
                                throw new AssertionError();
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        lock2.unlock();
                        if (receiveOrClosed2 == null) {
                            Intrinsics.throwNpe();
                        }
                        if (obj == null) {
                            Intrinsics.throwNpe();
                        }
                        receiveOrClosed2.completeResumeReceive(obj);
                        if (receiveOrClosed2 == null) {
                            Intrinsics.throwNpe();
                        }
                        return receiveOrClosed2.getOfferResult();
                    } else if (performAtomicTrySelect != AbstractChannelKt.OFFER_FAILED) {
                        if (performAtomicTrySelect != SelectKt.getALREADY_SELECTED()) {
                            if (!(performAtomicTrySelect instanceof Closed)) {
                                throw new IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + performAtomicTrySelect).toString());
                            }
                        }
                        this.size = i;
                        lock2.unlock();
                        return performAtomicTrySelect;
                    }
                }
                if (!selectInstance.trySelect((Object) null)) {
                    this.size = i;
                    Object already_selected = SelectKt.getALREADY_SELECTED();
                    lock2.unlock();
                    return already_selected;
                }
                ensureCapacity(i);
                Object[] objArr = this.buffer;
                objArr[(this.head + i) % objArr.length] = e;
                Object obj2 = AbstractChannelKt.OFFER_SUCCESS;
                lock2.unlock();
                return obj2;
            }
            Object obj3 = AbstractChannelKt.OFFER_FAILED;
            lock2.unlock();
            return obj3;
        } finally {
            lock2.unlock();
        }
    }

    private final void ensureCapacity(int i) {
        Object[] objArr = this.buffer;
        if (i >= objArr.length) {
            Object[] objArr2 = new Object[Math.min(objArr.length * 2, this.capacity)];
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr3 = this.buffer;
                objArr2[i2] = objArr3[(this.head + i2) % objArr3.length];
            }
            this.buffer = objArr2;
            this.head = 0;
        }
    }

    /* access modifiers changed from: protected */
    public Object pollInternal() {
        Object obj;
        Send send = null;
        Send send2 = null;
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            Object[] objArr = this.buffer;
            int i2 = this.head;
            Object obj2 = objArr[i2];
            objArr[i2] = null;
            this.size = i - 1;
            Object obj3 = AbstractChannelKt.POLL_FAILED;
            if (i == this.capacity) {
                Send send3 = null;
                obj = null;
                while (true) {
                    Send takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
                    if (takeFirstSendOrPeekClosed == null) {
                        send = send3;
                        break;
                    }
                    if (takeFirstSendOrPeekClosed == null) {
                        Intrinsics.throwNpe();
                    }
                    obj = takeFirstSendOrPeekClosed.tryResumeSend((Object) null);
                    if (obj != null) {
                        if (takeFirstSendOrPeekClosed == null) {
                            Intrinsics.throwNpe();
                        }
                        obj3 = takeFirstSendOrPeekClosed.getPollResult();
                        send = takeFirstSendOrPeekClosed;
                    } else {
                        send3 = takeFirstSendOrPeekClosed;
                    }
                }
            } else {
                obj = null;
            }
            if (obj3 != AbstractChannelKt.POLL_FAILED && !(obj3 instanceof Closed)) {
                this.size = i;
                Object[] objArr2 = this.buffer;
                objArr2[(this.head + i) % objArr2.length] = obj3;
            }
            this.head = (this.head + 1) % this.buffer.length;
            Unit unit = Unit.INSTANCE;
            lock2.unlock();
            if (obj != null) {
                if (send == null) {
                    Intrinsics.throwNpe();
                }
                send.completeResumeSend(obj);
            }
            return obj2;
        } finally {
            lock2.unlock();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ba A[Catch:{ all -> 0x00f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c6 A[Catch:{ all -> 0x00f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object pollSelectInternal(kotlinx.coroutines.selects.SelectInstance<?> r11) {
        /*
            r10 = this;
            java.lang.String r0 = "select"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r11, r0)
            r0 = 0
            r1 = r0
            kotlinx.coroutines.channels.Send r1 = (kotlinx.coroutines.channels.Send) r1
            java.util.concurrent.locks.ReentrantLock r1 = r10.lock
            java.util.concurrent.locks.Lock r1 = (java.util.concurrent.locks.Lock) r1
            r1.lock()
            int r2 = r10.size     // Catch:{ all -> 0x00f5 }
            if (r2 != 0) goto L_0x0021
            kotlinx.coroutines.channels.Closed r11 = r10.getClosedForSend()     // Catch:{ all -> 0x00f5 }
            if (r11 == 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            java.lang.Object r11 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x00f5 }
        L_0x001d:
            r1.unlock()
            return r11
        L_0x0021:
            java.lang.Object[] r3 = r10.buffer     // Catch:{ all -> 0x00f5 }
            int r4 = r10.head     // Catch:{ all -> 0x00f5 }
            r5 = r3[r4]     // Catch:{ all -> 0x00f5 }
            r3[r4] = r0     // Catch:{ all -> 0x00f5 }
            int r3 = r2 + -1
            r10.size = r3     // Catch:{ all -> 0x00f5 }
            java.lang.Object r3 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x00f5 }
            int r4 = r10.capacity     // Catch:{ all -> 0x00f5 }
            r6 = 1
            if (r2 != r4) goto L_0x00b0
            kotlinx.coroutines.channels.AbstractChannel$TryPollDesc r4 = r10.describeTryPoll()     // Catch:{ all -> 0x00f5 }
            r7 = r4
            kotlinx.coroutines.internal.AtomicDesc r7 = (kotlinx.coroutines.internal.AtomicDesc) r7     // Catch:{ all -> 0x00f5 }
            java.lang.Object r7 = r11.performAtomicTrySelect(r7)     // Catch:{ all -> 0x00f5 }
            if (r7 != 0) goto L_0x006d
            java.lang.Object r3 = r4.getResult()     // Catch:{ all -> 0x00f5 }
            kotlinx.coroutines.channels.Send r3 = (kotlinx.coroutines.channels.Send) r3     // Catch:{ all -> 0x00f5 }
            java.lang.Object r4 = r4.resumeToken     // Catch:{ all -> 0x00f5 }
            boolean r7 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()     // Catch:{ all -> 0x00f5 }
            if (r7 == 0) goto L_0x005f
            if (r4 == 0) goto L_0x0053
            r7 = 1
            goto L_0x0054
        L_0x0053:
            r7 = 0
        L_0x0054:
            if (r7 == 0) goto L_0x0057
            goto L_0x005f
        L_0x0057:
            java.lang.AssertionError r11 = new java.lang.AssertionError     // Catch:{ all -> 0x00f5 }
            r11.<init>()     // Catch:{ all -> 0x00f5 }
            java.lang.Throwable r11 = (java.lang.Throwable) r11     // Catch:{ all -> 0x00f5 }
            throw r11     // Catch:{ all -> 0x00f5 }
        L_0x005f:
            if (r3 != 0) goto L_0x0064
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x00f5 }
        L_0x0064:
            java.lang.Object r7 = r3.getPollResult()     // Catch:{ all -> 0x00f5 }
        L_0x0068:
            r9 = r4
            r4 = r3
            r3 = r7
            r7 = r9
            goto L_0x00b2
        L_0x006d:
            java.lang.Object r4 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x00f5 }
            if (r7 != r4) goto L_0x0072
            goto L_0x00b0
        L_0x0072:
            java.lang.Object r3 = kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()     // Catch:{ all -> 0x00f5 }
            if (r7 != r3) goto L_0x0084
            r10.size = r2     // Catch:{ all -> 0x00f5 }
            java.lang.Object[] r11 = r10.buffer     // Catch:{ all -> 0x00f5 }
            int r0 = r10.head     // Catch:{ all -> 0x00f5 }
            r11[r0] = r5     // Catch:{ all -> 0x00f5 }
            r1.unlock()
            return r7
        L_0x0084:
            boolean r3 = r7 instanceof kotlinx.coroutines.channels.Closed     // Catch:{ all -> 0x00f5 }
            if (r3 == 0) goto L_0x0093
            r3 = r7
            kotlinx.coroutines.channels.Send r3 = (kotlinx.coroutines.channels.Send) r3     // Catch:{ all -> 0x00f5 }
            r4 = r7
            kotlinx.coroutines.channels.Closed r4 = (kotlinx.coroutines.channels.Closed) r4     // Catch:{ all -> 0x00f5 }
            java.lang.Object r4 = r4.tryResumeSend(r0)     // Catch:{ all -> 0x00f5 }
            goto L_0x0068
        L_0x0093:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f5 }
            r11.<init>()     // Catch:{ all -> 0x00f5 }
            java.lang.String r0 = "performAtomicTrySelect(describeTryOffer) returned "
            r11.append(r0)     // Catch:{ all -> 0x00f5 }
            r11.append(r7)     // Catch:{ all -> 0x00f5 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00f5 }
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00f5 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00f5 }
            r0.<init>(r11)     // Catch:{ all -> 0x00f5 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x00f5 }
            throw r0     // Catch:{ all -> 0x00f5 }
        L_0x00b0:
            r4 = r0
            r7 = r4
        L_0x00b2:
            java.lang.Object r8 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch:{ all -> 0x00f5 }
            if (r3 == r8) goto L_0x00c6
            boolean r8 = r3 instanceof kotlinx.coroutines.channels.Closed     // Catch:{ all -> 0x00f5 }
            if (r8 != 0) goto L_0x00c6
            r10.size = r2     // Catch:{ all -> 0x00f5 }
            java.lang.Object[] r11 = r10.buffer     // Catch:{ all -> 0x00f5 }
            int r0 = r10.head     // Catch:{ all -> 0x00f5 }
            int r0 = r0 + r2
            int r2 = r11.length     // Catch:{ all -> 0x00f5 }
            int r0 = r0 % r2
            r11[r0] = r3     // Catch:{ all -> 0x00f5 }
            goto L_0x00dc
        L_0x00c6:
            boolean r11 = r11.trySelect(r0)     // Catch:{ all -> 0x00f5 }
            if (r11 != 0) goto L_0x00dc
            r10.size = r2     // Catch:{ all -> 0x00f5 }
            java.lang.Object[] r11 = r10.buffer     // Catch:{ all -> 0x00f5 }
            int r0 = r10.head     // Catch:{ all -> 0x00f5 }
            r11[r0] = r5     // Catch:{ all -> 0x00f5 }
            java.lang.Object r11 = kotlinx.coroutines.selects.SelectKt.getALREADY_SELECTED()     // Catch:{ all -> 0x00f5 }
            r1.unlock()
            return r11
        L_0x00dc:
            int r11 = r10.head     // Catch:{ all -> 0x00f5 }
            int r11 = r11 + r6
            java.lang.Object[] r0 = r10.buffer     // Catch:{ all -> 0x00f5 }
            int r0 = r0.length     // Catch:{ all -> 0x00f5 }
            int r11 = r11 % r0
            r10.head = r11     // Catch:{ all -> 0x00f5 }
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00f5 }
            r1.unlock()
            if (r7 == 0) goto L_0x00f4
            if (r4 != 0) goto L_0x00f1
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00f1:
            r4.completeResumeSend(r7)
        L_0x00f4:
            return r5
        L_0x00f5:
            r11 = move-exception
            r1.unlock()
            goto L_0x00fb
        L_0x00fa:
            throw r11
        L_0x00fb:
            goto L_0x00fa
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayChannel.pollSelectInternal(kotlinx.coroutines.selects.SelectInstance):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public void cleanupSendQueueOnCancel() {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            int i = this.size;
            for (int i2 = 0; i2 < i; i2++) {
                this.buffer[this.head] = 0;
                this.head = (this.head + 1) % this.buffer.length;
            }
            this.size = 0;
            Unit unit = Unit.INSTANCE;
            lock2.unlock();
            super.cleanupSendQueueOnCancel();
        } catch (Throwable th) {
            lock2.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public String getBufferDebugString() {
        return "(buffer:capacity=" + this.capacity + ",size=" + this.size + ')';
    }
}
