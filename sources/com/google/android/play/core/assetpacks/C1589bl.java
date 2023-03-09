package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.internal.C1692ca;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.play.core.assetpacks.bl */
final class C1589bl {

    /* renamed from: a */
    private static final C0944ag f583a = new C0944ag("ExtractorLooper");

    /* renamed from: b */
    private final C1605ca f584b;

    /* renamed from: c */
    private final C1587bj f585c;

    /* renamed from: d */
    private final C1635dd f586d;

    /* renamed from: e */
    private final C1619co f587e;

    /* renamed from: f */
    private final C1624ct f588f;

    /* renamed from: g */
    private final C1628cx f589g;

    /* renamed from: h */
    private final C1692ca<C1653t> f590h;

    /* renamed from: i */
    private final C1608cd f591i;

    /* renamed from: j */
    private final AtomicBoolean f592j = new AtomicBoolean(false);

    C1589bl(C1605ca caVar, C1692ca<C1653t> caVar2, C1587bj bjVar, C1635dd ddVar, C1619co coVar, C1624ct ctVar, C1628cx cxVar, C1608cd cdVar) {
        this.f584b = caVar;
        this.f590h = caVar2;
        this.f585c = bjVar;
        this.f586d = ddVar;
        this.f587e = coVar;
        this.f588f = ctVar;
        this.f589g = cxVar;
        this.f591i = cdVar;
    }

    /* renamed from: b */
    private final void m497b(int i, Exception exc) {
        try {
            this.f584b.mo30794p(i);
            this.f584b.mo30785g(i);
        } catch (C1588bk unused) {
            f583a.mo17055b("Error during error handling: %s", exc.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo30770a() {
        C0944ag agVar = f583a;
        agVar.mo17054a("Run extractor loop", new Object[0]);
        if (this.f592j.compareAndSet(false, true)) {
            while (true) {
                C1607cc ccVar = null;
                try {
                    ccVar = this.f591i.mo30795a();
                } catch (C1588bk e) {
                    f583a.mo17055b("Error while getting next extraction task: %s", e.getMessage());
                    if (e.f582a >= 0) {
                        this.f590h.mo30920a().mo30699g(e.f582a);
                        m497b(e.f582a, e);
                    }
                }
                if (ccVar != null) {
                    try {
                        if (ccVar instanceof C1586bi) {
                            this.f585c.mo30769a((C1586bi) ccVar);
                        } else if (ccVar instanceof C1634dc) {
                            this.f586d.mo30843a((C1634dc) ccVar);
                        } else if (ccVar instanceof C1618cn) {
                            this.f587e.mo30813a((C1618cn) ccVar);
                        } else if (ccVar instanceof C1621cq) {
                            this.f588f.mo30816a((C1621cq) ccVar);
                        } else if (ccVar instanceof C1627cw) {
                            this.f589g.mo30819a((C1627cw) ccVar);
                        } else {
                            f583a.mo17055b("Unknown task type: %s", ccVar.getClass().getName());
                        }
                    } catch (Exception e2) {
                        f583a.mo17055b("Error during extraction task: %s", e2.getMessage());
                        this.f590h.mo30920a().mo30699g(ccVar.f654j);
                        m497b(ccVar.f654j, e2);
                    }
                } else {
                    this.f592j.set(false);
                    return;
                }
            }
        } else {
            agVar.mo17058e("runLoop already looping; return", new Object[0]);
        }
    }
}
