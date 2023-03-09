package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import androidx.core.app.NotificationCompat;
import com.google.android.play.core.common.LocalTestingException;
import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.internal.C0950ax;
import com.google.android.play.core.internal.C0972i;
import com.google.android.play.core.internal.C1692ca;
import com.google.android.play.core.tasks.C1786i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.play.core.assetpacks.cj */
final class C1614cj implements C1653t {

    /* renamed from: a */
    private static final C0944ag f675a = new C0944ag("FakeAssetPackService");

    /* renamed from: h */
    private static final AtomicInteger f676h = new AtomicInteger(1);

    /* renamed from: b */
    private final String f677b;

    /* renamed from: c */
    private final C1568ar f678c;

    /* renamed from: d */
    private final C1592bo f679d;

    /* renamed from: e */
    private final Context f680e;

    /* renamed from: f */
    private final C1626cv f681f;

    /* renamed from: g */
    private final C1692ca<Executor> f682g;

    /* renamed from: i */
    private final Handler f683i = new Handler(Looper.getMainLooper());

    C1614cj(File file, C1568ar arVar, C1592bo boVar, Context context, C1626cv cvVar, C1692ca<Executor> caVar) {
        this.f677b = file.getAbsolutePath();
        this.f678c = arVar;
        this.f679d = boVar;
        this.f680e = context;
        this.f681f = cvVar;
        this.f682g = caVar;
    }

    /* renamed from: k */
    static long m535k(int i, long j) {
        if (i == 2) {
            return j / 2;
        }
        if (i == 3 || i == 4) {
            return j;
        }
        return 0;
    }

    /* renamed from: p */
    private final AssetPackState m536p(String str, int i) throws LocalTestingException {
        long j = 0;
        for (File length : m537q(str)) {
            j += length.length();
        }
        return AssetPackState.m354c(str, i, 0, m535k(i, j), j, this.f679d.mo30775b(str), 1, "");
    }

    /* renamed from: q */
    private final File[] m537q(String str) throws LocalTestingException {
        File file = new File(this.f677b);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles(new C1612ch(str));
            if (listFiles != null) {
                if (r1 != 0) {
                    for (File b : listFiles) {
                        if (C0950ax.m69b(b).equals(str)) {
                            return listFiles;
                        }
                    }
                    throw new LocalTestingException(String.format("No master slice available for pack '%s'.", new Object[]{str}));
                }
                throw new LocalTestingException(String.format("No APKs available for pack '%s'.", new Object[]{str}));
            }
            throw new LocalTestingException(String.format("Failed fetching APKs for pack '%s'.", new Object[]{str}));
        }
        throw new LocalTestingException(String.format("Local testing directory '%s' not found.", new Object[]{file}));
    }

    /* renamed from: r */
    private static String m538r(File file) throws LocalTestingException {
        try {
            return C1615ck.m554a(Arrays.asList(new File[]{file}));
        } catch (NoSuchAlgorithmException e) {
            throw new LocalTestingException("SHA256 algorithm not supported.", e);
        } catch (IOException e2) {
            throw new LocalTestingException(String.format("Could not digest file: %s.", new Object[]{file}), e2);
        }
    }

    /* renamed from: s */
    private final void m539s(int i, String str, int i2) throws LocalTestingException {
        Bundle bundle = new Bundle();
        bundle.putInt("app_version_code", this.f681f.mo30818a());
        bundle.putInt("session_id", i);
        File[] q = m537q(str);
        ArrayList arrayList = new ArrayList();
        long j = 0;
        for (File file : q) {
            j += file.length();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(i2 == 3 ? new Intent().setData(Uri.EMPTY) : null);
            String b = C0950ax.m69b(file);
            bundle.putParcelableArrayList(C0972i.m131f("chunk_intents", str, b), arrayList2);
            bundle.putString(C0972i.m131f("uncompressed_hash_sha256", str, b), m538r(file));
            bundle.putLong(C0972i.m131f("uncompressed_size", str, b), file.length());
            arrayList.add(b);
        }
        bundle.putStringArrayList(C0972i.m130e("slice_ids", str), arrayList);
        bundle.putLong(C0972i.m130e("pack_version", str), (long) this.f681f.mo30818a());
        bundle.putInt(C0972i.m130e(NotificationCompat.CATEGORY_STATUS, str), i2);
        bundle.putInt(C0972i.m130e("error_code", str), 0);
        bundle.putLong(C0972i.m130e("bytes_downloaded", str), m535k(i2, j));
        bundle.putLong(C0972i.m130e("total_bytes_to_download", str), j);
        bundle.putStringArrayList("pack_names", new ArrayList(Arrays.asList(new String[]{str})));
        bundle.putLong("bytes_downloaded", m535k(i2, j));
        bundle.putLong("total_bytes_to_download", j);
        this.f683i.post(new C1613ci(this, new Intent("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE").putExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE", bundle)));
    }

    /* renamed from: a */
    public final Task<AssetPackStates> mo30693a(List<String> list, List<String> list2, Map<String, Long> map) {
        f675a.mo17057d("startDownload(%s)", list2);
        C1786i iVar = new C1786i();
        this.f682g.mo30920a().execute(new C1609ce(this, list2, iVar, list));
        return iVar.mo31064c();
    }

    /* renamed from: b */
    public final void mo30694b(List<String> list) {
        f675a.mo17057d("cancelDownload(%s)", list);
    }

    /* renamed from: c */
    public final Task<List<String>> mo30695c(Map<String, Long> map) {
        f675a.mo17057d("syncPacks()", new Object[0]);
        return Tasks.m942a(new ArrayList());
    }

    /* renamed from: d */
    public final Task<AssetPackStates> mo30696d(List<String> list, C1569as asVar, Map<String, Long> map) {
        f675a.mo17057d("getPackStates(%s)", list);
        C1786i iVar = new C1786i();
        this.f682g.mo30920a().execute(new C1610cf(this, list, asVar, iVar));
        return iVar.mo31064c();
    }

    /* renamed from: e */
    public final void mo30697e(int i, String str, String str2, int i2) {
        f675a.mo17057d("notifyChunkTransferred", new Object[0]);
    }

    /* renamed from: f */
    public final void mo30698f(int i, String str) {
        f675a.mo17057d("notifyModuleCompleted", new Object[0]);
        this.f682g.mo30920a().execute(new C1611cg(this, i, str));
    }

    /* renamed from: g */
    public final void mo30699g(int i) {
        f675a.mo17057d("notifySessionFailed", new Object[0]);
    }

    /* renamed from: h */
    public final Task<ParcelFileDescriptor> mo30700h(int i, String str, String str2, int i2) {
        f675a.mo17057d("getChunkFileDescriptor(session=%d, %s, %s, %d)", Integer.valueOf(i), str, str2, Integer.valueOf(i2));
        C1786i iVar = new C1786i();
        try {
            for (File file : m537q(str)) {
                if (C0950ax.m69b(file).equals(str2)) {
                    iVar.mo31062a(ParcelFileDescriptor.open(file, 268435456));
                    return iVar.mo31064c();
                }
            }
            throw new LocalTestingException(String.format("Local testing slice for '%s' not found.", new Object[]{str2}));
        } catch (FileNotFoundException e) {
            f675a.mo17058e("getChunkFileDescriptor failed", e);
            iVar.mo31063b(new LocalTestingException("Asset Slice file not found.", e));
        } catch (LocalTestingException e2) {
            f675a.mo17058e("getChunkFileDescriptor failed", e2);
            iVar.mo31063b(e2);
        }
    }

    /* renamed from: i */
    public final void mo30701i(String str) {
        f675a.mo17057d("removePack(%s)", str);
    }

    /* renamed from: j */
    public final void mo30702j() {
        f675a.mo17057d("keepAlive", new Object[0]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final /* synthetic */ void mo30801l(Intent intent) {
        this.f678c.mo17084a(this.f680e, intent);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final /* synthetic */ void mo30802m(int i, String str) {
        try {
            m539s(i, str, 4);
        } catch (LocalTestingException e) {
            f675a.mo17058e("notifyModuleCompleted failed", e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public final /* synthetic */ void mo30803n(List list, C1569as asVar, C1786i iVar) {
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                AssetPackState p = m536p(str, asVar.mo30709a(8, str));
                j += p.totalBytesToDownload();
                hashMap.put(str, p);
            } catch (LocalTestingException e) {
                iVar.mo31063b(e);
                return;
            }
        }
        iVar.mo31062a(AssetPackStates.m358a(j, hashMap));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public final /* synthetic */ void mo30804o(List list, C1786i iVar, List list2) {
        C1786i iVar2 = iVar;
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                AssetPackState p = m536p(str, 1);
                j += p.totalBytesToDownload();
                hashMap.put(str, p);
            } catch (LocalTestingException e) {
                iVar2.mo31063b(e);
                return;
            }
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            try {
                int andIncrement = f676h.getAndIncrement();
                m539s(andIncrement, str2, 1);
                m539s(andIncrement, str2, 2);
                m539s(andIncrement, str2, 3);
            } catch (LocalTestingException e2) {
                iVar2.mo31063b(e2);
                return;
            }
        }
        Iterator it3 = list2.iterator();
        while (it3.hasNext()) {
            String str3 = (String) it3.next();
            hashMap.put(str3, AssetPackState.m354c(str3, 4, 0, 0, 0, 0.0d, 1, ""));
        }
        iVar2.mo31062a(AssetPackStates.m358a(j, hashMap));
    }
}
