package com.itextpdf.text.pdf;

public class PdfTransparencyGroup extends PdfDictionary {
    public PdfTransparencyGroup() {
        put(PdfName.f1357S, PdfName.TRANSPARENCY);
    }

    public void setIsolated(boolean z) {
        if (z) {
            put(PdfName.f1313I, PdfBoolean.PDFTRUE);
        } else {
            remove(PdfName.f1313I);
        }
    }

    public void setKnockout(boolean z) {
        if (z) {
            put(PdfName.f1320K, PdfBoolean.PDFTRUE);
        } else {
            remove(PdfName.f1320K);
        }
    }
}
