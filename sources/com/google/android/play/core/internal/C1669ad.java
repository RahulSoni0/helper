package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.ad */
public abstract class C1669ad extends C1703k implements C1670ae {
    public C1669ad() {
        super("com.google.android.play.core.inappreview.protocol.IInAppReviewServiceCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo30881a(int i, Parcel parcel) throws RemoteException {
        if (i != 2) {
            return false;
        }
        mo30882b((Bundle) C1704l.m756a(parcel, Bundle.CREATOR));
        return true;
    }
}
