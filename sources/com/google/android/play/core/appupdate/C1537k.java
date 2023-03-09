package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1672ah;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.appupdate.k */
final class C1537k extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ C1786i f371a;

    /* renamed from: b */
    final /* synthetic */ String f372b;

    /* renamed from: c */
    final /* synthetic */ C1541o f373c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1537k(C1541o oVar, C1786i iVar, C1786i iVar2, String str) {
        super(iVar);
        this.f373c = oVar;
        this.f371a = iVar2;
        this.f372b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30607a() {
        try {
            this.f373c.f381a.mo30895c().mo30953d(this.f373c.f382d, C1541o.m332j(), new C1539m(this.f373c, this.f371a));
        } catch (RemoteException e) {
            C1541o.f379b.mo17056c(e, "completeUpdate(%s)", this.f372b);
            this.f371a.mo31065d(new RuntimeException(e));
        }
    }
}
