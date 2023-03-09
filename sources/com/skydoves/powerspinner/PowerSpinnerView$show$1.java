package com.skydoves.powerspinner;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo18301d2 = {"<anonymous>", "", "invoke"}, mo18302k = 3, mo18303mv = {1, 4, 1})
/* compiled from: PowerSpinnerView.kt */
final class PowerSpinnerView$show$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $xOff;
    final /* synthetic */ int $yOff;
    final /* synthetic */ PowerSpinnerView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PowerSpinnerView$show$1(PowerSpinnerView powerSpinnerView, int i, int i2) {
        super(0);
        this.this$0 = powerSpinnerView;
        this.$xOff = i;
        this.$yOff = i2;
    }

    public final void invoke() {
        if (!this.this$0.isShowing()) {
            this.this$0.isShowing = true;
            this.this$0.animateArrow(true);
            this.this$0.applyWindowAnimation();
            this.this$0.spinnerWindow.showAsDropDown(this.this$0, this.$xOff, this.$yOff);
            this.this$0.post(new Runnable(this) {
                final /* synthetic */ PowerSpinnerView$show$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    int i;
                    int i2;
                    if (this.this$0.this$0.getSpinnerPopupWidth() != Integer.MIN_VALUE) {
                        i = this.this$0.this$0.getSpinnerPopupWidth();
                    } else {
                        i = this.this$0.this$0.getWidth();
                    }
                    if (this.this$0.this$0.getSpinnerPopupHeight() != Integer.MIN_VALUE) {
                        i2 = this.this$0.this$0.getSpinnerPopupHeight();
                    } else {
                        i2 = this.this$0.this$0.getSpinnerRecyclerView().getHeight();
                    }
                    this.this$0.this$0.spinnerWindow.update(i, i2);
                }
            });
        }
    }
}
