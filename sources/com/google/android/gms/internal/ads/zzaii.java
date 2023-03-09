package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaii extends zzhw implements zzaik {
    zzaii(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    public final void zze(zzaia zzaia, String str) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzaia);
        zza.writeString(str);
        zzbj(1, zza);
    }
}
