package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.RequestConfiguration;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final /* synthetic */ class zzyv implements Comparator {
    static final Comparator zza = new zzyv();

    private zzyv() {
    }

    public final int compare(Object obj, Object obj2) {
        return RequestConfiguration.zza.indexOf((String) obj) - RequestConfiguration.zza.indexOf((String) obj2);
    }
}
