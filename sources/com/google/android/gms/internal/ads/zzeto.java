package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeto<F, T> extends AbstractList<T> {
    private final List<F> zza;
    private final zzetn<F, T> zzb;

    public zzeto(List<F> list, zzetn<F, T> zzetn) {
        this.zza = list;
        this.zzb = zzetn;
    }

    public final T get(int i) {
        T zzb2 = zzvg.zzb(((Integer) this.zza.get(i)).intValue());
        return zzb2 == null ? zzvg.AD_FORMAT_TYPE_UNSPECIFIED : zzb2;
    }

    public final int size() {
        return this.zza.size();
    }
}
