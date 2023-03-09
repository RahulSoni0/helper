package com.google.android.play.core.internal;

import java.io.File;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.bd */
final class C0956bd implements C0955bc {

    /* renamed from: a */
    private final /* synthetic */ int f146a = 0;

    C0956bd() {
    }

    C0956bd(byte[] bArr) {
    }

    /* renamed from: a */
    public final Object[] mo17070a(Object obj, List list, List list2) {
        Object a;
        if (this.f146a != 0) {
            a = C0960bh.m98b(obj, "makePathElements", Object[].class, List.class, list, File.class, null, List.class, list2);
        } else {
            a = C0960bh.m97a(obj, "makePathElements", Object[].class, List.class, list);
        }
        return (Object[]) a;
    }
}
