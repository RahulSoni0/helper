package com.google.android.play.core.internal;

import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.internal.ah */
public abstract class C1672ah implements Runnable {

    /* renamed from: a */
    private final C1786i<?> f844a;

    C1672ah() {
        this.f844a = null;
    }

    public C1672ah(C1786i<?> iVar) {
        this.f844a = iVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo30607a();

    /* renamed from: b */
    public final void mo30886b(Exception exc) {
        C1786i<?> iVar = this.f844a;
        if (iVar != null) {
            iVar.mo31065d(exc);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final C1786i<?> mo30887c() {
        return this.f844a;
    }

    public final void run() {
        try {
            mo30607a();
        } catch (Exception e) {
            mo30886b(e);
        }
    }
}
