package com.google.android.play.core.internal;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.h */
class C1701h extends X509Certificate {

    /* renamed from: a */
    private final X509Certificate f881a;

    public C1701h(X509Certificate x509Certificate) {
        this.f881a = x509Certificate;
    }

    public final void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        this.f881a.checkValidity();
    }

    public final void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        this.f881a.checkValidity(date);
    }

    public final int getBasicConstraints() {
        return this.f881a.getBasicConstraints();
    }

    public final Set<String> getCriticalExtensionOIDs() {
        return this.f881a.getCriticalExtensionOIDs();
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        return this.f881a.getEncoded();
    }

    public final byte[] getExtensionValue(String str) {
        return this.f881a.getExtensionValue(str);
    }

    public final Principal getIssuerDN() {
        return this.f881a.getIssuerDN();
    }

    public final boolean[] getIssuerUniqueID() {
        return this.f881a.getIssuerUniqueID();
    }

    public final boolean[] getKeyUsage() {
        return this.f881a.getKeyUsage();
    }

    public final Set<String> getNonCriticalExtensionOIDs() {
        return this.f881a.getNonCriticalExtensionOIDs();
    }

    public final Date getNotAfter() {
        return this.f881a.getNotAfter();
    }

    public final Date getNotBefore() {
        return this.f881a.getNotBefore();
    }

    public final PublicKey getPublicKey() {
        return this.f881a.getPublicKey();
    }

    public final BigInteger getSerialNumber() {
        return this.f881a.getSerialNumber();
    }

    public final String getSigAlgName() {
        return this.f881a.getSigAlgName();
    }

    public final String getSigAlgOID() {
        return this.f881a.getSigAlgOID();
    }

    public final byte[] getSigAlgParams() {
        return this.f881a.getSigAlgParams();
    }

    public final byte[] getSignature() {
        return this.f881a.getSignature();
    }

    public final Principal getSubjectDN() {
        return this.f881a.getSubjectDN();
    }

    public final boolean[] getSubjectUniqueID() {
        return this.f881a.getSubjectUniqueID();
    }

    public final byte[] getTBSCertificate() throws CertificateEncodingException {
        return this.f881a.getTBSCertificate();
    }

    public final int getVersion() {
        return this.f881a.getVersion();
    }

    public final boolean hasUnsupportedCriticalExtension() {
        return this.f881a.hasUnsupportedCriticalExtension();
    }

    public final String toString() {
        return this.f881a.toString();
    }

    public final void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        this.f881a.verify(publicKey);
    }

    public final void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        this.f881a.verify(publicKey, str);
    }
}
