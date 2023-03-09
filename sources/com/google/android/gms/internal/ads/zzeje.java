package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeje extends zzegz<zzemg, zzemd> {
    final /* synthetic */ zzejf zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeje(zzejf zzejf, Class cls) {
        super(cls);
        this.zza = zzejf;
    }

    public final /* bridge */ /* synthetic */ void zzb(zzeuo zzeuo) throws GeneralSecurityException {
        zzemg zzemg = (zzemg) zzeuo;
        if (zzemg.zza() != 64) {
            int zza2 = zzemg.zza();
            StringBuilder sb = new StringBuilder(61);
            sb.append("invalid key size: ");
            sb.append(zza2);
            sb.append(". Valid keys must have 64 bytes.");
            throw new InvalidAlgorithmParameterException(sb.toString());
        }
    }

    public final /* bridge */ /* synthetic */ zzeuo zzc(zzesf zzesf) throws zzett {
        return zzemg.zzc(zzesf, zzest.zza());
    }

    public final /* bridge */ /* synthetic */ Object zzd(zzeuo zzeuo) throws GeneralSecurityException {
        zzemc zze = zzemd.zze();
        zze.zzb(zzesf.zzs(zzerb.zza(((zzemg) zzeuo).zza())));
        zze.zza(0);
        return (zzemd) zze.zzah();
    }
}
