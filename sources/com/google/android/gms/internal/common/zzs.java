package com.google.android.gms.internal.common;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
final class zzs<E> extends zzn<E> {
    private final zzu<E> zza;

    zzs(zzu<E> zzu, int i) {
        super(zzu.size(), i);
        this.zza = zzu;
    }

    /* access modifiers changed from: protected */
    public final E zza(int i) {
        return this.zza.get(i);
    }
}
