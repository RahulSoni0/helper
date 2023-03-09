package com.google.android.play.core.assetpacks;

import android.os.Bundle;

/* renamed from: com.google.android.play.core.assetpacks.ap */
final /* synthetic */ class C1566ap implements Runnable {

    /* renamed from: a */
    private final C1568ar f484a;

    /* renamed from: b */
    private final Bundle f485b;

    /* renamed from: c */
    private final AssetPackState f486c;

    C1566ap(C1568ar arVar, Bundle bundle, AssetPackState assetPackState) {
        this.f484a = arVar;
        this.f485b = bundle;
        this.f486c = assetPackState;
    }

    public final void run() {
        this.f484a.mo30708d(this.f485b, this.f486c);
    }
}
