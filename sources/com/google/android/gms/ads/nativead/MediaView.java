package com.google.android.gms.ads.nativead;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.internal.ads.zzagv;
import com.google.android.gms.internal.ads.zzagx;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public class MediaView extends FrameLayout {
    private MediaContent zza;
    private boolean zzb;
    private zzagv zzc;
    private ImageView.ScaleType zzd;
    private boolean zze;
    private zzagx zzf;

    public MediaView(Context context) {
        super(context);
    }

    public void setImageScaleType(ImageView.ScaleType scaleType) {
        this.zze = true;
        this.zzd = scaleType;
        zzagx zzagx = this.zzf;
        if (zzagx != null) {
            zzagx.zza(scaleType);
        }
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.zzb = true;
        this.zza = mediaContent;
        zzagv zzagv = this.zzc;
        if (zzagv != null) {
            zzagv.zza(mediaContent);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zza(zzagv zzagv) {
        this.zzc = zzagv;
        if (this.zzb) {
            zzagv.zza(this.zza);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzb(zzagx zzagx) {
        this.zzf = zzagx;
        if (this.zze) {
            zzagx.zza(this.zzd);
        }
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
