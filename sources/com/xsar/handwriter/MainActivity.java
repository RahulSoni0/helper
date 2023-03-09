package com.xsar.handwriter;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.p005ui.AppBarConfiguration;
import androidx.navigation.p005ui.NavigationUI;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import java.io.File;

public class MainActivity extends AppCompatActivity {
    private int REQUEST_CODE = 420;
    LinearLayout camBackgroundLayout;
    View cameraBackgroundView;
    LinearLayout contentsLayout;
    Button customCameraButton;
    View donateBackgroundView;
    Button donateContinue;
    View donateExtraView;
    LinearLayout donateLayout;
    private boolean donatePressed = false;
    private boolean exportPressed = false;
    View fab_button;
    private Animation fadeIn2;
    private Animation fadeOut2;
    private Animation fromBottom;
    private Animation fromBottom2;
    View indicator;
    private boolean isOpen = false;
    View lineBelow;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private AppBarConfiguration mAppBarConfiguration;
    /* access modifiers changed from: private */
    public DrawerLayout mDrawerLayout;
    FloatingActionButton mfab1;
    FloatingActionButton mfab2;
    FloatingActionButton mfab3;
    FloatingActionButton mfab4;
    FloatingActionButton mfab5;
    TextView mfabtext2;
    TextView mfabtext3;
    TextView mfabtext4;
    TextView mfabtext5;
    TextView openWith;
    Button phoneCameraButton;
    private Animation rotateClose;
    private Animation rotateOpen;
    TextView textView1;
    TextView textView2;
    TextView timerTV;
    private Animation toBottom;
    private Animation toBottom2;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2049R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(C2049R.C2052id.tool_bar);
        setSupportActionBar(toolbar);
        this.mfab4 = (FloatingActionButton) findViewById(C2049R.C2052id.floatingActionButton4);
        this.mfab1 = (FloatingActionButton) findViewById(C2049R.C2052id.floatingActionButton1);
        this.mfab2 = (FloatingActionButton) findViewById(C2049R.C2052id.floatingActionButton2);
        this.mfab3 = (FloatingActionButton) findViewById(C2049R.C2052id.floatingActionButton3);
        this.mfab5 = (FloatingActionButton) findViewById(C2049R.C2052id.floatingActionButton5);
        this.fab_button = findViewById(C2049R.C2052id.fab_button);
        this.mfabtext2 = (TextView) findViewById(C2049R.C2052id.fab_text2);
        this.mfabtext3 = (TextView) findViewById(C2049R.C2052id.fab_text3);
        this.mfabtext4 = (TextView) findViewById(C2049R.C2052id.fab_text4);
        this.mfabtext5 = (TextView) findViewById(C2049R.C2052id.fab_text5);
        this.customCameraButton = (Button) findViewById(C2049R.C2052id.customCamButton);
        this.phoneCameraButton = (Button) findViewById(C2049R.C2052id.phoneCamButton);
        this.camBackgroundLayout = (LinearLayout) findViewById(C2049R.C2052id.CameraLayout);
        this.cameraBackgroundView = findViewById(C2049R.C2052id.cameraBackground);
        this.indicator = findViewById(C2049R.C2052id.smallIndicator);
        this.openWith = (TextView) findViewById(C2049R.C2052id.openWitText);
        this.lineBelow = findViewById(C2049R.C2052id.lineBelow);
        this.contentsLayout = (LinearLayout) findViewById(C2049R.C2052id.contentsLayout);
        this.donateBackgroundView = findViewById(C2049R.C2052id.donateBackground);
        this.donateLayout = (LinearLayout) findViewById(C2049R.C2052id.donateLayout);
        this.donateContinue = (Button) findViewById(C2049R.C2052id.donateContinue);
        this.fromBottom = AnimationUtils.loadAnimation(this, C2049R.anim.from_bottom_anim);
        this.toBottom = AnimationUtils.loadAnimation(this, C2049R.anim.to_bottom_anim);
        this.toBottom2 = AnimationUtils.loadAnimation(this, C2049R.anim.to_bottom_original_size);
        this.fromBottom2 = AnimationUtils.loadAnimation(this, C2049R.anim.from_bottom_original_size);
        this.fadeIn2 = AnimationUtils.loadAnimation(this, C2049R.anim.fadein_slow);
        this.fadeOut2 = AnimationUtils.loadAnimation(this, C2049R.anim.fadeout_slow);
        this.rotateOpen = AnimationUtils.loadAnimation(this, C2049R.anim.rotate_open_anim);
        this.rotateClose = AnimationUtils.loadAnimation(this, C2049R.anim.rotate_close_anim);
        deleteTempFiles();
        this.mDrawerLayout = (DrawerLayout) findViewById(C2049R.C2052id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, this.mDrawerLayout, C2049R.string.navigation_drawer_open, C2049R.string.navigation_drawer_close);
        this.mActionBarDrawerToggle = actionBarDrawerToggle;
        this.mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        this.mActionBarDrawerToggle.syncState();
        this.mActionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(C2049R.C2050color.white));
        toolbar.setTitleTextColor(getResources().getColor(C2049R.C2050color.white));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(C2049R.C2052id.nav_view);
        this.mAppBarConfiguration = new AppBarConfiguration.Builder(C2049R.C2052id.nav_home, C2049R.C2052id.tutorials, C2049R.C2052id.rate_us, C2049R.C2052id.contact_us, C2049R.C2052id.feedback, C2049R.C2052id.about_us, C2049R.C2052id.follow).setDrawerLayout((DrawerLayout) findViewById(C2049R.C2052id.drawer_layout)).build();
        final NavController findNavController = Navigation.findNavController(this, C2049R.C2052id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController((AppCompatActivity) this, findNavController, this.mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, findNavController);
        FirstRunMethods();
        this.mfab1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.onAddButtonClicked();
            }
        });
        this.mfab2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.onAddButtonClicked();
                MainActivity.this.cameraLayoutAnimation();
            }
        });
        this.mfab3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.onAddButtonClicked();
                Intent intent = new Intent(MainActivity.this, activity_fab4.class);
                intent.putExtra("FileReady", 1);
                MainActivity.this.startActivity(intent);
            }
        });
        this.mfab4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.onAddButtonClicked();
                Intent intent = new Intent(MainActivity.this, activity_fab4.class);
                intent.putExtra("FileReady", 2);
                MainActivity.this.startActivity(intent);
            }
        });
        this.mfab5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.onAddButtonClicked();
                if (ContextCompat.checkSelfPermission(MainActivity.this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 200);
                } else {
                    MainActivity.this.OpenGallery();
                }
            }
        });
        this.fab_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.onAddButtonClicked();
            }
        });
        this.customCameraButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.openCustomCamera();
                MainActivity.this.cameraLayoutAnimation();
            }
        });
        this.phoneCameraButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.openCamera();
                MainActivity.this.cameraLayoutAnimation();
            }
        });
        this.cameraBackgroundView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.cameraLayoutAnimation();
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case C2049R.C2052id.contact_us /*2131361960*/:
                        MainActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("mailto:xsar.incorporated@gmail.com")));
                        break;
                    case C2049R.C2052id.donate /*2131362030*/:
                        MainActivity.this.startActivity(new Intent(MainActivity.this, DummyDonateActivity.class));
                        break;
                    case C2049R.C2052id.feedback /*2131362090*/:
                    case C2049R.C2052id.rate_us /*2131362397*/:
                        MainActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.xsar.handwriter")));
                        break;
                    case C2049R.C2052id.follow /*2131362139*/:
                        MainActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.instagram.com/xsar.inc/")));
                        break;
                    case C2049R.C2052id.video_tutorials /*2131362613*/:
                        MainActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://youtu.be/sxzadvkMfZE")));
                        break;
                }
                NavigationUI.onNavDestinationSelected(menuItem, findNavController);
                MainActivity.this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
                return true;
            }
        });
    }

    private void FirstRunMethods() {
        if (getSharedPreferences("PREFERENCE2", 0).getBoolean("isFirstRun2", true)) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    MainActivity.this.startActivity(new Intent(MainActivity.this, DummyDonateActivity.class));
                }
            }, 1000);
        }
        getSharedPreferences("PREFERENCE2", 0).edit().putBoolean("isFirstRun2", false).apply();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C2049R.C2054menu.menu_main, menu);
        return true;
    }

    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(this, C2049R.C2052id.nav_host_fragment), this.mAppBarConfiguration) || super.onSupportNavigateUp();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (!this.mActionBarDrawerToggle.onOptionsItemSelected(menuItem) && menuItem.getItemId() == C2049R.C2052id.share) {
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.SUBJECT", "HandWriter");
                intent.putExtra("android.intent.extra.TEXT", "https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName());
                startActivity(Intent.createChooser(intent, "Share-Via"));
            } catch (Exception unused) {
                Toast.makeText(this, "Error Sharing", 0).show();
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void OpenGallery() {
        Intent intent = new Intent(this, image_editor.class);
        intent.putExtra("fromGallery", true);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public void openCamera() {
        Intent intent = new Intent(this, image_editor.class);
        intent.putExtra("fromGallery", false);
        intent.putExtra("cameraNo", 1);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public void openCustomCamera() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 150);
            return;
        }
        Intent intent = new Intent(this, NewCustomCamera.class);
        intent.putExtra("fromActivity", 1);
        startActivity(intent);
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
        this.cameraBackgroundView.setVisibility(8);
        this.camBackgroundLayout.startAnimation(this.toBottom2);
        this.camBackgroundLayout.setVisibility(8);
        this.customCameraButton.setVisibility(8);
        this.phoneCameraButton.setVisibility(8);
        this.exportPressed = false;
    }

    private void donateLayoutAnimation() {
        if (!this.donatePressed) {
            this.donateBackgroundView.startAnimation(this.fadeIn2);
            this.donateBackgroundView.setVisibility(0);
            this.donateLayout.startAnimation(this.fadeIn2);
            this.donateLayout.setVisibility(0);
            this.donatePressed = true;
            return;
        }
        this.donateBackgroundView.startAnimation(this.fadeOut2);
        this.donateBackgroundView.setVisibility(8);
        this.donateLayout.startAnimation(this.fadeOut2);
        this.donateLayout.setVisibility(8);
        this.donatePressed = false;
    }

    public void onBackPressed() {
        if (this.mDrawerLayout.isDrawerOpen((int) GravityCompat.START)) {
            this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
        } else if (this.isOpen) {
            onAddButtonClicked();
        } else if (this.exportPressed) {
            cameraLayoutAnimation();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle((CharSequence) "Confirm Exit...!!");
            builder.setMessage((CharSequence) "Are you sure you want to exit..?");
            builder.setCancelable(false);
            builder.setPositiveButton((CharSequence) "Yes", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    MainActivity.this.finish();
                }
            });
            builder.setNegativeButton((CharSequence) "No", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                    Toast.makeText(MainActivity.this, "Press Yes to exit", 0).show();
                }
            });
            builder.create().show();
        }
    }

    /* access modifiers changed from: private */
    public void onAddButtonClicked() {
        setVisibility(this.isOpen);
        setAnimation(this.isOpen);
        setClickable(this.isOpen);
        this.isOpen = !this.isOpen;
    }

    private void setVisibility(boolean z) {
        if (!z) {
            this.mfab2.setVisibility(0);
            this.mfab3.setVisibility(0);
            this.mfab4.setVisibility(0);
            this.mfab5.setVisibility(0);
            this.fab_button.setVisibility(0);
            this.mfabtext2.setVisibility(0);
            this.mfabtext3.setVisibility(0);
            this.mfabtext4.setVisibility(0);
            this.mfabtext5.setVisibility(0);
            return;
        }
        this.mfab2.setVisibility(4);
        this.mfab3.setVisibility(4);
        this.mfab4.setVisibility(4);
        this.mfab5.setVisibility(4);
        this.fab_button.setVisibility(8);
        this.mfabtext2.setVisibility(4);
        this.mfabtext3.setVisibility(4);
        this.mfabtext4.setVisibility(4);
        this.mfabtext5.setVisibility(0);
    }

    private void setAnimation(boolean z) {
        if (!z) {
            this.mfab1.startAnimation(this.rotateOpen);
            this.mfab2.startAnimation(this.fromBottom);
            this.mfab3.startAnimation(this.fromBottom);
            this.mfab4.startAnimation(this.fromBottom);
            this.mfab5.startAnimation(this.fromBottom);
            this.mfabtext2.startAnimation(this.fromBottom);
            this.mfabtext3.startAnimation(this.fromBottom);
            this.mfabtext4.startAnimation(this.fromBottom);
            this.mfabtext5.startAnimation(this.fromBottom);
            return;
        }
        this.mfab1.startAnimation(this.rotateClose);
        this.mfab2.startAnimation(this.toBottom);
        this.mfab3.startAnimation(this.toBottom);
        this.mfab4.startAnimation(this.toBottom);
        this.mfab5.startAnimation(this.toBottom);
        this.mfabtext2.startAnimation(this.toBottom);
        this.mfabtext3.startAnimation(this.toBottom);
        this.mfabtext4.startAnimation(this.toBottom);
        this.mfabtext5.startAnimation(this.toBottom);
    }

    private void setClickable(boolean z) {
        if (!z) {
            this.mfab2.setClickable(true);
            this.mfab3.setClickable(true);
            this.mfab4.setClickable(true);
            this.mfab5.setClickable(true);
            return;
        }
        this.mfab2.setClickable(false);
        this.mfab3.setClickable(false);
        this.mfab4.setClickable(false);
        this.mfab5.setClickable(false);
    }

    private void deleteTempFiles() {
        File externalFilesDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        String[] list = externalFilesDir.list();
        for (String file : list) {
            File file2 = new File(externalFilesDir, file);
            if (file2.getName().startsWith("Handwriter_")) {
                file2.delete();
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 150) {
            if (i != 200) {
                return;
            }
        } else if (iArr[0] == 0) {
            onAddButtonClicked();
            Intent intent = new Intent(this, image_editor.class);
            intent.putExtra("fromGallery", false);
            startActivity(intent);
        } else {
            Toast.makeText(this, "camera permission required to take pictures", 0).show();
        }
        if (iArr[0] == 0) {
            OpenGallery();
        } else {
            Toast.makeText(this, "storage permission required to access images", 0).show();
        }
    }
}
