package com.skydoves.powerspinner;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004H\bø\u0001\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0007"}, mo18301d2 = {"whatIfNotNullOrEmpty", "", "", "whatIf", "Lkotlin/Function1;", "whatIfNot", "Lkotlin/Function0;", "powerspinner_release"}, mo18302k = 2, mo18303mv = {1, 4, 1})
/* compiled from: WhatIfExtension.kt */
public final class WhatIfExtensionKt {
    public static final void whatIfNotNullOrEmpty(String str, Function1<? super String, Unit> function1, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function1, "whatIf");
        Intrinsics.checkNotNullParameter(function0, "whatIfNot");
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            function1.invoke(str);
        } else {
            function0.invoke();
        }
    }

    public static final void whatIfNotNullOrEmpty(String str, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "whatIf");
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            function1.invoke(str);
        }
    }
}
