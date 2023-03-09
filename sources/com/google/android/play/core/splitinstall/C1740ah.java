package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1672ah;
import com.google.android.play.core.tasks.C1786i;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.ah */
final class C1740ah extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ List f940a;

    /* renamed from: b */
    final /* synthetic */ C1786i f941b;

    /* renamed from: c */
    final /* synthetic */ C1753au f942c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1740ah(C1753au auVar, C1786i iVar, List list, C1786i iVar2) {
        super(iVar);
        this.f942c = auVar;
        this.f940a = list;
        this.f941b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30607a() {
        try {
            this.f942c.f955a.mo30895c().mo30906j(this.f942c.f956d, C1753au.m875j(this.f940a), C1753au.m877l(), new C1747ao(this.f942c, this.f941b));
        } catch (RemoteException e) {
            C1753au.f953b.mo17056c(e, "deferredLanguageUninstall(%s)", this.f940a);
            this.f941b.mo31065d(new RuntimeException(e));
        }
    }
}
