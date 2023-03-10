package kotlinx.coroutines.channels;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo18301d2 = {"<anonymous>", "", "cause", "", "invoke"}, mo18302k = 3, mo18303mv = {1, 1, 15})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$consumesAll$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ ReceiveChannel[] $channels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$consumesAll$1(ReceiveChannel[] receiveChannelArr) {
        super(1);
        this.$channels = receiveChannelArr;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        Throwable th2 = null;
        Throwable th3 = null;
        for (ReceiveChannel cancelConsumed : this.$channels) {
            try {
                ChannelsKt.cancelConsumed(cancelConsumed, th);
            } catch (Throwable th4) {
                if (th2 == null) {
                    th2 = th4;
                } else {
                    ExceptionsKt.addSuppressed(th2, th4);
                }
            }
        }
        if (th2 != null) {
            throw th2;
        }
    }
}
