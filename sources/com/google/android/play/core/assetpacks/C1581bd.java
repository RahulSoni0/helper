package com.google.android.play.core.assetpacks;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* renamed from: com.google.android.play.core.assetpacks.bd */
final class C1581bd extends FilterInputStream {

    /* renamed from: a */
    private final C1617cm f532a = new C1617cm();

    /* renamed from: b */
    private byte[] f533b = new byte[4096];

    /* renamed from: c */
    private long f534c;

    /* renamed from: d */
    private boolean f535d = false;

    /* renamed from: e */
    private boolean f536e = false;

    C1581bd(InputStream inputStream) {
        super(inputStream);
    }

    /* renamed from: e */
    private final boolean m480e(int i) throws IOException {
        int f = m481f(this.f533b, 0, i);
        if (f != i) {
            int i2 = i - f;
            if (m481f(this.f533b, f, i2) != i2) {
                this.f532a.mo30809a(this.f533b, 0, f);
                return false;
            }
        }
        this.f532a.mo30809a(this.f533b, 0, i);
        return true;
    }

    /* renamed from: f */
    private final int m481f(byte[] bArr, int i, int i2) throws IOException {
        return Math.max(0, super.read(bArr, i, i2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C1636de mo30758a() throws IOException {
        byte[] bArr;
        if (this.f534c > 0) {
            do {
                bArr = this.f533b;
            } while (read(bArr, 0, bArr.length) != -1);
        }
        if (this.f535d || this.f536e) {
            return new C1636de((String) null, -1, -1, false, false, (byte[]) null);
        }
        if (!m480e(30)) {
            this.f535d = true;
            return this.f532a.mo30810b();
        }
        C1636de b = this.f532a.mo30810b();
        if (b.mo30851h()) {
            this.f536e = true;
            return b;
        } else if (b.mo30847e() != 4294967295L) {
            int c = this.f532a.mo30811c() - 30;
            long j = (long) c;
            int length = this.f533b.length;
            if (j > ((long) length)) {
                do {
                    length += length;
                } while (((long) length) < j);
                this.f533b = Arrays.copyOf(this.f533b, length);
            }
            if (!m480e(c)) {
                this.f535d = true;
                return this.f532a.mo30810b();
            }
            C1636de b2 = this.f532a.mo30810b();
            this.f534c = b2.mo30847e();
            return b2;
        } else {
            throw new C1588bk("Files bigger than 4GiB are not supported.");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo30759b() {
        return this.f535d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final boolean mo30760c() {
        return this.f536e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final long mo30761d() {
        return this.f534c;
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f534c;
        if (j <= 0 || this.f535d) {
            return -1;
        }
        int f = m481f(bArr, i, (int) Math.min(j, (long) i2));
        this.f534c -= (long) f;
        if (f != 0) {
            return f;
        }
        this.f535d = true;
        return 0;
    }
}
