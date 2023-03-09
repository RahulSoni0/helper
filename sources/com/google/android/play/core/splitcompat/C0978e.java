package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipFile;

/* renamed from: com.google.android.play.core.splitcompat.e */
final class C0978e implements C0981h {

    /* renamed from: a */
    final /* synthetic */ C0990q f175a;

    /* renamed from: b */
    final /* synthetic */ Set f176b;

    /* renamed from: c */
    final /* synthetic */ AtomicBoolean f177c;

    /* renamed from: d */
    final /* synthetic */ C0984k f178d;

    C0978e(C0984k kVar, C0990q qVar, Set set, AtomicBoolean atomicBoolean) {
        this.f178d = kVar;
        this.f175a = qVar;
        this.f176b = set;
        this.f177c = atomicBoolean;
    }

    /* renamed from: a */
    public final void mo17114a(ZipFile zipFile, Set<C0983j> set) throws IOException {
        this.f178d.m198f(this.f175a, set, new C0977d(this));
    }
}
