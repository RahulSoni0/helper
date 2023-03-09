package com.skydoves.powerspinner;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo18301d2 = {"<anonymous>", "", "invoke"}, mo18302k = 3, mo18303mv = {1, 4, 1})
/* compiled from: PowerSpinnerView.kt */
final class PowerSpinnerView$dismiss$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PowerSpinnerView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PowerSpinnerView$dismiss$1(PowerSpinnerView powerSpinnerView) {
        super(0);
        this.this$0 = powerSpinnerView;
    }

    public final void invoke() {
        if (this.this$0.isShowing()) {
            this.this$0.animateArrow(false);
            this.this$0.spinnerWindow.dismiss();
            this.this$0.isShowing = false;
        }
    }
}
