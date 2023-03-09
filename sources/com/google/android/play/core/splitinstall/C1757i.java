package com.google.android.play.core.splitinstall;

import android.app.Activity;
import android.content.IntentSender;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.internal.C1692ca;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import com.google.android.play.core.tasks.Task;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* renamed from: com.google.android.play.core.splitinstall.i */
final class C1757i implements SplitInstallManager {

    /* renamed from: a */
    private final C1692ca<C1774v> f970a;

    /* renamed from: b */
    private final C1692ca<FakeSplitInstallManager> f971b;

    /* renamed from: c */
    private final C1692ca<File> f972c;

    C1757i(C1692ca<C1774v> caVar, C1692ca<FakeSplitInstallManager> caVar2, C1692ca<File> caVar3) {
        this.f970a = caVar;
        this.f971b = caVar2;
        this.f972c = caVar3;
    }

    /* renamed from: c */
    private final SplitInstallManager m894c() {
        return (SplitInstallManager) (this.f972c.mo30920a() == null ? this.f970a : this.f971b).mo30920a();
    }

    /* renamed from: a */
    public final void mo30983a(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        m894c().mo30983a(splitInstallStateUpdatedListener);
    }

    /* renamed from: b */
    public final void mo30984b(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        m894c().mo30984b(splitInstallStateUpdatedListener);
    }

    public final Task<Void> cancelInstall(int i) {
        return m894c().cancelInstall(i);
    }

    public final Task<Void> deferredInstall(List<String> list) {
        return m894c().deferredInstall(list);
    }

    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return m894c().deferredLanguageInstall(list);
    }

    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return m894c().deferredLanguageUninstall(list);
    }

    public final Task<Void> deferredUninstall(List<String> list) {
        return m894c().deferredUninstall(list);
    }

    public final Set<String> getInstalledLanguages() {
        return m894c().getInstalledLanguages();
    }

    public final Set<String> getInstalledModules() {
        return m894c().getInstalledModules();
    }

    public final Task<SplitInstallSessionState> getSessionState(int i) {
        return m894c().getSessionState(i);
    }

    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        return m894c().getSessionStates();
    }

    public final void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        m894c().registerListener(splitInstallStateUpdatedListener);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i) throws IntentSender.SendIntentException {
        return m894c().startConfirmationDialogForResult(splitInstallSessionState, activity, i);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, IntentSenderForResultStarter intentSenderForResultStarter, int i) throws IntentSender.SendIntentException {
        return m894c().startConfirmationDialogForResult(splitInstallSessionState, intentSenderForResultStarter, i);
    }

    public final Task<Integer> startInstall(SplitInstallRequest splitInstallRequest) {
        return m894c().startInstall(splitInstallRequest);
    }

    public final void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        m894c().unregisterListener(splitInstallStateUpdatedListener);
    }
}
