package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H@"}, mo18301d2 = {"collect", "", "T", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo18302k = 3, mo18303mv = {1, 1, 15})
@DebugMetadata(mo18317c = "kotlinx.coroutines.flow.internal.SafeCollectorKt$unsafeFlow$1", mo18318f = "SafeCollector.kt", mo18319i = {0, 0}, mo18320l = {121}, mo18321m = "collect", mo18322n = {"this", "collector"}, mo18323s = {"L$0", "L$1"})
/* compiled from: SafeCollector.kt */
public final class SafeCollectorKt$unsafeFlow$1$collect$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SafeCollectorKt$unsafeFlow$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SafeCollectorKt$unsafeFlow$1$collect$1(SafeCollectorKt$unsafeFlow$1 safeCollectorKt$unsafeFlow$1, Continuation continuation) {
        super(continuation);
        this.this$0 = safeCollectorKt$unsafeFlow$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect((FlowCollector) null, this);
    }
}
