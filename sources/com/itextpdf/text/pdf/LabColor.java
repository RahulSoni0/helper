package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;

public class LabColor extends ExtendedColor {

    /* renamed from: a */
    private float f1246a;

    /* renamed from: b */
    private float f1247b;

    /* renamed from: l */
    private float f1248l;
    PdfLabColor labColorSpace;

    public LabColor(PdfLabColor pdfLabColor, float f, float f2, float f3) {
        super(7);
        this.labColorSpace = pdfLabColor;
        this.f1248l = f;
        this.f1246a = f2;
        this.f1247b = f3;
        BaseColor lab2Rgb = pdfLabColor.lab2Rgb(f, f2, f3);
        setValue(lab2Rgb.getRed(), lab2Rgb.getGreen(), lab2Rgb.getBlue(), 255);
    }

    public PdfLabColor getLabColorSpace() {
        return this.labColorSpace;
    }

    public float getL() {
        return this.f1248l;
    }

    public float getA() {
        return this.f1246a;
    }

    public float getB() {
        return this.f1247b;
    }

    public BaseColor toRgb() {
        return this.labColorSpace.lab2Rgb(this.f1248l, this.f1246a, this.f1247b);
    }

    /* access modifiers changed from: package-private */
    public CMYKColor toCmyk() {
        return this.labColorSpace.lab2Cmyk(this.f1248l, this.f1246a, this.f1247b);
    }
}
