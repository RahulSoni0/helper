package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.n */
public abstract class C1706n extends C1703k implements C1707o {
    /* renamed from: b */
    public static C1707o m761b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
        return queryLocalInterface instanceof C1707o ? (C1707o) queryLocalInterface : new C1705m(iBinder);
    }
}
