package com.google.ads.mediation.customevent;

import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerListener;
import com.google.android.gms.internal.ads.zzbbk;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zza implements CustomEventBannerListener {
    private final CustomEventAdapter zza;
    private final MediationBannerListener zzb;

    public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
        this.zza = customEventAdapter;
        this.zzb = mediationBannerListener;
    }

    public final void onClick() {
        zzbbk.zzd("Custom event adapter called onFailedToReceiveAd.");
        this.zzb.onClick(this.zza);
    }

    public final void onDismissScreen() {
        zzbbk.zzd("Custom event adapter called onFailedToReceiveAd.");
        this.zzb.onDismissScreen(this.zza);
    }

    public final void onFailedToReceiveAd() {
        zzbbk.zzd("Custom event adapter called onFailedToReceiveAd.");
        this.zzb.onFailedToReceiveAd(this.zza, AdRequest.ErrorCode.NO_FILL);
    }

    public final void onLeaveApplication() {
        zzbbk.zzd("Custom event adapter called onFailedToReceiveAd.");
        this.zzb.onLeaveApplication(this.zza);
    }

    public final void onPresentScreen() {
        zzbbk.zzd("Custom event adapter called onFailedToReceiveAd.");
        this.zzb.onPresentScreen(this.zza);
    }

    public final void onReceivedAd(View view) {
        zzbbk.zzd("Custom event adapter called onReceivedAd.");
        this.zza.zzc = view;
        this.zzb.onReceivedAd(this.zza);
    }
}
