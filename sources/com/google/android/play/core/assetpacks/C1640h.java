package com.google.android.play.core.assetpacks;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.assetpacks.h */
final class C1640h extends ResultReceiver {

    /* renamed from: a */
    final /* synthetic */ C1786i f769a;

    /* renamed from: b */
    final /* synthetic */ C1641i f770b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1640h(C1641i iVar, Handler handler, C1786i iVar2) {
        super(handler);
        this.f770b = iVar;
        this.f769a = iVar2;
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            this.f769a.mo31066e(-1);
            this.f770b.f778h.mo30764a((PendingIntent) null);
        } else if (i != 2) {
            this.f769a.mo31065d(new AssetPackException(-100));
        } else {
            this.f769a.mo31066e(0);
        }
    }
}
