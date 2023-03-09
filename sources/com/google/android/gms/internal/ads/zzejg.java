package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzejg {
    public static final String zza = "type.googleapis.com/google.crypto.tink.AesSivKey";
    @Deprecated
    public static final zzeph zzb = zzeph.zzc();
    @Deprecated
    public static final zzeph zzc = zzeph.zzc();

    static {
        new zzejf();
        try {
            zzeht.zzc(new zzejf(), true);
            zzeht.zze(new zzeji());
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
