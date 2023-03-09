package com.google.android.play.core.internal;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

/* renamed from: com.google.android.play.core.internal.g */
final class C1700g extends C1701h {

    /* renamed from: a */
    private final byte[] f880a;

    public C1700g(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.f880a = bArr;
    }

    public final byte[] getEncoded() throws CertificateEncodingException {
        return this.f880a;
    }
}
