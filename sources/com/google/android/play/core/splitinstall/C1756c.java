package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.appupdate.C1533g;
import com.google.android.play.core.internal.C1694cc;
import com.google.android.play.core.internal.C1696ce;
import com.google.android.play.core.splitinstall.testing.C1772j;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import java.io.File;

/* renamed from: com.google.android.play.core.splitinstall.c */
public final class C1756c implements C0999m {

    /* renamed from: a */
    private C1696ce<Context> f960a;

    /* renamed from: b */
    private C1696ce<C1753au> f961b;

    /* renamed from: c */
    private C1696ce<C1003s> f962c;

    /* renamed from: d */
    private C1696ce<C1002p> f963d = C1694cc.m742b(C1533g.m314b(this.f960a));

    /* renamed from: e */
    private C1696ce<C1754av> f964e;

    /* renamed from: f */
    private C1696ce<C1774v> f965f;

    /* renamed from: g */
    private C1696ce<File> f966g;

    /* renamed from: h */
    private C1696ce<FakeSplitInstallManager> f967h;

    /* renamed from: i */
    private C1696ce<C1757i> f968i;

    /* renamed from: j */
    private C1696ce<SplitInstallManager> f969j;

    /* synthetic */ C1756c(C1004x xVar) {
        C1776y yVar = new C1776y(xVar);
        this.f960a = yVar;
        this.f961b = C1694cc.m742b(new C1755aw(yVar, (byte[]) null));
        this.f962c = C1694cc.m742b(new C1733aa(xVar));
        C1696ce<C1754av> b = C1694cc.m742b(new C1755aw(this.f960a));
        this.f964e = b;
        this.f965f = C1694cc.m742b(new C1775w(this.f961b, this.f962c, this.f963d, b));
        C1696ce<File> b2 = C1694cc.m742b(new C1777z(this.f960a));
        this.f966g = b2;
        C1696ce<FakeSplitInstallManager> b3 = C1694cc.m742b(new C1772j(this.f960a, b2, this.f963d));
        this.f967h = b3;
        C1696ce<C1757i> b4 = C1694cc.m742b(new C1758j(this.f965f, b3, this.f966g));
        this.f968i = b4;
        this.f969j = C1694cc.m742b(new C1734ab(xVar, b4));
    }

    /* renamed from: a */
    public final SplitInstallManager mo17136a() {
        return this.f969j.mo30603a();
    }

    /* renamed from: b */
    public final File mo17137b() {
        return this.f966g.mo30603a();
    }
}
