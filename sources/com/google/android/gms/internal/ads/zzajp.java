package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzajp implements zzakp<Object> {
    private final zzajq zza;

    public zzajp(zzajq zzajq) {
        this.zza = zzajq;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (this.zza != null) {
            String str = map.get(AppMeasurementSdk.ConditionalUserProperty.NAME);
            if (str == null) {
                zze.zzh("Ad metadata with no name parameter.");
                str = "";
            }
            Bundle bundle = null;
            if (map.containsKey("info")) {
                try {
                    bundle = zzbk.zzj(new JSONObject(map.get("info")));
                } catch (JSONException e) {
                    zze.zzg("Failed to convert ad metadata to JSON.", e);
                }
            }
            if (bundle == null) {
                zze.zzf("Failed to convert ad metadata to Bundle.");
            } else {
                this.zza.zza(str, bundle);
            }
        }
    }
}
