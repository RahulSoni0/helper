package com.google.android.play.core.assetpacks;

import java.util.Objects;

/* renamed from: com.google.android.play.core.assetpacks.az */
final class C1576az extends AssetPackState {

    /* renamed from: a */
    private final String f516a;

    /* renamed from: b */
    private final int f517b;

    /* renamed from: c */
    private final int f518c;

    /* renamed from: d */
    private final long f519d;

    /* renamed from: e */
    private final long f520e;

    /* renamed from: f */
    private final int f521f;

    /* renamed from: g */
    private final int f522g;

    /* renamed from: h */
    private final String f523h;

    C1576az(String str, int i, int i2, long j, long j2, int i3, int i4, String str2) {
        Objects.requireNonNull(str, "Null name");
        this.f516a = str;
        this.f517b = i;
        this.f518c = i2;
        this.f519d = j;
        this.f520e = j2;
        this.f521f = i3;
        this.f522g = i4;
        Objects.requireNonNull(str2, "Null versionTag");
        this.f523h = str2;
    }

    /* renamed from: a */
    public final int mo30662a() {
        return this.f522g;
    }

    /* renamed from: b */
    public final String mo30663b() {
        return this.f523h;
    }

    public final long bytesDownloaded() {
        return this.f519d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackState) {
            AssetPackState assetPackState = (AssetPackState) obj;
            return this.f516a.equals(assetPackState.name()) && this.f517b == assetPackState.status() && this.f518c == assetPackState.errorCode() && this.f519d == assetPackState.bytesDownloaded() && this.f520e == assetPackState.totalBytesToDownload() && this.f521f == assetPackState.transferProgressPercentage() && this.f522g == assetPackState.mo30662a() && this.f523h.equals(assetPackState.mo30663b());
        }
    }

    public final int errorCode() {
        return this.f518c;
    }

    public final int hashCode() {
        int hashCode = this.f516a.hashCode();
        int i = this.f517b;
        int i2 = this.f518c;
        long j = this.f519d;
        long j2 = this.f520e;
        return ((((((((((((((hashCode ^ 1000003) * 1000003) ^ i) * 1000003) ^ i2) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f521f) * 1000003) ^ this.f522g) * 1000003) ^ this.f523h.hashCode();
    }

    public final String name() {
        return this.f516a;
    }

    public final int status() {
        return this.f517b;
    }

    public final String toString() {
        String str = this.f516a;
        int i = this.f517b;
        int i2 = this.f518c;
        long j = this.f519d;
        long j2 = this.f520e;
        int i3 = this.f521f;
        int i4 = this.f522g;
        String str2 = this.f523h;
        StringBuilder sb = new StringBuilder(str.length() + 230 + str2.length());
        sb.append("AssetPackState{name=");
        sb.append(str);
        sb.append(", status=");
        sb.append(i);
        sb.append(", errorCode=");
        sb.append(i2);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", transferProgressPercentage=");
        sb.append(i3);
        sb.append(", updateAvailability=");
        sb.append(i4);
        sb.append(", versionTag=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytesToDownload() {
        return this.f520e;
    }

    public final int transferProgressPercentage() {
        return this.f521f;
    }
}
