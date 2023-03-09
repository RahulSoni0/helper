package com.google.android.play.core.splitinstall;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.play.core.splitinstall.g */
public final class C0995g {

    /* renamed from: a */
    private final Map<String, Map<String, String>> f199a = new HashMap();

    /* renamed from: a */
    public final C0996h mo17132a() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f199a.entrySet()) {
            hashMap.put((String) next.getKey(), Collections.unmodifiableMap(new HashMap((Map) next.getValue())));
        }
        return new C0996h(Collections.unmodifiableMap(hashMap));
    }

    /* renamed from: b */
    public final void mo17133b(String str, String str2, String str3) {
        if (!this.f199a.containsKey(str2)) {
            this.f199a.put(str2, new HashMap());
        }
        this.f199a.get(str2).put(str, str3);
    }
}
