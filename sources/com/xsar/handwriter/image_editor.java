package com.xsar.handwriter;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.SparseArray;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.theartofdev.edmodo.cropper.CropImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class image_editor extends AppCompatActivity {
    private static final int CAMERA_REQUEST_CODE = 300;
    private static final int REQUEST_IMAGE_CAPTURE = 200;
    public Button addButton;
    AnimationDrawable anim;
    LinearLayout camBackgroundLayout;
    View cameraBackgroundView;
    public int cameraNo = 0;
    public Button cropButton;
    public String currentPhotoPath;
    Button customCameraButton;
    public Button editorDelete;
    public Button editorGallery;
    boolean exportPressed = false;
    Animation fadeIn2;
    Animation fadeOut2;
    public int firsttimeCam = 0;
    boolean freshEntry = true;
    Animation fromBottom2;
    boolean fromGallery;
    public Uri imageUri;
    public ImageView imageView;
    Bitmap imagebitmap;
    boolean imagecaptured = false;
    public ArrayList<Bitmap> imagesArray;
    public TextView imagesSelected;
    Uri imageuri;
    boolean lastBitmapAdded = false;
    ImageView loading;
    View loadingBg;
    TextView loadingText;
    public Toolbar lowerToolbar;
    boolean newImage = true;
    ArrayList<String> newUris;
    public Button nextButton;
    boolean nextPressed = false;
    Button phoneCameraButton;
    ArrayList<String> photopaths;
    public int picDisplay = 0;
    public int picsTaken = 0;
    public ArrayList<String> recognizedText;
    public Button retakeButton;
    public String scannedText;
    Animation toBottom2;
    public Toolbar upperToolbar;
    ArrayList<Uri> uris;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2049R.layout.activity_image_editor);
        setUi();
        setSupportActionBar(this.upperToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle((CharSequence) "");
        this.cameraBackgroundView = findViewById(C2049R.C2052id.cameraBackground1);
        this.camBackgroundLayout = (LinearLayout) findViewById(C2049R.C2052id.CameraLayout1);
        this.customCameraButton = (Button) findViewById(C2049R.C2052id.customCamButton1);
        this.phoneCameraButton = (Button) findViewById(C2049R.C2052id.phoneCamButton1);
        this.fadeOut2 = AnimationUtils.loadAnimation(this, C2049R.anim.fadeout_slow);
        this.fromBottom2 = AnimationUtils.loadAnimation(this, C2049R.anim.from_bottom_original_size);
        this.toBottom2 = AnimationUtils.loadAnimation(this, C2049R.anim.to_bottom_original_size);
        this.fadeIn2 = AnimationUtils.loadAnimation(this, C2049R.anim.fadein_slow);
        boolean z = getIntent().getExtras().getBoolean("fromGallery");
        this.fromGallery = z;
        if (!z && this.freshEntry) {
            int i = getIntent().getExtras().getInt("cameraNo");
            this.cameraNo = i;
            if (i == 1) {
                if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") != 0) {
                    ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 300);
                } else {
                    dispatchTakePictureIntent();
                }
            } else if (i == 2) {
                this.newUris = getIntent().getStringArrayListExtra("imagesCaptured");
                cameraImages();
            }
            this.freshEntry = false;
        }
        if (this.fromGallery) {
            getImages();
        }
        this.imageView.setOnTouchListener(new OnSwipeTouchListener(this));
        this.retakeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (image_editor.this.picsTaken <= 0) {
                    Toast.makeText(image_editor.this, "Press add or gallery button to take images", 0).show();
                } else if (image_editor.this.cameraNo == 0) {
                    image_editor.this.firsttimeCam = 1;
                    image_editor.this.cameraLayoutAnimation();
                    image_editor.this.cameraParametersVisibilityGONE();
                } else if (image_editor.this.cameraNo == 1) {
                    if (ContextCompat.checkSelfPermission(image_editor.this, "android.permission.CAMERA") != 0) {
                        ActivityCompat.requestPermissions(image_editor.this, new String[]{"android.permission.CAMERA"}, 300);
                        return;
                    }
                    image_editor.this.dispatchTakePictureIntent();
                    image_editor.this.newImage = false;
                } else if (image_editor.this.cameraNo == 2) {
                    Intent intent = new Intent(image_editor.this, NewCustomCamera.class);
                    intent.putExtra("fromActivity", 3);
                    image_editor.this.startActivityForResult(intent, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                }
            }
        });
        this.cropButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (image_editor.this.picsTaken > 0) {
                    CropImage.activity(image_editor.this.uris.get(image_editor.this.picDisplay - 1)).start(image_editor.this);
                } else {
                    Toast.makeText(image_editor.this, "Press add or gallery button to take images", 0).show();
                }
            }
        });
        this.addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (image_editor.this.cameraNo == 0) {
                    image_editor.this.firsttimeCam = 2;
                    image_editor.this.cameraLayoutAnimation();
                    image_editor.this.cameraParametersVisibilityGONE();
                } else if (image_editor.this.cameraNo == 1) {
                    if (image_editor.this.picsTaken >= 50) {
                        return;
                    }
                    if (ContextCompat.checkSelfPermission(image_editor.this, "android.permission.CAMERA") != 0) {
                        ActivityCompat.requestPermissions(image_editor.this, new String[]{"android.permission.CAMERA"}, 300);
                        return;
                    }
                    image_editor.this.dispatchTakePictureIntent();
                    image_editor.this.newImage = true;
                } else if (image_editor.this.cameraNo != 2) {
                } else {
                    if (image_editor.this.picsTaken < 50) {
                        Intent intent = new Intent(image_editor.this, NewCustomCamera.class);
                        intent.putExtra("picstaken", image_editor.this.picsTaken);
                        intent.putExtra("fromActivity", 2);
                        image_editor.this.startActivityForResult(intent, 150);
                        image_editor.this.newImage = true;
                        return;
                    }
                    Toast.makeText(image_editor.this, "Images limit reached", 0).show();
                }
            }
        });
        this.cameraBackgroundView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                image_editor.this.cameraLayoutAnimation();
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        image_editor.this.cameraParametersVisibilityVISIBLE();
                    }
                }, 100);
            }
        });
        this.nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (image_editor.this.picsTaken == 0) {
                    Toast.makeText(image_editor.this, "No Images selected or captured", 0).show();
                }
                if (image_editor.this.picsTaken > 0) {
                    image_editor.this.loading.setVisibility(0);
                    image_editor.this.loadingText.setVisibility(0);
                    image_editor.this.loadingBg.setVisibility(0);
                    image_editor.this.nextButton.setVisibility(8);
                    image_editor.this.editorGallery.setVisibility(8);
                    image_editor.this.cropButton.setVisibility(8);
                    image_editor.this.addButton.setVisibility(8);
                    image_editor.this.retakeButton.setVisibility(8);
                    image_editor.this.editorDelete.setVisibility(8);
                    image_editor.this.anim.start();
                    new Thread(new Runnable() {
                        public void run() {
                            TextRecognizer build = new TextRecognizer.Builder(image_editor.this.getApplicationContext()).build();
                            for (int i = 0; i < image_editor.this.imagesArray.size(); i++) {
                                if (build.isOperational()) {
                                    SparseArray<TextBlock> detect = build.detect(new Frame.Builder().setBitmap(image_editor.this.imagesArray.get(i)).build());
                                    StringBuilder sb = new StringBuilder();
                                    for (int i2 = 0; i2 < detect.size(); i2++) {
                                        sb.append(detect.valueAt(i2).getValue() + " ");
                                    }
                                    image_editor.this.scannedText = sb.toString();
                                    image_editor.this.recognizedText.add(image_editor.this.scannedText);
                                }
                            }
                            image_editor.this.anim.stop();
                            Intent intent = new Intent(image_editor.this, text_recognizer.class);
                            intent.putExtra("recognizedText", image_editor.this.recognizedText);
                            image_editor.this.startActivity(intent);
                            image_editor.this.nextPressed = false;
                            image_editor.this.recognizedText.clear();
                        }
                    }).start();
                }
            }
        });
        this.editorGallery.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                image_editor.this.getImages();
            }
        });
        this.editorDelete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (image_editor.this.picsTaken > 0) {
                    image_editor.this.uris.remove(image_editor.this.picDisplay - 1);
                    image_editor image_editor = image_editor.this;
                    image_editor.picsTaken--;
                    image_editor.this.imagesArray.remove(image_editor.this.picDisplay - 1);
                    Toast.makeText(image_editor.this, "Image deleted", 0).show();
                    if (image_editor.this.picsTaken > 0) {
                        if (image_editor.this.picsTaken < image_editor.this.picDisplay) {
                            image_editor image_editor2 = image_editor.this;
                            image_editor2.picDisplay--;
                            image_editor.this.imagesSelected.setText(String.valueOf(image_editor.this.picDisplay) + "/50");
                        }
                        image_editor image_editor3 = image_editor.this;
                        image_editor3.imagebitmap = image_editor3.imagesArray.get(image_editor.this.picDisplay - 1);
                        image_editor.this.imageView.setImageBitmap(image_editor.this.imagebitmap);
                        return;
                    }
                    image_editor.this.finish();
                    return;
                }
                Toast.makeText(image_editor.this, "Press add or gallery button to take images", 0).show();
            }
        });
        this.customCameraButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                image_editor.this.cameraLayoutAnimation();
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        image_editor.this.cameraParametersVisibilityVISIBLE();
                    }
                }, 1000);
                image_editor.this.cameraNo = 2;
                if (image_editor.this.firsttimeCam == 1) {
                    if (image_editor.this.picsTaken < 50) {
                        Intent intent = new Intent(image_editor.this, NewCustomCamera.class);
                        intent.putExtra("fromActivity", 3);
                        image_editor.this.startActivityForResult(intent, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                    }
                } else if (image_editor.this.firsttimeCam != 2) {
                } else {
                    if (image_editor.this.picsTaken < 50) {
                        Intent intent2 = new Intent(image_editor.this, NewCustomCamera.class);
                        intent2.putExtra("picstaken", image_editor.this.picsTaken);
                        intent2.putExtra("fromActivity", 2);
                        image_editor.this.startActivityForResult(intent2, 150);
                        image_editor.this.newImage = true;
                        return;
                    }
                    Toast.makeText(image_editor.this, "Images limit reached", 0).show();
                }
            }
        });
        this.phoneCameraButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                image_editor.this.cameraLayoutAnimation();
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        image_editor.this.cameraParametersVisibilityVISIBLE();
                    }
                }, 1000);
                image_editor.this.cameraNo = 1;
                if (image_editor.this.firsttimeCam == 1) {
                    if (image_editor.this.picsTaken >= 50) {
                        return;
                    }
                    if (ContextCompat.checkSelfPermission(image_editor.this, "android.permission.CAMERA") != 0) {
                        ActivityCompat.requestPermissions(image_editor.this, new String[]{"android.permission.CAMERA"}, 300);
                        return;
                    }
                    image_editor.this.dispatchTakePictureIntent();
                    image_editor.this.newImage = false;
                } else if (image_editor.this.firsttimeCam == 2 && image_editor.this.picsTaken < 50) {
                    if (ContextCompat.checkSelfPermission(image_editor.this, "android.permission.CAMERA") != 0) {
                        ActivityCompat.requestPermissions(image_editor.this, new String[]{"android.permission.CAMERA"}, 300);
                        return;
                    }
                    image_editor.this.dispatchTakePictureIntent();
                    image_editor.this.newImage = true;
                }
            }
        });
        this.camBackgroundLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        this.loading.setVisibility(4);
        this.loadingText.setVisibility(4);
        this.loadingBg.setVisibility(4);
        this.nextButton.setVisibility(0);
        this.editorGallery.setVisibility(0);
        this.cropButton.setVisibility(0);
        this.addButton.setVisibility(0);
        this.retakeButton.setVisibility(0);
        this.editorDelete.setVisibility(0);
        super.onRestart();
    }

    private void setUi() {
        this.upperToolbar = (Toolbar) findViewById(C2049R.C2052id.upperToolbar);
        this.lowerToolbar = (Toolbar) findViewById(C2049R.C2052id.lowerToolbar);
        this.retakeButton = (Button) findViewById(C2049R.C2052id.retakeButton);
        this.nextButton = (Button) findViewById(C2049R.C2052id.nextButton);
        this.cropButton = (Button) findViewById(C2049R.C2052id.cropButton);
        this.addButton = (Button) findViewById(C2049R.C2052id.addButton);
        this.editorGallery = (Button) findViewById(C2049R.C2052id.editorGallery);
        this.editorDelete = (Button) findViewById(C2049R.C2052id.editorDelete);
        this.imageView = (ImageView) findViewById(C2049R.C2052id.imageView);
        this.imagesSelected = (TextView) findViewById(C2049R.C2052id.imagesSelected);
        ImageView imageView2 = (ImageView) findViewById(C2049R.C2052id.loadingImageView);
        this.loading = imageView2;
        this.anim = (AnimationDrawable) imageView2.getDrawable();
        this.loadingBg = findViewById(C2049R.C2052id.loadingBG);
        this.loadingText = (TextView) findViewById(C2049R.C2052id.loadingTextView);
        this.imagesArray = new ArrayList<>();
        this.recognizedText = new ArrayList<>();
        this.photopaths = new ArrayList<>();
        this.uris = new ArrayList<>();
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.loading.getLayoutParams();
        int i = (width * 40) / 100;
        marginLayoutParams.height = i;
        marginLayoutParams.width = i;
        this.loading.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.upperToolbar.getLayoutParams();
        int i2 = (height * 7) / 100;
        marginLayoutParams2.height = i2;
        this.upperToolbar.setLayoutParams(marginLayoutParams2);
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.nextButton.getLayoutParams();
        int i3 = (height * 5) / 100;
        marginLayoutParams3.height = i3;
        marginLayoutParams3.width = i2;
        marginLayoutParams3.setMargins(0, 0, (height * 1) / 100, 0);
        this.nextButton.setLayoutParams(marginLayoutParams3);
        ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) this.lowerToolbar.getLayoutParams();
        marginLayoutParams4.height = (height * 13) / 100;
        this.lowerToolbar.setLayoutParams(marginLayoutParams4);
        ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) this.editorGallery.getLayoutParams();
        int i4 = (height * 4) / 100;
        marginLayoutParams5.height = i4;
        marginLayoutParams5.width = i4;
        this.editorGallery.setLayoutParams(marginLayoutParams5);
        ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) this.cropButton.getLayoutParams();
        marginLayoutParams6.height = i3;
        marginLayoutParams6.width = i3;
        this.cropButton.setLayoutParams(marginLayoutParams6);
        ViewGroup.MarginLayoutParams marginLayoutParams7 = (ViewGroup.MarginLayoutParams) this.addButton.getLayoutParams();
        marginLayoutParams7.height = i2;
        marginLayoutParams7.width = i2;
        this.addButton.setLayoutParams(marginLayoutParams7);
        ViewGroup.MarginLayoutParams marginLayoutParams8 = (ViewGroup.MarginLayoutParams) this.retakeButton.getLayoutParams();
        marginLayoutParams8.height = i3;
        marginLayoutParams8.width = i3;
        this.retakeButton.setLayoutParams(marginLayoutParams8);
        ViewGroup.MarginLayoutParams marginLayoutParams9 = (ViewGroup.MarginLayoutParams) this.editorDelete.getLayoutParams();
        marginLayoutParams9.height = i4;
        marginLayoutParams9.width = i4;
        this.editorDelete.setLayoutParams(marginLayoutParams9);
    }

    /* access modifiers changed from: private */
    public void dispatchTakePictureIntent() {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        try {
            File createTempFile = File.createTempFile("Handwriter_" + format, ".jpg", getExternalFilesDir(Environment.DIRECTORY_PICTURES));
            this.currentPhotoPath = createTempFile.getAbsolutePath();
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            Uri uriForFile = FileProvider.getUriForFile(this, "com.xsar.handwriter.fileprovider", createTempFile);
            this.imageUri = uriForFile;
            intent.putExtra("output", uriForFile);
            startActivityForResult(intent, 200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 200 && i2 == -1) {
            Bitmap decodeFile = BitmapFactory.decodeFile(this.currentPhotoPath);
            try {
                int attributeInt = new ExifInterface(this.currentPhotoPath).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
                if (attributeInt == 3) {
                    decodeFile = TransformationUtils.rotateImage(decodeFile, 180);
                } else if (attributeInt == 6) {
                    decodeFile = TransformationUtils.rotateImage(decodeFile, 90);
                } else if (attributeInt == 8) {
                    decodeFile = TransformationUtils.rotateImage(decodeFile, TIFFConstants.TIFFTAG_IMAGEDESCRIPTION);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.imagecaptured = true;
            this.imagebitmap = decodeFile;
            this.imageView.setImageBitmap(decodeFile);
            Uri uri = this.imageUri;
            this.imageuri = uri;
            if (this.newImage) {
                this.uris.add(uri);
                int i3 = this.picsTaken + 1;
                this.picsTaken = i3;
                this.picDisplay = i3;
                this.imagesSelected.setText(String.valueOf(this.picsTaken) + "/50");
                this.imagesArray.add(decodeFile);
            } else {
                this.uris.set(this.picDisplay - 1, uri);
                this.imagesArray.set(this.picDisplay - 1, decodeFile);
                this.newImage = true;
            }
            this.lastBitmapAdded = true;
        }
        if (i == 120 && i2 == -1) {
            this.fromGallery = false;
            ClipData clipData = intent.getClipData();
            if (clipData != null) {
                int itemCount = clipData.getItemCount();
                if (this.picsTaken == 0 && itemCount == 0) {
                    finish();
                }
                int i4 = this.picsTaken;
                if (itemCount > 50 - i4) {
                    itemCount = 50 - i4;
                }
                int i5 = i4 + itemCount;
                this.picsTaken = i5;
                this.picDisplay = i5;
                for (int i6 = 0; i6 < itemCount; i6++) {
                    Uri uri2 = clipData.getItemAt(i6).getUri();
                    try {
                        this.imagesArray.add(BitmapFactory.decodeStream(getContentResolver().openInputStream(uri2)));
                        this.uris.add(uri2);
                    } catch (FileNotFoundException e2) {
                        e2.printStackTrace();
                    }
                }
                this.imageuri = this.imageUri;
                Bitmap bitmap = this.imagesArray.get(this.picsTaken - 1);
                this.imagebitmap = bitmap;
                this.imageView.setImageBitmap(bitmap);
                this.imagesSelected.setText(String.valueOf(this.picDisplay) + "/50");
                this.lastBitmapAdded = true;
            } else {
                Uri data = intent.getData();
                this.picsTaken++;
                try {
                    this.imagesArray.add(BitmapFactory.decodeStream(getContentResolver().openInputStream(data)));
                } catch (FileNotFoundException e3) {
                    e3.printStackTrace();
                }
                this.imageuri = data;
                this.uris.add(data);
                Bitmap bitmap2 = this.imagesArray.get(this.picsTaken - 1);
                this.imagebitmap = bitmap2;
                this.imageView.setImageBitmap(bitmap2);
                this.imagesSelected.setText(String.valueOf(this.picDisplay) + "/50");
                this.lastBitmapAdded = true;
                this.picDisplay = this.picsTaken;
            }
        }
        if (i == 203) {
            CropImage.ActivityResult activityResult = CropImage.getActivityResult(intent);
            if (i2 == -1) {
                this.imageView.setImageURI(activityResult.getUri());
                this.uris.set(this.picDisplay - 1, activityResult.getUri());
                try {
                    Bitmap bitmap3 = MediaStore.Images.Media.getBitmap(getContentResolver(), activityResult.getUri());
                    this.imagebitmap = bitmap3;
                    this.imagesArray.set(this.picDisplay - 1, bitmap3);
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } else if (i2 == 204) {
                Toast.makeText(this, "Cropping failed: " + activityResult.getError(), 1).show();
            }
        }
        if (i == 150 && i2 == -1) {
            boolean z = intent.getExtras().getBoolean("fromGallery");
            this.fromGallery = z;
            if (z) {
                getImages();
            } else {
                this.newUris = intent.getStringArrayListExtra("imagesCaptured");
                cameraImages();
            }
        }
        if (i == 250 && i2 == -1) {
            String stringExtra = intent.getStringExtra("imagesCaptured");
            this.uris.set(this.picDisplay - 1, Uri.fromFile(new File(stringExtra)));
            Bitmap decodeFile2 = BitmapFactory.decodeFile(stringExtra);
            this.imagebitmap = decodeFile2;
            this.imagesArray.set(this.picDisplay - 1, decodeFile2);
            this.imageView.setImageBitmap(this.imagebitmap);
        }
    }

    /* access modifiers changed from: private */
    public void prevImageDisplay() {
        int i = this.picDisplay;
        if (i > 1) {
            this.imagesArray.set(i - 1, this.imagebitmap);
            int i2 = this.picDisplay - 1;
            this.picDisplay = i2;
            this.imageView.setImageBitmap(this.imagesArray.get(i2 - 1));
            this.imagebitmap = this.imagesArray.get(this.picDisplay - 1);
            TextView textView = this.imagesSelected;
            textView.setText(String.valueOf(this.picDisplay) + "/50");
        }
    }

    /* access modifiers changed from: private */
    public void nextImageDisplay() {
        int i = this.picDisplay;
        if (i < this.picsTaken) {
            this.imagesArray.set(i - 1, this.imagebitmap);
            int i2 = this.picDisplay + 1;
            this.picDisplay = i2;
            this.imageView.setImageBitmap(this.imagesArray.get(i2 - 1));
            this.imagebitmap = this.imagesArray.get(this.picDisplay - 1);
            TextView textView = this.imagesSelected;
            textView.setText(String.valueOf(this.picDisplay) + "/50");
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 100) {
            if (iArr[0] == 0) {
                getImages();
                Toast.makeText(this, "Permission Granted!", 0).show();
                return;
            }
            finish();
            Toast.makeText(this, "Storage Permission required to access Photos", 0).show();
        } else if (i != 300) {
        } else {
            if (iArr[0] == 0) {
                dispatchTakePictureIntent();
                return;
            }
            finish();
            Toast.makeText(this, "Camera Permission required to take pictures", 0).show();
        }
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        if (this.exportPressed) {
            cameraLayoutAnimation();
            this.customCameraButton.setVisibility(8);
            this.phoneCameraButton.setVisibility(8);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    image_editor.this.cameraParametersVisibilityVISIBLE();
                }
            }, 100);
            return;
        }
        File externalFilesDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        String[] list = externalFilesDir.list();
        for (String file : list) {
            new File(externalFilesDir, file).delete();
        }
        finish();
    }

    /* access modifiers changed from: private */
    public void getImages() {
        if (ActivityCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 100);
            return;
        }
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        startActivityForResult(intent, 120);
    }

    private void cameraImages() {
        Bitmap bitmap;
        for (int i = 0; i < this.newUris.size(); i++) {
            this.uris.add(Uri.fromFile(new File(this.newUris.get(i))));
            this.imagebitmap = BitmapFactory.decodeFile(this.newUris.get(i));
            try {
                int attributeInt = new ExifInterface(this.newUris.get(i)).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
                if (attributeInt == 3) {
                    bitmap = TransformationUtils.rotateImage(this.imagebitmap, 180);
                } else if (attributeInt != 6) {
                    bitmap = attributeInt != 8 ? this.imagebitmap : TransformationUtils.rotateImage(this.imagebitmap, TIFFConstants.TIFFTAG_IMAGEDESCRIPTION);
                } else {
                    bitmap = TransformationUtils.rotateImage(this.imagebitmap, 90);
                }
                this.imagebitmap = bitmap;
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.imagesArray.add(this.imagebitmap);
            int i2 = this.picsTaken + 1;
            this.picsTaken = i2;
            this.picDisplay = i2;
        }
        this.imageView.setImageBitmap(this.imagebitmap);
        TextView textView = this.imagesSelected;
        textView.setText(String.valueOf(this.picDisplay) + "/50");
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
                    image_editor.this.prevImageDisplay();
                    return true;
                }
                image_editor.this.nextImageDisplay();
                return true;
            }
        }
    }

    /* access modifiers changed from: private */
    public void cameraLayoutAnimation() {
        if (!this.exportPressed) {
            this.cameraBackgroundView.startAnimation(this.fadeIn2);
            this.cameraBackgroundView.setVisibility(0);
            this.camBackgroundLayout.startAnimation(this.fromBottom2);
            this.camBackgroundLayout.setVisibility(0);
            this.customCameraButton.setVisibility(0);
            this.phoneCameraButton.setVisibility(0);
            this.exportPressed = true;
            return;
        }
        this.cameraBackgroundView.startAnimation(this.fadeOut2);
        this.cameraBackgroundView.setVisibility(4);
        this.camBackgroundLayout.startAnimation(this.toBottom2);
        this.camBackgroundLayout.setVisibility(4);
        this.customCameraButton.setVisibility(4);
        this.phoneCameraButton.setVisibility(4);
        this.exportPressed = false;
    }

    /* access modifiers changed from: private */
    public void cameraParametersVisibilityGONE() {
        this.nextButton.setVisibility(8);
        this.editorGallery.setVisibility(8);
        this.cropButton.setVisibility(8);
        this.addButton.setVisibility(8);
        this.editorDelete.setVisibility(8);
        this.retakeButton.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void cameraParametersVisibilityVISIBLE() {
        this.nextButton.setVisibility(0);
        this.editorGallery.setVisibility(0);
        this.cropButton.setVisibility(0);
        this.addButton.setVisibility(0);
        this.editorDelete.setVisibility(0);
        this.retakeButton.setVisibility(0);
    }
}
