package com.google.android.gms.internal.ads;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzexf implements zzetj {
    TYPE_UNKNOWN(0),
    TYPE_CREATIVE(1);
    
    private static final zzetk<zzexf> zzc = null;
    private final int zzd;

    static {
        zzc = new zzexd();
    }

    private zzexf(int i) {
        this.zzd = i;
    }

    public static zzexf zzb(int i) {
        if (i == 0) {
            return TYPE_UNKNOWN;
        }
        if (i != 1) {
            return null;
        }
        return TYPE_CREATIVE;
    }

    public static zzetl zzc() {
        return zzexe.zza;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + Typography.greater;
    }

    public final int zza() {
        return this.zzd;
    }
}
