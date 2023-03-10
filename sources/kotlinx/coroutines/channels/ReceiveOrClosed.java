package kotlinx.coroutines.channels;

import kotlin.Metadata;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b`\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H&J!\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00028\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0002\u0010\fR\u0012\u0010\u0003\u001a\u00020\u0002X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\r"}, mo18301d2 = {"Lkotlinx/coroutines/channels/ReceiveOrClosed;", "E", "", "offerResult", "getOfferResult", "()Ljava/lang/Object;", "completeResumeReceive", "", "token", "tryResumeReceive", "value", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
/* compiled from: AbstractChannel.kt */
public interface ReceiveOrClosed<E> {
    void completeResumeReceive(Object obj);

    Object getOfferResult();

    Object tryResumeReceive(E e, Object obj);
}
