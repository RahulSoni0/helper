package com.google.android.play.core.assetpacks;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.android.play.core.assetpacks.k */
final /* synthetic */ class C1643k implements ThreadFactory {

    /* renamed from: a */
    static final ThreadFactory f792a = new C1643k();

    /* renamed from: b */
    static final ThreadFactory f793b = new C1643k((byte[]) null);

    /* renamed from: c */
    private final /* synthetic */ int f794c = 0;

    private C1643k() {
    }

    private C1643k(byte[] bArr) {
    }

    public final Thread newThread(Runnable runnable) {
        return this.f794c != 0 ? new Thread(runnable, "AssetPackBackgroundExecutor") : new Thread(runnable, "UpdateListenerExecutor");
    }
}
