package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzaaa;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzaou;
import com.google.android.gms.internal.ads.zzapb;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbbz;
import com.google.android.gms.internal.ads.zzefo;
import com.google.android.gms.internal.ads.zzefw;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zze {
    private Context zza;
    private long zzb = 0;

    public final void zza(Context context, zzbbq zzbbq, String str, Runnable runnable) {
        zzc(context, zzbbq, true, (zzbar) null, str, (String) null, runnable);
    }

    public final void zzb(Context context, zzbbq zzbbq, String str, zzbar zzbar) {
        zzc(context, zzbbq, false, zzbar, zzbar != null ? zzbar.zze() : null, str, (Runnable) null);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Context context, zzbbq zzbbq, boolean z, zzbar zzbar, String str, String str2, Runnable runnable) {
        if (zzs.zzj().elapsedRealtime() - this.zzb < 5000) {
            com.google.android.gms.ads.internal.util.zze.zzi("Not retrying to fetch app settings");
            return;
        }
        this.zzb = zzs.zzj().elapsedRealtime();
        if (zzbar != null) {
            long zzb2 = zzbar.zzb();
            if (zzs.zzj().currentTimeMillis() - zzb2 <= ((Long) zzaaa.zzc().zzb(zzaeq.zzcm)).longValue() && zzbar.zzc()) {
                return;
            }
        }
        if (context == null) {
            com.google.android.gms.ads.internal.util.zze.zzi("Context not provided to fetch application settings");
        } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            this.zza = applicationContext;
            zzaou<I, O> zza2 = zzs.zzp().zzb(this.zza, zzbbq).zza("google.afma.config.fetchAppSettings", zzapb.zza, zzapb.zza);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("app_id", str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z);
                jSONObject.put("pn", context.getPackageName());
                zzefw<O> zzb3 = zza2.zzb(jSONObject);
                zzefw<O> zzh = zzefo.zzh(zzb3, zzd.zza, zzbbw.zzf);
                if (runnable != null) {
                    zzb3.zze(runnable, zzbbw.zzf);
                }
                zzbbz.zza(zzh, "ConfigLoader.maybeFetchNewAppSettings");
            } catch (Exception e) {
                com.google.android.gms.ads.internal.util.zze.zzg("Error requesting application settings", e);
            }
        } else {
            com.google.android.gms.ads.internal.util.zze.zzi("App settings could not be fetched. Required parameters missing");
        }
    }
}
