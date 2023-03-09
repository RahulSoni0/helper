package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.appupdate.m */
final class C1539m extends C1538l<Void> {
    C1539m(C1541o oVar, C1786i<Void> iVar) {
        super(oVar, new C0944ag("OnCompleteUpdateCallback"), iVar);
    }

    /* renamed from: c */
    public final void mo30609c(Bundle bundle) throws RemoteException {
        super.mo30609c(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.f375b.mo31065d(new InstallException(bundle.getInt("error.code", -2)));
        } else {
            this.f375b.mo31066e(null);
        }
    }
}
