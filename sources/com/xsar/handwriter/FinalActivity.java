package com.xsar.handwriter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.res.ResourcesCompat;
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

public class FinalActivity extends AppCompatActivity {
    LinearLayout RedoButton;
    LinearLayout UndoButton;
    AnimationDrawable anim;
    SeekBar brushHardness;
    int brushOpacity = 10;
    SeekBar brushSize;
    int brushSizeValue = 20;
    boolean bullet = true;
    private Button bullet1;
    private Button bullet2;
    private Button bullet3;
    private Button bullet4;
    private Button bullet5;
    private Button bullet6;
    private Button bullet7;
    private Button bullet8;
    private Button bullet9;
    /* access modifiers changed from: private */
    public Button bulletClose;
    LinearLayout bulletLayout;
    ArrayList<Bitmap> capturedImages;
    Bitmap changeabliBitmap;
    Bitmap coloredBitmap;
    int diagramAction = 0;
    /* access modifiers changed from: private */
    public Button diagramClose;
    /* access modifiers changed from: private */
    public Button diagramOk;
    /* access modifiers changed from: private */
    public Button diagramResize;
    boolean diagramSelected = false;
    Bitmap drawingBitmap;
    boolean erase = true;
    Button eraseButton;
    LinearLayout eraseDiagram;
    LinearLayout eraseLayout;
    /* access modifiers changed from: private */
    public ImageButton eraseLayoutClose;
    View exportBg;
    private Button exportImages;
    LinearLayout exportLayout;
    private Button exportPdf;
    /* access modifiers changed from: private */
    public boolean exportPressed = false;
    /* access modifiers changed from: private */
    public int extraHeight;
    /* access modifiers changed from: private */
    public int extraWidth;
    Bitmap extrasBitmap;
    private Button extrasClose;
    PowerSpinnerView extrasColor;
    private Button extrasColorBg;
    ImageView extrasImageView;
    Bitmap extrasInkBitmap;
    ConstraintLayout extrasLayout;
    private Button extrasOk;
    /* access modifiers changed from: private */
    public boolean extrasOpen = false;
    SeekBar extrasSize;
    Animation fadeIn;
    Animation fadeIn2;
    Animation fadeOut;
    Animation fadeOut2;
    /* access modifiers changed from: private */
    public ImageButton finalAdd1;
    /* access modifiers changed from: private */
    public Button finalBullet;
    ConstraintLayout finalButtonLayout;
    PowerSpinnerView finalColorSpinner;
    /* access modifiers changed from: private */
    public Button finalDeleteButton;
    /* access modifiers changed from: private */
    public Button finalDiagram;
    /* access modifiers changed from: private */
    public ImageView finalDiagramView;
    LinearLayout finalExportButton;
    private EditText finalFilename;
    private Button finalFontBg;
    private Button finalFontColorBg;
    PowerSpinnerView finalFontSpinner;
    /* access modifiers changed from: private */
    public Button finalHeading;
    /* access modifiers changed from: private */
    public ImageView finalImageView;
    private Button finalRenameCancel;
    LinearLayout finalRenameLayout;
    private Button finalRenameOk;
    /* access modifiers changed from: private */
    public Button finalRetakeButton;
    /* access modifiers changed from: private */
    public Button finalScratch;
    boolean finished = true;
    /* access modifiers changed from: private */
    public Toolbar flToolbar;
    TextView fontSizeTv;
    Animation fromBottom;
    String heading;
    private Button headingCancel;
    Button headingEditButton;
    /* access modifiers changed from: private */
    public EditText headingEditText;
    /* access modifiers changed from: private */
    public Button headingEtClose;
    /* access modifiers changed from: private */
    public Button headingEtOk;
    private Button headingOk;
    SeekBar headingSeekBar;
    TextView headingTextView;
    View headingView;
    int imageHeight;
    /* access modifiers changed from: private */
    public boolean imageOpen = false;
    int imageWidth;
    GridView images;
    Bitmap inkBitmap;
    Button inkBlack;
    Button inkBlue;
    HorizontalScrollView inkColorScroll;
    Button inkDarkBlue;
    Button inkDarkRed;
    /* access modifiers changed from: private */
    public Button inkDiagram;
    Button inkGrey;
    Button inkRed;
    TextView lineAlignment;
    SeekBar lineSpacing;
    ImageView loading;
    View loadingBg;
    TextView loadingText;
    private InterstitialAd mInterstitialAd;

    /* renamed from: nx */
    int f1508nx;

    /* renamed from: ny */
    int f1509ny;
    Bitmap originalBitmap;
    /* access modifiers changed from: private */
    public Button originalDiagram;
    Button paintButton;
    LinearLayout paintDiagram;
    /* access modifiers changed from: private */
    public boolean pasting = false;
    LinearLayout redoButton;
    View renameBg;
    /* access modifiers changed from: private */
    public boolean renameLayout = false;
    int saveas;
    private Button scratch1;
    private Button scratch2;
    private Button scratch3;
    private Button scratch4;
    private Button scratch5;
    private Button scratch6;
    private Button scratch7;
    private Button scratch8;
    private Button scratch9;
    /* access modifiers changed from: private */
    public Button scratchClose;
    ImageView scratchImageView;
    LinearLayout scratchLayout;
    int selected;
    Animation toBottom;
    int totalImages;
    /* access modifiers changed from: private */
    public int uRNumber;
    /* access modifiers changed from: private */
    public int uRTotal;
    ArrayList<Bitmap> unReDoImages;
    LinearLayout unRedoLayout;
    LinearLayout undoButton;
    ArrayList<String> uris;
    ArrayList<String> uris2;

    static /* synthetic */ int access$1308(FinalActivity finalActivity) {
        int i = finalActivity.uRNumber;
        finalActivity.uRNumber = i + 1;
        return i;
    }

    static /* synthetic */ int access$1408(FinalActivity finalActivity) {
        int i = finalActivity.uRTotal;
        finalActivity.uRTotal = i + 1;
        return i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2049R.layout.activity_final);
        findViewbyId();
        homeUI();
        this.unReDoImages = new ArrayList<>();
        this.finalImageView.setOnTouchListener(new OnSwipeTouchListener(this));
        this.finalImageView.setVisibility(4);
        extrasColorSpinner();
        finalColorSpinner();
        finalFontSpinner();
        this.extrasClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.extrasColor.dismiss();
                FinalActivity.this.unRedoLayout.setVisibility(0);
                FinalActivity.this.exClose();
                FinalActivity.this.excloseaf();
            }
        });
        this.finalBullet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean unused = FinalActivity.this.extrasOpen = true;
                FinalActivity.this.bullet = true;
                FinalActivity.this.finalButtonLayout.setVisibility(4);
                FinalActivity.this.finalDeleteButton.setVisibility(4);
                FinalActivity.this.headingView.setVisibility(0);
                FinalActivity.this.bulletLayout.setVisibility(0);
                FinalActivity.this.bulletClose.setVisibility(0);
                FinalActivity.this.unRedoLayout.setVisibility(4);
            }
        });
        this.finalHeading.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean unused = FinalActivity.this.extrasOpen = true;
                FinalActivity.this.finalButtonLayout.setVisibility(4);
                FinalActivity.this.finalDeleteButton.setVisibility(4);
                FinalActivity.this.headingView.setVisibility(0);
                FinalActivity.this.headingEditText.setVisibility(0);
                FinalActivity.this.headingEtClose.setVisibility(0);
                FinalActivity.this.headingEtOk.setVisibility(0);
                FinalActivity.this.unRedoLayout.setVisibility(4);
            }
        });
        this.headingEditButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.spinnersDismiss();
                FinalActivity.this.headingTextView.setVisibility(4);
                FinalActivity.this.finalDeleteButton.setVisibility(4);
                FinalActivity.this.headinglayoutclose(4);
                FinalActivity.this.headingView.setVisibility(0);
                FinalActivity.this.headingEditText.setVisibility(0);
                FinalActivity.this.headingEtClose.setVisibility(0);
                FinalActivity.this.headingEtOk.setVisibility(0);
                FinalActivity.this.headingEditText.setText(FinalActivity.this.heading);
            }
        });
        this.headingEtClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean unused = FinalActivity.this.extrasOpen = false;
                FinalActivity.this.headingAction();
                FinalActivity.this.finalButtonLayout.setVisibility(0);
                FinalActivity.this.finalDeleteButton.setVisibility(0);
                FinalActivity.this.unRedoLayout.setVisibility(0);
            }
        });
        this.headingEtOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity finalActivity = FinalActivity.this;
                finalActivity.heading = finalActivity.headingEditText.getText().toString();
                FinalActivity.this.headingTextView.setX((float) ((FinalActivity.this.finalImageView.getWidth() - FinalActivity.this.headingTextView.getWidth()) / 2));
                FinalActivity.this.headingTextView.setY(FinalActivity.this.finalImageView.getY() + ((((float) FinalActivity.this.finalImageView.getHeight()) - FinalActivity.this.headingTextView.getY()) / 2.0f));
                if (!FinalActivity.this.heading.isEmpty()) {
                    FinalActivity.this.headingTextView.setVisibility(0);
                    FinalActivity.this.headingTextView.setText(FinalActivity.this.heading);
                    FinalActivity.this.headinglayoutclose(0);
                    FinalActivity.this.headingAction();
                }
            }
        });
        this.headingCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.spinnersDismiss();
                boolean unused = FinalActivity.this.extrasOpen = false;
                FinalActivity.this.headinglayoutclose(4);
                FinalActivity.this.headingTextView.setVisibility(4);
                FinalActivity.this.finalButtonLayout.setVisibility(0);
                FinalActivity.this.finalDeleteButton.setVisibility(0);
                FinalActivity.this.unRedoLayout.setVisibility(0);
            }
        });
        this.headingOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.spinnersDismiss();
                boolean unused = FinalActivity.this.extrasOpen = false;
                FinalActivity.this.headinglayoutclose(4);
                FinalActivity.this.headingTextView.setVisibility(4);
                FinalActivity.this.loadingBg.setVisibility(0);
                FinalActivity.this.loadingText.setVisibility(0);
                FinalActivity.this.loading.setVisibility(0);
                FinalActivity.this.anim.start();
                boolean unused2 = FinalActivity.this.pasting = true;
                new Thread(new Runnable() {
                    public void run() {
                        FinalActivity.this.headingTextView.setDrawingCacheEnabled(true);
                        FinalActivity.this.headingTextView.buildDrawingCache();
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(FinalActivity.this.headingTextView.getDrawingCache(), FinalActivity.this.headingTextView.getWidth(), FinalActivity.this.headingTextView.getHeight(), false);
                        int x = (int) FinalActivity.this.headingTextView.getX();
                        int y = (int) (FinalActivity.this.headingTextView.getY() - FinalActivity.this.finalImageView.getY());
                        Bitmap createBitmap = Bitmap.createBitmap(FinalActivity.this.drawingBitmap.getWidth(), FinalActivity.this.drawingBitmap.getHeight(), Bitmap.Config.ARGB_8888);
                        for (int i = 0; i < createBitmap.getWidth(); i++) {
                            for (int i2 = 0; i2 < createBitmap.getHeight(); i2++) {
                                int pixel = FinalActivity.this.drawingBitmap.getPixel(i, i2);
                                int red = Color.red(pixel);
                                int blue = Color.blue(pixel);
                                int green = Color.green(pixel);
                                if (i < x || i >= createScaledBitmap.getWidth() + x) {
                                    createBitmap.setPixel(i, i2, Color.argb(255, red, green, blue));
                                } else if (i2 < y || i2 >= createScaledBitmap.getHeight() + y) {
                                    createBitmap.setPixel(i, i2, Color.argb(255, red, green, blue));
                                } else {
                                    int pixel2 = createScaledBitmap.getPixel(i - x, i2 - y);
                                    int red2 = Color.red(pixel2);
                                    int blue2 = Color.blue(pixel2);
                                    int green2 = Color.green(pixel2);
                                    int alpha = Color.alpha(pixel2);
                                    if (alpha > 125) {
                                        createBitmap.setPixel(i, i2, Color.argb(255, red2, green2, blue2));
                                    } else if (alpha < 125) {
                                        createBitmap.setPixel(i, i2, Color.argb(255, red, green, blue));
                                    }
                                }
                            }
                        }
                        FinalActivity.this.finalImageView.setImageBitmap(createBitmap);
                        FinalActivity.this.drawingBitmap = createBitmap;
                        if (FinalActivity.this.uRNumber < FinalActivity.this.uRTotal) {
                            FinalActivity.access$1308(FinalActivity.this);
                            int unused = FinalActivity.this.uRTotal = FinalActivity.this.uRNumber;
                            FinalActivity.this.unReDoImages.set(FinalActivity.this.uRNumber, FinalActivity.this.drawingBitmap);
                        } else {
                            FinalActivity.access$1308(FinalActivity.this);
                            FinalActivity.access$1408(FinalActivity.this);
                            FinalActivity.this.unReDoImages.add(createBitmap);
                        }
                        boolean unused2 = FinalActivity.this.pasting = false;
                    }
                }).start();
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        FinalActivity.this.anim.stop();
                        FinalActivity.this.loadingBg.setVisibility(8);
                        FinalActivity.this.loadingText.setVisibility(8);
                        FinalActivity.this.loading.setVisibility(8);
                        FinalActivity.this.flToolbar.setVisibility(0);
                        FinalActivity.this.finalButtonLayout.setVisibility(0);
                        FinalActivity.this.headingTextView.setDrawingCacheEnabled(false);
                        FinalActivity.this.unRedoLayout.setVisibility(0);
                    }
                }, 3000);
            }
        });
        this.extrasOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.extrasColor.dismiss();
                FinalActivity.this.exClose();
                FinalActivity.this.loadingBg.setVisibility(0);
                FinalActivity.this.loadingText.setVisibility(0);
                FinalActivity.this.loading.setVisibility(0);
                FinalActivity.this.anim.start();
                boolean unused = FinalActivity.this.pasting = true;
                new Thread(new Runnable() {
                    public void run() {
                        float f;
                        float f2;
                        int i;
                        Bitmap bitmap;
                        Bitmap bitmap2 = FinalActivity.this.inkBitmap;
                        if (FinalActivity.this.bullet) {
                            bitmap = Bitmap.createScaledBitmap(FinalActivity.this.extrasInkBitmap, FinalActivity.this.extrasImageView.getWidth(), FinalActivity.this.extrasImageView.getHeight(), false);
                            i = (int) FinalActivity.this.extrasImageView.getX();
                            f2 = FinalActivity.this.extrasImageView.getY();
                            f = FinalActivity.this.finalImageView.getY();
                        } else {
                            bitmap = Bitmap.createScaledBitmap(FinalActivity.this.extrasInkBitmap, FinalActivity.this.scratchImageView.getWidth(), FinalActivity.this.scratchImageView.getHeight(), false);
                            i = (int) FinalActivity.this.scratchImageView.getX();
                            f2 = FinalActivity.this.scratchImageView.getY();
                            f = FinalActivity.this.finalImageView.getY();
                        }
                        int i2 = (int) (f2 - f);
                        Bitmap createBitmap = Bitmap.createBitmap(FinalActivity.this.drawingBitmap.getWidth(), FinalActivity.this.drawingBitmap.getHeight(), Bitmap.Config.ARGB_8888);
                        for (int i3 = 0; i3 < createBitmap.getWidth(); i3++) {
                            for (int i4 = 0; i4 < createBitmap.getHeight(); i4++) {
                                int pixel = FinalActivity.this.drawingBitmap.getPixel(i3, i4);
                                int red = Color.red(pixel);
                                int blue = Color.blue(pixel);
                                int green = Color.green(pixel);
                                if (i3 < i || i3 >= bitmap.getWidth() + i) {
                                    createBitmap.setPixel(i3, i4, Color.argb(255, red, green, blue));
                                } else if (i4 < i2 || i4 >= bitmap.getHeight() + i2) {
                                    createBitmap.setPixel(i3, i4, Color.argb(255, red, green, blue));
                                } else {
                                    int pixel2 = bitmap.getPixel(i3 - i, i4 - i2);
                                    int red2 = Color.red(pixel2);
                                    int blue2 = Color.blue(pixel2);
                                    int green2 = Color.green(pixel2);
                                    int alpha = Color.alpha(pixel2);
                                    if (alpha == 255) {
                                        createBitmap.setPixel(i3, i4, Color.argb(255, red2, green2, blue2));
                                    } else if (alpha == 0) {
                                        createBitmap.setPixel(i3, i4, Color.argb(255, red, green, blue));
                                    }
                                }
                            }
                        }
                        FinalActivity.this.finalImageView.setImageBitmap(createBitmap);
                        FinalActivity.this.drawingBitmap = createBitmap;
                        if (FinalActivity.this.uRNumber < FinalActivity.this.uRTotal) {
                            FinalActivity.access$1308(FinalActivity.this);
                            int unused = FinalActivity.this.uRTotal = FinalActivity.this.uRNumber;
                            FinalActivity.this.unReDoImages.set(FinalActivity.this.uRNumber, FinalActivity.this.drawingBitmap);
                        } else {
                            FinalActivity.access$1308(FinalActivity.this);
                            FinalActivity.access$1408(FinalActivity.this);
                            FinalActivity.this.unReDoImages.add(createBitmap);
                        }
                        boolean unused2 = FinalActivity.this.pasting = false;
                    }
                }).start();
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        FinalActivity.this.anim.stop();
                        FinalActivity.this.loadingBg.setVisibility(8);
                        FinalActivity.this.loadingText.setVisibility(8);
                        FinalActivity.this.loading.setVisibility(8);
                        FinalActivity.this.flToolbar.setVisibility(0);
                        FinalActivity.this.unRedoLayout.setVisibility(0);
                        FinalActivity.this.excloseaf();
                    }
                }, 4000);
            }
        });
        this.diagramOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (FinalActivity.this.diagramAction == 0) {
                    FinalActivity.this.diagramAction = 1;
                    FinalActivity.this.originalDiagram.setVisibility(4);
                    FinalActivity.this.inkDiagram.setVisibility(4);
                    FinalActivity.this.inkColorScroll.setVisibility(4);
                    FinalActivity.this.paintDiagram.setVisibility(0);
                    FinalActivity.this.eraseDiagram.setVisibility(0);
                    FinalActivity.this.eraseLayout.setVisibility(0);
                    FinalActivity.this.eraseLayoutClose.setVisibility(0);
                } else if (FinalActivity.this.diagramAction == 1) {
                    FinalActivity.this.diagramAction = 2;
                    FinalActivity.this.paintDiagram.setVisibility(4);
                    FinalActivity.this.eraseDiagram.setVisibility(4);
                    FinalActivity.this.eraseLayout.setVisibility(4);
                    FinalActivity.this.eraseLayoutClose.setVisibility(4);
                    FinalActivity.this.diagramResize.setVisibility(0);
                    FinalActivity.this.flToolbar.setVisibility(4);
                } else if (FinalActivity.this.diagramAction == 2) {
                    FinalActivity.this.diagramSelected = false;
                    FinalActivity.this.finalDiagramView.setVisibility(4);
                    FinalActivity.this.diagramResize.setVisibility(4);
                    FinalActivity.this.diagramClose.setVisibility(4);
                    FinalActivity.this.diagramOk.setVisibility(4);
                    FinalActivity.this.loadingBg.setVisibility(0);
                    FinalActivity.this.loadingText.setVisibility(0);
                    FinalActivity.this.loading.setVisibility(0);
                    FinalActivity.this.anim.start();
                    boolean unused = FinalActivity.this.pasting = true;
                    new Thread(new Runnable() {
                        public void run() {
                            FinalActivity.this.diagramAction = 0;
                            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(FinalActivity.this.changeabliBitmap, FinalActivity.this.finalDiagramView.getWidth(), FinalActivity.this.finalDiagramView.getHeight(), false);
                            Bitmap createBitmap = Bitmap.createBitmap(FinalActivity.this.drawingBitmap.getWidth(), FinalActivity.this.drawingBitmap.getHeight(), Bitmap.Config.ARGB_8888);
                            int x = (int) FinalActivity.this.finalDiagramView.getX();
                            int y = (int) (FinalActivity.this.finalDiagramView.getY() - FinalActivity.this.finalImageView.getY());
                            for (int i = 0; i < createBitmap.getWidth(); i++) {
                                for (int i2 = 0; i2 < createBitmap.getHeight(); i2++) {
                                    int pixel = FinalActivity.this.drawingBitmap.getPixel(i, i2);
                                    int red = Color.red(pixel);
                                    int blue = Color.blue(pixel);
                                    int green = Color.green(pixel);
                                    if (i < x || i >= createScaledBitmap.getWidth() + x) {
                                        createBitmap.setPixel(i, i2, Color.argb(255, red, green, blue));
                                    } else if (i2 < y || i2 >= createScaledBitmap.getHeight() + y) {
                                        createBitmap.setPixel(i, i2, Color.argb(255, red, green, blue));
                                    } else {
                                        int pixel2 = createScaledBitmap.getPixel(i - x, i2 - y);
                                        int red2 = Color.red(pixel2);
                                        int blue2 = Color.blue(pixel2);
                                        int green2 = Color.green(pixel2);
                                        int alpha = Color.alpha(pixel2);
                                        if (alpha == 255) {
                                            createBitmap.setPixel(i, i2, Color.argb(255, red2, green2, blue2));
                                        } else if (alpha == 0) {
                                            createBitmap.setPixel(i, i2, Color.argb(255, red, green, blue));
                                        } else {
                                            createBitmap.setPixel(i, i2, Color.argb(255, ((red + red2) + alpha) / 3, ((green + green2) + alpha) / 3, ((blue + blue2) + alpha) / 3));
                                        }
                                    }
                                }
                            }
                            if (FinalActivity.this.uRNumber < FinalActivity.this.uRTotal) {
                                FinalActivity.access$1308(FinalActivity.this);
                                int unused = FinalActivity.this.uRTotal = FinalActivity.this.uRNumber;
                                FinalActivity.this.unReDoImages.set(FinalActivity.this.uRNumber, FinalActivity.this.drawingBitmap);
                            } else {
                                FinalActivity.access$1308(FinalActivity.this);
                                FinalActivity.access$1408(FinalActivity.this);
                                FinalActivity.this.unReDoImages.add(createBitmap);
                            }
                            FinalActivity.this.drawingBitmap = createBitmap;
                            FinalActivity.this.finalImageView.setImageBitmap(createBitmap);
                            boolean unused2 = FinalActivity.this.pasting = false;
                        }
                    }).start();
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            FinalActivity.this.anim.stop();
                            FinalActivity.this.loadingBg.setVisibility(8);
                            FinalActivity.this.loadingText.setVisibility(8);
                            FinalActivity.this.loading.setVisibility(8);
                            FinalActivity.this.finalBullet.setVisibility(4);
                            FinalActivity.this.finalHeading.setVisibility(4);
                            FinalActivity.this.finalScratch.setVisibility(4);
                            FinalActivity.this.finalDeleteButton.setVisibility(0);
                            FinalActivity.this.finalRetakeButton.setVisibility(0);
                            FinalActivity.this.finalDiagram.setVisibility(0);
                            FinalActivity.this.flToolbar.setVisibility(0);
                            FinalActivity.this.unRedoLayout.setVisibility(0);
                        }
                    }, 5000);
                }
            }
        });
        this.finalScratch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.bullet = false;
                FinalActivity.this.finalButtonLayout.setVisibility(4);
                FinalActivity.this.finalDeleteButton.setVisibility(4);
                FinalActivity.this.headingView.setVisibility(0);
                FinalActivity.this.scratchLayout.setVisibility(0);
                FinalActivity.this.scratchClose.setVisibility(0);
                FinalActivity.this.unRedoLayout.setVisibility(4);
            }
        });
        this.bulletClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.bullet = false;
                FinalActivity.this.finalButtonLayout.setVisibility(0);
                FinalActivity.this.finalDeleteButton.setVisibility(0);
                FinalActivity.this.headingView.setVisibility(4);
                FinalActivity.this.bulletLayout.setVisibility(4);
                FinalActivity.this.bulletClose.setVisibility(4);
                FinalActivity.this.unRedoLayout.setVisibility(0);
            }
        });
        this.scratchClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.bullet = false;
                FinalActivity.this.finalButtonLayout.setVisibility(0);
                FinalActivity.this.finalDeleteButton.setVisibility(0);
                FinalActivity.this.headingView.setVisibility(4);
                FinalActivity.this.scratchLayout.setVisibility(4);
                FinalActivity.this.scratchClose.setVisibility(4);
                FinalActivity.this.unRedoLayout.setVisibility(0);
            }
        });
        bulletScratckOnClick();
        this.extrasImageView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getRawX() > ((float) (FinalActivity.this.extrasImageView.getWidth() / 2)) && motionEvent.getRawX() < ((float) (FinalActivity.this.finalImageView.getWidth() - (FinalActivity.this.extrasImageView.getWidth() / 2)))) {
                    FinalActivity.this.extrasImageView.setX(motionEvent.getRawX() - ((float) (FinalActivity.this.extrasImageView.getWidth() / 2)));
                }
                if (motionEvent.getRawY() <= FinalActivity.this.finalImageView.getY() + ((float) (FinalActivity.this.extrasImageView.getHeight() / 2)) || motionEvent.getRawY() >= (FinalActivity.this.finalImageView.getY() + ((float) FinalActivity.this.finalImageView.getHeight())) - ((float) (FinalActivity.this.extrasImageView.getHeight() / 2))) {
                    return true;
                }
                FinalActivity.this.extrasImageView.setY(motionEvent.getRawY() - ((float) (FinalActivity.this.extrasImageView.getHeight() / 2)));
                return true;
            }
        });
        this.scratchImageView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getRawX() > ((float) (FinalActivity.this.scratchImageView.getWidth() / 2)) && motionEvent.getRawX() < ((float) (FinalActivity.this.finalImageView.getWidth() - (FinalActivity.this.scratchImageView.getWidth() / 2)))) {
                    FinalActivity.this.scratchImageView.setX(motionEvent.getRawX() - ((float) (FinalActivity.this.scratchImageView.getWidth() / 2)));
                }
                if (motionEvent.getRawY() <= FinalActivity.this.finalImageView.getY() + ((float) (FinalActivity.this.scratchImageView.getHeight() / 2)) || motionEvent.getRawY() >= (FinalActivity.this.finalImageView.getY() + ((float) FinalActivity.this.finalImageView.getHeight())) - ((float) (FinalActivity.this.scratchImageView.getHeight() / 2))) {
                    return true;
                }
                FinalActivity.this.scratchImageView.setY(motionEvent.getRawY() - ((float) (FinalActivity.this.scratchImageView.getHeight() / 2)));
                return true;
            }
        });
        this.headingTextView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getRawX() > ((float) (FinalActivity.this.headingTextView.getWidth() / 2)) && motionEvent.getRawX() < ((float) (FinalActivity.this.finalImageView.getWidth() - (FinalActivity.this.headingTextView.getWidth() / 2)))) {
                    FinalActivity.this.headingTextView.setX(motionEvent.getRawX() - ((float) (FinalActivity.this.headingTextView.getWidth() / 2)));
                }
                if (motionEvent.getRawY() <= FinalActivity.this.finalImageView.getY() + ((float) (FinalActivity.this.headingTextView.getHeight() / 2)) || motionEvent.getRawY() >= (FinalActivity.this.finalImageView.getY() + ((float) FinalActivity.this.finalImageView.getHeight())) - ((float) (FinalActivity.this.headingTextView.getHeight() / 2))) {
                    return true;
                }
                FinalActivity.this.headingTextView.setY(motionEvent.getRawY() - ((float) (FinalActivity.this.headingTextView.getHeight() / 2)));
                return true;
            }
        });
        this.finalDeleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.delete();
            }
        });
        this.finalRetakeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.retake();
            }
        });
        this.finalExportButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.exportLayoutAnimation();
            }
        });
        this.exportPdf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.exportLayoutAnimation();
                FinalActivity.this.exportAsPdf();
            }
        });
        this.exportImages.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.exportLayoutAnimation();
                FinalActivity.this.exportAsImages();
            }
        });
        this.finalRenameLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        this.finalRenameCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.renameCancel();
            }
        });
        this.finalRenameOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.exportAsWhatever();
                FinalActivity.this.renameOk();
            }
        });
        this.renameBg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.renameBg();
                boolean unused = FinalActivity.this.renameLayout = false;
            }
        });
        this.exportBg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.exportLayoutAnimation();
            }
        });
        this.diagramResize.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                motionEvent.getAction();
                int x = (int) FinalActivity.this.finalDiagramView.getX();
                int y = (int) FinalActivity.this.finalDiagramView.getY();
                int i = y + 300;
                float f = (float) (x + 300);
                if (motionEvent.getRawX() > f && motionEvent.getRawY() > ((float) i) && FinalActivity.this.finalDiagramView.getY() > FinalActivity.this.finalImageView.getY() && FinalActivity.this.diagramResize.getY() < FinalActivity.this.flToolbar.getY()) {
                    FinalActivity.this.diagramResize.setX((float) ((int) (motionEvent.getRawX() - ((float) (FinalActivity.this.diagramResize.getWidth() / 2)))));
                    FinalActivity.this.diagramResize.setY((float) ((int) (motionEvent.getRawY() - ((float) FinalActivity.this.diagramResize.getHeight()))));
                    ViewGroup.LayoutParams layoutParams = FinalActivity.this.finalDiagramView.getLayoutParams();
                    layoutParams.width = (((int) motionEvent.getRawX()) - x) + (FinalActivity.this.diagramResize.getWidth() / 2);
                    layoutParams.height = (((int) motionEvent.getRawY()) - y) - FinalActivity.this.diagramResize.getHeight();
                    FinalActivity.this.finalDiagramView.setLayoutParams(layoutParams);
                    return true;
                } else if (motionEvent.getRawX() > f && motionEvent.getRawY() < ((float) i)) {
                    FinalActivity.this.diagramResize.setX((float) ((int) (motionEvent.getRawX() - ((float) (FinalActivity.this.diagramResize.getWidth() / 2)))));
                    ViewGroup.LayoutParams layoutParams2 = FinalActivity.this.finalDiagramView.getLayoutParams();
                    layoutParams2.width = (((int) motionEvent.getRawX()) - x) - (FinalActivity.this.diagramResize.getWidth() / 2);
                    FinalActivity.this.finalDiagramView.setLayoutParams(layoutParams2);
                    return true;
                } else if (motionEvent.getRawX() < f && motionEvent.getRawY() > ((float) i)) {
                    FinalActivity.this.diagramResize.setY((float) ((int) (motionEvent.getRawY() - ((float) FinalActivity.this.diagramResize.getHeight()))));
                    ViewGroup.LayoutParams layoutParams3 = FinalActivity.this.finalDiagramView.getLayoutParams();
                    layoutParams3.height = (((int) motionEvent.getRawY()) - y) - FinalActivity.this.diagramResize.getHeight();
                    FinalActivity.this.finalDiagramView.setLayoutParams(layoutParams3);
                    return true;
                } else if (FinalActivity.this.diagramResize.getY() > FinalActivity.this.flToolbar.getY() && motionEvent.getRawY() < FinalActivity.this.flToolbar.getY()) {
                    FinalActivity.this.diagramResize.setX((float) ((int) (motionEvent.getRawX() - ((float) (FinalActivity.this.diagramResize.getWidth() / 2)))));
                    FinalActivity.this.diagramResize.setY((float) ((int) (motionEvent.getRawY() - ((float) FinalActivity.this.diagramResize.getHeight()))));
                    ViewGroup.LayoutParams layoutParams4 = FinalActivity.this.finalDiagramView.getLayoutParams();
                    layoutParams4.width = (((int) motionEvent.getRawX()) - x) + (FinalActivity.this.diagramResize.getWidth() / 2);
                    layoutParams4.height = (((int) motionEvent.getRawY()) - y) - FinalActivity.this.diagramResize.getHeight();
                    FinalActivity.this.finalDiagramView.setLayoutParams(layoutParams4);
                    return true;
                } else if (FinalActivity.this.finalDiagramView.getY() >= FinalActivity.this.finalImageView.getY() || motionEvent.getRawY() >= FinalActivity.this.diagramResize.getY() || motionEvent.getRawY() <= ((float) i)) {
                    return true;
                } else {
                    FinalActivity.this.diagramResize.setX((float) ((int) (motionEvent.getRawX() - ((float) (FinalActivity.this.diagramResize.getWidth() / 2)))));
                    FinalActivity.this.diagramResize.setY((float) ((int) (motionEvent.getRawY() - ((float) FinalActivity.this.diagramResize.getHeight()))));
                    ViewGroup.LayoutParams layoutParams5 = FinalActivity.this.finalDiagramView.getLayoutParams();
                    layoutParams5.width = (((int) motionEvent.getRawX()) - x) + (FinalActivity.this.diagramResize.getWidth() / 2);
                    layoutParams5.height = (((int) motionEvent.getRawY()) - y) - FinalActivity.this.diagramResize.getHeight();
                    FinalActivity.this.finalDiagramView.setLayoutParams(layoutParams5);
                    return true;
                }
            }
        });
        this.finalDiagramView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    FinalActivity.this.f1508nx = (int) motionEvent.getX();
                    FinalActivity.this.f1509ny = (int) motionEvent.getY();
                }
                if (motionEvent.getAction() == 2) {
                    if (FinalActivity.this.diagramAction == 1) {
                        int x = (int) (motionEvent.getX() - ((float) FinalActivity.this.brushSizeValue));
                        int y = (int) (motionEvent.getY() - ((float) FinalActivity.this.brushSizeValue));
                        int x2 = (int) (motionEvent.getX() + ((float) FinalActivity.this.brushSizeValue));
                        int y2 = (int) (motionEvent.getY() + ((float) FinalActivity.this.brushSizeValue));
                        if (FinalActivity.this.erase) {
                            if (FinalActivity.this.finished) {
                                while (x <= x2) {
                                    for (int i = y; i <= y2; i++) {
                                        if (x >= 0 && x < FinalActivity.this.changeabliBitmap.getWidth() && i >= 0 && i < FinalActivity.this.changeabliBitmap.getHeight()) {
                                            int pixel = FinalActivity.this.changeabliBitmap.getPixel(x, i);
                                            int red = Color.red(pixel);
                                            int blue = Color.blue(pixel);
                                            int green = Color.green(pixel);
                                            int alpha = Color.alpha(pixel);
                                            int i2 = 0;
                                            if (FinalActivity.this.brushOpacity == 100) {
                                                FinalActivity.this.changeabliBitmap.setPixel(x, i, Color.argb(0, 0, 0, 0));
                                            } else {
                                                int i3 = alpha - FinalActivity.this.brushOpacity;
                                                int i4 = red - (red / FinalActivity.this.brushOpacity);
                                                int i5 = green - (green / FinalActivity.this.brushOpacity);
                                                int i6 = blue - (blue / FinalActivity.this.brushOpacity);
                                                if (i3 <= 0) {
                                                    i3 = 0;
                                                    i4 = 0;
                                                    i6 = 0;
                                                    i5 = 0;
                                                }
                                                if (i4 < 0) {
                                                    i4 = 0;
                                                }
                                                if (i5 < 0) {
                                                    i5 = 0;
                                                }
                                                if (i6 >= 0) {
                                                    i2 = i6;
                                                }
                                                FinalActivity.this.changeabliBitmap.setPixel(x, i, Color.argb(i3, i4, i5, i2));
                                            }
                                        }
                                    }
                                    x++;
                                }
                                FinalActivity.this.finalDiagramView.setBackground(new BitmapDrawable(FinalActivity.this.getResources(), FinalActivity.this.changeabliBitmap));
                                FinalActivity.this.finished = true;
                            }
                        } else if (FinalActivity.this.finished) {
                            while (x <= x2) {
                                for (int i7 = y; i7 <= y2; i7++) {
                                    if (x >= 0 && x < FinalActivity.this.changeabliBitmap.getWidth() && i7 >= 0 && i7 < FinalActivity.this.changeabliBitmap.getHeight()) {
                                        int alpha2 = Color.alpha(FinalActivity.this.changeabliBitmap.getPixel(x, i7));
                                        int pixel2 = FinalActivity.this.originalBitmap.getPixel(x, i7);
                                        int red2 = Color.red(pixel2);
                                        int blue2 = Color.blue(pixel2);
                                        int green2 = Color.green(pixel2);
                                        int i8 = 255;
                                        int alpha3 = alpha2 + ((Color.alpha(pixel2) * FinalActivity.this.brushOpacity) / 255);
                                        if (alpha3 <= 255) {
                                            i8 = alpha3;
                                        }
                                        FinalActivity.this.changeabliBitmap.setPixel(x, i7, Color.argb(i8, red2, green2, blue2));
                                    }
                                }
                                x++;
                            }
                            FinalActivity.this.finalDiagramView.setBackground(new BitmapDrawable(FinalActivity.this.getResources(), FinalActivity.this.changeabliBitmap));
                            FinalActivity.this.finished = true;
                        }
                    } else if (FinalActivity.this.diagramAction == 2 || FinalActivity.this.diagramAction == 0) {
                        int x3 = (int) motionEvent.getX();
                        int y3 = (int) motionEvent.getY();
                        int x4 = (int) FinalActivity.this.finalDiagramView.getX();
                        int y4 = (int) FinalActivity.this.finalDiagramView.getY();
                        int x5 = (int) FinalActivity.this.finalImageView.getX();
                        int y5 = (int) FinalActivity.this.finalImageView.getY();
                        int width = FinalActivity.this.finalDiagramView.getWidth();
                        int height = FinalActivity.this.finalDiagramView.getHeight();
                        int width2 = FinalActivity.this.finalImageView.getWidth();
                        int height2 = FinalActivity.this.finalImageView.getHeight();
                        if (x4 > x5 && x4 + width < x5 + width2) {
                            FinalActivity.this.finalDiagramView.setX((float) ((x3 - FinalActivity.this.f1508nx) + x4));
                        }
                        if (y4 > y5 && y5 + height2 > y4 + height) {
                            FinalActivity.this.finalDiagramView.setY((float) ((y4 + y3) - FinalActivity.this.f1509ny));
                        }
                        if (x4 <= x5 && x3 > FinalActivity.this.f1508nx) {
                            FinalActivity.this.finalDiagramView.setX((float) ((x3 - FinalActivity.this.f1508nx) + x4));
                        } else if (width + x4 >= x5 + width2 && FinalActivity.this.f1508nx > x3) {
                            FinalActivity.this.finalDiagramView.setX((float) ((x3 - FinalActivity.this.f1508nx) + x4));
                        }
                        if (y4 <= y5 && y3 > FinalActivity.this.f1509ny) {
                            FinalActivity.this.finalDiagramView.setY((float) ((y4 + y3) - FinalActivity.this.f1509ny));
                        } else if (height + y4 >= y5 + height2 && y3 < FinalActivity.this.f1509ny) {
                            FinalActivity.this.finalDiagramView.setY((float) ((y4 + y3) - FinalActivity.this.f1509ny));
                        }
                        FinalActivity.this.diagramClose.setX(FinalActivity.this.finalDiagramView.getX());
                        FinalActivity.this.diagramClose.setY(FinalActivity.this.finalDiagramView.getY() - ((float) FinalActivity.this.diagramClose.getHeight()));
                        FinalActivity.this.diagramOk.setX((FinalActivity.this.finalDiagramView.getX() + ((float) FinalActivity.this.finalDiagramView.getWidth())) - ((float) FinalActivity.this.diagramOk.getWidth()));
                        FinalActivity.this.diagramOk.setY(FinalActivity.this.finalDiagramView.getY() - ((float) FinalActivity.this.diagramOk.getHeight()));
                        FinalActivity.this.diagramResize.setX((FinalActivity.this.finalDiagramView.getX() + ((float) FinalActivity.this.finalDiagramView.getWidth())) - ((float) FinalActivity.this.diagramResize.getWidth()));
                        FinalActivity.this.diagramResize.setY(FinalActivity.this.finalDiagramView.getY() + ((float) FinalActivity.this.finalDiagramView.getHeight()));
                    }
                }
                return true;
            }
        });
        this.diagramClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.diagramSelected = false;
                FinalActivity.this.diagramClose();
            }
        });
        this.finalAdd1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.addMoreImages();
            }
        });
        this.capturedImages = new ArrayList<>();
        this.uris = new ArrayList<>();
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("capturedImages");
        this.uris = stringArrayListExtra;
        this.uris2 = stringArrayListExtra;
        this.totalImages = stringArrayListExtra.size();
        for (int i = 0; i < this.uris.size(); i++) {
            this.capturedImages.add(BitmapFactory.decodeFile(this.uris.get(i)));
        }
        this.images.setAdapter(new customAdapter());
        this.finalDiagram.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.unRedoLayout.setVisibility(4);
                FinalActivity.this.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 120);
            }
        });
        this.originalDiagram.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.originalDiagram();
            }
        });
        this.inkDiagram.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.inkColorScroll.setVisibility(0);
            }
        });
        inkButtonsListener();
        this.paintDiagram.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.paint();
            }
        });
        this.paintButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.paint();
            }
        });
        this.eraseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.erase();
            }
        });
        this.eraseDiagram.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.erase();
            }
        });
        this.eraseLayoutClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.eraseLayout.setVisibility(4);
                FinalActivity.this.eraseLayoutClose.setVisibility(4);
            }
        });
        this.brushHardness.setMin(10);
        this.brushHardness.setMax(100);
        this.brushSize.setMin(20);
        this.brushSize.setMax(100);
        this.extrasSize.setMin(0);
        this.extrasSize.setMax(150);
        this.headingSeekBar.setMin(40);
        this.headingSeekBar.setMax(140);
        this.lineSpacing.setMin(1);
        this.lineSpacing.setMax(100);
        seekbarListeners();
        this.undoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.undoAction();
            }
        });
        this.redoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.redoAction();
            }
        });
    }

    private void findViewbyId() {
        this.images = (GridView) findViewById(C2049R.C2052id.imagesGrid);
        this.finalImageView = (ImageView) findViewById(C2049R.C2052id.finalImageView);
        this.finalDeleteButton = (Button) findViewById(C2049R.C2052id.finaldelete);
        this.finalRetakeButton = (Button) findViewById(C2049R.C2052id.finalretake);
        this.finalBullet = (Button) findViewById(C2049R.C2052id.finalBullet);
        this.finalHeading = (Button) findViewById(C2049R.C2052id.finalHeading);
        this.finalScratch = (Button) findViewById(C2049R.C2052id.finalScratch);
        this.finalExportButton = (LinearLayout) findViewById(C2049R.C2052id.finalExport);
        this.flToolbar = (Toolbar) findViewById(C2049R.C2052id.fltoolbar);
        this.finalAdd1 = (ImageButton) findViewById(C2049R.C2052id.finaladd1);
        this.exportImages = (Button) findViewById(C2049R.C2052id.exportImages);
        this.exportPdf = (Button) findViewById(C2049R.C2052id.exportPdf);
        this.exportLayout = (LinearLayout) findViewById(C2049R.C2052id.exportLayout);
        this.finalRenameLayout = (LinearLayout) findViewById(C2049R.C2052id.finalrenamelayout);
        this.finalFilename = (EditText) findViewById(C2049R.C2052id.finalfilename);
        this.finalRenameOk = (Button) findViewById(C2049R.C2052id.finalrenameok);
        this.finalRenameCancel = (Button) findViewById(C2049R.C2052id.finalrenamecancel);
        this.renameBg = findViewById(C2049R.C2052id.renameBackground2);
        this.exportBg = findViewById(C2049R.C2052id.exportBackground22);
        this.finalDiagramView = (ImageView) findViewById(C2049R.C2052id.finalDiagramView);
        this.diagramClose = (Button) findViewById(C2049R.C2052id.cancelDiagram);
        this.diagramResize = (Button) findViewById(C2049R.C2052id.finalDragButton);
        this.finalDiagram = (Button) findViewById(C2049R.C2052id.finaldiagram);
        this.diagramOk = (Button) findViewById(C2049R.C2052id.okDiagram);
        this.originalDiagram = (Button) findViewById(C2049R.C2052id.originalDiagram);
        this.inkDiagram = (Button) findViewById(C2049R.C2052id.inkDiagram);
        ImageView imageView = (ImageView) findViewById(C2049R.C2052id.loadingImageView2);
        this.loading = imageView;
        this.anim = (AnimationDrawable) imageView.getDrawable();
        this.loadingBg = findViewById(C2049R.C2052id.loadingBG2);
        this.loadingText = (TextView) findViewById(C2049R.C2052id.loadingTextView2);
        this.fromBottom = AnimationUtils.loadAnimation(this, C2049R.anim.from_bottom_original_size);
        this.toBottom = AnimationUtils.loadAnimation(this, C2049R.anim.to_bottom_original_size);
        this.fadeIn2 = AnimationUtils.loadAnimation(this, C2049R.anim.fadein_slow);
        this.fadeOut2 = AnimationUtils.loadAnimation(this, C2049R.anim.fadeout_slow);
        this.fadeIn = AnimationUtils.loadAnimation(this, C2049R.anim.fadein);
        this.fadeOut = AnimationUtils.loadAnimation(this, C2049R.anim.fadeout);
        this.inkColorScroll = (HorizontalScrollView) findViewById(C2049R.C2052id.inkColorScroll);
        this.inkBlack = (Button) findViewById(C2049R.C2052id.ink_Colour_Black);
        this.inkGrey = (Button) findViewById(C2049R.C2052id.ink_Colour_Grey);
        this.inkBlue = (Button) findViewById(C2049R.C2052id.ink_Color_Blue);
        this.inkDarkBlue = (Button) findViewById(C2049R.C2052id.ink_Colour_DarkBlue);
        this.inkRed = (Button) findViewById(C2049R.C2052id.ink_Colour_Red);
        this.inkDarkRed = (Button) findViewById(C2049R.C2052id.ink_Colour_DarkRed);
        this.eraseLayout = (LinearLayout) findViewById(C2049R.C2052id.eraseLayout);
        this.brushHardness = (SeekBar) findViewById(C2049R.C2052id.brushHardness);
        this.paintDiagram = (LinearLayout) findViewById(C2049R.C2052id.paintDiagram);
        this.eraseDiagram = (LinearLayout) findViewById(C2049R.C2052id.eraseDiagram);
        this.brushSize = (SeekBar) findViewById(C2049R.C2052id.brushSize);
        this.eraseLayoutClose = (ImageButton) findViewById(C2049R.C2052id.eraseLayoutClose);
        this.eraseButton = (Button) findViewById(C2049R.C2052id.eraseButton);
        this.paintButton = (Button) findViewById(C2049R.C2052id.paintButton);
        this.headingEditText = (EditText) findViewById(C2049R.C2052id.headingEditText);
        this.headingView = findViewById(C2049R.C2052id.headingView);
        this.headingEtClose = (Button) findViewById(C2049R.C2052id.headingEtClose);
        this.headingEtOk = (Button) findViewById(C2049R.C2052id.headingEtOk);
        this.headingTextView = (TextView) findViewById(C2049R.C2052id.headingTextView);
        this.bulletLayout = (LinearLayout) findViewById(C2049R.C2052id.bulletLayout);
        this.bullet1 = (Button) findViewById(C2049R.C2052id.bullet1);
        this.bullet2 = (Button) findViewById(C2049R.C2052id.bullet2);
        this.bullet3 = (Button) findViewById(C2049R.C2052id.bullet3);
        this.bullet4 = (Button) findViewById(C2049R.C2052id.bullet4);
        this.bullet5 = (Button) findViewById(C2049R.C2052id.bullet5);
        this.bullet6 = (Button) findViewById(C2049R.C2052id.bullet6);
        this.bullet7 = (Button) findViewById(C2049R.C2052id.bullet7);
        this.bullet8 = (Button) findViewById(C2049R.C2052id.bullet8);
        this.bullet9 = (Button) findViewById(C2049R.C2052id.bullet9);
        this.bulletClose = (Button) findViewById(C2049R.C2052id.bulletClose);
        this.scratchLayout = (LinearLayout) findViewById(C2049R.C2052id.scratchLayout);
        this.scratch1 = (Button) findViewById(C2049R.C2052id.scratch1);
        this.scratch2 = (Button) findViewById(C2049R.C2052id.scratch2);
        this.scratch3 = (Button) findViewById(C2049R.C2052id.scratch3);
        this.scratch4 = (Button) findViewById(C2049R.C2052id.scratch4);
        this.scratch5 = (Button) findViewById(C2049R.C2052id.scratch5);
        this.scratch6 = (Button) findViewById(C2049R.C2052id.scratch6);
        this.scratch7 = (Button) findViewById(C2049R.C2052id.scratch7);
        this.scratch8 = (Button) findViewById(C2049R.C2052id.scratch8);
        this.scratch9 = (Button) findViewById(C2049R.C2052id.scratch9);
        this.scratchClose = (Button) findViewById(C2049R.C2052id.scratchClose);
        this.scratchImageView = (ImageView) findViewById(C2049R.C2052id.extrasImageView2);
        this.headingSeekBar = (SeekBar) findViewById(C2049R.C2052id.finalFontSize);
        this.finalFontSpinner = (PowerSpinnerView) findViewById(C2049R.C2052id.finalFont);
        this.finalColorSpinner = (PowerSpinnerView) findViewById(C2049R.C2052id.finalFontColor);
        this.finalFontBg = (Button) findViewById(C2049R.C2052id.finalFontBg);
        this.headingOk = (Button) findViewById(C2049R.C2052id.headingOk);
        this.headingCancel = (Button) findViewById(C2049R.C2052id.headingCancel);
        this.fontSizeTv = (TextView) findViewById(C2049R.C2052id.fontSizeTv);
        this.finalFontColorBg = (Button) findViewById(C2049R.C2052id.finalFontColorBg);
        this.extrasImageView = (ImageView) findViewById(C2049R.C2052id.extrasImageView);
        this.extrasLayout = (ConstraintLayout) findViewById(C2049R.C2052id.extrasLayout);
        this.finalButtonLayout = (ConstraintLayout) findViewById(C2049R.C2052id.finalButtonsLayout);
        this.extrasClose = (Button) findViewById(C2049R.C2052id.extrasCancel);
        this.extrasOk = (Button) findViewById(C2049R.C2052id.extrasOk);
        this.extrasColor = (PowerSpinnerView) findViewById(C2049R.C2052id.extrasColor);
        this.extrasSize = (SeekBar) findViewById(C2049R.C2052id.extrasSize);
        this.extrasColorBg = (Button) findViewById(C2049R.C2052id.extrasColorBg);
        this.lineAlignment = (TextView) findViewById(C2049R.C2052id.lineSacingTv);
        this.lineSpacing = (SeekBar) findViewById(C2049R.C2052id.finalLineSpacing);
        this.headingEditButton = (Button) findViewById(C2049R.C2052id.headingEditButton);
        this.undoButton = (LinearLayout) findViewById(C2049R.C2052id.undoButton);
        this.redoButton = (LinearLayout) findViewById(C2049R.C2052id.redoButton);
        this.unRedoLayout = (LinearLayout) findViewById(C2049R.C2052id.unRedoLayout);
        setSupportActionBar((Toolbar) findViewById(C2049R.C2052id.finaltoolbar1));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle((CharSequence) "");
    }

    private void inkButtonsListener() {
        this.inkBlack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.inkDiagram(0, 0, 0);
            }
        });
        this.inkGrey.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.inkDiagram(80, 80, 80);
            }
        });
        this.inkBlue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.inkDiagram(0, 68, 170);
            }
        });
        this.inkDarkBlue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.inkDiagram(22, 38, 119);
            }
        });
        this.inkRed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.inkDiagram(255, 34, 34);
            }
        });
        this.inkDarkRed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FinalActivity.this.inkDiagram(153, 0, 0);
            }
        });
    }

    private void seekbarListeners() {
        this.extrasSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (FinalActivity.this.bullet) {
                    ViewGroup.LayoutParams layoutParams = FinalActivity.this.extrasImageView.getLayoutParams();
                    layoutParams.height = FinalActivity.this.extraHeight + i;
                    layoutParams.width = FinalActivity.this.extraWidth + i;
                    FinalActivity.this.extrasImageView.setLayoutParams(layoutParams);
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = FinalActivity.this.scratchImageView.getLayoutParams();
                int i2 = i * 2;
                layoutParams2.height = FinalActivity.this.extraHeight + i2;
                layoutParams2.width = FinalActivity.this.extraWidth + i2;
                FinalActivity.this.scratchImageView.setLayoutParams(layoutParams2);
            }
        });
        this.headingSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                FinalActivity.this.headingTextView.setTextSize(0, (float) seekBar.getProgress());
            }
        });
        this.lineSpacing.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                FinalActivity.this.headingTextView.setLineSpacing((float) i, 1.0f);
            }
        });
        this.brushHardness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                FinalActivity.this.brushOpacity = i;
            }
        });
        this.brushSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                FinalActivity.this.brushSizeValue = i;
            }
        });
    }

    private void bulletScratckOnClick() {
        this.bullet1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bitmap decodeResource = BitmapFactory.decodeResource(FinalActivity.this.getResources(), C2049R.C2051drawable.hstar1);
                FinalActivity.this.extrasBitmap = Bitmap.createScaledBitmap(decodeResource, decodeResource.getWidth(), decodeResource.getHeight(), false);
                FinalActivity finalActivity = FinalActivity.this;
                finalActivity.extrasInkBitmap = Bitmap.createBitmap(finalActivity.extrasBitmap.getWidth(), FinalActivity.this.extrasBitmap.getHeight(), FinalActivity.this.extrasBitmap.getConfig());
                FinalActivity finalActivity2 = FinalActivity.this;
                finalActivity2.inkExtra(finalActivity2.extrasBitmap, 0, 0, 0);
                FinalActivity.this.bulletVisibility();
            }
        });
        this.bullet2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bitmap decodeResource = BitmapFactory.decodeResource(FinalActivity.this.getResources(), C2049R.C2051drawable.hstar2);
                FinalActivity.this.extrasBitmap = Bitmap.createScaledBitmap(decodeResource, decodeResource.getWidth(), decodeResource.getHeight(), false);
                FinalActivity finalActivity = FinalActivity.this;
                finalActivity.extrasInkBitmap = Bitmap.createBitmap(finalActivity.extrasBitmap.getWidth(), FinalActivity.this.extrasBitmap.getHeight(), FinalActivity.this.extrasBitmap.getConfig());
                FinalActivity finalActivity2 = FinalActivity.this;
                finalActivity2.inkExtra(finalActivity2.extrasBitmap, 0, 0, 0);
                FinalActivity.this.bulletVisibility();
            }
        });
        this.bullet3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bitmap decodeResource = BitmapFactory.decodeResource(FinalActivity.this.getResources(), C2049R.C2051drawable.hstar3);
                FinalActivity.this.extrasBitmap = Bitmap.createScaledBitmap(decodeResource, decodeResource.getWidth(), decodeResource.getHeight(), false);
                FinalActivity finalActivity = FinalActivity.this;
                finalActivity.extrasInkBitmap = Bitmap.createBitmap(finalActivity.extrasBitmap.getWidth(), FinalActivity.this.extrasBitmap.getHeight(), FinalActivity.this.extrasBitmap.getConfig());
                FinalActivity.this.bulletVisibility();
                FinalActivity finalActivity2 = FinalActivity.this;
                finalActivity2.inkExtra(finalActivity2.extrasBitmap, 0, 0, 0);
            }
        });
        this.bullet4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bitmap decodeResource = BitmapFactory.decodeResource(FinalActivity.this.getResources(), C2049R.C2051drawable.harrow1);
                FinalActivity.this.extrasBitmap = Bitmap.createScaledBitmap(decodeResource, decodeResource.getWidth(), decodeResource.getHeight(), false);
                FinalActivity finalActivity = FinalActivity.this;
                finalActivity.extrasInkBitmap = Bitmap.createBitmap(finalActivity.extrasBitmap.getWidth(), FinalActivity.this.extrasBitmap.getHeight(), FinalActivity.this.extrasBitmap.getConfig());
                FinalActivity.this.bulletVisibility();
                FinalActivity finalActivity2 = FinalActivity.this;
                finalActivity2.inkExtra(finalActivity2.extrasBitmap, 0, 0, 0);
            }
        });
        this.bullet5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bitmap decodeResource = BitmapFactory.decodeResource(FinalActivity.this.getResources(), C2049R.C2051drawable.harrow2);
                FinalActivity.this.extrasBitmap = Bitmap.createScaledBitmap(decodeResource, decodeResource.getWidth(), decodeResource.getHeight(), false);
                FinalActivity finalActivity = FinalActivity.this;
                finalActivity.extrasInkBitmap = Bitmap.createBitmap(finalActivity.extrasBitmap.getWidth(), FinalActivity.this.extrasBitmap.getHeight(), FinalActivity.this.extrasBitmap.getConfig());
                FinalActivity.this.bulletVisibility();
                FinalActivity finalActivity2 = FinalActivity.this;
                finalActivity2.inkExtra(finalActivity2.extrasBitmap, 0, 0, 0);
            }
        });
        this.bullet6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bitmap decodeResource = BitmapFactory.decodeResource(FinalActivity.this.getResources(), C2049R.C2051drawable.harrow3);
                FinalActivity.this.extrasBitmap = Bitmap.createScaledBitmap(decodeResource, decodeResource.getWidth(), decodeResource.getHeight(), false);
                FinalActivity finalActivity = FinalActivity.this;
                finalActivity.extrasInkBitmap = Bitmap.createBitmap(finalActivity.extrasBitmap.getWidth(), FinalActivity.this.extrasBitmap.getHeight(), FinalActivity.this.extrasBitmap.getConfig());
                FinalActivity.this.bulletVisibility();
                FinalActivity finalActivity2 = FinalActivity.this;
                finalActivity2.inkExtra(finalActivity2.extrasBitmap, 0, 0, 0);
            }
        });
        this.bullet7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bitmap decodeResource = BitmapFactory.decodeResource(FinalActivity.this.getResources(), C2049R.C2051drawable.hdarrow1);
                FinalActivity.this.extrasBitmap = Bitmap.createScaledBitmap(decodeResource, decodeResource.getWidth(), decodeResource.getHeight(), false);
                FinalActivity finalActivity = FinalActivity.this;
                finalActivity.extrasInkBitmap = Bitmap.createBitmap(finalActivity.extrasBitmap.getWidth(), FinalActivity.this.extrasBitmap.getHeight(), FinalActivity.this.extrasBitmap.getConfig());
                FinalActivity.this.bulletVisibility();
                FinalActivity finalActivity2 = FinalActivity.this;
                finalActivity2.inkExtra(finalActivity2.extrasBitmap, 0, 0, 0);
            }
        });
        this.bullet8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bitmap decodeResource = BitmapFactory.decodeResource(FinalActivity.this.getResources(), C2049R.C2051drawable.hdarrow2);
                FinalActivity.this.extrasBitmap = Bitmap.createScaledBitmap(decodeResource, decodeResource.getWidth(), decodeResource.getHeight(), false);
                FinalActivity finalActivity = FinalActivity.this;
                finalActivity.extrasInkBitmap = Bitmap.createBitmap(finalActivity.extrasBitmap.getWidth(), FinalActivity.this.extrasBitmap.getHeight(), FinalActivity.this.extrasBitmap.getConfig());
                FinalActivity.this.bulletVisibility();
                FinalActivity finalActivity2 = FinalActivity.this;
                finalActivity2.inkExtra(finalActivity2.extrasBitmap, 0, 0, 0);
            }
        });
        this.bullet9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bitmap decodeResource = BitmapFactory.decodeResource(FinalActivity.this.getResources(), C2049R.C2051drawable.hdarrow3);
                FinalActivity.this.extrasBitmap = Bitmap.createScaledBitmap(decodeResource, decodeResource.getWidth(), decodeResource.getHeight(), false);
                FinalActivity finalActivity = FinalActivity.this;
                finalActivity.extrasInkBitmap = Bitmap.createBitmap(finalActivity.extrasBitmap.getWidth(), FinalActivity.this.extrasBitmap.getHeight(), FinalActivity.this.extrasBitmap.getConfig());
                FinalActivity.this.bulletVisibility();
                FinalActivity finalActivity2 = FinalActivity.this;
                finalActivity2.inkExtra(finalActivity2.extrasBitmap, 0, 0, 0);
            }
        });
        this.scratch1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bitmap decodeResource = BitmapFactory.decodeResource(FinalActivity.this.getResources(), C2049R.C2051drawable.hscratch1);
                FinalActivity.this.extrasBitmap = Bitmap.createScaledBitmap(decodeResource, decodeResource.getWidth(), decodeResource.getHeight(), false);
                FinalActivity finalActivity = FinalActivity.this;
                finalActivity.extrasInkBitmap = Bitmap.createBitmap(finalActivity.extrasBitmap.getWidth(), FinalActivity.this.extrasBitmap.getHeight(), FinalActivity.this.extrasBitmap.getConfig());
                FinalActivity.this.scratchVisibility();
                FinalActivity finalActivity2 = FinalActivity.this;
                finalActivity2.inkExtra(finalActivity2.extrasBitmap, 0, 0, 0);
            }
        });
        this.scratch2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bitmap decodeResource = BitmapFactory.decodeResource(FinalActivity.this.getResources(), C2049R.C2051drawable.hscratch2);
                FinalActivity.this.extrasBitmap = Bitmap.createScaledBitmap(decodeResource, decodeResource.getWidth(), decodeResource.getHeight(), false);
                FinalActivity finalActivity = FinalActivity.this;
                finalActivity.extrasInkBitmap = Bitmap.createBitmap(finalActivity.extrasBitmap.getWidth(), FinalActivity.this.extrasBitmap.getHeight(), FinalActivity.this.extrasBitmap.getConfig());
                FinalActivity.this.scratchVisibility();
                FinalActivity finalActivity2 = FinalActivity.this;
                finalActivity2.inkExtra(finalActivity2.extrasBitmap, 0, 0, 0);
            }
        });
        this.scratch3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bitmap decodeResource = BitmapFactory.decodeResource(FinalActivity.this.getResources(), C2049R.C2051drawable.hscratch3);
                FinalActivity.this.extrasBitmap = Bitmap.createScaledBitmap(decodeResource, decodeResource.getWidth(), decodeResource.getHeight(), false);
                FinalActivity finalActivity = FinalActivity.this;
                finalActivity.extrasInkBitmap = Bitmap.createBitmap(finalActivity.extrasBitmap.getWidth(), FinalActivity.this.extrasBitmap.getHeight(), FinalActivity.this.extrasBitmap.getConfig());
                FinalActivity.this.scratchVisibility();
                FinalActivity finalActivity2 = FinalActivity.this;
                finalActivity2.inkExtra(finalActivity2.extrasBitmap, 0, 0, 0);
            }
        });
        this.scratch4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bitmap decodeResource = BitmapFactory.decodeResource(FinalActivity.this.getResources(), C2049R.C2051drawable.hscratch4);
                FinalActivity.this.extrasBitmap = Bitmap.createScaledBitmap(decodeResource, decodeResource.getWidth(), decodeResource.getHeight(), false);
                FinalActivity finalActivity = FinalActivity.this;
                finalActivity.extrasInkBitmap = Bitmap.createBitmap(finalActivity.extrasBitmap.getWidth(), FinalActivity.this.extrasBitmap.getHeight(), FinalActivity.this.extrasBitmap.getConfig());
                FinalActivity.this.scratchVisibility();
                FinalActivity finalActivity2 = FinalActivity.this;
                finalActivity2.inkExtra(finalActivity2.extrasBitmap, 0, 0, 0);
            }
        });
        this.scratch5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bitmap decodeResource = BitmapFactory.decodeResource(FinalActivity.this.getResources(), C2049R.C2051drawable.hscratch5);
                FinalActivity.this.extrasBitmap = Bitmap.createScaledBitmap(decodeResource, decodeResource.getWidth(), decodeResource.getHeight(), false);
                FinalActivity finalActivity = FinalActivity.this;
                finalActivity.extrasInkBitmap = Bitmap.createBitmap(finalActivity.extrasBitmap.getWidth(), FinalActivity.this.extrasBitmap.getHeight(), FinalActivity.this.extrasBitmap.getConfig());
                FinalActivity.this.scratchVisibility();
                FinalActivity finalActivity2 = FinalActivity.this;
                finalActivity2.inkExtra(finalActivity2.extrasBitmap, 0, 0, 0);
            }
        });
        this.scratch6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bitmap decodeResource = BitmapFactory.decodeResource(FinalActivity.this.getResources(), C2049R.C2051drawable.hscratch6);
                FinalActivity.this.extrasBitmap = Bitmap.createScaledBitmap(decodeResource, decodeResource.getWidth(), decodeResource.getHeight(), false);
                FinalActivity finalActivity = FinalActivity.this;
                finalActivity.extrasInkBitmap = Bitmap.createBitmap(finalActivity.extrasBitmap.getWidth(), FinalActivity.this.extrasBitmap.getHeight(), FinalActivity.this.extrasBitmap.getConfig());
                FinalActivity.this.scratchVisibility();
                FinalActivity finalActivity2 = FinalActivity.this;
                finalActivity2.inkExtra(finalActivity2.extrasBitmap, 0, 0, 0);
            }
        });
        this.scratch7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bitmap decodeResource = BitmapFactory.decodeResource(FinalActivity.this.getResources(), C2049R.C2051drawable.hscratch7);
                FinalActivity.this.extrasBitmap = Bitmap.createScaledBitmap(decodeResource, decodeResource.getWidth(), decodeResource.getHeight(), false);
                FinalActivity finalActivity = FinalActivity.this;
                finalActivity.extrasInkBitmap = Bitmap.createBitmap(finalActivity.extrasBitmap.getWidth(), FinalActivity.this.extrasBitmap.getHeight(), FinalActivity.this.extrasBitmap.getConfig());
                FinalActivity.this.scratchVisibility();
                FinalActivity finalActivity2 = FinalActivity.this;
                finalActivity2.inkExtra(finalActivity2.extrasBitmap, 0, 0, 0);
            }
        });
        this.scratch8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bitmap decodeResource = BitmapFactory.decodeResource(FinalActivity.this.getResources(), C2049R.C2051drawable.hscratch8);
                FinalActivity.this.extrasBitmap = Bitmap.createScaledBitmap(decodeResource, decodeResource.getWidth(), decodeResource.getHeight(), false);
                FinalActivity finalActivity = FinalActivity.this;
                finalActivity.extrasInkBitmap = Bitmap.createBitmap(finalActivity.extrasBitmap.getWidth(), FinalActivity.this.extrasBitmap.getHeight(), FinalActivity.this.extrasBitmap.getConfig());
                FinalActivity.this.scratchVisibility();
                FinalActivity finalActivity2 = FinalActivity.this;
                finalActivity2.inkExtra(finalActivity2.extrasBitmap, 0, 0, 0);
            }
        });
        this.scratch9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Bitmap decodeResource = BitmapFactory.decodeResource(FinalActivity.this.getResources(), C2049R.C2051drawable.hscratch9);
                FinalActivity.this.extrasBitmap = Bitmap.createScaledBitmap(decodeResource, decodeResource.getWidth(), decodeResource.getHeight(), false);
                FinalActivity finalActivity = FinalActivity.this;
                finalActivity.extrasInkBitmap = Bitmap.createBitmap(finalActivity.extrasBitmap.getWidth(), FinalActivity.this.extrasBitmap.getHeight(), FinalActivity.this.extrasBitmap.getConfig());
                FinalActivity.this.scratchVisibility();
                FinalActivity finalActivity2 = FinalActivity.this;
                finalActivity2.inkExtra(finalActivity2.extrasBitmap, 0, 0, 0);
            }
        });
    }

    /* access modifiers changed from: private */
    public void headinglayoutclose(int i) {
        this.fontSizeTv.setVisibility(i);
        this.headingSeekBar.setVisibility(i);
        this.finalFontColorBg.setVisibility(i);
        this.finalColorSpinner.setVisibility(i);
        this.finalFontBg.setVisibility(i);
        this.finalFontSpinner.setVisibility(i);
        this.headingOk.setVisibility(i);
        this.headingCancel.setVisibility(i);
        this.lineAlignment.setVisibility(i);
        this.lineSpacing.setVisibility(i);
        this.headingEditButton.setVisibility(i);
    }

    /* access modifiers changed from: private */
    public void headingAction() {
        this.headingEditText.setText("");
        this.headingView.setVisibility(4);
        this.headingEditText.setVisibility(4);
        this.headingEtClose.setVisibility(4);
        this.headingEtOk.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public void exClose() {
        this.extrasColor.setVisibility(4);
        this.extrasColorBg.setVisibility(4);
        this.extrasLayout.setVisibility(4);
        this.finalButtonLayout.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void excloseaf() {
        this.extrasOpen = false;
        if (this.bullet) {
            ViewGroup.LayoutParams layoutParams = this.extrasImageView.getLayoutParams();
            layoutParams.height = this.extraHeight;
            layoutParams.width = this.extraWidth;
            this.extrasImageView.setLayoutParams(layoutParams);
            this.extrasImageView.setX((float) (this.finalImageView.getWidth() / 2));
            this.extrasImageView.setY((float) (this.finalImageView.getHeight() / 2));
            this.extrasImageView.setVisibility(4);
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.scratchImageView.getLayoutParams();
        layoutParams2.height = this.extraHeight;
        layoutParams2.width = this.extraWidth;
        this.scratchImageView.setLayoutParams(layoutParams2);
        this.scratchImageView.setX((float) (this.finalImageView.getWidth() / 2));
        this.scratchImageView.setY((float) (this.finalImageView.getHeight() / 2));
        this.scratchImageView.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public void bulletVisibility() {
        this.headingView.setVisibility(4);
        this.bulletLayout.setVisibility(4);
        this.bulletClose.setVisibility(4);
        this.extrasImageView.setVisibility(0);
        this.extrasImageView.setImageBitmap(this.extrasBitmap);
        this.extraHeight = this.extrasImageView.getHeight();
        this.extraWidth = this.extrasImageView.getWidth();
        this.extrasLayout.setVisibility(0);
        this.extrasColor.setVisibility(0);
        this.extrasColorBg.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void scratchVisibility() {
        this.headingView.setVisibility(4);
        this.scratchLayout.setVisibility(4);
        this.scratchClose.setVisibility(4);
        this.scratchImageView.setVisibility(0);
        this.scratchImageView.setImageBitmap(this.extrasBitmap);
        this.extraHeight = this.scratchImageView.getHeight();
        this.extraWidth = this.scratchImageView.getWidth();
        this.extrasLayout.setVisibility(0);
        this.extrasColor.setVisibility(0);
        this.extrasColorBg.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void originalDiagram() {
        this.finalDiagramView.setBackground(new BitmapDrawable(getResources(), this.coloredBitmap));
        Bitmap bitmap = this.coloredBitmap;
        this.originalBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), this.coloredBitmap.getHeight(), false);
        Bitmap bitmap2 = this.coloredBitmap;
        this.changeabliBitmap = Bitmap.createScaledBitmap(bitmap2, bitmap2.getWidth(), this.coloredBitmap.getHeight(), false);
        this.inkColorScroll.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public void diagramClose() {
        this.diagramClose.setVisibility(4);
        this.finalDiagramView.setVisibility(4);
        this.diagramResize.setVisibility(4);
        this.diagramOk.setVisibility(4);
        this.originalDiagram.setVisibility(4);
        this.inkDiagram.setVisibility(4);
        this.finalDeleteButton.setVisibility(0);
        this.paintDiagram.setVisibility(4);
        this.eraseDiagram.setVisibility(4);
        this.eraseLayout.setVisibility(4);
        this.flToolbar.setVisibility(0);
        this.eraseLayoutClose.setVisibility(4);
        this.diagramAction = 0;
        this.finalButtonLayout.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void renameBg() {
        this.finalRenameLayout.startAnimation(this.fadeOut);
        this.renameBg.startAnimation(this.fadeOut2);
        this.finalRenameLayout.setVisibility(4);
        this.renameBg.setVisibility(4);
        this.exportPressed = false;
    }

    /* access modifiers changed from: private */
    public void renameOk() {
        this.finalRenameLayout.startAnimation(this.fadeOut);
        this.finalRenameLayout.setVisibility(4);
        this.renameBg.startAnimation(this.fadeOut2);
        this.renameBg.setVisibility(4);
        this.exportPressed = false;
    }

    /* access modifiers changed from: private */
    public void renameCancel() {
        this.saveas = 0;
        this.finalRenameLayout.startAnimation(this.fadeOut);
        this.finalRenameLayout.setVisibility(4);
        this.renameBg.startAnimation(this.fadeOut2);
        this.renameBg.setVisibility(4);
        this.exportPressed = false;
    }

    /* access modifiers changed from: private */
    public void exportAsImages() {
        this.saveas = 2;
        this.exportBg.startAnimation(this.fadeOut2);
        this.exportBg.setVisibility(4);
        this.exportLayout.startAnimation(this.fadeOut);
        this.exportLayout.setVisibility(4);
        this.finalRenameLayout.startAnimation(this.fadeIn);
        this.finalRenameLayout.setVisibility(0);
        this.renameBg.startAnimation(this.fadeIn2);
        this.renameBg.setVisibility(0);
        this.renameLayout = true;
        this.exportPressed = false;
    }

    /* access modifiers changed from: private */
    public void exportAsPdf() {
        this.saveas = 1;
        this.exportBg.startAnimation(this.fadeOut2);
        this.exportBg.setVisibility(4);
        this.exportLayout.startAnimation(this.fadeOut);
        this.exportLayout.setVisibility(4);
        this.finalRenameLayout.startAnimation(this.fadeIn);
        this.finalRenameLayout.setVisibility(0);
        this.renameBg.startAnimation(this.fadeIn2);
        this.renameBg.setVisibility(0);
        this.renameLayout = true;
        this.exportPressed = false;
    }

    /* access modifiers changed from: private */
    public void retake() {
        Intent intent = new Intent();
        intent.putExtra("actionPerformed", 2);
        intent.putExtra("uris", this.uris);
        intent.putExtra("retake", this.selected);
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: private */
    public void delete() {
        this.totalImages--;
        this.capturedImages.remove(this.selected - 1);
        this.uris.remove(this.selected - 1);
        Toast.makeText(this, "1 image deleted", 0).show();
        int i = this.totalImages;
        if (i > 0) {
            int i2 = this.selected;
            if (i2 <= i) {
                this.finalImageView.setImageBitmap(this.capturedImages.get(i2 - 1));
                this.drawingBitmap = this.capturedImages.get(this.selected - 1);
            } else {
                int i3 = i2 - 1;
                this.selected = i3;
                this.finalImageView.setImageBitmap(this.capturedImages.get(i3 - 1));
                this.drawingBitmap = this.capturedImages.get(this.selected - 1);
            }
            this.unReDoImages.clear();
            this.unReDoImages.add(this.drawingBitmap);
            this.uRNumber = 0;
            this.uRTotal = 0;
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("actionPerformed", 1);
        intent.putExtra("uris", this.uris);
        setResult(-1, intent);
        finish();
    }

    private void homeUI() {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        defaultDisplay.getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.loading.getLayoutParams();
        int i = (width * 40) / 100;
        marginLayoutParams.height = i;
        marginLayoutParams.width = i;
        this.loading.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.finalRenameLayout.getLayoutParams();
        marginLayoutParams2.width = (width * 80) / 100;
        this.finalRenameLayout.setLayoutParams(marginLayoutParams2);
    }

    /* access modifiers changed from: private */
    public void exportAsWhatever() {
        File file;
        File file2;
        File file3;
        String str;
        int i = this.saveas;
        if (i == 1) {
            if (ActivityCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
                return;
            }
            PdfDocument pdfDocument = new PdfDocument();
            for (int i2 = 0; i2 < this.capturedImages.size(); i2++) {
                PdfDocument.Page startPage = pdfDocument.startPage(new PdfDocument.PageInfo.Builder(this.capturedImages.get(i2).getWidth(), this.capturedImages.get(i2).getHeight(), i2).create());
                Canvas canvas = startPage.getCanvas();
                Paint paint = new Paint();
                paint.setColor(-1);
                canvas.drawPaint(paint);
                paint.setColor(-16776961);
                canvas.drawBitmap(this.capturedImages.get(i2), 0.0f, 0.0f, (Paint) null);
                pdfDocument.finishPage(startPage);
            }
            String obj = this.finalFilename.getText().toString();
            String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            if (Build.VERSION.SDK_INT >= 30) {
                file3 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath());
            } else {
                file3 = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
            }
            File file4 = new File(file3 + "/HandWriter//Pdf Files/");
            if (!file4.exists()) {
                file4.mkdirs();
            }
            if (!obj.isEmpty()) {
                str = obj + ".pdf";
            } else {
                str = "New Doc " + format + ".pdf";
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(file4, str));
                pdfDocument.writeTo(fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                Toast.makeText(this, str + " is saved to " + file4, 0).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            pdfDocument.close();
        } else if (i == 2) {
            String obj2 = this.finalFilename.getText().toString();
            String format2 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            if (obj2.isEmpty()) {
                obj2 = format2;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath());
            } else {
                file = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
            }
            File file5 = new File(file + "/HandWriter//Images/" + obj2);
            if (!file5.exists()) {
                file5.mkdirs();
            }
            for (int i3 = 0; i3 < this.capturedImages.size(); i3++) {
                try {
                    String str2 = obj2 + "_" + String.valueOf(i3);
                    if (Build.VERSION.SDK_INT >= 30) {
                        file2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath() + "/HandWriter//Images/" + obj2);
                    } else {
                        file2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/HandWriter//Images/" + obj2);
                    }
                    this.capturedImages.get(i3).compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(File.createTempFile(str2, ".jpg", file2)));
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            Toast.makeText(this, "Images saved to HandWriter/Images/" + obj2, 0).show();
        }
    }

    private void closeImage() {
        this.images.setVisibility(0);
        this.finalExportButton.setVisibility(0);
        this.finalAdd1.setVisibility(0);
        this.finalImageView.setVisibility(4);
        this.finalDeleteButton.setVisibility(4);
        this.flToolbar.setVisibility(4);
        this.finalButtonLayout.setVisibility(4);
        this.images.setAdapter(new customAdapter());
        this.imageOpen = false;
        this.capturedImages.set(this.selected - 1, this.drawingBitmap);
        try {
            this.drawingBitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(new File(Uri.parse(this.uris2.get(this.selected - 1)).getPath())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.unRedoLayout.setVisibility(4);
        this.unReDoImages.clear();
    }

    /* access modifiers changed from: private */
    public void addMoreImages() {
        Intent intent = new Intent();
        intent.putExtra("actionPerformed", 1);
        intent.putExtra("uris", this.uris);
        setResult(-1, intent);
        finish();
    }

    class customAdapter extends BaseAdapter {
        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }

        customAdapter() {
        }

        public int getCount() {
            return FinalActivity.this.capturedImages.size();
        }

        public View getView(final int i, View view, ViewGroup viewGroup) {
            int width = FinalActivity.this.getWindowManager().getDefaultDisplay().getWidth();
            View inflate = FinalActivity.this.getLayoutInflater().inflate(C2049R.layout.activity_finimg, (ViewGroup) null);
            ImageButton imageButton = (ImageButton) inflate.findViewById(C2049R.C2052id.imagesCaptured);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(C2049R.C2052id.flinearLayout);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams();
            int i2 = (width * 2) / 100;
            marginLayoutParams.setMargins(i2, i2, 0, 0);
            linearLayout.setLayoutParams(marginLayoutParams);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) imageButton.getLayoutParams();
            marginLayoutParams2.height = (width * 60) / 100;
            marginLayoutParams2.width = (width * 45) / 100;
            imageButton.setLayoutParams(marginLayoutParams2);
            ((Button) inflate.findViewById(C2049R.C2052id.imagesNumberFinal)).setText(String.valueOf(i + 1));
            imageButton.setBackground(new BitmapDrawable(FinalActivity.this.getResources(), FinalActivity.this.capturedImages.get(i)));
            imageButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (!FinalActivity.this.exportPressed) {
                        FinalActivity.this.unRedoLayout.setVisibility(0);
                        FinalActivity.this.images.setVisibility(4);
                        FinalActivity.this.finalExportButton.setVisibility(4);
                        FinalActivity.this.finalAdd1.setVisibility(4);
                        FinalActivity.this.finalImageView.setVisibility(0);
                        FinalActivity.this.finalDeleteButton.setVisibility(0);
                        FinalActivity.this.finalButtonLayout.setVisibility(0);
                        FinalActivity.this.flToolbar.setVisibility(0);
                        FinalActivity.this.finalImageView.setImageBitmap(FinalActivity.this.capturedImages.get(i));
                        FinalActivity.this.selected = i + 1;
                        int unused = FinalActivity.this.uRNumber = FinalActivity.this.uRTotal = 0;
                        FinalActivity.this.drawingBitmap = FinalActivity.this.capturedImages.get(i);
                        FinalActivity.this.unReDoImages.add(FinalActivity.this.drawingBitmap);
                        boolean unused2 = FinalActivity.this.imageOpen = true;
                    }
                }
            });
            return inflate;
        }
    }

    public class OnSwipeTouchListener implements View.OnTouchListener {
        private final GestureDetector gestureDetector;

        public OnSwipeTouchListener(Context context) {
            this.gestureDetector = new GestureDetector(context, new GestureListener());
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.gestureDetector.onTouchEvent(motionEvent);
        }

        final class GestureListener extends GestureDetector.SimpleOnGestureListener {
            private static final int SWIPE_DISTANCE_THRESHOLD = 100;
            private static final int SWIPE_VELOCITY_THRESHOLD = 100;

            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            GestureListener() {
            }

            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                float x = motionEvent2.getX() - motionEvent.getX();
                if (Math.abs(x) <= Math.abs(motionEvent2.getY() - motionEvent.getY()) || Math.abs(x) <= 100.0f || Math.abs(f) <= 100.0f) {
                    return false;
                }
                if (x > 0.0f) {
                    FinalActivity.this.prevImageDisplay();
                    return true;
                }
                FinalActivity.this.nextImageDisplay();
                return true;
            }
        }
    }

    /* access modifiers changed from: private */
    public void nextImageDisplay() {
        int i;
        if (!this.diagramSelected && (i = this.selected) < this.totalImages) {
            this.finalImageView.setImageBitmap(this.capturedImages.get(i));
            this.selected++;
        }
    }

    /* access modifiers changed from: private */
    public void prevImageDisplay() {
        int i;
        if (!this.diagramSelected && (i = this.selected) > 1) {
            int i2 = i - 1;
            this.selected = i2;
            this.finalImageView.setImageBitmap(this.capturedImages.get(i2 - 1));
        }
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        if (!this.pasting) {
            if (this.exportPressed) {
                exportLayoutAnimation();
            } else if (this.renameLayout) {
                renameBg();
                this.renameLayout = false;
            } else if (!this.extrasOpen) {
                if (!this.imageOpen) {
                    Intent intent = new Intent();
                    intent.putExtra("actionPerformed", 3);
                    intent.putExtra("uris", this.uris2);
                    setResult(-1, intent);
                    finish();
                } else if (this.finalDiagramView.getVisibility() == 0) {
                    Toast.makeText(this, "press cancel button on image top to discard diagram", 0).show();
                } else {
                    closeImage();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 120 && i2 == -1) {
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(getContentResolver().openInputStream(intent.getData()));
                float height = (float) decodeStream.getHeight();
                float width = (float) decodeStream.getWidth();
                this.diagramSelected = true;
                double width2 = (double) this.finalImageView.getWidth();
                Double.isNaN(width2);
                int i3 = (int) (width2 * 0.7d);
                this.imageWidth = i3;
                int i4 = (int) ((height / width) * ((float) i3));
                this.imageHeight = i4;
                double d = (double) i4;
                double height2 = (double) this.finalImageView.getHeight();
                Double.isNaN(height2);
                if (d > height2 * 0.7d) {
                    double height3 = (double) this.finalImageView.getHeight();
                    Double.isNaN(height3);
                    int i5 = (int) (height3 * 0.8d);
                    this.imageHeight = i5;
                    this.imageWidth = (int) ((width / height) * ((float) i5));
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, this.imageWidth, this.imageHeight, false);
                this.coloredBitmap = createScaledBitmap;
                this.inkBitmap = Bitmap.createBitmap(createScaledBitmap.getWidth(), this.coloredBitmap.getHeight(), this.coloredBitmap.getConfig());
                this.originalBitmap = Bitmap.createBitmap(this.coloredBitmap.getWidth(), this.coloredBitmap.getHeight(), this.coloredBitmap.getConfig());
                this.finalDiagramView.setVisibility(0);
                this.diagramClose.setVisibility(0);
                this.diagramOk.setVisibility(0);
                this.finalDeleteButton.setVisibility(4);
                this.originalDiagram.setVisibility(0);
                this.inkDiagram.setVisibility(0);
                this.finalButtonLayout.setVisibility(4);
                this.finalDiagramView.setX((float) ((this.finalImageView.getWidth() - this.finalDiagramView.getWidth()) / 2));
                this.finalDiagramView.setY(((float) ((this.finalImageView.getHeight() - this.finalDiagramView.getHeight()) / 2)) + this.finalImageView.getY());
                this.diagramClose.setX(this.finalDiagramView.getX());
                this.diagramClose.setY(this.finalDiagramView.getY() - ((float) this.diagramClose.getHeight()));
                this.diagramOk.setX((this.finalDiagramView.getX() + ((float) this.finalDiagramView.getWidth())) - ((float) this.diagramOk.getWidth()));
                this.diagramOk.setY(this.finalDiagramView.getY() - ((float) this.diagramOk.getHeight()));
                this.diagramResize.setX((this.finalDiagramView.getX() + ((float) this.finalDiagramView.getWidth())) - ((float) this.diagramResize.getWidth()));
                this.diagramResize.setY(this.finalDiagramView.getY() + ((float) this.finalDiagramView.getHeight()));
                ViewGroup.LayoutParams layoutParams = this.finalDiagramView.getLayoutParams();
                layoutParams.height = this.imageHeight;
                layoutParams.width = this.imageWidth;
                this.finalDiagramView.setLayoutParams(layoutParams);
                for (int i6 = 0; i6 < this.coloredBitmap.getWidth(); i6++) {
                    for (int i7 = 0; i7 < this.coloredBitmap.getHeight(); i7++) {
                        int pixel = this.coloredBitmap.getPixel(i6, i7);
                        int red = Color.red(pixel);
                        int blue = Color.blue(pixel);
                        int green = Color.green(pixel);
                        Color.alpha(pixel);
                        this.originalBitmap.setPixel(i6, i7, Color.argb(255, red, green, blue));
                    }
                }
                Bitmap bitmap = this.originalBitmap;
                this.changeabliBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), this.originalBitmap.getHeight(), false);
                this.finalDiagramView.setBackground(new BitmapDrawable(getResources(), this.coloredBitmap));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void erase() {
        if (!this.erase) {
            this.eraseLayout.setVisibility(0);
            this.eraseLayoutClose.setVisibility(0);
            this.eraseDiagram.setBackgroundColor(getResources().getColor(C2049R.C2050color.lightGrey));
            this.paintDiagram.setBackgroundColor(0);
            this.erase = true;
        } else if (this.eraseLayout.getVisibility() == 0) {
            this.eraseLayout.setVisibility(4);
            this.eraseLayoutClose.setVisibility(4);
        } else {
            this.eraseLayout.setVisibility(0);
            this.eraseLayoutClose.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void paint() {
        if (this.erase) {
            this.eraseLayout.setVisibility(0);
            this.eraseLayoutClose.setVisibility(0);
            this.eraseDiagram.setBackgroundColor(0);
            this.paintDiagram.setBackgroundColor(getResources().getColor(C2049R.C2050color.lightGrey));
            this.erase = false;
        } else if (this.eraseLayout.getVisibility() == 0) {
            this.eraseLayout.setVisibility(4);
            this.eraseLayoutClose.setVisibility(4);
        } else {
            this.eraseLayout.setVisibility(0);
            this.eraseLayoutClose.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void inkDiagram(int i, int i2, int i3) {
        for (int i4 = 0; i4 < this.coloredBitmap.getWidth(); i4++) {
            for (int i5 = 0; i5 < this.coloredBitmap.getHeight(); i5++) {
                int pixel = this.coloredBitmap.getPixel(i4, i5);
                int red = Color.red(pixel);
                int blue = Color.blue(pixel);
                int green = Color.green(pixel);
                if (red <= 100 || blue <= 100 || green <= 100) {
                    this.inkBitmap.setPixel(i4, i5, Color.argb(255, i, i2, i3));
                } else {
                    this.inkBitmap.setPixel(i4, i5, Color.argb(0, 0, 0, 0));
                }
            }
        }
        this.originalBitmap = Bitmap.createScaledBitmap(this.inkBitmap, this.coloredBitmap.getWidth(), this.coloredBitmap.getHeight(), false);
        this.changeabliBitmap = Bitmap.createScaledBitmap(this.inkBitmap, this.coloredBitmap.getWidth(), this.coloredBitmap.getHeight(), false);
        this.finalDiagramView.setBackground(new BitmapDrawable(getResources(), this.inkBitmap));
    }

    /* access modifiers changed from: private */
    public void inkExtra(Bitmap bitmap, int i, int i2, int i3) {
        for (int i4 = 0; i4 < bitmap.getWidth(); i4++) {
            for (int i5 = 0; i5 < bitmap.getHeight(); i5++) {
                if (Color.alpha(bitmap.getPixel(i4, i5)) < 100) {
                    this.extrasInkBitmap.setPixel(i4, i5, Color.argb(0, 0, 0, 0));
                } else {
                    this.extrasInkBitmap.setPixel(i4, i5, Color.argb(255, i, i2, i3));
                }
            }
        }
        if (this.bullet) {
            this.extrasImageView.setImageBitmap(this.extrasInkBitmap);
        } else {
            this.scratchImageView.setImageBitmap(this.extrasInkBitmap);
        }
    }

    private void extrasColorSpinner() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Black");
        arrayList.add("White");
        arrayList.add("Grey");
        arrayList.add("Blue");
        arrayList.add("Dark Blue");
        arrayList.add("Red");
        arrayList.add("Dark Red");
        this.extrasColor.setItems(arrayList);
        this.extrasColor.setDismissWhenNotifiedItemSelected(false);
        this.extrasColor.clearSelectedItem();
        this.extrasColor.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener<Object>() {
            public void onItemSelected(int i, Object obj, int i2, Object obj2) {
                FinalActivity.this.extrasColor.setText("");
                switch (i2) {
                    case 0:
                        FinalActivity finalActivity = FinalActivity.this;
                        finalActivity.inkExtra(finalActivity.extrasBitmap, 0, 0, 0);
                        return;
                    case 1:
                        FinalActivity finalActivity2 = FinalActivity.this;
                        finalActivity2.inkExtra(finalActivity2.extrasBitmap, 255, 255, 255);
                        return;
                    case 2:
                        FinalActivity finalActivity3 = FinalActivity.this;
                        finalActivity3.inkExtra(finalActivity3.extrasBitmap, 70, 70, 70);
                        return;
                    case 3:
                        FinalActivity finalActivity4 = FinalActivity.this;
                        finalActivity4.inkExtra(finalActivity4.extrasBitmap, 0, 68, 153);
                        return;
                    case 4:
                        FinalActivity finalActivity5 = FinalActivity.this;
                        finalActivity5.inkExtra(finalActivity5.extrasBitmap, 22, 38, 119);
                        return;
                    case 5:
                        FinalActivity finalActivity6 = FinalActivity.this;
                        finalActivity6.inkExtra(finalActivity6.extrasBitmap, 204, 34, 34);
                        return;
                    case 6:
                        FinalActivity finalActivity7 = FinalActivity.this;
                        finalActivity7.inkExtra(finalActivity7.extrasBitmap, 153, 0, 0);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    private void finalColorSpinner() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Black");
        arrayList.add("White");
        arrayList.add("Grey");
        arrayList.add("Blue");
        arrayList.add("Dark Blue");
        arrayList.add("Red");
        arrayList.add("Dark Red");
        this.finalColorSpinner.setItems(arrayList);
        this.finalColorSpinner.setDismissWhenNotifiedItemSelected(false);
        this.finalColorSpinner.clearSelectedItem();
        this.finalColorSpinner.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                FinalActivity.this.finalFontSpinner.dismiss();
                return false;
            }
        });
        this.finalColorSpinner.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener<Object>() {
            public void onItemSelected(int i, Object obj, int i2, Object obj2) {
                FinalActivity.this.finalColorSpinner.setText("");
                switch (i2) {
                    case 0:
                        FinalActivity.this.headingTextView.setTextColor(FinalActivity.this.getResources().getColor(C2049R.C2050color.ColourBlack));
                        return;
                    case 1:
                        FinalActivity.this.headingTextView.setTextColor(FinalActivity.this.getResources().getColor(C2049R.C2050color.white));
                        return;
                    case 2:
                        FinalActivity.this.headingTextView.setTextColor(FinalActivity.this.getResources().getColor(C2049R.C2050color.ColourGrey));
                        return;
                    case 3:
                        FinalActivity.this.headingTextView.setTextColor(FinalActivity.this.getResources().getColor(C2049R.C2050color.ColourBlue));
                        return;
                    case 4:
                        FinalActivity.this.headingTextView.setTextColor(FinalActivity.this.getResources().getColor(C2049R.C2050color.ColourDarkBlue));
                        return;
                    case 5:
                        FinalActivity.this.headingTextView.setTextColor(FinalActivity.this.getResources().getColor(C2049R.C2050color.ColourRed));
                        return;
                    case 6:
                        FinalActivity.this.headingTextView.setTextColor(FinalActivity.this.getResources().getColor(C2049R.C2050color.ColourDarkRed));
                        return;
                    default:
                        return;
                }
            }
        });
    }

    private void finalFontSpinner() {
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
        this.finalFontSpinner.setItems(arrayList);
        this.finalFontSpinner.setDismissWhenNotifiedItemSelected(false);
        this.finalFontSpinner.clearSelectedItem();
        this.finalFontSpinner.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                FinalActivity.this.finalColorSpinner.dismiss();
                return false;
            }
        });
        this.finalFontSpinner.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener<Object>() {
            public void onItemSelected(int i, Object obj, int i2, Object obj2) {
                FinalActivity.this.finalFontSpinner.setText("");
                switch (i2) {
                    case 0:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.times_new_roman));
                        return;
                    case 1:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.handwriting_03));
                        return;
                    case 2:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.handwriting_04));
                        return;
                    case 3:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.handwriting_02));
                        return;
                    case 4:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.handwriting_01));
                        return;
                    case 5:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.handwriting_05));
                        return;
                    case 6:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.handwriterfont6_yashwanth));
                        return;
                    case 7:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.handwriterfont7_ananya));
                        return;
                    case 8:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.handwriterfont_8_afreedi));
                        return;
                    case 9:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.handwriting_09));
                        return;
                    case 10:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.handwriting_10));
                        return;
                    case 11:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.handwriting_11));
                        return;
                    case 12:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.handwriting_12));
                        return;
                    case 13:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts13));
                        return;
                    case 14:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts14));
                        return;
                    case 15:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts15));
                        return;
                    case 16:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts16));
                        return;
                    case 17:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts17));
                        return;
                    case 18:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts18));
                        return;
                    case 19:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts19));
                        return;
                    case 20:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts20));
                        return;
                    case 21:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts21));
                        return;
                    case 22:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts22));
                        return;
                    case 23:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts23));
                        return;
                    case 24:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts24));
                        return;
                    case 25:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts25));
                        return;
                    case 26:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts26));
                        return;
                    case 27:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts27));
                        return;
                    case 28:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts28));
                        return;
                    case 29:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts29));
                        return;
                    case 30:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts30));
                        return;
                    case 31:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts31));
                        return;
                    case 32:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts32));
                        return;
                    case 33:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts33));
                        return;
                    case 34:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts34));
                        return;
                    case 35:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts35));
                        return;
                    case 36:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts36));
                        return;
                    case 37:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts37));
                        return;
                    case 38:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts57));
                        return;
                    case 39:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts39));
                        return;
                    case 40:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts40));
                        return;
                    case 41:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts41));
                        return;
                    case 42:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts42));
                        return;
                    case 43:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts43));
                        return;
                    case 44:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts44));
                        return;
                    case 45:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts45));
                        return;
                    case 46:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts46));
                        return;
                    case 47:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts47));
                        return;
                    case 48:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts48));
                        return;
                    case 49:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts49));
                        return;
                    case 50:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts50));
                        return;
                    case 51:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts51));
                        return;
                    case 52:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts52));
                        return;
                    case 53:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts53));
                        return;
                    case 54:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts54));
                        return;
                    case 55:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts55));
                        return;
                    case 56:
                        FinalActivity.this.headingTextView.setTypeface(ResourcesCompat.getFont(FinalActivity.this, C2049R.font.hwfonts56));
                        return;
                    default:
                        return;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void exportLayoutAnimation() {
        if (!this.exportPressed) {
            this.exportBg.startAnimation(this.fadeIn2);
            this.exportBg.setVisibility(0);
            this.exportLayout.startAnimation(this.fromBottom);
            this.exportLayout.setVisibility(0);
            this.exportImages.setVisibility(0);
            this.exportPdf.setVisibility(0);
            this.exportPressed = true;
            return;
        }
        this.exportBg.startAnimation(this.fadeOut2);
        this.exportBg.setVisibility(4);
        this.exportLayout.startAnimation(this.toBottom);
        this.exportLayout.setVisibility(4);
        this.exportImages.setVisibility(4);
        this.exportPdf.setVisibility(4);
        this.exportPressed = false;
    }

    /* access modifiers changed from: private */
    public void undoAction() {
        int i = this.uRNumber;
        if (i > 0) {
            int i2 = i - 1;
            this.uRNumber = i2;
            this.finalImageView.setImageBitmap(this.unReDoImages.get(i2));
            this.drawingBitmap = this.unReDoImages.get(this.uRNumber);
        }
    }

    /* access modifiers changed from: private */
    public void redoAction() {
        int i = this.uRNumber;
        if (i < this.uRTotal) {
            int i2 = i + 1;
            this.uRNumber = i2;
            this.finalImageView.setImageBitmap(this.unReDoImages.get(i2));
            this.drawingBitmap = this.unReDoImages.get(this.uRNumber);
        }
    }

    /* access modifiers changed from: private */
    public void spinnersDismiss() {
        this.finalFontSpinner.dismiss();
        this.finalColorSpinner.dismiss();
    }
}
