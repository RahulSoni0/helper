package com.skydoves.powerspinner.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.skydoves.powerspinner.C1867R;
import java.util.Objects;

public final class ItemDefaultPowerSpinnerLibraryBinding implements ViewBinding {
    public final AppCompatTextView itemDefaultText;
    private final AppCompatTextView rootView;

    private ItemDefaultPowerSpinnerLibraryBinding(AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.rootView = appCompatTextView;
        this.itemDefaultText = appCompatTextView2;
    }

    public AppCompatTextView getRoot() {
        return this.rootView;
    }

    public static ItemDefaultPowerSpinnerLibraryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemDefaultPowerSpinnerLibraryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1867R.layout.item_default_power_spinner_library, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemDefaultPowerSpinnerLibraryBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        AppCompatTextView appCompatTextView = (AppCompatTextView) view;
        return new ItemDefaultPowerSpinnerLibraryBinding(appCompatTextView, appCompatTextView);
    }
}
