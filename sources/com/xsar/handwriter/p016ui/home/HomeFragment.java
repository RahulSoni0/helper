package com.xsar.handwriter.p016ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import com.xsar.handwriter.Activity_Folder_Image;
import com.xsar.handwriter.Activity_Folder_PDF;
import com.xsar.handwriter.Activity_Folder_Text;
import com.xsar.handwriter.C2049R;
import java.io.File;

/* renamed from: com.xsar.handwriter.ui.home.HomeFragment */
public class HomeFragment extends Fragment {
    int TotalCount;
    CardView cardview;
    Animation fromLeft;
    Animation fromRight;
    TextView getImageFilesBadge;
    TextView getPdfFilesBadge;
    TextView getTextFilesBadge;
    LinearLayout imageFiles;
    LinearLayout imageFilesShadow;
    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    LinearLayout pdfFiles;
    LinearLayout pdfFilesshadow;
    LinearLayout textFiles;
    LinearLayout textFilesShadow;
    Animation toLeft;
    Animation toRight;
    ViewFlipper viewFlipper;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        View inflate = layoutInflater.inflate(C2049R.layout.fragment_home, viewGroup, false);
        this.textFiles = (LinearLayout) inflate.findViewById(C2049R.C2052id.text_button);
        this.pdfFiles = (LinearLayout) inflate.findViewById(C2049R.C2052id.pdf_button);
        this.imageFiles = (LinearLayout) inflate.findViewById(C2049R.C2052id.image_button);
        this.textFilesShadow = (LinearLayout) inflate.findViewById(C2049R.C2052id.text_button_shadow);
        this.pdfFilesshadow = (LinearLayout) inflate.findViewById(C2049R.C2052id.pdf_button_shadow);
        this.imageFilesShadow = (LinearLayout) inflate.findViewById(C2049R.C2052id.image_button_shadow);
        this.getTextFilesBadge = (TextView) inflate.findViewById(C2049R.C2052id.getTextFilesBadge);
        this.getPdfFilesBadge = (TextView) inflate.findViewById(C2049R.C2052id.getPdfFilesBadge);
        this.getImageFilesBadge = (TextView) inflate.findViewById(C2049R.C2052id.getImageFilesBadge);
        this.viewFlipper = (ViewFlipper) inflate.findViewById(C2049R.C2052id.viewFlipper);
        this.imageView1 = (ImageView) inflate.findViewById(C2049R.C2052id.flipperImageView1);
        this.imageView2 = (ImageView) inflate.findViewById(C2049R.C2052id.flipperImageView2);
        this.imageView3 = (ImageView) inflate.findViewById(C2049R.C2052id.flipperImageView3);
        this.imageView4 = (ImageView) inflate.findViewById(C2049R.C2052id.flipperImageView4);
        if (ActivityCompat.checkSelfPermission(getActivity(), "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            try {
                if (Build.VERSION.SDK_INT >= 30) {
                    str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath();
                } else {
                    str = Environment.getExternalStorageDirectory().getAbsolutePath();
                }
                this.getTextFilesBadge.setText(String.valueOf(new File(str + "/HandWriter/Text Files/").listFiles().length));
                this.getPdfFilesBadge.setText(String.valueOf(new File(str + "/HandWriter/Pdf Files/").listFiles().length));
                this.getImageFilesBadge.setText(String.valueOf(new File(str + "/HandWriter/Images/").listFiles().length));
            } catch (Exception unused) {
            }
        } else {
            this.getTextFilesBadge.setVisibility(4);
            this.getPdfFilesBadge.setVisibility(4);
            this.getImageFilesBadge.setVisibility(4);
        }
        homeUI();
        this.textFiles.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(HomeFragment.this.getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    ActivityCompat.requestPermissions(HomeFragment.this.getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 100);
                } else {
                    HomeFragment.this.getTextFiles();
                }
            }
        });
        this.pdfFiles.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(HomeFragment.this.getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    ActivityCompat.requestPermissions(HomeFragment.this.getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 200);
                } else {
                    HomeFragment.this.getPdfFiles();
                }
            }
        });
        this.imageFiles.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(HomeFragment.this.getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    ActivityCompat.requestPermissions(HomeFragment.this.getActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 300);
                } else {
                    HomeFragment.this.getImagesFiles();
                }
            }
        });
        this.imageView1.setOnClickListener(new HomeFragment$$ExternalSyntheticLambda0(this));
        this.imageView2.setOnClickListener(new HomeFragment$$ExternalSyntheticLambda1(this));
        this.imageView3.setOnClickListener(new HomeFragment$$ExternalSyntheticLambda2(this));
        this.imageView4.setOnClickListener(new HomeFragment$$ExternalSyntheticLambda3(this));
        return inflate;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreateView$0$com-xsar-handwriter-ui-home-HomeFragment  reason: not valid java name */
    public /* synthetic */ void m1933lambda$onCreateView$0$comxsarhandwriteruihomeHomeFragment(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://youtu.be/sxzadvkMfZE")));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreateView$1$com-xsar-handwriter-ui-home-HomeFragment  reason: not valid java name */
    public /* synthetic */ void m1934lambda$onCreateView$1$comxsarhandwriteruihomeHomeFragment(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://youtu.be/NMpyL7nHmIc")));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreateView$2$com-xsar-handwriter-ui-home-HomeFragment  reason: not valid java name */
    public /* synthetic */ void m1935lambda$onCreateView$2$comxsarhandwriteruihomeHomeFragment(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.xsar.handwriter")));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onCreateView$3$com-xsar-handwriter-ui-home-HomeFragment  reason: not valid java name */
    public /* synthetic */ void m1936lambda$onCreateView$3$comxsarhandwriteruihomeHomeFragment(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.instagram.com/xsar.inc/")));
    }

    /* access modifiers changed from: private */
    public void getTextFiles() {
        startActivity(new Intent(getActivity(), Activity_Folder_Text.class));
    }

    /* access modifiers changed from: private */
    public void getPdfFiles() {
        startActivity(new Intent(getActivity(), Activity_Folder_PDF.class));
    }

    /* access modifiers changed from: private */
    public void getImagesFiles() {
        startActivity(new Intent(getActivity(), Activity_Folder_Image.class));
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 100) {
            if (i != 200) {
                if (i == 300) {
                    if (iArr[0] == 0) {
                        Toast.makeText(getActivity(), "Permission Granted!", 0).show();
                        getImagesFiles();
                        return;
                    }
                    Toast.makeText(getActivity(), "Storage permission is required to access files", 0).show();
                }
            } else if (iArr[0] == 0) {
                Toast.makeText(getActivity(), "Permission Granted!", 0).show();
                getPdfFiles();
            } else {
                Toast.makeText(getActivity(), "Storage permission is required to access files", 0).show();
            }
        } else if (iArr[0] == 0) {
            Toast.makeText(getActivity(), "Permission Granted!", 0).show();
            getTextFiles();
        } else {
            Toast.makeText(getActivity(), "Storage permission is required to access files", 0).show();
        }
    }

    private void homeUI() {
        Display defaultDisplay = getActivity().getWindowManager().getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        defaultDisplay.getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.viewFlipper.getLayoutParams();
        marginLayoutParams.width = (width * 94) / 100;
        marginLayoutParams.height = (width * 47) / 100;
        this.viewFlipper.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.textFiles.getLayoutParams();
        int i = (width * 72) / 100;
        marginLayoutParams2.width = i;
        int i2 = (width * 18) / 100;
        marginLayoutParams2.height = i2;
        this.textFiles.setLayoutParams(marginLayoutParams2);
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.pdfFiles.getLayoutParams();
        marginLayoutParams3.width = i;
        marginLayoutParams3.height = i2;
        this.pdfFiles.setLayoutParams(marginLayoutParams3);
        ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) this.imageFiles.getLayoutParams();
        marginLayoutParams4.width = i;
        marginLayoutParams4.height = i2;
        this.imageFiles.setLayoutParams(marginLayoutParams4);
        ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) this.textFilesShadow.getLayoutParams();
        marginLayoutParams5.width = i;
        marginLayoutParams5.height = i2;
        this.textFilesShadow.setLayoutParams(marginLayoutParams5);
        ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) this.pdfFilesshadow.getLayoutParams();
        marginLayoutParams6.width = i;
        marginLayoutParams6.height = i2;
        this.pdfFilesshadow.setLayoutParams(marginLayoutParams6);
        ViewGroup.MarginLayoutParams marginLayoutParams7 = (ViewGroup.MarginLayoutParams) this.imageFilesShadow.getLayoutParams();
        marginLayoutParams7.width = i;
        marginLayoutParams7.height = i2;
        this.imageFilesShadow.setLayoutParams(marginLayoutParams7);
    }
}
