package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, mo18301d2 = {"<anonymous>", "", "T", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo18302k = 3, mo18303mv = {1, 1, 15})
@DebugMetadata(mo18317c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$1", mo18318f = "Errors.kt", mo18319i = {}, mo18320l = {}, mo18321m = "invokeSuspend", mo18322n = {}, mo18323s = {})
/* compiled from: Errors.kt */
final class FlowKt__ErrorsKt$retry$1 extends SuspendLambda implements Function2<Throwable, Continuation<? super Boolean>, Object> {
    int label;
    private Throwable p$0;

    FlowKt__ErrorsKt$retry$1(Continuation continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        FlowKt__ErrorsKt$retry$1 flowKt__ErrorsKt$retry$1 = new FlowKt__ErrorsKt$retry$1(continuation);
        flowKt__ErrorsKt$retry$1.p$0 = (Throwable) obj;
        return flowKt__ErrorsKt$retry$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FlowKt__ErrorsKt$retry$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(true);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
