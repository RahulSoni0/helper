package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.C1786i;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.cf */
final /* synthetic */ class C1610cf implements Runnable {

    /* renamed from: a */
    private final C1614cj f665a;

    /* renamed from: b */
    private final List f666b;

    /* renamed from: c */
    private final C1569as f667c;

    /* renamed from: d */
    private final C1786i f668d;

    C1610cf(C1614cj cjVar, List list, C1569as asVar, C1786i iVar) {
        this.f665a = cjVar;
        this.f666b = list;
        this.f667c = asVar;
        this.f668d = iVar;
    }

    public final void run() {
        this.f665a.mo30803n(this.f666b, this.f667c, this.f668d);
    }
}
