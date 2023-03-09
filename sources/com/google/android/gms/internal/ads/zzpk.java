package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzpk extends IOException {
    public final zzpg zza;

    public zzpk(IOException iOException, zzpg zzpg, int i) {
        super(iOException);
        this.zza = zzpg;
    }

    public zzpk(String str, zzpg zzpg, int i) {
        super(str);
        this.zza = zzpg;
    }

    public zzpk(String str, IOException iOException, zzpg zzpg, int i) {
        super(str, iOException);
        this.zza = zzpg;
    }
}
