package com.google.android.play.core.install;

import java.util.Objects;

/* renamed from: com.google.android.play.core.install.a */
final class C1664a extends InstallState {

    /* renamed from: a */
    private final int f836a;

    /* renamed from: b */
    private final long f837b;

    /* renamed from: c */
    private final long f838c;

    /* renamed from: d */
    private final int f839d;

    /* renamed from: e */
    private final String f840e;

    C1664a(int i, long j, long j2, int i2, String str) {
        this.f836a = i;
        this.f837b = j;
        this.f838c = j2;
        this.f839d = i2;
        Objects.requireNonNull(str, "Null packageName");
        this.f840e = str;
    }

    public final long bytesDownloaded() {
        return this.f837b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstallState) {
            InstallState installState = (InstallState) obj;
            return this.f836a == installState.installStatus() && this.f837b == installState.bytesDownloaded() && this.f838c == installState.totalBytesToDownload() && this.f839d == installState.installErrorCode() && this.f840e.equals(installState.packageName());
        }
    }

    public final int hashCode() {
        int i = this.f836a;
        long j = this.f837b;
        long j2 = this.f838c;
        return ((((((((i ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f839d) * 1000003) ^ this.f840e.hashCode();
    }

    public final int installErrorCode() {
        return this.f839d;
    }

    public final int installStatus() {
        return this.f836a;
    }

    public final String packageName() {
        return this.f840e;
    }

    public final String toString() {
        int i = this.f836a;
        long j = this.f837b;
        long j2 = this.f838c;
        int i2 = this.f839d;
        String str = this.f840e;
        StringBuilder sb = new StringBuilder(str.length() + 164);
        sb.append("InstallState{installStatus=");
        sb.append(i);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", installErrorCode=");
        sb.append(i2);
        sb.append(", packageName=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytesToDownload() {
        return this.f838c;
    }
}
