package com.google.android.gms.ads.nativead;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzahs;
import com.google.android.gms.internal.ads.zzbbk;
import com.google.android.gms.internal.ads.zzzy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class NativeAdViewHolder {
    public static WeakHashMap<View, NativeAdViewHolder> zza = new WeakHashMap<>();
    @NotOnlyInitialized
    private zzahs zzb;
    private WeakReference<View> zzc;

    public NativeAdViewHolder(View view, Map<String, View> map, Map<String, View> map2) {
        Preconditions.checkNotNull(view, "ContainerView must not be null");
        if (view instanceof NativeAdView) {
            zzbbk.zzf("The provided containerView is of type of NativeAdView, which cannot be usedwith NativeAdViewHolder.");
        } else if (zza.get(view) != null) {
            zzbbk.zzf("The provided containerView is already in use with another NativeAdViewHolder.");
        } else {
            zza.put(view, this);
            this.zzc = new WeakReference<>(view);
            this.zzb = zzzy.zzb().zze(view, zza(map), zza(map2));
        }
    }

    private static final HashMap<String, View> zza(Map<String, View> map) {
        if (map == null) {
            return new HashMap<>();
        }
        return new HashMap<>(map);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzb.zzd(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbbk.zzg("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [com.google.android.gms.dynamic.IObjectWrapper, java.lang.Object] */
    public void setNativeAd(NativeAd nativeAd) {
        ? zza2 = nativeAd.zza();
        WeakReference<View> weakReference = this.zzc;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view == null) {
            zzbbk.zzi("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!zza.containsKey(view)) {
            zza.put(view, this);
        }
        zzahs zzahs = this.zzb;
        if (zzahs != null) {
            try {
                zzahs.zzb(zza2);
            } catch (RemoteException e) {
                zzbbk.zzg("Unable to call setNativeAd on delegate", e);
            }
        }
    }

    public void unregisterNativeAd() {
        zzahs zzahs = this.zzb;
        if (zzahs != null) {
            try {
                zzahs.zzc();
            } catch (RemoteException e) {
                zzbbk.zzg("Unable to call unregisterNativeAd on delegate", e);
            }
        }
        WeakReference<View> weakReference = this.zzc;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view != null) {
            zza.remove(view);
        }
    }
}
