package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007HH"}, mo18301d2 = {"withPermit", "", "T", "Lkotlinx/coroutines/sync/Semaphore;", "action", "Lkotlin/Function0;", "continuation", "Lkotlin/coroutines/Continuation;"}, mo18302k = 3, mo18303mv = {1, 1, 15})
@DebugMetadata(mo18317c = "kotlinx.coroutines.sync.SemaphoreKt", mo18318f = "Semaphore.kt", mo18319i = {0, 0}, mo18320l = {74}, mo18321m = "withPermit", mo18322n = {"$this$withPermit", "action"}, mo18323s = {"L$0", "L$1"})
/* compiled from: Semaphore.kt */
public final class SemaphoreKt$withPermit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public SemaphoreKt$withPermit$1(Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SemaphoreKt.withPermit((Semaphore) null, (Function0) null, this);
    }
}
