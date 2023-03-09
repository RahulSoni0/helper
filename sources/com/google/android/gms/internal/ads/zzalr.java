package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import com.google.android.gms.ads.p008h5.OnH5AdsEventListener;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzalr {
    private final Context zza;
    private final OnH5AdsEventListener zzb;
    private zzaln zzc;

    public zzalr(Context context, OnH5AdsEventListener onH5AdsEventListener) {
        Preconditions.checkState(Build.VERSION.SDK_INT >= 21, "Android version must be Lollipop or higher");
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(onH5AdsEventListener);
        this.zza = context;
        this.zzb = onH5AdsEventListener;
    }

    public static final boolean zzc(String str) {
        if (!((Boolean) zzaaa.zzc().zzb(zzaeq.zzgf)).booleanValue()) {
            return false;
        }
        Preconditions.checkNotNull(str);
        if (str.length() > ((Integer) zzaaa.zzc().zzb(zzaeq.zzgh)).intValue()) {
            zzbbk.zzd("H5 GMSG exceeds max length");
            return false;
        }
        Uri parse = Uri.parse(str);
        if (!"gmsg".equals(parse.getScheme()) || !"mobileads.google.com".equals(parse.getHost()) || !"/h5ads".equals(parse.getPath())) {
            return false;
        }
        return true;
    }

    private final void zzd() {
        if (this.zzc == null) {
            this.zzc = zzzy.zzb().zzj(this.zza, new zzapy(), this.zzb);
        }
    }

    public final boolean zza(String str) {
        if (!zzc(str)) {
            return false;
        }
        zzd();
        zzaln zzaln = this.zzc;
        if (zzaln == null) {
            return false;
        }
        try {
            zzaln.zze(str);
            return true;
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
            return true;
        }
    }

    public final void zzb() {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzgf)).booleanValue()) {
            zzd();
            zzaln zzaln = this.zzc;
            if (zzaln != null) {
                try {
                    zzaln.zzf();
                } catch (RemoteException e) {
                    zzbbk.zzl("#007 Could not call remote method.", e);
                }
            }
        }
    }
}
