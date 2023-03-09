package com.google.android.play.core.internal;

import android.util.Log;
import com.google.android.play.core.splitinstall.C0997k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.ba */
final class C0953ba implements C0949aw {

    /* renamed from: a */
    private final /* synthetic */ int f144a = 0;

    C0953ba() {
    }

    C0953ba(byte[] bArr) {
    }

    C0953ba(char[] cArr) {
    }

    C0953ba(float[] fArr) {
    }

    C0953ba(int[] iArr) {
    }

    C0953ba(short[] sArr) {
    }

    C0953ba(boolean[] zArr) {
    }

    C0953ba(byte[][] bArr) {
    }

    /* renamed from: c */
    static void m74c(ClassLoader classLoader, Set<File> set) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File next : set) {
                String valueOf = String.valueOf(next.getParentFile().getAbsolutePath());
                Log.d("Splitcompat", valueOf.length() != 0 ? "Adding native library parent directory: ".concat(valueOf) : new String("Adding native library parent directory: "));
                hashSet.add(next.getParentFile());
            }
            C0959bg e = C0960bh.m101e(m76e(classLoader), "nativeLibraryDirectories", File.class);
            hashSet.removeAll(Arrays.asList((File[]) e.mo17071a()));
            synchronized (C0997k.class) {
                int size = hashSet.size();
                StringBuilder sb = new StringBuilder(30);
                sb.append("Adding directories ");
                sb.append(size);
                Log.d("Splitcompat", sb.toString());
                e.mo17075e(hashSet);
            }
        }
    }

    /* renamed from: d */
    static boolean m75d(ClassLoader classLoader, File file, File file2, boolean z, C0952az azVar, String str, C0951ay ayVar) {
        ArrayList arrayList = new ArrayList();
        Object e = m76e(classLoader);
        C0959bg e2 = C0960bh.m101e(e, "dexElements", Object.class);
        List<Object> asList = Arrays.asList((Object[]) e2.mo17071a());
        ArrayList arrayList2 = new ArrayList();
        for (Object d : asList) {
            arrayList2.add(C0960bh.m100d(d, str, File.class).mo17071a());
        }
        if (arrayList2.contains(file2)) {
            return true;
        }
        if (z || ayVar.mo17068a(e, file2, file)) {
            e2.mo17074d(Arrays.asList(azVar.mo17069a(e, new ArrayList(Collections.singleton(file2)), file, arrayList)));
            if (arrayList.isEmpty()) {
                return true;
            }
            C0958bf bfVar = new C0958bf("DexPathList.makeDexElement failed");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                IOException iOException = (IOException) arrayList.get(i);
                Log.e("SplitCompat", "DexPathList.makeDexElement failed", iOException);
                C0971bz.m125a(bfVar, iOException);
            }
            C0960bh.m101e(e, "dexElementsSuppressedExceptions", IOException.class).mo17074d(arrayList);
            throw bfVar;
        }
        String valueOf = String.valueOf(file2.getPath());
        Log.w("SplitCompat", valueOf.length() != 0 ? "Should be optimized ".concat(valueOf) : new String("Should be optimized "));
        return false;
    }

    /* renamed from: e */
    static Object m76e(ClassLoader classLoader) {
        return C0960bh.m100d(classLoader, "pathList", Object.class).mo17071a();
    }

    /* renamed from: f */
    static C0952az m77f() {
        return new C0954bb((byte[]) null);
    }

    /* renamed from: g */
    static C0951ay m78g() {
        return new C0957be((byte[]) null);
    }

    /* renamed from: h */
    public static void m79h(ClassLoader classLoader, Set<File> set, C0955bc bcVar) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File parentFile : set) {
                hashSet.add(parentFile.getParentFile());
            }
            Object e = m76e(classLoader);
            C0959bg<List> d = C0960bh.m100d(e, "nativeLibraryDirectories", List.class);
            synchronized (C0997k.class) {
                ArrayList arrayList = new ArrayList(d.mo17071a());
                hashSet.removeAll(arrayList);
                arrayList.addAll(hashSet);
                d.mo17072b(arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            Object[] a = bcVar.mo17070a(e, new ArrayList(hashSet), arrayList2);
            if (!arrayList2.isEmpty()) {
                C0958bf bfVar = new C0958bf("Error in makePathElements");
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    C0971bz.m125a(bfVar, (IOException) arrayList2.get(i));
                }
                throw bfVar;
            }
            synchronized (C0997k.class) {
                C0960bh.m101e(e, "nativeLibraryPathElements", Object.class).mo17075e(Arrays.asList(a));
            }
        }
    }

    /* renamed from: i */
    static C0952az m80i() {
        return new C0954bb();
    }

    /* renamed from: j */
    static C0955bc m81j() {
        return new C0956bd((byte[]) null);
    }

    /* renamed from: k */
    public static boolean m82k(ClassLoader classLoader, File file, File file2, boolean z) {
        return m75d(classLoader, file, file2, z, m80i(), "zip", m78g());
    }

    /* renamed from: l */
    static void m83l(ClassLoader classLoader, Set<File> set) {
        m79h(classLoader, set, new C0956bd());
    }

    /* renamed from: m */
    static boolean m84m(ClassLoader classLoader, File file, File file2, boolean z) {
        return m75d(classLoader, file, file2, z, m80i(), "path", new C0957be());
    }

    /* renamed from: a */
    public final void mo17066a(ClassLoader classLoader, Set set) {
        switch (this.f144a) {
            case 0:
                m74c(classLoader, set);
                return;
            case 1:
                m74c(classLoader, set);
                return;
            case 2:
            case 3:
            case 4:
                m79h(classLoader, set, m81j());
                return;
            case 5:
                m83l(classLoader, set);
                return;
            case 6:
                m83l(classLoader, set);
                return;
            default:
                m83l(classLoader, set);
                return;
        }
    }

    /* renamed from: b */
    public final boolean mo17067b(ClassLoader classLoader, File file, File file2, boolean z) {
        C0952az f;
        C0951ay g;
        String str;
        switch (this.f144a) {
            case 0:
            case 1:
                f = m77f();
                g = m78g();
                str = "zip";
                break;
            case 2:
                return m82k(classLoader, file, file2, z);
            case 3:
                return m82k(classLoader, file, file2, z);
            case 4:
                return m82k(classLoader, file, file2, z);
            case 5:
                return m84m(classLoader, file, file2, z);
            case 6:
                return m84m(classLoader, file, file2, z);
            default:
                f = m80i();
                g = new C0957be((char[]) null);
                str = "path";
                break;
        }
        return m75d(classLoader, file, file2, z, f, str, g);
    }
}
