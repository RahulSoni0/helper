package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H&J\u0014\u0010\n\u001a\u00020\b2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH&J\u0014\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H&R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo18301d2 = {"Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "()V", "pollResult", "", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "", "token", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "tryResumeSend", "idempotent", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
/* compiled from: AbstractChannel.kt */
public abstract class Send extends LockFreeLinkedListNode {
    public abstract void completeResumeSend(Object obj);

    public abstract Object getPollResult();

    public abstract void resumeSendClosed(Closed<?> closed);

    public abstract Object tryResumeSend(Object obj);
}
