package com.google.android.play.core.review;

import android.app.PendingIntent;
import java.util.Objects;

/* renamed from: com.google.android.play.core.review.a */
final class C1722a extends ReviewInfo {

    /* renamed from: a */
    private final PendingIntent f893a;

    C1722a(PendingIntent pendingIntent) {
        Objects.requireNonNull(pendingIntent, "Null pendingIntent");
        this.f893a = pendingIntent;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final PendingIntent mo30973a() {
        return this.f893a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReviewInfo) {
            return this.f893a.equals(((ReviewInfo) obj).mo30973a());
        }
        return false;
    }

    public final int hashCode() {
        return this.f893a.hashCode() ^ 1000003;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f893a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
        sb.append("ReviewInfo{pendingIntent=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }
}
