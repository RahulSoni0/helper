package com.skydoves.powerspinner;

import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.DividerItemDecoration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo18301d2 = {"<anonymous>", "", "run"}, mo18302k = 3, mo18303mv = {1, 4, 1})
/* compiled from: PowerSpinnerView.kt */
final class PowerSpinnerView$updateSpinnerWindow$1 implements Runnable {
    final /* synthetic */ PowerSpinnerView this$0;

    PowerSpinnerView$updateSpinnerWindow$1(PowerSpinnerView powerSpinnerView) {
        this.this$0 = powerSpinnerView;
    }

    public final void run() {
        PopupWindow access$getSpinnerWindow$p = this.this$0.spinnerWindow;
        access$getSpinnerWindow$p.setWidth(this.this$0.getWidth());
        access$getSpinnerWindow$p.setOutsideTouchable(true);
        access$getSpinnerWindow$p.setOnDismissListener(new C1864xc319e45a(this));
        access$getSpinnerWindow$p.setTouchInterceptor(new C1865xc319e45b(this));
        if (Build.VERSION.SDK_INT >= 21) {
            access$getSpinnerWindow$p.setElevation((float) this.this$0.getSpinnerPopupElevation());
        }
        FrameLayout frameLayout = this.this$0.binding.body;
        if (this.this$0.getSpinnerPopupBackgroundColor() == 65555) {
            frameLayout.setBackground(this.this$0.getBackground());
        } else {
            frameLayout.setBackgroundColor(this.this$0.getSpinnerPopupBackgroundColor());
        }
        Intrinsics.checkNotNullExpressionValue(frameLayout, "this");
        frameLayout.setPadding(frameLayout.getPaddingLeft(), frameLayout.getPaddingTop(), frameLayout.getPaddingRight(), frameLayout.getPaddingBottom());
        if (this.this$0.getShowDivider()) {
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(frameLayout.getContext(), 1);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setSize(frameLayout.getWidth(), this.this$0.getDividerSize());
            gradientDrawable.setColor(this.this$0.getDividerColor());
            dividerItemDecoration.setDrawable(gradientDrawable);
            this.this$0.getSpinnerRecyclerView().addItemDecoration(dividerItemDecoration);
        }
        if (this.this$0.getSpinnerPopupWidth() != Integer.MIN_VALUE) {
            this.this$0.spinnerWindow.setWidth(this.this$0.getSpinnerPopupWidth());
        }
        if (this.this$0.getSpinnerPopupHeight() != Integer.MIN_VALUE) {
            this.this$0.spinnerWindow.setHeight(this.this$0.getSpinnerPopupHeight());
        }
    }
}
