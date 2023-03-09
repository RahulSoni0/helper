package com.xsar.handwriter;

import android.content.ActivityNotFoundException;
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

public class Activity_Folder_PDF extends AppCompatActivity {
    View deleteBgPdf;
    Button deleteCancel;
    LinearLayout deleteLayoutPdf;
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
    EditText fileNamePdf;
    String filePath;
    public ArrayList<Long> fileSize;
    public ArrayList<Long> filedate;
    Button filenamecancelPdf;
    public ArrayList<String> filenames;
    public ArrayList<String> filepaths;
    /* access modifiers changed from: private */
    public Animation fromRight;
    View renameBgPdf;
    public int renameSelected;
    public File renamefrom;
    LinearLayout renamelayoutPdf;
    Button renameokPdf;
    boolean savingPdf = false;
    SwipeRefreshLayout swipeRefreshLayoutPdf;
    /* access modifiers changed from: private */
    public Animation toRight;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2049R.layout.activity__folder__pdf);
        setSupportActionBar((Toolbar) findViewById(C2049R.C2052id.toolbarPDF));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle((CharSequence) "Saved Pdf Files");
        this.renamelayoutPdf = (LinearLayout) findViewById(C2049R.C2052id.renamelayoutPdf);
        this.deleteLayoutPdf = (LinearLayout) findViewById(C2049R.C2052id.deletePdf);
        this.deleteOk = (Button) findViewById(C2049R.C2052id.deleteOk);
        this.deleteCancel = (Button) findViewById(C2049R.C2052id.deleteCancel);
        this.renameokPdf = (Button) findViewById(C2049R.C2052id.renameokPdf);
        this.filenamecancelPdf = (Button) findViewById(C2049R.C2052id.renamecancelPdf);
        this.renameBgPdf = findViewById(C2049R.C2052id.renameBgPdf);
        this.deleteBgPdf = findViewById(C2049R.C2052id.deleteBgPdf);
        this.fileNamePdf = (EditText) findViewById(C2049R.C2052id.filenamePdf);
        this.fadeIn2 = AnimationUtils.loadAnimation(this, C2049R.anim.fadein_slow);
        this.fadeOut2 = AnimationUtils.loadAnimation(this, C2049R.anim.fadeout_slow);
        this.fadeIn = AnimationUtils.loadAnimation(this, C2049R.anim.fadein);
        this.fadeOut = AnimationUtils.loadAnimation(this, C2049R.anim.fadeout);
        this.fromRight = AnimationUtils.loadAnimation(this, C2049R.anim.enter_from_right);
        this.toRight = AnimationUtils.loadAnimation(this, C2049R.anim.exit_to_right);
        this.filenames = new ArrayList<>();
        this.filepaths = new ArrayList<>();
        this.filedate = new ArrayList<>();
        this.fileSize = new ArrayList<>();
        renameUI();
        if (Build.VERSION.SDK_INT >= 30) {
            this.filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getAbsolutePath();
        } else {
            this.filePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        this.filePath += "/HandWriter/Pdf Files/";
        File file = new File(this.filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        for (File file2 : file.listFiles()) {
            if (file2.isFile()) {
                this.filenames.add(file2.getName());
                this.filepaths.add(file2.getAbsolutePath());
                this.filedate.add(Long.valueOf(file2.lastModified()));
                this.fileSize.add(Long.valueOf(file2.length() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID));
            }
        }
        final ListView listView = (ListView) findViewById(C2049R.C2052id.pdf_files_list);
        final customAdapter customadapter = new customAdapter();
        listView.setAdapter(customadapter);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(C2049R.C2052id.swipeRefreshPdf);
        this.swipeRefreshLayoutPdf = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                Activity_Folder_PDF.this.filenames.clear();
                Activity_Folder_PDF.this.filepaths.clear();
                Activity_Folder_PDF.this.filedate.clear();
                Activity_Folder_PDF.this.fileSize.clear();
                File file = new File(Activity_Folder_PDF.this.filePath);
                if (!file.exists()) {
                    file.mkdirs();
                }
                for (File file2 : file.listFiles()) {
                    if (file2.isFile()) {
                        Activity_Folder_PDF.this.filenames.add(file2.getName());
                        Activity_Folder_PDF.this.filepaths.add(file2.getAbsolutePath());
                        Activity_Folder_PDF.this.filedate.add(Long.valueOf(file2.lastModified()));
                        Activity_Folder_PDF.this.fileSize.add(Long.valueOf(file2.length()));
                    }
                }
                listView.setAdapter(new customAdapter());
                listView.setItemsCanFocus(false);
                Activity_Folder_PDF.this.swipeRefreshLayoutPdf.setRefreshing(false);
            }
        });
        this.renameokPdf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Activity_Folder_PDF.this.saveToPdfFilePdf();
                Activity_Folder_PDF.this.renamelayoutPdf.startAnimation(Activity_Folder_PDF.this.fadeOut);
                Activity_Folder_PDF.this.renamelayoutPdf.setVisibility(4);
                Activity_Folder_PDF.this.renameBgPdf.startAnimation(Activity_Folder_PDF.this.fadeOut2);
                Activity_Folder_PDF.this.renameBgPdf.setVisibility(4);
                Activity_Folder_PDF.this.savingPdf = false;
                customadapter.notifyDataSetChanged();
            }
        });
        this.filenamecancelPdf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Activity_Folder_PDF.this.renamelayoutPdf.startAnimation(Activity_Folder_PDF.this.fadeOut);
                Activity_Folder_PDF.this.renamelayoutPdf.setVisibility(4);
                Activity_Folder_PDF.this.renamelayoutPdf.startAnimation(Activity_Folder_PDF.this.fadeOut2);
                Activity_Folder_PDF.this.renameBgPdf.setVisibility(4);
                Activity_Folder_PDF.this.savingPdf = false;
            }
        });
        this.renameBgPdf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Activity_Folder_PDF.this.renamelayoutPdf.startAnimation(Activity_Folder_PDF.this.fadeOut);
                Activity_Folder_PDF.this.renameBgPdf.startAnimation(Activity_Folder_PDF.this.fadeOut2);
                Activity_Folder_PDF.this.renamelayoutPdf.setVisibility(4);
                Activity_Folder_PDF.this.renameBgPdf.setVisibility(4);
                Activity_Folder_PDF.this.savingPdf = false;
            }
        });
        this.deleteBgPdf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Activity_Folder_PDF.this.deleteLayoutPdf.startAnimation(Activity_Folder_PDF.this.fadeOut);
                Activity_Folder_PDF.this.deleteLayoutPdf.setVisibility(4);
                Activity_Folder_PDF.this.deleteBgPdf.startAnimation(Activity_Folder_PDF.this.fadeOut2);
                Activity_Folder_PDF.this.deleteBgPdf.setVisibility(4);
            }
        });
        this.deleteOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Activity_Folder_PDF.this.deleteFile();
                Activity_Folder_PDF.this.deleteLayoutPdf.startAnimation(Activity_Folder_PDF.this.fadeOut);
                Activity_Folder_PDF.this.deleteLayoutPdf.setVisibility(4);
                Activity_Folder_PDF.this.deleteBgPdf.startAnimation(Activity_Folder_PDF.this.fadeOut2);
                Activity_Folder_PDF.this.deleteBgPdf.setVisibility(4);
                customadapter.notifyDataSetChanged();
                Toast.makeText(Activity_Folder_PDF.this, "file deleted", 0).show();
            }
        });
        this.deleteCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Activity_Folder_PDF.this.deleteLayoutPdf.startAnimation(Activity_Folder_PDF.this.fadeOut);
                Activity_Folder_PDF.this.deleteLayoutPdf.setVisibility(4);
                Activity_Folder_PDF.this.deleteBgPdf.startAnimation(Activity_Folder_PDF.this.fadeOut2);
                Activity_Folder_PDF.this.deleteBgPdf.setVisibility(4);
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
            return Activity_Folder_PDF.this.filenames.size();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            String str;
            final int i2 = i;
            View inflate = Activity_Folder_PDF.this.getLayoutInflater().inflate(C2049R.layout.pdf_apps_layout, (ViewGroup) null);
            ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(C2049R.C2052id.pdf_file_but);
            ((TextView) inflate.findViewById(C2049R.C2052id.pdf_file_but1)).setText(Activity_Folder_PDF.this.filenames.get(i2));
            TextView textView = (TextView) inflate.findViewById(C2049R.C2052id.pdf_file_size);
            ((TextView) inflate.findViewById(C2049R.C2052id.pdf_file_details)).setText(String.valueOf(new SimpleDateFormat("dd/MM/yyyy ").format(Activity_Folder_PDF.this.filedate.get(i2))));
            long longValue = Activity_Folder_PDF.this.fileSize.get(i2).longValue();
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
            ImageButton imageButton = (ImageButton) inflate.findViewById(C2049R.C2052id.showMenu);
            ImageButton imageButton2 = (ImageButton) inflate.findViewById(C2049R.C2052id.menuClose);
            ImageButton imageButton3 = (ImageButton) inflate.findViewById(C2049R.C2052id.renameButtonMenu);
            ImageButton imageButton4 = (ImageButton) inflate.findViewById(C2049R.C2052id.deleteButtonMenu);
            ImageButton imageButton5 = (ImageButton) inflate.findViewById(C2049R.C2052id.shareButtonMenu);
            View findViewById = inflate.findViewById(C2049R.C2052id.MenuOptionsBgText);
            constraintLayout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.parse(Activity_Folder_PDF.this.filepaths.get(i2)), "application/pdf");
                    intent.setFlags(1);
                    try {
                        Activity_Folder_PDF.this.startActivity(Intent.createChooser(intent, "Open With"));
                    } catch (ActivityNotFoundException unused) {
                        Toast.makeText(Activity_Folder_PDF.this, "Oops, No application found", 0).show();
                    }
                }
            });
            final View view2 = findViewById;
            final ImageButton imageButton6 = imageButton;
            final ImageButton imageButton7 = imageButton2;
            final ImageButton imageButton8 = imageButton3;
            C19222 r8 = r0;
            final ImageButton imageButton9 = imageButton4;
            View view3 = findViewById;
            final ImageButton imageButton10 = imageButton5;
            C19222 r0 = new View.OnClickListener() {
                public void onClick(View view) {
                    view2.setVisibility(0);
                    imageButton6.startAnimation(Activity_Folder_PDF.this.fadeOut);
                    imageButton6.setVisibility(4);
                    imageButton7.startAnimation(Activity_Folder_PDF.this.fadeIn2);
                    imageButton7.setVisibility(0);
                    imageButton8.startAnimation(Activity_Folder_PDF.this.fromRight);
                    imageButton8.setVisibility(0);
                    imageButton9.startAnimation(Activity_Folder_PDF.this.fromRight);
                    imageButton9.setVisibility(0);
                    imageButton10.startAnimation(Activity_Folder_PDF.this.fromRight);
                    imageButton10.setVisibility(0);
                }
            };
            imageButton.setOnClickListener(r8);
            final View view4 = view3;
            view4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    view4.setVisibility(4);
                    imageButton6.startAnimation(Activity_Folder_PDF.this.fadeIn2);
                    imageButton6.setVisibility(0);
                    imageButton7.startAnimation(Activity_Folder_PDF.this.fadeOut);
                    imageButton7.setVisibility(4);
                    imageButton8.startAnimation(Activity_Folder_PDF.this.toRight);
                    imageButton8.setVisibility(4);
                    imageButton9.startAnimation(Activity_Folder_PDF.this.toRight);
                    imageButton9.setVisibility(4);
                    imageButton10.startAnimation(Activity_Folder_PDF.this.toRight);
                    imageButton10.setVisibility(4);
                }
            });
            imageButton2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    view4.setVisibility(4);
                    imageButton6.startAnimation(Activity_Folder_PDF.this.fadeIn2);
                    imageButton6.setVisibility(0);
                    imageButton7.startAnimation(Activity_Folder_PDF.this.fadeOut);
                    imageButton7.setVisibility(4);
                    imageButton8.startAnimation(Activity_Folder_PDF.this.toRight);
                    imageButton8.setVisibility(4);
                    imageButton9.startAnimation(Activity_Folder_PDF.this.toRight);
                    imageButton9.setVisibility(4);
                    imageButton10.startAnimation(Activity_Folder_PDF.this.toRight);
                    imageButton10.setVisibility(4);
                }
            });
            final int i3 = i;
            imageButton3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Activity_Folder_PDF.this.renamelayoutPdf.startAnimation(Activity_Folder_PDF.this.fadeIn);
                    Activity_Folder_PDF.this.renameBgPdf.startAnimation(Activity_Folder_PDF.this.fadeIn2);
                    Activity_Folder_PDF.this.renamelayoutPdf.setVisibility(0);
                    Activity_Folder_PDF.this.renameBgPdf.setVisibility(0);
                    Activity_Folder_PDF.this.renamefrom = new File(Activity_Folder_PDF.this.filePath, Activity_Folder_PDF.this.filenames.get(i3));
                    Activity_Folder_PDF.this.renameSelected = i3;
                    imageButton6.startAnimation(Activity_Folder_PDF.this.fadeIn2);
                    imageButton6.setVisibility(0);
                    imageButton7.startAnimation(Activity_Folder_PDF.this.fadeOut);
                    imageButton7.setVisibility(4);
                    imageButton8.startAnimation(Activity_Folder_PDF.this.toRight);
                    imageButton8.setVisibility(4);
                    imageButton9.startAnimation(Activity_Folder_PDF.this.toRight);
                    imageButton9.setVisibility(4);
                    imageButton10.startAnimation(Activity_Folder_PDF.this.toRight);
                    imageButton10.setVisibility(4);
                }
            });
            imageButton4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Activity_Folder_PDF.this.deleteLayoutPdf.startAnimation(Activity_Folder_PDF.this.fadeIn);
                    Activity_Folder_PDF.this.deleteBgPdf.startAnimation(Activity_Folder_PDF.this.fadeIn2);
                    Activity_Folder_PDF.this.deleteLayoutPdf.setVisibility(0);
                    Activity_Folder_PDF.this.deleteSelected = i3;
                    Activity_Folder_PDF.this.deleteBgPdf.setVisibility(0);
                    imageButton6.startAnimation(Activity_Folder_PDF.this.fadeIn2);
                    imageButton6.setVisibility(0);
                    imageButton7.startAnimation(Activity_Folder_PDF.this.fadeOut);
                    imageButton7.setVisibility(4);
                    imageButton8.startAnimation(Activity_Folder_PDF.this.toRight);
                    imageButton8.setVisibility(4);
                    imageButton9.startAnimation(Activity_Folder_PDF.this.toRight);
                    imageButton9.setVisibility(4);
                    imageButton10.startAnimation(Activity_Folder_PDF.this.toRight);
                    imageButton10.setVisibility(4);
                }
            });
            imageButton5.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.STREAM", Uri.parse(Activity_Folder_PDF.this.filePath + "/" + Activity_Folder_PDF.this.filenames.get(i3)));
                    intent.setType("pdf/*");
                    Activity_Folder_PDF.this.startActivity(Intent.createChooser(intent, (CharSequence) null));
                    imageButton6.startAnimation(Activity_Folder_PDF.this.fadeIn2);
                    imageButton6.setVisibility(0);
                    imageButton7.startAnimation(Activity_Folder_PDF.this.fadeOut);
                    imageButton7.setVisibility(4);
                    imageButton8.startAnimation(Activity_Folder_PDF.this.toRight);
                    imageButton8.setVisibility(4);
                    imageButton9.startAnimation(Activity_Folder_PDF.this.toRight);
                    imageButton9.setVisibility(4);
                    imageButton10.startAnimation(Activity_Folder_PDF.this.toRight);
                    imageButton10.setVisibility(4);
                }
            });
            return inflate;
        }
    }

    /* access modifiers changed from: private */
    public void saveToPdfFilePdf() {
        String obj = this.fileNamePdf.getText().toString();
        if (obj.length() > 0) {
            String str = this.filePath;
            this.renamefrom.renameTo(new File(str, obj + ".pdf"));
            ArrayList<String> arrayList = this.filenames;
            int i = this.renameSelected;
            arrayList.set(i, obj + ".pdf");
        }
    }

    private void renameUI() {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        defaultDisplay.getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.renamelayoutPdf.getLayoutParams();
        marginLayoutParams.width = (width * 80) / 100;
        this.renamelayoutPdf.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.deleteLayoutPdf.getLayoutParams();
        marginLayoutParams2.width = (width * 70) / 100;
        this.deleteLayoutPdf.setLayoutParams(marginLayoutParams2);
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
        if (this.savingPdf) {
            this.renamelayoutPdf.startAnimation(this.fadeOut);
            this.renamelayoutPdf.setVisibility(4);
            this.renamelayoutPdf.startAnimation(this.fadeOut2);
            this.renameBgPdf.setVisibility(4);
            this.savingPdf = false;
            return;
        }
        finish();
    }
}
