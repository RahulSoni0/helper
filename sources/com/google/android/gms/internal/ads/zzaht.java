package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaht extends zzhw implements IInterface {
    zzaht(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
    }

    public final IBinder zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzf(zza, iObjectWrapper2);
        zzhy.zzf(zza, iObjectWrapper3);
        Parcel zzbi = zzbi(1, zza);
        IBinder readStrongBinder = zzbi.readStrongBinder();
        zzbi.recycle();
        return readStrongBinder;
    }
}
