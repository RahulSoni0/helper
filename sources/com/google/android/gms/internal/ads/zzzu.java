package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzzu extends zzzx<zzahs> {
    final /* synthetic */ View zza;
    final /* synthetic */ HashMap zzb;
    final /* synthetic */ HashMap zzc;
    final /* synthetic */ zzzw zzd;

    zzzu(zzzw zzzw, View view, HashMap hashMap, HashMap hashMap2) {
        this.zzd = zzzw;
        this.zza = view;
        this.zzb = hashMap;
        this.zzc = hashMap2;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzzw.zzl(this.zza.getContext(), "native_ad_view_holder_delegate");
        return new zzadn();
    }

    public final /* bridge */ /* synthetic */ Object zzb() throws RemoteException {
        return this.zzd.zzg.zza(this.zza, this.zzb, this.zzc);
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzabe zzabe) throws RemoteException {
        return zzabe.zzj(ObjectWrapper.wrap(this.zza), ObjectWrapper.wrap(this.zzb), ObjectWrapper.wrap(this.zzc));
    }
}
