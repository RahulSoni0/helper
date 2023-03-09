package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import android.os.RemoteException;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.internal.ads.zzapy;
import com.google.android.gms.internal.ads.zzatz;
import com.google.android.gms.internal.ads.zzzy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public class OfflinePingSender extends Worker {
    private final zzatz zza;

    public OfflinePingSender(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.zza = zzzy.zzb().zzi(context, new zzapy());
    }

    public final ListenableWorker.Result doWork() {
        try {
            this.zza.zzg();
            return ListenableWorker.Result.success();
        } catch (RemoteException unused) {
            return ListenableWorker.Result.failure();
        }
    }
}
