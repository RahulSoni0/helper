package com.google.android.play.core.splitinstall.testing;

import android.content.Context;
import com.google.android.play.core.internal.C1696ce;
import com.google.android.play.core.splitinstall.C1002p;
import com.google.android.play.core.splitinstall.C1776y;
import java.io.File;

/* renamed from: com.google.android.play.core.splitinstall.testing.j */
public final class C1772j implements C1696ce<FakeSplitInstallManager> {

    /* renamed from: a */
    private final C1696ce<Context> f1033a;

    /* renamed from: b */
    private final C1696ce<File> f1034b;

    /* renamed from: c */
    private final C1696ce<C1002p> f1035c;

    public C1772j(C1696ce<Context> ceVar, C1696ce<File> ceVar2, C1696ce<C1002p> ceVar3) {
        this.f1033a = ceVar;
        this.f1034b = ceVar2;
        this.f1035c = ceVar3;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo30603a() {
        return new FakeSplitInstallManager(((C1776y) this.f1033a).mo30603a(), this.f1034b.mo30603a(), this.f1035c.mo30603a());
    }
}
