package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeij extends zzegz<zzelu, zzelr> {
    final /* synthetic */ zzeik zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeij(zzeik zzeik, Class cls) {
        super(cls);
        this.zza = zzeik;
    }

    public final /* bridge */ /* synthetic */ void zzb(zzeuo zzeuo) throws GeneralSecurityException {
        zzerd.zza(((zzelu) zzeuo).zza());
    }

    public final /* bridge */ /* synthetic */ zzeuo zzc(zzesf zzesf) throws zzett {
        return zzelu.zzc(zzesf, zzest.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzeuo zzeuo) throws GeneralSecurityException {
        zzelq zze = zzelr.zze();
        zze.zzb(zzesf.zzs(zzerb.zza(((zzelu) zzeuo).zza())));
        zze.zza(0);
        return (zzelr) zze.zzah();
    }
}
