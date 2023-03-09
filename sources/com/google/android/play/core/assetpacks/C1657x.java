package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C1672ah;
import com.google.android.play.core.internal.C1712t;
import com.google.android.play.core.tasks.C1786i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.x */
final class C1657x extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ List f816a;

    /* renamed from: b */
    final /* synthetic */ Map f817b;

    /* renamed from: c */
    final /* synthetic */ C1786i f818c;

    /* renamed from: d */
    final /* synthetic */ List f819d;

    /* renamed from: e */
    final /* synthetic */ C1564an f820e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1657x(C1564an anVar, C1786i iVar, List list, Map map, C1786i iVar2, List list2) {
        super(iVar);
        this.f820e = anVar;
        this.f816a = list;
        this.f817b = map;
        this.f818c = iVar2;
        this.f819d = list2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30607a() {
        ArrayList k = C1564an.m397k(this.f816a);
        try {
            String l = this.f820e.f477c;
            Bundle m = C1564an.m399m(this.f817b);
            C1564an anVar = this.f820e;
            ((C1712t) this.f820e.f479e.mo30895c()).mo30954c(l, k, m, new C1563am(anVar, this.f818c, anVar.f478d, this.f819d));
        } catch (RemoteException e) {
            C1564an.f475a.mo17056c(e, "startDownload(%s)", this.f816a);
            this.f818c.mo31065d(new RuntimeException(e));
        }
    }
}
