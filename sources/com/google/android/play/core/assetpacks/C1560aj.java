package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.assetpacks.aj */
final class C1560aj extends C1557ag<Void> {

    /* renamed from: c */
    final /* synthetic */ C1564an f466c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1560aj(C1564an anVar, C1786i<Void> iVar) {
        super(anVar, iVar);
        this.f466c = anVar;
    }

    /* renamed from: d */
    public final void mo30682d(Bundle bundle, Bundle bundle2) {
        super.mo30682d(bundle, bundle2);
        if (!this.f466c.f481g.compareAndSet(true, false)) {
            C1564an.f475a.mo17058e("Expected keepingAlive to be true, but was false.", new Object[0]);
        }
        if (bundle.getBoolean("keep_alive")) {
            this.f466c.mo30702j();
        }
    }
}
