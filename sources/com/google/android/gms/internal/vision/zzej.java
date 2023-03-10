package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public abstract class zzej<E> extends zzeb<E> implements Set<E> {
    @NullableDecl
    private transient zzee<E> zza;

    static int zza(int i) {
        int max = Math.max(i, 2);
        boolean z = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (true) {
                double d = (double) highestOneBit;
                Double.isNaN(d);
                if (d * 0.7d >= ((double) max)) {
                    return highestOneBit;
                }
                highestOneBit <<= 1;
            }
        } else {
            if (max >= 1073741824) {
                z = false;
            }
            zzde.zza(z, (Object) "collection too large");
            return 1073741824;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzg() {
        return false;
    }

    zzej() {
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzej) || !zzg() || !((zzej) obj).zzg() || hashCode() == obj.hashCode()) {
            return zzey.zza(this, obj);
        }
        return false;
    }

    public int hashCode() {
        return zzey.zza(this);
    }

    public zzee<E> zze() {
        zzee<E> zzee = this.zza;
        if (zzee != null) {
            return zzee;
        }
        zzee<E> zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    /* access modifiers changed from: package-private */
    public zzee<E> zzh() {
        return zzee.zza(toArray());
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
