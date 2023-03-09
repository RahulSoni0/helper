package com.google.android.play.core.assetpacks;

/* renamed from: com.google.android.play.core.assetpacks.ay */
final class C1575ay extends AssetPackLocation {

    /* renamed from: a */
    private final int f513a;

    /* renamed from: b */
    private final String f514b;

    /* renamed from: c */
    private final String f515c;

    C1575ay(int i, String str, String str2) {
        this.f513a = i;
        this.f514b = str;
        this.f515c = str2;
    }

    public final String assetsPath() {
        return this.f515c;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackLocation) {
            AssetPackLocation assetPackLocation = (AssetPackLocation) obj;
            if (this.f513a == assetPackLocation.packStorageMethod() && ((str = this.f514b) != null ? str.equals(assetPackLocation.path()) : assetPackLocation.path() == null)) {
                String str2 = this.f515c;
                String assetsPath = assetPackLocation.assetsPath();
                if (str2 != null ? str2.equals(assetsPath) : assetsPath == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.f513a ^ 1000003) * 1000003;
        String str = this.f514b;
        int i2 = 0;
        int hashCode = (i ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f515c;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode ^ i2;
    }

    public final int packStorageMethod() {
        return this.f513a;
    }

    public final String path() {
        return this.f514b;
    }

    public final String toString() {
        int i = this.f513a;
        String str = this.f514b;
        String str2 = this.f515c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str2).length());
        sb.append("AssetPackLocation{packStorageMethod=");
        sb.append(i);
        sb.append(", path=");
        sb.append(str);
        sb.append(", assetsPath=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }
}
