package com.skydoves.powerspinner;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo18301d2 = {"outRangeColor", "", "contextDrawable", "Landroid/graphics/drawable/Drawable;", "Landroid/content/Context;", "resource", "dp2Px", "dp", "", "Landroid/view/View;", "powerspinner_release"}, mo18302k = 2, mo18303mv = {1, 4, 1})
/* compiled from: ContextExtension.kt */
public final class ContextExtensionKt {
    public static final int outRangeColor = 65555;

    public static final int dp2Px(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "$this$dp2Px");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return (int) (((float) i) * resources.getDisplayMetrics().density);
    }

    public static final int dp2Px(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "$this$dp2Px");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return dp2Px(context, i);
    }

    public static final int dp2Px(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "$this$dp2Px");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        return (int) (f * resources.getDisplayMetrics().density);
    }

    public static final int dp2Px(View view, float f) {
        Intrinsics.checkNotNullParameter(view, "$this$dp2Px");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return dp2Px(context, f);
    }

    public static final Drawable contextDrawable(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "$this$contextDrawable");
        return ContextCompat.getDrawable(context, i);
    }
}
