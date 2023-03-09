package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.ads.zzbbk;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzb implements CustomEventInterstitialListener {
    final /* synthetic */ CustomEventAdapter zza;
    private final CustomEventAdapter zzb;
    private final MediationInterstitialListener zzc;

    public zzb(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
        this.zza = customEventAdapter;
        this.zzb = customEventAdapter2;
        this.zzc = mediationInterstitialListener;
    }

    public final void onAdClicked() {
        zzbbk.zzd("Custom event adapter called onAdClicked.");
        this.zzc.onAdClicked(this.zzb);
    }

    public final void onAdClosed() {
        zzbbk.zzd("Custom event adapter called onAdClosed.");
        this.zzc.onAdClosed(this.zzb);
    }

    public final void onAdFailedToLoad(int i) {
        zzbbk.zzd("Custom event adapter called onFailedToReceiveAd.");
        this.zzc.onAdFailedToLoad((MediationInterstitialAdapter) this.zzb, i);
    }

    public final void onAdLeftApplication() {
        zzbbk.zzd("Custom event adapter called onAdLeftApplication.");
        this.zzc.onAdLeftApplication(this.zzb);
    }

    public final void onAdLoaded() {
        zzbbk.zzd("Custom event adapter called onReceivedAd.");
        this.zzc.onAdLoaded(this.zza);
    }

    public final void onAdOpened() {
        zzbbk.zzd("Custom event adapter called onAdOpened.");
        this.zzc.onAdOpened(this.zzb);
    }

    public final void onAdFailedToLoad(AdError adError) {
        zzbbk.zzd("Custom event adapter called onFailedToReceiveAd.");
        this.zzc.onAdFailedToLoad((MediationInterstitialAdapter) this.zzb, adError);
    }
}
