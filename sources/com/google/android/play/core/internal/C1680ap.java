package com.google.android.play.core.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: com.google.android.play.core.internal.ap */
final class C1680ap implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ C1681aq f852a;

    /* synthetic */ C1680ap(C1681aq aqVar) {
        this.f852a = aqVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f852a.f855c.mo17057d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.f852a.m696r(new C1678an(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f852a.f855c.mo17057d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.f852a.m696r(new C1679ao(this));
    }
}
