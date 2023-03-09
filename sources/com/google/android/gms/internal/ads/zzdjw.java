package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdjw implements Callable {
    private final zzdjx zza;

    zzdjw(zzdjx zzdjx) {
        this.zza = zzdjx;
    }

    public final Object call() {
        return new zzdjy(new JSONObject());
    }
}
