package com.google.android.play.core.assetpacks;

import com.google.android.play.core.common.C1661a;
import com.google.android.play.core.internal.C1692ca;
import com.google.android.play.core.internal.C1694cc;
import com.google.android.play.core.internal.C1696ce;
import com.google.android.play.core.splitinstall.C1002p;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.j */
public final class C1642j implements C1696ce<C1641i> {

    /* renamed from: a */
    private final C1696ce<C1571au> f783a;

    /* renamed from: b */
    private final C1696ce<C1653t> f784b;

    /* renamed from: c */
    private final C1696ce<C1568ar> f785c;

    /* renamed from: d */
    private final C1696ce<C1002p> f786d;

    /* renamed from: e */
    private final C1696ce<C1605ca> f787e;

    /* renamed from: f */
    private final C1696ce<C1592bo> f788f;

    /* renamed from: g */
    private final C1696ce<C1582be> f789g;

    /* renamed from: h */
    private final C1696ce<Executor> f790h;

    /* renamed from: i */
    private final C1696ce<C1661a> f791i;

    public C1642j(C1696ce<C1571au> ceVar, C1696ce<C1653t> ceVar2, C1696ce<C1568ar> ceVar3, C1696ce<C1002p> ceVar4, C1696ce<C1605ca> ceVar5, C1696ce<C1592bo> ceVar6, C1696ce<C1582be> ceVar7, C1696ce<Executor> ceVar8, C1696ce<C1661a> ceVar9) {
        this.f783a = ceVar;
        this.f784b = ceVar2;
        this.f785c = ceVar3;
        this.f786d = ceVar4;
        this.f787e = ceVar5;
        this.f788f = ceVar6;
        this.f789g = ceVar7;
        this.f790h = ceVar8;
        this.f791i = ceVar9;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo30603a() {
        C1571au a = this.f783a.mo30603a();
        C1692ca<C1653t> c = C1694cc.m743c(this.f784b);
        C1568ar a2 = this.f785c.mo30603a();
        C1605ca a3 = this.f787e.mo30603a();
        C1592bo a4 = this.f788f.mo30603a();
        C1592bo boVar = a4;
        return new C1641i(a, c, a2, this.f786d.mo30603a(), a3, boVar, this.f789g.mo30603a(), C1694cc.m743c(this.f790h), this.f791i.mo30603a());
    }
}
