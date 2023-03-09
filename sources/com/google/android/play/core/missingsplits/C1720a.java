package com.google.android.play.core.missingsplits;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.play.core.internal.C0944ag;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.play.core.missingsplits.a */
final class C1720a {

    /* renamed from: a */
    private static final C0944ag f885a = new C0944ag("MissingSplitsAppComponentsHelper");

    /* renamed from: b */
    private final Context f886b;

    /* renamed from: c */
    private final PackageManager f887c;

    C1720a(Context context, PackageManager packageManager) {
        this.f886b = context;
        this.f887c = packageManager;
    }

    /* renamed from: d */
    private final void m813d(List<ComponentInfo> list, int i) {
        for (ComponentInfo next : list) {
            this.f887c.setComponentEnabledSetting(new ComponentName(next.packageName, next.name), i, 1);
        }
    }

    /* renamed from: e */
    private final List<ComponentInfo> m814e() {
        try {
            ArrayList arrayList = new ArrayList();
            PackageInfo packageInfo = this.f887c.getPackageInfo(this.f886b.getPackageName(), MetaDo.META_SETVIEWPORTEXT);
            if (packageInfo.providers != null) {
                Collections.addAll(arrayList, packageInfo.providers);
            }
            if (packageInfo.receivers != null) {
                Collections.addAll(arrayList, packageInfo.receivers);
            }
            if (packageInfo.services != null) {
                Collections.addAll(arrayList, packageInfo.services);
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            f885a.mo17058e("Failed to resolve own package : %s", e);
            return Collections.emptyList();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo30970a() {
        for (ComponentInfo next : m814e()) {
            if (this.f887c.getComponentEnabledSetting(new ComponentName(next.packageName, next.name)) != 2) {
                f885a.mo17054a("Not all non-activity components are disabled", new Object[0]);
                return false;
            }
        }
        f885a.mo17054a("All non-activity components are disabled", new Object[0]);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo30971b() {
        f885a.mo17057d("Disabling all non-activity components", new Object[0]);
        m813d(m814e(), 2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo30972c() {
        f885a.mo17057d("Resetting enabled state of all non-activity components", new Object[0]);
        m813d(m814e(), 0);
    }
}
