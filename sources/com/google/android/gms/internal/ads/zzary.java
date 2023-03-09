package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class zzary extends zzhx implements zzarz {
    public zzary() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbA(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zze();
        } else if (i == 3) {
            zzf(parcel.readString());
        } else if (i != 4) {
            return false;
        } else {
            zzg((zzym) zzhy.zzc(parcel, zzym.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
