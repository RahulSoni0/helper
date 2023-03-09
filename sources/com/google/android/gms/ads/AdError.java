package com.google.android.gms.ads;

import android.os.IBinder;
import com.google.android.gms.internal.ads.zzym;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public class AdError {
    public static final String UNDEFINED_DOMAIN = "undefined";
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final AdError zzd;

    public AdError(int i, String str, String str2) {
        this(i, str, str2, (AdError) null);
    }

    public AdError(int i, String str, String str2, AdError adError) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = adError;
    }

    public AdError getCause() {
        return this.zzd;
    }

    public int getCode() {
        return this.zza;
    }

    public String getDomain() {
        return this.zzc;
    }

    public String getMessage() {
        return this.zzb;
    }

    public String toString() {
        try {
            return zzb().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    public final zzym zza() {
        AdError adError = this.zzd;
        return new zzym(this.zza, this.zzb, this.zzc, adError == null ? null : new zzym(adError.zza, adError.zzb, adError.zzc, (zzym) null, (IBinder) null), (IBinder) null);
    }

    public JSONObject zzb() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Code", this.zza);
        jSONObject.put("Message", this.zzb);
        jSONObject.put("Domain", this.zzc);
        AdError adError = this.zzd;
        if (adError == null) {
            jSONObject.put("Cause", "null");
        } else {
            jSONObject.put("Cause", adError.zzb());
        }
        return jSONObject;
    }
}
