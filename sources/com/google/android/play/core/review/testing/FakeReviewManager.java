package com.google.android.play.core.review.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

public class FakeReviewManager implements ReviewManager {

    /* renamed from: a */
    private final Context f906a;

    /* renamed from: b */
    private ReviewInfo f907b;

    public FakeReviewManager(Context context) {
        this.f906a = context;
    }

    public Task<Void> launchReviewFlow(Activity activity, ReviewInfo reviewInfo) {
        return reviewInfo != this.f907b ? Tasks.m943b(new C1731a()) : Tasks.m942a(null);
    }

    public Task<ReviewInfo> requestReviewFlow() {
        ReviewInfo b = ReviewInfo.m822b(PendingIntent.getBroadcast(this.f906a, 0, new Intent(), 0));
        this.f907b = b;
        return Tasks.m942a(b);
    }
}
