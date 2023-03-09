package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
final class zzgs extends zzgu {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzgp zzc;

    zzgs(zzgp zzgp) {
        this.zzc = zzgp;
        this.zzb = zzgp.zza();
    }

    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    public final byte zza() {
        int i = this.zza;
        if (i < this.zzb) {
            this.zza = i + 1;
            return this.zzc.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
