package com.skydoves.powerspinner;

import android.view.View;
import com.skydoves.powerspinner.DefaultSpinnerAdapter;
import com.skydoves.powerspinner.databinding.ItemDefaultPowerSpinnerLibraryBinding;
import kotlin.Metadata;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo18301d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/skydoves/powerspinner/DefaultSpinnerAdapter$onCreateViewHolder$1$1"}, mo18302k = 3, mo18303mv = {1, 4, 1})
/* compiled from: DefaultSpinnerAdapter.kt */
final class DefaultSpinnerAdapter$onCreateViewHolder$$inlined$apply$lambda$1 implements View.OnClickListener {
    final /* synthetic */ ItemDefaultPowerSpinnerLibraryBinding $binding$inlined;
    final /* synthetic */ DefaultSpinnerAdapter.DefaultSpinnerViewHolder $this_apply;
    final /* synthetic */ DefaultSpinnerAdapter this$0;

    DefaultSpinnerAdapter$onCreateViewHolder$$inlined$apply$lambda$1(DefaultSpinnerAdapter.DefaultSpinnerViewHolder defaultSpinnerViewHolder, DefaultSpinnerAdapter defaultSpinnerAdapter, ItemDefaultPowerSpinnerLibraryBinding itemDefaultPowerSpinnerLibraryBinding) {
        this.$this_apply = defaultSpinnerViewHolder;
        this.this$0 = defaultSpinnerAdapter;
        this.$binding$inlined = itemDefaultPowerSpinnerLibraryBinding;
    }

    public final void onClick(View view) {
        Integer valueOf = Integer.valueOf(this.$this_apply.getAdapterPosition());
        if (!(valueOf.intValue() != -1)) {
            valueOf = null;
        }
        if (valueOf != null) {
            this.this$0.notifyItemSelected(valueOf.intValue());
        }
    }
}
