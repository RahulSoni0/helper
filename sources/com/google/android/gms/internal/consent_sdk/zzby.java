package com.google.android.gms.internal.consent_sdk;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzby {
    public int zza = zzbu.zzg;
    public String zzb;
    public String zzc;
    public String zzd;
    public List<String> zze = Collections.emptyList();
    public List<zzbx> zzf = Collections.emptyList();

    public static zzby zza(JsonReader jsonReader) throws IOException {
        zzby zzby = new zzby();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -2001388947:
                    if (nextName.equals("consent_signal")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1938755376:
                    if (nextName.equals("error_message")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1851537225:
                    if (nextName.equals("consent_form_base_url")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1161803523:
                    if (nextName.equals("actions")) {
                        c = 3;
                        break;
                    }
                    break;
                case -986806987:
                    if (nextName.equals("request_info_keys")) {
                        c = 4;
                        break;
                    }
                    break;
                case -790907624:
                    if (nextName.equals("consent_form_payload")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    zzby.zza = zzbu.zzb(jsonReader);
                    break;
                case 1:
                    zzby.zzd = jsonReader.nextString();
                    break;
                case 2:
                    zzby.zzc = jsonReader.nextString();
                    break;
                case 3:
                    zzby.zzf = new ArrayList();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        zzbx zzbx = new zzbx();
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String nextName2 = jsonReader.nextName();
                            nextName2.hashCode();
                            if (nextName2.equals("args_json")) {
                                zzbx.zzb = jsonReader.nextString();
                            } else if (!nextName2.equals("action_type")) {
                                jsonReader.skipValue();
                            } else {
                                zzbx.zza = zzbu.zza(jsonReader);
                            }
                        }
                        jsonReader.endObject();
                        zzby.zzf.add(zzbx);
                    }
                    jsonReader.endArray();
                    break;
                case 4:
                    zzby.zze = new ArrayList();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        zzby.zze.add(jsonReader.nextString());
                    }
                    jsonReader.endArray();
                    break;
                case 5:
                    zzby.zzb = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return zzby;
    }
}
