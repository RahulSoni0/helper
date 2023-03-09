package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzail extends zzhw implements zzain {
    zzail(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    public final void zze(zzaia zzaia) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzaia);
        zzbj(1, zza);
    }
}
