package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzass implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    final /* synthetic */ zzasf zza;
    final /* synthetic */ zzaqh zzb;
    final /* synthetic */ zzast zzc;

    zzass(zzast zzast, zzasf zzasf, zzaqh zzaqh) {
        this.zzc = zzast;
        this.zza = zzasf;
        this.zzb = zzaqh;
    }

    public final void onFailure(AdError adError) {
        try {
            this.zza.zzg(adError.zza());
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
        }
    }

    public final /* bridge */ /* synthetic */ Object onSuccess(Object obj) {
        MediationRewardedAd mediationRewardedAd = (MediationRewardedAd) obj;
        if (mediationRewardedAd == null) {
            zzbbk.zzi("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zza.zzf("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzbbk.zzg("", e);
                return null;
            }
        } else {
            try {
                MediationRewardedAd unused = this.zzc.zzc = mediationRewardedAd;
                this.zza.zze();
            } catch (RemoteException e2) {
                zzbbk.zzg("", e2);
            }
            return new zzasu(this.zzb);
        }
    }

    public final void onFailure(String str) {
        onFailure(new AdError(0, str, AdError.UNDEFINED_DOMAIN));
    }
}
