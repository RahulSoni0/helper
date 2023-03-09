package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import com.itextpdf.text.html.HtmlTags;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a%\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\n\u001a\u001d\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\n\u001a\r\u0010\u000b\u001a\u00020\u0002*\u00020\fH\b¨\u0006\r"}, mo18301d2 = {"clearSpans", "", "Landroid/text/Spannable;", "set", "start", "", "end", "span", "", "range", "Lkotlin/ranges/IntRange;", "toSpannable", "", "core-ktx_release"}, mo18302k = 2, mo18303mv = {1, 1, 15})
/* compiled from: SpannableString.kt */
public final class SpannableStringKt {
    public static final Spannable toSpannable(CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "$this$toSpannable");
        SpannableString valueOf = SpannableString.valueOf(charSequence);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "SpannableString.valueOf(this)");
        return valueOf;
    }

    public static final void clearSpans(Spannable spannable) {
        Intrinsics.checkParameterIsNotNull(spannable, "$this$clearSpans");
        Spanned spanned = spannable;
        Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
        Intrinsics.checkExpressionValueIsNotNull(spans, "getSpans(start, end, T::class.java)");
        for (Object removeSpan : spans) {
            spannable.removeSpan(removeSpan);
        }
    }

    public static final void set(Spannable spannable, int i, int i2, Object obj) {
        Intrinsics.checkParameterIsNotNull(spannable, "$this$set");
        Intrinsics.checkParameterIsNotNull(obj, HtmlTags.SPAN);
        spannable.setSpan(obj, i, i2, 17);
    }

    public static final void set(Spannable spannable, IntRange intRange, Object obj) {
        Intrinsics.checkParameterIsNotNull(spannable, "$this$set");
        Intrinsics.checkParameterIsNotNull(intRange, "range");
        Intrinsics.checkParameterIsNotNull(obj, HtmlTags.SPAN);
        spannable.setSpan(obj, intRange.getStart().intValue(), intRange.getEndInclusive().intValue(), 17);
    }
}
