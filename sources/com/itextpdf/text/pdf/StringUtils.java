package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;

public class StringUtils {

    /* renamed from: b */
    private static final byte[] f1408b = DocWriter.getISOBytes("\\b");

    /* renamed from: f */
    private static final byte[] f1409f = DocWriter.getISOBytes("\\f");

    /* renamed from: n */
    private static final byte[] f1410n = DocWriter.getISOBytes("\\n");

    /* renamed from: r */
    private static final byte[] f1411r = DocWriter.getISOBytes("\\r");

    /* renamed from: t */
    private static final byte[] f1412t = DocWriter.getISOBytes("\\t");

    private StringUtils() {
    }

    public static byte[] escapeString(byte[] bArr) {
        ByteBuffer byteBuffer = new ByteBuffer();
        escapeString(bArr, byteBuffer);
        return byteBuffer.toByteArray();
    }

    public static void escapeString(byte[] bArr, ByteBuffer byteBuffer) {
        byteBuffer.append_i(40);
        for (byte b : bArr) {
            if (b == 12) {
                byteBuffer.append(f1409f);
            } else if (b != 13) {
                if (b != 40 && b != 41 && b != 92) {
                    switch (b) {
                        case 8:
                            byteBuffer.append(f1408b);
                            break;
                        case 9:
                            byteBuffer.append(f1412t);
                            break;
                        case 10:
                            byteBuffer.append(f1410n);
                            break;
                        default:
                            byteBuffer.append_i(b);
                            break;
                    }
                } else {
                    byteBuffer.append_i(92).append_i(b);
                }
            } else {
                byteBuffer.append(f1411r);
            }
        }
        byteBuffer.append_i(41);
    }

    public static byte[] convertCharsToBytes(char[] cArr) {
        byte[] bArr = new byte[(cArr.length * 2)];
        for (int i = 0; i < cArr.length; i++) {
            int i2 = i * 2;
            bArr[i2] = (byte) (cArr[i] / 256);
            bArr[i2 + 1] = (byte) (cArr[i] % 256);
        }
        return bArr;
    }
}
