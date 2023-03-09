package com.google.android.play.core.assetpacks;

import java.util.Arrays;

/* renamed from: com.google.android.play.core.assetpacks.de */
final class C1636de {

    /* renamed from: a */
    private final String f759a;

    /* renamed from: b */
    private final long f760b;

    /* renamed from: c */
    private final int f761c;

    /* renamed from: d */
    private final boolean f762d;

    /* renamed from: e */
    private final boolean f763e;

    /* renamed from: f */
    private final byte[] f764f;

    C1636de() {
    }

    C1636de(String str, long j, int i, boolean z, boolean z2, byte[] bArr) {
        this();
        this.f759a = str;
        this.f760b = j;
        this.f761c = i;
        this.f762d = z;
        this.f763e = z2;
        this.f764f = bArr;
    }

    /* renamed from: a */
    static C1636de m604a(String str, long j, int i, boolean z, byte[] bArr, boolean z2) {
        return new C1636de(str, j, i, z, z2, bArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo30844b() {
        if (mo30846d() == null) {
            return false;
        }
        return mo30846d().endsWith("/");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final boolean mo30845c() {
        return mo30849f() == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo30846d() {
        return this.f759a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public long mo30847e() {
        return this.f760b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1636de) {
            C1636de deVar = (C1636de) obj;
            String str = this.f759a;
            if (str != null ? str.equals(deVar.mo30846d()) : deVar.mo30846d() == null) {
                if (this.f760b == deVar.mo30847e() && this.f761c == deVar.mo30849f() && this.f762d == deVar.mo30850g() && this.f763e == deVar.mo30851h()) {
                    if (Arrays.equals(this.f764f, deVar instanceof C1636de ? deVar.f764f : deVar.mo30853i())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo30849f() {
        return this.f761c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo30850g() {
        return this.f762d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo30851h() {
        return this.f763e;
    }

    public int hashCode() {
        String str = this.f759a;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f760b;
        int i = 1237;
        int i2 = (((((((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.f761c) * 1000003) ^ (true != this.f762d ? 1237 : 1231)) * 1000003;
        if (true == this.f763e) {
            i = 1231;
        }
        return ((i2 ^ i) * 1000003) ^ Arrays.hashCode(this.f764f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public byte[] mo30853i() {
        return this.f764f;
    }

    public String toString() {
        String str = this.f759a;
        long j = this.f760b;
        int i = this.f761c;
        boolean z = this.f762d;
        boolean z2 = this.f763e;
        String arrays = Arrays.toString(this.f764f);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 126 + String.valueOf(arrays).length());
        sb.append("ZipEntry{name=");
        sb.append(str);
        sb.append(", size=");
        sb.append(j);
        sb.append(", compressionMethod=");
        sb.append(i);
        sb.append(", isPartial=");
        sb.append(z);
        sb.append(", isEndOfArchive=");
        sb.append(z2);
        sb.append(", headerBytes=");
        sb.append(arrays);
        sb.append("}");
        return sb.toString();
    }
}
