package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbji extends zzdjr {
    final /* synthetic */ zzbko zza;
    private final zzdky zzb;
    private final zzeyw<Integer> zzc;
    private final zzeyw<zzdjo> zzd;
    private final zzeyw<String> zze;
    private final zzeyw<zzdjx> zzf;
    private final zzeyw<zzdkd> zzg;
    private final zzeyw<zzdkh> zzh;
    private final zzeyw<zzdko> zzi;
    private final zzeyw<zzdkv> zzj;
    private final zzeyw<zzdlh> zzk = new zzdlj(zzdua.zza());
    private final zzeyw<String> zzl;
    private final zzeyw<zzcmr> zzm;
    private final zzeyw<zzcmr> zzn;
    private final zzeyw<zzcmr> zzo;
    private final zzeyw<zzcmr> zzp;
    private final zzeyw<Map<zzduy, zzcmr>> zzq;
    private final zzeyw<Set<zzcav<zzdvf>>> zzr;
    private final zzeyw<Set<zzcav<zzdvf>>> zzs;
    private final zzeyw zzt;
    private final zzeyw<zzdve> zzu;

    /* synthetic */ zzbji(zzbko zzbko, zzdky zzdky, zzbjd zzbjd) {
        this.zza = zzbko;
        this.zzb = zzdky;
        zzdla zzdla = new zzdla(zzdky);
        this.zzc = zzdla;
        this.zzd = new zzdjq(zzbll.zza, zzbko.zzf, zzbko.zzl, zzdua.zza(), zzdla);
        zzdkz zzdkz = new zzdkz(zzdky);
        this.zze = zzdkz;
        this.zzf = new zzdjz(zzbit.zza, zzbko.zzf, zzdkz, zzdua.zza());
        this.zzg = new zzdkf(zzbll.zza, zzdla, zzbko.zzf, zzbko.zzW, zzbko.zzl, zzdua.zza());
        this.zzh = new zzdkj(zzblf.zza, zzdua.zza(), zzbko.zzf);
        this.zzi = new zzdkq(zzblh.zza, zzdua.zza(), zzdkz);
        this.zzj = new zzdkx(zzblj.zza, zzbko.zzl, zzbko.zzf);
        zzdlb zzdlb = new zzdlb(zzdky);
        this.zzl = zzdlb;
        zzeyw<zzcmr> zza2 = zzeyk.zza(zzcmk.zza());
        this.zzm = zza2;
        zzeyw<zzcmr> zza3 = zzeyk.zza(zzcmi.zza());
        this.zzn = zza3;
        zzeyw<zzcmr> zza4 = zzeyk.zza(zzcmm.zza());
        this.zzo = zza4;
        zzeyw<zzcmr> zza5 = zzeyk.zza(zzcmo.zza());
        this.zzp = zza5;
        zzeyo zzc2 = zzeyp.zzc(4);
        zzc2.zza(zzduy.GMS_SIGNALS, zza2);
        zzc2.zza(zzduy.BUILD_URL, zza3);
        zzc2.zza(zzduy.HTTP, zza4);
        zzc2.zza(zzduy.PRE_PROCESS, zza5);
        zzeyp zzb2 = zzc2.zzb();
        this.zzq = zzb2;
        zzeyw<Set<zzcav<zzdvf>>> zza6 = zzeyk.zza(new zzcmp(zzdlb, zzbko.zzf, zzdua.zza(), zzb2));
        this.zzr = zza6;
        zzeyt zza7 = zzeyu.zza(0, 1);
        zza7.zzb(zza6);
        zzeyu zzc3 = zza7.zzc();
        this.zzs = zzc3;
        zzdvh zzdvh = new zzdvh(zzc3);
        this.zzt = zzdvh;
        this.zzu = zzeyk.zza(new zzdvg(zzdua.zza(), zzbko.zzl, zzdvh));
    }

    private final zzdks zzd() {
        zzaec zzaec = new zzaec();
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        List<String> zzd2 = this.zzb.zzd();
        zzeyr.zzb(zzd2);
        return new zzdks(zzaec, zzefx, zzd2, (List<String>) null);
    }

    private final zzdju zze() {
        zzbao zzbao = new zzbao();
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        String zzb2 = this.zzb.zzb();
        zzeyr.zzb(zzb2);
        return new zzdju(zzbao, zzefx, zzb2, this.zzb.zzc(), this.zzb.zzf(), (byte[]) null);
    }

    public final zzdjc<JSONObject> zza() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        zzbam zzbam = new zzbam();
        zzefx zzefx2 = zzbbw.zza;
        zzeyr.zzb(zzefx2);
        String zza2 = this.zzb.zza();
        zzeyr.zzb(zza2);
        zzdhs zzdhs = new zzdhs(new zzdko(zzbam, zzefx2, zza2, (byte[]) null), 0, (ScheduledExecutorService) this.zza.zzl.zzb());
        Context zza3 = this.zza.zza.zza();
        zzeyr.zzb(zza3);
        zzdhs zzdhs2 = new zzdhs(new zzdkv(new zzaun(), (ScheduledExecutorService) this.zza.zzl.zzb(), zza3, (byte[]) null), ((Long) zzaaa.zzc().zzb(zzaeq.zzcn)).longValue(), (ScheduledExecutorService) this.zza.zzl.zzb());
        zzbao zzbao = new zzbao();
        Context zza4 = this.zza.zza.zza();
        zzeyr.zzb(zza4);
        zzefx zzefx3 = zzbbw.zza;
        zzeyr.zzb(zzefx3);
        zzdhs zzdhs3 = new zzdhs(new zzdjo(zzbao, zza4, (ScheduledExecutorService) this.zza.zzl.zzb(), zzefx3, this.zzb.zzf(), (byte[]) null), 0, (ScheduledExecutorService) this.zza.zzl.zzb());
        zzefx zzefx4 = zzbbw.zza;
        zzeyr.zzb(zzefx4);
        zzdhs zzdhs4 = new zzdhs(new zzdlh(zzefx4), 0, (ScheduledExecutorService) this.zza.zzl.zzb());
        zzdiz<? extends zzdiy<JSONObject>> zza5 = zzdle.zza();
        Context zza6 = this.zza.zza.zza();
        zzeyr.zzb(zza6);
        String zza7 = this.zzb.zza();
        zzeyr.zzb(zza7);
        zzefx zzefx5 = zzbbw.zza;
        zzeyr.zzb(zzefx5);
        zzdjx zzdjx = new zzdjx((zzawe) null, zza6, zza7, zzefx5);
        zztv zztv = new zztv();
        zzefx zzefx6 = zzbbw.zza;
        zzeyr.zzb(zzefx6);
        Context zza8 = this.zza.zza.zza();
        zzeyr.zzb(zza8);
        zzbao zzbao2 = new zzbao();
        int zzf2 = this.zzb.zzf();
        Context zza9 = this.zza.zza.zza();
        zzeyr.zzb(zza9);
        zzefx zzefx7 = zzbbw.zza;
        zzeyr.zzb(zzefx7);
        return new zzdjc<>(zzefx, zzedi.zzi(zzdhs, zzdhs2, zzdhs3, zzdhs4, zza5, zzdjx, new zzdkh(zztv, zzefx6, zza8, (byte[]) null), zzd(), zze(), new zzdkd(zzbao2, zzf2, zza9, (zzbav) this.zza.zzW.zzb(), (ScheduledExecutorService) this.zza.zzl.zzb(), zzefx7, (byte[]) null), (zzdiz) this.zza.zzau.zzb()));
    }

    public final zzdjc<JSONObject> zzb() {
        zzbam zzbam = new zzbam();
        Object zzb2 = this.zza.zzau.zzb();
        zzdju zze2 = zze();
        zzdks zzd2 = zzd();
        zzeyf<zzdjo> zzc2 = zzeyk.zzc(this.zzd);
        zzeyf<zzdjx> zzc3 = zzeyk.zzc(this.zzf);
        zzeyf<zzdkd> zzc4 = zzeyk.zzc(this.zzg);
        zzeyf<zzdkh> zzc5 = zzeyk.zzc(this.zzh);
        zzeyf<zzdko> zzc6 = zzeyk.zzc(this.zzi);
        zzeyf<zzdkv> zzc7 = zzeyk.zzc(this.zzj);
        zzeyf<zzdlh> zzc8 = zzeyk.zzc(this.zzk);
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return zzdlf.zza(zzbam, zzb2, zze2, zzd2, zzc2, zzc3, zzc4, zzc5, zzc6, zzc7, zzc8, zzefx, (ScheduledExecutorService) this.zza.zzl.zzb());
    }

    public final zzdve zzc() {
        return this.zzu.zzb();
    }
}
