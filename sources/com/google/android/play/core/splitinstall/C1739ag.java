package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1672ah;
import com.google.android.play.core.tasks.C1786i;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.ag */
final class C1739ag extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ List f937a;

    /* renamed from: b */
    final /* synthetic */ C1786i f938b;

    /* renamed from: c */
    final /* synthetic */ C1753au f939c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1739ag(C1753au auVar, C1786i iVar, List list, C1786i iVar2) {
        super(iVar);
        this.f939c = auVar;
        this.f937a = list;
        this.f938b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30607a() {
        try {
            this.f939c.f955a.mo30895c().mo30905i(this.f939c.f956d, C1753au.m875j(this.f937a), C1753au.m877l(), new C1746an(this.f939c, this.f938b));
        } catch (RemoteException e) {
            C1753au.f953b.mo17056c(e, "deferredLanguageInstall(%s)", this.f937a);
            this.f938b.mo31065d(new RuntimeException(e));
        }
    }
}
