package com.itextpdf.text.pdf.collection;

import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;

public class PdfTargetDictionary extends PdfDictionary {
    public PdfTargetDictionary(PdfTargetDictionary pdfTargetDictionary) {
        put(PdfName.f1347R, PdfName.f1338P);
        if (pdfTargetDictionary != null) {
            setAdditionalPath(pdfTargetDictionary);
        }
    }

    public PdfTargetDictionary(boolean z) {
        if (z) {
            put(PdfName.f1347R, PdfName.f1272C);
        } else {
            put(PdfName.f1347R, PdfName.f1338P);
        }
    }

    public void setEmbeddedFileName(String str) {
        put(PdfName.f1325N, new PdfString(str, (String) null));
    }

    public void setFileAttachmentPagename(String str) {
        put(PdfName.f1338P, new PdfString(str, (String) null));
    }

    public void setFileAttachmentPage(int i) {
        put(PdfName.f1338P, new PdfNumber(i));
    }

    public void setFileAttachmentName(String str) {
        put(PdfName.f1260A, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public void setFileAttachmentIndex(int i) {
        put(PdfName.f1260A, new PdfNumber(i));
    }

    public void setAdditionalPath(PdfTargetDictionary pdfTargetDictionary) {
        put(PdfName.f1362T, pdfTargetDictionary);
    }
}
