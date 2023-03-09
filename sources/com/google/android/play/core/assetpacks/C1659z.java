package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1672ah;
import com.google.android.play.core.internal.C1712t;
import com.google.android.play.core.tasks.C1786i;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.z */
final class C1659z extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ Map f824a;

    /* renamed from: b */
    final /* synthetic */ C1786i f825b;

    /* renamed from: c */
    final /* synthetic */ C1564an f826c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1659z(C1564an anVar, C1786i iVar, Map map, C1786i iVar2) {
        super(iVar);
        this.f826c = anVar;
        this.f824a = map;
        this.f825b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30607a() {
        try {
            ((C1712t) this.f826c.f479e.mo30895c()).mo30956e(this.f826c.f477c, C1564an.m399m(this.f824a), new C1559ai(this.f826c, this.f825b));
        } catch (RemoteException e) {
            C1564an.f475a.mo17056c(e, "syncPacks", new Object[0]);
            this.f825b.mo31065d(new RuntimeException(e));
        }
    }
}
