package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H@"}, mo18301d2 = {"awaitClose", "", "Lkotlinx/coroutines/channels/ProducerScope;", "block", "Lkotlin/Function0;", "", "continuation", "Lkotlin/coroutines/Continuation;"}, mo18302k = 3, mo18303mv = {1, 1, 15})
@DebugMetadata(mo18317c = "kotlinx.coroutines.channels.ProduceKt", mo18318f = "Produce.kt", mo18319i = {0, 0}, mo18320l = {145}, mo18321m = "awaitClose", mo18322n = {"$this$awaitClose", "block"}, mo18323s = {"L$0", "L$1"})
/* compiled from: Produce.kt */
final class ProduceKt$awaitClose$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    ProduceKt$awaitClose$1(Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ProduceKt.awaitClose((ProducerScope<?>) null, (Function0<Unit>) null, this);
    }
}
