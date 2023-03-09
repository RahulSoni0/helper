package com.google.android.play.core.splitcompat;

import android.util.Log;

/* renamed from: com.google.android.play.core.splitcompat.n */
final class C0987n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SplitCompat f192a;

    C0987n(SplitCompat splitCompat) {
        this.f192a = splitCompat;
    }

    public final void run() {
        try {
            this.f192a.f167b.mo17099a();
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to cleanup splitcompat storage", e);
        }
    }
}
