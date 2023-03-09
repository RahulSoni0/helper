package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzkm extends zzkh {
    public final zzkk zza = new zzkk();
    public ByteBuffer zzb;
    public long zzc;

    public zzkm(int i) {
    }

    private final ByteBuffer zzj(int i) {
        ByteBuffer byteBuffer = this.zzb;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(capacity);
        sb.append(" < ");
        sb.append(i);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }

    public final void zza() {
        super.zza();
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final void zzh(int i) throws IllegalStateException {
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer == null) {
            this.zzb = zzj(i);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.zzb.position();
        int i2 = i + position;
        if (capacity < i2) {
            ByteBuffer zzj = zzj(i2);
            if (position > 0) {
                this.zzb.position(0);
                this.zzb.limit(position);
                zzj.put(this.zzb);
            }
            this.zzb = zzj;
        }
    }

    public final boolean zzi() {
        return zzg(1073741824);
    }
}
