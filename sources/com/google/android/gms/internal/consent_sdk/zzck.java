package com.google.android.gms.internal.consent_sdk;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
final class zzck extends WeakReference<Throwable> {
    private final int zza;

    public zzck(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.zza = System.identityHashCode(th);
    }

    public final int hashCode() {
        return this.zza;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            zzck zzck = (zzck) obj;
            return this.zza == zzck.zza && get() == zzck.get();
        }
    }
}
