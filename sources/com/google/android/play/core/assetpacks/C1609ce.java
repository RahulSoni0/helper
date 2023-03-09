package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.C1786i;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.ce */
final /* synthetic */ class C1609ce implements Runnable {

    /* renamed from: a */
    private final C1614cj f661a;

    /* renamed from: b */
    private final List f662b;

    /* renamed from: c */
    private final C1786i f663c;

    /* renamed from: d */
    private final List f664d;

    C1609ce(C1614cj cjVar, List list, C1786i iVar, List list2) {
        this.f661a = cjVar;
        this.f662b = list;
        this.f663c = iVar;
        this.f664d = list2;
    }

    public final void run() {
        this.f661a.mo30804o(this.f662b, this.f663c, this.f664d);
    }
}
