package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.testing.b */
final /* synthetic */ class C1764b implements C1771i {

    /* renamed from: a */
    private final Integer f1006a;

    /* renamed from: b */
    private final int f1007b;

    /* renamed from: c */
    private final int f1008c;

    /* renamed from: d */
    private final Long f1009d;

    /* renamed from: e */
    private final Long f1010e;

    /* renamed from: f */
    private final List f1011f;

    /* renamed from: g */
    private final List f1012g;

    C1764b(Integer num, int i, int i2, Long l, Long l2, List list, List list2) {
        this.f1006a = num;
        this.f1007b = i;
        this.f1008c = i2;
        this.f1009d = l;
        this.f1010e = l2;
        this.f1011f = list;
        this.f1012g = list2;
    }

    /* renamed from: a */
    public final SplitInstallSessionState mo31038a(SplitInstallSessionState splitInstallSessionState) {
        return FakeSplitInstallManager.m903i(this.f1006a, this.f1007b, this.f1008c, this.f1009d, this.f1010e, this.f1011f, this.f1012g, splitInstallSessionState);
    }
}
