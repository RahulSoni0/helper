package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.ads.zzbbk;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    CustomEventBanner zza;
    CustomEventInterstitial zzb;
    /* access modifiers changed from: private */
    public View zzc;

    private static <T> T zzb(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(message).length());
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzbbk.zzi(sb.toString());
            return null;
        }
    }

    public void destroy() {
        CustomEventBanner customEventBanner = this.zza;
        if (customEventBanner != null) {
            customEventBanner.destroy();
        }
        CustomEventInterstitial customEventInterstitial = this.zzb;
        if (customEventInterstitial != null) {
            customEventInterstitial.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.zzc;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void showInterstitial() {
        this.zzb.showInterstitial();
    }

    public void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        Object obj;
        CustomEventBanner customEventBanner = (CustomEventBanner) zzb(customEventServerParameters.className);
        this.zza = customEventBanner;
        if (customEventBanner == null) {
            mediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (customEventExtras == null) {
            obj = null;
        } else {
            obj = customEventExtras.getExtra(customEventServerParameters.label);
        }
        Activity activity2 = activity;
        this.zza.requestBannerAd(new zza(this, mediationBannerListener), activity2, customEventServerParameters.label, customEventServerParameters.parameter, adSize, mediationAdRequest, obj);
    }

    public void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        Object obj;
        CustomEventInterstitial customEventInterstitial = (CustomEventInterstitial) zzb(customEventServerParameters.className);
        this.zzb = customEventInterstitial;
        if (customEventInterstitial == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (customEventExtras == null) {
            obj = null;
        } else {
            obj = customEventExtras.getExtra(customEventServerParameters.label);
        }
        Activity activity2 = activity;
        this.zzb.requestInterstitialAd(new zzb(this, this, mediationInterstitialListener), activity2, customEventServerParameters.label, customEventServerParameters.parameter, mediationAdRequest, obj);
    }
}
