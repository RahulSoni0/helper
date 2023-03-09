package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzaso implements MediationAdLoadCallback<MediationInterscrollerAd, MediationBannerAdCallback> {
    final /* synthetic */ zzarw zza;
    final /* synthetic */ zzaqh zzb;

    zzaso(zzast zzast, zzarw zzarw, zzaqh zzaqh) {
        this.zza = zzarw;
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
        MediationInterscrollerAd mediationInterscrollerAd = (MediationInterscrollerAd) obj;
        if (mediationInterscrollerAd == null) {
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
                this.zza.zzh(new zzarb(mediationInterscrollerAd));
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
