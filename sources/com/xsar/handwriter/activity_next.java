package com.xsar.handwriter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.skydoves.powerspinner.OnSpinnerItemSelectedListener;
import com.skydoves.powerspinner.PowerSpinnerView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class activity_next extends AppCompatActivity implements PurchasesUpdatedListener {
    public static final String PREF_FILE = "MyPref";
    public static final String PRODUCT_ID = "add_font_169.69";
    public static final String PURCHASE_KEY = "purchase";
    LinearLayout AddFont;
    ImageButton CaptureButton;
    LinearLayout Import_Font;
    Button LineLayoutView;
    Button LineLayoutViewDuplicate;
    Button MarginButton;
    Button MarginColorBlack;
    Button MarginColorBlue;
    Button MarginColorDarkBlue;
    Button MarginColorDarkRed;
    Button MarginColorGrey;
    HorizontalScrollView MarginColorLayout;
    Button MarginColorRed;
    Button PayContinue;
    Button PayText1;
    Button PayText2;
    View PayTutorialBackground;
    Button PayTutorialLayout;
    AcknowledgePurchaseResponseListener ackPurchase;
    ImageButton backButton;
    PowerSpinnerView backgroundPaperSpinnerView;
    Integer[] backgroundPapers;
    int backgroundSelected = 0;
    BillingClient billingClient;
    private Animation captureAnim;
    ImageButton capturedAccept;
    ImageButton capturedDecline;
    public boolean capturedImage = false;
    ArrayList<Bitmap> capturedImages;
    PowerSpinnerView colorSpinnerView;
    public int count = 0;
    public boolean customFontPayment = false;
    float dist2;
    Button drawLineLayout;
    public boolean drawLines = false;
    public boolean drawMargin = false;
    public boolean drawSideMargin = false;
    EditText editText1;
    LinearLayout exportButton;
    public boolean extraLayout = false;
    Button extraLayoutclose;
    LinearLayout extraSettingsLayout;
    Animation fadeIn2;
    Animation fadeOut2;
    int fontColorSelected = 0;
    int fontHeight;
    int fontSize = 50;
    Animation fromBottom2;
    /* access modifiers changed from: private */
    public Animation fromRight;
    Button guidance2;
    PowerSpinnerView handwritingSpinnerView;
    ImageButton imageButton1;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    Bitmap lineBitmap;
    SeekBar lineDistance;
    SeekBar lineDistance2;
    View lineHeightView;
    int linePaddinfTop = 0;
    SeekBar linePaddingHori;
    int linePaddingLeft = 0;
    SeekBar linePaddingVert;
    Button lineSettings;
    View lineView;
    LinearLayout linesLinearLayout;
    public boolean linesSelector = false;
    private InterstitialAd mInterstitialAd;
    SeekBar marginAllign;
    Bitmap marginBitmap;
    Integer marginColor;
    View marginView;
    int numOfImages = 0;
    Button payBGButton;
    Button payBgView;
    ImageView pickImage;
    /* access modifiers changed from: private */
    public SharedPreferences prefs;
    public boolean retake = false;
    int retakeNum;
    Bitmap saveBitmap;
    SeekBar seekBar;
    SeekBar seekBar2;
    ImageView selected;
    ImageView selected2;
    ImageView selected21;
    ImageView selected22;
    ImageView selected31;
    ImageView selected33;
    Bitmap sideMarginBitmap;
    Button sideMarginButton;
    int sideMarginDistance = 48;
    View sideMarginView;
    int sidePadding = 40;
    public boolean spinnerBoolean1 = false;
    public boolean spinnerBoolean2 = false;
    public boolean spinnerBoolean3 = false;
    int tempInt = 0;
    TextView textView;
    Animation toBottom2;
    private Animation toRight;
    Toolbar toolbarCaptured;
    int topPadding;
    TextView tvColor;
    TextView tvFont;
    TextView tvPaper;
    TextView tvSize;
    ImageView unselected;
    ArrayList<String> uris;

    public activity_next() {
        Integer valueOf = Integer.valueOf(C2049R.C2051drawable.paper_background_3);
        this.backgroundPapers = new Integer[]{valueOf, Integer.valueOf(C2049R.C2051drawable.paper_background_1), Integer.valueOf(C2049R.C2051drawable.paper_background_2), valueOf, Integer.valueOf(C2049R.C2051drawable.paper_background_4), Integer.valueOf(C2049R.C2051drawable.paper_background_5), Integer.valueOf(C2049R.C2051drawable.paper_background_6), Integer.valueOf(C2049R.C2051drawable.paper_background_7), Integer.valueOf(C2049R.C2051drawable.paper_background_8), Integer.valueOf(C2049R.C2051drawable.paper_background_9)};
        this.capturedImages = new ArrayList<>();
        this.ackPurchase = new activity_next$$ExternalSyntheticLambda0(this);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2049R.layout.activity_next);
        findViewById();
        setInvisible();
        renameUI();
        payInstructionContinue();
        SpinnerPaperMethod();
        SpinnerHandwritingsMethod();
        SpinnerColorMethod();
        MarginColorClickListeners();
        FirstRunMethods();
        this.captureAnim = AnimationUtils.loadAnimation(this, C2049R.anim.captureanimation);
        this.fromRight = AnimationUtils.loadAnimation(this, C2049R.anim.enter_from_right);
        this.toRight = AnimationUtils.loadAnimation(this, C2049R.anim.exit_to_right);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                activity_next.this.uris = new ArrayList<>();
                EditText editText = activity_next.this.editText1;
                editText.setText("\n \n" + activity_next.this.getIntent().getStringExtra("edittext") + "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n ");
                activity_next.this.editText1.setPadding(40, 0, 0, 0);
                activity_next.this.topPadding = 118;
                activity_next.this.fontHeight = 87;
                activity_next activity_next = activity_next.this;
                SharedPreferences unused = activity_next.prefs = activity_next.getPreferences(0);
                float f = activity_next.this.prefs.getFloat("fontsize", 70.0f);
                activity_next.this.seekBar.setMin(40);
                activity_next.this.seekBar.setMax(90);
                activity_next.this.seekBar.setProgress((int) f);
            }
        }, 100);
        this.exportButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_next.this.spinnerDismiss();
                if (activity_next.this.capturedImage) {
                    return;
                }
                if (activity_next.this.numOfImages > 0) {
                    activity_next.this.goToFinalize();
                } else {
                    activity_next.this.guidance2.setVisibility(0);
                }
            }
        });
        this.guidance2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_next.this.guidance2.setVisibility(4);
            }
        });
        this.imageButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (activity_next.this.capturedImage) {
                    return;
                }
                if (!activity_next.this.linesSelector) {
                    activity_next.this.setInvisible();
                    activity_next.this.setFalse();
                    activity_next.this.spinnerDismiss();
                    activity_next.this.linesLinearLayout.startAnimation(activity_next.this.fromRight);
                    activity_next.this.linesLinearLayout.setVisibility(0);
                    activity_next.this.LineLayoutView.setVisibility(0);
                    activity_next.this.LineLayoutViewDuplicate.setVisibility(0);
                    activity_next.this.linesSelector = true;
                    return;
                }
                activity_next.this.setInvisible();
                activity_next.this.linesSelector = false;
            }
        });
        this.LineLayoutView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_next.this.allLayoutsClose();
            }
        });
        this.LineLayoutViewDuplicate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_next.this.allLayoutsClose();
            }
        });
        this.CaptureButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_next.this.captureImage();
                activity_next.this.spinnerDismiss();
                activity_next.this.backgroundPaperSpinnerView.setEnabled(false);
                activity_next.this.handwritingSpinnerView.setEnabled(false);
                activity_next.this.colorSpinnerView.setEnabled(false);
                activity_next.this.AddFont.setEnabled(false);
                activity_next.this.Import_Font.setEnabled(false);
            }
        });
        this.capturedAccept.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_next.this.captureAccept();
                activity_next.this.spinnersOnCaptureAcceptOrDecline();
            }
        });
        this.capturedDecline.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_next.this.captureDecline();
                activity_next.this.spinnersOnCaptureAcceptOrDecline();
            }
        });
        this.backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!activity_next.this.capturedImage) {
                    activity_next.this.finish();
                }
            }
        });
        this.MarginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_next activity_next = activity_next.this;
                activity_next.topMargin(activity_next.marginColor);
            }
        });
        this.sideMarginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_next activity_next = activity_next.this;
                activity_next.sideMargin(activity_next.sideMarginDistance, activity_next.this.marginColor);
            }
        });
        this.drawLineLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (activity_next.this.drawLines) {
                    activity_next.this.eraseLines();
                    activity_next.this.selected31.setVisibility(4);
                    activity_next.this.selected33.setVisibility(4);
                    return;
                }
                activity_next activity_next = activity_next.this;
                activity_next.drawLines(activity_next.lineHeightView.getHeight());
                activity_next.this.selected31.setVisibility(0);
                activity_next.this.selected33.setVisibility(0);
            }
        });
        this.lineSettings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_next.this.extraSettingsLayout.setVisibility(0);
                activity_next.this.extraSettingsLayout.startAnimation(activity_next.this.fromRight);
                activity_next.this.extraLayout = true;
                activity_next.this.linesLinearLayout.setVisibility(8);
                activity_next.this.linesSelector = false;
                activity_next.this.extraLayoutclose.setVisibility(0);
            }
        });
        this.extraLayoutclose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_next.this.extraLineLayouClose();
                activity_next.this.linesLinearLayout.setVisibility(0);
                activity_next.this.linesSelector = true;
                activity_next.this.extraLayoutclose.setVisibility(4);
            }
        });
        this.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                activity_next.this.editText1.setTextSize(0, (float) seekBar.getProgress());
                activity_next.this.fontSize = i;
                TextView textView = activity_next.this.tvSize;
                textView.setText("Font " + String.valueOf(i));
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                activity_next activity_next = activity_next.this;
                SharedPreferences unused = activity_next.prefs = activity_next.getPreferences(0);
                SharedPreferences.Editor edit = activity_next.this.prefs.edit();
                edit.putFloat("fontsize", activity_next.this.editText1.getTextSize());
                edit.commit();
            }
        });
        this.seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                activity_next.this.editText1.setLetterSpacing(((float) i) / 500.0f);
            }
        });
        this.lineDistance.setMin(50);
        this.lineDistance.setMax(150);
        this.lineDistance.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                activity_next.this.drawLines(i);
            }
        });
        this.linePaddingHori.setMin(10);
        this.linePaddingHori.setMax(150);
        this.linePaddingHori.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                activity_next.this.linePaddingLeft = i;
                activity_next.this.editText1.setPadding(i, activity_next.this.linePaddinfTop, 0, 0);
            }
        });
        this.linePaddingVert.setMin(10);
        this.linePaddingVert.setMax(100);
        this.linePaddingVert.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                activity_next.this.linePaddinfTop = i;
                activity_next.this.editText1.setPadding(activity_next.this.linePaddingLeft, i, 0, 0);
            }
        });
        this.lineDistance2.setMin(1);
        this.lineDistance2.setMax(100);
        this.lineDistance2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                activity_next.this.editText1.setLineSpacing((float) i, 1.0f);
            }
        });
        this.marginAllign.setMin(10);
        this.marginAllign.setMax(120);
        this.marginAllign.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                activity_next.this.drawSideMargin = false;
                activity_next activity_next = activity_next.this;
                activity_next.sideMargin(i, activity_next.marginColor);
                activity_next.this.sideMarginDistance = i;
            }
        });
    }

    private void FirstRunMethods() {
        int readSharedPrefernceInt = readSharedPrefernceInt("cntSP", "cntKey");
        this.count = readSharedPrefernceInt;
        if (readSharedPrefernceInt == 0) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    activity_next.this.payBgView.setVisibility(0);
                    activity_next.this.payBGButton.setVisibility(0);
                    activity_next.this.payBgView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            activity_next.this.payBgView.setVisibility(8);
                            activity_next.this.payBGButton.setVisibility(8);
                        }
                    });
                }
            }, 1000);
            int i = this.count + 1;
            this.count = i;
            writeSharedPreferences(i, "cntSP", "cntKey");
        }
    }

    private int readSharedPrefernceInt(String str, String str2) {
        int i = getSharedPreferences(str, 0).getInt(str2, 0);
        this.tempInt = i;
        return i;
    }

    private void writeSharedPreferences(int i, String str, String str2) {
        SharedPreferences.Editor edit = getSharedPreferences(str, 0).edit();
        edit.putInt(str2, i);
        edit.commit();
    }

    private void MarginColorClickListeners() {
        this.MarginColorBlack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_next activity_next = activity_next.this;
                activity_next.marginColor = Integer.valueOf(activity_next.getResources().getColor(C2049R.C2050color.ColourBlack));
                activity_next activity_next2 = activity_next.this;
                activity_next2.drawMargin = !activity_next2.drawMargin;
                activity_next activity_next3 = activity_next.this;
                activity_next3.drawSideMargin = !activity_next3.drawSideMargin;
                activity_next activity_next4 = activity_next.this;
                activity_next4.topMargin(activity_next4.marginColor);
                activity_next activity_next5 = activity_next.this;
                activity_next5.sideMargin(activity_next5.sideMarginDistance, activity_next.this.marginColor);
            }
        });
        this.MarginColorGrey.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_next activity_next = activity_next.this;
                activity_next.marginColor = Integer.valueOf(activity_next.getResources().getColor(C2049R.C2050color.ColourGrey));
                activity_next activity_next2 = activity_next.this;
                activity_next2.drawMargin = !activity_next2.drawMargin;
                activity_next activity_next3 = activity_next.this;
                activity_next3.drawSideMargin = !activity_next3.drawSideMargin;
                activity_next activity_next4 = activity_next.this;
                activity_next4.topMargin(activity_next4.marginColor);
                activity_next activity_next5 = activity_next.this;
                activity_next5.sideMargin(activity_next5.sideMarginDistance, activity_next.this.marginColor);
            }
        });
        this.MarginColorBlue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_next activity_next = activity_next.this;
                activity_next.marginColor = Integer.valueOf(activity_next.getResources().getColor(C2049R.C2050color.ColourBlue));
                activity_next activity_next2 = activity_next.this;
                activity_next2.drawMargin = !activity_next2.drawMargin;
                activity_next activity_next3 = activity_next.this;
                activity_next3.drawSideMargin = !activity_next3.drawSideMargin;
                activity_next activity_next4 = activity_next.this;
                activity_next4.topMargin(activity_next4.marginColor);
                activity_next activity_next5 = activity_next.this;
                activity_next5.sideMargin(activity_next5.sideMarginDistance, activity_next.this.marginColor);
            }
        });
        this.MarginColorDarkBlue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_next activity_next = activity_next.this;
                activity_next.marginColor = Integer.valueOf(activity_next.getResources().getColor(C2049R.C2050color.ColourDarkBlue));
                activity_next activity_next2 = activity_next.this;
                activity_next2.drawMargin = !activity_next2.drawMargin;
                activity_next activity_next3 = activity_next.this;
                activity_next3.drawSideMargin = !activity_next3.drawSideMargin;
                activity_next activity_next4 = activity_next.this;
                activity_next4.topMargin(activity_next4.marginColor);
                activity_next activity_next5 = activity_next.this;
                activity_next5.sideMargin(activity_next5.sideMarginDistance, activity_next.this.marginColor);
            }
        });
        this.MarginColorRed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_next activity_next = activity_next.this;
                activity_next.marginColor = Integer.valueOf(activity_next.getResources().getColor(C2049R.C2050color.ColourRed));
                activity_next activity_next2 = activity_next.this;
                activity_next2.drawMargin = !activity_next2.drawMargin;
                activity_next activity_next3 = activity_next.this;
                activity_next3.drawSideMargin = !activity_next3.drawSideMargin;
                activity_next activity_next4 = activity_next.this;
                activity_next4.topMargin(activity_next4.marginColor);
                activity_next activity_next5 = activity_next.this;
                activity_next5.sideMargin(activity_next5.sideMarginDistance, activity_next.this.marginColor);
            }
        });
        this.MarginColorDarkRed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_next activity_next = activity_next.this;
                activity_next.marginColor = Integer.valueOf(activity_next.getResources().getColor(C2049R.C2050color.ColourDarkRed));
                activity_next activity_next2 = activity_next.this;
                activity_next2.drawMargin = !activity_next2.drawMargin;
                activity_next activity_next3 = activity_next.this;
                activity_next3.drawSideMargin = !activity_next3.drawSideMargin;
                activity_next activity_next4 = activity_next.this;
                activity_next4.topMargin(activity_next4.marginColor);
                activity_next activity_next5 = activity_next.this;
                activity_next5.sideMargin(activity_next5.sideMarginDistance, activity_next.this.marginColor);
            }
        });
    }

    private void findViewById() {
        this.marginColor = Integer.valueOf(C2049R.C2050color.ColourDarkRed);
        this.lineHeightView = findViewById(C2049R.C2052id.LineHeightView);
        this.backButton = (ImageButton) findViewById(C2049R.C2052id.back_button);
        this.exportButton = (LinearLayout) findViewById(C2049R.C2052id.export_btn);
        this.AddFont = (LinearLayout) findViewById(C2049R.C2052id.add_font);
        this.Import_Font = (LinearLayout) findViewById(C2049R.C2052id.Import_Font);
        this.payBgView = (Button) findViewById(C2049R.C2052id.payBGView);
        this.payBGButton = (Button) findViewById(C2049R.C2052id.payBGButton);
        this.guidance2 = (Button) findViewById(C2049R.C2052id.guidance2);
        this.PayTutorialBackground = findViewById(C2049R.C2052id.payTutorialBackground);
        this.PayTutorialLayout = (Button) findViewById(C2049R.C2052id.payTutorialLayout);
        this.PayText1 = (Button) findViewById(C2049R.C2052id.payText1);
        this.PayText2 = (Button) findViewById(C2049R.C2052id.payText2);
        this.PayContinue = (Button) findViewById(C2049R.C2052id.payTutorialContinue);
        this.editText1 = (EditText) findViewById(C2049R.C2052id.edit_text_InNext);
        this.pickImage = (ImageView) findViewById(C2049R.C2052id.Pick_Image_from_gallery);
        this.toolbarCaptured = (Toolbar) findViewById(C2049R.C2052id.toolbarcaptured);
        this.LineLayoutView = (Button) findViewById(C2049R.C2052id.lineLayoutView);
        this.LineLayoutViewDuplicate = (Button) findViewById(C2049R.C2052id.lineLayoutViewDuplicate);
        this.linesLinearLayout = (LinearLayout) findViewById(C2049R.C2052id.linesLinearLayout);
        this.MarginButton = (Button) findViewById(C2049R.C2052id.marginButton);
        this.sideMarginButton = (Button) findViewById(C2049R.C2052id.marginButton2);
        this.selected = (ImageView) findViewById(C2049R.C2052id.circle_selected);
        this.selected2 = (ImageView) findViewById(C2049R.C2052id.circle_selected2);
        this.unselected = (ImageView) findViewById(C2049R.C2052id.circle_unselected);
        this.lineSettings = (Button) findViewById(C2049R.C2052id.lineExtraSettings);
        this.MarginColorLayout = (HorizontalScrollView) findViewById(C2049R.C2052id.marginColor);
        this.selected21 = (ImageView) findViewById(C2049R.C2052id.circle_selected21);
        this.selected22 = (ImageView) findViewById(C2049R.C2052id.circle_selected22);
        this.selected31 = (ImageView) findViewById(C2049R.C2052id.circle_selected3);
        this.selected33 = (ImageView) findViewById(C2049R.C2052id.circle_selected23);
        this.MarginColorBlack = (Button) findViewById(C2049R.C2052id.margin_Colour_Black);
        this.MarginColorGrey = (Button) findViewById(C2049R.C2052id.margin_Colour_Grey);
        this.MarginColorBlue = (Button) findViewById(C2049R.C2052id.margin_Color_Blue);
        this.MarginColorDarkBlue = (Button) findViewById(C2049R.C2052id.margin_Colour_DarkBlue);
        this.MarginColorRed = (Button) findViewById(C2049R.C2052id.margin_Colour_Red);
        this.MarginColorDarkRed = (Button) findViewById(C2049R.C2052id.margin_Colour_DarkRed);
        this.extraSettingsLayout = (LinearLayout) findViewById(C2049R.C2052id.extraLineSettingsLayout);
        this.extraLayoutclose = (Button) findViewById(C2049R.C2052id.extraLayoutClose);
        this.imageButton1 = (ImageButton) findViewById(C2049R.C2052id.imageButton1);
        this.imageButton2 = (ImageButton) findViewById(C2049R.C2052id.imageButton2);
        this.imageButton3 = (ImageButton) findViewById(C2049R.C2052id.imageButton3);
        this.imageButton4 = (ImageButton) findViewById(C2049R.C2052id.imageButton4);
        this.CaptureButton = (ImageButton) findViewById(C2049R.C2052id.textCaptureButton);
        this.capturedAccept = (ImageButton) findViewById(C2049R.C2052id.captured_accept);
        this.capturedDecline = (ImageButton) findViewById(C2049R.C2052id.captured_decline);
        this.textView = (TextView) findViewById(C2049R.C2052id.pages_tv);
        this.lineView = findViewById(C2049R.C2052id.lineView);
        this.marginView = findViewById(C2049R.C2052id.marginView);
        this.sideMarginView = findViewById(C2049R.C2052id.sideMarginView);
        this.drawLineLayout = (Button) findViewById(C2049R.C2052id.lineButton);
        this.seekBar = (SeekBar) findViewById(C2049R.C2052id.FontSizeBar);
        this.seekBar2 = (SeekBar) findViewById(C2049R.C2052id.letterSpacingBar);
        this.lineDistance = (SeekBar) findViewById(C2049R.C2052id.lineDist);
        this.linePaddingHori = (SeekBar) findViewById(C2049R.C2052id.linepaddingh);
        this.linePaddingVert = (SeekBar) findViewById(C2049R.C2052id.linepaddingv);
        this.lineDistance2 = (SeekBar) findViewById(C2049R.C2052id.lineDist2);
        this.marginAllign = (SeekBar) findViewById(C2049R.C2052id.marginAlign);
        this.tvPaper = (TextView) findViewById(C2049R.C2052id.tvDisplayPaper);
        this.tvFont = (TextView) findViewById(C2049R.C2052id.tvDisplayFont);
        this.tvColor = (TextView) findViewById(C2049R.C2052id.tvDisplayColor);
        this.tvSize = (TextView) findViewById(C2049R.C2052id.tvDisplayLine);
        this.fadeOut2 = AnimationUtils.loadAnimation(this, C2049R.anim.fadeout_slow);
        this.fromBottom2 = AnimationUtils.loadAnimation(this, C2049R.anim.from_bottom_original_size);
        this.toBottom2 = AnimationUtils.loadAnimation(this, C2049R.anim.to_bottom_original_size);
        this.fadeIn2 = AnimationUtils.loadAnimation(this, C2049R.anim.fadein_slow);
    }

    private void payInstructionContinue() {
        BillingClient build = BillingClient.newBuilder(this).enablePendingPurchases().setListener(this).build();
        this.billingClient = build;
        build.startConnection(new BillingClientStateListener() {
            public void onBillingServiceDisconnected() {
            }

            public void onBillingSetupFinished(BillingResult billingResult) {
                if (billingResult.getResponseCode() == 0) {
                    List<Purchase> purchasesList = activity_next.this.billingClient.queryPurchases("inapp").getPurchasesList();
                    if (purchasesList == null || purchasesList.size() <= 0) {
                        activity_next.this.savePurchaseValueToPref(false);
                    } else {
                        activity_next.this.handlePurchase(purchasesList);
                    }
                }
            }
        });
        if (getPurchaseValueFromPref()) {
            this.AddFont.setVisibility(8);
            this.Import_Font.setVisibility(0);
            this.Import_Font.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    String str;
                    activity_next.this.spinnerDismiss();
                    if (Build.VERSION.SDK_INT >= 30) {
                        str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath() + "/HandWriter/Fonts/myfont.ttf";
                    } else {
                        str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/HandWriter/Fonts/myfont.ttf";
                    }
                    if (new File(str).exists()) {
                        activity_next.this.editText1.setTypeface(Typeface.createFromFile(str));
                        return;
                    }
                    activity_next.this.PayInstructionItemsVisible();
                    activity_next.this.PayContinue.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            activity_next.this.PayInstructionItemsGone();
                        }
                    });
                }
            });
        } else {
            this.AddFont.setVisibility(0);
            this.Import_Font.setVisibility(8);
        }
        this.AddFont.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_next.this.PayInstructionItemsVisible();
                activity_next.this.spinnerDismiss();
                activity_next.this.PayContinue.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        activity_next.this.purchase(view);
                        activity_next.this.PayInstructionItemsGone();
                    }
                });
            }
        });
        this.PayTutorialBackground.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                activity_next.this.PayInstructionItemsGone();
            }
        });
    }

    /* access modifiers changed from: private */
    public void PayInstructionItemsVisible() {
        this.PayTutorialBackground.startAnimation(this.fadeIn2);
        this.PayTutorialLayout.startAnimation(this.fromBottom2);
        this.PayTutorialLayout.setVisibility(0);
        this.PayTutorialBackground.setVisibility(0);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                activity_next.this.PayText1.setVisibility(0);
                activity_next.this.PayText2.setVisibility(0);
                activity_next.this.PayContinue.setVisibility(0);
            }
        }, 200);
        this.customFontPayment = true;
        this.backgroundPaperSpinnerView.setVisibility(8);
        this.handwritingSpinnerView.setVisibility(8);
        this.colorSpinnerView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void PayInstructionItemsGone() {
        this.PayTutorialBackground.setVisibility(8);
        this.PayTutorialLayout.setVisibility(8);
        this.PayText1.setVisibility(8);
        this.PayText2.setVisibility(8);
        this.PayContinue.setVisibility(8);
        this.PayTutorialBackground.startAnimation(this.fadeOut2);
        this.PayTutorialLayout.startAnimation(this.toBottom2);
        this.customFontPayment = false;
        this.backgroundPaperSpinnerView.setVisibility(0);
        this.handwritingSpinnerView.setVisibility(0);
        this.colorSpinnerView.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void spinnersOnCaptureAcceptOrDecline() {
        this.backgroundPaperSpinnerView.setEnabled(true);
        this.handwritingSpinnerView.setEnabled(true);
        this.colorSpinnerView.setEnabled(true);
        this.AddFont.setEnabled(true);
        this.Import_Font.setEnabled(true);
    }

    private void SpinnerPaperMethod() {
        this.backgroundPaperSpinnerView = (PowerSpinnerView) findViewById(C2049R.C2052id.testSpinner1);
        ArrayList arrayList = new ArrayList();
        arrayList.add("Default");
        arrayList.add("Add Image");
        arrayList.add("Paper 1");
        arrayList.add("Paper 2");
        arrayList.add("Paper 3");
        arrayList.add("Paper 4");
        arrayList.add("Paper 5");
        arrayList.add("Paper 6");
        arrayList.add("Paper 7");
        arrayList.add("Paper 8");
        this.backgroundPaperSpinnerView.setItems(arrayList);
        this.backgroundPaperSpinnerView.setDismissWhenNotifiedItemSelected(false);
        this.backgroundPaperSpinnerView.clearSelectedItem();
        this.backgroundPaperSpinnerView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    activity_next.this.handwritingSpinnerView.dismiss();
                }
                activity_next.this.colorSpinnerView.dismiss();
                return false;
            }
        });
        this.backgroundPaperSpinnerView.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener<Object>() {
            public void onItemSelected(int i, Object obj, int i2, Object obj2) {
                activity_next.this.backgroundPaperSpinnerView.setText("");
                switch (i2) {
                    case 0:
                        activity_next.this.backgroundSelected = 0;
                        activity_next.this.editText1.setBackgroundColor(-1);
                        activity_next.this.tvPaper.setText("Default");
                        return;
                    case 1:
                        activity_next.this.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 120);
                        activity_next.this.tvPaper.setText("Custom");
                        activity_next.this.backgroundPaperSpinnerView.dismiss();
                        return;
                    case 2:
                        activity_next.this.backgroundSelected = 1;
                        activity_next.this.editText1.setBackgroundResource(activity_next.this.backgroundPapers[1].intValue());
                        activity_next.this.tvPaper.setText("Paper 1");
                        return;
                    case 3:
                        activity_next.this.backgroundSelected = 2;
                        activity_next.this.editText1.setBackgroundResource(activity_next.this.backgroundPapers[2].intValue());
                        activity_next.this.tvPaper.setText("Paper 2");
                        return;
                    case 4:
                        activity_next.this.backgroundSelected = 3;
                        activity_next.this.editText1.setBackgroundResource(activity_next.this.backgroundPapers[3].intValue());
                        activity_next.this.tvPaper.setText("Paper 3");
                        return;
                    case 5:
                        activity_next.this.backgroundSelected = 5;
                        activity_next.this.editText1.setBackgroundResource(activity_next.this.backgroundPapers[5].intValue());
                        activity_next.this.tvPaper.setText("Paper 4");
                        return;
                    case 6:
                        activity_next.this.backgroundSelected = 6;
                        activity_next.this.editText1.setBackgroundResource(activity_next.this.backgroundPapers[6].intValue());
                        activity_next.this.tvPaper.setText("Paper 5");
                        return;
                    case 7:
                        activity_next.this.backgroundSelected = 7;
                        activity_next.this.editText1.setBackgroundResource(activity_next.this.backgroundPapers[7].intValue());
                        activity_next.this.tvPaper.setText("Paper 6");
                        return;
                    case 8:
                        activity_next.this.backgroundSelected = 8;
                        activity_next.this.editText1.setBackgroundResource(activity_next.this.backgroundPapers[8].intValue());
                        activity_next.this.tvPaper.setText("Paper 7");
                        return;
                    case 9:
                        activity_next.this.backgroundSelected = 9;
                        activity_next.this.editText1.setBackgroundResource(activity_next.this.backgroundPapers[9].intValue());
                        activity_next.this.tvPaper.setText("Paper 8");
                        return;
                    default:
                        return;
                }
            }
        });
    }

    private void SpinnerHandwritingsMethod() {
        this.handwritingSpinnerView = (PowerSpinnerView) findViewById(C2049R.C2052id.testSpinner2);
        ArrayList arrayList = new ArrayList();
        arrayList.add("Default");
        arrayList.add("Handwriting 1");
        arrayList.add("Handwriting 2");
        arrayList.add("Handwriting 3");
        arrayList.add("Handwriting 4");
        arrayList.add("Handwriting 5");
        arrayList.add("Handwriting 6");
        arrayList.add("Handwriting 7");
        arrayList.add("Handwriting 8");
        arrayList.add("Handwriting 9");
        arrayList.add("Handwriting 10");
        arrayList.add("Handwriting 11");
        arrayList.add("Handwriting 12");
        arrayList.add("Handwriting 13");
        arrayList.add("Handwriting 14");
        arrayList.add("Handwriting 15");
        arrayList.add("Handwriting 16");
        arrayList.add("Handwriting 17");
        arrayList.add("Handwriting 18");
        arrayList.add("Handwriting 19");
        arrayList.add("Handwriting 20");
        arrayList.add("Handwriting 21");
        arrayList.add("Handwriting 22");
        arrayList.add("Handwriting 23");
        arrayList.add("Handwriting 24");
        arrayList.add("Handwriting 25");
        arrayList.add("Handwriting 26");
        arrayList.add("Handwriting 27");
        arrayList.add("Handwriting 28");
        arrayList.add("Handwriting 29");
        arrayList.add("Handwriting 30");
        arrayList.add("Handwriting 31");
        arrayList.add("Handwriting 32");
        arrayList.add("Handwriting 33");
        arrayList.add("Handwriting 34");
        arrayList.add("Handwriting 35");
        arrayList.add("Handwriting 36");
        arrayList.add("Handwriting 37");
        arrayList.add("Handwriting 38");
        arrayList.add("Handwriting 39");
        arrayList.add("Handwriting 40");
        arrayList.add("Handwriting 41");
        arrayList.add("Handwriting 42");
        arrayList.add("Handwriting 43");
        arrayList.add("Handwriting 44");
        arrayList.add("Handwriting 45");
        arrayList.add("Handwriting 46");
        arrayList.add("Handwriting 47");
        arrayList.add("Handwriting 48");
        arrayList.add("Handwriting 49");
        arrayList.add("Handwriting 50");
        arrayList.add("Handwriting 51");
        arrayList.add("Handwriting 52");
        arrayList.add("Handwriting 53");
        arrayList.add("Handwriting 54");
        arrayList.add("Handwriting 55");
        arrayList.add("Handwriting 56");
        this.handwritingSpinnerView.setItems(arrayList);
        this.handwritingSpinnerView.setDismissWhenNotifiedItemSelected(false);
        this.handwritingSpinnerView.clearSelectedItem();
        this.handwritingSpinnerView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    activity_next.this.backgroundPaperSpinnerView.dismiss();
                }
                activity_next.this.colorSpinnerView.dismiss();
                return false;
            }
        });
        this.handwritingSpinnerView.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener<Object>() {
            public void onItemSelected(int i, Object obj, int i2, Object obj2) {
                activity_next.this.handwritingSpinnerView.setText("");
                switch (i2) {
                    case 0:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.times_new_roman));
                        activity_next.this.tvFont.setText("Default");
                        return;
                    case 1:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.handwriting_03));
                        activity_next.this.tvFont.setText("Hw 1");
                        return;
                    case 2:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.handwriting_04));
                        activity_next.this.tvFont.setText("Hw 2");
                        return;
                    case 3:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.handwriting_02));
                        activity_next.this.tvFont.setText("Hw 3");
                        return;
                    case 4:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.handwriting_01));
                        activity_next.this.tvFont.setText("Hw 4");
                        return;
                    case 5:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.handwriting_05));
                        activity_next.this.tvFont.setText("Hw 5");
                        return;
                    case 6:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.handwriterfont6_yashwanth));
                        activity_next.this.tvFont.setText("Hw 6");
                        return;
                    case 7:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.handwriterfont7_ananya));
                        activity_next.this.tvFont.setText("Hw 7");
                        return;
                    case 8:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.handwriterfont_8_afreedi));
                        activity_next.this.tvFont.setText("Hw 8");
                        return;
                    case 9:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.handwriting_09));
                        activity_next.this.tvFont.setText("Hw 9");
                        return;
                    case 10:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.handwriting_10));
                        activity_next.this.tvFont.setText("Hw 10");
                        return;
                    case 11:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.handwriting_11));
                        activity_next.this.tvFont.setText("Hw 11");
                        return;
                    case 12:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.handwriting_12));
                        activity_next.this.tvFont.setText("Hw 12");
                        return;
                    case 13:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts13));
                        activity_next.this.tvFont.setText("Hw 13");
                        return;
                    case 14:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts14));
                        activity_next.this.tvFont.setText("Hw 14");
                        return;
                    case 15:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts15));
                        activity_next.this.tvFont.setText("Hw 15");
                        return;
                    case 16:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts16));
                        activity_next.this.tvFont.setText("Hw 16");
                        return;
                    case 17:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts17));
                        activity_next.this.tvFont.setText("Hw 17");
                        return;
                    case 18:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts18));
                        activity_next.this.tvFont.setText("Hw 18");
                        return;
                    case 19:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts19));
                        activity_next.this.tvFont.setText("Hw 19");
                        return;
                    case 20:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts20));
                        activity_next.this.tvFont.setText("Hw 20");
                        return;
                    case 21:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts21));
                        activity_next.this.tvFont.setText("Hw 21");
                        return;
                    case 22:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts22));
                        activity_next.this.tvFont.setText("Hw 22");
                        return;
                    case 23:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts23));
                        activity_next.this.tvFont.setText("Hw 23");
                        return;
                    case 24:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts24));
                        activity_next.this.tvFont.setText("Hw 24");
                        return;
                    case 25:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts25));
                        activity_next.this.tvFont.setText("Hw 25");
                        return;
                    case 26:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts26));
                        activity_next.this.tvFont.setText("Hw 26");
                        return;
                    case 27:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts27));
                        activity_next.this.tvFont.setText("Hw 27");
                        return;
                    case 28:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts28));
                        activity_next.this.tvFont.setText("Hw 28");
                        return;
                    case 29:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts29));
                        activity_next.this.tvFont.setText("Hw 29");
                        return;
                    case 30:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts30));
                        activity_next.this.tvFont.setText("Hw 30");
                        return;
                    case 31:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts31));
                        activity_next.this.tvFont.setText("Hw 31");
                        return;
                    case 32:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts32));
                        activity_next.this.tvFont.setText("Hw 32");
                        return;
                    case 33:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts33));
                        activity_next.this.tvFont.setText("Hw 33");
                        return;
                    case 34:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts34));
                        activity_next.this.tvFont.setText("Hw 34");
                        return;
                    case 35:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts35));
                        activity_next.this.tvFont.setText("Hw 35");
                        return;
                    case 36:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts36));
                        activity_next.this.tvFont.setText("Hw 36");
                        return;
                    case 37:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts37));
                        activity_next.this.tvFont.setText("Hw 37");
                        return;
                    case 38:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts57));
                        activity_next.this.tvFont.setText("Hw 38");
                        return;
                    case 39:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts39));
                        activity_next.this.tvFont.setText("Hw 39");
                        return;
                    case 40:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts40));
                        activity_next.this.tvFont.setText("Hw 40");
                        return;
                    case 41:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts41));
                        activity_next.this.tvFont.setText("Hw 41");
                        return;
                    case 42:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts42));
                        activity_next.this.tvFont.setText("Hw 42");
                        return;
                    case 43:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts43));
                        activity_next.this.tvFont.setText("Hw 43");
                        return;
                    case 44:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts44));
                        activity_next.this.tvFont.setText("Hw 44");
                        return;
                    case 45:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts45));
                        activity_next.this.tvFont.setText("Hw 45");
                        return;
                    case 46:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts46));
                        activity_next.this.tvFont.setText("Hw 46");
                        return;
                    case 47:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts47));
                        activity_next.this.tvFont.setText("Hw 47");
                        return;
                    case 48:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts48));
                        activity_next.this.tvFont.setText("Hw 48");
                        return;
                    case 49:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts49));
                        activity_next.this.tvFont.setText("Hw 49");
                        return;
                    case 50:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts50));
                        activity_next.this.tvFont.setText("Hw 50");
                        return;
                    case 51:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts51));
                        activity_next.this.tvFont.setText("Hw 51");
                        return;
                    case 52:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts52));
                        activity_next.this.tvFont.setText("Hw 52");
                        return;
                    case 53:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts53));
                        activity_next.this.tvFont.setText("Hw 53");
                        return;
                    case 54:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts54));
                        activity_next.this.tvFont.setText("Hw 54");
                        return;
                    case 55:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts55));
                        activity_next.this.tvFont.setText("Hw 55");
                        return;
                    case 56:
                        activity_next.this.editText1.setTypeface(ResourcesCompat.getFont(activity_next.this, C2049R.font.hwfonts56));
                        activity_next.this.tvFont.setText("Hw 56");
                        return;
                    default:
                        return;
                }
            }
        });
    }

    private void SpinnerColorMethod() {
        this.colorSpinnerView = (PowerSpinnerView) findViewById(C2049R.C2052id.testSpinner3);
        ArrayList arrayList = new ArrayList();
        arrayList.add("Black");
        arrayList.add("White");
        arrayList.add("Grey");
        arrayList.add("Blue");
        arrayList.add("Dark Blue");
        arrayList.add("Red");
        arrayList.add("Dark Red");
        this.colorSpinnerView.setItems(arrayList);
        this.colorSpinnerView.setDismissWhenNotifiedItemSelected(false);
        this.colorSpinnerView.clearSelectedItem();
        this.colorSpinnerView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    activity_next.this.handwritingSpinnerView.dismiss();
                }
                activity_next.this.backgroundPaperSpinnerView.dismiss();
                return false;
            }
        });
        this.colorSpinnerView.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener<Object>() {
            public void onItemSelected(int i, Object obj, int i2, Object obj2) {
                activity_next.this.colorSpinnerView.setText("");
                switch (i2) {
                    case 0:
                        activity_next.this.fontColorSelected = 0;
                        activity_next.this.editText1.setTextColor(activity_next.this.getResources().getColor(C2049R.C2050color.ColourBlack));
                        activity_next.this.tvColor.setText("Black");
                        return;
                    case 1:
                        activity_next.this.fontColorSelected = 6;
                        activity_next.this.editText1.setTextColor(activity_next.this.getResources().getColor(C2049R.C2050color.white));
                        activity_next.this.tvColor.setText("White");
                        return;
                    case 2:
                        activity_next.this.fontColorSelected = 1;
                        activity_next.this.editText1.setTextColor(activity_next.this.getResources().getColor(C2049R.C2050color.ColourGrey));
                        activity_next.this.tvColor.setText("Grey");
                        return;
                    case 3:
                        activity_next.this.fontColorSelected = 2;
                        activity_next.this.editText1.setTextColor(activity_next.this.getResources().getColor(C2049R.C2050color.ColourBlue));
                        activity_next.this.tvColor.setText("Blue");
                        return;
                    case 4:
                        activity_next.this.fontColorSelected = 3;
                        activity_next.this.editText1.setTextColor(activity_next.this.getResources().getColor(C2049R.C2050color.ColourDarkBlue));
                        activity_next.this.tvColor.setText("Dark Blue");
                        return;
                    case 5:
                        activity_next.this.fontColorSelected = 4;
                        activity_next.this.editText1.setTextColor(activity_next.this.getResources().getColor(C2049R.C2050color.ColourRed));
                        activity_next.this.tvColor.setText("Red");
                        return;
                    case 6:
                        activity_next.this.fontColorSelected = 5;
                        activity_next.this.editText1.setTextColor(activity_next.this.getResources().getColor(C2049R.C2050color.ColourDarkRed));
                        activity_next.this.tvColor.setText("Dark Red");
                        return;
                    default:
                        return;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void topMargin(Integer num) {
        if (this.drawMargin) {
            this.drawMargin = false;
            this.selected.setVisibility(4);
            this.selected2.setVisibility(4);
            Bitmap createBitmap = Bitmap.createBitmap(this.marginView.getWidth(), this.marginView.getHeight(), Bitmap.Config.ARGB_8888);
            this.marginView.setBackground(new BitmapDrawable(getResources(), createBitmap));
            this.marginBitmap = createBitmap;
            return;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(this.marginView.getWidth(), this.marginView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap2);
        Paint paint = new Paint();
        paint.setColor(num.intValue());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0f);
        canvas.drawLine(0.0f, 78.0f, (float) this.marginView.getWidth(), 78.0f, paint);
        this.marginView.setBackground(new BitmapDrawable(getResources(), createBitmap2));
        this.marginBitmap = createBitmap2;
        this.drawMargin = true;
        this.selected.setVisibility(0);
        this.selected2.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void sideMargin(int i, Integer num) {
        if (this.drawSideMargin) {
            this.drawSideMargin = false;
            this.selected21.setVisibility(4);
            this.selected22.setVisibility(4);
            this.editText1.setPadding(40, 0, 0, 0);
            this.sidePadding = 40;
            Bitmap createBitmap = Bitmap.createBitmap(this.marginView.getWidth(), this.marginView.getHeight(), Bitmap.Config.ARGB_8888);
            this.sideMarginView.setBackground(new BitmapDrawable(getResources(), createBitmap));
            this.sideMarginBitmap = createBitmap;
            return;
        }
        this.selected21.setVisibility(0);
        this.selected22.setVisibility(0);
        int i2 = i + 10;
        this.editText1.setPadding(i2, 0, 0, 0);
        this.sidePadding = i2;
        Bitmap createBitmap2 = Bitmap.createBitmap(this.marginView.getWidth(), this.marginView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap2);
        Paint paint = new Paint();
        paint.setColor(num.intValue());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0f);
        float f = (float) i;
        canvas.drawLine(f, 0.0f, f, (float) this.marginView.getHeight(), paint);
        this.sideMarginView.setBackground(new BitmapDrawable(getResources(), createBitmap2));
        this.sideMarginBitmap = createBitmap2;
        this.drawSideMargin = true;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 120 && i2 == -1) {
            try {
                this.editText1.setBackground(new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(BitmapFactory.decodeStream(getContentResolver().openInputStream(intent.getData())), this.editText1.getWidth(), this.editText1.getHeight(), false)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (i == 100 && i2 == -1) {
            int i3 = intent.getExtras().getInt("actionPerformed");
            this.uris = intent.getStringArrayListExtra("uris");
            if (i3 == 1) {
                this.capturedImages.clear();
                this.numOfImages = this.uris.size();
                TextView textView2 = this.textView;
                textView2.setText("Pages : " + this.numOfImages);
            } else if (i3 == 2) {
                this.capturedImages.clear();
                this.numOfImages = this.uris.size();
                TextView textView3 = this.textView;
                textView3.setText("Pages : " + this.numOfImages);
                this.exportButton.setVisibility(4);
                this.retake = true;
                this.retakeNum = intent.getExtras().getInt("retake");
            } else if (i3 == 3) {
                TextView textView4 = this.textView;
                textView4.setText("pages : " + this.uris.size());
                this.capturedImages.clear();
            }
        }
    }

    /* access modifiers changed from: private */
    public void setInvisible() {
        this.linesLinearLayout.setVisibility(4);
        this.extraSettingsLayout.setVisibility(4);
        this.extraLayoutclose.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public void setFalse() {
        this.linesSelector = false;
        this.extraLayout = false;
    }

    public void allLayoutsClose() {
        this.LineLayoutView.setVisibility(4);
        this.LineLayoutViewDuplicate.setVisibility(4);
        this.linesLinearLayout.startAnimation(this.toRight);
        setInvisible();
        setFalse();
        this.backgroundPaperSpinnerView.dismiss();
        this.handwritingSpinnerView.dismiss();
        this.colorSpinnerView.dismiss();
    }

    public void extraLineLayouClose() {
        this.extraSettingsLayout.startAnimation(this.toRight);
        this.extraSettingsLayout.setVisibility(8);
        this.extraLayout = false;
    }

    /* access modifiers changed from: private */
    public void spinnerDismiss() {
        this.backgroundPaperSpinnerView.dismiss();
        this.handwritingSpinnerView.dismiss();
        this.colorSpinnerView.dismiss();
        this.spinnerBoolean1 = false;
        this.spinnerBoolean2 = false;
        this.spinnerBoolean3 = false;
    }

    /* access modifiers changed from: private */
    public void goToFinalize() {
        for (int i = 0; i < this.capturedImages.size(); i++) {
            try {
                String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                File createTempFile = File.createTempFile("Handwriter_" + format, ".jpg", getExternalFilesDir(Environment.DIRECTORY_PICTURES));
                this.capturedImages.get(i).compress(Bitmap.CompressFormat.JPEG, 50, new FileOutputStream(createTempFile));
                this.uris.add(createTempFile.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Intent intent = new Intent(this, FinalActivity.class);
        intent.putExtra("capturedImages", this.uris);
        startActivityForResult(intent, 100);
    }

    /* access modifiers changed from: private */
    public void drawLines(int i) {
        this.drawLines = true;
        int height = this.lineView.getHeight();
        int width = this.lineView.getWidth();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(C2049R.C2050color.black));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0f);
        this.dist2 = (float) (i + 100);
        for (int i2 = 0; i2 < height / i; i2++) {
            float f = this.dist2;
            canvas.drawLine(0.0f, f, (float) width, f, paint);
            this.dist2 += (float) i;
        }
        this.lineView.setBackground(new BitmapDrawable(getResources(), createBitmap));
        this.lineBitmap = createBitmap;
    }

    /* access modifiers changed from: private */
    public void eraseLines() {
        this.drawLines = false;
        Bitmap createBitmap = Bitmap.createBitmap(this.lineView.getWidth(), this.lineView.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap);
        this.lineView.setBackground(new BitmapDrawable(getResources(), createBitmap));
        this.lineBitmap = createBitmap;
    }

    /* access modifiers changed from: private */
    public void captureImage() {
        if (!this.capturedImage) {
            this.CaptureButton.startAnimation(this.captureAnim);
            setInvisible();
            setFalse();
            this.editText1.setCursorVisible(false);
            this.editText1.clearFocus();
            this.editText1.buildDrawingCache();
            Bitmap createBitmap = Bitmap.createBitmap(this.editText1.getDrawingCache());
            Bitmap createBitmap2 = Bitmap.createBitmap(this.lineView.getWidth(), this.lineView.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap2);
            canvas.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
            if (this.drawLines) {
                canvas.drawBitmap(this.lineBitmap, 0.0f, 0.0f, (Paint) null);
            }
            if (this.drawMargin) {
                canvas.drawBitmap(this.marginBitmap, 0.0f, 0.0f, (Paint) null);
            }
            if (this.drawSideMargin) {
                canvas.drawBitmap(this.sideMarginBitmap, 0.0f, 0.0f, (Paint) null);
            }
            this.saveBitmap = createBitmap2;
            this.pickImage.setVisibility(0);
            this.pickImage.setImageBitmap(this.saveBitmap);
            this.capturedAccept.setVisibility(0);
            this.capturedDecline.setVisibility(0);
            this.toolbarCaptured.setVisibility(0);
            this.editText1.destroyDrawingCache();
            this.capturedImage = true;
        }
    }

    /* access modifiers changed from: private */
    public void captureAccept() {
        this.capturedImages.add(this.saveBitmap);
        this.capturedAccept.setVisibility(4);
        this.capturedDecline.setVisibility(4);
        this.pickImage.setVisibility(4);
        this.textView.setVisibility(0);
        this.editText1.setCursorVisible(true);
        this.capturedImage = false;
        this.numOfImages++;
        this.textView.setText("Pages : " + this.numOfImages);
        this.toolbarCaptured.setVisibility(4);
        if (this.retake) {
            this.retake = false;
            this.exportButton.setVisibility(0);
            try {
                File createTempFile = File.createTempFile("Handwriter_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()), ".jpg", getExternalFilesDir(Environment.DIRECTORY_PICTURES));
                this.saveBitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(createTempFile));
                this.uris.set(this.retakeNum - 1, createTempFile.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent(this, FinalActivity.class);
            intent.putExtra("capturedImages", this.uris);
            startActivityForResult(intent, 100);
        }
    }

    /* access modifiers changed from: private */
    public void captureDecline() {
        this.capturedAccept.setVisibility(4);
        this.capturedDecline.setVisibility(4);
        this.pickImage.setVisibility(4);
        this.editText1.setCursorVisible(true);
        this.capturedImage = false;
        this.toolbarCaptured.setVisibility(4);
    }

    private void renameUI() {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        defaultDisplay.getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.extraSettingsLayout.getLayoutParams();
        int i = (width * 70) / 100;
        marginLayoutParams.width = i;
        this.extraSettingsLayout.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.linesLinearLayout.getLayoutParams();
        marginLayoutParams2.width = i;
        this.linesLinearLayout.setLayoutParams(marginLayoutParams2);
    }

    public void onBackPressed() {
        if (this.retake) {
            this.retake = false;
            this.exportButton.setVisibility(0);
            Intent intent = new Intent(this, FinalActivity.class);
            intent.putExtra("capturedImages", this.uris);
            startActivityForResult(intent, 100);
        } else if (this.extraLayout) {
            extraLineLayouClose();
            this.linesLinearLayout.setVisibility(0);
            this.linesSelector = true;
            this.extraLayoutclose.setVisibility(4);
        } else if (this.customFontPayment) {
            PayInstructionItemsGone();
        } else {
            boolean z = this.capturedImage;
            if (!z) {
                boolean z2 = this.linesSelector;
                if (!z2) {
                    Toast.makeText(this, "Click on Top-Left corner to perform back function", 0).show();
                } else if (z2) {
                    allLayoutsClose();
                }
            } else if (z) {
                Toast.makeText(this, "Save or Discard the captured image", 0).show();
            }
        }
    }

    private SharedPreferences getPrefs() {
        return getApplicationContext().getSharedPreferences(PREF_FILE, 0);
    }

    private SharedPreferences.Editor getPrefsEdit() {
        return getApplicationContext().getSharedPreferences(PREF_FILE, 0).edit();
    }

    private boolean getPurchaseValueFromPref() {
        return getPrefs().getBoolean(PURCHASE_KEY, false);
    }

    /* access modifiers changed from: private */
    public void savePurchaseValueToPref(boolean z) {
        getPrefsEdit().putBoolean(PURCHASE_KEY, z).commit();
    }

    public void purchase(View view) {
        if (this.billingClient.isReady()) {
            initiatePurchase();
            return;
        }
        BillingClient build = BillingClient.newBuilder(this).enablePendingPurchases().setListener(this).build();
        this.billingClient = build;
        build.startConnection(new BillingClientStateListener() {
            public void onBillingServiceDisconnected() {
            }

            public void onBillingSetupFinished(BillingResult billingResult) {
                if (billingResult.getResponseCode() == 0) {
                    activity_next.this.initiatePurchase();
                    return;
                }
                activity_next activity_next = activity_next.this;
                Toast.makeText(activity_next, "Error : " + billingResult.getDebugMessage(), 0).show();
            }
        });
    }

    /* access modifiers changed from: private */
    public void initiatePurchase() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PRODUCT_ID);
        SkuDetailsParams.Builder newBuilder = SkuDetailsParams.newBuilder();
        newBuilder.setSkusList(arrayList).setType("inapp");
        this.billingClient.querySkuDetailsAsync(newBuilder.build(), new activity_next$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$initiatePurchase$0$com-xsar-handwriter-activity_next  reason: not valid java name */
    public /* synthetic */ void m1931lambda$initiatePurchase$0$comxsarhandwriteractivity_next(BillingResult billingResult, List list) {
        if (billingResult.getResponseCode() != 0) {
            Toast.makeText(this, "Error : " + billingResult.getDebugMessage(), 0).show();
        } else if (list == null || list.size() <= 0) {
            Toast.makeText(this, "Item not found..!", 0).show();
        } else {
            this.billingClient.launchBillingFlow(this, BillingFlowParams.newBuilder().setSkuDetails((SkuDetails) list.get(0)).build());
        }
    }

    public void onPurchasesUpdated(BillingResult billingResult, List<Purchase> list) {
        if (billingResult.getResponseCode() == 0 && list != null) {
            handlePurchase(list);
        } else if (billingResult.getResponseCode() == 7) {
            List<Purchase> purchasesList = this.billingClient.queryPurchases("inapp").getPurchasesList();
            if (purchasesList != null) {
                handlePurchase(purchasesList);
            }
        } else if (billingResult.getResponseCode() == 1) {
            Toast.makeText(this, "Purchase canceled", 0).show();
        } else {
            Toast.makeText(this, "Error : " + billingResult.getDebugMessage(), 0).show();
        }
    }

    /* access modifiers changed from: package-private */
    public void handlePurchase(List<Purchase> list) {
        for (Purchase next : list) {
            if (!PRODUCT_ID.equals(next.getSku()) || next.getPurchaseState() != 1) {
                if (PRODUCT_ID.equals(next.getSku()) && next.getPurchaseState() == 2) {
                    Toast.makeText(this, "Purchase Pending : Please complete the Transaction", 0).show();
                } else if (PRODUCT_ID.equals(next.getSku()) && next.getPurchaseState() == 0) {
                    savePurchaseValueToPref(false);
                    this.AddFont.setVisibility(0);
                    Toast.makeText(this, "Purchase Status in Unknown", 0).show();
                }
            } else if (!verifyValidSignature(next.getOriginalJson(), next.getSignature())) {
                Toast.makeText(this, "Error : Invalid Purchase", 0).show();
                return;
            } else if (!next.isAcknowledged()) {
                this.billingClient.acknowledgePurchase(AcknowledgePurchaseParams.newBuilder().setPurchaseToken(next.getPurchaseToken()).build(), this.ackPurchase);
            } else if (!getPurchaseValueFromPref()) {
                savePurchaseValueToPref(true);
                Toast.makeText(this, "Item Purchased", 0).show();
                recreate();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$1$com-xsar-handwriter-activity_next  reason: not valid java name */
    public /* synthetic */ void m1932lambda$new$1$comxsarhandwriteractivity_next(BillingResult billingResult) {
        if (billingResult.getResponseCode() == 0) {
            savePurchaseValueToPref(true);
            Toast.makeText(this, "Item Purchased", 0).show();
            recreate();
        }
    }

    public boolean verifyValidSignature(String str, String str2) {
        try {
            return Security.verifyPurchase("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA80p0Rw5hdEAtFTnX9Qmwxte5oOI+gjhTfiK2kqwrBOFE75erUJ9OJxa6e31yIvbjRsJc/9LrlMaYBOnDno9lqlRpDjDq6Ij/L2WhH3NIOqmR+XQXISY9dpMg3La/DzpDQAJCoqoDimayc4JM9tKWSivdGS7LNBVNkuepK9qi+EgA3U8sB0ahqYUa0ukYZVMH4fqvuikNhYPRD1lR3vSnFnEJlP97EwUwUpx1odhNHTGTx6Onk0z5xNQjiIxBi0jw8o4Ij+PU6LTSdKSlkEpioCK03Z1cJjx6bzSLpc0MCZ4I5WFmDnihGIdEcx3OPMafuxrSN9kkdtVz7FVZN9tn3QIDAQAB", str, str2);
        } catch (IOException unused) {
            return false;
        }
    }

    public void onDestroy() {
        BillingClient billingClient2 = this.billingClient;
        if (billingClient2 != null) {
            billingClient2.endConnection();
        }
        super.onDestroy();
    }
}
