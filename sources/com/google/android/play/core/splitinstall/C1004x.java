package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.io.File;

/* renamed from: com.google.android.play.core.splitinstall.x */
public final class C1004x {

    /* renamed from: a */
    private final Context f212a;

    C1004x(Context context) {
        this.f212a = context;
    }

    /* renamed from: c */
    static File m242c(Context context) {
        String string;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null || (string = bundle.getString("local_testing_dir")) == null) {
                return null;
            }
            return new File(context.getExternalFilesDir((String) null), string);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C1003s mo17144a() {
        return C1003s.m235b(this.f212a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final Context mo17145b() {
        return this.f212a;
    }
}
