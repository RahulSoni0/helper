package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzavd {
    /* access modifiers changed from: private */
    @Nonnull
    public View zza;
    /* access modifiers changed from: private */
    public final Map<String, WeakReference<View>> zzb = new HashMap();

    public final zzavd zza(View view) {
        this.zza = view;
        return this;
    }

    public final zzavd zzb(Map<String, View> map) {
        this.zzb.clear();
        for (Map.Entry next : map.entrySet()) {
            View view = (View) next.getValue();
            if (view != null) {
                this.zzb.put((String) next.getKey(), new WeakReference(view));
            }
        }
        return this;
    }
}
