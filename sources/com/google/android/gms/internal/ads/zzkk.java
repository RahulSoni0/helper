package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzkk {
    public byte[] zza;
    public byte[] zzb;
    public int zzc;
    public int[] zzd;
    public int[] zze;
    public int zzf;
    private final MediaCodec.CryptoInfo zzg;
    private final zzkj zzh;

    public zzkk() {
        zzkj zzkj = null;
        MediaCodec.CryptoInfo cryptoInfo = zzqj.zza >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.zzg = cryptoInfo;
        this.zzh = zzqj.zza >= 24 ? new zzkj(cryptoInfo, (zzki) null) : zzkj;
    }

    public final void zza(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.zzf = i;
        this.zzd = iArr;
        this.zze = iArr2;
        this.zzb = bArr;
        this.zza = bArr2;
        this.zzc = 1;
        if (zzqj.zza >= 16) {
            this.zzg.numSubSamples = this.zzf;
            this.zzg.numBytesOfClearData = this.zzd;
            this.zzg.numBytesOfEncryptedData = this.zze;
            this.zzg.key = this.zzb;
            this.zzg.iv = this.zza;
            this.zzg.mode = this.zzc;
            if (zzqj.zza >= 24) {
                zzkj.zza(this.zzh, 0, 0);
            }
        }
    }

    public final MediaCodec.CryptoInfo zzb() {
        return this.zzg;
    }
}
