package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1672ah;
import com.google.android.play.core.internal.C1712t;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.assetpacks.ac */
final class C1553ac extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ int f447a;

    /* renamed from: b */
    final /* synthetic */ String f448b;

    /* renamed from: c */
    final /* synthetic */ C1786i f449c;

    /* renamed from: d */
    final /* synthetic */ int f450d;

    /* renamed from: e */
    final /* synthetic */ C1564an f451e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1553ac(C1564an anVar, C1786i iVar, int i, String str, C1786i iVar2, int i2) {
        super(iVar);
        this.f451e = anVar;
        this.f447a = i;
        this.f448b = str;
        this.f449c = iVar2;
        this.f450d = i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30607a() {
        try {
            ((C1712t) this.f451e.f479e.mo30895c()).mo30958g(this.f451e.f477c, C1564an.m394A(this.f447a, this.f448b), C1564an.m396C(), new C1561ak(this.f451e, this.f449c, this.f447a, this.f448b, this.f450d));
        } catch (RemoteException e) {
            C1564an.f475a.mo17056c(e, "notifyModuleCompleted", new Object[0]);
        }
    }
}
