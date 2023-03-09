package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzbae extends zzhw implements zzbag {
    zzbae(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public final void zze(IObjectWrapper iObjectWrapper, zzbak zzbak, zzbad zzbad) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzd(zza, zzbak);
        zzhy.zzf(zza, zzbad);
        zzbj(1, zza);
    }

    public final void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzbj(2, zza);
    }

    public final void zzg(List<Uri> list, IObjectWrapper iObjectWrapper, zzauy zzauy) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzf(zza, zzauy);
        zzbj(5, zza);
    }

    public final void zzh(List<Uri> list, IObjectWrapper iObjectWrapper, zzauy zzauy) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzf(zza, zzauy);
        zzbj(6, zza);
    }

    public final void zzi(zzavf zzavf) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzavf);
        zzbj(7, zza);
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzbj(8, zza);
    }
}
