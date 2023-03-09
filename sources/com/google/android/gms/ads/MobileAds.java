package com.google.android.gms.ads;

import android.content.Context;
import android.webkit.WebView;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.internal.ads.zzacy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public class MobileAds {
    public static final String ERROR_DOMAIN = "com.google.android.gms.ads";

    private MobileAds() {
    }

    public static void disableMediationAdapterInitialization(Context context) {
        zzacy.zza().zzk(context);
    }

    public static InitializationStatus getInitializationStatus() {
        return zzacy.zza().zzj();
    }

    public static RequestConfiguration getRequestConfiguration() {
        return zzacy.zza().zzm();
    }

    public static String getVersionString() {
        return zzacy.zza().zzh();
    }

    public static void initialize(Context context) {
        zzacy.zza().zzb(context, (String) null, (OnInitializationCompleteListener) null);
    }

    public static void openAdInspector(Context context, OnAdInspectorClosedListener onAdInspectorClosedListener) {
        zzacy.zza().zzl(context, onAdInspectorClosedListener);
    }

    public static void openDebugMenu(Context context, String str) {
        zzacy.zza().zzg(context, str);
    }

    public static void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        zzacy.zza().zzi(cls);
    }

    public static void registerWebView(WebView webView) {
        zzacy.zza().zzo(webView);
    }

    public static void setAppMuted(boolean z) {
        zzacy.zza().zze(z);
    }

    public static void setAppVolume(float f) {
        zzacy.zza().zzc(f);
    }

    public static void setRequestConfiguration(RequestConfiguration requestConfiguration) {
        zzacy.zza().zzn(requestConfiguration);
    }

    public static void initialize(Context context, OnInitializationCompleteListener onInitializationCompleteListener) {
        zzacy.zza().zzb(context, (String) null, onInitializationCompleteListener);
    }
}
