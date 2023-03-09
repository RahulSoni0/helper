package com.google.android.gms.internal.ads;

import java.util.Comparator;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzerx implements Comparator<zzesf> {
    zzerx() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzesf zzesf = (zzesf) obj;
        zzesf zzesf2 = (zzesf) obj2;
        zzesa zzp = zzesf.iterator();
        zzesa zzp2 = zzesf2.iterator();
        while (zzp.hasNext() && zzp2.hasNext()) {
            int compare = Integer.compare(zzp.zza() & UByte.MAX_VALUE, zzp2.zza() & UByte.MAX_VALUE);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzesf.zzc(), zzesf2.zzc());
    }
}
