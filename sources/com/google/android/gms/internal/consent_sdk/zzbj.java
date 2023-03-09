package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.util.Locale;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
final class zzbj implements zzi {
    private final Application zza;
    private final zzbh zzb;
    private final Handler zzc;
    private final Executor zzd;
    private final zze zze;
    private final zzaj zzf;
    private final zzat zzg;

    zzbj(Application application, zzbh zzbh, Handler handler, Executor executor, zze zze2, zzaj zzaj, zzat zzat) {
        this.zza = application;
        this.zzb = zzbh;
        this.zzc = handler;
        this.zzd = executor;
        this.zze = zze2;
        this.zzf = zzaj;
        this.zzg = zzat;
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, String str, String str2) {
        this.zzg.zza(new zzk(2, String.format(Locale.US, "WebResourceError(%d, %s): %s", new Object[]{Integer.valueOf(i), str2, str})));
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str) {
        String valueOf = String.valueOf(str);
        Log.d("UserMessagingPlatform", valueOf.length() != 0 ? "Receive consent action: ".concat(valueOf) : new String("Receive consent action: "));
        Uri parse = Uri.parse(str);
        this.zze.zza(parse.getQueryParameter("action"), parse.getQueryParameter("args"), this, this.zzf);
    }

    public final Executor zza() {
        Handler handler = this.zzc;
        handler.getClass();
        return zzbm.zza(handler);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(java.lang.String r7, org.json.JSONObject r8) {
        /*
            r6 = this;
            r7.hashCode()
            int r0 = r7.hashCode()
            r1 = -1
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            switch(r0) {
                case -1370505102: goto L_0x0032;
                case -278739366: goto L_0x0027;
                case 150940456: goto L_0x001c;
                case 1671672458: goto L_0x0011;
                default: goto L_0x000f;
            }
        L_0x000f:
            r7 = -1
            goto L_0x003c
        L_0x0011:
            java.lang.String r0 = "dismiss"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x001a
            goto L_0x000f
        L_0x001a:
            r7 = 3
            goto L_0x003c
        L_0x001c:
            java.lang.String r0 = "browser"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x0025
            goto L_0x000f
        L_0x0025:
            r7 = 2
            goto L_0x003c
        L_0x0027:
            java.lang.String r0 = "configure_app_assets"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x0030
            goto L_0x000f
        L_0x0030:
            r7 = 1
            goto L_0x003c
        L_0x0032:
            java.lang.String r0 = "load_complete"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L_0x003b
            goto L_0x000f
        L_0x003b:
            r7 = 0
        L_0x003c:
            switch(r7) {
                case 0: goto L_0x010a;
                case 1: goto L_0x00ff;
                case 2: goto L_0x00a0;
                case 3: goto L_0x0040;
                default: goto L_0x003f;
            }
        L_0x003f:
            return r4
        L_0x0040:
            java.lang.String r7 = "status"
            java.lang.String r7 = r8.optString(r7)
            r7.hashCode()
            int r8 = r7.hashCode()
            switch(r8) {
                case -954325659: goto L_0x007d;
                case -258041904: goto L_0x0072;
                case 429411856: goto L_0x0067;
                case 467888915: goto L_0x005c;
                case 1666911234: goto L_0x0051;
                default: goto L_0x0050;
            }
        L_0x0050:
            goto L_0x0087
        L_0x0051:
            java.lang.String r8 = "non_personalized"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x005a
            goto L_0x0087
        L_0x005a:
            r1 = 4
            goto L_0x0087
        L_0x005c:
            java.lang.String r8 = "CONSENT_SIGNAL_PERSONALIZED_ADS"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0065
            goto L_0x0087
        L_0x0065:
            r1 = 3
            goto L_0x0087
        L_0x0067:
            java.lang.String r8 = "CONSENT_SIGNAL_SUFFICIENT"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0070
            goto L_0x0087
        L_0x0070:
            r1 = 2
            goto L_0x0087
        L_0x0072:
            java.lang.String r8 = "personalized"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x007b
            goto L_0x0087
        L_0x007b:
            r1 = 1
            goto L_0x0087
        L_0x007d:
            java.lang.String r8 = "CONSENT_SIGNAL_NON_PERSONALIZED_ADS"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0086
            goto L_0x0087
        L_0x0086:
            r1 = 0
        L_0x0087:
            switch(r1) {
                case 0: goto L_0x0099;
                case 1: goto L_0x009a;
                case 2: goto L_0x0097;
                case 3: goto L_0x009a;
                case 4: goto L_0x0099;
                default: goto L_0x008a;
            }
        L_0x008a:
            com.google.android.gms.internal.consent_sdk.zzat r7 = r6.zzg
            com.google.android.gms.internal.consent_sdk.zzk r8 = new com.google.android.gms.internal.consent_sdk.zzk
            java.lang.String r0 = "We are getting something wrong with the webview."
            r8.<init>(r5, r0)
            r7.zzb(r8)
            goto L_0x009f
        L_0x0097:
            r3 = 0
            goto L_0x009a
        L_0x0099:
            r3 = 1
        L_0x009a:
            com.google.android.gms.internal.consent_sdk.zzat r7 = r6.zzg
            r7.zza((int) r2, (int) r3)
        L_0x009f:
            return r5
        L_0x00a0:
            java.lang.String r7 = "url"
            java.lang.String r7 = r8.optString(r7)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            java.lang.String r0 = "UserMessagingPlatform"
            if (r8 == 0) goto L_0x00b3
            java.lang.String r8 = "Action[browser]: empty url."
            android.util.Log.d(r0, r8)
        L_0x00b3:
            android.net.Uri r8 = android.net.Uri.parse(r7)
            java.lang.String r1 = r8.getScheme()
            if (r1 != 0) goto L_0x00d7
            java.lang.String r1 = "Action[browser]: empty scheme: "
            java.lang.String r2 = java.lang.String.valueOf(r7)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x00ce
            java.lang.String r1 = r1.concat(r2)
            goto L_0x00d4
        L_0x00ce:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r1)
            r1 = r2
        L_0x00d4:
            android.util.Log.d(r0, r1)
        L_0x00d7:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x00e4 }
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1, r8)     // Catch:{ ActivityNotFoundException -> 0x00e4 }
            com.google.android.gms.internal.consent_sdk.zzbh r8 = r6.zzb     // Catch:{ ActivityNotFoundException -> 0x00e4 }
            r8.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x00e4 }
            goto L_0x00fe
        L_0x00e4:
            r8 = move-exception
            java.lang.String r0 = "Action[browser]: can not open url: "
            java.lang.String r7 = java.lang.String.valueOf(r7)
            int r1 = r7.length()
            if (r1 == 0) goto L_0x00f6
            java.lang.String r7 = r0.concat(r7)
            goto L_0x00fb
        L_0x00f6:
            java.lang.String r7 = new java.lang.String
            r7.<init>(r0)
        L_0x00fb:
            com.google.android.gms.internal.consent_sdk.zzca.zza(r7, r8)
        L_0x00fe:
            return r5
        L_0x00ff:
            java.util.concurrent.Executor r7 = r6.zzd
            com.google.android.gms.internal.consent_sdk.zzbl r8 = new com.google.android.gms.internal.consent_sdk.zzbl
            r8.<init>(r6)
            r7.execute(r8)
            return r5
        L_0x010a:
            com.google.android.gms.internal.consent_sdk.zzat r7 = r6.zzg
            r7.zzb()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzbj.zza(java.lang.String, org.json.JSONObject):boolean");
    }

    private static JSONObject zza(Context context) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString());
            Drawable applicationIcon = context.getPackageManager().getApplicationIcon(context.getApplicationInfo());
            if (applicationIcon == null) {
                str = null;
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(applicationIcon.getIntrinsicWidth(), applicationIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                applicationIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                applicationIcon.draw(canvas);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                String valueOf = String.valueOf(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                str = valueOf.length() != 0 ? "data:image/png;base64,".concat(valueOf) : new String("data:image/png;base64,");
            }
            jSONObject.put("app_icon", str);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb() {
        this.zzg.zza().zza("UMP_configureFormWithAppAssets", zza((Context) this.zza));
    }
}
