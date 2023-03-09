package com.google.android.gms.ads.internal.util;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzh implements Runnable {
    private final zzj zza;
    private final Context zzb;
    private final String zzc = "admob";

    zzh(zzj zzj, Context context, String str) {
        this.zza = zzj;
        this.zzb = context;
    }

    public final void run() {
        this.zza.zzH(this.zzb, this.zzc);
    }
}
