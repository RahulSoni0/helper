package com.skydoves.powerspinner;

import android.widget.PopupWindow;
import kotlin.Metadata;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo18301d2 = {"<anonymous>", "", "onDismiss", "com/skydoves/powerspinner/PowerSpinnerView$updateSpinnerWindow$1$1$1"}, mo18302k = 3, mo18303mv = {1, 4, 1})
/* renamed from: com.skydoves.powerspinner.PowerSpinnerView$updateSpinnerWindow$1$$special$$inlined$apply$lambda$1 */
/* compiled from: PowerSpinnerView.kt */
final class C1864xc319e45a implements PopupWindow.OnDismissListener {
    final /* synthetic */ PowerSpinnerView$updateSpinnerWindow$1 this$0;

    C1864xc319e45a(PowerSpinnerView$updateSpinnerWindow$1 powerSpinnerView$updateSpinnerWindow$1) {
        this.this$0 = powerSpinnerView$updateSpinnerWindow$1;
    }

    public final void onDismiss() {
        OnSpinnerDismissListener onSpinnerDismissListener = this.this$0.this$0.getOnSpinnerDismissListener();
        if (onSpinnerDismissListener != null) {
            onSpinnerDismissListener.onDismiss();
        }
    }
}
