package com.itextpdf.text.pdf;

import com.itextpdf.text.pdf.PdfStamperImp;

public class StampContent extends PdfContentByte {
    PageResources pageResources;

    /* renamed from: ps */
    PdfStamperImp.PageStamp f1406ps;

    StampContent(PdfStamperImp pdfStamperImp, PdfStamperImp.PageStamp pageStamp) {
        super(pdfStamperImp);
        this.f1406ps = pageStamp;
        this.pageResources = pageStamp.pageResources;
    }

    public void setAction(PdfAction pdfAction, float f, float f2, float f3, float f4) {
        ((PdfStamperImp) this.writer).addAnnotation(this.writer.createAnnotation(f, f2, f3, f4, pdfAction, (PdfName) null), this.f1406ps.pageN);
    }

    public PdfContentByte getDuplicate() {
        return new StampContent((PdfStamperImp) this.writer, this.f1406ps);
    }

    /* access modifiers changed from: package-private */
    public PageResources getPageResources() {
        return this.pageResources;
    }

    /* access modifiers changed from: package-private */
    public void addAnnotation(PdfAnnotation pdfAnnotation) {
        ((PdfStamperImp) this.writer).addAnnotation(pdfAnnotation, this.f1406ps.pageN);
    }
}
