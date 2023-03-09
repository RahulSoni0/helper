package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final /* synthetic */ class zzaps implements Runnable {
    private final zzapu zza;
    private final Context zzb;
    private final String zzc;

    zzaps(zzapu zzapu, Context context, String str) {
        this.zza = zzapu;
        this.zzb = context;
        this.zzc = str;
    }

    public final void run() {
        Context context = this.zzb;
        String str = this.zzc;
        zzaeq.zza(context);
        Bundle bundle = new Bundle();
        bundle.putBoolean("measurementEnabled", ((Boolean) zzaaa.zzc().zzb(zzaeq.zzac)).booleanValue());
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzaj)).booleanValue()) {
            bundle.putString("ad_storage", "denied");
            bundle.putString("analytics_storage", "denied");
        }
        try {
            ((zzbia) zzbbo.zza(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", zzapt.zza)).zze(ObjectWrapper.wrap(context), new zzapr(AppMeasurementSdk.getInstance(context, "FA-Ads", "am", str, bundle)));
        } catch (RemoteException | zzbbn | NullPointerException e) {
            zzbbk.zzl("#007 Could not call remote method.", e);
        }
    }
}
