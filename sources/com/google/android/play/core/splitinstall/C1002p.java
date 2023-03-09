package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import com.google.android.play.core.internal.C0944ag;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.play.core.splitinstall.p */
public final class C1002p {

    /* renamed from: a */
    private static final C0944ag f205a = new C0944ag("SplitInstallInfoProvider");

    /* renamed from: b */
    private final Context f206b;

    /* renamed from: c */
    private final String f207c;

    public C1002p(Context context) {
        this.f206b = context;
        this.f207c = context.getPackageName();
    }

    public C1002p(Context context, String str) {
        this.f206b = context;
        this.f207c = str;
    }

    /* renamed from: d */
    public static boolean m228d(String str) {
        return str.startsWith("config.");
    }

    /* renamed from: e */
    public static boolean m229e(String str) {
        return m228d(str) || str.contains(".config.");
    }

    /* renamed from: f */
    private final Set<String> m230f() {
        HashSet hashSet = new HashSet();
        Bundle g = m231g();
        if (g != null) {
            String string = g.getString("com.android.dynamic.apk.fused.modules");
            if (string == null || string.isEmpty()) {
                f205a.mo17054a("App has no fused modules.", new Object[0]);
            } else {
                Collections.addAll(hashSet, string.split(",", -1));
                hashSet.remove("");
                hashSet.remove("base");
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = null;
            try {
                PackageInfo packageInfo = this.f206b.getPackageManager().getPackageInfo(this.f207c, 0);
                if (packageInfo != null) {
                    strArr = packageInfo.splitNames;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                f205a.mo17058e("App is not found in PackageManager", new Object[0]);
            }
            if (strArr != null) {
                f205a.mo17054a("Adding splits from package manager: %s", Arrays.toString(strArr));
                Collections.addAll(hashSet, strArr);
            } else {
                f205a.mo17054a("No splits are found or app cannot be found in package manager.", new Object[0]);
            }
            C1000n a = C1001o.m226a();
            if (a != null) {
                hashSet.addAll(a.mo17117a());
            }
        }
        return hashSet;
    }

    /* renamed from: g */
    private final Bundle m231g() {
        try {
            ApplicationInfo applicationInfo = this.f206b.getPackageManager().getApplicationInfo(this.f207c, 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                return applicationInfo.metaData;
            }
            f205a.mo17054a("App has no applicationInfo or metaData", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            f205a.mo17058e("App is not found in PackageManager", new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    public final Set<String> mo17138a() {
        HashSet hashSet = new HashSet();
        for (String next : m230f()) {
            if (!m229e(next)) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    /* renamed from: b */
    public final Set<String> mo17139b() {
        C0996h c = mo17140c();
        if (c == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Set<String> f = m230f();
        f.add("");
        Set<String> a = mo17138a();
        a.add("");
        for (Map.Entry next : c.mo17134a(a).entrySet()) {
            if (f.containsAll((Collection) next.getValue())) {
                hashSet.add((String) next.getKey());
            }
        }
        return hashSet;
    }

    /* renamed from: c */
    public final C0996h mo17140c() {
        Bundle g = m231g();
        if (g == null) {
            f205a.mo17058e("No metadata found in Context.", new Object[0]);
            return null;
        }
        int i = g.getInt("com.android.vending.splits");
        if (i == 0) {
            f205a.mo17058e("No metadata found in AndroidManifest.", new Object[0]);
            return null;
        }
        try {
            C0996h b = C0997k.m218b(this.f206b.getResources().getXml(i), new C0995g());
            if (b == null) {
                f205a.mo17058e("Can't parse languages metadata.", new Object[0]);
            }
            return b;
        } catch (Resources.NotFoundException unused) {
            f205a.mo17058e("Resource with languages metadata doesn't exist.", new Object[0]);
            return null;
        }
    }
}
