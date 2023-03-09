package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.OnFailureListener;

/* renamed from: com.google.android.play.core.assetpacks.g */
final /* synthetic */ class C1639g implements OnFailureListener {

    /* renamed from: a */
    static final OnFailureListener f768a = new C1639g();

    private C1639g() {
    }

    public final void onFailure(Exception exc) {
        C1641i.f771a.mo17058e(String.format("Could not sync active asset packs. %s", new Object[]{exc}), new Object[0]);
    }
}
