package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CollectionUtils;
import com.itextpdf.text.html.HtmlTags;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzate extends zzatk {
    static final Set<String> zza = CollectionUtils.setOf("top-left", "top-right", "top-center", HtmlTags.ALIGN_CENTER, "bottom-left", "bottom-right", "bottom-center");
    private String zzb = "top-right";
    private boolean zzc = true;
    private int zzd = 0;
    private int zze = 0;
    private int zzf = -1;
    private int zzg = 0;
    private int zzh = 0;
    private int zzi = -1;
    private final Object zzj = new Object();
    private final zzbgf zzk;
    private final Activity zzl;
    private zzbhv zzm;
    private ImageView zzn;
    private LinearLayout zzo;
    private final zzatl zzp;
    private PopupWindow zzq;
    private RelativeLayout zzr;
    private ViewGroup zzs;

    public zzate(zzbgf zzbgf, zzatl zzatl) {
        super(zzbgf, "resize");
        this.zzk = zzbgf;
        this.zzl = zzbgf.zzj();
        this.zzp = zzatl;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01f6 A[Catch:{ RuntimeException -> 0x041c }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01f7 A[Catch:{ RuntimeException -> 0x041c }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0257 A[Catch:{ RuntimeException -> 0x041c }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0465 A[Catch:{ RuntimeException -> 0x041c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.util.Map<java.lang.String, java.lang.String> r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            java.lang.Object r2 = r1.zzj
            monitor-enter(r2)
            android.app.Activity r3 = r1.zzl     // Catch:{ all -> 0x0481 }
            if (r3 != 0) goto L_0x0012
            java.lang.String r0 = "Not an activity context. Cannot resize."
            r1.zzf(r0)     // Catch:{ all -> 0x0481 }
            monitor-exit(r2)     // Catch:{ all -> 0x0481 }
            return
        L_0x0012:
            com.google.android.gms.internal.ads.zzbgf r3 = r1.zzk     // Catch:{ all -> 0x0481 }
            com.google.android.gms.internal.ads.zzbhv r3 = r3.zzP()     // Catch:{ all -> 0x0481 }
            if (r3 != 0) goto L_0x0021
            java.lang.String r0 = "Webview is not yet available, size is not set."
            r1.zzf(r0)     // Catch:{ all -> 0x0481 }
            monitor-exit(r2)     // Catch:{ all -> 0x0481 }
            return
        L_0x0021:
            com.google.android.gms.internal.ads.zzbgf r3 = r1.zzk     // Catch:{ all -> 0x0481 }
            com.google.android.gms.internal.ads.zzbhv r3 = r3.zzP()     // Catch:{ all -> 0x0481 }
            boolean r3 = r3.zzg()     // Catch:{ all -> 0x0481 }
            if (r3 == 0) goto L_0x0034
            java.lang.String r0 = "Is interstitial. Cannot resize an interstitial."
            r1.zzf(r0)     // Catch:{ all -> 0x0481 }
            monitor-exit(r2)     // Catch:{ all -> 0x0481 }
            return
        L_0x0034:
            com.google.android.gms.internal.ads.zzbgf r3 = r1.zzk     // Catch:{ all -> 0x0481 }
            boolean r3 = r3.zzW()     // Catch:{ all -> 0x0481 }
            if (r3 != 0) goto L_0x047a
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0481 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0481 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0481 }
            if (r3 != 0) goto L_0x005b
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0481 }
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0481 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0481 }
            int r3 = com.google.android.gms.ads.internal.util.zzr.zzO(r3)     // Catch:{ all -> 0x0481 }
            r1.zzi = r3     // Catch:{ all -> 0x0481 }
        L_0x005b:
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0481 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0481 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0481 }
            if (r3 != 0) goto L_0x007a
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0481 }
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0481 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0481 }
            int r3 = com.google.android.gms.ads.internal.util.zzr.zzO(r3)     // Catch:{ all -> 0x0481 }
            r1.zzf = r3     // Catch:{ all -> 0x0481 }
        L_0x007a:
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0481 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0481 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0481 }
            if (r3 != 0) goto L_0x0099
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0481 }
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0481 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0481 }
            int r3 = com.google.android.gms.ads.internal.util.zzr.zzO(r3)     // Catch:{ all -> 0x0481 }
            r1.zzg = r3     // Catch:{ all -> 0x0481 }
        L_0x0099:
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0481 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0481 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0481 }
            if (r3 != 0) goto L_0x00b8
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0481 }
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0481 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0481 }
            int r3 = com.google.android.gms.ads.internal.util.zzr.zzO(r3)     // Catch:{ all -> 0x0481 }
            r1.zzh = r3     // Catch:{ all -> 0x0481 }
        L_0x00b8:
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0481 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0481 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0481 }
            if (r3 != 0) goto L_0x00d4
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0481 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0481 }
            boolean r3 = java.lang.Boolean.parseBoolean(r3)     // Catch:{ all -> 0x0481 }
            r1.zzc = r3     // Catch:{ all -> 0x0481 }
        L_0x00d4:
            java.lang.String r3 = "customClosePosition"
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x0481 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0481 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0481 }
            if (r3 != 0) goto L_0x00e4
            r1.zzb = r0     // Catch:{ all -> 0x0481 }
        L_0x00e4:
            int r0 = r1.zzi     // Catch:{ all -> 0x0481 }
            if (r0 < 0) goto L_0x0473
            int r0 = r1.zzf     // Catch:{ all -> 0x0481 }
            if (r0 < 0) goto L_0x0473
            android.app.Activity r0 = r1.zzl     // Catch:{ all -> 0x0481 }
            android.view.Window r0 = r0.getWindow()     // Catch:{ all -> 0x0481 }
            if (r0 == 0) goto L_0x046c
            android.view.View r3 = r0.getDecorView()     // Catch:{ all -> 0x0481 }
            if (r3 != 0) goto L_0x00fc
            goto L_0x046c
        L_0x00fc:
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0481 }
            android.app.Activity r3 = r1.zzl     // Catch:{ all -> 0x0481 }
            int[] r3 = com.google.android.gms.ads.internal.util.zzr.zzW(r3)     // Catch:{ all -> 0x0481 }
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0481 }
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x0481 }
            int[] r4 = com.google.android.gms.ads.internal.util.zzr.zzT(r4)     // Catch:{ all -> 0x0481 }
            r5 = 0
            r6 = r3[r5]     // Catch:{ all -> 0x0481 }
            r7 = 1
            r3 = r3[r7]     // Catch:{ all -> 0x0481 }
            int r8 = r1.zzi     // Catch:{ all -> 0x0481 }
            r9 = 5
            r10 = 4
            r11 = 3
            r13 = 2
            r14 = 50
            if (r8 < r14) goto L_0x024f
            if (r8 <= r6) goto L_0x0122
            goto L_0x024f
        L_0x0122:
            int r15 = r1.zzf     // Catch:{ all -> 0x0481 }
            if (r15 < r14) goto L_0x0249
            if (r15 <= r3) goto L_0x012a
            goto L_0x0249
        L_0x012a:
            if (r15 != r3) goto L_0x0135
            if (r8 != r6) goto L_0x0135
            java.lang.String r3 = "Cannot resize to a full-screen ad."
            com.google.android.gms.ads.internal.util.zze.zzi(r3)     // Catch:{ all -> 0x0481 }
            goto L_0x0254
        L_0x0135:
            boolean r3 = r1.zzc     // Catch:{ all -> 0x0481 }
            if (r3 == 0) goto L_0x0208
            java.lang.String r3 = r1.zzb     // Catch:{ all -> 0x0481 }
            int r16 = r3.hashCode()     // Catch:{ all -> 0x0481 }
            switch(r16) {
                case -1364013995: goto L_0x0175;
                case -1012429441: goto L_0x016b;
                case -655373719: goto L_0x0161;
                case 1163912186: goto L_0x0157;
                case 1288627767: goto L_0x014d;
                case 1755462605: goto L_0x0143;
                default: goto L_0x0142;
            }
        L_0x0142:
            goto L_0x017f
        L_0x0143:
            java.lang.String r12 = "top-center"
            boolean r3 = r3.equals(r12)
            if (r3 == 0) goto L_0x017f
            r3 = 1
            goto L_0x0180
        L_0x014d:
            java.lang.String r12 = "bottom-center"
            boolean r3 = r3.equals(r12)
            if (r3 == 0) goto L_0x017f
            r3 = 4
            goto L_0x0180
        L_0x0157:
            java.lang.String r12 = "bottom-right"
            boolean r3 = r3.equals(r12)
            if (r3 == 0) goto L_0x017f
            r3 = 5
            goto L_0x0180
        L_0x0161:
            java.lang.String r12 = "bottom-left"
            boolean r3 = r3.equals(r12)
            if (r3 == 0) goto L_0x017f
            r3 = 3
            goto L_0x0180
        L_0x016b:
            java.lang.String r12 = "top-left"
            boolean r3 = r3.equals(r12)
            if (r3 == 0) goto L_0x017f
            r3 = 0
            goto L_0x0180
        L_0x0175:
            java.lang.String r12 = "center"
            boolean r3 = r3.equals(r12)
            if (r3 == 0) goto L_0x017f
            r3 = 2
            goto L_0x0180
        L_0x017f:
            r3 = -1
        L_0x0180:
            if (r3 == 0) goto L_0x01df
            if (r3 == r7) goto L_0x01d1
            if (r3 == r13) goto L_0x01bd
            if (r3 == r11) goto L_0x01b0
            if (r3 == r10) goto L_0x01a2
            if (r3 == r9) goto L_0x0197
            int r3 = r1.zzd     // Catch:{ all -> 0x0481 }
            int r12 = r1.zzg     // Catch:{ all -> 0x0481 }
            int r3 = r3 + r12
            int r3 = r3 + r8
            int r3 = r3 + -50
            int r8 = r1.zze     // Catch:{ all -> 0x0481 }
            goto L_0x01dc
        L_0x0197:
            int r3 = r1.zzd     // Catch:{ all -> 0x0481 }
            int r12 = r1.zzg     // Catch:{ all -> 0x0481 }
            int r3 = r3 + r12
            int r3 = r3 + r8
            int r3 = r3 + -50
            int r8 = r1.zze     // Catch:{ all -> 0x0481 }
            goto L_0x01ad
        L_0x01a2:
            int r3 = r1.zzd     // Catch:{ all -> 0x0481 }
            int r12 = r1.zzg     // Catch:{ all -> 0x0481 }
            int r3 = r3 + r12
            int r8 = r8 >> r7
            int r3 = r3 + r8
            int r3 = r3 + -25
            int r8 = r1.zze     // Catch:{ all -> 0x0481 }
        L_0x01ad:
            int r12 = r1.zzh     // Catch:{ all -> 0x0481 }
            goto L_0x01b8
        L_0x01b0:
            int r3 = r1.zzd     // Catch:{ all -> 0x0481 }
            int r8 = r1.zzg     // Catch:{ all -> 0x0481 }
            int r3 = r3 + r8
            int r8 = r1.zze     // Catch:{ all -> 0x0481 }
            goto L_0x01ad
        L_0x01b8:
            int r8 = r8 + r12
            int r8 = r8 + r15
            int r8 = r8 + -50
            goto L_0x01e8
        L_0x01bd:
            int r3 = r1.zzd     // Catch:{ all -> 0x0481 }
            int r12 = r1.zzg     // Catch:{ all -> 0x0481 }
            int r3 = r3 + r12
            int r8 = r8 >> r7
            int r3 = r3 + r8
            int r3 = r3 + -25
            int r8 = r1.zze     // Catch:{ all -> 0x0481 }
            int r12 = r1.zzh     // Catch:{ all -> 0x0481 }
            int r8 = r8 + r12
            int r12 = r15 >> 1
            int r8 = r8 + r12
            int r8 = r8 + -25
            goto L_0x01e8
        L_0x01d1:
            int r3 = r1.zzd     // Catch:{ all -> 0x0481 }
            int r12 = r1.zzg     // Catch:{ all -> 0x0481 }
            int r3 = r3 + r12
            int r8 = r8 >> r7
            int r3 = r3 + r8
            int r3 = r3 + -25
            int r8 = r1.zze     // Catch:{ all -> 0x0481 }
        L_0x01dc:
            int r12 = r1.zzh     // Catch:{ all -> 0x0481 }
            goto L_0x01e7
        L_0x01df:
            int r3 = r1.zzd     // Catch:{ all -> 0x0481 }
            int r8 = r1.zzg     // Catch:{ all -> 0x0481 }
            int r3 = r3 + r8
            int r8 = r1.zze     // Catch:{ all -> 0x0481 }
            goto L_0x01dc
        L_0x01e7:
            int r8 = r8 + r12
        L_0x01e8:
            if (r3 < 0) goto L_0x0254
            int r3 = r3 + r14
            if (r3 > r6) goto L_0x0254
            r3 = r4[r5]     // Catch:{ all -> 0x0481 }
            if (r8 < r3) goto L_0x0254
            int r8 = r8 + r14
            r3 = r4[r7]     // Catch:{ all -> 0x0481 }
            if (r8 <= r3) goto L_0x01f7
            goto L_0x0254
        L_0x01f7:
            int[] r15 = new int[r13]     // Catch:{ all -> 0x0481 }
            int r3 = r1.zzd     // Catch:{ all -> 0x0481 }
            int r4 = r1.zzg     // Catch:{ all -> 0x0481 }
            int r3 = r3 + r4
            r15[r5] = r3     // Catch:{ all -> 0x0481 }
            int r3 = r1.zze     // Catch:{ all -> 0x0481 }
            int r4 = r1.zzh     // Catch:{ all -> 0x0481 }
            int r3 = r3 + r4
            r15[r7] = r3     // Catch:{ all -> 0x0481 }
            goto L_0x0255
        L_0x0208:
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0481 }
            android.app.Activity r3 = r1.zzl     // Catch:{ all -> 0x0481 }
            int[] r3 = com.google.android.gms.ads.internal.util.zzr.zzW(r3)     // Catch:{ all -> 0x0481 }
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0481 }
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x0481 }
            int[] r4 = com.google.android.gms.ads.internal.util.zzr.zzT(r4)     // Catch:{ all -> 0x0481 }
            r3 = r3[r5]     // Catch:{ all -> 0x0481 }
            int r6 = r1.zzd     // Catch:{ all -> 0x0481 }
            int r8 = r1.zzg     // Catch:{ all -> 0x0481 }
            int r6 = r6 + r8
            int r8 = r1.zze     // Catch:{ all -> 0x0481 }
            int r12 = r1.zzh     // Catch:{ all -> 0x0481 }
            int r8 = r8 + r12
            if (r6 >= 0) goto L_0x022a
            r6 = 0
            goto L_0x0232
        L_0x022a:
            int r12 = r1.zzi     // Catch:{ all -> 0x0481 }
            int r15 = r6 + r12
            if (r15 <= r3) goto L_0x0232
            int r6 = r3 - r12
        L_0x0232:
            r3 = r4[r5]     // Catch:{ all -> 0x0481 }
            if (r8 >= r3) goto L_0x0238
            r8 = r3
            goto L_0x0242
        L_0x0238:
            int r3 = r1.zzf     // Catch:{ all -> 0x0481 }
            int r12 = r8 + r3
            r4 = r4[r7]     // Catch:{ all -> 0x0481 }
            if (r12 <= r4) goto L_0x0242
            int r8 = r4 - r3
        L_0x0242:
            int[] r15 = new int[r13]     // Catch:{ all -> 0x0481 }
            r15[r5] = r6     // Catch:{ all -> 0x0481 }
            r15[r7] = r8     // Catch:{ all -> 0x0481 }
            goto L_0x0255
        L_0x0249:
            java.lang.String r3 = "Height is too small or too large."
            com.google.android.gms.ads.internal.util.zze.zzi(r3)     // Catch:{ all -> 0x0481 }
            goto L_0x0254
        L_0x024f:
            java.lang.String r3 = "Width is too small or too large."
            com.google.android.gms.ads.internal.util.zze.zzi(r3)     // Catch:{ all -> 0x0481 }
        L_0x0254:
            r15 = 0
        L_0x0255:
            if (r15 == 0) goto L_0x0465
            com.google.android.gms.internal.ads.zzzy.zza()     // Catch:{ all -> 0x0481 }
            android.app.Activity r3 = r1.zzl     // Catch:{ all -> 0x0481 }
            int r4 = r1.zzi     // Catch:{ all -> 0x0481 }
            int r3 = com.google.android.gms.internal.ads.zzbbd.zzs(r3, r4)     // Catch:{ all -> 0x0481 }
            com.google.android.gms.internal.ads.zzzy.zza()     // Catch:{ all -> 0x0481 }
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x0481 }
            int r6 = r1.zzf     // Catch:{ all -> 0x0481 }
            int r4 = com.google.android.gms.internal.ads.zzbbd.zzs(r4, r6)     // Catch:{ all -> 0x0481 }
            com.google.android.gms.internal.ads.zzbgf r6 = r1.zzk     // Catch:{ all -> 0x0481 }
            android.view.View r6 = (android.view.View) r6     // Catch:{ all -> 0x0481 }
            android.view.ViewParent r6 = r6.getParent()     // Catch:{ all -> 0x0481 }
            if (r6 == 0) goto L_0x045e
            boolean r8 = r6 instanceof android.view.ViewGroup     // Catch:{ all -> 0x0481 }
            if (r8 == 0) goto L_0x045e
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6     // Catch:{ all -> 0x0481 }
            com.google.android.gms.internal.ads.zzbgf r8 = r1.zzk     // Catch:{ all -> 0x0481 }
            android.view.View r8 = (android.view.View) r8     // Catch:{ all -> 0x0481 }
            r6.removeView(r8)     // Catch:{ all -> 0x0481 }
            android.widget.PopupWindow r8 = r1.zzq     // Catch:{ all -> 0x0481 }
            if (r8 != 0) goto L_0x02c1
            r1.zzs = r6     // Catch:{ all -> 0x0481 }
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0481 }
            com.google.android.gms.internal.ads.zzbgf r6 = r1.zzk     // Catch:{ all -> 0x0481 }
            r8 = r6
            android.view.View r8 = (android.view.View) r8     // Catch:{ all -> 0x0481 }
            r8.setDrawingCacheEnabled(r7)     // Catch:{ all -> 0x0481 }
            r8 = r6
            android.view.View r8 = (android.view.View) r8     // Catch:{ all -> 0x0481 }
            android.graphics.Bitmap r8 = r8.getDrawingCache()     // Catch:{ all -> 0x0481 }
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r8)     // Catch:{ all -> 0x0481 }
            android.view.View r6 = (android.view.View) r6     // Catch:{ all -> 0x0481 }
            r6.setDrawingCacheEnabled(r5)     // Catch:{ all -> 0x0481 }
            android.widget.ImageView r6 = new android.widget.ImageView     // Catch:{ all -> 0x0481 }
            android.app.Activity r12 = r1.zzl     // Catch:{ all -> 0x0481 }
            r6.<init>(r12)     // Catch:{ all -> 0x0481 }
            r1.zzn = r6     // Catch:{ all -> 0x0481 }
            r6.setImageBitmap(r8)     // Catch:{ all -> 0x0481 }
            com.google.android.gms.internal.ads.zzbgf r6 = r1.zzk     // Catch:{ all -> 0x0481 }
            com.google.android.gms.internal.ads.zzbhv r6 = r6.zzP()     // Catch:{ all -> 0x0481 }
            r1.zzm = r6     // Catch:{ all -> 0x0481 }
            android.view.ViewGroup r6 = r1.zzs     // Catch:{ all -> 0x0481 }
            android.widget.ImageView r8 = r1.zzn     // Catch:{ all -> 0x0481 }
            r6.addView(r8)     // Catch:{ all -> 0x0481 }
            goto L_0x02c4
        L_0x02c1:
            r8.dismiss()     // Catch:{ all -> 0x0481 }
        L_0x02c4:
            android.widget.RelativeLayout r6 = new android.widget.RelativeLayout     // Catch:{ all -> 0x0481 }
            android.app.Activity r8 = r1.zzl     // Catch:{ all -> 0x0481 }
            r6.<init>(r8)     // Catch:{ all -> 0x0481 }
            r1.zzr = r6     // Catch:{ all -> 0x0481 }
            r6.setBackgroundColor(r5)     // Catch:{ all -> 0x0481 }
            android.widget.RelativeLayout r6 = r1.zzr     // Catch:{ all -> 0x0481 }
            android.view.ViewGroup$LayoutParams r8 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x0481 }
            r8.<init>(r3, r4)     // Catch:{ all -> 0x0481 }
            r6.setLayoutParams(r8)     // Catch:{ all -> 0x0481 }
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0481 }
            android.widget.RelativeLayout r6 = r1.zzr     // Catch:{ all -> 0x0481 }
            android.widget.PopupWindow r8 = new android.widget.PopupWindow     // Catch:{ all -> 0x0481 }
            r8.<init>(r6, r3, r4, r5)     // Catch:{ all -> 0x0481 }
            r1.zzq = r8     // Catch:{ all -> 0x0481 }
            r8.setOutsideTouchable(r7)     // Catch:{ all -> 0x0481 }
            android.widget.PopupWindow r6 = r1.zzq     // Catch:{ all -> 0x0481 }
            r6.setTouchable(r7)     // Catch:{ all -> 0x0481 }
            android.widget.PopupWindow r6 = r1.zzq     // Catch:{ all -> 0x0481 }
            boolean r8 = r1.zzc     // Catch:{ all -> 0x0481 }
            r8 = r8 ^ r7
            r6.setClippingEnabled(r8)     // Catch:{ all -> 0x0481 }
            android.widget.RelativeLayout r6 = r1.zzr     // Catch:{ all -> 0x0481 }
            com.google.android.gms.internal.ads.zzbgf r8 = r1.zzk     // Catch:{ all -> 0x0481 }
            android.view.View r8 = (android.view.View) r8     // Catch:{ all -> 0x0481 }
            r12 = -1
            r6.addView(r8, r12, r12)     // Catch:{ all -> 0x0481 }
            android.widget.LinearLayout r6 = new android.widget.LinearLayout     // Catch:{ all -> 0x0481 }
            android.app.Activity r8 = r1.zzl     // Catch:{ all -> 0x0481 }
            r6.<init>(r8)     // Catch:{ all -> 0x0481 }
            r1.zzo = r6     // Catch:{ all -> 0x0481 }
            android.widget.RelativeLayout$LayoutParams r6 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x0481 }
            com.google.android.gms.internal.ads.zzzy.zza()     // Catch:{ all -> 0x0481 }
            android.app.Activity r8 = r1.zzl     // Catch:{ all -> 0x0481 }
            int r8 = com.google.android.gms.internal.ads.zzbbd.zzs(r8, r14)     // Catch:{ all -> 0x0481 }
            com.google.android.gms.internal.ads.zzzy.zza()     // Catch:{ all -> 0x0481 }
            android.app.Activity r12 = r1.zzl     // Catch:{ all -> 0x0481 }
            int r12 = com.google.android.gms.internal.ads.zzbbd.zzs(r12, r14)     // Catch:{ all -> 0x0481 }
            r6.<init>(r8, r12)     // Catch:{ all -> 0x0481 }
            java.lang.String r8 = r1.zzb     // Catch:{ all -> 0x0481 }
            int r12 = r8.hashCode()     // Catch:{ all -> 0x0481 }
            switch(r12) {
                case -1364013995: goto L_0x035c;
                case -1012429441: goto L_0x0352;
                case -655373719: goto L_0x0348;
                case 1163912186: goto L_0x033e;
                case 1288627767: goto L_0x0334;
                case 1755462605: goto L_0x032a;
                default: goto L_0x0329;
            }
        L_0x0329:
            goto L_0x0366
        L_0x032a:
            java.lang.String r12 = "top-center"
            boolean r8 = r8.equals(r12)
            if (r8 == 0) goto L_0x0366
            r12 = 1
            goto L_0x0367
        L_0x0334:
            java.lang.String r12 = "bottom-center"
            boolean r8 = r8.equals(r12)
            if (r8 == 0) goto L_0x0366
            r12 = 4
            goto L_0x0367
        L_0x033e:
            java.lang.String r12 = "bottom-right"
            boolean r8 = r8.equals(r12)
            if (r8 == 0) goto L_0x0366
            r12 = 5
            goto L_0x0367
        L_0x0348:
            java.lang.String r12 = "bottom-left"
            boolean r8 = r8.equals(r12)
            if (r8 == 0) goto L_0x0366
            r12 = 3
            goto L_0x0367
        L_0x0352:
            java.lang.String r12 = "top-left"
            boolean r8 = r8.equals(r12)
            if (r8 == 0) goto L_0x0366
            r12 = 0
            goto L_0x0367
        L_0x035c:
            java.lang.String r12 = "center"
            boolean r8 = r8.equals(r12)
            if (r8 == 0) goto L_0x0366
            r12 = 2
            goto L_0x0367
        L_0x0366:
            r12 = -1
        L_0x0367:
            r8 = 9
            r14 = 10
            if (r12 == 0) goto L_0x03a6
            r5 = 14
            if (r12 == r7) goto L_0x039f
            if (r12 == r13) goto L_0x0399
            r13 = 12
            if (r12 == r11) goto L_0x0392
            if (r12 == r10) goto L_0x038b
            r5 = 11
            if (r12 == r9) goto L_0x0384
            r6.addRule(r14)     // Catch:{ all -> 0x0481 }
            r6.addRule(r5)     // Catch:{ all -> 0x0481 }
            goto L_0x03ac
        L_0x0384:
            r6.addRule(r13)     // Catch:{ all -> 0x0481 }
            r6.addRule(r5)     // Catch:{ all -> 0x0481 }
            goto L_0x03ac
        L_0x038b:
            r6.addRule(r13)     // Catch:{ all -> 0x0481 }
            r6.addRule(r5)     // Catch:{ all -> 0x0481 }
            goto L_0x03ac
        L_0x0392:
            r6.addRule(r13)     // Catch:{ all -> 0x0481 }
            r6.addRule(r8)     // Catch:{ all -> 0x0481 }
            goto L_0x03ac
        L_0x0399:
            r5 = 13
            r6.addRule(r5)     // Catch:{ all -> 0x0481 }
            goto L_0x03ac
        L_0x039f:
            r6.addRule(r14)     // Catch:{ all -> 0x0481 }
            r6.addRule(r5)     // Catch:{ all -> 0x0481 }
            goto L_0x03ac
        L_0x03a6:
            r6.addRule(r14)     // Catch:{ all -> 0x0481 }
            r6.addRule(r8)     // Catch:{ all -> 0x0481 }
        L_0x03ac:
            android.widget.LinearLayout r5 = r1.zzo     // Catch:{ all -> 0x0481 }
            com.google.android.gms.internal.ads.zzatd r8 = new com.google.android.gms.internal.ads.zzatd     // Catch:{ all -> 0x0481 }
            r8.<init>(r1)     // Catch:{ all -> 0x0481 }
            r5.setOnClickListener(r8)     // Catch:{ all -> 0x0481 }
            android.widget.LinearLayout r5 = r1.zzo     // Catch:{ all -> 0x0481 }
            java.lang.String r8 = "Close button"
            r5.setContentDescription(r8)     // Catch:{ all -> 0x0481 }
            android.widget.RelativeLayout r5 = r1.zzr     // Catch:{ all -> 0x0481 }
            android.widget.LinearLayout r8 = r1.zzo     // Catch:{ all -> 0x0481 }
            r5.addView(r8, r6)     // Catch:{ all -> 0x0481 }
            android.widget.PopupWindow r5 = r1.zzq     // Catch:{ RuntimeException -> 0x041c }
            android.view.View r0 = r0.getDecorView()     // Catch:{ RuntimeException -> 0x041c }
            com.google.android.gms.internal.ads.zzzy.zza()     // Catch:{ RuntimeException -> 0x041c }
            android.app.Activity r6 = r1.zzl     // Catch:{ RuntimeException -> 0x041c }
            r8 = 0
            r9 = r15[r8]     // Catch:{ RuntimeException -> 0x041c }
            int r6 = com.google.android.gms.internal.ads.zzbbd.zzs(r6, r9)     // Catch:{ RuntimeException -> 0x041c }
            com.google.android.gms.internal.ads.zzzy.zza()     // Catch:{ RuntimeException -> 0x041c }
            android.app.Activity r8 = r1.zzl     // Catch:{ RuntimeException -> 0x041c }
            r9 = r15[r7]     // Catch:{ RuntimeException -> 0x041c }
            int r8 = com.google.android.gms.internal.ads.zzbbd.zzs(r8, r9)     // Catch:{ RuntimeException -> 0x041c }
            r9 = 0
            r5.showAtLocation(r0, r9, r6, r8)     // Catch:{ RuntimeException -> 0x041c }
            r0 = r15[r9]     // Catch:{ all -> 0x0481 }
            r5 = r15[r7]     // Catch:{ all -> 0x0481 }
            com.google.android.gms.internal.ads.zzatl r6 = r1.zzp     // Catch:{ all -> 0x0481 }
            if (r6 == 0) goto L_0x03f4
            int r8 = r1.zzi     // Catch:{ all -> 0x0481 }
            int r9 = r1.zzf     // Catch:{ all -> 0x0481 }
            r6.zza(r0, r5, r8, r9)     // Catch:{ all -> 0x0481 }
        L_0x03f4:
            com.google.android.gms.internal.ads.zzbgf r0 = r1.zzk     // Catch:{ all -> 0x0481 }
            com.google.android.gms.internal.ads.zzbhv r3 = com.google.android.gms.internal.ads.zzbhv.zzc(r3, r4)     // Catch:{ all -> 0x0481 }
            r0.zzaf(r3)     // Catch:{ all -> 0x0481 }
            r0 = 0
            r3 = r15[r0]     // Catch:{ all -> 0x0481 }
            r4 = r15[r7]     // Catch:{ all -> 0x0481 }
            com.google.android.gms.ads.internal.zzs.zzc()     // Catch:{ all -> 0x0481 }
            android.app.Activity r5 = r1.zzl     // Catch:{ all -> 0x0481 }
            int[] r5 = com.google.android.gms.ads.internal.util.zzr.zzT(r5)     // Catch:{ all -> 0x0481 }
            r0 = r5[r0]     // Catch:{ all -> 0x0481 }
            int r4 = r4 - r0
            int r0 = r1.zzi     // Catch:{ all -> 0x0481 }
            int r5 = r1.zzf     // Catch:{ all -> 0x0481 }
            r1.zzh(r3, r4, r0, r5)     // Catch:{ all -> 0x0481 }
            java.lang.String r0 = "resized"
            r1.zzj(r0)     // Catch:{ all -> 0x0481 }
            monitor-exit(r2)     // Catch:{ all -> 0x0481 }
            return
        L_0x041c:
            r0 = move-exception
            java.lang.String r3 = "Cannot show popup window: "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0481 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0481 }
            int r4 = r0.length()     // Catch:{ all -> 0x0481 }
            if (r4 == 0) goto L_0x0432
            java.lang.String r0 = r3.concat(r0)     // Catch:{ all -> 0x0481 }
            goto L_0x0437
        L_0x0432:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0481 }
            r0.<init>(r3)     // Catch:{ all -> 0x0481 }
        L_0x0437:
            r1.zzf(r0)     // Catch:{ all -> 0x0481 }
            android.widget.RelativeLayout r0 = r1.zzr     // Catch:{ all -> 0x0481 }
            com.google.android.gms.internal.ads.zzbgf r3 = r1.zzk     // Catch:{ all -> 0x0481 }
            android.view.View r3 = (android.view.View) r3     // Catch:{ all -> 0x0481 }
            r0.removeView(r3)     // Catch:{ all -> 0x0481 }
            android.view.ViewGroup r0 = r1.zzs     // Catch:{ all -> 0x0481 }
            if (r0 == 0) goto L_0x045c
            android.widget.ImageView r3 = r1.zzn     // Catch:{ all -> 0x0481 }
            r0.removeView(r3)     // Catch:{ all -> 0x0481 }
            android.view.ViewGroup r0 = r1.zzs     // Catch:{ all -> 0x0481 }
            com.google.android.gms.internal.ads.zzbgf r3 = r1.zzk     // Catch:{ all -> 0x0481 }
            android.view.View r3 = (android.view.View) r3     // Catch:{ all -> 0x0481 }
            r0.addView(r3)     // Catch:{ all -> 0x0481 }
            com.google.android.gms.internal.ads.zzbgf r0 = r1.zzk     // Catch:{ all -> 0x0481 }
            com.google.android.gms.internal.ads.zzbhv r3 = r1.zzm     // Catch:{ all -> 0x0481 }
            r0.zzaf(r3)     // Catch:{ all -> 0x0481 }
        L_0x045c:
            monitor-exit(r2)     // Catch:{ all -> 0x0481 }
            return
        L_0x045e:
            java.lang.String r0 = "Webview is detached, probably in the middle of a resize or expand."
            r1.zzf(r0)     // Catch:{ all -> 0x0481 }
            monitor-exit(r2)     // Catch:{ all -> 0x0481 }
            return
        L_0x0465:
            java.lang.String r0 = "Resize location out of screen or close button is not visible."
            r1.zzf(r0)     // Catch:{ all -> 0x0481 }
            monitor-exit(r2)     // Catch:{ all -> 0x0481 }
            return
        L_0x046c:
            java.lang.String r0 = "Activity context is not ready, cannot get window or decor view."
            r1.zzf(r0)     // Catch:{ all -> 0x0481 }
            monitor-exit(r2)     // Catch:{ all -> 0x0481 }
            return
        L_0x0473:
            java.lang.String r0 = "Invalid width and height options. Cannot resize."
            r1.zzf(r0)     // Catch:{ all -> 0x0481 }
            monitor-exit(r2)     // Catch:{ all -> 0x0481 }
            return
        L_0x047a:
            java.lang.String r0 = "Cannot resize an expanded banner."
            r1.zzf(r0)     // Catch:{ all -> 0x0481 }
            monitor-exit(r2)     // Catch:{ all -> 0x0481 }
            return
        L_0x0481:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0481 }
            goto L_0x0485
        L_0x0484:
            throw r0
        L_0x0485:
            goto L_0x0484
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzate.zza(java.util.Map):void");
    }

    public final void zzb(boolean z) {
        synchronized (this.zzj) {
            PopupWindow popupWindow = this.zzq;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.zzr.removeView((View) this.zzk);
                ViewGroup viewGroup = this.zzs;
                if (viewGroup != null) {
                    viewGroup.removeView(this.zzn);
                    this.zzs.addView((View) this.zzk);
                    this.zzk.zzaf(this.zzm);
                }
                if (z) {
                    zzj("default");
                    zzatl zzatl = this.zzp;
                    if (zzatl != null) {
                        zzatl.zzb();
                    }
                }
                this.zzq = null;
                this.zzr = null;
                this.zzs = null;
                this.zzo = null;
            }
        }
    }

    public final void zzc(int i, int i2, boolean z) {
        synchronized (this.zzj) {
            this.zzd = i;
            this.zze = i2;
        }
    }

    public final boolean zzd() {
        boolean z;
        synchronized (this.zzj) {
            z = this.zzq != null;
        }
        return z;
    }

    public final void zze(int i, int i2) {
        this.zzd = i;
        this.zze = i2;
    }
}
