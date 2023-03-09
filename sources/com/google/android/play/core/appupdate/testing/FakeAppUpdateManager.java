package com.google.android.play.core.appupdate.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateOptions;
import com.google.android.play.core.appupdate.C1527a;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.util.ArrayList;
import java.util.List;

public class FakeAppUpdateManager implements AppUpdateManager {

    /* renamed from: a */
    private final C1527a f406a;

    /* renamed from: b */
    private final Context f407b;

    /* renamed from: c */
    private final List<Integer> f408c = new ArrayList();

    /* renamed from: d */
    private int f409d = 0;

    /* renamed from: e */
    private int f410e = 0;

    /* renamed from: f */
    private boolean f411f = false;

    /* renamed from: g */
    private int f412g = 0;

    /* renamed from: h */
    private Integer f413h = null;

    /* renamed from: i */
    private int f414i = 0;

    /* renamed from: j */
    private long f415j = 0;

    /* renamed from: k */
    private long f416k = 0;

    /* renamed from: l */
    private boolean f417l = false;

    /* renamed from: m */
    private boolean f418m = false;

    /* renamed from: n */
    private boolean f419n = false;

    /* renamed from: o */
    private Integer f420o;

    public FakeAppUpdateManager(Context context) {
        this.f406a = new C1527a(context);
        this.f407b = context;
    }

    /* renamed from: a */
    private final boolean m344a(AppUpdateInfo appUpdateInfo, AppUpdateOptions appUpdateOptions) {
        int i;
        if (!appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions) && (!AppUpdateOptions.defaultOptions(appUpdateOptions.appUpdateType()).equals(appUpdateOptions) || !appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions.appUpdateType()))) {
            return false;
        }
        if (appUpdateOptions.appUpdateType() == 1) {
            this.f418m = true;
            i = 1;
        } else {
            this.f417l = true;
            i = 0;
        }
        this.f420o = i;
        return true;
    }

    /* renamed from: b */
    private final int m345b() {
        if (!this.f411f) {
            return 1;
        }
        int i = this.f409d;
        return (i == 0 || i == 4 || i == 5 || i == 6) ? 2 : 3;
    }

    /* renamed from: c */
    private final void m346c() {
        this.f406a.mo17089i(InstallState.m664a(this.f409d, this.f415j, this.f416k, this.f410e, this.f407b.getPackageName()));
    }

    public Task<Void> completeUpdate() {
        int i = this.f410e;
        if (i != 0) {
            return Tasks.m943b(new InstallException(i));
        }
        int i2 = this.f409d;
        if (i2 != 11) {
            return i2 == 3 ? Tasks.m943b(new InstallException(-8)) : Tasks.m943b(new InstallException(-7));
        }
        this.f409d = 3;
        this.f419n = true;
        Integer num = 0;
        if (num.equals(this.f420o)) {
            m346c();
        }
        return Tasks.m942a(null);
    }

    public void downloadCompletes() {
        int i = this.f409d;
        if (i == 2 || i == 1) {
            this.f409d = 11;
            this.f415j = 0;
            this.f416k = 0;
            Integer num = 0;
            if (num.equals(this.f420o)) {
                m346c();
                return;
            }
            Integer num2 = 1;
            if (num2.equals(this.f420o)) {
                completeUpdate();
            }
        }
    }

    public void downloadFails() {
        int i = this.f409d;
        if (i == 1 || i == 2) {
            this.f409d = 5;
            Integer num = 0;
            if (num.equals(this.f420o)) {
                m346c();
            }
            this.f420o = null;
            this.f418m = false;
            this.f409d = 0;
        }
    }

    public void downloadStarts() {
        if (this.f409d == 1) {
            this.f409d = 2;
            Integer num = 0;
            if (num.equals(this.f420o)) {
                m346c();
            }
        }
    }

    public Task<AppUpdateInfo> getAppUpdateInfo() {
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        PendingIntent pendingIntent3;
        PendingIntent pendingIntent4;
        PendingIntent pendingIntent5;
        PendingIntent pendingIntent6;
        int i = this.f410e;
        if (i != 0) {
            return Tasks.m943b(new InstallException(i));
        }
        if (m345b() == 2 && this.f410e == 0) {
            if (this.f408c.contains(0)) {
                pendingIntent6 = PendingIntent.getBroadcast(this.f407b, 0, new Intent(), 0);
                pendingIntent5 = PendingIntent.getBroadcast(this.f407b, 0, new Intent(), 0);
            } else {
                pendingIntent6 = null;
                pendingIntent5 = null;
            }
            if (this.f408c.contains(1)) {
                PendingIntent broadcast = PendingIntent.getBroadcast(this.f407b, 0, new Intent(), 0);
                pendingIntent3 = pendingIntent6;
                pendingIntent2 = PendingIntent.getBroadcast(this.f407b, 0, new Intent(), 0);
                pendingIntent4 = broadcast;
            } else {
                pendingIntent3 = pendingIntent6;
                pendingIntent4 = null;
                pendingIntent2 = null;
            }
            pendingIntent = pendingIntent5;
        } else {
            pendingIntent4 = null;
            pendingIntent3 = null;
            pendingIntent2 = null;
            pendingIntent = null;
        }
        return Tasks.m942a(AppUpdateInfo.m302a(this.f407b.getPackageName(), this.f412g, m345b(), this.f409d, this.f413h, this.f414i, this.f415j, this.f416k, 0, 0, pendingIntent4, pendingIntent3, pendingIntent2, pendingIntent));
    }

    public Integer getTypeForUpdateInProgress() {
        return this.f420o;
    }

    public void installCompletes() {
        if (this.f409d == 3) {
            this.f409d = 4;
            this.f411f = false;
            this.f412g = 0;
            this.f413h = null;
            this.f414i = 0;
            this.f415j = 0;
            this.f416k = 0;
            this.f418m = false;
            this.f419n = false;
            Integer num = 0;
            if (num.equals(this.f420o)) {
                m346c();
            }
            this.f420o = null;
            this.f409d = 0;
        }
    }

    public void installFails() {
        if (this.f409d == 3) {
            this.f409d = 5;
            Integer num = 0;
            if (num.equals(this.f420o)) {
                m346c();
            }
            this.f420o = null;
            this.f419n = false;
            this.f418m = false;
            this.f409d = 0;
        }
    }

    public boolean isConfirmationDialogVisible() {
        return this.f417l;
    }

    public boolean isImmediateFlowVisible() {
        return this.f418m;
    }

    public boolean isInstallSplashScreenVisible() {
        return this.f419n;
    }

    public void registerListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f406a.mo17086f(installStateUpdatedListener);
    }

    public void setBytesDownloaded(long j) {
        if (this.f409d == 2 && j <= this.f416k) {
            this.f415j = j;
            Integer num = 0;
            if (num.equals(this.f420o)) {
                m346c();
            }
        }
    }

    public void setClientVersionStalenessDays(Integer num) {
        if (this.f411f) {
            this.f413h = num;
        }
    }

    public void setInstallErrorCode(int i) {
        this.f410e = i;
    }

    public void setTotalBytesToDownload(long j) {
        if (this.f409d == 2) {
            this.f416k = j;
            Integer num = 0;
            if (num.equals(this.f420o)) {
                m346c();
            }
        }
    }

    public void setUpdateAvailable(int i) {
        this.f411f = true;
        this.f408c.clear();
        this.f408c.add(0);
        this.f408c.add(1);
        this.f412g = i;
    }

    public void setUpdateAvailable(int i, int i2) {
        this.f411f = true;
        this.f408c.clear();
        this.f408c.add(Integer.valueOf(i2));
        this.f412g = i;
    }

    public void setUpdateNotAvailable() {
        this.f411f = false;
        this.f413h = null;
    }

    public void setUpdatePriority(int i) {
        if (this.f411f) {
            this.f414i = i;
        }
    }

    public final Task<Integer> startUpdateFlow(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions) {
        return m344a(appUpdateInfo, appUpdateOptions) ? Tasks.m942a(-1) : Tasks.m943b(new InstallException(-6));
    }

    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, int i, Activity activity, int i2) {
        return m344a(appUpdateInfo, AppUpdateOptions.newBuilder(i).build());
    }

    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, int i, IntentSenderForResultStarter intentSenderForResultStarter, int i2) {
        return m344a(appUpdateInfo, AppUpdateOptions.newBuilder(i).build());
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions, int i) {
        return m344a(appUpdateInfo, appUpdateOptions);
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, IntentSenderForResultStarter intentSenderForResultStarter, AppUpdateOptions appUpdateOptions, int i) {
        return m344a(appUpdateInfo, appUpdateOptions);
    }

    public void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f406a.mo17087g(installStateUpdatedListener);
    }

    public void userAcceptsUpdate() {
        if (this.f417l || this.f418m) {
            this.f417l = false;
            this.f409d = 1;
            Integer num = 0;
            if (num.equals(this.f420o)) {
                m346c();
            }
        }
    }

    public void userCancelsDownload() {
        int i = this.f409d;
        if (i == 1 || i == 2) {
            this.f409d = 6;
            Integer num = 0;
            if (num.equals(this.f420o)) {
                m346c();
            }
            this.f420o = null;
            this.f418m = false;
            this.f409d = 0;
        }
    }

    public void userRejectsUpdate() {
        if (this.f417l || this.f418m) {
            this.f417l = false;
            this.f418m = false;
            this.f420o = null;
            this.f409d = 0;
        }
    }
}
