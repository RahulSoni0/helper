package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbmp implements zzakp<Object> {
    final /* synthetic */ zzbmq zza;

    zzbmp(zzbmq zzbmq) {
        this.zza = zzbmq;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (zzbmq.zze(this.zza, map)) {
            this.zza.zzc.execute(new zzbmo(this));
        }
    }
}
