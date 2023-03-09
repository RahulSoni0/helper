package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzcq<T> implements zzct<T> {
    private static final Object zza = new Object();
    private volatile zzct<T> zzb;
    private volatile Object zzc = zza;

    private zzcq(zzct<T> zzct) {
        this.zzb = zzct;
    }

    public final T zza() {
        T t = this.zzc;
        T t2 = zza;
        if (t == t2) {
            synchronized (this) {
                t = this.zzc;
                if (t == t2) {
                    t = this.zzb.zza();
                    T t3 = this.zzc;
                    if (t3 != t2 && !(t3 instanceof zzcr)) {
                        if (t3 != t) {
                            String valueOf = String.valueOf(t3);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.zzc = t;
                    this.zzb = null;
                }
            }
        }
        return t;
    }

    public static <P extends zzct<T>, T> zzct<T> zza(P p) {
        zzcu.zza(p);
        if (p instanceof zzcq) {
            return p;
        }
        return new zzcq(p);
    }
}
