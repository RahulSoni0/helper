package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzewj {
    DOUBLE(zzewk.DOUBLE, 1),
    FLOAT(zzewk.FLOAT, 5),
    INT64(zzewk.LONG, 0),
    UINT64(zzewk.LONG, 0),
    INT32(zzewk.INT, 0),
    FIXED64(zzewk.LONG, 1),
    FIXED32(zzewk.INT, 5),
    BOOL(zzewk.BOOLEAN, 0),
    STRING(zzewk.STRING, 2),
    GROUP(zzewk.MESSAGE, 3),
    MESSAGE(zzewk.MESSAGE, 2),
    BYTES(zzewk.BYTE_STRING, 2),
    UINT32(zzewk.INT, 0),
    ENUM(zzewk.ENUM, 0),
    SFIXED32(zzewk.INT, 5),
    SFIXED64(zzewk.LONG, 1),
    SINT32(zzewk.INT, 0),
    SINT64(zzewk.LONG, 0);
    
    private final zzewk zzs;

    private zzewj(zzewk zzewk, int i) {
        this.zzs = zzewk;
    }

    public final zzewk zza() {
        return this.zzs;
    }
}
