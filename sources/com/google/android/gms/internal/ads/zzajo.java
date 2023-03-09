package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzajo extends zzaiz {
    private final UnifiedNativeAd.UnconfirmedClickListener zza;

    public zzajo(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zza = unconfirmedClickListener;
    }

    public final void zze(String str) {
        this.zza.onUnconfirmedClickReceived(str);
    }

    public final void zzf() {
        this.zza.onUnconfirmedClickCancelled();
    }
}
