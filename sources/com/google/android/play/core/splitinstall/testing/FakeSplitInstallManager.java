package com.google.android.play.core.splitinstall.testing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.internal.C0950ax;
import com.google.android.play.core.internal.C1671af;
import com.google.android.play.core.internal.C1689bo;
import com.google.android.play.core.splitcompat.C0989p;
import com.google.android.play.core.splitinstall.C0993e;
import com.google.android.play.core.splitinstall.C0996h;
import com.google.android.play.core.splitinstall.C0998l;
import com.google.android.play.core.splitinstall.C1002p;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FakeSplitInstallManager implements SplitInstallManager {

    /* renamed from: a */
    public static final /* synthetic */ int f988a = 0;

    /* renamed from: c */
    private static final long f989c = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: b */
    private final Handler f990b;

    /* renamed from: d */
    private final Context f991d;

    /* renamed from: e */
    private final C1002p f992e;

    /* renamed from: f */
    private final C1689bo f993f;

    /* renamed from: g */
    private final C1671af<SplitInstallSessionState> f994g;

    /* renamed from: h */
    private final C1671af<SplitInstallSessionState> f995h;

    /* renamed from: i */
    private final Executor f996i;

    /* renamed from: j */
    private final C0993e f997j;

    /* renamed from: k */
    private final File f998k;

    /* renamed from: l */
    private final AtomicReference<SplitInstallSessionState> f999l;

    /* renamed from: m */
    private final Set<String> f1000m;

    /* renamed from: n */
    private final Set<String> f1001n;

    /* renamed from: o */
    private final AtomicBoolean f1002o;

    /* renamed from: p */
    private final C1763a f1003p;

    @Deprecated
    public FakeSplitInstallManager(Context context, File file) {
        this(context, file, new C1002p(context, context.getPackageName()));
    }

    FakeSplitInstallManager(Context context, File file, C1002p pVar) {
        Executor a = C0989p.m202a();
        C1689bo boVar = new C1689bo(context);
        C1763a aVar = C1763a.f1005a;
        this.f990b = new Handler(Looper.getMainLooper());
        this.f999l = new AtomicReference<>();
        this.f1000m = Collections.synchronizedSet(new HashSet());
        this.f1001n = Collections.synchronizedSet(new HashSet());
        this.f1002o = new AtomicBoolean(false);
        this.f991d = context;
        this.f998k = file;
        this.f992e = pVar;
        this.f996i = a;
        this.f993f = boVar;
        this.f1003p = aVar;
        this.f995h = new C1671af<>();
        this.f994g = new C1671af<>();
        this.f997j = C0998l.f202a;
    }

    /* renamed from: g */
    static final /* synthetic */ SplitInstallSessionState m902g(int i, SplitInstallSessionState splitInstallSessionState) {
        int status;
        if (splitInstallSessionState != null && i == splitInstallSessionState.sessionId() && ((status = splitInstallSessionState.status()) == 1 || status == 2 || status == 8 || status == 9 || status == 7)) {
            return SplitInstallSessionState.create(i, 7, splitInstallSessionState.errorCode(), splitInstallSessionState.bytesDownloaded(), splitInstallSessionState.totalBytesToDownload(), splitInstallSessionState.moduleNames(), splitInstallSessionState.languages());
        }
        throw new SplitInstallException(-3);
    }

    /* renamed from: i */
    static final /* synthetic */ SplitInstallSessionState m903i(Integer num, int i, int i2, Long l, Long l2, List list, List list2, SplitInstallSessionState splitInstallSessionState) {
        SplitInstallSessionState create = splitInstallSessionState == null ? SplitInstallSessionState.create(0, 0, 0, 0, 0, new ArrayList(), new ArrayList()) : splitInstallSessionState;
        return SplitInstallSessionState.create(num == null ? create.sessionId() : num.intValue(), i, i2, l == null ? create.bytesDownloaded() : l.longValue(), l2 == null ? create.totalBytesToDownload() : l2.longValue(), list == null ? create.moduleNames() : list, list2 == null ? create.languages() : list2);
    }

    /* renamed from: n */
    private final SplitInstallSessionState m908n() {
        return this.f999l.get();
    }

    /* renamed from: o */
    private final synchronized SplitInstallSessionState m909o(C1771i iVar) {
        SplitInstallSessionState n = m908n();
        SplitInstallSessionState a = iVar.mo31038a(n);
        if (this.f999l.compareAndSet(n, a)) {
            return a;
        }
        return null;
    }

    /* renamed from: p */
    private final boolean m910p(int i, int i2, Long l, Long l2, List<String> list, Integer num, List<String> list2) {
        SplitInstallSessionState o = m909o(new C1764b(num, i, i2, l, l2, list, list2));
        if (o == null) {
            return false;
        }
        m914t(o);
        return true;
    }

    /* renamed from: q */
    private final Task<Integer> m911q(int i) {
        m909o(new C1767e(i, (byte[]) null));
        return Tasks.m943b(new SplitInstallException(i));
    }

    /* renamed from: r */
    private static String m912r(String str) {
        return str.split("\\.config\\.", 2)[0];
    }

    /* renamed from: s */
    private final C0996h m913s() {
        C0996h c = this.f992e.mo17140c();
        if (c != null) {
            return c;
        }
        throw new IllegalStateException("Language information could not be found. Make sure you are using the target application context, not the tests context, and the app is built as a bundle.");
    }

    /* renamed from: t */
    private final void m914t(SplitInstallSessionState splitInstallSessionState) {
        this.f990b.post(new C1768f(this, splitInstallSessionState));
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public final void m915u(List<Intent> list, List<String> list2, List<String> list3, long j, boolean z) {
        List<Intent> list4 = list;
        this.f997j.mo17131a().mo17060a(list, new C1770h(this, list2, list3, j, z, list));
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public final void m916v(List<String> list, List<String> list2, long j) {
        this.f1000m.addAll(list);
        this.f1001n.addAll(list2);
        Long valueOf = Long.valueOf(j);
        m910p(5, 0, valueOf, valueOf, (List<String>) null, (Integer) null, (List<String>) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public final boolean m917w(int i) {
        return m910p(6, i, (Long) null, (Long) null, (List<String>) null, (Integer) null, (List<String>) null);
    }

    /* renamed from: a */
    public final void mo30983a(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f994g.mo30883a(splitInstallStateUpdatedListener);
    }

    /* renamed from: b */
    public final void mo30984b(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f994g.mo30884b(splitInstallStateUpdatedListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final File mo31032c() {
        return this.f998k;
    }

    public final Task<Void> cancelInstall(int i) {
        try {
            SplitInstallSessionState o = m909o(new C1767e(i));
            if (o != null) {
                m914t(o);
            }
            return Tasks.m942a(null);
        } catch (SplitInstallException e) {
            return Tasks.m943b(e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void mo31033d(List list, List list2, List list3, long j) {
        if (this.f1002o.get()) {
            m917w(-6);
        } else if (this.f997j.mo17131a() != null) {
            m915u(list, list2, list3, j, false);
        } else {
            m916v(list2, list3, j);
        }
    }

    public final Task<Void> deferredInstall(List<String> list) {
        return Tasks.m943b(new SplitInstallException(-5));
    }

    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return Tasks.m943b(new SplitInstallException(-5));
    }

    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return Tasks.m943b(new SplitInstallException(-5));
    }

    public final Task<Void> deferredUninstall(List<String> list) {
        return Tasks.m943b(new SplitInstallException(-5));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final /* synthetic */ void mo31034e(long j, List list, List list2, List list3) {
        long j2 = j;
        long j3 = j2 / 3;
        long j4 = 0;
        int i = 0;
        while (i < 3) {
            j4 = Math.min(j2, j4 + j3);
            m910p(2, 0, Long.valueOf(j4), Long.valueOf(j), (List<String>) null, (Integer) null, (List<String>) null);
            SystemClock.sleep(f989c);
            SplitInstallSessionState n = m908n();
            if (n.status() != 9 && n.status() != 7 && n.status() != 6) {
                i++;
            } else {
                return;
            }
        }
        this.f996i.execute(new C1769g(this, list, list2, list3, j));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final /* synthetic */ void mo31035f(SplitInstallSessionState splitInstallSessionState) {
        this.f994g.mo30885c(splitInstallSessionState);
        this.f995h.mo30885c(splitInstallSessionState);
    }

    public final Set<String> getInstalledLanguages() {
        HashSet hashSet = new HashSet();
        if (this.f992e.mo17139b() != null) {
            hashSet.addAll(this.f992e.mo17139b());
        }
        hashSet.addAll(this.f1001n);
        return hashSet;
    }

    public final Set<String> getInstalledModules() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.f992e.mo17138a());
        hashSet.addAll(this.f1000m);
        return hashSet;
    }

    public final Task<SplitInstallSessionState> getSessionState(int i) {
        SplitInstallSessionState n = m908n();
        return (n == null || n.sessionId() != i) ? Tasks.m943b(new SplitInstallException(-4)) : Tasks.m942a(n);
    }

    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        SplitInstallSessionState n = m908n();
        return Tasks.m942a(n != null ? Collections.singletonList(n) : Collections.emptyList());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final /* synthetic */ void mo31036h(List list, List list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            String b = C0950ax.m69b(file);
            Uri fromFile = Uri.fromFile(file);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(fromFile, this.f991d.getContentResolver().getType(fromFile));
            intent.addFlags(1);
            intent.putExtra("module_name", m912r(b));
            intent.putExtra("split_id", b);
            arrayList.add(intent);
            arrayList2.add(m912r(C0950ax.m69b(file)));
        }
        SplitInstallSessionState n = m908n();
        if (n != null) {
            this.f996i.execute(new C1769g(this, n.totalBytesToDownload(), (List) arrayList, (List) arrayList2, list2));
        }
    }

    public final void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f995h.mo30883a(splitInstallStateUpdatedListener);
    }

    public void setShouldNetworkError(boolean z) {
        this.f1002o.set(z);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i) throws IntentSender.SendIntentException {
        return false;
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, IntentSenderForResultStarter intentSenderForResultStarter, int i) throws IntentSender.SendIntentException {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0131, code lost:
        if (r0.contains(r6) == false) goto L_0x013a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.play.core.tasks.Task<java.lang.Integer> startInstall(com.google.android.play.core.splitinstall.SplitInstallRequest r22) {
        /*
            r21 = this;
            r9 = r21
            com.google.android.play.core.splitinstall.testing.d r0 = new com.google.android.play.core.splitinstall.testing.d     // Catch:{ SplitInstallException -> 0x021d }
            r1 = r22
            r0.<init>(r1)     // Catch:{ SplitInstallException -> 0x021d }
            com.google.android.play.core.splitinstall.SplitInstallSessionState r0 = r9.m909o(r0)     // Catch:{ SplitInstallException -> 0x021d }
            if (r0 == 0) goto L_0x0216
            int r0 = r0.sessionId()     // Catch:{ SplitInstallException -> 0x021d }
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r2 = r22.getLanguages()
            java.util.Iterator r2 = r2.iterator()
        L_0x0020:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0034
            java.lang.Object r3 = r2.next()
            java.util.Locale r3 = (java.util.Locale) r3
            java.lang.String r3 = r3.getLanguage()
            r10.add(r3)
            goto L_0x0020
        L_0x0034:
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.io.File r3 = r9.f998k
            java.io.File[] r3 = r3.listFiles()
            java.lang.String r4 = "FakeSplitInstallManager"
            if (r3 != 0) goto L_0x0053
            java.lang.String r0 = "Specified splits directory does not exist."
            android.util.Log.w(r4, r0)
            r0 = -5
            com.google.android.play.core.tasks.Task r0 = r9.m911q(r0)
            return r0
        L_0x0053:
            int r5 = r3.length
            r12 = 0
            r13 = 0
        L_0x0057:
            if (r12 >= r5) goto L_0x019a
            r15 = r3[r12]
            java.lang.String r6 = com.google.android.play.core.internal.C0950ax.m69b(r15)
            java.lang.String r7 = m912r(r6)
            r2.add(r6)
            java.util.List r8 = r22.getModuleNames()
            boolean r7 = r8.contains(r7)
            if (r7 == 0) goto L_0x0134
            java.lang.String r7 = m912r(r6)
            java.util.HashSet r8 = new java.util.HashSet
            com.google.android.play.core.internal.bo r1 = r9.f993f
            java.util.List r1 = r1.mo30919a()
            r8.<init>(r1)
            com.google.android.play.core.splitinstall.h r1 = r21.m913s()
            r17 = r3
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]
            r16 = 0
            r3[r16] = r7
            java.util.List r3 = java.util.Arrays.asList(r3)
            java.util.Map r1 = r1.mo17134a(r3)
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.Collection r7 = r1.values()
            java.util.Iterator r7 = r7.iterator()
        L_0x00a1:
            boolean r18 = r7.hasNext()
            if (r18 == 0) goto L_0x00b7
            java.lang.Object r18 = r7.next()
            r19 = r5
            r5 = r18
            java.util.Set r5 = (java.util.Set) r5
            r3.addAll(r5)
            r5 = r19
            goto L_0x00a1
        L_0x00b7:
            r19 = r5
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            java.util.Iterator r7 = r8.iterator()
        L_0x00c2:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00ee
            java.lang.Object r8 = r7.next()
            java.lang.String r8 = (java.lang.String) r8
            r18 = r7
            java.lang.String r7 = "_"
            boolean r20 = r8.contains(r7)
            if (r20 == 0) goto L_0x00e3
            r20 = r0
            r0 = -1
            java.lang.String[] r0 = r8.split(r7, r0)
            r7 = 0
            r8 = r0[r7]
            goto L_0x00e6
        L_0x00e3:
            r20 = r0
            r7 = 0
        L_0x00e6:
            r5.add(r8)
            r7 = r18
            r0 = r20
            goto L_0x00c2
        L_0x00ee:
            r20 = r0
            r7 = 0
            java.util.Set<java.lang.String> r0 = r9.f1001n
            r5.addAll(r0)
            r5.addAll(r10)
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0106:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L_0x0127
            java.lang.Object r8 = r1.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            java.lang.Object r7 = r8.getKey()
            boolean r7 = r5.contains(r7)
            if (r7 == 0) goto L_0x0125
            java.lang.Object r7 = r8.getValue()
            java.util.Collection r7 = (java.util.Collection) r7
            r0.addAll(r7)
        L_0x0125:
            r7 = 0
            goto L_0x0106
        L_0x0127:
            boolean r1 = r3.contains(r6)
            if (r1 == 0) goto L_0x0186
            boolean r0 = r0.contains(r6)
            if (r0 == 0) goto L_0x013a
            goto L_0x0186
        L_0x0134:
            r20 = r0
            r17 = r3
            r19 = r5
        L_0x013a:
            java.util.List r0 = r22.getLanguages()
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Set<java.lang.String> r3 = r9.f1000m
            r1.<init>(r3)
            java.lang.String r3 = ""
            java.lang.String r5 = "base"
            java.lang.String[] r3 = new java.lang.String[]{r3, r5}
            java.util.List r3 = java.util.Arrays.asList(r3)
            r1.addAll(r3)
            com.google.android.play.core.splitinstall.h r3 = r21.m913s()
            java.util.Map r1 = r3.mo17134a(r1)
            java.util.Iterator r0 = r0.iterator()
        L_0x0160:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x018e
            java.lang.Object r3 = r0.next()
            java.util.Locale r3 = (java.util.Locale) r3
            java.lang.String r5 = r3.getLanguage()
            boolean r5 = r1.containsKey(r5)
            if (r5 == 0) goto L_0x0160
            java.lang.String r3 = r3.getLanguage()
            java.lang.Object r3 = r1.get(r3)
            java.util.Set r3 = (java.util.Set) r3
            boolean r3 = r3.contains(r6)
            if (r3 == 0) goto L_0x0160
        L_0x0186:
            long r0 = r15.length()
            long r13 = r13 + r0
            r11.add(r15)
        L_0x018e:
            int r12 = r12 + 1
            r1 = r22
            r3 = r17
            r5 = r19
            r0 = r20
            goto L_0x0057
        L_0x019a:
            r20 = r0
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.util.List r1 = r22.getModuleNames()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            java.lang.String r5 = java.lang.String.valueOf(r1)
            int r5 = r5.length()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            int r3 = r3 + 22
            int r3 = r3 + r5
            r6.<init>(r3)
            java.lang.String r3 = "availableSplits "
            r6.append(r3)
            r6.append(r0)
            java.lang.String r0 = " want "
            r6.append(r0)
            r6.append(r1)
            java.lang.String r0 = r6.toString()
            android.util.Log.i(r4, r0)
            java.util.HashSet r0 = new java.util.HashSet
            java.util.List r1 = r22.getModuleNames()
            r0.<init>(r1)
            boolean r0 = r2.containsAll(r0)
            if (r0 != 0) goto L_0x01ec
            r0 = -2
            com.google.android.play.core.tasks.Task r0 = r9.m911q(r0)
            return r0
        L_0x01ec:
            r0 = 0
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
            java.lang.Long r5 = java.lang.Long.valueOf(r13)
            java.util.List r6 = r22.getModuleNames()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r20)
            r2 = 1
            r3 = 0
            r1 = r21
            r7 = r0
            r8 = r10
            r1.m910p(r2, r3, r4, r5, r6, r7, r8)
            java.util.concurrent.Executor r1 = r9.f996i
            com.google.android.play.core.splitinstall.testing.c r2 = new com.google.android.play.core.splitinstall.testing.c
            r2.<init>(r9, r11, r10)
            r1.execute(r2)
            com.google.android.play.core.tasks.Task r0 = com.google.android.play.core.tasks.Tasks.m942a(r0)
            return r0
        L_0x0216:
            r0 = -100
            com.google.android.play.core.tasks.Task r0 = r9.m911q(r0)     // Catch:{ SplitInstallException -> 0x021d }
            return r0
        L_0x021d:
            r0 = move-exception
            int r0 = r0.getErrorCode()
            com.google.android.play.core.tasks.Task r0 = r9.m911q(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager.startInstall(com.google.android.play.core.splitinstall.SplitInstallRequest):com.google.android.play.core.tasks.Task");
    }

    public final void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f995h.mo30884b(splitInstallStateUpdatedListener);
    }
}
