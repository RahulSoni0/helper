package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzaqv implements InitializationCompleteCallback {
    final /* synthetic */ zzamn zza;

    zzaqv(zzara zzara, zzamn zzamn) {
        this.zza = zzamn;
    }

    public final void onInitializationFailed(String str) {
        try {
            this.zza.zzf(str);
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
        }
    }

    public final void onInitializationSucceeded() {
        try {
            this.zza.zze();
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
        }
    }
}
