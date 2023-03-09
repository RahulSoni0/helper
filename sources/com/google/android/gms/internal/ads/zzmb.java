package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.LongCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzmb implements zzku {
    public static final zzkw zza = new zzly();
    private static final int zzb = zzqj.zzl("seig");
    private static final byte[] zzc = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private final SparseArray<zzma> zzd;
    private final zzqc zze;
    private final zzqc zzf;
    private final zzqc zzg;
    private final zzqc zzh;
    private final zzqc zzi;
    private final byte[] zzj;
    private final Stack<zzln> zzk;
    private final LinkedList<zzlz> zzl;
    private int zzm;
    private int zzn;
    private long zzo;
    private int zzp;
    private zzqc zzq;
    private long zzr;
    private long zzs;
    private zzma zzt;
    private int zzu;
    private int zzv;
    private int zzw;
    private zzkv zzx;
    private boolean zzy;

    public zzmb() {
        this(0, (zzqg) null, (zzmh) null);
    }

    private final void zza() {
        this.zzm = 0;
        this.zzp = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x0349  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0350  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0358  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x038c  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x039e  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x03bf  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x03c1  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x05a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(long r50) throws com.google.android.gms.internal.ads.zziw {
        /*
            r49 = this;
        L_0x0000:
            r0 = r49
        L_0x0002:
            java.util.Stack<com.google.android.gms.internal.ads.zzln> r1 = r0.zzk
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0639
            java.util.Stack<com.google.android.gms.internal.ads.zzln> r1 = r0.zzk
            java.lang.Object r1 = r1.peek()
            com.google.android.gms.internal.ads.zzln r1 = (com.google.android.gms.internal.ads.zzln) r1
            long r1 = r1.zza
            int r3 = (r1 > r50 ? 1 : (r1 == r50 ? 0 : -1))
            if (r3 != 0) goto L_0x0639
            java.util.Stack<com.google.android.gms.internal.ads.zzln> r1 = r0.zzk
            java.lang.Object r1 = r1.pop()
            com.google.android.gms.internal.ads.zzln r1 = (com.google.android.gms.internal.ads.zzln) r1
            int r2 = r1.zzaR
            int r3 = com.google.android.gms.internal.ads.zzlp.zzE
            r4 = 12
            r5 = 8
            r7 = 1
            if (r2 != r3) goto L_0x015f
            java.util.List<com.google.android.gms.internal.ads.zzlo> r2 = r1.zzb
            com.google.android.gms.internal.ads.zzkq r2 = zzh(r2)
            int r3 = com.google.android.gms.internal.ads.zzlp.zzP
            com.google.android.gms.internal.ads.zzln r3 = r1.zzd(r3)
            android.util.SparseArray r14 = new android.util.SparseArray
            r14.<init>()
            java.util.List<com.google.android.gms.internal.ads.zzlo> r8 = r3.zzb
            int r8 = r8.size()
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r15 = r9
            r9 = 0
        L_0x0049:
            if (r9 >= r8) goto L_0x00b5
            java.util.List<com.google.android.gms.internal.ads.zzlo> r10 = r3.zzb
            java.lang.Object r10 = r10.get(r9)
            com.google.android.gms.internal.ads.zzlo r10 = (com.google.android.gms.internal.ads.zzlo) r10
            int r11 = r10.zzaR
            int r12 = com.google.android.gms.internal.ads.zzlp.zzB
            if (r11 != r12) goto L_0x0091
            com.google.android.gms.internal.ads.zzqc r10 = r10.zza
            r10.zzi(r4)
            int r11 = r10.zzr()
            int r12 = r10.zzu()
            int r13 = r10.zzu()
            int r6 = r10.zzu()
            int r10 = r10.zzr()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            com.google.android.gms.internal.ads.zzlx r4 = new com.google.android.gms.internal.ads.zzlx
            int r12 = r12 + -1
            r4.<init>(r12, r13, r6, r10)
            android.util.Pair r4 = android.util.Pair.create(r11, r4)
            java.lang.Object r6 = r4.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.Object r4 = r4.second
            com.google.android.gms.internal.ads.zzlx r4 = (com.google.android.gms.internal.ads.zzlx) r4
            r14.put(r6, r4)
            goto L_0x00b0
        L_0x0091:
            int r4 = r10.zzaR
            int r6 = com.google.android.gms.internal.ads.zzlp.zzQ
            if (r4 != r6) goto L_0x00b0
            com.google.android.gms.internal.ads.zzqc r4 = r10.zza
            r4.zzi(r5)
            int r6 = r4.zzr()
            int r6 = com.google.android.gms.internal.ads.zzlp.zze(r6)
            if (r6 != 0) goto L_0x00ab
            long r10 = r4.zzp()
            goto L_0x00af
        L_0x00ab:
            long r10 = r4.zzv()
        L_0x00af:
            r15 = r10
        L_0x00b0:
            int r9 = r9 + 1
            r4 = 12
            goto L_0x0049
        L_0x00b5:
            android.util.SparseArray r3 = new android.util.SparseArray
            r3.<init>()
            java.util.List<com.google.android.gms.internal.ads.zzln> r4 = r1.zzc
            int r4 = r4.size()
            r5 = 0
        L_0x00c1:
            if (r5 >= r4) goto L_0x00e9
            java.util.List<com.google.android.gms.internal.ads.zzln> r6 = r1.zzc
            java.lang.Object r6 = r6.get(r5)
            r8 = r6
            com.google.android.gms.internal.ads.zzln r8 = (com.google.android.gms.internal.ads.zzln) r8
            int r6 = r8.zzaR
            int r9 = com.google.android.gms.internal.ads.zzlp.zzG
            if (r6 != r9) goto L_0x00e6
            int r6 = com.google.android.gms.internal.ads.zzlp.zzF
            com.google.android.gms.internal.ads.zzlo r9 = r1.zzc(r6)
            r13 = 0
            r10 = r15
            r12 = r2
            com.google.android.gms.internal.ads.zzmh r6 = com.google.android.gms.internal.ads.zzlw.zza(r8, r9, r10, r12, r13)
            if (r6 == 0) goto L_0x00e6
            int r8 = r6.zza
            r3.put(r8, r6)
        L_0x00e6:
            int r5 = r5 + 1
            goto L_0x00c1
        L_0x00e9:
            int r1 = r3.size()
            android.util.SparseArray<com.google.android.gms.internal.ads.zzma> r2 = r0.zzd
            int r2 = r2.size()
            if (r2 != 0) goto L_0x0131
            r6 = 0
        L_0x00f6:
            if (r6 >= r1) goto L_0x012a
            java.lang.Object r2 = r3.valueAt(r6)
            com.google.android.gms.internal.ads.zzmh r2 = (com.google.android.gms.internal.ads.zzmh) r2
            com.google.android.gms.internal.ads.zzma r4 = new com.google.android.gms.internal.ads.zzma
            com.google.android.gms.internal.ads.zzkv r5 = r0.zzx
            int r7 = r2.zzb
            com.google.android.gms.internal.ads.zzld r5 = r5.zzbf(r6, r7)
            r4.<init>(r5)
            int r5 = r2.zza
            java.lang.Object r5 = r14.get(r5)
            com.google.android.gms.internal.ads.zzlx r5 = (com.google.android.gms.internal.ads.zzlx) r5
            r4.zza(r2, r5)
            android.util.SparseArray<com.google.android.gms.internal.ads.zzma> r5 = r0.zzd
            int r7 = r2.zza
            r5.put(r7, r4)
            long r4 = r0.zzs
            long r7 = r2.zze
            long r4 = java.lang.Math.max(r4, r7)
            r0.zzs = r4
            int r6 = r6 + 1
            goto L_0x00f6
        L_0x012a:
            com.google.android.gms.internal.ads.zzkv r1 = r0.zzx
            r1.zzbg()
            goto L_0x0002
        L_0x0131:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzma> r2 = r0.zzd
            int r2 = r2.size()
            if (r2 != r1) goto L_0x013a
            goto L_0x013b
        L_0x013a:
            r7 = 0
        L_0x013b:
            com.google.android.gms.internal.ads.zzpu.zzd(r7)
            r6 = 0
        L_0x013f:
            if (r6 >= r1) goto L_0x0002
            java.lang.Object r2 = r3.valueAt(r6)
            com.google.android.gms.internal.ads.zzmh r2 = (com.google.android.gms.internal.ads.zzmh) r2
            android.util.SparseArray<com.google.android.gms.internal.ads.zzma> r4 = r0.zzd
            int r5 = r2.zza
            java.lang.Object r4 = r4.get(r5)
            com.google.android.gms.internal.ads.zzma r4 = (com.google.android.gms.internal.ads.zzma) r4
            int r5 = r2.zza
            java.lang.Object r5 = r14.get(r5)
            com.google.android.gms.internal.ads.zzlx r5 = (com.google.android.gms.internal.ads.zzlx) r5
            r4.zza(r2, r5)
            int r6 = r6 + 1
            goto L_0x013f
        L_0x015f:
            int r2 = r1.zzaR
            int r3 = com.google.android.gms.internal.ads.zzlp.zzN
            if (r2 != r3) goto L_0x0622
            android.util.SparseArray<com.google.android.gms.internal.ads.zzma> r2 = r0.zzd
            byte[] r3 = r0.zzj
            java.util.List<com.google.android.gms.internal.ads.zzln> r4 = r1.zzc
            int r4 = r4.size()
            r6 = 0
        L_0x0170:
            if (r6 >= r4) goto L_0x05f6
            java.util.List<com.google.android.gms.internal.ads.zzln> r8 = r1.zzc
            java.lang.Object r8 = r8.get(r6)
            com.google.android.gms.internal.ads.zzln r8 = (com.google.android.gms.internal.ads.zzln) r8
            int r9 = r8.zzaR
            int r10 = com.google.android.gms.internal.ads.zzlp.zzO
            if (r9 != r10) goto L_0x05dc
            int r9 = com.google.android.gms.internal.ads.zzlp.zzA
            com.google.android.gms.internal.ads.zzlo r9 = r8.zzc(r9)
            com.google.android.gms.internal.ads.zzqc r9 = r9.zza
            r9.zzi(r5)
            int r10 = r9.zzr()
            int r10 = com.google.android.gms.internal.ads.zzlp.zzf(r10)
            int r11 = r9.zzr()
            java.lang.Object r11 = r2.get(r11)
            com.google.android.gms.internal.ads.zzma r11 = (com.google.android.gms.internal.ads.zzma) r11
            if (r11 != 0) goto L_0x01a1
            r11 = 0
            goto L_0x01e8
        L_0x01a1:
            r12 = r10 & 1
            if (r12 == 0) goto L_0x01af
            long r12 = r9.zzv()
            com.google.android.gms.internal.ads.zzmj r14 = r11.zza
            r14.zzb = r12
            r14.zzc = r12
        L_0x01af:
            com.google.android.gms.internal.ads.zzlx r12 = r11.zzd
            r13 = r10 & 2
            if (r13 == 0) goto L_0x01bc
            int r13 = r9.zzu()
            int r13 = r13 + -1
            goto L_0x01be
        L_0x01bc:
            int r13 = r12.zza
        L_0x01be:
            r14 = r10 & 8
            if (r14 == 0) goto L_0x01c7
            int r14 = r9.zzu()
            goto L_0x01c9
        L_0x01c7:
            int r14 = r12.zzb
        L_0x01c9:
            r15 = r10 & 16
            if (r15 == 0) goto L_0x01d2
            int r15 = r9.zzu()
            goto L_0x01d4
        L_0x01d2:
            int r15 = r12.zzc
        L_0x01d4:
            r10 = r10 & 32
            if (r10 == 0) goto L_0x01dd
            int r9 = r9.zzu()
            goto L_0x01df
        L_0x01dd:
            int r9 = r12.zzd
        L_0x01df:
            com.google.android.gms.internal.ads.zzmj r10 = r11.zza
            com.google.android.gms.internal.ads.zzlx r12 = new com.google.android.gms.internal.ads.zzlx
            r12.<init>(r13, r14, r15, r9)
            r10.zza = r12
        L_0x01e8:
            if (r11 != 0) goto L_0x01ec
            goto L_0x05dc
        L_0x01ec:
            com.google.android.gms.internal.ads.zzmj r9 = r11.zza
            long r12 = r9.zzr
            r11.zzb()
            int r10 = com.google.android.gms.internal.ads.zzlp.zzz
            com.google.android.gms.internal.ads.zzlo r10 = r8.zzc(r10)
            if (r10 == 0) goto L_0x0219
            int r10 = com.google.android.gms.internal.ads.zzlp.zzz
            com.google.android.gms.internal.ads.zzlo r10 = r8.zzc(r10)
            com.google.android.gms.internal.ads.zzqc r10 = r10.zza
            r10.zzi(r5)
            int r12 = r10.zzr()
            int r12 = com.google.android.gms.internal.ads.zzlp.zze(r12)
            if (r12 != r7) goto L_0x0215
            long r12 = r10.zzv()
            goto L_0x0219
        L_0x0215:
            long r12 = r10.zzp()
        L_0x0219:
            java.util.List<com.google.android.gms.internal.ads.zzlo> r10 = r8.zzb
            int r14 = r10.size()
            r5 = 0
            r7 = 0
            r15 = 0
        L_0x0222:
            if (r15 >= r14) goto L_0x0254
            java.lang.Object r18 = r10.get(r15)
            r19 = r2
            r2 = r18
            com.google.android.gms.internal.ads.zzlo r2 = (com.google.android.gms.internal.ads.zzlo) r2
            r18 = r4
            int r4 = r2.zzaR
            r20 = r12
            int r12 = com.google.android.gms.internal.ads.zzlp.zzC
            if (r4 != r12) goto L_0x0249
            com.google.android.gms.internal.ads.zzqc r2 = r2.zza
            r4 = 12
            r2.zzi(r4)
            int r2 = r2.zzu()
            if (r2 <= 0) goto L_0x024b
            int r5 = r5 + r2
            int r7 = r7 + 1
            goto L_0x024b
        L_0x0249:
            r4 = 12
        L_0x024b:
            int r15 = r15 + 1
            r4 = r18
            r2 = r19
            r12 = r20
            goto L_0x0222
        L_0x0254:
            r19 = r2
            r18 = r4
            r20 = r12
            r2 = 0
            r4 = 12
            r11.zzg = r2
            r11.zzf = r2
            r11.zze = r2
            com.google.android.gms.internal.ads.zzmj r2 = r11.zza
            r2.zzd = r7
            r2.zze = r5
            int[] r12 = r2.zzg
            if (r12 == 0) goto L_0x0270
            int r12 = r12.length
            if (r12 >= r7) goto L_0x0278
        L_0x0270:
            long[] r12 = new long[r7]
            r2.zzf = r12
            int[] r7 = new int[r7]
            r2.zzg = r7
        L_0x0278:
            int[] r7 = r2.zzh
            if (r7 == 0) goto L_0x027f
            int r7 = r7.length
            if (r7 >= r5) goto L_0x0297
        L_0x027f:
            int r5 = r5 * 125
            int r5 = r5 / 100
            int[] r7 = new int[r5]
            r2.zzh = r7
            int[] r7 = new int[r5]
            r2.zzi = r7
            long[] r7 = new long[r5]
            r2.zzj = r7
            boolean[] r7 = new boolean[r5]
            r2.zzk = r7
            boolean[] r5 = new boolean[r5]
            r2.zzm = r5
        L_0x0297:
            r2 = 0
            r5 = 0
            r7 = 0
        L_0x029a:
            if (r2 >= r14) goto L_0x0406
            java.lang.Object r17 = r10.get(r2)
            r4 = r17
            com.google.android.gms.internal.ads.zzlo r4 = (com.google.android.gms.internal.ads.zzlo) r4
            int r15 = r4.zzaR
            int r12 = com.google.android.gms.internal.ads.zzlp.zzC
            if (r15 != r12) goto L_0x03dc
            int r12 = r7 + 1
            com.google.android.gms.internal.ads.zzqc r4 = r4.zza
            r13 = 8
            r4.zzi(r13)
            int r13 = r4.zzr()
            int r13 = com.google.android.gms.internal.ads.zzlp.zzf(r13)
            com.google.android.gms.internal.ads.zzmh r15 = r11.zzc
            r24 = r10
            com.google.android.gms.internal.ads.zzmj r10 = r11.zza
            r25 = r12
            com.google.android.gms.internal.ads.zzlx r12 = r10.zza
            r26 = r14
            int[] r14 = r10.zzg
            int r27 = r4.zzu()
            r14[r7] = r27
            long[] r14 = r10.zzf
            r27 = r1
            long r0 = r10.zzb
            r14[r7] = r0
            r28 = r13 & 1
            if (r28 == 0) goto L_0x02ea
            r28 = r6
            int r6 = r4.zzr()
            r29 = r8
            r30 = r9
            long r8 = (long) r6
            long r0 = r0 + r8
            r14[r7] = r0
            goto L_0x02f0
        L_0x02ea:
            r28 = r6
            r29 = r8
            r30 = r9
        L_0x02f0:
            r0 = r13 & 4
            int r1 = r12.zzd
            if (r0 == 0) goto L_0x02fa
            int r1 = r4.zzu()
        L_0x02fa:
            r6 = r13 & 256(0x100, float:3.59E-43)
            r8 = r13 & 512(0x200, float:7.175E-43)
            r9 = r13 & 1024(0x400, float:1.435E-42)
            r13 = r13 & 2048(0x800, float:2.87E-42)
            long[] r14 = r15.zzi
            if (r14 == 0) goto L_0x0329
            r31 = r1
            int r1 = r14.length
            r32 = r3
            r3 = 1
            if (r1 != r3) goto L_0x032d
            r1 = 0
            r33 = r14[r1]
            r22 = 0
            int r3 = (r33 > r22 ? 1 : (r33 == r22 ? 0 : -1))
            if (r3 != 0) goto L_0x032d
            long[] r3 = r15.zzj
            r33 = r3[r1]
            r35 = 1000(0x3e8, double:4.94E-321)
            r3 = r2
            long r1 = r15.zzc
            r37 = r1
            long r1 = com.google.android.gms.internal.ads.zzqj.zzj(r33, r35, r37)
            r22 = r1
            goto L_0x0330
        L_0x0329:
            r31 = r1
            r32 = r3
        L_0x032d:
            r3 = r2
            r22 = 0
        L_0x0330:
            int[] r1 = r10.zzh
            int[] r2 = r10.zzi
            long[] r14 = r10.zzj
            r33 = r11
            boolean[] r11 = r10.zzk
            r34 = r3
            int r3 = r15.zzb
            int[] r3 = r10.zzg
            r3 = r3[r7]
            int r3 = r3 + r5
            r41 = r14
            long r14 = r15.zzc
            if (r7 <= 0) goto L_0x0350
            r42 = r1
            r43 = r2
            long r1 = r10.zzr
            goto L_0x0356
        L_0x0350:
            r42 = r1
            r43 = r2
            r1 = r20
        L_0x0356:
            if (r5 >= r3) goto L_0x03d3
            if (r6 == 0) goto L_0x035f
            int r7 = r4.zzu()
            goto L_0x0361
        L_0x035f:
            int r7 = r12.zzb
        L_0x0361:
            if (r8 == 0) goto L_0x036c
            int r35 = r4.zzu()
            r44 = r3
            r3 = r35
            goto L_0x0370
        L_0x036c:
            r44 = r3
            int r3 = r12.zzc
        L_0x0370:
            if (r5 != 0) goto L_0x037b
            if (r0 == 0) goto L_0x037a
            r45 = r0
            r0 = r31
            r5 = 0
            goto L_0x038a
        L_0x037a:
            r5 = 0
        L_0x037b:
            if (r9 == 0) goto L_0x0386
            int r35 = r4.zzr()
            r45 = r0
            r0 = r35
            goto L_0x038a
        L_0x0386:
            r45 = r0
            int r0 = r12.zzd
        L_0x038a:
            if (r13 == 0) goto L_0x039e
            r46 = r6
            int r6 = r4.zzr()
            int r6 = r6 * 1000
            r47 = r8
            r48 = r9
            long r8 = (long) r6
            long r8 = r8 / r14
            int r6 = (int) r8
            r43[r5] = r6
            goto L_0x03a7
        L_0x039e:
            r46 = r6
            r47 = r8
            r48 = r9
            r6 = 0
            r43[r5] = r6
        L_0x03a7:
            r37 = 1000(0x3e8, double:4.94E-321)
            r35 = r1
            r39 = r14
            long r8 = com.google.android.gms.internal.ads.zzqj.zzj(r35, r37, r39)
            long r8 = r8 - r22
            r41[r5] = r8
            r42[r5] = r3
            r3 = 16
            int r0 = r0 >> r3
            r3 = 1
            r0 = r0 & r3
            r0 = r0 ^ r3
            if (r3 == r0) goto L_0x03c1
            r0 = 0
            goto L_0x03c2
        L_0x03c1:
            r0 = 1
        L_0x03c2:
            r11[r5] = r0
            long r6 = (long) r7
            long r1 = r1 + r6
            int r5 = r5 + 1
            r3 = r44
            r0 = r45
            r6 = r46
            r8 = r47
            r9 = r48
            goto L_0x0356
        L_0x03d3:
            r44 = r3
            r10.zzr = r1
            r7 = r25
            r5 = r44
            goto L_0x03ee
        L_0x03dc:
            r27 = r1
            r34 = r2
            r32 = r3
            r28 = r6
            r29 = r8
            r30 = r9
            r24 = r10
            r33 = r11
            r26 = r14
        L_0x03ee:
            int r2 = r34 + 1
            r0 = r49
            r10 = r24
            r14 = r26
            r1 = r27
            r6 = r28
            r8 = r29
            r9 = r30
            r3 = r32
            r11 = r33
            r4 = 12
            goto L_0x029a
        L_0x0406:
            r27 = r1
            r32 = r3
            r28 = r6
            r29 = r8
            r30 = r9
            r33 = r11
            int r0 = com.google.android.gms.internal.ads.zzlp.zzaf
            com.google.android.gms.internal.ads.zzlo r0 = r8.zzc(r0)
            if (r0 == 0) goto L_0x0495
            r11 = r33
            com.google.android.gms.internal.ads.zzmh r1 = r11.zzc
            com.google.android.gms.internal.ads.zzmi[] r1 = r1.zzh
            r2 = r30
            com.google.android.gms.internal.ads.zzlx r3 = r2.zza
            int r3 = r3.zza
            r1 = r1[r3]
            com.google.android.gms.internal.ads.zzqc r0 = r0.zza
            int r1 = r1.zza
            r3 = 8
            r0.zzi(r3)
            int r4 = r0.zzr()
            int r4 = com.google.android.gms.internal.ads.zzlp.zzf(r4)
            r5 = 1
            r4 = r4 & r5
            if (r4 != r5) goto L_0x0440
            r0.zzj(r3)
        L_0x0440:
            int r3 = r0.zzl()
            int r4 = r0.zzu()
            int r5 = r2.zze
            if (r4 != r5) goto L_0x0474
            if (r3 != 0) goto L_0x0463
            boolean[] r3 = r2.zzm
            r5 = 0
            r6 = 0
        L_0x0452:
            if (r5 >= r4) goto L_0x0470
            int r7 = r0.zzl()
            int r6 = r6 + r7
            if (r7 <= r1) goto L_0x045d
            r7 = 1
            goto L_0x045e
        L_0x045d:
            r7 = 0
        L_0x045e:
            r3[r5] = r7
            int r5 = r5 + 1
            goto L_0x0452
        L_0x0463:
            if (r3 <= r1) goto L_0x0467
            r0 = 1
            goto L_0x0468
        L_0x0467:
            r0 = 0
        L_0x0468:
            int r6 = r3 * r4
            boolean[] r1 = r2.zzm
            r3 = 0
            java.util.Arrays.fill(r1, r3, r4, r0)
        L_0x0470:
            r2.zza(r6)
            goto L_0x0497
        L_0x0474:
            com.google.android.gms.internal.ads.zziw r0 = new com.google.android.gms.internal.ads.zziw
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 41
            r1.<init>(r2)
            java.lang.String r2 = "Length mismatch: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = ", "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0495:
            r2 = r30
        L_0x0497:
            int r0 = com.google.android.gms.internal.ads.zzlp.zzag
            com.google.android.gms.internal.ads.zzlo r0 = r8.zzc(r0)
            if (r0 == 0) goto L_0x04e9
            com.google.android.gms.internal.ads.zzqc r0 = r0.zza
            r1 = 8
            r0.zzi(r1)
            int r3 = r0.zzr()
            int r4 = com.google.android.gms.internal.ads.zzlp.zzf(r3)
            r5 = 1
            r4 = r4 & r5
            if (r4 != r5) goto L_0x04b5
            r0.zzj(r1)
        L_0x04b5:
            int r1 = r0.zzu()
            if (r1 != r5) goto L_0x04d0
            long r4 = r2.zzc
            int r1 = com.google.android.gms.internal.ads.zzlp.zze(r3)
            if (r1 != 0) goto L_0x04c8
            long r0 = r0.zzp()
            goto L_0x04cc
        L_0x04c8:
            long r0 = r0.zzv()
        L_0x04cc:
            long r4 = r4 + r0
            r2.zzc = r4
            goto L_0x04e9
        L_0x04d0:
            com.google.android.gms.internal.ads.zziw r0 = new com.google.android.gms.internal.ads.zziw
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 40
            r2.<init>(r3)
            java.lang.String r3 = "Unexpected saio entry count: "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x04e9:
            int r0 = com.google.android.gms.internal.ads.zzlp.zzak
            com.google.android.gms.internal.ads.zzlo r0 = r8.zzc(r0)
            if (r0 == 0) goto L_0x04f7
            com.google.android.gms.internal.ads.zzqc r0 = r0.zza
            r1 = 0
            zzc(r0, r1, r2)
        L_0x04f7:
            int r0 = com.google.android.gms.internal.ads.zzlp.zzah
            com.google.android.gms.internal.ads.zzlo r0 = r8.zzc(r0)
            int r1 = com.google.android.gms.internal.ads.zzlp.zzai
            com.google.android.gms.internal.ads.zzlo r1 = r8.zzc(r1)
            if (r0 == 0) goto L_0x0597
            if (r1 == 0) goto L_0x0597
            com.google.android.gms.internal.ads.zzqc r0 = r0.zza
            com.google.android.gms.internal.ads.zzqc r1 = r1.zza
            r3 = 8
            r0.zzi(r3)
            int r3 = r0.zzr()
            int r4 = r0.zzr()
            int r5 = zzb
            if (r4 == r5) goto L_0x051e
            goto L_0x0597
        L_0x051e:
            int r3 = com.google.android.gms.internal.ads.zzlp.zze(r3)
            r4 = 4
            r6 = 1
            if (r3 != r6) goto L_0x0529
            r0.zzj(r4)
        L_0x0529:
            int r0 = r0.zzr()
            if (r0 != r6) goto L_0x058f
            r0 = 8
            r1.zzi(r0)
            int r0 = r1.zzr()
            int r3 = r1.zzr()
            if (r3 != r5) goto L_0x0597
            int r0 = com.google.android.gms.internal.ads.zzlp.zze(r0)
            r3 = 2
            if (r0 != r6) goto L_0x0558
            long r4 = r1.zzp()
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0550
            goto L_0x055d
        L_0x0550:
            com.google.android.gms.internal.ads.zziw r0 = new com.google.android.gms.internal.ads.zziw
            java.lang.String r1 = "Variable length decription in sgpd found (unsupported)"
            r0.<init>(r1)
            throw r0
        L_0x0558:
            if (r0 < r3) goto L_0x055d
            r1.zzj(r4)
        L_0x055d:
            long r4 = r1.zzp()
            r6 = 1
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0587
            r1.zzj(r3)
            int r0 = r1.zzl()
            r3 = 1
            if (r0 != r3) goto L_0x0598
            int r0 = r1.zzl()
            r4 = 16
            byte[] r5 = new byte[r4]
            r6 = 0
            r1.zzk(r5, r6, r4)
            r2.zzl = r3
            com.google.android.gms.internal.ads.zzmi r1 = new com.google.android.gms.internal.ads.zzmi
            r1.<init>(r3, r0, r5)
            r2.zzn = r1
            goto L_0x0598
        L_0x0587:
            com.google.android.gms.internal.ads.zziw r0 = new com.google.android.gms.internal.ads.zziw
            java.lang.String r1 = "Entry count in sgpd != 1 (unsupported)."
            r0.<init>(r1)
            throw r0
        L_0x058f:
            com.google.android.gms.internal.ads.zziw r0 = new com.google.android.gms.internal.ads.zziw
            java.lang.String r1 = "Entry count in sbgp != 1 (unsupported)."
            r0.<init>(r1)
            throw r0
        L_0x0597:
            r3 = 1
        L_0x0598:
            java.util.List<com.google.android.gms.internal.ads.zzlo> r0 = r8.zzb
            int r0 = r0.size()
            r1 = 0
        L_0x059f:
            if (r1 >= r0) goto L_0x05d6
            java.util.List<com.google.android.gms.internal.ads.zzlo> r4 = r8.zzb
            java.lang.Object r4 = r4.get(r1)
            com.google.android.gms.internal.ads.zzlo r4 = (com.google.android.gms.internal.ads.zzlo) r4
            int r5 = r4.zzaR
            int r6 = com.google.android.gms.internal.ads.zzlp.zzaj
            if (r5 != r6) goto L_0x05ca
            com.google.android.gms.internal.ads.zzqc r4 = r4.zza
            r5 = 8
            r4.zzi(r5)
            r6 = r32
            r7 = 16
            r9 = 0
            r4.zzk(r6, r9, r7)
            byte[] r10 = zzc
            boolean r10 = java.util.Arrays.equals(r6, r10)
            if (r10 == 0) goto L_0x05d1
            zzc(r4, r7, r2)
            goto L_0x05d1
        L_0x05ca:
            r6 = r32
            r5 = 8
            r7 = 16
            r9 = 0
        L_0x05d1:
            int r1 = r1 + 1
            r32 = r6
            goto L_0x059f
        L_0x05d6:
            r6 = r32
            r5 = 8
            r9 = 0
            goto L_0x05e7
        L_0x05dc:
            r27 = r1
            r19 = r2
            r18 = r4
            r28 = r6
            r9 = 0
            r6 = r3
            r3 = 1
        L_0x05e7:
            int r0 = r28 + 1
            r3 = r6
            r4 = r18
            r2 = r19
            r1 = r27
            r7 = 1
            r6 = r0
            r0 = r49
            goto L_0x0170
        L_0x05f6:
            r9 = 0
            java.util.List<com.google.android.gms.internal.ads.zzlo> r0 = r1.zzb
            com.google.android.gms.internal.ads.zzkq r0 = zzh(r0)
            if (r0 == 0) goto L_0x0000
            r2 = r49
            android.util.SparseArray<com.google.android.gms.internal.ads.zzma> r1 = r2.zzd
            int r1 = r1.size()
            r6 = 0
        L_0x0608:
            if (r6 >= r1) goto L_0x0636
            android.util.SparseArray<com.google.android.gms.internal.ads.zzma> r3 = r2.zzd
            java.lang.Object r3 = r3.valueAt(r6)
            com.google.android.gms.internal.ads.zzma r3 = (com.google.android.gms.internal.ads.zzma) r3
            com.google.android.gms.internal.ads.zzld r4 = r3.zzb
            com.google.android.gms.internal.ads.zzmh r3 = r3.zzc
            com.google.android.gms.internal.ads.zzit r3 = r3.zzf
            com.google.android.gms.internal.ads.zzit r3 = r3.zzi(r0)
            r4.zza(r3)
            int r6 = r6 + 1
            goto L_0x0608
        L_0x0622:
            r2 = r0
            java.util.Stack<com.google.android.gms.internal.ads.zzln> r0 = r2.zzk
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0636
            java.util.Stack<com.google.android.gms.internal.ads.zzln> r0 = r2.zzk
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.zzln r0 = (com.google.android.gms.internal.ads.zzln) r0
            r0.zzb(r1)
        L_0x0636:
            r0 = r2
            goto L_0x0002
        L_0x0639:
            r2 = r0
            r49.zza()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmb.zzb(long):void");
    }

    private static void zzc(zzqc zzqc, int i, zzmj zzmj) throws zziw {
        zzqc.zzi(i + 8);
        int zzf2 = zzlp.zzf(zzqc.zzr());
        if ((zzf2 & 1) == 0) {
            boolean z = (zzf2 & 2) != 0;
            int zzu2 = zzqc.zzu();
            int i2 = zzmj.zze;
            if (zzu2 == i2) {
                Arrays.fill(zzmj.zzm, 0, zzu2, z);
                zzmj.zza(zzqc.zzd());
                zzqc.zzk(zzmj.zzp.zza, 0, zzmj.zzo);
                zzmj.zzp.zzi(0);
                zzmj.zzq = false;
                return;
            }
            StringBuilder sb = new StringBuilder(41);
            sb.append("Length mismatch: ");
            sb.append(zzu2);
            sb.append(", ");
            sb.append(i2);
            throw new zziw(sb.toString());
        }
        throw new zziw("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzkq zzh(java.util.List<com.google.android.gms.internal.ads.zzlo> r14) {
        /*
            int r0 = r14.size()
            r1 = 0
            r2 = 0
            r4 = r2
            r3 = 0
        L_0x0008:
            if (r3 >= r0) goto L_0x00b9
            java.lang.Object r5 = r14.get(r3)
            com.google.android.gms.internal.ads.zzlo r5 = (com.google.android.gms.internal.ads.zzlo) r5
            int r6 = r5.zzaR
            int r7 = com.google.android.gms.internal.ads.zzlp.zzX
            if (r6 != r7) goto L_0x00b5
            if (r4 != 0) goto L_0x001d
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x001d:
            com.google.android.gms.internal.ads.zzqc r5 = r5.zza
            byte[] r5 = r5.zza
            com.google.android.gms.internal.ads.zzqc r6 = new com.google.android.gms.internal.ads.zzqc
            r6.<init>((byte[]) r5)
            int r7 = r6.zze()
            r8 = 32
            if (r7 >= r8) goto L_0x0030
        L_0x002e:
            r6 = r2
            goto L_0x0099
        L_0x0030:
            r6.zzi(r1)
            int r7 = r6.zzr()
            int r8 = r6.zzd()
            int r8 = r8 + 4
            if (r7 == r8) goto L_0x0040
            goto L_0x002e
        L_0x0040:
            int r7 = r6.zzr()
            int r8 = com.google.android.gms.internal.ads.zzlp.zzX
            if (r7 == r8) goto L_0x0049
            goto L_0x002e
        L_0x0049:
            int r7 = r6.zzr()
            int r7 = com.google.android.gms.internal.ads.zzlp.zze(r7)
            r8 = 1
            if (r7 <= r8) goto L_0x006d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r8 = 37
            r6.<init>(r8)
            java.lang.String r8 = "Unsupported pssh version: "
            r6.append(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "PsshAtomUtil"
            android.util.Log.w(r7, r6)
            goto L_0x002e
        L_0x006d:
            java.util.UUID r9 = new java.util.UUID
            long r10 = r6.zzs()
            long r12 = r6.zzs()
            r9.<init>(r10, r12)
            if (r7 != r8) goto L_0x0085
            int r7 = r6.zzu()
            int r7 = r7 * 16
            r6.zzj(r7)
        L_0x0085:
            int r7 = r6.zzu()
            int r8 = r6.zzd()
            if (r7 == r8) goto L_0x0090
            goto L_0x002e
        L_0x0090:
            byte[] r8 = new byte[r7]
            r6.zzk(r8, r1, r7)
            android.util.Pair r6 = android.util.Pair.create(r9, r8)
        L_0x0099:
            if (r6 != 0) goto L_0x009d
            r6 = r2
            goto L_0x00a1
        L_0x009d:
            java.lang.Object r6 = r6.first
            java.util.UUID r6 = (java.util.UUID) r6
        L_0x00a1:
            if (r6 != 0) goto L_0x00ab
            java.lang.String r5 = "FragmentedMp4Extractor"
            java.lang.String r6 = "Skipped pssh atom (failed to extract uuid)"
            android.util.Log.w(r5, r6)
            goto L_0x00b5
        L_0x00ab:
            com.google.android.gms.internal.ads.zzkp r7 = new com.google.android.gms.internal.ads.zzkp
            java.lang.String r8 = "video/mp4"
            r7.<init>(r6, r8, r5, r1)
            r4.add(r7)
        L_0x00b5:
            int r3 = r3 + 1
            goto L_0x0008
        L_0x00b9:
            if (r4 != 0) goto L_0x00bc
            return r2
        L_0x00bc:
            com.google.android.gms.internal.ads.zzkq r14 = new com.google.android.gms.internal.ads.zzkq
            r14.<init>((java.util.List<com.google.android.gms.internal.ads.zzkp>) r4)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmb.zzh(java.util.List):com.google.android.gms.internal.ads.zzkq");
    }

    public final void zzd(zzkv zzkv) {
        this.zzx = zzkv;
    }

    public final void zze(long j, long j2) {
        int size = this.zzd.size();
        for (int i = 0; i < size; i++) {
            this.zzd.valueAt(i).zzb();
        }
        this.zzl.clear();
        this.zzk.clear();
        zza();
    }

    public final boolean zzf(zzkt zzkt) throws IOException, InterruptedException {
        return zzmg.zza(zzkt);
    }

    public final int zzg(zzkt zzkt, zzkz zzkz) throws IOException, InterruptedException {
        long j;
        long j2;
        zzlc zzlc;
        zzmi zzmi;
        zzlc zzlc2;
        int i;
        zzkt zzkt2 = zzkt;
        while (true) {
            int i2 = this.zzm;
            int i3 = 0;
            if (i2 == 0) {
                if (this.zzp == 0) {
                    if (!zzkt2.zzb(this.zzi.zza, 0, 8, true)) {
                        return -1;
                    }
                    this.zzp = 8;
                    this.zzi.zzi(0);
                    this.zzo = this.zzi.zzp();
                    this.zzn = this.zzi.zzr();
                }
                long j3 = this.zzo;
                if (j3 == 1) {
                    zzkt2.zzb(this.zzi.zza, 8, 8, false);
                    this.zzp += 8;
                    j3 = this.zzi.zzv();
                    this.zzo = j3;
                }
                if (j3 >= ((long) this.zzp)) {
                    long zzh2 = zzkt.zzh() - ((long) this.zzp);
                    if (this.zzn == zzlp.zzN) {
                        int size = this.zzd.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            zzmj zzmj = this.zzd.valueAt(i4).zza;
                            zzmj.zzc = zzh2;
                            zzmj.zzb = zzh2;
                        }
                    }
                    if (this.zzn == zzlp.zzk) {
                        this.zzt = null;
                        this.zzr = zzh2 + this.zzo;
                        if (!this.zzy) {
                            this.zzx.zzc(new zzla(this.zzs));
                            this.zzy = true;
                        }
                        this.zzm = 2;
                    } else {
                        int i5 = this.zzn;
                        if (i5 == zzlp.zzE || i5 == zzlp.zzG || i5 == zzlp.zzH || i5 == zzlp.zzI || i5 == zzlp.zzJ || i5 == zzlp.zzN || i5 == zzlp.zzO || i5 == zzlp.zzP || i5 == zzlp.zzS) {
                            long zzh3 = (zzkt.zzh() + this.zzo) - 8;
                            this.zzk.add(new zzln(this.zzn, zzh3));
                            if (this.zzo == ((long) this.zzp)) {
                                zzb(zzh3);
                            } else {
                                zza();
                            }
                        } else {
                            int i6 = this.zzn;
                            if (i6 == zzlp.zzV || i6 == zzlp.zzU || i6 == zzlp.zzF || i6 == zzlp.zzD || i6 == zzlp.zzW || i6 == zzlp.zzz || i6 == zzlp.zzA || i6 == zzlp.zzR || i6 == zzlp.zzB || i6 == zzlp.zzC || i6 == zzlp.zzX || i6 == zzlp.zzaf || i6 == zzlp.zzag || i6 == zzlp.zzak || i6 == zzlp.zzaj || i6 == zzlp.zzah || i6 == zzlp.zzai || i6 == zzlp.zzT || i6 == zzlp.zzQ || i6 == zzlp.zzaI) {
                                if (this.zzp == 8) {
                                    long j4 = this.zzo;
                                    if (j4 <= 2147483647L) {
                                        this.zzq = new zzqc((int) j4);
                                        System.arraycopy(this.zzi.zza, 0, this.zzq.zza, 0, 8);
                                        this.zzm = 1;
                                    } else {
                                        throw new zziw("Leaf atom with length > 2147483647 (unsupported).");
                                    }
                                } else {
                                    throw new zziw("Leaf atom defines extended atom size (unsupported).");
                                }
                            } else if (this.zzo <= 2147483647L) {
                                this.zzq = null;
                                this.zzm = 1;
                            } else {
                                throw new zziw("Skipping atom with length > 2147483647 (unsupported).");
                            }
                        }
                    }
                } else {
                    throw new zziw("Atom size less than header length (unsupported).");
                }
            } else if (i2 != 1) {
                long j5 = LongCompanionObject.MAX_VALUE;
                if (i2 != 2) {
                    if (i2 == 3) {
                        if (this.zzt != null) {
                            break;
                        }
                        SparseArray<zzma> sparseArray = this.zzd;
                        int size2 = sparseArray.size();
                        zzma zzma = null;
                        for (int i7 = 0; i7 < size2; i7++) {
                            zzma valueAt = sparseArray.valueAt(i7);
                            int i8 = valueAt.zzg;
                            zzmj zzmj2 = valueAt.zza;
                            if (i8 != zzmj2.zzd) {
                                long j6 = zzmj2.zzf[i8];
                                if (j6 < j5) {
                                    zzma = valueAt;
                                    j5 = j6;
                                }
                            }
                        }
                        if (zzma == null) {
                            int zzh4 = (int) (this.zzr - zzkt.zzh());
                            if (zzh4 >= 0) {
                                zzkt2.zzd(zzh4, false);
                                zza();
                            } else {
                                throw new zziw("Offset to end of mdat was negative.");
                            }
                        } else {
                            int zzh5 = (int) (zzma.zza.zzf[zzma.zzg] - zzkt.zzh());
                            if (zzh5 < 0) {
                                Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                                zzh5 = 0;
                            }
                            zzkt2.zzd(zzh5, false);
                            this.zzt = zzma;
                        }
                    } else {
                        break;
                    }
                } else {
                    int size3 = this.zzd.size();
                    zzma zzma2 = null;
                    for (int i9 = 0; i9 < size3; i9++) {
                        zzmj zzmj3 = this.zzd.valueAt(i9).zza;
                        if (zzmj3.zzq) {
                            long j7 = zzmj3.zzc;
                            if (j7 < j5) {
                                zzma2 = this.zzd.valueAt(i9);
                                j5 = j7;
                            }
                        }
                    }
                    if (zzma2 == null) {
                        this.zzm = 3;
                    } else {
                        int zzh6 = (int) (j5 - zzkt.zzh());
                        if (zzh6 >= 0) {
                            zzkt2.zzd(zzh6, false);
                            zzmj zzmj4 = zzma2.zza;
                            zzkt2.zzb(zzmj4.zzp.zza, 0, zzmj4.zzo, false);
                            zzmj4.zzp.zzi(0);
                            zzmj4.zzq = false;
                        } else {
                            throw new zziw("Offset to encryption data was negative.");
                        }
                    }
                }
            } else {
                int i10 = ((int) this.zzo) - this.zzp;
                zzqc zzqc = this.zzq;
                if (zzqc != null) {
                    zzkt2.zzb(zzqc.zza, 8, i10, false);
                    zzlo zzlo = new zzlo(this.zzn, this.zzq);
                    long zzh7 = zzkt.zzh();
                    if (!this.zzk.isEmpty()) {
                        this.zzk.peek().zza(zzlo);
                    } else {
                        if (zzlo.zzaR == zzlp.zzD) {
                            zzqc zzqc2 = zzlo.zza;
                            zzqc2.zzi(8);
                            int zzr2 = zzqc2.zzr();
                            zzqc2.zzj(4);
                            long zzp2 = zzqc2.zzp();
                            if (zzlp.zze(zzr2) == 0) {
                                j2 = zzqc2.zzp();
                                j = zzqc2.zzp();
                            } else {
                                j2 = zzqc2.zzv();
                                j = zzqc2.zzv();
                            }
                            long j8 = zzh7 + j;
                            long j9 = j2;
                            long zzj2 = zzqj.zzj(j9, 1000000, zzp2);
                            zzqc2.zzj(2);
                            int zzm2 = zzqc2.zzm();
                            int[] iArr = new int[zzm2];
                            long[] jArr = new long[zzm2];
                            long[] jArr2 = new long[zzm2];
                            long[] jArr3 = new long[zzm2];
                            long j10 = zzj2;
                            while (i3 < zzm2) {
                                int zzr3 = zzqc2.zzr();
                                if ((zzr3 & Integer.MIN_VALUE) == 0) {
                                    long zzp3 = zzqc2.zzp();
                                    iArr[i3] = zzr3 & Integer.MAX_VALUE;
                                    jArr[i3] = j8;
                                    jArr3[i3] = j10;
                                    j9 += zzp3;
                                    int i11 = zzm2;
                                    long[] jArr4 = jArr2;
                                    long[] jArr5 = jArr3;
                                    j10 = zzqj.zzj(j9, 1000000, zzp2);
                                    jArr4[i3] = j10 - jArr5[i3];
                                    zzqc2.zzj(4);
                                    j8 += (long) iArr[i3];
                                    i3++;
                                    jArr = jArr;
                                    jArr3 = jArr5;
                                    jArr2 = jArr4;
                                    zzm2 = i11;
                                    zzkt zzkt3 = zzkt;
                                } else {
                                    throw new zziw("Unhandled indirect reference");
                                }
                            }
                            Pair create = Pair.create(Long.valueOf(zzj2), new zzks(iArr, jArr, jArr2, jArr3));
                            ((Long) create.first).longValue();
                            this.zzx.zzc((zzlb) create.second);
                            this.zzy = true;
                        }
                        zzkt2 = zzkt;
                    }
                } else {
                    zzkt2.zzd(i10, false);
                }
                zzb(zzkt.zzh());
            }
        }
        zzma zzma3 = this.zzt;
        zzmj zzmj5 = zzma3.zza;
        int[] iArr2 = zzmj5.zzh;
        int i12 = zzma3.zze;
        int i13 = iArr2[i12];
        this.zzu = i13;
        if (zzmj5.zzl) {
            zzqc zzqc3 = zzmj5.zzp;
            int i14 = zzmj5.zza.zza;
            zzmi zzmi2 = zzmj5.zzn;
            if (zzmi2 == null) {
                zzmi2 = zzma3.zzc.zzh[i14];
            }
            int i15 = zzmi2.zza;
            boolean z = zzmj5.zzm[i12];
            zzqc zzqc4 = this.zzh;
            zzqc4.zza[0] = (byte) ((true != z ? 0 : 128) | i15);
            zzqc4.zzi(0);
            zzld zzld = zzma3.zzb;
            zzld.zzb(this.zzh, 1);
            zzld.zzb(zzqc3, i15);
            if (!z) {
                i = i15 + 1;
            } else {
                int zzm3 = zzqc3.zzm();
                zzqc3.zzj(-2);
                int i16 = (zzm3 * 6) + 2;
                zzld.zzb(zzqc3, i16);
                i = i15 + 1 + i16;
            }
            this.zzv = i;
            i13 = this.zzu + i;
            this.zzu = i13;
        } else {
            this.zzv = 0;
        }
        if (this.zzt.zzc.zzg == 1) {
            this.zzu = i13 - 8;
            zzkt2.zzd(8, false);
        }
        this.zzm = 4;
        this.zzw = 0;
        zzma zzma4 = this.zzt;
        zzmj zzmj6 = zzma4.zza;
        zzmh zzmh = zzma4.zzc;
        zzld zzld2 = zzma4.zzb;
        int i17 = zzma4.zze;
        int i18 = zzmh.zzk;
        if (i18 == 0) {
            while (true) {
                int i19 = this.zzv;
                int i20 = this.zzu;
                if (i19 >= i20) {
                    break;
                }
                this.zzv += zzld2.zzd(zzkt2, i20 - i19, false);
            }
        } else {
            byte[] bArr = this.zzf.zza;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i21 = i18 + 1;
            int i22 = 4 - i18;
            while (this.zzv < this.zzu) {
                int i23 = this.zzw;
                if (i23 == 0) {
                    zzkt2.zzb(bArr, i22, i21, false);
                    this.zzf.zzi(0);
                    this.zzw = this.zzf.zzu() - 1;
                    this.zze.zzi(0);
                    zzld2.zzb(this.zze, 4);
                    zzld2.zzb(this.zzf, 1);
                    this.zzv += 5;
                    this.zzu += i22;
                } else {
                    int zzd2 = zzld2.zzd(zzkt2, i23, false);
                    this.zzv += zzd2;
                    this.zzw -= zzd2;
                }
            }
        }
        long j11 = (zzmj6.zzj[i17] + ((long) zzmj6.zzi[i17])) * 1000;
        boolean z2 = zzmj6.zzl;
        boolean z3 = (true != z2 ? 0 : CharCompanionObject.MIN_VALUE) | zzmj6.zzk[i17];
        if (z2) {
            zzmi = zzmj6.zzn;
            if (zzmi == null) {
                zzmi = zzmh.zzh[zzmj6.zza.zza];
            }
            zzma zzma5 = this.zzt;
            if (zzmi != zzma5.zzi) {
                zzlc2 = new zzlc(1, zzmi.zzb);
            } else {
                zzlc2 = zzma5.zzh;
            }
            zzlc = zzlc2;
        } else {
            zzmi = null;
            zzlc = null;
        }
        zzma zzma6 = this.zzt;
        zzma6.zzh = zzlc;
        zzma6.zzi = zzmi;
        zzld2.zzc(j11, z3 ? 1 : 0, this.zzu, 0, zzlc);
        if (this.zzl.isEmpty()) {
            zzma zzma7 = this.zzt;
            zzma7.zze++;
            int i24 = zzma7.zzf + 1;
            zzma7.zzf = i24;
            int[] iArr3 = zzmj6.zzg;
            int i25 = zzma7.zzg;
            if (i24 == iArr3[i25]) {
                zzma7.zzg = i25 + 1;
                zzma7.zzf = 0;
                this.zzt = null;
            }
            this.zzm = 3;
            return 0;
        }
        zzlz removeFirst = this.zzl.removeFirst();
        int i26 = removeFirst.zzb;
        long j12 = removeFirst.zza;
        throw null;
    }

    public zzmb(int i, zzqg zzqg, zzmh zzmh) {
        this.zzi = new zzqc(16);
        this.zze = new zzqc(zzqa.zza);
        this.zzf = new zzqc(5);
        this.zzg = new zzqc();
        this.zzh = new zzqc(1);
        this.zzj = new byte[16];
        this.zzk = new Stack<>();
        this.zzl = new LinkedList<>();
        this.zzd = new SparseArray<>();
        this.zzs = -9223372036854775807L;
        zza();
    }
}
