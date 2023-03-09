package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.ads.internal.zzs;
import com.itextpdf.text.html.HtmlTags;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbmr implements zzaox<zzbmu> {
    private final Context zza;
    private final zzre zzb;
    private final PowerManager zzc;

    public zzbmr(Context context, zzre zzre) {
        this.zza = context;
        this.zzb = zzre;
        this.zzc = (PowerManager) context.getSystemService("power");
    }

    /* renamed from: zza */
    public final JSONObject zzb(zzbmu zzbmu) throws JSONException {
        JSONObject jSONObject;
        boolean z;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzrh zzrh = zzbmu.zzf;
        if (zzrh == null) {
            jSONObject = new JSONObject();
        } else if (this.zzb.zzc() != null) {
            boolean z2 = zzrh.zza;
            JSONObject jSONObject3 = new JSONObject();
            JSONObject put = jSONObject3.put("afmaVersion", this.zzb.zzb()).put("activeViewJSON", this.zzb.zzc()).put("timestamp", zzbmu.zzd).put("adFormat", this.zzb.zza()).put("hashCode", this.zzb.zzd()).put("isMraid", false);
            boolean z3 = zzbmu.zzc;
            JSONObject put2 = put.put("isStopped", false).put("isPaused", zzbmu.zzb).put("isNative", this.zzb.zze());
            if (Build.VERSION.SDK_INT >= 20) {
                z = this.zzc.isInteractive();
            } else {
                z = this.zzc.isScreenOn();
            }
            put2.put("isScreenOn", z).put("appMuted", zzs.zzh().zzd()).put("appVolume", (double) zzs.zzh().zzb()).put("deviceVolume", (double) zzad.zze(this.zza.getApplicationContext()));
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.zza.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzrh.zzb).put("isAttachedToWindow", z2).put("viewBox", new JSONObject().put(HtmlTags.ALIGN_TOP, zzrh.zzc.top).put(HtmlTags.ALIGN_BOTTOM, zzrh.zzc.bottom).put(HtmlTags.ALIGN_LEFT, zzrh.zzc.left).put(HtmlTags.ALIGN_RIGHT, zzrh.zzc.right)).put("adBox", new JSONObject().put(HtmlTags.ALIGN_TOP, zzrh.zzd.top).put(HtmlTags.ALIGN_BOTTOM, zzrh.zzd.bottom).put(HtmlTags.ALIGN_LEFT, zzrh.zzd.left).put(HtmlTags.ALIGN_RIGHT, zzrh.zzd.right)).put("globalVisibleBox", new JSONObject().put(HtmlTags.ALIGN_TOP, zzrh.zze.top).put(HtmlTags.ALIGN_BOTTOM, zzrh.zze.bottom).put(HtmlTags.ALIGN_LEFT, zzrh.zze.left).put(HtmlTags.ALIGN_RIGHT, zzrh.zze.right)).put("globalVisibleBoxVisible", zzrh.zzf).put("localVisibleBox", new JSONObject().put(HtmlTags.ALIGN_TOP, zzrh.zzg.top).put(HtmlTags.ALIGN_BOTTOM, zzrh.zzg.bottom).put(HtmlTags.ALIGN_LEFT, zzrh.zzg.left).put(HtmlTags.ALIGN_RIGHT, zzrh.zzg.right)).put("localVisibleBoxVisible", zzrh.zzh).put("hitBox", new JSONObject().put(HtmlTags.ALIGN_TOP, zzrh.zzi.top).put(HtmlTags.ALIGN_BOTTOM, zzrh.zzi.bottom).put(HtmlTags.ALIGN_LEFT, zzrh.zzi.left).put(HtmlTags.ALIGN_RIGHT, zzrh.zzi.right)).put("screenDensity", (double) this.zza.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzbmu.zza);
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzaT)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzrh.zzk;
                if (list != null) {
                    for (Rect next : list) {
                        jSONArray2.put(new JSONObject().put(HtmlTags.ALIGN_TOP, next.top).put(HtmlTags.ALIGN_BOTTOM, next.bottom).put(HtmlTags.ALIGN_LEFT, next.left).put(HtmlTags.ALIGN_RIGHT, next.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzbmu.zze)) {
                jSONObject3.put("doneReasonCode", HtmlTags.f1209U);
            }
            jSONObject = jSONObject3;
        } else {
            throw new JSONException("Active view Info cannot be null.");
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
