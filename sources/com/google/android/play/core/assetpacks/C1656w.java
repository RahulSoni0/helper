package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1672ah;
import com.google.android.play.core.internal.C1712t;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.assetpacks.w */
final class C1656w extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ String f813a;

    /* renamed from: b */
    final /* synthetic */ C1786i f814b;

    /* renamed from: c */
    final /* synthetic */ C1564an f815c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1656w(C1564an anVar, C1786i iVar, String str, C1786i iVar2) {
        super(iVar);
        this.f815c = anVar;
        this.f813a = str;
        this.f814b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30607a() {
        try {
            ((C1712t) this.f815c.f479e.mo30895c()).mo30963l(this.f815c.f477c, C1564an.m394A(0, this.f813a), C1564an.m396C(), new C1557ag(this.f815c, this.f814b, (short[]) null));
        } catch (RemoteException e) {
            C1564an.f475a.mo17056c(e, "removePack(%s)", this.f813a);
        }
    }
}
