package com.google.android.play.core.tasks;

/* renamed from: com.google.android.play.core.tasks.e */
final class C1782e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Task f1061a;

    /* renamed from: b */
    final /* synthetic */ C1783f f1062b;

    C1782e(C1783f fVar, Task task) {
        this.f1062b = fVar;
        this.f1061a = task;
    }

    public final void run() {
        synchronized (this.f1062b.f1064b) {
            if (this.f1062b.f1065c != null) {
                this.f1062b.f1065c.onSuccess(this.f1061a.getResult());
            }
        }
    }
}
