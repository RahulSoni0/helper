package com.xsar.handwriter.p016ui.aboutus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.xsar.handwriter.C2049R;

/* renamed from: com.xsar.handwriter.ui.aboutus.FragmentAboutUs */
public class FragmentAboutUs extends Fragment {
    private AboutUsViewModel slideshowViewModel;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.slideshowViewModel = (AboutUsViewModel) ViewModelProviders.m15of((Fragment) this).get(AboutUsViewModel.class);
        View inflate = layoutInflater.inflate(C2049R.layout.fragment_about_us, viewGroup, false);
        final TextView textView = (TextView) inflate.findViewById(C2049R.C2052id.text_slideshow);
        this.slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            public void onChanged(String str) {
                textView.setText(str);
            }
        });
        return inflate;
    }
}
