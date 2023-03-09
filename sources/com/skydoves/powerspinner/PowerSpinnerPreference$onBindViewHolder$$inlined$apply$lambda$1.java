package com.skydoves.powerspinner;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\n¢\u0006\u0002\b\b¨\u0006\t"}, mo18301d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "newIndex", "<anonymous parameter 3>", "invoke", "com/skydoves/powerspinner/PowerSpinnerPreference$onBindViewHolder$1$1"}, mo18302k = 3, mo18303mv = {1, 4, 1})
/* compiled from: PowerSpinnerPreference.kt */
final class PowerSpinnerPreference$onBindViewHolder$$inlined$apply$lambda$1 extends Lambda implements Function4<Integer, Object, Integer, Object, Unit> {
    final /* synthetic */ PowerSpinnerPreference this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PowerSpinnerPreference$onBindViewHolder$$inlined$apply$lambda$1(PowerSpinnerPreference powerSpinnerPreference) {
        super(4);
        this.this$0 = powerSpinnerPreference;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke(((Number) obj).intValue(), obj2, ((Number) obj3).intValue(), obj4);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, Object obj, int i2, Object obj2) {
        Intrinsics.checkNotNullParameter(obj2, "<anonymous parameter 3>");
        boolean unused = this.this$0.persistInt(i2);
    }
}
