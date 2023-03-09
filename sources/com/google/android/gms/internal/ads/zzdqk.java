package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdqk extends zzdyp {
    final /* synthetic */ zzaay zza;
    final /* synthetic */ zzdql zzb;

    zzdqk(zzdql zzdql, zzaay zzaay) {
        this.zzb = zzdql;
        this.zza = zzaay;
    }

    public final void zzl() {
        if (this.zzb.zzd != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e) {
                zze.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
