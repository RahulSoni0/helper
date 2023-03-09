package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.appupdate.b */
final class C1528b extends ResultReceiver {

    /* renamed from: a */
    final /* synthetic */ C1786i f354a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1528b(Handler handler, C1786i iVar) {
        super(handler);
        this.f354a = iVar;
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        C1786i iVar;
        int i2 = 1;
        if (i == 1) {
            iVar = this.f354a;
            i2 = -1;
        } else if (i != 2) {
            iVar = this.f354a;
        } else {
            iVar = this.f354a;
            i2 = 0;
        }
        iVar.mo31066e(Integer.valueOf(i2));
    }
}
