package com.google.android.gms.internal.ads;

import java.io.PrintWriter;

/* compiled from: com.google.android.gms:play-services-ads-base@@20.1.0 */
final class zzerl extends zzerg {
    zzerl() {
    }

    public final void zza(Throwable th, Throwable th2) {
        th.addSuppressed(th2);
    }

    public final void zzb(Throwable th) {
        th.printStackTrace();
    }

    public final void zzc(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
    }
}
