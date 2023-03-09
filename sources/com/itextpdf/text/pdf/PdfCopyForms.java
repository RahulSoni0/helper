package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings;
import com.itextpdf.text.pdf.interfaces.PdfViewerPreferences;
import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.util.HashMap;
import java.util.List;

public class PdfCopyForms implements PdfViewerPreferences, PdfEncryptionSettings {

    /* renamed from: fc */
    private PdfCopyFormsImp f1255fc;

    public PdfCopyForms(OutputStream outputStream) throws DocumentException {
        this.f1255fc = new PdfCopyFormsImp(outputStream);
    }

    public void addDocument(PdfReader pdfReader) throws DocumentException, IOException {
        this.f1255fc.addDocument(pdfReader);
    }

    public void addDocument(PdfReader pdfReader, List<Integer> list) throws DocumentException, IOException {
        this.f1255fc.addDocument(pdfReader, list);
    }

    public void addDocument(PdfReader pdfReader, String str) throws DocumentException, IOException {
        this.f1255fc.addDocument(pdfReader, SequenceList.expand(str, pdfReader.getNumberOfPages()));
    }

    public void copyDocumentFields(PdfReader pdfReader) throws DocumentException {
        this.f1255fc.copyDocumentFields(pdfReader);
    }

    public void setEncryption(byte[] bArr, byte[] bArr2, int i, boolean z) throws DocumentException {
        this.f1255fc.setEncryption(bArr, bArr2, i, z ? 1 : 0);
    }

    public void setEncryption(boolean z, String str, String str2, int i) throws DocumentException {
        setEncryption(DocWriter.getISOBytes(str), DocWriter.getISOBytes(str2), i, z);
    }

    public void close() {
        this.f1255fc.close();
    }

    public void open() {
        this.f1255fc.openDoc();
    }

    public void addJavaScript(String str) {
        this.f1255fc.addJavaScript(str, !PdfEncodings.isPdfDocEncoding(str));
    }

    public void setOutlines(List<HashMap<String, Object>> list) {
        this.f1255fc.setOutlines(list);
    }

    public PdfWriter getWriter() {
        return this.f1255fc;
    }

    public boolean isFullCompression() {
        return this.f1255fc.isFullCompression();
    }

    public void setFullCompression() throws DocumentException {
        this.f1255fc.setFullCompression();
    }

    public void setEncryption(byte[] bArr, byte[] bArr2, int i, int i2) throws DocumentException {
        this.f1255fc.setEncryption(bArr, bArr2, i, i2);
    }

    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        this.f1255fc.addViewerPreference(pdfName, pdfObject);
    }

    public void setViewerPreferences(int i) {
        this.f1255fc.setViewerPreferences(i);
    }

    public void setEncryption(Certificate[] certificateArr, int[] iArr, int i) throws DocumentException {
        this.f1255fc.setEncryption(certificateArr, iArr, i);
    }
}
