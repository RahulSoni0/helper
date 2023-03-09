package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbto;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdnv<RequestComponentT extends zzbto<AdT>, AdT> implements zzdof<RequestComponentT, AdT> {
    private RequestComponentT zza;

    /* renamed from: zza */
    public final synchronized RequestComponentT zzc() {
        return this.zza;
    }

    public final synchronized zzefw<AdT> zzb(zzdog zzdog, zzdoe<RequestComponentT> zzdoe) {
        zzbro zzc;
        RequestComponentT requestcomponentt = (zzbto) zzdoe.zza(zzdog.zzb).zzf();
        this.zza = requestcomponentt;
        zzc = requestcomponentt.zzc();
        return zzc.zzc(zzc.zzb());
    }
}
