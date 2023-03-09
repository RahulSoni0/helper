package com.google.android.play.core.assetpacks;

import java.util.Arrays;

/* renamed from: com.google.android.play.core.assetpacks.cm */
final class C1617cm {

    /* renamed from: a */
    private byte[] f687a = new byte[4096];

    /* renamed from: b */
    private int f688b;

    /* renamed from: c */
    private long f689c;

    /* renamed from: d */
    private long f690d;

    /* renamed from: e */
    private int f691e;

    /* renamed from: f */
    private int f692f;

    /* renamed from: g */
    private int f693g;

    /* renamed from: h */
    private boolean f694h;

    /* renamed from: i */
    private String f695i;

    public C1617cm() {
        mo30812d();
    }

    /* renamed from: e */
    private final int m566e(int i, byte[] bArr, int i2, int i3) {
        int i4 = this.f688b;
        if (i4 >= i) {
            return 0;
        }
        int min = Math.min(i3, i - i4);
        System.arraycopy(bArr, i2, this.f687a, this.f688b, min);
        int i5 = this.f688b + min;
        this.f688b = i5;
        if (i5 < i) {
            return -1;
        }
        return min;
    }

    /* renamed from: a */
    public final int mo30809a(byte[] bArr, int i, int i2) {
        int e = m566e(30, bArr, i, i2);
        if (e == -1) {
            return -1;
        }
        if (this.f689c == -1) {
            long d = C1615ck.m557d(this.f687a, 0);
            this.f689c = d;
            if (d == 67324752) {
                this.f694h = false;
                this.f690d = C1615ck.m557d(this.f687a, 18);
                this.f693g = C1615ck.m558e(this.f687a, 8);
                this.f691e = C1615ck.m558e(this.f687a, 26);
                int e2 = this.f691e + 30 + C1615ck.m558e(this.f687a, 28);
                this.f692f = e2;
                int length = this.f687a.length;
                if (length < e2) {
                    do {
                        length += length;
                    } while (length < e2);
                    this.f687a = Arrays.copyOf(this.f687a, length);
                }
            } else {
                this.f694h = true;
            }
        }
        int e3 = m566e(this.f692f, bArr, i + e, i2 - e);
        if (e3 == -1) {
            return -1;
        }
        int i3 = e + e3;
        if (!this.f694h && this.f695i == null) {
            this.f695i = new String(this.f687a, 30, this.f691e);
        }
        return i3;
    }

    /* renamed from: b */
    public final C1636de mo30810b() {
        int i = this.f688b;
        int i2 = this.f692f;
        if (i < i2) {
            return C1636de.m604a(this.f695i, this.f690d, this.f693g, true, Arrays.copyOf(this.f687a, i), this.f694h);
        }
        C1636de a = C1636de.m604a(this.f695i, this.f690d, this.f693g, false, Arrays.copyOf(this.f687a, i2), this.f694h);
        mo30812d();
        return a;
    }

    /* renamed from: c */
    public final int mo30811c() {
        return this.f692f;
    }

    /* renamed from: d */
    public final void mo30812d() {
        this.f688b = 0;
        this.f691e = -1;
        this.f689c = -1;
        this.f694h = false;
        this.f692f = 30;
        this.f690d = -1;
        this.f693g = -1;
        this.f695i = null;
    }
}
