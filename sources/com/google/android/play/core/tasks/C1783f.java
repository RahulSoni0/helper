package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.f */
final class C1783f<ResultT> implements C1784g<ResultT> {

    /* renamed from: a */
    private final Executor f1063a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f1064b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final OnSuccessListener<? super ResultT> f1065c;

    public C1783f(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        this.f1063a = executor;
        this.f1065c = onSuccessListener;
    }

    /* renamed from: a */
    public final void mo31057a(Task<ResultT> task) {
        if (task.isSuccessful()) {
            synchronized (this.f1064b) {
                if (this.f1065c != null) {
                    this.f1063a.execute(new C1782e(this, task));
                }
            }
        }
    }
}
