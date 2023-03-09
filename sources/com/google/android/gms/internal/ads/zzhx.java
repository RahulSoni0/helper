package com.google.android.gms.internal.ads;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-base@@20.1.0 */
public class zzhx extends Binder implements IInterface {
    protected zzhx(String str) {
        attachInterface(this, str);
    }

    public final IBinder asBinder() {
        return this;
    }

    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i, parcel, parcel2, i2)) {
            return true;
        }
        return zzbA(i, parcel, parcel2, i2);
    }

    /* access modifiers changed from: protected */
    public boolean zzbA(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        throw null;
    }
}
