package com.google.android.play.core.internal;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.play.core.internal.bs */
public final class C0964bs extends C0963br {

    /* renamed from: a */
    private final C0963br f151a;

    /* renamed from: b */
    private final long f152b;

    /* renamed from: c */
    private final long f153c;

    public C0964bs(C0963br brVar, long j, long j2) {
        this.f151a = brVar;
        long d = m117d(j);
        this.f152b = d;
        this.f153c = m117d(d + j2);
    }

    /* renamed from: d */
    private final long m117d(long j) {
        if (j < 0) {
            return 0;
        }
        return j > this.f151a.mo17076a() ? this.f151a.mo17076a() : j;
    }

    /* renamed from: a */
    public final long mo17076a() {
        return this.f153c - this.f152b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final InputStream mo17077b(long j, long j2) throws IOException {
        long d = m117d(this.f152b);
        return this.f151a.mo17077b(d, m117d(j2 + d) - d);
    }

    public final void close() throws IOException {
    }
}
