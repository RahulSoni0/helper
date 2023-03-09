package com.google.android.play.core.assetpacks;

import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.ba */
final class C1578ba extends AssetPackStates {

    /* renamed from: a */
    private final long f527a;

    /* renamed from: b */
    private final Map<String, AssetPackState> f528b;

    C1578ba(long j, Map<String, AssetPackState> map) {
        this.f527a = j;
        this.f528b = map;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackStates) {
            AssetPackStates assetPackStates = (AssetPackStates) obj;
            return this.f527a == assetPackStates.totalBytes() && this.f528b.equals(assetPackStates.packStates());
        }
    }

    public final int hashCode() {
        long j = this.f527a;
        return this.f528b.hashCode() ^ ((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003);
    }

    public final Map<String, AssetPackState> packStates() {
        return this.f528b;
    }

    public final String toString() {
        long j = this.f527a;
        String valueOf = String.valueOf(this.f528b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 61);
        sb.append("AssetPackStates{totalBytes=");
        sb.append(j);
        sb.append(", packStates=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytes() {
        return this.f527a;
    }
}
