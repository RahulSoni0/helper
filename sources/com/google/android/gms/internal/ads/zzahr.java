package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class zzahr extends zzhx implements zzahs {
    public zzahr() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    public static zzahs zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
        if (queryLocalInterface instanceof zzahs) {
            return (zzahs) queryLocalInterface;
        }
        return new zzahq(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbA(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
        } else if (i == 2) {
            zzc();
        } else if (i != 3) {
            return false;
        } else {
            zzd(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
        }
        parcel2.writeNoException();
        return true;
    }
}
