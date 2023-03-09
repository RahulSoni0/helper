package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzayf extends RewardedInterstitialAd {
    private final String zza;
    private final zzaxl zzb;
    private final Context zzc;
    private final zzayd zzd = new zzayd();
    private FullScreenContentCallback zze;
    private OnAdMetadataChangedListener zzf;
    private OnPaidEventListener zzg;

    public zzayf(Context context, String str) {
        this.zza = str;
        this.zzc = context.getApplicationContext();
        this.zzb = zzzy.zzb().zzf(context, str, new zzapy());
    }

    public final Bundle getAdMetadata() {
        try {
            zzaxl zzaxl = this.zzb;
            if (zzaxl != null) {
                return zzaxl.zzg();
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
        return new Bundle();
    }

    public final String getAdUnitId() {
        return this.zza;
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zze;
    }

    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zzf;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzg;
    }

    public final ResponseInfo getResponseInfo() {
        zzacg zzacg = null;
        try {
            zzaxl zzaxl = this.zzb;
            if (zzaxl != null) {
                zzacg = zzaxl.zzm();
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zzc(zzacg);
    }

    public final RewardItem getRewardItem() {
        try {
            zzaxl zzaxl = this.zzb;
            zzaxi zzl = zzaxl != null ? zzaxl.zzl() : null;
            if (zzl != null) {
                return new zzaxv(zzl);
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
        return RewardItem.DEFAULT_REWARD;
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zze = fullScreenContentCallback;
        this.zzd.zzb(fullScreenContentCallback);
    }

    public final void setImmersiveMode(boolean z) {
        try {
            zzaxl zzaxl = this.zzb;
            if (zzaxl != null) {
                zzaxl.zzo(z);
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzf = onAdMetadataChangedListener;
        try {
            zzaxl zzaxl = this.zzb;
            if (zzaxl != null) {
                zzaxl.zzf(new zzadq(onAdMetadataChangedListener));
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zzg = onPaidEventListener;
        try {
            zzaxl zzaxl = this.zzb;
            if (zzaxl != null) {
                zzaxl.zzn(new zzadr(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            zzaxl zzaxl = this.zzb;
            if (zzaxl != null) {
                zzaxl.zzh(new zzaxz(serverSideVerificationOptions));
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzd.zzc(onUserEarnedRewardListener);
        try {
            zzaxl zzaxl = this.zzb;
            if (zzaxl != null) {
                zzaxl.zze(this.zzd);
                this.zzb.zzb(ObjectWrapper.wrap(activity));
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzacq zzacq, RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        try {
            zzaxl zzaxl = this.zzb;
            if (zzaxl != null) {
                zzaxl.zzd(zzyw.zza.zza(this.zzc, zzacq), new zzaye(rewardedInterstitialAdLoadCallback, this));
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }
}
