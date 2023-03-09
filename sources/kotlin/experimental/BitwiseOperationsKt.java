package kotlin.experimental;

import kotlin.Metadata;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\u0015\u0010\u0000\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\f\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0004\u001a\u00020\u0003*\u00020\u0003H\b\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\u0015\u0010\u0005\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\f\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\u0015\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\f¨\u0006\u0007"}, mo18301d2 = {"and", "", "other", "", "inv", "or", "xor", "kotlin-stdlib"}, mo18302k = 2, mo18303mv = {1, 4, 0})
/* compiled from: bitwiseOperations.kt */
public final class BitwiseOperationsKt {
    private static final byte and(byte b, byte b2) {
        return (byte) (b & b2);
    }

    private static final short and(short s, short s2) {
        return (short) (s & s2);
    }

    private static final byte inv(byte b) {
        return (byte) (b ^ -1);
    }

    private static final short inv(short s) {
        return (short) (s ^ -1);
    }

    /* renamed from: or */
    private static final byte m988or(byte b, byte b2) {
        return (byte) (b | b2);
    }

    /* renamed from: or */
    private static final short m989or(short s, short s2) {
        return (short) (s | s2);
    }

    private static final byte xor(byte b, byte b2) {
        return (byte) (b ^ b2);
    }

    private static final short xor(short s, short s2) {
        return (short) (s ^ s2);
    }
}
