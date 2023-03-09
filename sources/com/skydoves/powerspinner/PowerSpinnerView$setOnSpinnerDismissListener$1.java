package com.skydoves.powerspinner;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo18301d2 = {"<anonymous>", "", "onDismiss"}, mo18302k = 3, mo18303mv = {1, 4, 1})
/* compiled from: PowerSpinnerView.kt */
final class PowerSpinnerView$setOnSpinnerDismissListener$1 implements OnSpinnerDismissListener {
    final /* synthetic */ Function0 $block;

    PowerSpinnerView$setOnSpinnerDismissListener$1(Function0 function0) {
        this.$block = function0;
    }

    public final void onDismiss() {
        this.$block.invoke();
    }
}
