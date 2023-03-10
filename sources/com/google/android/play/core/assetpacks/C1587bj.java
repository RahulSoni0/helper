package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.internal.C1692ca;
import java.io.File;

/* renamed from: com.google.android.play.core.assetpacks.bj */
final class C1587bj {

    /* renamed from: a */
    private static final C0944ag f576a = new C0944ag("ExtractChunkTaskHandler");

    /* renamed from: b */
    private final byte[] f577b = new byte[8192];

    /* renamed from: c */
    private final C1571au f578c;

    /* renamed from: d */
    private final C1692ca<C1653t> f579d;

    /* renamed from: e */
    private final C1692ca<C1568ar> f580e;

    /* renamed from: f */
    private final C1592bo f581f;

    C1587bj(C1571au auVar, C1692ca<C1653t> caVar, C1692ca<C1568ar> caVar2, C1592bo boVar) {
        this.f578c = auVar;
        this.f579d = caVar;
        this.f580e = caVar2;
        this.f581f = boVar;
    }

    /* renamed from: b */
    private final File m495b(C1586bi biVar) {
        File h = this.f578c.mo30720h(biVar.f655k, biVar.f567a, biVar.f568b, biVar.f569c);
        if (!h.exists()) {
            h.mkdirs();
        }
        return h;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x030b  */
    /* JADX WARNING: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x017c A[Catch:{ all -> 0x032e, all -> 0x0334, IOException -> 0x033a }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01a1 A[Catch:{ all -> 0x032e, all -> 0x0334, IOException -> 0x033a }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01d5 A[Catch:{ all -> 0x032e, all -> 0x0334, IOException -> 0x033a }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0290 A[SYNTHETIC, Splitter:B:93:0x0290] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo30769a(com.google.android.play.core.assetpacks.C1586bi r23) {
        /*
            r22 = this;
            r1 = r22
            r2 = r23
            com.google.android.play.core.assetpacks.cz r0 = new com.google.android.play.core.assetpacks.cz
            com.google.android.play.core.assetpacks.au r4 = r1.f578c
            java.lang.String r5 = r2.f655k
            int r6 = r2.f567a
            long r7 = r2.f568b
            java.lang.String r9 = r2.f569c
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r9)
            com.google.android.play.core.assetpacks.au r10 = r1.f578c
            java.lang.String r11 = r2.f655k
            int r12 = r2.f567a
            long r13 = r2.f568b
            java.lang.String r15 = r2.f569c
            java.io.File r3 = r10.mo30727o(r11, r12, r13, r15)
            boolean r4 = r3.exists()
            if (r4 != 0) goto L_0x002b
            r3.mkdirs()
        L_0x002b:
            r11 = 3
            r12 = 2
            r13 = 1
            r14 = 0
            java.io.InputStream r3 = r2.f575i     // Catch:{ IOException -> 0x033a }
            int r4 = r2.f570d     // Catch:{ IOException -> 0x033a }
            if (r4 == r13) goto L_0x0037
            r15 = r3
            goto L_0x003f
        L_0x0037:
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x033a }
            r5 = 8192(0x2000, float:1.14794E-41)
            r4.<init>(r3, r5)     // Catch:{ IOException -> 0x033a }
            r15 = r4
        L_0x003f:
            int r3 = r2.f571e     // Catch:{ all -> 0x032e }
            r16 = 0
            if (r3 <= 0) goto L_0x0179
            com.google.android.play.core.assetpacks.cy r3 = r0.mo30832e()     // Catch:{ all -> 0x032e }
            int r4 = r3.mo30824e()     // Catch:{ all -> 0x032e }
            int r5 = r2.f571e     // Catch:{ all -> 0x032e }
            int r6 = r5 + -1
            if (r4 != r6) goto L_0x0159
            int r4 = r3.mo30820a()     // Catch:{ all -> 0x032e }
            if (r4 == r13) goto L_0x00d8
            if (r4 == r12) goto L_0x009b
            if (r4 != r11) goto L_0x0081
            com.google.android.play.core.internal.ag r4 = f576a     // Catch:{ all -> 0x032e }
            java.lang.String r5 = "Resuming central directory from last chunk."
            java.lang.Object[] r6 = new java.lang.Object[r14]     // Catch:{ all -> 0x032e }
            r4.mo17054a(r5, r6)     // Catch:{ all -> 0x032e }
            long r3 = r3.mo30822c()     // Catch:{ all -> 0x032e }
            r0.mo30833f(r15, r3)     // Catch:{ all -> 0x032e }
            boolean r3 = r23.mo30768a()     // Catch:{ all -> 0x032e }
            if (r3 == 0) goto L_0x0077
        L_0x0073:
            r4 = r16
            goto L_0x017a
        L_0x0077:
            com.google.android.play.core.assetpacks.bk r0 = new com.google.android.play.core.assetpacks.bk     // Catch:{ all -> 0x032e }
            java.lang.String r3 = "Chunk has ended twice during central directory. This should not be possible with chunk sizes of 50MB."
            int r4 = r2.f654j     // Catch:{ all -> 0x032e }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x032e }
            throw r0     // Catch:{ all -> 0x032e }
        L_0x0081:
            com.google.android.play.core.assetpacks.bk r0 = new com.google.android.play.core.assetpacks.bk     // Catch:{ all -> 0x032e }
            java.lang.Object[] r4 = new java.lang.Object[r13]     // Catch:{ all -> 0x032e }
            int r3 = r3.mo30820a()     // Catch:{ all -> 0x032e }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x032e }
            r4[r14] = r3     // Catch:{ all -> 0x032e }
            java.lang.String r3 = "Slice checkpoint file corrupt. Unexpected FileExtractionStatus %s."
            java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch:{ all -> 0x032e }
            int r4 = r2.f654j     // Catch:{ all -> 0x032e }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x032e }
            throw r0     // Catch:{ all -> 0x032e }
        L_0x009b:
            com.google.android.play.core.internal.ag r3 = f576a     // Catch:{ all -> 0x032e }
            java.lang.String r4 = "Resuming zip entry from last chunk during local file header."
            java.lang.Object[] r5 = new java.lang.Object[r14]     // Catch:{ all -> 0x032e }
            r3.mo17054a(r4, r5)     // Catch:{ all -> 0x032e }
            com.google.android.play.core.assetpacks.au r3 = r1.f578c     // Catch:{ all -> 0x032e }
            java.lang.String r4 = r2.f655k     // Catch:{ all -> 0x032e }
            int r5 = r2.f567a     // Catch:{ all -> 0x032e }
            long r6 = r2.f568b     // Catch:{ all -> 0x032e }
            java.lang.String r8 = r2.f569c     // Catch:{ all -> 0x032e }
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r21 = r8
            java.io.File r3 = r16.mo30726n(r17, r18, r19, r21)     // Catch:{ all -> 0x032e }
            boolean r4 = r3.exists()     // Catch:{ all -> 0x032e }
            if (r4 == 0) goto L_0x00ce
            java.io.SequenceInputStream r4 = new java.io.SequenceInputStream     // Catch:{ all -> 0x032e }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ all -> 0x032e }
            r5.<init>(r3)     // Catch:{ all -> 0x032e }
            r4.<init>(r5, r15)     // Catch:{ all -> 0x032e }
            goto L_0x017a
        L_0x00ce:
            com.google.android.play.core.assetpacks.bk r0 = new com.google.android.play.core.assetpacks.bk     // Catch:{ all -> 0x032e }
            java.lang.String r3 = "Checkpoint extension file not found."
            int r4 = r2.f654j     // Catch:{ all -> 0x032e }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x032e }
            throw r0     // Catch:{ all -> 0x032e }
        L_0x00d8:
            com.google.android.play.core.internal.ag r4 = f576a     // Catch:{ all -> 0x032e }
            java.lang.Object[] r5 = new java.lang.Object[r13]     // Catch:{ all -> 0x032e }
            java.lang.String r6 = r3.mo30821b()     // Catch:{ all -> 0x032e }
            r5[r14] = r6     // Catch:{ all -> 0x032e }
            java.lang.String r6 = "Resuming zip entry from last chunk during file %s."
            r4.mo17054a(r6, r5)     // Catch:{ all -> 0x032e }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x032e }
            java.lang.String r5 = r3.mo30821b()     // Catch:{ all -> 0x032e }
            r4.<init>(r5)     // Catch:{ all -> 0x032e }
            boolean r5 = r4.exists()     // Catch:{ all -> 0x032e }
            if (r5 == 0) goto L_0x014f
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ all -> 0x032e }
            java.lang.String r6 = "rw"
            r5.<init>(r4, r6)     // Catch:{ all -> 0x032e }
            long r6 = r3.mo30822c()     // Catch:{ all -> 0x032e }
            r5.seek(r6)     // Catch:{ all -> 0x032e }
            long r6 = r3.mo30823d()     // Catch:{ all -> 0x032e }
        L_0x0108:
            r8 = 8192(0x2000, double:4.0474E-320)
            long r8 = java.lang.Math.min(r6, r8)     // Catch:{ all -> 0x032e }
            int r3 = (int) r8     // Catch:{ all -> 0x032e }
            byte[] r8 = r1.f577b     // Catch:{ all -> 0x032e }
            int r8 = r15.read(r8, r14, r3)     // Catch:{ all -> 0x032e }
            int r8 = java.lang.Math.max(r8, r14)     // Catch:{ all -> 0x032e }
            if (r8 <= 0) goto L_0x0120
            byte[] r9 = r1.f577b     // Catch:{ all -> 0x032e }
            r5.write(r9, r14, r8)     // Catch:{ all -> 0x032e }
        L_0x0120:
            long r10 = (long) r8     // Catch:{ all -> 0x032e }
            long r10 = r6 - r10
            r6 = 0
            int r9 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r9 <= 0) goto L_0x012f
            if (r8 > 0) goto L_0x012c
            goto L_0x012f
        L_0x012c:
            r6 = r10
            r11 = 3
            goto L_0x0108
        L_0x012f:
            long r6 = r5.length()     // Catch:{ all -> 0x032e }
            r5.close()     // Catch:{ all -> 0x032e }
            if (r8 == r3) goto L_0x0179
            com.google.android.play.core.internal.ag r3 = f576a     // Catch:{ all -> 0x032e }
            java.lang.String r5 = "Chunk has ended while resuming the previous chunks file content."
            java.lang.Object[] r8 = new java.lang.Object[r14]     // Catch:{ all -> 0x032e }
            r3.mo17054a(r5, r8)     // Catch:{ all -> 0x032e }
            java.lang.String r4 = r4.getCanonicalPath()     // Catch:{ all -> 0x032e }
            int r9 = r2.f571e     // Catch:{ all -> 0x032e }
            r3 = r0
            r5 = r6
            r7 = r10
            r3.mo30828a(r4, r5, r7, r9)     // Catch:{ all -> 0x032e }
            goto L_0x0073
        L_0x014f:
            com.google.android.play.core.assetpacks.bk r0 = new com.google.android.play.core.assetpacks.bk     // Catch:{ all -> 0x032e }
            java.lang.String r3 = "Partial file specified in checkpoint does not exist. Corrupt directory."
            int r4 = r2.f654j     // Catch:{ all -> 0x032e }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x032e }
            throw r0     // Catch:{ all -> 0x032e }
        L_0x0159:
            com.google.android.play.core.assetpacks.bk r0 = new com.google.android.play.core.assetpacks.bk     // Catch:{ all -> 0x032e }
            java.lang.String r4 = "Trying to resume with chunk number %s when previously processed chunk was number %s."
            java.lang.Object[] r6 = new java.lang.Object[r12]     // Catch:{ all -> 0x032e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x032e }
            r6[r14] = r5     // Catch:{ all -> 0x032e }
            int r3 = r3.mo30824e()     // Catch:{ all -> 0x032e }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x032e }
            r6[r13] = r3     // Catch:{ all -> 0x032e }
            java.lang.String r3 = java.lang.String.format(r4, r6)     // Catch:{ all -> 0x032e }
            int r4 = r2.f654j     // Catch:{ all -> 0x032e }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x032e }
            throw r0     // Catch:{ all -> 0x032e }
        L_0x0179:
            r4 = r15
        L_0x017a:
            if (r4 == 0) goto L_0x0287
            com.google.android.play.core.assetpacks.bd r3 = new com.google.android.play.core.assetpacks.bd     // Catch:{ all -> 0x032e }
            r3.<init>(r4)     // Catch:{ all -> 0x032e }
            java.io.File r5 = r22.m495b(r23)     // Catch:{ all -> 0x032e }
        L_0x0185:
            com.google.android.play.core.assetpacks.de r6 = r3.mo30758a()     // Catch:{ all -> 0x032e }
            boolean r7 = r6.mo30850g()     // Catch:{ all -> 0x032e }
            if (r7 != 0) goto L_0x01dc
            boolean r7 = r3.mo30760c()     // Catch:{ all -> 0x032e }
            if (r7 != 0) goto L_0x01dc
            boolean r7 = r6.mo30845c()     // Catch:{ all -> 0x032e }
            if (r7 == 0) goto L_0x01d5
            boolean r7 = r6.mo30844b()     // Catch:{ all -> 0x032e }
            if (r7 != 0) goto L_0x01d5
            byte[] r7 = r6.mo30853i()     // Catch:{ all -> 0x032e }
            r0.mo30834g(r7)     // Catch:{ all -> 0x032e }
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x032e }
            java.lang.String r8 = r6.mo30846d()     // Catch:{ all -> 0x032e }
            r7.<init>(r5, r8)     // Catch:{ all -> 0x032e }
            java.io.File r8 = r7.getParentFile()     // Catch:{ all -> 0x032e }
            r8.mkdirs()     // Catch:{ all -> 0x032e }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ all -> 0x032e }
            r8.<init>(r7)     // Catch:{ all -> 0x032e }
            byte[] r7 = r1.f577b     // Catch:{ all -> 0x032e }
            int r7 = r3.read(r7)     // Catch:{ all -> 0x032e }
        L_0x01c3:
            if (r7 <= 0) goto L_0x01d1
            byte[] r9 = r1.f577b     // Catch:{ all -> 0x032e }
            r8.write(r9, r14, r7)     // Catch:{ all -> 0x032e }
            byte[] r7 = r1.f577b     // Catch:{ all -> 0x032e }
            int r7 = r3.read(r7)     // Catch:{ all -> 0x032e }
            goto L_0x01c3
        L_0x01d1:
            r8.close()     // Catch:{ all -> 0x032e }
            goto L_0x01dc
        L_0x01d5:
            byte[] r7 = r6.mo30853i()     // Catch:{ all -> 0x032e }
            r0.mo30835h(r7, r3)     // Catch:{ all -> 0x032e }
        L_0x01dc:
            boolean r7 = r3.mo30759b()     // Catch:{ all -> 0x032e }
            if (r7 != 0) goto L_0x01e8
            boolean r7 = r3.mo30760c()     // Catch:{ all -> 0x032e }
            if (r7 == 0) goto L_0x0185
        L_0x01e8:
            boolean r5 = r3.mo30760c()     // Catch:{ all -> 0x032e }
            if (r5 == 0) goto L_0x01fe
            com.google.android.play.core.internal.ag r5 = f576a     // Catch:{ all -> 0x032e }
            java.lang.String r7 = "Writing central directory metadata."
            java.lang.Object[] r8 = new java.lang.Object[r14]     // Catch:{ all -> 0x032e }
            r5.mo17054a(r7, r8)     // Catch:{ all -> 0x032e }
            byte[] r5 = r6.mo30853i()     // Catch:{ all -> 0x032e }
            r0.mo30835h(r5, r4)     // Catch:{ all -> 0x032e }
        L_0x01fe:
            boolean r4 = r23.mo30768a()     // Catch:{ all -> 0x032e }
            if (r4 != 0) goto L_0x0287
            boolean r4 = r6.mo30850g()     // Catch:{ all -> 0x032e }
            if (r4 == 0) goto L_0x021d
            com.google.android.play.core.internal.ag r3 = f576a     // Catch:{ all -> 0x032e }
            java.lang.String r4 = "Writing slice checkpoint for partial local file header."
            java.lang.Object[] r5 = new java.lang.Object[r14]     // Catch:{ all -> 0x032e }
            r3.mo17054a(r4, r5)     // Catch:{ all -> 0x032e }
            byte[] r3 = r6.mo30853i()     // Catch:{ all -> 0x032e }
            int r4 = r2.f571e     // Catch:{ all -> 0x032e }
            r0.mo30829b(r3, r4)     // Catch:{ all -> 0x032e }
            goto L_0x0287
        L_0x021d:
            boolean r4 = r3.mo30760c()     // Catch:{ all -> 0x032e }
            if (r4 == 0) goto L_0x0232
            com.google.android.play.core.internal.ag r3 = f576a     // Catch:{ all -> 0x032e }
            java.lang.String r4 = "Writing slice checkpoint for central directory."
            java.lang.Object[] r5 = new java.lang.Object[r14]     // Catch:{ all -> 0x032e }
            r3.mo17054a(r4, r5)     // Catch:{ all -> 0x032e }
            int r3 = r2.f571e     // Catch:{ all -> 0x032e }
            r0.mo30830c(r3)     // Catch:{ all -> 0x032e }
            goto L_0x0287
        L_0x0232:
            int r4 = r6.mo30849f()     // Catch:{ all -> 0x032e }
            if (r4 != 0) goto L_0x0268
            com.google.android.play.core.internal.ag r4 = f576a     // Catch:{ all -> 0x032e }
            java.lang.String r5 = "Writing slice checkpoint for partial file."
            java.lang.Object[] r7 = new java.lang.Object[r14]     // Catch:{ all -> 0x032e }
            r4.mo17054a(r5, r7)     // Catch:{ all -> 0x032e }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x032e }
            java.io.File r5 = r22.m495b(r23)     // Catch:{ all -> 0x032e }
            java.lang.String r7 = r6.mo30846d()     // Catch:{ all -> 0x032e }
            r4.<init>(r5, r7)     // Catch:{ all -> 0x032e }
            long r5 = r6.mo30847e()     // Catch:{ all -> 0x032e }
            long r7 = r3.mo30761d()     // Catch:{ all -> 0x032e }
            long r5 = r5 - r7
            long r7 = r4.length()     // Catch:{ all -> 0x032e }
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 != 0) goto L_0x0260
            goto L_0x0279
        L_0x0260:
            com.google.android.play.core.assetpacks.bk r0 = new com.google.android.play.core.assetpacks.bk     // Catch:{ all -> 0x032e }
            java.lang.String r3 = "Partial file is of unexpected size."
            r0.<init>(r3)     // Catch:{ all -> 0x032e }
            throw r0     // Catch:{ all -> 0x032e }
        L_0x0268:
            com.google.android.play.core.internal.ag r4 = f576a     // Catch:{ all -> 0x032e }
            java.lang.String r5 = "Writing slice checkpoint for partial unextractable file."
            java.lang.Object[] r6 = new java.lang.Object[r14]     // Catch:{ all -> 0x032e }
            r4.mo17054a(r5, r6)     // Catch:{ all -> 0x032e }
            java.io.File r4 = r0.mo30837j()     // Catch:{ all -> 0x032e }
            long r5 = r4.length()     // Catch:{ all -> 0x032e }
        L_0x0279:
            java.lang.String r4 = r4.getCanonicalPath()     // Catch:{ all -> 0x032e }
            long r7 = r3.mo30761d()     // Catch:{ all -> 0x032e }
            int r9 = r2.f571e     // Catch:{ all -> 0x032e }
            r3 = r0
            r3.mo30828a(r4, r5, r7, r9)     // Catch:{ all -> 0x032e }
        L_0x0287:
            r15.close()     // Catch:{ IOException -> 0x033a }
            boolean r3 = r23.mo30768a()
            if (r3 == 0) goto L_0x02b0
            int r3 = r2.f571e     // Catch:{ IOException -> 0x0296 }
            r0.mo30831d(r3)     // Catch:{ IOException -> 0x0296 }
            goto L_0x02b0
        L_0x0296:
            r0 = move-exception
            com.google.android.play.core.internal.ag r3 = f576a
            java.lang.Object[] r4 = new java.lang.Object[r13]
            java.lang.String r5 = r0.getMessage()
            r4[r14] = r5
            java.lang.String r5 = "Writing extraction finished checkpoint failed with %s."
            r3.mo17055b(r5, r4)
            com.google.android.play.core.assetpacks.bk r3 = new com.google.android.play.core.assetpacks.bk
            int r2 = r2.f654j
            java.lang.String r4 = "Writing extraction finished checkpoint failed."
            r3.<init>(r4, r0, r2)
            throw r3
        L_0x02b0:
            com.google.android.play.core.internal.ag r0 = f576a
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]
            int r4 = r2.f571e
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r14] = r4
            java.lang.String r4 = r2.f569c
            r3[r13] = r4
            java.lang.String r4 = r2.f655k
            r3[r12] = r4
            int r4 = r2.f654j
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 3
            r3[r5] = r4
            java.lang.String r4 = "Extraction finished for chunk %s of slice %s of pack %s of session %s."
            r0.mo17057d(r4, r3)
            com.google.android.play.core.internal.ca<com.google.android.play.core.assetpacks.t> r0 = r1.f579d
            java.lang.Object r0 = r0.mo30920a()
            com.google.android.play.core.assetpacks.t r0 = (com.google.android.play.core.assetpacks.C1653t) r0
            int r3 = r2.f654j
            java.lang.String r4 = r2.f655k
            java.lang.String r5 = r2.f569c
            int r6 = r2.f571e
            r0.mo30697e(r3, r4, r5, r6)
            java.io.InputStream r0 = r2.f575i     // Catch:{ IOException -> 0x02ec }
            r0.close()     // Catch:{ IOException -> 0x02ec }
            goto L_0x0306
        L_0x02ec:
            com.google.android.play.core.internal.ag r0 = f576a
            r3 = 3
            java.lang.Object[] r4 = new java.lang.Object[r3]
            int r3 = r2.f571e
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4[r14] = r3
            java.lang.String r3 = r2.f569c
            r4[r13] = r3
            java.lang.String r3 = r2.f655k
            r4[r12] = r3
            java.lang.String r3 = "Could not close file for chunk %s of slice %s of pack %s."
            r0.mo17058e(r3, r4)
        L_0x0306:
            int r0 = r2.f574h
            r3 = 3
            if (r0 != r3) goto L_0x032d
            com.google.android.play.core.internal.ca<com.google.android.play.core.assetpacks.ar> r0 = r1.f580e
            java.lang.Object r0 = r0.mo30920a()
            com.google.android.play.core.assetpacks.ar r0 = (com.google.android.play.core.assetpacks.C1568ar) r0
            java.lang.String r3 = r2.f655k
            long r7 = r2.f573g
            r4 = 3
            r5 = 0
            com.google.android.play.core.assetpacks.bo r6 = r1.f581f
            double r9 = r6.mo30776c(r3, r2)
            r11 = 1
            java.lang.String r12 = ""
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            com.google.android.play.core.assetpacks.AssetPackState r2 = com.google.android.play.core.assetpacks.AssetPackState.m354c(r2, r3, r4, r5, r7, r9, r11, r12)
            r0.mo30706b(r2)
        L_0x032d:
            return
        L_0x032e:
            r0 = move-exception
            r3 = r0
            r15.close()     // Catch:{ all -> 0x0334 }
            goto L_0x0339
        L_0x0334:
            r0 = move-exception
            r4 = r0
            com.google.android.play.core.internal.C0971bz.m125a(r3, r4)     // Catch:{ IOException -> 0x033a }
        L_0x0339:
            throw r3     // Catch:{ IOException -> 0x033a }
        L_0x033a:
            r0 = move-exception
            com.google.android.play.core.internal.ag r3 = f576a
            java.lang.Object[] r4 = new java.lang.Object[r13]
            java.lang.String r5 = r0.getMessage()
            r4[r14] = r5
            java.lang.String r5 = "IOException during extraction %s."
            r3.mo17055b(r5, r4)
            com.google.android.play.core.assetpacks.bk r3 = new com.google.android.play.core.assetpacks.bk
            r4 = 4
            java.lang.Object[] r4 = new java.lang.Object[r4]
            int r5 = r2.f571e
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4[r14] = r5
            java.lang.String r5 = r2.f569c
            r4[r13] = r5
            java.lang.String r5 = r2.f655k
            r4[r12] = r5
            int r5 = r2.f654j
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6 = 3
            r4[r6] = r5
            java.lang.String r5 = "Error extracting chunk %s of slice %s of pack %s of session %s."
            java.lang.String r4 = java.lang.String.format(r5, r4)
            int r2 = r2.f654j
            r3.<init>(r4, r0, r2)
            goto L_0x0375
        L_0x0374:
            throw r3
        L_0x0375:
            goto L_0x0374
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.C1587bj.mo30769a(com.google.android.play.core.assetpacks.bi):void");
    }
}
