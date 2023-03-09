package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.appupdate.C1533g;
import com.google.android.play.core.common.C1661a;
import com.google.android.play.core.common.C1663c;
import com.google.android.play.core.internal.C1693cb;
import com.google.android.play.core.internal.C1694cc;
import com.google.android.play.core.internal.C1696ce;
import com.google.android.play.core.splitinstall.C1002p;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.bh */
public final class C1585bh implements C1550a {

    /* renamed from: A */
    private C1696ce<C1577b> f540A;

    /* renamed from: a */
    private final C1644l f541a;

    /* renamed from: b */
    private C1696ce<Context> f542b;

    /* renamed from: c */
    private C1696ce<C1626cv> f543c;

    /* renamed from: d */
    private C1696ce<C1571au> f544d;

    /* renamed from: e */
    private C1696ce<C1592bo> f545e;

    /* renamed from: f */
    private C1696ce<C1564an> f546f;

    /* renamed from: g */
    private C1696ce<String> f547g = C1694cc.m742b(new C1650q(this.f542b));

    /* renamed from: h */
    private C1696ce<C1653t> f548h = new C1693cb();

    /* renamed from: i */
    private C1696ce<Executor> f549i;

    /* renamed from: j */
    private C1696ce<C1605ca> f550j;

    /* renamed from: k */
    private C1696ce<C1568ar> f551k;

    /* renamed from: l */
    private C1696ce<C1587bj> f552l;

    /* renamed from: m */
    private C1696ce<C1635dd> f553m;

    /* renamed from: n */
    private C1696ce<C1619co> f554n;

    /* renamed from: o */
    private C1696ce<C1661a> f555o;

    /* renamed from: p */
    private C1696ce<C1624ct> f556p;

    /* renamed from: q */
    private C1696ce<C1628cx> f557q;

    /* renamed from: r */
    private C1696ce<C1580bc> f558r;

    /* renamed from: s */
    private C1696ce<C1608cd> f559s;

    /* renamed from: t */
    private C1696ce<C1589bl> f560t;

    /* renamed from: u */
    private C1696ce<C1582be> f561u;

    /* renamed from: v */
    private C1696ce<Executor> f562v;

    /* renamed from: w */
    private C1696ce<C1614cj> f563w;

    /* renamed from: x */
    private C1696ce<C1002p> f564x;

    /* renamed from: y */
    private C1696ce<C1641i> f565y;

    /* renamed from: z */
    private C1696ce<AssetPackManager> f566z;

    /* synthetic */ C1585bh(C1644l lVar) {
        C1644l lVar2 = lVar;
        this.f541a = lVar2;
        C1649p pVar = new C1649p(lVar2);
        this.f542b = pVar;
        C1696ce<C1626cv> b = C1694cc.m742b(new C1620cp((C1696ce<Context>) pVar, (char[]) null));
        this.f543c = b;
        this.f544d = C1694cc.m742b(new C1647n(this.f542b, b, (short[]) null));
        C1696ce<C1592bo> b2 = C1694cc.m742b(C1593bp.f610a);
        this.f545e = b2;
        this.f546f = C1694cc.m742b(new C1647n(this.f542b, b2, (char[]) null));
        C1696ce<Executor> b3 = C1694cc.m742b(C1645m.f796a);
        this.f549i = b3;
        this.f550j = C1694cc.m742b(new C1606cb(this.f544d, this.f548h, this.f545e, b3));
        C1693cb cbVar = new C1693cb();
        this.f551k = cbVar;
        this.f552l = C1694cc.m742b(new C1606cb(this.f544d, this.f548h, (C1696ce<C1568ar>) cbVar, this.f545e, (byte[]) null));
        this.f553m = C1694cc.m742b(new C1620cp(this.f544d, (short[]) null));
        this.f554n = C1694cc.m742b(new C1620cp(this.f544d));
        C1696ce<C1661a> b4 = C1694cc.m742b(C1663c.m661b());
        this.f555o = b4;
        this.f556p = C1694cc.m742b(new C1625cu(this.f544d, this.f548h, this.f550j, this.f549i, this.f545e, b4));
        this.f557q = C1694cc.m742b(new C1647n(this.f544d, this.f548h, (int[]) null));
        C1696ce<C1580bc> b5 = C1694cc.m742b(new C1620cp(this.f548h, (byte[]) null));
        this.f558r = b5;
        C1696ce<C1608cd> b6 = C1694cc.m742b(new C1606cb(this.f550j, this.f544d, b5, this.f555o, (char[]) null));
        this.f559s = b6;
        this.f560t = C1694cc.m742b(new C1590bm(this.f550j, this.f548h, this.f552l, this.f553m, this.f554n, this.f556p, this.f557q, b6));
        this.f561u = C1694cc.m742b(C1583bf.f538a);
        C1696ce<Executor> b7 = C1694cc.m742b(C1651r.f807a);
        this.f562v = b7;
        C1693cb.m740b(this.f551k, C1694cc.m742b(new C1590bm(this.f542b, this.f550j, this.f560t, this.f548h, this.f545e, this.f561u, this.f549i, b7, (byte[]) null)));
        C1696ce<C1614cj> b8 = C1694cc.m742b(new C1625cu(this.f547g, this.f551k, this.f545e, this.f542b, this.f543c, this.f549i, (byte[]) null));
        this.f563w = b8;
        C1693cb.m740b(this.f548h, C1694cc.m742b(new C1648o(this.f542b, this.f546f, b8)));
        C1696ce<C1002p> b9 = C1694cc.m742b(C1533g.m314b(this.f542b));
        this.f564x = b9;
        C1696ce<C1641i> b10 = C1694cc.m742b(new C1642j(this.f544d, this.f548h, this.f551k, b9, this.f550j, this.f545e, this.f561u, this.f549i, this.f555o));
        this.f565y = b10;
        this.f566z = C1694cc.m742b(new C1647n(b10, this.f542b));
        this.f540A = C1694cc.m742b(new C1647n(this.f542b, this.f544d, (byte[]) null));
    }

    /* renamed from: a */
    public final AssetPackManager mo30677a() {
        return this.f566z.mo30603a();
    }

    /* renamed from: b */
    public final void mo30678b(AssetPackExtractionService assetPackExtractionService) {
        assetPackExtractionService.f430a = this.f540A.mo30603a();
    }

    /* renamed from: c */
    public final void mo30679c(ExtractionForegroundService extractionForegroundService) {
        extractionForegroundService.f432a = C1649p.m630c(this.f541a);
        extractionForegroundService.f433b = this.f565y.mo30603a();
    }
}
