package com.google.android.play.core.internal;

import android.util.Log;
import com.google.android.play.core.splitinstall.C0992d;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.as */
final class C0945as implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f129a;

    /* renamed from: b */
    final /* synthetic */ C0992d f130b;

    /* renamed from: c */
    final /* synthetic */ C0946at f131c;

    C0945as(C0946at atVar, List list, C0992d dVar) {
        this.f131c = atVar;
        this.f129a = list;
        this.f130b = dVar;
    }

    public final void run() {
        try {
            if (this.f131c.f134c.mo17065c(this.f129a)) {
                C0946at.m55c(this.f131c, this.f130b);
            } else {
                C0946at.m56d(this.f131c, this.f129a, this.f130b);
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Error checking verified files.", e);
            this.f130b.mo17130c(-11);
        }
    }
}
