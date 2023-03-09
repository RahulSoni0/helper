package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.tasks.C1786i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

/* renamed from: com.google.android.play.core.appupdate.d */
final class C1530d implements AppUpdateManager {

    /* renamed from: a */
    private final C1541o f356a;

    /* renamed from: b */
    private final C1527a f357b;

    /* renamed from: c */
    private final Context f358c;

    /* renamed from: d */
    private final Handler f359d = new Handler(Looper.getMainLooper());

    C1530d(C1541o oVar, C1527a aVar, Context context) {
        this.f356a = oVar;
        this.f357b = aVar;
        this.f358c = context;
    }

    public final Task<Void> completeUpdate() {
        return this.f356a.mo30611b(this.f358c.getPackageName());
    }

    public final Task<AppUpdateInfo> getAppUpdateInfo() {
        return this.f356a.mo30610a(this.f358c.getPackageName());
    }

    public final synchronized void registerListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f357b.mo17086f(installStateUpdatedListener);
    }

    public final Task<Integer> startUpdateFlow(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions) {
        PlayCoreDialogWrapperActivity.m655a(this.f358c);
        if (!appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions)) {
            return Tasks.m943b(new InstallException(-6));
        }
        Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", appUpdateInfo.mo30579h(appUpdateOptions));
        C1786i iVar = new C1786i();
        intent.putExtra("result_receiver", new C1528b(this.f359d, iVar));
        activity.startActivity(intent);
        return iVar.mo31064c();
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, int i, Activity activity, int i2) throws IntentSender.SendIntentException {
        return startUpdateFlowForResult(appUpdateInfo, (IntentSenderForResultStarter) new C1529c(activity), AppUpdateOptions.defaultOptions(i), i2);
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, int i, IntentSenderForResultStarter intentSenderForResultStarter, int i2) throws IntentSender.SendIntentException {
        return startUpdateFlowForResult(appUpdateInfo, intentSenderForResultStarter, AppUpdateOptions.defaultOptions(i), i2);
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions, int i) throws IntentSender.SendIntentException {
        return startUpdateFlowForResult(appUpdateInfo, (IntentSenderForResultStarter) new C1529c(activity), appUpdateOptions, i);
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, IntentSenderForResultStarter intentSenderForResultStarter, AppUpdateOptions appUpdateOptions, int i) throws IntentSender.SendIntentException {
        if (!appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions)) {
            return false;
        }
        intentSenderForResultStarter.startIntentSenderForResult(appUpdateInfo.mo30579h(appUpdateOptions).getIntentSender(), i, (Intent) null, 0, 0, 0, (Bundle) null);
        return true;
    }

    public final synchronized void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f357b.mo17087g(installStateUpdatedListener);
    }
}
