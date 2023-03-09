package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcob implements zzeyl<Set<zzcav<zzyi>>> {
    private final zzcnv zza;
    private final zzeyw<zzcoe> zzb;
    private final zzeyw<Executor> zzc;

    public zzcob(zzcnv zzcnv, zzeyw<zzcoe> zzeyw, zzeyw<Executor> zzeyw2) {
        this.zza = zzcnv;
        this.zzb = zzeyw;
        this.zzc = zzeyw2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        Set<zzcav<zzyi>> zzg = zzcnv.zzg(this.zzb.zzb(), zzefx);
        zzeyr.zzb(zzg);
        return zzg;
    }
}
