package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzaj implements zzi {
    private final Application zza;
    private final zzal zzb;
    private final Executor zzc;

    public zzaj(Application application, zzal zzal, Executor executor) {
        this.zza = application;
        this.zzb = zzal;
        this.zzc = executor;
    }

    public final Executor zza() {
        return this.zzc;
    }

    public final boolean zza(String str, JSONObject jSONObject) {
        str.hashCode();
        if (str.equals("clear")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("keys");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                String valueOf = String.valueOf(jSONObject.toString());
                Log.d("UserMessagingPlatform", valueOf.length() != 0 ? "Action[clear]: wrong args.".concat(valueOf) : new String("Action[clear]: wrong args."));
            } else {
                HashSet hashSet = new HashSet();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    if (TextUtils.isEmpty(optString)) {
                        StringBuilder sb = new StringBuilder(46);
                        sb.append("Action[clear]: empty key at index: ");
                        sb.append(i);
                        Log.d("UserMessagingPlatform", sb.toString());
                    } else {
                        hashSet.add(optString);
                    }
                }
                zzcc.zza((Context) this.zza, (Set<String>) hashSet);
            }
            return true;
        } else if (!str.equals("write")) {
            return false;
        } else {
            zzce zzce = new zzce(this.zza);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                String valueOf2 = String.valueOf(opt);
                StringBuilder sb2 = new StringBuilder(String.valueOf(next).length() + 23 + String.valueOf(valueOf2).length());
                sb2.append("Writing to storage: [");
                sb2.append(next);
                sb2.append("] ");
                sb2.append(valueOf2);
                Log.d("UserMessagingPlatform", sb2.toString());
                if (zzce.zza(next, opt)) {
                    this.zzb.zzd().add(next);
                } else {
                    String valueOf3 = String.valueOf(next);
                    Log.d("UserMessagingPlatform", valueOf3.length() != 0 ? "Failed writing key: ".concat(valueOf3) : new String("Failed writing key: "));
                }
            }
            this.zzb.zze();
            zzce.zza();
            return true;
        }
    }
}
