package com.google.android.play.core.splitinstall;

import android.content.Context;

public final class InternalFrameworkListenerExtensions {
    private InternalFrameworkListenerExtensions() {
    }

    public static void registerFrameworkListener(Context context, SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        C0997k.m217a(context).mo17136a().mo30983a(splitInstallStateUpdatedListener);
    }

    public static void unregisterFrameworkListener(Context context, SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        C0997k.m217a(context).mo17136a().mo30984b(splitInstallStateUpdatedListener);
    }
}
