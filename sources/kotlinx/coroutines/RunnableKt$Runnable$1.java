package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo18301d2 = {"<anonymous>", "", "run"}, mo18302k = 3, mo18303mv = {1, 1, 15})
/* compiled from: Runnable.kt */
public final class RunnableKt$Runnable$1 implements Runnable {
    final /* synthetic */ Function0 $block;

    public RunnableKt$Runnable$1(Function0 function0) {
        this.$block = function0;
    }

    public final void run() {
        this.$block.invoke();
    }
}
