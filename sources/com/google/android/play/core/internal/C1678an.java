package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.an */
final class C1678an extends C1672ah {

    /* renamed from: a */
    final /* synthetic */ IBinder f849a;

    /* renamed from: b */
    final /* synthetic */ C1680ap f850b;

    C1678an(C1680ap apVar, IBinder iBinder) {
        this.f850b = apVar;
        this.f849a = iBinder;
    }

    /* renamed from: a */
    public final void mo30607a() {
        C1681aq aqVar = this.f850b.f852a;
        aqVar.f864l = (IInterface) aqVar.f860h.mo30606a(this.f849a);
        C1681aq.m689j(this.f850b.f852a);
        this.f850b.f852a.f858f = false;
        for (Runnable run : this.f850b.f852a.f857e) {
            run.run();
        }
        this.f850b.f852a.f857e.clear();
    }
}
