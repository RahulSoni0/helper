package com.google.android.play.core.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.play.core.internal.bv */
final class C0967bv {

    /* renamed from: a */
    private final ConcurrentHashMap<C0966bu, List<Throwable>> f155a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b */
    private final ReferenceQueue<Throwable> f156b = new ReferenceQueue<>();

    C0967bv() {
    }

    /* renamed from: a */
    public final List<Throwable> mo17083a(Throwable th) {
        while (true) {
            Reference<? extends Throwable> poll = this.f156b.poll();
            if (poll == null) {
                break;
            }
            this.f155a.remove(poll);
        }
        List<Throwable> list = this.f155a.get(new C0966bu(th, (ReferenceQueue<Throwable>) null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f155a.putIfAbsent(new C0966bu(th, this.f156b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
