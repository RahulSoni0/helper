package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzasp implements MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> {
    final /* synthetic */ zzarz zza;
    final /* synthetic */ zzaqh zzb;
    final /* synthetic */ zzast zzc;

    zzasp(zzast zzast, zzarz zzarz, zzaqh zzaqh) {
        this.zzc = zzast;
        this.zza = zzarz;
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
        MediationInterstitialAd mediationInterstitialAd = (MediationInterstitialAd) obj;
        if (mediationInterstitialAd == null) {
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
                MediationInterstitialAd unused = this.zzc.zzb = mediationInterstitialAd;
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
