package com.google.android.gms.internal.common;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
abstract class zzn<E> extends zzy<E> {
    private final int zza;
    private int zzb;

    protected zzn(int i, int i2) {
        zzl.zzb(i2, i, "index");
        this.zza = i;
        this.zzb = i2;
    }

    public final boolean hasNext() {
        return this.zzb < this.zza;
    }

    public final boolean hasPrevious() {
        return this.zzb > 0;
    }

    public final E next() {
        if (hasNext()) {
            int i = this.zzb;
            this.zzb = i + 1;
            return zza(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.zzb;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i = this.zzb - 1;
            this.zzb = i;
            return zza(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.zzb - 1;
    }

    /* access modifiers changed from: protected */
    public abstract E zza(int i);
}
