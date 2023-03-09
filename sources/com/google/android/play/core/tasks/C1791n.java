package com.google.android.play.core.tasks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.play.core.tasks.n */
final class C1791n implements OnSuccessListener, OnFailureListener {

    /* renamed from: a */
    private final CountDownLatch f1076a = new CountDownLatch(1);

    private C1791n() {
    }

    /* synthetic */ C1791n(byte[] bArr) {
    }

    /* renamed from: a */
    public final void mo31073a() throws InterruptedException {
        this.f1076a.await();
    }

    /* renamed from: b */
    public final boolean mo31074b(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f1076a.await(j, timeUnit);
    }

    public final void onFailure(Exception exc) {
        this.f1076a.countDown();
    }

    public final void onSuccess(Object obj) {
        this.f1076a.countDown();
    }
}
