package com.google.android.play.core.assetpacks;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.internal.C1690bp;
import com.google.android.play.core.internal.C1715w;
import com.google.android.play.core.internal.C1718z;

/* renamed from: com.google.android.play.core.assetpacks.b */
final class C1577b extends C1715w {

    /* renamed from: a */
    private final C0944ag f524a = new C0944ag("AssetPackExtractionService");

    /* renamed from: b */
    private final Context f525b;

    /* renamed from: c */
    private final C1571au f526c;

    C1577b(Context context, C1571au auVar) {
        this.f525b = context;
        this.f526c = auVar;
    }

    /* renamed from: d */
    private final synchronized void m476d(Bundle bundle) {
        ComponentName componentName;
        Intent intent = new Intent(this.f525b, ExtractionForegroundService.class);
        int i = bundle.getInt("action_type");
        intent.putExtra("action_type", i);
        if (i == 1) {
            intent.putExtra("notification_channel_name", bundle.getString("notification_channel_name"));
            intent.putExtra("notification_title", bundle.getString("notification_title"));
            intent.putExtra("notification_subtext", bundle.getString("notification_subtext"));
            intent.putExtra("notification_timeout", bundle.getLong("notification_timeout"));
            Parcelable parcelable = bundle.getParcelable("notification_on_click_intent");
            if (parcelable instanceof PendingIntent) {
                intent.putExtra("notification_on_click_intent", parcelable);
            }
            intent.putExtra("notification_color", bundle.getInt("notification_color"));
        }
        try {
            componentName = Build.VERSION.SDK_INT >= 26 ? this.f525b.startForegroundService(intent) : this.f525b.startService(intent);
        } catch (IllegalStateException | SecurityException e) {
            this.f524a.mo17056c(e, "Failed starting installation service.", new Object[0]);
            componentName = null;
        }
        if (componentName == null) {
            this.f524a.mo17055b("Failed starting installation service.", new Object[0]);
        }
    }

    /* renamed from: b */
    public final void mo30752b(Bundle bundle, C1718z zVar) throws RemoteException {
        this.f524a.mo17054a("updateServiceState AIDL call", new Object[0]);
        if (!C1690bp.m735a(this.f525b) || !C1690bp.m736b(this.f525b)) {
            zVar.mo30965d(new Bundle());
            return;
        }
        m476d(bundle);
        zVar.mo30964c(new Bundle(), new Bundle());
    }

    /* renamed from: c */
    public final void mo30753c(C1718z zVar) throws RemoteException {
        this.f524a.mo17054a("clearAssetPackStorage AIDL call", new Object[0]);
        if (!C1690bp.m735a(this.f525b) || !C1690bp.m736b(this.f525b)) {
            zVar.mo30965d(new Bundle());
            return;
        }
        this.f526c.mo30736x();
        zVar.mo30966e(new Bundle());
    }
}
