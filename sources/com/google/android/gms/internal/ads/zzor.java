package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzor extends zzov {
    private final AtomicReference<zzoq> zza;

    public zzor() {
        this((zzow) null);
    }

    protected static boolean zza(int i, boolean z) {
        int i2 = i & 3;
        return i2 == 3 || (z && i2 == 2);
    }

    private static int zzh(int i, int i2) {
        if (i == -1) {
            return i2 != -1 ? -1 : 0;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    /* access modifiers changed from: protected */
    public final zzop[] zzb(zziz[] zzizArr, zzol[] zzolArr, int[][][] iArr) throws zzif {
        zzos zzos;
        zzos zzos2;
        int[] iArr2;
        ArrayList arrayList;
        zzok zzok;
        boolean z;
        boolean z2;
        int i;
        int i2;
        int i3 = 2;
        zzop[] zzopArr = new zzop[2];
        zzoq zzoq = this.zza.get();
        int i4 = 0;
        boolean z3 = false;
        while (true) {
            int i5 = -1;
            if (i4 >= i3) {
                break;
            }
            if (zzizArr[i4].zza() == i3) {
                if (!z3) {
                    zziz zziz = zzizArr[i4];
                    zzol zzol = zzolArr[i4];
                    int[][] iArr3 = iArr[i4];
                    int i6 = zzoq.zzd;
                    int i7 = zzoq.zze;
                    int i8 = zzoq.zzf;
                    boolean z4 = zzoq.zzc;
                    boolean z5 = zzoq.zzb;
                    int i9 = zzoq.zzi;
                    int i10 = zzoq.zzj;
                    boolean z6 = zzoq.zzk;
                    boolean z7 = zzoq.zzg;
                    boolean z8 = zzoq.zzh;
                    int i11 = -1;
                    int i12 = 0;
                    zzok zzok2 = null;
                    int i13 = 0;
                    int i14 = 0;
                    while (i12 < zzol.zzb) {
                        zzok zza2 = zzol.zza(i12);
                        ArrayList arrayList2 = new ArrayList(zza2.zza);
                        for (int i15 = 0; i15 < zza2.zza; i15++) {
                            arrayList2.add(Integer.valueOf(i15));
                        }
                        int[] iArr4 = iArr3[i12];
                        int i16 = 0;
                        while (i16 < zza2.zza) {
                            zzol zzol2 = zzol;
                            if (zza(iArr4[i16], true)) {
                                zzit zza3 = zza2.zza(i16);
                                if (arrayList2.contains(Integer.valueOf(i16))) {
                                    int i17 = zza3.zzj;
                                    int i18 = zza3.zzk;
                                    int i19 = zza3.zzb;
                                    zzok = zza2;
                                    z2 = true;
                                    z = true;
                                } else {
                                    zzok = zza2;
                                    z2 = true;
                                    z = false;
                                }
                                if (z2 != z) {
                                    arrayList = arrayList2;
                                    i = 1;
                                } else {
                                    arrayList = arrayList2;
                                    i = 2;
                                }
                                iArr2 = iArr4;
                                boolean zza4 = zza(iArr4[i16], false);
                                if (zza4) {
                                    i += 1000;
                                }
                                boolean z9 = i > i14;
                                if (i == i14) {
                                    if (zza3.zzk() != i11) {
                                        i2 = zzh(zza3.zzk(), i11);
                                    } else {
                                        i2 = zzh(zza3.zzb, i5);
                                    }
                                    z9 = !zza4 || !z ? i2 < 0 : i2 > 0;
                                }
                                if (z9) {
                                    i5 = zza3.zzb;
                                    i11 = zza3.zzk();
                                    i14 = i;
                                    i13 = i16;
                                    zzok2 = zzok;
                                }
                            } else {
                                zzok = zza2;
                                iArr2 = iArr4;
                                arrayList = arrayList2;
                            }
                            i16++;
                            zzol = zzol2;
                            zza2 = zzok;
                            arrayList2 = arrayList;
                            iArr4 = iArr2;
                        }
                        zzol zzol3 = zzol;
                        i12++;
                    }
                    if (zzok2 == null) {
                        zzos2 = null;
                    } else {
                        zzos2 = new zzos(zzok2, i13, 0, (Object) null);
                    }
                    zzopArr[i4] = zzos2;
                    z3 = zzos2 != null;
                }
                int i20 = zzolArr[i4].zzb;
            }
            i4++;
            i3 = 2;
        }
        int i21 = 0;
        boolean z10 = false;
        while (i21 < i3) {
            if (zzizArr[i21].zza() == 1 && !z10) {
                zzol zzol4 = zzolArr[i21];
                int[][] iArr5 = iArr[i21];
                String str = zzoq.zza;
                boolean z11 = zzoq.zzh;
                boolean z12 = zzoq.zzb;
                int i22 = 0;
                int i23 = 0;
                int i24 = -1;
                int i25 = -1;
                while (i22 < zzol4.zzb) {
                    zzok zza5 = zzol4.zza(i22);
                    int[] iArr6 = iArr5[i22];
                    int i26 = i25;
                    int i27 = i24;
                    int i28 = i23;
                    for (int i29 = 0; i29 < zza5.zza; i29++) {
                        if (zza(iArr6[i29], true)) {
                            zzit zza6 = zza5.zza(i29);
                            int i30 = iArr6[i29];
                            int i31 = 1 != (zza6.zzx & 1) ? 1 : 2;
                            if (zza(i30, false)) {
                                i31 += 1000;
                            }
                            if (i31 > i28) {
                                i27 = i22;
                                i26 = i29;
                                i28 = i31;
                            }
                        }
                    }
                    i22++;
                    i23 = i28;
                    i24 = i27;
                    i25 = i26;
                }
                if (i24 == -1) {
                    zzos = null;
                } else {
                    zzos = new zzos(zzol4.zza(i24), i25, 0, (Object) null);
                }
                zzopArr[i21] = zzos;
                z10 = zzos != null;
            }
            i21++;
            i3 = 2;
        }
        return zzopArr;
    }

    public zzor(zzow zzow) {
        this.zza = new AtomicReference<>(new zzoq());
    }
}
