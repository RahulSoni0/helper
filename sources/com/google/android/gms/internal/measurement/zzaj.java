package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
final class zzaj extends zzag.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Context zze;
    private final /* synthetic */ Bundle zzf;
    private final /* synthetic */ zzag zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaj(zzag zzag, String str, String str2, Context context, Bundle bundle) {
        super(zzag);
        this.zzg = zzag;
        this.zzc = str;
        this.zzd = str2;
        this.zze = context;
        this.zzf = bundle;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048 A[Catch:{ Exception -> 0x0095 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054 A[Catch:{ Exception -> 0x0095 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza() {
        /*
            r14 = this;
            r0 = 0
            r1 = 1
            com.google.android.gms.internal.measurement.zzag r2 = r14.zzg     // Catch:{ Exception -> 0x0095 }
            java.lang.String r3 = r14.zzc     // Catch:{ Exception -> 0x0095 }
            java.lang.String r4 = r14.zzd     // Catch:{ Exception -> 0x0095 }
            boolean r2 = com.google.android.gms.internal.measurement.zzag.zzc(r3, r4)     // Catch:{ Exception -> 0x0095 }
            r3 = 0
            if (r2 == 0) goto L_0x001d
            java.lang.String r3 = r14.zzd     // Catch:{ Exception -> 0x0095 }
            java.lang.String r2 = r14.zzc     // Catch:{ Exception -> 0x0095 }
            com.google.android.gms.internal.measurement.zzag r4 = r14.zzg     // Catch:{ Exception -> 0x0095 }
            java.lang.String r4 = r4.zzc     // Catch:{ Exception -> 0x0095 }
            r10 = r2
            r11 = r3
            r9 = r4
            goto L_0x0020
        L_0x001d:
            r9 = r3
            r10 = r9
            r11 = r10
        L_0x0020:
            android.content.Context r2 = r14.zze     // Catch:{ Exception -> 0x0095 }
            com.google.android.gms.internal.measurement.zzag.zzh(r2)     // Catch:{ Exception -> 0x0095 }
            java.lang.Boolean r2 = com.google.android.gms.internal.measurement.zzag.zzh     // Catch:{ Exception -> 0x0095 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x0095 }
            if (r2 != 0) goto L_0x0034
            if (r10 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r2 = 0
            goto L_0x0035
        L_0x0034:
            r2 = 1
        L_0x0035:
            com.google.android.gms.internal.measurement.zzag r3 = r14.zzg     // Catch:{ Exception -> 0x0095 }
            android.content.Context r4 = r14.zze     // Catch:{ Exception -> 0x0095 }
            com.google.android.gms.internal.measurement.zzv r4 = r3.zza((android.content.Context) r4, (boolean) r2)     // Catch:{ Exception -> 0x0095 }
            com.google.android.gms.internal.measurement.zzv unused = r3.zzm = r4     // Catch:{ Exception -> 0x0095 }
            com.google.android.gms.internal.measurement.zzag r3 = r14.zzg     // Catch:{ Exception -> 0x0095 }
            com.google.android.gms.internal.measurement.zzv r3 = r3.zzm     // Catch:{ Exception -> 0x0095 }
            if (r3 != 0) goto L_0x0054
            com.google.android.gms.internal.measurement.zzag r2 = r14.zzg     // Catch:{ Exception -> 0x0095 }
            java.lang.String r2 = r2.zzc     // Catch:{ Exception -> 0x0095 }
            java.lang.String r3 = "Failed to connect to measurement client."
            android.util.Log.w(r2, r3)     // Catch:{ Exception -> 0x0095 }
            return
        L_0x0054:
            android.content.Context r3 = r14.zze     // Catch:{ Exception -> 0x0095 }
            int r3 = com.google.android.gms.internal.measurement.zzag.zzg(r3)     // Catch:{ Exception -> 0x0095 }
            android.content.Context r4 = r14.zze     // Catch:{ Exception -> 0x0095 }
            int r4 = com.google.android.gms.internal.measurement.zzag.zzf(r4)     // Catch:{ Exception -> 0x0095 }
            if (r2 == 0) goto L_0x006d
            int r2 = java.lang.Math.max(r3, r4)     // Catch:{ Exception -> 0x0095 }
            if (r4 >= r3) goto L_0x006a
            r3 = 1
            goto L_0x006b
        L_0x006a:
            r3 = 0
        L_0x006b:
            r8 = r3
            goto L_0x0077
        L_0x006d:
            if (r3 <= 0) goto L_0x0070
            r4 = r3
        L_0x0070:
            if (r3 <= 0) goto L_0x0074
            r2 = 1
            goto L_0x0075
        L_0x0074:
            r2 = 0
        L_0x0075:
            r8 = r2
            r2 = r4
        L_0x0077:
            com.google.android.gms.internal.measurement.zzae r13 = new com.google.android.gms.internal.measurement.zzae     // Catch:{ Exception -> 0x0095 }
            r4 = 33025(0x8101, double:1.63165E-319)
            long r6 = (long) r2     // Catch:{ Exception -> 0x0095 }
            android.os.Bundle r12 = r14.zzf     // Catch:{ Exception -> 0x0095 }
            r3 = r13
            r3.<init>(r4, r6, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0095 }
            com.google.android.gms.internal.measurement.zzag r2 = r14.zzg     // Catch:{ Exception -> 0x0095 }
            com.google.android.gms.internal.measurement.zzv r2 = r2.zzm     // Catch:{ Exception -> 0x0095 }
            android.content.Context r3 = r14.zze     // Catch:{ Exception -> 0x0095 }
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r3)     // Catch:{ Exception -> 0x0095 }
            long r4 = r14.zza     // Catch:{ Exception -> 0x0095 }
            r2.initialize(r3, r13, r4)     // Catch:{ Exception -> 0x0095 }
            return
        L_0x0095:
            r2 = move-exception
            com.google.android.gms.internal.measurement.zzag r3 = r14.zzg
            r3.zza((java.lang.Exception) r2, (boolean) r1, (boolean) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaj.zza():void");
    }
}
