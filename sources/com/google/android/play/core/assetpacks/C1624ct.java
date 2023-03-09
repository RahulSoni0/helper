package com.google.android.play.core.assetpacks;

import com.google.android.play.core.common.C1661a;
import com.google.android.play.core.internal.C1692ca;
import java.io.File;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.ct */
final class C1624ct {

    /* renamed from: a */
    private final C1571au f708a;

    /* renamed from: b */
    private final C1692ca<C1653t> f709b;

    /* renamed from: c */
    private final C1605ca f710c;

    /* renamed from: d */
    private final C1692ca<Executor> f711d;

    /* renamed from: e */
    private final C1592bo f712e;

    /* renamed from: f */
    private final C1661a f713f;

    C1624ct(C1571au auVar, C1692ca<C1653t> caVar, C1605ca caVar2, C1692ca<Executor> caVar3, C1592bo boVar, C1661a aVar) {
        this.f708a = auVar;
        this.f709b = caVar;
        this.f710c = caVar2;
        this.f711d = caVar3;
        this.f712e = boVar;
        this.f713f = aVar;
    }

    /* renamed from: a */
    public final void mo30816a(C1621cq cqVar) {
        Runnable runnable;
        Executor executor;
        File j = this.f708a.mo30722j(cqVar.f655k, cqVar.f703a, cqVar.f704b);
        File p = this.f708a.mo30728p(cqVar.f655k, cqVar.f703a, cqVar.f704b);
        if (!j.exists() || !p.exists()) {
            throw new C1588bk(String.format("Cannot find pack files to move for pack %s.", new Object[]{cqVar.f655k}), cqVar.f654j);
        }
        File f = this.f708a.mo30718f(cqVar.f655k, cqVar.f703a, cqVar.f704b);
        f.mkdirs();
        if (j.renameTo(f)) {
            new File(this.f708a.mo30718f(cqVar.f655k, cqVar.f703a, cqVar.f704b), "merge.tmp").delete();
            File g = this.f708a.mo30719g(cqVar.f655k, cqVar.f703a, cqVar.f704b);
            g.mkdirs();
            if (p.renameTo(g)) {
                if (this.f713f.mo30870a()) {
                    executor = this.f711d.mo30920a();
                    runnable = new C1622cr(this, cqVar);
                } else {
                    executor = this.f711d.mo30920a();
                    C1571au auVar = this.f708a;
                    auVar.getClass();
                    runnable = C1623cs.m574a(auVar);
                }
                executor.execute(runnable);
                this.f710c.mo30784f(cqVar.f655k, cqVar.f703a, cqVar.f704b);
                this.f712e.mo30774a(cqVar.f655k);
                this.f709b.mo30920a().mo30698f(cqVar.f654j, cqVar.f655k);
                return;
            }
            throw new C1588bk("Cannot move metadata files to final location.", cqVar.f654j);
        }
        throw new C1588bk("Cannot move merged pack files to final location.", cqVar.f654j);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo30817b(C1621cq cqVar) {
        this.f708a.mo30730r(cqVar.f655k, cqVar.f703a, cqVar.f704b);
    }
}
