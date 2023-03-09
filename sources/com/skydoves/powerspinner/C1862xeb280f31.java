package com.skydoves.powerspinner;

import kotlin.Metadata;
import kotlin.jvm.functions.Function4;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u0001H\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u0002H\u0002H\n¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, mo18301d2 = {"<anonymous>", "", "T", "oldIndex", "", "oldItem", "newIndex", "newItem", "onItemSelected", "(ILjava/lang/Object;ILjava/lang/Object;)V", "com/skydoves/powerspinner/PowerSpinnerView$Builder$setOnSpinnerItemSelectedListener$2$1"}, mo18302k = 3, mo18303mv = {1, 4, 1})
/* renamed from: com.skydoves.powerspinner.PowerSpinnerView$Builder$setOnSpinnerItemSelectedListener$$inlined$apply$lambda$1 */
/* compiled from: PowerSpinnerView.kt */
final class C1862xeb280f31<T> implements OnSpinnerItemSelectedListener<T> {
    final /* synthetic */ Function4 $block$inlined;

    C1862xeb280f31(Function4 function4) {
        this.$block$inlined = function4;
    }

    public final void onItemSelected(int i, T t, int i2, T t2) {
        this.$block$inlined.invoke(Integer.valueOf(i), t, Integer.valueOf(i2), t2);
    }
}
