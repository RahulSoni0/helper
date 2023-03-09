package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzajb extends zzhw implements zzajd {
    zzajb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    public final boolean zzA() throws RemoteException {
        Parcel zzbi = zzbi(24, zza());
        boolean zza = zzhy.zza(zzbi);
        zzbi.recycle();
        return zza;
    }

    public final void zzB(zzabt zzabt) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzabt);
        zzbj(25, zza);
    }

    public final void zzC(zzabp zzabp) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzabp);
        zzbj(26, zza);
    }

    public final void zzD() throws RemoteException {
        zzbj(27, zza());
    }

    public final void zzE() throws RemoteException {
        zzbj(28, zza());
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzahh zzF() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 29
            android.os.Parcel r0 = r4.zzbi(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.IMediaContent"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzahh
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzahh r1 = (com.google.android.gms.internal.ads.zzahh) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzahf r2 = new com.google.android.gms.internal.ads.zzahf
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajb.zzF():com.google.android.gms.internal.ads.zzahh");
    }

    public final boolean zzG() throws RemoteException {
        Parcel zzbi = zzbi(30, zza());
        boolean zza = zzhy.zza(zzbi);
        zzbi.recycle();
        return zza;
    }

    public final zzacg zzH() throws RemoteException {
        Parcel zzbi = zzbi(31, zza());
        zzacg zzb = zzacf.zzb(zzbi.readStrongBinder());
        zzbi.recycle();
        return zzb;
    }

    public final void zzI(zzacd zzacd) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzacd);
        zzbj(32, zza);
    }

    public final String zze() throws RemoteException {
        Parcel zzbi = zzbi(2, zza());
        String readString = zzbi.readString();
        zzbi.recycle();
        return readString;
    }

    public final List zzf() throws RemoteException {
        Parcel zzbi = zzbi(3, zza());
        ArrayList zzg = zzhy.zzg(zzbi);
        zzbi.recycle();
        return zzg;
    }

    public final String zzg() throws RemoteException {
        Parcel zzbi = zzbi(4, zza());
        String readString = zzbi.readString();
        zzbi.recycle();
        return readString;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzahk zzh() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 5
            android.os.Parcel r0 = r4.zzbi(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzahk
            if (r3 == 0) goto L_0x001f
            r1 = r2
            com.google.android.gms.internal.ads.zzahk r1 = (com.google.android.gms.internal.ads.zzahk) r1
            goto L_0x0025
        L_0x001f:
            com.google.android.gms.internal.ads.zzahi r2 = new com.google.android.gms.internal.ads.zzahi
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajb.zzh():com.google.android.gms.internal.ads.zzahk");
    }

    public final String zzi() throws RemoteException {
        Parcel zzbi = zzbi(6, zza());
        String readString = zzbi.readString();
        zzbi.recycle();
        return readString;
    }

    public final String zzj() throws RemoteException {
        Parcel zzbi = zzbi(7, zza());
        String readString = zzbi.readString();
        zzbi.recycle();
        return readString;
    }

    public final double zzk() throws RemoteException {
        Parcel zzbi = zzbi(8, zza());
        double readDouble = zzbi.readDouble();
        zzbi.recycle();
        return readDouble;
    }

    public final String zzl() throws RemoteException {
        Parcel zzbi = zzbi(9, zza());
        String readString = zzbi.readString();
        zzbi.recycle();
        return readString;
    }

    public final String zzm() throws RemoteException {
        Parcel zzbi = zzbi(10, zza());
        String readString = zzbi.readString();
        zzbi.recycle();
        return readString;
    }

    public final zzacj zzn() throws RemoteException {
        Parcel zzbi = zzbi(11, zza());
        zzacj zzb = zzaci.zzb(zzbi.readStrongBinder());
        zzbi.recycle();
        return zzb;
    }

    public final String zzo() throws RemoteException {
        Parcel zzbi = zzbi(12, zza());
        String readString = zzbi.readString();
        zzbi.recycle();
        return readString;
    }

    public final void zzp() throws RemoteException {
        zzbj(13, zza());
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzahc zzq() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 14
            android.os.Parcel r0 = r4.zzbi(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.IAttributionInfo"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzahc
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzahc r1 = (com.google.android.gms.internal.ads.zzahc) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzaha r2 = new com.google.android.gms.internal.ads.zzaha
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajb.zzq():com.google.android.gms.internal.ads.zzahc");
    }

    public final void zzr(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, bundle);
        zzbj(15, zza);
    }

    public final boolean zzs(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, bundle);
        Parcel zzbi = zzbi(16, zza);
        boolean zza2 = zzhy.zza(zzbi);
        zzbi.recycle();
        return zza2;
    }

    public final void zzt(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, bundle);
        zzbj(17, zza);
    }

    public final IObjectWrapper zzu() throws RemoteException {
        Parcel zzbi = zzbi(18, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbi.readStrongBinder());
        zzbi.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzv() throws RemoteException {
        Parcel zzbi = zzbi(19, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbi.readStrongBinder());
        zzbi.recycle();
        return asInterface;
    }

    public final Bundle zzw() throws RemoteException {
        Parcel zzbi = zzbi(20, zza());
        Bundle bundle = (Bundle) zzhy.zzc(zzbi, Bundle.CREATOR);
        zzbi.recycle();
        return bundle;
    }

    public final void zzx(zzaja zzaja) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzaja);
        zzbj(21, zza);
    }

    public final void zzy() throws RemoteException {
        zzbj(22, zza());
    }

    public final List zzz() throws RemoteException {
        Parcel zzbi = zzbi(23, zza());
        ArrayList zzg = zzhy.zzg(zzbi);
        zzbi.recycle();
        return zzg;
    }
}
