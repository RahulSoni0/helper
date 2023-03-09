package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzatv extends zzait {
    private final NativeAd.OnNativeAdLoadedListener zza;

    public zzatv(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
        this.zza = onNativeAdLoadedListener;
    }

    public final void zze(zzajd zzajd) {
        this.zza.onNativeAdLoaded(new zzatp(zzajd));
    }
}
