package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.CombineKt;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, mo18301d2 = {"kotlinx/coroutines/flow/internal/SafeCollectorKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MigrationKt$combine$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__MigrationKt$combine$$inlined$combine$1"}, mo18302k = 1, mo18303mv = {1, 1, 15})
/* compiled from: SafeCollector.kt */
public final class FlowKt__MigrationKt$combineLatest$$inlined$combine$1 implements Flow<R> {
    final /* synthetic */ Flow[] $flows$inlined;
    final /* synthetic */ Function4 $transform$inlined$1;

    public FlowKt__MigrationKt$combineLatest$$inlined$combine$1(Flow[] flowArr, Function4 function4) {
        this.$flows$inlined = flowArr;
        this.$transform$inlined$1 = function4;
    }

    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        return CombineKt.combineInternal(flowCollector, this.$flows$inlined, new Function0<Object[]>(this) {
            final /* synthetic */ FlowKt__MigrationKt$combineLatest$$inlined$combine$1 this$0;

            {
                this.this$0 = r1;
            }

            public final Object[] invoke() {
                return new Object[this.this$0.$flows$inlined.length];
            }
        }, new C10833((Continuation) null), continuation);
    }

    public Object collect$$forInline(FlowCollector flowCollector, Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(this, continuation) {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__MigrationKt$combineLatest$$inlined$combine$1 this$0;

            {
                this.this$0 = r1;
            }

            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.collect((FlowCollector) null, this);
            }
        };
        InlineMarker.mark(5);
        InlineMarker.mark(0);
        CombineKt.combineInternal(flowCollector, this.$flows$inlined, new Function0<Object[]>(this) {
            final /* synthetic */ FlowKt__MigrationKt$combineLatest$$inlined$combine$1 this$0;

            {
                this.this$0 = r1;
            }

            public final Object[] invoke() {
                return new Object[this.this$0.$flows$inlined.length];
            }
        }, new C10833((Continuation) null), continuation);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    @Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000h\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, mo18301d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$5$2", "kotlinx/coroutines/flow/FlowKt__MigrationKt$combine$$inlined$unsafeFlow$1$lambda$2", "kotlinx/coroutines/flow/FlowKt__MigrationKt$combine$$inlined$combine$1$3"}, mo18302k = 3, mo18303mv = {1, 1, 15})
    @DebugMetadata(mo18317c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$combineLatest$$inlined$combine$1$3", mo18318f = "Migration.kt", mo18319i = {0, 0, 0, 0, 1, 1}, mo18320l = {317, 318}, mo18321m = "invokeSuspend", mo18322n = {"$receiver", "it", "continuation", "args", "$receiver", "it"}, mo18323s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__MigrationKt$combineLatest$$inlined$combine$1$3 */
    /* compiled from: Zip.kt */
    public static final class C10833 extends SuspendLambda implements Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* renamed from: p$ */
        private FlowCollector f272p$;
        private Object[] p$0;

        public final Continuation<Unit> create(FlowCollector<? super R> flowCollector, Object[] objArr, Continuation<? super Unit> continuation) {
            Intrinsics.checkParameterIsNotNull(flowCollector, "$this$create");
            Intrinsics.checkParameterIsNotNull(objArr, "it");
            Intrinsics.checkParameterIsNotNull(continuation, "continuation");
            C10833 r0 = new C10833(continuation, this);
            r0.f272p$ = flowCollector;
            r0.p$0 = objArr;
            return r0;
        }

        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ((C10833) create((FlowCollector) obj, (Object[]) obj2, (Continuation) obj3)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            FlowCollector flowCollector = this.f272p$;
            Object[] objArr = this.p$0;
            Continuation continuation = this;
            Function4 function4 = this.$transform$inlined$1;
            Object obj2 = objArr[0];
            Object obj3 = objArr[1];
            Object obj4 = objArr[2];
            InlineMarker.mark(0);
            Object invoke = function4.invoke(obj2, obj3, obj4, this);
            InlineMarker.mark(1);
            InlineMarker.mark(0);
            flowCollector.emit(invoke, this);
            InlineMarker.mark(2);
            InlineMarker.mark(1);
            return Unit.INSTANCE;
        }

        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector;
            Object[] objArr;
            FlowCollector flowCollector2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector2 = this.f272p$;
                Object[] objArr2 = this.p$0;
                Function4 function4 = this.$transform$inlined$1;
                Object obj2 = objArr2[0];
                Object obj3 = objArr2[1];
                Object obj4 = objArr2[2];
                this.L$0 = flowCollector2;
                this.L$1 = objArr2;
                this.L$2 = this;
                this.L$3 = objArr2;
                this.L$4 = flowCollector2;
                this.label = 1;
                Object invoke = function4.invoke(obj2, obj3, obj4, this);
                if (invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                flowCollector = flowCollector2;
                Object obj5 = invoke;
                objArr = objArr2;
                obj = obj5;
            } else if (i == 1) {
                flowCollector2 = (FlowCollector) this.L$4;
                Object[] objArr3 = (Object[]) this.L$3;
                Continuation continuation = (Continuation) this.L$2;
                objArr = (Object[]) this.L$1;
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                Object[] objArr4 = (Object[]) this.L$1;
                FlowCollector flowCollector3 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.L$0 = flowCollector;
            this.L$1 = objArr;
            this.label = 2;
            if (flowCollector2.emit(obj, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }
}
