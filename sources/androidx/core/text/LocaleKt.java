package androidx.core.text;

import android.text.TextUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, mo18301d2 = {"layoutDirection", "", "Ljava/util/Locale;", "getLayoutDirection", "(Ljava/util/Locale;)I", "core-ktx_release"}, mo18302k = 2, mo18303mv = {1, 1, 15})
/* compiled from: Locale.kt */
public final class LocaleKt {
    public static final int getLayoutDirection(Locale locale) {
        Intrinsics.checkParameterIsNotNull(locale, "$this$layoutDirection");
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
