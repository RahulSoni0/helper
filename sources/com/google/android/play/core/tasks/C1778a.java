package com.google.android.play.core.tasks;

/* renamed from: com.google.android.play.core.tasks.a */
final class C1778a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Task f1051a;

    /* renamed from: b */
    final /* synthetic */ C1779b f1052b;

    C1778a(C1779b bVar, Task task) {
        this.f1052b = bVar;
        this.f1051a = task;
    }

    public final void run() {
        synchronized (this.f1052b.f1054b) {
            if (this.f1052b.f1055c != null) {
                this.f1052b.f1055c.onComplete(this.f1051a);
            }
        }
    }
}
