package com.google.android.gms.common.api.internal;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zaa extends ActivityLifecycleObserver {
    private final WeakReference<C2158zaa> zaa;

    public zaa(Activity activity) {
        this(C2158zaa.zab(activity));
    }

    private zaa(C2158zaa zaa2) {
        this.zaa = new WeakReference<>(zaa2);
    }

    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        C2158zaa zaa2 = (C2158zaa) this.zaa.get();
        if (zaa2 != null) {
            zaa2.zaa(runnable);
            return this;
        }
        throw new IllegalStateException("The target activity has already been GC'd");
    }

    /* renamed from: com.google.android.gms.common.api.internal.zaa$zaa  reason: collision with other inner class name */
    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    static class C2158zaa extends LifecycleCallback {
        private List<Runnable> zaa = new ArrayList();

        /* access modifiers changed from: private */
        public static C2158zaa zab(Activity activity) {
            C2158zaa zaa2;
            synchronized (activity) {
                LifecycleFragment fragment = getFragment(activity);
                zaa2 = (C2158zaa) fragment.getCallbackOrNull("LifecycleObserverOnStop", C2158zaa.class);
                if (zaa2 == null) {
                    zaa2 = new C2158zaa(fragment);
                }
            }
            return zaa2;
        }

        private C2158zaa(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
        }

        /* access modifiers changed from: private */
        public final synchronized void zaa(Runnable runnable) {
            this.zaa.add(runnable);
        }

        public void onStop() {
            List<Runnable> list;
            synchronized (this) {
                list = this.zaa;
                this.zaa = new ArrayList();
            }
            for (Runnable run : list) {
                run.run();
            }
        }
    }
}
