package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.play.core.internal.aq */
public final class C1681aq<T extends IInterface> {

    /* renamed from: a */
    private static final Map<String, Handler> f853a = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f854b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C0944ag f855c;

    /* renamed from: d */
    private final String f856d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final List<C1672ah> f857e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f858f;

    /* renamed from: g */
    private final Intent f859g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C1677am<T> f860h;

    /* renamed from: i */
    private final WeakReference<C1676al> f861i;

    /* renamed from: j */
    private final IBinder.DeathRecipient f862j = new C1673ai(this);
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ServiceConnection f863k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public T f864l;

    public C1681aq(Context context, C0944ag agVar, String str, Intent intent, C1677am<T> amVar) {
        this.f854b = context;
        this.f855c = agVar;
        this.f856d = str;
        this.f859g = intent;
        this.f860h = amVar;
        this.f861i = new WeakReference<>((Object) null);
    }

    /* renamed from: d */
    static /* synthetic */ void m683d(C1681aq aqVar, C1672ah ahVar) {
        if (aqVar.f864l == null && !aqVar.f858f) {
            aqVar.f855c.mo17057d("Initiate binding to the service.", new Object[0]);
            aqVar.f857e.add(ahVar);
            C1680ap apVar = new C1680ap(aqVar);
            aqVar.f863k = apVar;
            aqVar.f858f = true;
            if (!aqVar.f854b.bindService(aqVar.f859g, apVar, 1)) {
                aqVar.f855c.mo17057d("Failed to bind to the service.", new Object[0]);
                aqVar.f858f = false;
                for (C1672ah b : aqVar.f857e) {
                    b.mo30886b(new C1682ar());
                }
                aqVar.f857e.clear();
            }
        } else if (aqVar.f858f) {
            aqVar.f855c.mo17057d("Waiting to bind to the service.", new Object[0]);
            aqVar.f857e.add(ahVar);
        } else {
            ahVar.run();
        }
    }

    /* renamed from: j */
    static /* synthetic */ void m689j(C1681aq aqVar) {
        aqVar.f855c.mo17057d("linkToDeath", new Object[0]);
        try {
            aqVar.f864l.asBinder().linkToDeath(aqVar.f862j, 0);
        } catch (RemoteException e) {
            aqVar.f855c.mo17056c(e, "linkToDeath failed", new Object[0]);
        }
    }

    /* renamed from: m */
    static /* synthetic */ void m692m(C1681aq aqVar) {
        aqVar.f855c.mo17057d("unlinkToDeath", new Object[0]);
        aqVar.f864l.asBinder().unlinkToDeath(aqVar.f862j, 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public final void m696r(C1672ah ahVar) {
        Handler handler;
        Map<String, Handler> map = f853a;
        synchronized (map) {
            if (!map.containsKey(this.f856d)) {
                HandlerThread handlerThread = new HandlerThread(this.f856d, 10);
                handlerThread.start();
                map.put(this.f856d, new Handler(handlerThread.getLooper()));
            }
            handler = map.get(this.f856d);
        }
        handler.post(ahVar);
    }

    /* renamed from: a */
    public final void mo30893a(C1672ah ahVar) {
        m696r(new C1674aj(this, ahVar.mo30887c(), ahVar));
    }

    /* renamed from: b */
    public final void mo30894b() {
        m696r(new C1675ak(this));
    }

    /* renamed from: c */
    public final T mo30895c() {
        return this.f864l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public final /* bridge */ /* synthetic */ void mo30896n() {
        this.f855c.mo17057d("reportBinderDeath", new Object[0]);
        C1676al alVar = (C1676al) this.f861i.get();
        if (alVar == null) {
            this.f855c.mo17057d("%s : Binder has died.", this.f856d);
            for (C1672ah b : this.f857e) {
                b.mo30886b(Build.VERSION.SDK_INT < 15 ? new RemoteException() : new RemoteException(String.valueOf(this.f856d).concat(" : Binder has died.")));
            }
            this.f857e.clear();
            return;
        }
        this.f855c.mo17057d("calling onBinderDied", new Object[0]);
        alVar.mo30890a();
    }
}
