package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.AppUpdateOptions;

/* renamed from: com.google.android.play.core.appupdate.s */
final class C1545s extends AppUpdateOptions.Builder {

    /* renamed from: a */
    private Integer f402a;

    /* renamed from: b */
    private Boolean f403b;

    C1545s() {
    }

    public final AppUpdateOptions build() {
        String str = "";
        if (this.f402a == null) {
            str = str.concat(" appUpdateType");
        }
        if (this.f403b == null) {
            str = String.valueOf(str).concat(" allowAssetPackDeletion");
        }
        if (str.isEmpty()) {
            return new C1546t(this.f402a.intValue(), this.f403b.booleanValue());
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }

    public final AppUpdateOptions.Builder setAllowAssetPackDeletion(boolean z) {
        this.f403b = Boolean.valueOf(z);
        return this;
    }

    public final AppUpdateOptions.Builder setAppUpdateType(int i) {
        this.f402a = Integer.valueOf(i);
        return this;
    }
}
