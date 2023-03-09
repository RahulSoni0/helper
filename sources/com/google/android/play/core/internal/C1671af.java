package com.google.android.play.core.internal;

import com.google.android.play.core.listener.StateUpdatedListener;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.af */
public final class C1671af<StateT> {

    /* renamed from: a */
    protected final Set<StateUpdatedListener<StateT>> f843a = new HashSet();

    /* renamed from: a */
    public final synchronized void mo30883a(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f843a.add(stateUpdatedListener);
    }

    /* renamed from: b */
    public final synchronized void mo30884b(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f843a.remove(stateUpdatedListener);
    }

    /* renamed from: c */
    public final synchronized void mo30885c(StateT statet) {
        for (StateUpdatedListener<StateT> onStateUpdate : this.f843a) {
            onStateUpdate.onStateUpdate(statet);
        }
    }
}
