package com.google.android.gms.internal.ads;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzca implements zzetj {
    UNKNOWN(0),
    ENABLED(1),
    DISABLED(2);
    
    private static final zzetk<zzca> zzd = null;
    private final int zze;

    static {
        zzd = new zzby();
    }

    private zzca(int i) {
        this.zze = i;
    }

    public static zzca zzb(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 1) {
            return ENABLED;
        }
        if (i != 2) {
            return null;
        }
        return DISABLED;
    }

    public static zzetl zzc() {
        return zzbz.zza;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + Typography.greater;
    }

    public final int zza() {
        return this.zze;
    }
}
