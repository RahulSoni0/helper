package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzalf implements zzakp<Object> {
    private final zzale zza;

    public zzalf(zzale zzale) {
        this.zza = zzale;
    }

    public static void zzb(zzbgf zzbgf, zzale zzale) {
        zzbgf.zzab("/reward", new zzalf(zzale));
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("action");
        if ("grant".equals(str)) {
            zzaxe zzaxe = null;
            try {
                int parseInt = Integer.parseInt(map.get("amount"));
                String str2 = map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzaxe = new zzaxe(str2, parseInt);
                }
            } catch (NumberFormatException e) {
                zze.zzj("Unable to parse reward amount.", e);
            }
            this.zza.zzb(zzaxe);
        } else if ("video_start".equals(str)) {
            this.zza.zza();
        } else if ("video_complete".equals(str)) {
            this.zza.zzc();
        }
    }
}
