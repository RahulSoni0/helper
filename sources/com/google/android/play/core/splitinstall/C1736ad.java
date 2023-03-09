package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.C1672ah;
import com.google.android.play.core.tasks.C1786i;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.google.android.play.core.splitinstall.ad */
final class C1736ad extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ Collection f927a;

    /* renamed from: b */
    final /* synthetic */ Collection f928b;

    /* renamed from: c */
    final /* synthetic */ C1786i f929c;

    /* renamed from: d */
    final /* synthetic */ C1753au f930d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1736ad(C1753au auVar, C1786i iVar, Collection collection, Collection collection2, C1786i iVar2) {
        super(iVar);
        this.f930d = auVar;
        this.f927a = collection;
        this.f928b = collection2;
        this.f929c = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30607a() {
        ArrayList i = C1753au.m874i(this.f927a);
        i.addAll(C1753au.m875j(this.f928b));
        try {
            this.f930d.f955a.mo30895c().mo30899c(this.f930d.f956d, i, C1753au.m877l(), new C1751as(this.f930d, this.f929c));
        } catch (RemoteException e) {
            C1753au.f953b.mo17056c(e, "startInstall(%s,%s)", this.f927a, this.f928b);
            this.f929c.mo31065d(new RuntimeException(e));
        }
    }
}
