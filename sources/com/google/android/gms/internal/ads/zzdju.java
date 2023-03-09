package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdju implements zzdiz<zzdjv> {
    private final Executor zza;
    private final String zzb;
    private final PackageInfo zzc;
    private final zzbao zzd;

    public zzdju(zzbao zzbao, Executor executor, String str, PackageInfo packageInfo, int i, byte[] bArr) {
        this.zzd = zzbao;
        this.zza = executor;
        this.zzb = str;
        this.zzc = packageInfo;
    }

    public final zzefw<zzdjv> zza() {
        return zzefo.zzf(zzefo.zzi(zzefo.zza(this.zzb), zzdjs.zza, this.zza), Throwable.class, new zzdjt(this), this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzefw zzb(Throwable th) throws Exception {
        return zzefo.zza(new zzdjv(this.zzb));
    }
}
