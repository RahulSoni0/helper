package com.xsar.handwriter;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.io.File;

public class SplashActivity extends AppCompatActivity {
    private static final int CAMERA_REQUEST_CODE = 200;
    private static int SPLASH_SCREEN = 1000;
    ImageView imageView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2049R.layout.activity_splash);
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 200);
        } else {
            splash();
        }
        this.imageView = (ImageView) findViewById(C2049R.C2052id.xsar_icon);
        this.imageView = (ImageView) findViewById(C2049R.C2052id.from_icon);
        this.imageView = (ImageView) findViewById(C2049R.C2052id.logo_pic);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 200) {
            return;
        }
        if (iArr[0] == 0) {
            Toast.makeText(this, "Permission Granted!", 0).show();
            splash();
            return;
        }
        Toast.makeText(this, "Permission DENIED..!", 0).show();
        splash();
    }

    private void splash() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                File file;
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, MainActivity.class));
                SplashActivity.this.overridePendingTransition(C2049R.anim.fadein, C2049R.anim.fadeout);
                SplashActivity.this.finish();
                if (Build.VERSION.SDK_INT >= 30) {
                    file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath());
                } else {
                    file = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
                }
                File file2 = new File(file + "/HandWriter//Text Files/");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                File file3 = new File(file + "/HandWriter//Pdf Files/");
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                File file4 = new File(file + "/HandWriter//Images/");
                if (!file4.exists()) {
                    file4.mkdirs();
                }
                File file5 = new File(file + "/HandWriter//Fonts/");
                if (!file5.exists()) {
                    file5.mkdirs();
                }
            }
        }, (long) SPLASH_SCREEN);
    }
}
