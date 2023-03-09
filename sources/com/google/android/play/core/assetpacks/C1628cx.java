package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.internal.C0960bh;
import com.google.android.play.core.internal.C0971bz;
import com.google.android.play.core.internal.C1692ca;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* renamed from: com.google.android.play.core.assetpacks.cx */
final class C1628cx {

    /* renamed from: a */
    private static final C0944ag f732a = new C0944ag("PatchSliceTaskHandler");

    /* renamed from: b */
    private final C1571au f733b;

    /* renamed from: c */
    private final C1692ca<C1653t> f734c;

    C1628cx(C1571au auVar, C1692ca<C1653t> caVar) {
        this.f733b = auVar;
        this.f734c = caVar;
    }

    /* renamed from: a */
    public final void mo30819a(C1627cw cwVar) {
        InputStream inputStream;
        File f = this.f733b.mo30718f(cwVar.f655k, cwVar.f724a, cwVar.f725b);
        C1571au auVar = this.f733b;
        String str = cwVar.f655k;
        int i = cwVar.f724a;
        long j = cwVar.f725b;
        File file = new File(auVar.mo30719g(str, i, j), cwVar.f729f);
        try {
            inputStream = cwVar.f731h;
            if (cwVar.f728e == 2) {
                inputStream = new GZIPInputStream(inputStream, 8192);
            }
            C1573aw awVar = new C1573aw(f, file);
            File h = this.f733b.mo30720h(cwVar.f655k, cwVar.f726c, cwVar.f727d, cwVar.f729f);
            if (!h.exists()) {
                h.mkdirs();
            }
            C1630cz czVar = new C1630cz(this.f733b, cwVar.f655k, cwVar.f726c, cwVar.f727d, cwVar.f729f);
            C0960bh.m108l(awVar, inputStream, new C1591bn(h, czVar), cwVar.f730g);
            czVar.mo30831d(0);
            inputStream.close();
            f732a.mo17057d("Patching and extraction finished for slice %s of pack %s.", cwVar.f729f, cwVar.f655k);
            this.f734c.mo30920a().mo30697e(cwVar.f654j, cwVar.f655k, cwVar.f729f, 0);
            try {
                cwVar.f731h.close();
                return;
            } catch (IOException unused) {
                f732a.mo17058e("Could not close file for slice %s of pack %s.", cwVar.f729f, cwVar.f655k);
                return;
            }
        } catch (IOException e) {
            f732a.mo17055b("IOException during patching %s.", e.getMessage());
            throw new C1588bk(String.format("Error patching slice %s of pack %s.", new Object[]{cwVar.f729f, cwVar.f655k}), e, cwVar.f654j);
        } catch (Throwable th) {
            C0971bz.m125a(th, th);
        }
        throw th;
    }
}
