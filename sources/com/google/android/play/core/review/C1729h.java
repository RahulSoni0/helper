package com.google.android.play.core.review;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.review.h */
final class C1729h extends C1728g<ReviewInfo> {
    C1729h(C1730i iVar, C1786i iVar2) {
        super(iVar, new C0944ag("OnRequestInstallCallback"), iVar2);
    }

    /* renamed from: b */
    public final void mo30882b(Bundle bundle) throws RemoteException {
        super.mo30882b(bundle);
        this.f901b.mo31066e(ReviewInfo.m822b((PendingIntent) bundle.get("confirmation_intent")));
    }
}
