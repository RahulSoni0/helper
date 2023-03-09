package com.google.android.play.core.assetpacks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.google.android.play.core.common.C1661a;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.internal.C0972i;
import com.google.android.play.core.internal.C1692ca;
import com.google.android.play.core.splitinstall.C1002p;
import com.google.android.play.core.tasks.C1786i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.i */
final class C1641i implements AssetPackManager {

    /* renamed from: a */
    private static final C0944ag f771a = new C0944ag("AssetPackManager");

    /* renamed from: b */
    private final C1571au f772b;

    /* renamed from: c */
    private final C1692ca<C1653t> f773c;

    /* renamed from: d */
    private final C1568ar f774d;

    /* renamed from: e */
    private final C1002p f775e;

    /* renamed from: f */
    private final C1605ca f776f;

    /* renamed from: g */
    private final C1592bo f777g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C1582be f778h;

    /* renamed from: i */
    private final C1692ca<Executor> f779i;

    /* renamed from: j */
    private final C1661a f780j;

    /* renamed from: k */
    private final Handler f781k = new Handler(Looper.getMainLooper());

    /* renamed from: l */
    private boolean f782l;

    C1641i(C1571au auVar, C1692ca<C1653t> caVar, C1568ar arVar, C1002p pVar, C1605ca caVar2, C1592bo boVar, C1582be beVar, C1692ca<Executor> caVar3, C1661a aVar) {
        this.f772b = auVar;
        this.f773c = caVar;
        this.f774d = arVar;
        this.f775e = pVar;
        this.f776f = caVar2;
        this.f777g = boVar;
        this.f778h = beVar;
        this.f779i = caVar3;
        this.f780j = aVar;
    }

    /* renamed from: h */
    private final void m616h() {
        this.f779i.mo30920a().execute(new C1637e(this, (byte[]) null));
    }

    /* renamed from: i */
    private final void m617i() {
        this.f779i.mo30920a().execute(new C1637e(this));
        this.f782l = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo30859a(boolean z) {
        boolean j = this.f774d.mo17090j();
        this.f774d.mo17085e(z);
        if (z && !j) {
            m616h();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final int mo30860b(int i, String str) {
        if (!this.f772b.mo30713a(str) && i == 4) {
            return 8;
        }
        if (!this.f772b.mo30713a(str) || i == 4) {
            return i;
        }
        return 4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo30861c() {
        this.f772b.mo30734v();
        this.f772b.mo30731s();
        this.f772b.mo30735w();
    }

    public final AssetPackStates cancel(List<String> list) {
        List<String> list2 = list;
        Map<String, Integer> h = this.f776f.mo30786h(list2);
        HashMap hashMap = new HashMap();
        for (String next : list) {
            Integer num = h.get(next);
            hashMap.put(next, AssetPackState.m354c(next, num == null ? 0 : num.intValue(), 0, 0, 0, 0.0d, 0, ""));
        }
        this.f773c.mo30920a().mo30694b(list2);
        return AssetPackStates.m358a(0, hashMap);
    }

    public final void clearListeners() {
        this.f774d.mo17088h();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void mo30862d() {
        Task<List<String>> c = this.f773c.mo30920a().mo30695c(this.f772b.mo30715c());
        C1571au auVar = this.f772b;
        auVar.getClass();
        c.addOnSuccessListener(this.f779i.mo30920a(), C1638f.m613a(auVar));
        c.addOnFailureListener(this.f779i.mo30920a(), C1639g.f768a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final /* synthetic */ void mo30863f(String str, C1786i iVar) {
        if (this.f772b.mo30729q(str)) {
            iVar.mo31062a(null);
            this.f773c.mo30920a().mo30701i(str);
            return;
        }
        iVar.mo31063b(new IOException(String.format("Failed to remove pack %s.", new Object[]{str})));
    }

    public final Task<AssetPackStates> fetch(List<String> list) {
        Map<String, Long> c = this.f772b.mo30715c();
        ArrayList arrayList = new ArrayList(list);
        ArrayList arrayList2 = new ArrayList();
        if (!this.f780j.mo30870a()) {
            arrayList.removeAll(c.keySet());
            arrayList2.addAll(list);
            arrayList2.removeAll(arrayList);
        }
        if (!arrayList.isEmpty()) {
            return this.f773c.mo30920a().mo30693a(arrayList2, arrayList, c);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt("error_code", 0);
        for (String next : list) {
            bundle.putInt(C0972i.m130e(NotificationCompat.CATEGORY_STATUS, next), 4);
            bundle.putInt(C0972i.m130e("error_code", next), 0);
            bundle.putLong(C0972i.m130e("total_bytes_to_download", next), 0);
            bundle.putLong(C0972i.m130e("bytes_downloaded", next), 0);
        }
        bundle.putStringArrayList("pack_names", new ArrayList(list));
        bundle.putLong("total_bytes_to_download", 0);
        bundle.putLong("bytes_downloaded", 0);
        return Tasks.m942a(AssetPackStates.m359b(bundle, this.f777g));
    }

    public final AssetLocation getAssetLocation(String str, String str2) {
        AssetPackLocation assetPackLocation;
        if (!this.f782l) {
            this.f779i.mo30920a().execute(new C1637e(this));
            this.f782l = true;
        }
        if (this.f772b.mo30713a(str)) {
            try {
                assetPackLocation = this.f772b.mo30716d(str);
            } catch (IOException unused) {
            }
        } else {
            if (this.f775e.mo17138a().contains(str)) {
                assetPackLocation = AssetPackLocation.m352a();
            }
            assetPackLocation = null;
        }
        if (assetPackLocation == null) {
            return null;
        }
        if (assetPackLocation.packStorageMethod() == 1) {
            return this.f772b.mo30737y(str, str2);
        }
        if (assetPackLocation.packStorageMethod() == 0) {
            return this.f772b.mo30738z(str, str2, assetPackLocation);
        }
        f771a.mo17054a("The asset %s is not present in Asset Pack %s", str2, str);
        return null;
    }

    public final AssetPackLocation getPackLocation(String str) {
        if (!this.f782l) {
            m617i();
        }
        if (this.f772b.mo30713a(str)) {
            try {
                return this.f772b.mo30716d(str);
            } catch (IOException unused) {
                return null;
            }
        } else if (this.f775e.mo17138a().contains(str)) {
            return AssetPackLocation.m352a();
        } else {
            return null;
        }
    }

    public final Map<String, AssetPackLocation> getPackLocations() {
        Map<String, AssetPackLocation> b = this.f772b.mo30714b();
        HashMap hashMap = new HashMap();
        for (String put : this.f775e.mo17138a()) {
            hashMap.put(put, AssetPackLocation.m352a());
        }
        b.putAll(hashMap);
        return b;
    }

    public final Task<AssetPackStates> getPackStates(List<String> list) {
        return this.f773c.mo30920a().mo30696d(list, new C1604c(this), this.f772b.mo30715c());
    }

    public final synchronized void registerListener(AssetPackStateUpdateListener assetPackStateUpdateListener) {
        boolean j = this.f774d.mo17090j();
        this.f774d.mo17086f(assetPackStateUpdateListener);
        if (!j) {
            m616h();
        }
    }

    public final Task<Void> removePack(String str) {
        C1786i iVar = new C1786i();
        this.f779i.mo30920a().execute(new C1631d(this, str, iVar));
        return iVar.mo31064c();
    }

    public final Task<Integer> showCellularDataConfirmation(Activity activity) {
        if (activity == null) {
            return Tasks.m943b(new AssetPackException(-3));
        }
        if (this.f778h.mo30765b() == null) {
            return Tasks.m943b(new AssetPackException(-12));
        }
        Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", this.f778h.mo30765b());
        C1786i iVar = new C1786i();
        intent.putExtra("result_receiver", new C1640h(this, this.f781k, iVar));
        activity.startActivity(intent);
        return iVar.mo31064c();
    }

    public final void unregisterListener(AssetPackStateUpdateListener assetPackStateUpdateListener) {
        this.f774d.mo17087g(assetPackStateUpdateListener);
    }
}
