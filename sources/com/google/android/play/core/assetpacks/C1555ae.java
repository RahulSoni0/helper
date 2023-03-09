package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1672ah;
import com.google.android.play.core.internal.C1712t;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.assetpacks.ae */
final class C1555ae extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ int f455a;

    /* renamed from: b */
    final /* synthetic */ String f456b;

    /* renamed from: c */
    final /* synthetic */ String f457c;

    /* renamed from: d */
    final /* synthetic */ int f458d;

    /* renamed from: e */
    final /* synthetic */ C1786i f459e;

    /* renamed from: f */
    final /* synthetic */ C1564an f460f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1555ae(C1564an anVar, C1786i iVar, int i, String str, String str2, int i2, C1786i iVar2) {
        super(iVar);
        this.f460f = anVar;
        this.f455a = i;
        this.f456b = str;
        this.f457c = str2;
        this.f458d = i2;
        this.f459e = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30607a() {
        try {
            ((C1712t) this.f460f.f479e.mo30895c()).mo30961j(this.f460f.f477c, C1564an.m404r(this.f455a, this.f456b, this.f457c, this.f458d), C1564an.m396C(), new C1558ah(this.f460f, this.f459e));
        } catch (RemoteException e) {
            C1564an.f475a.mo17055b("getChunkFileDescriptor(%s, %s, %d, session=%d)", this.f456b, this.f457c, Integer.valueOf(this.f458d), Integer.valueOf(this.f455a));
            this.f459e.mo31065d(new RuntimeException(e));
        }
    }
}
