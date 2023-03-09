package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzgp extends zzhm {
    private static final zzhn<zzdy> zzi = new zzhn<>();
    private final Context zzj;

    public zzgp(zzge zzge, String str, String str2, zzcn zzcn, int i, int i2, Context context, zzce zzce) {
        super(zzge, "UZTSNWb1zXgw5vjxx2ZhxjLLyqN54Pno04MXjtzCVCMzKVc+OfmNkNnAKjZ08r/h", "BTQuS/+Ue5xwms1CJL1YODGUh5Ur1d+4x5VZpgqRylk=", zzcn, i, 27);
        this.zzj = context;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:37|38|(1:40)|41|(1:45)|46|47|(1:49)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00dd */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r12 = this;
            com.google.android.gms.internal.ads.zzhn<com.google.android.gms.internal.ads.zzdy> r0 = zzi
            android.content.Context r1 = r12.zzj
            java.lang.String r1 = r1.getPackageName()
            java.util.concurrent.atomic.AtomicReference r0 = r0.zza(r1)
            monitor-enter(r0)
            java.lang.Object r1 = r0.get()     // Catch:{ all -> 0x011c }
            com.google.android.gms.internal.ads.zzdy r1 = (com.google.android.gms.internal.ads.zzdy) r1     // Catch:{ all -> 0x011c }
            if (r1 == 0) goto L_0x0031
            java.lang.String r2 = r1.zza     // Catch:{ all -> 0x011c }
            boolean r2 = com.google.android.gms.internal.ads.zzgh.zzc(r2)     // Catch:{ all -> 0x011c }
            if (r2 != 0) goto L_0x0031
            java.lang.String r2 = r1.zza     // Catch:{ all -> 0x011c }
            java.lang.String r3 = "E"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x011c }
            if (r2 != 0) goto L_0x0031
            java.lang.String r1 = r1.zza     // Catch:{ all -> 0x011c }
            java.lang.String r2 = "0000000000000000000000000000000000000000000000000000000000000000"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x011c }
            if (r1 == 0) goto L_0x00e8
        L_0x0031:
            r1 = 0
            boolean r2 = com.google.android.gms.internal.ads.zzgh.zzc(r1)     // Catch:{ all -> 0x011c }
            r3 = 0
            if (r2 != 0) goto L_0x003c
            com.google.android.gms.internal.ads.zzcj r2 = com.google.android.gms.internal.ads.zzcj.ENUM_SIGNAL_SOURCE_CALLER_PROVIDED     // Catch:{ all -> 0x011c }
            goto L_0x005e
        L_0x003c:
            boolean r2 = com.google.android.gms.internal.ads.zzgh.zzc(r1)     // Catch:{ all -> 0x011c }
            if (r2 != 0) goto L_0x0047
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x011c }
            goto L_0x004b
        L_0x0047:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x011c }
        L_0x004b:
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x011c }
            if (r2 == 0) goto L_0x005c
            com.google.android.gms.internal.ads.zzge r2 = r12.zzb     // Catch:{ all -> 0x011c }
            boolean r2 = r2.zzj()     // Catch:{ all -> 0x011c }
            if (r2 == 0) goto L_0x005c
            com.google.android.gms.internal.ads.zzcj r2 = com.google.android.gms.internal.ads.zzcj.ENUM_SIGNAL_SOURCE_GASS     // Catch:{ all -> 0x011c }
            goto L_0x005e
        L_0x005c:
            com.google.android.gms.internal.ads.zzcj r2 = com.google.android.gms.internal.ads.zzcj.ENUM_SIGNAL_SOURCE_ADSHIELD     // Catch:{ all -> 0x011c }
        L_0x005e:
            com.google.android.gms.internal.ads.zzcj r4 = com.google.android.gms.internal.ads.zzcj.ENUM_SIGNAL_SOURCE_ADSHIELD     // Catch:{ all -> 0x011c }
            r5 = 1
            if (r2 != r4) goto L_0x0065
            r4 = 1
            goto L_0x0066
        L_0x0065:
            r4 = 0
        L_0x0066:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x011c }
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzaeq.zzbv     // Catch:{ all -> 0x011c }
            com.google.android.gms.internal.ads.zzaeo r7 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ all -> 0x011c }
            java.lang.Object r6 = r7.zzb(r6)     // Catch:{ all -> 0x011c }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x011c }
            com.google.android.gms.internal.ads.zzaei<java.lang.String> r7 = com.google.android.gms.internal.ads.zzaeq.zzbw     // Catch:{ all -> 0x011c }
            com.google.android.gms.internal.ads.zzaeo r8 = com.google.android.gms.internal.ads.zzaaa.zzc()     // Catch:{ all -> 0x011c }
            java.lang.Object r7 = r8.zzb(r7)     // Catch:{ all -> 0x011c }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x011c }
            java.lang.reflect.Method r8 = r12.zzf     // Catch:{ all -> 0x011c }
            r9 = 4
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ all -> 0x011c }
            android.content.Context r11 = r12.zzj     // Catch:{ all -> 0x011c }
            r10[r3] = r11     // Catch:{ all -> 0x011c }
            r10[r5] = r4     // Catch:{ all -> 0x011c }
            r3 = 2
            r10[r3] = r6     // Catch:{ all -> 0x011c }
            r3 = 3
            r10[r3] = r7     // Catch:{ all -> 0x011c }
            java.lang.Object r4 = r8.invoke(r1, r10)     // Catch:{ all -> 0x011c }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x011c }
            com.google.android.gms.internal.ads.zzdy r5 = new com.google.android.gms.internal.ads.zzdy     // Catch:{ all -> 0x011c }
            r5.<init>(r4)     // Catch:{ all -> 0x011c }
            java.lang.String r4 = r5.zza     // Catch:{ all -> 0x011c }
            boolean r4 = com.google.android.gms.internal.ads.zzgh.zzc(r4)     // Catch:{ all -> 0x011c }
            if (r4 != 0) goto L_0x00b0
            java.lang.String r4 = r5.zza     // Catch:{ all -> 0x011c }
            java.lang.String r6 = "E"
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x011c }
            if (r4 == 0) goto L_0x00e5
        L_0x00b0:
            int r2 = r2.ordinal()     // Catch:{ all -> 0x011c }
            if (r2 == r3) goto L_0x00ba
            if (r2 == r9) goto L_0x00b9
            goto L_0x00e5
        L_0x00b9:
            throw r1     // Catch:{ all -> 0x011c }
        L_0x00ba:
            com.google.android.gms.internal.ads.zzge r2 = r12.zzb     // Catch:{ InterruptedException | ExecutionException -> 0x00dd }
            java.util.concurrent.Future r2 = r2.zzn()     // Catch:{ InterruptedException | ExecutionException -> 0x00dd }
            if (r2 == 0) goto L_0x00cb
            com.google.android.gms.internal.ads.zzge r2 = r12.zzb     // Catch:{ InterruptedException | ExecutionException -> 0x00dd }
            java.util.concurrent.Future r2 = r2.zzn()     // Catch:{ InterruptedException | ExecutionException -> 0x00dd }
            r2.get()     // Catch:{ InterruptedException | ExecutionException -> 0x00dd }
        L_0x00cb:
            com.google.android.gms.internal.ads.zzge r2 = r12.zzb     // Catch:{ InterruptedException | ExecutionException -> 0x00dd }
            com.google.android.gms.internal.ads.zzdc r2 = r2.zzm()     // Catch:{ InterruptedException | ExecutionException -> 0x00dd }
            if (r2 == 0) goto L_0x00dd
            boolean r3 = r2.zza()     // Catch:{ InterruptedException | ExecutionException -> 0x00dd }
            if (r3 == 0) goto L_0x00dd
            java.lang.String r1 = r2.zzc()     // Catch:{ InterruptedException | ExecutionException -> 0x00dd }
        L_0x00dd:
            boolean r2 = com.google.android.gms.internal.ads.zzgh.zzc(r1)     // Catch:{ all -> 0x011c }
            if (r2 != 0) goto L_0x00e5
            r5.zza = r1     // Catch:{ all -> 0x011c }
        L_0x00e5:
            r0.set(r5)     // Catch:{ all -> 0x011c }
        L_0x00e8:
            java.lang.Object r1 = r0.get()     // Catch:{ all -> 0x011c }
            com.google.android.gms.internal.ads.zzdy r1 = (com.google.android.gms.internal.ads.zzdy) r1     // Catch:{ all -> 0x011c }
            monitor-exit(r0)     // Catch:{ all -> 0x011c }
            com.google.android.gms.internal.ads.zzcn r2 = r12.zze
            monitor-enter(r2)
            if (r1 == 0) goto L_0x0117
            com.google.android.gms.internal.ads.zzcn r0 = r12.zze     // Catch:{ all -> 0x0119 }
            java.lang.String r3 = r1.zza     // Catch:{ all -> 0x0119 }
            r0.zzo(r3)     // Catch:{ all -> 0x0119 }
            com.google.android.gms.internal.ads.zzcn r0 = r12.zze     // Catch:{ all -> 0x0119 }
            long r3 = r1.zzb     // Catch:{ all -> 0x0119 }
            r0.zzu(r3)     // Catch:{ all -> 0x0119 }
            com.google.android.gms.internal.ads.zzcn r0 = r12.zze     // Catch:{ all -> 0x0119 }
            java.lang.String r3 = r1.zzc     // Catch:{ all -> 0x0119 }
            r0.zzt(r3)     // Catch:{ all -> 0x0119 }
            com.google.android.gms.internal.ads.zzcn r0 = r12.zze     // Catch:{ all -> 0x0119 }
            java.lang.String r3 = r1.zzd     // Catch:{ all -> 0x0119 }
            r0.zzD(r3)     // Catch:{ all -> 0x0119 }
            com.google.android.gms.internal.ads.zzcn r0 = r12.zze     // Catch:{ all -> 0x0119 }
            java.lang.String r1 = r1.zze     // Catch:{ all -> 0x0119 }
            r0.zzE(r1)     // Catch:{ all -> 0x0119 }
        L_0x0117:
            monitor-exit(r2)     // Catch:{ all -> 0x0119 }
            return
        L_0x0119:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0119 }
            throw r0
        L_0x011c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x011c }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgp.zza():void");
    }
}
