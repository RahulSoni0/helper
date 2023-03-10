package com.google.android.gms.internal.ads;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzdzy implements zzetj {
    EVENT_TYPE_UNKNOWN(0),
    BLOCKED_IMPRESSION(1);
    
    private static final zzetk<zzdzy> zzc = null;
    private final int zzd;

    static {
        zzc = new zzdzw();
    }

    private zzdzy(int i) {
        this.zzd = i;
    }

    public static zzdzy zzb(int i) {
        if (i == 0) {
            return EVENT_TYPE_UNKNOWN;
        }
        if (i != 1) {
            return null;
        }
        return BLOCKED_IMPRESSION;
    }

    public static zzetl zzc() {
        return zzdzx.zza;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + Typography.greater;
    }

    public final int zza() {
        return this.zzd;
    }
}
