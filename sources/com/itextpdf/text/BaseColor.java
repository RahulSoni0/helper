package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;

public class BaseColor {
    public static final BaseColor BLACK = new BaseColor(0, 0, 0);
    public static final BaseColor BLUE = new BaseColor(0, 0, 255);
    public static final BaseColor CYAN = new BaseColor(0, 255, 255);
    public static final BaseColor DARK_GRAY = new BaseColor(64, 64, 64);
    private static final double FACTOR = 0.7d;
    public static final BaseColor GRAY = new BaseColor(128, 128, 128);
    public static final BaseColor GREEN = new BaseColor(0, 255, 0);
    public static final BaseColor LIGHT_GRAY = new BaseColor(192, 192, 192);
    public static final BaseColor MAGENTA = new BaseColor(255, 0, 255);
    public static final BaseColor ORANGE = new BaseColor(255, 200, 0);
    public static final BaseColor PINK = new BaseColor(255, 175, 175);
    public static final BaseColor RED = new BaseColor(255, 0, 0);
    public static final BaseColor WHITE = new BaseColor(255, 255, 255);
    public static final BaseColor YELLOW = new BaseColor(255, 255, 0);
    private int value;

    public BaseColor(int i, int i2, int i3, int i4) {
        setValue(i, i2, i3, i4);
    }

    public BaseColor(int i, int i2, int i3) {
        this(i, i2, i3, 255);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BaseColor(float r6, float r7, float r8, float r9) {
        /*
            r5 = this;
            r0 = 1132396544(0x437f0000, float:255.0)
            float r6 = r6 * r0
            double r1 = (double) r6
            r3 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            java.lang.Double.isNaN(r1)
            double r1 = r1 + r3
            int r6 = (int) r1
            float r7 = r7 * r0
            double r1 = (double) r7
            java.lang.Double.isNaN(r1)
            double r1 = r1 + r3
            int r7 = (int) r1
            float r8 = r8 * r0
            double r1 = (double) r8
            java.lang.Double.isNaN(r1)
            double r1 = r1 + r3
            int r8 = (int) r1
            float r9 = r9 * r0
            double r0 = (double) r9
            java.lang.Double.isNaN(r0)
            double r0 = r0 + r3
            int r9 = (int) r0
            r5.<init>((int) r6, (int) r7, (int) r8, (int) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.BaseColor.<init>(float, float, float, float):void");
    }

    public BaseColor(float f, float f2, float f3) {
        this(f, f2, f3, 1.0f);
    }

    public BaseColor(int i) {
        this.value = i;
    }

    public int getRGB() {
        return this.value;
    }

    public int getRed() {
        return (getRGB() >> 16) & 255;
    }

    public int getGreen() {
        return (getRGB() >> 8) & 255;
    }

    public int getBlue() {
        return (getRGB() >> 0) & 255;
    }

    public int getAlpha() {
        return (getRGB() >> 24) & 255;
    }

    public BaseColor brighter() {
        int red = getRed();
        int green = getGreen();
        int blue = getBlue();
        if (red == 0 && green == 0 && blue == 0) {
            return new BaseColor(3, 3, 3);
        }
        if (red > 0 && red < 3) {
            red = 3;
        }
        if (green > 0 && green < 3) {
            green = 3;
        }
        if (blue > 0 && blue < 3) {
            blue = 3;
        }
        double d = (double) red;
        Double.isNaN(d);
        int min = Math.min((int) (d / FACTOR), 255);
        double d2 = (double) green;
        Double.isNaN(d2);
        int min2 = Math.min((int) (d2 / FACTOR), 255);
        double d3 = (double) blue;
        Double.isNaN(d3);
        return new BaseColor(min, min2, Math.min((int) (d3 / FACTOR), 255));
    }

    public BaseColor darker() {
        double red = (double) getRed();
        Double.isNaN(red);
        int max = Math.max((int) (red * FACTOR), 0);
        double green = (double) getGreen();
        Double.isNaN(green);
        int max2 = Math.max((int) (green * FACTOR), 0);
        double blue = (double) getBlue();
        Double.isNaN(blue);
        return new BaseColor(max, max2, Math.max((int) (blue * FACTOR), 0));
    }

    public boolean equals(Object obj) {
        return (obj instanceof BaseColor) && ((BaseColor) obj).value == this.value;
    }

    public int hashCode() {
        return this.value;
    }

    /* access modifiers changed from: protected */
    public void setValue(int i, int i2, int i3, int i4) {
        validate(i);
        validate(i2);
        validate(i3);
        validate(i4);
        this.value = ((i & 255) << 16) | ((i4 & 255) << 24) | ((i2 & 255) << 8) | ((i3 & 255) << 0);
    }

    private static void validate(int i) {
        if (i < 0 || i > 255) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("color.value.outside.range.0.255", new Object[0]));
        }
    }

    public String toString() {
        return "Color value[" + Integer.toString(this.value, 16) + "]";
    }
}
