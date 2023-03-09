package com.google.android.play.core.splitinstall;

import com.google.android.play.core.internal.C1694cc;
import com.google.android.play.core.internal.C1696ce;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import java.io.File;

/* renamed from: com.google.android.play.core.splitinstall.j */
public final class C1758j implements C1696ce<C1757i> {

    /* renamed from: a */
    private final C1696ce<C1774v> f973a;

    /* renamed from: b */
    private final C1696ce<FakeSplitInstallManager> f974b;

    /* renamed from: c */
    private final C1696ce<File> f975c;

    public C1758j(C1696ce<C1774v> ceVar, C1696ce<FakeSplitInstallManager> ceVar2, C1696ce<File> ceVar3) {
        this.f973a = ceVar;
        this.f974b = ceVar2;
        this.f975c = ceVar3;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo30603a() {
        return new C1757i(C1694cc.m743c(this.f973a), C1694cc.m743c(this.f974b), C1694cc.m743c(this.f975c));
    }
}
