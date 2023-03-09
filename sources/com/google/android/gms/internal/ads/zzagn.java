package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzagn {
    public static final zzafs<Long> zza = zzafs.zzb("gads:ad_loader:timeout_ms", 60000);
    public static final zzafs<Long> zzb = zzafs.zzb("gads:rendering:timeout_ms", 60000);
    public static final zzafs<Long> zzc = zzafs.zzb("gads:resolve_future:default_timeout_ms", WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
}
