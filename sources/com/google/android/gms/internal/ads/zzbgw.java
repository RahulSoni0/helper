package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.itextpdf.text.html.HtmlTags;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbgw implements zzakp<zzbgf> {
    final /* synthetic */ zzbgy zza;

    zzbgw(zzbgy zzbgy) {
        this.zza = zzbgy;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbgf zzbgf = (zzbgf) obj;
        if (map != null) {
            String str = (String) map.get(HtmlTags.HEIGHT);
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zza) {
                        if (this.zza.zzG != parseInt) {
                            int unused = this.zza.zzG = parseInt;
                            this.zza.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zze.zzj("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
