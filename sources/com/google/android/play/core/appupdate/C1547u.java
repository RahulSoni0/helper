package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.splitcompat.C0989p;

/* renamed from: com.google.android.play.core.appupdate.u */
public final /* synthetic */ class C1547u {

    /* renamed from: a */
    private static C1549w f421a;

    /* renamed from: a */
    static synchronized C1549w m347a(Context context) {
        C1549w wVar;
        synchronized (C1547u.class) {
            if (f421a == null) {
                C1548v vVar = new C1548v((byte[]) null);
                vVar.mo30640b(new C1532f(C0989p.m204c(context)));
                f421a = vVar.mo30639a();
            }
            wVar = f421a;
        }
        return wVar;
    }
}
