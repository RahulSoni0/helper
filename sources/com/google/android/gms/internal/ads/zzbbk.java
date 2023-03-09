package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.ads.AdRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public class zzbbk {
    public static void zzd(String str) {
        if (zzm(3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
    }

    public static void zze(String str, Throwable th) {
        if (zzm(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    public static void zzf(String str) {
        if (zzm(6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    public static void zzg(String str, Throwable th) {
        if (zzm(6)) {
            Log.e(AdRequest.LOGTAG, str, th);
        }
    }

    public static void zzh(String str) {
        if (zzm(4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    public static void zzi(String str) {
        if (zzm(5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
    }

    public static void zzj(String str, Throwable th) {
        if (zzm(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }

    static String zzk(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4) {
            return str;
        }
        int lineNumber = stackTrace[3].getLineNumber();
        StringBuilder sb = new StringBuilder(str.length() + 13);
        sb.append(str);
        sb.append(" @");
        sb.append(lineNumber);
        return sb.toString();
    }

    public static void zzl(String str, Throwable th) {
        if (!zzm(5)) {
            return;
        }
        if (th != null) {
            zzj(zzk(str), th);
        } else {
            zzi(zzk(str));
        }
    }

    public static boolean zzm(int i) {
        return i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i);
    }
}
