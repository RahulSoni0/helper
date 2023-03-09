package com.google.android.gms.internal.ads;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbhk extends zzbhj {
    public zzbhk(zzbgf zzbgf, zzug zzug, boolean z) {
        super(zzbgf, zzug, z);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return null;
        }
        return zzL(webView, webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
    }
}
