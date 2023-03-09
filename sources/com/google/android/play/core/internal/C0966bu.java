package com.google.android.play.core.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.play.core.internal.bu */
final class C0966bu extends WeakReference<Throwable> {

    /* renamed from: a */
    private final int f154a;

    public C0966bu(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.f154a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            C0966bu buVar = (C0966bu) obj;
            return this.f154a == buVar.f154a && get() == buVar.get();
        }
    }

    public final int hashCode() {
        return this.f154a;
    }
}
