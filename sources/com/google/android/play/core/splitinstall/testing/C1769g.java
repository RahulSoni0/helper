package com.google.android.play.core.splitinstall.testing;

import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.testing.g */
final /* synthetic */ class C1769g implements Runnable {

    /* renamed from: a */
    private final FakeSplitInstallManager f1021a;

    /* renamed from: b */
    private final List f1022b;

    /* renamed from: c */
    private final List f1023c;

    /* renamed from: d */
    private final List f1024d;

    /* renamed from: e */
    private final long f1025e;

    /* renamed from: f */
    private final /* synthetic */ int f1026f = 1;

    C1769g(FakeSplitInstallManager fakeSplitInstallManager, long j, List list, List list2, List list3) {
        this.f1021a = fakeSplitInstallManager;
        this.f1025e = j;
        this.f1022b = list;
        this.f1023c = list2;
        this.f1024d = list3;
    }

    C1769g(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2, List list3, long j) {
        this.f1021a = fakeSplitInstallManager;
        this.f1022b = list;
        this.f1023c = list2;
        this.f1024d = list3;
        this.f1025e = j;
    }

    public final void run() {
        if (this.f1026f != 0) {
            this.f1021a.mo31034e(this.f1025e, this.f1022b, this.f1023c, this.f1024d);
        } else {
            this.f1021a.mo31033d(this.f1022b, this.f1023c, this.f1024d, this.f1025e);
        }
    }
}
