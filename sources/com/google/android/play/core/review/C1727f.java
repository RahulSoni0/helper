package com.google.android.play.core.review;

import android.os.RemoteException;
import com.google.android.play.core.common.PlayCoreVersion;
import com.google.android.play.core.internal.C1672ah;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.review.f */
final class C1727f extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ C1786i f898a;

    /* renamed from: b */
    final /* synthetic */ C1730i f899b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1727f(C1730i iVar, C1786i iVar2, C1786i iVar3) {
        super(iVar2);
        this.f899b = iVar;
        this.f898a = iVar3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo30607a() {
        try {
            this.f899b.f904a.mo30895c().mo30880c(this.f899b.f905c, PlayCoreVersion.m657b("review"), new C1729h(this.f899b, this.f898a));
        } catch (RemoteException e) {
            C1730i.f903b.mo17056c(e, "error requesting in-app review for %s", this.f899b.f905c);
            this.f898a.mo31065d(new RuntimeException(e));
        }
    }
}
