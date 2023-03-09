package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzaaq;
import com.google.android.gms.internal.ads.zzacq;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzady;
import com.google.android.gms.internal.ads.zzagy;
import com.google.android.gms.internal.ads.zzajk;
import com.google.android.gms.internal.ads.zzajm;
import com.google.android.gms.internal.ads.zzajn;
import com.google.android.gms.internal.ads.zzapy;
import com.google.android.gms.internal.ads.zzatt;
import com.google.android.gms.internal.ads.zzatv;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzyo;
import com.google.android.gms.internal.ads.zzyw;
import com.google.android.gms.internal.ads.zzyx;
import com.google.android.gms.internal.ads.zzzy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public class AdLoader {
    private final zzyw zza;
    private final Context zzb;
    private final zzaan zzc;

    AdLoader(Context context, zzaan zzaan, zzyw zzyw) {
        this.zzb = context;
        this.zzc = zzaan;
        this.zza = zzyw;
    }

    private final void zza(zzacq zzacq) {
        try {
            this.zzc.zze(this.zza.zza(this.zzb, zzacq));
        } catch (RemoteException e) {
            zzbbk.zzg("Failed to load ad.", e);
        }
    }

    public boolean isLoading() {
        try {
            return this.zzc.zzg();
        } catch (RemoteException e) {
            zzbbk.zzj("Failed to check if ad is loading.", e);
            return false;
        }
    }

    public void loadAd(AdRequest adRequest) {
        zza(adRequest.zza());
    }

    public void loadAds(AdRequest adRequest, int i) {
        try {
            this.zzc.zzi(this.zza.zza(this.zzb, adRequest.zza()), i);
        } catch (RemoteException e) {
            zzbbk.zzg("Failed to load ads.", e);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
    public static class Builder {
        private final Context zza;
        private final zzaaq zzb;

        public Builder(Context context, String str) {
            zzaaq zzc = zzzy.zzb().zzc(context, str, new zzapy());
            this.zza = (Context) Preconditions.checkNotNull(context, "context cannot be null");
            this.zzb = zzc;
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.zza, this.zzb.zze(), zzyw.zza);
            } catch (RemoteException e) {
                zzbbk.zzg("Failed to build AdLoader.", e);
                return new AdLoader(this.zza, new zzadh().zzb(), zzyw.zza);
            }
        }

        public Builder forAdManagerAdView(OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr == null || adSizeArr.length <= 0) {
                throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            }
            try {
                this.zzb.zzk(new zzajm(onAdManagerAdViewLoadedListener), new zzyx(this.zza, adSizeArr));
            } catch (RemoteException e) {
                zzbbk.zzj("Failed to add Google Ad Manager banner ad listener", e);
            }
            return this;
        }

        public Builder forCustomFormatAd(String str, NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
            zzatt zzatt = new zzatt(onCustomFormatAdLoadedListener, onCustomClickListener);
            try {
                this.zzb.zzi(str, zzatt.zza(), zzatt.zzb());
            } catch (RemoteException e) {
                zzbbk.zzj("Failed to add custom format ad listener", e);
            }
            return this;
        }

        @Deprecated
        public Builder forCustomTemplateAd(String str, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            zzajk zzajk = new zzajk(onCustomTemplateAdLoadedListener, onCustomClickListener);
            try {
                this.zzb.zzi(str, zzajk.zza(), zzajk.zzb());
            } catch (RemoteException e) {
                zzbbk.zzj("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder forNativeAd(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
            try {
                this.zzb.zzm(new zzatv(onNativeAdLoadedListener));
            } catch (RemoteException e) {
                zzbbk.zzj("Failed to add google native ad listener", e);
            }
            return this;
        }

        @Deprecated
        public Builder forUnifiedNativeAd(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
            try {
                this.zzb.zzm(new zzajn(onUnifiedNativeAdLoadedListener));
            } catch (RemoteException e) {
                zzbbk.zzj("Failed to add google native ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.zzb.zzf(new zzyo(adListener));
            } catch (RemoteException e) {
                zzbbk.zzj("Failed to set AdListener.", e);
            }
            return this;
        }

        public Builder withAdManagerAdViewOptions(AdManagerAdViewOptions adManagerAdViewOptions) {
            try {
                this.zzb.zzp(adManagerAdViewOptions);
            } catch (RemoteException e) {
                zzbbk.zzj("Failed to specify Ad Manager banner ad options", e);
            }
            return this;
        }

        @Deprecated
        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.zzb.zzj(new zzagy(nativeAdOptions));
            } catch (RemoteException e) {
                zzbbk.zzj("Failed to specify native ad options", e);
            }
            return this;
        }

        public Builder withNativeAdOptions(com.google.android.gms.ads.nativead.NativeAdOptions nativeAdOptions) {
            try {
                this.zzb.zzj(new zzagy(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), -1, nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzady(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zza(), nativeAdOptions.getMediaAspectRatio()));
            } catch (RemoteException e) {
                zzbbk.zzj("Failed to specify native ad options", e);
            }
            return this;
        }
    }

    public void loadAd(AdManagerAdRequest adManagerAdRequest) {
        zza(adManagerAdRequest.zza);
    }
}
