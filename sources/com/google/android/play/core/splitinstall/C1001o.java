package com.google.android.play.core.splitinstall;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.play.core.splitinstall.o */
public final class C1001o {

    /* renamed from: a */
    private static final AtomicReference<C1000n> f204a = new AtomicReference<>((Object) null);

    /* renamed from: a */
    static C1000n m226a() {
        return f204a.get();
    }

    /* renamed from: b */
    public static void m227b(C1000n nVar) {
        f204a.compareAndSet((Object) null, nVar);
    }
}
