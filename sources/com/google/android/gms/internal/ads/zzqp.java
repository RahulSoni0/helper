package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzqp extends Surface {
    private static boolean zza;
    private static boolean zzb;
    private final zzqo zzc;
    private boolean zzd;

    /* synthetic */ zzqp(zzqo zzqo, SurfaceTexture surfaceTexture, boolean z, zzqn zzqn) {
        super(surfaceTexture);
        this.zzc = zzqo;
    }

    public static synchronized boolean zza(Context context) {
        boolean z;
        synchronized (zzqp.class) {
            if (!zzb) {
                if (zzqj.zza >= 17) {
                    boolean z2 = false;
                    String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                    if (eglQueryString != null && eglQueryString.contains("EGL_EXT_protected_content")) {
                        if (zzqj.zza != 24 || ((!zzqj.zzd.startsWith("SM-G950") && !zzqj.zzd.startsWith("SM-G955")) || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance"))) {
                            z2 = true;
                        }
                    }
                    zza = z2;
                }
                zzb = true;
            }
            z = zza;
        }
        return z;
    }

    public static zzqp zzb(Context context, boolean z) {
        if (zzqj.zza >= 17) {
            boolean z2 = true;
            if (z && !zza(context)) {
                z2 = false;
            }
            zzpu.zzd(z2);
            return new zzqo().zza(z);
        }
        throw new UnsupportedOperationException("Unsupported prior to API level 17");
    }

    public final void release() {
        super.release();
        synchronized (this.zzc) {
            if (!this.zzd) {
                this.zzc.zzb();
                this.zzd = true;
            }
        }
    }
}
