package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.listener.C0973b;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: com.google.android.play.core.splitinstall.s */
public final class C1003s extends C0973b<SplitInstallSessionState> {

    /* renamed from: c */
    private static C1003s f208c;

    /* renamed from: d */
    private final Handler f209d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    private final C0993e f210e;

    /* renamed from: f */
    private final Set<SplitInstallStateUpdatedListener> f211f = new LinkedHashSet();

    public C1003s(Context context, C0993e eVar) {
        super(new C0944ag("SplitInstallListenerRegistry"), new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService"), context);
        this.f210e = eVar;
    }

    /* renamed from: b */
    public static synchronized C1003s m235b(Context context) {
        C1003s sVar;
        synchronized (C1003s.class) {
            if (f208c == null) {
                f208c = new C1003s(context, C0998l.f202a);
            }
            sVar = f208c;
        }
        return sVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo17084a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("session_state");
        if (bundleExtra != null) {
            SplitInstallSessionState d = SplitInstallSessionState.m836d(bundleExtra);
            this.f159a.mo17054a("ListenerRegistryBroadcastReceiver.onReceive: %s", d);
            C0994f a = this.f210e.mo17131a();
            if (d.status() != 3 || a == null) {
                mo17143k(d);
            } else {
                a.mo17060a(d.mo31008c(), new C1760q(this, d, intent, context));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final synchronized void mo17141c(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f211f.add(splitInstallStateUpdatedListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final synchronized void mo17142d(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f211f.remove(splitInstallStateUpdatedListener);
    }

    /* renamed from: k */
    public final synchronized void mo17143k(SplitInstallSessionState splitInstallSessionState) {
        Iterator it = new LinkedHashSet(this.f211f).iterator();
        while (it.hasNext()) {
            ((SplitInstallStateUpdatedListener) it.next()).onStateUpdate(splitInstallSessionState);
        }
        super.mo17089i(splitInstallSessionState);
    }
}
