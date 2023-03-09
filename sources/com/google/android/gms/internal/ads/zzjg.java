package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzjg {
    public static final zzjg zza = new zzjg(new int[]{2}, 2);
    private final int[] zzb;
    private final int zzc = 2;

    zzjg(int[] iArr, int i) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        this.zzb = copyOf;
        Arrays.sort(copyOf);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjg)) {
            return false;
        }
        zzjg zzjg = (zzjg) obj;
        if (!Arrays.equals(this.zzb, zzjg.zzb)) {
            return false;
        }
        int i = zzjg.zzc;
        return true;
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.zzb) * 31) + 2;
    }

    public final String toString() {
        String arrays = Arrays.toString(this.zzb);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=2, supportedEncodings=");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
