package com.itextpdf.text.pdf;

import java.io.IOException;

public class PdfMediaClipData extends PdfDictionary {
    PdfMediaClipData(String str, PdfFileSpecification pdfFileSpecification, String str2) throws IOException {
        put(PdfName.TYPE, new PdfName("MediaClip"));
        put(PdfName.f1357S, new PdfName("MCD"));
        PdfName pdfName = PdfName.f1325N;
        put(pdfName, new PdfString("Media clip for " + str));
        put(new PdfName("CT"), new PdfString(str2));
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(new PdfName("TF"), new PdfString("TEMPACCESS"));
        put(new PdfName("P"), pdfDictionary);
        put(PdfName.f1282D, pdfFileSpecification.getReference());
    }
}
