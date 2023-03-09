package com.google.android.gms.internal.ads;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzecu {
    @NullableDecl
    private static final Object zza;
    @NullableDecl
    private static final Method zzb;
    @NullableDecl
    private static final Method zzc;

    static {
        Method method;
        Object zzc2 = zzc();
        zza = zzc2;
        Method method2 = null;
        if (zzc2 == null) {
            method = null;
        } else {
            method = zze("getStackTraceElement", Throwable.class, Integer.TYPE);
        }
        zzb = method;
        if (zzc2 != null) {
            method2 = zzd();
        }
        zzc = method2;
    }

    public static void zza(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        }
    }

    public static String zzb(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        zzerm.zzc(th, new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @NullableDecl
    private static Object zzc() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, (ClassLoader) null).getMethod("getJavaLangAccess", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    @NullableDecl
    private static Method zzd() {
        try {
            Method zze = zze("getStackTraceDepth", Throwable.class);
            if (zze == null) {
                return null;
            }
            zze.invoke(zzc(), new Object[]{new Throwable()});
            return zze;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    @NullableDecl
    private static Method zze(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, (ClassLoader) null).getMethod(str, clsArr);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }
}
