package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.zip.ZipFile;

/* renamed from: com.google.android.play.core.splitcompat.f */
final class C0979f implements C0981h {

    /* renamed from: a */
    final /* synthetic */ Set f179a;

    /* renamed from: b */
    final /* synthetic */ C0990q f180b;

    /* renamed from: c */
    final /* synthetic */ C0984k f181c;

    C0979f(C0984k kVar, Set set, C0990q qVar) {
        this.f181c = kVar;
        this.f179a = set;
        this.f180b = qVar;
    }

    /* renamed from: a */
    public final void mo17114a(ZipFile zipFile, Set<C0983j> set) throws IOException {
        this.f179a.addAll(C0984k.m196d(this.f181c, set, this.f180b, zipFile));
    }
}
