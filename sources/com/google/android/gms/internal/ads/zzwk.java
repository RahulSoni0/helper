package com.google.android.gms.internal.ads;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzwk implements zzetj {
    CELLULAR_NETWORK_TYPE_UNSPECIFIED(0),
    TWO_G(1),
    THREE_G(2),
    LTE(4);
    
    private static final zzetk<zzwk> zze = null;
    private final int zzf;

    static {
        zze = new zzwi();
    }

    private zzwk(int i) {
        this.zzf = i;
    }

    public static zzwk zzb(int i) {
        if (i == 0) {
            return CELLULAR_NETWORK_TYPE_UNSPECIFIED;
        }
        if (i == 1) {
            return TWO_G;
        }
        if (i == 2) {
            return THREE_G;
        }
        if (i != 4) {
            return null;
        }
        return LTE;
    }

    public static zzetl zzc() {
        return zzwj.zza;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
    }

    public final int zza() {
        return this.zzf;
    }
}
