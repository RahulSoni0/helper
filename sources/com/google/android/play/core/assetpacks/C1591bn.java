package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.play.core.assetpacks.bn */
final class C1591bn extends OutputStream {

    /* renamed from: a */
    private final C1617cm f602a = new C1617cm();

    /* renamed from: b */
    private final File f603b;

    /* renamed from: c */
    private final C1630cz f604c;

    /* renamed from: d */
    private long f605d;

    /* renamed from: e */
    private long f606e;

    /* renamed from: f */
    private FileOutputStream f607f;

    /* renamed from: g */
    private C1636de f608g;

    C1591bn(File file, C1630cz czVar) {
        this.f603b = file;
        this.f604c = czVar;
    }

    public final void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        while (i2 > 0) {
            if (this.f605d == 0 && this.f606e == 0) {
                int a = this.f602a.mo30809a(bArr, i, i2);
                if (a != -1) {
                    i += a;
                    i2 -= a;
                    C1636de b = this.f602a.mo30810b();
                    this.f608g = b;
                    if (b.mo30851h()) {
                        this.f605d = 0;
                        this.f604c.mo30840m(this.f608g.mo30853i(), this.f608g.mo30853i().length);
                        this.f606e = (long) this.f608g.mo30853i().length;
                    } else if (!this.f608g.mo30845c() || this.f608g.mo30844b()) {
                        byte[] i4 = this.f608g.mo30853i();
                        this.f604c.mo30840m(i4, i4.length);
                        this.f605d = this.f608g.mo30847e();
                    } else {
                        this.f604c.mo30834g(this.f608g.mo30853i());
                        File file = new File(this.f603b, this.f608g.mo30846d());
                        file.getParentFile().mkdirs();
                        this.f605d = this.f608g.mo30847e();
                        this.f607f = new FileOutputStream(file);
                    }
                } else {
                    return;
                }
            }
            if (!this.f608g.mo30844b()) {
                if (this.f608g.mo30851h()) {
                    this.f604c.mo30836i(this.f606e, bArr, i, i2);
                    this.f606e += (long) i2;
                    i3 = i2;
                } else if (this.f608g.mo30845c()) {
                    i3 = (int) Math.min((long) i2, this.f605d);
                    this.f607f.write(bArr, i, i3);
                    long j = this.f605d - ((long) i3);
                    this.f605d = j;
                    if (j == 0) {
                        this.f607f.close();
                    }
                } else {
                    i3 = (int) Math.min((long) i2, this.f605d);
                    int length = this.f608g.mo30853i().length;
                    this.f604c.mo30836i((((long) length) + this.f608g.mo30847e()) - this.f605d, bArr, i, i3);
                    this.f605d -= (long) i3;
                }
                i += i3;
                i2 -= i3;
            }
        }
    }
}
