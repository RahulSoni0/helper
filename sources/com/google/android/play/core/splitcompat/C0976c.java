package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.play.core.internal.C0950ax;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.play.core.splitcompat.c */
public final class C0976c {

    /* renamed from: a */
    private final long f171a;

    /* renamed from: b */
    private final Context f172b;

    /* renamed from: c */
    private File f173c;

    public C0976c(Context context) throws PackageManager.NameNotFoundException {
        this.f172b = context;
        this.f171a = (long) context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
    }

    /* renamed from: o */
    public static void m166o(File file) throws IOException {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File o : listFiles) {
                m166o(o);
            }
        }
        if (file.exists() && !file.delete()) {
            throw new IOException(String.format("Failed to delete '%s'", new Object[]{file.getAbsolutePath()}));
        }
    }

    /* renamed from: p */
    private final File m167p() throws IOException {
        File file = new File(m168q(), "verified-splits");
        m174w(file);
        return file;
    }

    /* renamed from: q */
    private final File m168q() throws IOException {
        File file = new File(m169r(), Long.toString(this.f171a));
        m174w(file);
        return file;
    }

    /* renamed from: r */
    private final File m169r() throws IOException {
        if (this.f173c == null) {
            Context context = this.f172b;
            if (context != null) {
                this.f173c = context.getFilesDir();
            } else {
                throw new IllegalStateException("context must be non-null to populate null filesDir");
            }
        }
        File file = new File(this.f173c, "splitcompat");
        m174w(file);
        return file;
    }

    /* renamed from: s */
    private final File m170s() throws IOException {
        File file = new File(m168q(), "native-libraries");
        m174w(file);
        return file;
    }

    /* renamed from: t */
    private final File m171t(String str) throws IOException {
        File u = m172u(m170s(), str);
        m174w(u);
        return u;
    }

    /* renamed from: u */
    private static File m172u(File file, String str) throws IOException {
        File file2 = new File(file, str);
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            return file2;
        }
        throw new IllegalArgumentException("split ID cannot be placed in target directory");
    }

    /* renamed from: v */
    private static String m173v(String str) {
        return String.valueOf(str).concat(".apk");
    }

    /* renamed from: w */
    private static void m174w(File file) throws IOException {
        if (!file.exists()) {
            file.mkdirs();
            if (!file.isDirectory()) {
                String valueOf = String.valueOf(file.getAbsolutePath());
                throw new IOException(valueOf.length() != 0 ? "Unable to create directory: ".concat(valueOf) : new String("Unable to create directory: "));
            }
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException("File input must be directory when it exists.");
        }
    }

    /* renamed from: a */
    public final void mo17099a() throws IOException {
        File r = m169r();
        String[] list = r.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(Long.toString(this.f171a))) {
                    File file = new File(r, str);
                    String valueOf = String.valueOf(file);
                    long j = this.f171a;
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118);
                    sb.append("FileStorage: removing directory for different version code (directory = ");
                    sb.append(valueOf);
                    sb.append(", current version code = ");
                    sb.append(j);
                    sb.append(")");
                    Log.d("SplitCompat", sb.toString());
                    m166o(file);
                }
            }
        }
    }

    /* renamed from: b */
    public final File mo17100b(String str) throws IOException {
        return m172u(mo17105g(), m173v(str));
    }

    /* renamed from: c */
    public final File mo17101c(String str) throws IOException {
        return m172u(m167p(), m173v(str));
    }

    /* renamed from: d */
    public final File mo17102d(File file) throws IOException {
        return m172u(m167p(), file.getName());
    }

    /* renamed from: e */
    public final File mo17103e(String str, String str2) throws IOException {
        return m172u(m171t(str), str2);
    }

    /* renamed from: f */
    public final File mo17104f() throws IOException {
        return new File(m168q(), "lock.tmp");
    }

    /* renamed from: g */
    public final File mo17105g() throws IOException {
        File file = new File(m168q(), "unverified-splits");
        m174w(file);
        return file;
    }

    /* renamed from: h */
    public final File mo17106h(String str) throws IOException {
        File file = new File(m168q(), "dex");
        m174w(file);
        File u = m172u(file, str);
        m174w(u);
        return u;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final Set<C0990q> mo17107i() throws IOException {
        File p = m167p();
        HashSet hashSet = new HashSet();
        File[] listFiles = p.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile() && file.getName().endsWith(".apk")) {
                    String name = file.getName();
                    hashSet.add(new C0990q(file, name.substring(0, name.length() - 4)));
                }
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final List<String> mo17108j() throws IOException {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = m170s().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    arrayList.add(file.getName());
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public final void mo17109k(String str) throws IOException {
        m166o(m171t(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final void mo17110l(File file) throws IOException {
        C0950ax.m70c(file.getParentFile().getParentFile().equals(m170s()), "File to remove is not a native library");
        m166o(file);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final Set<File> mo17111m(String str) throws IOException {
        HashSet hashSet = new HashSet();
        File[] listFiles = m171t(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    hashSet.add(file);
                }
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public final void mo17112n(String str) throws IOException {
        m166o(mo17101c(str));
    }
}
