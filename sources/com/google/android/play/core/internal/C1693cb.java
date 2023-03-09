package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.cb */
public final class C1693cb<T> implements C1696ce<T> {

    /* renamed from: a */
    private C1696ce<T> f868a;

    /* renamed from: b */
    public static <T> void m740b(C1696ce<T> ceVar, C1696ce<T> ceVar2) {
        C0960bh.m106j(ceVar2);
        C1693cb cbVar = (C1693cb) ceVar;
        if (cbVar.f868a == null) {
            cbVar.f868a = ceVar2;
            return;
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public final T mo30603a() {
        C1696ce<T> ceVar = this.f868a;
        if (ceVar != null) {
            return ceVar.mo30603a();
        }
        throw new IllegalStateException();
    }
}
