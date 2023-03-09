package com.google.android.gms.ads.mediation.admob;

import android.os.Bundle;
import com.google.ads.mediation.NetworkExtras;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class AdMobExtras implements NetworkExtras {
    private final Bundle zza;

    public AdMobExtras(Bundle bundle) {
        this.zza = bundle != null ? new Bundle(bundle) : null;
    }

    public Bundle getExtras() {
        return this.zza;
    }
}
