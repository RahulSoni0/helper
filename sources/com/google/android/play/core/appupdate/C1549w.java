package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.internal.C1694cc;
import com.google.android.play.core.internal.C1696ce;

/* renamed from: com.google.android.play.core.appupdate.w */
public final class C1549w {

    /* renamed from: a */
    private C1696ce<Context> f423a;

    /* renamed from: b */
    private C1696ce<C1543q> f424b;

    /* renamed from: c */
    private C1696ce<C1541o> f425c;

    /* renamed from: d */
    private C1696ce<C1527a> f426d;

    /* renamed from: e */
    private C1696ce<C1530d> f427e;

    /* renamed from: f */
    private C1696ce<AppUpdateManager> f428f;

    /* synthetic */ C1549w(C1532f fVar) {
        C1534h hVar = new C1534h(fVar);
        this.f423a = hVar;
        C1696ce<C1543q> b = C1694cc.m742b(new C1533g((C1696ce<Context>) hVar, (char[]) null));
        this.f424b = b;
        this.f425c = C1694cc.m742b(new C1542p(this.f423a, b));
        C1696ce<C1527a> b2 = C1694cc.m742b(new C1533g(this.f423a, (byte[]) null));
        this.f426d = b2;
        C1696ce<C1530d> b3 = C1694cc.m742b(new C1531e(this.f425c, b2, this.f423a));
        this.f427e = b3;
        this.f428f = C1694cc.m742b(new C1533g(b3));
    }

    /* renamed from: a */
    public final AppUpdateManager mo30641a() {
        return this.f428f.mo30603a();
    }
}
