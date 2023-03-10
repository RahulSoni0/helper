package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.itextpdf.text.html.HtmlTags;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdqp {
    public final int zza;
    public final int zzb;
    public final boolean zzc;

    public zzdqp(int i, int i2, boolean z) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = z;
    }

    static List<zzdqp> zza(JsonReader jsonReader) throws IllegalStateException, IOException, NumberFormatException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            int i = 0;
            int i2 = 0;
            boolean z = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (HtmlTags.WIDTH.equals(nextName)) {
                    i = jsonReader.nextInt();
                } else if (HtmlTags.HEIGHT.equals(nextName)) {
                    i2 = jsonReader.nextInt();
                } else if ("is_fluid_height".equals(nextName)) {
                    z = jsonReader.nextBoolean();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            arrayList.add(new zzdqp(i, i2, z));
        }
        jsonReader.endArray();
        return arrayList;
    }
}
