package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1672ah;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.appupdate.j */
final class C1536j extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ String f368a;

    /* renamed from: b */
    final /* synthetic */ C1786i f369b;

    /* renamed from: c */
    final /* synthetic */ C1541o f370c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1536j(C1541o oVar, C1786i iVar, String str, C1786i iVar2) {
        super(iVar);
        this.f370c = oVar;
        this.f368a = str;
        this.f369b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30607a() {
        try {
            this.f370c.f381a.mo30895c().mo30952c(this.f370c.f382d, C1541o.m326d(this.f370c, this.f368a), new C1540n(this.f370c, this.f369b, this.f368a));
        } catch (RemoteException e) {
            C1541o.f379b.mo17056c(e, "requestUpdateInfo(%s)", this.f368a);
            this.f369b.mo31065d(new RuntimeException(e));
        }
    }
}
