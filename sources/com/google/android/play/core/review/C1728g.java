package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.internal.C1669ad;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.review.g */
class C1728g<T> extends C1669ad {

    /* renamed from: a */
    final C0944ag f900a;

    /* renamed from: b */
    final C1786i<T> f901b;

    /* renamed from: c */
    final /* synthetic */ C1730i f902c;

    C1728g(C1730i iVar, C0944ag agVar, C1786i<T> iVar2) {
        this.f902c = iVar;
        this.f900a = agVar;
        this.f901b = iVar2;
    }

    /* renamed from: b */
    public void mo30882b(Bundle bundle) throws RemoteException {
        this.f902c.f904a.mo30894b();
        this.f900a.mo17057d("onGetLaunchReviewFlowInfo", new Object[0]);
    }
}
