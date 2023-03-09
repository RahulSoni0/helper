package com.google.android.play.core.review;

import android.content.Context;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.splitcompat.C0989p;

public class ReviewManagerFactory {
    private ReviewManagerFactory() {
    }

    public static ReviewManager create(Context context) {
        PlayCoreDialogWrapperActivity.m655a(context);
        return new C1724c(new C1730i(C0989p.m204c(context)));
    }
}
