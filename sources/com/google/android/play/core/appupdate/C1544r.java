package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import java.util.Objects;

/* renamed from: com.google.android.play.core.appupdate.r */
final class C1544r extends AppUpdateInfo {

    /* renamed from: a */
    private final String f388a;

    /* renamed from: b */
    private final int f389b;

    /* renamed from: c */
    private final int f390c;

    /* renamed from: d */
    private final int f391d;

    /* renamed from: e */
    private final Integer f392e;

    /* renamed from: f */
    private final int f393f;

    /* renamed from: g */
    private final long f394g;

    /* renamed from: h */
    private final long f395h;

    /* renamed from: i */
    private final long f396i;

    /* renamed from: j */
    private final long f397j;

    /* renamed from: k */
    private final PendingIntent f398k;

    /* renamed from: l */
    private final PendingIntent f399l;

    /* renamed from: m */
    private final PendingIntent f400m;

    /* renamed from: n */
    private final PendingIntent f401n;

    C1544r(String str, int i, int i2, int i3, Integer num, int i4, long j, long j2, long j3, long j4, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4) {
        Objects.requireNonNull(str, "Null packageName");
        this.f388a = str;
        this.f389b = i;
        this.f390c = i2;
        this.f391d = i3;
        this.f392e = num;
        this.f393f = i4;
        this.f394g = j;
        this.f395h = j2;
        this.f396i = j3;
        this.f397j = j4;
        this.f398k = pendingIntent;
        this.f399l = pendingIntent2;
        this.f400m = pendingIntent3;
        this.f401n = pendingIntent4;
    }

    public final int availableVersionCode() {
        return this.f389b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final long mo30571b() {
        return this.f396i;
    }

    public final long bytesDownloaded() {
        return this.f394g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final long mo30573c() {
        return this.f397j;
    }

    public final Integer clientVersionStalenessDays() {
        return this.f392e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final PendingIntent mo30575d() {
        return this.f398k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final PendingIntent mo30576e() {
        return this.f399l;
    }

    public final boolean equals(Object obj) {
        Integer num;
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        PendingIntent pendingIntent3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AppUpdateInfo) {
            AppUpdateInfo appUpdateInfo = (AppUpdateInfo) obj;
            if (this.f388a.equals(appUpdateInfo.packageName()) && this.f389b == appUpdateInfo.availableVersionCode() && this.f390c == appUpdateInfo.updateAvailability() && this.f391d == appUpdateInfo.installStatus() && ((num = this.f392e) != null ? num.equals(appUpdateInfo.clientVersionStalenessDays()) : appUpdateInfo.clientVersionStalenessDays() == null) && this.f393f == appUpdateInfo.updatePriority() && this.f394g == appUpdateInfo.bytesDownloaded() && this.f395h == appUpdateInfo.totalBytesToDownload() && this.f396i == appUpdateInfo.mo30571b() && this.f397j == appUpdateInfo.mo30573c() && ((pendingIntent = this.f398k) != null ? pendingIntent.equals(appUpdateInfo.mo30575d()) : appUpdateInfo.mo30575d() == null) && ((pendingIntent2 = this.f399l) != null ? pendingIntent2.equals(appUpdateInfo.mo30576e()) : appUpdateInfo.mo30576e() == null) && ((pendingIntent3 = this.f400m) != null ? pendingIntent3.equals(appUpdateInfo.mo30577f()) : appUpdateInfo.mo30577f() == null)) {
                PendingIntent pendingIntent4 = this.f401n;
                PendingIntent g = appUpdateInfo.mo30578g();
                if (pendingIntent4 != null ? pendingIntent4.equals(g) : g == null) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final PendingIntent mo30577f() {
        return this.f400m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final PendingIntent mo30578g() {
        return this.f401n;
    }

    public final int hashCode() {
        int hashCode = (((((((this.f388a.hashCode() ^ 1000003) * 1000003) ^ this.f389b) * 1000003) ^ this.f390c) * 1000003) ^ this.f391d) * 1000003;
        Integer num = this.f392e;
        int i = 0;
        int hashCode2 = num == null ? 0 : num.hashCode();
        int i2 = this.f393f;
        long j = this.f394g;
        long j2 = this.f395h;
        long j3 = this.f396i;
        long j4 = this.f397j;
        int i3 = (((((((((((hashCode ^ hashCode2) * 1000003) ^ i2) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003;
        PendingIntent pendingIntent = this.f398k;
        int hashCode3 = (i3 ^ (pendingIntent == null ? 0 : pendingIntent.hashCode())) * 1000003;
        PendingIntent pendingIntent2 = this.f399l;
        int hashCode4 = (hashCode3 ^ (pendingIntent2 == null ? 0 : pendingIntent2.hashCode())) * 1000003;
        PendingIntent pendingIntent3 = this.f400m;
        int hashCode5 = (hashCode4 ^ (pendingIntent3 == null ? 0 : pendingIntent3.hashCode())) * 1000003;
        PendingIntent pendingIntent4 = this.f401n;
        if (pendingIntent4 != null) {
            i = pendingIntent4.hashCode();
        }
        return hashCode5 ^ i;
    }

    public final int installStatus() {
        return this.f391d;
    }

    public final String packageName() {
        return this.f388a;
    }

    public final String toString() {
        String str = this.f388a;
        int i = this.f389b;
        int i2 = this.f390c;
        int i3 = this.f391d;
        String valueOf = String.valueOf(this.f392e);
        int i4 = this.f393f;
        long j = this.f394g;
        long j2 = this.f395h;
        long j3 = this.f396i;
        long j4 = this.f397j;
        String valueOf2 = String.valueOf(this.f398k);
        long j5 = j4;
        String valueOf3 = String.valueOf(this.f399l);
        String valueOf4 = String.valueOf(this.f400m);
        long j6 = j3;
        String valueOf5 = String.valueOf(this.f401n);
        int length = str.length();
        int length2 = String.valueOf(valueOf).length();
        int length3 = String.valueOf(valueOf2).length();
        int length4 = String.valueOf(valueOf3).length();
        StringBuilder sb = new StringBuilder(length + 463 + length2 + length3 + length4 + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length());
        sb.append("AppUpdateInfo{packageName=");
        sb.append(str);
        sb.append(", availableVersionCode=");
        sb.append(i);
        sb.append(", updateAvailability=");
        sb.append(i2);
        sb.append(", installStatus=");
        sb.append(i3);
        sb.append(", clientVersionStalenessDays=");
        sb.append(valueOf);
        sb.append(", updatePriority=");
        sb.append(i4);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", additionalSpaceRequired=");
        sb.append(j6);
        sb.append(", assetPackStorageSize=");
        sb.append(j5);
        sb.append(", immediateUpdateIntent=");
        sb.append(valueOf2);
        sb.append(", flexibleUpdateIntent=");
        sb.append(valueOf3);
        sb.append(", immediateDestructiveUpdateIntent=");
        sb.append(valueOf4);
        sb.append(", flexibleDestructiveUpdateIntent=");
        sb.append(valueOf5);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytesToDownload() {
        return this.f395h;
    }

    public final int updateAvailability() {
        return this.f390c;
    }

    public final int updatePriority() {
        return this.f393f;
    }
}
