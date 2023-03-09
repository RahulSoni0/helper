package com.xsar.handwriter.p016ui.tutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.xsar.handwriter.C2049R;

/* renamed from: com.xsar.handwriter.ui.tutorial.FragmentTutorial */
public class FragmentTutorial extends Fragment {
    private TutorialViewModel galleryViewModel;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.galleryViewModel = (TutorialViewModel) ViewModelProviders.m15of((Fragment) this).get(TutorialViewModel.class);
        View inflate = layoutInflater.inflate(C2049R.layout.fragment_tutorial, viewGroup, false);
        final TextView textView = (TextView) inflate.findViewById(C2049R.C2052id.text_gallery);
        this.galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            public void onChanged(String str) {
                textView.setText(str);
            }
        });
        return inflate;
    }
}
