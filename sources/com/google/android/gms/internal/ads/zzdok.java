package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdok implements zzeyl<zzdof<zzckb, zzcjw>> {
    private final zzeyw<Context> zza;
    private final zzeyw<zzdsn> zzb;
    private final zzeyw<zzdtf> zzc;

    public zzdok(zzeyw<Context> zzeyw, zzeyw<zzdsn> zzeyw2, zzeyw<zzdtf> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    /* renamed from: zza */
    public final zzdof<zzckb, zzcjw> zzb() {
        Context zzb2 = this.zza.zzb();
        zzdsn zzb3 = this.zzb.zzb();
        zzdtf zzb4 = this.zzc.zzb();
        if (((Integer) zzaaa.zzc().zzb(zzaeq.zzev)).intValue() <= 0) {
            return new zzdnv();
        }
        zzdte zza2 = zzb4.zza(zzdsv.Rewarded, zzb2, zzb3, new zzdnk(new zzdng()));
        return new zzdnm(new zzdnw(new zzdnv()), new zzdns(zza2.zza, zzbbw.zza), zza2.zzb, zzbbw.zza);
    }
}
