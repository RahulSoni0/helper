package com.xsar.handwriter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import java.io.File;

public class CustomFontActivity extends AppCompatActivity {
    private static final int READ_REQUEST_CODE = 42;
    Button customFontButton1;

    /* renamed from: tv */
    TextView f1507tv;
    Button uploadFont;
    Boolean visibleFont1 = false;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2049R.layout.activity_custom_font);
        setSupportActionBar((Toolbar) findViewById(C2049R.C2052id.toolarFont));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle((CharSequence) "Add Font");
        this.customFontButton1 = (Button) findViewById(C2049R.C2052id.customFont1);
        this.uploadFont = (Button) findViewById(C2049R.C2052id.upload);
        this.f1507tv = (TextView) findViewById(C2049R.C2052id.textView);
        this.uploadFont.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CustomFontActivity.this.performFileSearch();
            }
        });
        if (!this.visibleFont1.booleanValue()) {
            this.customFontButton1.setVisibility(8);
        } else {
            this.customFontButton1.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void performFileSearch() {
        if (ActivityCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 100);
            return;
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("application/octet-stream");
        startActivityForResult(intent, 42);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 100) {
            return;
        }
        if (iArr[0] == 0) {
            performFileSearch();
            Toast.makeText(this, "Permission Granted!", 0).show();
            return;
        }
        finish();
        Toast.makeText(this, "Storage Permission required to access text files", 0).show();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 42 && i2 == -1) {
            this.f1507tv.setText(new File(intent.getData().getPath()).toString());
            this.customFontButton1.setVisibility(0);
            this.visibleFont1 = true;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
