package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
abstract class zzi extends zzx {
    private final int zza;

    protected zzi(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 25);
        this.zza = Arrays.hashCode(bArr);
    }

    protected static byte[] zzf(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        IObjectWrapper zzd;
        if (obj != null && (obj instanceof zzy)) {
            try {
                zzy zzy = (zzy) obj;
                if (zzy.zze() != this.zza || (zzd = zzy.zzd()) == null) {
                    return false;
                }
                return Arrays.equals(zzc(), (byte[]) ObjectWrapper.unwrap(zzd));
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] zzc();

    public final IObjectWrapper zzd() {
        return ObjectWrapper.wrap(zzc());
    }

    public final int zze() {
        return this.zza;
    }
}
