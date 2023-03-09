package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;
import kotlin.jvm.internal.LongCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzakq implements zzakp<Object> {
    private final zzcpz zza;

    public zzakq(zzcpz zzcpz) {
        Preconditions.checkNotNull(zzcpz, "The Inspector Manager must not be null");
        this.zza = zzcpz;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (map != null && map.containsKey("extras")) {
            boolean containsKey = map.containsKey("expires");
            long j = LongCompanionObject.MAX_VALUE;
            if (containsKey) {
                try {
                    j = Long.parseLong(map.get("expires"));
                } catch (NumberFormatException unused) {
                }
            }
            this.zza.zzf(map.get("extras"), j);
        }
    }
}
