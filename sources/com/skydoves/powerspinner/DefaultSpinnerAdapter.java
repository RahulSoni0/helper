package com.skydoves.powerspinner;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.skydoves.powerspinner.databinding.ItemDefaultPowerSpinnerLibraryBinding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001&B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0019\u001a\u00020\tH\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\tH\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\tH\u0016J\u0016\u0010#\u001a\u00020\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040%H\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, mo18301d2 = {"Lcom/skydoves/powerspinner/DefaultSpinnerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/skydoves/powerspinner/DefaultSpinnerAdapter$DefaultSpinnerViewHolder;", "Lcom/skydoves/powerspinner/PowerSpinnerInterface;", "", "powerSpinnerView", "Lcom/skydoves/powerspinner/PowerSpinnerView;", "(Lcom/skydoves/powerspinner/PowerSpinnerView;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "onSpinnerItemSelectedListener", "Lcom/skydoves/powerspinner/OnSpinnerItemSelectedListener;", "getOnSpinnerItemSelectedListener", "()Lcom/skydoves/powerspinner/OnSpinnerItemSelectedListener;", "setOnSpinnerItemSelectedListener", "(Lcom/skydoves/powerspinner/OnSpinnerItemSelectedListener;)V", "spinnerItems", "", "spinnerView", "getSpinnerView", "()Lcom/skydoves/powerspinner/PowerSpinnerView;", "getItemCount", "notifyItemSelected", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItems", "itemList", "", "DefaultSpinnerViewHolder", "powerspinner_release"}, mo18302k = 1, mo18303mv = {1, 4, 1})
/* compiled from: DefaultSpinnerAdapter.kt */
public final class DefaultSpinnerAdapter extends RecyclerView.Adapter<DefaultSpinnerViewHolder> implements PowerSpinnerInterface<CharSequence> {
    private int index;
    private OnSpinnerItemSelectedListener<CharSequence> onSpinnerItemSelectedListener;
    private final List<CharSequence> spinnerItems = new ArrayList();
    private final PowerSpinnerView spinnerView;

    public DefaultSpinnerAdapter(PowerSpinnerView powerSpinnerView) {
        Intrinsics.checkNotNullParameter(powerSpinnerView, "powerSpinnerView");
        this.index = powerSpinnerView.getSelectedIndex();
        this.spinnerView = powerSpinnerView;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public PowerSpinnerView getSpinnerView() {
        return this.spinnerView;
    }

    public OnSpinnerItemSelectedListener<CharSequence> getOnSpinnerItemSelectedListener() {
        return this.onSpinnerItemSelectedListener;
    }

    public void setOnSpinnerItemSelectedListener(OnSpinnerItemSelectedListener<CharSequence> onSpinnerItemSelectedListener2) {
        this.onSpinnerItemSelectedListener = onSpinnerItemSelectedListener2;
    }

    public DefaultSpinnerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemDefaultPowerSpinnerLibraryBinding inflate = ItemDefaultPowerSpinnerLibraryBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "ItemDefaultPowerSpinnerL…nt,\n        false\n      )");
        DefaultSpinnerViewHolder defaultSpinnerViewHolder = new DefaultSpinnerViewHolder(inflate);
        inflate.getRoot().setOnClickListener(new DefaultSpinnerAdapter$onCreateViewHolder$$inlined$apply$lambda$1(defaultSpinnerViewHolder, this, inflate));
        return defaultSpinnerViewHolder;
    }

    public void onBindViewHolder(DefaultSpinnerViewHolder defaultSpinnerViewHolder, int i) {
        Intrinsics.checkNotNullParameter(defaultSpinnerViewHolder, "holder");
        defaultSpinnerViewHolder.bind(this.spinnerItems.get(i), getSpinnerView());
    }

    public void setItems(List<? extends CharSequence> list) {
        Intrinsics.checkNotNullParameter(list, "itemList");
        this.spinnerItems.clear();
        this.spinnerItems.addAll(list);
        notifyDataSetChanged();
    }

    public void notifyItemSelected(int i) {
        if (i != -1) {
            int index2 = getIndex();
            setIndex(i);
            getSpinnerView().notifyItemSelected(i, this.spinnerItems.get(i));
            OnSpinnerItemSelectedListener<CharSequence> onSpinnerItemSelectedListener2 = getOnSpinnerItemSelectedListener();
            if (onSpinnerItemSelectedListener2 != null) {
                Integer valueOf = Integer.valueOf(index2);
                CharSequence charSequence = null;
                if (!(valueOf.intValue() != -1)) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    valueOf.intValue();
                    charSequence = this.spinnerItems.get(index2);
                }
                onSpinnerItemSelectedListener2.onItemSelected(index2, charSequence, i, this.spinnerItems.get(i));
            }
        }
    }

    public int getItemCount() {
        return this.spinnerItems.size();
    }

    @Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo18301d2 = {"Lcom/skydoves/powerspinner/DefaultSpinnerAdapter$DefaultSpinnerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/skydoves/powerspinner/databinding/ItemDefaultPowerSpinnerLibraryBinding;", "(Lcom/skydoves/powerspinner/databinding/ItemDefaultPowerSpinnerLibraryBinding;)V", "bind", "", "item", "", "spinnerView", "Lcom/skydoves/powerspinner/PowerSpinnerView;", "powerspinner_release"}, mo18302k = 1, mo18303mv = {1, 4, 1})
    /* compiled from: DefaultSpinnerAdapter.kt */
    public static final class DefaultSpinnerViewHolder extends RecyclerView.ViewHolder {
        private final ItemDefaultPowerSpinnerLibraryBinding binding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DefaultSpinnerViewHolder(ItemDefaultPowerSpinnerLibraryBinding itemDefaultPowerSpinnerLibraryBinding) {
            super(itemDefaultPowerSpinnerLibraryBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemDefaultPowerSpinnerLibraryBinding, "binding");
            this.binding = itemDefaultPowerSpinnerLibraryBinding;
        }

        public final void bind(CharSequence charSequence, PowerSpinnerView powerSpinnerView) {
            Intrinsics.checkNotNullParameter(charSequence, "item");
            Intrinsics.checkNotNullParameter(powerSpinnerView, "spinnerView");
            AppCompatTextView appCompatTextView = this.binding.itemDefaultText;
            appCompatTextView.setText(charSequence);
            appCompatTextView.setTypeface(powerSpinnerView.getTypeface());
            appCompatTextView.setGravity(powerSpinnerView.getGravity());
            appCompatTextView.setTextSize(0, powerSpinnerView.getTextSize());
            appCompatTextView.setTextColor(powerSpinnerView.getCurrentTextColor());
            this.binding.getRoot().setPadding(powerSpinnerView.getPaddingLeft(), powerSpinnerView.getPaddingTop(), powerSpinnerView.getPaddingRight(), powerSpinnerView.getPaddingBottom());
        }
    }
}
