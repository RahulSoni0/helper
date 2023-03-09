package com.google.android.gms.internal.ads;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzvy implements zzetj {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_UNKNOWN(1000);
    
    private static final zzetk<zzvy> zzd = null;
    private final int zze;

    static {
        zzd = new zzvw();
    }

    private zzvy(int i) {
        this.zze = i;
    }

    public static zzvy zzb(int i) {
        if (i == 0) {
            return ENUM_FALSE;
        }
        if (i == 1) {
            return ENUM_TRUE;
        }
        if (i != 1000) {
            return null;
        }
        return ENUM_UNKNOWN;
    }

    public static zzetl zzc() {
        return zzvx.zza;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }

    public final int zza() {
        return this.zze;
    }
}
