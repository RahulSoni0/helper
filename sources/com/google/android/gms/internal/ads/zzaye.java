package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaye extends zzaxr {
    private final RewardedInterstitialAdLoadCallback zza;
    private final zzayf zzb;

    public zzaye(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzayf zzayf) {
        this.zza = rewardedInterstitialAdLoadCallback;
        this.zzb = zzayf;
    }

    public final void zze() {
        zzayf zzayf;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null && (zzayf = this.zzb) != null) {
            rewardedInterstitialAdLoadCallback.onAdLoaded(zzayf);
        }
    }

    public final void zzf(int i) {
    }

    public final void zzg(zzym zzym) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onAdFailedToLoad(zzym.zzb());
        }
    }
}
