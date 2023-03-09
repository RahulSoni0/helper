package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzavc extends zzaux {
    final /* synthetic */ UpdateClickUrlCallback zza;

    zzavc(zzave zzave, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zza = updateClickUrlCallback;
    }

    public final void zze(List<Uri> list) {
        this.zza.onSuccess(list.get(0));
    }

    public final void zzf(String str) {
        this.zza.onFailure(str);
    }
}
