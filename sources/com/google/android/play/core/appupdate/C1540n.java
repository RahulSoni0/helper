package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.appupdate.n */
final class C1540n extends C1538l<AppUpdateInfo> {

    /* renamed from: d */
    final /* synthetic */ C1541o f377d;

    /* renamed from: e */
    private final String f378e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1540n(C1541o oVar, C1786i<AppUpdateInfo> iVar, String str) {
        super(oVar, new C0944ag("OnRequestInstallCallback"), iVar);
        this.f377d = oVar;
        this.f378e = str;
    }

    /* renamed from: b */
    public final void mo30608b(Bundle bundle) throws RemoteException {
        super.mo30608b(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.f375b.mo31065d(new InstallException(bundle.getInt("error.code", -2)));
        } else {
            this.f375b.mo31066e(C1541o.m330h(this.f377d, bundle, this.f378e));
        }
    }
}
