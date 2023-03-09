package com.google.android.play.core.assetpacks;

public abstract class AssetPackLocation {

    /* renamed from: a */
    private static final AssetPackLocation f431a = new C1575ay(1, (String) null, (String) null);

    /* renamed from: a */
    static AssetPackLocation m352a() {
        return f431a;
    }

    /* renamed from: b */
    static AssetPackLocation m353b(String str, String str2) {
        return new C1575ay(0, str, str2);
    }

    public abstract String assetsPath();

    public abstract int packStorageMethod();

    public abstract String path();
}
