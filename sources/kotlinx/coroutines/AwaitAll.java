package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\f\rB\u001d\u0012\u0014\u0010\u0005\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nR$\u0010\u0005\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, mo18301d2 = {"Lkotlinx/coroutines/AwaitAll;", "T", "", "", "Lkotlinx/coroutines/Deferred;", "deferreds", "<init>", "([Lkotlinx/coroutines/Deferred;)V", "", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "[Lkotlinx/coroutines/Deferred;", "AwaitAllNode", "DisposeHandlersOnCancel", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
/* compiled from: Await.kt */
final class AwaitAll<T> {
    static final AtomicIntegerFieldUpdater notCompletedCount$FU = AtomicIntegerFieldUpdater.newUpdater(AwaitAll.class, "notCompletedCount");
    /* access modifiers changed from: private */
    public final Deferred<T>[] deferreds;
    volatile int notCompletedCount;

    public AwaitAll(Deferred<? extends T>[] deferredArr) {
        Intrinsics.checkParameterIsNotNull(deferredArr, "deferreds");
        this.deferreds = deferredArr;
        this.notCompletedCount = deferredArr.length;
    }

    @Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f0\u0004R\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\b\u001a\u00020\tJ\u0013\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R \u0010\u0002\u001a\u0012\u0012\u000e\u0012\f0\u0004R\b\u0012\u0004\u0012\u00028\u00000\u00050\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000f"}, mo18301d2 = {"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "nodes", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "disposeAll", "", "invoke", "cause", "", "toString", "", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
    /* compiled from: Await.kt */
    private final class DisposeHandlersOnCancel extends CancelHandler {
        private final AwaitAll<T>.AwaitAllNode[] nodes;
        final /* synthetic */ AwaitAll this$0;

        public DisposeHandlersOnCancel(AwaitAll awaitAll, AwaitAll<T>.AwaitAllNode[] awaitAllNodeArr) {
            Intrinsics.checkParameterIsNotNull(awaitAllNodeArr, "nodes");
            this.this$0 = awaitAll;
            this.nodes = awaitAllNodeArr;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return Unit.INSTANCE;
        }

        public final void disposeAll() {
            for (AwaitAll<T>.AwaitAllNode handle : this.nodes) {
                handle.getHandle().dispose();
            }
        }

        public void invoke(Throwable th) {
            disposeAll();
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.nodes + ']';
        }
    }

    @Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u000e\u0018\u00010\tR\b\u0012\u0004\u0012\u00028\u00000\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, mo18301d2 = {"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "job", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;Lkotlinx/coroutines/Job;)V", "disposer", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "getDisposer", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "handle", "Lkotlinx/coroutines/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
    /* compiled from: Await.kt */
    private final class AwaitAllNode extends JobNode<Job> {
        private final CancellableContinuation<List<? extends T>> continuation;
        private volatile AwaitAll<T>.DisposeHandlersOnCancel disposer;
        public DisposableHandle handle;
        final /* synthetic */ AwaitAll this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AwaitAllNode(AwaitAll awaitAll, CancellableContinuation<? super List<? extends T>> cancellableContinuation, Job job) {
            super(job);
            Intrinsics.checkParameterIsNotNull(cancellableContinuation, "continuation");
            Intrinsics.checkParameterIsNotNull(job, "job");
            this.this$0 = awaitAll;
            this.continuation = cancellableContinuation;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return Unit.INSTANCE;
        }

        public final DisposableHandle getHandle() {
            DisposableHandle disposableHandle = this.handle;
            if (disposableHandle == null) {
                Intrinsics.throwUninitializedPropertyAccessException("handle");
            }
            return disposableHandle;
        }

        public final void setHandle(DisposableHandle disposableHandle) {
            Intrinsics.checkParameterIsNotNull(disposableHandle, "<set-?>");
            this.handle = disposableHandle;
        }

        public final AwaitAll<T>.DisposeHandlersOnCancel getDisposer() {
            return this.disposer;
        }

        public final void setDisposer(AwaitAll<T>.DisposeHandlersOnCancel disposeHandlersOnCancel) {
            this.disposer = disposeHandlersOnCancel;
        }

        public void invoke(Throwable th) {
            if (th != null) {
                Object tryResumeWithException = this.continuation.tryResumeWithException(th);
                if (tryResumeWithException != null) {
                    this.continuation.completeResume(tryResumeWithException);
                    AwaitAll<T>.DisposeHandlersOnCancel disposeHandlersOnCancel = this.disposer;
                    if (disposeHandlersOnCancel != null) {
                        disposeHandlersOnCancel.disposeAll();
                        return;
                    }
                    return;
                }
                return;
            }
            if (AwaitAll.notCompletedCount$FU.decrementAndGet(this.this$0) == 0) {
                Continuation continuation2 = this.continuation;
                Deferred[] access$getDeferreds$p = this.this$0.deferreds;
                Collection arrayList = new ArrayList(access$getDeferreds$p.length);
                for (Deferred completed : access$getDeferreds$p) {
                    arrayList.add(completed.getCompleted());
                }
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.m1941constructorimpl((List) arrayList));
            }
        }
    }

    public final Object await(Continuation<? super List<? extends T>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        int length = this.deferreds.length;
        AwaitAllNode[] awaitAllNodeArr = new AwaitAllNode[length];
        for (int i = 0; i < length; i++) {
            Deferred deferred = this.deferreds[Boxing.boxInt(i).intValue()];
            deferred.start();
            AwaitAllNode awaitAllNode = new AwaitAllNode(this, cancellableContinuation, deferred);
            awaitAllNode.setHandle(deferred.invokeOnCompletion(awaitAllNode));
            awaitAllNodeArr[i] = awaitAllNode;
        }
        DisposeHandlersOnCancel disposeHandlersOnCancel = new DisposeHandlersOnCancel(this, awaitAllNodeArr);
        for (int i2 = 0; i2 < length; i2++) {
            awaitAllNodeArr[i2].setDisposer(disposeHandlersOnCancel);
        }
        if (cancellableContinuation.isCompleted()) {
            disposeHandlersOnCancel.disposeAll();
        } else {
            cancellableContinuation.invokeOnCancellation(disposeHandlersOnCancel);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
