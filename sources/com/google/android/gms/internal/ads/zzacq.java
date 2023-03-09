package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzacq {
    private final Date zza;
    private final String zzb;
    private final List<String> zzc;
    private final int zzd;
    private final Set<String> zze;
    private final Location zzf;
    private final Bundle zzg;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzh;
    private final String zzi;
    private final String zzj;
    @NotOnlyInitialized
    private final SearchAdRequest zzk;
    private final int zzl;
    private final Set<String> zzm;
    private final Bundle zzn;
    private final Set<String> zzo;
    private final boolean zzp;
    private final AdInfo zzq;
    private final int zzr;

    public zzacq(zzacp zzacp, SearchAdRequest searchAdRequest) {
        this.zza = zzacp.zzg;
        this.zzb = zzacp.zzh;
        this.zzc = zzacp.zzi;
        this.zzd = zzacp.zzj;
        this.zze = Collections.unmodifiableSet(zzacp.zza);
        this.zzf = zzacp.zzk;
        this.zzg = zzacp.zzb;
        this.zzh = Collections.unmodifiableMap(zzacp.zzc);
        this.zzi = zzacp.zzl;
        this.zzj = zzacp.zzm;
        this.zzk = searchAdRequest;
        this.zzl = zzacp.zzn;
        this.zzm = Collections.unmodifiableSet(zzacp.zzd);
        this.zzn = zzacp.zze;
        this.zzo = Collections.unmodifiableSet(zzacp.zzf);
        this.zzp = zzacp.zzo;
        this.zzq = zzacp.zzp;
        this.zzr = zzacp.zzq;
    }

    @Deprecated
    public final Date zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final List<String> zzc() {
        return new ArrayList(this.zzc);
    }

    @Deprecated
    public final int zzd() {
        return this.zzd;
    }

    public final Set<String> zze() {
        return this.zze;
    }

    public final Location zzf() {
        return this.zzf;
    }

    @Deprecated
    public final <T extends NetworkExtras> T zzg(Class<T> cls) {
        return (NetworkExtras) this.zzh.get(cls);
    }

    public final Bundle zzh(Class<? extends MediationExtrasReceiver> cls) {
        return this.zzg.getBundle(cls.getName());
    }

    public final Bundle zzi(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.zzg.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final String zzj() {
        return this.zzi;
    }

    public final String zzk() {
        return this.zzj;
    }

    public final SearchAdRequest zzl() {
        return this.zzk;
    }

    public final boolean zzm(Context context) {
        RequestConfiguration zzm2 = zzacy.zza().zzm();
        zzzy.zza();
        String zzt = zzbbd.zzt(context);
        return this.zzm.contains(zzt) || zzm2.getTestDeviceIds().contains(zzt);
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzn() {
        return this.zzh;
    }

    public final Bundle zzo() {
        return this.zzg;
    }

    public final int zzp() {
        return this.zzl;
    }

    public final Bundle zzq() {
        return this.zzn;
    }

    public final Set<String> zzr() {
        return this.zzo;
    }

    @Deprecated
    public final boolean zzs() {
        return this.zzp;
    }

    public final AdInfo zzt() {
        return this.zzq;
    }

    public final int zzu() {
        return this.zzr;
    }
}
