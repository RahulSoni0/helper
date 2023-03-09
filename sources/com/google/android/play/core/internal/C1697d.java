package com.google.android.play.core.internal;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/* renamed from: com.google.android.play.core.internal.d */
final class C1697d implements C1691c {

    /* renamed from: a */
    private final FileChannel f872a;

    /* renamed from: b */
    private final long f873b;

    /* renamed from: c */
    private final long f874c;

    public C1697d(FileChannel fileChannel, long j, long j2) {
        this.f872a = fileChannel;
        this.f873b = j;
        this.f874c = j2;
    }

    /* renamed from: a */
    public final long mo30897a() {
        return this.f874c;
    }

    /* renamed from: b */
    public final void mo30898b(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        MappedByteBuffer map = this.f872a.map(FileChannel.MapMode.READ_ONLY, this.f873b + j, (long) i);
        map.load();
        for (MessageDigest update : messageDigestArr) {
            map.position(0);
            update.update(map);
        }
    }
}
