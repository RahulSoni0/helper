package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1672ah;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.splitinstall.ai */
final class C1741ai extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ int f943a;

    /* renamed from: b */
    final /* synthetic */ C1786i f944b;

    /* renamed from: c */
    final /* synthetic */ C1753au f945c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1741ai(C1753au auVar, C1786i iVar, int i, C1786i iVar2) {
        super(iVar);
        this.f945c = auVar;
        this.f943a = i;
        this.f944b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30607a() {
        try {
            this.f945c.f955a.mo30895c().mo30901e(this.f945c.f956d, this.f943a, new C1749aq(this.f945c, this.f944b));
        } catch (RemoteException e) {
            C1753au.f953b.mo17056c(e, "getSessionState(%d)", Integer.valueOf(this.f943a));
            this.f944b.mo31065d(new RuntimeException(e));
        }
    }
}
