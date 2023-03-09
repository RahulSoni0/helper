package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.j */
public class C1702j implements IInterface {

    /* renamed from: a */
    private final IBinder f882a;

    /* renamed from: b */
    private final String f883b;

    protected C1702j(IBinder iBinder, String str) {
        this.f882a = iBinder;
        this.f883b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo30947a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f883b);
        return obtain;
    }

    public final IBinder asBinder() {
        return this.f882a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo30949b(int i, Parcel parcel) throws RemoteException {
        try {
            this.f882a.transact(i, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
