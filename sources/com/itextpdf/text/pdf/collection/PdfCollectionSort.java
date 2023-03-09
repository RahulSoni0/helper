package com.itextpdf.text.pdf.collection;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfBoolean;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;

public class PdfCollectionSort extends PdfDictionary {
    public PdfCollectionSort(String str) {
        super(PdfName.COLLECTIONSORT);
        put(PdfName.f1357S, new PdfName(str));
    }

    public PdfCollectionSort(String[] strArr) {
        super(PdfName.COLLECTIONSORT);
        PdfArray pdfArray = new PdfArray();
        for (String pdfName : strArr) {
            pdfArray.add((PdfObject) new PdfName(pdfName));
        }
        put(PdfName.f1357S, pdfArray);
    }

    public void setSortOrder(boolean z) {
        if (get(PdfName.f1357S) instanceof PdfName) {
            put(PdfName.f1260A, new PdfBoolean(z));
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("you.have.to.define.a.boolean.array.for.this.collection.sort.dictionary", new Object[0]));
    }

    public void setSortOrder(boolean[] zArr) {
        PdfObject pdfObject = get(PdfName.f1357S);
        if (!(pdfObject instanceof PdfArray)) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("you.need.a.single.boolean.for.this.collection.sort.dictionary", new Object[0]));
        } else if (((PdfArray) pdfObject).size() == zArr.length) {
            PdfArray pdfArray = new PdfArray();
            for (boolean pdfBoolean : zArr) {
                pdfArray.add((PdfObject) new PdfBoolean(pdfBoolean));
            }
            put(PdfName.f1260A, pdfArray);
        } else {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.number.of.booleans.in.this.array.doesn.t.correspond.with.the.number.of.fields", new Object[0]));
        }
    }
}
