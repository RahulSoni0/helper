package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.internal.C0971bz;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.play.core.assetpacks.au */
final class C1571au {

    /* renamed from: a */
    private static final C0944ag f500a = new C0944ag("AssetPackStorage");

    /* renamed from: b */
    private static final long f501b = TimeUnit.DAYS.toMillis(14);

    /* renamed from: c */
    private static final long f502c = TimeUnit.DAYS.toMillis(28);

    /* renamed from: d */
    private final Context f503d;

    /* renamed from: e */
    private final C1626cv f504e;

    C1571au(Context context, C1626cv cvVar) {
        this.f503d = context;
        this.f504e = cvVar;
    }

    /* renamed from: D */
    private final File m429D(String str, int i) {
        return new File(m430E(str), String.valueOf(i));
    }

    /* renamed from: E */
    private final File m430E(String str) {
        return new File(m440O(), str);
    }

    /* renamed from: F */
    private final File m431F(String str, int i, long j) {
        return new File(mo30722j(str, i, j), "merge.tmp");
    }

    /* renamed from: G */
    private static void m432G(File file) {
        if (file.listFiles() != null && file.listFiles().length > 1) {
            long J = m435J(file);
            for (File file2 : file.listFiles()) {
                if (!file2.getName().equals(String.valueOf(J)) && !file2.getName().equals("stale.tmp")) {
                    m441P(file2);
                }
            }
        }
    }

    /* renamed from: H */
    private static long m433H(File file) {
        return m434I(file, true);
    }

    /* renamed from: I */
    private static long m434I(File file, boolean z) {
        if (!file.exists()) {
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        if (z && file.listFiles().length > 1) {
            f500a.mo17058e("Multiple pack versions found, using highest version code.", new Object[0]);
        }
        try {
            for (File file2 : file.listFiles()) {
                if (!file2.getName().equals("stale.tmp")) {
                    arrayList.add(Long.valueOf(file2.getName()));
                }
            }
        } catch (NumberFormatException e) {
            f500a.mo17056c(e, "Corrupt asset pack directories.", new Object[0]);
        }
        if (arrayList.isEmpty()) {
            return -1;
        }
        Collections.sort(arrayList);
        return ((Long) arrayList.get(arrayList.size() - 1)).longValue();
    }

    /* renamed from: J */
    private static long m435J(File file) {
        return m434I(file, false);
    }

    /* renamed from: K */
    private static List<String> m436K(PackageInfo packageInfo, String str) {
        ArrayList arrayList = new ArrayList();
        if (packageInfo.splitNames == null) {
            return arrayList;
        }
        int i = (-Arrays.binarySearch(packageInfo.splitNames, str)) - 1;
        while (i < packageInfo.splitNames.length && packageInfo.splitNames[i].startsWith(str)) {
            arrayList.add(packageInfo.applicationInfo.splitSourceDirs[i]);
            i++;
        }
        return arrayList;
    }

    /* renamed from: L */
    private final List<File> m437L() {
        ArrayList arrayList = new ArrayList();
        try {
            if (m440O().exists()) {
                if (m440O().listFiles() != null) {
                    for (File file : m440O().listFiles()) {
                        if (!file.getCanonicalPath().equals(m439N().getCanonicalPath())) {
                            arrayList.add(file);
                        }
                    }
                    return arrayList;
                }
            }
            return arrayList;
        } catch (IOException e) {
            f500a.mo17055b("Could not process directory while scanning installed packs. %s", e);
        }
    }

    /* renamed from: M */
    private final File m438M(String str, int i, long j) {
        return new File(new File(new File(m439N(), str), String.valueOf(i)), String.valueOf(j));
    }

    /* renamed from: N */
    private final File m439N() {
        return new File(m440O(), "_tmp");
    }

    /* renamed from: O */
    private final File m440O() {
        return new File(this.f503d.getFilesDir(), "assetpacks");
    }

    /* renamed from: P */
    private static boolean m441P(File file) {
        boolean z;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            z = true;
            for (File P : listFiles) {
                z &= m441P(P);
            }
        } else {
            z = true;
        }
        return file.delete() && true == z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public final void mo30710A(List<String> list) {
        int a = this.f504e.mo30818a();
        for (File next : m437L()) {
            if (!list.contains(next.getName()) && m433H(next) != ((long) a)) {
                m441P(next);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public final void mo30711B(String str, int i, long j) {
        if (m438M(str, i, j).exists()) {
            m441P(m438M(str, i, j));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: C */
    public final void mo30712C(String str, int i, long j) {
        if (mo30718f(str, i, j).exists()) {
            m441P(mo30718f(str, i, j));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo30713a(String str) {
        try {
            return mo30717e(str) != null;
        } catch (IOException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final Map<String, AssetPackLocation> mo30714b() {
        HashMap hashMap = new HashMap();
        try {
            for (File next : m437L()) {
                AssetPackLocation d = mo30716d(next.getName());
                if (d != null) {
                    hashMap.put(next.getName(), d);
                }
            }
        } catch (IOException e) {
            f500a.mo17055b("Could not process directory while scanning installed packs: %s", e);
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final Map<String, Long> mo30715c() {
        HashMap hashMap = new HashMap();
        for (String next : mo30714b().keySet()) {
            hashMap.put(next, Long.valueOf(mo30733u(next)));
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final AssetPackLocation mo30716d(String str) throws IOException {
        String e = mo30717e(str);
        if (e == null) {
            return null;
        }
        File file = new File(e, "assets");
        if (file.isDirectory()) {
            return AssetPackLocation.m353b(e, file.getCanonicalPath());
        }
        f500a.mo17055b("Failed to find assets directory: %s", file);
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final String mo30717e(String str) throws IOException {
        int length;
        File file = new File(m440O(), str);
        if (!file.exists()) {
            f500a.mo17054a("Pack not found with pack name: %s", str);
            return null;
        }
        File file2 = new File(file, String.valueOf(this.f504e.mo30818a()));
        if (!file2.exists()) {
            f500a.mo17054a("Pack not found with pack name: %s app version: %s", str, Integer.valueOf(this.f504e.mo30818a()));
            return null;
        }
        File[] listFiles = file2.listFiles();
        if (listFiles == null || (length = listFiles.length) == 0) {
            f500a.mo17054a("No pack version found for pack name: %s app version: %s", str, Integer.valueOf(this.f504e.mo30818a()));
            return null;
        } else if (length <= 1) {
            return listFiles[0].getCanonicalPath();
        } else {
            f500a.mo17055b("Multiple pack versions found for pack name: %s app version: %s", str, Integer.valueOf(this.f504e.mo30818a()));
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final File mo30718f(String str, int i, long j) {
        return new File(m429D(str, i), String.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final File mo30719g(String str, int i, long j) {
        return new File(mo30718f(str, i, j), "_metadata");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final File mo30720h(String str, int i, long j, String str2) {
        return new File(new File(new File(m438M(str, i, j), "_slices"), "_unverified"), str2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final File mo30721i(String str, int i, long j, String str2) {
        return new File(new File(new File(m438M(str, i, j), "_slices"), "_verified"), str2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final File mo30722j(String str, int i, long j) {
        return new File(m438M(str, i, j), "_packs");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public final int mo30723k(String str, int i, long j) throws IOException {
        File F = m431F(str, i, j);
        if (!F.exists()) {
            return 0;
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(F);
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("numberOfMerges") != null) {
                try {
                    return Integer.parseInt(properties.getProperty("numberOfMerges"));
                } catch (NumberFormatException e) {
                    throw new C1588bk("Merge checkpoint file corrupt.", (Exception) e);
                }
            } else {
                throw new C1588bk("Merge checkpoint file corrupt.");
            }
        } catch (Throwable th) {
            C0971bz.m125a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final void mo30724l(String str, int i, long j, int i2) throws IOException {
        File F = m431F(str, i, j);
        Properties properties = new Properties();
        properties.put("numberOfMerges", String.valueOf(i2));
        F.getParentFile().mkdirs();
        F.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(F);
        properties.store(fileOutputStream, (String) null);
        fileOutputStream.close();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final File mo30725m(String str, int i, long j, String str2) {
        return new File(mo30727o(str, i, j, str2), "checkpoint.dat");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public final File mo30726n(String str, int i, long j, String str2) {
        return new File(mo30727o(str, i, j, str2), "checkpoint_ext.dat");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public final File mo30727o(String str, int i, long j, String str2) {
        return new File(mo30728p(str, i, j), str2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public final File mo30728p(String str, int i, long j) {
        return new File(new File(m438M(str, i, j), "_slices"), "_metadata");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public final boolean mo30729q(String str) {
        if (!m430E(str).exists()) {
            return true;
        }
        return m441P(m430E(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public final void mo30730r(String str, int i, long j) {
        File E = m430E(str);
        if (E.exists()) {
            for (File file : E.listFiles()) {
                if (!file.getName().equals(String.valueOf(i)) && !file.getName().equals("stale.tmp")) {
                    m441P(file);
                } else if (file.getName().equals(String.valueOf(i))) {
                    for (File file2 : file.listFiles()) {
                        if (!file2.getName().equals(String.valueOf(j))) {
                            m441P(file2);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public final void mo30731s() {
        for (File next : m437L()) {
            if (next.listFiles() != null) {
                m432G(next);
                long J = m435J(next);
                if (((long) this.f504e.mo30818a()) != J) {
                    try {
                        new File(new File(next, String.valueOf(J)), "stale.tmp").createNewFile();
                    } catch (IOException unused) {
                        f500a.mo17055b("Could not write staleness marker.", new Object[0]);
                    }
                }
                for (File G : next.listFiles()) {
                    m432G(G);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public final int mo30732t(String str) {
        return (int) m433H(m430E(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public final long mo30733u(String str) {
        return m433H(m429D(str, mo30732t(str)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public final void mo30734v() {
        for (File next : m437L()) {
            if (next.listFiles() != null) {
                for (File file : next.listFiles()) {
                    File file2 = new File(file, "stale.tmp");
                    if (file2.exists() && System.currentTimeMillis() - file2.lastModified() > f502c) {
                        m441P(file);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: w */
    public final void mo30735w() {
        if (m439N().exists()) {
            for (File file : m439N().listFiles()) {
                if (System.currentTimeMillis() - file.lastModified() > f501b) {
                    m441P(file);
                } else {
                    m432G(file);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public final void mo30736x() {
        m441P(m440O());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0073  */
    /* renamed from: y */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.play.core.assetpacks.AssetLocation mo30737y(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            android.content.Context r2 = r8.f503d     // Catch:{ NameNotFoundException -> 0x0013 }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0013 }
            android.content.Context r3 = r8.f503d     // Catch:{ NameNotFoundException -> 0x0013 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ NameNotFoundException -> 0x0013 }
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r3, r0)     // Catch:{ NameNotFoundException -> 0x0013 }
            goto L_0x001d
        L_0x0013:
            com.google.android.play.core.internal.ag r2 = f500a
            java.lang.Object[] r3 = new java.lang.Object[r0]
            java.lang.String r4 = "Could not find PackageInfo."
            r2.mo17055b(r4, r3)
            r2 = r1
        L_0x001d:
            r3 = 1
            if (r2 != 0) goto L_0x0022
            r4 = r1
            goto L_0x0087
        L_0x0022:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 21
            if (r5 >= r6) goto L_0x0035
            android.content.pm.ApplicationInfo r2 = r2.applicationInfo
            java.lang.String r2 = r2.sourceDir
            r4.add(r2)
            goto L_0x0087
        L_0x0035:
            java.lang.String[] r5 = r2.splitNames
            if (r5 == 0) goto L_0x005b
            android.content.pm.ApplicationInfo r5 = r2.applicationInfo
            java.lang.String[] r5 = r5.splitSourceDirs
            if (r5 != 0) goto L_0x0040
            goto L_0x005b
        L_0x0040:
            java.lang.String[] r5 = r2.splitNames
            int r5 = java.util.Arrays.binarySearch(r5, r9)
            if (r5 >= 0) goto L_0x0054
            com.google.android.play.core.internal.ag r5 = f500a
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r6[r0] = r9
            java.lang.String r7 = "Asset Pack '%s' is not installed."
            r5.mo17054a(r7, r6)
            goto L_0x0066
        L_0x0054:
            android.content.pm.ApplicationInfo r6 = r2.applicationInfo
            java.lang.String[] r6 = r6.splitSourceDirs
            r5 = r6[r5]
            goto L_0x0067
        L_0x005b:
            com.google.android.play.core.internal.ag r5 = f500a
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r6[r0] = r9
            java.lang.String r7 = "No splits present for package %s."
            r5.mo17054a(r7, r6)
        L_0x0066:
            r5 = r1
        L_0x0067:
            if (r5 != 0) goto L_0x0073
            android.content.pm.ApplicationInfo r5 = r2.applicationInfo
            java.lang.String r5 = r5.sourceDir
            r4.add(r5)
            java.lang.String r5 = "config."
            goto L_0x0080
        L_0x0073:
            r4.add(r5)
            java.lang.String r5 = java.lang.String.valueOf(r9)
            java.lang.String r6 = ".config."
            java.lang.String r5 = r5.concat(r6)
        L_0x0080:
            java.util.List r2 = m436K(r2, r5)
            r4.addAll(r2)
        L_0x0087:
            if (r4 != 0) goto L_0x008a
            goto L_0x00cd
        L_0x008a:
            java.io.File r2 = new java.io.File
            java.lang.String r5 = "assets"
            r2.<init>(r5, r10)
            java.lang.String r2 = r2.getPath()
            java.util.Iterator r5 = r4.iterator()
        L_0x0099:
            boolean r6 = r5.hasNext()
            r7 = 2
            if (r6 == 0) goto L_0x00bd
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            com.google.android.play.core.assetpacks.AssetLocation r6 = com.google.android.play.core.assetpacks.C1615ck.m555b(r6, r2)     // Catch:{ IOException -> 0x00ae }
            if (r6 == 0) goto L_0x0099
            r1 = r6
            goto L_0x00cd
        L_0x00ae:
            r9 = move-exception
            com.google.android.play.core.internal.ag r2 = f500a
            java.lang.Object[] r4 = new java.lang.Object[r7]
            r4[r0] = r6
            r4[r3] = r10
            java.lang.String r10 = "Failed to parse APK file '%s' looking for asset '%s'."
            r2.mo17056c(r9, r10, r4)
            goto L_0x00cd
        L_0x00bd:
            com.google.android.play.core.internal.ag r2 = f500a
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r0] = r10
            r5[r3] = r9
            r5[r7] = r4
            java.lang.String r9 = "The asset %s is not present in Asset Pack %s. Searched in APKs: %s"
            r2.mo17054a(r9, r5)
        L_0x00cd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.C1571au.mo30737y(java.lang.String, java.lang.String):com.google.android.play.core.assetpacks.AssetLocation");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: z */
    public final AssetLocation mo30738z(String str, String str2, AssetPackLocation assetPackLocation) {
        File file = new File(assetPackLocation.assetsPath(), str2);
        if (file.exists()) {
            return AssetLocation.m351a(file.getPath(), 0, file.length());
        }
        f500a.mo17054a("The asset %s is not present in Asset Pack %s. Searched in folder: %s", str2, str, assetPackLocation.assetsPath());
        return null;
    }
}
