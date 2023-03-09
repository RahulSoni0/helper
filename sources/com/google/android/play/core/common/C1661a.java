package com.google.android.play.core.common;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.play.core.common.a */
public final class C1661a {

    /* renamed from: a */
    private final Map<String, Object> f832a = new HashMap();

    /* renamed from: b */
    private final AtomicBoolean f833b = new AtomicBoolean(false);

    /* renamed from: b */
    private final synchronized void m658b() {
        this.f832a.put("assetOnlyUpdates", false);
    }

    /* renamed from: a */
    public final synchronized boolean mo30870a() {
        if (!this.f833b.get()) {
            m658b();
        }
        Object obj = this.f832a.get("assetOnlyUpdates");
        if (!(obj instanceof Boolean)) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }
}
