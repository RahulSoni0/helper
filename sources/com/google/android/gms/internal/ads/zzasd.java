package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzasd extends zzhw implements zzasf {
    zzasd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
    }

    public final void zze() throws RemoteException {
        zzbj(2, zza());
    }

    public final void zzf(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString("Adapter returned null.");
        zzbj(3, zza);
    }

    public final void zzg(zzym zzym) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzym);
        zzbj(4, zza);
    }
}
