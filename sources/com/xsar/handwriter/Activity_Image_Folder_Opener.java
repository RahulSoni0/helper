package com.xsar.handwriter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.itextpdf.text.xml.xmp.PdfSchema;
import java.io.File;
import java.util.ArrayList;

public class Activity_Image_Folder_Opener extends AppCompatActivity {
    public ArrayList<Bitmap> capturedImages;
    customAdapter customAdap;
    ImageButton deleteImage;
    public ArrayList<Long> fileSize;
    public ArrayList<Long> filedate;
    public ArrayList<String> filenames;
    String filepath;
    public ArrayList<String> filepaths;
    public ArrayList<File> filesfolder;
    final String[] folderExtension = {PdfSchema.DEFAULT_XPATH_ID, "txt", "zip", "mp3", "mp4", "rar", "apk"};
    final String[] imageExtension = {"jpg", "png", "jpeg"};
    /* access modifiers changed from: private */
    public boolean imageOpen = false;
    GridView images;
    String name;
    ImageView openImageView;
    /* access modifiers changed from: private */
    public int selected = 0;
    SwipeRefreshLayout swipeRefreshLayout;
    /* access modifiers changed from: private */
    public int totalImages = 0;

    static /* synthetic */ int access$010(Activity_Image_Folder_Opener activity_Image_Folder_Opener) {
        int i = activity_Image_Folder_Opener.selected;
        activity_Image_Folder_Opener.selected = i - 1;
        return i;
    }

    static /* synthetic */ int access$110(Activity_Image_Folder_Opener activity_Image_Folder_Opener) {
        int i = activity_Image_Folder_Opener.totalImages;
        activity_Image_Folder_Opener.totalImages = i - 1;
        return i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2049R.layout.activity__image__folder__opener);
        this.filenames = new ArrayList<>();
        this.filepaths = new ArrayList<>();
        this.filedate = new ArrayList<>();
        this.fileSize = new ArrayList<>();
        this.filesfolder = new ArrayList<>();
        this.capturedImages = new ArrayList<>();
        this.images = (GridView) findViewById(C2049R.C2052id.imagesGrid2);
        this.openImageView = (ImageView) findViewById(C2049R.C2052id.OpenImageView);
        this.deleteImage = (ImageButton) findViewById(C2049R.C2052id.deleteImageInFolder);
        this.openImageView.setOnTouchListener(new OnSwipeTouchListener(this));
        this.openImageView.setVisibility(4);
        this.name = getIntent().getStringExtra("send");
        if (Build.VERSION.SDK_INT >= 30) {
            this.filepath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath();
        } else {
            this.filepath = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        this.filepath += "/HandWriter/Images/" + this.name;
        setSupportActionBar((Toolbar) findViewById(C2049R.C2052id.toolbarOpener));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle((CharSequence) this.name);
        File file = new File(this.filepath);
        if (!file.exists()) {
            file.mkdirs();
        } else if (file.list().length == 0) {
            Toast.makeText(this, "No images found..!", 0).show();
        }
        for (File file2 : file.listFiles()) {
            for (String endsWith : this.imageExtension) {
                if (file2.getName().toLowerCase().endsWith(endsWith)) {
                    this.filenames.add(file2.getName());
                    this.filepaths.add(file2.getAbsolutePath());
                    this.filedate.add(Long.valueOf(file2.lastModified()));
                    this.fileSize.add(Long.valueOf(file2.length()));
                    this.filesfolder.add(file2);
                    this.capturedImages.add(BitmapFactory.decodeFile(file2.getAbsolutePath()));
                }
            }
            for (String endsWith2 : this.folderExtension) {
                if (file2.getName().toLowerCase().endsWith(endsWith2)) {
                    Toast.makeText(this, "No images found..!", 0).show();
                }
            }
        }
        this.totalImages = this.capturedImages.size();
        customAdapter customadapter = new customAdapter();
        this.customAdap = customadapter;
        this.images.setAdapter(customadapter);
        SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) findViewById(C2049R.C2052id.swipeRefreshOpener);
        this.swipeRefreshLayout = swipeRefreshLayout2;
        swipeRefreshLayout2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                Activity_Image_Folder_Opener.this.swipeRefreshLayout.setRefreshing(false);
            }
        });
        this.deleteImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                new File(Activity_Image_Folder_Opener.this.filepath, Activity_Image_Folder_Opener.this.filenames.get(Activity_Image_Folder_Opener.this.selected)).delete();
                Activity_Image_Folder_Opener.this.capturedImages.remove(Activity_Image_Folder_Opener.this.selected);
                Activity_Image_Folder_Opener.access$110(Activity_Image_Folder_Opener.this);
                if (Activity_Image_Folder_Opener.this.selected == Activity_Image_Folder_Opener.this.totalImages) {
                    Activity_Image_Folder_Opener.access$010(Activity_Image_Folder_Opener.this);
                    Activity_Image_Folder_Opener.this.openImageView.setImageBitmap(Activity_Image_Folder_Opener.this.capturedImages.get(Activity_Image_Folder_Opener.this.selected));
                } else {
                    Activity_Image_Folder_Opener.this.openImageView.setImageBitmap(Activity_Image_Folder_Opener.this.capturedImages.get(Activity_Image_Folder_Opener.this.selected));
                }
                Toast.makeText(Activity_Image_Folder_Opener.this, "Image deleted", 0).show();
            }
        });
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
            return Activity_Image_Folder_Opener.this.capturedImages.size();
        }

        public View getView(final int i, View view, ViewGroup viewGroup) {
            int width = Activity_Image_Folder_Opener.this.getWindowManager().getDefaultDisplay().getWidth();
            View inflate = Activity_Image_Folder_Opener.this.getLayoutInflater().inflate(C2049R.layout.activity_finimg, (ViewGroup) null);
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
            imageButton.setBackground(new BitmapDrawable(Activity_Image_Folder_Opener.this.getResources(), Activity_Image_Folder_Opener.this.capturedImages.get(i)));
            imageButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Activity_Image_Folder_Opener.this.getSupportActionBar().setTitle((CharSequence) " ");
                    Activity_Image_Folder_Opener.this.openImageView.setVisibility(0);
                    Activity_Image_Folder_Opener.this.deleteImage.setVisibility(0);
                    Activity_Image_Folder_Opener.this.openImageView.setImageBitmap(Activity_Image_Folder_Opener.this.capturedImages.get(i));
                    Activity_Image_Folder_Opener.this.images.setVisibility(8);
                    boolean unused = Activity_Image_Folder_Opener.this.imageOpen = true;
                    int unused2 = Activity_Image_Folder_Opener.this.selected = i;
                }
            });
            return inflate;
        }
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        if (this.imageOpen) {
            this.openImageView.setVisibility(4);
            this.images.setVisibility(0);
            this.deleteImage.setVisibility(8);
            getSupportActionBar().setTitle((CharSequence) this.name);
            this.imageOpen = false;
            this.filenames.clear();
            this.filepaths.clear();
            this.filedate.clear();
            this.fileSize.clear();
            this.filesfolder.clear();
            this.capturedImages.clear();
            File file = new File(this.filepath);
            if (!file.exists()) {
                file.mkdirs();
            } else if (file.list().length == 0) {
                Toast.makeText(this, "No images found..!", 0).show();
            }
            for (File file2 : file.listFiles()) {
                for (String endsWith : this.imageExtension) {
                    if (file2.getName().toLowerCase().endsWith(endsWith)) {
                        this.filenames.add(file2.getName());
                        this.filepaths.add(file2.getAbsolutePath());
                        this.filedate.add(Long.valueOf(file2.lastModified()));
                        this.fileSize.add(Long.valueOf(file2.length()));
                        this.filesfolder.add(file2);
                        this.capturedImages.add(BitmapFactory.decodeFile(file2.getAbsolutePath()));
                    }
                }
                for (String endsWith2 : this.folderExtension) {
                    if (file2.getName().toLowerCase().endsWith(endsWith2)) {
                        Toast.makeText(this, "No images found..!", 0).show();
                    }
                }
            }
            this.images.setAdapter(new customAdapter());
            return;
        }
        finish();
    }

    /* access modifiers changed from: private */
    public void nextImageDisplay() {
        int i = this.selected;
        if (i < this.totalImages - 1) {
            this.openImageView.setImageBitmap(this.capturedImages.get(i + 1));
            this.selected++;
        }
    }

    /* access modifiers changed from: private */
    public void prevImageDisplay() {
        int i = this.selected;
        if (i > 0) {
            int i2 = i - 1;
            this.selected = i2;
            this.openImageView.setImageBitmap(this.capturedImages.get(i2));
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
                    Activity_Image_Folder_Opener.this.prevImageDisplay();
                    return true;
                }
                Activity_Image_Folder_Opener.this.nextImageDisplay();
                return true;
            }
        }
    }
}
