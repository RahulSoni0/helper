package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1672ah;
import com.google.android.play.core.internal.C1712t;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.assetpacks.ad */
final class C1554ad extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ int f452a;

    /* renamed from: b */
    final /* synthetic */ C1786i f453b;

    /* renamed from: c */
    final /* synthetic */ C1564an f454c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1554ad(C1564an anVar, C1786i iVar, int i, C1786i iVar2) {
        super(iVar);
        this.f454c = anVar;
        this.f452a = i;
        this.f453b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30607a() {
        try {
            ((C1712t) this.f454c.f479e.mo30895c()).mo30959h(this.f454c.f477c, C1564an.m395B(this.f452a), C1564an.m396C(), new C1557ag(this.f454c, this.f453b, (int[]) null));
        } catch (RemoteException e) {
            C1564an.f475a.mo17056c(e, "notifySessionFailed", new Object[0]);
        }
    }
}
