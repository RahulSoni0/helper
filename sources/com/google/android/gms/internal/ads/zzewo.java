package com.google.android.gms.internal.ads;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzewo implements zzetj {
    SAFE(0),
    DANGEROUS(1),
    UNKNOWN(2),
    POTENTIALLY_UNWANTED(3),
    DANGEROUS_HOST(4);
    
    private static final zzetk<zzewo> zzf = null;
    private final int zzg;

    static {
        zzf = new zzewm();
    }

    private zzewo(int i) {
        this.zzg = i;
    }

    public static zzewo zza(int i) {
        if (i == 0) {
            return SAFE;
        }
        if (i == 1) {
            return DANGEROUS;
        }
        if (i == 2) {
            return UNKNOWN;
        }
        if (i == 3) {
            return POTENTIALLY_UNWANTED;
        }
        if (i != 4) {
            return null;
        }
        return DANGEROUS_HOST;
    }

    public static zzetl zzb() {
        return zzewn.zza;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
    }
}
