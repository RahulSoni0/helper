package com.android.billingclient.api;

import android.text.TextUtils;
import com.anjlab.android.iab.p007v3.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
public class PurchaseHistoryRecord {
    private final String zza;
    private final String zzb;
    private final JSONObject zzc;

    public PurchaseHistoryRecord(String str, String str2) throws JSONException {
        this.zza = str;
        this.zzb = str2;
        this.zzc = new JSONObject(str);
    }

    public String getSku() {
        return this.zzc.optString(Constants.RESPONSE_PRODUCT_ID);
    }

    public long getPurchaseTime() {
        return this.zzc.optLong(Constants.RESPONSE_PURCHASE_TIME);
    }

    public String getPurchaseToken() {
        JSONObject jSONObject = this.zzc;
        return jSONObject.optString("token", jSONObject.optString(Constants.RESPONSE_PURCHASE_TOKEN));
    }

    public String getDeveloperPayload() {
        return this.zzc.optString(Constants.RESPONSE_DEVELOPER_PAYLOAD);
    }

    public String getOriginalJson() {
        return this.zza;
    }

    public String getSignature() {
        return this.zzb;
    }

    public String toString() {
        String valueOf = String.valueOf(this.zza);
        return valueOf.length() != 0 ? "PurchaseHistoryRecord. Json: ".concat(valueOf) : new String("PurchaseHistoryRecord. Json: ");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PurchaseHistoryRecord)) {
            return false;
        }
        PurchaseHistoryRecord purchaseHistoryRecord = (PurchaseHistoryRecord) obj;
        return TextUtils.equals(this.zza, purchaseHistoryRecord.getOriginalJson()) && TextUtils.equals(this.zzb, purchaseHistoryRecord.getSignature());
    }

    public int hashCode() {
        return this.zza.hashCode();
    }
}
