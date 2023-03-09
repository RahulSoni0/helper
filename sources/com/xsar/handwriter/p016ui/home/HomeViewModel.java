package com.xsar.handwriter.p016ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* renamed from: com.xsar.handwriter.ui.home.HomeViewModel */
public class HomeViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public HomeViewModel() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this.mText = mutableLiveData;
        mutableLiveData.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return this.mText;
    }
}
