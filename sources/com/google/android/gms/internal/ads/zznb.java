package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zznb extends zznf {
    public static final Parcelable.Creator<zznb> CREATOR = new zzna();
    public final String zza;
    public final String zzb;
    public final int zzc;
    public final byte[] zzd;

    zznb(Parcel parcel) {
        super("APIC");
        this.zza = parcel.readString();
        this.zzb = parcel.readString();
        this.zzc = parcel.readInt();
        this.zzd = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zznb zznb = (zznb) obj;
            return this.zzc == zznb.zzc && zzqj.zza(this.zza, zznb.zza) && zzqj.zza(this.zzb, zznb.zzb) && Arrays.equals(this.zzd, zznb.zzd);
        }
    }

    public final int hashCode() {
        int i = (this.zzc + MetaDo.META_OFFSETWINDOWORG) * 31;
        String str = this.zza;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.zzb;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((hashCode + i2) * 31) + Arrays.hashCode(this.zzd);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public zznb(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.zza = str;
        this.zzb = null;
        this.zzc = 3;
        this.zzd = bArr;
    }
}
