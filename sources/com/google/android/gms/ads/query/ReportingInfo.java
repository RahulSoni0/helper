package com.google.android.gms.ads.query;

import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzavd;
import com.google.android.gms.internal.ads.zzave;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class ReportingInfo {
    private final zzave zza;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public final zzavd zza;

        public Builder(View view) {
            zzavd zzavd = new zzavd();
            this.zza = zzavd;
            zzavd.zza(view);
        }

        public ReportingInfo build() {
            return new ReportingInfo(this, (zza) null);
        }

        public Builder setAssetViews(Map<String, View> map) {
            this.zza.zzb(map);
            return this;
        }
    }

    /* synthetic */ ReportingInfo(Builder builder, zza zza2) {
        this.zza = new zzave(builder.zza);
    }

    public void reportTouchEvent(MotionEvent motionEvent) {
        this.zza.zzc(motionEvent);
    }

    public void updateClickUrl(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zza.zzb(uri, updateClickUrlCallback);
    }

    public void updateImpressionUrls(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zza.zza(list, updateImpressionUrlsCallback);
    }
}
