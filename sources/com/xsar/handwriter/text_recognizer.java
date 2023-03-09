package com.xsar.handwriter;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

public class text_recognizer extends AppCompatActivity {
    Button addText;
    String copiedText;
    TextView copyIns;
    TextView downPaste;
    Boolean finalized = false;
    Button guidance;
    Boolean guidanceon = false;
    public Toolbar lowerToolbar2;
    Button nextButton2;
    Button nextText;
    Button okButton;
    Boolean pasting = false;
    Button prevText;
    ArrayList<String> recognizedText;
    EditText scannedText;
    String textFile;
    int textNumber = 0;
    TextView textSelected;
    int totalTexts;
    public Toolbar upperToolbar2;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2049R.layout.activity_text_recognizer);
        this.upperToolbar2 = (Toolbar) findViewById(C2049R.C2052id.upperToolbar2);
        this.textSelected = (TextView) findViewById(C2049R.C2052id.textSelected);
        this.nextButton2 = (Button) findViewById(C2049R.C2052id.nextButton2);
        this.scannedText = (EditText) findViewById(C2049R.C2052id.scannedText);
        this.lowerToolbar2 = (Toolbar) findViewById(C2049R.C2052id.lowerToolbar2);
        this.prevText = (Button) findViewById(C2049R.C2052id.prevText);
        this.addText = (Button) findViewById(C2049R.C2052id.addText);
        this.nextText = (Button) findViewById(C2049R.C2052id.nextText);
        this.okButton = (Button) findViewById(C2049R.C2052id.okbutton);
        this.copyIns = (TextView) findViewById(C2049R.C2052id.copyInstruction);
        this.guidance = (Button) findViewById(C2049R.C2052id.guidance);
        this.downPaste = (TextView) findViewById(C2049R.C2052id.downPaste);
        this.recognizedText = new ArrayList<>();
        setUI();
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("recognizedText");
        this.recognizedText = stringArrayListExtra;
        this.totalTexts = stringArrayListExtra.size();
        TextView textView = this.textSelected;
        textView.setText(String.valueOf(this.textNumber + 1) + "/" + String.valueOf(this.totalTexts));
        this.scannedText.setText(this.recognizedText.get(0));
        setSupportActionBar(this.upperToolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle((CharSequence) "");
        if (getSharedPreferences("PREFERENCE", 0).getBoolean("isFirstRun3", true)) {
            this.guidanceon = true;
            this.guidance.setVisibility(0);
            this.guidance.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    text_recognizer.this.guidance.setVisibility(4);
                    text_recognizer.this.guidanceon = false;
                }
            });
        }
        getSharedPreferences("PREFERENCE", 0).edit().putBoolean("isFirstRun3", false).apply();
        this.prevText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (text_recognizer.this.textNumber > 0) {
                    text_recognizer.this.recognizedText.set(text_recognizer.this.textNumber, text_recognizer.this.scannedText.getText().toString());
                    text_recognizer text_recognizer = text_recognizer.this;
                    text_recognizer.textNumber--;
                    text_recognizer.this.scannedText.setText(text_recognizer.this.recognizedText.get(text_recognizer.this.textNumber));
                    text_recognizer.this.textSelected.setText(String.valueOf(text_recognizer.this.textNumber + 1) + "/" + String.valueOf(text_recognizer.this.totalTexts));
                }
            }
        });
        this.nextText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (text_recognizer.this.textNumber < text_recognizer.this.totalTexts - 1) {
                    text_recognizer.this.recognizedText.set(text_recognizer.this.textNumber, text_recognizer.this.scannedText.getText().toString());
                    text_recognizer.this.textNumber++;
                    text_recognizer.this.scannedText.setText(text_recognizer.this.recognizedText.get(text_recognizer.this.textNumber));
                    text_recognizer.this.textSelected.setText(String.valueOf(text_recognizer.this.textNumber + 1) + "/" + String.valueOf(text_recognizer.this.totalTexts));
                }
            }
        });
        this.addText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!text_recognizer.this.guidanceon.booleanValue()) {
                    text_recognizer.this.nextButton2.setVisibility(0);
                    text_recognizer.this.copyIns.setText("Paste Here");
                    text_recognizer.this.scannedText.setBackgroundResource(C2049R.C2051drawable.paste);
                    text_recognizer.this.prevText.setVisibility(4);
                    text_recognizer.this.nextText.setVisibility(4);
                    text_recognizer.this.addText.setVisibility(4);
                    text_recognizer.this.downPaste.setVisibility(4);
                    text_recognizer.this.okButton.setVisibility(0);
                    text_recognizer.this.scannedText.setText(text_recognizer.this.textFile);
                    text_recognizer text_recognizer = text_recognizer.this;
                    text_recognizer.copiedText = text_recognizer.scannedText.getText().toString();
                    text_recognizer.this.pasting = true;
                    text_recognizer.this.finalized = false;
                }
            }
        });
        this.okButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                text_recognizer.this.nextButton2.setVisibility(4);
                text_recognizer text_recognizer = text_recognizer.this;
                text_recognizer.textFile = text_recognizer.scannedText.getText().toString();
                text_recognizer.this.scannedText.setText(text_recognizer.this.recognizedText.get(text_recognizer.this.textNumber));
                text_recognizer.this.scannedText.setBackground(text_recognizer.this.getDrawable(C2049R.C2051drawable.copy));
                text_recognizer.this.okButton.setVisibility(4);
                text_recognizer.this.prevText.setVisibility(0);
                text_recognizer.this.addText.setVisibility(0);
                text_recognizer.this.nextText.setVisibility(0);
                text_recognizer.this.downPaste.setVisibility(0);
                text_recognizer.this.copyIns.setText("Edit and Copy");
                text_recognizer.this.pasting = false;
                text_recognizer.this.finalized = true;
            }
        });
        this.nextButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (text_recognizer.this.finalized.booleanValue()) {
                    return;
                }
                if (text_recognizer.this.scannedText.getText().length() == 0) {
                    Toast.makeText(text_recognizer.this, "Text cannot be empty", 0).show();
                    return;
                }
                text_recognizer text_recognizer = text_recognizer.this;
                text_recognizer.textFile = text_recognizer.scannedText.getText().toString();
                Intent intent = new Intent(text_recognizer.this, activity_fab4.class);
                intent.putExtra("FileReady", 3);
                intent.putExtra("textFile", text_recognizer.this.textFile);
                text_recognizer.this.startActivity(intent);
            }
        });
    }

    private void setUI() {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.upperToolbar2.getLayoutParams();
        int i = (height * 7) / 100;
        marginLayoutParams.height = i;
        this.upperToolbar2.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.nextButton2.getLayoutParams();
        int i2 = (height * 5) / 100;
        marginLayoutParams2.height = i2;
        marginLayoutParams2.setMargins(0, 0, (height * 1) / 100, 0);
        this.nextButton2.setLayoutParams(marginLayoutParams2);
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.lowerToolbar2.getLayoutParams();
        marginLayoutParams3.height = (height * 13) / 100;
        this.lowerToolbar2.setLayoutParams(marginLayoutParams3);
        ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) this.prevText.getLayoutParams();
        marginLayoutParams4.height = i2;
        marginLayoutParams4.width = i2;
        int i3 = (width * 10) / 100;
        marginLayoutParams4.setMargins(i3, 0, 0, 0);
        this.prevText.setLayoutParams(marginLayoutParams4);
        ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) this.addText.getLayoutParams();
        marginLayoutParams5.height = i;
        marginLayoutParams5.width = i;
        this.addText.setLayoutParams(marginLayoutParams5);
        ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) this.okButton.getLayoutParams();
        marginLayoutParams6.height = i;
        marginLayoutParams6.width = i;
        this.okButton.setLayoutParams(marginLayoutParams6);
        ViewGroup.MarginLayoutParams marginLayoutParams7 = (ViewGroup.MarginLayoutParams) this.nextText.getLayoutParams();
        marginLayoutParams7.height = i2;
        marginLayoutParams7.width = i2;
        marginLayoutParams7.setMargins(0, 0, i3, 0);
        this.nextText.setLayoutParams(marginLayoutParams7);
        this.okButton.setVisibility(4);
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        if (this.pasting.booleanValue()) {
            this.nextButton2.setVisibility(4);
            this.textFile = this.scannedText.getText().toString();
            this.scannedText.setText(this.recognizedText.get(this.textNumber));
            this.okButton.setVisibility(4);
            this.prevText.setVisibility(0);
            this.addText.setVisibility(0);
            this.nextText.setVisibility(0);
            this.downPaste.setVisibility(0);
            this.scannedText.setBackgroundResource(C2049R.C2051drawable.copy);
            this.copyIns.setText("Edit and Copy");
            this.pasting = false;
            this.finalized = true;
            return;
        }
        finish();
    }
}
