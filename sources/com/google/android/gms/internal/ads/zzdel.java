package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.util.ArrayList;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdel implements zzdiy<Bundle> {
    public final zzyx zza;
    public final String zzb;
    public final boolean zzc;
    public final String zzd;
    public final float zze;
    public final int zzf;
    public final int zzg;
    public final String zzh;
    public final boolean zzi;

    public zzdel(zzyx zzyx, String str, boolean z, String str2, float f, int i, int i2, String str3, boolean z2) {
        Preconditions.checkNotNull(zzyx, "the adSize must not be null");
        this.zza = zzyx;
        this.zzb = str;
        this.zzc = z;
        this.zzd = str2;
        this.zze = f;
        this.zzf = i;
        this.zzg = i2;
        this.zzh = str3;
        this.zzi = z2;
    }

    public final /* bridge */ /* synthetic */ void zzd(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzdrs.zzb(bundle, "smart_w", "full", this.zza.zze == -1);
        zzdrs.zzb(bundle, "smart_h", DebugKt.DEBUG_PROPERTY_VALUE_AUTO, this.zza.zzb == -2);
        zzdrs.zzd(bundle, "ene", true, this.zza.zzj);
        zzdrs.zzb(bundle, "rafmt", "102", this.zza.zzm);
        zzdrs.zzb(bundle, "rafmt", "103", this.zza.zzn);
        zzdrs.zzb(bundle, "rafmt", "105", this.zza.zzo);
        zzdrs.zzd(bundle, "inline_adaptive_slot", true, this.zzi);
        zzdrs.zzd(bundle, "interscroller_slot", true, this.zza.zzo);
        zzdrs.zze(bundle, DublinCoreProperties.FORMAT, this.zzb);
        zzdrs.zzb(bundle, "fluid", HtmlTags.HEIGHT, this.zzc);
        String str = this.zzd;
        zzdrs.zzb(bundle, "sz", str, !TextUtils.isEmpty(str));
        bundle.putFloat("u_sd", this.zze);
        bundle.putInt("sw", this.zzf);
        bundle.putInt("sh", this.zzg);
        String str2 = this.zzh;
        zzdrs.zzb(bundle, "sc", str2, true ^ TextUtils.isEmpty(str2));
        ArrayList arrayList = new ArrayList();
        zzyx[] zzyxArr = this.zza.zzg;
        if (zzyxArr == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt(HtmlTags.HEIGHT, this.zza.zzb);
            bundle2.putInt(HtmlTags.WIDTH, this.zza.zze);
            bundle2.putBoolean("is_fluid_height", this.zza.zzi);
            arrayList.add(bundle2);
        } else {
            for (zzyx zzyx : zzyxArr) {
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("is_fluid_height", zzyx.zzi);
                bundle3.putInt(HtmlTags.HEIGHT, zzyx.zzb);
                bundle3.putInt(HtmlTags.WIDTH, zzyx.zze);
                arrayList.add(bundle3);
            }
        }
        bundle.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
