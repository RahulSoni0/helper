package com.android.billingclient.api;

import android.text.TextUtils;
import com.anjlab.android.iab.p007v3.Constants;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
public class SkuDetails {
    private final String zza;
    private final JSONObject zzb;

    public SkuDetails(String str) throws JSONException {
        this.zza = str;
        JSONObject jSONObject = new JSONObject(str);
        this.zzb = jSONObject;
        if (TextUtils.isEmpty(jSONObject.optString(Constants.RESPONSE_PRODUCT_ID))) {
            throw new IllegalArgumentException("SKU cannot be empty.");
        } else if (TextUtils.isEmpty(jSONObject.optString("type"))) {
            throw new IllegalArgumentException("SkuType cannot be empty.");
        }
    }

    /* compiled from: com.android.billingclient:billing@@3.0.1 */
    static class zza {
        private final List<SkuDetails> zza;
        private final int zzb;
        private final String zzc;

        public zza(int i, String str, List<SkuDetails> list) {
            this.zzb = i;
            this.zzc = str;
            this.zza = list;
        }

        public final List<SkuDetails> zza() {
            return this.zza;
        }

        public final int zzb() {
            return this.zzb;
        }

        public final String zzc() {
            return this.zzc;
        }
    }

    public String getOriginalJson() {
        return this.zza;
    }

    public String getSku() {
        return this.zzb.optString(Constants.RESPONSE_PRODUCT_ID);
    }

    public final String zza() {
        return this.zzb.optString(Constants.RESPONSE_PACKAGE_NAME);
    }

    public String getType() {
        return this.zzb.optString("type");
    }

    public String getPrice() {
        return this.zzb.optString(Constants.RESPONSE_PRICE);
    }

    public long getPriceAmountMicros() {
        return this.zzb.optLong(Constants.RESPONSE_PRICE_MICROS);
    }

    public String getPriceCurrencyCode() {
        return this.zzb.optString(Constants.RESPONSE_PRICE_CURRENCY);
    }

    public String getOriginalPrice() {
        if (this.zzb.has("original_price")) {
            return this.zzb.optString("original_price");
        }
        return getPrice();
    }

    public long getOriginalPriceAmountMicros() {
        if (this.zzb.has("original_price_micros")) {
            return this.zzb.optLong("original_price_micros");
        }
        return getPriceAmountMicros();
    }

    public String getTitle() {
        return this.zzb.optString("title");
    }

    public String getDescription() {
        return this.zzb.optString("description");
    }

    public String getSubscriptionPeriod() {
        return this.zzb.optString(Constants.RESPONSE_SUBSCRIPTION_PERIOD);
    }

    public String getFreeTrialPeriod() {
        return this.zzb.optString(Constants.RESPONSE_FREE_TRIAL_PERIOD);
    }

    public String getIntroductoryPrice() {
        return this.zzb.optString(Constants.RESPONSE_INTRODUCTORY_PRICE);
    }

    public long getIntroductoryPriceAmountMicros() {
        return this.zzb.optLong(Constants.RESPONSE_INTRODUCTORY_PRICE_MICROS);
    }

    public String getIntroductoryPricePeriod() {
        return this.zzb.optString(Constants.RESPONSE_INTRODUCTORY_PRICE_PERIOD);
    }

    public int getIntroductoryPriceCycles() {
        return this.zzb.optInt(Constants.RESPONSE_INTRODUCTORY_PRICE_CYCLES);
    }

    public String getIconUrl() {
        return this.zzb.optString("iconUrl");
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        return this.zzb.optString("skuDetailsToken");
    }

    public String toString() {
        String valueOf = String.valueOf(this.zza);
        return valueOf.length() != 0 ? "SkuDetails: ".concat(valueOf) : new String("SkuDetails: ");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SkuDetails)) {
            return false;
        }
        return TextUtils.equals(this.zza, ((SkuDetails) obj).zza);
    }

    public int hashCode() {
        return this.zza.hashCode();
    }
}
