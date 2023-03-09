package com.google.android.gms.ads.p008h5;

import android.content.Context;
import com.google.android.gms.internal.ads.zzalr;

/* renamed from: com.google.android.gms.ads.h5.H5AdsRequestHandler */
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class H5AdsRequestHandler {
    private final zzalr zza;

    public H5AdsRequestHandler(Context context, OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = new zzalr(context, onH5AdsEventListener);
    }

    public void clearAdObjects() {
        this.zza.zzb();
    }

    public boolean handleH5AdsRequest(String str) {
        return this.zza.zza(str);
    }

    public boolean shouldInterceptRequest(String str) {
        return zzalr.zzc(str);
    }
}
