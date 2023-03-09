package com.xsar.handwriter.p016ui.tutorial;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* renamed from: com.xsar.handwriter.ui.tutorial.TutorialViewModel */
public class TutorialViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public TutorialViewModel() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this.mText = mutableLiveData;
        mutableLiveData.setValue("AN OVERVIEW ON HOW TO USE...\n\nHere you can convert text to handwritten form by directly capturing Pictures or by importing them from Gallery.\n \n\nSELECT\n\nCamera : Capture clear image of printed text\nOpen Text File : Open .txt Files from External Storage \nCreate Text File : Type or Copy/Paste the text you want \nImport from Gallery : On Top-Right Corner, Click Gallery Icon to import Images from the Gallery \n\n\nGET TEXT FROM IMAGES \n\nCopy recognized text from all images, Edit and paste it in a single text file \n\n\nGET FILES FROM PHONE\n\nText file selected from the phone will be displayed here or edited text file from images will be displayed here, You can save the text file for future use or go to final Activity.  \n\n\nFINAL ACTIVITY.\n\n* Select your desired paper for background.\n* Choose your favourite handwriting.\n* Adjust the text size. \n* Choose Ink color. \n* Import and add hand drawn diagram from gallery in\n  selected ink color at the cursor position.\n* Scroll and Capture the images of final text.\n* Save or Cancel the captured image.\n* Finally Export as Pdf File.\n");
    }

    public LiveData<String> getText() {
        return this.mText;
    }
}
