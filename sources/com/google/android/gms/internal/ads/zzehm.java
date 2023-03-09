package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeuo;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzehm<PrimitiveT, KeyProtoT extends zzeuo, PublicKeyProtoT extends zzeuo> extends zzegy<PrimitiveT, KeyProtoT> implements zzegw<PrimitiveT> {
    private final zzehn<KeyProtoT, PublicKeyProtoT> zza;
    private final zzehb<PublicKeyProtoT> zzb;

    public zzehm(zzehn<KeyProtoT, PublicKeyProtoT> zzehn, zzehb<PublicKeyProtoT> zzehb, Class<PrimitiveT> cls) {
        super(zzehn, cls);
        this.zza = zzehn;
        this.zzb = zzehb;
    }
}
