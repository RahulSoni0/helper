package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo18301d2 = {"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, mo18302k = 3, mo18303mv = {1, 1, 15})
/* compiled from: Runnable.kt */
public final class HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 implements Runnable {
    final /* synthetic */ CancellableContinuation $continuation$inlined;
    final /* synthetic */ HandlerContext this$0;

    public HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1(HandlerContext handlerContext, CancellableContinuation cancellableContinuation) {
        this.this$0 = handlerContext;
        this.$continuation$inlined = cancellableContinuation;
    }

    public final void run() {
        this.$continuation$inlined.resumeUndispatched(this.this$0, Unit.INSTANCE);
    }
}
