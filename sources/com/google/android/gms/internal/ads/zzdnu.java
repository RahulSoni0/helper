package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdnu {
    public static <T> void zza(AtomicReference<T> atomicReference, zzdnt<T> zzdnt) {
        T t = atomicReference.get();
        if (t != null) {
            try {
                zzdnt.zza(t);
            } catch (RemoteException e) {
                zze.zzl("#007 Could not call remote method.", e);
            } catch (NullPointerException e2) {
                zze.zzj("NullPointerException occurs when invoking a method from a delegating listener.", e2);
            }
        }
    }
}
