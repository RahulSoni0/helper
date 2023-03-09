package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1672ah;
import com.google.android.play.core.internal.C1712t;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.assetpacks.ab */
final class C1552ab extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ int f441a;

    /* renamed from: b */
    final /* synthetic */ String f442b;

    /* renamed from: c */
    final /* synthetic */ String f443c;

    /* renamed from: d */
    final /* synthetic */ int f444d;

    /* renamed from: e */
    final /* synthetic */ C1786i f445e;

    /* renamed from: f */
    final /* synthetic */ C1564an f446f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1552ab(C1564an anVar, C1786i iVar, int i, String str, String str2, int i2, C1786i iVar2) {
        super(iVar);
        this.f446f = anVar;
        this.f441a = i;
        this.f442b = str;
        this.f443c = str2;
        this.f444d = i2;
        this.f445e = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30607a() {
        try {
            ((C1712t) this.f446f.f479e.mo30895c()).mo30957f(this.f446f.f477c, C1564an.m404r(this.f441a, this.f442b, this.f443c, this.f444d), C1564an.m396C(), new C1557ag(this.f446f, this.f445e, (char[]) null));
        } catch (RemoteException e) {
            C1564an.f475a.mo17056c(e, "notifyChunkTransferred", new Object[0]);
        }
    }
}
