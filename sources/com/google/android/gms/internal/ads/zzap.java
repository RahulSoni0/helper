package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzap implements zzab {
    private final Map<String, List<zzac<?>>> zza = new HashMap();
    private final zzo zzb;
    private final BlockingQueue<zzac<?>> zzc;
    private final zzt zzd;

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzo, java.util.concurrent.BlockingQueue<com.google.android.gms.internal.ads.zzac<?>>] */
    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.concurrent.BlockingQueue<com.google.android.gms.internal.ads.zzac<?>>, com.google.android.gms.internal.ads.zzt] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzap(com.google.android.gms.internal.ads.zzo r1, com.google.android.gms.internal.ads.zzo r2, java.util.concurrent.BlockingQueue<com.google.android.gms.internal.ads.zzac<?>> r3, com.google.android.gms.internal.ads.zzt r4) {
        /*
            r0 = this;
            r0.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r0.zza = r4
            r0.zzd = r3
            r0.zzb = r1
            r0.zzc = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzap.<init>(com.google.android.gms.internal.ads.zzo, java.util.concurrent.BlockingQueue, com.google.android.gms.internal.ads.zzt, byte[]):void");
    }

    public final void zza(zzac<?> zzac, zzai<?> zzai) {
        List<zzac> remove;
        zzl zzl = zzai.zzb;
        if (zzl == null || zzl.zza(System.currentTimeMillis())) {
            zzb(zzac);
            return;
        }
        String zzi = zzac.zzi();
        synchronized (this) {
            remove = this.zza.remove(zzi);
        }
        if (remove != null) {
            if (zzao.zzb) {
                zzao.zza("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), zzi);
            }
            for (zzac zza2 : remove) {
                this.zzd.zza(zza2, zzai, (Runnable) null);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0061, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb(com.google.android.gms.internal.ads.zzac<?> r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r6 = r6.zzi()     // Catch:{ all -> 0x0062 }
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzac<?>>> r0 = r5.zza     // Catch:{ all -> 0x0062 }
            java.lang.Object r0 = r0.remove(r6)     // Catch:{ all -> 0x0062 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0062 }
            if (r0 == 0) goto L_0x0060
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x0062 }
            if (r1 != 0) goto L_0x0060
            boolean r1 = com.google.android.gms.internal.ads.zzao.zzb     // Catch:{ all -> 0x0062 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x002f
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0062 }
            int r4 = r0.size()     // Catch:{ all -> 0x0062 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0062 }
            r1[r3] = r4     // Catch:{ all -> 0x0062 }
            r1[r2] = r6     // Catch:{ all -> 0x0062 }
            java.lang.String r4 = "%d waiting requests for cacheKey=%s; resend to network"
            com.google.android.gms.internal.ads.zzao.zza(r4, r1)     // Catch:{ all -> 0x0062 }
        L_0x002f:
            java.lang.Object r1 = r0.remove(r3)     // Catch:{ all -> 0x0062 }
            com.google.android.gms.internal.ads.zzac r1 = (com.google.android.gms.internal.ads.zzac) r1     // Catch:{ all -> 0x0062 }
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzac<?>>> r4 = r5.zza     // Catch:{ all -> 0x0062 }
            r4.put(r6, r0)     // Catch:{ all -> 0x0062 }
            r1.zzu(r5)     // Catch:{ all -> 0x0062 }
            java.util.concurrent.BlockingQueue<com.google.android.gms.internal.ads.zzac<?>> r6 = r5.zzc     // Catch:{ InterruptedException -> 0x0044 }
            r6.put(r1)     // Catch:{ InterruptedException -> 0x0044 }
            monitor-exit(r5)
            return
        L_0x0044:
            r6 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x0062 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0062 }
            r0[r3] = r6     // Catch:{ all -> 0x0062 }
            java.lang.String r6 = "Couldn't add request to queue. %s"
            com.google.android.gms.internal.ads.zzao.zzc(r6, r0)     // Catch:{ all -> 0x0062 }
            java.lang.Thread r6 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0062 }
            r6.interrupt()     // Catch:{ all -> 0x0062 }
            com.google.android.gms.internal.ads.zzo r6 = r5.zzb     // Catch:{ all -> 0x0062 }
            r6.zza()     // Catch:{ all -> 0x0062 }
            monitor-exit(r5)
            return
        L_0x0060:
            monitor-exit(r5)
            return
        L_0x0062:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzap.zzb(com.google.android.gms.internal.ads.zzac):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzc(com.google.android.gms.internal.ads.zzac<?> r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = r6.zzi()     // Catch:{ all -> 0x0052 }
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzac<?>>> r1 = r5.zza     // Catch:{ all -> 0x0052 }
            boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x0052 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x003a
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzac<?>>> r1 = r5.zza     // Catch:{ all -> 0x0052 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0052 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0052 }
            if (r1 != 0) goto L_0x001e
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0052 }
            r1.<init>()     // Catch:{ all -> 0x0052 }
        L_0x001e:
            java.lang.String r4 = "waiting-for-response"
            r6.zzc(r4)     // Catch:{ all -> 0x0052 }
            r1.add(r6)     // Catch:{ all -> 0x0052 }
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzac<?>>> r6 = r5.zza     // Catch:{ all -> 0x0052 }
            r6.put(r0, r1)     // Catch:{ all -> 0x0052 }
            boolean r6 = com.google.android.gms.internal.ads.zzao.zzb     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x0038
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x0052 }
            r6[r3] = r0     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = "Request for cacheKey=%s is in flight, putting on hold."
            com.google.android.gms.internal.ads.zzao.zzb(r0, r6)     // Catch:{ all -> 0x0052 }
        L_0x0038:
            monitor-exit(r5)
            return r2
        L_0x003a:
            java.util.Map<java.lang.String, java.util.List<com.google.android.gms.internal.ads.zzac<?>>> r1 = r5.zza     // Catch:{ all -> 0x0052 }
            r4 = 0
            r1.put(r0, r4)     // Catch:{ all -> 0x0052 }
            r6.zzu(r5)     // Catch:{ all -> 0x0052 }
            boolean r6 = com.google.android.gms.internal.ads.zzao.zzb     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x0050
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x0052 }
            r6[r3] = r0     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = "new request, sending to network %s"
            com.google.android.gms.internal.ads.zzao.zzb(r0, r6)     // Catch:{ all -> 0x0052 }
        L_0x0050:
            monitor-exit(r5)
            return r3
        L_0x0052:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzap.zzc(com.google.android.gms.internal.ads.zzac):boolean");
    }
}
