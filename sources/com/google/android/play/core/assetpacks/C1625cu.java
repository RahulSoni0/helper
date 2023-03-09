package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.common.C1661a;
import com.google.android.play.core.internal.C1694cc;
import com.google.android.play.core.internal.C1696ce;
import java.io.File;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.cu */
public final class C1625cu implements C1696ce<C1624ct> {

    /* renamed from: a */
    private final C1696ce f714a;

    /* renamed from: b */
    private final C1696ce f715b;

    /* renamed from: c */
    private final C1696ce f716c;

    /* renamed from: d */
    private final C1696ce f717d;

    /* renamed from: e */
    private final C1696ce f718e;

    /* renamed from: f */
    private final C1696ce f719f;

    /* renamed from: g */
    private final /* synthetic */ int f720g = 0;

    public C1625cu(C1696ce<C1571au> ceVar, C1696ce<C1653t> ceVar2, C1696ce<C1605ca> ceVar3, C1696ce<Executor> ceVar4, C1696ce<C1592bo> ceVar5, C1696ce<C1661a> ceVar6) {
        this.f714a = ceVar;
        this.f715b = ceVar2;
        this.f716c = ceVar3;
        this.f717d = ceVar4;
        this.f718e = ceVar5;
        this.f719f = ceVar6;
    }

    public C1625cu(C1696ce<String> ceVar, C1696ce<C1568ar> ceVar2, C1696ce<C1592bo> ceVar3, C1696ce<Context> ceVar4, C1696ce<C1626cv> ceVar5, C1696ce<Executor> ceVar6, byte[] bArr) {
        this.f719f = ceVar;
        this.f715b = ceVar2;
        this.f718e = ceVar3;
        this.f717d = ceVar4;
        this.f716c = ceVar5;
        this.f714a = ceVar6;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo30603a() {
        if (this.f720g != 0) {
            String str = (String) this.f719f.mo30603a();
            Object a = this.f715b.mo30603a();
            Object a2 = this.f718e.mo30603a();
            Context b = ((C1649p) this.f717d).mo30603a();
            Object a3 = this.f716c.mo30603a();
            return new C1614cj(str != null ? new File(b.getExternalFilesDir((String) null), str) : b.getExternalFilesDir((String) null), (C1568ar) a, (C1592bo) a2, b, (C1626cv) a3, C1694cc.m743c(this.f714a));
        }
        Object a4 = this.f714a.mo30603a();
        return new C1624ct((C1571au) a4, C1694cc.m743c(this.f715b), (C1605ca) this.f716c.mo30603a(), C1694cc.m743c(this.f717d), (C1592bo) this.f718e.mo30603a(), (C1661a) this.f719f.mo30603a());
    }
}
