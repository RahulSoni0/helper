package com.google.android.gms.common;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
final class zzj extends zzi {
    private final byte[] zza;

    zzj(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.zza = bArr;
    }

    /* access modifiers changed from: package-private */
    public final byte[] zzc() {
        return this.zza;
    }
}
