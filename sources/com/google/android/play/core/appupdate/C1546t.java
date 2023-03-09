package com.google.android.play.core.appupdate;

/* renamed from: com.google.android.play.core.appupdate.t */
final class C1546t extends AppUpdateOptions {

    /* renamed from: a */
    private final int f404a;

    /* renamed from: b */
    private final boolean f405b;

    /* synthetic */ C1546t(int i, boolean z) {
        this.f404a = i;
        this.f405b = z;
    }

    public final boolean allowAssetPackDeletion() {
        return this.f405b;
    }

    public final int appUpdateType() {
        return this.f404a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AppUpdateOptions) {
            AppUpdateOptions appUpdateOptions = (AppUpdateOptions) obj;
            return this.f404a == appUpdateOptions.appUpdateType() && this.f405b == appUpdateOptions.allowAssetPackDeletion();
        }
    }

    public final int hashCode() {
        return ((this.f404a ^ 1000003) * 1000003) ^ (true != this.f405b ? 1237 : 1231);
    }

    public final String toString() {
        int i = this.f404a;
        boolean z = this.f405b;
        StringBuilder sb = new StringBuilder(73);
        sb.append("AppUpdateOptions{appUpdateType=");
        sb.append(i);
        sb.append(", allowAssetPackDeletion=");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
