package com.google.android.gms.internal.vision;

import com.itextpdf.xmp.options.PropertyOptions;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzko<T> implements zzlc<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzma.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzkk zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzks zzo;
    private final zzju zzp;
    private final zzlu<?, ?> zzq;
    private final zziq<?> zzr;
    private final zzkh zzs;

    private zzko(int[] iArr, Object[] objArr, int i, int i2, zzkk zzkk, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzks zzks, zzju zzju, zzlu<?, ?> zzlu, zziq<?> zziq, zzkh zzkh) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzkk instanceof zzjb;
        this.zzj = z;
        this.zzh = zziq != null && zziq.zza(zzkk);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzks;
        this.zzp = zzju;
        this.zzq = zzlu;
        this.zzr = zziq;
        this.zzg = zzkk;
        this.zzs = zzkh;
    }

    private static boolean zzf(int i) {
        return (i & PropertyOptions.DELETE_EXISTING) != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:159:0x033e  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x038c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.vision.zzko<T> zza(java.lang.Class<T> r33, com.google.android.gms.internal.vision.zzki r34, com.google.android.gms.internal.vision.zzks r35, com.google.android.gms.internal.vision.zzju r36, com.google.android.gms.internal.vision.zzlu<?, ?> r37, com.google.android.gms.internal.vision.zziq<?> r38, com.google.android.gms.internal.vision.zzkh r39) {
        /*
            r0 = r34
            boolean r1 = r0 instanceof com.google.android.gms.internal.vision.zzla
            if (r1 == 0) goto L_0x040f
            com.google.android.gms.internal.vision.zzla r0 = (com.google.android.gms.internal.vision.zzla) r0
            int r1 = r0.zza()
            int r2 = com.google.android.gms.internal.vision.zzkz.zzb
            r3 = 0
            r4 = 1
            if (r1 != r2) goto L_0x0014
            r11 = 1
            goto L_0x0015
        L_0x0014:
            r11 = 0
        L_0x0015:
            java.lang.String r1 = r0.zzd()
            int r2 = r1.length()
            char r5 = r1.charAt(r3)
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r6) goto L_0x0031
            r5 = 1
        L_0x0027:
            int r7 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x0032
            r5 = r7
            goto L_0x0027
        L_0x0031:
            r7 = 1
        L_0x0032:
            int r5 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x0051
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x003e:
            int r10 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x004e
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r9
            r7 = r7 | r5
            int r9 = r9 + 13
            r5 = r10
            goto L_0x003e
        L_0x004e:
            int r5 = r5 << r9
            r7 = r7 | r5
            r5 = r10
        L_0x0051:
            if (r7 != 0) goto L_0x005e
            int[] r7 = zza
            r14 = r7
            r7 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            goto L_0x016f
        L_0x005e:
            int r7 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x007d
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x006a:
            int r10 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x007a
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r5 = r5 | r7
            int r9 = r9 + 13
            r7 = r10
            goto L_0x006a
        L_0x007a:
            int r7 = r7 << r9
            r5 = r5 | r7
            r7 = r10
        L_0x007d:
            int r9 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x009c
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0089:
            int r12 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r6) goto L_0x0099
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r10
            r7 = r7 | r9
            int r10 = r10 + 13
            r9 = r12
            goto L_0x0089
        L_0x0099:
            int r9 = r9 << r10
            r7 = r7 | r9
            r9 = r12
        L_0x009c:
            int r10 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r6) goto L_0x00bb
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00a8:
            int r13 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r6) goto L_0x00b8
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r12
            r9 = r9 | r10
            int r12 = r12 + 13
            r10 = r13
            goto L_0x00a8
        L_0x00b8:
            int r10 = r10 << r12
            r9 = r9 | r10
            r10 = r13
        L_0x00bb:
            int r12 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r6) goto L_0x00da
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00c7:
            int r14 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r6) goto L_0x00d7
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r10 = r10 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00c7
        L_0x00d7:
            int r12 = r12 << r13
            r10 = r10 | r12
            r12 = r14
        L_0x00da:
            int r13 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r6) goto L_0x00f9
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00e6:
            int r15 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r6) goto L_0x00f6
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00e6
        L_0x00f6:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x00f9:
            int r14 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r6) goto L_0x011a
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0105:
            int r16 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r6) goto L_0x0116
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x0105
        L_0x0116:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x011a:
            int r15 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r6) goto L_0x013d
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0126:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x0138
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x0126
        L_0x0138:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x013d:
            int r16 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x0162
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r3 = r16
            r16 = 13
        L_0x014b:
            int r17 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r6) goto L_0x015d
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r16
            r15 = r15 | r3
            int r16 = r16 + 13
            r3 = r17
            goto L_0x014b
        L_0x015d:
            int r3 = r3 << r16
            r15 = r15 | r3
            r16 = r17
        L_0x0162:
            int r3 = r15 + r13
            int r3 = r3 + r14
            int[] r3 = new int[r3]
            int r14 = r5 << 1
            int r14 = r14 + r7
            r7 = r14
            r14 = r3
            r3 = r5
            r5 = r16
        L_0x016f:
            sun.misc.Unsafe r8 = zzb
            java.lang.Object[] r16 = r0.zze()
            com.google.android.gms.internal.vision.zzkk r17 = r0.zzc()
            java.lang.Class r6 = r17.getClass()
            r17 = r5
            int r5 = r12 * 3
            int[] r5 = new int[r5]
            int r12 = r12 << r4
            java.lang.Object[] r12 = new java.lang.Object[r12]
            int r19 = r15 + r13
            r13 = r7
            r21 = r15
            r7 = r17
            r22 = r19
            r17 = 0
            r20 = 0
        L_0x0193:
            if (r7 >= r2) goto L_0x03e3
            int r23 = r7 + 1
            char r7 = r1.charAt(r7)
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r7 < r4) goto L_0x01c5
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r4 = r23
            r23 = 13
        L_0x01a6:
            int r25 = r4 + 1
            char r4 = r1.charAt(r4)
            r26 = r2
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r2) goto L_0x01bf
            r2 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r23
            r7 = r7 | r2
            int r23 = r23 + 13
            r4 = r25
            r2 = r26
            goto L_0x01a6
        L_0x01bf:
            int r2 = r4 << r23
            r7 = r7 | r2
            r2 = r25
            goto L_0x01c9
        L_0x01c5:
            r26 = r2
            r2 = r23
        L_0x01c9:
            int r4 = r2 + 1
            char r2 = r1.charAt(r2)
            r23 = r4
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r4) goto L_0x01fb
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r4 = r23
            r23 = 13
        L_0x01dc:
            int r25 = r4 + 1
            char r4 = r1.charAt(r4)
            r27 = r15
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r15) goto L_0x01f5
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r23
            r2 = r2 | r4
            int r23 = r23 + 13
            r4 = r25
            r15 = r27
            goto L_0x01dc
        L_0x01f5:
            int r4 = r4 << r23
            r2 = r2 | r4
            r4 = r25
            goto L_0x01ff
        L_0x01fb:
            r27 = r15
            r4 = r23
        L_0x01ff:
            r15 = r2 & 255(0xff, float:3.57E-43)
            r23 = r10
            r10 = r2 & 1024(0x400, float:1.435E-42)
            if (r10 == 0) goto L_0x020d
            int r10 = r17 + 1
            r14[r17] = r20
            r17 = r10
        L_0x020d:
            r10 = 51
            r29 = r9
            if (r15 < r10) goto L_0x02aa
            int r10 = r4 + 1
            char r4 = r1.charAt(r4)
            r9 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r9) goto L_0x023c
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r31 = 13
        L_0x0222:
            int r32 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r9) goto L_0x0237
            r9 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r31
            r4 = r4 | r9
            int r31 = r31 + 13
            r10 = r32
            r9 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0222
        L_0x0237:
            int r9 = r10 << r31
            r4 = r4 | r9
            r10 = r32
        L_0x023c:
            int r9 = r15 + -51
            r31 = r10
            r10 = 9
            if (r9 == r10) goto L_0x025d
            r10 = 17
            if (r9 != r10) goto L_0x0249
            goto L_0x025d
        L_0x0249:
            r10 = 12
            if (r9 != r10) goto L_0x025b
            if (r11 != 0) goto L_0x025b
            int r9 = r20 / 3
            r10 = 1
            int r9 = r9 << r10
            int r9 = r9 + r10
            int r10 = r13 + 1
            r13 = r16[r13]
            r12[r9] = r13
            r13 = r10
        L_0x025b:
            r10 = 1
            goto L_0x026a
        L_0x025d:
            int r9 = r20 / 3
            r10 = 1
            int r9 = r9 << r10
            int r9 = r9 + r10
            int r24 = r13 + 1
            r13 = r16[r13]
            r12[r9] = r13
            r13 = r24
        L_0x026a:
            int r4 = r4 << r10
            r9 = r16[r4]
            boolean r10 = r9 instanceof java.lang.reflect.Field
            if (r10 == 0) goto L_0x0274
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            goto L_0x027c
        L_0x0274:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = zza((java.lang.Class<?>) r6, (java.lang.String) r9)
            r16[r4] = r9
        L_0x027c:
            long r9 = r8.objectFieldOffset(r9)
            int r10 = (int) r9
            int r4 = r4 + 1
            r9 = r16[r4]
            r25 = r10
            boolean r10 = r9 instanceof java.lang.reflect.Field
            if (r10 == 0) goto L_0x028e
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            goto L_0x0296
        L_0x028e:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = zza((java.lang.Class<?>) r6, (java.lang.String) r9)
            r16[r4] = r9
        L_0x0296:
            long r9 = r8.objectFieldOffset(r9)
            int r4 = (int) r9
            r30 = r1
            r9 = r4
            r1 = r11
            r24 = r12
            r10 = r25
            r11 = r31
            r4 = 0
            r18 = 1
            goto L_0x03a8
        L_0x02aa:
            int r9 = r13 + 1
            r10 = r16[r13]
            java.lang.String r10 = (java.lang.String) r10
            java.lang.reflect.Field r10 = zza((java.lang.Class<?>) r6, (java.lang.String) r10)
            r13 = 9
            if (r15 == r13) goto L_0x031e
            r13 = 17
            if (r15 != r13) goto L_0x02bd
            goto L_0x031e
        L_0x02bd:
            r13 = 27
            if (r15 == r13) goto L_0x030d
            r13 = 49
            if (r15 != r13) goto L_0x02c6
            goto L_0x030d
        L_0x02c6:
            r13 = 12
            if (r15 == r13) goto L_0x02f9
            r13 = 30
            if (r15 == r13) goto L_0x02f9
            r13 = 44
            if (r15 != r13) goto L_0x02d3
            goto L_0x02f9
        L_0x02d3:
            r13 = 50
            if (r15 != r13) goto L_0x032c
            int r13 = r21 + 1
            r14[r21] = r20
            int r21 = r20 / 3
            r24 = 1
            int r21 = r21 << 1
            int r25 = r9 + 1
            r9 = r16[r9]
            r12[r21] = r9
            r9 = r2 & 2048(0x800, float:2.87E-42)
            if (r9 == 0) goto L_0x02f6
            int r21 = r21 + 1
            int r9 = r25 + 1
            r25 = r16[r25]
            r12[r21] = r25
            r21 = r13
            goto L_0x032c
        L_0x02f6:
            r21 = r13
            goto L_0x031b
        L_0x02f9:
            if (r11 != 0) goto L_0x030a
            int r13 = r20 / 3
            r24 = 1
            int r13 = r13 << 1
            int r13 = r13 + 1
            int r25 = r9 + 1
            r9 = r16[r9]
            r12[r13] = r9
            goto L_0x031b
        L_0x030a:
            r24 = 1
            goto L_0x032c
        L_0x030d:
            r24 = 1
            int r13 = r20 / 3
            int r13 = r13 << 1
            int r13 = r13 + 1
            int r25 = r9 + 1
            r9 = r16[r9]
            r12[r13] = r9
        L_0x031b:
            r13 = r25
            goto L_0x032d
        L_0x031e:
            r24 = 1
            int r13 = r20 / 3
            int r13 = r13 << 1
            int r13 = r13 + 1
            java.lang.Class r25 = r10.getType()
            r12[r13] = r25
        L_0x032c:
            r13 = r9
        L_0x032d:
            long r9 = r8.objectFieldOffset(r10)
            int r10 = (int) r9
            r9 = r2 & 4096(0x1000, float:5.74E-42)
            r25 = r13
            r13 = 4096(0x1000, float:5.74E-42)
            if (r9 != r13) goto L_0x038c
            r9 = 17
            if (r15 > r9) goto L_0x038c
            int r9 = r4 + 1
            char r4 = r1.charAt(r4)
            r13 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r13) goto L_0x0364
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r18 = 13
        L_0x034d:
            int r28 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r13) goto L_0x035f
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r18
            r4 = r4 | r9
            int r18 = r18 + 13
            r9 = r28
            goto L_0x034d
        L_0x035f:
            int r9 = r9 << r18
            r4 = r4 | r9
            r9 = r28
        L_0x0364:
            r18 = 1
            int r24 = r3 << 1
            int r28 = r4 / 32
            int r24 = r24 + r28
            r13 = r16[r24]
            r30 = r1
            boolean r1 = r13 instanceof java.lang.reflect.Field
            if (r1 == 0) goto L_0x0377
            java.lang.reflect.Field r13 = (java.lang.reflect.Field) r13
            goto L_0x037f
        L_0x0377:
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = zza((java.lang.Class<?>) r6, (java.lang.String) r13)
            r16[r24] = r13
        L_0x037f:
            r1 = r11
            r24 = r12
            long r11 = r8.objectFieldOffset(r13)
            int r12 = (int) r11
            int r4 = r4 % 32
            r11 = r9
            r9 = r12
            goto L_0x0398
        L_0x038c:
            r30 = r1
            r1 = r11
            r24 = r12
            r18 = 1
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r11 = r4
            r4 = 0
        L_0x0398:
            r12 = 18
            if (r15 < r12) goto L_0x03a6
            r12 = 49
            if (r15 > r12) goto L_0x03a6
            int r12 = r22 + 1
            r14[r22] = r10
            r22 = r12
        L_0x03a6:
            r13 = r25
        L_0x03a8:
            int r12 = r20 + 1
            r5[r20] = r7
            int r7 = r12 + 1
            r20 = r3
            r3 = r2 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x03b7
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03b8
        L_0x03b7:
            r3 = 0
        L_0x03b8:
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x03bf
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03c0
        L_0x03bf:
            r2 = 0
        L_0x03c0:
            r2 = r2 | r3
            int r3 = r15 << 20
            r2 = r2 | r3
            r2 = r2 | r10
            r5[r12] = r2
            int r2 = r7 + 1
            int r3 = r4 << 20
            r3 = r3 | r9
            r5[r7] = r3
            r7 = r11
            r3 = r20
            r10 = r23
            r12 = r24
            r15 = r27
            r9 = r29
            r4 = 1
            r11 = r1
            r20 = r2
            r2 = r26
            r1 = r30
            goto L_0x0193
        L_0x03e3:
            r29 = r9
            r23 = r10
            r1 = r11
            r24 = r12
            r27 = r15
            com.google.android.gms.internal.vision.zzko r2 = new com.google.android.gms.internal.vision.zzko
            com.google.android.gms.internal.vision.zzkk r10 = r0.zzc()
            r12 = 0
            r0 = r5
            r5 = r2
            r6 = r0
            r7 = r24
            r8 = r29
            r9 = r23
            r13 = r14
            r14 = r27
            r15 = r19
            r16 = r35
            r17 = r36
            r18 = r37
            r19 = r38
            r20 = r39
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r2
        L_0x040f:
            com.google.android.gms.internal.vision.zzlr r0 = (com.google.android.gms.internal.vision.zzlr) r0
            r0.zza()
            int r0 = com.google.android.gms.internal.vision.zzkz.zzb
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            goto L_0x041d
        L_0x041c:
            throw r0
        L_0x041d:
            goto L_0x041c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zza(java.lang.Class, com.google.android.gms.internal.vision.zzki, com.google.android.gms.internal.vision.zzks, com.google.android.gms.internal.vision.zzju, com.google.android.gms.internal.vision.zzlu, com.google.android.gms.internal.vision.zziq, com.google.android.gms.internal.vision.zzkh):com.google.android.gms.internal.vision.zzko");
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    public final T zza() {
        return this.zzo.zza(this.zzg);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.vision.zzle.zza(com.google.android.gms.internal.vision.zzma.zzf(r10, r6), com.google.android.gms.internal.vision.zzma.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.vision.zzma.zzb(r10, r6) == com.google.android.gms.internal.vision.zzma.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.vision.zzma.zzb(r10, r6) == com.google.android.gms.internal.vision.zzma.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.vision.zzle.zza(com.google.android.gms.internal.vision.zzma.zzf(r10, r6), com.google.android.gms.internal.vision.zzma.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.vision.zzle.zza(com.google.android.gms.internal.vision.zzma.zzf(r10, r6), com.google.android.gms.internal.vision.zzma.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.vision.zzle.zza(com.google.android.gms.internal.vision.zzma.zzf(r10, r6), com.google.android.gms.internal.vision.zzma.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.vision.zzma.zzc(r10, r6) == com.google.android.gms.internal.vision.zzma.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.vision.zzma.zzb(r10, r6) == com.google.android.gms.internal.vision.zzma.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.vision.zzma.zzb(r10, r6) == com.google.android.gms.internal.vision.zzma.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.vision.zzma.zzb(r10, r6) == com.google.android.gms.internal.vision.zzma.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.vision.zzma.zzd(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.vision.zzma.zzd(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.vision.zzma.zze(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.vision.zzma.zze(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.vision.zzle.zza(com.google.android.gms.internal.vision.zzma.zzf(r10, r6), com.google.android.gms.internal.vision.zzma.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzd((int) r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x01a7;
                case 1: goto L_0x018e;
                case 2: goto L_0x017b;
                case 3: goto L_0x0168;
                case 4: goto L_0x0157;
                case 5: goto L_0x0144;
                case 6: goto L_0x0132;
                case 7: goto L_0x0120;
                case 8: goto L_0x010a;
                case 9: goto L_0x00f4;
                case 10: goto L_0x00de;
                case 11: goto L_0x00cc;
                case 12: goto L_0x00ba;
                case 13: goto L_0x00a8;
                case 14: goto L_0x0094;
                case 15: goto L_0x0082;
                case 16: goto L_0x006e;
                case 17: goto L_0x0058;
                case 18: goto L_0x004a;
                case 19: goto L_0x004a;
                case 20: goto L_0x004a;
                case 21: goto L_0x004a;
                case 22: goto L_0x004a;
                case 23: goto L_0x004a;
                case 24: goto L_0x004a;
                case 25: goto L_0x004a;
                case 26: goto L_0x004a;
                case 27: goto L_0x004a;
                case 28: goto L_0x004a;
                case 29: goto L_0x004a;
                case 30: goto L_0x004a;
                case 31: goto L_0x004a;
                case 32: goto L_0x004a;
                case 33: goto L_0x004a;
                case 34: goto L_0x004a;
                case 35: goto L_0x004a;
                case 36: goto L_0x004a;
                case 37: goto L_0x004a;
                case 38: goto L_0x004a;
                case 39: goto L_0x004a;
                case 40: goto L_0x004a;
                case 41: goto L_0x004a;
                case 42: goto L_0x004a;
                case 43: goto L_0x004a;
                case 44: goto L_0x004a;
                case 45: goto L_0x004a;
                case 46: goto L_0x004a;
                case 47: goto L_0x004a;
                case 48: goto L_0x004a;
                case 49: goto L_0x004a;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01c2
        L_0x001c:
            int r4 = r9.zze((int) r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r10, (long) r4)
            int r4 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r11, (long) r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzma.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzma.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzle.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzma.zzf(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzma.zzf(r11, r6)
            boolean r3 = com.google.android.gms.internal.vision.zzle.zza((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzma.zzf(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzma.zzf(r11, r6)
            boolean r3 = com.google.android.gms.internal.vision.zzle.zza((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzma.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzma.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzle.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzma.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzma.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzma.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzma.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzma.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzma.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzle.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzma.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzma.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzle.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzma.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzma.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzle.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.vision.zzma.zzc(r10, r6)
            boolean r5 = com.google.android.gms.internal.vision.zzma.zzc(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzma.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzma.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzma.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzma.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzma.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzma.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.vision.zzma.zzd(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.vision.zzma.zzd(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.vision.zzma.zze(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.vision.zzma.zze(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
        L_0x01c1:
            r3 = 0
        L_0x01c2:
            if (r3 != 0) goto L_0x01c5
            return r1
        L_0x01c5:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01c9:
            com.google.android.gms.internal.vision.zzlu<?, ?> r0 = r9.zzq
            java.lang.Object r0 = r0.zzb(r10)
            com.google.android.gms.internal.vision.zzlu<?, ?> r2 = r9.zzq
            java.lang.Object r2 = r2.zzb(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.vision.zziq<?> r0 = r9.zzr
            com.google.android.gms.internal.vision.zziu r10 = r0.zza((java.lang.Object) r10)
            com.google.android.gms.internal.vision.zziq<?> r0 = r9.zzr
            com.google.android.gms.internal.vision.zziu r11 = r0.zza((java.lang.Object) r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zza(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c3, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0227, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0228, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022c
            int r3 = r8.zzd((int) r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0219;
                case 1: goto L_0x020e;
                case 2: goto L_0x0203;
                case 3: goto L_0x01f8;
                case 4: goto L_0x01f1;
                case 5: goto L_0x01e6;
                case 6: goto L_0x01df;
                case 7: goto L_0x01d4;
                case 8: goto L_0x01c7;
                case 9: goto L_0x01b9;
                case 10: goto L_0x01ad;
                case 11: goto L_0x01a5;
                case 12: goto L_0x019d;
                case 13: goto L_0x0195;
                case 14: goto L_0x0189;
                case 15: goto L_0x0181;
                case 16: goto L_0x0175;
                case 17: goto L_0x016a;
                case 18: goto L_0x015e;
                case 19: goto L_0x015e;
                case 20: goto L_0x015e;
                case 21: goto L_0x015e;
                case 22: goto L_0x015e;
                case 23: goto L_0x015e;
                case 24: goto L_0x015e;
                case 25: goto L_0x015e;
                case 26: goto L_0x015e;
                case 27: goto L_0x015e;
                case 28: goto L_0x015e;
                case 29: goto L_0x015e;
                case 30: goto L_0x015e;
                case 31: goto L_0x015e;
                case 32: goto L_0x015e;
                case 33: goto L_0x015e;
                case 34: goto L_0x015e;
                case 35: goto L_0x015e;
                case 36: goto L_0x015e;
                case 37: goto L_0x015e;
                case 38: goto L_0x015e;
                case 39: goto L_0x015e;
                case 40: goto L_0x015e;
                case 41: goto L_0x015e;
                case 42: goto L_0x015e;
                case 43: goto L_0x015e;
                case 44: goto L_0x015e;
                case 45: goto L_0x015e;
                case 46: goto L_0x015e;
                case 47: goto L_0x015e;
                case 48: goto L_0x015e;
                case 49: goto L_0x015e;
                case 50: goto L_0x0152;
                case 51: goto L_0x013c;
                case 52: goto L_0x012a;
                case 53: goto L_0x0118;
                case 54: goto L_0x0106;
                case 55: goto L_0x00f8;
                case 56: goto L_0x00e6;
                case 57: goto L_0x00d8;
                case 58: goto L_0x00c6;
                case 59: goto L_0x00b2;
                case 60: goto L_0x00a0;
                case 61: goto L_0x008e;
                case 62: goto L_0x0080;
                case 63: goto L_0x0072;
                case 64: goto L_0x0064;
                case 65: goto L_0x0052;
                case 66: goto L_0x0044;
                case 67: goto L_0x0032;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0228
        L_0x0020:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzma.zzf(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x0032:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzjf.zza((long) r3)
            goto L_0x0227
        L_0x0044:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x0052:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzjf.zza((long) r3)
            goto L_0x0227
        L_0x0064:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x0072:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x0080:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x008e:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzma.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00a0:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzma.zzf(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00b2:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzma.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00c6:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            boolean r3 = zzf(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzjf.zza((boolean) r3)
            goto L_0x0227
        L_0x00d8:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x00e6:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzjf.zza((long) r3)
            goto L_0x0227
        L_0x00f8:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x0106:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzjf.zza((long) r3)
            goto L_0x0227
        L_0x0118:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzjf.zza((long) r3)
            goto L_0x0227
        L_0x012a:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            float r3 = zzc(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x013c:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            double r3 = zzb(r9, (long) r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.vision.zzjf.zza((long) r3)
            goto L_0x0227
        L_0x0152:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzma.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x015e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzma.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x016a:
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzma.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
            goto L_0x01c3
        L_0x0175:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.vision.zzma.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzjf.zza((long) r3)
            goto L_0x0227
        L_0x0181:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x0189:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.vision.zzma.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzjf.zza((long) r3)
            goto L_0x0227
        L_0x0195:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x019d:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01a5:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01ad:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzma.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01b9:
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzma.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
        L_0x01c3:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0228
        L_0x01c7:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzma.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01d4:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.vision.zzma.zzc(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzjf.zza((boolean) r3)
            goto L_0x0227
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.vision.zzma.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzjf.zza((long) r3)
            goto L_0x0227
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.vision.zzma.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzjf.zza((long) r3)
            goto L_0x0227
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.vision.zzma.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzjf.zza((long) r3)
            goto L_0x0227
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.vision.zzma.zzd(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x0219:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.vision.zzma.zze(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.vision.zzjf.zza((long) r3)
        L_0x0227:
            int r2 = r2 + r3
        L_0x0228:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022c:
            int r2 = r2 * 53
            com.google.android.gms.internal.vision.zzlu<?, ?> r0 = r8.zzq
            java.lang.Object r0 = r0.zzb(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x024a
            int r2 = r2 * 53
            com.google.android.gms.internal.vision.zziq<?> r0 = r8.zzr
            com.google.android.gms.internal.vision.zziu r9 = r0.zza((java.lang.Object) r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zza(java.lang.Object):int");
    }

    public final void zzb(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzd2 = zzd(i);
            long j = (long) (1048575 & zzd2);
            int i2 = this.zzc[i];
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzma.zza((Object) t, j, zzma.zze(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 1:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzma.zza((Object) t, j, zzma.zzd(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 2:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzma.zza((Object) t, j, zzma.zzb(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 3:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzma.zza((Object) t, j, zzma.zzb(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 4:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzma.zza((Object) t, j, zzma.zza((Object) t2, j));
                        zzb(t, i);
                        break;
                    }
                case 5:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzma.zza((Object) t, j, zzma.zzb(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 6:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzma.zza((Object) t, j, zzma.zza((Object) t2, j));
                        zzb(t, i);
                        break;
                    }
                case 7:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzma.zza((Object) t, j, zzma.zzc(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 8:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzma.zza((Object) t, j, zzma.zzf(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzma.zza((Object) t, j, zzma.zzf(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 11:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzma.zza((Object) t, j, zzma.zza((Object) t2, j));
                        zzb(t, i);
                        break;
                    }
                case 12:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzma.zza((Object) t, j, zzma.zza((Object) t2, j));
                        zzb(t, i);
                        break;
                    }
                case 13:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzma.zza((Object) t, j, zzma.zza((Object) t2, j));
                        zzb(t, i);
                        break;
                    }
                case 14:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzma.zza((Object) t, j, zzma.zzb(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 15:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzma.zza((Object) t, j, zzma.zza((Object) t2, j));
                        zzb(t, i);
                        break;
                    }
                case 16:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzma.zza((Object) t, j, zzma.zzb(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzp.zza(t, t2, j);
                    break;
                case 50:
                    zzle.zza(this.zzs, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zza(t2, i2, i)) {
                        break;
                    } else {
                        zzma.zza((Object) t, j, zzma.zzf(t2, j));
                        zzb(t, i2, i);
                        break;
                    }
                case 60:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zza(t2, i2, i)) {
                        break;
                    } else {
                        zzma.zza((Object) t, j, zzma.zzf(t2, j));
                        zzb(t, i2, i);
                        break;
                    }
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzle.zza(this.zzq, t, t2);
        if (this.zzh) {
            zzle.zza(this.zzr, t, t2);
        }
    }

    private final void zza(T t, T t2, int i) {
        long zzd2 = (long) (zzd(i) & 1048575);
        if (zza(t2, i)) {
            Object zzf2 = zzma.zzf(t, zzd2);
            Object zzf3 = zzma.zzf(t2, zzd2);
            if (zzf2 != null && zzf3 != null) {
                zzma.zza((Object) t, zzd2, zzjf.zza(zzf2, zzf3));
                zzb(t, i);
            } else if (zzf3 != null) {
                zzma.zza((Object) t, zzd2, zzf3);
                zzb(t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzd2 = zzd(i);
        int i2 = this.zzc[i];
        long j = (long) (zzd2 & 1048575);
        if (zza(t2, i2, i)) {
            Object obj = null;
            if (zza(t, i2, i)) {
                obj = zzma.zzf(t, j);
            }
            Object zzf2 = zzma.zzf(t2, j);
            if (obj != null && zzf2 != null) {
                zzma.zza((Object) t, j, zzjf.zza(obj, zzf2));
                zzb(t, i2, i);
            } else if (zzf2 != null) {
                zzma.zza((Object) t, j, zzf2);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x072e, code lost:
        r8 = (r8 + r9) + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x07fa, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x080f, code lost:
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:342:0x0854, code lost:
        r5 = r5 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x0902, code lost:
        r5 = r5 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:387:0x0925, code lost:
        r3 = r3 + 3;
        r9 = r13;
        r7 = 1048575;
        r8 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(T r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            boolean r2 = r0.zzj
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r9 = 0
            r11 = 0
            if (r2 == 0) goto L_0x047d
            sun.misc.Unsafe r2 = zzb
            r12 = 0
            r13 = 0
        L_0x0016:
            int[] r14 = r0.zzc
            int r14 = r14.length
            if (r12 >= r14) goto L_0x0475
            int r14 = r0.zzd((int) r12)
            r15 = r14 & r3
            int r15 = r15 >>> 20
            int[] r3 = r0.zzc
            r3 = r3[r12]
            r14 = r14 & r7
            long r5 = (long) r14
            com.google.android.gms.internal.vision.zziv r14 = com.google.android.gms.internal.vision.zziv.DOUBLE_LIST_PACKED
            int r14 = r14.zza()
            if (r15 < r14) goto L_0x003f
            com.google.android.gms.internal.vision.zziv r14 = com.google.android.gms.internal.vision.zziv.SINT64_LIST_PACKED
            int r14 = r14.zza()
            if (r15 > r14) goto L_0x003f
            int[] r14 = r0.zzc
            int r17 = r12 + 2
            r14 = r14[r17]
        L_0x003f:
            switch(r15) {
                case 0: goto L_0x0461;
                case 1: goto L_0x0455;
                case 2: goto L_0x0445;
                case 3: goto L_0x0435;
                case 4: goto L_0x0425;
                case 5: goto L_0x0419;
                case 6: goto L_0x040d;
                case 7: goto L_0x0401;
                case 8: goto L_0x03e3;
                case 9: goto L_0x03cf;
                case 10: goto L_0x03be;
                case 11: goto L_0x03af;
                case 12: goto L_0x03a0;
                case 13: goto L_0x0395;
                case 14: goto L_0x038a;
                case 15: goto L_0x037b;
                case 16: goto L_0x036c;
                case 17: goto L_0x0357;
                case 18: goto L_0x034c;
                case 19: goto L_0x0343;
                case 20: goto L_0x033a;
                case 21: goto L_0x0331;
                case 22: goto L_0x0328;
                case 23: goto L_0x031f;
                case 24: goto L_0x0316;
                case 25: goto L_0x030d;
                case 26: goto L_0x0304;
                case 27: goto L_0x02f7;
                case 28: goto L_0x02ee;
                case 29: goto L_0x02e5;
                case 30: goto L_0x02db;
                case 31: goto L_0x02d1;
                case 32: goto L_0x02c7;
                case 33: goto L_0x02bd;
                case 34: goto L_0x02b3;
                case 35: goto L_0x029b;
                case 36: goto L_0x0286;
                case 37: goto L_0x0271;
                case 38: goto L_0x025c;
                case 39: goto L_0x0247;
                case 40: goto L_0x0232;
                case 41: goto L_0x021c;
                case 42: goto L_0x0206;
                case 43: goto L_0x01f0;
                case 44: goto L_0x01da;
                case 45: goto L_0x01c4;
                case 46: goto L_0x01ae;
                case 47: goto L_0x0198;
                case 48: goto L_0x0182;
                case 49: goto L_0x0174;
                case 50: goto L_0x0164;
                case 51: goto L_0x0156;
                case 52: goto L_0x014a;
                case 53: goto L_0x013a;
                case 54: goto L_0x012a;
                case 55: goto L_0x011a;
                case 56: goto L_0x010e;
                case 57: goto L_0x0102;
                case 58: goto L_0x00f6;
                case 59: goto L_0x00d8;
                case 60: goto L_0x00c4;
                case 61: goto L_0x00b2;
                case 62: goto L_0x00a2;
                case 63: goto L_0x0092;
                case 64: goto L_0x0086;
                case 65: goto L_0x007a;
                case 66: goto L_0x006a;
                case 67: goto L_0x005a;
                case 68: goto L_0x0044;
                default: goto L_0x0042;
            }
        L_0x0042:
            goto L_0x046f
        L_0x0044:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzma.zzf(r1, r5)
            com.google.android.gms.internal.vision.zzkk r5 = (com.google.android.gms.internal.vision.zzkk) r5
            com.google.android.gms.internal.vision.zzlc r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.vision.zzii.zzc(r3, r5, r6)
            goto L_0x0354
        L_0x005a:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            long r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzii.zzf((int) r3, (long) r5)
            goto L_0x0354
        L_0x006a:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            int r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzii.zzh((int) r3, (int) r5)
            goto L_0x0354
        L_0x007a:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zzh((int) r3, (long) r9)
            goto L_0x0354
        L_0x0086:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zzj(r3, r11)
            goto L_0x0354
        L_0x0092:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            int r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzii.zzk(r3, r5)
            goto L_0x0354
        L_0x00a2:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            int r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzii.zzg((int) r3, (int) r5)
            goto L_0x0354
        L_0x00b2:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzma.zzf(r1, r5)
            com.google.android.gms.internal.vision.zzht r5 = (com.google.android.gms.internal.vision.zzht) r5
            int r3 = com.google.android.gms.internal.vision.zzii.zzc((int) r3, (com.google.android.gms.internal.vision.zzht) r5)
            goto L_0x0354
        L_0x00c4:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzma.zzf(r1, r5)
            com.google.android.gms.internal.vision.zzlc r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.vision.zzle.zza((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.vision.zzlc) r6)
            goto L_0x0354
        L_0x00d8:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzma.zzf(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.vision.zzht
            if (r6 == 0) goto L_0x00ee
            com.google.android.gms.internal.vision.zzht r5 = (com.google.android.gms.internal.vision.zzht) r5
            int r3 = com.google.android.gms.internal.vision.zzii.zzc((int) r3, (com.google.android.gms.internal.vision.zzht) r5)
            goto L_0x0354
        L_0x00ee:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.vision.zzii.zzb((int) r3, (java.lang.String) r5)
            goto L_0x0354
        L_0x00f6:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zzb((int) r3, (boolean) r8)
            goto L_0x0354
        L_0x0102:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zzi(r3, r11)
            goto L_0x0354
        L_0x010e:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zzg((int) r3, (long) r9)
            goto L_0x0354
        L_0x011a:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            int r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzii.zzf((int) r3, (int) r5)
            goto L_0x0354
        L_0x012a:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            long r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzii.zze((int) r3, (long) r5)
            goto L_0x0354
        L_0x013a:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            long r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzii.zzd((int) r3, (long) r5)
            goto L_0x0354
        L_0x014a:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zzb((int) r3, (float) r4)
            goto L_0x0354
        L_0x0156:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x046f
            r5 = 0
            int r3 = com.google.android.gms.internal.vision.zzii.zzb((int) r3, (double) r5)
            goto L_0x0354
        L_0x0164:
            com.google.android.gms.internal.vision.zzkh r14 = r0.zzs
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzma.zzf(r1, r5)
            java.lang.Object r6 = r0.zzb((int) r12)
            int r3 = r14.zza(r3, r5, r6)
            goto L_0x0354
        L_0x0174:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            com.google.android.gms.internal.vision.zzlc r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.vision.zzle.zzb((int) r3, (java.util.List<com.google.android.gms.internal.vision.zzkk>) r5, (com.google.android.gms.internal.vision.zzlc) r6)
            goto L_0x0354
        L_0x0182:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzle.zzc(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zze((int) r3)
            int r6 = com.google.android.gms.internal.vision.zzii.zzg((int) r5)
            goto L_0x02af
        L_0x0198:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzle.zzg(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zze((int) r3)
            int r6 = com.google.android.gms.internal.vision.zzii.zzg((int) r5)
            goto L_0x02af
        L_0x01ae:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzle.zzi(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zze((int) r3)
            int r6 = com.google.android.gms.internal.vision.zzii.zzg((int) r5)
            goto L_0x02af
        L_0x01c4:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzle.zzh(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zze((int) r3)
            int r6 = com.google.android.gms.internal.vision.zzii.zzg((int) r5)
            goto L_0x02af
        L_0x01da:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzle.zzd(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zze((int) r3)
            int r6 = com.google.android.gms.internal.vision.zzii.zzg((int) r5)
            goto L_0x02af
        L_0x01f0:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzle.zzf(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zze((int) r3)
            int r6 = com.google.android.gms.internal.vision.zzii.zzg((int) r5)
            goto L_0x02af
        L_0x0206:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzle.zzj(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zze((int) r3)
            int r6 = com.google.android.gms.internal.vision.zzii.zzg((int) r5)
            goto L_0x02af
        L_0x021c:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzle.zzh(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zze((int) r3)
            int r6 = com.google.android.gms.internal.vision.zzii.zzg((int) r5)
            goto L_0x02af
        L_0x0232:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzle.zzi(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zze((int) r3)
            int r6 = com.google.android.gms.internal.vision.zzii.zzg((int) r5)
            goto L_0x02af
        L_0x0247:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzle.zze(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zze((int) r3)
            int r6 = com.google.android.gms.internal.vision.zzii.zzg((int) r5)
            goto L_0x02af
        L_0x025c:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzle.zzb(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zze((int) r3)
            int r6 = com.google.android.gms.internal.vision.zzii.zzg((int) r5)
            goto L_0x02af
        L_0x0271:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzle.zza((java.util.List<java.lang.Long>) r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zze((int) r3)
            int r6 = com.google.android.gms.internal.vision.zzii.zzg((int) r5)
            goto L_0x02af
        L_0x0286:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzle.zzh(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zze((int) r3)
            int r6 = com.google.android.gms.internal.vision.zzii.zzg((int) r5)
            goto L_0x02af
        L_0x029b:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzle.zzi(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zze((int) r3)
            int r6 = com.google.android.gms.internal.vision.zzii.zzg((int) r5)
        L_0x02af:
            int r3 = r3 + r6
            int r3 = r3 + r5
            goto L_0x0354
        L_0x02b3:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.vision.zzle.zzc(r3, r5, r11)
            goto L_0x0354
        L_0x02bd:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.vision.zzle.zzg(r3, r5, r11)
            goto L_0x0354
        L_0x02c7:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.vision.zzle.zzi(r3, r5, r11)
            goto L_0x0354
        L_0x02d1:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.vision.zzle.zzh(r3, r5, r11)
            goto L_0x0354
        L_0x02db:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.vision.zzle.zzd(r3, r5, r11)
            goto L_0x0354
        L_0x02e5:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.vision.zzle.zzf(r3, r5, r11)
            goto L_0x0354
        L_0x02ee:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.vision.zzle.zzb(r3, r5)
            goto L_0x0354
        L_0x02f7:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            com.google.android.gms.internal.vision.zzlc r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.vision.zzle.zza((int) r3, (java.util.List<?>) r5, (com.google.android.gms.internal.vision.zzlc) r6)
            goto L_0x0354
        L_0x0304:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.vision.zzle.zza((int) r3, (java.util.List<?>) r5)
            goto L_0x0354
        L_0x030d:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.vision.zzle.zzj(r3, r5, r11)
            goto L_0x0354
        L_0x0316:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.vision.zzle.zzh(r3, r5, r11)
            goto L_0x0354
        L_0x031f:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.vision.zzle.zzi(r3, r5, r11)
            goto L_0x0354
        L_0x0328:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.vision.zzle.zze(r3, r5, r11)
            goto L_0x0354
        L_0x0331:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.vision.zzle.zzb((int) r3, (java.util.List<java.lang.Long>) r5, (boolean) r11)
            goto L_0x0354
        L_0x033a:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.vision.zzle.zza((int) r3, (java.util.List<java.lang.Long>) r5, (boolean) r11)
            goto L_0x0354
        L_0x0343:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.vision.zzle.zzh(r3, r5, r11)
            goto L_0x0354
        L_0x034c:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.vision.zzle.zzi(r3, r5, r11)
        L_0x0354:
            int r13 = r13 + r3
            goto L_0x046f
        L_0x0357:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzma.zzf(r1, r5)
            com.google.android.gms.internal.vision.zzkk r5 = (com.google.android.gms.internal.vision.zzkk) r5
            com.google.android.gms.internal.vision.zzlc r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.vision.zzii.zzc(r3, r5, r6)
            goto L_0x0354
        L_0x036c:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            long r5 = com.google.android.gms.internal.vision.zzma.zzb(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzii.zzf((int) r3, (long) r5)
            goto L_0x0354
        L_0x037b:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            int r5 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.vision.zzii.zzh((int) r3, (int) r5)
            goto L_0x0354
        L_0x038a:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zzh((int) r3, (long) r9)
            goto L_0x0354
        L_0x0395:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zzj(r3, r11)
            goto L_0x0354
        L_0x03a0:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            int r5 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.vision.zzii.zzk(r3, r5)
            goto L_0x0354
        L_0x03af:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            int r5 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.vision.zzii.zzg((int) r3, (int) r5)
            goto L_0x0354
        L_0x03be:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzma.zzf(r1, r5)
            com.google.android.gms.internal.vision.zzht r5 = (com.google.android.gms.internal.vision.zzht) r5
            int r3 = com.google.android.gms.internal.vision.zzii.zzc((int) r3, (com.google.android.gms.internal.vision.zzht) r5)
            goto L_0x0354
        L_0x03cf:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzma.zzf(r1, r5)
            com.google.android.gms.internal.vision.zzlc r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.vision.zzle.zza((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.vision.zzlc) r6)
            goto L_0x0354
        L_0x03e3:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzma.zzf(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.vision.zzht
            if (r6 == 0) goto L_0x03f9
            com.google.android.gms.internal.vision.zzht r5 = (com.google.android.gms.internal.vision.zzht) r5
            int r3 = com.google.android.gms.internal.vision.zzii.zzc((int) r3, (com.google.android.gms.internal.vision.zzht) r5)
            goto L_0x0354
        L_0x03f9:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.vision.zzii.zzb((int) r3, (java.lang.String) r5)
            goto L_0x0354
        L_0x0401:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zzb((int) r3, (boolean) r8)
            goto L_0x0354
        L_0x040d:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zzi(r3, r11)
            goto L_0x0354
        L_0x0419:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zzg((int) r3, (long) r9)
            goto L_0x0354
        L_0x0425:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            int r5 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.vision.zzii.zzf((int) r3, (int) r5)
            goto L_0x0354
        L_0x0435:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            long r5 = com.google.android.gms.internal.vision.zzma.zzb(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzii.zze((int) r3, (long) r5)
            goto L_0x0354
        L_0x0445:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            long r5 = com.google.android.gms.internal.vision.zzma.zzb(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzii.zzd((int) r3, (long) r5)
            goto L_0x0354
        L_0x0455:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.vision.zzii.zzb((int) r3, (float) r4)
            goto L_0x0354
        L_0x0461:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x046f
            r5 = 0
            int r3 = com.google.android.gms.internal.vision.zzii.zzb((int) r3, (double) r5)
            goto L_0x0354
        L_0x046f:
            int r12 = r12 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x0475:
            com.google.android.gms.internal.vision.zzlu<?, ?> r2 = r0.zzq
            int r1 = zza(r2, r1)
            int r13 = r13 + r1
            return r13
        L_0x047d:
            sun.misc.Unsafe r2 = zzb
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            r12 = 0
        L_0x0485:
            int[] r13 = r0.zzc
            int r13 = r13.length
            if (r3 >= r13) goto L_0x0930
            int r13 = r0.zzd((int) r3)
            int[] r14 = r0.zzc
            r15 = r14[r3]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r17 = r13 & r16
            int r4 = r17 >>> 20
            r11 = 17
            if (r4 > r11) goto L_0x04b0
            int r11 = r3 + 2
            r11 = r14[r11]
            r14 = r11 & r7
            int r11 = r11 >>> 20
            int r11 = r8 << r11
            if (r14 == r6) goto L_0x04b1
            long r8 = (long) r14
            int r6 = r2.getInt(r1, r8)
            r12 = r6
            r6 = r14
            goto L_0x04b1
        L_0x04b0:
            r11 = 0
        L_0x04b1:
            r8 = r13 & r7
            long r8 = (long) r8
            switch(r4) {
                case 0: goto L_0x0915;
                case 1: goto L_0x0904;
                case 2: goto L_0x08f3;
                case 3: goto L_0x08e3;
                case 4: goto L_0x08d3;
                case 5: goto L_0x08c6;
                case 6: goto L_0x08b9;
                case 7: goto L_0x08ad;
                case 8: goto L_0x0891;
                case 9: goto L_0x087f;
                case 10: goto L_0x0870;
                case 11: goto L_0x0863;
                case 12: goto L_0x0856;
                case 13: goto L_0x084b;
                case 14: goto L_0x0840;
                case 15: goto L_0x0833;
                case 16: goto L_0x0826;
                case 17: goto L_0x0813;
                case 18: goto L_0x07ff;
                case 19: goto L_0x07ef;
                case 20: goto L_0x07e3;
                case 21: goto L_0x07d7;
                case 22: goto L_0x07cb;
                case 23: goto L_0x07bf;
                case 24: goto L_0x07b3;
                case 25: goto L_0x07a7;
                case 26: goto L_0x079c;
                case 27: goto L_0x078c;
                case 28: goto L_0x0780;
                case 29: goto L_0x0773;
                case 30: goto L_0x0766;
                case 31: goto L_0x0759;
                case 32: goto L_0x074c;
                case 33: goto L_0x073f;
                case 34: goto L_0x0732;
                case 35: goto L_0x071a;
                case 36: goto L_0x0705;
                case 37: goto L_0x06f0;
                case 38: goto L_0x06db;
                case 39: goto L_0x06c6;
                case 40: goto L_0x06b1;
                case 41: goto L_0x069b;
                case 42: goto L_0x0685;
                case 43: goto L_0x066f;
                case 44: goto L_0x0659;
                case 45: goto L_0x0643;
                case 46: goto L_0x062d;
                case 47: goto L_0x0617;
                case 48: goto L_0x0601;
                case 49: goto L_0x05f1;
                case 50: goto L_0x05e1;
                case 51: goto L_0x05d3;
                case 52: goto L_0x05c6;
                case 53: goto L_0x05b6;
                case 54: goto L_0x05a6;
                case 55: goto L_0x0596;
                case 56: goto L_0x0588;
                case 57: goto L_0x057b;
                case 58: goto L_0x056e;
                case 59: goto L_0x0550;
                case 60: goto L_0x053c;
                case 61: goto L_0x052a;
                case 62: goto L_0x051a;
                case 63: goto L_0x050a;
                case 64: goto L_0x04fd;
                case 65: goto L_0x04ef;
                case 66: goto L_0x04df;
                case 67: goto L_0x04cf;
                case 68: goto L_0x04b9;
                default: goto L_0x04b7;
            }
        L_0x04b7:
            goto L_0x080b
        L_0x04b9:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080b
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.vision.zzkk r4 = (com.google.android.gms.internal.vision.zzkk) r4
            com.google.android.gms.internal.vision.zzlc r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.vision.zzii.zzc(r15, r4, r8)
            goto L_0x080a
        L_0x04cf:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080b
            long r8 = zze(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzii.zzf((int) r15, (long) r8)
            goto L_0x080a
        L_0x04df:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080b
            int r4 = zzd(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzii.zzh((int) r15, (int) r4)
            goto L_0x080a
        L_0x04ef:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080b
            r8 = 0
            int r4 = com.google.android.gms.internal.vision.zzii.zzh((int) r15, (long) r8)
            goto L_0x080a
        L_0x04fd:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080b
            r4 = 0
            int r8 = com.google.android.gms.internal.vision.zzii.zzj(r15, r4)
            goto L_0x0854
        L_0x050a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080b
            int r4 = zzd(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzii.zzk(r15, r4)
            goto L_0x080a
        L_0x051a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080b
            int r4 = zzd(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzii.zzg((int) r15, (int) r4)
            goto L_0x080a
        L_0x052a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080b
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.vision.zzht r4 = (com.google.android.gms.internal.vision.zzht) r4
            int r4 = com.google.android.gms.internal.vision.zzii.zzc((int) r15, (com.google.android.gms.internal.vision.zzht) r4)
            goto L_0x080a
        L_0x053c:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080b
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.vision.zzlc r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.vision.zzle.zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzlc) r8)
            goto L_0x080a
        L_0x0550:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080b
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.gms.internal.vision.zzht
            if (r8 == 0) goto L_0x0566
            com.google.android.gms.internal.vision.zzht r4 = (com.google.android.gms.internal.vision.zzht) r4
            int r4 = com.google.android.gms.internal.vision.zzii.zzc((int) r15, (com.google.android.gms.internal.vision.zzht) r4)
            goto L_0x080a
        L_0x0566:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.vision.zzii.zzb((int) r15, (java.lang.String) r4)
            goto L_0x080a
        L_0x056e:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080b
            r4 = 1
            int r8 = com.google.android.gms.internal.vision.zzii.zzb((int) r15, (boolean) r4)
            goto L_0x0854
        L_0x057b:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080b
            r4 = 0
            int r8 = com.google.android.gms.internal.vision.zzii.zzi(r15, r4)
            goto L_0x0854
        L_0x0588:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080b
            r8 = 0
            int r4 = com.google.android.gms.internal.vision.zzii.zzg((int) r15, (long) r8)
            goto L_0x080a
        L_0x0596:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080b
            int r4 = zzd(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzii.zzf((int) r15, (int) r4)
            goto L_0x080a
        L_0x05a6:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080b
            long r8 = zze(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzii.zze((int) r15, (long) r8)
            goto L_0x080a
        L_0x05b6:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080b
            long r8 = zze(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzii.zzd((int) r15, (long) r8)
            goto L_0x080a
        L_0x05c6:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080b
            r4 = 0
            int r8 = com.google.android.gms.internal.vision.zzii.zzb((int) r15, (float) r4)
            goto L_0x0854
        L_0x05d3:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080b
            r8 = 0
            int r4 = com.google.android.gms.internal.vision.zzii.zzb((int) r15, (double) r8)
            goto L_0x080a
        L_0x05e1:
            com.google.android.gms.internal.vision.zzkh r4 = r0.zzs
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.lang.Object r9 = r0.zzb((int) r3)
            int r4 = r4.zza(r15, r8, r9)
            goto L_0x080a
        L_0x05f1:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzlc r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.vision.zzle.zzb((int) r15, (java.util.List<com.google.android.gms.internal.vision.zzkk>) r4, (com.google.android.gms.internal.vision.zzlc) r8)
            goto L_0x080a
        L_0x0601:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzc(r4)
            if (r4 <= 0) goto L_0x080b
            int r8 = com.google.android.gms.internal.vision.zzii.zze((int) r15)
            int r9 = com.google.android.gms.internal.vision.zzii.zzg((int) r4)
            goto L_0x072e
        L_0x0617:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzg(r4)
            if (r4 <= 0) goto L_0x080b
            int r8 = com.google.android.gms.internal.vision.zzii.zze((int) r15)
            int r9 = com.google.android.gms.internal.vision.zzii.zzg((int) r4)
            goto L_0x072e
        L_0x062d:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzi(r4)
            if (r4 <= 0) goto L_0x080b
            int r8 = com.google.android.gms.internal.vision.zzii.zze((int) r15)
            int r9 = com.google.android.gms.internal.vision.zzii.zzg((int) r4)
            goto L_0x072e
        L_0x0643:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzh(r4)
            if (r4 <= 0) goto L_0x080b
            int r8 = com.google.android.gms.internal.vision.zzii.zze((int) r15)
            int r9 = com.google.android.gms.internal.vision.zzii.zzg((int) r4)
            goto L_0x072e
        L_0x0659:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzd(r4)
            if (r4 <= 0) goto L_0x080b
            int r8 = com.google.android.gms.internal.vision.zzii.zze((int) r15)
            int r9 = com.google.android.gms.internal.vision.zzii.zzg((int) r4)
            goto L_0x072e
        L_0x066f:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzf(r4)
            if (r4 <= 0) goto L_0x080b
            int r8 = com.google.android.gms.internal.vision.zzii.zze((int) r15)
            int r9 = com.google.android.gms.internal.vision.zzii.zzg((int) r4)
            goto L_0x072e
        L_0x0685:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzj(r4)
            if (r4 <= 0) goto L_0x080b
            int r8 = com.google.android.gms.internal.vision.zzii.zze((int) r15)
            int r9 = com.google.android.gms.internal.vision.zzii.zzg((int) r4)
            goto L_0x072e
        L_0x069b:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzh(r4)
            if (r4 <= 0) goto L_0x080b
            int r8 = com.google.android.gms.internal.vision.zzii.zze((int) r15)
            int r9 = com.google.android.gms.internal.vision.zzii.zzg((int) r4)
            goto L_0x072e
        L_0x06b1:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzi(r4)
            if (r4 <= 0) goto L_0x080b
            int r8 = com.google.android.gms.internal.vision.zzii.zze((int) r15)
            int r9 = com.google.android.gms.internal.vision.zzii.zzg((int) r4)
            goto L_0x072e
        L_0x06c6:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zze(r4)
            if (r4 <= 0) goto L_0x080b
            int r8 = com.google.android.gms.internal.vision.zzii.zze((int) r15)
            int r9 = com.google.android.gms.internal.vision.zzii.zzg((int) r4)
            goto L_0x072e
        L_0x06db:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzb(r4)
            if (r4 <= 0) goto L_0x080b
            int r8 = com.google.android.gms.internal.vision.zzii.zze((int) r15)
            int r9 = com.google.android.gms.internal.vision.zzii.zzg((int) r4)
            goto L_0x072e
        L_0x06f0:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zza((java.util.List<java.lang.Long>) r4)
            if (r4 <= 0) goto L_0x080b
            int r8 = com.google.android.gms.internal.vision.zzii.zze((int) r15)
            int r9 = com.google.android.gms.internal.vision.zzii.zzg((int) r4)
            goto L_0x072e
        L_0x0705:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzh(r4)
            if (r4 <= 0) goto L_0x080b
            int r8 = com.google.android.gms.internal.vision.zzii.zze((int) r15)
            int r9 = com.google.android.gms.internal.vision.zzii.zzg((int) r4)
            goto L_0x072e
        L_0x071a:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzi(r4)
            if (r4 <= 0) goto L_0x080b
            int r8 = com.google.android.gms.internal.vision.zzii.zze((int) r15)
            int r9 = com.google.android.gms.internal.vision.zzii.zzg((int) r4)
        L_0x072e:
            int r8 = r8 + r9
            int r8 = r8 + r4
            goto L_0x0854
        L_0x0732:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.gms.internal.vision.zzle.zzc(r15, r4, r10)
            goto L_0x07fa
        L_0x073f:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzg(r15, r4, r10)
            goto L_0x07fa
        L_0x074c:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzi(r15, r4, r10)
            goto L_0x07fa
        L_0x0759:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzh(r15, r4, r10)
            goto L_0x07fa
        L_0x0766:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzd(r15, r4, r10)
            goto L_0x07fa
        L_0x0773:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzf(r15, r4, r10)
            goto L_0x080a
        L_0x0780:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzb(r15, r4)
            goto L_0x080a
        L_0x078c:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzlc r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.vision.zzle.zza((int) r15, (java.util.List<?>) r4, (com.google.android.gms.internal.vision.zzlc) r8)
            goto L_0x080a
        L_0x079c:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zza((int) r15, (java.util.List<?>) r4)
            goto L_0x080a
        L_0x07a7:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.gms.internal.vision.zzle.zzj(r15, r4, r10)
            goto L_0x07fa
        L_0x07b3:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzh(r15, r4, r10)
            goto L_0x07fa
        L_0x07bf:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzi(r15, r4, r10)
            goto L_0x07fa
        L_0x07cb:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zze(r15, r4, r10)
            goto L_0x07fa
        L_0x07d7:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzb((int) r15, (java.util.List<java.lang.Long>) r4, (boolean) r10)
            goto L_0x07fa
        L_0x07e3:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zza((int) r15, (java.util.List<java.lang.Long>) r4, (boolean) r10)
            goto L_0x07fa
        L_0x07ef:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzh(r15, r4, r10)
        L_0x07fa:
            int r5 = r5 + r4
            r4 = 1
        L_0x07fc:
            r7 = 0
            goto L_0x080f
        L_0x07ff:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzle.zzi(r15, r4, r10)
        L_0x080a:
            int r5 = r5 + r4
        L_0x080b:
            r4 = 1
        L_0x080c:
            r7 = 0
            r10 = 0
        L_0x080f:
            r13 = 0
            goto L_0x0925
        L_0x0813:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080b
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.vision.zzkk r4 = (com.google.android.gms.internal.vision.zzkk) r4
            com.google.android.gms.internal.vision.zzlc r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.vision.zzii.zzc(r15, r4, r8)
            goto L_0x080a
        L_0x0826:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080b
            long r8 = r2.getLong(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzii.zzf((int) r15, (long) r8)
            goto L_0x080a
        L_0x0833:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080b
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzii.zzh((int) r15, (int) r4)
            goto L_0x080a
        L_0x0840:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080b
            r8 = 0
            int r4 = com.google.android.gms.internal.vision.zzii.zzh((int) r15, (long) r8)
            goto L_0x080a
        L_0x084b:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080b
            r4 = 0
            int r8 = com.google.android.gms.internal.vision.zzii.zzj(r15, r4)
        L_0x0854:
            int r5 = r5 + r8
            goto L_0x080b
        L_0x0856:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080b
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzii.zzk(r15, r4)
            goto L_0x080a
        L_0x0863:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080b
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.vision.zzii.zzg((int) r15, (int) r4)
            goto L_0x080a
        L_0x0870:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080b
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.vision.zzht r4 = (com.google.android.gms.internal.vision.zzht) r4
            int r4 = com.google.android.gms.internal.vision.zzii.zzc((int) r15, (com.google.android.gms.internal.vision.zzht) r4)
            goto L_0x080a
        L_0x087f:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080b
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.vision.zzlc r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.vision.zzle.zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzlc) r8)
            goto L_0x080a
        L_0x0891:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080b
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.gms.internal.vision.zzht
            if (r8 == 0) goto L_0x08a5
            com.google.android.gms.internal.vision.zzht r4 = (com.google.android.gms.internal.vision.zzht) r4
            int r4 = com.google.android.gms.internal.vision.zzii.zzc((int) r15, (com.google.android.gms.internal.vision.zzht) r4)
            goto L_0x080a
        L_0x08a5:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.vision.zzii.zzb((int) r15, (java.lang.String) r4)
            goto L_0x080a
        L_0x08ad:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080b
            r4 = 1
            int r8 = com.google.android.gms.internal.vision.zzii.zzb((int) r15, (boolean) r4)
            int r5 = r5 + r8
            goto L_0x080c
        L_0x08b9:
            r4 = 1
            r8 = r12 & r11
            r10 = 0
            if (r8 == 0) goto L_0x07fc
            int r8 = com.google.android.gms.internal.vision.zzii.zzi(r15, r10)
            int r5 = r5 + r8
            goto L_0x07fc
        L_0x08c6:
            r4 = 1
            r10 = 0
            r8 = r12 & r11
            r13 = 0
            if (r8 == 0) goto L_0x0912
            int r8 = com.google.android.gms.internal.vision.zzii.zzg((int) r15, (long) r13)
            goto L_0x0902
        L_0x08d3:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r11 & r12
            if (r11 == 0) goto L_0x0912
            int r8 = r2.getInt(r1, r8)
            int r8 = com.google.android.gms.internal.vision.zzii.zzf((int) r15, (int) r8)
            goto L_0x0902
        L_0x08e3:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r11 & r12
            if (r11 == 0) goto L_0x0912
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.gms.internal.vision.zzii.zze((int) r15, (long) r8)
            goto L_0x0902
        L_0x08f3:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r11 & r12
            if (r11 == 0) goto L_0x0912
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.gms.internal.vision.zzii.zzd((int) r15, (long) r8)
        L_0x0902:
            int r5 = r5 + r8
            goto L_0x0912
        L_0x0904:
            r4 = 1
            r10 = 0
            r13 = 0
            r8 = r12 & r11
            if (r8 == 0) goto L_0x0912
            r8 = 0
            int r9 = com.google.android.gms.internal.vision.zzii.zzb((int) r15, (float) r8)
            int r5 = r5 + r9
        L_0x0912:
            r7 = 0
            goto L_0x0925
        L_0x0915:
            r4 = 1
            r8 = 0
            r10 = 0
            r13 = 0
            r9 = r12 & r11
            if (r9 == 0) goto L_0x0912
            r7 = 0
            int r11 = com.google.android.gms.internal.vision.zzii.zzb((int) r15, (double) r7)
            int r5 = r5 + r11
        L_0x0925:
            int r3 = r3 + 3
            r9 = r13
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r11 = 0
            goto L_0x0485
        L_0x0930:
            r10 = 0
            com.google.android.gms.internal.vision.zzlu<?, ?> r2 = r0.zzq
            int r2 = zza(r2, r1)
            int r5 = r5 + r2
            boolean r2 = r0.zzh
            if (r2 == 0) goto L_0x098a
            com.google.android.gms.internal.vision.zziq<?> r2 = r0.zzr
            com.google.android.gms.internal.vision.zziu r1 = r2.zza((java.lang.Object) r1)
            r11 = 0
        L_0x0943:
            com.google.android.gms.internal.vision.zzlh<T, java.lang.Object> r2 = r1.zza
            int r2 = r2.zzc()
            if (r11 >= r2) goto L_0x0963
            com.google.android.gms.internal.vision.zzlh<T, java.lang.Object> r2 = r1.zza
            java.util.Map$Entry r2 = r2.zzb((int) r11)
            java.lang.Object r3 = r2.getKey()
            com.google.android.gms.internal.vision.zziw r3 = (com.google.android.gms.internal.vision.zziw) r3
            java.lang.Object r2 = r2.getValue()
            int r2 = com.google.android.gms.internal.vision.zziu.zzc(r3, r2)
            int r10 = r10 + r2
            int r11 = r11 + 1
            goto L_0x0943
        L_0x0963:
            com.google.android.gms.internal.vision.zzlh<T, java.lang.Object> r1 = r1.zza
            java.lang.Iterable r1 = r1.zzd()
            java.util.Iterator r1 = r1.iterator()
        L_0x096d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0989
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            com.google.android.gms.internal.vision.zziw r3 = (com.google.android.gms.internal.vision.zziw) r3
            java.lang.Object r2 = r2.getValue()
            int r2 = com.google.android.gms.internal.vision.zziu.zzc(r3, r2)
            int r10 = r10 + r2
            goto L_0x096d
        L_0x0989:
            int r5 = r5 + r10
        L_0x098a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zzb(java.lang.Object):int");
    }

    private static <UT, UB> int zza(zzlu<UT, UB> zzlu, T t) {
        return zzlu.zzf(zzlu.zzb(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzma.zzf(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.vision.zzmr r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zza()
            int r1 = com.google.android.gms.internal.vision.zzmq.zzb
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0529
            com.google.android.gms.internal.vision.zzlu<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.gms.internal.vision.zzmr) r15)
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.vision.zziq<?> r0 = r13.zzr
            com.google.android.gms.internal.vision.zziu r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.vision.zzlh<T, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0032
            java.util.Iterator r0 = r0.zze()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0034
        L_0x0032:
            r0 = r3
            r1 = r0
        L_0x0034:
            int[] r7 = r13.zzc
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x0511
            int r8 = r13.zzd((int) r7)
            int[] r9 = r13.zzc
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.vision.zziq<?> r10 = r13.zzr
            int r10 = r10.zza((java.util.Map.Entry<?, ?>) r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.vision.zziq<?> r10 = r13.zzr
            r10.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005f
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0043
        L_0x005f:
            r1 = r3
            goto L_0x0043
        L_0x0061:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x04fe;
                case 1: goto L_0x04ee;
                case 2: goto L_0x04de;
                case 3: goto L_0x04ce;
                case 4: goto L_0x04be;
                case 5: goto L_0x04ae;
                case 6: goto L_0x049e;
                case 7: goto L_0x048d;
                case 8: goto L_0x047c;
                case 9: goto L_0x0467;
                case 10: goto L_0x0454;
                case 11: goto L_0x0443;
                case 12: goto L_0x0432;
                case 13: goto L_0x0421;
                case 14: goto L_0x0410;
                case 15: goto L_0x03ff;
                case 16: goto L_0x03ee;
                case 17: goto L_0x03d9;
                case 18: goto L_0x03c8;
                case 19: goto L_0x03b7;
                case 20: goto L_0x03a6;
                case 21: goto L_0x0395;
                case 22: goto L_0x0384;
                case 23: goto L_0x0373;
                case 24: goto L_0x0362;
                case 25: goto L_0x0351;
                case 26: goto L_0x0340;
                case 27: goto L_0x032b;
                case 28: goto L_0x031a;
                case 29: goto L_0x0309;
                case 30: goto L_0x02f8;
                case 31: goto L_0x02e7;
                case 32: goto L_0x02d6;
                case 33: goto L_0x02c5;
                case 34: goto L_0x02b4;
                case 35: goto L_0x02a3;
                case 36: goto L_0x0292;
                case 37: goto L_0x0281;
                case 38: goto L_0x0270;
                case 39: goto L_0x025f;
                case 40: goto L_0x024e;
                case 41: goto L_0x023d;
                case 42: goto L_0x022c;
                case 43: goto L_0x021b;
                case 44: goto L_0x020a;
                case 45: goto L_0x01f9;
                case 46: goto L_0x01e8;
                case 47: goto L_0x01d7;
                case 48: goto L_0x01c6;
                case 49: goto L_0x01b1;
                case 50: goto L_0x01a6;
                case 51: goto L_0x0195;
                case 52: goto L_0x0184;
                case 53: goto L_0x0173;
                case 54: goto L_0x0162;
                case 55: goto L_0x0151;
                case 56: goto L_0x0140;
                case 57: goto L_0x012f;
                case 58: goto L_0x011e;
                case 59: goto L_0x010d;
                case 60: goto L_0x00f8;
                case 61: goto L_0x00e5;
                case 62: goto L_0x00d4;
                case 63: goto L_0x00c3;
                case 64: goto L_0x00b2;
                case 65: goto L_0x00a1;
                case 66: goto L_0x0090;
                case 67: goto L_0x007f;
                case 68: goto L_0x006a;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x050d
        L_0x006a:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            com.google.android.gms.internal.vision.zzlc r10 = r13.zza((int) r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzlc) r10)
            goto L_0x050d
        L_0x007f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zze((int) r9, (long) r10)
            goto L_0x050d
        L_0x0090:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x00a1:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x00b2:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zza((int) r9, (int) r8)
            goto L_0x050d
        L_0x00c3:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzb((int) r9, (int) r8)
            goto L_0x050d
        L_0x00d4:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zze((int) r9, (int) r8)
            goto L_0x050d
        L_0x00e5:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            com.google.android.gms.internal.vision.zzht r8 = (com.google.android.gms.internal.vision.zzht) r8
            r15.zza((int) r9, (com.google.android.gms.internal.vision.zzht) r8)
            goto L_0x050d
        L_0x00f8:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            com.google.android.gms.internal.vision.zzlc r10 = r13.zza((int) r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzlc) r10)
            goto L_0x050d
        L_0x010d:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzmr) r15)
            goto L_0x050d
        L_0x011e:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzf(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x012f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzd((int) r9, (int) r8)
            goto L_0x050d
        L_0x0140:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzd((int) r9, (long) r10)
            goto L_0x050d
        L_0x0151:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzc((int) r9, (int) r8)
            goto L_0x050d
        L_0x0162:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x050d
        L_0x0173:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x050d
        L_0x0184:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzc(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x0195:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zzb(r14, (long) r10)
            r15.zza((int) r9, (double) r10)
            goto L_0x050d
        L_0x01a6:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            r13.zza((com.google.android.gms.internal.vision.zzmr) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x050d
        L_0x01b1:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzlc r10 = r13.zza((int) r7)
            com.google.android.gms.internal.vision.zzle.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.vision.zzmr) r15, (com.google.android.gms.internal.vision.zzlc) r10)
            goto L_0x050d
        L_0x01c6:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zze(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01d7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzj(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01e8:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzg(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01f9:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzl(r9, r8, r15, r4)
            goto L_0x050d
        L_0x020a:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzm(r9, r8, r15, r4)
            goto L_0x050d
        L_0x021b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzi(r9, r8, r15, r4)
            goto L_0x050d
        L_0x022c:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzn(r9, r8, r15, r4)
            goto L_0x050d
        L_0x023d:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzk(r9, r8, r15, r4)
            goto L_0x050d
        L_0x024e:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzf(r9, r8, r15, r4)
            goto L_0x050d
        L_0x025f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzh(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0270:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzd(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0281:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzc(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0292:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.vision.zzmr) r15, (boolean) r4)
            goto L_0x050d
        L_0x02a3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.vision.zzmr) r15, (boolean) r4)
            goto L_0x050d
        L_0x02b4:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zze(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02c5:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzj(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02d6:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzg(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02e7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzl(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02f8:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzm(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0309:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzi(r9, r8, r15, r5)
            goto L_0x050d
        L_0x031a:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzb((int) r9, (java.util.List<com.google.android.gms.internal.vision.zzht>) r8, (com.google.android.gms.internal.vision.zzmr) r15)
            goto L_0x050d
        L_0x032b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzlc r10 = r13.zza((int) r7)
            com.google.android.gms.internal.vision.zzle.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.vision.zzmr) r15, (com.google.android.gms.internal.vision.zzlc) r10)
            goto L_0x050d
        L_0x0340:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.vision.zzmr) r15)
            goto L_0x050d
        L_0x0351:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzn(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0362:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzk(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0373:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzf(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0384:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzh(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0395:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzd(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03a6:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzc(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03b7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.vision.zzmr) r15, (boolean) r5)
            goto L_0x050d
        L_0x03c8:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.vision.zzmr) r15, (boolean) r5)
            goto L_0x050d
        L_0x03d9:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            com.google.android.gms.internal.vision.zzlc r10 = r13.zza((int) r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzlc) r10)
            goto L_0x050d
        L_0x03ee:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzma.zzb(r14, r10)
            r15.zze((int) r9, (long) r10)
            goto L_0x050d
        L_0x03ff:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r14, (long) r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x0410:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzma.zzb(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x0421:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r14, (long) r10)
            r15.zza((int) r9, (int) r8)
            goto L_0x050d
        L_0x0432:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r14, (long) r10)
            r15.zzb((int) r9, (int) r8)
            goto L_0x050d
        L_0x0443:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r14, (long) r10)
            r15.zze((int) r9, (int) r8)
            goto L_0x050d
        L_0x0454:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            com.google.android.gms.internal.vision.zzht r8 = (com.google.android.gms.internal.vision.zzht) r8
            r15.zza((int) r9, (com.google.android.gms.internal.vision.zzht) r8)
            goto L_0x050d
        L_0x0467:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            com.google.android.gms.internal.vision.zzlc r10 = r13.zza((int) r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzlc) r10)
            goto L_0x050d
        L_0x047c:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzma.zzf(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzmr) r15)
            goto L_0x050d
        L_0x048d:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.vision.zzma.zzc(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x049e:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r14, (long) r10)
            r15.zzd((int) r9, (int) r8)
            goto L_0x050d
        L_0x04ae:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzma.zzb(r14, r10)
            r15.zzd((int) r9, (long) r10)
            goto L_0x050d
        L_0x04be:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r14, (long) r10)
            r15.zzc((int) r9, (int) r8)
            goto L_0x050d
        L_0x04ce:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzma.zzb(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x050d
        L_0x04de:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzma.zzb(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x050d
        L_0x04ee:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.vision.zzma.zzd(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x04fe:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.vision.zzma.zze(r14, r10)
            r15.zza((int) r9, (double) r10)
        L_0x050d:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x0511:
            if (r1 == 0) goto L_0x0528
            com.google.android.gms.internal.vision.zziq<?> r14 = r13.zzr
            r14.zza(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x0526
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x0511
        L_0x0526:
            r1 = r3
            goto L_0x0511
        L_0x0528:
            return
        L_0x0529:
            boolean r0 = r13.zzj
            if (r0 == 0) goto L_0x0a44
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x054a
            com.google.android.gms.internal.vision.zziq<?> r0 = r13.zzr
            com.google.android.gms.internal.vision.zziu r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.vision.zzlh<T, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x054a
            java.util.Iterator r0 = r0.zzd()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x054c
        L_0x054a:
            r0 = r3
            r1 = r0
        L_0x054c:
            int[] r7 = r13.zzc
            int r7 = r7.length
            r8 = 0
        L_0x0550:
            if (r8 >= r7) goto L_0x0a28
            int r9 = r13.zzd((int) r8)
            int[] r10 = r13.zzc
            r10 = r10[r8]
        L_0x055a:
            if (r1 == 0) goto L_0x0578
            com.google.android.gms.internal.vision.zziq<?> r11 = r13.zzr
            int r11 = r11.zza((java.util.Map.Entry<?, ?>) r1)
            if (r11 > r10) goto L_0x0578
            com.google.android.gms.internal.vision.zziq<?> r11 = r13.zzr
            r11.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0576
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x055a
        L_0x0576:
            r1 = r3
            goto L_0x055a
        L_0x0578:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0a15;
                case 1: goto L_0x0a05;
                case 2: goto L_0x09f5;
                case 3: goto L_0x09e5;
                case 4: goto L_0x09d5;
                case 5: goto L_0x09c5;
                case 6: goto L_0x09b5;
                case 7: goto L_0x09a4;
                case 8: goto L_0x0993;
                case 9: goto L_0x097e;
                case 10: goto L_0x096b;
                case 11: goto L_0x095a;
                case 12: goto L_0x0949;
                case 13: goto L_0x0938;
                case 14: goto L_0x0927;
                case 15: goto L_0x0916;
                case 16: goto L_0x0905;
                case 17: goto L_0x08f0;
                case 18: goto L_0x08df;
                case 19: goto L_0x08ce;
                case 20: goto L_0x08bd;
                case 21: goto L_0x08ac;
                case 22: goto L_0x089b;
                case 23: goto L_0x088a;
                case 24: goto L_0x0879;
                case 25: goto L_0x0868;
                case 26: goto L_0x0857;
                case 27: goto L_0x0842;
                case 28: goto L_0x0831;
                case 29: goto L_0x0820;
                case 30: goto L_0x080f;
                case 31: goto L_0x07fe;
                case 32: goto L_0x07ed;
                case 33: goto L_0x07dc;
                case 34: goto L_0x07cb;
                case 35: goto L_0x07ba;
                case 36: goto L_0x07a9;
                case 37: goto L_0x0798;
                case 38: goto L_0x0787;
                case 39: goto L_0x0776;
                case 40: goto L_0x0765;
                case 41: goto L_0x0754;
                case 42: goto L_0x0743;
                case 43: goto L_0x0732;
                case 44: goto L_0x0721;
                case 45: goto L_0x0710;
                case 46: goto L_0x06ff;
                case 47: goto L_0x06ee;
                case 48: goto L_0x06dd;
                case 49: goto L_0x06c8;
                case 50: goto L_0x06bd;
                case 51: goto L_0x06ac;
                case 52: goto L_0x069b;
                case 53: goto L_0x068a;
                case 54: goto L_0x0679;
                case 55: goto L_0x0668;
                case 56: goto L_0x0657;
                case 57: goto L_0x0646;
                case 58: goto L_0x0635;
                case 59: goto L_0x0624;
                case 60: goto L_0x060f;
                case 61: goto L_0x05fc;
                case 62: goto L_0x05eb;
                case 63: goto L_0x05da;
                case 64: goto L_0x05c9;
                case 65: goto L_0x05b8;
                case 66: goto L_0x05a7;
                case 67: goto L_0x0596;
                case 68: goto L_0x0581;
                default: goto L_0x057f;
            }
        L_0x057f:
            goto L_0x0a24
        L_0x0581:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            com.google.android.gms.internal.vision.zzlc r11 = r13.zza((int) r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.zzlc) r11)
            goto L_0x0a24
        L_0x0596:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zze((int) r10, (long) r11)
            goto L_0x0a24
        L_0x05a7:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0a24
        L_0x05b8:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a24
        L_0x05c9:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zza((int) r10, (int) r9)
            goto L_0x0a24
        L_0x05da:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzb((int) r10, (int) r9)
            goto L_0x0a24
        L_0x05eb:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zze((int) r10, (int) r9)
            goto L_0x0a24
        L_0x05fc:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            com.google.android.gms.internal.vision.zzht r9 = (com.google.android.gms.internal.vision.zzht) r9
            r15.zza((int) r10, (com.google.android.gms.internal.vision.zzht) r9)
            goto L_0x0a24
        L_0x060f:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            com.google.android.gms.internal.vision.zzlc r11 = r13.zza((int) r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.zzlc) r11)
            goto L_0x0a24
        L_0x0624:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.zzmr) r15)
            goto L_0x0a24
        L_0x0635:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzf(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0a24
        L_0x0646:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzd((int) r10, (int) r9)
            goto L_0x0a24
        L_0x0657:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzd((int) r10, (long) r11)
            goto L_0x0a24
        L_0x0668:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzc((int) r10, (int) r9)
            goto L_0x0a24
        L_0x0679:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0a24
        L_0x068a:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0a24
        L_0x069b:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzc(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a24
        L_0x06ac:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zzb(r14, (long) r11)
            r15.zza((int) r10, (double) r11)
            goto L_0x0a24
        L_0x06bd:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            r13.zza((com.google.android.gms.internal.vision.zzmr) r15, (int) r10, (java.lang.Object) r9, (int) r8)
            goto L_0x0a24
        L_0x06c8:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzlc r11 = r13.zza((int) r8)
            com.google.android.gms.internal.vision.zzle.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.vision.zzmr) r15, (com.google.android.gms.internal.vision.zzlc) r11)
            goto L_0x0a24
        L_0x06dd:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zze(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ee:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzj(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ff:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzg(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0710:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzl(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0721:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzm(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0732:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzi(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0743:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzn(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0754:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzk(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0765:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzf(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0776:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzh(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0787:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzd(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0798:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzc(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07a9:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.vision.zzmr) r15, (boolean) r4)
            goto L_0x0a24
        L_0x07ba:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.vision.zzmr) r15, (boolean) r4)
            goto L_0x0a24
        L_0x07cb:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zze(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07dc:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzj(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07ed:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzg(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07fe:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzl(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x080f:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzm(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0820:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzi(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0831:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzb((int) r10, (java.util.List<com.google.android.gms.internal.vision.zzht>) r9, (com.google.android.gms.internal.vision.zzmr) r15)
            goto L_0x0a24
        L_0x0842:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzlc r11 = r13.zza((int) r8)
            com.google.android.gms.internal.vision.zzle.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.vision.zzmr) r15, (com.google.android.gms.internal.vision.zzlc) r11)
            goto L_0x0a24
        L_0x0857:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.vision.zzmr) r15)
            goto L_0x0a24
        L_0x0868:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzn(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0879:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzk(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x088a:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzf(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x089b:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzh(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ac:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzd(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08bd:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzc(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ce:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.vision.zzmr) r15, (boolean) r5)
            goto L_0x0a24
        L_0x08df:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzle.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.vision.zzmr) r15, (boolean) r5)
            goto L_0x0a24
        L_0x08f0:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            com.google.android.gms.internal.vision.zzlc r11 = r13.zza((int) r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.zzlc) r11)
            goto L_0x0a24
        L_0x0905:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzma.zzb(r14, r11)
            r15.zze((int) r10, (long) r11)
            goto L_0x0a24
        L_0x0916:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r14, (long) r11)
            r15.zzf(r10, r9)
            goto L_0x0a24
        L_0x0927:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzma.zzb(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a24
        L_0x0938:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r14, (long) r11)
            r15.zza((int) r10, (int) r9)
            goto L_0x0a24
        L_0x0949:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r14, (long) r11)
            r15.zzb((int) r10, (int) r9)
            goto L_0x0a24
        L_0x095a:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r14, (long) r11)
            r15.zze((int) r10, (int) r9)
            goto L_0x0a24
        L_0x096b:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            com.google.android.gms.internal.vision.zzht r9 = (com.google.android.gms.internal.vision.zzht) r9
            r15.zza((int) r10, (com.google.android.gms.internal.vision.zzht) r9)
            goto L_0x0a24
        L_0x097e:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            com.google.android.gms.internal.vision.zzlc r11 = r13.zza((int) r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.zzlc) r11)
            goto L_0x0a24
        L_0x0993:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzma.zzf(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.zzmr) r15)
            goto L_0x0a24
        L_0x09a4:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.vision.zzma.zzc(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0a24
        L_0x09b5:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r14, (long) r11)
            r15.zzd((int) r10, (int) r9)
            goto L_0x0a24
        L_0x09c5:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzma.zzb(r14, r11)
            r15.zzd((int) r10, (long) r11)
            goto L_0x0a24
        L_0x09d5:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r14, (long) r11)
            r15.zzc((int) r10, (int) r9)
            goto L_0x0a24
        L_0x09e5:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzma.zzb(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0a24
        L_0x09f5:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzma.zzb(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0a24
        L_0x0a05:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.vision.zzma.zzd(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a24
        L_0x0a15:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.vision.zzma.zze(r14, r11)
            r15.zza((int) r10, (double) r11)
        L_0x0a24:
            int r8 = r8 + 3
            goto L_0x0550
        L_0x0a28:
            if (r1 == 0) goto L_0x0a3e
            com.google.android.gms.internal.vision.zziq<?> r2 = r13.zzr
            r2.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0a3c
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0a28
        L_0x0a3c:
            r1 = r3
            goto L_0x0a28
        L_0x0a3e:
            com.google.android.gms.internal.vision.zzlu<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.gms.internal.vision.zzmr) r15)
            return
        L_0x0a44:
            r13.zzb(r14, (com.google.android.gms.internal.vision.zzmr) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zza(java.lang.Object, com.google.android.gms.internal.vision.zzmr):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:168:0x0491  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r18, com.google.android.gms.internal.vision.zzmr r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.zzh
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.vision.zziq<?> r3 = r0.zzr
            com.google.android.gms.internal.vision.zziu r3 = r3.zza((java.lang.Object) r1)
            com.google.android.gms.internal.vision.zzlh<T, java.lang.Object> r5 = r3.zza
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.zzd()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            int[] r6 = r0.zzc
            int r6 = r6.length
            sun.misc.Unsafe r7 = zzb
            r10 = 0
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r12 = 0
        L_0x002f:
            if (r10 >= r6) goto L_0x048f
            int r13 = r0.zzd((int) r10)
            int[] r14 = r0.zzc
            r15 = r14[r10]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r16 = r13 & r16
            int r4 = r16 >>> 20
            r9 = 17
            if (r4 > r9) goto L_0x005a
            int r9 = r10 + 2
            r9 = r14[r9]
            r14 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r9 & r14
            if (r8 == r11) goto L_0x0054
            long r11 = (long) r8
            int r12 = r7.getInt(r1, r11)
            r11 = r8
        L_0x0054:
            int r8 = r9 >>> 20
            r9 = 1
            int r8 = r9 << r8
            goto L_0x005b
        L_0x005a:
            r8 = 0
        L_0x005b:
            if (r5 == 0) goto L_0x0079
            com.google.android.gms.internal.vision.zziq<?> r9 = r0.zzr
            int r9 = r9.zza((java.util.Map.Entry<?, ?>) r5)
            if (r9 > r15) goto L_0x0079
            com.google.android.gms.internal.vision.zziq<?> r9 = r0.zzr
            r9.zza(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0077
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x005b
        L_0x0077:
            r5 = 0
            goto L_0x005b
        L_0x0079:
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r13 & r9
            long r13 = (long) r13
            switch(r4) {
                case 0: goto L_0x0480;
                case 1: goto L_0x0474;
                case 2: goto L_0x0468;
                case 3: goto L_0x045c;
                case 4: goto L_0x0450;
                case 5: goto L_0x0444;
                case 6: goto L_0x0438;
                case 7: goto L_0x042c;
                case 8: goto L_0x0420;
                case 9: goto L_0x040f;
                case 10: goto L_0x0400;
                case 11: goto L_0x03f3;
                case 12: goto L_0x03e6;
                case 13: goto L_0x03d9;
                case 14: goto L_0x03cc;
                case 15: goto L_0x03bf;
                case 16: goto L_0x03b2;
                case 17: goto L_0x03a1;
                case 18: goto L_0x0391;
                case 19: goto L_0x0381;
                case 20: goto L_0x0371;
                case 21: goto L_0x0361;
                case 22: goto L_0x0351;
                case 23: goto L_0x0341;
                case 24: goto L_0x0331;
                case 25: goto L_0x0321;
                case 26: goto L_0x0312;
                case 27: goto L_0x02ff;
                case 28: goto L_0x02f0;
                case 29: goto L_0x02e0;
                case 30: goto L_0x02d0;
                case 31: goto L_0x02c0;
                case 32: goto L_0x02b0;
                case 33: goto L_0x02a0;
                case 34: goto L_0x0290;
                case 35: goto L_0x0280;
                case 36: goto L_0x0270;
                case 37: goto L_0x0260;
                case 38: goto L_0x0250;
                case 39: goto L_0x0240;
                case 40: goto L_0x0230;
                case 41: goto L_0x0220;
                case 42: goto L_0x0210;
                case 43: goto L_0x0200;
                case 44: goto L_0x01f0;
                case 45: goto L_0x01e0;
                case 46: goto L_0x01d0;
                case 47: goto L_0x01c0;
                case 48: goto L_0x01b0;
                case 49: goto L_0x019d;
                case 50: goto L_0x0194;
                case 51: goto L_0x0185;
                case 52: goto L_0x0176;
                case 53: goto L_0x0167;
                case 54: goto L_0x0158;
                case 55: goto L_0x0149;
                case 56: goto L_0x013a;
                case 57: goto L_0x012b;
                case 58: goto L_0x011c;
                case 59: goto L_0x010d;
                case 60: goto L_0x00fa;
                case 61: goto L_0x00ea;
                case 62: goto L_0x00dc;
                case 63: goto L_0x00ce;
                case 64: goto L_0x00c0;
                case 65: goto L_0x00b2;
                case 66: goto L_0x00a4;
                case 67: goto L_0x0096;
                case 68: goto L_0x0084;
                default: goto L_0x0081;
            }
        L_0x0081:
            r4 = 0
            goto L_0x048b
        L_0x0084:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.vision.zzlc r8 = r0.zza((int) r10)
            r2.zzb((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzlc) r8)
            goto L_0x0081
        L_0x0096:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            long r13 = zze(r1, r13)
            r2.zze((int) r15, (long) r13)
            goto L_0x0081
        L_0x00a4:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            int r4 = zzd(r1, r13)
            r2.zzf(r15, r4)
            goto L_0x0081
        L_0x00b2:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            long r13 = zze(r1, r13)
            r2.zzb((int) r15, (long) r13)
            goto L_0x0081
        L_0x00c0:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            int r4 = zzd(r1, r13)
            r2.zza((int) r15, (int) r4)
            goto L_0x0081
        L_0x00ce:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            int r4 = zzd(r1, r13)
            r2.zzb((int) r15, (int) r4)
            goto L_0x0081
        L_0x00dc:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            int r4 = zzd(r1, r13)
            r2.zze((int) r15, (int) r4)
            goto L_0x0081
        L_0x00ea:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.vision.zzht r4 = (com.google.android.gms.internal.vision.zzht) r4
            r2.zza((int) r15, (com.google.android.gms.internal.vision.zzht) r4)
            goto L_0x0081
        L_0x00fa:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.vision.zzlc r8 = r0.zza((int) r10)
            r2.zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzlc) r8)
            goto L_0x0081
        L_0x010d:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            java.lang.Object r4 = r7.getObject(r1, r13)
            zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzmr) r2)
            goto L_0x0081
        L_0x011c:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            boolean r4 = zzf(r1, r13)
            r2.zza((int) r15, (boolean) r4)
            goto L_0x0081
        L_0x012b:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            int r4 = zzd(r1, r13)
            r2.zzd((int) r15, (int) r4)
            goto L_0x0081
        L_0x013a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            long r13 = zze(r1, r13)
            r2.zzd((int) r15, (long) r13)
            goto L_0x0081
        L_0x0149:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            int r4 = zzd(r1, r13)
            r2.zzc((int) r15, (int) r4)
            goto L_0x0081
        L_0x0158:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            long r13 = zze(r1, r13)
            r2.zzc((int) r15, (long) r13)
            goto L_0x0081
        L_0x0167:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            long r13 = zze(r1, r13)
            r2.zza((int) r15, (long) r13)
            goto L_0x0081
        L_0x0176:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            float r4 = zzc(r1, r13)
            r2.zza((int) r15, (float) r4)
            goto L_0x0081
        L_0x0185:
            boolean r4 = r0.zza(r1, (int) r15, (int) r10)
            if (r4 == 0) goto L_0x0081
            double r13 = zzb(r1, (long) r13)
            r2.zza((int) r15, (double) r13)
            goto L_0x0081
        L_0x0194:
            java.lang.Object r4 = r7.getObject(r1, r13)
            r0.zza((com.google.android.gms.internal.vision.zzmr) r2, (int) r15, (java.lang.Object) r4, (int) r10)
            goto L_0x0081
        L_0x019d:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzlc r13 = r0.zza((int) r10)
            com.google.android.gms.internal.vision.zzle.zzb((int) r4, (java.util.List<?>) r8, (com.google.android.gms.internal.vision.zzmr) r2, (com.google.android.gms.internal.vision.zzlc) r13)
            goto L_0x0081
        L_0x01b0:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            r15 = 1
            com.google.android.gms.internal.vision.zzle.zze(r4, r8, r2, r15)
            goto L_0x0081
        L_0x01c0:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzj(r4, r8, r2, r15)
            goto L_0x0081
        L_0x01d0:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzg(r4, r8, r2, r15)
            goto L_0x0081
        L_0x01e0:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzl(r4, r8, r2, r15)
            goto L_0x0081
        L_0x01f0:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzm(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0200:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzi(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0210:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzn(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0220:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzk(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0230:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzf(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0240:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzh(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0250:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzd(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0260:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzc(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0270:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzb((int) r4, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.vision.zzmr) r2, (boolean) r15)
            goto L_0x0081
        L_0x0280:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zza((int) r4, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.vision.zzmr) r2, (boolean) r15)
            goto L_0x0081
        L_0x0290:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            r15 = 0
            com.google.android.gms.internal.vision.zzle.zze(r4, r8, r2, r15)
            goto L_0x0081
        L_0x02a0:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzj(r4, r8, r2, r15)
            goto L_0x0081
        L_0x02b0:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzg(r4, r8, r2, r15)
            goto L_0x0081
        L_0x02c0:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzl(r4, r8, r2, r15)
            goto L_0x0081
        L_0x02d0:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzm(r4, r8, r2, r15)
            goto L_0x0081
        L_0x02e0:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzi(r4, r8, r2, r15)
            goto L_0x0081
        L_0x02f0:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzb((int) r4, (java.util.List<com.google.android.gms.internal.vision.zzht>) r8, (com.google.android.gms.internal.vision.zzmr) r2)
            goto L_0x0081
        L_0x02ff:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzlc r13 = r0.zza((int) r10)
            com.google.android.gms.internal.vision.zzle.zza((int) r4, (java.util.List<?>) r8, (com.google.android.gms.internal.vision.zzmr) r2, (com.google.android.gms.internal.vision.zzlc) r13)
            goto L_0x0081
        L_0x0312:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zza((int) r4, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.vision.zzmr) r2)
            goto L_0x0081
        L_0x0321:
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            r15 = 0
            com.google.android.gms.internal.vision.zzle.zzn(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0331:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzk(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0341:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzf(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0351:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzh(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0361:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzd(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0371:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzc(r4, r8, r2, r15)
            goto L_0x0081
        L_0x0381:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zzb((int) r4, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.vision.zzmr) r2, (boolean) r15)
            goto L_0x0081
        L_0x0391:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzle.zza((int) r4, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.vision.zzmr) r2, (boolean) r15)
            goto L_0x0081
        L_0x03a1:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            java.lang.Object r8 = r7.getObject(r1, r13)
            com.google.android.gms.internal.vision.zzlc r13 = r0.zza((int) r10)
            r2.zzb((int) r15, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzlc) r13)
            goto L_0x048b
        L_0x03b2:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            long r13 = r7.getLong(r1, r13)
            r2.zze((int) r15, (long) r13)
            goto L_0x048b
        L_0x03bf:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            int r8 = r7.getInt(r1, r13)
            r2.zzf(r15, r8)
            goto L_0x048b
        L_0x03cc:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            long r13 = r7.getLong(r1, r13)
            r2.zzb((int) r15, (long) r13)
            goto L_0x048b
        L_0x03d9:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            int r8 = r7.getInt(r1, r13)
            r2.zza((int) r15, (int) r8)
            goto L_0x048b
        L_0x03e6:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            int r8 = r7.getInt(r1, r13)
            r2.zzb((int) r15, (int) r8)
            goto L_0x048b
        L_0x03f3:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            int r8 = r7.getInt(r1, r13)
            r2.zze((int) r15, (int) r8)
            goto L_0x048b
        L_0x0400:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            java.lang.Object r8 = r7.getObject(r1, r13)
            com.google.android.gms.internal.vision.zzht r8 = (com.google.android.gms.internal.vision.zzht) r8
            r2.zza((int) r15, (com.google.android.gms.internal.vision.zzht) r8)
            goto L_0x048b
        L_0x040f:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            java.lang.Object r8 = r7.getObject(r1, r13)
            com.google.android.gms.internal.vision.zzlc r13 = r0.zza((int) r10)
            r2.zza((int) r15, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzlc) r13)
            goto L_0x048b
        L_0x0420:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            java.lang.Object r8 = r7.getObject(r1, r13)
            zza((int) r15, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzmr) r2)
            goto L_0x048b
        L_0x042c:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            boolean r8 = com.google.android.gms.internal.vision.zzma.zzc(r1, r13)
            r2.zza((int) r15, (boolean) r8)
            goto L_0x048b
        L_0x0438:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            int r8 = r7.getInt(r1, r13)
            r2.zzd((int) r15, (int) r8)
            goto L_0x048b
        L_0x0444:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            long r13 = r7.getLong(r1, r13)
            r2.zzd((int) r15, (long) r13)
            goto L_0x048b
        L_0x0450:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            int r8 = r7.getInt(r1, r13)
            r2.zzc((int) r15, (int) r8)
            goto L_0x048b
        L_0x045c:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            long r13 = r7.getLong(r1, r13)
            r2.zzc((int) r15, (long) r13)
            goto L_0x048b
        L_0x0468:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            long r13 = r7.getLong(r1, r13)
            r2.zza((int) r15, (long) r13)
            goto L_0x048b
        L_0x0474:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            float r8 = com.google.android.gms.internal.vision.zzma.zzd(r1, r13)
            r2.zza((int) r15, (float) r8)
            goto L_0x048b
        L_0x0480:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048b
            double r13 = com.google.android.gms.internal.vision.zzma.zze(r1, r13)
            r2.zza((int) r15, (double) r13)
        L_0x048b:
            int r10 = r10 + 3
            goto L_0x002f
        L_0x048f:
            if (r5 == 0) goto L_0x04a6
            com.google.android.gms.internal.vision.zziq<?> r4 = r0.zzr
            r4.zza(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04a4
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x048f
        L_0x04a4:
            r5 = 0
            goto L_0x048f
        L_0x04a6:
            com.google.android.gms.internal.vision.zzlu<?, ?> r3 = r0.zzq
            zza(r3, r1, (com.google.android.gms.internal.vision.zzmr) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zzb(java.lang.Object, com.google.android.gms.internal.vision.zzmr):void");
    }

    private final <K, V> void zza(zzmr zzmr, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzmr.zza(i, this.zzs.zzb(zzb(i2)), this.zzs.zzc(obj));
        }
    }

    private static <UT, UB> void zza(zzlu<UT, UB> zzlu, T t, zzmr zzmr) throws IOException {
        zzlu.zza(zzlu.zzb(t), zzmr);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:147|148|(1:150)|151|(5:171|153|(2:156|154)|253|(2:158|261)(1:262))(1:249)) */
    /* JADX WARNING: Code restructure failed: missing block: B:148:?, code lost:
        r7.zza(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x05a1, code lost:
        if (r10 == null) goto L_0x05a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x05a3, code lost:
        r10 = r7.zzc(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x05ac, code lost:
        if (r7.zza(r10, r14) == false) goto L_0x05ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x05ae, code lost:
        r14 = r12.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x05b2, code lost:
        if (r14 < r12.zzn) goto L_0x05b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x05b4, code lost:
        r10 = zza((java.lang.Object) r13, r12.zzl[r14], r10, r7);
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x05bf, code lost:
        if (r10 != null) goto L_0x05c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x05c1, code lost:
        r7.zzb((java.lang.Object) r13, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:147:0x059e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r13, com.google.android.gms.internal.vision.zzld r14, com.google.android.gms.internal.vision.zzio r15) throws java.io.IOException {
        /*
            r12 = this;
            java.util.Objects.requireNonNull(r15)
            com.google.android.gms.internal.vision.zzlu<?, ?> r7 = r12.zzq
            com.google.android.gms.internal.vision.zziq<?> r8 = r12.zzr
            r9 = 0
            r0 = r9
            r10 = r0
        L_0x000a:
            int r1 = r14.zza()     // Catch:{ all -> 0x05c5 }
            int r2 = r12.zzg(r1)     // Catch:{ all -> 0x05c5 }
            if (r2 >= 0) goto L_0x0078
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x0030
            int r14 = r12.zzm
        L_0x001b:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x002a
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x001b
        L_0x002a:
            if (r10 == 0) goto L_0x002f
            r7.zzb((java.lang.Object) r13, r10)
        L_0x002f:
            return
        L_0x0030:
            boolean r2 = r12.zzh     // Catch:{ all -> 0x05c5 }
            if (r2 != 0) goto L_0x0036
            r2 = r9
            goto L_0x003d
        L_0x0036:
            com.google.android.gms.internal.vision.zzkk r2 = r12.zzg     // Catch:{ all -> 0x05c5 }
            java.lang.Object r1 = r8.zza(r15, r2, r1)     // Catch:{ all -> 0x05c5 }
            r2 = r1
        L_0x003d:
            if (r2 == 0) goto L_0x0052
            if (r0 != 0) goto L_0x0045
            com.google.android.gms.internal.vision.zziu r0 = r8.zzb(r13)     // Catch:{ all -> 0x05c5 }
        L_0x0045:
            r11 = r0
            r0 = r8
            r1 = r14
            r3 = r15
            r4 = r11
            r5 = r10
            r6 = r7
            java.lang.Object r10 = r0.zza(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x05c5 }
            r0 = r11
            goto L_0x000a
        L_0x0052:
            r7.zza((com.google.android.gms.internal.vision.zzld) r14)     // Catch:{ all -> 0x05c5 }
            if (r10 != 0) goto L_0x005b
            java.lang.Object r10 = r7.zzc(r13)     // Catch:{ all -> 0x05c5 }
        L_0x005b:
            boolean r1 = r7.zza(r10, (com.google.android.gms.internal.vision.zzld) r14)     // Catch:{ all -> 0x05c5 }
            if (r1 != 0) goto L_0x000a
            int r14 = r12.zzm
        L_0x0063:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0072
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x0063
        L_0x0072:
            if (r10 == 0) goto L_0x0077
            r7.zzb((java.lang.Object) r13, r10)
        L_0x0077:
            return
        L_0x0078:
            int r3 = r12.zzd((int) r2)     // Catch:{ all -> 0x05c5 }
            r4 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r3
            int r4 = r4 >>> 20
            r5 = 1048575(0xfffff, float:1.469367E-39)
            switch(r4) {
                case 0: goto L_0x0572;
                case 1: goto L_0x0563;
                case 2: goto L_0x0554;
                case 3: goto L_0x0545;
                case 4: goto L_0x0536;
                case 5: goto L_0x0527;
                case 6: goto L_0x0518;
                case 7: goto L_0x0509;
                case 8: goto L_0x0501;
                case 9: goto L_0x04d0;
                case 10: goto L_0x04c1;
                case 11: goto L_0x04b2;
                case 12: goto L_0x0490;
                case 13: goto L_0x0481;
                case 14: goto L_0x0472;
                case 15: goto L_0x0463;
                case 16: goto L_0x0454;
                case 17: goto L_0x0423;
                case 18: goto L_0x0415;
                case 19: goto L_0x0407;
                case 20: goto L_0x03f9;
                case 21: goto L_0x03eb;
                case 22: goto L_0x03dd;
                case 23: goto L_0x03cf;
                case 24: goto L_0x03c1;
                case 25: goto L_0x03b3;
                case 26: goto L_0x0391;
                case 27: goto L_0x037f;
                case 28: goto L_0x0371;
                case 29: goto L_0x0363;
                case 30: goto L_0x034e;
                case 31: goto L_0x0340;
                case 32: goto L_0x0332;
                case 33: goto L_0x0324;
                case 34: goto L_0x0316;
                case 35: goto L_0x0308;
                case 36: goto L_0x02fa;
                case 37: goto L_0x02ec;
                case 38: goto L_0x02de;
                case 39: goto L_0x02d0;
                case 40: goto L_0x02c2;
                case 41: goto L_0x02b4;
                case 42: goto L_0x02a6;
                case 43: goto L_0x0298;
                case 44: goto L_0x0283;
                case 45: goto L_0x0275;
                case 46: goto L_0x0267;
                case 47: goto L_0x0259;
                case 48: goto L_0x024b;
                case 49: goto L_0x0239;
                case 50: goto L_0x01f7;
                case 51: goto L_0x01e5;
                case 52: goto L_0x01d3;
                case 53: goto L_0x01c1;
                case 54: goto L_0x01af;
                case 55: goto L_0x019d;
                case 56: goto L_0x018b;
                case 57: goto L_0x0179;
                case 58: goto L_0x0167;
                case 59: goto L_0x015f;
                case 60: goto L_0x012e;
                case 61: goto L_0x0120;
                case 62: goto L_0x010e;
                case 63: goto L_0x00e9;
                case 64: goto L_0x00d7;
                case 65: goto L_0x00c5;
                case 66: goto L_0x00b3;
                case 67: goto L_0x00a1;
                case 68: goto L_0x008f;
                default: goto L_0x0087;
            }
        L_0x0087:
            if (r10 != 0) goto L_0x0581
            java.lang.Object r10 = r7.zza()     // Catch:{ zzjn -> 0x059e }
            goto L_0x0581
        L_0x008f:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzlc r5 = r12.zza((int) r2)     // Catch:{ zzjn -> 0x059e }
            java.lang.Object r5 = r14.zzb(r5, (com.google.android.gms.internal.vision.zzio) r15)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x00a1:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzjn -> 0x059e }
            long r5 = r14.zzt()     // Catch:{ zzjn -> 0x059e }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x00b3:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzjn -> 0x059e }
            int r5 = r14.zzs()     // Catch:{ zzjn -> 0x059e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x00c5:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzjn -> 0x059e }
            long r5 = r14.zzr()     // Catch:{ zzjn -> 0x059e }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x00d7:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzjn -> 0x059e }
            int r5 = r14.zzq()     // Catch:{ zzjn -> 0x059e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x00e9:
            int r4 = r14.zzp()     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzjg r6 = r12.zzc((int) r2)     // Catch:{ zzjn -> 0x059e }
            if (r6 == 0) goto L_0x0100
            boolean r6 = r6.zza(r4)     // Catch:{ zzjn -> 0x059e }
            if (r6 == 0) goto L_0x00fa
            goto L_0x0100
        L_0x00fa:
            java.lang.Object r10 = com.google.android.gms.internal.vision.zzle.zza((int) r1, (int) r4, r10, r7)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0100:
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzjn -> 0x059e }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r5, (java.lang.Object) r3)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x010e:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzjn -> 0x059e }
            int r5 = r14.zzo()     // Catch:{ zzjn -> 0x059e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0120:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzht r5 = r14.zzn()     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x012e:
            boolean r4 = r12.zza(r13, (int) r1, (int) r2)     // Catch:{ zzjn -> 0x059e }
            if (r4 == 0) goto L_0x014a
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzjn -> 0x059e }
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzma.zzf(r13, r3)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzlc r6 = r12.zza((int) r2)     // Catch:{ zzjn -> 0x059e }
            java.lang.Object r6 = r14.zza(r6, (com.google.android.gms.internal.vision.zzio) r15)     // Catch:{ zzjn -> 0x059e }
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjf.zza((java.lang.Object) r5, (java.lang.Object) r6)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzjn -> 0x059e }
            goto L_0x015a
        L_0x014a:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzlc r5 = r12.zza((int) r2)     // Catch:{ zzjn -> 0x059e }
            java.lang.Object r5 = r14.zza(r5, (com.google.android.gms.internal.vision.zzio) r15)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r2)     // Catch:{ zzjn -> 0x059e }
        L_0x015a:
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x015f:
            r12.zza((java.lang.Object) r13, (int) r3, (com.google.android.gms.internal.vision.zzld) r14)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0167:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzjn -> 0x059e }
            boolean r5 = r14.zzk()     // Catch:{ zzjn -> 0x059e }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0179:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzjn -> 0x059e }
            int r5 = r14.zzj()     // Catch:{ zzjn -> 0x059e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x018b:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzjn -> 0x059e }
            long r5 = r14.zzi()     // Catch:{ zzjn -> 0x059e }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x019d:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzjn -> 0x059e }
            int r5 = r14.zzh()     // Catch:{ zzjn -> 0x059e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x01af:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzjn -> 0x059e }
            long r5 = r14.zzf()     // Catch:{ zzjn -> 0x059e }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x01c1:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzjn -> 0x059e }
            long r5 = r14.zzg()     // Catch:{ zzjn -> 0x059e }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x01d3:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzjn -> 0x059e }
            float r5 = r14.zze()     // Catch:{ zzjn -> 0x059e }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x01e5:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzjn -> 0x059e }
            double r5 = r14.zzd()     // Catch:{ zzjn -> 0x059e }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x01f7:
            java.lang.Object r1 = r12.zzb((int) r2)     // Catch:{ zzjn -> 0x059e }
            int r2 = r12.zzd((int) r2)     // Catch:{ zzjn -> 0x059e }
            r2 = r2 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzma.zzf(r13, r2)     // Catch:{ zzjn -> 0x059e }
            if (r4 != 0) goto L_0x0211
            com.google.android.gms.internal.vision.zzkh r4 = r12.zzs     // Catch:{ zzjn -> 0x059e }
            java.lang.Object r4 = r4.zzf(r1)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r2, (java.lang.Object) r4)     // Catch:{ zzjn -> 0x059e }
            goto L_0x0228
        L_0x0211:
            com.google.android.gms.internal.vision.zzkh r5 = r12.zzs     // Catch:{ zzjn -> 0x059e }
            boolean r5 = r5.zzd(r4)     // Catch:{ zzjn -> 0x059e }
            if (r5 == 0) goto L_0x0228
            com.google.android.gms.internal.vision.zzkh r5 = r12.zzs     // Catch:{ zzjn -> 0x059e }
            java.lang.Object r5 = r5.zzf(r1)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzkh r6 = r12.zzs     // Catch:{ zzjn -> 0x059e }
            r6.zza(r5, r4)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r2, (java.lang.Object) r5)     // Catch:{ zzjn -> 0x059e }
            r4 = r5
        L_0x0228:
            com.google.android.gms.internal.vision.zzkh r2 = r12.zzs     // Catch:{ zzjn -> 0x059e }
            java.util.Map r2 = r2.zza(r4)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzkh r3 = r12.zzs     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzkf r1 = r3.zzb(r1)     // Catch:{ zzjn -> 0x059e }
            r14.zza(r2, r1, (com.google.android.gms.internal.vision.zzio) r15)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0239:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzlc r1 = r12.zza((int) r2)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzju r2 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzjn -> 0x059e }
            r14.zzb(r2, r1, r15)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x024b:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzq(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0259:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzp(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0267:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzo(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0275:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzn(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0283:
            com.google.android.gms.internal.vision.zzju r4 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzjn -> 0x059e }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzjn -> 0x059e }
            r14.zzm(r3)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzjg r2 = r12.zzc((int) r2)     // Catch:{ zzjn -> 0x059e }
            java.lang.Object r10 = com.google.android.gms.internal.vision.zzle.zza(r1, r3, r2, r10, r7)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0298:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzl(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x02a6:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzh(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x02b4:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzg(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x02c2:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzf(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x02d0:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zze(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x02de:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzc(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x02ec:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzd(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x02fa:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzb(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0308:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zza(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0316:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzq(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0324:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzp(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0332:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzo(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0340:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzn(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x034e:
            com.google.android.gms.internal.vision.zzju r4 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzjn -> 0x059e }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzjn -> 0x059e }
            r14.zzm(r3)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzjg r2 = r12.zzc((int) r2)     // Catch:{ zzjn -> 0x059e }
            java.lang.Object r10 = com.google.android.gms.internal.vision.zzle.zza(r1, r3, r2, r10, r7)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0363:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzl(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0371:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzk(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x037f:
            com.google.android.gms.internal.vision.zzlc r1 = r12.zza((int) r2)     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzju r4 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            java.util.List r2 = r4.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zza(r2, r1, (com.google.android.gms.internal.vision.zzio) r15)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0391:
            boolean r1 = zzf(r3)     // Catch:{ zzjn -> 0x059e }
            if (r1 == 0) goto L_0x03a5
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzj(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x03a5:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzi(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x03b3:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzh(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x03c1:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzg(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x03cf:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzf(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x03dd:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zze(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x03eb:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzc(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x03f9:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzd(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0407:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zzb(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0415:
            com.google.android.gms.internal.vision.zzju r1 = r12.zzp     // Catch:{ zzjn -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzjn -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzjn -> 0x059e }
            r14.zza(r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0423:
            boolean r1 = r12.zza(r13, (int) r2)     // Catch:{ zzjn -> 0x059e }
            if (r1 == 0) goto L_0x0441
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzjn -> 0x059e }
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzma.zzf(r13, r3)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzlc r2 = r12.zza((int) r2)     // Catch:{ zzjn -> 0x059e }
            java.lang.Object r2 = r14.zzb(r2, (com.google.android.gms.internal.vision.zzio) r15)     // Catch:{ zzjn -> 0x059e }
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzjf.zza((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0441:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzlc r1 = r12.zza((int) r2)     // Catch:{ zzjn -> 0x059e }
            java.lang.Object r1 = r14.zzb(r1, (com.google.android.gms.internal.vision.zzio) r15)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0454:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzjn -> 0x059e }
            long r5 = r14.zzt()     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0463:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzjn -> 0x059e }
            int r1 = r14.zzs()     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0472:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzjn -> 0x059e }
            long r5 = r14.zzr()     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0481:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzjn -> 0x059e }
            int r1 = r14.zzq()     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0490:
            int r4 = r14.zzp()     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzjg r6 = r12.zzc((int) r2)     // Catch:{ zzjn -> 0x059e }
            if (r6 == 0) goto L_0x04a7
            boolean r6 = r6.zza(r4)     // Catch:{ zzjn -> 0x059e }
            if (r6 == 0) goto L_0x04a1
            goto L_0x04a7
        L_0x04a1:
            java.lang.Object r10 = com.google.android.gms.internal.vision.zzle.zza((int) r1, (int) r4, r10, r7)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x04a7:
            r1 = r3 & r5
            long r5 = (long) r1     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r5, (int) r4)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x04b2:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzjn -> 0x059e }
            int r1 = r14.zzo()     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x04c1:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzht r1 = r14.zzn()     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x04d0:
            boolean r1 = r12.zza(r13, (int) r2)     // Catch:{ zzjn -> 0x059e }
            if (r1 == 0) goto L_0x04ee
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzjn -> 0x059e }
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzma.zzf(r13, r3)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzlc r2 = r12.zza((int) r2)     // Catch:{ zzjn -> 0x059e }
            java.lang.Object r2 = r14.zza(r2, (com.google.android.gms.internal.vision.zzio) r15)     // Catch:{ zzjn -> 0x059e }
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzjf.zza((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x04ee:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzlc r1 = r12.zza((int) r2)     // Catch:{ zzjn -> 0x059e }
            java.lang.Object r1 = r14.zza(r1, (com.google.android.gms.internal.vision.zzio) r15)     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0501:
            r12.zza((java.lang.Object) r13, (int) r3, (com.google.android.gms.internal.vision.zzld) r14)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0509:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzjn -> 0x059e }
            boolean r1 = r14.zzk()     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (boolean) r1)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0518:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzjn -> 0x059e }
            int r1 = r14.zzj()     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0527:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzjn -> 0x059e }
            long r5 = r14.zzi()     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0536:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzjn -> 0x059e }
            int r1 = r14.zzh()     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0545:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzjn -> 0x059e }
            long r5 = r14.zzf()     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0554:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzjn -> 0x059e }
            long r5 = r14.zzg()     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0563:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzjn -> 0x059e }
            float r1 = r14.zze()     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (float) r1)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0572:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzjn -> 0x059e }
            double r5 = r14.zzd()     // Catch:{ zzjn -> 0x059e }
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r13, (long) r3, (double) r5)     // Catch:{ zzjn -> 0x059e }
            r12.zzb(r13, (int) r2)     // Catch:{ zzjn -> 0x059e }
            goto L_0x000a
        L_0x0581:
            boolean r1 = r7.zza(r10, (com.google.android.gms.internal.vision.zzld) r14)     // Catch:{ zzjn -> 0x059e }
            if (r1 != 0) goto L_0x000a
            int r14 = r12.zzm
        L_0x0589:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0598
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x0589
        L_0x0598:
            if (r10 == 0) goto L_0x059d
            r7.zzb((java.lang.Object) r13, r10)
        L_0x059d:
            return
        L_0x059e:
            r7.zza((com.google.android.gms.internal.vision.zzld) r14)     // Catch:{ all -> 0x05c5 }
            if (r10 != 0) goto L_0x05a8
            java.lang.Object r1 = r7.zzc(r13)     // Catch:{ all -> 0x05c5 }
            r10 = r1
        L_0x05a8:
            boolean r1 = r7.zza(r10, (com.google.android.gms.internal.vision.zzld) r14)     // Catch:{ all -> 0x05c5 }
            if (r1 != 0) goto L_0x000a
            int r14 = r12.zzm
        L_0x05b0:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x05bf
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x05b0
        L_0x05bf:
            if (r10 == 0) goto L_0x05c4
            r7.zzb((java.lang.Object) r13, r10)
        L_0x05c4:
            return
        L_0x05c5:
            r14 = move-exception
            int r15 = r12.zzm
        L_0x05c8:
            int r0 = r12.zzn
            if (r15 >= r0) goto L_0x05d7
            int[] r0 = r12.zzl
            r0 = r0[r15]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r0, r10, r7)
            int r15 = r15 + 1
            goto L_0x05c8
        L_0x05d7:
            if (r10 == 0) goto L_0x05dc
            r7.zzb((java.lang.Object) r13, r10)
        L_0x05dc:
            goto L_0x05de
        L_0x05dd:
            throw r14
        L_0x05de:
            goto L_0x05dd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zza(java.lang.Object, com.google.android.gms.internal.vision.zzld, com.google.android.gms.internal.vision.zzio):void");
    }

    private static zzlx zze(Object obj) {
        zzjb zzjb = (zzjb) obj;
        zzlx zzlx = zzjb.zzb;
        if (zzlx != zzlx.zza()) {
            return zzlx;
        }
        zzlx zzb2 = zzlx.zzb();
        zzjb.zzb = zzb2;
        return zzb2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r2 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(byte[] r1, int r2, int r3, com.google.android.gms.internal.vision.zzml r4, java.lang.Class<?> r5, com.google.android.gms.internal.vision.zzhn r6) throws java.io.IOException {
        /*
            int[] r0 = com.google.android.gms.internal.vision.zzkr.zza
            int r4 = r4.ordinal()
            r4 = r0[r4]
            switch(r4) {
                case 1: goto L_0x0099;
                case 2: goto L_0x0094;
                case 3: goto L_0x0087;
                case 4: goto L_0x007a;
                case 5: goto L_0x007a;
                case 6: goto L_0x006f;
                case 7: goto L_0x006f;
                case 8: goto L_0x0064;
                case 9: goto L_0x0057;
                case 10: goto L_0x0057;
                case 11: goto L_0x0057;
                case 12: goto L_0x004a;
                case 13: goto L_0x004a;
                case 14: goto L_0x003d;
                case 15: goto L_0x002b;
                case 16: goto L_0x0019;
                case 17: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "unsupported field type."
            r1.<init>(r2)
            throw r1
        L_0x0013:
            int r1 = com.google.android.gms.internal.vision.zzhl.zzd(r1, r2, r6)
            goto L_0x00ae
        L_0x0019:
            int r1 = com.google.android.gms.internal.vision.zzhl.zzb(r1, r2, r6)
            long r2 = r6.zzb
            long r2 = com.google.android.gms.internal.vision.zzif.zza((long) r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zzc = r2
            goto L_0x00ae
        L_0x002b:
            int r1 = com.google.android.gms.internal.vision.zzhl.zza(r1, r2, r6)
            int r2 = r6.zza
            int r2 = com.google.android.gms.internal.vision.zzif.zze(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zzc = r2
            goto L_0x00ae
        L_0x003d:
            com.google.android.gms.internal.vision.zzky r4 = com.google.android.gms.internal.vision.zzky.zza()
            com.google.android.gms.internal.vision.zzlc r4 = r4.zza(r5)
            int r1 = com.google.android.gms.internal.vision.zzhl.zza((com.google.android.gms.internal.vision.zzlc) r4, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.zzhn) r6)
            goto L_0x00ae
        L_0x004a:
            int r1 = com.google.android.gms.internal.vision.zzhl.zzb(r1, r2, r6)
            long r2 = r6.zzb
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zzc = r2
            goto L_0x00ae
        L_0x0057:
            int r1 = com.google.android.gms.internal.vision.zzhl.zza(r1, r2, r6)
            int r2 = r6.zza
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zzc = r2
            goto L_0x00ae
        L_0x0064:
            float r1 = com.google.android.gms.internal.vision.zzhl.zzd(r1, r2)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r6.zzc = r1
            goto L_0x0084
        L_0x006f:
            long r3 = com.google.android.gms.internal.vision.zzhl.zzb(r1, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r6.zzc = r1
            goto L_0x0091
        L_0x007a:
            int r1 = com.google.android.gms.internal.vision.zzhl.zza(r1, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r6.zzc = r1
        L_0x0084:
            int r1 = r2 + 4
            goto L_0x00ae
        L_0x0087:
            double r3 = com.google.android.gms.internal.vision.zzhl.zzc(r1, r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r6.zzc = r1
        L_0x0091:
            int r1 = r2 + 8
            goto L_0x00ae
        L_0x0094:
            int r1 = com.google.android.gms.internal.vision.zzhl.zze(r1, r2, r6)
            goto L_0x00ae
        L_0x0099:
            int r1 = com.google.android.gms.internal.vision.zzhl.zzb(r1, r2, r6)
            long r2 = r6.zzb
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00a7
            r2 = 1
            goto L_0x00a8
        L_0x00a7:
            r2 = 0
        L_0x00a8:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r6.zzc = r2
        L_0x00ae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zza(byte[], int, int, com.google.android.gms.internal.vision.zzml, java.lang.Class, com.google.android.gms.internal.vision.zzhn):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0420 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x041f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x041f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01e8  */
    private final int zza(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.vision.zzhn r29) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r20
            r6 = r22
            r8 = r23
            r9 = r27
            r7 = r29
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r12 = r11.getObject(r1, r9)
            com.google.android.gms.internal.vision.zzjl r12 = (com.google.android.gms.internal.vision.zzjl) r12
            boolean r13 = r12.zza()
            r14 = 1
            if (r13 != 0) goto L_0x0033
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002b
            r13 = 10
            goto L_0x002c
        L_0x002b:
            int r13 = r13 << r14
        L_0x002c:
            com.google.android.gms.internal.vision.zzjl r12 = r12.zza(r13)
            r11.putObject(r1, r9, r12)
        L_0x0033:
            r9 = 5
            r10 = 0
            r13 = 2
            switch(r26) {
                case 18: goto L_0x03e1;
                case 19: goto L_0x03a3;
                case 20: goto L_0x0362;
                case 21: goto L_0x0362;
                case 22: goto L_0x0348;
                case 23: goto L_0x0309;
                case 24: goto L_0x02ca;
                case 25: goto L_0x0273;
                case 26: goto L_0x01c0;
                case 27: goto L_0x01a6;
                case 28: goto L_0x014e;
                case 29: goto L_0x0348;
                case 30: goto L_0x0116;
                case 31: goto L_0x02ca;
                case 32: goto L_0x0309;
                case 33: goto L_0x00c9;
                case 34: goto L_0x007c;
                case 35: goto L_0x03e1;
                case 36: goto L_0x03a3;
                case 37: goto L_0x0362;
                case 38: goto L_0x0362;
                case 39: goto L_0x0348;
                case 40: goto L_0x0309;
                case 41: goto L_0x02ca;
                case 42: goto L_0x0273;
                case 43: goto L_0x0348;
                case 44: goto L_0x0116;
                case 45: goto L_0x02ca;
                case 46: goto L_0x0309;
                case 47: goto L_0x00c9;
                case 48: goto L_0x007c;
                case 49: goto L_0x003c;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x041f
        L_0x003c:
            r1 = 3
            if (r6 != r1) goto L_0x041f
            com.google.android.gms.internal.vision.zzlc r1 = r15.zza((int) r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.vision.zzhl.zza((com.google.android.gms.internal.vision.zzlc) r21, (byte[]) r22, (int) r23, (int) r24, (int) r25, (com.google.android.gms.internal.vision.zzhn) r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
        L_0x005c:
            if (r4 >= r5) goto L_0x041f
            int r8 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r7)
            int r9 = r7.zza
            if (r2 != r9) goto L_0x041f
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.vision.zzhl.zza((com.google.android.gms.internal.vision.zzlc) r21, (byte[]) r22, (int) r23, (int) r24, (int) r25, (com.google.android.gms.internal.vision.zzhn) r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x005c
        L_0x007c:
            if (r6 != r13) goto L_0x00a0
            com.google.android.gms.internal.vision.zzjy r12 = (com.google.android.gms.internal.vision.zzjy) r12
            int r1 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0087:
            if (r1 >= r2) goto L_0x0097
            int r1 = com.google.android.gms.internal.vision.zzhl.zzb(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.vision.zzif.zza((long) r4)
            r12.zza((long) r4)
            goto L_0x0087
        L_0x0097:
            if (r1 != r2) goto L_0x009b
            goto L_0x0420
        L_0x009b:
            com.google.android.gms.internal.vision.zzjk r1 = com.google.android.gms.internal.vision.zzjk.zza()
            throw r1
        L_0x00a0:
            if (r6 != 0) goto L_0x041f
            com.google.android.gms.internal.vision.zzjy r12 = (com.google.android.gms.internal.vision.zzjy) r12
            int r1 = com.google.android.gms.internal.vision.zzhl.zzb(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.vision.zzif.zza((long) r8)
            r12.zza((long) r8)
        L_0x00b1:
            if (r1 >= r5) goto L_0x0420
            int r4 = com.google.android.gms.internal.vision.zzhl.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0420
            int r1 = com.google.android.gms.internal.vision.zzhl.zzb(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.vision.zzif.zza((long) r8)
            r12.zza((long) r8)
            goto L_0x00b1
        L_0x00c9:
            if (r6 != r13) goto L_0x00ed
            com.google.android.gms.internal.vision.zzjd r12 = (com.google.android.gms.internal.vision.zzjd) r12
            int r1 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00d4:
            if (r1 >= r2) goto L_0x00e4
            int r1 = com.google.android.gms.internal.vision.zzhl.zza(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.vision.zzif.zze(r4)
            r12.zzc(r4)
            goto L_0x00d4
        L_0x00e4:
            if (r1 != r2) goto L_0x00e8
            goto L_0x0420
        L_0x00e8:
            com.google.android.gms.internal.vision.zzjk r1 = com.google.android.gms.internal.vision.zzjk.zza()
            throw r1
        L_0x00ed:
            if (r6 != 0) goto L_0x041f
            com.google.android.gms.internal.vision.zzjd r12 = (com.google.android.gms.internal.vision.zzjd) r12
            int r1 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.vision.zzif.zze(r4)
            r12.zzc(r4)
        L_0x00fe:
            if (r1 >= r5) goto L_0x0420
            int r4 = com.google.android.gms.internal.vision.zzhl.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0420
            int r1 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.vision.zzif.zze(r4)
            r12.zzc(r4)
            goto L_0x00fe
        L_0x0116:
            if (r6 != r13) goto L_0x011d
            int r2 = com.google.android.gms.internal.vision.zzhl.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.vision.zzjl<?>) r12, (com.google.android.gms.internal.vision.zzhn) r7)
            goto L_0x012e
        L_0x011d:
            if (r6 != 0) goto L_0x041f
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = com.google.android.gms.internal.vision.zzhl.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.vision.zzjl<?>) r6, (com.google.android.gms.internal.vision.zzhn) r7)
        L_0x012e:
            com.google.android.gms.internal.vision.zzjb r1 = (com.google.android.gms.internal.vision.zzjb) r1
            com.google.android.gms.internal.vision.zzlx r3 = r1.zzb
            com.google.android.gms.internal.vision.zzlx r4 = com.google.android.gms.internal.vision.zzlx.zza()
            if (r3 != r4) goto L_0x0139
            r3 = 0
        L_0x0139:
            com.google.android.gms.internal.vision.zzjg r4 = r15.zzc((int) r8)
            com.google.android.gms.internal.vision.zzlu<?, ?> r5 = r0.zzq
            r6 = r21
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzle.zza(r6, r12, r4, r3, r5)
            com.google.android.gms.internal.vision.zzlx r3 = (com.google.android.gms.internal.vision.zzlx) r3
            if (r3 == 0) goto L_0x014b
            r1.zzb = r3
        L_0x014b:
            r1 = r2
            goto L_0x0420
        L_0x014e:
            if (r6 != r13) goto L_0x041f
            int r1 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01a1
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x019c
            if (r4 != 0) goto L_0x0164
            com.google.android.gms.internal.vision.zzht r4 = com.google.android.gms.internal.vision.zzht.zza
            r12.add(r4)
            goto L_0x016c
        L_0x0164:
            com.google.android.gms.internal.vision.zzht r6 = com.google.android.gms.internal.vision.zzht.zza((byte[]) r3, (int) r1, (int) r4)
            r12.add(r6)
        L_0x016b:
            int r1 = r1 + r4
        L_0x016c:
            if (r1 >= r5) goto L_0x0420
            int r4 = com.google.android.gms.internal.vision.zzhl.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0420
            int r1 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0197
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0192
            if (r4 != 0) goto L_0x018a
            com.google.android.gms.internal.vision.zzht r4 = com.google.android.gms.internal.vision.zzht.zza
            r12.add(r4)
            goto L_0x016c
        L_0x018a:
            com.google.android.gms.internal.vision.zzht r6 = com.google.android.gms.internal.vision.zzht.zza((byte[]) r3, (int) r1, (int) r4)
            r12.add(r6)
            goto L_0x016b
        L_0x0192:
            com.google.android.gms.internal.vision.zzjk r1 = com.google.android.gms.internal.vision.zzjk.zza()
            throw r1
        L_0x0197:
            com.google.android.gms.internal.vision.zzjk r1 = com.google.android.gms.internal.vision.zzjk.zzb()
            throw r1
        L_0x019c:
            com.google.android.gms.internal.vision.zzjk r1 = com.google.android.gms.internal.vision.zzjk.zza()
            throw r1
        L_0x01a1:
            com.google.android.gms.internal.vision.zzjk r1 = com.google.android.gms.internal.vision.zzjk.zzb()
            throw r1
        L_0x01a6:
            if (r6 != r13) goto L_0x041f
            com.google.android.gms.internal.vision.zzlc r1 = r15.zza((int) r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r1 = com.google.android.gms.internal.vision.zzhl.zza(r21, r22, r23, r24, r25, r26, r27)
            goto L_0x0420
        L_0x01c0:
            if (r6 != r13) goto L_0x041f
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 != 0) goto L_0x0213
            int r4 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x020e
            if (r6 != 0) goto L_0x01db
            r12.add(r1)
            goto L_0x01e6
        L_0x01db:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.vision.zzjf.zza
            r8.<init>(r3, r4, r6, r9)
            r12.add(r8)
        L_0x01e5:
            int r4 = r4 + r6
        L_0x01e6:
            if (r4 >= r5) goto L_0x041f
            int r6 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x041f
            int r4 = com.google.android.gms.internal.vision.zzhl.zza(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0209
            if (r6 != 0) goto L_0x01fe
            r12.add(r1)
            goto L_0x01e6
        L_0x01fe:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.vision.zzjf.zza
            r8.<init>(r3, r4, r6, r9)
            r12.add(r8)
            goto L_0x01e5
        L_0x0209:
            com.google.android.gms.internal.vision.zzjk r1 = com.google.android.gms.internal.vision.zzjk.zzb()
            throw r1
        L_0x020e:
            com.google.android.gms.internal.vision.zzjk r1 = com.google.android.gms.internal.vision.zzjk.zzb()
            throw r1
        L_0x0213:
            int r4 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x026e
            if (r6 != 0) goto L_0x0221
            r12.add(r1)
            goto L_0x0234
        L_0x0221:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.vision.zzmd.zza((byte[]) r3, (int) r4, (int) r8)
            if (r9 == 0) goto L_0x0269
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.vision.zzjf.zza
            r9.<init>(r3, r4, r6, r10)
            r12.add(r9)
        L_0x0233:
            r4 = r8
        L_0x0234:
            if (r4 >= r5) goto L_0x041f
            int r6 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x041f
            int r4 = com.google.android.gms.internal.vision.zzhl.zza(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0264
            if (r6 != 0) goto L_0x024c
            r12.add(r1)
            goto L_0x0234
        L_0x024c:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.vision.zzmd.zza((byte[]) r3, (int) r4, (int) r8)
            if (r9 == 0) goto L_0x025f
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.vision.zzjf.zza
            r9.<init>(r3, r4, r6, r10)
            r12.add(r9)
            goto L_0x0233
        L_0x025f:
            com.google.android.gms.internal.vision.zzjk r1 = com.google.android.gms.internal.vision.zzjk.zzh()
            throw r1
        L_0x0264:
            com.google.android.gms.internal.vision.zzjk r1 = com.google.android.gms.internal.vision.zzjk.zzb()
            throw r1
        L_0x0269:
            com.google.android.gms.internal.vision.zzjk r1 = com.google.android.gms.internal.vision.zzjk.zzh()
            throw r1
        L_0x026e:
            com.google.android.gms.internal.vision.zzjk r1 = com.google.android.gms.internal.vision.zzjk.zzb()
            throw r1
        L_0x0273:
            r1 = 0
            if (r6 != r13) goto L_0x029b
            com.google.android.gms.internal.vision.zzhr r12 = (com.google.android.gms.internal.vision.zzhr) r12
            int r2 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x027f:
            if (r2 >= r4) goto L_0x0292
            int r2 = com.google.android.gms.internal.vision.zzhl.zzb(r3, r2, r7)
            long r5 = r7.zzb
            int r8 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x028d
            r5 = 1
            goto L_0x028e
        L_0x028d:
            r5 = 0
        L_0x028e:
            r12.zza((boolean) r5)
            goto L_0x027f
        L_0x0292:
            if (r2 != r4) goto L_0x0296
            goto L_0x014b
        L_0x0296:
            com.google.android.gms.internal.vision.zzjk r1 = com.google.android.gms.internal.vision.zzjk.zza()
            throw r1
        L_0x029b:
            if (r6 != 0) goto L_0x041f
            com.google.android.gms.internal.vision.zzhr r12 = (com.google.android.gms.internal.vision.zzhr) r12
            int r4 = com.google.android.gms.internal.vision.zzhl.zzb(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x02ab
            r6 = 1
            goto L_0x02ac
        L_0x02ab:
            r6 = 0
        L_0x02ac:
            r12.zza((boolean) r6)
        L_0x02af:
            if (r4 >= r5) goto L_0x041f
            int r6 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x041f
            int r4 = com.google.android.gms.internal.vision.zzhl.zzb(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x02c5
            r6 = 1
            goto L_0x02c6
        L_0x02c5:
            r6 = 0
        L_0x02c6:
            r12.zza((boolean) r6)
            goto L_0x02af
        L_0x02ca:
            if (r6 != r13) goto L_0x02ea
            com.google.android.gms.internal.vision.zzjd r12 = (com.google.android.gms.internal.vision.zzjd) r12
            int r1 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02d5:
            if (r1 >= r2) goto L_0x02e1
            int r4 = com.google.android.gms.internal.vision.zzhl.zza(r3, r1)
            r12.zzc(r4)
            int r1 = r1 + 4
            goto L_0x02d5
        L_0x02e1:
            if (r1 != r2) goto L_0x02e5
            goto L_0x0420
        L_0x02e5:
            com.google.android.gms.internal.vision.zzjk r1 = com.google.android.gms.internal.vision.zzjk.zza()
            throw r1
        L_0x02ea:
            if (r6 != r9) goto L_0x041f
            com.google.android.gms.internal.vision.zzjd r12 = (com.google.android.gms.internal.vision.zzjd) r12
            int r1 = com.google.android.gms.internal.vision.zzhl.zza(r17, r18)
            r12.zzc(r1)
        L_0x02f5:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0420
            int r4 = com.google.android.gms.internal.vision.zzhl.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0420
            int r1 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4)
            r12.zzc(r1)
            goto L_0x02f5
        L_0x0309:
            if (r6 != r13) goto L_0x0329
            com.google.android.gms.internal.vision.zzjy r12 = (com.google.android.gms.internal.vision.zzjy) r12
            int r1 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0314:
            if (r1 >= r2) goto L_0x0320
            long r4 = com.google.android.gms.internal.vision.zzhl.zzb(r3, r1)
            r12.zza((long) r4)
            int r1 = r1 + 8
            goto L_0x0314
        L_0x0320:
            if (r1 != r2) goto L_0x0324
            goto L_0x0420
        L_0x0324:
            com.google.android.gms.internal.vision.zzjk r1 = com.google.android.gms.internal.vision.zzjk.zza()
            throw r1
        L_0x0329:
            if (r6 != r14) goto L_0x041f
            com.google.android.gms.internal.vision.zzjy r12 = (com.google.android.gms.internal.vision.zzjy) r12
            long r8 = com.google.android.gms.internal.vision.zzhl.zzb(r17, r18)
            r12.zza((long) r8)
        L_0x0334:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0420
            int r4 = com.google.android.gms.internal.vision.zzhl.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0420
            long r8 = com.google.android.gms.internal.vision.zzhl.zzb(r3, r4)
            r12.zza((long) r8)
            goto L_0x0334
        L_0x0348:
            if (r6 != r13) goto L_0x0350
            int r1 = com.google.android.gms.internal.vision.zzhl.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.vision.zzjl<?>) r12, (com.google.android.gms.internal.vision.zzhn) r7)
            goto L_0x0420
        L_0x0350:
            if (r6 != 0) goto L_0x041f
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r12
            r25 = r29
            int r1 = com.google.android.gms.internal.vision.zzhl.zza((int) r20, (byte[]) r21, (int) r22, (int) r23, (com.google.android.gms.internal.vision.zzjl<?>) r24, (com.google.android.gms.internal.vision.zzhn) r25)
            goto L_0x0420
        L_0x0362:
            if (r6 != r13) goto L_0x0382
            com.google.android.gms.internal.vision.zzjy r12 = (com.google.android.gms.internal.vision.zzjy) r12
            int r1 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x036d:
            if (r1 >= r2) goto L_0x0379
            int r1 = com.google.android.gms.internal.vision.zzhl.zzb(r3, r1, r7)
            long r4 = r7.zzb
            r12.zza((long) r4)
            goto L_0x036d
        L_0x0379:
            if (r1 != r2) goto L_0x037d
            goto L_0x0420
        L_0x037d:
            com.google.android.gms.internal.vision.zzjk r1 = com.google.android.gms.internal.vision.zzjk.zza()
            throw r1
        L_0x0382:
            if (r6 != 0) goto L_0x041f
            com.google.android.gms.internal.vision.zzjy r12 = (com.google.android.gms.internal.vision.zzjy) r12
            int r1 = com.google.android.gms.internal.vision.zzhl.zzb(r3, r4, r7)
            long r8 = r7.zzb
            r12.zza((long) r8)
        L_0x038f:
            if (r1 >= r5) goto L_0x0420
            int r4 = com.google.android.gms.internal.vision.zzhl.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0420
            int r1 = com.google.android.gms.internal.vision.zzhl.zzb(r3, r4, r7)
            long r8 = r7.zzb
            r12.zza((long) r8)
            goto L_0x038f
        L_0x03a3:
            if (r6 != r13) goto L_0x03c2
            com.google.android.gms.internal.vision.zzja r12 = (com.google.android.gms.internal.vision.zzja) r12
            int r1 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03ae:
            if (r1 >= r2) goto L_0x03ba
            float r4 = com.google.android.gms.internal.vision.zzhl.zzd(r3, r1)
            r12.zza((float) r4)
            int r1 = r1 + 4
            goto L_0x03ae
        L_0x03ba:
            if (r1 != r2) goto L_0x03bd
            goto L_0x0420
        L_0x03bd:
            com.google.android.gms.internal.vision.zzjk r1 = com.google.android.gms.internal.vision.zzjk.zza()
            throw r1
        L_0x03c2:
            if (r6 != r9) goto L_0x041f
            com.google.android.gms.internal.vision.zzja r12 = (com.google.android.gms.internal.vision.zzja) r12
            float r1 = com.google.android.gms.internal.vision.zzhl.zzd(r17, r18)
            r12.zza((float) r1)
        L_0x03cd:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0420
            int r4 = com.google.android.gms.internal.vision.zzhl.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0420
            float r1 = com.google.android.gms.internal.vision.zzhl.zzd(r3, r4)
            r12.zza((float) r1)
            goto L_0x03cd
        L_0x03e1:
            if (r6 != r13) goto L_0x0400
            com.google.android.gms.internal.vision.zzin r12 = (com.google.android.gms.internal.vision.zzin) r12
            int r1 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03ec:
            if (r1 >= r2) goto L_0x03f8
            double r4 = com.google.android.gms.internal.vision.zzhl.zzc(r3, r1)
            r12.zza((double) r4)
            int r1 = r1 + 8
            goto L_0x03ec
        L_0x03f8:
            if (r1 != r2) goto L_0x03fb
            goto L_0x0420
        L_0x03fb:
            com.google.android.gms.internal.vision.zzjk r1 = com.google.android.gms.internal.vision.zzjk.zza()
            throw r1
        L_0x0400:
            if (r6 != r14) goto L_0x041f
            com.google.android.gms.internal.vision.zzin r12 = (com.google.android.gms.internal.vision.zzin) r12
            double r8 = com.google.android.gms.internal.vision.zzhl.zzc(r17, r18)
            r12.zza((double) r8)
        L_0x040b:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0420
            int r4 = com.google.android.gms.internal.vision.zzhl.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0420
            double r8 = com.google.android.gms.internal.vision.zzhl.zzc(r3, r4)
            r12.zza((double) r8)
            goto L_0x040b
        L_0x041f:
            r1 = r4
        L_0x0420:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.vision.zzhn):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int zza(T r8, byte[] r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.vision.zzhn r15) throws java.io.IOException {
        /*
            r7 = this;
            sun.misc.Unsafe r0 = zzb
            java.lang.Object r12 = r7.zzb((int) r12)
            java.lang.Object r1 = r0.getObject(r8, r13)
            com.google.android.gms.internal.vision.zzkh r2 = r7.zzs
            boolean r2 = r2.zzd(r1)
            if (r2 == 0) goto L_0x0021
            com.google.android.gms.internal.vision.zzkh r2 = r7.zzs
            java.lang.Object r2 = r2.zzf(r12)
            com.google.android.gms.internal.vision.zzkh r3 = r7.zzs
            r3.zza(r2, r1)
            r0.putObject(r8, r13, r2)
            r1 = r2
        L_0x0021:
            com.google.android.gms.internal.vision.zzkh r8 = r7.zzs
            com.google.android.gms.internal.vision.zzkf r8 = r8.zzb(r12)
            com.google.android.gms.internal.vision.zzkh r12 = r7.zzs
            java.util.Map r12 = r12.zza(r1)
            int r10 = com.google.android.gms.internal.vision.zzhl.zza(r9, r10, r15)
            int r13 = r15.zza
            if (r13 < 0) goto L_0x0097
            int r14 = r11 - r10
            if (r13 > r14) goto L_0x0097
            int r13 = r13 + r10
            K r14 = r8.zzb
            V r0 = r8.zzd
        L_0x003e:
            if (r10 >= r13) goto L_0x008c
            int r1 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x004c
            int r1 = com.google.android.gms.internal.vision.zzhl.zza((int) r10, (byte[]) r9, (int) r1, (com.google.android.gms.internal.vision.zzhn) r15)
            int r10 = r15.zza
        L_0x004c:
            r2 = r1
            int r1 = r10 >>> 3
            r3 = r10 & 7
            r4 = 1
            if (r1 == r4) goto L_0x0072
            r4 = 2
            if (r1 == r4) goto L_0x0058
            goto L_0x0087
        L_0x0058:
            com.google.android.gms.internal.vision.zzml r1 = r8.zzc
            int r1 = r1.zzb()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.vision.zzml r4 = r8.zzc
            V r10 = r8.zzd
            java.lang.Class r5 = r10.getClass()
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.zzml) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.vision.zzhn) r6)
            java.lang.Object r0 = r15.zzc
            goto L_0x003e
        L_0x0072:
            com.google.android.gms.internal.vision.zzml r1 = r8.zza
            int r1 = r1.zzb()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.vision.zzml r4 = r8.zza
            r5 = 0
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.zzml) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.vision.zzhn) r6)
            java.lang.Object r14 = r15.zzc
            goto L_0x003e
        L_0x0087:
            int r10 = com.google.android.gms.internal.vision.zzhl.zza((int) r10, (byte[]) r9, (int) r2, (int) r11, (com.google.android.gms.internal.vision.zzhn) r15)
            goto L_0x003e
        L_0x008c:
            if (r10 != r13) goto L_0x0092
            r12.put(r14, r0)
            return r13
        L_0x0092:
            com.google.android.gms.internal.vision.zzjk r8 = com.google.android.gms.internal.vision.zzjk.zzg()
            throw r8
        L_0x0097:
            com.google.android.gms.internal.vision.zzjk r8 = com.google.android.gms.internal.vision.zzjk.zza()
            goto L_0x009d
        L_0x009c:
            throw r8
        L_0x009d:
            goto L_0x009c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zza(java.lang.Object, byte[], int, int, int, long, com.google.android.gms.internal.vision.zzhn):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x018a, code lost:
        r2 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x019b, code lost:
        r2 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x019d, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.vision.zzhn r29) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = zzb
            int[] r7 = r0.zzc
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x018d;
                case 52: goto L_0x017d;
                case 53: goto L_0x016d;
                case 54: goto L_0x016d;
                case 55: goto L_0x015d;
                case 56: goto L_0x014e;
                case 57: goto L_0x0140;
                case 58: goto L_0x0127;
                case 59: goto L_0x00f3;
                case 60: goto L_0x00c5;
                case 61: goto L_0x00b8;
                case 62: goto L_0x015d;
                case 63: goto L_0x008a;
                case 64: goto L_0x0140;
                case 65: goto L_0x014e;
                case 66: goto L_0x0075;
                case 67: goto L_0x0060;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x01a1
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x01a1
            r2 = r2 & -8
            r7 = r2 | 4
            com.google.android.gms.internal.vision.zzlc r2 = r0.zza((int) r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = com.google.android.gms.internal.vision.zzhl.zza((com.google.android.gms.internal.vision.zzlc) r2, (byte[]) r3, (int) r4, (int) r5, (int) r6, (com.google.android.gms.internal.vision.zzhn) r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            if (r15 != 0) goto L_0x0055
            java.lang.Object r3 = r11.zzc
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0055:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzjf.zza((java.lang.Object) r15, (java.lang.Object) r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0060:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.zzhl.zzb(r3, r4, r11)
            long r3 = r11.zzb
            long r3 = com.google.android.gms.internal.vision.zzif.zza((long) r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0075:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r11)
            int r3 = r11.zza
            int r3 = com.google.android.gms.internal.vision.zzif.zze(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x008a:
            if (r5 != 0) goto L_0x01a1
            int r3 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r11)
            int r4 = r11.zza
            com.google.android.gms.internal.vision.zzjg r5 = r0.zzc((int) r6)
            if (r5 == 0) goto L_0x00ae
            boolean r5 = r5.zza(r4)
            if (r5 == 0) goto L_0x009f
            goto L_0x00ae
        L_0x009f:
            com.google.android.gms.internal.vision.zzlx r1 = zze((java.lang.Object) r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.zza((int) r2, (java.lang.Object) r4)
            r2 = r3
            goto L_0x01a2
        L_0x00ae:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x019d
        L_0x00b8:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.zzhl.zze(r3, r4, r11)
            java.lang.Object r3 = r11.zzc
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x00c5:
            if (r5 != r15) goto L_0x01a1
            com.google.android.gms.internal.vision.zzlc r2 = r0.zza((int) r6)
            r5 = r20
            int r2 = com.google.android.gms.internal.vision.zzhl.zza((com.google.android.gms.internal.vision.zzlc) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.vision.zzhn) r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00dc
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00dd
        L_0x00dc:
            r15 = 0
        L_0x00dd:
            if (r15 != 0) goto L_0x00e5
            java.lang.Object r3 = r11.zzc
            r12.putObject(r1, r9, r3)
            goto L_0x00ee
        L_0x00e5:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzjf.zza((java.lang.Object) r15, (java.lang.Object) r3)
            r12.putObject(r1, r9, r3)
        L_0x00ee:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x00f3:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r11)
            int r4 = r11.zza
            if (r4 != 0) goto L_0x0103
            java.lang.String r3 = ""
            r12.putObject(r1, r9, r3)
            goto L_0x0122
        L_0x0103:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x0117
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.vision.zzmd.zza((byte[]) r3, (int) r2, (int) r5)
            if (r5 == 0) goto L_0x0112
            goto L_0x0117
        L_0x0112:
            com.google.android.gms.internal.vision.zzjk r1 = com.google.android.gms.internal.vision.zzjk.zzh()
            throw r1
        L_0x0117:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.vision.zzjf.zza
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
        L_0x0122:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x0127:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.zzhl.zzb(r3, r4, r11)
            long r3 = r11.zzb
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0137
            r15 = 1
            goto L_0x0138
        L_0x0137:
            r15 = 0
        L_0x0138:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0140:
            if (r5 != r7) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.zzhl.zza(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x018a
        L_0x014e:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            long r2 = com.google.android.gms.internal.vision.zzhl.zzb(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x019b
        L_0x015d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.zzhl.zza(r3, r4, r11)
            int r3 = r11.zza
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x016d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.zzhl.zzb(r3, r4, r11)
            long r3 = r11.zzb
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x017d:
            if (r5 != r7) goto L_0x01a1
            float r2 = com.google.android.gms.internal.vision.zzhl.zzd(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x018a:
            int r2 = r4 + 4
            goto L_0x019d
        L_0x018d:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            double r2 = com.google.android.gms.internal.vision.zzhl.zzc(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x019b:
            int r2 = r4 + 8
        L_0x019d:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x01a1:
            r2 = r4
        L_0x01a2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zza(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.vision.zzhn):int");
    }

    private final zzlc zza(int i) {
        int i2 = (i / 3) << 1;
        zzlc zzlc = (zzlc) this.zzd[i2];
        if (zzlc != null) {
            return zzlc;
        }
        zzlc zza2 = zzky.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zza2;
        return zza2;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final zzjg zzc(int i) {
        return (zzjg) this.zzd[((i / 3) << 1) + 1];
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.google.android.gms.internal.vision.zzlx} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02f9, code lost:
        r5 = r6 | r24;
        r11 = r39;
        r3 = r0;
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02ff, code lost:
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0300, code lost:
        r2 = r13;
        r6 = r21;
        r13 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0307, code lost:
        r15 = r39;
        r24 = r6;
        r23 = r7;
        r31 = r10;
        r2 = r11;
        r18 = r13;
        r6 = r21;
        r7 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03be, code lost:
        if (r0 == r22) goto L_0x042b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0405, code lost:
        if (r0 == r14) goto L_0x042b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x05bd, code lost:
        r2 = r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x05cc, code lost:
        r2 = r2 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a8, code lost:
        r13 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0187, code lost:
        r0 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01ec, code lost:
        r1 = r6 | r24;
        r11 = r39;
        r3 = r5;
        r2 = r13;
        r6 = r21;
        r5 = r1;
        r13 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0242, code lost:
        r1 = r6 | r24;
        r11 = r39;
        r3 = r5;
        r2 = r13;
        r6 = r21;
        r13 = r38;
        r5 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x024d, code lost:
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0277, code lost:
        r0 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02b9, code lost:
        r5 = r6 | r24;
        r1 = r7;
        r0 = r8;
        r3 = r11;
        r2 = r13;
        r6 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02c3, code lost:
        r0 = r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r35, byte[] r36, int r37, int r38, int r39, com.google.android.gms.internal.vision.zzhn r40) throws java.io.IOException {
        /*
            r34 = this;
            r15 = r34
            r14 = r35
            r12 = r36
            r13 = r38
            r11 = r39
            r9 = r40
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r37
            r1 = -1
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0019:
            if (r0 >= r13) goto L_0x0650
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0028
            int r0 = com.google.android.gms.internal.vision.zzhl.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.vision.zzhn) r9)
            int r3 = r9.zza
            goto L_0x002d
        L_0x0028:
            r32 = r3
            r3 = r0
            r0 = r32
        L_0x002d:
            int r7 = r3 >>> 3
            r8 = r3 & 7
            r4 = 3
            if (r7 <= r1) goto L_0x003a
            int r2 = r2 / r4
            int r1 = r15.zza((int) r7, (int) r2)
            goto L_0x003e
        L_0x003a:
            int r1 = r15.zzg(r7)
        L_0x003e:
            r2 = r1
            r19 = 0
            r4 = -1
            if (r2 != r4) goto L_0x0055
            r2 = r0
            r24 = r5
            r23 = r7
            r31 = r10
            r15 = r11
            r17 = -1
            r18 = 0
            r21 = 1
            r7 = r3
            goto L_0x042f
        L_0x0055:
            int[] r4 = r15.zzc
            int r23 = r2 + 1
            r1 = r4[r23]
            r23 = 267386880(0xff00000, float:2.3665827E-29)
            r23 = r1 & r23
            int r11 = r23 >>> 20
            r17 = r0
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r1 & r13
            long r13 = (long) r0
            r0 = 17
            if (r11 > r0) goto L_0x0319
            int r24 = r2 + 2
            r4 = r4[r24]
            int r24 = r4 >>> 20
            r22 = 1
            int r24 = r22 << r24
            r25 = r13
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r13
            if (r4 == r6) goto L_0x0096
            if (r6 == r13) goto L_0x008a
            long r13 = (long) r6
            r6 = r35
            r27 = r25
            r10.putInt(r6, r13, r5)
            goto L_0x008e
        L_0x008a:
            r6 = r35
            r27 = r25
        L_0x008e:
            long r13 = (long) r4
            int r5 = r10.getInt(r6, r13)
            r13 = r4
            r14 = r6
            goto L_0x009b
        L_0x0096:
            r14 = r35
            r27 = r25
            r13 = r6
        L_0x009b:
            r6 = r5
            r4 = 5
            switch(r11) {
                case 0: goto L_0x02e0;
                case 1: goto L_0x02c5;
                case 2: goto L_0x0299;
                case 3: goto L_0x0299;
                case 4: goto L_0x027a;
                case 5: goto L_0x0250;
                case 6: goto L_0x022a;
                case 7: goto L_0x01f8;
                case 8: goto L_0x01c7;
                case 9: goto L_0x018e;
                case 10: goto L_0x016f;
                case 11: goto L_0x027a;
                case 12: goto L_0x0139;
                case 13: goto L_0x022a;
                case 14: goto L_0x0250;
                case 15: goto L_0x011e;
                case 16: goto L_0x00f6;
                case 17: goto L_0x00ae;
                default: goto L_0x00a0;
            }
        L_0x00a0:
            r0 = r3
            r21 = r13
            r11 = r17
            r4 = 1
            r17 = -1
        L_0x00a8:
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r2
            goto L_0x0307
        L_0x00ae:
            r5 = 3
            if (r8 != r5) goto L_0x00ed
            int r0 = r7 << 3
            r4 = r0 | 4
            com.google.android.gms.internal.vision.zzlc r0 = r15.zza((int) r2)
            r11 = r17
            r1 = r36
            r8 = r2
            r2 = r11
            r11 = r3
            r3 = r38
            r17 = -1
            r5 = r40
            int r0 = com.google.android.gms.internal.vision.zzhl.zza((com.google.android.gms.internal.vision.zzlc) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.vision.zzhn) r5)
            r1 = r6 & r24
            if (r1 != 0) goto L_0x00d6
            java.lang.Object r1 = r9.zzc
            r2 = r27
            r10.putObject(r14, r2, r1)
            goto L_0x00e5
        L_0x00d6:
            r2 = r27
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzjf.zza((java.lang.Object) r1, (java.lang.Object) r4)
            r10.putObject(r14, r2, r1)
        L_0x00e5:
            r5 = r6 | r24
            r1 = r7
            r2 = r8
            r3 = r11
            r6 = r13
            goto L_0x036d
        L_0x00ed:
            r11 = r17
            r17 = -1
            r0 = r3
            r21 = r13
            r4 = 1
            goto L_0x00a8
        L_0x00f6:
            r5 = r2
            r4 = r3
            r11 = r17
            r2 = r27
            r17 = -1
            if (r8 != 0) goto L_0x0118
            int r8 = com.google.android.gms.internal.vision.zzhl.zzb(r12, r11, r9)
            long r0 = r9.zzb
            long r18 = com.google.android.gms.internal.vision.zzif.zza((long) r0)
            r0 = r10
            r1 = r35
            r11 = r4
            r21 = r13
            r13 = r5
            r4 = r18
            r0.putLong(r1, r2, r4)
            goto L_0x02b9
        L_0x0118:
            r21 = r13
            r13 = r5
            r0 = r4
            goto L_0x0188
        L_0x011e:
            r5 = r3
            r21 = r13
            r11 = r17
            r17 = -1
            r13 = r2
            r2 = r27
            if (r8 != 0) goto L_0x0187
            int r0 = com.google.android.gms.internal.vision.zzhl.zza(r12, r11, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.vision.zzif.zze(r1)
            r10.putInt(r14, r2, r1)
            goto L_0x0242
        L_0x0139:
            r5 = r3
            r21 = r13
            r11 = r17
            r17 = -1
            r13 = r2
            r2 = r27
            if (r8 != 0) goto L_0x0187
            int r0 = com.google.android.gms.internal.vision.zzhl.zza(r12, r11, r9)
            int r1 = r9.zza
            com.google.android.gms.internal.vision.zzjg r4 = r15.zzc((int) r13)
            if (r4 == 0) goto L_0x016a
            boolean r4 = r4.zza(r1)
            if (r4 == 0) goto L_0x0158
            goto L_0x016a
        L_0x0158:
            com.google.android.gms.internal.vision.zzlx r2 = zze((java.lang.Object) r35)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zza((int) r5, (java.lang.Object) r1)
            r11 = r39
            r3 = r5
            r5 = r6
            goto L_0x02ff
        L_0x016a:
            r10.putInt(r14, r2, r1)
            goto L_0x0242
        L_0x016f:
            r5 = r3
            r21 = r13
            r11 = r17
            r1 = 2
            r17 = -1
            r13 = r2
            r2 = r27
            if (r8 != r1) goto L_0x0187
            int r0 = com.google.android.gms.internal.vision.zzhl.zze(r12, r11, r9)
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r2, r1)
            goto L_0x0242
        L_0x0187:
            r0 = r5
        L_0x0188:
            r4 = 1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0307
        L_0x018e:
            r5 = r3
            r21 = r13
            r11 = r17
            r1 = 2
            r17 = -1
            r13 = r2
            r2 = r27
            if (r8 != r1) goto L_0x01c0
            com.google.android.gms.internal.vision.zzlc r0 = r15.zza((int) r13)
            r4 = r38
            r18 = 1048575(0xfffff, float:1.469367E-39)
            int r0 = com.google.android.gms.internal.vision.zzhl.zza((com.google.android.gms.internal.vision.zzlc) r0, (byte[]) r12, (int) r11, (int) r4, (com.google.android.gms.internal.vision.zzhn) r9)
            r1 = r6 & r24
            if (r1 != 0) goto L_0x01b2
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r2, r1)
            goto L_0x01ec
        L_0x01b2:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r8 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzjf.zza((java.lang.Object) r1, (java.lang.Object) r8)
            r10.putObject(r14, r2, r1)
            goto L_0x01ec
        L_0x01c0:
            r4 = r38
            r18 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0277
        L_0x01c7:
            r4 = r38
            r5 = r3
            r21 = r13
            r11 = r17
            r0 = 2
            r17 = -1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r2
            r2 = r27
            if (r8 != r0) goto L_0x0277
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r1
            if (r0 != 0) goto L_0x01e3
            int r0 = com.google.android.gms.internal.vision.zzhl.zzc(r12, r11, r9)
            goto L_0x01e7
        L_0x01e3:
            int r0 = com.google.android.gms.internal.vision.zzhl.zzd(r12, r11, r9)
        L_0x01e7:
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r2, r1)
        L_0x01ec:
            r1 = r6 | r24
            r11 = r39
            r3 = r5
            r2 = r13
            r6 = r21
            r5 = r1
            r13 = r4
            goto L_0x024d
        L_0x01f8:
            r4 = r38
            r5 = r3
            r21 = r13
            r11 = r17
            r17 = -1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r2
            r2 = r27
            if (r8 != 0) goto L_0x0277
            int r0 = com.google.android.gms.internal.vision.zzhl.zzb(r12, r11, r9)
            r37 = r0
            long r0 = r9.zzb
            int r8 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r8 == 0) goto L_0x0217
            r0 = 1
            goto L_0x0218
        L_0x0217:
            r0 = 0
        L_0x0218:
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r14, (long) r2, (boolean) r0)
            r0 = r6 | r24
            r11 = r39
            r3 = r5
            r1 = r7
            r2 = r13
            r6 = r21
            r5 = r0
            r13 = r4
            r0 = r37
            goto L_0x0019
        L_0x022a:
            r5 = r3
            r21 = r13
            r11 = r17
            r17 = -1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r2
            r2 = r27
            if (r8 != r4) goto L_0x0277
            int r0 = com.google.android.gms.internal.vision.zzhl.zza(r12, r11)
            r10.putInt(r14, r2, r0)
            int r0 = r11 + 4
        L_0x0242:
            r1 = r6 | r24
            r11 = r39
            r3 = r5
            r2 = r13
            r6 = r21
            r13 = r38
            r5 = r1
        L_0x024d:
            r1 = r7
            goto L_0x0019
        L_0x0250:
            r5 = r3
            r21 = r13
            r11 = r17
            r0 = 1
            r17 = -1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r2
            r2 = r27
            if (r8 != r0) goto L_0x0277
            long r19 = com.google.android.gms.internal.vision.zzhl.zzb(r12, r11)
            r0 = r10
            r1 = r35
            r8 = r5
            r4 = r19
            r0.putLong(r1, r2, r4)
            int r0 = r11 + 8
            r5 = r6 | r24
            r11 = r39
            r1 = r7
            r3 = r8
            goto L_0x0300
        L_0x0277:
            r0 = r5
            goto L_0x02de
        L_0x027a:
            r4 = r3
            r21 = r13
            r11 = r17
            r17 = -1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r2
            r2 = r27
            if (r8 != 0) goto L_0x02c3
            int r0 = com.google.android.gms.internal.vision.zzhl.zza(r12, r11, r9)
            int r1 = r9.zza
            r10.putInt(r14, r2, r1)
            r5 = r6 | r24
            r11 = r39
            r3 = r4
            goto L_0x02ff
        L_0x0299:
            r4 = r3
            r21 = r13
            r11 = r17
            r17 = -1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r2
            r2 = r27
            if (r8 != 0) goto L_0x02c3
            int r8 = com.google.android.gms.internal.vision.zzhl.zzb(r12, r11, r9)
            long r0 = r9.zzb
            r19 = r0
            r0 = r10
            r1 = r35
            r11 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
        L_0x02b9:
            r5 = r6 | r24
            r1 = r7
            r0 = r8
            r3 = r11
            r2 = r13
            r6 = r21
            goto L_0x036d
        L_0x02c3:
            r0 = r4
            goto L_0x02de
        L_0x02c5:
            r0 = r3
            r21 = r13
            r11 = r17
            r17 = -1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r2
            r2 = r27
            if (r8 != r4) goto L_0x02de
            float r1 = com.google.android.gms.internal.vision.zzhl.zzd(r12, r11)
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r14, (long) r2, (float) r1)
            int r1 = r11 + 4
            goto L_0x02f9
        L_0x02de:
            r4 = 1
            goto L_0x0307
        L_0x02e0:
            r0 = r3
            r21 = r13
            r11 = r17
            r4 = 1
            r17 = -1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r2
            r2 = r27
            if (r8 != r4) goto L_0x0307
            double r4 = com.google.android.gms.internal.vision.zzhl.zzc(r12, r11)
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r14, (long) r2, (double) r4)
            int r1 = r11 + 8
        L_0x02f9:
            r5 = r6 | r24
            r11 = r39
            r3 = r0
            r0 = r1
        L_0x02ff:
            r1 = r7
        L_0x0300:
            r2 = r13
            r6 = r21
            r13 = r38
            goto L_0x0019
        L_0x0307:
            r15 = r39
            r24 = r6
            r23 = r7
            r31 = r10
            r2 = r11
            r18 = r13
            r6 = r21
            r21 = 1
            r7 = r0
            goto L_0x042f
        L_0x0319:
            r0 = r3
            r22 = r17
            r17 = -1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r32 = r13
            r14 = r35
            r13 = r2
            r2 = r32
            r4 = 27
            if (r11 != r4) goto L_0x0387
            r4 = 2
            if (r8 != r4) goto L_0x0373
            java.lang.Object r1 = r10.getObject(r14, r2)
            com.google.android.gms.internal.vision.zzjl r1 = (com.google.android.gms.internal.vision.zzjl) r1
            boolean r4 = r1.zza()
            if (r4 != 0) goto L_0x034d
            int r4 = r1.size()
            if (r4 != 0) goto L_0x0344
            r4 = 10
            goto L_0x0346
        L_0x0344:
            int r4 = r4 << 1
        L_0x0346:
            com.google.android.gms.internal.vision.zzjl r1 = r1.zza(r4)
            r10.putObject(r14, r2, r1)
        L_0x034d:
            r8 = r1
            com.google.android.gms.internal.vision.zzlc r1 = r15.zza((int) r13)
            r11 = r0
            r0 = r1
            r1 = r11
            r2 = r36
            r3 = r22
            r4 = r38
            r24 = r5
            r5 = r8
            r25 = r6
            r6 = r40
            int r0 = com.google.android.gms.internal.vision.zzhl.zza(r0, r1, r2, r3, r4, r5, r6)
            r1 = r7
            r3 = r11
            r2 = r13
            r5 = r24
            r6 = r25
        L_0x036d:
            r13 = r38
            r11 = r39
            goto L_0x0019
        L_0x0373:
            r24 = r5
            r25 = r6
            r15 = r39
            r37 = r0
            r23 = r7
            r31 = r10
            r18 = r13
            r14 = r22
            r21 = 1
            goto L_0x0408
        L_0x0387:
            r24 = r5
            r25 = r6
            r6 = r0
            r0 = 49
            if (r11 > r0) goto L_0x03db
            long r4 = (long) r1
            r1 = 17
            r0 = r34
            r1 = r35
            r26 = r2
            r2 = r36
            r3 = r22
            r29 = r4
            r5 = 0
            r21 = 1
            r4 = r38
            r5 = r6
            r37 = r6
            r6 = r7
            r23 = r7
            r7 = r8
            r8 = r13
            r31 = r10
            r9 = r29
            r15 = r39
            r18 = r13
            r12 = r26
            r14 = r40
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.vision.zzhn) r14)
            r14 = r22
            if (r0 != r14) goto L_0x03c2
            goto L_0x042b
        L_0x03c2:
            r14 = r35
            r12 = r36
            r3 = r37
            r13 = r38
            r9 = r40
            r11 = r15
            r2 = r18
            r1 = r23
            r5 = r24
            r6 = r25
            r10 = r31
            r15 = r34
            goto L_0x0019
        L_0x03db:
            r15 = r39
            r26 = r2
            r37 = r6
            r23 = r7
            r31 = r10
            r18 = r13
            r14 = r22
            r21 = 1
            r0 = 50
            if (r11 != r0) goto L_0x040e
            r0 = 2
            if (r8 != r0) goto L_0x0408
            r0 = r34
            r1 = r35
            r2 = r36
            r3 = r14
            r4 = r38
            r5 = r18
            r6 = r26
            r8 = r40
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.vision.zzhn) r8)
            if (r0 != r14) goto L_0x03c2
            goto L_0x042b
        L_0x0408:
            r7 = r37
            r2 = r14
        L_0x040b:
            r6 = r25
            goto L_0x042f
        L_0x040e:
            r0 = r34
            r9 = r1
            r1 = r35
            r2 = r36
            r3 = r14
            r4 = r38
            r5 = r37
            r6 = r23
            r7 = r8
            r8 = r9
            r9 = r11
            r10 = r26
            r12 = r18
            r13 = r40
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.vision.zzhn) r13)
            if (r0 != r14) goto L_0x0634
        L_0x042b:
            r7 = r37
            r2 = r0
            goto L_0x040b
        L_0x042f:
            if (r7 != r15) goto L_0x0446
            if (r15 != 0) goto L_0x0434
            goto L_0x0446
        L_0x0434:
            r8 = r34
            r13 = r35
            r0 = r2
            r1 = r6
            r3 = r7
            r9 = r15
            r5 = r24
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r4 = 0
            r6 = r38
            goto L_0x0660
        L_0x0446:
            r8 = r34
            r9 = r15
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x0607
            r10 = r40
            com.google.android.gms.internal.vision.zzio r0 = r10.zzd
            com.google.android.gms.internal.vision.zzio r1 = com.google.android.gms.internal.vision.zzio.zzb()
            if (r0 == r1) goto L_0x0602
            com.google.android.gms.internal.vision.zzkk r0 = r8.zzg
            com.google.android.gms.internal.vision.zzlu<?, ?> r1 = r8.zzq
            com.google.android.gms.internal.vision.zzio r3 = r10.zzd
            r11 = r23
            com.google.android.gms.internal.vision.zzjb$zze r12 = r3.zza(r0, r11)
            if (r12 != 0) goto L_0x047e
            com.google.android.gms.internal.vision.zzlx r4 = zze((java.lang.Object) r35)
            r0 = r7
            r1 = r36
            r3 = r38
            r5 = r40
            int r0 = com.google.android.gms.internal.vision.zzhl.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.zzlx) r4, (com.google.android.gms.internal.vision.zzhn) r5)
            r13 = r35
            r15 = r36
            r37 = r6
            r6 = r38
            goto L_0x0622
        L_0x047e:
            r13 = r35
            r0 = r13
            com.google.android.gms.internal.vision.zzjb$zzc r0 = (com.google.android.gms.internal.vision.zzjb.zzc) r0
            r0.zza()
            com.google.android.gms.internal.vision.zziu<com.google.android.gms.internal.vision.zzjb$zzf> r14 = r0.zzc
            com.google.android.gms.internal.vision.zzjb$zzf r3 = r12.zzd
            boolean r3 = r3.zzd
            com.google.android.gms.internal.vision.zzjb$zzf r3 = r12.zzd
            com.google.android.gms.internal.vision.zzml r3 = r3.zzc
            com.google.android.gms.internal.vision.zzml r4 = com.google.android.gms.internal.vision.zzml.ENUM
            if (r3 != r4) goto L_0x04c3
            r15 = r36
            int r2 = com.google.android.gms.internal.vision.zzhl.zza(r15, r2, r10)
            int r3 = r10.zza
            r4 = 0
            com.google.android.gms.internal.vision.zzje r3 = r4.zza(r3)
            if (r3 != 0) goto L_0x04bc
            com.google.android.gms.internal.vision.zzlx r3 = r0.zzb
            com.google.android.gms.internal.vision.zzlx r4 = com.google.android.gms.internal.vision.zzlx.zza()
            if (r3 != r4) goto L_0x04b1
            com.google.android.gms.internal.vision.zzlx r3 = com.google.android.gms.internal.vision.zzlx.zzb()
            r0.zzb = r3
        L_0x04b1:
            int r0 = r10.zza
            com.google.android.gms.internal.vision.zzle.zza((int) r11, (int) r0, r3, r1)
            r37 = r6
            r6 = r38
            goto L_0x0600
        L_0x04bc:
            int r0 = r10.zza
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            goto L_0x04d5
        L_0x04c3:
            r15 = r36
            r4 = 0
            int[] r0 = com.google.android.gms.internal.vision.zzhk.zza
            com.google.android.gms.internal.vision.zzjb$zzf r1 = r12.zzd
            com.google.android.gms.internal.vision.zzml r1 = r1.zzc
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x05c0;
                case 2: goto L_0x05b1;
                case 3: goto L_0x05a2;
                case 4: goto L_0x05a2;
                case 5: goto L_0x0593;
                case 6: goto L_0x0593;
                case 7: goto L_0x0586;
                case 8: goto L_0x0586;
                case 9: goto L_0x0579;
                case 10: goto L_0x0579;
                case 11: goto L_0x0563;
                case 12: goto L_0x054f;
                case 13: goto L_0x053b;
                case 14: goto L_0x0533;
                case 15: goto L_0x0527;
                case 16: goto L_0x051b;
                case 17: goto L_0x04f6;
                case 18: goto L_0x04db;
                default: goto L_0x04d5;
            }
        L_0x04d5:
            r37 = r6
            r6 = r38
            goto L_0x05ce
        L_0x04db:
            com.google.android.gms.internal.vision.zzky r0 = com.google.android.gms.internal.vision.zzky.zza()
            com.google.android.gms.internal.vision.zzkk r1 = r12.zzc
            java.lang.Class r1 = r1.getClass()
            com.google.android.gms.internal.vision.zzlc r0 = r0.zza(r1)
            r5 = r38
            int r2 = com.google.android.gms.internal.vision.zzhl.zza((com.google.android.gms.internal.vision.zzlc) r0, (byte[]) r15, (int) r2, (int) r5, (com.google.android.gms.internal.vision.zzhn) r10)
            java.lang.Object r4 = r10.zzc
            r37 = r6
            r6 = r5
            goto L_0x05ce
        L_0x04f6:
            r5 = r38
            int r0 = r11 << 3
            r4 = r0 | 4
            com.google.android.gms.internal.vision.zzky r0 = com.google.android.gms.internal.vision.zzky.zza()
            com.google.android.gms.internal.vision.zzkk r1 = r12.zzc
            java.lang.Class r1 = r1.getClass()
            com.google.android.gms.internal.vision.zzlc r0 = r0.zza(r1)
            r1 = r36
            r3 = r38
            r37 = r6
            r6 = r5
            r5 = r40
            int r2 = com.google.android.gms.internal.vision.zzhl.zza((com.google.android.gms.internal.vision.zzlc) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.vision.zzhn) r5)
            java.lang.Object r4 = r10.zzc
            goto L_0x05ce
        L_0x051b:
            r37 = r6
            r6 = r38
            int r2 = com.google.android.gms.internal.vision.zzhl.zzc(r15, r2, r10)
            java.lang.Object r4 = r10.zzc
            goto L_0x05ce
        L_0x0527:
            r37 = r6
            r6 = r38
            int r2 = com.google.android.gms.internal.vision.zzhl.zze(r15, r2, r10)
            java.lang.Object r4 = r10.zzc
            goto L_0x05ce
        L_0x0533:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Shouldn't reach here."
            r0.<init>(r1)
            throw r0
        L_0x053b:
            r37 = r6
            r6 = r38
            int r2 = com.google.android.gms.internal.vision.zzhl.zzb(r15, r2, r10)
            long r0 = r10.zzb
            long r0 = com.google.android.gms.internal.vision.zzif.zza((long) r0)
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
            goto L_0x05ce
        L_0x054f:
            r37 = r6
            r6 = r38
            int r2 = com.google.android.gms.internal.vision.zzhl.zza(r15, r2, r10)
            int r0 = r10.zza
            int r0 = com.google.android.gms.internal.vision.zzif.zze(r0)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            goto L_0x05ce
        L_0x0563:
            r37 = r6
            r6 = r38
            int r2 = com.google.android.gms.internal.vision.zzhl.zzb(r15, r2, r10)
            long r0 = r10.zzb
            int r3 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r3 == 0) goto L_0x0573
            r4 = 1
            goto L_0x0574
        L_0x0573:
            r4 = 0
        L_0x0574:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            goto L_0x05ce
        L_0x0579:
            r37 = r6
            r6 = r38
            int r0 = com.google.android.gms.internal.vision.zzhl.zza(r15, r2)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            goto L_0x05bd
        L_0x0586:
            r37 = r6
            r6 = r38
            long r0 = com.google.android.gms.internal.vision.zzhl.zzb(r15, r2)
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
            goto L_0x05cc
        L_0x0593:
            r37 = r6
            r6 = r38
            int r2 = com.google.android.gms.internal.vision.zzhl.zza(r15, r2, r10)
            int r0 = r10.zza
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            goto L_0x05ce
        L_0x05a2:
            r37 = r6
            r6 = r38
            int r2 = com.google.android.gms.internal.vision.zzhl.zzb(r15, r2, r10)
            long r0 = r10.zzb
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
            goto L_0x05ce
        L_0x05b1:
            r37 = r6
            r6 = r38
            float r0 = com.google.android.gms.internal.vision.zzhl.zzd(r15, r2)
            java.lang.Float r4 = java.lang.Float.valueOf(r0)
        L_0x05bd:
            int r2 = r2 + 4
            goto L_0x05ce
        L_0x05c0:
            r37 = r6
            r6 = r38
            double r0 = com.google.android.gms.internal.vision.zzhl.zzc(r15, r2)
            java.lang.Double r4 = java.lang.Double.valueOf(r0)
        L_0x05cc:
            int r2 = r2 + 8
        L_0x05ce:
            com.google.android.gms.internal.vision.zzjb$zzf r0 = r12.zzd
            boolean r0 = r0.zzd
            if (r0 == 0) goto L_0x05da
            com.google.android.gms.internal.vision.zzjb$zzf r0 = r12.zzd
            r14.zzb(r0, r4)
            goto L_0x0600
        L_0x05da:
            int[] r0 = com.google.android.gms.internal.vision.zzhk.zza
            com.google.android.gms.internal.vision.zzjb$zzf r1 = r12.zzd
            com.google.android.gms.internal.vision.zzml r1 = r1.zzc
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 17
            if (r0 == r1) goto L_0x05ef
            r1 = 18
            if (r0 == r1) goto L_0x05ef
            goto L_0x05fb
        L_0x05ef:
            com.google.android.gms.internal.vision.zzjb$zzf r0 = r12.zzd
            java.lang.Object r0 = r14.zza(r0)
            if (r0 == 0) goto L_0x05fb
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjf.zza((java.lang.Object) r0, (java.lang.Object) r4)
        L_0x05fb:
            com.google.android.gms.internal.vision.zzjb$zzf r0 = r12.zzd
            r14.zza(r0, (java.lang.Object) r4)
        L_0x0600:
            r0 = r2
            goto L_0x0622
        L_0x0602:
            r13 = r35
            r15 = r36
            goto L_0x060d
        L_0x0607:
            r13 = r35
            r15 = r36
            r10 = r40
        L_0x060d:
            r37 = r6
            r11 = r23
            r6 = r38
            com.google.android.gms.internal.vision.zzlx r4 = zze((java.lang.Object) r35)
            r0 = r7
            r1 = r36
            r3 = r38
            r5 = r40
            int r0 = com.google.android.gms.internal.vision.zzhl.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.zzlx) r4, (com.google.android.gms.internal.vision.zzhn) r5)
        L_0x0622:
            r3 = r7
            r1 = r11
            r14 = r13
            r12 = r15
            r2 = r18
            r5 = r24
            r13 = r6
            r15 = r8
            r11 = r9
            r9 = r10
            r10 = r31
            r6 = r37
            goto L_0x0019
        L_0x0634:
            r7 = r37
            r9 = r15
            r11 = r23
            r15 = r34
            r14 = r35
            r12 = r36
            r13 = r38
            r3 = r7
            r1 = r11
            r2 = r18
            r5 = r24
            r6 = r25
            r10 = r31
            r11 = r9
            r9 = r40
            goto L_0x0019
        L_0x0650:
            r24 = r5
            r25 = r6
            r31 = r10
            r9 = r11
            r6 = r13
            r13 = r14
            r8 = r15
            r4 = 0
            r1 = r25
            r2 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0660:
            if (r1 == r2) goto L_0x0668
            long r1 = (long) r1
            r7 = r31
            r7.putInt(r13, r1, r5)
        L_0x0668:
            int r1 = r8.zzm
        L_0x066a:
            int r2 = r8.zzn
            if (r1 >= r2) goto L_0x067e
            int[] r2 = r8.zzl
            r2 = r2[r1]
            com.google.android.gms.internal.vision.zzlu<?, ?> r5 = r8.zzq
            java.lang.Object r2 = r8.zza((java.lang.Object) r13, (int) r2, r4, r5)
            r4 = r2
            com.google.android.gms.internal.vision.zzlx r4 = (com.google.android.gms.internal.vision.zzlx) r4
            int r1 = r1 + 1
            goto L_0x066a
        L_0x067e:
            if (r4 == 0) goto L_0x0685
            com.google.android.gms.internal.vision.zzlu<?, ?> r1 = r8.zzq
            r1.zzb((java.lang.Object) r13, r4)
        L_0x0685:
            if (r9 != 0) goto L_0x068f
            if (r0 != r6) goto L_0x068a
            goto L_0x0693
        L_0x068a:
            com.google.android.gms.internal.vision.zzjk r0 = com.google.android.gms.internal.vision.zzjk.zzg()
            throw r0
        L_0x068f:
            if (r0 > r6) goto L_0x0694
            if (r3 != r9) goto L_0x0694
        L_0x0693:
            return r0
        L_0x0694:
            com.google.android.gms.internal.vision.zzjk r0 = com.google.android.gms.internal.vision.zzjk.zzg()
            goto L_0x069a
        L_0x0699:
            throw r0
        L_0x069a:
            goto L_0x0699
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.vision.zzhn):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02dc, code lost:
        if (r0 == r15) goto L_0x0348;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0323, code lost:
        if (r0 == r15) goto L_0x0348;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0346, code lost:
        if (r0 == r15) goto L_0x0348;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0348, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01ca, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0234, code lost:
        r6 = r6 | r23;
        r9 = r7;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0239, code lost:
        r2 = r5;
        r29 = r7;
        r18 = r10;
        r7 = r20;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.vision.zzhn r35) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            boolean r0 = r15.zzj
            if (r0 == 0) goto L_0x038d
            sun.misc.Unsafe r9 = zzb
            r10 = -1
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r33
            r1 = -1
            r2 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001e:
            if (r0 >= r13) goto L_0x0370
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0030
            int r0 = com.google.android.gms.internal.vision.zzhl.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.vision.zzhn) r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x0033
        L_0x0030:
            r17 = r0
            r4 = r3
        L_0x0033:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x0040
            int r2 = r2 / 3
            int r0 = r15.zza((int) r5, (int) r2)
            goto L_0x0044
        L_0x0040:
            int r0 = r15.zzg(r5)
        L_0x0044:
            r2 = r0
            if (r2 != r10) goto L_0x0052
            r2 = r4
            r25 = r5
            r29 = r9
            r18 = 0
        L_0x004e:
            r20 = -1
            goto L_0x034a
        L_0x0052:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            r18 = 267386880(0xff00000, float:2.3665827E-29)
            r18 = r1 & r18
            int r10 = r18 >>> 20
            r33 = r5
            r5 = r1 & r8
            r18 = r9
            long r8 = (long) r5
            r5 = 17
            r21 = r1
            if (r10 > r5) goto L_0x0242
            int r5 = r2 + 2
            r0 = r0[r5]
            int r5 = r0 >>> 20
            r1 = 1
            int r23 = r1 << r5
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            r20 = r2
            if (r0 == r7) goto L_0x0092
            if (r7 == r5) goto L_0x0085
            long r1 = (long) r7
            r7 = r18
            r7.putInt(r14, r1, r6)
            goto L_0x0087
        L_0x0085:
            r7 = r18
        L_0x0087:
            if (r0 == r5) goto L_0x008f
            long r1 = (long) r0
            int r1 = r7.getInt(r14, r1)
            r6 = r1
        L_0x008f:
            r2 = r7
            r7 = r0
            goto L_0x0094
        L_0x0092:
            r2 = r18
        L_0x0094:
            r0 = 5
            switch(r10) {
                case 0: goto L_0x021d;
                case 1: goto L_0x0206;
                case 2: goto L_0x01e4;
                case 3: goto L_0x01e4;
                case 4: goto L_0x01cd;
                case 5: goto L_0x01ab;
                case 6: goto L_0x0194;
                case 7: goto L_0x0174;
                case 8: goto L_0x0151;
                case 9: goto L_0x0124;
                case 10: goto L_0x010c;
                case 11: goto L_0x01cd;
                case 12: goto L_0x00f5;
                case 13: goto L_0x0194;
                case 14: goto L_0x01ab;
                case 15: goto L_0x00da;
                case 16: goto L_0x00a5;
                default: goto L_0x0098;
            }
        L_0x0098:
            r25 = r33
            r5 = r4
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            goto L_0x0239
        L_0x00a5:
            if (r3 != 0) goto L_0x00cc
            int r10 = com.google.android.gms.internal.vision.zzhl.zzb(r12, r4, r11)
            long r0 = r11.zzb
            long r17 = com.google.android.gms.internal.vision.zzif.zza((long) r0)
            r0 = r2
            r1 = r31
            r4 = r20
            r20 = r7
            r7 = r2
            r2 = r8
            r25 = r33
            r8 = r4
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r17
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r9 = r7
            r2 = r8
            r0 = r10
            goto L_0x028c
        L_0x00cc:
            r25 = r33
            r8 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            r5 = r4
            r10 = r8
            goto L_0x0239
        L_0x00da:
            r25 = r33
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.vision.zzhl.zza(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.vision.zzif.zze(r1)
            r7.putInt(r14, r8, r1)
            goto L_0x0234
        L_0x00f5:
            r25 = r33
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.vision.zzhl.zza(r12, r4, r11)
            int r1 = r11.zza
            r7.putInt(r14, r8, r1)
            goto L_0x0234
        L_0x010c:
            r25 = r33
            r10 = r20
            r0 = 2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.vision.zzhl.zze(r12, r4, r11)
            java.lang.Object r1 = r11.zzc
            r7.putObject(r14, r8, r1)
            goto L_0x0234
        L_0x0124:
            r25 = r33
            r10 = r20
            r0 = 2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x01ca
            com.google.android.gms.internal.vision.zzlc r0 = r15.zza((int) r10)
            int r0 = com.google.android.gms.internal.vision.zzhl.zza((com.google.android.gms.internal.vision.zzlc) r0, (byte[]) r12, (int) r4, (int) r13, (com.google.android.gms.internal.vision.zzhn) r11)
            java.lang.Object r1 = r7.getObject(r14, r8)
            if (r1 != 0) goto L_0x0146
            java.lang.Object r1 = r11.zzc
            r7.putObject(r14, r8, r1)
            goto L_0x0234
        L_0x0146:
            java.lang.Object r2 = r11.zzc
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzjf.zza((java.lang.Object) r1, (java.lang.Object) r2)
            r7.putObject(r14, r8, r1)
            goto L_0x0234
        L_0x0151:
            r25 = r33
            r10 = r20
            r0 = 2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x01ca
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r21 & r0
            if (r0 != 0) goto L_0x0169
            int r0 = com.google.android.gms.internal.vision.zzhl.zzc(r12, r4, r11)
            goto L_0x016d
        L_0x0169:
            int r0 = com.google.android.gms.internal.vision.zzhl.zzd(r12, r4, r11)
        L_0x016d:
            java.lang.Object r1 = r11.zzc
            r7.putObject(r14, r8, r1)
            goto L_0x0234
        L_0x0174:
            r25 = r33
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.vision.zzhl.zzb(r12, r4, r11)
            long r1 = r11.zzb
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x018e
            r1 = 1
            goto L_0x018f
        L_0x018e:
            r1 = 0
        L_0x018f:
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r14, (long) r8, (boolean) r1)
            goto L_0x0234
        L_0x0194:
            r25 = r33
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.vision.zzhl.zza(r12, r4)
            r7.putInt(r14, r8, r0)
            int r0 = r4 + 4
            goto L_0x0234
        L_0x01ab:
            r25 = r33
            r10 = r20
            r0 = 1
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x01ca
            long r17 = com.google.android.gms.internal.vision.zzhl.zzb(r12, r4)
            r0 = r7
            r1 = r31
            r2 = r8
            r8 = r4
            r4 = r17
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x0234
        L_0x01ca:
            r5 = r4
            goto L_0x0239
        L_0x01cd:
            r25 = r33
            r5 = r4
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x0239
            int r0 = com.google.android.gms.internal.vision.zzhl.zza(r12, r5, r11)
            int r1 = r11.zza
            r7.putInt(r14, r8, r1)
            goto L_0x0234
        L_0x01e4:
            r25 = r33
            r5 = r4
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x0239
            int r17 = com.google.android.gms.internal.vision.zzhl.zzb(r12, r5, r11)
            long r4 = r11.zzb
            r0 = r7
            r1 = r31
            r2 = r8
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r9 = r7
            r2 = r10
            r0 = r17
            goto L_0x028c
        L_0x0206:
            r25 = r33
            r5 = r4
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x0239
            float r0 = com.google.android.gms.internal.vision.zzhl.zzd(r12, r5)
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r14, (long) r8, (float) r0)
            int r0 = r5 + 4
            goto L_0x0234
        L_0x021d:
            r25 = r33
            r5 = r4
            r10 = r20
            r0 = 1
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x0239
            double r0 = com.google.android.gms.internal.vision.zzhl.zzc(r12, r5)
            com.google.android.gms.internal.vision.zzma.zza((java.lang.Object) r14, (long) r8, (double) r0)
            int r0 = r5 + 8
        L_0x0234:
            r6 = r6 | r23
            r9 = r7
            r2 = r10
            goto L_0x028c
        L_0x0239:
            r2 = r5
            r29 = r7
            r18 = r10
            r7 = r20
            goto L_0x004e
        L_0x0242:
            r25 = r33
            r5 = r4
            r20 = r7
            r7 = r18
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r2
            r0 = 27
            if (r10 != r0) goto L_0x029f
            r0 = 2
            if (r3 != r0) goto L_0x0292
            java.lang.Object r0 = r7.getObject(r14, r8)
            com.google.android.gms.internal.vision.zzjl r0 = (com.google.android.gms.internal.vision.zzjl) r0
            boolean r1 = r0.zza()
            if (r1 != 0) goto L_0x0272
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0269
            r1 = 10
            goto L_0x026b
        L_0x0269:
            int r1 = r1 << 1
        L_0x026b:
            com.google.android.gms.internal.vision.zzjl r0 = r0.zza(r1)
            r7.putObject(r14, r8, r0)
        L_0x0272:
            r8 = r0
            com.google.android.gms.internal.vision.zzlc r0 = r15.zza((int) r4)
            r1 = r17
            r2 = r32
            r3 = r5
            r18 = r4
            r4 = r34
            r5 = r8
            r8 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.vision.zzhl.zza(r0, r1, r2, r3, r4, r5, r6)
            r9 = r7
            r6 = r8
            r2 = r18
        L_0x028c:
            r7 = r20
            r1 = r25
            goto L_0x036a
        L_0x0292:
            r18 = r4
            r15 = r5
            r27 = r6
            r29 = r7
            r28 = r20
            r20 = -1
            goto L_0x0326
        L_0x029f:
            r18 = r4
            r0 = 49
            if (r10 > r0) goto L_0x02f4
            r1 = r21
            long r1 = (long) r1
            r0 = r30
            r21 = r1
            r1 = r31
            r2 = r32
            r4 = r3
            r3 = r5
            r33 = r4
            r4 = r34
            r15 = r5
            r5 = r17
            r27 = r6
            r6 = r25
            r28 = r20
            r20 = r7
            r7 = r33
            r23 = r8
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r18
            r19 = r10
            r29 = r20
            r20 = -1
            r9 = r21
            r11 = r19
            r12 = r23
            r14 = r35
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.vision.zzhn) r14)
            if (r0 != r15) goto L_0x02e0
            goto L_0x0348
        L_0x02e0:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r18
            r1 = r25
            r6 = r27
            r7 = r28
            goto L_0x0368
        L_0x02f4:
            r33 = r3
            r15 = r5
            r27 = r6
            r29 = r7
            r23 = r8
            r19 = r10
            r28 = r20
            r1 = r21
            r20 = -1
            r0 = 50
            r9 = r19
            if (r9 != r0) goto L_0x032c
            r7 = r33
            r0 = 2
            if (r7 != r0) goto L_0x0326
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r18
            r6 = r23
            r8 = r35
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.vision.zzhn) r8)
            if (r0 != r15) goto L_0x02e0
            goto L_0x0348
        L_0x0326:
            r2 = r15
        L_0x0327:
            r6 = r27
            r7 = r28
            goto L_0x034a
        L_0x032c:
            r7 = r33
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r17
            r6 = r25
            r10 = r23
            r12 = r18
            r13 = r35
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.vision.zzhn) r13)
            if (r0 != r15) goto L_0x02e0
        L_0x0348:
            r2 = r0
            goto L_0x0327
        L_0x034a:
            com.google.android.gms.internal.vision.zzlx r4 = zze((java.lang.Object) r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = com.google.android.gms.internal.vision.zzhl.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.zzlx) r4, (com.google.android.gms.internal.vision.zzhn) r5)
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r18
            r1 = r25
        L_0x0368:
            r9 = r29
        L_0x036a:
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            goto L_0x001e
        L_0x0370:
            r27 = r6
            r29 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 == r1) goto L_0x0383
            long r1 = (long) r7
            r3 = r31
            r6 = r27
            r4 = r29
            r4.putInt(r3, r1, r6)
        L_0x0383:
            r4 = r34
            if (r0 != r4) goto L_0x0388
            return
        L_0x0388:
            com.google.android.gms.internal.vision.zzjk r0 = com.google.android.gms.internal.vision.zzjk.zzg()
            throw r0
        L_0x038d:
            r4 = r13
            r3 = r14
            r5 = 0
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r33
            r4 = r34
            r6 = r35
            r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (com.google.android.gms.internal.vision.zzhn) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.vision.zzhn):void");
    }

    public final void zzc(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long zzd2 = (long) (zzd(this.zzl[i2]) & 1048575);
            Object zzf2 = zzma.zzf(t, zzd2);
            if (zzf2 != null) {
                zzma.zza((Object) t, zzd2, this.zzs.zze(zzf2));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zzb(t, (long) this.zzl[i]);
            i++;
        }
        this.zzq.zzd(t);
        if (this.zzh) {
            this.zzr.zzc(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzlu<UT, UB> zzlu) {
        zzjg zzc2;
        int i2 = this.zzc[i];
        Object zzf2 = zzma.zzf(obj, (long) (zzd(i) & 1048575));
        if (zzf2 == null || (zzc2 = zzc(i)) == null) {
            return ub;
        }
        return zza(i, i2, this.zzs.zza(zzf2), zzc2, ub, zzlu);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzjg zzjg, UB ub, zzlu<UT, UB> zzlu) {
        zzkf<?, ?> zzb2 = this.zzs.zzb(zzb(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzjg.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzlu.zza();
                }
                zzib zzc2 = zzht.zzc(zzkc.zza(zzb2, next.getKey(), next.getValue()));
                try {
                    zzkc.zza(zzc2.zzb(), zzb2, next.getKey(), next.getValue());
                    zzlu.zza(ub, i2, zzc2.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    public final boolean zzd(T t) {
        int i;
        int i2;
        T t2 = t;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i5 >= this.zzm) {
                return !this.zzh || this.zzr.zza((Object) t2).zzf();
            }
            int i6 = this.zzl[i5];
            int i7 = this.zzc[i6];
            int zzd2 = zzd(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(t2, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if (((268435456 & zzd2) != 0) && !zza(t, i6, i2, i, i10)) {
                return false;
            }
            int i11 = (267386880 & zzd2) >>> 20;
            if (i11 != 9 && i11 != 17) {
                if (i11 != 27) {
                    if (i11 == 60 || i11 == 68) {
                        if (zza(t2, i7, i6) && !zza((Object) t2, zzd2, zza(i6))) {
                            return false;
                        }
                    } else if (i11 != 49) {
                        if (i11 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzc2 = this.zzs.zzc(zzma.zzf(t2, (long) (zzd2 & 1048575)));
                            if (!zzc2.isEmpty()) {
                                if (this.zzs.zzb(zzb(i6)).zzc.zza() == zzmo.MESSAGE) {
                                    zzlc<?> zzlc = null;
                                    Iterator<?> it = zzc2.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzlc == null) {
                                            zzlc = zzky.zza().zza(next.getClass());
                                        }
                                        if (!zzlc.zzd(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzma.zzf(t2, (long) (zzd2 & 1048575));
                if (!list.isEmpty()) {
                    zzlc zza2 = zza(i6);
                    int i12 = 0;
                    while (true) {
                        if (i12 >= list.size()) {
                            break;
                        } else if (!zza2.zzd(list.get(i12))) {
                            z = false;
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i6, i2, i, i10) && !zza((Object) t2, zzd2, zza(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
    }

    private static boolean zza(Object obj, int i, zzlc zzlc) {
        return zzlc.zzd(zzma.zzf(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzmr zzmr) throws IOException {
        if (obj instanceof String) {
            zzmr.zza(i, (String) obj);
        } else {
            zzmr.zza(i, (zzht) obj);
        }
    }

    private final void zza(Object obj, int i, zzld zzld) throws IOException {
        if (zzf(i)) {
            zzma.zza(obj, (long) (i & 1048575), (Object) zzld.zzm());
        } else if (this.zzi) {
            zzma.zza(obj, (long) (i & 1048575), (Object) zzld.zzl());
        } else {
            zzma.zza(obj, (long) (i & 1048575), (Object) zzld.zzn());
        }
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzma.zzf(t, j)).doubleValue();
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzma.zzf(t, j)).floatValue();
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzma.zzf(t, j)).intValue();
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzma.zzf(t, j)).longValue();
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzma.zzf(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zza(t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zza(T t, int i) {
        int zze2 = zze(i);
        long j = (long) (zze2 & 1048575);
        if (j == 1048575) {
            int zzd2 = zzd(i);
            long j2 = (long) (zzd2 & 1048575);
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    return zzma.zze(t, j2) != 0.0d;
                case 1:
                    return zzma.zzd(t, j2) != 0.0f;
                case 2:
                    return zzma.zzb(t, j2) != 0;
                case 3:
                    return zzma.zzb(t, j2) != 0;
                case 4:
                    return zzma.zza((Object) t, j2) != 0;
                case 5:
                    return zzma.zzb(t, j2) != 0;
                case 6:
                    return zzma.zza((Object) t, j2) != 0;
                case 7:
                    return zzma.zzc(t, j2);
                case 8:
                    Object zzf2 = zzma.zzf(t, j2);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzht) {
                        return !zzht.zza.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzma.zzf(t, j2) != null;
                case 10:
                    return !zzht.zza.equals(zzma.zzf(t, j2));
                case 11:
                    return zzma.zza((Object) t, j2) != 0;
                case 12:
                    return zzma.zza((Object) t, j2) != 0;
                case 13:
                    return zzma.zza((Object) t, j2) != 0;
                case 14:
                    return zzma.zzb(t, j2) != 0;
                case 15:
                    return zzma.zza((Object) t, j2) != 0;
                case 16:
                    return zzma.zzb(t, j2) != 0;
                case 17:
                    return zzma.zzf(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzma.zza((Object) t, j) & (1 << (zze2 >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        int zze2 = zze(i);
        long j = (long) (1048575 & zze2);
        if (j != 1048575) {
            zzma.zza((Object) t, j, (1 << (zze2 >>> 20)) | zzma.zza((Object) t, j));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzma.zza((Object) t, (long) (zze(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzma.zza((Object) t, (long) (zze(i2) & 1048575), i);
    }

    private final int zzg(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, 0);
    }

    private final int zza(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, i2);
    }

    private final int zzb(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
