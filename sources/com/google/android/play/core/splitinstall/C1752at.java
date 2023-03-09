package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C1687bm;
import com.google.android.play.core.tasks.C1786i;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.at */
class C1752at<T> extends C1687bm {

    /* renamed from: a */
    final C1786i<T> f951a;

    /* renamed from: b */
    final /* synthetic */ C1753au f952b;

    C1752at(C1753au auVar, C1786i<T> iVar) {
        this.f952b = auVar;
        this.f951a = iVar;
    }

    /* renamed from: b */
    public void mo30907b(int i, Bundle bundle) throws RemoteException {
        this.f952b.f955a.mo30894b();
        C1753au.f953b.mo17057d("onCancelInstall(%d)", Integer.valueOf(i));
    }

    /* renamed from: c */
    public void mo30908c(Bundle bundle) throws RemoteException {
        this.f952b.f955a.mo30894b();
        C1753au.f953b.mo17057d("onDeferredInstall", new Object[0]);
    }

    /* renamed from: d */
    public void mo30909d(Bundle bundle) throws RemoteException {
        this.f952b.f955a.mo30894b();
        C1753au.f953b.mo17057d("onDeferredLanguageInstall", new Object[0]);
    }

    /* renamed from: e */
    public void mo30910e(Bundle bundle) throws RemoteException {
        this.f952b.f955a.mo30894b();
        C1753au.f953b.mo17057d("onDeferredLanguageUninstall", new Object[0]);
    }

    /* renamed from: f */
    public void mo30911f(Bundle bundle) throws RemoteException {
        this.f952b.f955a.mo30894b();
        C1753au.f953b.mo17057d("onDeferredUninstall", new Object[0]);
    }

    /* renamed from: g */
    public void mo30912g(int i, Bundle bundle) throws RemoteException {
        this.f952b.f955a.mo30894b();
        C1753au.f953b.mo17057d("onGetSession(%d)", Integer.valueOf(i));
    }

    /* renamed from: h */
    public void mo30913h(List<Bundle> list) throws RemoteException {
        this.f952b.f955a.mo30894b();
        C1753au.f953b.mo17057d("onGetSessionStates", new Object[0]);
    }

    /* renamed from: i */
    public void mo30914i(int i, Bundle bundle) throws RemoteException {
        this.f952b.f955a.mo30894b();
        C1753au.f953b.mo17057d("onStartInstall(%d)", Integer.valueOf(i));
    }

    /* renamed from: j */
    public final void mo30915j(Bundle bundle) throws RemoteException {
        this.f952b.f955a.mo30894b();
        int i = bundle.getInt("error_code");
        C1753au.f953b.mo17055b("onError(%d)", Integer.valueOf(i));
        this.f951a.mo31065d(new SplitInstallException(i));
    }

    /* renamed from: k */
    public final void mo30916k(int i) throws RemoteException {
        this.f952b.f955a.mo30894b();
        C1753au.f953b.mo17057d("onCompleteInstall(%d)", Integer.valueOf(i));
    }

    /* renamed from: l */
    public final void mo30917l() throws RemoteException {
        this.f952b.f955a.mo30894b();
        C1753au.f953b.mo17057d("onCompleteInstallForAppUpdate", new Object[0]);
    }

    /* renamed from: m */
    public final void mo30918m() throws RemoteException {
        this.f952b.f955a.mo30894b();
        C1753au.f953b.mo17057d("onGetSplitsForAppUpdate", new Object[0]);
    }
}
