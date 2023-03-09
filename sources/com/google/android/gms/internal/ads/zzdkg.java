package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdkg implements Callable {
    private final zzdkh zza;

    zzdkg(zzdkh zzdkh) {
        this.zza = zzdkh;
    }

    public final Object call() {
        return new zzdki(new JSONObject());
    }
}
