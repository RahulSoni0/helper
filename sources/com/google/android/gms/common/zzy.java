package com.google.android.gms.common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.common.zzu;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
final class zzy {
    private String zza = null;
    private long zzb = -1;
    private zzu<byte[]> zzc = zzu.zzi();
    private zzu<byte[]> zzd = zzu.zzi();

    zzy() {
    }

    /* access modifiers changed from: package-private */
    public final zzy zza(String str) {
        this.zza = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzy zzb(long j) {
        this.zzb = j;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzy zzc(List<byte[]> list) {
        Preconditions.checkNotNull(list);
        this.zzc = zzu.zzm(list);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzy zzd(List<byte[]> list) {
        Preconditions.checkNotNull(list);
        this.zzd = zzu.zzm(list);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzz zze() {
        if (this.zza == null) {
            throw new IllegalStateException("packageName must be defined");
        } else if (this.zzb < 0) {
            throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
        } else if (!this.zzc.isEmpty() || !this.zzd.isEmpty()) {
            return new zzz(this.zza, this.zzb, this.zzc, this.zzd, (zzx) null);
        } else {
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
    }
}
