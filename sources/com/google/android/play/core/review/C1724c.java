package com.google.android.play.core.review;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.tasks.C1786i;
import com.google.android.play.core.tasks.Task;

/* renamed from: com.google.android.play.core.review.c */
public final class C1724c implements ReviewManager {

    /* renamed from: a */
    private final C1730i f895a;

    /* renamed from: b */
    private final Handler f896b = new Handler(Looper.getMainLooper());

    C1724c(C1730i iVar) {
        this.f895a = iVar;
    }

    public final Task<Void> launchReviewFlow(Activity activity, ReviewInfo reviewInfo) {
        Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", reviewInfo.mo30973a());
        intent.putExtra("window_flags", activity.getWindow().getDecorView().getWindowSystemUiVisibility());
        C1786i iVar = new C1786i();
        intent.putExtra("result_receiver", new C1723b(this.f896b, iVar));
        activity.startActivity(intent);
        return iVar.mo31064c();
    }

    public final Task<ReviewInfo> requestReviewFlow() {
        return this.f895a.mo30982a();
    }
}
