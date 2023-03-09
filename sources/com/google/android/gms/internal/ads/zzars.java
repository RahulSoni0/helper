package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzars {
    public static int zza(AdRequest.ErrorCode errorCode) {
        AdRequest.ErrorCode errorCode2 = AdRequest.ErrorCode.INVALID_REQUEST;
        AdRequest.Gender gender = AdRequest.Gender.UNKNOWN;
        int ordinal = errorCode.ordinal();
        if (ordinal == 0) {
            return 1;
        }
        if (ordinal != 1) {
            return ordinal != 2 ? 0 : 2;
        }
        return 3;
    }

    public static MediationAdRequest zzb(zzys zzys, boolean z) {
        AdRequest.Gender gender;
        List<String> list = zzys.zze;
        HashSet hashSet = list != null ? new HashSet(list) : null;
        Date date = new Date(zzys.zzb);
        int i = zzys.zzd;
        if (i == 1) {
            gender = AdRequest.Gender.MALE;
        } else if (i != 2) {
            gender = AdRequest.Gender.UNKNOWN;
        } else {
            gender = AdRequest.Gender.FEMALE;
        }
        return new MediationAdRequest(date, gender, hashSet, z, zzys.zzk);
    }
}
