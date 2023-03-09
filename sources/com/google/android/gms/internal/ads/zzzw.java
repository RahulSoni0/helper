package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.p008h5.OnH5AdsEventListener;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzzw {
    /* access modifiers changed from: private */
    public final zzyr zza;
    /* access modifiers changed from: private */
    public final zzyq zzb;
    /* access modifiers changed from: private */
    public final zzadd zzc;
    /* access modifiers changed from: private */
    public final zzajf zzd;
    private final zzaxx zze;
    /* access modifiers changed from: private */
    public final zzaui zzf;
    /* access modifiers changed from: private */
    public final zzajg zzg;

    public zzzw(zzyr zzyr, zzyq zzyq, zzadd zzadd, zzajf zzajf, zzaxx zzaxx, zzaui zzaui, zzajg zzajg) {
        this.zza = zzyr;
        this.zzb = zzyq;
        this.zzc = zzadd;
        this.zzd = zzajf;
        this.zze = zzaxx;
        this.zzf = zzaui;
        this.zzg = zzajg;
    }

    static /* synthetic */ void zzl(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzzy.zza().zze(context, zzzy.zzd().zza, "gmob-apps", bundle, true);
    }

    public final zzaau zza(Context context, zzyx zzyx, String str, zzaqb zzaqb) {
        return (zzaau) new zzzo(this, context, zzyx, str, zzaqb).zzd(context, false);
    }

    public final zzaau zzb(Context context, zzyx zzyx, String str, zzaqb zzaqb) {
        return (zzaau) new zzzq(this, context, zzyx, str, zzaqb).zzd(context, false);
    }

    public final zzaaq zzc(Context context, String str, zzaqb zzaqb) {
        return (zzaaq) new zzzr(this, context, str, zzaqb).zzd(context, false);
    }

    public final zzaho zzd(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzaho) new zzzt(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzahs zze(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        return (zzahs) new zzzu(this, view, hashMap, hashMap2).zzd(view.getContext(), false);
    }

    public final zzaxl zzf(Context context, String str, zzaqb zzaqb) {
        return (zzaxl) new zzzv(this, context, str, zzaqb).zzd(context, false);
    }

    public final zzaul zzg(Activity activity) {
        zzzg zzzg = new zzzg(this, activity);
        Intent intent = activity.getIntent();
        boolean z = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzbbk.zzf("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return (zzaul) zzzg.zzd(activity, z);
    }

    public final zzbag zzh(Context context, zzaqb zzaqb) {
        return (zzbag) new zzzi(this, context, zzaqb).zzd(context, false);
    }

    public final zzatz zzi(Context context, zzaqb zzaqb) {
        return (zzatz) new zzzk(this, context, zzaqb).zzd(context, false);
    }

    public final zzaln zzj(Context context, zzaqb zzaqb, OnH5AdsEventListener onH5AdsEventListener) {
        return (zzaln) new zzzm(this, context, zzaqb, onH5AdsEventListener).zzd(context, false);
    }
}
