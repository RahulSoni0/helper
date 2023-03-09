package com.google.android.play.core.splitinstall.testing;

import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.testing.c */
final /* synthetic */ class C1765c implements Runnable {

    /* renamed from: a */
    private final FakeSplitInstallManager f1013a;

    /* renamed from: b */
    private final List f1014b;

    /* renamed from: c */
    private final List f1015c;

    C1765c(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2) {
        this.f1013a = fakeSplitInstallManager;
        this.f1014b = list;
        this.f1015c = list2;
    }

    public final void run() {
        this.f1013a.mo31036h(this.f1014b, this.f1015c);
    }
}
