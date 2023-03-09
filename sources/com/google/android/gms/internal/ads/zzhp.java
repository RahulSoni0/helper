package com.google.android.gms.internal.ads;

import androidx.room.RoomDatabase;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzhp implements zzetj {
    UNSUPPORTED(0),
    ARM7(2),
    X86(4),
    ARM64(5),
    X86_64(6),
    UNKNOWN(RoomDatabase.MAX_BIND_PARAMETER_CNT);
    
    private static final zzetk<zzhp> zzg = null;
    private final int zzh;

    static {
        zzg = new zzho();
    }

    private zzhp(int i) {
        this.zzh = i;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
    }

    public final int zza() {
        return this.zzh;
    }
}
