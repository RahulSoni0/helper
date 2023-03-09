package com.google.android.play.core.assetpacks;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.internal.C0972i;
import com.google.android.play.core.internal.C1692ca;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.play.core.assetpacks.ca */
final class C1605ca {

    /* renamed from: a */
    private static final C0944ag f642a = new C0944ag("ExtractorSessionStoreView");

    /* renamed from: b */
    private final C1571au f643b;

    /* renamed from: c */
    private final C1692ca<C1653t> f644c;

    /* renamed from: d */
    private final C1592bo f645d;

    /* renamed from: e */
    private final C1692ca<Executor> f646e;

    /* renamed from: f */
    private final Map<Integer, C1601bx> f647f = new HashMap();

    /* renamed from: g */
    private final ReentrantLock f648g = new ReentrantLock();

    C1605ca(C1571au auVar, C1692ca<C1653t> caVar, C1592bo boVar, C1692ca<Executor> caVar2) {
        this.f643b = auVar;
        this.f644c = caVar;
        this.f645d = boVar;
        this.f646e = caVar2;
    }

    /* renamed from: q */
    private final Map<String, C1601bx> m510q(List<String> list) {
        return (Map) m511r(new C1597bt(this, list, (byte[]) null));
    }

    /* renamed from: r */
    private final <T> T m511r(C1603bz<T> bzVar) {
        try {
            mo30779a();
            return bzVar.mo30777a();
        } finally {
            mo30780b();
        }
    }

    /* renamed from: s */
    private final C1601bx m512s(int i) {
        Map<Integer, C1601bx> map = this.f647f;
        Integer valueOf = Integer.valueOf(i);
        C1601bx bxVar = map.get(valueOf);
        if (bxVar != null) {
            return bxVar;
        }
        throw new C1588bk(String.format("Could not find session %d while trying to get it", new Object[]{valueOf}), i);
    }

    /* renamed from: t */
    private static String m513t(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        if (stringArrayList != null && !stringArrayList.isEmpty()) {
            return stringArrayList.get(0);
        }
        throw new C1588bk("Session without pack received.");
    }

    /* renamed from: u */
    private static <T> List<T> m514u(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo30779a() {
        this.f648g.lock();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo30780b() {
        this.f648g.unlock();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final Map<Integer, C1601bx> mo30781c() {
        return this.f647f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final boolean mo30782d(Bundle bundle) {
        return ((Boolean) m511r(new C1594bq(this, bundle, (byte[]) null))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean mo30783e(Bundle bundle) {
        return ((Boolean) m511r(new C1594bq(this, bundle))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final void mo30784f(String str, int i, long j) {
        m511r(new C1595br(this, str, i, j));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final void mo30785g(int i) {
        m511r(new C1596bs(this, i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final Map<String, Integer> mo30786h(List<String> list) {
        return (Map) m511r(new C1597bt(this, list));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final /* synthetic */ Map mo30787i(List list) {
        int i;
        Map<String, C1601bx> q = m510q(list);
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            C1601bx bxVar = q.get(str);
            if (bxVar == null) {
                i = 8;
            } else {
                if (C1615ck.m559f(bxVar.f634c.f629c)) {
                    try {
                        bxVar.f634c.f629c = 6;
                        this.f646e.mo30920a().execute(new C1598bu(this, bxVar));
                        this.f645d.mo30774a(str);
                    } catch (C1588bk unused) {
                        f642a.mo17057d("Session %d with pack %s does not exist, no need to cancel.", Integer.valueOf(bxVar.f632a), str);
                    }
                }
                i = bxVar.f634c.f629c;
            }
            hashMap.put(str, Integer.valueOf(i));
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final /* synthetic */ Map mo30788j(List list) {
        HashMap hashMap = new HashMap();
        for (C1601bx next : this.f647f.values()) {
            String str = next.f634c.f627a;
            if (list.contains(str)) {
                C1601bx bxVar = (C1601bx) hashMap.get(str);
                if ((bxVar == null ? -1 : bxVar.f632a) < next.f632a) {
                    hashMap.put(str, next);
                }
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public final /* synthetic */ Boolean mo30789k(Bundle bundle) {
        boolean z;
        int i = bundle.getInt("session_id");
        if (i == 0) {
            return true;
        }
        Map<Integer, C1601bx> map = this.f647f;
        Integer valueOf = Integer.valueOf(i);
        if (!map.containsKey(valueOf)) {
            return true;
        }
        C1601bx bxVar = this.f647f.get(valueOf);
        if (bxVar.f634c.f629c == 6) {
            z = false;
        } else {
            z = !C1615ck.m562i(bxVar.f634c.f629c, bundle.getInt(C0972i.m130e(NotificationCompat.CATEGORY_STATUS, m513t(bundle))));
        }
        return Boolean.valueOf(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final /* synthetic */ Boolean mo30790l(Bundle bundle) {
        C1602by byVar;
        Bundle bundle2 = bundle;
        int i = bundle2.getInt("session_id");
        if (i == 0) {
            return false;
        }
        Map<Integer, C1601bx> map = this.f647f;
        Integer valueOf = Integer.valueOf(i);
        boolean z = true;
        if (map.containsKey(valueOf)) {
            C1601bx s = m512s(i);
            int i2 = bundle2.getInt(C0972i.m130e(NotificationCompat.CATEGORY_STATUS, s.f634c.f627a));
            if (C1615ck.m562i(s.f634c.f629c, i2)) {
                f642a.mo17054a("Found stale update for session %s with status %d.", valueOf, Integer.valueOf(s.f634c.f629c));
                C1600bw bwVar = s.f634c;
                String str = bwVar.f627a;
                int i3 = bwVar.f629c;
                if (i3 == 4) {
                    this.f644c.mo30920a().mo30698f(i, str);
                } else if (i3 == 5) {
                    this.f644c.mo30920a().mo30699g(i);
                } else if (i3 == 6) {
                    this.f644c.mo30920a().mo30694b(Arrays.asList(new String[]{str}));
                }
            } else {
                s.f634c.f629c = i2;
                if (C1615ck.m560g(i2)) {
                    mo30785g(i);
                    this.f645d.mo30774a(s.f634c.f627a);
                } else {
                    for (C1602by next : s.f634c.f631e) {
                        ArrayList parcelableArrayList = bundle2.getParcelableArrayList(C0972i.m131f("chunk_intents", s.f634c.f627a, next.f635a));
                        if (parcelableArrayList != null) {
                            for (int i4 = 0; i4 < parcelableArrayList.size(); i4++) {
                                if (!(parcelableArrayList.get(i4) == null || ((Intent) parcelableArrayList.get(i4)).getData() == null)) {
                                    next.f638d.get(i4).f626a = true;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            String t = m513t(bundle);
            long j = bundle2.getLong(C0972i.m130e("pack_version", t));
            int i5 = bundle2.getInt(C0972i.m130e(NotificationCompat.CATEGORY_STATUS, t));
            long j2 = bundle2.getLong(C0972i.m130e("total_bytes_to_download", t));
            ArrayList<String> stringArrayList = bundle2.getStringArrayList(C0972i.m130e("slice_ids", t));
            ArrayList arrayList = new ArrayList();
            for (T t2 : m514u(stringArrayList)) {
                ArrayList parcelableArrayList2 = bundle2.getParcelableArrayList(C0972i.m131f("chunk_intents", t, t2));
                ArrayList arrayList2 = new ArrayList();
                for (Intent intent : m514u(parcelableArrayList2)) {
                    if (intent == null) {
                        z = false;
                    }
                    arrayList2.add(new C1599bv(z));
                    z = true;
                }
                String string = bundle2.getString(C0972i.m131f("uncompressed_hash_sha256", t, t2));
                long j3 = bundle2.getLong(C0972i.m131f("uncompressed_size", t, t2));
                int i6 = bundle2.getInt(C0972i.m131f("patch_format", t, t2), 0);
                if (i6 != 0) {
                    byVar = new C1602by(t2, string, j3, arrayList2, 0, i6);
                } else {
                    byVar = new C1602by(t2, string, j3, arrayList2, bundle2.getInt(C0972i.m131f("compression_format", t, t2), 0), 0);
                }
                arrayList.add(byVar);
                z = true;
            }
            this.f647f.put(Integer.valueOf(i), new C1601bx(i, bundle2.getInt("app_version_code"), new C1600bw(t, j, i5, j2, arrayList)));
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final /* synthetic */ void mo30791m(String str, int i, long j) {
        C1601bx bxVar = m510q(Arrays.asList(new String[]{str})).get(str);
        if (bxVar == null || C1615ck.m560g(bxVar.f634c.f629c)) {
            f642a.mo17055b(String.format("Could not find pack %s while trying to complete it", new Object[]{str}), new Object[0]);
        }
        this.f643b.mo30711B(str, i, j);
        bxVar.f634c.f629c = 4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public final /* synthetic */ void mo30792n(int i) {
        m512s(i).f634c.f629c = 5;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public final /* synthetic */ void mo30793o(int i) {
        C1601bx s = m512s(i);
        if (C1615ck.m560g(s.f634c.f629c)) {
            C1571au auVar = this.f643b;
            C1600bw bwVar = s.f634c;
            auVar.mo30711B(bwVar.f627a, s.f633b, bwVar.f628b);
            C1600bw bwVar2 = s.f634c;
            int i2 = bwVar2.f629c;
            if (i2 == 5 || i2 == 6) {
                this.f643b.mo30712C(bwVar2.f627a, s.f633b, bwVar2.f628b);
                return;
            }
            return;
        }
        throw new C1588bk(String.format("Could not safely delete session %d because it is not in a terminal state.", new Object[]{Integer.valueOf(i)}), i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public final void mo30794p(int i) {
        m511r(new C1596bs(this, i, (byte[]) null));
    }
}
