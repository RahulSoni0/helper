package com.google.android.gms.ads.admanager;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.internal.ads.zzacq;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class AdManagerAdRequest extends AdRequest {

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
    public static final class Builder extends AdRequest.Builder {
        public Builder addCategoryExclusion(String str) {
            this.zza.zzp(str);
            return this;
        }

        public Builder addCustomTargeting(String str, String str2) {
            this.zza.zzo(str, str2);
            return this;
        }

        public Builder setPublisherProvidedId(String str) {
            this.zza.zzl(str);
            return this;
        }

        public Builder addCustomTargeting(String str, List<String> list) {
            if (list != null) {
                this.zza.zzo(str, TextUtils.join(",", list));
            }
            return this;
        }

        public AdManagerAdRequest build() {
            return new AdManagerAdRequest(this, (zza) null);
        }

        public Builder setAdInfo(AdInfo adInfo) {
            this.zza.zzr(adInfo);
            return this;
        }
    }

    /* synthetic */ AdManagerAdRequest(Builder builder, zza zza) {
        super(builder);
    }

    public Bundle getCustomTargeting() {
        return this.zza.zzq();
    }

    public String getPublisherProvidedId() {
        return this.zza.zzj();
    }

    public final zzacq zza() {
        return this.zza;
    }
}
