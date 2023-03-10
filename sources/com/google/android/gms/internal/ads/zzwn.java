package com.google.android.gms.internal.ads;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzwn implements zzetj {
    NETWORKTYPE_UNSPECIFIED(0),
    CELL(1),
    WIFI(2);
    
    private static final zzetk<zzwn> zzd = null;
    private final int zze;

    static {
        zzd = new zzwl();
    }

    private zzwn(int i) {
        this.zze = i;
    }

    public static zzwn zzb(int i) {
        if (i == 0) {
            return NETWORKTYPE_UNSPECIFIED;
        }
        if (i == 1) {
            return CELL;
        }
        if (i != 2) {
            return null;
        }
        return WIFI;
    }

    public static zzetl zzc() {
        return zzwm.zza;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }

    public final int zza() {
        return this.zze;
    }
}
