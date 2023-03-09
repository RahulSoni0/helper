package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.itextpdf.text.html.HtmlTags;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdrm implements zzakp {
    private final zzdwg zza;
    private final zzcvk zzb;

    zzdrm(zzdwg zzdwg, zzcvk zzcvk) {
        this.zza = zzdwg;
        this.zzb = zzcvk;
    }

    public final void zza(Object obj, Map map) {
        zzdwg zzdwg = this.zza;
        zzcvk zzcvk = this.zzb;
        zzbgf zzbgf = (zzbgf) obj;
        String str = (String) map.get(HtmlTags.f1209U);
        if (str == null) {
            zze.zzi("URL missing from click GMSG.");
        } else {
            zzefo.zzo(zzako.zza(zzbgf, str), new zzdro(zzbgf, zzdwg, zzcvk), zzbbw.zza);
        }
    }
}
