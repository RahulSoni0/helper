package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;

class PdfColor extends PdfArray {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    PdfColor(int r6, int r7, int r8) {
        /*
            r5 = this;
            com.itextpdf.text.pdf.PdfNumber r0 = new com.itextpdf.text.pdf.PdfNumber
            r6 = r6 & 255(0xff, float:3.57E-43)
            double r1 = (double) r6
            r3 = 4643176031446892544(0x406fe00000000000, double:255.0)
            java.lang.Double.isNaN(r1)
            double r1 = r1 / r3
            r0.<init>((double) r1)
            r5.<init>((com.itextpdf.text.pdf.PdfObject) r0)
            com.itextpdf.text.pdf.PdfNumber r6 = new com.itextpdf.text.pdf.PdfNumber
            r7 = r7 & 255(0xff, float:3.57E-43)
            double r0 = (double) r7
            java.lang.Double.isNaN(r0)
            double r0 = r0 / r3
            r6.<init>((double) r0)
            r5.add((com.itextpdf.text.pdf.PdfObject) r6)
            com.itextpdf.text.pdf.PdfNumber r6 = new com.itextpdf.text.pdf.PdfNumber
            r7 = r8 & 255(0xff, float:3.57E-43)
            double r7 = (double) r7
            java.lang.Double.isNaN(r7)
            double r7 = r7 / r3
            r6.<init>((double) r7)
            r5.add((com.itextpdf.text.pdf.PdfObject) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfColor.<init>(int, int, int):void");
    }

    PdfColor(BaseColor baseColor) {
        this(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue());
    }
}
