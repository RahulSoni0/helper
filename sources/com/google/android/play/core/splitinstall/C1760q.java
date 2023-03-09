package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;

/* renamed from: com.google.android.play.core.splitinstall.q */
final class C1760q implements C0992d {

    /* renamed from: a */
    final /* synthetic */ SplitInstallSessionState f978a;

    /* renamed from: b */
    final /* synthetic */ Intent f979b;

    /* renamed from: c */
    final /* synthetic */ Context f980c;

    /* renamed from: d */
    final /* synthetic */ C1003s f981d;

    C1760q(C1003s sVar, SplitInstallSessionState splitInstallSessionState, Intent intent, Context context) {
        this.f981d = sVar;
        this.f978a = splitInstallSessionState;
        this.f979b = intent;
        this.f980c = context;
    }

    /* renamed from: a */
    public final void mo17128a() {
        this.f981d.f209d.post(new C1761r(this.f981d, this.f978a, 5, 0));
    }

    /* renamed from: b */
    public final void mo17129b() {
        if (!this.f979b.getBooleanExtra("triggered_from_app_after_verification", false)) {
            this.f979b.putExtra("triggered_from_app_after_verification", true);
            this.f980c.sendBroadcast(this.f979b);
            return;
        }
        this.f981d.f159a.mo17055b("Splits copied and verified more than once.", new Object[0]);
    }

    /* renamed from: c */
    public final void mo17130c(int i) {
        this.f981d.f209d.post(new C1761r(this.f981d, this.f978a, 6, i));
    }
}
