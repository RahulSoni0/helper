package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.d */
final class C1781d<ResultT> implements C1784g<ResultT> {

    /* renamed from: a */
    private final Executor f1058a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Object f1059b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final OnFailureListener f1060c;

    public C1781d(Executor executor, OnFailureListener onFailureListener) {
        this.f1058a = executor;
        this.f1060c = onFailureListener;
    }

    /* renamed from: a */
    public final void mo31057a(Task<ResultT> task) {
        if (!task.isSuccessful()) {
            synchronized (this.f1059b) {
                if (this.f1060c != null) {
                    this.f1058a.execute(new C1780c(this, task));
                }
            }
        }
    }
}
