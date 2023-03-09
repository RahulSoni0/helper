package com.google.android.play.core.splitcompat;

import android.util.Log;
import java.util.Set;

/* renamed from: com.google.android.play.core.splitcompat.o */
final class C0988o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Set f193a;

    /* renamed from: b */
    final /* synthetic */ SplitCompat f194b;

    C0988o(SplitCompat splitCompat, Set set) {
        this.f194b = splitCompat;
        this.f193a = set;
    }

    public final void run() {
        try {
            for (String n : this.f193a) {
                this.f194b.f167b.mo17112n(n);
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to remove from splitcompat storage split that is already installed", e);
        }
    }
}
