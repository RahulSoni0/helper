package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzag;
import com.google.android.gms.internal.ads.zzal;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzay implements zzag {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbb zzb;

    zzay(zzbe zzbe, String str, zzbb zzbb) {
        this.zza = str;
        this.zzb = zzbb;
    }

    public final void zza(zzal zzal) {
        String str = this.zza;
        String zzal2 = zzal.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(zzal2).length());
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append("\n");
        sb.append(zzal2);
        zze.zzi(sb.toString());
        this.zzb.zza(null);
    }
}
