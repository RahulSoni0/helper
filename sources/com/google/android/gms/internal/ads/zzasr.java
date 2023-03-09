package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzasr implements SignalCallbacks {
    final /* synthetic */ zzasl zza;

    zzasr(zzast zzast, zzasl zzasl) {
        this.zza = zzasl;
    }

    public final void onFailure(AdError adError) {
        try {
            this.zza.zzg(adError.zza());
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
        }
    }

    public final void onSuccess(String str) {
        try {
            this.zza.zze(str);
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
        }
    }

    public final void onFailure(String str) {
        try {
            this.zza.zzf(str);
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
        }
    }
}
