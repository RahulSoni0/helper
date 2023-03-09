package com.skydoves.powerspinner.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.skydoves.powerspinner.C1867R;

public final class LayoutPreferencePowerSpinnerLibraryBinding implements ViewBinding {
    public final LinearLayout powerSpinnerPreference;
    public final AppCompatTextView preferenceTitle;
    private final LinearLayout rootView;

    private LayoutPreferencePowerSpinnerLibraryBinding(LinearLayout linearLayout, LinearLayout linearLayout2, AppCompatTextView appCompatTextView) {
        this.rootView = linearLayout;
        this.powerSpinnerPreference = linearLayout2;
        this.preferenceTitle = appCompatTextView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutPreferencePowerSpinnerLibraryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutPreferencePowerSpinnerLibraryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1867R.layout.layout_preference_power_spinner_library, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutPreferencePowerSpinnerLibraryBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = C1867R.C1870id.preference_title;
        AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(i);
        if (appCompatTextView != null) {
            return new LayoutPreferencePowerSpinnerLibraryBinding(linearLayout, linearLayout, appCompatTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
