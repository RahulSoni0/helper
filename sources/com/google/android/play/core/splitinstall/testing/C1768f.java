package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;

/* renamed from: com.google.android.play.core.splitinstall.testing.f */
final /* synthetic */ class C1768f implements Runnable {

    /* renamed from: a */
    private final FakeSplitInstallManager f1019a;

    /* renamed from: b */
    private final SplitInstallSessionState f1020b;

    C1768f(FakeSplitInstallManager fakeSplitInstallManager, SplitInstallSessionState splitInstallSessionState) {
        this.f1019a = fakeSplitInstallManager;
        this.f1020b = splitInstallSessionState;
    }

    public final void run() {
        this.f1019a.mo31035f(this.f1020b);
    }
}
