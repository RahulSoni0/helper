package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdkh implements zzdiz<zzdki> {
    final zzefx zza;
    final Context zzb;
    final zztv zzc;

    public zzdkh(zztv zztv, zzefx zzefx, Context context, byte[] bArr) {
        this.zzc = zztv;
        this.zza = zzefx;
        this.zzb = context;
    }

    public final zzefw<zzdki> zza() {
        return this.zza.zzb(new zzdkg(this));
    }
}
