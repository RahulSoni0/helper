package com.google.android.play.core.internal;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.bb */
final class C0954bb implements C0952az {

    /* renamed from: a */
    private final /* synthetic */ int f145a = 0;

    C0954bb() {
    }

    C0954bb(byte[] bArr) {
    }

    /* renamed from: a */
    public final Object[] mo17069a(Object obj, ArrayList arrayList, File file, ArrayList arrayList2) {
        Object b;
        if (this.f145a != 0) {
            b = C0960bh.m98b(obj, "makeDexElements", Object[].class, ArrayList.class, arrayList, File.class, file, ArrayList.class, arrayList2);
        } else {
            b = C0960bh.m98b(obj, "makePathElements", Object[].class, List.class, arrayList, File.class, file, List.class, arrayList2);
        }
        return (Object[]) b;
    }
}
