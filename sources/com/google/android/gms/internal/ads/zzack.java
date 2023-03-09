package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzack extends zzhw implements zzacm {
    zzack(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    public final void zze() throws RemoteException {
        zzbj(1, zza());
    }

    public final void zzf() throws RemoteException {
        zzbj(2, zza());
    }

    public final void zzg() throws RemoteException {
        zzbj(3, zza());
    }

    public final void zzh() throws RemoteException {
        zzbj(4, zza());
    }

    public final void zzi(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzb(zza, z);
        zzbj(5, zza);
    }
}
