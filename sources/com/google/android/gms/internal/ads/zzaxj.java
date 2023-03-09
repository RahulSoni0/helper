package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaxj extends zzhw implements zzaxl {
    zzaxj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public final void zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzbj(5, zza);
    }

    public final void zzc(zzys zzys, zzaxs zzaxs) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzys);
        zzhy.zzf(zza, zzaxs);
        zzbj(1, zza);
    }

    public final void zzd(zzys zzys, zzaxs zzaxs) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzys);
        zzhy.zzf(zza, zzaxs);
        zzbj(14, zza);
    }

    public final void zze(zzaxo zzaxo) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzaxo);
        zzbj(2, zza);
    }

    public final void zzf(zzaca zzaca) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzaca);
        zzbj(8, zza);
    }

    public final Bundle zzg() throws RemoteException {
        Parcel zzbi = zzbi(9, zza());
        Bundle bundle = (Bundle) zzhy.zzc(zzbi, Bundle.CREATOR);
        zzbi.recycle();
        return bundle;
    }

    public final void zzh(zzaxz zzaxz) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzaxz);
        zzbj(7, zza);
    }

    public final boolean zzi() throws RemoteException {
        throw null;
    }

    public final String zzj() throws RemoteException {
        throw null;
    }

    public final void zzk(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        throw null;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzaxi zzl() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 11
            android.os.Parcel r0 = r4.zzbi(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.rewarded.client.IRewardItem"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzaxi
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzaxi r1 = (com.google.android.gms.internal.ads.zzaxi) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzaxg r2 = new com.google.android.gms.internal.ads.zzaxg
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxj.zzl():com.google.android.gms.internal.ads.zzaxi");
    }

    public final zzacg zzm() throws RemoteException {
        Parcel zzbi = zzbi(12, zza());
        zzacg zzb = zzacf.zzb(zzbi.readStrongBinder());
        zzbi.recycle();
        return zzb;
    }

    public final void zzn(zzacd zzacd) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzacd);
        zzbj(13, zza);
    }

    public final void zzo(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzb(zza, z);
        zzbj(15, zza);
    }

    public final void zzp(zzaxt zzaxt) throws RemoteException {
        throw null;
    }
}
