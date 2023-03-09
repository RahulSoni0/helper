package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzacp {
    /* access modifiers changed from: private */
    public final HashSet<String> zza = new HashSet<>();
    /* access modifiers changed from: private */
    public final Bundle zzb = new Bundle();
    /* access modifiers changed from: private */
    public final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzc = new HashMap<>();
    /* access modifiers changed from: private */
    public final HashSet<String> zzd = new HashSet<>();
    /* access modifiers changed from: private */
    public final Bundle zze = new Bundle();
    /* access modifiers changed from: private */
    public final HashSet<String> zzf = new HashSet<>();
    /* access modifiers changed from: private */
    public Date zzg;
    /* access modifiers changed from: private */
    public String zzh;
    /* access modifiers changed from: private */
    public final List<String> zzi = new ArrayList();
    /* access modifiers changed from: private */
    public int zzj = -1;
    /* access modifiers changed from: private */
    public Location zzk;
    /* access modifiers changed from: private */
    public String zzl;
    /* access modifiers changed from: private */
    public String zzm;
    /* access modifiers changed from: private */
    public int zzn = -1;
    /* access modifiers changed from: private */
    public boolean zzo;
    /* access modifiers changed from: private */
    public AdInfo zzp;
    /* access modifiers changed from: private */
    public int zzq = 60000;

    public final void zza(String str) {
        this.zza.add(str);
    }

    @Deprecated
    public final void zzb(NetworkExtras networkExtras) {
        if (networkExtras instanceof AdMobExtras) {
            zzc(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
        } else {
            this.zzc.put(networkExtras.getClass(), networkExtras);
        }
    }

    public final void zzc(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
        this.zzb.putBundle(cls.getName(), bundle);
    }

    public final void zzd(Class<? extends CustomEvent> cls, Bundle bundle) {
        if (this.zzb.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.zzb.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        Bundle bundle2 = this.zzb.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        Preconditions.checkNotNull(bundle2);
        bundle2.putBundle(cls.getName(), bundle);
    }

    public final void zze(String str) {
        this.zzd.add(str);
    }

    public final void zzf(String str) {
        this.zzd.remove("B3EEABB8EE11C2BE770B684D95219ECB");
    }

    @Deprecated
    public final void zzg(Date date) {
        this.zzg = date;
    }

    public final void zzh(String str) {
        this.zzh = str;
    }

    public final void zzi(List<String> list) {
        this.zzi.clear();
        for (String next : list) {
            if (TextUtils.isEmpty(next)) {
                zzbbk.zzi("neighboring content URL should not be null or empty");
            } else {
                this.zzi.add(next);
            }
        }
    }

    @Deprecated
    public final void zzj(int i) {
        this.zzj = i;
    }

    public final void zzk(Location location) {
        this.zzk = location;
    }

    public final void zzl(String str) {
        this.zzl = str;
    }

    public final void zzm(String str) {
        this.zzm = str;
    }

    @Deprecated
    public final void zzn(boolean z) {
        this.zzn = z ? 1 : 0;
    }

    public final void zzo(String str, String str2) {
        this.zze.putString(str, str2);
    }

    public final void zzp(String str) {
        this.zzf.add(str);
    }

    @Deprecated
    public final void zzq(boolean z) {
        this.zzo = z;
    }

    public final void zzr(AdInfo adInfo) {
        this.zzp = adInfo;
    }

    public final void zzs(int i) {
        this.zzq = i;
    }
}
