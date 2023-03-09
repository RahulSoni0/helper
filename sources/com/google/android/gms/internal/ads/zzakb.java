package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbo;
import com.google.android.gms.ads.internal.util.zze;
import com.itextpdf.text.html.HtmlTags;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzakb implements zzakp {
    static final zzakp zza = new zzakb();

    private zzakb() {
    }

    public final void zza(Object obj, Map map) {
        zzbhh zzbhh = (zzbhh) obj;
        zzakp<zzbgf> zzakp = zzako.zza;
        String str = (String) map.get(HtmlTags.f1209U);
        if (str == null) {
            zze.zzi("URL missing from httpTrack GMSG.");
        } else {
            new zzbo(zzbhh.getContext(), ((zzbhp) zzbhh).zzt().zza, str).zzb();
        }
    }
}
