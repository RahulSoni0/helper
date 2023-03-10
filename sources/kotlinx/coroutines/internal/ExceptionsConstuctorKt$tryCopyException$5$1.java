package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, mo18301d2 = {"<anonymous>", "", "E", "", "it", "invoke"}, mo18302k = 3, mo18303mv = {1, 1, 15})
/* compiled from: ExceptionsConstuctor.kt */
final class ExceptionsConstuctorKt$tryCopyException$5$1 extends Lambda implements Function1 {
    public static final ExceptionsConstuctorKt$tryCopyException$5$1 INSTANCE = new ExceptionsConstuctorKt$tryCopyException$5$1();

    ExceptionsConstuctorKt$tryCopyException$5$1() {
        super(1);
    }

    public final Void invoke(Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "it");
        return null;
    }
}
