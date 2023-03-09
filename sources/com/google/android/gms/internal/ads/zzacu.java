package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final /* synthetic */ class zzacu implements InitializationStatus {
    private final zzacy zza;

    zzacu(zzacy zzacy) {
        this.zza = zzacy;
    }

    public final Map getAdapterStatusMap() {
        zzacy zzacy = this.zza;
        HashMap hashMap = new HashMap();
        hashMap.put("com.google.android.gms.ads.MobileAds", new zzacv(zzacy));
        return hashMap;
    }
}
