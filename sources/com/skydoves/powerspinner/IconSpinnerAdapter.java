package com.skydoves.powerspinner;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.skydoves.powerspinner.databinding.ItemDefaultPowerSpinnerLibraryBinding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001'B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\tH\u0016J\u0016\u0010$\u001a\u00020\u001c2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0016R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, mo18301d2 = {"Lcom/skydoves/powerspinner/IconSpinnerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/skydoves/powerspinner/IconSpinnerAdapter$IconSpinnerViewHolder;", "Lcom/skydoves/powerspinner/PowerSpinnerInterface;", "Lcom/skydoves/powerspinner/IconSpinnerItem;", "powerSpinnerView", "Lcom/skydoves/powerspinner/PowerSpinnerView;", "(Lcom/skydoves/powerspinner/PowerSpinnerView;)V", "compoundPadding", "", "index", "getIndex", "()I", "setIndex", "(I)V", "onSpinnerItemSelectedListener", "Lcom/skydoves/powerspinner/OnSpinnerItemSelectedListener;", "getOnSpinnerItemSelectedListener", "()Lcom/skydoves/powerspinner/OnSpinnerItemSelectedListener;", "setOnSpinnerItemSelectedListener", "(Lcom/skydoves/powerspinner/OnSpinnerItemSelectedListener;)V", "spinnerItems", "", "spinnerView", "getSpinnerView", "()Lcom/skydoves/powerspinner/PowerSpinnerView;", "getItemCount", "notifyItemSelected", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItems", "itemList", "", "IconSpinnerViewHolder", "powerspinner_release"}, mo18302k = 1, mo18303mv = {1, 4, 1})
/* compiled from: IconSpinnerAdapter.kt */
public final class IconSpinnerAdapter extends RecyclerView.Adapter<IconSpinnerViewHolder> implements PowerSpinnerInterface<IconSpinnerItem> {
    private final int compoundPadding = 12;
    private int index;
    private OnSpinnerItemSelectedListener<IconSpinnerItem> onSpinnerItemSelectedListener;
    private final List<IconSpinnerItem> spinnerItems = new ArrayList();
    private final PowerSpinnerView spinnerView;

    public IconSpinnerAdapter(PowerSpinnerView powerSpinnerView) {
        Intrinsics.checkNotNullParameter(powerSpinnerView, "powerSpinnerView");
        this.index = powerSpinnerView.getSelectedIndex();
        this.spinnerView = powerSpinnerView;
        getSpinnerView().setCompoundDrawablePadding(12);
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

    public OnSpinnerItemSelectedListener<IconSpinnerItem> getOnSpinnerItemSelectedListener() {
        return this.onSpinnerItemSelectedListener;
    }

    public void setOnSpinnerItemSelectedListener(OnSpinnerItemSelectedListener<IconSpinnerItem> onSpinnerItemSelectedListener2) {
        this.onSpinnerItemSelectedListener = onSpinnerItemSelectedListener2;
    }

    public IconSpinnerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemDefaultPowerSpinnerLibraryBinding inflate = ItemDefaultPowerSpinnerLibraryBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "ItemDefaultPowerSpinnerL…nt,\n        false\n      )");
        IconSpinnerViewHolder iconSpinnerViewHolder = new IconSpinnerViewHolder(inflate);
        inflate.getRoot().setOnClickListener(new IconSpinnerAdapter$onCreateViewHolder$$inlined$apply$lambda$1(iconSpinnerViewHolder, this, inflate));
        return iconSpinnerViewHolder;
    }

    public void onBindViewHolder(IconSpinnerViewHolder iconSpinnerViewHolder, int i) {
        Intrinsics.checkNotNullParameter(iconSpinnerViewHolder, "holder");
        iconSpinnerViewHolder.bind(this.spinnerItems.get(i), getSpinnerView());
    }

    public void setItems(List<IconSpinnerItem> list) {
        Intrinsics.checkNotNullParameter(list, "itemList");
        this.spinnerItems.clear();
        this.spinnerItems.addAll(list);
        notifyDataSetChanged();
    }

    public void notifyItemSelected(int i) {
        Drawable drawable;
        if (i != -1) {
            IconSpinnerItem iconSpinnerItem = this.spinnerItems.get(i);
            PowerSpinnerView spinnerView2 = getSpinnerView();
            Integer iconPadding = iconSpinnerItem.getIconPadding();
            spinnerView2.setCompoundDrawablePadding(iconPadding != null ? iconPadding.intValue() : getSpinnerView().getCompoundDrawablePadding());
            Integer iconRes = iconSpinnerItem.getIconRes();
            IconSpinnerItem iconSpinnerItem2 = null;
            if (iconRes == null || (drawable = ResourcesCompat.getDrawable(getSpinnerView().getResources(), iconRes.intValue(), (Resources.Theme) null)) == null) {
                drawable = iconSpinnerItem.getIcon();
            }
            int iconGravity = iconSpinnerItem.getIconGravity();
            if (iconGravity == 48) {
                getSpinnerView().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
            } else if (iconGravity == 80) {
                getSpinnerView().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, drawable);
            } else if (iconGravity == 8388611) {
                getSpinnerView().setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (iconGravity == 8388613) {
                getSpinnerView().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            }
            int index2 = getIndex();
            setIndex(i);
            getSpinnerView().notifyItemSelected(i, iconSpinnerItem.getText());
            OnSpinnerItemSelectedListener<IconSpinnerItem> onSpinnerItemSelectedListener2 = getOnSpinnerItemSelectedListener();
            if (onSpinnerItemSelectedListener2 != null) {
                Integer valueOf = Integer.valueOf(index2);
                if (!(valueOf.intValue() != -1)) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    valueOf.intValue();
                    iconSpinnerItem2 = this.spinnerItems.get(index2);
                }
                onSpinnerItemSelectedListener2.onItemSelected(index2, iconSpinnerItem2, i, iconSpinnerItem);
            }
        }
    }

    public int getItemCount() {
        return this.spinnerItems.size();
    }

    @Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo18301d2 = {"Lcom/skydoves/powerspinner/IconSpinnerAdapter$IconSpinnerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/skydoves/powerspinner/databinding/ItemDefaultPowerSpinnerLibraryBinding;", "(Lcom/skydoves/powerspinner/databinding/ItemDefaultPowerSpinnerLibraryBinding;)V", "bind", "", "item", "Lcom/skydoves/powerspinner/IconSpinnerItem;", "spinnerView", "Lcom/skydoves/powerspinner/PowerSpinnerView;", "powerspinner_release"}, mo18302k = 1, mo18303mv = {1, 4, 1})
    /* compiled from: IconSpinnerAdapter.kt */
    public static final class IconSpinnerViewHolder extends RecyclerView.ViewHolder {
        private final ItemDefaultPowerSpinnerLibraryBinding binding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IconSpinnerViewHolder(ItemDefaultPowerSpinnerLibraryBinding itemDefaultPowerSpinnerLibraryBinding) {
            super(itemDefaultPowerSpinnerLibraryBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemDefaultPowerSpinnerLibraryBinding, "binding");
            this.binding = itemDefaultPowerSpinnerLibraryBinding;
        }

        public final void bind(IconSpinnerItem iconSpinnerItem, PowerSpinnerView powerSpinnerView) {
            Drawable drawable;
            Intrinsics.checkNotNullParameter(iconSpinnerItem, "item");
            Intrinsics.checkNotNullParameter(powerSpinnerView, "spinnerView");
            AppCompatTextView appCompatTextView = this.binding.itemDefaultText;
            appCompatTextView.setText(iconSpinnerItem.getText());
            Integer typeface = iconSpinnerItem.getTypeface();
            if (typeface != null) {
                appCompatTextView.setTypeface(appCompatTextView.getTypeface(), typeface.intValue());
            } else {
                appCompatTextView.setTypeface(powerSpinnerView.getTypeface());
            }
            Integer gravity = iconSpinnerItem.getGravity();
            appCompatTextView.setGravity(gravity != null ? gravity.intValue() : powerSpinnerView.getGravity());
            Float textSize = iconSpinnerItem.getTextSize();
            appCompatTextView.setTextSize(0, textSize != null ? textSize.floatValue() : powerSpinnerView.getTextSize());
            Integer textColor = iconSpinnerItem.getTextColor();
            appCompatTextView.setTextColor(textColor != null ? textColor.intValue() : powerSpinnerView.getCurrentTextColor());
            Integer iconPadding = iconSpinnerItem.getIconPadding();
            appCompatTextView.setCompoundDrawablePadding(iconPadding != null ? iconPadding.intValue() : powerSpinnerView.getCompoundDrawablePadding());
            Integer iconRes = iconSpinnerItem.getIconRes();
            if (iconRes == null || (drawable = ResourcesCompat.getDrawable(powerSpinnerView.getResources(), iconRes.intValue(), (Resources.Theme) null)) == null) {
                drawable = iconSpinnerItem.getIcon();
            }
            int iconGravity = iconSpinnerItem.getIconGravity();
            if (iconGravity == 48) {
                appCompatTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
            } else if (iconGravity == 80) {
                appCompatTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, drawable);
            } else if (iconGravity == 8388611) {
                appCompatTextView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (iconGravity == 8388613) {
                appCompatTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            }
            this.binding.getRoot().setPadding(powerSpinnerView.getPaddingLeft(), powerSpinnerView.getPaddingTop(), powerSpinnerView.getPaddingRight(), powerSpinnerView.getPaddingBottom());
        }
    }
}
