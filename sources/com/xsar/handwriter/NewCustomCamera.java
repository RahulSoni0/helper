package com.xsar.handwriter;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlinx.coroutines.DebugKt;

public class  NewCustomCamera extends AppCompatActivity {
    Camera camera;
    Button captureButton;
    boolean captureFinished = true;
    Animation captureanim;
    float cfBottom;
    float cfTop;
    Toolbar customCamToolbar1;
    Toolbar customCamToolbar2;
    FrameLayout customFramelayout;
    LinearLayout customRL;
    float fbSize;
    public File file;
    ArrayList<String> fileUris;
    float finalHeight;
    float finalWidth;
    boolean firrstImageCaptured = false;
    Animation flash1anim;
    Animation flash2anim;
    Button flashButton;
    ImageView flashImage1;
    ImageView flashImage2;
    ImageView flashImage3;
    int flashmode = 1;
    Animation focusAnim;
    Button focusButton;
    int fromActivity;
    Button galleryButton;
    float heightRatio;
    Button imagesCaptured;
    ImageButton imagesCaptured2;
    int imagesCapturedno = 0;
    Button imagesNo;
    private Camera.AutoFocusCallback mAutoFocusTakePictureCallback = new Camera.AutoFocusCallback() {
        public void onAutoFocus(boolean z, Camera camera) {
        }
    };
    Camera.PictureCallback mPictureCallback = new Camera.PictureCallback() {
        public void onPictureTaken(byte[] bArr, Camera camera) {
            try {
                NewCustomCamera.this.file = File.createTempFile("Handwriter_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()), ".jpg", NewCustomCamera.this.getExternalFilesDir(Environment.DIRECTORY_PICTURES));
                FileOutputStream fileOutputStream = new FileOutputStream(NewCustomCamera.this.file);
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                NewCustomCamera.this.fileUris.add(NewCustomCamera.this.file.getAbsolutePath());
                NewCustomCamera.this.captureFinished = true;
                NewCustomCamera.this.imageCaptured();
                camera.startPreview();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
    Button okButton;
    Camera.Parameters params;
    int picstaken = 0;
    float prevRatio = 0.0f;
    float previewHeight;
    float screenWidth;
    ShowCamera showCamera;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2049R.layout.activity_new_custom_camera);
        this.customFramelayout = (FrameLayout) findViewById(C2049R.C2052id.customCamFrame);
        this.captureButton = (Button) findViewById(C2049R.C2052id.customCamCapture2);
        this.galleryButton = (Button) findViewById(C2049R.C2052id.customgallery2);
        this.imagesCaptured = (Button) findViewById(C2049R.C2052id.customimages21);
        this.imagesNo = (Button) findViewById(C2049R.C2052id.customimagesno2);
        this.imagesCaptured2 = (ImageButton) findViewById(C2049R.C2052id.customimages22);
        this.flashButton = (Button) findViewById(C2049R.C2052id.customflash2);
        this.okButton = (Button) findViewById(C2049R.C2052id.customnext2);
        this.customCamToolbar1 = (Toolbar) findViewById(C2049R.C2052id.customCam2Toolbar);
        this.customCamToolbar2 = (Toolbar) findViewById(C2049R.C2052id.customCam2Toolbar2);
        this.focusButton = (Button) findViewById(C2049R.C2052id.focusButton);
        this.flash1anim = AnimationUtils.loadAnimation(this, C2049R.anim.flashanimation);
        this.flash2anim = AnimationUtils.loadAnimation(this, C2049R.anim.flashanimation2);
        this.captureanim = AnimationUtils.loadAnimation(this, C2049R.anim.captureanimation);
        this.focusAnim = AnimationUtils.loadAnimation(this, C2049R.anim.focusanim1);
        this.flashImage1 = (ImageView) findViewById(C2049R.C2052id.customflashImage1);
        this.flashImage2 = (ImageView) findViewById(C2049R.C2052id.customflashImage2);
        this.flashImage3 = (ImageView) findViewById(C2049R.C2052id.customflashImage3);
        this.fileUris = new ArrayList<>();
        int i = getIntent().getExtras().getInt("fromActivity");
        this.fromActivity = i;
        if (i == 2) {
            this.picstaken = getIntent().getExtras().getInt("picstaken");
        } else if (i == 3) {
            this.galleryButton.setVisibility(4);
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        this.screenWidth = (float) defaultDisplay.getWidth();
        float height = ((((float) defaultDisplay.getHeight()) - ((float) this.customCamToolbar1.getHeight())) - ((float) this.customCamToolbar2.getHeight())) / this.screenWidth;
        Camera open = Camera.open();
        this.camera = open;
        Camera.Parameters parameters = open.getParameters();
        this.params = parameters;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        this.finalHeight = (float) supportedPreviewSizes.get(0).height;
        float f = (float) supportedPreviewSizes.get(0).width;
        this.finalWidth = f;
        this.prevRatio = this.finalHeight / f;
        for (Camera.Size next : supportedPreviewSizes) {
            float f2 = (float) (next.height / next.width);
            if (f2 < height && f2 > this.prevRatio) {
                double d = (double) this.screenWidth;
                Double.isNaN(d);
                if (((double) next.width) > d * 0.7d) {
                    this.finalWidth = (float) next.width;
                    this.finalHeight = (float) next.height;
                    this.prevRatio = f2;
                }
            }
        }
        this.params.setPreviewSize((int) this.finalWidth, (int) this.finalHeight);
        this.params.setPictureSize((int) this.finalWidth, (int) this.finalHeight);
        this.params.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        this.camera.setParameters(this.params);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.customFramelayout.getLayoutParams();
        marginLayoutParams.width = (int) this.screenWidth;
        marginLayoutParams.height = (int) ((this.finalWidth / this.finalHeight) * this.screenWidth);
        this.previewHeight = (this.finalWidth / this.finalHeight) * this.screenWidth;
        this.customFramelayout.setLayoutParams(marginLayoutParams);
        ShowCamera showCamera2 = new ShowCamera(this, this.camera, this.customFramelayout);
        this.showCamera = showCamera2;
        this.customFramelayout.addView(showCamera2);
        this.captureButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (NewCustomCamera.this.captureFinished) {
                    NewCustomCamera.this.captureFinished = false;
                    NewCustomCamera.this.captureButton.startAnimation(NewCustomCamera.this.captureanim);
                    NewCustomCamera.this.CaptureImage(view);
                }
            }
        });
        this.galleryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(NewCustomCamera.this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    ActivityCompat.requestPermissions(NewCustomCamera.this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 200);
                } else if (NewCustomCamera.this.fromActivity == 1) {
                    Intent intent = new Intent(NewCustomCamera.this, image_editor.class);
                    intent.putExtra("fromGallery", true);
                    NewCustomCamera.this.startActivity(intent);
                    NewCustomCamera.this.finish();
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("fromGallery", true);
                    NewCustomCamera.this.setResult(-1, intent2);
                    NewCustomCamera.this.finish();
                }
            }
        });
        this.flashButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (NewCustomCamera.this.firrstImageCaptured) {
                    NewCustomCamera.this.galleryButton.setAnimation((Animation) null);
                    NewCustomCamera.this.okButton.setAnimation((Animation) null);
                    NewCustomCamera.this.imagesCaptured.setAnimation((Animation) null);
                    NewCustomCamera.this.imagesCaptured2.setAnimation((Animation) null);
                    NewCustomCamera.this.imagesNo.setAnimation((Animation) null);
                    NewCustomCamera.this.galleryButton.setVisibility(4);
                }
                if (NewCustomCamera.this.flashmode == 1) {
                    NewCustomCamera.this.flashmode = 2;
                    NewCustomCamera.this.params.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_ON);
                    NewCustomCamera.this.flashImage2.setVisibility(0);
                    NewCustomCamera.this.flashImage1.startAnimation(NewCustomCamera.this.flash1anim);
                    NewCustomCamera.this.flashImage2.startAnimation(NewCustomCamera.this.flash2anim);
                    NewCustomCamera.this.flashImage3.setAnimation((Animation) null);
                    NewCustomCamera.this.camera.setParameters(NewCustomCamera.this.params);
                } else if (NewCustomCamera.this.flashmode == 2) {
                    NewCustomCamera.this.flashmode = 3;
                    NewCustomCamera.this.params.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
                    NewCustomCamera.this.flashImage3.setVisibility(0);
                    NewCustomCamera.this.flashImage2.startAnimation(NewCustomCamera.this.flash1anim);
                    NewCustomCamera.this.flashImage3.startAnimation(NewCustomCamera.this.flash2anim);
                    NewCustomCamera.this.flashImage2.setVisibility(4);
                    NewCustomCamera.this.flashImage1.setAnimation((Animation) null);
                    NewCustomCamera.this.camera.setParameters(NewCustomCamera.this.params);
                } else if (NewCustomCamera.this.flashmode == 3) {
                    NewCustomCamera.this.flashmode = 1;
                    NewCustomCamera.this.params.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                    NewCustomCamera.this.flashImage1.setVisibility(0);
                    NewCustomCamera.this.flashImage3.startAnimation(NewCustomCamera.this.flash1anim);
                    NewCustomCamera.this.flashImage1.startAnimation(NewCustomCamera.this.flash2anim);
                    NewCustomCamera.this.flashImage3.setVisibility(4);
                    NewCustomCamera.this.flashImage2.setAnimation((Animation) null);
                    NewCustomCamera.this.camera.setParameters(NewCustomCamera.this.params);
                }
            }
        });
        this.okButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NewCustomCamera.this.okPressed();
            }
        });
        this.imagesCaptured.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NewCustomCamera.this.okPressed();
            }
        });
        this.customFramelayout.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                NewCustomCamera.this.focusOnTouch(motionEvent);
                return true;
            }
        });
        float y = this.customCamToolbar2.getY() - ((float) this.customCamToolbar1.getHeight());
        float f3 = this.finalHeight;
        float f4 = (y - f3) / 2.0f;
        this.cfTop = f4;
        this.cfBottom = f4 + ((float) ((int) ((this.finalWidth / f3) * this.screenWidth)));
        this.fbSize = (float) (this.focusButton.getWidth() / 2);
    }

    /* access modifiers changed from: private */
    public void focusOnTouch(MotionEvent motionEvent) {
        Camera camera2 = this.camera;
        if (camera2 != null) {
            Camera.Parameters parameters = camera2.getParameters();
            if (parameters.getMaxNumMeteringAreas() > 0) {
                float f = this.screenWidth;
                Rect rect = new Rect(((int) (f / 2.0f)) - 25, ((int) (f / 2.0f)) - 25, ((int) (f / 2.0f)) + 25, ((int) (f / 2.0f)) + 25);
                this.focusButton.setX(motionEvent.getRawX() - ((float) (this.focusButton.getWidth() / 2)));
                this.focusButton.setY(motionEvent.getRawY() - ((float) (this.focusButton.getHeight() / 2)));
                this.focusButton.setVisibility(0);
                this.focusButton.startAnimation(this.focusAnim);
                parameters.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Camera.Area(rect, 800));
                parameters.setFocusAreas(arrayList);
                this.camera.setParameters(parameters);
                this.camera.autoFocus(this.mAutoFocusTakePictureCallback);
                return;
            }
            this.camera.autoFocus(this.mAutoFocusTakePictureCallback);
        }
    }

    public class ShowCamera extends SurfaceView implements SurfaceHolder.Callback {
        Camera camera;
        FrameLayout frameLaout;
        SurfaceHolder holder;
        Camera.Parameters params;
        List<Camera.Size> supportedSizes;

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        public ShowCamera(Context context, Camera camera2, FrameLayout frameLayout) {
            super(context);
            this.camera = camera2;
            this.frameLaout = frameLayout;
            SurfaceHolder holder2 = getHolder();
            this.holder = holder2;
            holder2.addCallback(this);
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Camera.Parameters parameters = this.camera.getParameters();
            this.supportedSizes = this.camera.getParameters().getSupportedPreviewSizes();
            if (getResources().getConfiguration().orientation != 2) {
                parameters.set("orientation", "portrait");
                this.camera.setDisplayOrientation(90);
                parameters.setRotation(90);
            } else {
                parameters.set("orientation", "landscape");
                this.camera.setDisplayOrientation(0);
                parameters.setRotation(0);
            }
            this.camera.setParameters(parameters);
            try {
                this.camera.setPreviewDisplay(this.holder);
                this.camera.startPreview();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.camera.stopPreview();
            this.camera.release();
        }
    }

    public void CaptureImage(View view) {
        Camera camera2 = this.camera;
        if (camera2 != null) {
            camera2.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, this.mPictureCallback);
        }
    }

    /* access modifiers changed from: private */
    public void imageCaptured() {
        int i = this.picstaken + 1;
        this.picstaken = i;
        this.imagesCapturedno++;
        if (i >= 50 || this.fromActivity == 3) {
            int i2 = this.fromActivity;
            if (i2 == 1) {
                Intent intent = new Intent(this, image_editor.class);
                intent.putExtra("imagesCaptured", this.fileUris);
                intent.putExtra("fromGallery", false);
                startActivity(intent);
                finish();
            } else if (i2 == 2) {
                Intent intent2 = new Intent();
                intent2.putExtra("imagesCaptured", this.fileUris);
                intent2.putExtra("fromGallery", false);
                setResult(-1, intent2);
                finish();
            } else {
                Intent intent3 = new Intent();
                intent3.putExtra("imagesCaptured", this.file.getAbsolutePath());
                intent3.putExtra("fromGallery", false);
                setResult(-1, intent3);
                finish();
            }
        } else {
            if (!this.firrstImageCaptured) {
                this.firrstImageCaptured = true;
                this.imagesCaptured.setVisibility(0);
                this.imagesCaptured2.setVisibility(0);
                this.imagesNo.setVisibility(0);
                this.imagesCaptured.startAnimation(this.flash2anim);
                this.imagesCaptured2.startAnimation(this.flash2anim);
                this.imagesNo.startAnimation(this.flash2anim);
                this.galleryButton.startAnimation(this.flash1anim);
                this.okButton.setVisibility(0);
                this.okButton.startAnimation(this.flash2anim);
            }
            this.imagesNo.setText(String.valueOf(this.imagesCapturedno));
            this.imagesCaptured2.setBackground(new BitmapDrawable(getResources(), BitmapFactory.decodeFile(this.file.getAbsolutePath())));
        }
    }

    /* access modifiers changed from: private */
    public void okPressed() {
        if (!this.captureFinished) {
            return;
        }
        if (this.fromActivity == 1) {
            Intent intent = new Intent(this, image_editor.class);
            intent.putExtra("imagesCaptured", this.fileUris);
            intent.putExtra("fromGallery", false);
            intent.putExtra("cameraNo", 2);
            startActivity(intent);
            finish();
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("imagesCaptured", this.fileUris);
        intent2.putExtra("fromGallery", false);
        intent2.putExtra("cameraNo", 2);
        setResult(-1, intent2);
        finish();
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        finish();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 200) {
            if (iArr[0] != 0) {
                Toast.makeText(this, "storage permission required to access images", 0).show();
            } else if (this.fromActivity == 1) {
                Intent intent = new Intent(this, image_editor.class);
                intent.putExtra("fromGallery", true);
                startActivity(intent);
                finish();
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("fromGallery", true);
                setResult(-1, intent2);
                finish();
            }
        }
    }
}
