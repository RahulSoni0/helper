package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1672ah;
import com.google.android.play.core.tasks.C1786i;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.ae */
final class C1737ae extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ List f931a;

    /* renamed from: b */
    final /* synthetic */ C1786i f932b;

    /* renamed from: c */
    final /* synthetic */ C1753au f933c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1737ae(C1753au auVar, C1786i iVar, List list, C1786i iVar2) {
        super(iVar);
        this.f933c = auVar;
        this.f931a = list;
        this.f932b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30607a() {
        try {
            this.f933c.f955a.mo30895c().mo30903g(this.f933c.f956d, C1753au.m874i(this.f931a), C1753au.m877l(), new C1748ap(this.f933c, this.f932b));
        } catch (RemoteException e) {
            C1753au.f953b.mo17056c(e, "deferredUninstall(%s)", this.f931a);
            this.f932b.mo31065d(new RuntimeException(e));
        }
    }
}
