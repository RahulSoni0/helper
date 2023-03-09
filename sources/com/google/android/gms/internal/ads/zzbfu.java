package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbfu implements Runnable {
    private final zzbdp zza;
    private final boolean zzb;
    private final long zzc;

    zzbfu(zzbdp zzbdp, boolean z, long j) {
        this.zza = zzbdp;
        this.zzb = z;
        this.zzc = j;
    }

    public final void run() {
        zzbdp zzbdp = this.zza;
        boolean z = this.zzb;
        long j = this.zzc;
        int i = zzbfv.zzd;
        zzbdp.zzv(z, j);
    }
}
