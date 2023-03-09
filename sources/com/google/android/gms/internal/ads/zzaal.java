package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaal extends zzhw implements zzaan {
    zzaal(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    public final void zze(zzys zzys) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzys);
        zzbj(1, zza);
    }

    public final String zzf() throws RemoteException {
        throw null;
    }

    public final boolean zzg() throws RemoteException {
        Parcel zzbi = zzbi(3, zza());
        boolean zza = zzhy.zza(zzbi);
        zzbi.recycle();
        return zza;
    }

    public final String zzh() throws RemoteException {
        throw null;
    }

    public final void zzi(zzys zzys, int i) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzys);
        zza.writeInt(i);
        zzbj(5, zza);
    }
}
