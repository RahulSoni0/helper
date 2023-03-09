package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzehu {
    public static final Charset zza = Charset.forName("UTF-8");

    public static zzeoq zza(zzeol zzeol) {
        zzeon zza2 = zzeoq.zza();
        zza2.zza(zzeol.zza());
        for (zzeok next : zzeol.zzc()) {
            zzeoo zza3 = zzeop.zza();
            zza3.zza(next.zzc().zza());
            zza3.zzb(next.zzd());
            zza3.zzd(next.zzf());
            zza3.zzc(next.zze());
            zza2.zzb((zzeop) zza3.zzah());
        }
        return (zzeoq) zza2.zzah();
    }

    public static void zzb(zzeol zzeol) throws GeneralSecurityException {
        int zza2 = zzeol.zza();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzeok next : zzeol.zzc()) {
            if (next.zzd() == zzeoa.ENABLED) {
                if (!next.zza()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(next.zze())}));
                } else if (next.zzf() == zzepe.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(next.zze())}));
                } else if (next.zzd() != zzeoa.UNKNOWN_STATUS) {
                    if (next.zze() == zza2) {
                        if (!z) {
                            z = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    z2 &= next.zzc().zzd() == zzenx.ASYMMETRIC_PUBLIC;
                    i++;
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(next.zze())}));
                }
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
