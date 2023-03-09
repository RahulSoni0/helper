package com.xsar.handwriter;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class activity_fab4 extends AppCompatActivity {
    private static final int READ_REQUEST_CODE = 42;
    private static final int RESULT_SPEECH = 420;
    int FileReady;
    String eTuNString;
    EditText editText;
    /* access modifiers changed from: private */
    public Animation fadeIn;
    /* access modifiers changed from: private */
    public Animation fadeIn2;
    /* access modifiers changed from: private */
    public Animation fadeOut;
    /* access modifiers changed from: private */
    public Animation fadeOut2;
    String fileName;
    EditText filename;
    Button filenamecancel;
    Button filenameok;
    private InterstitialAd mInterstitialAd;
    String mText;
    LinearLayout nextButton;
    View renameBg;
    LinearLayout renamelayout;
    LinearLayout saveButton;
    boolean saving = false;
    ImageButton speechButton;
    String textFile;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2049R.layout.activity_fab4);
        setSupportActionBar((Toolbar) findViewById(C2049R.C2052id.tool_bar4));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle((CharSequence) "Write your Text here");
        EditText editText2 = (EditText) findViewById(C2049R.C2052id.edit_text);
        this.editText = editText2;
        this.eTuNString = editText2.getText().toString();
        this.saveButton = (LinearLayout) findViewById(C2049R.C2052id.save_btn);
        this.nextButton = (LinearLayout) findViewById(C2049R.C2052id.next_btn);
        this.filename = (EditText) findViewById(C2049R.C2052id.filename2);
        this.renamelayout = (LinearLayout) findViewById(C2049R.C2052id.renamelayout2);
        this.filenameok = (Button) findViewById(C2049R.C2052id.renameok2);
        this.filenamecancel = (Button) findViewById(C2049R.C2052id.renamecancel2);
        this.renameBg = findViewById(C2049R.C2052id.renameBackground);
        this.speechButton = (ImageButton) findViewById(C2049R.C2052id.speechButton);
        renameUI();
        this.fadeIn2 = AnimationUtils.loadAnimation(this, C2049R.anim.fadein_slow);
        this.fadeOut2 = AnimationUtils.loadAnimation(this, C2049R.anim.fadeout_slow);
        this.fadeIn = AnimationUtils.loadAnimation(this, C2049R.anim.fadein);
        this.fadeOut = AnimationUtils.loadAnimation(this, C2049R.anim.fadeout);
        ((InputMethodManager) getSystemService("input_method")).showSoftInput(this.filename, 1);
        int i = getIntent().getExtras().getInt("FileReady");
        this.FileReady = i;
        if (i == 1) {
            performFileSearch();
            saveFunction();
            nextFunction();
        } else if (i == 2) {
            saveFunction();
            nextFunction();
        } else if (i == 3) {
            String string = getIntent().getExtras().getString("textFile");
            this.textFile = string;
            this.editText.setText(string);
            saveFunction();
            nextFunction();
        } else if (i == 4) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(getIntent().getExtras().getString("path")))));
                String str = "";
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    str = str + readLine + "\n";
                }
                this.editText.setText(str);
                bufferedReader.close();
            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), 0).show();
            }
            saveFunction();
            nextFunction();
        }
        this.speechButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
                intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
                intent.putExtra("android.speech.extra.LANGUAGE", "en-US");
                try {
                    activity_fab4.this.startActivityForResult(intent, activity_fab4.RESULT_SPEECH);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(activity_fab4.this, "This device do not support Speech-to-text function", 0).show();
                    e.printStackTrace();
                }
            }
        });
        this.renamelayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        this.filenamecancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_fab4.this.renamelayout.startAnimation(activity_fab4.this.fadeOut);
                activity_fab4.this.renamelayout.setVisibility(4);
                activity_fab4.this.renameBg.startAnimation(activity_fab4.this.fadeOut2);
                activity_fab4.this.renameBg.setVisibility(4);
                activity_fab4.this.saving = false;
            }
        });
        this.renameBg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_fab4.this.renamelayout.startAnimation(activity_fab4.this.fadeOut);
                activity_fab4.this.renameBg.startAnimation(activity_fab4.this.fadeOut2);
                activity_fab4.this.renamelayout.setVisibility(4);
                activity_fab4.this.renameBg.setVisibility(4);
                activity_fab4.this.saving = false;
            }
        });
        this.filenameok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_fab4.this.saveToTextFile();
                activity_fab4.this.renamelayout.startAnimation(activity_fab4.this.fadeOut);
                activity_fab4.this.renamelayout.setVisibility(4);
                activity_fab4.this.renameBg.startAnimation(activity_fab4.this.fadeOut2);
                activity_fab4.this.renameBg.setVisibility(4);
                activity_fab4.this.saving = false;
            }
        });
    }

    private void renameUI() {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        defaultDisplay.getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.renamelayout.getLayoutParams();
        marginLayoutParams.width = (width * 80) / 100;
        this.renamelayout.setLayoutParams(marginLayoutParams);
    }

    private void nextFunction() {
        this.nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!activity_fab4.this.saving) {
                    activity_fab4 activity_fab4 = activity_fab4.this;
                    activity_fab4.mText = activity_fab4.editText.getText().toString().trim();
                    if (activity_fab4.this.mText.isEmpty()) {
                        Toast.makeText(activity_fab4.this, "Text cannot be Empty ", 0).show();
                        return;
                    }
                    String obj = activity_fab4.this.editText.getText().toString();
                    Intent intent = new Intent(activity_fab4.this, activity_next.class);
                    intent.putExtra("edittext", obj);
                    activity_fab4.this.startActivity(intent);
                }
            }
        });
    }

    private void performFileSearch() {
        if (ActivityCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 100);
            return;
        }
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("text/*");
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

    /* access modifiers changed from: private */
    public void saveToTextFile() {
        File file;
        if (ActivityCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
            return;
        }
        String format = new SimpleDateFormat("yyyyMMdd_HHmm", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis()));
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath());
            } else {
                file = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
            }
            File file2 = new File(file + "/HandWriter//Text Files/");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (this.filename.getText().toString().isEmpty()) {
                this.fileName = "New Text " + format + ".txt";
            } else {
                this.fileName = this.filename.getText().toString() + ".txt";
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(file2, this.fileName).getAbsoluteFile()));
            bufferedWriter.write(this.mText);
            bufferedWriter.close();
            Toast.makeText(this, this.fileName + " is saved to " + file2, 0).show();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), 0).show();
        }
    }

    private void saveFunction() {
        this.saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!activity_fab4.this.saving) {
                    activity_fab4 activity_fab4 = activity_fab4.this;
                    activity_fab4.mText = activity_fab4.editText.getText().toString().trim();
                    if (activity_fab4.this.mText.isEmpty()) {
                        Toast.makeText(activity_fab4.this, "Text cannot be Empty ", 0).show();
                        return;
                    }
                    activity_fab4.this.renamelayout.startAnimation(activity_fab4.this.fadeIn);
                    activity_fab4.this.renamelayout.setVisibility(0);
                    activity_fab4.this.renameBg.startAnimation(activity_fab4.this.fadeIn2);
                    activity_fab4.this.renameBg.setVisibility(0);
                    activity_fab4.this.saving = true;
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        File file;
        super.onActivityResult(i, i2, intent);
        if (i == 42 && i2 == -1) {
            String path = intent.getData().getPath();
            String substring = path.substring(path.lastIndexOf("/") + 1);
            this.editText.setText(substring);
            String substring2 = path.substring(path.lastIndexOf(":") + 1);
            try {
                if (Build.VERSION.SDK_INT >= 30) {
                    file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath() + "/" + substring2);
                } else {
                    file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + substring2);
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                String str = "";
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        str = str + readLine + "\n";
                    } else {
                        this.editText.setText(str);
                        bufferedReader.close();
                        Toast.makeText(this, "Opening " + substring, 0).show();
                        return;
                    }
                }
            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), 0).show();
            }
        } else if (i == RESULT_SPEECH && i2 == -1 && intent != null) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("android.speech.extra.RESULTS");
            this.editText.getText().insert(this.editText.getSelectionStart(), " " + stringArrayListExtra.get(0) + " ");
        }
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        if (this.saving) {
            this.renamelayout.startAnimation(this.fadeOut);
            this.renamelayout.setVisibility(4);
            this.renameBg.startAnimation(this.fadeOut2);
            this.renameBg.setVisibility(4);
            this.saving = false;
            return;
        }
        finish();
    }
}
