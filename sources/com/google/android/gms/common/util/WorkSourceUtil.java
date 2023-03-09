package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class WorkSourceUtil {
    private static final int zza = Process.myUid();
    private static final Method zzb;
    private static final Method zzc;
    private static final Method zzd;
    private static final Method zze;
    private static final Method zzf;
    private static final Method zzg;
    private static final Method zzh;

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c A[SYNTHETIC, Splitter:B:23:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0090  */
    static {
        /*
            java.lang.String r0 = "add"
            int r1 = android.os.Process.myUid()
            zza = r1
            r1 = 1
            r2 = 0
            r3 = 0
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0018 }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0018 }
            r4[r2] = r5     // Catch:{ Exception -> 0x0018 }
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            java.lang.reflect.Method r4 = r5.getMethod(r0, r4)     // Catch:{ Exception -> 0x0018 }
            goto L_0x0019
        L_0x0018:
            r4 = r3
        L_0x0019:
            zzb = r4
            boolean r4 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            r5 = 2
            if (r4 == 0) goto L_0x0033
            java.lang.Class[] r4 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x0033 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0033 }
            r4[r2] = r6     // Catch:{ Exception -> 0x0033 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r4[r1] = r6     // Catch:{ Exception -> 0x0033 }
            java.lang.Class<android.os.WorkSource> r6 = android.os.WorkSource.class
            java.lang.reflect.Method r0 = r6.getMethod(r0, r4)     // Catch:{ Exception -> 0x0033 }
            goto L_0x0034
        L_0x0033:
            r0 = r3
        L_0x0034:
            zzc = r0
            java.lang.Class<android.os.WorkSource> r0 = android.os.WorkSource.class
            java.lang.String r4 = "size"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0041 }
            java.lang.reflect.Method r0 = r0.getMethod(r4, r6)     // Catch:{ Exception -> 0x0041 }
            goto L_0x0042
        L_0x0041:
            r0 = r3
        L_0x0042:
            zzd = r0
            java.lang.Class[] r0 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0053 }
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0053 }
            r0[r2] = r4     // Catch:{ Exception -> 0x0053 }
            java.lang.Class<android.os.WorkSource> r4 = android.os.WorkSource.class
            java.lang.String r6 = "get"
            java.lang.reflect.Method r0 = r4.getMethod(r6, r0)     // Catch:{ Exception -> 0x0053 }
            goto L_0x0054
        L_0x0053:
            r0 = r3
        L_0x0054:
            zze = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            if (r0 == 0) goto L_0x006b
            java.lang.Class[] r0 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x006b }
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x006b }
            r0[r2] = r4     // Catch:{ Exception -> 0x006b }
            java.lang.Class<android.os.WorkSource> r4 = android.os.WorkSource.class
            java.lang.String r6 = "getName"
            java.lang.reflect.Method r0 = r4.getMethod(r6, r0)     // Catch:{ Exception -> 0x006b }
            goto L_0x006c
        L_0x006b:
            r0 = r3
        L_0x006c:
            zzf = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            java.lang.String r4 = "WorkSourceUtil"
            if (r0 == 0) goto L_0x0087
            java.lang.Class<android.os.WorkSource> r0 = android.os.WorkSource.class
            java.lang.String r6 = "createWorkChain"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0081 }
            java.lang.reflect.Method r0 = r0.getMethod(r6, r7)     // Catch:{ Exception -> 0x0081 }
            goto L_0x0088
        L_0x0081:
            r0 = move-exception
            java.lang.String r6 = "Missing WorkChain API createWorkChain"
            android.util.Log.w(r4, r6, r0)
        L_0x0087:
            r0 = r3
        L_0x0088:
            zzg = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r0 == 0) goto L_0x00ad
            java.lang.String r0 = "android.os.WorkSource$WorkChain"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x00a7 }
            java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x00a7 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x00a7 }
            r5[r2] = r6     // Catch:{ Exception -> 0x00a7 }
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            r5[r1] = r2     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r1 = "addNode"
            java.lang.reflect.Method r3 = r0.getMethod(r1, r5)     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00ad
        L_0x00a7:
            r0 = move-exception
            java.lang.String r1 = "Missing WorkChain class"
            android.util.Log.w(r4, r1, r0)
        L_0x00ad:
            zzh = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.<clinit>():void");
    }

    private WorkSourceUtil() {
    }

    public static WorkSource fromPackage(Context context, String str) {
        if (!(context == null || context.getPackageManager() == null || str == null)) {
            try {
                ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
                if (applicationInfo == null) {
                    Log.e("WorkSourceUtil", str.length() != 0 ? "Could not get applicationInfo from package: ".concat(str) : new String("Could not get applicationInfo from package: "));
                    return null;
                }
                int i = applicationInfo.uid;
                WorkSource workSource = new WorkSource();
                zza(workSource, i, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", str.length() != 0 ? "Could not find package: ".concat(str) : new String("Could not find package: "));
            }
        }
        return null;
    }

    public static WorkSource fromPackageAndModuleExperimentalPi(Context context, String str, String str2) {
        Method method;
        if (context == null || context.getPackageManager() == null || str2 == null || str == null) {
            Log.w("WorkSourceUtil", "Unexpected null arguments");
            return null;
        }
        int i = -1;
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
            if (applicationInfo == null) {
                Log.e("WorkSourceUtil", str.length() != 0 ? "Could not get applicationInfo from package: ".concat(str) : new String("Could not get applicationInfo from package: "));
            } else {
                i = applicationInfo.uid;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("WorkSourceUtil", str.length() != 0 ? "Could not find package: ".concat(str) : new String("Could not find package: "));
        }
        if (i < 0) {
            return null;
        }
        WorkSource workSource = new WorkSource();
        Method method2 = zzg;
        if (method2 == null || (method = zzh) == null) {
            zza(workSource, i, str);
        } else {
            try {
                Object invoke = method2.invoke(workSource, new Object[0]);
                int i2 = zza;
                if (i != i2) {
                    method.invoke(invoke, new Object[]{Integer.valueOf(i), str});
                }
                method.invoke(invoke, new Object[]{Integer.valueOf(i2), str2});
            } catch (Exception e) {
                Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", e);
            }
        }
        return workSource;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String> getNames(android.os.WorkSource r10) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r1 = "Unable to assign blame through WorkSource"
            java.lang.String r2 = "WorkSourceUtil"
            r3 = 0
            if (r10 != 0) goto L_0x000e
        L_0x000c:
            r4 = 0
            goto L_0x0027
        L_0x000e:
            java.lang.reflect.Method r4 = zzd
            if (r4 == 0) goto L_0x000c
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0022 }
            java.lang.Object r4 = r4.invoke(r10, r5)     // Catch:{ Exception -> 0x0022 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ Exception -> 0x0022 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ Exception -> 0x0022 }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x0022 }
            goto L_0x0027
        L_0x0022:
            r4 = move-exception
            android.util.Log.wtf(r2, r1, r4)
            goto L_0x000c
        L_0x0027:
            if (r4 == 0) goto L_0x0055
            r5 = 0
        L_0x002a:
            if (r5 >= r4) goto L_0x0055
            java.lang.reflect.Method r6 = zzf
            r7 = 0
            if (r6 == 0) goto L_0x0046
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0042 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0042 }
            r8[r3] = r9     // Catch:{ Exception -> 0x0042 }
            java.lang.Object r6 = r6.invoke(r10, r8)     // Catch:{ Exception -> 0x0042 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0042 }
            r7 = r6
            goto L_0x0046
        L_0x0042:
            r6 = move-exception
            android.util.Log.wtf(r2, r1, r6)
        L_0x0046:
            boolean r6 = com.google.android.gms.common.util.Strings.isEmptyOrWhitespace(r7)
            if (r6 != 0) goto L_0x0052
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)
            r0.add(r7)
        L_0x0052:
            int r5 = r5 + 1
            goto L_0x002a
        L_0x0055:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.getNames(android.os.WorkSource):java.util.List");
    }

    public static boolean hasWorkSourcePermission(Context context) {
        if (context == null || context.getPackageManager() == null || Wrappers.packageManager(context).checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static void zza(WorkSource workSource, int i, String str) {
        Method method = zzc;
        if (method != null) {
            try {
                method.invoke(workSource, new Object[]{Integer.valueOf(i), str});
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        } else {
            Method method2 = zzb;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, new Object[]{Integer.valueOf(i)});
                } catch (Exception e2) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                }
            }
        }
    }
}
