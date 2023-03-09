package com.google.android.play.core.splitinstall;

/* renamed from: com.google.android.play.core.splitinstall.r */
final class C1761r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SplitInstallSessionState f982a;

    /* renamed from: b */
    final /* synthetic */ int f983b;

    /* renamed from: c */
    final /* synthetic */ int f984c;

    /* renamed from: d */
    final /* synthetic */ C1003s f985d;

    C1761r(C1003s sVar, SplitInstallSessionState splitInstallSessionState, int i, int i2) {
        this.f985d = sVar;
        this.f982a = splitInstallSessionState;
        this.f983b = i;
        this.f984c = i2;
    }

    public final void run() {
        C1003s sVar = this.f985d;
        SplitInstallSessionState splitInstallSessionState = this.f982a;
        sVar.mo17143k(new C1732a(splitInstallSessionState.sessionId(), this.f983b, this.f984c, splitInstallSessionState.bytesDownloaded(), splitInstallSessionState.totalBytesToDownload(), splitInstallSessionState.mo31005a(), splitInstallSessionState.mo31006b(), splitInstallSessionState.resolutionIntent(), splitInstallSessionState.mo31008c()));
    }
}
