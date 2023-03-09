package com.google.android.gms.internal.ads;

import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzebl extends zzebe {
    private zzect<Integer> zza;
    private zzect<Integer> zzb;
    private zzebk zzc = null;
    private HttpURLConnection zzd;

    zzebl() {
        zzect<Integer> zzect = zzebg.zza;
        zzect<Integer> zzect2 = zzebh.zza;
        this.zza = zzect;
        this.zzb = zzect2;
    }

    public final void close() {
        HttpURLConnection httpURLConnection = this.zzd;
        zzebf.zzb();
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public final HttpURLConnection zzb(zzebk zzebk, int i, int i2) throws IOException {
        this.zza = new zzebi(TIFFConstants.TIFFTAG_CELLLENGTH);
        this.zzb = new zzebj(-1);
        this.zzc = zzebk;
        zzebf.zza(this.zza.zza().intValue(), this.zzb.zza().intValue());
        zzebk zzebk2 = this.zzc;
        Objects.requireNonNull(zzebk2);
        HttpURLConnection httpURLConnection = (HttpURLConnection) zzebk2.zza();
        this.zzd = httpURLConnection;
        return httpURLConnection;
    }
}
