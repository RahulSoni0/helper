package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, mo18301d2 = {"<anonymous>", "", "R", "it", "", "invoke"}, mo18302k = 3, mo18303mv = {1, 4, 0})
/* compiled from: _Sequences.kt */
public final class SequencesKt___SequencesKt$filterIsInstance$1 extends Lambda implements Function1<Object, Boolean> {
    public static final SequencesKt___SequencesKt$filterIsInstance$1 INSTANCE = new SequencesKt___SequencesKt$filterIsInstance$1();

    public SequencesKt___SequencesKt$filterIsInstance$1() {
        super(1);
    }

    public final boolean invoke(Object obj) {
        Intrinsics.reifiedOperationMarker(3, "R");
        return obj instanceof Object;
    }
}
