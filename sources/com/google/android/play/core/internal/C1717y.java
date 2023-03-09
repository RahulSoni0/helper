package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.y */
public final class C1717y extends C1702j implements C1718z {
    C1717y(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
    }

    /* renamed from: c */
    public final void mo30964c(Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel a = mo30947a();
        C1704l.m757b(a, bundle);
        C1704l.m757b(a, bundle2);
        mo30949b(2, a);
    }

    /* renamed from: d */
    public final void mo30965d(Bundle bundle) throws RemoteException {
        Parcel a = mo30947a();
        C1704l.m757b(a, bundle);
        mo30949b(3, a);
    }

    /* renamed from: e */
    public final void mo30966e(Bundle bundle) throws RemoteException {
        Parcel a = mo30947a();
        C1704l.m757b(a, bundle);
        mo30949b(4, a);
    }
}
