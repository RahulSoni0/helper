package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzasq implements MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> {
    final /* synthetic */ zzasc zza;
    final /* synthetic */ zzaqh zzb;

    zzasq(zzast zzast, zzasc zzasc, zzaqh zzaqh) {
        this.zza = zzasc;
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
        UnifiedNativeAdMapper unifiedNativeAdMapper = (UnifiedNativeAdMapper) obj;
        if (unifiedNativeAdMapper == null) {
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
                this.zza.zze(new zzart(unifiedNativeAdMapper));
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
