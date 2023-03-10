package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbhd implements zzbhf {
    private final zzbgf zza;

    zzbhd(zzbgf zzbgf) {
        this.zza = zzbgf;
    }

    public final void zza(Uri uri) {
        zzbgm zzaQ = ((zzbgy) this.zza).zzaQ();
        if (zzaQ == null) {
            zze.zzf("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        } else {
            zzaQ.zzD(uri);
        }
    }
}
