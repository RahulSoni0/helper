package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzacp;
import com.google.android.gms.internal.ads.zzacq;
import com.google.android.gms.internal.ads.zzbbk;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public class AdRequest {
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_APP_ID_MISSING = 8;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_MEDIATION_NO_FILL = 9;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int ERROR_CODE_REQUEST_ID_MISMATCH = 10;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final int MAX_CONTENT_URL_LENGTH = 512;
    protected final zzacq zza;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
    public static class Builder {
        protected final zzacp zza;

        public Builder() {
            zzacp zzacp = new zzacp();
            this.zza = zzacp;
            zzacp.zze("B3EEABB8EE11C2BE770B684D95219ECB");
        }

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.zza.zzd(cls, bundle);
            return this;
        }

        public Builder addKeyword(String str) {
            this.zza.zza(str);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zza.zzb(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
            this.zza.zzc(cls, bundle);
            if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
                this.zza.zzf("B3EEABB8EE11C2BE770B684D95219ECB");
            }
            return this;
        }

        public AdRequest build() {
            return new AdRequest(this);
        }

        public Builder setAdInfo(AdInfo adInfo) {
            this.zza.zzr(adInfo);
            return this;
        }

        public Builder setContentUrl(String str) {
            Preconditions.checkNotNull(str, "Content URL must be non-null.");
            Preconditions.checkNotEmpty(str, "Content URL must be non-empty.");
            Preconditions.checkArgument(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(str.length()));
            this.zza.zzh(str);
            return this;
        }

        public Builder setHttpTimeoutMillis(int i) {
            this.zza.zzs(i);
            return this;
        }

        public Builder setLocation(Location location) {
            this.zza.zzk(location);
            return this;
        }

        public Builder setNeighboringContentUrls(List<String> list) {
            if (list == null) {
                zzbbk.zzi("neighboring content URLs list should not be null");
                return this;
            }
            this.zza.zzi(list);
            return this;
        }

        public Builder setRequestAgent(String str) {
            this.zza.zzm(str);
            return this;
        }

        @Deprecated
        public final Builder zza(String str) {
            this.zza.zze(str);
            return this;
        }

        @Deprecated
        public final Builder zzb(Date date) {
            this.zza.zzg(date);
            return this;
        }

        @Deprecated
        public final Builder zzc(int i) {
            this.zza.zzj(i);
            return this;
        }

        @Deprecated
        public final Builder zzd(boolean z) {
            this.zza.zzn(z);
            return this;
        }

        @Deprecated
        public final Builder zze(boolean z) {
            this.zza.zzq(z);
            return this;
        }
    }

    protected AdRequest(Builder builder) {
        this.zza = new zzacq(builder.zza, (SearchAdRequest) null);
    }

    public String getContentUrl() {
        return this.zza.zzb();
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zza.zzi(cls);
    }

    public Bundle getCustomTargeting() {
        return this.zza.zzq();
    }

    public Set<String> getKeywords() {
        return this.zza.zze();
    }

    public Location getLocation() {
        return this.zza.zzf();
    }

    public List<String> getNeighboringContentUrls() {
        return this.zza.zzc();
    }

    public <T extends MediationExtrasReceiver> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.zza.zzh(cls);
    }

    public boolean isTestDevice(Context context) {
        return this.zza.zzm(context);
    }

    public zzacq zza() {
        return this.zza;
    }
}
