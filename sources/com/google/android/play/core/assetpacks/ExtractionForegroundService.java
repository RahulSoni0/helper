package com.google.android.play.core.assetpacks;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.google.android.play.core.internal.C0944ag;

public class ExtractionForegroundService extends Service {

    /* renamed from: a */
    Context f432a;

    /* renamed from: b */
    C1641i f433b;

    /* renamed from: c */
    NotificationManager f434c;

    /* renamed from: d */
    private final C0944ag f435d = new C0944ag("ExtractionForegroundService");

    /* renamed from: a */
    private final synchronized void m363a(Intent intent) {
        int intExtra;
        String stringExtra = intent.getStringExtra("notification_title");
        String stringExtra2 = intent.getStringExtra("notification_subtext");
        long longExtra = intent.getLongExtra("notification_timeout", 600000);
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("notification_on_click_intent");
        Notification.Builder timeoutAfter = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(this.f432a, "playcore-assetpacks-service-notification-channel").setTimeoutAfter(longExtra) : new Notification.Builder(this.f432a).setPriority(-2);
        if (pendingIntent != null) {
            timeoutAfter.setContentIntent(pendingIntent);
        }
        Notification.Builder contentTitle = timeoutAfter.setSmallIcon(17301633).setOngoing(false).setContentTitle(stringExtra == null ? "Downloading additional file" : stringExtra);
        if (stringExtra2 == null) {
            stringExtra = "Transferring";
        }
        contentTitle.setSubText(stringExtra);
        if (Build.VERSION.SDK_INT >= 21 && (intExtra = intent.getIntExtra("notification_color", 0)) != 0) {
            timeoutAfter.setColor(intExtra).setVisibility(-1);
        }
        Notification build = timeoutAfter.build();
        this.f435d.mo17057d("Starting foreground installation service.", new Object[0]);
        this.f433b.mo30859a(true);
        if (Build.VERSION.SDK_INT >= 26) {
            m365c(intent.getStringExtra("notification_channel_name"));
        }
        startForeground(-1883842196, build);
    }

    /* renamed from: b */
    private final synchronized void m364b() {
        this.f435d.mo17057d("Stopping service.", new Object[0]);
        this.f433b.mo30859a(false);
        stopForeground(true);
        stopSelf();
    }

    /* renamed from: c */
    private final synchronized void m365c(String str) {
        if (str == null) {
            str = "File downloads by Play";
        }
        this.f434c.createNotificationChannel(new NotificationChannel("playcore-assetpacks-service-notification-channel", str, 2));
    }

    public final IBinder onBind(Intent intent) {
        return null;
    }

    public final void onCreate() {
        super.onCreate();
        C1615ck.m563j(getApplicationContext()).mo30679c(this);
        this.f434c = (NotificationManager) this.f432a.getSystemService("notification");
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        m363a(intent);
        int intExtra = intent.getIntExtra("action_type", 0);
        if (intExtra == 2) {
            m364b();
        } else {
            this.f435d.mo17055b("Unknown action type received: %d", Integer.valueOf(intExtra));
        }
        return 2;
    }
}
