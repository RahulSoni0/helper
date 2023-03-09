package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.ab */
public abstract class C1667ab extends C1703k implements C1668ac {
    /* renamed from: b */
    public static C1668ac m667b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.inappreview.protocol.IInAppReviewService");
        return queryLocalInterface instanceof C1668ac ? (C1668ac) queryLocalInterface : new C1666aa(iBinder);
    }
}
