package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, mo18301d2 = {"<anonymous>", "", "T", "R", "invoke", "()[Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$1"}, mo18302k = 3, mo18303mv = {1, 1, 15})
/* compiled from: Zip.kt */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$6$lambda$1 extends Lambda implements Function0<T[]> {
    final /* synthetic */ FlowKt__ZipKt$combine$$inlined$unsafeFlow$6 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$6$lambda$1(FlowKt__ZipKt$combine$$inlined$unsafeFlow$6 flowKt__ZipKt$combine$$inlined$unsafeFlow$6) {
        super(0);
        this.this$0 = flowKt__ZipKt$combine$$inlined$unsafeFlow$6;
    }

    public final T[] invoke() {
        int length = this.this$0.$flowArray$inlined.length;
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new Object[length];
    }
}
