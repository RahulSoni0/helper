package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdjx implements zzdiz<zzdjy> {
    private final Context zza;
    private final String zzb;
    private final zzefx zzc;

    public zzdjx(zzawe zzawe, Context context, String str, zzefx zzefx) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzefx;
    }

    public final zzefw<zzdjy> zza() {
        return this.zzc.zzb(new zzdjw(this));
    }
}
