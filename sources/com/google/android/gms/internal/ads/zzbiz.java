package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbiz implements zzeyl<zzawn> {
    private final zzeyw<Context> zza;

    public zzbiz(zzeyw<Context> zzeyw) {
        this.zza = zzeyw;
    }

    /* renamed from: zza */
    public final zzawn zzb() {
        Context zza2 = ((zzbii) this.zza).zza();
        zzs.zzp().zza(zza2, zzbbq.zza()).zza("google.afma.request.getAdDictionary", zzapb.zza, zzapb.zza);
        return new zzawm(zza2, zzs.zzp().zza(zza2, zzbbq.zza()).zza("google.afma.sdkConstants.getSdkConstants", zzapb.zza, zzapb.zza));
    }
}
