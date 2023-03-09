package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzjb;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzip extends zziq<zzjb.zzf> {
    zzip() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzkk zzkk) {
        return zzkk instanceof zzjb.zzc;
    }

    /* access modifiers changed from: package-private */
    public final zziu<zzjb.zzf> zza(Object obj) {
        return ((zzjb.zzc) obj).zzc;
    }

    /* access modifiers changed from: package-private */
    public final zziu<zzjb.zzf> zzb(Object obj) {
        return ((zzjb.zzc) obj).zza();
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Object obj) {
        zza(obj).zzb();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.google.android.gms.internal.vision.zzjh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.google.android.gms.internal.vision.zzjh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: com.google.android.gms.internal.vision.zzjh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: com.google.android.gms.internal.vision.zzjh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v27, resolved type: com.google.android.gms.internal.vision.zzjh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: com.google.android.gms.internal.vision.zzjh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v29, resolved type: com.google.android.gms.internal.vision.zzjh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v30, resolved type: com.google.android.gms.internal.vision.zzjh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v31, resolved type: com.google.android.gms.internal.vision.zzjh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v32, resolved type: com.google.android.gms.internal.vision.zzjh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v33, resolved type: com.google.android.gms.internal.vision.zzjh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v34, resolved type: com.google.android.gms.internal.vision.zzjh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v35, resolved type: com.google.android.gms.internal.vision.zzjh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v36, resolved type: com.google.android.gms.internal.vision.zzjh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v37, resolved type: com.google.android.gms.internal.vision.zzjh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v38, resolved type: com.google.android.gms.internal.vision.zzjh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v39, resolved type: com.google.android.gms.internal.vision.zzjh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v40, resolved type: com.google.android.gms.internal.vision.zzjh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v41, resolved type: com.google.android.gms.internal.vision.zzjh} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v42, resolved type: com.google.android.gms.internal.vision.zzjh} */
    /* JADX WARNING: type inference failed for: r3v4, types: [java.lang.Double] */
    /* JADX WARNING: type inference failed for: r3v5, types: [java.lang.Float] */
    /* JADX WARNING: type inference failed for: r3v6, types: [java.lang.Long] */
    /* JADX WARNING: type inference failed for: r3v7, types: [java.lang.Long] */
    /* JADX WARNING: type inference failed for: r3v8, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r3v9, types: [java.lang.Long] */
    /* JADX WARNING: type inference failed for: r3v10, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r3v11, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r3v12, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r3v13, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r3v14, types: [java.lang.Long] */
    /* JADX WARNING: type inference failed for: r3v15, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r3v16, types: [java.lang.Long] */
    /* JADX WARNING: type inference failed for: r3v17, types: [com.google.android.gms.internal.vision.zzht] */
    /* JADX WARNING: type inference failed for: r3v18, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v21, types: [java.lang.Integer] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f8, code lost:
        if (r5 != 18) goto L_0x0107;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <UT, UB> UB zza(com.google.android.gms.internal.vision.zzld r5, java.lang.Object r6, com.google.android.gms.internal.vision.zzio r7, com.google.android.gms.internal.vision.zziu<com.google.android.gms.internal.vision.zzjb.zzf> r8, UB r9, com.google.android.gms.internal.vision.zzlu<UT, UB> r10) throws java.io.IOException {
        /*
            r4 = this;
            com.google.android.gms.internal.vision.zzjb$zze r6 = (com.google.android.gms.internal.vision.zzjb.zze) r6
            com.google.android.gms.internal.vision.zzjb$zzf r0 = r6.zzd
            int r0 = r0.zzb
            com.google.android.gms.internal.vision.zzjb$zzf r1 = r6.zzd
            boolean r1 = r1.zzd
            com.google.android.gms.internal.vision.zzjb$zzf r1 = r6.zzd
            com.google.android.gms.internal.vision.zzml r1 = r1.zzc
            com.google.android.gms.internal.vision.zzml r2 = com.google.android.gms.internal.vision.zzml.ENUM
            r3 = 0
            if (r1 != r2) goto L_0x0028
            int r5 = r5.zzh()
            com.google.android.gms.internal.vision.zzje r7 = r3.zza(r5)
            if (r7 != 0) goto L_0x0022
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzle.zza((int) r0, (int) r5, r9, r10)
            return r5
        L_0x0022:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            goto L_0x00da
        L_0x0028:
            int[] r10 = com.google.android.gms.internal.vision.zzis.zza
            com.google.android.gms.internal.vision.zzjb$zzf r0 = r6.zzd
            com.google.android.gms.internal.vision.zzml r0 = r0.zzc
            int r0 = r0.ordinal()
            r10 = r10[r0]
            switch(r10) {
                case 1: goto L_0x00d2;
                case 2: goto L_0x00c9;
                case 3: goto L_0x00c0;
                case 4: goto L_0x00b7;
                case 5: goto L_0x00ae;
                case 6: goto L_0x00a5;
                case 7: goto L_0x009c;
                case 8: goto L_0x0093;
                case 9: goto L_0x008a;
                case 10: goto L_0x0081;
                case 11: goto L_0x0078;
                case 12: goto L_0x006f;
                case 13: goto L_0x0065;
                case 14: goto L_0x005d;
                case 15: goto L_0x0057;
                case 16: goto L_0x0051;
                case 17: goto L_0x0045;
                case 18: goto L_0x0039;
                default: goto L_0x0037;
            }
        L_0x0037:
            goto L_0x00da
        L_0x0039:
            com.google.android.gms.internal.vision.zzkk r10 = r6.zzc
            java.lang.Class r10 = r10.getClass()
            java.lang.Object r3 = r5.zza(r10, (com.google.android.gms.internal.vision.zzio) r7)
            goto L_0x00da
        L_0x0045:
            com.google.android.gms.internal.vision.zzkk r10 = r6.zzc
            java.lang.Class r10 = r10.getClass()
            java.lang.Object r3 = r5.zzb(r10, (com.google.android.gms.internal.vision.zzio) r7)
            goto L_0x00da
        L_0x0051:
            java.lang.String r3 = r5.zzl()
            goto L_0x00da
        L_0x0057:
            com.google.android.gms.internal.vision.zzht r3 = r5.zzn()
            goto L_0x00da
        L_0x005d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Shouldn't reach here."
            r5.<init>(r6)
            throw r5
        L_0x0065:
            long r0 = r5.zzt()
            java.lang.Long r3 = java.lang.Long.valueOf(r0)
            goto L_0x00da
        L_0x006f:
            int r5 = r5.zzs()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            goto L_0x00da
        L_0x0078:
            long r0 = r5.zzr()
            java.lang.Long r3 = java.lang.Long.valueOf(r0)
            goto L_0x00da
        L_0x0081:
            int r5 = r5.zzq()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            goto L_0x00da
        L_0x008a:
            int r5 = r5.zzo()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            goto L_0x00da
        L_0x0093:
            boolean r5 = r5.zzk()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r5)
            goto L_0x00da
        L_0x009c:
            int r5 = r5.zzj()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            goto L_0x00da
        L_0x00a5:
            long r0 = r5.zzi()
            java.lang.Long r3 = java.lang.Long.valueOf(r0)
            goto L_0x00da
        L_0x00ae:
            int r5 = r5.zzh()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            goto L_0x00da
        L_0x00b7:
            long r0 = r5.zzf()
            java.lang.Long r3 = java.lang.Long.valueOf(r0)
            goto L_0x00da
        L_0x00c0:
            long r0 = r5.zzg()
            java.lang.Long r3 = java.lang.Long.valueOf(r0)
            goto L_0x00da
        L_0x00c9:
            float r5 = r5.zze()
            java.lang.Float r3 = java.lang.Float.valueOf(r5)
            goto L_0x00da
        L_0x00d2:
            double r0 = r5.zzd()
            java.lang.Double r3 = java.lang.Double.valueOf(r0)
        L_0x00da:
            com.google.android.gms.internal.vision.zzjb$zzf r5 = r6.zzd
            boolean r5 = r5.zzd
            if (r5 == 0) goto L_0x00e6
            com.google.android.gms.internal.vision.zzjb$zzf r5 = r6.zzd
            r8.zzb(r5, r3)
            goto L_0x010c
        L_0x00e6:
            int[] r5 = com.google.android.gms.internal.vision.zzis.zza
            com.google.android.gms.internal.vision.zzjb$zzf r7 = r6.zzd
            com.google.android.gms.internal.vision.zzml r7 = r7.zzc
            int r7 = r7.ordinal()
            r5 = r5[r7]
            r7 = 17
            if (r5 == r7) goto L_0x00fb
            r7 = 18
            if (r5 == r7) goto L_0x00fb
            goto L_0x0107
        L_0x00fb:
            com.google.android.gms.internal.vision.zzjb$zzf r5 = r6.zzd
            java.lang.Object r5 = r8.zza(r5)
            if (r5 == 0) goto L_0x0107
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzjf.zza((java.lang.Object) r5, (java.lang.Object) r3)
        L_0x0107:
            com.google.android.gms.internal.vision.zzjb$zzf r5 = r6.zzd
            r8.zza(r5, (java.lang.Object) r3)
        L_0x010c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzip.zza(com.google.android.gms.internal.vision.zzld, java.lang.Object, com.google.android.gms.internal.vision.zzio, com.google.android.gms.internal.vision.zziu, java.lang.Object, com.google.android.gms.internal.vision.zzlu):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public final int zza(Map.Entry<?, ?> entry) {
        return ((zzjb.zzf) entry.getKey()).zzb;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzmr zzmr, Map.Entry<?, ?> entry) throws IOException {
        zzjb.zzf zzf = (zzjb.zzf) entry.getKey();
        if (zzf.zzd) {
            switch (zzis.zza[zzf.zzc.ordinal()]) {
                case 1:
                    zzle.zza(zzf.zzb, (List<Double>) (List) entry.getValue(), zzmr, false);
                    return;
                case 2:
                    zzle.zzb(zzf.zzb, (List<Float>) (List) entry.getValue(), zzmr, false);
                    return;
                case 3:
                    zzle.zzc(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 4:
                    zzle.zzd(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 5:
                    zzle.zzh(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 6:
                    zzle.zzf(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 7:
                    zzle.zzk(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 8:
                    zzle.zzn(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 9:
                    zzle.zzi(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 10:
                    zzle.zzl(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 11:
                    zzle.zzg(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 12:
                    zzle.zzj(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 13:
                    zzle.zze(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 14:
                    zzle.zzh(zzf.zzb, (List) entry.getValue(), zzmr, false);
                    return;
                case 15:
                    zzle.zzb(zzf.zzb, (List<zzht>) (List) entry.getValue(), zzmr);
                    return;
                case 16:
                    zzle.zza(zzf.zzb, (List<String>) (List) entry.getValue(), zzmr);
                    return;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        zzle.zzb(zzf.zzb, (List<?>) (List) entry.getValue(), zzmr, (zzlc) zzky.zza().zza(list.get(0).getClass()));
                        return;
                    }
                    return;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        zzle.zza(zzf.zzb, (List<?>) (List) entry.getValue(), zzmr, (zzlc) zzky.zza().zza(list2.get(0).getClass()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            switch (zzis.zza[zzf.zzc.ordinal()]) {
                case 1:
                    zzmr.zza(zzf.zzb, ((Double) entry.getValue()).doubleValue());
                    return;
                case 2:
                    zzmr.zza(zzf.zzb, ((Float) entry.getValue()).floatValue());
                    return;
                case 3:
                    zzmr.zza(zzf.zzb, ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    zzmr.zzc(zzf.zzb, ((Long) entry.getValue()).longValue());
                    return;
                case 5:
                    zzmr.zzc(zzf.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 6:
                    zzmr.zzd(zzf.zzb, ((Long) entry.getValue()).longValue());
                    return;
                case 7:
                    zzmr.zzd(zzf.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 8:
                    zzmr.zza(zzf.zzb, ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 9:
                    zzmr.zze(zzf.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 10:
                    zzmr.zza(zzf.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 11:
                    zzmr.zzb(zzf.zzb, ((Long) entry.getValue()).longValue());
                    return;
                case 12:
                    zzmr.zzf(zzf.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    zzmr.zze(zzf.zzb, ((Long) entry.getValue()).longValue());
                    return;
                case 14:
                    zzmr.zzc(zzf.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 15:
                    zzmr.zza(zzf.zzb, (zzht) entry.getValue());
                    return;
                case 16:
                    zzmr.zza(zzf.zzb, (String) entry.getValue());
                    return;
                case 17:
                    zzmr.zzb(zzf.zzb, (Object) entry.getValue(), (zzlc) zzky.zza().zza(entry.getValue().getClass()));
                    return;
                case 18:
                    zzmr.zza(zzf.zzb, (Object) entry.getValue(), (zzlc) zzky.zza().zza(entry.getValue().getClass()));
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Object zza(zzio zzio, zzkk zzkk, int i) {
        return zzio.zza(zzkk, i);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzld zzld, Object obj, zzio zzio, zziu<zzjb.zzf> zziu) throws IOException {
        zzjb.zze zze = (zzjb.zze) obj;
        zziu.zza(zze.zzd, (Object) zzld.zza(zze.zzc.getClass(), zzio));
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzht zzht, Object obj, zzio zzio, zziu<zzjb.zzf> zziu) throws IOException {
        byte[] bArr;
        zzjb.zze zze = (zzjb.zze) obj;
        zzkk zze2 = zze.zzc.zzq().zze();
        int zza = zzht.zza();
        if (zza == 0) {
            bArr = zzjf.zzb;
        } else {
            byte[] bArr2 = new byte[zza];
            zzht.zza(bArr2, 0, 0, zza);
            bArr = bArr2;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (wrap.hasArray()) {
            zzho zzho = new zzho(wrap, true);
            zzky.zza().zza(zze2).zza(zze2, zzho, zzio);
            zziu.zza(zze.zzd, (Object) zze2);
            if (zzho.zza() != Integer.MAX_VALUE) {
                throw zzjk.zze();
            }
            return;
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }
}
