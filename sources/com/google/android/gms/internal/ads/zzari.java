package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzari implements Runnable {
    final /* synthetic */ zzarr zza;

    zzari(zzarr zzarr) {
        this.zza = zzarr;
    }

    public final void run() {
        try {
            this.zza.zza.zze();
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }
}
