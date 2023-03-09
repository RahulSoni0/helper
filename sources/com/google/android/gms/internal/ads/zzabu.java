package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzabu implements MuteThisAdReason {
    private final String zza;
    private final zzabt zzb;

    public zzabu(zzabt zzabt) {
        String str;
        this.zzb = zzabt;
        try {
            str = zzabt.zze();
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
            str = null;
        }
        this.zza = str;
    }

    public final String getDescription() {
        return this.zza;
    }

    public final String toString() {
        return this.zza;
    }

    public final zzabt zza() {
        return this.zzb;
    }
}
