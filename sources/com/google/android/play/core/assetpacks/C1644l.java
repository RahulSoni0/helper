package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* renamed from: com.google.android.play.core.assetpacks.l */
final class C1644l {

    /* renamed from: a */
    private final Context f795a;

    public C1644l(Context context) {
        this.f795a = context;
    }

    /* renamed from: b */
    static String m624b(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            return bundle.getString("local_testing_dir");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Context mo30865a() {
        return this.f795a;
    }
}
