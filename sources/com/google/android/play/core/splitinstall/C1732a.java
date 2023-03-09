package com.google.android.play.core.splitinstall;

import android.app.PendingIntent;
import android.content.Intent;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.a */
final class C1732a extends SplitInstallSessionState {

    /* renamed from: a */
    private final int f914a;

    /* renamed from: b */
    private final int f915b;

    /* renamed from: c */
    private final int f916c;

    /* renamed from: d */
    private final long f917d;

    /* renamed from: e */
    private final long f918e;

    /* renamed from: f */
    private final List<String> f919f;

    /* renamed from: g */
    private final List<String> f920g;

    /* renamed from: h */
    private final PendingIntent f921h;

    /* renamed from: i */
    private final List<Intent> f922i;

    C1732a(int i, int i2, int i3, long j, long j2, List<String> list, List<String> list2, PendingIntent pendingIntent, List<Intent> list3) {
        this.f914a = i;
        this.f915b = i2;
        this.f916c = i3;
        this.f917d = j;
        this.f918e = j2;
        this.f919f = list;
        this.f920g = list2;
        this.f921h = pendingIntent;
        this.f922i = list3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final List<String> mo31005a() {
        return this.f919f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final List<String> mo31006b() {
        return this.f920g;
    }

    public final long bytesDownloaded() {
        return this.f917d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final List<Intent> mo31008c() {
        return this.f922i;
    }

    public final boolean equals(Object obj) {
        List<String> list;
        List<String> list2;
        PendingIntent pendingIntent;
        if (obj == this) {
            return true;
        }
        if (obj instanceof SplitInstallSessionState) {
            SplitInstallSessionState splitInstallSessionState = (SplitInstallSessionState) obj;
            if (this.f914a == splitInstallSessionState.sessionId() && this.f915b == splitInstallSessionState.status() && this.f916c == splitInstallSessionState.errorCode() && this.f917d == splitInstallSessionState.bytesDownloaded() && this.f918e == splitInstallSessionState.totalBytesToDownload() && ((list = this.f919f) != null ? list.equals(splitInstallSessionState.mo31005a()) : splitInstallSessionState.mo31005a() == null) && ((list2 = this.f920g) != null ? list2.equals(splitInstallSessionState.mo31006b()) : splitInstallSessionState.mo31006b() == null) && ((pendingIntent = this.f921h) != null ? pendingIntent.equals(splitInstallSessionState.resolutionIntent()) : splitInstallSessionState.resolutionIntent() == null)) {
                List<Intent> list3 = this.f922i;
                List<Intent> c = splitInstallSessionState.mo31008c();
                if (list3 != null ? list3.equals(c) : c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int errorCode() {
        return this.f916c;
    }

    public final int hashCode() {
        int i = this.f914a;
        int i2 = this.f915b;
        int i3 = this.f916c;
        long j = this.f917d;
        long j2 = this.f918e;
        int i4 = (((((((((i ^ 1000003) * 1000003) ^ i2) * 1000003) ^ i3) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        List<String> list = this.f919f;
        int i5 = 0;
        int hashCode = (i4 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List<String> list2 = this.f920g;
        int hashCode2 = (hashCode ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        PendingIntent pendingIntent = this.f921h;
        int hashCode3 = (hashCode2 ^ (pendingIntent == null ? 0 : pendingIntent.hashCode())) * 1000003;
        List<Intent> list3 = this.f922i;
        if (list3 != null) {
            i5 = list3.hashCode();
        }
        return hashCode3 ^ i5;
    }

    @Deprecated
    public final PendingIntent resolutionIntent() {
        return this.f921h;
    }

    public final int sessionId() {
        return this.f914a;
    }

    public final int status() {
        return this.f915b;
    }

    public final String toString() {
        int i = this.f914a;
        int i2 = this.f915b;
        int i3 = this.f916c;
        long j = this.f917d;
        long j2 = this.f918e;
        String valueOf = String.valueOf(this.f919f);
        String valueOf2 = String.valueOf(this.f920g);
        String valueOf3 = String.valueOf(this.f921h);
        String valueOf4 = String.valueOf(this.f922i);
        int length = String.valueOf(valueOf).length();
        int length2 = String.valueOf(valueOf2).length();
        StringBuilder sb = new StringBuilder(length + 251 + length2 + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("SplitInstallSessionState{sessionId=");
        sb.append(i);
        sb.append(", status=");
        sb.append(i2);
        sb.append(", errorCode=");
        sb.append(i3);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", moduleNamesNullable=");
        sb.append(valueOf);
        sb.append(", languagesNullable=");
        sb.append(valueOf2);
        sb.append(", resolutionIntent=");
        sb.append(valueOf3);
        sb.append(", splitFileIntents=");
        sb.append(valueOf4);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytesToDownload() {
        return this.f918e;
    }
}
