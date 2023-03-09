package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Objects;

/* renamed from: com.google.android.play.core.assetpacks.cl */
public final class C1616cl extends InputStream {

    /* renamed from: a */
    private final Enumeration<File> f685a;

    /* renamed from: b */
    private InputStream f686b;

    public C1616cl(Enumeration<File> enumeration) throws IOException {
        this.f685a = enumeration;
        mo30805a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo30805a() throws IOException {
        InputStream inputStream = this.f686b;
        if (inputStream != null) {
            inputStream.close();
        }
        this.f686b = this.f685a.hasMoreElements() ? new FileInputStream(this.f685a.nextElement()) : null;
    }

    public final void close() throws IOException {
        super.close();
        InputStream inputStream = this.f686b;
        if (inputStream != null) {
            inputStream.close();
            this.f686b = null;
        }
    }

    public final int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f686b;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            mo30805a();
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f686b == null) {
            return -1;
        }
        Objects.requireNonNull(bArr);
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        } else if (i2 == 0) {
            return 0;
        } else {
            do {
                int read = this.f686b.read(bArr, i, i2);
                if (read > 0) {
                    return read;
                }
                mo30805a();
            } while (this.f686b != null);
            return -1;
        }
    }
}
