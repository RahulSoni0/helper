package com.google.android.gms.internal.ads;

import com.itextpdf.text.DocWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
abstract class zzepz implements zzequ {
    private static final int[] zzb = zzi(new byte[]{101, 120, 112, 97, 110, 100, DocWriter.SPACE, 51, 50, 45, 98, 121, 116, 101, DocWriter.SPACE, 107});
    int[] zza;
    private final int zzc;

    zzepz(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length == 32) {
            this.zza = zzi(bArr);
            this.zzc = i;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    static void zzf(int[] iArr, int[] iArr2) {
        int[] iArr3 = zzb;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    static void zzg(int[] iArr) {
        int[] iArr2 = iArr;
        for (int i = 0; i < 10; i++) {
            zzh(iArr2, 0, 4, 8, 12);
            zzh(iArr2, 1, 5, 9, 13);
            zzh(iArr2, 2, 6, 10, 14);
            zzh(iArr2, 3, 7, 11, 15);
            zzh(iArr2, 0, 5, 10, 15);
            zzh(iArr2, 1, 6, 11, 12);
            zzh(iArr2, 2, 7, 8, 13);
            zzh(iArr2, 3, 4, 9, 14);
        }
    }

    static void zzh(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = iArr[i] + iArr[i2];
        iArr[i] = i5;
        int i6 = i5 ^ iArr[i4];
        int i7 = (i6 >>> -16) | (i6 << 16);
        iArr[i4] = i7;
        int i8 = iArr[i3] + i7;
        iArr[i3] = i8;
        int i9 = iArr[i2] ^ i8;
        int i10 = (i9 >>> -12) | (i9 << 12);
        iArr[i2] = i10;
        int i11 = iArr[i] + i10;
        iArr[i] = i11;
        int i12 = iArr[i4] ^ i11;
        int i13 = (i12 >>> -8) | (i12 << 8);
        iArr[i4] = i13;
        int i14 = iArr[i3] + i13;
        iArr[i3] = i14;
        int i15 = iArr[i2] ^ i14;
        iArr[i2] = (i15 >>> -7) | (i15 << 7);
    }

    static int[] zzi(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        if (length <= Integer.MAX_VALUE - zzc()) {
            ByteBuffer allocate = ByteBuffer.allocate(zzc() + length);
            zzd(allocate, bArr);
            return allocate.array();
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    /* access modifiers changed from: package-private */
    public abstract int[] zzb(int[] iArr, int i);

    /* access modifiers changed from: package-private */
    public abstract int zzc();

    /* access modifiers changed from: package-private */
    public final void zzd(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (byteBuffer.remaining() - zzc() >= bArr.length) {
            byte[] zza2 = zzerb.zza(zzc());
            byteBuffer.put(zza2);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int remaining = wrap.remaining();
            int i = (remaining / 64) + 1;
            for (int i2 = 0; i2 < i; i2++) {
                ByteBuffer zze = zze(zza2, this.zzc + i2);
                if (i2 == i - 1) {
                    zzepx.zzc(byteBuffer, wrap, zze, remaining % 64);
                } else {
                    zzepx.zzc(byteBuffer, wrap, zze, 64);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }

    /* access modifiers changed from: package-private */
    public final ByteBuffer zze(byte[] bArr, int i) {
        int[] zzb2 = zzb(zzi(bArr), i);
        int[] iArr = (int[]) zzb2.clone();
        zzg(iArr);
        for (int i2 = 0; i2 < 16; i2++) {
            zzb2[i2] = zzb2[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(zzb2, 0, 16);
        return order;
    }
}
