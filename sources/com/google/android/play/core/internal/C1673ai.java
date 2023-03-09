package com.google.android.play.core.internal;

import android.os.IBinder;

/* renamed from: com.google.android.play.core.internal.ai */
final /* synthetic */ class C1673ai implements IBinder.DeathRecipient {

    /* renamed from: a */
    private final C1681aq f845a;

    C1673ai(C1681aq aqVar) {
        this.f845a = aqVar;
    }

    public final void binderDied() {
        this.f845a.mo30896n();
    }
}
