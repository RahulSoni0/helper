package com.google.android.play.core.assetpacks;

/* renamed from: com.google.android.play.core.assetpacks.cy */
final class C1629cy {

    /* renamed from: a */
    private final int f735a;

    /* renamed from: b */
    private final String f736b;

    /* renamed from: c */
    private final long f737c;

    /* renamed from: d */
    private final long f738d;

    /* renamed from: e */
    private final int f739e;

    C1629cy() {
    }

    C1629cy(int i, String str, long j, long j2, int i2) {
        this();
        this.f735a = i;
        this.f736b = str;
        this.f737c = j;
        this.f738d = j2;
        this.f739e = i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo30820a() {
        return this.f735a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo30821b() {
        return this.f736b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public long mo30822c() {
        return this.f737c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public long mo30823d() {
        return this.f738d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo30824e() {
        return this.f739e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        r1 = r7.f736b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.android.play.core.assetpacks.C1629cy
            r2 = 0
            if (r1 == 0) goto L_0x0046
            com.google.android.play.core.assetpacks.cy r8 = (com.google.android.play.core.assetpacks.C1629cy) r8
            int r1 = r7.f735a
            int r3 = r8.mo30820a()
            if (r1 != r3) goto L_0x0046
            java.lang.String r1 = r7.f736b
            if (r1 != 0) goto L_0x001e
            java.lang.String r1 = r8.mo30821b()
            if (r1 != 0) goto L_0x0046
            goto L_0x0029
        L_0x001e:
            java.lang.String r3 = r8.mo30821b()
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0029
            goto L_0x0046
        L_0x0029:
            long r3 = r7.f737c
            long r5 = r8.mo30822c()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0046
            long r3 = r7.f738d
            long r5 = r8.mo30823d()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0046
            int r1 = r7.f739e
            int r8 = r8.mo30824e()
            if (r1 != r8) goto L_0x0046
            return r0
        L_0x0046:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.C1629cy.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = (this.f735a ^ 1000003) * 1000003;
        String str = this.f736b;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f737c;
        long j2 = this.f738d;
        return ((((((i ^ hashCode) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f739e;
    }

    public String toString() {
        int i = this.f735a;
        String str = this.f736b;
        long j = this.f737c;
        long j2 = this.f738d;
        int i2 = this.f739e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 157);
        sb.append("SliceCheckpoint{fileExtractionStatus=");
        sb.append(i);
        sb.append(", filePath=");
        sb.append(str);
        sb.append(", fileOffset=");
        sb.append(j);
        sb.append(", remainingBytes=");
        sb.append(j2);
        sb.append(", previousChunk=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }
}
