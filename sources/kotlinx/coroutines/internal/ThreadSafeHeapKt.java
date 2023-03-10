package kotlinx.coroutines.internal;

import com.itextpdf.text.html.HtmlTags;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004H\b¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo18301d2 = {"clear", "", "T", "a", "", "([Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, mo18302k = 2, mo18303mv = {1, 1, 15})
/* compiled from: ThreadSafeHeap.kt */
public final class ThreadSafeHeapKt {
    public static final <T> void clear(T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, HtmlTags.f1190A);
        ArraysKt.fill$default((Object[]) tArr, (Object) null, 0, 0, 6, (Object) null);
    }
}
