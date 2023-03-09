package com.google.android.gms.ads.search;

import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.ads.zzacp;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzc {
    /* access modifiers changed from: private */
    public final zzacp zza = new zzacp();
    /* access modifiers changed from: private */
    public String zzb;

    public final zzc zza(NetworkExtras networkExtras) {
        this.zza.zzb(networkExtras);
        return this;
    }

    public final zzc zzb(Class<? extends MediationAdapter> cls, Bundle bundle) {
        this.zza.zzc(cls, bundle);
        return this;
    }

    public final zzc zzc(Class<? extends CustomEvent> cls, Bundle bundle) {
        this.zza.zzd(cls, bundle);
        return this;
    }

    public final zzc zzd(String str) {
        this.zzb = str;
        return this;
    }
}
