package com.itextpdf.text.pdf.crypto;

import org.spongycastle.crypto.engines.AESFastEngine;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class AESCipher {

    /* renamed from: bp */
    private PaddedBufferedBlockCipher f1445bp = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESFastEngine()));

    public AESCipher(boolean z, byte[] bArr, byte[] bArr2) {
        this.f1445bp.init(z, new ParametersWithIV(new KeyParameter(bArr), bArr2));
    }

    public byte[] update(byte[] bArr, int i, int i2) {
        int updateOutputSize = this.f1445bp.getUpdateOutputSize(i2);
        byte[] bArr2 = updateOutputSize > 0 ? new byte[updateOutputSize] : null;
        this.f1445bp.processBytes(bArr, i, i2, bArr2, 0);
        return bArr2;
    }

    public byte[] doFinal() {
        int outputSize = this.f1445bp.getOutputSize(0);
        byte[] bArr = new byte[outputSize];
        try {
            int doFinal = this.f1445bp.doFinal(bArr, 0);
            if (doFinal != outputSize) {
                byte[] bArr2 = new byte[doFinal];
                System.arraycopy(bArr, 0, bArr2, 0, doFinal);
                return bArr2;
            }
        } catch (Exception unused) {
        }
        return bArr;
    }
}
