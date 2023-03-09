package com.itextpdf.text.pdf.qrcode;

public final class ErrorCorrectionLevel {
    private static final ErrorCorrectionLevel[] FOR_BITS;

    /* renamed from: H */
    public static final ErrorCorrectionLevel f1477H;

    /* renamed from: L */
    public static final ErrorCorrectionLevel f1478L;

    /* renamed from: M */
    public static final ErrorCorrectionLevel f1479M;

    /* renamed from: Q */
    public static final ErrorCorrectionLevel f1480Q;
    private final int bits;
    private final String name;
    private final int ordinal;

    static {
        ErrorCorrectionLevel errorCorrectionLevel = new ErrorCorrectionLevel(0, 1, "L");
        f1478L = errorCorrectionLevel;
        ErrorCorrectionLevel errorCorrectionLevel2 = new ErrorCorrectionLevel(1, 0, "M");
        f1479M = errorCorrectionLevel2;
        ErrorCorrectionLevel errorCorrectionLevel3 = new ErrorCorrectionLevel(2, 3, "Q");
        f1480Q = errorCorrectionLevel3;
        ErrorCorrectionLevel errorCorrectionLevel4 = new ErrorCorrectionLevel(3, 2, "H");
        f1477H = errorCorrectionLevel4;
        FOR_BITS = new ErrorCorrectionLevel[]{errorCorrectionLevel2, errorCorrectionLevel, errorCorrectionLevel4, errorCorrectionLevel3};
    }

    private ErrorCorrectionLevel(int i, int i2, String str) {
        this.ordinal = i;
        this.bits = i2;
        this.name = str;
    }

    public int ordinal() {
        return this.ordinal;
    }

    public int getBits() {
        return this.bits;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }

    public static ErrorCorrectionLevel forBits(int i) {
        if (i >= 0) {
            ErrorCorrectionLevel[] errorCorrectionLevelArr = FOR_BITS;
            if (i < errorCorrectionLevelArr.length) {
                return errorCorrectionLevelArr[i];
            }
        }
        throw new IllegalArgumentException();
    }
}
