package com.google.android.play.core.assetpacks;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AssetPackExtractionService extends Service {

    /* renamed from: a */
    C1577b f430a;

    public final IBinder onBind(Intent intent) {
        return this.f430a;
    }

    public final void onCreate() {
        super.onCreate();
        C1615ck.m563j(getApplicationContext()).mo30678b(this);
    }
}
