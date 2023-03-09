package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1672ah;
import com.google.android.play.core.internal.C1712t;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.assetpacks.af */
final class C1556af extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ C1786i f461a;

    /* renamed from: b */
    final /* synthetic */ C1564an f462b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1556af(C1564an anVar, C1786i iVar, C1786i iVar2) {
        super(iVar);
        this.f462b = anVar;
        this.f461a = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30607a() {
        try {
            ((C1712t) this.f462b.f480f.mo30895c()).mo30960i(this.f462b.f477c, C1564an.m396C(), new C1560aj(this.f462b, this.f461a));
        } catch (RemoteException e) {
            C1564an.f475a.mo17056c(e, "keepAlive", new Object[0]);
        }
    }
}
