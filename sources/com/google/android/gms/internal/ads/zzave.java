package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzave {
    @Nonnull
    private final View zza;
    private final Map<String, WeakReference<View>> zzb;
    private final zzbag zzc;

    public zzave(zzavd zzavd) {
        View zzc2 = zzavd.zza;
        this.zza = zzc2;
        Map<String, WeakReference<View>> zzd = zzavd.zzb;
        this.zzb = zzd;
        zzbag zza2 = zzava.zza(zzavd.zza.getContext());
        this.zzc = zza2;
        if (zza2 != null && !zzd.isEmpty()) {
            try {
                zza2.zzi(new zzavf(ObjectWrapper.wrap(zzc2).asBinder(), ObjectWrapper.wrap(zzd).asBinder()));
            } catch (RemoteException unused) {
                zzbbk.zzf("Failed to call remote method.");
            }
        }
    }

    public final void zza(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        if (this.zzc == null) {
            updateImpressionUrlsCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzc.zzg(list, ObjectWrapper.wrap(this.zza), new zzavb(this, updateImpressionUrlsCallback));
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("Internal error: ");
            sb.append(valueOf);
            updateImpressionUrlsCallback.onFailure(sb.toString());
        }
    }

    public final void zzb(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        if (this.zzc == null) {
            updateClickUrlCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzc.zzh(new ArrayList(Arrays.asList(new Uri[]{uri})), ObjectWrapper.wrap(this.zza), new zzavc(this, updateClickUrlCallback));
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("Internal error: ");
            sb.append(valueOf);
            updateClickUrlCallback.onFailure(sb.toString());
        }
    }

    public final void zzc(MotionEvent motionEvent) {
        zzbag zzbag = this.zzc;
        if (zzbag != null) {
            try {
                zzbag.zzf(ObjectWrapper.wrap(motionEvent));
            } catch (RemoteException unused) {
                zzbbk.zzf("Failed to call remote method.");
            }
        } else {
            zzbbk.zzd("Failed to get internal reporting info generator.");
        }
    }
}
