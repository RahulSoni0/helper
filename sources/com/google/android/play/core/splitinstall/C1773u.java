package com.google.android.play.core.splitinstall;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.play.core.common.IntentSenderForResultStarter;

/* renamed from: com.google.android.play.core.splitinstall.u */
final class C1773u implements IntentSenderForResultStarter {

    /* renamed from: a */
    final /* synthetic */ Activity f1036a;

    C1773u(Activity activity) {
        this.f1036a = activity;
    }

    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        this.f1036a.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }
}
