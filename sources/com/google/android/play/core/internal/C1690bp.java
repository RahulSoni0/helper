package com.google.android.play.core.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.Build;
import com.google.android.play.core.splitcompat.C0989p;
import java.util.Arrays;

/* renamed from: com.google.android.play.core.internal.bp */
public final class C1690bp {

    /* renamed from: a */
    private static final C0944ag f867a = new C0944ag("PhoneskyVerificationUtils");

    /* renamed from: a */
    public static boolean m735a(Context context) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo("com.android.vending", 64).signatures;
            if (signatureArr == null || (r1 = signatureArr.length) == 0) {
                f867a.mo17058e("Phonesky package is not signed -- possibly self-built package. Could not verify.", new Object[0]);
                return false;
            }
            for (Signature byteArray : signatureArr) {
                String b = C0989p.m203b(byteArray.toByteArray());
                if ("8P1sW0EPJcslw7UzRsiXL64w-O50Ed-RBICtay1g24M".equals(b)) {
                    return true;
                }
                if ((Build.TAGS.contains("dev-keys") || Build.TAGS.contains("test-keys")) && "GXWy8XF3vIml3_MfnmSmyuKBpT3B0dWbHRR_4cgq-gA".equals(b)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    /* renamed from: b */
    public static boolean m736b(Context context) {
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        return packagesForUid != null && Arrays.asList(packagesForUid).contains("com.android.vending");
    }
}
