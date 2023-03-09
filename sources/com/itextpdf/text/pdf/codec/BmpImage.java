package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.ImgRaw;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BidiOrder;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class BmpImage {
    private static final int BI_BITFIELDS = 3;
    private static final int BI_RGB = 0;
    private static final int BI_RLE4 = 2;
    private static final int BI_RLE8 = 1;
    private static final int LCS_CALIBRATED_RGB = 0;
    private static final int LCS_CMYK = 2;
    private static final int LCS_sRGB = 1;
    private static final int VERSION_2_1_BIT = 0;
    private static final int VERSION_2_24_BIT = 3;
    private static final int VERSION_2_4_BIT = 1;
    private static final int VERSION_2_8_BIT = 2;
    private static final int VERSION_3_1_BIT = 4;
    private static final int VERSION_3_24_BIT = 7;
    private static final int VERSION_3_4_BIT = 5;
    private static final int VERSION_3_8_BIT = 6;
    private static final int VERSION_3_NT_16_BIT = 8;
    private static final int VERSION_3_NT_32_BIT = 9;
    private static final int VERSION_4_16_BIT = 13;
    private static final int VERSION_4_1_BIT = 10;
    private static final int VERSION_4_24_BIT = 14;
    private static final int VERSION_4_32_BIT = 15;
    private static final int VERSION_4_4_BIT = 11;
    private static final int VERSION_4_8_BIT = 12;
    private int alphaMask;
    private long bitmapFileSize;
    private long bitmapOffset;
    private int bitsPerPixel;
    private int blueMask;
    private long compression;
    private int greenMask;
    int height;
    private long imageSize;
    private int imageType;
    private InputStream inputStream;
    private boolean isBottomUp;
    private int numBands;
    private byte[] palette;
    public HashMap<String, Object> properties = new HashMap<>();
    private int redMask;
    int width;
    private long xPelsPerMeter;
    private long yPelsPerMeter;

    private int findMask(int i) {
        for (int i2 = 0; i2 < 32 && (i & 1) != 1; i2++) {
            i >>>= 1;
        }
        return i;
    }

    private int findShift(int i) {
        int i2 = 0;
        while (i2 < 32 && (i & 1) != 1) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    BmpImage(InputStream inputStream2, boolean z, int i) throws IOException {
        this.bitmapFileSize = (long) i;
        this.bitmapOffset = 0;
        process(inputStream2, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.itextpdf.text.Image getImage(java.net.URL r2) throws java.io.IOException {
        /*
            java.io.InputStream r0 = r2.openStream()     // Catch:{ all -> 0x0013 }
            com.itextpdf.text.Image r1 = getImage((java.io.InputStream) r0)     // Catch:{ all -> 0x0011 }
            r1.setUrl(r2)     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x0010
            r0.close()
        L_0x0010:
            return r1
        L_0x0011:
            r2 = move-exception
            goto L_0x0015
        L_0x0013:
            r2 = move-exception
            r0 = 0
        L_0x0015:
            if (r0 == 0) goto L_0x001a
            r0.close()
        L_0x001a:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.BmpImage.getImage(java.net.URL):com.itextpdf.text.Image");
    }

    public static Image getImage(InputStream inputStream2) throws IOException {
        return getImage(inputStream2, false, 0);
    }

    public static Image getImage(InputStream inputStream2, boolean z, int i) throws IOException {
        BmpImage bmpImage = new BmpImage(inputStream2, z, i);
        try {
            Image image = bmpImage.getImage();
            double d = (double) bmpImage.xPelsPerMeter;
            Double.isNaN(d);
            int i2 = (int) ((d * 0.0254d) + 0.5d);
            double d2 = (double) bmpImage.yPelsPerMeter;
            Double.isNaN(d2);
            image.setDpi(i2, (int) ((d2 * 0.0254d) + 0.5d));
            image.setOriginalType(4);
            return image;
        } catch (BadElementException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static Image getImage(String str) throws IOException {
        return getImage(Utilities.toURL(str));
    }

    public static Image getImage(byte[] bArr) throws IOException {
        Image image = getImage((InputStream) new ByteArrayInputStream(bArr));
        image.setOriginalData(bArr);
        return image;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02fe, code lost:
        r1 = ((int) r4) * 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0301, code lost:
        r0.bitmapOffset = r2 + ((long) r1);
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x030d  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x032d  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void process(java.io.InputStream r34, boolean r35) throws java.io.IOException {
        /*
            r33 = this;
            r0 = r33
            r1 = r34
            if (r35 != 0) goto L_0x0013
            boolean r2 = r1 instanceof java.io.BufferedInputStream
            if (r2 == 0) goto L_0x000b
            goto L_0x0013
        L_0x000b:
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream
            r2.<init>(r1)
            r0.inputStream = r2
            goto L_0x0015
        L_0x0013:
            r0.inputStream = r1
        L_0x0015:
            r1 = 0
            if (r35 != 0) goto L_0x0055
            java.io.InputStream r2 = r0.inputStream
            int r2 = r0.readUnsignedByte(r2)
            r3 = 66
            if (r2 != r3) goto L_0x0047
            java.io.InputStream r2 = r0.inputStream
            int r2 = r0.readUnsignedByte(r2)
            r3 = 77
            if (r2 != r3) goto L_0x0047
            java.io.InputStream r2 = r0.inputStream
            long r2 = r0.readDWord(r2)
            r0.bitmapFileSize = r2
            java.io.InputStream r2 = r0.inputStream
            r0.readWord(r2)
            java.io.InputStream r2 = r0.inputStream
            r0.readWord(r2)
            java.io.InputStream r2 = r0.inputStream
            long r2 = r0.readDWord(r2)
            r0.bitmapOffset = r2
            goto L_0x0055
        L_0x0047:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r3 = "invalid.magic.value.for.bmp.file"
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage((java.lang.String) r3, (java.lang.Object[]) r1)
            r2.<init>(r1)
            throw r2
        L_0x0055:
            java.io.InputStream r2 = r0.inputStream
            long r2 = r0.readDWord(r2)
            r4 = 12
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0072
            java.io.InputStream r6 = r0.inputStream
            int r6 = r0.readWord(r6)
            r0.width = r6
            java.io.InputStream r6 = r0.inputStream
            int r6 = r0.readWord(r6)
            r0.height = r6
            goto L_0x0082
        L_0x0072:
            java.io.InputStream r6 = r0.inputStream
            int r6 = r0.readLong(r6)
            r0.width = r6
            java.io.InputStream r6 = r0.inputStream
            int r6 = r0.readLong(r6)
            r0.height = r6
        L_0x0082:
            java.io.InputStream r6 = r0.inputStream
            int r6 = r0.readWord(r6)
            java.io.InputStream r7 = r0.inputStream
            int r7 = r0.readWord(r7)
            r0.bitsPerPixel = r7
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r0.properties
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r8 = "color_planes"
            r7.put(r8, r6)
            java.util.HashMap<java.lang.String, java.lang.Object> r6 = r0.properties
            int r7 = r0.bitsPerPixel
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r8 = "bits_per_pixel"
            r6.put(r8, r7)
            r6 = 3
            r0.numBands = r6
            long r7 = r0.bitmapOffset
            r9 = 0
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x00b5
            r0.bitmapOffset = r2
        L_0x00b5:
            r8 = 24
            r11 = 14
            java.lang.String r15 = "bmp_version"
            r7 = 8
            r9 = 2
            r10 = 1
            r13 = 4
            int r17 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r17 != 0) goto L_0x010e
            java.util.HashMap<java.lang.String, java.lang.Object> r4 = r0.properties
            java.lang.String r5 = "BMP v. 2.x"
            r4.put(r15, r5)
            int r4 = r0.bitsPerPixel
            if (r4 != r10) goto L_0x00d2
            r0.imageType = r1
            goto L_0x00e0
        L_0x00d2:
            if (r4 != r13) goto L_0x00d7
            r0.imageType = r10
            goto L_0x00e0
        L_0x00d7:
            if (r4 != r7) goto L_0x00dc
            r0.imageType = r9
            goto L_0x00e0
        L_0x00dc:
            if (r4 != r8) goto L_0x00e0
            r0.imageType = r6
        L_0x00e0:
            long r4 = r0.bitmapOffset
            long r11 = r4 - r11
            long r11 = r11 - r2
            r15 = 3
            long r11 = r11 / r15
            int r8 = (int) r11
            int r8 = r8 * 3
            int r11 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r11 != 0) goto L_0x0109
            int r4 = r0.imageType
            if (r4 == 0) goto L_0x0103
            if (r4 == r10) goto L_0x0100
            if (r4 == r9) goto L_0x00fd
            if (r4 == r6) goto L_0x00fb
            r4 = r8
            goto L_0x0104
        L_0x00fb:
            r4 = 0
            goto L_0x0104
        L_0x00fd:
            r4 = 768(0x300, float:1.076E-42)
            goto L_0x0104
        L_0x0100:
            r4 = 48
            goto L_0x0104
        L_0x0103:
            r4 = 6
        L_0x0104:
            long r11 = (long) r4
            long r2 = r2 + r11
            r0.bitmapOffset = r2
            r8 = r4
        L_0x0109:
            r0.readPalette(r8)
            goto L_0x0589
        L_0x010e:
            java.io.InputStream r4 = r0.inputStream
            long r4 = r0.readDWord(r4)
            r0.compression = r4
            java.io.InputStream r4 = r0.inputStream
            long r4 = r0.readDWord(r4)
            r0.imageSize = r4
            java.io.InputStream r4 = r0.inputStream
            int r4 = r0.readLong(r4)
            long r4 = (long) r4
            r0.xPelsPerMeter = r4
            java.io.InputStream r4 = r0.inputStream
            int r4 = r0.readLong(r4)
            long r4 = (long) r4
            r0.yPelsPerMeter = r4
            java.io.InputStream r4 = r0.inputStream
            long r4 = r0.readDWord(r4)
            java.io.InputStream r1 = r0.inputStream
            long r18 = r0.readDWord(r1)
            long r11 = r0.compression
            int r1 = (int) r11
            java.lang.String r11 = "compression"
            if (r1 == 0) goto L_0x0162
            if (r1 == r10) goto L_0x015a
            if (r1 == r9) goto L_0x0152
            if (r1 == r6) goto L_0x014a
            goto L_0x0169
        L_0x014a:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.String r12 = "BI_BITFIELDS"
            r1.put(r11, r12)
            goto L_0x0169
        L_0x0152:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.String r12 = "BI_RLE4"
            r1.put(r11, r12)
            goto L_0x0169
        L_0x015a:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.String r12 = "BI_RLE8"
            r1.put(r11, r12)
            goto L_0x0169
        L_0x0162:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.String r12 = "BI_RGB"
            r1.put(r11, r12)
        L_0x0169:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            long r11 = r0.xPelsPerMeter
            java.lang.Long r11 = java.lang.Long.valueOf(r11)
            java.lang.String r12 = "x_pixels_per_meter"
            r1.put(r12, r11)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            long r11 = r0.yPelsPerMeter
            java.lang.Long r11 = java.lang.Long.valueOf(r11)
            java.lang.String r12 = "y_pixels_per_meter"
            r1.put(r12, r11)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.Long r11 = java.lang.Long.valueOf(r4)
            java.lang.String r12 = "colors_used"
            r1.put(r12, r11)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.Long r11 = java.lang.Long.valueOf(r18)
            java.lang.String r12 = "colors_important"
            r1.put(r12, r11)
            r11 = 40
            java.lang.String r1 = "alpha_mask"
            r18 = 56
            java.lang.String r6 = "blue_mask"
            java.lang.String r9 = "green_mask"
            java.lang.String r8 = "red_mask"
            int r23 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r23 == 0) goto L_0x03cf
            r11 = 52
            int r23 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r23 == 0) goto L_0x03cf
            int r11 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r11 != 0) goto L_0x01b5
            goto L_0x03cf
        L_0x01b5:
            r11 = 108(0x6c, double:5.34E-322)
            int r18 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r18 != 0) goto L_0x03c0
            java.util.HashMap<java.lang.String, java.lang.Object> r11 = r0.properties
            java.lang.String r12 = "BMP v. 4.x"
            r11.put(r15, r12)
            java.io.InputStream r11 = r0.inputStream
            long r11 = r0.readDWord(r11)
            int r12 = (int) r11
            r0.redMask = r12
            java.io.InputStream r11 = r0.inputStream
            long r11 = r0.readDWord(r11)
            int r12 = (int) r11
            r0.greenMask = r12
            java.io.InputStream r11 = r0.inputStream
            long r11 = r0.readDWord(r11)
            int r12 = (int) r11
            r0.blueMask = r12
            java.io.InputStream r11 = r0.inputStream
            long r11 = r0.readDWord(r11)
            int r12 = (int) r11
            r0.alphaMask = r12
            java.io.InputStream r11 = r0.inputStream
            long r11 = r0.readDWord(r11)
            java.io.InputStream r15 = r0.inputStream
            int r15 = r0.readLong(r15)
            java.io.InputStream r14 = r0.inputStream
            int r14 = r0.readLong(r14)
            java.io.InputStream r7 = r0.inputStream
            int r7 = r0.readLong(r7)
            java.io.InputStream r13 = r0.inputStream
            int r13 = r0.readLong(r13)
            java.io.InputStream r10 = r0.inputStream
            int r10 = r0.readLong(r10)
            r34 = r10
            java.io.InputStream r10 = r0.inputStream
            int r10 = r0.readLong(r10)
            r18 = r10
            java.io.InputStream r10 = r0.inputStream
            int r10 = r0.readLong(r10)
            r19 = r10
            java.io.InputStream r10 = r0.inputStream
            int r10 = r0.readLong(r10)
            r24 = r10
            java.io.InputStream r10 = r0.inputStream
            int r10 = r0.readLong(r10)
            r25 = r10
            java.io.InputStream r10 = r0.inputStream
            long r26 = r0.readDWord(r10)
            java.io.InputStream r10 = r0.inputStream
            long r28 = r0.readDWord(r10)
            java.io.InputStream r10 = r0.inputStream
            long r30 = r0.readDWord(r10)
            int r10 = r0.bitsPerPixel
            r32 = r13
            r13 = 1
            if (r10 != r13) goto L_0x024c
            r10 = 10
            r0.imageType = r10
        L_0x0249:
            r22 = r14
            goto L_0x029e
        L_0x024c:
            r13 = 4
            if (r10 != r13) goto L_0x0254
            r10 = 11
            r0.imageType = r10
            goto L_0x0249
        L_0x0254:
            r13 = 8
            if (r10 != r13) goto L_0x025d
            r10 = 12
            r0.imageType = r10
            goto L_0x0249
        L_0x025d:
            r13 = 16
            if (r10 != r13) goto L_0x0279
            r10 = 13
            r0.imageType = r10
            r22 = r14
            long r13 = r0.compression
            int r10 = (int) r13
            if (r10 != 0) goto L_0x029e
            r10 = 31744(0x7c00, float:4.4483E-41)
            r0.redMask = r10
            r10 = 992(0x3e0, float:1.39E-42)
            r0.greenMask = r10
            r10 = 31
            r0.blueMask = r10
            goto L_0x029e
        L_0x0279:
            r22 = r14
            r13 = 24
            if (r10 != r13) goto L_0x0284
            r10 = 14
            r0.imageType = r10
            goto L_0x029e
        L_0x0284:
            r13 = 32
            if (r10 != r13) goto L_0x029e
            r10 = 15
            r0.imageType = r10
            long r13 = r0.compression
            int r10 = (int) r13
            if (r10 != 0) goto L_0x029e
            r10 = 16711680(0xff0000, float:2.3418052E-38)
            r0.redMask = r10
            r10 = 65280(0xff00, float:9.1477E-41)
            r0.greenMask = r10
            r10 = 255(0xff, float:3.57E-43)
            r0.blueMask = r10
        L_0x029e:
            java.util.HashMap<java.lang.String, java.lang.Object> r10 = r0.properties
            int r13 = r0.redMask
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r10.put(r8, r13)
            java.util.HashMap<java.lang.String, java.lang.Object> r8 = r0.properties
            int r10 = r0.greenMask
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r8.put(r9, r10)
            java.util.HashMap<java.lang.String, java.lang.Object> r8 = r0.properties
            int r9 = r0.blueMask
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r8.put(r6, r9)
            java.util.HashMap<java.lang.String, java.lang.Object> r6 = r0.properties
            int r8 = r0.alphaMask
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r6.put(r1, r8)
            long r8 = r0.bitmapOffset
            r13 = 14
            long r13 = r8 - r13
            long r13 = r13 - r2
            r20 = 4
            long r13 = r13 / r20
            int r1 = (int) r13
            r6 = 4
            int r1 = r1 * 4
            int r10 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r10 != 0) goto L_0x0305
            int r1 = r0.imageType
            switch(r1) {
                case 10: goto L_0x02f6;
                case 11: goto L_0x02ed;
                case 12: goto L_0x02e4;
                default: goto L_0x02e2;
            }
        L_0x02e2:
            r1 = 0
            goto L_0x0301
        L_0x02e4:
            r8 = 0
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 != 0) goto L_0x02fe
            r4 = 256(0x100, double:1.265E-321)
            goto L_0x02fe
        L_0x02ed:
            r8 = 0
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 != 0) goto L_0x02fe
            r4 = 16
            goto L_0x02fe
        L_0x02f6:
            r8 = 0
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 != 0) goto L_0x02fe
            r4 = 2
        L_0x02fe:
            int r1 = (int) r4
            int r1 = r1 * 4
        L_0x0301:
            long r4 = (long) r1
            long r2 = r2 + r4
            r0.bitmapOffset = r2
        L_0x0305:
            r0.readPalette(r1)
            int r1 = (int) r11
            java.lang.String r2 = "color_space"
            if (r1 == 0) goto L_0x032d
            r3 = 1
            if (r1 == r3) goto L_0x0324
            r3 = 2
            if (r1 == r3) goto L_0x0315
            goto L_0x0589
        L_0x0315:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.String r3 = "LCS_CMYK"
            r1.put(r2, r3)
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Not implemented yet."
            r1.<init>(r2)
            throw r1
        L_0x0324:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.String r3 = "LCS_sRGB"
            r1.put(r2, r3)
            goto L_0x0589
        L_0x032d:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.String r3 = "LCS_CALIBRATED_RGB"
            r1.put(r2, r3)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.Integer r2 = java.lang.Integer.valueOf(r15)
            java.lang.String r3 = "redX"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.Integer r2 = java.lang.Integer.valueOf(r22)
            java.lang.String r3 = "redY"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            java.lang.String r3 = "redZ"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.Integer r2 = java.lang.Integer.valueOf(r32)
            java.lang.String r3 = "greenX"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.Integer r2 = java.lang.Integer.valueOf(r34)
            java.lang.String r3 = "greenY"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.Integer r2 = java.lang.Integer.valueOf(r18)
            java.lang.String r3 = "greenZ"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.Integer r2 = java.lang.Integer.valueOf(r19)
            java.lang.String r3 = "blueX"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.Integer r2 = java.lang.Integer.valueOf(r24)
            java.lang.String r3 = "blueY"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.Integer r2 = java.lang.Integer.valueOf(r25)
            java.lang.String r3 = "blueZ"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.Long r2 = java.lang.Long.valueOf(r26)
            java.lang.String r3 = "gamma_red"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.Long r2 = java.lang.Long.valueOf(r28)
            java.lang.String r3 = "gamma_green"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.Long r2 = java.lang.Long.valueOf(r30)
            java.lang.String r3 = "gamma_blue"
            r1.put(r3, r2)
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Not implemented yet."
            r1.<init>(r2)
            throw r1
        L_0x03c0:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.String r2 = "BMP v. 5.x"
            r1.put(r15, r2)
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "BMP version 5 not implemented yet."
            r1.<init>(r2)
            throw r1
        L_0x03cf:
            long r10 = r0.compression
            int r7 = (int) r10
            if (r7 == 0) goto L_0x0460
            r10 = 1
            if (r7 == r10) goto L_0x0460
            r10 = 2
            if (r7 == r10) goto L_0x0460
            r10 = 3
            if (r7 != r10) goto L_0x0458
            int r7 = r0.bitsPerPixel
            r10 = 16
            if (r7 != r10) goto L_0x03e8
            r10 = 8
            r0.imageType = r10
            goto L_0x03f0
        L_0x03e8:
            r10 = 32
            if (r7 != r10) goto L_0x03f0
            r7 = 9
            r0.imageType = r7
        L_0x03f0:
            java.io.InputStream r7 = r0.inputStream
            long r10 = r0.readDWord(r7)
            int r7 = (int) r10
            r0.redMask = r7
            java.io.InputStream r7 = r0.inputStream
            long r10 = r0.readDWord(r7)
            int r7 = (int) r10
            r0.greenMask = r7
            java.io.InputStream r7 = r0.inputStream
            long r10 = r0.readDWord(r7)
            int r7 = (int) r10
            r0.blueMask = r7
            int r7 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r7 != 0) goto L_0x0421
            java.io.InputStream r2 = r0.inputStream
            long r2 = r0.readDWord(r2)
            int r3 = (int) r2
            r0.alphaMask = r3
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r0.properties
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.put(r1, r3)
        L_0x0421:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            int r2 = r0.redMask
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.put(r8, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            int r2 = r0.greenMask
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.put(r9, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            int r2 = r0.blueMask
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.put(r6, r2)
            r1 = 0
            int r3 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x044f
            int r1 = (int) r4
            r2 = 4
            int r1 = r1 * 4
            r0.readPalette(r1)
        L_0x044f:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.String r2 = "BMP v. 3.x NT"
            r1.put(r15, r2)
            goto L_0x0589
        L_0x0458:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Invalid compression specified in BMP file."
            r1.<init>(r2)
            throw r1
        L_0x0460:
            int r7 = r0.bitsPerPixel
            r10 = 1
            if (r7 != r10) goto L_0x046a
            r10 = 4
            r0.imageType = r10
            goto L_0x04e8
        L_0x046a:
            r10 = 4
            if (r7 != r10) goto L_0x0472
            r7 = 5
            r0.imageType = r7
            goto L_0x04e8
        L_0x0472:
            r10 = 8
            if (r7 != r10) goto L_0x047a
            r11 = 6
            r0.imageType = r11
            goto L_0x04e8
        L_0x047a:
            r11 = 24
            if (r7 != r11) goto L_0x0482
            r7 = 7
            r0.imageType = r7
            goto L_0x04e8
        L_0x0482:
            r11 = 16
            if (r7 != r11) goto L_0x04b4
            r0.imageType = r10
            r7 = 31744(0x7c00, float:4.4483E-41)
            r0.redMask = r7
            r10 = 992(0x3e0, float:1.39E-42)
            r0.greenMask = r10
            r10 = 31
            r0.blueMask = r10
            java.util.HashMap<java.lang.String, java.lang.Object> r10 = r0.properties
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r10.put(r8, r7)
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r0.properties
            int r10 = r0.greenMask
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r7.put(r9, r10)
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r0.properties
            int r10 = r0.blueMask
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r7.put(r6, r10)
            goto L_0x04e8
        L_0x04b4:
            r10 = 32
            if (r7 != r10) goto L_0x04e8
            r7 = 9
            r0.imageType = r7
            r7 = 16711680(0xff0000, float:2.3418052E-38)
            r0.redMask = r7
            r10 = 65280(0xff00, float:9.1477E-41)
            r0.greenMask = r10
            r10 = 255(0xff, float:3.57E-43)
            r0.blueMask = r10
            java.util.HashMap<java.lang.String, java.lang.Object> r10 = r0.properties
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r10.put(r8, r7)
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r0.properties
            int r10 = r0.greenMask
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r7.put(r9, r10)
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r0.properties
            int r10 = r0.blueMask
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r7.put(r6, r10)
        L_0x04e8:
            r10 = 52
            int r7 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r7 < 0) goto L_0x052a
            java.io.InputStream r7 = r0.inputStream
            long r10 = r0.readDWord(r7)
            int r7 = (int) r10
            r0.redMask = r7
            java.io.InputStream r7 = r0.inputStream
            long r10 = r0.readDWord(r7)
            int r7 = (int) r10
            r0.greenMask = r7
            java.io.InputStream r7 = r0.inputStream
            long r10 = r0.readDWord(r7)
            int r7 = (int) r10
            r0.blueMask = r7
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r0.properties
            int r10 = r0.redMask
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r7.put(r8, r10)
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r0.properties
            int r8 = r0.greenMask
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r7.put(r9, r8)
            java.util.HashMap<java.lang.String, java.lang.Object> r7 = r0.properties
            int r8 = r0.blueMask
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r7.put(r6, r8)
        L_0x052a:
            int r6 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r6 != 0) goto L_0x0540
            java.io.InputStream r6 = r0.inputStream
            long r6 = r0.readDWord(r6)
            int r7 = (int) r6
            r0.alphaMask = r7
            java.util.HashMap<java.lang.String, java.lang.Object> r6 = r0.properties
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6.put(r1, r7)
        L_0x0540:
            long r6 = r0.bitmapOffset
            r8 = 14
            long r8 = r6 - r8
            long r8 = r8 - r2
            r10 = 4
            long r8 = r8 / r10
            int r1 = (int) r8
            r8 = 4
            int r1 = r1 * 4
            int r9 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r9 != 0) goto L_0x057f
            int r1 = r0.imageType
            if (r1 == r8) goto L_0x0570
            r6 = 5
            if (r1 == r6) goto L_0x0567
            r6 = 6
            if (r1 == r6) goto L_0x055e
            r1 = 0
            goto L_0x057b
        L_0x055e:
            r6 = 0
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 != 0) goto L_0x0578
            r4 = 256(0x100, double:1.265E-321)
            goto L_0x0578
        L_0x0567:
            r6 = 0
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 != 0) goto L_0x0578
            r4 = 16
            goto L_0x0578
        L_0x0570:
            r6 = 0
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 != 0) goto L_0x0578
            r4 = 2
        L_0x0578:
            int r1 = (int) r4
            int r1 = r1 * 4
        L_0x057b:
            long r4 = (long) r1
            long r2 = r2 + r4
            r0.bitmapOffset = r2
        L_0x057f:
            r0.readPalette(r1)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.properties
            java.lang.String r2 = "BMP v. 3.x"
            r1.put(r15, r2)
        L_0x0589:
            int r1 = r0.height
            if (r1 <= 0) goto L_0x0592
            r2 = 1
            r0.isBottomUp = r2
            r3 = 0
            goto L_0x059c
        L_0x0592:
            r2 = 1
            r3 = 0
            r0.isBottomUp = r3
            int r1 = java.lang.Math.abs(r1)
            r0.height = r1
        L_0x059c:
            int r1 = r0.bitsPerPixel
            if (r1 == r2) goto L_0x05c3
            r2 = 4
            if (r1 == r2) goto L_0x05c3
            r2 = 8
            if (r1 != r2) goto L_0x05a8
            goto L_0x05c3
        L_0x05a8:
            r2 = 16
            if (r1 != r2) goto L_0x05b1
            r2 = 3
            r0.numBands = r2
            goto L_0x0622
        L_0x05b1:
            r2 = 3
            r3 = 32
            if (r1 != r3) goto L_0x05c0
            int r1 = r0.alphaMask
            if (r1 != 0) goto L_0x05bc
            r6 = 3
            goto L_0x05bd
        L_0x05bc:
            r6 = 4
        L_0x05bd:
            r0.numBands = r6
            goto L_0x0622
        L_0x05c0:
            r0.numBands = r2
            goto L_0x0622
        L_0x05c3:
            r1 = 1
            r0.numBands = r1
            int r2 = r0.imageType
            r4 = 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x05fa
            if (r2 == r1) goto L_0x05fa
            r1 = 2
            if (r2 != r1) goto L_0x05d2
            goto L_0x05fa
        L_0x05d2:
            byte[] r1 = r0.palette
            int r1 = r1.length
            r2 = 4
            int r1 = r1 / r2
            if (r1 <= r4) goto L_0x05da
            goto L_0x05db
        L_0x05da:
            r4 = r1
        L_0x05db:
            byte[] r1 = new byte[r4]
            byte[] r2 = new byte[r4]
            byte[] r5 = new byte[r4]
        L_0x05e1:
            if (r3 >= r4) goto L_0x0622
            int r6 = r3 * 4
            byte[] r7 = r0.palette
            byte r8 = r7[r6]
            r5[r3] = r8
            int r8 = r6 + 1
            byte r8 = r7[r8]
            r2[r3] = r8
            r8 = 2
            int r6 = r6 + r8
            byte r6 = r7[r6]
            r1[r3] = r6
            int r3 = r3 + 1
            goto L_0x05e1
        L_0x05fa:
            byte[] r1 = r0.palette
            int r1 = r1.length
            r2 = 3
            int r1 = r1 / r2
            if (r1 <= r4) goto L_0x0602
            goto L_0x0603
        L_0x0602:
            r4 = r1
        L_0x0603:
            byte[] r1 = new byte[r4]
            byte[] r2 = new byte[r4]
            byte[] r5 = new byte[r4]
        L_0x0609:
            if (r3 >= r4) goto L_0x0622
            int r6 = r3 * 3
            byte[] r7 = r0.palette
            byte r8 = r7[r6]
            r5[r3] = r8
            int r8 = r6 + 1
            byte r8 = r7[r8]
            r2[r3] = r8
            r8 = 2
            int r6 = r6 + r8
            byte r6 = r7[r6]
            r1[r3] = r6
            int r3 = r3 + 1
            goto L_0x0609
        L_0x0622:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.BmpImage.process(java.io.InputStream, boolean):void");
    }

    private byte[] getPalette(int i) {
        byte[] bArr = this.palette;
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[((bArr.length / i) * 3)];
        int length = bArr.length / i;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * i;
            int i4 = i2 * 3;
            byte[] bArr3 = this.palette;
            int i5 = i3 + 1;
            bArr2[i4 + 2] = bArr3[i3];
            bArr2[i4 + 1] = bArr3[i5];
            bArr2[i4] = bArr3[i5 + 1];
        }
        return bArr2;
    }

    private Image getImage() throws IOException, BadElementException {
        switch (this.imageType) {
            case 0:
                return read1Bit(3);
            case 1:
                return read4Bit(3);
            case 2:
                return read8Bit(3);
            case 3:
                byte[] bArr = new byte[(this.width * this.height * 3)];
                read24Bit(bArr);
                return new ImgRaw(this.width, this.height, 3, 8, bArr);
            case 4:
                return read1Bit(4);
            case 5:
                int i = (int) this.compression;
                if (i == 0) {
                    return read4Bit(4);
                }
                if (i == 2) {
                    return readRLE4();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 6:
                int i2 = (int) this.compression;
                if (i2 == 0) {
                    return read8Bit(4);
                }
                if (i2 == 1) {
                    return readRLE8();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 7:
                byte[] bArr2 = new byte[(this.width * this.height * 3)];
                read24Bit(bArr2);
                return new ImgRaw(this.width, this.height, 3, 8, bArr2);
            case 8:
                return read1632Bit(false);
            case 9:
                return read1632Bit(true);
            case 10:
                return read1Bit(4);
            case 11:
                int i3 = (int) this.compression;
                if (i3 == 0) {
                    return read4Bit(4);
                }
                if (i3 == 2) {
                    return readRLE4();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 12:
                int i4 = (int) this.compression;
                if (i4 == 0) {
                    return read8Bit(4);
                }
                if (i4 == 1) {
                    return readRLE8();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 13:
                return read1632Bit(false);
            case 14:
                byte[] bArr3 = new byte[(this.width * this.height * 3)];
                read24Bit(bArr3);
                return new ImgRaw(this.width, this.height, 3, 8, bArr3);
            case 15:
                return read1632Bit(true);
            default:
                return null;
        }
    }

    private Image indexedModel(byte[] bArr, int i, int i2) throws BadElementException {
        ImgRaw imgRaw = new ImgRaw(this.width, this.height, 1, i, bArr);
        PdfArray pdfArray = new PdfArray();
        pdfArray.add((PdfObject) PdfName.INDEXED);
        pdfArray.add((PdfObject) PdfName.DEVICERGB);
        byte[] palette2 = getPalette(i2);
        pdfArray.add((PdfObject) new PdfNumber((palette2.length / 3) - 1));
        pdfArray.add((PdfObject) new PdfString(palette2));
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.COLORSPACE, pdfArray);
        imgRaw.setAdditional(pdfDictionary);
        return imgRaw;
    }

    private void readPalette(int i) throws IOException {
        if (i != 0) {
            this.palette = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = this.inputStream.read(this.palette, i2, i - i2);
                if (read >= 0) {
                    i2 += read;
                } else {
                    throw new RuntimeException(MessageLocalization.getComposedMessage("incomplete.palette", new Object[0]));
                }
            }
            this.properties.put("palette", this.palette);
        }
    }

    private Image read1Bit(int i) throws IOException, BadElementException {
        int i2 = this.width;
        byte[] bArr = new byte[(((i2 + 7) / 8) * this.height)];
        double d = (double) i2;
        Double.isNaN(d);
        int ceil = (int) Math.ceil(d / 8.0d);
        int i3 = ceil % 4;
        int i4 = 0;
        int i5 = (i3 != 0 ? 4 - i3 : 0) + ceil;
        int i6 = this.height * i5;
        byte[] bArr2 = new byte[i6];
        int i7 = 0;
        while (i7 < i6) {
            i7 += this.inputStream.read(bArr2, i7, i6 - i7);
        }
        if (this.isBottomUp) {
            while (i4 < this.height) {
                int i8 = i4 + 1;
                System.arraycopy(bArr2, i6 - (i8 * i5), bArr, i4 * ceil, ceil);
                i4 = i8;
            }
        } else {
            while (i4 < this.height) {
                System.arraycopy(bArr2, i4 * i5, bArr, i4 * ceil, ceil);
                i4++;
            }
        }
        return indexedModel(bArr, 1, i);
    }

    private Image read4Bit(int i) throws IOException, BadElementException {
        int i2 = this.width;
        byte[] bArr = new byte[(((i2 + 1) / 2) * this.height)];
        double d = (double) i2;
        Double.isNaN(d);
        int ceil = (int) Math.ceil(d / 2.0d);
        int i3 = ceil % 4;
        int i4 = 0;
        int i5 = (i3 != 0 ? 4 - i3 : 0) + ceil;
        int i6 = this.height * i5;
        byte[] bArr2 = new byte[i6];
        int i7 = 0;
        while (i7 < i6) {
            i7 += this.inputStream.read(bArr2, i7, i6 - i7);
        }
        if (this.isBottomUp) {
            while (i4 < this.height) {
                int i8 = i4 + 1;
                System.arraycopy(bArr2, i6 - (i8 * i5), bArr, i4 * ceil, ceil);
                i4 = i8;
            }
        } else {
            while (i4 < this.height) {
                System.arraycopy(bArr2, i4 * i5, bArr, i4 * ceil, ceil);
                i4++;
            }
        }
        return indexedModel(bArr, 4, i);
    }

    private Image read8Bit(int i) throws IOException, BadElementException {
        int i2;
        int i3 = this.width;
        byte[] bArr = new byte[(this.height * i3)];
        int i4 = i3 * 8;
        int i5 = 0;
        if (i4 % 32 != 0) {
            double d = (double) ((((i4 / 32) + 1) * 32) - i4);
            Double.isNaN(d);
            i2 = (int) Math.ceil(d / 8.0d);
        } else {
            i2 = 0;
        }
        int i6 = (this.width + i2) * this.height;
        byte[] bArr2 = new byte[i6];
        int i7 = 0;
        while (i7 < i6) {
            i7 += this.inputStream.read(bArr2, i7, i6 - i7);
        }
        if (this.isBottomUp) {
            while (i5 < this.height) {
                int i8 = i5 + 1;
                int i9 = this.width;
                System.arraycopy(bArr2, i6 - ((i9 + i2) * i8), bArr, i5 * i9, i9);
                i5 = i8;
            }
        } else {
            while (i5 < this.height) {
                int i10 = this.width;
                System.arraycopy(bArr2, (i10 + i2) * i5, bArr, i5 * i10, i10);
                i5++;
            }
        }
        return indexedModel(bArr, 8, i);
    }

    private void read24Bit(byte[] bArr) {
        int i;
        int i2 = this.width * 24;
        if (i2 % 32 != 0) {
            double d = (double) ((((i2 / 32) + 1) * 32) - i2);
            Double.isNaN(d);
            i = (int) Math.ceil(d / 8.0d);
        } else {
            i = 0;
        }
        int i3 = (((this.width * 3) + 3) / 4) * 4 * this.height;
        byte[] bArr2 = new byte[i3];
        int i4 = 0;
        while (i4 < i3) {
            try {
                int read = this.inputStream.read(bArr2, i4, i3 - i4);
                if (read < 0) {
                    break;
                }
                i4 += read;
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
        if (this.isBottomUp) {
            int i5 = ((this.width * this.height) * 3) - 1;
            int i6 = -i;
            int i7 = 0;
            while (i7 < this.height) {
                i7++;
                int i8 = (i5 - ((this.width * i7) * 3)) + 1;
                i6 += i;
                for (int i9 = 0; i9 < this.width; i9++) {
                    int i10 = i6 + 1;
                    bArr[i8 + 2] = bArr2[i6];
                    int i11 = i10 + 1;
                    bArr[i8 + 1] = bArr2[i10];
                    i6 = i11 + 1;
                    bArr[i8] = bArr2[i11];
                    i8 += 3;
                }
            }
            return;
        }
        int i12 = -i;
        int i13 = 0;
        for (int i14 = 0; i14 < this.height; i14++) {
            i12 += i;
            for (int i15 = 0; i15 < this.width; i15++) {
                int i16 = i12 + 1;
                bArr[i13 + 2] = bArr2[i12];
                int i17 = i16 + 1;
                bArr[i13 + 1] = bArr2[i16];
                i12 = i17 + 1;
                bArr[i13] = bArr2[i17];
                i13 += 3;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.itextpdf.text.Image read1632Bit(boolean r21) throws java.io.IOException, com.itextpdf.text.BadElementException {
        /*
            r20 = this;
            r0 = r20
            int r1 = r0.redMask
            int r1 = r0.findMask(r1)
            int r2 = r0.redMask
            int r2 = r0.findShift(r2)
            int r3 = r1 + 1
            int r4 = r0.greenMask
            int r4 = r0.findMask(r4)
            int r5 = r0.greenMask
            int r5 = r0.findShift(r5)
            int r6 = r4 + 1
            int r7 = r0.blueMask
            int r7 = r0.findMask(r7)
            int r8 = r0.blueMask
            int r8 = r0.findShift(r8)
            int r9 = r7 + 1
            int r10 = r0.width
            int r11 = r0.height
            int r11 = r11 * r10
            int r11 = r11 * 3
            byte[] r11 = new byte[r11]
            if (r21 != 0) goto L_0x0052
            int r10 = r10 * 16
            int r13 = r10 % 32
            if (r13 == 0) goto L_0x0052
            int r13 = r10 / 32
            int r13 = r13 + 1
            int r13 = r13 * 32
            int r13 = r13 - r10
            double r13 = (double) r13
            r15 = 4620693217682128896(0x4020000000000000, double:8.0)
            java.lang.Double.isNaN(r13)
            double r13 = r13 / r15
            double r13 = java.lang.Math.ceil(r13)
            int r10 = (int) r13
            goto L_0x0053
        L_0x0052:
            r10 = 0
        L_0x0053:
            boolean r13 = r0.isBottomUp
            if (r13 == 0) goto L_0x00bb
            int r13 = r0.height
            int r13 = r13 + -1
        L_0x005b:
            if (r13 < 0) goto L_0x0111
            int r14 = r0.width
            int r14 = r14 * 3
            int r14 = r14 * r13
            r15 = 0
        L_0x0064:
            int r12 = r0.width
            if (r15 >= r12) goto L_0x00a7
            if (r21 == 0) goto L_0x0074
            java.io.InputStream r12 = r0.inputStream
            r17 = r13
            long r12 = r0.readDWord(r12)
            int r13 = (int) r12
            goto L_0x007c
        L_0x0074:
            r17 = r13
            java.io.InputStream r12 = r0.inputStream
            int r13 = r0.readWord(r12)
        L_0x007c:
            int r12 = r14 + 1
            int r18 = r13 >>> r2
            r19 = r2
            r2 = r18 & r1
            int r2 = r2 * 256
            int r2 = r2 / r3
            byte r2 = (byte) r2
            r11[r14] = r2
            int r2 = r12 + 1
            int r14 = r13 >>> r5
            r14 = r14 & r4
            int r14 = r14 * 256
            int r14 = r14 / r6
            byte r14 = (byte) r14
            r11[r12] = r14
            int r14 = r2 + 1
            int r12 = r13 >>> r8
            r12 = r12 & r7
            int r12 = r12 * 256
            int r12 = r12 / r9
            byte r12 = (byte) r12
            r11[r2] = r12
            int r15 = r15 + 1
            r13 = r17
            r2 = r19
            goto L_0x0064
        L_0x00a7:
            r19 = r2
            r17 = r13
            r2 = 0
        L_0x00ac:
            if (r2 >= r10) goto L_0x00b6
            java.io.InputStream r12 = r0.inputStream
            r12.read()
            int r2 = r2 + 1
            goto L_0x00ac
        L_0x00b6:
            int r13 = r17 + -1
            r2 = r19
            goto L_0x005b
        L_0x00bb:
            r19 = r2
            r2 = 0
            r12 = 0
        L_0x00bf:
            int r13 = r0.height
            if (r2 >= r13) goto L_0x0111
            r13 = 0
        L_0x00c4:
            int r14 = r0.width
            if (r13 >= r14) goto L_0x0101
            if (r21 == 0) goto L_0x00d2
            java.io.InputStream r14 = r0.inputStream
            long r14 = r0.readDWord(r14)
            int r15 = (int) r14
            goto L_0x00d8
        L_0x00d2:
            java.io.InputStream r14 = r0.inputStream
            int r15 = r0.readWord(r14)
        L_0x00d8:
            int r14 = r12 + 1
            int r17 = r15 >>> r19
            r18 = r2
            r2 = r17 & r1
            int r2 = r2 * 256
            int r2 = r2 / r3
            byte r2 = (byte) r2
            r11[r12] = r2
            int r2 = r14 + 1
            int r12 = r15 >>> r5
            r12 = r12 & r4
            int r12 = r12 * 256
            int r12 = r12 / r6
            byte r12 = (byte) r12
            r11[r14] = r12
            int r12 = r2 + 1
            int r14 = r15 >>> r8
            r14 = r14 & r7
            int r14 = r14 * 256
            int r14 = r14 / r9
            byte r14 = (byte) r14
            r11[r2] = r14
            int r13 = r13 + 1
            r2 = r18
            goto L_0x00c4
        L_0x0101:
            r18 = r2
            r2 = 0
        L_0x0104:
            if (r2 >= r10) goto L_0x010e
            java.io.InputStream r13 = r0.inputStream
            r13.read()
            int r2 = r2 + 1
            goto L_0x0104
        L_0x010e:
            int r2 = r18 + 1
            goto L_0x00bf
        L_0x0111:
            com.itextpdf.text.ImgRaw r1 = new com.itextpdf.text.ImgRaw
            int r13 = r0.width
            int r14 = r0.height
            r15 = 3
            r16 = 8
            r12 = r1
            r17 = r11
            r12.<init>(r13, r14, r15, r16, r17)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.BmpImage.read1632Bit(boolean):com.itextpdf.text.Image");
    }

    private Image readRLE8() throws IOException, BadElementException {
        int i = (int) this.imageSize;
        if (i == 0) {
            i = (int) (this.bitmapFileSize - this.bitmapOffset);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        int i3 = 0;
        while (i3 < i) {
            i3 += this.inputStream.read(bArr, i3, i - i3);
        }
        byte[] decodeRLE = decodeRLE(true, bArr);
        int i4 = this.width;
        int i5 = this.height * i4;
        if (this.isBottomUp) {
            byte[] bArr2 = new byte[decodeRLE.length];
            while (i2 < this.height) {
                int i6 = i2 + 1;
                System.arraycopy(decodeRLE, i5 - (i6 * i4), bArr2, i2 * i4, i4);
                i2 = i6;
            }
            decodeRLE = bArr2;
        }
        return indexedModel(decodeRLE, 8, 4);
    }

    private Image readRLE4() throws IOException, BadElementException {
        int i = (int) this.imageSize;
        if (i == 0) {
            i = (int) (this.bitmapFileSize - this.bitmapOffset);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            i2 += this.inputStream.read(bArr, i2, i - i2);
        }
        byte[] decodeRLE = decodeRLE(false, bArr);
        if (this.isBottomUp) {
            int i3 = this.width;
            int i4 = this.height;
            byte[] bArr2 = new byte[(i3 * i4)];
            int i5 = 0;
            for (int i6 = i4 - 1; i6 >= 0; i6--) {
                int i7 = this.width;
                int i8 = i6 * i7;
                int i9 = i7 + i5;
                while (i5 != i9) {
                    bArr2[i5] = decodeRLE[i8];
                    i5++;
                    i8++;
                }
            }
            decodeRLE = bArr2;
        }
        int i10 = (this.width + 1) / 2;
        byte[] bArr3 = new byte[(this.height * i10)];
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < this.height; i13++) {
            for (int i14 = 0; i14 < this.width; i14++) {
                if ((i14 & 1) == 0) {
                    bArr3[(i14 / 2) + i12] = (byte) (decodeRLE[i11] << 4);
                    i11++;
                } else {
                    int i15 = (i14 / 2) + i12;
                    bArr3[i15] = (byte) (((byte) (decodeRLE[i11] & BidiOrder.f1233B)) | bArr3[i15]);
                    i11++;
                }
            }
            i12 += i10;
        }
        return indexedModel(bArr3, 4, 4);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] decodeRLE(boolean r17, byte[] r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            int r2 = r0.width
            int r3 = r0.height
            int r2 = r2 * r3
            byte[] r2 = new byte[r2]
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x0011:
            int r8 = r0.height     // Catch:{ RuntimeException -> 0x00c7 }
            if (r4 >= r8) goto L_0x00c7
            int r8 = r1.length     // Catch:{ RuntimeException -> 0x00c7 }
            if (r5 >= r8) goto L_0x00c7
            int r8 = r5 + 1
            byte r5 = r1[r5]     // Catch:{ RuntimeException -> 0x00c7 }
            r5 = r5 & 255(0xff, float:3.57E-43)
            r9 = 1
            if (r5 == 0) goto L_0x004f
            int r10 = r8 + 1
            byte r8 = r1[r8]     // Catch:{ RuntimeException -> 0x00c7 }
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r17 == 0) goto L_0x0035
            r9 = r5
        L_0x002a:
            if (r9 == 0) goto L_0x004c
            int r11 = r7 + 1
            byte r12 = (byte) r8     // Catch:{ RuntimeException -> 0x00c7 }
            r2[r7] = r12     // Catch:{ RuntimeException -> 0x00c7 }
            int r9 = r9 + -1
            r7 = r11
            goto L_0x002a
        L_0x0035:
            r11 = 0
        L_0x0036:
            if (r11 >= r5) goto L_0x004c
            int r12 = r7 + 1
            r13 = r11 & 1
            if (r13 != r9) goto L_0x0041
            r13 = r8 & 15
            goto L_0x0045
        L_0x0041:
            int r13 = r8 >>> 4
            r13 = r13 & 15
        L_0x0045:
            byte r13 = (byte) r13     // Catch:{ RuntimeException -> 0x00c7 }
            r2[r7] = r13     // Catch:{ RuntimeException -> 0x00c7 }
            int r11 = r11 + 1
            r7 = r12
            goto L_0x0036
        L_0x004c:
            int r6 = r6 + r5
            r5 = r10
            goto L_0x0011
        L_0x004f:
            int r5 = r8 + 1
            byte r8 = r1[r8]     // Catch:{ RuntimeException -> 0x00c7 }
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r8 != r9) goto L_0x0059
            goto L_0x00c7
        L_0x0059:
            if (r8 == 0) goto L_0x00bd
            r10 = 2
            if (r8 == r10) goto L_0x00a8
            if (r17 == 0) goto L_0x0073
            r11 = r8
        L_0x0061:
            if (r11 == 0) goto L_0x0096
            int r12 = r7 + 1
            int r13 = r5 + 1
            byte r5 = r1[r5]     // Catch:{ RuntimeException -> 0x00c7 }
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = (byte) r5     // Catch:{ RuntimeException -> 0x00c7 }
            r2[r7] = r5     // Catch:{ RuntimeException -> 0x00c7 }
            int r11 = r11 + -1
            r7 = r12
            r5 = r13
            goto L_0x0061
        L_0x0073:
            r11 = 0
            r12 = 0
        L_0x0075:
            if (r11 >= r8) goto L_0x0096
            r13 = r11 & 1
            if (r13 != 0) goto L_0x0084
            int r12 = r5 + 1
            byte r5 = r1[r5]     // Catch:{ RuntimeException -> 0x00c7 }
            r5 = r5 & 255(0xff, float:3.57E-43)
            r15 = r12
            r12 = r5
            r5 = r15
        L_0x0084:
            int r14 = r7 + 1
            if (r13 != r9) goto L_0x008b
            r13 = r12 & 15
            goto L_0x008f
        L_0x008b:
            int r13 = r12 >>> 4
            r13 = r13 & 15
        L_0x008f:
            byte r13 = (byte) r13     // Catch:{ RuntimeException -> 0x00c7 }
            r2[r7] = r13     // Catch:{ RuntimeException -> 0x00c7 }
            int r11 = r11 + 1
            r7 = r14
            goto L_0x0075
        L_0x0096:
            int r6 = r6 + r8
            if (r17 == 0) goto L_0x009e
            r8 = r8 & 1
            if (r8 != r9) goto L_0x0011
            goto L_0x00a4
        L_0x009e:
            r8 = r8 & 3
            if (r8 == r9) goto L_0x00a4
            if (r8 != r10) goto L_0x0011
        L_0x00a4:
            int r5 = r5 + 1
            goto L_0x0011
        L_0x00a8:
            int r7 = r5 + 1
            byte r5 = r1[r5]     // Catch:{ RuntimeException -> 0x00c7 }
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r6 = r6 + r5
            int r5 = r7 + 1
            byte r7 = r1[r7]     // Catch:{ RuntimeException -> 0x00c7 }
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r4 = r4 + r7
            int r7 = r0.width     // Catch:{ RuntimeException -> 0x00c7 }
            int r7 = r7 * r4
            int r7 = r7 + r6
            goto L_0x0011
        L_0x00bd:
            int r4 = r4 + 1
            int r6 = r0.width     // Catch:{ RuntimeException -> 0x00c7 }
            int r6 = r6 * r4
            r7 = r6
            r6 = 0
            goto L_0x0011
        L_0x00c7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.BmpImage.decodeRLE(boolean, byte[]):byte[]");
    }

    private int readUnsignedByte(InputStream inputStream2) throws IOException {
        return inputStream2.read() & 255;
    }

    private int readUnsignedShort(InputStream inputStream2) throws IOException {
        return ((readUnsignedByte(inputStream2) << 8) | readUnsignedByte(inputStream2)) & 65535;
    }

    private int readShort(InputStream inputStream2) throws IOException {
        return (readUnsignedByte(inputStream2) << 8) | readUnsignedByte(inputStream2);
    }

    private int readWord(InputStream inputStream2) throws IOException {
        return readUnsignedShort(inputStream2);
    }

    private long readUnsignedInt(InputStream inputStream2) throws IOException {
        int readUnsignedByte = readUnsignedByte(inputStream2);
        int readUnsignedByte2 = readUnsignedByte(inputStream2);
        return ((long) ((readUnsignedByte(inputStream2) << 24) | (readUnsignedByte(inputStream2) << 16) | (readUnsignedByte2 << 8) | readUnsignedByte)) & -1;
    }

    private int readInt(InputStream inputStream2) throws IOException {
        int readUnsignedByte = readUnsignedByte(inputStream2);
        int readUnsignedByte2 = readUnsignedByte(inputStream2);
        return (readUnsignedByte(inputStream2) << 24) | (readUnsignedByte(inputStream2) << 16) | (readUnsignedByte2 << 8) | readUnsignedByte;
    }

    private long readDWord(InputStream inputStream2) throws IOException {
        return readUnsignedInt(inputStream2);
    }

    private int readLong(InputStream inputStream2) throws IOException {
        return readInt(inputStream2);
    }
}
