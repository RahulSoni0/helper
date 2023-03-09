package com.google.android.play.core.assetpacks;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.bo */
final class C1592bo {

    /* renamed from: a */
    private final Map<String, Double> f609a = new HashMap();

    C1592bo() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo30774a(String str) {
        this.f609a.put(str, Double.valueOf(0.0d));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized double mo30775b(String str) {
        Double d = this.f609a.get(str);
        if (d == null) {
            return 0.0d;
        }
        return d.doubleValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final synchronized double mo30776c(String str, C1607cc ccVar) {
        double d;
        double d2 = (double) ((C1586bi) ccVar).f571e;
        Double.isNaN(d2);
        double d3 = d2 + 1.0d;
        double d4 = (double) ((C1586bi) ccVar).f572f;
        Double.isNaN(d4);
        d = d3 / d4;
        this.f609a.put(str, Double.valueOf(d));
        return d;
    }
}
