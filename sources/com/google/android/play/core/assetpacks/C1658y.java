package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1672ah;
import com.google.android.play.core.internal.C1712t;
import com.google.android.play.core.tasks.C1786i;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.y */
final class C1658y extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ List f821a;

    /* renamed from: b */
    final /* synthetic */ C1786i f822b;

    /* renamed from: c */
    final /* synthetic */ C1564an f823c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1658y(C1564an anVar, C1786i iVar, List list, C1786i iVar2) {
        super(iVar);
        this.f823c = anVar;
        this.f821a = list;
        this.f822b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30607a() {
        try {
            ((C1712t) this.f823c.f479e.mo30895c()).mo30955d(this.f823c.f477c, C1564an.m397k(this.f821a), C1564an.m396C(), new C1557ag(this.f823c, this.f822b, (byte[]) null));
        } catch (RemoteException e) {
            C1564an.f475a.mo17056c(e, "cancelDownloads(%s)", this.f821a);
        }
    }
}
