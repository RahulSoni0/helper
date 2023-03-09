package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AdManagerAdView;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzajl implements Runnable {
    final /* synthetic */ AdManagerAdView zza;
    final /* synthetic */ zzaau zzb;
    final /* synthetic */ zzajm zzc;

    zzajl(zzajm zzajm, AdManagerAdView adManagerAdView, zzaau zzaau) {
        this.zzc = zzajm;
        this.zza = adManagerAdView;
        this.zzb = zzaau;
    }

    public final void run() {
        if (this.zza.zza(this.zzb)) {
            this.zzc.zza.onAdManagerAdViewLoaded(this.zza);
        } else {
            zzbbk.zzi("Could not bind.");
        }
    }
}
