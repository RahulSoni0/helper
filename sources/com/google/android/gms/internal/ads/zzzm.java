package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.p008h5.OnH5AdsEventListener;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzzm extends zzzx<zzaln> {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzaqb zzb;
    final /* synthetic */ OnH5AdsEventListener zzc;

    zzzm(zzzw zzzw, Context context, zzaqb zzaqb, OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = context;
        this.zzb = zzaqb;
        this.zzc = onH5AdsEventListener;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        return new zzalu();
    }

    public final /* bridge */ /* synthetic */ Object zzb() throws RemoteException {
        try {
            return ((zzalq) zzbbo.zza(this.zza, "com.google.android.gms.ads.DynamiteH5AdsManagerCreatorImpl", zzzl.zza)).zze(ObjectWrapper.wrap(this.zza), this.zzb, 210890000, new zzalh(this.zzc));
        } catch (RemoteException | zzbbn | NullPointerException unused) {
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzabe zzabe) throws RemoteException {
        return zzabe.zzo(ObjectWrapper.wrap(this.zza), this.zzb, 210890000, new zzalh(this.zzc));
    }
}
