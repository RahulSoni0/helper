package com.google.android.play.core.assetpacks;

/* renamed from: com.google.android.play.core.assetpacks.bk */
final class C1588bk extends RuntimeException {

    /* renamed from: a */
    final int f582a;

    C1588bk(String str) {
        super(str);
        this.f582a = -1;
    }

    C1588bk(String str, int i) {
        super(str);
        this.f582a = i;
    }

    C1588bk(String str, Exception exc) {
        super(str, exc);
        this.f582a = -1;
    }

    C1588bk(String str, Exception exc, int i) {
        super(str, exc);
        this.f582a = i;
    }
}
