package com.google.android.play.core.splitcompat;

import java.io.File;
import java.util.Objects;

/* renamed from: com.google.android.play.core.splitcompat.q */
final class C0990q {

    /* renamed from: a */
    private final File f196a;

    /* renamed from: b */
    private final String f197b;

    C0990q() {
    }

    C0990q(File file, String str) {
        this();
        Objects.requireNonNull(file, "Null splitFile");
        this.f196a = file;
        Objects.requireNonNull(str, "Null splitId");
        this.f197b = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public File mo17121a() {
        return this.f196a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo17122b() {
        return this.f197b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0990q) {
            C0990q qVar = (C0990q) obj;
            return this.f196a.equals(qVar.mo17121a()) && this.f197b.equals(qVar.mo17122b());
        }
    }

    public int hashCode() {
        return ((this.f196a.hashCode() ^ 1000003) * 1000003) ^ this.f197b.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.f196a);
        String str = this.f197b;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35 + str.length());
        sb.append("SplitFileInfo{splitFile=");
        sb.append(valueOf);
        sb.append(", splitId=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
