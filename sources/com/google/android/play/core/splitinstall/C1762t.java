package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.t */
final class C1762t implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SplitInstallRequest f986a;

    /* renamed from: b */
    final /* synthetic */ C1774v f987b;

    C1762t(C1774v vVar, SplitInstallRequest splitInstallRequest) {
        this.f987b = vVar;
        this.f986a = splitInstallRequest;
    }

    public final void run() {
        C1003s d = this.f987b.f1038b;
        List<String> moduleNames = this.f986a.getModuleNames();
        List c = C1774v.m935e(this.f986a.getLanguages());
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt(NotificationCompat.CATEGORY_STATUS, 5);
        bundle.putInt("error_code", 0);
        if (!moduleNames.isEmpty()) {
            bundle.putStringArrayList("module_names", new ArrayList(moduleNames));
        }
        if (!c.isEmpty()) {
            bundle.putStringArrayList("languages", new ArrayList(c));
        }
        bundle.putLong("total_bytes_to_download", 0);
        bundle.putLong("bytes_downloaded", 0);
        d.mo17143k(SplitInstallSessionState.m836d(bundle));
    }
}
