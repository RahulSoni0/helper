package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzavb extends zzaux {
    final /* synthetic */ UpdateImpressionUrlsCallback zza;

    zzavb(zzave zzave, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zza = updateImpressionUrlsCallback;
    }

    public final void zze(List<Uri> list) {
        this.zza.onSuccess(list);
    }

    public final void zzf(String str) {
        this.zza.onFailure(str);
    }
}
