package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.review.b */
final class C1723b extends ResultReceiver {

    /* renamed from: a */
    final /* synthetic */ C1786i f894a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1723b(Handler handler, C1786i iVar) {
        super(handler);
        this.f894a = iVar;
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        this.f894a.mo31066e(null);
    }
}
