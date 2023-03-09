package com.google.android.play.core.appupdate;

import android.app.PendingIntent;

public abstract class AppUpdateInfo {
    /* renamed from: a */
    public static AppUpdateInfo m302a(String str, int i, int i2, int i3, Integer num, int i4, long j, long j2, long j3, long j4, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4) {
        return new C1544r(str, i, i2, i3, num, i4, j, j2, j3, j4, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4);
    }

    /* renamed from: i */
    private final boolean m303i(AppUpdateOptions appUpdateOptions) {
        return appUpdateOptions.allowAssetPackDeletion() && mo30571b() <= mo30573c();
    }

    public abstract int availableVersionCode();

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract long mo30571b();

    public abstract long bytesDownloaded();

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract long mo30573c();

    public abstract Integer clientVersionStalenessDays();

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract PendingIntent mo30575d();

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract PendingIntent mo30576e();

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public abstract PendingIntent mo30577f();

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public abstract PendingIntent mo30578g();

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final PendingIntent mo30579h(AppUpdateOptions appUpdateOptions) {
        if (appUpdateOptions.appUpdateType() != 0) {
            if (appUpdateOptions.appUpdateType() == 1) {
                if (mo30575d() != null) {
                    return mo30575d();
                }
                if (m303i(appUpdateOptions)) {
                    return mo30577f();
                }
            }
            return null;
        } else if (mo30576e() != null) {
            return mo30576e();
        } else {
            if (m303i(appUpdateOptions)) {
                return mo30578g();
            }
            return null;
        }
    }

    public abstract int installStatus();

    public boolean isUpdateTypeAllowed(int i) {
        return mo30579h(AppUpdateOptions.defaultOptions(i)) != null;
    }

    public boolean isUpdateTypeAllowed(AppUpdateOptions appUpdateOptions) {
        return mo30579h(appUpdateOptions) != null;
    }

    public abstract String packageName();

    public abstract long totalBytesToDownload();

    public abstract int updateAvailability();

    public abstract int updatePriority();
}
