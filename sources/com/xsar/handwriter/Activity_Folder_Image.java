package com.xsar.handwriter;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Activity_Folder_Image extends AppCompatActivity {
    View deleteBgText;
    Button deleteCancel;
    LinearLayout deleteLayout;
    Button deleteOk;
    public int deleteSelected;
    /* access modifiers changed from: private */
    public Animation fadeIn;
    /* access modifiers changed from: private */
    public Animation fadeIn2;
    /* access modifiers changed from: private */
    public Animation fadeOut;
    /* access modifiers changed from: private */
    public Animation fadeOut2;
    String fileName;
    EditText fileNameText;
    String filePath;
    public ArrayList<Long> fileSize;
    public ArrayList<Long> filedate;
    Button filenamecancelText;
    public ArrayList<String> filenames;
    public ArrayList<String> filepaths;
    public ArrayList<File> filesfolder;
    /* access modifiers changed from: private */
    public Animation fromRight;
    ListView image_files_list;
    View renameBgText;
    public int renameSelected;
    public File renamefrom;
    LinearLayout renamelayoutText;
    Button renameokText;
    boolean savingText = false;
    SwipeRefreshLayout swipeRefreshLayout;
    /* access modifiers changed from: private */
    public Animation toRight;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2049R.layout.activity_folder_image);
        setSupportActionBar((Toolbar) findViewById(C2049R.C2052id.toolbarText));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle((CharSequence) "Saved Image Folders");
        this.renamelayoutText = (LinearLayout) findViewById(C2049R.C2052id.renamelayoutImage);
        this.deleteLayout = (LinearLayout) findViewById(C2049R.C2052id.deleteImage);
        this.deleteOk = (Button) findViewById(C2049R.C2052id.deleteOk);
        this.deleteCancel = (Button) findViewById(C2049R.C2052id.deleteCancel);
        this.renameokText = (Button) findViewById(C2049R.C2052id.renameokText);
        this.filenamecancelText = (Button) findViewById(C2049R.C2052id.renamecancelText);
        this.renameBgText = findViewById(C2049R.C2052id.renameBgText);
        this.deleteBgText = findViewById(C2049R.C2052id.deleteBgText);
        this.fileNameText = (EditText) findViewById(C2049R.C2052id.filenameText);
        this.image_files_list = (ListView) findViewById(C2049R.C2052id.image_files_list);
        this.fadeIn2 = AnimationUtils.loadAnimation(this, C2049R.anim.fadein_slow);
        this.fadeOut2 = AnimationUtils.loadAnimation(this, C2049R.anim.fadeout_slow);
        this.fadeIn = AnimationUtils.loadAnimation(this, C2049R.anim.fadein);
        this.fadeOut = AnimationUtils.loadAnimation(this, C2049R.anim.fadeout);
        this.fromRight = AnimationUtils.loadAnimation(this, C2049R.anim.enter_from_right);
        this.toRight = AnimationUtils.loadAnimation(this, C2049R.anim.exit_to_right);
        renameUI();
        this.filenames = new ArrayList<>();
        this.filepaths = new ArrayList<>();
        this.filedate = new ArrayList<>();
        this.fileSize = new ArrayList<>();
        this.filesfolder = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= 30) {
            this.filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath();
        } else {
            this.filePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        this.filePath += "/HandWriter/Images/";
        File file = new File(this.filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                this.filenames.add(file2.getName());
                this.filepaths.add(file2.getAbsolutePath());
                this.filedate.add(Long.valueOf(file2.lastModified()));
                this.fileSize.add(Long.valueOf(file2.length()));
                this.filesfolder.add(file2);
            }
        }
        final customAdapter customadapter = new customAdapter();
        this.image_files_list.setAdapter(customadapter);
        this.image_files_list.setItemsCanFocus(false);
        SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) findViewById(C2049R.C2052id.swipeRefresh);
        this.swipeRefreshLayout = swipeRefreshLayout2;
        swipeRefreshLayout2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                Activity_Folder_Image.this.filenames.clear();
                Activity_Folder_Image.this.filepaths.clear();
                Activity_Folder_Image.this.filedate.clear();
                Activity_Folder_Image.this.fileSize.clear();
                File file = new File(Activity_Folder_Image.this.filePath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                for (File file2 : file.listFiles()) {
                    if (file2.isDirectory()) {
                        Activity_Folder_Image.this.filenames.add(file2.getName());
                        Activity_Folder_Image.this.filepaths.add(file2.getAbsolutePath());
                        Activity_Folder_Image.this.filedate.add(Long.valueOf(file2.lastModified()));
                        Activity_Folder_Image.this.fileSize.add(Long.valueOf(file2.length()));
                    }
                }
                Activity_Folder_Image.this.image_files_list.setAdapter(new customAdapter());
                Activity_Folder_Image.this.image_files_list.setItemsCanFocus(false);
                Activity_Folder_Image.this.swipeRefreshLayout.setRefreshing(false);
            }
        });
        this.renameokText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Activity_Folder_Image.this.saveToTextFileText();
                Activity_Folder_Image.this.renamelayoutText.startAnimation(Activity_Folder_Image.this.fadeOut);
                Activity_Folder_Image.this.renamelayoutText.setVisibility(4);
                Activity_Folder_Image.this.renameBgText.startAnimation(Activity_Folder_Image.this.fadeOut2);
                Activity_Folder_Image.this.renameBgText.setVisibility(4);
                Activity_Folder_Image.this.savingText = false;
                customadapter.notifyDataSetChanged();
            }
        });
        this.filenamecancelText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Activity_Folder_Image.this.renamelayoutText.startAnimation(Activity_Folder_Image.this.fadeOut);
                Activity_Folder_Image.this.renamelayoutText.setVisibility(4);
                Activity_Folder_Image.this.renamelayoutText.startAnimation(Activity_Folder_Image.this.fadeOut2);
                Activity_Folder_Image.this.renameBgText.setVisibility(4);
                Activity_Folder_Image.this.savingText = false;
            }
        });
        this.renameBgText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Activity_Folder_Image.this.renamelayoutText.startAnimation(Activity_Folder_Image.this.fadeOut);
                Activity_Folder_Image.this.renameBgText.startAnimation(Activity_Folder_Image.this.fadeOut2);
                Activity_Folder_Image.this.renamelayoutText.setVisibility(4);
                Activity_Folder_Image.this.renameBgText.setVisibility(4);
                Activity_Folder_Image.this.savingText = false;
            }
        });
        this.deleteBgText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Activity_Folder_Image.this.deleteLayout.startAnimation(Activity_Folder_Image.this.fadeOut);
                Activity_Folder_Image.this.deleteLayout.setVisibility(4);
                Activity_Folder_Image.this.deleteBgText.startAnimation(Activity_Folder_Image.this.fadeOut2);
                Activity_Folder_Image.this.deleteBgText.setVisibility(4);
            }
        });
        this.deleteOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Activity_Folder_Image.this.deleteFile();
                Activity_Folder_Image.this.deleteLayout.startAnimation(Activity_Folder_Image.this.fadeOut);
                Activity_Folder_Image.this.deleteLayout.setVisibility(4);
                Activity_Folder_Image.this.deleteBgText.startAnimation(Activity_Folder_Image.this.fadeOut2);
                Activity_Folder_Image.this.deleteBgText.setVisibility(4);
                customadapter.notifyDataSetChanged();
                Toast.makeText(Activity_Folder_Image.this, "file deleted", 0).show();
            }
        });
        this.deleteCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Activity_Folder_Image.this.deleteLayout.startAnimation(Activity_Folder_Image.this.fadeOut);
                Activity_Folder_Image.this.deleteLayout.setVisibility(4);
                Activity_Folder_Image.this.deleteBgText.startAnimation(Activity_Folder_Image.this.fadeOut2);
                Activity_Folder_Image.this.deleteBgText.setVisibility(4);
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
            return Activity_Folder_Image.this.filenames.size();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            String str;
            final int i2 = i;
            View inflate = Activity_Folder_Image.this.getLayoutInflater().inflate(C2049R.layout.image_apps_layout, (ViewGroup) null);
            ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(C2049R.C2052id.image_file_but);
            TextView textView = (TextView) inflate.findViewById(C2049R.C2052id.image_file_size);
            View findViewById = inflate.findViewById(C2049R.C2052id.MenuOptionsBgText);
            ((TextView) inflate.findViewById(C2049R.C2052id.image_file_but1)).setText(Activity_Folder_Image.this.filenames.get(i2));
            ImageButton imageButton = (ImageButton) inflate.findViewById(C2049R.C2052id.showMenu);
            ImageButton imageButton2 = (ImageButton) inflate.findViewById(C2049R.C2052id.menuClose);
            ImageButton imageButton3 = (ImageButton) inflate.findViewById(C2049R.C2052id.renameButtonMenu);
            ImageButton imageButton4 = (ImageButton) inflate.findViewById(C2049R.C2052id.deleteButtonMenu);
            final ImageButton imageButton5 = (ImageButton) inflate.findViewById(C2049R.C2052id.shareButtonMenu);
            constraintLayout.setTag(Integer.valueOf(i));
            ((TextView) inflate.findViewById(C2049R.C2052id.image_file_details)).setText(String.valueOf(new SimpleDateFormat("dd/MM/yyyy ").format(Activity_Folder_Image.this.filedate.get(i2))));
            long longValue = Activity_Folder_Image.this.fileSize.get(i2).longValue();
            if (longValue > PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
                longValue /= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                if (longValue > PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
                    longValue /= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                    str = "MB";
                } else {
                    str = "KB";
                }
            } else {
                str = "B";
            }
            textView.setText(longValue + str);
            constraintLayout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Folder_Image.this, Activity_Image_Folder_Opener.class);
                    intent.putExtra("send", Activity_Folder_Image.this.filenames.get(i2));
                    Activity_Folder_Image.this.startActivity(intent);
                }
            });
            final View view2 = findViewById;
            final ImageButton imageButton6 = imageButton;
            final ImageButton imageButton7 = imageButton2;
            final ImageButton imageButton8 = imageButton3;
            C19082 r8 = r0;
            final ImageButton imageButton9 = imageButton4;
            C19082 r0 = new View.OnClickListener() {
                public void onClick(View view) {
                    view2.setVisibility(0);
                    imageButton6.startAnimation(Activity_Folder_Image.this.fadeOut);
                    imageButton6.setVisibility(4);
                    imageButton7.startAnimation(Activity_Folder_Image.this.fadeIn2);
                    imageButton7.setVisibility(0);
                    imageButton8.startAnimation(Activity_Folder_Image.this.fromRight);
                    imageButton8.setVisibility(0);
                    imageButton9.startAnimation(Activity_Folder_Image.this.fromRight);
                    imageButton9.setVisibility(0);
                    imageButton5.startAnimation(Activity_Folder_Image.this.fromRight);
                    imageButton5.setVisibility(0);
                }
            };
            imageButton.setOnClickListener(r8);
            findViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    view2.setVisibility(4);
                    imageButton6.startAnimation(Activity_Folder_Image.this.fadeIn2);
                    imageButton6.setVisibility(0);
                    imageButton7.startAnimation(Activity_Folder_Image.this.fadeOut);
                    imageButton7.setVisibility(4);
                    imageButton8.startAnimation(Activity_Folder_Image.this.toRight);
                    imageButton8.setVisibility(4);
                    imageButton9.startAnimation(Activity_Folder_Image.this.toRight);
                    imageButton9.setVisibility(4);
                    imageButton5.startAnimation(Activity_Folder_Image.this.toRight);
                    imageButton5.setVisibility(4);
                }
            });
            imageButton2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    view2.setVisibility(4);
                    imageButton6.startAnimation(Activity_Folder_Image.this.fadeIn2);
                    imageButton6.setVisibility(0);
                    imageButton7.startAnimation(Activity_Folder_Image.this.fadeOut);
                    imageButton7.setVisibility(4);
                    imageButton8.startAnimation(Activity_Folder_Image.this.toRight);
                    imageButton8.setVisibility(4);
                    imageButton9.startAnimation(Activity_Folder_Image.this.toRight);
                    imageButton9.setVisibility(4);
                    imageButton5.startAnimation(Activity_Folder_Image.this.toRight);
                    imageButton5.setVisibility(4);
                }
            });
            final int i3 = i;
            imageButton3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Activity_Folder_Image.this.renamelayoutText.startAnimation(Activity_Folder_Image.this.fadeIn);
                    Activity_Folder_Image.this.renameBgText.startAnimation(Activity_Folder_Image.this.fadeIn2);
                    Activity_Folder_Image.this.renamelayoutText.setVisibility(0);
                    Activity_Folder_Image.this.renameBgText.setVisibility(0);
                    Activity_Folder_Image.this.renamefrom = new File(Activity_Folder_Image.this.filePath, Activity_Folder_Image.this.filenames.get(i3));
                    Activity_Folder_Image.this.renameSelected = i3;
                    imageButton6.startAnimation(Activity_Folder_Image.this.fadeIn2);
                    imageButton6.setVisibility(0);
                    imageButton7.startAnimation(Activity_Folder_Image.this.fadeOut);
                    imageButton7.setVisibility(4);
                    imageButton8.startAnimation(Activity_Folder_Image.this.toRight);
                    imageButton8.setVisibility(4);
                    imageButton9.startAnimation(Activity_Folder_Image.this.toRight);
                    imageButton9.setVisibility(4);
                    imageButton5.startAnimation(Activity_Folder_Image.this.toRight);
                    imageButton5.setVisibility(4);
                }
            });
            imageButton4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Activity_Folder_Image.this.deleteLayout.startAnimation(Activity_Folder_Image.this.fadeIn);
                    Activity_Folder_Image.this.deleteBgText.startAnimation(Activity_Folder_Image.this.fadeIn2);
                    Activity_Folder_Image.this.deleteLayout.setVisibility(0);
                    Activity_Folder_Image.this.deleteSelected = i3;
                    Activity_Folder_Image.this.deleteBgText.setVisibility(0);
                    imageButton6.startAnimation(Activity_Folder_Image.this.fadeIn2);
                    imageButton6.setVisibility(0);
                    imageButton7.startAnimation(Activity_Folder_Image.this.fadeOut);
                    imageButton7.setVisibility(4);
                    imageButton8.startAnimation(Activity_Folder_Image.this.toRight);
                    imageButton8.setVisibility(4);
                    imageButton9.startAnimation(Activity_Folder_Image.this.toRight);
                    imageButton9.setVisibility(4);
                    imageButton5.startAnimation(Activity_Folder_Image.this.toRight);
                    imageButton5.setVisibility(4);
                }
            });
            imageButton5.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.STREAM", Uri.parse(Activity_Folder_Image.this.filesfolder.get(i3).getAbsolutePath()));
                    intent.setType("text/*");
                    Activity_Folder_Image.this.startActivity(Intent.createChooser(intent, (CharSequence) null));
                    imageButton6.startAnimation(Activity_Folder_Image.this.fadeIn2);
                    imageButton6.setVisibility(0);
                    imageButton7.startAnimation(Activity_Folder_Image.this.fadeOut);
                    imageButton7.setVisibility(4);
                    imageButton8.startAnimation(Activity_Folder_Image.this.toRight);
                    imageButton8.setVisibility(4);
                    imageButton9.startAnimation(Activity_Folder_Image.this.toRight);
                    imageButton9.setVisibility(4);
                    imageButton5.startAnimation(Activity_Folder_Image.this.toRight);
                    imageButton5.setVisibility(4);
                }
            });
            return inflate;
        }
    }

    private void renameUI() {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        defaultDisplay.getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.renamelayoutText.getLayoutParams();
        marginLayoutParams.width = (width * 80) / 100;
        this.renamelayoutText.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.deleteLayout.getLayoutParams();
        marginLayoutParams2.width = (width * 70) / 100;
        this.deleteLayout.setLayoutParams(marginLayoutParams2);
    }

    /* access modifiers changed from: private */
    public void saveToTextFileText() {
        String obj = this.fileNameText.getText().toString();
        if (obj.length() > 0) {
            this.renamefrom.renameTo(new File(this.filePath, obj));
            this.filenames.set(this.renameSelected, obj);
        }
    }

    /* access modifiers changed from: private */
    public void deleteFile() {
        new File(this.filePath, this.filenames.get(this.deleteSelected)).delete();
        this.filenames.remove(this.deleteSelected);
        this.filepaths.remove(this.deleteSelected);
        this.filedate.remove(this.deleteSelected);
        this.fileSize.remove(this.deleteSelected);
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        finish();
    }
}
