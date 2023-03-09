package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.ak */
final class C1675ak extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ C1681aq f848a;

    C1675ak(C1681aq aqVar) {
        this.f848a = aqVar;
    }

    /* renamed from: a */
    public final void mo30607a() {
        if (this.f848a.f864l != null) {
            this.f848a.f855c.mo17057d("Unbind from service.", new Object[0]);
            this.f848a.f854b.unbindService(this.f848a.f863k);
            this.f848a.f858f = false;
            this.f848a.f864l = null;
            this.f848a.f863k = null;
        }
    }
}
