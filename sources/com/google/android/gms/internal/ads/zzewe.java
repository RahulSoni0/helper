package com.google.android.gms.internal.ads;

import com.itextpdf.text.pdf.BidiOrder;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzewe {
    static /* synthetic */ boolean zza(byte b) {
        return b >= 0;
    }

    static /* synthetic */ void zzc(byte b, byte b2, byte b3, char[] cArr, int i) throws zzett {
        if (!zze(b2)) {
            if (b == -32) {
                if (b2 >= -96) {
                    b = -32;
                }
            }
            if (b == -19) {
                if (b2 < -96) {
                    b = -19;
                }
            }
            if (!zze(b3)) {
                cArr[i] = (char) (((b & BidiOrder.f1233B) << BidiOrder.f1235CS) | ((b2 & 63) << 6) | (b3 & 63));
                return;
            }
        }
        throw zzett.zzj();
    }

    private static boolean zze(byte b) {
        return b > -65;
    }

    static /* synthetic */ void zzb(byte b, byte b2, char[] cArr, int i) throws zzett {
        if (b < -62 || zze(b2)) {
            throw zzett.zzj();
        }
        cArr[i] = (char) (((b & 31) << 6) | (b2 & 63));
    }

    static /* synthetic */ void zzd(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws zzett {
        if (zze(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || zze(b3) || zze(b4)) {
            throw zzett.zzj();
        }
        byte b5 = ((b & 7) << 18) | ((b2 & 63) << BidiOrder.f1235CS) | ((b3 & 63) << 6) | (b4 & 63);
        cArr[i] = (char) ((b5 >>> 10) + 55232);
        cArr[i + 1] = (char) ((b5 & UByte.MAX_VALUE) + 56320);
    }
}
