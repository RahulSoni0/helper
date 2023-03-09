package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class PdfLiteral extends PdfObject {
    private long position;

    public PdfLiteral(String str) {
        super(0, str);
    }

    public PdfLiteral(byte[] bArr) {
        super(0, bArr);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PdfLiteral(int i) {
        super(0, (byte[]) null);
        byte[] bArr = null;
        this.bytes = new byte[i];
        Arrays.fill(this.bytes, DocWriter.SPACE);
    }

    public PdfLiteral(int i, String str) {
        super(i, str);
    }

    public PdfLiteral(int i, byte[] bArr) {
        super(i, bArr);
    }

    public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        if (outputStream instanceof OutputStreamCounter) {
            this.position = ((OutputStreamCounter) outputStream).getCounter();
        }
        super.toPdf(pdfWriter, outputStream);
    }

    public long getPosition() {
        return this.position;
    }

    public int getPosLength() {
        if (this.bytes != null) {
            return this.bytes.length;
        }
        return 0;
    }
}
