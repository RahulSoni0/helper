package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ChannelCoroutine;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, mo18301d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
/* compiled from: Collect.kt */
public final class CombineKt$asFairChannel$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<Object> {
    final /* synthetic */ ChannelCoroutine $channel$inlined;

    public CombineKt$asFairChannel$1$invokeSuspend$$inlined$collect$1(ChannelCoroutine channelCoroutine) {
        this.$channel$inlined = channelCoroutine;
    }

    public Object emit(Object obj, Continuation continuation) {
        ChannelCoroutine channelCoroutine = this.$channel$inlined;
        if (obj == null) {
            obj = NullSurrogateKt.NULL;
        }
        return channelCoroutine.sendFair(obj, continuation);
    }
}
