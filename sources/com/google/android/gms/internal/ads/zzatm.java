package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzatm extends NativeAd.AdChoicesInfo {
    private final List<NativeAd.Image> zza = new ArrayList();
    private String zzb;

    public zzatm(zzahc zzahc) {
        try {
            this.zzb = zzahc.zzb();
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
            this.zzb = "";
        }
        try {
            for (zzahk next : zzahc.zzc()) {
                zzahk zzg = next instanceof IBinder ? zzahj.zzg((IBinder) next) : null;
                if (zzg != null) {
                    this.zza.add(new zzato(zzg));
                }
            }
        } catch (RemoteException e2) {
            zzbbk.zzg("", e2);
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.zza;
    }

    public final CharSequence getText() {
        return this.zzb;
    }
}
