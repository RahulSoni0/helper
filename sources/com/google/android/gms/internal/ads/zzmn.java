package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import com.itextpdf.text.html.HtmlTags;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzmn extends zzid {
    private static final byte[] zzb = zzqj.zzm("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private boolean zzA;
    private int zzB;
    private int zzC;
    private boolean zzD;
    private boolean zzE;
    private boolean zzF;
    private boolean zzG;
    private boolean zzH;
    protected zzkl zza;
    private final zzmp zzc;
    private final zzkm zzd;
    private final zzkm zze;
    private final zziu zzf;
    private final List<Long> zzg;
    private final MediaCodec.BufferInfo zzh;
    private zzit zzi;
    private MediaCodec zzj;
    private zzml zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private ByteBuffer[] zzu;
    private ByteBuffer[] zzv;
    private long zzw;
    private int zzx;
    private int zzy;
    private boolean zzz;

    public zzmn(int i, zzmp zzmp, zzkr zzkr, boolean z) {
        super(i);
        zzpu.zzd(zzqj.zza >= 16);
        this.zzc = zzmp;
        this.zzd = new zzkm(0);
        this.zze = new zzkm(0);
        this.zzf = new zziu();
        this.zzg = new ArrayList();
        this.zzh = new MediaCodec.BufferInfo();
        this.zzB = 0;
        this.zzC = 0;
    }

    private final boolean zzN() throws zzif {
        MediaCodec mediaCodec = this.zzj;
        if (mediaCodec == null || this.zzC == 2 || this.zzF) {
            return false;
        }
        if (this.zzx < 0) {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(0);
            this.zzx = dequeueInputBuffer;
            if (dequeueInputBuffer < 0) {
                return false;
            }
            zzkm zzkm = this.zzd;
            zzkm.zzb = this.zzu[dequeueInputBuffer];
            zzkm.zza();
        }
        if (this.zzC == 1) {
            if (!this.zzo) {
                this.zzE = true;
                this.zzj.queueInputBuffer(this.zzx, 0, 0, 0, 4);
                this.zzx = -1;
            }
            this.zzC = 2;
            return false;
        } else if (this.zzs) {
            this.zzs = false;
            ByteBuffer byteBuffer = this.zzd.zzb;
            byte[] bArr = zzb;
            byteBuffer.put(bArr);
            MediaCodec mediaCodec2 = this.zzj;
            int i = this.zzx;
            int length = bArr.length;
            mediaCodec2.queueInputBuffer(i, 0, 38, 0, 0);
            this.zzx = -1;
            this.zzD = true;
            return true;
        } else {
            if (this.zzB == 1) {
                for (int i2 = 0; i2 < this.zzi.zzh.size(); i2++) {
                    this.zzd.zzb.put(this.zzi.zzh.get(i2));
                }
                this.zzB = 2;
            }
            int position = this.zzd.zzb.position();
            int zzA2 = zzA(this.zzf, this.zzd, false);
            if (zzA2 == -3) {
                return false;
            }
            if (zzA2 == -5) {
                if (this.zzB == 2) {
                    this.zzd.zza();
                    this.zzB = 1;
                }
                zzL(this.zzf.zza);
                return true;
            } else if (this.zzd.zzc()) {
                if (this.zzB == 2) {
                    this.zzd.zza();
                    this.zzB = 1;
                }
                this.zzF = true;
                if (!this.zzD) {
                    zzO();
                    return false;
                }
                try {
                    if (!this.zzo) {
                        this.zzE = true;
                        this.zzj.queueInputBuffer(this.zzx, 0, 0, 0, 4);
                        this.zzx = -1;
                    }
                    return false;
                } catch (MediaCodec.CryptoException e) {
                    throw zzif.zza(e, zzz());
                }
            } else if (!this.zzH || this.zzd.zzd()) {
                this.zzH = false;
                boolean zzi2 = this.zzd.zzi();
                if (this.zzl && !zzi2) {
                    ByteBuffer byteBuffer2 = this.zzd.zzb;
                    byte[] bArr2 = zzqa.zza;
                    int position2 = byteBuffer2.position();
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        int i5 = i3 + 1;
                        if (i5 >= position2) {
                            byteBuffer2.clear();
                            break;
                        }
                        byte b = byteBuffer2.get(i3) & UByte.MAX_VALUE;
                        if (i4 == 3) {
                            if (b == 1) {
                                if ((byteBuffer2.get(i5) & 31) == 7) {
                                    ByteBuffer duplicate = byteBuffer2.duplicate();
                                    duplicate.position(i3 - 3);
                                    duplicate.limit(position2);
                                    byteBuffer2.position(0);
                                    byteBuffer2.put(duplicate);
                                    break;
                                }
                                b = 1;
                            }
                        } else if (b == 0) {
                            i4++;
                        }
                        if (b != 0) {
                            i4 = 0;
                        }
                        i3 = i5;
                    }
                    if (this.zzd.zzb.position() == 0) {
                        return true;
                    }
                    this.zzl = false;
                }
                try {
                    zzkm zzkm2 = this.zzd;
                    long j = zzkm2.zzc;
                    if (zzkm2.zzb()) {
                        this.zzg.add(Long.valueOf(j));
                    }
                    this.zzd.zzb.flip();
                    zzZ(this.zzd);
                    if (zzi2) {
                        MediaCodec.CryptoInfo zzb2 = this.zzd.zza.zzb();
                        if (position != 0) {
                            if (zzb2.numBytesOfClearData == null) {
                                zzb2.numBytesOfClearData = new int[1];
                            }
                            int[] iArr = zzb2.numBytesOfClearData;
                            iArr[0] = iArr[0] + position;
                        }
                        this.zzj.queueSecureInputBuffer(this.zzx, 0, zzb2, j, 0);
                    } else {
                        this.zzj.queueInputBuffer(this.zzx, 0, this.zzd.zzb.limit(), j, 0);
                    }
                    this.zzx = -1;
                    this.zzD = true;
                    this.zzB = 0;
                    this.zza.zzc++;
                    return true;
                } catch (MediaCodec.CryptoException e2) {
                    throw zzif.zza(e2, zzz());
                }
            } else {
                this.zzd.zza();
                if (this.zzB == 2) {
                    this.zzB = 1;
                }
                return true;
            }
        }
    }

    private final void zzO() throws zzif {
        if (this.zzC == 2) {
            zzY();
            zzU();
            return;
        }
        this.zzG = true;
        zzR();
    }

    public final void zzD(long j, long j2) throws zzif {
        boolean z;
        int i;
        boolean z2;
        if (this.zzG) {
            zzR();
            return;
        }
        if (this.zzi == null) {
            this.zze.zza();
            int zzA2 = zzA(this.zzf, this.zze, true);
            if (zzA2 == -5) {
                zzL(this.zzf.zza);
            } else if (zzA2 == -4) {
                zzpu.zzd(this.zze.zzc());
                this.zzF = true;
                zzO();
                return;
            } else {
                return;
            }
        }
        zzU();
        if (this.zzj != null) {
            zzqh.zza("drainAndFeed");
            while (true) {
                if (this.zzy < 0) {
                    if (!this.zzq || !this.zzE) {
                        i = this.zzj.dequeueOutputBuffer(this.zzh, 0);
                        this.zzy = i;
                    } else {
                        try {
                            i = this.zzj.dequeueOutputBuffer(this.zzh, 0);
                            this.zzy = i;
                        } catch (IllegalStateException unused) {
                            zzO();
                            if (this.zzG) {
                                zzY();
                            }
                        }
                    }
                    if (i >= 0) {
                        if (this.zzt) {
                            this.zzt = false;
                            this.zzj.releaseOutputBuffer(i, false);
                            this.zzy = -1;
                        } else if ((this.zzh.flags & 4) != 0) {
                            zzO();
                            this.zzy = -1;
                            break;
                        } else {
                            ByteBuffer byteBuffer = this.zzv[this.zzy];
                            if (byteBuffer != null) {
                                byteBuffer.position(this.zzh.offset);
                                byteBuffer.limit(this.zzh.offset + this.zzh.size);
                            }
                            long j3 = this.zzh.presentationTimeUs;
                            int size = this.zzg.size();
                            int i2 = 0;
                            while (true) {
                                if (i2 >= size) {
                                    z2 = false;
                                    break;
                                } else if (this.zzg.get(i2).longValue() == j3) {
                                    this.zzg.remove(i2);
                                    z2 = true;
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                            this.zzz = z2;
                        }
                    } else if (i == -2) {
                        MediaFormat outputFormat = this.zzj.getOutputFormat();
                        if (this.zzn && outputFormat.getInteger(HtmlTags.WIDTH) == 32 && outputFormat.getInteger(HtmlTags.HEIGHT) == 32) {
                            this.zzt = true;
                        } else {
                            if (this.zzr) {
                                outputFormat.setInteger("channel-count", 1);
                            }
                            zzM(this.zzj, outputFormat);
                        }
                    } else if (i == -3) {
                        this.zzv = this.zzj.getOutputBuffers();
                    } else if (this.zzo && (this.zzF || this.zzC == 2)) {
                        zzO();
                    }
                }
                if (!this.zzq || !this.zzE) {
                    MediaCodec mediaCodec = this.zzj;
                    ByteBuffer[] byteBufferArr = this.zzv;
                    int i3 = this.zzy;
                    z = zzQ(j, j2, mediaCodec, byteBufferArr[i3], i3, this.zzh.flags, this.zzh.presentationTimeUs, this.zzz);
                } else {
                    try {
                        MediaCodec mediaCodec2 = this.zzj;
                        ByteBuffer[] byteBufferArr2 = this.zzv;
                        int i4 = this.zzy;
                        z = zzQ(j, j2, mediaCodec2, byteBufferArr2[i4], i4, this.zzh.flags, this.zzh.presentationTimeUs, this.zzz);
                    } catch (IllegalStateException unused2) {
                        zzO();
                        if (this.zzG) {
                            zzY();
                        }
                    }
                }
                if (!z) {
                    break;
                }
                long j4 = this.zzh.presentationTimeUs;
                this.zzy = -1;
            }
            do {
            } while (zzN());
            zzqh.zzb();
        } else {
            zzB(j);
            this.zze.zza();
            int zzA3 = zzA(this.zzf, this.zze, false);
            if (zzA3 == -5) {
                zzL(this.zzf.zza);
            } else if (zzA3 == -4) {
                zzpu.zzd(this.zze.zzc());
                this.zzF = true;
                zzO();
            }
        }
        this.zza.zza();
    }

    public boolean zzE() {
        if (this.zzi != null) {
            if (zzC() || this.zzy >= 0) {
                return true;
            }
            if (this.zzw == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.zzw) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean zzF() {
        return this.zzG;
    }

    public final int zzG(zzit zzit) throws zzif {
        try {
            return zzH(this.zzc, zzit);
        } catch (zzms e) {
            throw zzif.zza(e, zzz());
        }
    }

    /* access modifiers changed from: protected */
    public abstract int zzH(zzmp zzmp, zzit zzit) throws zzms;

    /* access modifiers changed from: protected */
    public zzml zzI(zzmp zzmp, zzit zzit, boolean z) throws zzms {
        return zzmw.zza(zzit.zzf, false);
    }

    /* access modifiers changed from: protected */
    public abstract void zzJ(zzml zzml, MediaCodec mediaCodec, zzit zzit, MediaCrypto mediaCrypto) throws zzms;

    /* access modifiers changed from: protected */
    public void zzK(String str, long j, long j2) {
        throw null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
        if (r6.zzk == r0.zzk) goto L_0x0053;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzL(com.google.android.gms.internal.ads.zzit r6) throws com.google.android.gms.internal.ads.zzif {
        /*
            r5 = this;
            com.google.android.gms.internal.ads.zzit r0 = r5.zzi
            r5.zzi = r6
            com.google.android.gms.internal.ads.zzkq r6 = r6.zzi
            if (r0 != 0) goto L_0x000a
            r1 = 0
            goto L_0x000c
        L_0x000a:
            com.google.android.gms.internal.ads.zzkq r1 = r0.zzi
        L_0x000c:
            boolean r6 = com.google.android.gms.internal.ads.zzqj.zza(r6, r1)
            if (r6 != 0) goto L_0x0029
            com.google.android.gms.internal.ads.zzit r6 = r5.zzi
            com.google.android.gms.internal.ads.zzkq r6 = r6.zzi
            if (r6 != 0) goto L_0x0019
            goto L_0x0029
        L_0x0019:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Media requires a DrmSessionManager"
            r6.<init>(r0)
            int r0 = r5.zzz()
            com.google.android.gms.internal.ads.zzif r6 = com.google.android.gms.internal.ads.zzif.zza(r6, r0)
            throw r6
        L_0x0029:
            android.media.MediaCodec r6 = r5.zzj
            r1 = 1
            if (r6 == 0) goto L_0x0056
            com.google.android.gms.internal.ads.zzml r2 = r5.zzk
            boolean r2 = r2.zzb
            com.google.android.gms.internal.ads.zzit r3 = r5.zzi
            boolean r6 = r5.zzaa(r6, r2, r0, r3)
            if (r6 == 0) goto L_0x0056
            r5.zzA = r1
            r5.zzB = r1
            boolean r6 = r5.zzn
            r2 = 0
            if (r6 == 0) goto L_0x0052
            com.google.android.gms.internal.ads.zzit r6 = r5.zzi
            int r3 = r6.zzj
            int r4 = r0.zzj
            if (r3 != r4) goto L_0x0052
            int r6 = r6.zzk
            int r0 = r0.zzk
            if (r6 != r0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r1 = 0
        L_0x0053:
            r5.zzs = r1
            return
        L_0x0056:
            boolean r6 = r5.zzD
            if (r6 == 0) goto L_0x005d
            r5.zzC = r1
            return
        L_0x005d:
            r5.zzY()
            r5.zzU()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmn.zzL(com.google.android.gms.internal.ads.zzit):void");
    }

    /* access modifiers changed from: protected */
    public void zzM(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzif {
        throw null;
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzQ(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzif;

    /* access modifiers changed from: protected */
    public void zzR() throws zzif {
    }

    /* access modifiers changed from: protected */
    public final void zzU() throws zzif {
        zzit zzit;
        boolean z;
        String str;
        if (this.zzj == null && (zzit = this.zzi) != null) {
            zzml zzml = this.zzk;
            if (zzml == null) {
                try {
                    zzml = zzI(this.zzc, zzit, false);
                    this.zzk = zzml;
                    if (zzml == null) {
                        throw zzif.zza(new zzmm(this.zzi, (Throwable) null, false, -49999), zzz());
                    }
                } catch (zzms e) {
                    throw zzif.zza(new zzmm(this.zzi, (Throwable) e, false, -49998), zzz());
                }
            }
            if (zzV(zzml)) {
                String str2 = this.zzk.zza;
                this.zzl = zzqj.zza < 21 && this.zzi.zzh.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2);
                this.zzm = zzqj.zza < 18 || (zzqj.zza == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (zzqj.zza == 19 && zzqj.zzd.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2)));
                this.zzn = zzqj.zza < 24 && ("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(zzqj.zzb) || "flounder_lte".equals(zzqj.zzb) || "grouper".equals(zzqj.zzb) || "tilapia".equals(zzqj.zzb));
                this.zzo = zzqj.zza <= 17 && ("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2));
                if ((zzqj.zza > 23 || !"OMX.google.vorbis.decoder".equals(str2)) && (zzqj.zza > 19 || !"hb2000".equals(zzqj.zzb) || (!"OMX.amlogic.avc.decoder.awesome".equals(str2) && !"OMX.amlogic.avc.decoder.awesome.secure".equals(str2)))) {
                    z = false;
                } else {
                    z = true;
                }
                this.zzp = z;
                this.zzq = zzqj.zza == 21 && "OMX.google.aac.decoder".equals(str2);
                this.zzr = zzqj.zza <= 18 && this.zzi.zzr == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2);
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    String valueOf = String.valueOf(str2);
                    if (valueOf.length() != 0) {
                        str = "createCodec:".concat(valueOf);
                    } else {
                        str = new String("createCodec:");
                    }
                    zzqh.zza(str);
                    this.zzj = MediaCodec.createByCodecName(str2);
                    zzqh.zzb();
                    zzqh.zza("configureCodec");
                    zzJ(this.zzk, this.zzj, this.zzi, (MediaCrypto) null);
                    zzqh.zzb();
                    zzqh.zza("startCodec");
                    this.zzj.start();
                    zzqh.zzb();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    zzK(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.zzu = this.zzj.getInputBuffers();
                    this.zzv = this.zzj.getOutputBuffers();
                    this.zzw = zze() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                    this.zzx = -1;
                    this.zzy = -1;
                    this.zzH = true;
                    this.zza.zza++;
                } catch (Exception e2) {
                    throw zzif.zza(new zzmm(this.zzi, (Throwable) e2, false, str2), zzz());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzV(zzml zzml) {
        return true;
    }

    /* access modifiers changed from: protected */
    public final MediaCodec zzW() {
        return this.zzj;
    }

    /* access modifiers changed from: protected */
    public final zzml zzX() {
        return this.zzk;
    }

    /* access modifiers changed from: protected */
    public void zzY() {
        this.zzw = -9223372036854775807L;
        this.zzx = -1;
        this.zzy = -1;
        this.zzz = false;
        this.zzg.clear();
        this.zzu = null;
        this.zzv = null;
        this.zzk = null;
        this.zzA = false;
        this.zzD = false;
        this.zzl = false;
        this.zzm = false;
        this.zzn = false;
        this.zzo = false;
        this.zzp = false;
        this.zzr = false;
        this.zzs = false;
        this.zzt = false;
        this.zzE = false;
        this.zzB = 0;
        this.zzC = 0;
        this.zzd.zzb = null;
        MediaCodec mediaCodec = this.zzj;
        if (mediaCodec != null) {
            this.zza.zzb++;
            try {
                mediaCodec.stop();
                try {
                    this.zzj.release();
                } finally {
                    this.zzj = null;
                }
            } catch (Throwable th) {
                this.zzj.release();
                throw th;
            } finally {
                this.zzj = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzZ(zzkm zzkm) {
    }

    /* access modifiers changed from: protected */
    public boolean zzaa(MediaCodec mediaCodec, boolean z, zzit zzit, zzit zzit2) {
        return false;
    }

    public final int zzq() {
        return 4;
    }

    /* access modifiers changed from: protected */
    public void zzs(boolean z) throws zzif {
        this.zza = new zzkl();
    }

    /* access modifiers changed from: protected */
    public void zzu(long j, boolean z) throws zzif {
        this.zzF = false;
        this.zzG = false;
        if (this.zzj != null) {
            this.zzw = -9223372036854775807L;
            this.zzx = -1;
            this.zzy = -1;
            this.zzH = true;
            this.zzz = false;
            this.zzg.clear();
            this.zzs = false;
            this.zzt = false;
            if (this.zzm || (this.zzp && this.zzE)) {
                zzY();
                zzU();
            } else if (this.zzC != 0) {
                zzY();
                zzU();
            } else {
                this.zzj.flush();
                this.zzD = false;
            }
            if (this.zzA && this.zzi != null) {
                this.zzB = 1;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzx() {
        this.zzi = null;
        zzY();
    }
}
