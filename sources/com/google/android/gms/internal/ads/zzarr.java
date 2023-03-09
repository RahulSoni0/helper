package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzarr<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    /* access modifiers changed from: private */
    public final zzaqh zza;

    public zzarr(zzaqh zzaqh) {
        this.zza = zzaqh;
    }

    public final void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbbk.zzd("Adapter called onClick.");
        zzzy.zza();
        if (!zzbbd.zzp()) {
            zzbbk.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbbd.zza.post(new zzari(this));
            return;
        }
        try {
            this.zza.zze();
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbbk.zzd("Adapter called onDismissScreen.");
        zzzy.zza();
        if (!zzbbd.zzp()) {
            zzbbk.zzi("#008 Must be called on the main UI thread.");
            zzbbd.zza.post(new zzarj(this));
            return;
        }
        try {
            this.zza.zzf();
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error. ");
        sb.append(valueOf);
        zzbbk.zzd(sb.toString());
        zzzy.zza();
        if (!zzbbd.zzp()) {
            zzbbk.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbbd.zza.post(new zzark(this, errorCode));
            return;
        }
        try {
            this.zza.zzg(zzars.zza(errorCode));
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbbk.zzd("Adapter called onLeaveApplication.");
        zzzy.zza();
        if (!zzbbd.zzp()) {
            zzbbk.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbbd.zza.post(new zzarl(this));
            return;
        }
        try {
            this.zza.zzh();
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbbk.zzd("Adapter called onPresentScreen.");
        zzzy.zza();
        if (!zzbbd.zzp()) {
            zzbbk.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbbd.zza.post(new zzarm(this));
            return;
        }
        try {
            this.zza.zzi();
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbbk.zzd("Adapter called onReceivedAd.");
        zzzy.zza();
        if (!zzbbd.zzp()) {
            zzbbk.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbbd.zza.post(new zzarn(this));
            return;
        }
        try {
            this.zza.zzj();
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbbk.zzd("Adapter called onDismissScreen.");
        zzzy.zza();
        if (!zzbbd.zzp()) {
            zzbbk.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbbd.zza.post(new zzaro(this));
            return;
        }
        try {
            this.zza.zzf();
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error ");
        sb.append(valueOf);
        sb.append(".");
        zzbbk.zzd(sb.toString());
        zzzy.zza();
        if (!zzbbd.zzp()) {
            zzbbk.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbbd.zza.post(new zzarp(this, errorCode));
            return;
        }
        try {
            this.zza.zzg(zzars.zza(errorCode));
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbbk.zzd("Adapter called onLeaveApplication.");
        zzzy.zza();
        if (!zzbbd.zzp()) {
            zzbbk.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbbd.zza.post(new zzarq(this));
            return;
        }
        try {
            this.zza.zzh();
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbbk.zzd("Adapter called onPresentScreen.");
        zzzy.zza();
        if (!zzbbd.zzp()) {
            zzbbk.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbbd.zza.post(new zzarg(this));
            return;
        }
        try {
            this.zza.zzi();
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbbk.zzd("Adapter called onReceivedAd.");
        zzzy.zza();
        if (!zzbbd.zzp()) {
            zzbbk.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzbbd.zza.post(new zzarh(this));
            return;
        }
        try {
            this.zza.zzj();
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }
}
