package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zztj {
    private zzaau zza;
    private final Context zzb;
    private final String zzc;
    private final zzacq zzd;
    private final int zze;
    private final AppOpenAd.AppOpenAdLoadCallback zzf;
    private final zzapy zzg = new zzapy();
    private final zzyw zzh;

    public zztj(Context context, String str, zzacq zzacq, int i, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzb = context;
        this.zzc = str;
        this.zzd = zzacq;
        this.zze = i;
        this.zzf = appOpenAdLoadCallback;
        this.zzh = zzyw.zza;
    }

    public final void zza() {
        try {
            this.zza = zzzy.zzb().zza(this.zzb, zzyx.zzd(), this.zzc, this.zzg);
            zzzd zzzd = new zzzd(this.zze);
            zzaau zzaau = this.zza;
            if (zzaau != null) {
                zzaau.zzH(zzzd);
                this.zza.zzI(new zzsw(this.zzf, this.zzc));
                this.zza.zze(this.zzh.zza(this.zzb, this.zzd));
            }
        } catch (RemoteException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }
}
