package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.play.core.common.PlayCoreVersion;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.internal.C1681aq;
import com.google.android.play.core.internal.C1690bp;
import com.google.android.play.core.internal.C1707o;
import com.google.android.play.core.splitcompat.C0989p;
import com.google.android.play.core.tasks.C1786i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

/* renamed from: com.google.android.play.core.appupdate.o */
final class C1541o {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final C0944ag f379b = new C0944ag("AppUpdateService");

    /* renamed from: c */
    private static final Intent f380c = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");

    /* renamed from: a */
    C1681aq<C1707o> f381a;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final String f382d;

    /* renamed from: e */
    private final Context f383e;

    /* renamed from: f */
    private final C1543q f384f;

    public C1541o(Context context, C1543q qVar) {
        this.f382d = context.getPackageName();
        this.f383e = context;
        this.f384f = qVar;
        if (C1690bp.m735a(context)) {
            this.f381a = new C1681aq(C0989p.m204c(context), f379b, "AppUpdateService", f380c, C1535i.f367a);
        }
    }

    /* renamed from: d */
    static /* synthetic */ Bundle m326d(C1541o oVar, String str) {
        Integer num;
        Bundle bundle = new Bundle();
        bundle.putAll(m332j());
        bundle.putString("package.name", str);
        try {
            num = Integer.valueOf(oVar.f383e.getPackageManager().getPackageInfo(oVar.f383e.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            f379b.mo17055b("The current version of the app could not be retrieved", new Object[0]);
            num = null;
        }
        if (num != null) {
            bundle.putInt("app.version.code", num.intValue());
        }
        return bundle;
    }

    /* renamed from: h */
    static /* synthetic */ AppUpdateInfo m330h(C1541o oVar, Bundle bundle, String str) {
        Bundle bundle2 = bundle;
        return AppUpdateInfo.m302a(str, bundle2.getInt("version.code", -1), bundle2.getInt("update.availability"), bundle2.getInt("install.status", 0), bundle2.getInt("client.version.staleness", -1) == -1 ? null : Integer.valueOf(bundle2.getInt("client.version.staleness")), bundle2.getInt("in.app.update.priority", 0), bundle2.getLong("bytes.downloaded"), bundle2.getLong("total.bytes.to.download"), bundle2.getLong("additional.size.required"), oVar.f384f.mo30612a(), (PendingIntent) bundle2.getParcelable("blocking.intent"), (PendingIntent) bundle2.getParcelable("nonblocking.intent"), (PendingIntent) bundle2.getParcelable("blocking.destructive.intent"), (PendingIntent) bundle2.getParcelable("nonblocking.destructive.intent"));
    }

    /* renamed from: i */
    private static <T> Task<T> m331i() {
        f379b.mo17055b("onError(%d)", -9);
        return Tasks.m943b(new InstallException(-9));
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public static Bundle m332j() {
        Bundle bundle = new Bundle();
        bundle.putAll(PlayCoreVersion.m657b("app_update"));
        bundle.putInt("playcore.version.code", 11000);
        return bundle;
    }

    /* renamed from: a */
    public final Task<AppUpdateInfo> mo30610a(String str) {
        if (this.f381a == null) {
            return m331i();
        }
        f379b.mo17057d("requestUpdateInfo(%s)", str);
        C1786i iVar = new C1786i();
        this.f381a.mo30893a(new C1536j(this, iVar, str, iVar));
        return iVar.mo31064c();
    }

    /* renamed from: b */
    public final Task<Void> mo30611b(String str) {
        if (this.f381a == null) {
            return m331i();
        }
        f379b.mo17057d("completeUpdate(%s)", str);
        C1786i iVar = new C1786i();
        this.f381a.mo30893a(new C1537k(this, iVar, iVar, str));
        return iVar.mo31064c();
    }
}
