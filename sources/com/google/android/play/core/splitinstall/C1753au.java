package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.internal.C1681aq;
import com.google.android.play.core.internal.C1686bl;
import com.google.android.play.core.internal.C1690bp;
import com.google.android.play.core.splitcompat.C0989p;
import com.google.android.play.core.tasks.C1786i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.au */
final class C1753au {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final C0944ag f953b = new C0944ag("SplitInstallService");

    /* renamed from: c */
    private static final Intent f954c = new Intent("com.google.android.play.core.splitinstall.BIND_SPLIT_INSTALL_SERVICE").setPackage("com.android.vending");

    /* renamed from: a */
    C1681aq<C1686bl> f955a;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final String f956d;

    public C1753au(Context context) {
        this.f956d = context.getPackageName();
        if (C1690bp.m735a(context)) {
            this.f955a = new C1681aq(C0989p.m204c(context), f953b, "SplitInstallService", f954c, C1735ac.f926a);
        }
    }

    /* renamed from: i */
    static /* synthetic */ ArrayList m874i(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", (String) it.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* renamed from: j */
    static /* synthetic */ ArrayList m875j(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString(DublinCoreProperties.LANGUAGE, (String) it.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* renamed from: l */
    static /* synthetic */ Bundle m877l() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 11000);
        return bundle;
    }

    /* renamed from: n */
    private static <T> Task<T> m879n() {
        f953b.mo17055b("onError(%d)", -14);
        return Tasks.m943b(new SplitInstallException(-14));
    }

    /* renamed from: a */
    public final Task<Integer> mo31020a(Collection<String> collection, Collection<String> collection2) {
        if (this.f955a == null) {
            return m879n();
        }
        f953b.mo17057d("startInstall(%s,%s)", collection, collection2);
        C1786i iVar = new C1786i();
        this.f955a.mo30893a(new C1736ad(this, iVar, collection, collection2, iVar));
        return iVar.mo31064c();
    }

    /* renamed from: b */
    public final Task<Void> mo31021b(List<String> list) {
        if (this.f955a == null) {
            return m879n();
        }
        f953b.mo17057d("deferredUninstall(%s)", list);
        C1786i iVar = new C1786i();
        this.f955a.mo30893a(new C1737ae(this, iVar, list, iVar));
        return iVar.mo31064c();
    }

    /* renamed from: c */
    public final Task<Void> mo31022c(List<String> list) {
        if (this.f955a == null) {
            return m879n();
        }
        f953b.mo17057d("deferredInstall(%s)", list);
        C1786i iVar = new C1786i();
        this.f955a.mo30893a(new C1738af(this, iVar, list, iVar));
        return iVar.mo31064c();
    }

    /* renamed from: d */
    public final Task<Void> mo31023d(List<String> list) {
        if (this.f955a == null) {
            return m879n();
        }
        f953b.mo17057d("deferredLanguageInstall(%s)", list);
        C1786i iVar = new C1786i();
        this.f955a.mo30893a(new C1739ag(this, iVar, list, iVar));
        return iVar.mo31064c();
    }

    /* renamed from: e */
    public final Task<Void> mo31024e(List<String> list) {
        if (this.f955a == null) {
            return m879n();
        }
        f953b.mo17057d("deferredLanguageUninstall(%s)", list);
        C1786i iVar = new C1786i();
        this.f955a.mo30893a(new C1740ah(this, iVar, list, iVar));
        return iVar.mo31064c();
    }

    /* renamed from: f */
    public final Task<SplitInstallSessionState> mo31025f(int i) {
        if (this.f955a == null) {
            return m879n();
        }
        f953b.mo17057d("getSessionState(%d)", Integer.valueOf(i));
        C1786i iVar = new C1786i();
        this.f955a.mo30893a(new C1741ai(this, iVar, i, iVar));
        return iVar.mo31064c();
    }

    /* renamed from: g */
    public final Task<List<SplitInstallSessionState>> mo31026g() {
        if (this.f955a == null) {
            return m879n();
        }
        f953b.mo17057d("getSessionStates", new Object[0]);
        C1786i iVar = new C1786i();
        this.f955a.mo30893a(new C1742aj(this, iVar, iVar));
        return iVar.mo31064c();
    }

    /* renamed from: h */
    public final Task<Void> mo31027h(int i) {
        if (this.f955a == null) {
            return m879n();
        }
        f953b.mo17057d("cancelInstall(%d)", Integer.valueOf(i));
        C1786i iVar = new C1786i();
        this.f955a.mo30893a(new C1743ak(this, iVar, i, iVar));
        return iVar.mo31064c();
    }
}
