package com.google.android.play.core.internal;

import java.util.Objects;

/* renamed from: com.google.android.play.core.internal.bw */
final class C0968bw extends C0965bt {

    /* renamed from: a */
    private final C0967bv f157a = new C0967bv();

    C0968bw() {
    }

    /* renamed from: a */
    public final void mo17080a(Throwable th, Throwable th2) {
        if (th2 != th) {
            Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
            this.f157a.mo17083a(th).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }
}
