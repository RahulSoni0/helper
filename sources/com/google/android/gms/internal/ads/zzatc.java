package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.C0930R;
import com.google.android.gms.ads.internal.zzs;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzatc extends zzatk {
    private final Map<String, String> zza;
    /* access modifiers changed from: private */
    public final Context zzb;
    private final String zzc = zzd("description");
    private final long zzd = zze("start_ticks");
    private final long zze = zze("end_ticks");
    private final String zzf = zzd("summary");
    private final String zzg = zzd("location");

    public zzatc(zzbgf zzbgf, Map<String, String> map) {
        super(zzbgf, "createCalendarEvent");
        this.zza = map;
        this.zzb = zzbgf.zzj();
    }

    private final String zzd(String str) {
        return TextUtils.isEmpty(this.zza.get(str)) ? "" : this.zza.get(str);
    }

    private final long zze(String str) {
        String str2 = this.zza.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final void zza() {
        if (this.zzb == null) {
            zzf("Activity context is not available.");
            return;
        }
        zzs.zzc();
        if (!new zzaeb(this.zzb).zzb()) {
            zzf("This feature is not available on the device.");
            return;
        }
        zzs.zzc();
        AlertDialog.Builder builder = new AlertDialog.Builder(this.zzb);
        Resources zzf2 = zzs.zzg().zzf();
        builder.setTitle(zzf2 != null ? zzf2.getString(C0930R.string.f124s5) : "Create calendar event");
        builder.setMessage(zzf2 != null ? zzf2.getString(C0930R.string.f125s6) : "Allow Ad to create a calendar event?");
        builder.setPositiveButton(zzf2 != null ? zzf2.getString(C0930R.string.f122s3) : "Accept", new zzata(this));
        builder.setNegativeButton(zzf2 != null ? zzf2.getString(C0930R.string.f123s4) : "Decline", new zzatb(this));
        builder.create().show();
    }

    /* access modifiers changed from: package-private */
    public final Intent zzb() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzc);
        data.putExtra("eventLocation", this.zzg);
        data.putExtra("description", this.zzf);
        long j = this.zzd;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.zze;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(268435456);
        return data;
    }
}
