package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.internal.C0960bh;
import com.google.android.play.core.internal.C1696ce;
import com.google.android.play.core.splitinstall.C1002p;

/* renamed from: com.google.android.play.core.appupdate.g */
public final class C1533g implements C1696ce<AppUpdateManager> {

    /* renamed from: a */
    private final C1696ce f364a;

    /* renamed from: b */
    private final /* synthetic */ int f365b = 0;

    public C1533g(C1696ce<C1530d> ceVar) {
        this.f364a = ceVar;
    }

    public C1533g(C1696ce<Context> ceVar, byte[] bArr) {
        this.f364a = ceVar;
    }

    public C1533g(C1696ce<Context> ceVar, char[] cArr) {
        this.f364a = ceVar;
    }

    public C1533g(C1696ce<Context> ceVar, short[] sArr) {
        this.f364a = ceVar;
    }

    /* renamed from: b */
    public static C1533g m314b(C1696ce<Context> ceVar) {
        return new C1533g(ceVar, (short[]) null);
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo30603a() {
        int i = this.f365b;
        if (i != 0) {
            return i != 1 ? i != 2 ? new C1002p((Context) this.f364a.mo30603a()) : new C1543q(((C1534h) this.f364a).mo30603a()) : new C1527a(((C1534h) this.f364a).mo30603a());
        }
        C1530d dVar = (C1530d) this.f364a.mo30603a();
        C0960bh.m107k(dVar);
        return dVar;
    }
}
