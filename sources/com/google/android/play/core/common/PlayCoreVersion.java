package com.google.android.play.core.common;

import android.os.Bundle;
import com.google.android.play.core.internal.C0944ag;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PlayCoreVersion {

    /* renamed from: a */
    private static final Set<String> f828a = new HashSet(Arrays.asList(new String[]{"app_update", "review"}));

    /* renamed from: b */
    private static final Set<String> f829b = new HashSet(Arrays.asList(new String[]{"native", "unity"}));

    /* renamed from: c */
    private static final Map<String, Map<String, Integer>> f830c = new HashMap();

    /* renamed from: d */
    private static final C0944ag f831d = new C0944ag("PlayCoreVersion");

    private PlayCoreVersion() {
    }

    /* renamed from: a */
    public static synchronized Map<String, Integer> m656a(String str) {
        Map<String, Integer> map;
        synchronized (PlayCoreVersion.class) {
            Map<String, Map<String, Integer>> map2 = f830c;
            if (!map2.containsKey(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put("java", 11000);
                map2.put(str, hashMap);
            }
            map = map2.get(str);
        }
        return map;
    }

    public static synchronized void addVersion(String str, String str2, int i) {
        synchronized (PlayCoreVersion.class) {
            if (!f828a.contains(str)) {
                f831d.mo17058e("Illegal module name: %s", str);
            } else if (!f829b.contains(str2)) {
                f831d.mo17058e("Illegal platform name: %s", str2);
            } else {
                m656a(str).put(str2, Integer.valueOf(i));
            }
        }
    }

    /* renamed from: b */
    public static Bundle m657b(String str) {
        Bundle bundle = new Bundle();
        Map<String, Integer> a = m656a(str);
        bundle.putInt("playcore_version_code", a.get("java").intValue());
        if (a.containsKey("native")) {
            bundle.putInt("playcore_native_version", a.get("native").intValue());
        }
        if (a.containsKey("unity")) {
            bundle.putInt("playcore_unity_version", a.get("unity").intValue());
        }
        return bundle;
    }
}
