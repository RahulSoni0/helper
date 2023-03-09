package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.android.gms.ads.p008h5.OnH5AdsEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final /* synthetic */ class zzals implements OnH5AdsEventListener {
    private final WebView zza;

    zzals(WebView webView) {
        this.zza = webView;
    }

    public final void onH5AdsEvent(String str) {
        WebView webView = this.zza;
        int i = zzalt.zza;
        webView.evaluateJavascript(str, (ValueCallback) null);
    }
}
