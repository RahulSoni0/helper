package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaib implements NativeCustomTemplateAd {
    private final zzaia zza;
    private final MediaView zzb;
    private final VideoController zzc = new VideoController();
    private NativeCustomTemplateAd.DisplayOpenMeasurement zzd;

    public zzaib(zzaia zzaia) {
        Context context;
        this.zza = zzaia;
        MediaView mediaView = null;
        try {
            context = (Context) ObjectWrapper.unwrap(zzaia.zzm());
        } catch (RemoteException | NullPointerException e) {
            zzbbk.zzg("", e);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (true == this.zza.zzn(ObjectWrapper.wrap(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e2) {
                zzbbk.zzg("", e2);
            }
        }
        this.zzb = mediaView;
    }

    public final void destroy() {
        try {
            this.zza.zzl();
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
        }
    }

    public final List<String> getAvailableAssetNames() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
            return null;
        }
    }

    public final String getCustomTemplateId() {
        try {
            return this.zza.zzh();
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
            return null;
        }
    }

    public final NativeCustomTemplateAd.DisplayOpenMeasurement getDisplayOpenMeasurement() {
        try {
            if (this.zzd == null && this.zza.zzo()) {
                this.zzd = new zzahe(this.zza);
            }
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
        }
        return this.zzd;
    }

    public final NativeAd.Image getImage(String str) {
        try {
            zzahk zzf = this.zza.zzf(str);
            if (zzf != null) {
                return new zzahl(zzf);
            }
            return null;
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
            return null;
        }
    }

    public final CharSequence getText(String str) {
        try {
            return this.zza.zze(str);
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            zzacj zzk = this.zza.zzk();
            if (zzk != null) {
                this.zzc.zza(zzk);
            }
        } catch (RemoteException e) {
            zzbbk.zzg("Exception occurred while getting video controller", e);
        }
        return this.zzc;
    }

    public final MediaView getVideoMediaView() {
        return this.zzb;
    }

    public final void performClick(String str) {
        try {
            this.zza.zzi(str);
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
        }
    }

    public final void recordImpression() {
        try {
            this.zza.zzj();
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
        }
    }

    public final zzaia zza() {
        return this.zza;
    }
}
