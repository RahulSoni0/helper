package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zznd extends zznf {
    public static final Parcelable.Creator<zznd> CREATOR = new zznc();
    public final String zza;
    public final String zzb;
    public final String zzc;

    zznd(Parcel parcel) {
        super("COMM");
        this.zza = parcel.readString();
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zznd zznd = (zznd) obj;
            return zzqj.zza(this.zzb, zznd.zzb) && zzqj.zza(this.zza, zznd.zza) && zzqj.zza(this.zzc, zznd.zzc);
        }
    }

    public final int hashCode() {
        String str = this.zza;
        int i = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + MetaDo.META_OFFSETWINDOWORG) * 31;
        String str2 = this.zzb;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.zzc;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zze);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzc);
    }

    public zznd(String str, String str2, String str3) {
        super("COMM");
        this.zza = "und";
        this.zzb = str2;
        this.zzc = str3;
    }
}
