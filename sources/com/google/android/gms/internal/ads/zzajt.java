package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzajt implements zzakp<zzbgf> {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbgf zzbgf = (zzbgf) obj;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get("label");
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                zze.zzi("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str4)) {
                zze.zzi("No timestamp given for CSI tick.");
            } else {
                try {
                    long elapsedRealtime = zzs.zzj().elapsedRealtime() + (Long.parseLong(str4) - zzs.zzj().currentTimeMillis());
                    if (true == TextUtils.isEmpty(str3)) {
                        str3 = "native:view_load";
                    }
                    zzbgf.zzq().zzb(str2, str3, elapsedRealtime);
                } catch (NumberFormatException e) {
                    zze.zzj("Malformed timestamp for CSI tick.", e);
                }
            }
        } else if ("experiment".equals(str)) {
            String str5 = (String) map.get(AppMeasurementSdk.ConditionalUserProperty.VALUE);
            if (TextUtils.isEmpty(str5)) {
                zze.zzi("No value given for CSI experiment.");
            } else {
                zzbgf.zzq().zzc().zzd("e", str5);
            }
        } else if ("extra".equals(str)) {
            String str6 = (String) map.get(AppMeasurementSdk.ConditionalUserProperty.NAME);
            String str7 = (String) map.get(AppMeasurementSdk.ConditionalUserProperty.VALUE);
            if (TextUtils.isEmpty(str7)) {
                zze.zzi("No value given for CSI extra.");
            } else if (TextUtils.isEmpty(str6)) {
                zze.zzi("No name given for CSI extra.");
            } else {
                zzbgf.zzq().zzc().zzd(str6, str7);
            }
        }
    }
}
