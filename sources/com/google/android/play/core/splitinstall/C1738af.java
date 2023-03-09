package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1672ah;
import com.google.android.play.core.tasks.C1786i;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.af */
final class C1738af extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ List f934a;

    /* renamed from: b */
    final /* synthetic */ C1786i f935b;

    /* renamed from: c */
    final /* synthetic */ C1753au f936c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1738af(C1753au auVar, C1786i iVar, List list, C1786i iVar2) {
        super(iVar);
        this.f936c = auVar;
        this.f934a = list;
        this.f935b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30607a() {
        try {
            this.f936c.f955a.mo30895c().mo30904h(this.f936c.f956d, C1753au.m874i(this.f934a), C1753au.m877l(), new C1745am(this.f936c, this.f935b));
        } catch (RemoteException e) {
            C1753au.f953b.mo17056c(e, "deferredInstall(%s)", this.f934a);
            this.f935b.mo31065d(new RuntimeException(e));
        }
    }
}
