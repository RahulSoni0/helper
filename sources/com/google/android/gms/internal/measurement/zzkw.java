package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
final class zzkw implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zzku zzb;

    zzkw(zzku zzku) {
        this.zzb = zzku;
        this.zza = zzku.zza.iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.zza.next();
    }
}
