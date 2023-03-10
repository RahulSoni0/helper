package com.google.android.gms.internal.ads;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzvu implements zzetj {
    PLATFORM_UNSPECIFIED(0),
    IOS(1),
    ANDROID(2);
    
    private static final zzetk<zzvu> zzd = null;
    private final int zze;

    static {
        zzd = new zzvs();
    }

    private zzvu(int i) {
        this.zze = i;
    }

    public static zzvu zza(int i) {
        if (i == 0) {
            return PLATFORM_UNSPECIFIED;
        }
        if (i == 1) {
            return IOS;
        }
        if (i != 2) {
            return null;
        }
        return ANDROID;
    }

    public static zzetl zzb() {
        return zzvt.zza;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }
}
