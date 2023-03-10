package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzams implements InitializationStatus {
    private final Map<String, AdapterStatus> zza;

    public zzams(Map<String, AdapterStatus> map) {
        this.zza = map;
    }

    public final Map<String, AdapterStatus> getAdapterStatusMap() {
        return this.zza;
    }
}
