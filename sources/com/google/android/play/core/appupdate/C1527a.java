package com.google.android.play.core.appupdate;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.listener.C0973b;

/* renamed from: com.google.android.play.core.appupdate.a */
public final class C1527a extends C0973b<InstallState> {
    public C1527a(Context context) {
        super(new C0944ag("AppUpdateListenerRegistry"), new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"), context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo17084a(Context context, Intent intent) {
        Intent intent2 = intent;
        if (!context.getPackageName().equals(intent2.getStringExtra("package.name"))) {
            this.f159a.mo17054a("ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", intent2.getStringExtra("package.name"));
            return;
        }
        this.f159a.mo17054a("List of extras in received intent:", new Object[0]);
        for (String str : intent.getExtras().keySet()) {
            this.f159a.mo17054a("Key: %s; value: %s", str, intent.getExtras().get(str));
        }
        C0944ag agVar = this.f159a;
        agVar.mo17054a("List of extras in received intent needed by fromUpdateIntent:", new Object[0]);
        agVar.mo17054a("Key: %s; value: %s", "install.status", Integer.valueOf(intent2.getIntExtra("install.status", 0)));
        agVar.mo17054a("Key: %s; value: %s", "error.code", Integer.valueOf(intent2.getIntExtra("error.code", 0)));
        InstallState a = InstallState.m664a(intent2.getIntExtra("install.status", 0), intent2.getLongExtra("bytes.downloaded", 0), intent2.getLongExtra("total.bytes.to.download", 0), intent2.getIntExtra("error.code", 0), intent2.getStringExtra("package.name"));
        this.f159a.mo17054a("ListenerRegistryBroadcastReceiver.onReceive: %s", a);
        mo17089i(a);
    }
}
