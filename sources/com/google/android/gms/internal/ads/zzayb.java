package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzayb implements MediationRewardedAdCallback {
    private final zzaqh zza;

    public zzayb(zzaqh zzaqh) {
        this.zza = zzaqh;
    }

    public final void onAdClosed() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbk.zzd("Adapter called onAdClosed.");
        try {
            this.zza.zzf();
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToShow(AdError adError) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbk.zzd("Adapter called onAdFailedToShow.");
        int code = adError.getCode();
        String message = adError.getMessage();
        String domain = adError.getDomain();
        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 87 + String.valueOf(domain).length());
        sb.append("Mediation ad failed to show: Error Code = ");
        sb.append(code);
        sb.append(". Error Message = ");
        sb.append(message);
        sb.append(" Error Domain = ");
        sb.append(domain);
        zzbbk.zzi(sb.toString());
        try {
            this.zza.zzy(adError.zza());
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onAdOpened() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbk.zzd("Adapter called onAdOpened.");
        try {
            this.zza.zzi();
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onUserEarnedReward(RewardItem rewardItem) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbk.zzd("Adapter called onUserEarnedReward.");
        try {
            this.zza.zzr(new zzayc(rewardItem));
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoComplete() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbk.zzd("Adapter called onVideoComplete.");
        try {
            this.zza.zzt();
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onVideoStart() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbk.zzd("Adapter called onVideoStart.");
        try {
            this.zza.zzo();
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void reportAdClicked() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbk.zzd("Adapter called reportAdClicked.");
        try {
            this.zza.zze();
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void reportAdImpression() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbk.zzd("Adapter called reportAdImpression.");
        try {
            this.zza.zzk();
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToShow(String str) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbk.zzd("Adapter called onAdFailedToShow.");
        String valueOf = String.valueOf(str);
        zzbbk.zzi(valueOf.length() != 0 ? "Mediation ad failed to show: ".concat(valueOf) : new String("Mediation ad failed to show: "));
        try {
            this.zza.zzv(str);
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }
}
