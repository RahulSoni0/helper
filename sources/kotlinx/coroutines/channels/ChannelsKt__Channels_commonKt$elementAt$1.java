package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H@"}, mo18301d2 = {"elementAt", "", "E", "Lkotlinx/coroutines/channels/ReceiveChannel;", "index", "", "continuation", "Lkotlin/coroutines/Continuation;"}, mo18302k = 3, mo18303mv = {1, 1, 15})
@DebugMetadata(mo18317c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", mo18318f = "Channels.common.kt", mo18319i = {0, 0, 0, 0, 0, 0, 0}, mo18320l = {2257}, mo18321m = "elementAt", mo18322n = {"$this$elementAt", "index", "$this$elementAtOrElse$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "count$iv"}, mo18323s = {"L$0", "I$0", "L$1", "L$2", "L$3", "L$4", "I$1"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$elementAt$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;

    ChannelsKt__Channels_commonKt$elementAt$1(Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt.elementAt((ReceiveChannel) null, 0, this);
    }
}