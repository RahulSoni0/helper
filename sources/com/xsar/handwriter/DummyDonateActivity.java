package com.xsar.handwriter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DummyDonateActivity extends AppCompatActivity {
    ImageButton copy;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2049R.layout.activity_donate_dummy);
        ImageButton imageButton = (ImageButton) findViewById(C2049R.C2052id.copyButton);
        this.copy = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((ClipboardManager) DummyDonateActivity.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", "xsar.handwriter@ybl"));
                Toast.makeText(DummyDonateActivity.this, "UPI ID copied", 0).show();
            }
        });
    }
}
