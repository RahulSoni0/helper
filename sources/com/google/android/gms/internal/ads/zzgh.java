package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzgh {
    private static final char[] zza = "0123456789abcdef".toCharArray();

    public static String zza(String str) {
        if (str == null || !str.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            return str;
        }
        UUID fromString = UUID.fromString(str);
        byte[] bArr = new byte[16];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.putLong(fromString.getMostSignificantBits());
        wrap.putLong(fromString.getLeastSignificantBits());
        return zzdx.zza(bArr, true);
    }

    public static String zzb(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        zzerm.zzc(th, new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static boolean zzc(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean zzd() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean zze(DisplayMetrics displayMetrics) {
        return (displayMetrics == null || displayMetrics.density == 0.0f) ? false : true;
    }

    public static long zzf(double d, int i, DisplayMetrics displayMetrics) {
        double d2 = (double) displayMetrics.density;
        Double.isNaN(d2);
        return Math.round(d / d2);
    }

    public static Activity zzg(View view) {
        View rootView = view.getRootView();
        if (rootView != null) {
            view = rootView;
        }
        Context context = view.getContext();
        int i = 0;
        while ((context instanceof ContextWrapper) && i < 10) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
            i++;
        }
        return null;
    }
}
