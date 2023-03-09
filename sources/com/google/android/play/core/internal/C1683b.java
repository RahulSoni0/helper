package com.google.android.play.core.internal;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.google.android.play.core.internal.b */
final class C1683b implements C1691c {

    /* renamed from: a */
    private final ByteBuffer f865a;

    public C1683b(ByteBuffer byteBuffer) {
        this.f865a = byteBuffer.slice();
    }

    /* renamed from: a */
    public final long mo30897a() {
        return (long) this.f865a.capacity();
    }

    /* renamed from: b */
    public final void mo30898b(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        ByteBuffer slice;
        synchronized (this.f865a) {
            int i2 = (int) j;
            this.f865a.position(i2);
            this.f865a.limit(i2 + i);
            slice = this.f865a.slice();
        }
        for (MessageDigest update : messageDigestArr) {
            slice.position(0);
            update.update(slice);
        }
    }
}
