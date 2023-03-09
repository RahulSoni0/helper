package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.google.android.play.core.assetpacks.ch */
final /* synthetic */ class C1612ch implements FilenameFilter {

    /* renamed from: a */
    private final String f672a;

    C1612ch(String str) {
        this.f672a = str;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(String.valueOf(this.f672a).concat("-")) && str.endsWith(".apk");
    }
}
