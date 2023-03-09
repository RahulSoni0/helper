package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeoz extends zzeth<zzeoz, zzeoy> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzeoz zzf;
    /* access modifiers changed from: private */
    public int zzb;
    private zzepc zze;

    static {
        zzeoz zzeoz = new zzeoz();
        zzf = zzeoz;
        zzeth.zzay(zzeoz.class, zzeoz);
    }

    private zzeoz() {
    }

    public static zzeoz zzd(zzesf zzesf, zzest zzest) throws zzett {
        return (zzeoz) zzeth.zzaI(zzf, zzesf, zzest);
    }

    public static zzeoy zze() {
        return (zzeoy) zzf.zzas();
    }

    static /* synthetic */ void zzh(zzeoz zzeoz, zzepc zzepc) {
        zzepc.getClass();
        zzeoz.zze = zzepc;
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
            return zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzeoz();
        } else {
            if (i2 == 4) {
                return new zzeoy((zzeox) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final zzepc zzc() {
        zzepc zzepc = this.zze;
        return zzepc == null ? zzepc.zze() : zzepc;
    }
}
