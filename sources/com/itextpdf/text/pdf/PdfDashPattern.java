package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.OutputStream;

public class PdfDashPattern extends PdfArray {
    private float dash;
    private float gap;
    private float phase;

    public PdfDashPattern() {
        this.dash = -1.0f;
        this.gap = -1.0f;
        this.phase = -1.0f;
    }

    public PdfDashPattern(float f) {
        super((PdfObject) new PdfNumber(f));
        this.gap = -1.0f;
        this.phase = -1.0f;
        this.dash = f;
    }

    public PdfDashPattern(float f, float f2) {
        super((PdfObject) new PdfNumber(f));
        this.dash = -1.0f;
        this.gap = -1.0f;
        this.phase = -1.0f;
        add((PdfObject) new PdfNumber(f2));
        this.dash = f;
        this.gap = f2;
    }

    public PdfDashPattern(float f, float f2, float f3) {
        super((PdfObject) new PdfNumber(f));
        this.dash = -1.0f;
        this.gap = -1.0f;
        this.phase = -1.0f;
        add((PdfObject) new PdfNumber(f2));
        this.dash = f;
        this.gap = f2;
        this.phase = f3;
    }

    public void add(float f) {
        add((PdfObject) new PdfNumber(f));
    }

    public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        outputStream.write(91);
        float f = this.dash;
        if (f >= 0.0f) {
            new PdfNumber(f).toPdf(pdfWriter, outputStream);
            if (this.gap >= 0.0f) {
                outputStream.write(32);
                new PdfNumber(this.gap).toPdf(pdfWriter, outputStream);
            }
        }
        outputStream.write(93);
        if (this.phase >= 0.0f) {
            outputStream.write(32);
            new PdfNumber(this.phase).toPdf(pdfWriter, outputStream);
        }
    }
}
