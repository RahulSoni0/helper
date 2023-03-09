package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzbgf;
import com.google.android.gms.internal.ads.zzbgm;
import com.google.android.gms.internal.ads.zzbhk;
import com.google.android.gms.internal.ads.zzug;
import java.io.InputStream;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzx extends zzw {
    public final CookieManager zzk(Context context) {
        if (!zzu()) {
            try {
                return CookieManager.getInstance();
            } catch (Throwable th) {
                zze.zzg("Failed to obtain CookieManager.", th);
                zzs.zzg().zzg(th, "ApiLevelUtil.getCookieManager");
            }
        }
        return null;
    }

    public final zzbgm zzl(zzbgf zzbgf, zzug zzug, boolean z) {
        return new zzbhk(zzbgf, zzug, z);
    }

    public final int zzm() {
        return 16974374;
    }

    public final WebResourceResponse zzn(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i, str3, map, inputStream);
    }
}
