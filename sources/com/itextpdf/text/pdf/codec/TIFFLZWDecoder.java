package com.itextpdf.text.pdf.codec;

import androidx.core.app.FrameMetricsAggregator;
import com.itextpdf.text.error_messages.MessageLocalization;
import kotlin.UByte;

public class TIFFLZWDecoder {
    int[] andTable = {FrameMetricsAggregator.EVERY_DURATION, 1023, 2047, 4095};
    int bitPointer;
    int bitsToGet = 9;
    int bytePointer;
    byte[] data = null;
    int dstIndex;

    /* renamed from: h */
    int f1438h;
    int nextBits = 0;
    int nextData = 0;
    int predictor;
    int samplesPerPixel;
    byte[][] stringTable;
    int tableIndex;
    byte[] uncompData;

    /* renamed from: w */
    int f1439w;

    public TIFFLZWDecoder(int i, int i2, int i3) {
        this.f1439w = i;
        this.predictor = i2;
        this.samplesPerPixel = i3;
    }

    public byte[] decode(byte[] bArr, byte[] bArr2, int i) {
        if (bArr[0] == 0 && bArr[1] == 1) {
            throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("tiff.5.0.style.lzw.codes.are.not.supported", new Object[0]));
        }
        initializeStringTable();
        this.data = bArr;
        this.f1438h = i;
        this.uncompData = bArr2;
        this.bytePointer = 0;
        this.bitPointer = 0;
        this.dstIndex = 0;
        this.nextData = 0;
        this.nextBits = 0;
        int i2 = 0;
        while (true) {
            int nextCode = getNextCode();
            if (nextCode == 257 || this.dstIndex >= bArr2.length) {
                break;
            } else if (nextCode == 256) {
                initializeStringTable();
                i2 = getNextCode();
                if (i2 == 257) {
                    break;
                }
                writeString(this.stringTable[i2]);
            } else {
                if (nextCode < this.tableIndex) {
                    byte[] bArr3 = this.stringTable[nextCode];
                    writeString(bArr3);
                    addStringToTable(this.stringTable[i2], bArr3[0]);
                } else {
                    byte[] bArr4 = this.stringTable[i2];
                    byte[] composeString = composeString(bArr4, bArr4[0]);
                    writeString(composeString);
                    addStringToTable(composeString);
                }
                i2 = nextCode;
            }
        }
        if (this.predictor == 2) {
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = this.samplesPerPixel;
                int i5 = ((this.f1439w * i3) + 1) * i4;
                while (true) {
                    int i6 = this.f1439w;
                    int i7 = this.samplesPerPixel;
                    if (i4 >= i6 * i7) {
                        break;
                    }
                    bArr2[i5] = (byte) (bArr2[i5] + bArr2[i5 - i7]);
                    i5++;
                    i4++;
                }
            }
        }
        return bArr2;
    }

    public void initializeStringTable() {
        this.stringTable = new byte[4096][];
        for (int i = 0; i < 256; i++) {
            byte[][] bArr = this.stringTable;
            bArr[i] = new byte[1];
            bArr[i][0] = (byte) i;
        }
        this.tableIndex = 258;
        this.bitsToGet = 9;
    }

    public void writeString(byte[] bArr) {
        byte[] bArr2 = this.uncompData;
        int length = bArr2.length;
        int i = this.dstIndex;
        int i2 = length - i;
        if (bArr.length < i2) {
            i2 = bArr.length;
        }
        System.arraycopy(bArr, 0, bArr2, i, i2);
        this.dstIndex += i2;
    }

    public void addStringToTable(byte[] bArr, byte b) {
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 1)];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        bArr2[length] = b;
        byte[][] bArr3 = this.stringTable;
        int i = this.tableIndex;
        int i2 = i + 1;
        this.tableIndex = i2;
        bArr3[i] = bArr2;
        if (i2 == 511) {
            this.bitsToGet = 10;
        } else if (i2 == 1023) {
            this.bitsToGet = 11;
        } else if (i2 == 2047) {
            this.bitsToGet = 12;
        }
    }

    public void addStringToTable(byte[] bArr) {
        byte[][] bArr2 = this.stringTable;
        int i = this.tableIndex;
        int i2 = i + 1;
        this.tableIndex = i2;
        bArr2[i] = bArr;
        if (i2 == 511) {
            this.bitsToGet = 10;
        } else if (i2 == 1023) {
            this.bitsToGet = 11;
        } else if (i2 == 2047) {
            this.bitsToGet = 12;
        }
    }

    public byte[] composeString(byte[] bArr, byte b) {
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 1)];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        bArr2[length] = b;
        return bArr2;
    }

    public int getNextCode() {
        try {
            byte[] bArr = this.data;
            int i = this.bytePointer;
            int i2 = i + 1;
            this.bytePointer = i2;
            byte b = (this.nextData << 8) | (bArr[i] & UByte.MAX_VALUE);
            this.nextData = b;
            int i3 = this.nextBits + 8;
            this.nextBits = i3;
            int i4 = this.bitsToGet;
            if (i3 < i4) {
                this.bytePointer = i2 + 1;
                this.nextData = (b << 8) | (bArr[i2] & UByte.MAX_VALUE);
                this.nextBits = i3 + 8;
            }
            int i5 = this.nextData;
            int i6 = this.nextBits;
            int i7 = (i5 >> (i6 - i4)) & this.andTable[i4 - 9];
            this.nextBits = i6 - i4;
            return i7;
        } catch (ArrayIndexOutOfBoundsException unused) {
            return 257;
        }
    }
}
