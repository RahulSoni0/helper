package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzato extends NativeAd.Image {
    private final zzahk zza;
    private final Drawable zzb;
    private final Uri zzc;
    private final double zzd;

    public zzato(zzahk zzahk) {
        Drawable drawable;
        double d;
        this.zza = zzahk;
        Uri uri = null;
        try {
            IObjectWrapper zzb2 = zzahk.zzb();
            if (zzb2 != null) {
                drawable = (Drawable) ObjectWrapper.unwrap(zzb2);
                this.zzb = drawable;
                uri = this.zza.zzc();
                this.zzc = uri;
                d = this.zza.zzd();
                this.zzd = d;
                this.zza.zze();
                this.zza.zzf();
            }
        } catch (RemoteException e) {
            zzbbk.zzg("", e);
        }
        drawable = null;
        this.zzb = drawable;
        try {
            uri = this.zza.zzc();
        } catch (RemoteException e2) {
            zzbbk.zzg("", e2);
        }
        this.zzc = uri;
        try {
            d = this.zza.zzd();
        } catch (RemoteException e3) {
            zzbbk.zzg("", e3);
            d = 1.0d;
        }
        this.zzd = d;
        try {
            this.zza.zze();
        } catch (RemoteException e4) {
            zzbbk.zzg("", e4);
        }
        try {
            this.zza.zzf();
        } catch (RemoteException e5) {
            zzbbk.zzg("", e5);
        }
    }

    public final Drawable getDrawable() {
        return this.zzb;
    }

    public final double getScale() {
        return this.zzd;
    }

    public final Uri getUri() {
        return this.zzc;
    }
}
