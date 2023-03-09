package com.skydoves.powerspinner;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

public class PowerSpinnerView_LifecycleAdapter implements GeneratedAdapter {
    final PowerSpinnerView mReceiver;

    PowerSpinnerView_LifecycleAdapter(PowerSpinnerView powerSpinnerView) {
        this.mReceiver = powerSpinnerView;
    }

    public void callMethods(LifecycleOwner lifecycleOwner, Lifecycle.Event event, boolean z, MethodCallsLogger methodCallsLogger) {
        boolean z2 = methodCallsLogger != null;
        if (z || event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        if (!z2 || methodCallsLogger.approveCall("onDestroy", 1)) {
            this.mReceiver.onDestroy();
        }
    }
}
