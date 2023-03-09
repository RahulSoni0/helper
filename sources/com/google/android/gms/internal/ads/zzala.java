package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import androidx.core.app.NotificationManagerCompat;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzang;
import com.google.android.gms.internal.ads.zzbfw;
import com.google.android.gms.internal.ads.zzbgf;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhh;
import com.google.android.gms.internal.ads.zzbhl;
import com.google.android.gms.internal.ads.zzbho;
import com.google.android.gms.internal.ads.zzbhq;
import com.google.android.gms.internal.ads.zzyi;
import com.itextpdf.text.html.HtmlTags;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzala<T extends zzyi & zzbfw & zzbgf & zzang & zzbhc & zzbhh & zzbhl & zzbho & zzbhq> implements zzakp<T> {
    private final zzb zza;
    private final zzcni zzb;
    private final zzdvo zzc;
    private final zzbbp zzd;
    private final zzate zze;
    private final zzcvk zzf;
    private zzu zzg = null;

    public zzala(zzb zzb2, zzate zzate, zzcvk zzcvk, zzcni zzcni, zzdvo zzdvo) {
        this.zza = zzb2;
        this.zze = zzate;
        this.zzf = zzcvk;
        this.zzb = zzcni;
        this.zzc = zzdvo;
        this.zzd = new zzbbp((String) null);
    }

    public static boolean zzc(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    public static int zzd(Map<String, String> map) {
        String str = map.get("o");
        if (str == null) {
            return -1;
        }
        if (HtmlTags.f1204P.equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        if ("c".equalsIgnoreCase(str)) {
            return zzs.zze().zzh();
        }
        return -1;
    }

    static Uri zze(Context context, zzfh zzfh, Uri uri, View view, Activity activity) {
        if (zzfh == null) {
            return uri;
        }
        try {
            if (zzfh.zzf(uri)) {
                return zzfh.zze(uri, context, view, activity);
            }
            return uri;
        } catch (zzfi unused) {
            return uri;
        } catch (Exception e) {
            zzs.zzg().zzg(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    static Uri zzf(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            String valueOf = String.valueOf(uri.toString());
            zze.zzg(valueOf.length() != 0 ? "Error adding click uptime parameter to url: ".concat(valueOf) : new String("Error adding click uptime parameter to url: "), e);
        }
        return uri;
    }

    private final boolean zzh(T t, Context context, String str, String str2) {
        String str3 = str2;
        zzs.zzc();
        boolean zzH = zzr.zzH(context);
        zzs.zzc();
        zzbh zzC = zzr.zzC(context);
        zzcni zzcni = this.zzb;
        if (zzcni != null) {
            zzcvs.zzd(context, zzcni, this.zzc, this.zzf, str2, "offline_open");
        }
        zzbgf zzbgf = (zzbgf) t;
        boolean z = zzbgf.zzP().zzg() && zzbgf.zzj() == null;
        if (zzH) {
            this.zzf.zzc(this.zzd, str3);
            return false;
        }
        zzs.zzc();
        if (NotificationManagerCompat.from(context).areNotificationsEnabled() && zzC != null && !z) {
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfA)).booleanValue()) {
                if (zzbgf.zzP().zzg()) {
                    zzcvs.zzc(zzbgf.zzj(), (zzm) null, zzC, this.zzf, this.zzb, this.zzc, str2, str);
                } else {
                    ((zzbhl) t).zzaJ(zzC, this.zzf, this.zzb, this.zzc, str2, str, zzs.zze().zzh());
                }
                zzcni zzcni2 = this.zzb;
                if (zzcni2 != null) {
                    zzcvs.zzd(context, zzcni2, this.zzc, this.zzf, str2, "dialog_impression");
                }
                t.onAdClicked();
                return true;
            }
        }
        this.zzf.zzd(str3);
        if (this.zzb != null) {
            HashMap hashMap = new HashMap();
            zzs.zzc();
            if (!NotificationManagerCompat.from(context).areNotificationsEnabled()) {
                hashMap.put("dialog_not_shown_reason", "notifications_disabled");
            } else if (zzC == null) {
                hashMap.put("dialog_not_shown_reason", "work_manager_unavailable");
            } else {
                if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzfA)).booleanValue()) {
                    hashMap.put("dialog_not_shown_reason", "notification_flow_disabled");
                } else if (z) {
                    hashMap.put("dialog_not_shown_reason", "fullscreen_no_activity");
                }
            }
            zzcvs.zzh(context, this.zzb, this.zzc, this.zzf, str2, "dialog_not_shown", hashMap);
        }
        return false;
    }

    private final void zzi(T t, Intent intent) {
        try {
            ((zzbhl) t).zzaF(new zzc(intent, this.zzg));
        } catch (ActivityNotFoundException e) {
            zze.zzi(e.getMessage());
        }
    }

    private final void zzj(boolean z) {
        zzate zzate = this.zze;
        if (zzate != null) {
            zzate.zzb(z);
        }
    }

    /* access modifiers changed from: private */
    public final void zzk(int i) {
        if (this.zzb != null) {
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfI)).booleanValue()) {
                zzdvo zzdvo = this.zzc;
                zzdvn zza2 = zzdvn.zza("cct_action");
                zza2.zzc("cct_open_status", zzafn.zza(i));
                zzdvo.zza(zza2);
                return;
            }
            zzcnh zza3 = this.zzb.zza();
            zza3.zzc("action", "cct_action");
            zza3.zzc("cct_open_status", zzafn.zza(i));
            zza3.zzd();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0298, code lost:
        if (com.google.android.gms.internal.ads.zzakz.zzb(r13, r4, r6, r8) == null) goto L_0x029a;
     */
    /* renamed from: zzb */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r27, java.util.Map<java.lang.String, java.lang.String> r28) {
        /*
            r26 = this;
            r1 = r26
            r2 = r27
            r3 = r28
            java.lang.String r0 = "u"
            java.lang.Object r4 = r3.get(r0)
            java.lang.String r4 = (java.lang.String) r4
            r5 = r2
            com.google.android.gms.internal.ads.zzbgf r5 = (com.google.android.gms.internal.ads.zzbgf) r5
            android.content.Context r6 = r5.getContext()
            r7 = 1
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r7)
            java.lang.String r4 = com.google.android.gms.internal.ads.zzazv.zza(r4, r6, r7)
            java.lang.String r6 = "a"
            java.lang.Object r6 = r3.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L_0x002e
            java.lang.String r0 = "Action missing from an open GMSG."
            com.google.android.gms.ads.internal.util.zze.zzi(r0)
            return
        L_0x002e:
            com.google.android.gms.ads.internal.zzb r9 = r1.zza
            if (r9 == 0) goto L_0x003f
            boolean r9 = r9.zzb()
            if (r9 == 0) goto L_0x0039
            goto L_0x003f
        L_0x0039:
            com.google.android.gms.ads.internal.zzb r0 = r1.zza
            r0.zzc(r4)
            return
        L_0x003f:
            com.google.android.gms.internal.ads.zzdqo r9 = r5.zzF()
            com.google.android.gms.internal.ads.zzdqr r10 = r5.zzaB()
            r11 = 0
            java.lang.String r12 = ""
            if (r9 == 0) goto L_0x0053
            if (r10 == 0) goto L_0x0053
            boolean r9 = r9.zzad
            java.lang.String r12 = r10.zzb
            goto L_0x0054
        L_0x0053:
            r9 = 0
        L_0x0054:
            java.lang.String r10 = "expand"
            boolean r10 = r10.equalsIgnoreCase(r6)
            if (r10 == 0) goto L_0x007a
            boolean r0 = r5.zzW()
            if (r0 == 0) goto L_0x0068
            java.lang.String r0 = "Cannot expand WebView that is already expanded."
            com.google.android.gms.ads.internal.util.zze.zzi(r0)
            return
        L_0x0068:
            r1.zzj(r11)
            r0 = r2
            com.google.android.gms.internal.ads.zzbhl r0 = (com.google.android.gms.internal.ads.zzbhl) r0
            boolean r2 = zzc(r28)
            int r3 = zzd(r28)
            r0.zzaG(r2, r3)
            return
        L_0x007a:
            java.lang.String r10 = "webapp"
            boolean r10 = r10.equalsIgnoreCase(r6)
            if (r10 == 0) goto L_0x00b5
            r1.zzj(r11)
            if (r4 == 0) goto L_0x0096
            r0 = r2
            com.google.android.gms.internal.ads.zzbhl r0 = (com.google.android.gms.internal.ads.zzbhl) r0
            boolean r2 = zzc(r28)
            int r3 = zzd(r28)
            r0.zzaH(r2, r3, r4)
            return
        L_0x0096:
            r0 = r2
            com.google.android.gms.internal.ads.zzbhl r0 = (com.google.android.gms.internal.ads.zzbhl) r0
            boolean r2 = zzc(r28)
            int r4 = zzd(r28)
            java.lang.String r5 = "html"
            java.lang.Object r5 = r3.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = "baseurl"
            java.lang.Object r3 = r3.get(r6)
            java.lang.String r3 = (java.lang.String) r3
            r0.zzaI(r2, r4, r5, r3)
            return
        L_0x00b5:
            java.lang.String r10 = "chrome_custom_tab"
            boolean r10 = r10.equalsIgnoreCase(r6)
            if (r10 == 0) goto L_0x01aa
            android.content.Context r10 = r5.getContext()
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r13 = com.google.android.gms.internal.ads.zzaeq.zzcJ
            com.google.android.gms.internal.ads.zzaeo r14 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r13 = r14.zzb(r13)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L_0x00d5
            goto L_0x01aa
        L_0x00d5:
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r13 = com.google.android.gms.internal.ads.zzaeq.zzcP
            com.google.android.gms.internal.ads.zzaeo r14 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r13 = r14.zzb(r13)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x00ee
            java.lang.String r10 = "User opt out chrome custom tab."
            com.google.android.gms.ads.internal.util.zze.zza(r10)
            goto L_0x01aa
        L_0x00ee:
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r13 = com.google.android.gms.internal.ads.zzaeq.zzcN
            com.google.android.gms.internal.ads.zzaeo r14 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r13 = r14.zzb(r13)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L_0x0101
            goto L_0x013d
        L_0x0101:
            com.google.android.gms.internal.ads.zzaei<java.lang.String> r13 = com.google.android.gms.internal.ads.zzaeq.zzcO
            com.google.android.gms.internal.ads.zzaeo r14 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r13 = r14.zzb(r13)
            java.lang.String r13 = (java.lang.String) r13
            boolean r14 = r13.isEmpty()
            if (r14 != 0) goto L_0x01aa
            if (r10 == 0) goto L_0x01aa
            java.lang.String r10 = r10.getPackageName()
            r14 = 59
            com.google.android.gms.internal.ads.zzeby r14 = com.google.android.gms.internal.ads.zzeby.zzb(r14)
            com.google.android.gms.internal.ads.zzecq r14 = com.google.android.gms.internal.ads.zzecq.zza(r14)
            java.lang.Iterable r13 = r14.zzb(r13)
            java.util.Iterator r13 = r13.iterator()
        L_0x012b:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x01aa
            java.lang.Object r14 = r13.next()
            java.lang.String r14 = (java.lang.String) r14
            boolean r14 = r14.equals(r10)
            if (r14 == 0) goto L_0x012b
        L_0x013d:
            r1.zzj(r7)
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L_0x0150
            java.lang.String r0 = "Cannot open browser with null or empty url"
            com.google.android.gms.ads.internal.util.zze.zzi(r0)
            r0 = 7
            r1.zzk(r0)
            return
        L_0x0150:
            android.net.Uri r0 = android.net.Uri.parse(r4)
            android.content.Context r3 = r5.getContext()
            com.google.android.gms.internal.ads.zzfh r4 = r5.zzU()
            android.view.View r6 = r5.zzH()
            android.app.Activity r7 = r5.zzj()
            android.net.Uri r0 = zze(r3, r4, r0, r6, r7)
            android.net.Uri r0 = zzf(r0)
            if (r9 == 0) goto L_0x0181
            com.google.android.gms.internal.ads.zzcvk r3 = r1.zzf
            if (r3 == 0) goto L_0x0181
            android.content.Context r3 = r5.getContext()
            java.lang.String r4 = r0.toString()
            boolean r3 = r1.zzh(r2, r3, r4, r12)
            if (r3 == 0) goto L_0x0181
            return
        L_0x0181:
            com.google.android.gms.internal.ads.zzakx r3 = new com.google.android.gms.internal.ads.zzakx
            r3.<init>(r1)
            r1.zzg = r3
            com.google.android.gms.internal.ads.zzbhl r2 = (com.google.android.gms.internal.ads.zzbhl) r2
            com.google.android.gms.ads.internal.overlay.zzc r14 = new com.google.android.gms.ads.internal.overlay.zzc
            r4 = 0
            java.lang.String r5 = r0.toString()
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            com.google.android.gms.ads.internal.overlay.zzu r0 = r1.zzg
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r0)
            android.os.IBinder r12 = r0.asBinder()
            r13 = 1
            r3 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r2.zzaF(r14)
            return
        L_0x01aa:
            java.lang.String r10 = "app"
            boolean r10 = r10.equalsIgnoreCase(r6)
            r13 = 0
            if (r10 == 0) goto L_0x0317
            java.lang.String r10 = "system_browser"
            java.lang.Object r10 = r3.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            java.lang.String r14 = "true"
            boolean r10 = r14.equalsIgnoreCase(r10)
            if (r10 == 0) goto L_0x0317
            r1.zzj(r7)
            android.content.Context r4 = r5.getContext()
            com.google.android.gms.internal.ads.zzfh r6 = r5.zzU()
            android.view.View r8 = r5.zzH()
            java.lang.String r10 = "activity"
            java.lang.Object r10 = r4.getSystemService(r10)
            android.app.ActivityManager r10 = (android.app.ActivityManager) r10
            java.lang.Object r0 = r3.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r14 = android.text.TextUtils.isEmpty(r0)
            if (r14 == 0) goto L_0x01e8
            goto L_0x02f8
        L_0x01e8:
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.net.Uri r0 = zze(r4, r6, r0, r8, r13)
            android.net.Uri r0 = zzf(r0)
            java.lang.String r14 = "use_first_package"
            java.lang.Object r14 = r3.get(r14)
            java.lang.String r14 = (java.lang.String) r14
            boolean r14 = java.lang.Boolean.parseBoolean(r14)
            java.lang.String r15 = "use_running_process"
            java.lang.Object r15 = r3.get(r15)
            java.lang.String r15 = (java.lang.String) r15
            boolean r15 = java.lang.Boolean.parseBoolean(r15)
            java.lang.String r13 = "use_custom_tabs"
            java.lang.Object r3 = r3.get(r13)
            java.lang.String r3 = (java.lang.String) r3
            boolean r3 = java.lang.Boolean.parseBoolean(r3)
            if (r3 != 0) goto L_0x022e
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzaeq.zzcH
            com.google.android.gms.internal.ads.zzaeo r13 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r3 = r13.zzb(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x022d
            goto L_0x022e
        L_0x022d:
            r7 = 0
        L_0x022e:
            java.lang.String r3 = r0.getScheme()
            java.lang.String r13 = "http"
            boolean r3 = r13.equalsIgnoreCase(r3)
            java.lang.String r11 = "https"
            if (r3 == 0) goto L_0x0249
            android.net.Uri$Builder r3 = r0.buildUpon()
            android.net.Uri$Builder r3 = r3.scheme(r11)
            android.net.Uri r13 = r3.build()
            goto L_0x0261
        L_0x0249:
            java.lang.String r3 = r0.getScheme()
            boolean r3 = r11.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0260
            android.net.Uri$Builder r3 = r0.buildUpon()
            android.net.Uri$Builder r3 = r3.scheme(r13)
            android.net.Uri r13 = r3.build()
            goto L_0x0261
        L_0x0260:
            r13 = 0
        L_0x0261:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            android.content.Intent r0 = com.google.android.gms.internal.ads.zzakz.zza(r0, r4, r6, r8)
            android.content.Intent r11 = com.google.android.gms.internal.ads.zzakz.zza(r13, r4, r6, r8)
            if (r7 == 0) goto L_0x027c
            com.google.android.gms.ads.internal.zzs.zzc()
            com.google.android.gms.ads.internal.util.zzr.zzu(r4, r0)
            com.google.android.gms.ads.internal.zzs.zzc()
            com.google.android.gms.ads.internal.util.zzr.zzu(r4, r11)
        L_0x027c:
            android.content.pm.ResolveInfo r7 = com.google.android.gms.internal.ads.zzakz.zzc(r0, r3, r4, r6, r8)
            if (r7 == 0) goto L_0x0288
            android.content.Intent r13 = com.google.android.gms.internal.ads.zzakz.zzd(r0, r7, r4, r6, r8)
            goto L_0x02f8
        L_0x0288:
            if (r11 == 0) goto L_0x029a
            android.content.pm.ResolveInfo r7 = com.google.android.gms.internal.ads.zzakz.zzb(r11, r4, r6, r8)
            if (r7 == 0) goto L_0x029a
            android.content.Intent r13 = com.google.android.gms.internal.ads.zzakz.zzd(r0, r7, r4, r6, r8)
            android.content.pm.ResolveInfo r7 = com.google.android.gms.internal.ads.zzakz.zzb(r13, r4, r6, r8)
            if (r7 != 0) goto L_0x02f8
        L_0x029a:
            int r7 = r3.size()
            if (r7 != 0) goto L_0x02a1
            goto L_0x02f7
        L_0x02a1:
            if (r15 == 0) goto L_0x02e9
            if (r10 == 0) goto L_0x02e9
            java.util.List r7 = r10.getRunningAppProcesses()
            if (r7 == 0) goto L_0x02e9
            int r10 = r3.size()
            r11 = 0
        L_0x02b0:
            if (r11 >= r10) goto L_0x02e9
            java.lang.Object r13 = r3.get(r11)
            android.content.pm.ResolveInfo r13 = (android.content.pm.ResolveInfo) r13
            java.util.Iterator r15 = r7.iterator()
        L_0x02bc:
            int r16 = r11 + 1
            boolean r18 = r15.hasNext()
            if (r18 == 0) goto L_0x02e6
            java.lang.Object r16 = r15.next()
            r28 = r7
            r7 = r16
            android.app.ActivityManager$RunningAppProcessInfo r7 = (android.app.ActivityManager.RunningAppProcessInfo) r7
            java.lang.String r7 = r7.processName
            r18 = r10
            android.content.pm.ActivityInfo r10 = r13.activityInfo
            java.lang.String r10 = r10.packageName
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x02e1
            android.content.Intent r13 = com.google.android.gms.internal.ads.zzakz.zzd(r0, r13, r4, r6, r8)
            goto L_0x02f8
        L_0x02e1:
            r7 = r28
            r10 = r18
            goto L_0x02bc
        L_0x02e6:
            r11 = r16
            goto L_0x02b0
        L_0x02e9:
            if (r14 == 0) goto L_0x02f7
            r7 = 0
            java.lang.Object r3 = r3.get(r7)
            android.content.pm.ResolveInfo r3 = (android.content.pm.ResolveInfo) r3
            android.content.Intent r13 = com.google.android.gms.internal.ads.zzakz.zzd(r0, r3, r4, r6, r8)
            goto L_0x02f8
        L_0x02f7:
            r13 = r0
        L_0x02f8:
            if (r9 == 0) goto L_0x0313
            com.google.android.gms.internal.ads.zzcvk r0 = r1.zzf
            if (r0 == 0) goto L_0x0313
            if (r13 == 0) goto L_0x0313
            android.content.Context r0 = r5.getContext()
            android.net.Uri r3 = r13.getData()
            java.lang.String r3 = r3.toString()
            boolean r0 = r1.zzh(r2, r0, r3, r12)
            if (r0 == 0) goto L_0x0313
            return
        L_0x0313:
            r1.zzi(r2, r13)
            return
        L_0x0317:
            java.lang.String r0 = "open_app"
            boolean r0 = r0.equalsIgnoreCase(r6)
            java.lang.String r10 = "p"
            if (r0 == 0) goto L_0x037a
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzaeq.zzfs
            com.google.android.gms.internal.ads.zzaeo r4 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r0 = r4.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0334
            return
        L_0x0334:
            r1.zzj(r7)
            java.lang.Object r0 = r3.get(r10)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0345
            java.lang.String r0 = "Package name missing from open app action."
            com.google.android.gms.ads.internal.util.zze.zzi(r0)
            return
        L_0x0345:
            if (r9 == 0) goto L_0x0357
            com.google.android.gms.internal.ads.zzcvk r3 = r1.zzf
            if (r3 == 0) goto L_0x0357
            android.content.Context r3 = r5.getContext()
            boolean r3 = r1.zzh(r2, r3, r0, r12)
            if (r3 != 0) goto L_0x0356
            goto L_0x0357
        L_0x0356:
            return
        L_0x0357:
            android.content.Context r3 = r5.getContext()
            android.content.pm.PackageManager r3 = r3.getPackageManager()
            if (r3 != 0) goto L_0x0367
            java.lang.String r0 = "Cannot get package manager from open app action."
            com.google.android.gms.ads.internal.util.zze.zzi(r0)
            return
        L_0x0367:
            android.content.Intent r0 = r3.getLaunchIntentForPackage(r0)
            if (r0 == 0) goto L_0x0379
            com.google.android.gms.internal.ads.zzbhl r2 = (com.google.android.gms.internal.ads.zzbhl) r2
            com.google.android.gms.ads.internal.overlay.zzc r3 = new com.google.android.gms.ads.internal.overlay.zzc
            com.google.android.gms.ads.internal.overlay.zzu r4 = r1.zzg
            r3.<init>(r0, r4)
            r2.zzaF(r3)
        L_0x0379:
            return
        L_0x037a:
            r1.zzj(r7)
            java.lang.String r0 = "intent_url"
            java.lang.Object r0 = r3.get(r0)
            r11 = r0
            java.lang.String r11 = (java.lang.String) r11
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto L_0x03ae
            r13 = 0
            android.content.Intent r0 = android.content.Intent.parseUri(r11, r13)     // Catch:{ URISyntaxException -> 0x0392 }
            goto L_0x03b0
        L_0x0392:
            r0 = move-exception
            r14 = r0
            java.lang.String r0 = java.lang.String.valueOf(r11)
            java.lang.String r11 = "Error parsing the url: "
            int r15 = r0.length()
            if (r15 == 0) goto L_0x03a5
            java.lang.String r0 = r11.concat(r0)
            goto L_0x03aa
        L_0x03a5:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r11)
        L_0x03aa:
            com.google.android.gms.ads.internal.util.zze.zzg(r0, r14)
            goto L_0x03af
        L_0x03ae:
            r13 = 0
        L_0x03af:
            r0 = 0
        L_0x03b0:
            if (r0 == 0) goto L_0x0403
            android.net.Uri r11 = r0.getData()
            if (r11 == 0) goto L_0x0403
            android.net.Uri r11 = r0.getData()
            android.net.Uri r14 = android.net.Uri.EMPTY
            boolean r14 = r14.equals(r11)
            if (r14 != 0) goto L_0x0403
            android.content.Context r14 = r5.getContext()
            com.google.android.gms.internal.ads.zzfh r15 = r5.zzU()
            android.view.View r7 = r5.zzH()
            android.app.Activity r13 = r5.zzj()
            android.net.Uri r7 = zze(r14, r15, r11, r7, r13)
            android.net.Uri r7 = zzf(r7)
            java.lang.String r11 = r0.getType()
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x0400
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r11 = com.google.android.gms.internal.ads.zzaeq.zzft
            com.google.android.gms.internal.ads.zzaeo r13 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r11 = r13.zzb(r11)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x0400
            java.lang.String r11 = r0.getType()
            r0.setDataAndType(r7, r11)
            goto L_0x0403
        L_0x0400:
            r0.setData(r7)
        L_0x0403:
            com.google.android.gms.internal.ads.zzaei<java.lang.Boolean> r7 = com.google.android.gms.internal.ads.zzaeq.zzfE
            com.google.android.gms.internal.ads.zzaeo r11 = com.google.android.gms.internal.ads.zzaaa.zzc()
            java.lang.Object r7 = r11.zzb(r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            java.lang.String r11 = "event_id"
            if (r7 == 0) goto L_0x0427
            java.lang.String r7 = "intent_async"
            boolean r6 = r7.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x0427
            boolean r6 = r3.containsKey(r11)
            if (r6 == 0) goto L_0x0427
            r7 = 1
            goto L_0x0428
        L_0x0427:
            r7 = 0
        L_0x0428:
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            if (r7 == 0) goto L_0x0436
            com.google.android.gms.internal.ads.zzaky r13 = new com.google.android.gms.internal.ads.zzaky
            r13.<init>(r1, r6, r3, r2)
            r1.zzg = r13
        L_0x0436:
            java.lang.String r13 = "openIntentAsync"
            if (r0 == 0) goto L_0x0471
            if (r9 == 0) goto L_0x0464
            com.google.android.gms.internal.ads.zzcvk r4 = r1.zzf
            if (r4 == 0) goto L_0x0464
            android.content.Context r4 = r5.getContext()
            android.net.Uri r5 = r0.getData()
            java.lang.String r5 = r5.toString()
            boolean r4 = r1.zzh(r2, r4, r5, r12)
            if (r4 == 0) goto L_0x0464
            if (r7 == 0) goto L_0x0463
            java.lang.Object r0 = r3.get(r11)
            java.lang.String r0 = (java.lang.String) r0
            r6.put(r0, r8)
            r0 = r2
            com.google.android.gms.internal.ads.zzang r0 = (com.google.android.gms.internal.ads.zzang) r0
            r0.zze(r13, r6)
        L_0x0463:
            return
        L_0x0464:
            com.google.android.gms.internal.ads.zzbhl r2 = (com.google.android.gms.internal.ads.zzbhl) r2
            com.google.android.gms.ads.internal.overlay.zzc r3 = new com.google.android.gms.ads.internal.overlay.zzc
            com.google.android.gms.ads.internal.overlay.zzu r4 = r1.zzg
            r3.<init>(r0, r4)
            r2.zzaF(r3)
            return
        L_0x0471:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L_0x049a
            android.net.Uri r0 = android.net.Uri.parse(r4)
            android.content.Context r4 = r5.getContext()
            com.google.android.gms.internal.ads.zzfh r14 = r5.zzU()
            android.view.View r15 = r5.zzH()
            r16 = r10
            android.app.Activity r10 = r5.zzj()
            android.net.Uri r0 = zze(r4, r14, r0, r15, r10)
            android.net.Uri r0 = zzf(r0)
            java.lang.String r4 = r0.toString()
            goto L_0x049c
        L_0x049a:
            r16 = r10
        L_0x049c:
            if (r9 == 0) goto L_0x04be
            com.google.android.gms.internal.ads.zzcvk r0 = r1.zzf
            if (r0 == 0) goto L_0x04be
            android.content.Context r0 = r5.getContext()
            boolean r0 = r1.zzh(r2, r0, r4, r12)
            if (r0 == 0) goto L_0x04be
            if (r7 == 0) goto L_0x04bd
            java.lang.Object r0 = r3.get(r11)
            java.lang.String r0 = (java.lang.String) r0
            r6.put(r0, r8)
            r0 = r2
            com.google.android.gms.internal.ads.zzang r0 = (com.google.android.gms.internal.ads.zzang) r0
            r0.zze(r13, r6)
        L_0x04bd:
            return
        L_0x04be:
            r0 = r2
            com.google.android.gms.internal.ads.zzbhl r0 = (com.google.android.gms.internal.ads.zzbhl) r0
            com.google.android.gms.ads.internal.overlay.zzc r2 = new com.google.android.gms.ads.internal.overlay.zzc
            java.lang.String r5 = "i"
            java.lang.Object r5 = r3.get(r5)
            r18 = r5
            java.lang.String r18 = (java.lang.String) r18
            java.lang.String r5 = "m"
            java.lang.Object r5 = r3.get(r5)
            r20 = r5
            java.lang.String r20 = (java.lang.String) r20
            r5 = r16
            java.lang.Object r5 = r3.get(r5)
            r21 = r5
            java.lang.String r21 = (java.lang.String) r21
            java.lang.String r5 = "c"
            java.lang.Object r5 = r3.get(r5)
            r22 = r5
            java.lang.String r22 = (java.lang.String) r22
            java.lang.String r5 = "f"
            java.lang.Object r5 = r3.get(r5)
            r23 = r5
            java.lang.String r23 = (java.lang.String) r23
            java.lang.String r5 = "e"
            java.lang.Object r3 = r3.get(r5)
            r24 = r3
            java.lang.String r24 = (java.lang.String) r24
            com.google.android.gms.ads.internal.overlay.zzu r3 = r1.zzg
            r17 = r2
            r19 = r4
            r25 = r3
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25)
            r0.zzaF(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzala.zza(com.google.android.gms.internal.ads.zzyi, java.util.Map):void");
    }
}
