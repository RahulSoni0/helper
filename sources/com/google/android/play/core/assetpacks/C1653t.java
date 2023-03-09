package com.google.android.play.core.assetpacks;

import android.os.ParcelFileDescriptor;
import com.google.android.play.core.tasks.Task;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.t */
interface C1653t {
    /* renamed from: a */
    Task<AssetPackStates> mo30693a(List<String> list, List<String> list2, Map<String, Long> map);

    /* renamed from: b */
    void mo30694b(List<String> list);

    /* renamed from: c */
    Task<List<String>> mo30695c(Map<String, Long> map);

    /* renamed from: d */
    Task<AssetPackStates> mo30696d(List<String> list, C1569as asVar, Map<String, Long> map);

    /* renamed from: e */
    void mo30697e(int i, String str, String str2, int i2);

    /* renamed from: f */
    void mo30698f(int i, String str);

    /* renamed from: g */
    void mo30699g(int i);

    /* renamed from: h */
    Task<ParcelFileDescriptor> mo30700h(int i, String str, String str2, int i2);

    /* renamed from: i */
    void mo30701i(String str);

    /* renamed from: j */
    void mo30702j();
}
