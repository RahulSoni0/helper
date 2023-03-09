package com.google.android.play.core.assetpacks;

import java.util.Objects;

/* renamed from: com.google.android.play.core.assetpacks.ax */
final class C1574ax extends AssetLocation {

    /* renamed from: a */
    private final String f510a;

    /* renamed from: b */
    private final long f511b;

    /* renamed from: c */
    private final long f512c;

    C1574ax(String str, long j, long j2) {
        Objects.requireNonNull(str, "Null path");
        this.f510a = str;
        this.f511b = j;
        this.f512c = j2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetLocation) {
            AssetLocation assetLocation = (AssetLocation) obj;
            return this.f510a.equals(assetLocation.path()) && this.f511b == assetLocation.offset() && this.f512c == assetLocation.size();
        }
    }

    public final int hashCode() {
        int hashCode = this.f510a.hashCode();
        long j = this.f511b;
        long j2 = this.f512c;
        return ((((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2));
    }

    public final long offset() {
        return this.f511b;
    }

    public final String path() {
        return this.f510a;
    }

    public final long size() {
        return this.f512c;
    }

    public final String toString() {
        String str = this.f510a;
        long j = this.f511b;
        long j2 = this.f512c;
        StringBuilder sb = new StringBuilder(str.length() + 76);
        sb.append("AssetLocation{path=");
        sb.append(str);
        sb.append(", offset=");
        sb.append(j);
        sb.append(", size=");
        sb.append(j2);
        sb.append("}");
        return sb.toString();
    }
}
