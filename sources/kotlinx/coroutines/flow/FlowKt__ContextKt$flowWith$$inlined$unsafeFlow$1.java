package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, mo18301d2 = {"kotlinx/coroutines/flow/internal/SafeCollectorKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
/* compiled from: SafeCollector.kt */
public final class FlowKt__ContextKt$flowWith$$inlined$unsafeFlow$1 implements Flow<R> {
    final /* synthetic */ int $bufferSize$inlined;
    final /* synthetic */ Function1 $builder$inlined;
    final /* synthetic */ CoroutineContext $flowContext$inlined;
    final /* synthetic */ Flow $source$inlined;

    public FlowKt__ContextKt$flowWith$$inlined$unsafeFlow$1(Flow flow, int i, Function1 function1, CoroutineContext coroutineContext) {
        this.$source$inlined = flow;
        this.$bufferSize$inlined = i;
        this.$builder$inlined = function1;
        this.$flowContext$inlined = coroutineContext;
    }

    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        return FlowKt.buffer(FlowKt.flowOn((Flow) this.$builder$inlined.invoke(FlowKt.buffer(FlowKt.flowOn(this.$source$inlined, continuation.getContext().minusKey(Job.Key)), this.$bufferSize$inlined)), this.$flowContext$inlined), this.$bufferSize$inlined).collect(new FlowKt__ContextKt$flowWith$$inlined$unsafeFlow$1$lambda$1(flowCollector), continuation);
    }
}
