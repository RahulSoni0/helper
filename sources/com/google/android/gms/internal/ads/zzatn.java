package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzatn implements NativeCustomFormatAd.DisplayOpenMeasurement {
    private final zzaia zza;

    public zzatn(zzaia zzaia) {
        this.zza = zzaia;
        try {
            zzaia.zzr();
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
        }
    }

    public final void setView(View view) {
        try {
            this.zza.zzq(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
        }
    }

    public final boolean start() {
        try {
            return this.zza.zzp();
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
            return false;
        }
    }
}
