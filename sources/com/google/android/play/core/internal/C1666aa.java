package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.aa */
public final class C1666aa extends C1702j implements C1668ac {
    C1666aa(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.inappreview.protocol.IInAppReviewService");
    }

    /* renamed from: c */
    public final void mo30880c(String str, Bundle bundle, C1670ae aeVar) throws RemoteException {
        Parcel a = mo30947a();
        a.writeString(str);
        C1704l.m757b(a, bundle);
        C1704l.m758c(a, aeVar);
        mo30949b(2, a);
    }
}
