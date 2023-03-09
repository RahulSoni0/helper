package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import kotlin.text.Typography;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdxj {
    private static final zzdxj zza = new zzdxj();

    private zzdxj() {
    }

    public static zzdxj zza() {
        return zza;
    }

    public final void zzb(WebView webView, JSONObject jSONObject) {
        zzg(webView, "init", jSONObject);
    }

    public final void zzc(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        zzg(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    public final void zzd(WebView webView) {
        zzg(webView, "finishSession", new Object[0]);
    }

    public final void zze(WebView webView, String str) {
        zzg(webView, "setNativeViewHierarchy", str);
    }

    public final void zzf(WebView webView, float f) {
        zzg(webView, "setDeviceVolume", Float.valueOf(f));
    }

    /* access modifiers changed from: package-private */
    public final void zzg(WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            if (r6 > 0) {
                for (Object obj : objArr) {
                    if (obj == null) {
                        sb.append("\"\"");
                    } else if (obj instanceof String) {
                        String obj2 = obj.toString();
                        if (obj2.startsWith("{")) {
                            sb.append(obj2);
                        } else {
                            sb.append(Typography.quote);
                            sb.append(obj2);
                            sb.append(Typography.quote);
                        }
                    } else {
                        sb.append(obj);
                    }
                    sb.append(",");
                }
                sb.setLength(sb.length() - 1);
            }
            sb.append(")}");
            String sb2 = sb.toString();
            Handler handler = webView.getHandler();
            if (handler == null || Looper.myLooper() == handler.getLooper()) {
                webView.loadUrl(sb2);
            } else {
                handler.post(new zzdxi(this, webView, sb2));
            }
        } else {
            String concat = str.length() != 0 ? "The WebView is null for ".concat(str) : new String("The WebView is null for ");
            if (zzdwl.zza.booleanValue() && !TextUtils.isEmpty(concat)) {
                Log.i("OMIDLIB", concat);
            }
        }
    }
}
