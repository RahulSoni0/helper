package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzafw {
    public static final zzafs<Boolean> zza = zzaft.zzf("gads:consent:gmscore:dsid:enabled", true);
    public static final zzafs<Boolean> zzb = zzaft.zzf("gads:consent:gmscore:lat:enabled", true);
    public static final zzafs<String> zzc = new zzaft("gads:consent:gmscore:backend_url", "https://adservice.google.com/getconfig/pubvendors", 4);
    public static final zzafs<Long> zzd = new zzaft("gads:consent:gmscore:time_out", Long.valueOf(WorkRequest.MIN_BACKOFF_MILLIS), 2);
    public static final zzafs<Boolean> zze = zzaft.zzf("gads:consent:gmscore:enabled", true);
}
