package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzrz implements Runnable {
    final /* synthetic */ zzsa zza;

    zzrz(zzsa zzsa) {
        this.zza = zzsa;
    }

    public final void run() {
        synchronized (this.zza.zzc) {
            if (!this.zza.zzd || !this.zza.zze) {
                zze.zzd("App is still foreground");
            } else {
                boolean unused = this.zza.zzd = false;
                zze.zzd("App went background");
                for (zzsb zza2 : this.zza.zzf) {
                    try {
                        zza2.zza(false);
                    } catch (Exception e) {
                        zzbbk.zzg("", e);
                    }
                }
            }
        }
    }
}
