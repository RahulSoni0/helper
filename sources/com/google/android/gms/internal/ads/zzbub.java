package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbub implements zzeyl<zzayr> {
    private final zzbua zza;
    private final zzeyw<Context> zzb;
    private final zzeyw<zzbbq> zzc;
    private final zzeyw<zzdqo> zzd;
    private final zzeyw<zzayn> zze;

    public zzbub(zzbua zzbua, zzeyw<Context> zzeyw, zzeyw<zzbbq> zzeyw2, zzeyw<zzdqo> zzeyw3, zzeyw<zzayn> zzeyw4) {
        this.zza = zzbua;
        this.zzb = zzeyw;
        this.zzc = zzeyw2;
        this.zzd = zzeyw3;
        this.zze = zzeyw4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zzb2 = this.zzb.zzb();
        zzbbq zza2 = ((zzbir) this.zzc).zza();
        zzdqo zza3 = ((zzbrb) this.zzd).zza();
        zzayn zzayn = new zzayn();
        zzayo zzayo = zza3.zzz;
        if (zzayo != null) {
            return new zzayl(zzb2, zza2, zzayo, zza3.zzr.zzb, zzayn, (byte[]) null);
        }
        return null;
    }
}
