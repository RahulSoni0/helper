package com.google.android.gms.internal.vision;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzhs extends zzhu {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzht zzc;

    zzhs(zzht zzht) {
        this.zzc = zzht;
        this.zzb = zzht.zza();
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
