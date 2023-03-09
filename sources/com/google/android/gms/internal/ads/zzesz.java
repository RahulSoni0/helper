package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public enum zzesz {
    DOUBLE(0, 1, zzetu.DOUBLE),
    FLOAT(1, 1, zzetu.FLOAT),
    INT64(2, 1, zzetu.LONG),
    UINT64(3, 1, zzetu.LONG),
    INT32(4, 1, zzetu.INT),
    FIXED64(5, 1, zzetu.LONG),
    FIXED32(6, 1, zzetu.INT),
    BOOL(7, 1, zzetu.BOOLEAN),
    STRING(8, 1, zzetu.STRING),
    MESSAGE(9, 1, zzetu.MESSAGE),
    BYTES(10, 1, zzetu.BYTE_STRING),
    UINT32(11, 1, zzetu.INT),
    ENUM(12, 1, zzetu.ENUM),
    SFIXED32(13, 1, zzetu.INT),
    SFIXED64(14, 1, zzetu.LONG),
    SINT32(15, 1, zzetu.INT),
    SINT64(16, 1, zzetu.LONG),
    GROUP(17, 1, zzetu.MESSAGE),
    DOUBLE_LIST(18, 2, zzetu.DOUBLE),
    FLOAT_LIST(19, 2, zzetu.FLOAT),
    INT64_LIST(20, 2, zzetu.LONG),
    UINT64_LIST(21, 2, zzetu.LONG),
    INT32_LIST(22, 2, zzetu.INT),
    FIXED64_LIST(23, 2, zzetu.LONG),
    FIXED32_LIST(24, 2, zzetu.INT),
    BOOL_LIST(25, 2, zzetu.BOOLEAN),
    STRING_LIST(26, 2, zzetu.STRING),
    MESSAGE_LIST(27, 2, zzetu.MESSAGE),
    BYTES_LIST(28, 2, zzetu.BYTE_STRING),
    UINT32_LIST(29, 2, zzetu.INT),
    ENUM_LIST(30, 2, zzetu.ENUM),
    SFIXED32_LIST(31, 2, zzetu.INT),
    SFIXED64_LIST(32, 2, zzetu.LONG),
    SINT32_LIST(33, 2, zzetu.INT),
    SINT64_LIST(34, 2, zzetu.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzetu.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzetu.FLOAT),
    INT64_LIST_PACKED(37, 3, zzetu.LONG),
    UINT64_LIST_PACKED(38, 3, zzetu.LONG),
    INT32_LIST_PACKED(39, 3, zzetu.INT),
    FIXED64_LIST_PACKED(40, 3, zzetu.LONG),
    FIXED32_LIST_PACKED(41, 3, zzetu.INT),
    BOOL_LIST_PACKED(42, 3, zzetu.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzetu.INT),
    ENUM_LIST_PACKED(44, 3, zzetu.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzetu.INT),
    SFIXED64_LIST_PACKED(46, 3, zzetu.LONG),
    SINT32_LIST_PACKED(47, 3, zzetu.INT),
    SINT64_LIST_PACKED(48, 3, zzetu.LONG),
    GROUP_LIST(49, 2, zzetu.MESSAGE),
    MAP(50, 4, zzetu.VOID);
    
    private static final zzesz[] zzac = null;
    private final zzetu zzZ;
    private final int zzaa;
    private final Class<?> zzab;

    static {
        zzac = new zzesz[r1];
        for (zzesz zzesz : values()) {
            zzac[zzesz.zzaa] = zzesz;
        }
    }

    private zzesz(int i, int i2, zzetu zzetu) {
        this.zzaa = i;
        this.zzZ = zzetu;
        zzetu zzetu2 = zzetu.VOID;
        int i3 = i2 - 1;
        if (i3 == 1) {
            this.zzab = zzetu.zza();
        } else if (i3 != 3) {
            this.zzab = null;
        } else {
            this.zzab = zzetu.zza();
        }
        if (i2 == 1) {
            zzetu.ordinal();
        }
    }

    public final int zza() {
        return this.zzaa;
    }
}
