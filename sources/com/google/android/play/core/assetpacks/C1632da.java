package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.google.android.play.core.assetpacks.da */
final /* synthetic */ class C1632da implements FilenameFilter {

    /* renamed from: a */
    static final FilenameFilter f751a = new C1632da();

    private C1632da() {
    }

    public final boolean accept(File file, String str) {
        return C1633db.f752a.matcher(str).matches();
    }
}
