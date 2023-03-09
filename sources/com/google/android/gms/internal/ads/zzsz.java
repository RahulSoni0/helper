package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzsz extends zzhw implements zztb {
    zzsz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    public final zzaau zze() throws RemoteException {
        throw null;
    }

    public final void zzf(IObjectWrapper iObjectWrapper, zzti zzti) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzf(zza, zzti);
        zzbj(4, zza);
    }

    public final zzacg zzg() throws RemoteException {
        Parcel zzbi = zzbi(5, zza());
        zzacg zzb = zzacf.zzb(zzbi.readStrongBinder());
        zzbi.recycle();
        return zzb;
    }

    public final void zzh(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzb(zza, z);
        zzbj(6, zza);
    }

    public final void zzi(zzacd zzacd) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzacd);
        zzbj(7, zza);
    }

    public final void zzj(zztf zztf) throws RemoteException {
        throw null;
    }
}
