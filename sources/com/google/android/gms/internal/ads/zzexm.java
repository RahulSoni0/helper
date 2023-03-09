package com.google.android.gms.internal.ads;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzexm implements zzetj {
    AD_RESOURCE_UNKNOWN(0),
    AD_RESOURCE_CREATIVE(1),
    AD_RESOURCE_POST_CLICK(2),
    AD_RESOURCE_AUTO_CLICK_DESTINATION(3);
    
    private static final zzetk<zzexm> zze = null;
    private final int zzf;

    static {
        zze = new zzexk();
    }

    private zzexm(int i) {
        this.zzf = i;
    }

    public static zzexm zzb(int i) {
        if (i == 0) {
            return AD_RESOURCE_UNKNOWN;
        }
        if (i == 1) {
            return AD_RESOURCE_CREATIVE;
        }
        if (i == 2) {
            return AD_RESOURCE_POST_CLICK;
        }
        if (i != 3) {
            return null;
        }
        return AD_RESOURCE_AUTO_CLICK_DESTINATION;
    }

    public static zzetl zzc() {
        return zzexl.zza;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + Typography.greater;
    }

    public final int zza() {
        return this.zzf;
    }
}
