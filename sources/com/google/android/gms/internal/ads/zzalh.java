package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.p008h5.OnH5AdsEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzalh extends zzalj {
    private final OnH5AdsEventListener zza;

    public zzalh(OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = onH5AdsEventListener;
    }

    public final void zzb(String str) {
        this.zza.onH5AdsEvent(str);
    }
}
