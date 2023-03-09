package com.skydoves.powerspinner;

import android.content.Context;
import com.skydoves.powerspinner.PowerSpinnerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\t"}, mo18301d2 = {"createPowerSpinnerView", "Lcom/skydoves/powerspinner/PowerSpinnerView;", "context", "Landroid/content/Context;", "builder", "Lkotlin/Function1;", "Lcom/skydoves/powerspinner/PowerSpinnerView$Builder;", "", "Lkotlin/ExtensionFunctionType;", "powerspinner_release"}, mo18302k = 2, mo18303mv = {1, 4, 1})
/* compiled from: PowerSpinnerExtension.kt */
public final class PowerSpinnerExtensionKt {
    @PowerSpinnerDsl
    public static final /* synthetic */ PowerSpinnerView createPowerSpinnerView(Context context, Function1<? super PowerSpinnerView.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "builder");
        PowerSpinnerView.Builder builder = new PowerSpinnerView.Builder(context);
        function1.invoke(builder);
        return builder.build();
    }
}
