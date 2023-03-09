package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public class MediationAdRequest {
    private final Date zza;
    private final AdRequest.Gender zzb;
    private final Set<String> zzc;
    private final boolean zzd;
    private final Location zze;

    public MediationAdRequest(Date date, AdRequest.Gender gender, Set<String> set, boolean z, Location location) {
        this.zza = date;
        this.zzb = gender;
        this.zzc = set;
        this.zzd = z;
        this.zze = location;
    }

    public Integer getAgeInYears() {
        if (this.zza == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.zza);
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        if (instance2.get(2) < instance.get(2) || (instance2.get(2) == instance.get(2) && instance2.get(5) < instance.get(5))) {
            return Integer.valueOf(valueOf.intValue() - 1);
        }
        return valueOf;
    }

    public Date getBirthday() {
        return this.zza;
    }

    public AdRequest.Gender getGender() {
        return this.zzb;
    }

    public Set<String> getKeywords() {
        return this.zzc;
    }

    public Location getLocation() {
        return this.zze;
    }

    public boolean isTesting() {
        return this.zzd;
    }
}
