package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C1672ah;
import com.google.android.play.core.internal.C1712t;
import com.google.android.play.core.tasks.C1786i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.aa */
final class C1551aa extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ List f436a;

    /* renamed from: b */
    final /* synthetic */ Map f437b;

    /* renamed from: c */
    final /* synthetic */ C1786i f438c;

    /* renamed from: d */
    final /* synthetic */ C1569as f439d;

    /* renamed from: e */
    final /* synthetic */ C1564an f440e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1551aa(C1564an anVar, C1786i iVar, List list, Map map, C1786i iVar2, C1569as asVar) {
        super(iVar);
        this.f440e = anVar;
        this.f436a = list;
        this.f437b = map;
        this.f438c = iVar2;
        this.f439d = asVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30607a() {
        ArrayList k = C1564an.m397k(this.f436a);
        try {
            String l = this.f440e.f477c;
            Bundle m = C1564an.m399m(this.f437b);
            C1564an anVar = this.f440e;
            ((C1712t) this.f440e.f479e.mo30895c()).mo30962k(l, k, m, new C1562al(anVar, this.f438c, anVar.f478d, this.f439d));
        } catch (RemoteException e) {
            C1564an.f475a.mo17056c(e, "getPackStates(%s)", this.f436a);
            this.f438c.mo31065d(new RuntimeException(e));
        }
    }
}
