package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class zztd extends zzhx implements zzte {
    public zztd() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    public static zzte zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
        if (queryLocalInterface instanceof zzte) {
            return (zzte) queryLocalInterface;
        }
        return new zztc(iBinder);
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbA(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            r5 = 1
            if (r2 == r5) goto L_0x001b
            r0 = 2
            if (r2 == r0) goto L_0x0017
            r0 = 3
            if (r2 == r0) goto L_0x000b
            r2 = 0
            return r2
        L_0x000b:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzym> r2 = com.google.android.gms.internal.ads.zzym.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzhy.zzc(r3, r2)
            com.google.android.gms.internal.ads.zzym r2 = (com.google.android.gms.internal.ads.zzym) r2
            r1.zzd(r2)
            goto L_0x003a
        L_0x0017:
            r3.readInt()
            goto L_0x003a
        L_0x001b:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0023
            r2 = 0
            goto L_0x0037
        L_0x0023:
            java.lang.String r3 = "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r0 = r3 instanceof com.google.android.gms.internal.ads.zztb
            if (r0 == 0) goto L_0x0031
            r2 = r3
            com.google.android.gms.internal.ads.zztb r2 = (com.google.android.gms.internal.ads.zztb) r2
            goto L_0x0037
        L_0x0031:
            com.google.android.gms.internal.ads.zzsz r3 = new com.google.android.gms.internal.ads.zzsz
            r3.<init>(r2)
            r2 = r3
        L_0x0037:
            r1.zzb(r2)
        L_0x003a:
            r4.writeNoException()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztd.zzbA(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
