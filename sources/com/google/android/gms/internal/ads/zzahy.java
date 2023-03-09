package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzahy extends zzhw implements zzaia {
    zzahy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public final String zze(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzbi = zzbi(1, zza);
        String readString = zzbi.readString();
        zzbi.recycle();
        return readString;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzahk zzf(java.lang.String r4) throws android.os.RemoteException {
        /*
            r3 = this;
            android.os.Parcel r0 = r3.zza()
            r0.writeString(r4)
            r4 = 2
            android.os.Parcel r4 = r3.zzbi(r4, r0)
            android.os.IBinder r0 = r4.readStrongBinder()
            if (r0 != 0) goto L_0x0014
            r0 = 0
            goto L_0x0028
        L_0x0014:
            java.lang.String r1 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.ads.zzahk
            if (r2 == 0) goto L_0x0022
            r0 = r1
            com.google.android.gms.internal.ads.zzahk r0 = (com.google.android.gms.internal.ads.zzahk) r0
            goto L_0x0028
        L_0x0022:
            com.google.android.gms.internal.ads.zzahi r1 = new com.google.android.gms.internal.ads.zzahi
            r1.<init>(r0)
            r0 = r1
        L_0x0028:
            r4.recycle()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahy.zzf(java.lang.String):com.google.android.gms.internal.ads.zzahk");
    }

    public final List<String> zzg() throws RemoteException {
        Parcel zzbi = zzbi(3, zza());
        ArrayList<String> createStringArrayList = zzbi.createStringArrayList();
        zzbi.recycle();
        return createStringArrayList;
    }

    public final String zzh() throws RemoteException {
        Parcel zzbi = zzbi(4, zza());
        String readString = zzbi.readString();
        zzbi.recycle();
        return readString;
    }

    public final void zzi(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbj(5, zza);
    }

    public final void zzj() throws RemoteException {
        zzbj(6, zza());
    }

    public final zzacj zzk() throws RemoteException {
        Parcel zzbi = zzbi(7, zza());
        zzacj zzb = zzaci.zzb(zzbi.readStrongBinder());
        zzbi.recycle();
        return zzb;
    }

    public final void zzl() throws RemoteException {
        zzbj(8, zza());
    }

    public final IObjectWrapper zzm() throws RemoteException {
        Parcel zzbi = zzbi(9, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbi.readStrongBinder());
        zzbi.recycle();
        return asInterface;
    }

    public final boolean zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        Parcel zzbi = zzbi(10, zza);
        boolean zza2 = zzhy.zza(zzbi);
        zzbi.recycle();
        return zza2;
    }

    public final boolean zzo() throws RemoteException {
        Parcel zzbi = zzbi(12, zza());
        boolean zza = zzhy.zza(zzbi);
        zzbi.recycle();
        return zza;
    }

    public final boolean zzp() throws RemoteException {
        Parcel zzbi = zzbi(13, zza());
        boolean zza = zzhy.zza(zzbi);
        zzbi.recycle();
        return zza;
    }

    public final void zzq(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzbj(14, zza);
    }

    public final void zzr() throws RemoteException {
        zzbj(15, zza());
    }
}
