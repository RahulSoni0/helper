package com.google.android.gms.internal.ads;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbhi extends zzbhj {
    public zzbhi(zzbgf zzbgf, zzug zzug, boolean z) {
        super(zzbgf, zzug, z);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzL(webView, str, (Map<String, String>) null);
    }
}
