package com.google.android.play.core.splitcompat;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.android.play.core.splitcompat.b */
final class C0975b implements ThreadFactory {
    C0975b() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "SplitCompatBackgroundThread");
    }
}
