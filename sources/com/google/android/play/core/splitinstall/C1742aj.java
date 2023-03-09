package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1672ah;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.splitinstall.aj */
final class C1742aj extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ C1786i f946a;

    /* renamed from: b */
    final /* synthetic */ C1753au f947b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1742aj(C1753au auVar, C1786i iVar, C1786i iVar2) {
        super(iVar);
        this.f947b = auVar;
        this.f946a = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30607a() {
        try {
            this.f947b.f955a.mo30895c().mo30902f(this.f947b.f956d, new C1750ar(this.f947b, this.f946a));
        } catch (RemoteException e) {
            C1753au.f953b.mo17056c(e, "getSessionStates", new Object[0]);
            this.f946a.mo31065d(new RuntimeException(e));
        }
    }
}
