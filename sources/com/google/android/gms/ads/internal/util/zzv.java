package com.google.android.gms.ads.internal.util;

import android.os.Environment;
import android.os.StatFs;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzv extends zzu {
    public boolean zzg(View view) {
        return super.zzg(view) || view.getWindowId() != null;
    }

    public final int zzh() {
        return 14;
    }

    public final long zzi() {
        return new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }
}
