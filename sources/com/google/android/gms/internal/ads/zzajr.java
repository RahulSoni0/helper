package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzajr implements zzakp<Object> {
    private final zzajs zza;

    public zzajr(zzajs zzajs) {
        this.zza = zzajs;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get(AppMeasurementSdk.ConditionalUserProperty.NAME);
        if (str == null) {
            zze.zzi("App event with no name parameter.");
        } else {
            this.zza.zzbB(str, map.get("info"));
        }
    }
}
