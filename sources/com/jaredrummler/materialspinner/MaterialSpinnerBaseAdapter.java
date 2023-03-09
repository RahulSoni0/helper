package com.jaredrummler.materialspinner;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public abstract class MaterialSpinnerBaseAdapter<T> extends BaseAdapter {
    private int backgroundSelector;
    private final Context context;
    private boolean isHintEnabled;
    private int popupPaddingBottom;
    private int popupPaddingLeft;
    private int popupPaddingRight;
    private int popupPaddingTop;
    private int selectedIndex;
    private int textColor;

    public abstract T get(int i);

    public abstract int getCount();

    public abstract T getItem(int i);

    public long getItemId(int i) {
        return (long) i;
    }

    public abstract List<T> getItems();

    public MaterialSpinnerBaseAdapter(Context context2) {
        this.context = context2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(C1844R.layout.ms__list_item, viewGroup, false);
            textView = (TextView) view.findViewById(C1844R.C1846id.tv_tinted_spinner);
            textView.setTextColor(this.textColor);
            textView.setPadding(this.popupPaddingLeft, this.popupPaddingTop, this.popupPaddingRight, this.popupPaddingBottom);
            int i2 = this.backgroundSelector;
            if (i2 != 0) {
                textView.setBackgroundResource(i2);
            }
            if (Build.VERSION.SDK_INT >= 17 && this.context.getResources().getConfiguration().getLayoutDirection() == 1) {
                textView.setTextDirection(4);
            }
            view.setTag(new ViewHolder(textView));
        } else {
            textView = ((ViewHolder) view.getTag()).textView;
        }
        textView.setText(getItemText(i));
        return view;
    }

    public String getItemText(int i) {
        return getItem(i).toString();
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    public void notifyItemSelected(int i) {
        this.selectedIndex = i;
    }

    public void setHintEnabled(boolean z) {
        this.isHintEnabled = z;
    }

    public boolean isHintEnabled() {
        return this.isHintEnabled;
    }

    public MaterialSpinnerBaseAdapter<T> setTextColor(int i) {
        this.textColor = i;
        return this;
    }

    public MaterialSpinnerBaseAdapter<T> setBackgroundSelector(int i) {
        this.backgroundSelector = i;
        return this;
    }

    public MaterialSpinnerBaseAdapter<T> setPopupPadding(int i, int i2, int i3, int i4) {
        this.popupPaddingLeft = i;
        this.popupPaddingTop = i2;
        this.popupPaddingRight = i3;
        this.popupPaddingBottom = i4;
        return this;
    }

    private static class ViewHolder {
        /* access modifiers changed from: private */
        public TextView textView;

        private ViewHolder(TextView textView2) {
            this.textView = textView2;
        }
    }
}
