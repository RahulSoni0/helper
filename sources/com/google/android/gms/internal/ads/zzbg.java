package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbg extends ByteArrayOutputStream {
    private final zzat zza;

    public zzbg(zzat zzat, int i) {
        this.zza = zzat;
        this.buf = zzat.zza(Math.max(i, 256));
    }

    private final void zza(int i) {
        if (this.count + i > this.buf.length) {
            zzat zzat = this.zza;
            int i2 = this.count + i;
            byte[] zza2 = zzat.zza(i2 + i2);
            System.arraycopy(this.buf, 0, zza2, 0, this.count);
            this.zza.zzb(this.buf);
            this.buf = zza2;
        }
    }

    public final void close() throws IOException {
        this.zza.zzb(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.zza.zzb(this.buf);
    }

    public final synchronized void write(int i) {
        zza(1);
        super.write(i);
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        zza(i2);
        super.write(bArr, i, i2);
    }
}
