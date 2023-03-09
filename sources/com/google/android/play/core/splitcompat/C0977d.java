package com.google.android.play.core.splitcompat;

import java.io.File;
import java.io.IOException;

/* renamed from: com.google.android.play.core.splitcompat.d */
final class C0977d implements C0982i {

    /* renamed from: a */
    final /* synthetic */ C0978e f174a;

    C0977d(C0978e eVar) {
        this.f174a = eVar;
    }

    /* renamed from: a */
    public final void mo17113a(C0983j jVar, File file, boolean z) throws IOException {
        this.f174a.f176b.add(file);
        if (!z) {
            this.f174a.f177c.set(false);
        }
    }
}
