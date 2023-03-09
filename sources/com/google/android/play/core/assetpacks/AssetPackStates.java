package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AssetPackStates {
    /* renamed from: a */
    public static AssetPackStates m358a(long j, Map<String, AssetPackState> map) {
        return new C1578ba(j, map);
    }

    /* renamed from: b */
    public static AssetPackStates m359b(Bundle bundle, C1592bo boVar) {
        return m360c(bundle, boVar, new ArrayList());
    }

    /* renamed from: c */
    public static AssetPackStates m360c(Bundle bundle, C1592bo boVar, List<String> list) {
        return m362e(bundle, boVar, list, C1570at.f497a);
    }

    /* renamed from: d */
    public static AssetPackStates m361d(Bundle bundle, C1592bo boVar, C1569as asVar) {
        return m362e(bundle, boVar, new ArrayList(), asVar);
    }

    /* renamed from: e */
    private static AssetPackStates m362e(Bundle bundle, C1592bo boVar, List<String> list, C1569as asVar) {
        Bundle bundle2 = bundle;
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        HashMap hashMap = new HashMap();
        int size = stringArrayList.size();
        for (int i = 0; i < size; i++) {
            String str = stringArrayList.get(i);
            hashMap.put(str, AssetPackState.m355d(bundle, str, boVar, asVar));
        }
        for (String next : list) {
            hashMap.put(next, AssetPackState.m354c(next, 4, 0, 0, 0, 0.0d, 1, ""));
        }
        return m358a(bundle.getLong("total_bytes_to_download"), hashMap);
    }

    public abstract Map<String, AssetPackState> packStates();

    public abstract long totalBytes();
}
