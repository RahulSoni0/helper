package kotlinx.coroutines;

import androidx.work.impl.utils.futures.C0842x3bb65290;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b \u0018\u00002\u00020\u00012\u00020\u0002:\u00044567B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\r\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00052\n\u0010\u0010\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\u00020\u00132\n\u0010\u0010\u001a\u00060\u0007j\u0002`\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\u001a\u0010\u0004J\u001d\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b!\u0010\"J#\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\u00162\n\u0010\r\u001a\u00060\u0007j\u0002`\bH\u0004¢\u0006\u0004\b%\u0010&J%\u0010)\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00162\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050'H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u001cH\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0005H\u0014¢\u0006\u0004\b-\u0010\u0004R\u0016\u0010.\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\u00138T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0016\u00103\u001a\u00020\u00168T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0018¨\u00068"}, mo18301d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;", "<init>", "()V", "", "closeQueue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "", "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "isCompleted", "Z", "isEmpty", "()Z", "getNextTime", "nextTime", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
/* compiled from: EventLoop.common.kt */
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {
    private static final AtomicReferenceFieldUpdater _delayed$FU;
    private static final AtomicReferenceFieldUpdater _queue$FU;
    private volatile Object _delayed = null;
    private volatile Object _queue = null;
    /* access modifiers changed from: private */
    public volatile boolean isCompleted;

    static {
        Class<EventLoopImplBase> cls = EventLoopImplBase.class;
        _queue$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_queue");
        _delayed$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_delayed");
    }

    public Object delay(long j, Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.delay(this, j, continuation);
    }

    public DisposableHandle invokeOnTimeout(long j, Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        return Delay.DefaultImpls.invokeOnTimeout(this, j, runnable);
    }

    /* access modifiers changed from: protected */
    public boolean isEmpty() {
        if (!isUnconfinedQueueEmpty()) {
            return false;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue != null && !delayedTaskQueue.isEmpty()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof LockFreeTaskQueueCore) {
                return ((LockFreeTaskQueueCore) obj).isEmpty();
            }
            if (obj == EventLoop_commonKt.CLOSED_EMPTY) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public long getNextTime() {
        DelayedTask delayedTask;
        if (super.getNextTime() == 0) {
            return 0;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof LockFreeTaskQueueCore) {
                if (!((LockFreeTaskQueueCore) obj).isEmpty()) {
                    return 0;
                }
            } else if (obj == EventLoop_commonKt.CLOSED_EMPTY) {
                return LongCompanionObject.MAX_VALUE;
            } else {
                return 0;
            }
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue == null || (delayedTask = (DelayedTask) delayedTaskQueue.peek()) == null) {
            return LongCompanionObject.MAX_VALUE;
        }
        long j = delayedTask.nanoTime;
        TimeSource timeSource = TimeSourceKt.getTimeSource();
        return RangesKt.coerceAtLeast(j - (timeSource != null ? timeSource.nanoTime() : System.nanoTime()), 0);
    }

    /* access modifiers changed from: protected */
    public void shutdown() {
        ThreadLocalEventLoop.INSTANCE.resetEventLoop$kotlinx_coroutines_core();
        this.isCompleted = true;
        closeQueue();
        do {
        } while (processNextEvent() <= 0);
        rescheduleAllDelayed();
    }

    public void scheduleResumeAfterDelay(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        Intrinsics.checkParameterIsNotNull(cancellableContinuation, "continuation");
        long delayToNanos = EventLoop_commonKt.delayToNanos(j);
        if (delayToNanos < 4611686018427387903L) {
            TimeSource timeSource = TimeSourceKt.getTimeSource();
            long nanoTime = timeSource != null ? timeSource.nanoTime() : System.nanoTime();
            DelayedResumeTask delayedResumeTask = new DelayedResumeTask(this, delayToNanos + nanoTime, cancellableContinuation);
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuation, delayedResumeTask);
            schedule(nanoTime, delayedResumeTask);
        }
    }

    /* access modifiers changed from: protected */
    public final DisposableHandle scheduleInvokeOnTimeout(long j, Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        long delayToNanos = EventLoop_commonKt.delayToNanos(j);
        if (delayToNanos >= 4611686018427387903L) {
            return NonDisposableHandle.INSTANCE;
        }
        TimeSource timeSource = TimeSourceKt.getTimeSource();
        long nanoTime = timeSource != null ? timeSource.nanoTime() : System.nanoTime();
        DelayedRunnableTask delayedRunnableTask = new DelayedRunnableTask(delayToNanos + nanoTime, runnable);
        schedule(nanoTime, delayedRunnableTask);
        return delayedRunnableTask;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long processNextEvent() {
        /*
            r7 = this;
            boolean r0 = r7.processUnconfinedEvent()
            if (r0 == 0) goto L_0x000b
            long r0 = r7.getNextTime()
            return r0
        L_0x000b:
            java.lang.Object r0 = r7._delayed
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r0 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r0
            if (r0 == 0) goto L_0x0051
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0051
            kotlinx.coroutines.TimeSource r1 = kotlinx.coroutines.TimeSourceKt.getTimeSource()
            if (r1 == 0) goto L_0x0022
            long r1 = r1.nanoTime()
            goto L_0x0026
        L_0x0022:
            long r1 = java.lang.System.nanoTime()
        L_0x0026:
            monitor-enter(r0)
            kotlinx.coroutines.internal.ThreadSafeHeapNode r3 = r0.firstImpl()     // Catch:{ all -> 0x004e }
            r4 = 0
            if (r3 == 0) goto L_0x0048
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r3 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r3     // Catch:{ all -> 0x004e }
            boolean r5 = r3.timeToExecute(r1)     // Catch:{ all -> 0x004e }
            r6 = 0
            if (r5 == 0) goto L_0x003e
            java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch:{ all -> 0x004e }
            boolean r3 = r7.enqueueImpl(r3)     // Catch:{ all -> 0x004e }
            goto L_0x003f
        L_0x003e:
            r3 = 0
        L_0x003f:
            if (r3 == 0) goto L_0x0046
            kotlinx.coroutines.internal.ThreadSafeHeapNode r3 = r0.removeAtImpl(r6)     // Catch:{ all -> 0x004e }
            r4 = r3
        L_0x0046:
            monitor-exit(r0)
            goto L_0x0049
        L_0x0048:
            monitor-exit(r0)
        L_0x0049:
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r4 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r4
            if (r4 == 0) goto L_0x0051
            goto L_0x0026
        L_0x004e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0051:
            java.lang.Runnable r0 = r7.dequeue()
            if (r0 == 0) goto L_0x005a
            r0.run()
        L_0x005a:
            long r0 = r7.getNextTime()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.processNextEvent():long");
    }

    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        enqueue(runnable);
    }

    public final void enqueue(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "task");
        if (enqueueImpl(runnable)) {
            unpark();
        } else {
            DefaultExecutor.INSTANCE.enqueue(runnable);
        }
    }

    private final void closeQueue() {
        if (!DebugKt.getASSERTIONS_ENABLED() || this.isCompleted) {
            while (true) {
                Object obj = this._queue;
                if (obj == null) {
                    if (C0842x3bb65290.m23m(_queue$FU, this, (Object) null, EventLoop_commonKt.CLOSED_EMPTY)) {
                        return;
                    }
                } else if (obj instanceof LockFreeTaskQueueCore) {
                    ((LockFreeTaskQueueCore) obj).close();
                    return;
                } else if (obj != EventLoop_commonKt.CLOSED_EMPTY) {
                    LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                    if (obj != null) {
                        lockFreeTaskQueueCore.addLast((Runnable) obj);
                        if (C0842x3bb65290.m23m(_queue$FU, this, obj, lockFreeTaskQueueCore)) {
                            return;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    public final void schedule(long j, DelayedTask delayedTask) {
        Intrinsics.checkParameterIsNotNull(delayedTask, "delayedTask");
        int scheduleImpl = scheduleImpl(j, delayedTask);
        if (scheduleImpl != 0) {
            if (scheduleImpl == 1) {
                reschedule(j, delayedTask);
            } else if (scheduleImpl != 2) {
                throw new IllegalStateException("unexpected result".toString());
            }
        } else if (shouldUnpark(delayedTask)) {
            unpark();
        }
    }

    private final boolean shouldUnpark(DelayedTask delayedTask) {
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        return (delayedTaskQueue != null ? (DelayedTask) delayedTaskQueue.peek() : null) == delayedTask;
    }

    private final int scheduleImpl(long j, DelayedTask delayedTask) {
        if (this.isCompleted) {
            return 1;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue == null) {
            EventLoopImplBase eventLoopImplBase = this;
            C0842x3bb65290.m23m(_delayed$FU, this, (Object) null, new DelayedTaskQueue(j));
            Object obj = this._delayed;
            if (obj == null) {
                Intrinsics.throwNpe();
            }
            delayedTaskQueue = (DelayedTaskQueue) obj;
        }
        return delayedTask.scheduleTask(j, delayedTaskQueue, this);
    }

    /* access modifiers changed from: protected */
    public final void resetAll() {
        this._queue = null;
        this._delayed = null;
    }

    private final void rescheduleAllDelayed() {
        DelayedTask delayedTask;
        TimeSource timeSource = TimeSourceKt.getTimeSource();
        long nanoTime = timeSource != null ? timeSource.nanoTime() : System.nanoTime();
        while (true) {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
            if (delayedTaskQueue != null && (delayedTask = (DelayedTask) delayedTaskQueue.removeFirstOrNull()) != null) {
                reschedule(nanoTime, delayedTask);
            } else {
                return;
            }
        }
    }

    @Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0000H\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u0007J\b\u0010$\u001a\u00020%H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R0\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, mo18301d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "nanoTime", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
    /* compiled from: EventLoop.common.kt */
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        private Object _heap;
        private int index = -1;
        public long nanoTime;

        public DelayedTask(long j) {
            this.nanoTime = j;
        }

        public ThreadSafeHeap<?> getHeap() {
            Object obj = this._heap;
            if (!(obj instanceof ThreadSafeHeap)) {
                obj = null;
            }
            return (ThreadSafeHeap) obj;
        }

        public void setHeap(ThreadSafeHeap<?> threadSafeHeap) {
            if (this._heap != EventLoop_commonKt.DISPOSED_TASK) {
                this._heap = threadSafeHeap;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public int getIndex() {
            return this.index;
        }

        public void setIndex(int i) {
            this.index = i;
        }

        public int compareTo(DelayedTask delayedTask) {
            Intrinsics.checkParameterIsNotNull(delayedTask, "other");
            long j = this.nanoTime - delayedTask.nanoTime;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        public final boolean timeToExecute(long j) {
            return j - this.nanoTime >= 0;
        }

        public final synchronized int scheduleTask(long j, DelayedTaskQueue delayedTaskQueue, EventLoopImplBase eventLoopImplBase) {
            Intrinsics.checkParameterIsNotNull(delayedTaskQueue, "delayed");
            Intrinsics.checkParameterIsNotNull(eventLoopImplBase, "eventLoop");
            if (this._heap == EventLoop_commonKt.DISPOSED_TASK) {
                return 2;
            }
            ThreadSafeHeapNode threadSafeHeapNode = this;
            synchronized (delayedTaskQueue) {
                DelayedTask delayedTask = (DelayedTask) delayedTaskQueue.firstImpl();
                if (eventLoopImplBase.isCompleted) {
                    return 1;
                }
                if (delayedTask == null) {
                    delayedTaskQueue.timeNow = j;
                } else {
                    long j2 = delayedTask.nanoTime;
                    if (j2 - j < 0) {
                        j = j2;
                    }
                    if (j - delayedTaskQueue.timeNow > 0) {
                        delayedTaskQueue.timeNow = j;
                    }
                }
                if (this.nanoTime - delayedTaskQueue.timeNow < 0) {
                    this.nanoTime = delayedTaskQueue.timeNow;
                }
                delayedTaskQueue.addImpl(threadSafeHeapNode);
                return 0;
            }
        }

        public final synchronized void dispose() {
            Object obj = this._heap;
            if (obj != EventLoop_commonKt.DISPOSED_TASK) {
                if (!(obj instanceof DelayedTaskQueue)) {
                    obj = null;
                }
                DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) obj;
                if (delayedTaskQueue != null) {
                    delayedTaskQueue.remove(this);
                }
                this._heap = EventLoop_commonKt.DISPOSED_TASK;
            }
        }

        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }
    }

    @Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo18301d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
    /* compiled from: EventLoop.common.kt */
    private final class DelayedResumeTask extends DelayedTask {
        private final CancellableContinuation<Unit> cont;
        final /* synthetic */ EventLoopImplBase this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DelayedResumeTask(EventLoopImplBase eventLoopImplBase, long j, CancellableContinuation<? super Unit> cancellableContinuation) {
            super(j);
            Intrinsics.checkParameterIsNotNull(cancellableContinuation, "cont");
            this.this$0 = eventLoopImplBase;
            this.cont = cancellableContinuation;
        }

        public void run() {
            this.cont.resumeUndispatched(this.this$0, Unit.INSTANCE);
        }

        public String toString() {
            return super.toString() + this.cont.toString();
        }
    }

    @Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo18301d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(JLjava/lang/Runnable;)V", "run", "", "toString", "", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
    /* compiled from: EventLoop.common.kt */
    private static final class DelayedRunnableTask extends DelayedTask {
        private final Runnable block;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DelayedRunnableTask(long j, Runnable runnable) {
            super(j);
            Intrinsics.checkParameterIsNotNull(runnable, "block");
            this.block = runnable;
        }

        public void run() {
            this.block.run();
        }

        public String toString() {
            return super.toString() + this.block.toString();
        }
    }

    @Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo18301d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
    /* compiled from: EventLoop.common.kt */
    public static final class DelayedTaskQueue extends ThreadSafeHeap<DelayedTask> {
        public long timeNow;

        public DelayedTaskQueue(long j) {
            this.timeNow = j;
        }
    }

    private final boolean enqueueImpl(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (this.isCompleted) {
                return false;
            }
            if (obj == null) {
                if (C0842x3bb65290.m23m(_queue$FU, this, (Object) null, runnable)) {
                    return true;
                }
            } else if (obj instanceof LockFreeTaskQueueCore) {
                if (obj != null) {
                    LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                    int addLast = lockFreeTaskQueueCore.addLast(runnable);
                    if (addLast == 0) {
                        return true;
                    }
                    if (addLast == 1) {
                        C0842x3bb65290.m23m(_queue$FU, this, obj, lockFreeTaskQueueCore.next());
                    } else if (addLast == 2) {
                        return false;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                }
            } else if (obj == EventLoop_commonKt.CLOSED_EMPTY) {
                return false;
            } else {
                LockFreeTaskQueueCore lockFreeTaskQueueCore2 = new LockFreeTaskQueueCore(8, true);
                if (obj != null) {
                    lockFreeTaskQueueCore2.addLast((Runnable) obj);
                    lockFreeTaskQueueCore2.addLast(runnable);
                    if (C0842x3bb65290.m23m(_queue$FU, this, obj, lockFreeTaskQueueCore2)) {
                        return true;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            }
        }
    }

    private final Runnable dequeue() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof LockFreeTaskQueueCore) {
                if (obj != null) {
                    LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                    Object removeFirstOrNull = lockFreeTaskQueueCore.removeFirstOrNull();
                    if (removeFirstOrNull != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                        return (Runnable) removeFirstOrNull;
                    }
                    C0842x3bb65290.m23m(_queue$FU, this, obj, lockFreeTaskQueueCore.next());
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeTaskQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                }
            } else if (obj == EventLoop_commonKt.CLOSED_EMPTY) {
                return null;
            } else {
                if (C0842x3bb65290.m23m(_queue$FU, this, obj, (Object) null)) {
                    if (obj != null) {
                        return (Runnable) obj;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            }
        }
    }
}
