package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1672ah;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.splitinstall.ak */
final class C1743ak extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ int f948a;

    /* renamed from: b */
    final /* synthetic */ C1786i f949b;

    /* renamed from: c */
    final /* synthetic */ C1753au f950c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1743ak(C1753au auVar, C1786i iVar, int i, C1786i iVar2) {
        super(iVar);
        this.f950c = auVar;
        this.f948a = i;
        this.f949b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30607a() {
        try {
            this.f950c.f955a.mo30895c().mo30900d(this.f950c.f956d, this.f948a, C1753au.m877l(), new C1744al(this.f950c, this.f949b));
        } catch (RemoteException e) {
            C1753au.f953b.mo17056c(e, "cancelInstall(%d)", Integer.valueOf(this.f948a));
            this.f949b.mo31065d(new RuntimeException(e));
        }
    }
}
