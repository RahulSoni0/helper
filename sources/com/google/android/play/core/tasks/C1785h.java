package com.google.android.play.core.tasks;

import java.util.ArrayDeque;
import java.util.Queue;

/* renamed from: com.google.android.play.core.tasks.h */
final class C1785h<ResultT> {

    /* renamed from: a */
    private final Object f1066a = new Object();

    /* renamed from: b */
    private Queue<C1784g<ResultT>> f1067b;

    /* renamed from: c */
    private boolean f1068c;

    C1785h() {
    }

    /* renamed from: a */
    public final void mo31060a(C1784g<ResultT> gVar) {
        synchronized (this.f1066a) {
            if (this.f1067b == null) {
                this.f1067b = new ArrayDeque();
            }
            this.f1067b.add(gVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0010, code lost:
        r1 = r2.f1066a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0 = r2.f1067b.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        if (r0 != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
        r2.f1068c = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0022, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0023, code lost:
        r0.mo31057a(r3);
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo31061b(com.google.android.play.core.tasks.Task<ResultT> r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f1066a
            monitor-enter(r0)
            java.util.Queue<com.google.android.play.core.tasks.g<ResultT>> r1 = r2.f1067b     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x002a
            boolean r1 = r2.f1068c     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x000c
            goto L_0x002a
        L_0x000c:
            r1 = 1
            r2.f1068c = r1     // Catch:{ all -> 0x002c }
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
        L_0x0010:
            java.lang.Object r1 = r2.f1066a
            monitor-enter(r1)
            java.util.Queue<com.google.android.play.core.tasks.g<ResultT>> r0 = r2.f1067b     // Catch:{ all -> 0x0027 }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0027 }
            com.google.android.play.core.tasks.g r0 = (com.google.android.play.core.tasks.C1784g) r0     // Catch:{ all -> 0x0027 }
            if (r0 != 0) goto L_0x0022
            r3 = 0
            r2.f1068c = r3     // Catch:{ all -> 0x0027 }
            monitor-exit(r1)     // Catch:{ all -> 0x0027 }
            return
        L_0x0022:
            monitor-exit(r1)     // Catch:{ all -> 0x0027 }
            r0.mo31057a(r3)
            goto L_0x0010
        L_0x0027:
            r3 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0027 }
            throw r3
        L_0x002a:
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            return
        L_0x002c:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            goto L_0x0030
        L_0x002f:
            throw r3
        L_0x0030:
            goto L_0x002f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.tasks.C1785h.mo31061b(com.google.android.play.core.tasks.Task):void");
    }
}
