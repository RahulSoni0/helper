package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo18301d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo18302k = 3, mo18303mv = {1, 1, 15})
@DebugMetadata(mo18317c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", mo18318f = "ChannelFlow.kt", mo18319i = {0}, mo18320l = {75}, mo18321m = "invokeSuspend", mo18322n = {"$this$coroutineScope"}, mo18323s = {"L$0"})
/* compiled from: ChannelFlow.kt */
final class ChannelFlow$collect$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector $collector;
    Object L$0;
    int label;

    /* renamed from: p$ */
    private CoroutineScope f299p$;
    final /* synthetic */ ChannelFlow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelFlow$collect$2(ChannelFlow channelFlow, FlowCollector flowCollector, Continuation continuation) {
        super(2, continuation);
        this.this$0 = channelFlow;
        this.$collector = flowCollector;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        ChannelFlow$collect$2 channelFlow$collect$2 = new ChannelFlow$collect$2(this.this$0, this.$collector, continuation);
        channelFlow$collect$2.f299p$ = (CoroutineScope) obj;
        return channelFlow$collect$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelFlow$collect$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.f299p$;
            FlowCollector flowCollector = this.$collector;
            ReceiveChannel produceImpl = this.this$0.produceImpl(coroutineScope);
            this.L$0 = coroutineScope;
            this.label = 1;
            if (FlowKt.emitAll(flowCollector, produceImpl, (Continuation<? super Unit>) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
