package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzatr extends zzaij {
    final /* synthetic */ zzatt zza;

    /* synthetic */ zzatr(zzatt zzatt, zzatq zzatq) {
        this.zza = zzatt;
    }

    public final void zze(zzaia zzaia, String str) {
        if (this.zza.zzb != null) {
            this.zza.zzb.onCustomClick(this.zza.zzf(zzaia), str);
        }
    }
}
