package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzanf<AdT> extends AdManagerInterstitialAd {
    private final Context zza;
    private final zzyw zzb = zzyw.zza;
    private final zzaau zzc;
    private final String zzd;
    private final zzapy zze;
    private AppEventListener zzf;
    private FullScreenContentCallback zzg;
    private OnPaidEventListener zzh;

    public zzanf(Context context, String str) {
        zzapy zzapy = new zzapy();
        this.zze = zzapy;
        this.zza = context;
        this.zzd = str;
        this.zzc = zzzy.zzb().zzb(context, new zzyx(), str, zzapy);
    }

    public final String getAdUnitId() {
        return this.zzd;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzf;
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzg;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzh;
    }

    public final ResponseInfo getResponseInfo() {
        zzacg zzacg = null;
        try {
            zzaau zzaau = this.zzc;
            if (zzaau != null) {
                zzacg = zzaau.zzt();
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zzc(zzacg);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzf = appEventListener;
            zzaau zzaau = this.zzc;
            if (zzaau != null) {
                zzaau.zzi(appEventListener != null ? new zzrw(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        try {
            this.zzg = fullScreenContentCallback;
            zzaau zzaau = this.zzc;
            if (zzaau != null) {
                zzaau.zzR(new zzaab(fullScreenContentCallback));
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setImmersiveMode(boolean z) {
        try {
            zzaau zzaau = this.zzc;
            if (zzaau != null) {
                zzaau.zzJ(z);
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzh = onPaidEventListener;
            zzaau zzaau = this.zzc;
            if (zzaau != null) {
                zzaau.zzO(new zzadr(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity) {
        if (activity == null) {
            zzbbk.zzi("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            zzaau zzaau = this.zzc;
            if (zzaau != null) {
                zzaau.zzQ(ObjectWrapper.wrap(activity));
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzacq zzacq, AdLoadCallback<AdT> adLoadCallback) {
        try {
            if (this.zzc != null) {
                this.zze.zze(zzacq.zzn());
                this.zzc.zzP(this.zzb.zza(this.zza, zzacq), new zzyp(adLoadCallback, this));
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
            adLoadCallback.onAdFailedToLoad(new LoadAdError(0, "Internal Error.", MobileAds.ERROR_DOMAIN, (AdError) null, (ResponseInfo) null));
        }
    }
}
