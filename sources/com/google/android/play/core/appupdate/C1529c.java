package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.play.core.common.IntentSenderForResultStarter;

/* renamed from: com.google.android.play.core.appupdate.c */
final class C1529c implements IntentSenderForResultStarter {

    /* renamed from: a */
    final /* synthetic */ Activity f355a;

    C1529c(Activity activity) {
        this.f355a = activity;
    }

    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        this.f355a.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
