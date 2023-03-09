package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.m */
public final class C1705m extends C1702j implements C1707o {
    C1705m(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.appupdate.protocol.IAppUpdateService");
    }

    /* renamed from: c */
    public final void mo30952c(String str, Bundle bundle, C1709q qVar) throws RemoteException {
        Parcel a = mo30947a();
        a.writeString(str);
        C1704l.m757b(a, bundle);
        C1704l.m758c(a, qVar);
        mo30949b(2, a);
    }

    /* renamed from: d */
    public final void mo30953d(String str, Bundle bundle, C1709q qVar) throws RemoteException {
        Parcel a = mo30947a();
        a.writeString(str);
        C1704l.m757b(a, bundle);
        C1704l.m758c(a, qVar);
        mo30949b(3, a);
    }
}
