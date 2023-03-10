package com.google.android.gms.internal.ads;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzuy implements zzetj {
    UNSPECIFIED(0),
    IN_MEMORY(1);
    
    private static final zzetk<zzuy> zzc = null;
    private final int zzd;

    static {
        zzc = new zzuw();
    }

    private zzuy(int i) {
        this.zzd = i;
    }

    public static zzuy zzb(int i) {
        if (i == 0) {
            return UNSPECIFIED;
        }
        if (i != 1) {
            return null;
        }
        return IN_MEMORY;
    }

    public static zzetl zzc() {
        return zzux.zza;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + Typography.greater;
    }

    public final int zza() {
        return this.zzd;
    }
}
