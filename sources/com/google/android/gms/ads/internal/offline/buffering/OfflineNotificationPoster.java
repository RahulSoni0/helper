package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import android.os.RemoteException;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzapy;
import com.google.android.gms.internal.ads.zzatz;
import com.google.android.gms.internal.ads.zzzy;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public class OfflineNotificationPoster extends Worker {
    private final zzatz zza;

    public OfflineNotificationPoster(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.zza = zzzy.zzb().zzi(context, new zzapy());
    }

    public final ListenableWorker.Result doWork() {
        try {
            this.zza.zzf(ObjectWrapper.wrap(getApplicationContext()), getInputData().getString("uri"), getInputData().getString("gws_query_id"));
            return ListenableWorker.Result.success();
        } catch (RemoteException unused) {
            return ListenableWorker.Result.failure();
        }
    }
}
