package com.google.android.play.core.assetpacks;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.internal.C1692ca;
import com.google.android.play.core.listener.C0973b;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.ar */
final class C1568ar extends C0973b<AssetPackState> {

    /* renamed from: c */
    private final C1605ca f489c;

    /* renamed from: d */
    private final C1589bl f490d;

    /* renamed from: e */
    private final C1692ca<C1653t> f491e;

    /* renamed from: f */
    private final C1582be f492f;

    /* renamed from: g */
    private final C1592bo f493g;

    /* renamed from: h */
    private final C1692ca<Executor> f494h;

    /* renamed from: i */
    private final C1692ca<Executor> f495i;

    /* renamed from: j */
    private final Handler f496j = new Handler(Looper.getMainLooper());

    C1568ar(Context context, C1605ca caVar, C1589bl blVar, C1692ca<C1653t> caVar2, C1592bo boVar, C1582be beVar, C1692ca<Executor> caVar3, C1692ca<Executor> caVar4) {
        super(new C0944ag("AssetPackServiceListenerRegistry"), new IntentFilter("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE"), context);
        this.f489c = caVar;
        this.f490d = blVar;
        this.f491e = caVar2;
        this.f493g = boVar;
        this.f492f = beVar;
        this.f494h = caVar3;
        this.f495i = caVar4;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo17084a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE");
        if (bundleExtra != null) {
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("pack_names");
            if (stringArrayList == null || stringArrayList.size() != 1) {
                this.f159a.mo17055b("Corrupt bundle received from broadcast.", new Object[0]);
                return;
            }
            AssetPackState d = AssetPackState.m355d(bundleExtra, stringArrayList.get(0), this.f493g, C1570at.f498b);
            this.f159a.mo17054a("ListenerRegistryBroadcastReceiver.onReceive: %s", d);
            PendingIntent pendingIntent = (PendingIntent) bundleExtra.getParcelable("confirmation_intent");
            if (pendingIntent != null) {
                this.f492f.mo30764a(pendingIntent);
            }
            this.f495i.mo30920a().execute(new C1566ap(this, bundleExtra, d));
            this.f494h.mo30920a().execute(new C1567aq(this, bundleExtra));
            return;
        }
        this.f159a.mo17055b("Empty bundle received from broadcast.", new Object[0]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo30706b(AssetPackState assetPackState) {
        this.f496j.post(new C1565ao(this, assetPackState));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo30707c(Bundle bundle) {
        if (this.f489c.mo30782d(bundle)) {
            this.f490d.mo30770a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ void mo30708d(Bundle bundle, AssetPackState assetPackState) {
        if (this.f489c.mo30783e(bundle)) {
            mo30706b(assetPackState);
            this.f491e.mo30920a().mo30702j();
        }
    }
}
