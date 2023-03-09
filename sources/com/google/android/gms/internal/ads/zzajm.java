package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzajm extends zzaiq {
    /* access modifiers changed from: private */
    public final OnAdManagerAdViewLoadedListener zza;

    public zzajm(OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener) {
        this.zza = onAdManagerAdViewLoadedListener;
    }

    public final void zze(zzaau zzaau, IObjectWrapper iObjectWrapper) {
        if (zzaau != null && iObjectWrapper != null) {
            AdManagerAdView adManagerAdView = new AdManagerAdView((Context) ObjectWrapper.unwrap(iObjectWrapper));
            AppEventListener appEventListener = null;
            try {
                if (zzaau.zzw() instanceof zzyo) {
                    zzyo zzyo = (zzyo) zzaau.zzw();
                    adManagerAdView.setAdListener(zzyo != null ? zzyo.zzj() : null);
                }
            } catch (RemoteException e) {
                zzbbk.zzg("", e);
            }
            try {
                if (zzaau.zzv() instanceof zzrw) {
                    zzrw zzrw = (zzrw) zzaau.zzv();
                    if (zzrw != null) {
                        appEventListener = zzrw.zzc();
                    }
                    adManagerAdView.setAppEventListener(appEventListener);
                }
            } catch (RemoteException e2) {
                zzbbk.zzg("", e2);
            }
            zzbbd.zza.post(new zzajl(this, adManagerAdView, zzaau));
        }
    }
}
