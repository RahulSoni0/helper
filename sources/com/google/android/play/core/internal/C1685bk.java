package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.bk */
public abstract class C1685bk extends C1703k implements C1686bl {
    /* renamed from: b */
    public static C1686bl m711b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
        return queryLocalInterface instanceof C1686bl ? (C1686bl) queryLocalInterface : new C1684bj(iBinder);
    }
}
