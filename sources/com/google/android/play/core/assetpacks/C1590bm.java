package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.C1692ca;
import com.google.android.play.core.internal.C1694cc;
import com.google.android.play.core.internal.C1696ce;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.bm */
public final class C1590bm implements C1696ce<C1589bl> {

    /* renamed from: a */
    private final C1696ce f593a;

    /* renamed from: b */
    private final C1696ce f594b;

    /* renamed from: c */
    private final C1696ce f595c;

    /* renamed from: d */
    private final C1696ce f596d;

    /* renamed from: e */
    private final C1696ce f597e;

    /* renamed from: f */
    private final C1696ce f598f;

    /* renamed from: g */
    private final C1696ce f599g;

    /* renamed from: h */
    private final C1696ce f600h;

    /* renamed from: i */
    private final /* synthetic */ int f601i = 0;

    public C1590bm(C1696ce<C1605ca> ceVar, C1696ce<C1653t> ceVar2, C1696ce<C1587bj> ceVar3, C1696ce<C1635dd> ceVar4, C1696ce<C1619co> ceVar5, C1696ce<C1624ct> ceVar6, C1696ce<C1628cx> ceVar7, C1696ce<C1608cd> ceVar8) {
        this.f593a = ceVar;
        this.f594b = ceVar2;
        this.f595c = ceVar3;
        this.f596d = ceVar4;
        this.f597e = ceVar5;
        this.f598f = ceVar6;
        this.f599g = ceVar7;
        this.f600h = ceVar8;
    }

    public C1590bm(C1696ce<Context> ceVar, C1696ce<C1605ca> ceVar2, C1696ce<C1589bl> ceVar3, C1696ce<C1653t> ceVar4, C1696ce<C1592bo> ceVar5, C1696ce<C1582be> ceVar6, C1696ce<Executor> ceVar7, C1696ce<Executor> ceVar8, byte[] bArr) {
        this.f593a = ceVar;
        this.f599g = ceVar2;
        this.f600h = ceVar3;
        this.f594b = ceVar4;
        this.f597e = ceVar5;
        this.f598f = ceVar6;
        this.f595c = ceVar7;
        this.f596d = ceVar8;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo30603a() {
        if (this.f601i != 0) {
            Context b = ((C1649p) this.f593a).mo30603a();
            Object a = this.f599g.mo30603a();
            Object a2 = this.f600h.mo30603a();
            C1692ca c = C1694cc.m743c(this.f594b);
            Object a3 = this.f597e.mo30603a();
            Object a4 = this.f598f.mo30603a();
            return new C1568ar(b, (C1605ca) a, (C1589bl) a2, c, (C1592bo) a3, (C1582be) a4, C1694cc.m743c(this.f595c), C1694cc.m743c(this.f596d));
        }
        Object a5 = this.f593a.mo30603a();
        return new C1589bl((C1605ca) a5, C1694cc.m743c(this.f594b), (C1587bj) this.f595c.mo30603a(), (C1635dd) this.f596d.mo30603a(), (C1619co) this.f597e.mo30603a(), (C1624ct) this.f598f.mo30603a(), (C1628cx) this.f599g.mo30603a(), (C1608cd) this.f600h.mo30603a());
    }
}
