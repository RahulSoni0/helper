package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.b */
final class C1779b<ResultT> implements C1784g<ResultT> {

    /* renamed from: a */
    private final Executor f1053a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f1054b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final OnCompleteListener<ResultT> f1055c;

    public C1779b(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        this.f1053a = executor;
        this.f1055c = onCompleteListener;
    }

    /* renamed from: a */
    public final void mo31057a(Task<ResultT> task) {
        synchronized (this.f1054b) {
            if (this.f1055c != null) {
                this.f1053a.execute(new C1778a(this, task));
            }
        }
    }
}
