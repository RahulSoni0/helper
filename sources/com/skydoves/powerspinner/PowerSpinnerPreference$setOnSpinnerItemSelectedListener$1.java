package com.skydoves.powerspinner;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u0001H\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u0002H\u0002H\n¢\u0006\u0004\b\b\u0010\t"}, mo18301d2 = {"<anonymous>", "", "T", "oldIndex", "", "oldItem", "newIndex", "newItem", "invoke", "(ILjava/lang/Object;ILjava/lang/Object;)V"}, mo18302k = 3, mo18303mv = {1, 4, 1})
/* compiled from: PowerSpinnerPreference.kt */
final class PowerSpinnerPreference$setOnSpinnerItemSelectedListener$1 extends Lambda implements Function4<Integer, T, Integer, T, Unit> {
    final /* synthetic */ OnSpinnerItemSelectedListener $onSpinnerItemSelectedListener;
    final /* synthetic */ PowerSpinnerPreference this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PowerSpinnerPreference$setOnSpinnerItemSelectedListener$1(PowerSpinnerPreference powerSpinnerPreference, OnSpinnerItemSelectedListener onSpinnerItemSelectedListener) {
        super(4);
        this.this$0 = powerSpinnerPreference;
        this.$onSpinnerItemSelectedListener = onSpinnerItemSelectedListener;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke(((Number) obj).intValue(), obj2, ((Number) obj3).intValue(), obj4);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, T t, int i2, T t2) {
        this.$onSpinnerItemSelectedListener.onItemSelected(i, t, i2, t2);
        boolean unused = this.this$0.persistInt(i2);
    }
}
