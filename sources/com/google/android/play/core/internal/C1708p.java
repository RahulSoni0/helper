package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.p */
public abstract class C1708p extends C1703k implements C1709q {
    public C1708p() {
        super("com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo30881a(int i, Parcel parcel) throws RemoteException {
        if (i == 2) {
            mo30608b((Bundle) C1704l.m756a(parcel, Bundle.CREATOR));
            return true;
        } else if (i != 3) {
            return false;
        } else {
            mo30609c((Bundle) C1704l.m756a(parcel, Bundle.CREATOR));
            return true;
        }
    }
}
