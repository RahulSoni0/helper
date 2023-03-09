package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzacw extends zzabw {
    private zzacw() {
    }

    public final void zze(@Nullable zzym zzym) {
        AdInspectorError adInspectorError;
        OnAdInspectorClosedListener zzu = zzacy.zza().zzg;
        if (zzu != null) {
            if (zzym == null) {
                adInspectorError = null;
            } else {
                adInspectorError = new AdInspectorError(zzym.zza, zzym.zzb, zzym.zzc);
            }
            zzu.onAdInspectorClosed(adInspectorError);
        }
    }

    /* synthetic */ zzacw(zzacv zzacv) {
    }
}
