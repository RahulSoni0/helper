package com.google.android.play.core.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.play.core.internal.br */
public abstract class C0963br implements Closeable {
    /* renamed from: a */
    public abstract long mo17076a();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract InputStream mo17077b(long j, long j2) throws IOException;

    /* renamed from: c */
    public final synchronized InputStream mo17078c() throws IOException {
        return mo17077b(0, mo17076a());
    }
}
