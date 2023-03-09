package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.MotionEvent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzafp {
    private MotionEvent zza = MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 0);
    private MotionEvent zzb = MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0);
    private final Context zzc;
    private final ScheduledExecutorService zzd;
    private final zzafr zze;

    public zzafp(Context context, ScheduledExecutorService scheduledExecutorService, zzafr zzafr, byte[] bArr) {
        this.zzc = context;
        this.zzd = scheduledExecutorService;
        this.zze = zzafr;
    }

    public final void zza(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && motionEvent.getEventTime() > this.zza.getEventTime()) {
            this.zza = MotionEvent.obtain(motionEvent);
        } else if (motionEvent.getAction() == 0 && motionEvent.getEventTime() > this.zzb.getEventTime()) {
            this.zzb = MotionEvent.obtain(motionEvent);
        }
    }

    public final zzefw<String> zzb() {
        return (zzeff) zzefo.zzg(zzeff.zzw(zzefo.zza(null)), zzagc.zzc.zze().longValue(), TimeUnit.MILLISECONDS, this.zzd);
    }
}
