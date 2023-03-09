package com.skydoves.powerspinner;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, mo18301d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "onSpinnerOutsideTouch", "com/skydoves/powerspinner/PowerSpinnerView$Builder$setOnSpinnerOutsideTouchListener$2$1"}, mo18302k = 3, mo18303mv = {1, 4, 1})
/* renamed from: com.skydoves.powerspinner.PowerSpinnerView$Builder$setOnSpinnerOutsideTouchListener$$inlined$apply$lambda$1 */
/* compiled from: PowerSpinnerView.kt */
final class C1863x2fbc48fd implements OnSpinnerOutsideTouchListener {
    final /* synthetic */ Function2 $unit$inlined;

    C1863x2fbc48fd(Function2 function2) {
        this.$unit$inlined = function2;
    }

    public final void onSpinnerOutsideTouch(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
        this.$unit$inlined.invoke(view, motionEvent);
    }
}
