package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ChannelCoroutine;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo18301d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo18302k = 3, mo18303mv = {1, 1, 15})
@DebugMetadata(mo18317c = "kotlinx.coroutines.flow.internal.CombineKt$asFairChannel$1", mo18318f = "Combine.kt", mo18319i = {0, 0, 0}, mo18320l = {144}, mo18321m = "invokeSuspend", mo18322n = {"$this$produce", "channel", "$this$collect$iv"}, mo18323s = {"L$0", "L$1", "L$2"})
/* compiled from: Combine.kt */
final class CombineKt$asFairChannel$1 extends SuspendLambda implements Function2<ProducerScope<? super Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $flow;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* renamed from: p$ */
    private ProducerScope f306p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$asFairChannel$1(Flow flow, Continuation continuation) {
        super(2, continuation);
        this.$flow = flow;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        CombineKt$asFairChannel$1 combineKt$asFairChannel$1 = new CombineKt$asFairChannel$1(this.$flow, continuation);
        combineKt$asFairChannel$1.f306p$ = (ProducerScope) obj;
        return combineKt$asFairChannel$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CombineKt$asFairChannel$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = this.f306p$;
            SendChannel channel = producerScope.getChannel();
            if (channel != null) {
                ChannelCoroutine channelCoroutine = (ChannelCoroutine) channel;
                Flow flow = this.$flow;
                this.L$0 = producerScope;
                this.L$1 = channelCoroutine;
                this.L$2 = flow;
                this.label = 1;
                if (flow.collect(new CombineKt$asFairChannel$1$invokeSuspend$$inlined$collect$1(channelCoroutine), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelCoroutine<kotlin.Any>");
            }
        } else if (i == 1) {
            Flow flow2 = (Flow) this.L$2;
            ChannelCoroutine channelCoroutine2 = (ChannelCoroutine) this.L$1;
            ProducerScope producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
