package com.google.android.play.core.tasks;

/* renamed from: com.google.android.play.core.tasks.c */
final class C1780c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Task f1056a;

    /* renamed from: b */
    final /* synthetic */ C1781d f1057b;

    C1780c(C1781d dVar, Task task) {
        this.f1057b = dVar;
        this.f1056a = task;
    }

    public final void run() {
        synchronized (this.f1057b.f1059b) {
            if (this.f1057b.f1060c != null) {
                this.f1057b.f1060c.onFailure(this.f1056a.getException());
            }
        }
    }
}
