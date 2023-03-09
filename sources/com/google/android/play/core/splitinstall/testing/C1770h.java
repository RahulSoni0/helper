package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.C0992d;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.testing.h */
final class C1770h implements C0992d {

    /* renamed from: a */
    final /* synthetic */ List f1027a;

    /* renamed from: b */
    final /* synthetic */ List f1028b;

    /* renamed from: c */
    final /* synthetic */ long f1029c;

    /* renamed from: d */
    final /* synthetic */ boolean f1030d;

    /* renamed from: e */
    final /* synthetic */ List f1031e;

    /* renamed from: f */
    final /* synthetic */ FakeSplitInstallManager f1032f;

    C1770h(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2, long j, boolean z, List list3) {
        this.f1032f = fakeSplitInstallManager;
        this.f1027a = list;
        this.f1028b = list2;
        this.f1029c = j;
        this.f1030d = z;
        this.f1031e = list3;
    }

    /* renamed from: a */
    public final void mo17128a() {
        this.f1032f.m916v(this.f1027a, this.f1028b, this.f1029c);
    }

    /* renamed from: b */
    public final void mo17129b() {
        if (!this.f1030d) {
            this.f1032f.m915u(this.f1031e, this.f1027a, this.f1028b, this.f1029c, true);
        }
    }

    /* renamed from: c */
    public final void mo17130c(int i) {
        this.f1032f.m917w(i);
    }
}
