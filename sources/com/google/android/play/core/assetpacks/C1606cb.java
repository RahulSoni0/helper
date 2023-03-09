package com.google.android.play.core.assetpacks;

import com.google.android.play.core.common.C1661a;
import com.google.android.play.core.internal.C1694cc;
import com.google.android.play.core.internal.C1696ce;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.cb */
public final class C1606cb implements C1696ce<C1605ca> {

    /* renamed from: a */
    private final C1696ce f649a;

    /* renamed from: b */
    private final C1696ce f650b;

    /* renamed from: c */
    private final C1696ce f651c;

    /* renamed from: d */
    private final C1696ce f652d;

    /* renamed from: e */
    private final /* synthetic */ int f653e = 0;

    public C1606cb(C1696ce<C1571au> ceVar, C1696ce<C1653t> ceVar2, C1696ce<C1592bo> ceVar3, C1696ce<Executor> ceVar4) {
        this.f649a = ceVar;
        this.f650b = ceVar2;
        this.f651c = ceVar3;
        this.f652d = ceVar4;
    }

    public C1606cb(C1696ce<C1571au> ceVar, C1696ce<C1653t> ceVar2, C1696ce<C1568ar> ceVar3, C1696ce<C1592bo> ceVar4, byte[] bArr) {
        this.f649a = ceVar;
        this.f650b = ceVar2;
        this.f651c = ceVar3;
        this.f652d = ceVar4;
    }

    public C1606cb(C1696ce<C1605ca> ceVar, C1696ce<C1571au> ceVar2, C1696ce<C1580bc> ceVar3, C1696ce<C1661a> ceVar4, char[] cArr) {
        this.f651c = ceVar;
        this.f650b = ceVar2;
        this.f649a = ceVar3;
        this.f652d = ceVar4;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo30603a() {
        int i = this.f653e;
        if (i == 0) {
            Object a = this.f649a.mo30603a();
            return new C1605ca((C1571au) a, C1694cc.m743c(this.f650b), (C1592bo) this.f651c.mo30603a(), C1694cc.m743c(this.f652d));
        } else if (i != 1) {
            Object a2 = this.f651c.mo30603a();
            Object a3 = this.f650b.mo30603a();
            return new C1608cd((C1605ca) a2, (C1571au) a3, (C1580bc) this.f649a.mo30603a(), (C1661a) this.f652d.mo30603a());
        } else {
            return new C1587bj((C1571au) this.f649a.mo30603a(), C1694cc.m743c(this.f650b), C1694cc.m743c(this.f651c), (C1592bo) this.f652d.mo30603a());
        }
    }
}
