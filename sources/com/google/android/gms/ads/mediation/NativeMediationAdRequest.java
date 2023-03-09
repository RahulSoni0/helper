package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAdOptions;
import java.util.Map;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public interface NativeMediationAdRequest extends MediationAdRequest {
    float getAdVolume();

    @Deprecated
    NativeAdOptions getNativeAdOptions();

    com.google.android.gms.ads.nativead.NativeAdOptions getNativeAdRequestOptions();

    boolean isAdMuted();

    boolean isUnifiedNativeAdRequested();

    boolean zza();

    Map<String, Boolean> zzb();
}
