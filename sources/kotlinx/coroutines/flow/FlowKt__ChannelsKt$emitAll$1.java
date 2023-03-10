package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.ReceiveChannel;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H@"}, mo18301d2 = {"emitAll", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "Lkotlinx/coroutines/channels/ReceiveChannel;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo18302k = 3, mo18303mv = {1, 1, 15})
@DebugMetadata(mo18317c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", mo18318f = "Channels.kt", mo18319i = {0, 0, 0, 0, 1, 1, 1, 1}, mo18320l = {45, 56}, mo18321m = "emitAll", mo18322n = {"$this$emitAll", "channel", "cause", "$this$run", "$this$emitAll", "channel", "cause", "result"}, mo18323s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
/* compiled from: Channels.kt */
final class FlowKt__ChannelsKt$emitAll$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    FlowKt__ChannelsKt$emitAll$1(Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FlowKt.emitAll((FlowCollector) null, (ReceiveChannel) null, (Continuation<? super Unit>) this);
    }
}
