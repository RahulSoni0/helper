package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeqd implements zzegu {
    private final ECPrivateKey zza;
    private final zzeqf zzb;
    private final String zzc;
    private final byte[] zzd;
    private final zzeqc zze;

    public zzeqd(ECPrivateKey eCPrivateKey, byte[] bArr, String str, int i, zzeqc zzeqc) throws GeneralSecurityException {
        this.zza = eCPrivateKey;
        this.zzb = new zzeqf(eCPrivateKey);
        this.zzd = bArr;
        this.zzc = str;
        this.zze = zzeqc;
    }
}
