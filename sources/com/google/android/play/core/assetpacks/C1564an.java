package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.internal.C1681aq;
import com.google.android.play.core.internal.C1690bp;
import com.google.android.play.core.internal.C1712t;
import com.google.android.play.core.splitcompat.C0989p;
import com.google.android.play.core.tasks.C1786i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.play.core.assetpacks.an */
final class C1564an implements C1653t {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final C0944ag f475a = new C0944ag("AssetPackServiceImpl");

    /* renamed from: b */
    private static final Intent f476b = new Intent("com.google.android.play.core.assetmoduleservice.BIND_ASSET_MODULE_SERVICE").setPackage("com.android.vending");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f477c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1592bo f478d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C1681aq<C1712t> f479e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1681aq<C1712t> f480f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final AtomicBoolean f481g = new AtomicBoolean();

    C1564an(Context context, C1592bo boVar) {
        this.f477c = context.getPackageName();
        this.f478d = boVar;
        if (C1690bp.m735a(context)) {
            Context c = C0989p.m204c(context);
            C0944ag agVar = f475a;
            Intent intent = f476b;
            this.f479e = new C1681aq(c, agVar, "AssetPackService", intent, C1654u.f810b);
            this.f480f = new C1681aq(C0989p.m204c(context), agVar, "AssetPackService-keepAlive", intent, C1654u.f809a);
        }
        f475a.mo17054a("AssetPackService initiated.", new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public static Bundle m394A(int i, String str) {
        Bundle B = m395B(i);
        B.putString("module_name", str);
        return B;
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public static Bundle m395B(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", i);
        return bundle;
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public static Bundle m396C() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 11000);
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(1);
        bundle.putIntegerArrayList("supported_compression_formats", arrayList);
        bundle.putIntegerArrayList("supported_patch_formats", new ArrayList());
        return bundle;
    }

    /* renamed from: k */
    static /* synthetic */ ArrayList m397k(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", (String) it.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* renamed from: m */
    static /* synthetic */ Bundle m399m(Map map) {
        Bundle C = m396C();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            Bundle bundle = new Bundle();
            bundle.putString("installed_asset_module_name", (String) entry.getKey());
            bundle.putLong("installed_asset_module_version", ((Long) entry.getValue()).longValue());
            arrayList.add(bundle);
        }
        C.putParcelableArrayList("installed_asset_module", arrayList);
        return C;
    }

    /* renamed from: r */
    static /* synthetic */ Bundle m404r(int i, String str, String str2, int i2) {
        Bundle A = m394A(i, str);
        A.putString("slice_id", str2);
        A.putInt("chunk_number", i2);
        return A;
    }

    /* renamed from: v */
    static /* synthetic */ List m408v(C1564an anVar, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AssetPackState next = AssetPackStates.m359b((Bundle) it.next(), anVar.f478d).packStates().values().iterator().next();
            if (next == null) {
                f475a.mo17055b("onGetSessionStates: Bundle contained no pack.", new Object[0]);
            }
            if (C1615ck.m559f(next.status())) {
                arrayList.add(next.name());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public final void m411y(int i, String str, int i2) {
        if (this.f479e != null) {
            f475a.mo17057d("notifyModuleCompleted", new Object[0]);
            C1786i iVar = new C1786i();
            this.f479e.mo30893a(new C1553ac(this, iVar, i, str, iVar, i2));
            return;
        }
        throw new C1588bk("The Play Store app is not installed or is an unofficial version.", i);
    }

    /* renamed from: z */
    private static <T> Task<T> m412z() {
        f475a.mo17055b("onError(%d)", -11);
        return Tasks.m943b(new AssetPackException(-11));
    }

    /* renamed from: a */
    public final Task<AssetPackStates> mo30693a(List<String> list, List<String> list2, Map<String, Long> map) {
        if (this.f479e == null) {
            return m412z();
        }
        f475a.mo17057d("startDownload(%s)", list2);
        C1786i iVar = new C1786i();
        this.f479e.mo30893a(new C1657x(this, iVar, list2, map, iVar, list));
        iVar.mo31064c().addOnSuccessListener(new C1655v(this));
        return iVar.mo31064c();
    }

    /* renamed from: b */
    public final void mo30694b(List<String> list) {
        if (this.f479e != null) {
            f475a.mo17057d("cancelDownloads(%s)", list);
            C1786i iVar = new C1786i();
            this.f479e.mo30893a(new C1658y(this, iVar, list, iVar));
        }
    }

    /* renamed from: c */
    public final Task<List<String>> mo30695c(Map<String, Long> map) {
        if (this.f479e == null) {
            return m412z();
        }
        f475a.mo17057d("syncPacks", new Object[0]);
        C1786i iVar = new C1786i();
        this.f479e.mo30893a(new C1659z(this, iVar, map, iVar));
        return iVar.mo31064c();
    }

    /* renamed from: d */
    public final Task<AssetPackStates> mo30696d(List<String> list, C1569as asVar, Map<String, Long> map) {
        if (this.f479e == null) {
            return m412z();
        }
        f475a.mo17057d("getPackStates(%s)", list);
        C1786i iVar = new C1786i();
        this.f479e.mo30893a(new C1551aa(this, iVar, list, map, iVar, asVar));
        return iVar.mo31064c();
    }

    /* renamed from: e */
    public final void mo30697e(int i, String str, String str2, int i2) {
        if (this.f479e != null) {
            f475a.mo17057d("notifyChunkTransferred", new Object[0]);
            C1786i iVar = new C1786i();
            this.f479e.mo30893a(new C1552ab(this, iVar, i, str, str2, i2, iVar));
            return;
        }
        throw new C1588bk("The Play Store app is not installed or is an unofficial version.", i);
    }

    /* renamed from: f */
    public final void mo30698f(int i, String str) {
        m411y(i, str, 10);
    }

    /* renamed from: g */
    public final void mo30699g(int i) {
        if (this.f479e != null) {
            f475a.mo17057d("notifySessionFailed", new Object[0]);
            C1786i iVar = new C1786i();
            this.f479e.mo30893a(new C1554ad(this, iVar, i, iVar));
            return;
        }
        throw new C1588bk("The Play Store app is not installed or is an unofficial version.", i);
    }

    /* renamed from: h */
    public final Task<ParcelFileDescriptor> mo30700h(int i, String str, String str2, int i2) {
        if (this.f479e == null) {
            return m412z();
        }
        f475a.mo17057d("getChunkFileDescriptor(%s, %s, %d, session=%d)", str, str2, Integer.valueOf(i2), Integer.valueOf(i));
        C1786i iVar = new C1786i();
        this.f479e.mo30893a(new C1555ae(this, iVar, i, str, str2, i2, iVar));
        return iVar.mo31064c();
    }

    /* renamed from: i */
    public final void mo30701i(String str) {
        if (this.f479e != null) {
            f475a.mo17057d("removePack(%s)", str);
            C1786i iVar = new C1786i();
            this.f479e.mo30893a(new C1656w(this, iVar, str, iVar));
        }
    }

    /* renamed from: j */
    public final synchronized void mo30702j() {
        if (this.f480f == null) {
            f475a.mo17058e("Keep alive connection manager is not initialized.", new Object[0]);
            return;
        }
        C0944ag agVar = f475a;
        agVar.mo17057d("keepAlive", new Object[0]);
        if (!this.f481g.compareAndSet(false, true)) {
            agVar.mo17057d("Service is already kept alive.", new Object[0]);
            return;
        }
        C1786i iVar = new C1786i();
        this.f480f.mo30893a(new C1556af(this, iVar, iVar));
    }
}
