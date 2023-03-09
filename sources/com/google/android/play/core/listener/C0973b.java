package com.google.android.play.core.listener;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.internal.C0950ax;
import com.google.android.play.core.splitcompat.C0989p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.google.android.play.core.listener.b */
public abstract class C0973b<StateT> {

    /* renamed from: a */
    protected final C0944ag f159a;

    /* renamed from: b */
    protected final Set<StateUpdatedListener<StateT>> f160b = new HashSet();

    /* renamed from: c */
    private final IntentFilter f161c;

    /* renamed from: d */
    private final Context f162d;

    /* renamed from: e */
    private C1719a f163e = null;

    /* renamed from: f */
    private volatile boolean f164f = false;

    protected C0973b(C0944ag agVar, IntentFilter intentFilter, Context context) {
        this.f159a = agVar;
        this.f161c = intentFilter;
        this.f162d = C0989p.m204c(context);
    }

    /* renamed from: b */
    private final void m147b() {
        C1719a aVar;
        if ((this.f164f || !this.f160b.isEmpty()) && this.f163e == null) {
            C1719a aVar2 = new C1719a(this);
            this.f163e = aVar2;
            this.f162d.registerReceiver(aVar2, this.f161c);
        }
        if (!this.f164f && this.f160b.isEmpty() && (aVar = this.f163e) != null) {
            this.f162d.unregisterReceiver(aVar);
            this.f163e = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo17084a(Context context, Intent intent);

    /* renamed from: e */
    public final synchronized void mo17085e(boolean z) {
        this.f164f = z;
        m147b();
    }

    /* renamed from: f */
    public final synchronized void mo17086f(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f159a.mo17057d("registerListener", new Object[0]);
        C0950ax.m71d(stateUpdatedListener, "Registered Play Core listener should not be null.");
        this.f160b.add(stateUpdatedListener);
        m147b();
    }

    /* renamed from: g */
    public final synchronized void mo17087g(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f159a.mo17057d("unregisterListener", new Object[0]);
        C0950ax.m71d(stateUpdatedListener, "Unregistered Play Core listener should not be null.");
        this.f160b.remove(stateUpdatedListener);
        m147b();
    }

    /* renamed from: h */
    public final synchronized void mo17088h() {
        this.f159a.mo17057d("clearListeners", new Object[0]);
        this.f160b.clear();
        m147b();
    }

    /* renamed from: i */
    public final synchronized void mo17089i(StateT statet) {
        Iterator it = new HashSet(this.f160b).iterator();
        while (it.hasNext()) {
            ((StateUpdatedListener) it.next()).onStateUpdate(statet);
        }
    }

    /* renamed from: j */
    public final synchronized boolean mo17090j() {
        return this.f163e != null;
    }
}
