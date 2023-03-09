package com.google.android.play.core.assetpacks;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.play.core.assetpacks.av */
final class C1572av extends InputStream {

    /* renamed from: a */
    private final InputStream f505a;

    /* renamed from: b */
    private long f506b;

    C1572av(InputStream inputStream, long j) {
        this.f505a = inputStream;
        this.f506b = j;
    }

    public final void close() throws IOException {
        super.close();
        this.f505a.close();
        this.f506b = 0;
    }

    public final int read() throws IOException {
        long j = this.f506b;
        if (j <= 0) {
            return -1;
        }
        this.f506b = j - 1;
        return this.f505a.read();
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f506b;
        if (j <= 0) {
            return -1;
        }
        int read = this.f505a.read(bArr, i, (int) Math.min((long) i2, j));
        if (read != -1) {
            this.f506b -= (long) read;
        }
        return read;
    }
}
