package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C0944ag;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.play.core.assetpacks.dd */
final class C1635dd {

    /* renamed from: a */
    private static final C0944ag f757a = new C0944ag("VerifySliceTaskHandler");

    /* renamed from: b */
    private final C1571au f758b;

    C1635dd(C1571au auVar) {
        this.f758b = auVar;
    }

    /* renamed from: b */
    private final void m602b(C1634dc dcVar, File file) {
        try {
            File o = this.f758b.mo30727o(dcVar.f655k, dcVar.f753a, dcVar.f754b, dcVar.f755c);
            if (o.exists()) {
                try {
                    if (C1615ck.m554a(C1633db.m600a(file, o)).equals(dcVar.f756d)) {
                        f757a.mo17057d("Verification of slice %s of pack %s successful.", dcVar.f755c, dcVar.f655k);
                        return;
                    }
                    throw new C1588bk(String.format("Verification failed for slice %s.", new Object[]{dcVar.f755c}), dcVar.f654j);
                } catch (NoSuchAlgorithmException e) {
                    throw new C1588bk("SHA256 algorithm not supported.", e, dcVar.f654j);
                } catch (IOException e2) {
                    throw new C1588bk(String.format("Could not digest file during verification for slice %s.", new Object[]{dcVar.f755c}), e2, dcVar.f654j);
                }
            } else {
                throw new C1588bk(String.format("Cannot find metadata files for slice %s.", new Object[]{dcVar.f755c}), dcVar.f654j);
            }
        } catch (IOException e3) {
            throw new C1588bk(String.format("Could not reconstruct slice archive during verification for slice %s.", new Object[]{dcVar.f755c}), e3, dcVar.f654j);
        }
    }

    /* renamed from: a */
    public final void mo30843a(C1634dc dcVar) {
        File h = this.f758b.mo30720h(dcVar.f655k, dcVar.f753a, dcVar.f754b, dcVar.f755c);
        if (h.exists()) {
            m602b(dcVar, h);
            File i = this.f758b.mo30721i(dcVar.f655k, dcVar.f753a, dcVar.f754b, dcVar.f755c);
            if (!i.exists()) {
                i.mkdirs();
            }
            if (!h.renameTo(i)) {
                throw new C1588bk(String.format("Failed to move slice %s after verification.", new Object[]{dcVar.f755c}), dcVar.f654j);
            }
            return;
        }
        throw new C1588bk(String.format("Cannot find unverified files for slice %s.", new Object[]{dcVar.f755c}), dcVar.f654j);
    }
}
