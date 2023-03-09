package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import com.itextpdf.text.html.HtmlTags;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdrn implements zzakp {
    private final zzdwg zza;
    private final zzcvk zzb;

    zzdrn(zzdwg zzdwg, zzcvk zzcvk) {
        this.zza = zzdwg;
        this.zzb = zzcvk;
    }

    public final void zza(Object obj, Map map) {
        zzdwg zzdwg = this.zza;
        zzcvk zzcvk = this.zzb;
        zzbfw zzbfw = (zzbfw) obj;
        String str = (String) map.get(HtmlTags.f1209U);
        if (str == null) {
            zze.zzi("URL missing from httpTrack GMSG.");
        } else if (!zzbfw.zzF().zzad) {
            zzdwg.zzb(str);
        } else {
            zzcvk.zze(new zzcvm(zzs.zzj().currentTimeMillis(), ((zzbhc) zzbfw).zzaB().zzb, str, 2));
        }
    }
}
