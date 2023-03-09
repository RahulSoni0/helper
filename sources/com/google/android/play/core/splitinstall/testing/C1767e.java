package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;

/* renamed from: com.google.android.play.core.splitinstall.testing.e */
final /* synthetic */ class C1767e implements C1771i {

    /* renamed from: a */
    private final int f1017a;

    /* renamed from: b */
    private final /* synthetic */ int f1018b = 0;

    C1767e(int i) {
        this.f1017a = i;
    }

    C1767e(int i, byte[] bArr) {
        this.f1017a = i;
    }

    /* renamed from: a */
    public final SplitInstallSessionState mo31038a(SplitInstallSessionState splitInstallSessionState) {
        if (this.f1018b == 0) {
            return FakeSplitInstallManager.m902g(this.f1017a, splitInstallSessionState);
        }
        int i = this.f1017a;
        int i2 = FakeSplitInstallManager.f988a;
        if (splitInstallSessionState == null) {
            return null;
        }
        return SplitInstallSessionState.create(splitInstallSessionState.sessionId(), 6, i, splitInstallSessionState.bytesDownloaded(), splitInstallSessionState.totalBytesToDownload(), splitInstallSessionState.moduleNames(), splitInstallSessionState.languages());
    }
}
