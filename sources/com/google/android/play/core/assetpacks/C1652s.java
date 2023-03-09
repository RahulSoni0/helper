package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C0960bh;
import com.google.android.play.core.internal.C1696ce;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.play.core.assetpacks.s */
public final class C1652s implements C1696ce<Executor> {

    /* renamed from: a */
    private final /* synthetic */ int f808a = 0;

    public C1652s() {
    }

    public C1652s(byte[] bArr) {
    }

    public C1652s(char[] cArr) {
    }

    public C1652s(short[] sArr) {
    }

    /* renamed from: b */
    public static Executor m635b() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(C1643k.f792a);
        C0960bh.m107k(newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    /* renamed from: c */
    public static Executor m636c() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(C1643k.f793b);
        C0960bh.m107k(newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    /* renamed from: d */
    public static C1582be m637d() {
        return new C1582be();
    }

    /* renamed from: e */
    public static C1592bo m638e() {
        return new C1592bo();
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo30603a() {
        int i = this.f808a;
        return i != 0 ? i != 1 ? i != 2 ? m638e() : m637d() : m636c() : m635b();
    }
}
