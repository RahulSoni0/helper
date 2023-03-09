package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.s */
public abstract class C1711s extends C1703k implements C1712t {
    /* renamed from: b */
    public static C1712t m777b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
        return queryLocalInterface instanceof C1712t ? (C1712t) queryLocalInterface : new C1710r(iBinder);
    }
}
