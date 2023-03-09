package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzahf extends zzhw implements zzahh {
    zzahf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    public final float zze() throws RemoteException {
        Parcel zzbi = zzbi(2, zza());
        float readFloat = zzbi.readFloat();
        zzbi.recycle();
        return readFloat;
    }

    public final void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzbj(3, zza);
    }

    public final IObjectWrapper zzg() throws RemoteException {
        Parcel zzbi = zzbi(4, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbi.readStrongBinder());
        zzbi.recycle();
        return asInterface;
    }

    public final float zzh() throws RemoteException {
        Parcel zzbi = zzbi(5, zza());
        float readFloat = zzbi.readFloat();
        zzbi.recycle();
        return readFloat;
    }

    public final float zzi() throws RemoteException {
        Parcel zzbi = zzbi(6, zza());
        float readFloat = zzbi.readFloat();
        zzbi.recycle();
        return readFloat;
    }

    public final zzacj zzj() throws RemoteException {
        Parcel zzbi = zzbi(7, zza());
        zzacj zzb = zzaci.zzb(zzbi.readStrongBinder());
        zzbi.recycle();
        return zzb;
    }

    public final boolean zzk() throws RemoteException {
        Parcel zzbi = zzbi(8, zza());
        boolean zza = zzhy.zza(zzbi);
        zzbi.recycle();
        return zza;
    }

    public final void zzl(zzaio zzaio) throws RemoteException {
        throw null;
    }
}
