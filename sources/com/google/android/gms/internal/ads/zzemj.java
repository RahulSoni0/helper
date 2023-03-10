package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzemj extends zzeth<zzemj, zzemi> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzemj zzf;
    /* access modifiers changed from: private */
    public int zzb;
    /* access modifiers changed from: private */
    public zzesf zze = zzesf.zzb;

    static {
        zzemj zzemj = new zzemj();
        zzf = zzemj;
        zzeth.zzay(zzemj.class, zzemj);
    }

    private zzemj() {
    }

    public static zzemj zzd(zzesf zzesf, zzest zzest) throws zzett {
        return (zzemj) zzeth.zzaI(zzf, zzesf, zzest);
    }

    public static zzemi zze() {
        return (zzemi) zzf.zzas();
    }

    public final int zza() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzemj();
        } else {
            if (i2 == 4) {
                return new zzemi((zzemh) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final zzesf zzc() {
        return this.zze;
    }
}
