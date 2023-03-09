package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.internal.C1708p;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.appupdate.l */
class C1538l<T> extends C1708p {

    /* renamed from: a */
    final C0944ag f374a;

    /* renamed from: b */
    final C1786i<T> f375b;

    /* renamed from: c */
    final /* synthetic */ C1541o f376c;

    C1538l(C1541o oVar, C0944ag agVar, C1786i<T> iVar) {
        this.f376c = oVar;
        this.f374a = agVar;
        this.f375b = iVar;
    }

    /* renamed from: b */
    public void mo30608b(Bundle bundle) throws RemoteException {
        this.f376c.f381a.mo30894b();
        this.f374a.mo17057d("onRequestInfo", new Object[0]);
    }

    /* renamed from: c */
    public void mo30609c(Bundle bundle) throws RemoteException {
        this.f376c.f381a.mo30894b();
        this.f374a.mo17057d("onCompleteUpdate", new Object[0]);
    }
}
