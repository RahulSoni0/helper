package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzsw extends zztd {
    private final AppOpenAd.AppOpenAdLoadCallback zza;
    private final String zzb;

    public zzsw(AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback, String str) {
        this.zza = appOpenAdLoadCallback;
        this.zzb = str;
    }

    public final void zzb(zztb zztb) {
        if (this.zza != null) {
            this.zza.onAdLoaded(new zzsx(zztb, this.zzb));
        }
    }

    public final void zzc(int i) {
    }

    public final void zzd(zzym zzym) {
        if (this.zza != null) {
            this.zza.onAdFailedToLoad(zzym.zzb());
        }
    }
}
