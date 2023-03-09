package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.common.zzh;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class HandlerExecutor implements Executor {
    private final Handler zza;

    public HandlerExecutor(Looper looper) {
        this.zza = new zzh(looper);
    }

    public final void execute(Runnable runnable) {
        this.zza.post(runnable);
    }
}
