package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzkd extends zzmn implements zzpy {
    /* access modifiers changed from: private */
    public final zzjp zzb;
    private final zzjz zzc = new zzjz((zzjg) null, new zzji[0], new zzkc(this, (zzkb) null));
    private boolean zzd;
    private int zze;
    private int zzf;
    private long zzg;
    /* access modifiers changed from: private */
    public boolean zzh;

    public zzkd(zzmp zzmp, zzkr zzkr, boolean z, Handler handler, zzjq zzjq) {
        super(1, zzmp, (zzkr) null, true);
        this.zzb = new zzjp(handler, zzjq);
    }

    public final boolean zzE() {
        return this.zzc.zzh() || super.zzE();
    }

    public final boolean zzF() {
        return super.zzF() && this.zzc.zzg();
    }

    /* access modifiers changed from: protected */
    public final int zzH(zzmp zzmp, zzit zzit) throws zzms {
        int i;
        int i2;
        String str = zzit.zzf;
        if (!zzpz.zza(str)) {
            return 0;
        }
        int i3 = zzqj.zza >= 21 ? 16 : 0;
        zzml zza = zzmw.zza(str, false);
        if (zza == null) {
            return 1;
        }
        int i4 = 2;
        if (zzqj.zza < 21 || (((i = zzit.zzs) == -1 || zza.zzg(i)) && ((i2 = zzit.zzr) == -1 || zza.zzh(i2)))) {
            i4 = 3;
        }
        return i3 | 4 | i4;
    }

    /* access modifiers changed from: protected */
    public final zzml zzI(zzmp zzmp, zzit zzit, boolean z) throws zzms {
        return super.zzI(zzmp, zzit, false);
    }

    /* access modifiers changed from: protected */
    public final void zzJ(zzml zzml, MediaCodec mediaCodec, zzit zzit, MediaCrypto mediaCrypto) {
        String str = zzml.zza;
        boolean z = true;
        if (zzqj.zza >= 24 || !"OMX.SEC.aac.dec".equals(str) || !"samsung".equals(zzqj.zzc) || (!zzqj.zzb.startsWith("zeroflte") && !zzqj.zzb.startsWith("herolte") && !zzqj.zzb.startsWith("heroqlte"))) {
            z = false;
        }
        this.zzd = z;
        mediaCodec.configure(zzit.zzl(), (Surface) null, (MediaCrypto) null, 0);
    }

    /* access modifiers changed from: protected */
    public final void zzK(String str, long j, long j2) {
        this.zzb.zzb(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzL(zzit zzit) throws zzif {
        super.zzL(zzit);
        this.zzb.zzc(zzit);
        this.zze = "audio/raw".equals(zzit.zzf) ? zzit.zzt : 2;
        this.zzf = zzit.zzr;
    }

    /* access modifiers changed from: protected */
    public final void zzM(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzif {
        int[] iArr;
        int i;
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (!this.zzd || integer != 6) {
            i = integer;
            iArr = null;
        } else {
            int i2 = this.zzf;
            if (i2 < 6) {
                int[] iArr2 = new int[i2];
                for (int i3 = 0; i3 < this.zzf; i3++) {
                    iArr2[i3] = i3;
                }
                iArr = iArr2;
            } else {
                iArr = null;
            }
            i = 6;
        }
        try {
            this.zzc.zzb("audio/raw", i, integer2, this.zze, 0, iArr);
        } catch (zzju e) {
            throw zzif.zza(e, zzz());
        }
    }

    public final long zzN() {
        long zza = this.zzc.zza(zzF());
        if (zza != Long.MIN_VALUE) {
            if (!this.zzh) {
                zza = Math.max(this.zzg, zza);
            }
            this.zzg = zza;
            this.zzh = false;
        }
        return this.zzg;
    }

    public final zzix zzO(zzix zzix) {
        return this.zzc.zzi(zzix);
    }

    public final zzix zzP() {
        return this.zzc.zzj();
    }

    /* access modifiers changed from: protected */
    public final boolean zzQ(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzif {
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.zza.zze++;
            this.zzc.zzd();
            return true;
        }
        try {
            if (!this.zzc.zze(byteBuffer, j3)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            this.zza.zzd++;
            return true;
        } catch (zzjv | zzjy e) {
            throw zzif.zza(e, zzz());
        }
    }

    public final zzpy zzd() {
        return this;
    }

    public final void zzr(int i, Object obj) throws zzif {
        if (i == 2) {
            this.zzc.zzk(((Float) obj).floatValue());
        }
    }

    /* access modifiers changed from: protected */
    public final void zzs(boolean z) throws zzif {
        super.zzs(z);
        this.zzb.zza(this.zza);
        int i = zzy().zzb;
    }

    /* access modifiers changed from: protected */
    public final void zzu(long j, boolean z) throws zzif {
        super.zzu(j, z);
        this.zzc.zzm();
        this.zzg = j;
        this.zzh = true;
    }

    /* access modifiers changed from: protected */
    public final void zzv() {
        this.zzc.zzc();
    }

    /* access modifiers changed from: protected */
    public final void zzw() {
        this.zzc.zzl();
    }

    /* access modifiers changed from: protected */
    public final void zzx() {
        try {
            this.zzc.zzn();
            try {
                super.zzx();
            } finally {
                this.zza.zza();
                this.zzb.zze(this.zza);
            }
        } catch (Throwable th) {
            super.zzx();
            throw th;
        } finally {
            this.zza.zza();
            this.zzb.zze(this.zza);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzR() throws zzif {
        try {
            this.zzc.zzf();
        } catch (zzjy e) {
            throw zzif.zza(e, zzz());
        }
    }
}
