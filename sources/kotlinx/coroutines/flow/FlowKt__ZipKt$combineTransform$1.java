package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.CombineKt;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, mo18301d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo18302k = 3, mo18303mv = {1, 1, 15})
@DebugMetadata(mo18317c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$1", mo18318f = "Zip.kt", mo18319i = {0}, mo18320l = {82}, mo18321m = "invokeSuspend", mo18322n = {"$this$flow"}, mo18323s = {"L$0"})
/* compiled from: Zip.kt */
final class FlowKt__ZipKt$combineTransform$1 extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $flow;
    final /* synthetic */ Flow $this_combineTransform;
    final /* synthetic */ Function4 $transform;
    Object L$0;
    int label;

    /* renamed from: p$ */
    private FlowCollector f293p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__ZipKt$combineTransform$1(Flow flow, Flow flow2, Function4 function4, Continuation continuation) {
        super(2, continuation);
        this.$this_combineTransform = flow;
        this.$flow = flow2;
        this.$transform = function4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        FlowKt__ZipKt$combineTransform$1 flowKt__ZipKt$combineTransform$1 = new FlowKt__ZipKt$combineTransform$1(this.$this_combineTransform, this.$flow, this.$transform, continuation);
        flowKt__ZipKt$combineTransform$1.f293p$ = (FlowCollector) obj;
        return flowKt__ZipKt$combineTransform$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FlowKt__ZipKt$combineTransform$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u0002H\u0003H@¢\u0006\u0004\b\b\u0010\t"}, mo18301d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "a", "b", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo18302k = 3, mo18303mv = {1, 1, 15})
    @DebugMetadata(mo18317c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$1$1", mo18318f = "Zip.kt", mo18319i = {0, 0, 0}, mo18320l = {83}, mo18321m = "invokeSuspend", mo18322n = {"$this$combineTransformInternal", "a", "b"}, mo18323s = {"L$0", "L$1", "L$2"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$1$1 */
    /* compiled from: Zip.kt */
    static final class C11601 extends SuspendLambda implements Function4<FlowCollector<? super R>, T1, T2, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* renamed from: p$ */
        private FlowCollector f294p$;
        private Object p$0;
        private Object p$1;
        final /* synthetic */ FlowKt__ZipKt$combineTransform$1 this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(FlowCollector<? super R> flowCollector, T1 t1, T2 t2, Continuation<? super Unit> continuation) {
            Intrinsics.checkParameterIsNotNull(flowCollector, "$this$create");
            Intrinsics.checkParameterIsNotNull(continuation, "continuation");
            C11601 r0 = new C11601(this.this$0, continuation);
            r0.f294p$ = flowCollector;
            r0.p$0 = t1;
            r0.p$1 = t2;
            return r0;
        }

        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ((C11601) create((FlowCollector) obj, obj2, obj3, (Continuation) obj4)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = this.f294p$;
                Object obj2 = this.p$0;
                Object obj3 = this.p$1;
                Function4 function4 = this.this$0.$transform;
                this.L$0 = flowCollector;
                this.L$1 = obj2;
                this.L$2 = obj3;
                this.label = 1;
                if (function4.invoke(flowCollector, obj2, obj3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = this.f293p$;
            this.L$0 = flowCollector;
            this.label = 1;
            if (CombineKt.combineTransformInternal(flowCollector, this.$this_combineTransform, this.$flow, new C11601(this, (Continuation) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            FlowCollector flowCollector2 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
