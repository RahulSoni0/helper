package com.skydoves.powerspinner.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.skydoves.powerspinner.C1867R;

public final class LayoutBodyPowerSpinnerLibraryBinding implements ViewBinding {
    public final FrameLayout body;
    public final RecyclerView recyclerView;
    private final FrameLayout rootView;

    private LayoutBodyPowerSpinnerLibraryBinding(FrameLayout frameLayout, FrameLayout frameLayout2, RecyclerView recyclerView2) {
        this.rootView = frameLayout;
        this.body = frameLayout2;
        this.recyclerView = recyclerView2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LayoutBodyPowerSpinnerLibraryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutBodyPowerSpinnerLibraryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1867R.layout.layout_body_power_spinner_library, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutBodyPowerSpinnerLibraryBinding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i = C1867R.C1870id.recyclerView;
        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(i);
        if (recyclerView2 != null) {
            return new LayoutBodyPowerSpinnerLibraryBinding(frameLayout, frameLayout, recyclerView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
