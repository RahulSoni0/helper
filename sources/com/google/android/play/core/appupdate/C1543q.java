package com.google.android.play.core.appupdate;

import android.content.Context;
import java.io.File;

/* renamed from: com.google.android.play.core.appupdate.q */
final class C1543q {

    /* renamed from: a */
    private final Context f387a;

    C1543q(Context context) {
        this.f387a = context;
    }

    /* renamed from: b */
    private static long m336b(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles != null) {
            for (File b : listFiles) {
                j += m336b(b);
            }
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final long mo30612a() {
        return m336b(new File(this.f387a.getFilesDir(), "assetpacks"));
    }
}
