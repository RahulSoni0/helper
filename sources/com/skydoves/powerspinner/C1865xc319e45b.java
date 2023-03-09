package com.skydoves.powerspinner;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017¨\u0006\b¸\u0006\u0000"}, mo18301d2 = {"com/skydoves/powerspinner/PowerSpinnerView$updateSpinnerWindow$1$1$2", "Landroid/view/View$OnTouchListener;", "onTouch", "", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "powerspinner_release"}, mo18302k = 1, mo18303mv = {1, 4, 1})
/* renamed from: com.skydoves.powerspinner.PowerSpinnerView$updateSpinnerWindow$1$$special$$inlined$apply$lambda$2 */
/* compiled from: PowerSpinnerView.kt */
public final class C1865xc319e45b implements View.OnTouchListener {
    final /* synthetic */ PowerSpinnerView$updateSpinnerWindow$1 this$0;

    C1865xc319e45b(PowerSpinnerView$updateSpinnerWindow$1 powerSpinnerView$updateSpinnerWindow$1) {
        this.this$0 = powerSpinnerView$updateSpinnerWindow$1;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
        if (motionEvent.getAction() != 4) {
            return false;
        }
        OnSpinnerOutsideTouchListener spinnerOutsideTouchListener = this.this$0.this$0.getSpinnerOutsideTouchListener();
        if (spinnerOutsideTouchListener == null) {
            return true;
        }
        spinnerOutsideTouchListener.onSpinnerOutsideTouch(view, motionEvent);
        return true;
    }
}
