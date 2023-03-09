package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbti implements zzbvr, zzbuy {
    private final Context zza;
    private final zzdqo zzb;
    private final zzauo zzc;

    public zzbti(Context context, zzdqo zzdqo, zzauo zzauo, byte[] bArr) {
        this.zza = context;
        this.zzb = zzdqo;
        this.zzc = zzauo;
    }

    public final void zzb(Context context) {
    }

    public final void zzbD() {
        zzaup zzaup = this.zzb.zzX;
        if (zzaup != null && zzaup.zza) {
            ArrayList arrayList = new ArrayList();
            if (!this.zzb.zzX.zzb.isEmpty()) {
                arrayList.add(this.zzb.zzX.zzb);
            }
        }
    }

    public final void zzbn(Context context) {
    }

    public final void zzbq(Context context) {
    }
}
