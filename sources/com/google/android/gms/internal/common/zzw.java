package com.google.android.gms.internal.common;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
final class zzw<E> extends zzu<E> {
    static final zzu<Object> zza = new zzw(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzw(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    public final E get(int i) {
        zzl.zza(i, this.zzc, "index");
        return this.zzb[i];
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzb() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzd() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final int zzg(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }
}
