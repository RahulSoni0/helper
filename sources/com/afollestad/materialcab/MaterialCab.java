package com.afollestad.materialcab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.io.Serializable;

public class MaterialCab implements Serializable, Toolbar.OnMenuItemClickListener {
    private boolean mActive;
    private int mAttacherId;
    private int mBackgroundColor;
    private transient Callback mCallback;
    private int mCloseDrawable;
    private int mContentInsetStart;
    private transient AppCompatActivity mContext;
    private int mMenu;
    private int mPopupTheme;
    private CharSequence mTitle;
    private transient Toolbar mToolbar;

    public interface Callback {
        boolean onCabCreated(MaterialCab materialCab, Menu menu);

        boolean onCabFinished(MaterialCab materialCab);

        boolean onCabItemClicked(MenuItem menuItem);
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        Callback callback = this.mCallback;
        return callback != null && callback.onCabItemClicked(menuItem);
    }

    public MaterialCab(AppCompatActivity appCompatActivity, int i) {
        this.mContext = appCompatActivity;
        this.mAttacherId = i;
        reset();
    }

    public void setContext(AppCompatActivity appCompatActivity) {
        this.mContext = appCompatActivity;
    }

    public boolean isActive() {
        return this.mActive;
    }

    public MaterialCab reset() {
        this.mTitle = Util.resolveString(this.mContext, C0847R.attr.mcab_title);
        this.mPopupTheme = Util.resolveResId(this.mContext, C0847R.attr.mcab_popup_theme, C0847R.style.ThemeOverlay_AppCompat_Light);
        this.mContentInsetStart = Util.resolveDimension(this.mContext, C0847R.attr.mcab_contentinset_start, C0847R.dimen.mcab_default_content_inset);
        this.mMenu = Util.resolveResId(this.mContext, C0847R.attr.mcab_menu, 0);
        this.mBackgroundColor = Util.resolveColor(this.mContext, C0847R.attr.mcab_background_color, Util.resolveColor(this.mContext, C0847R.attr.colorPrimary, -7829368));
        this.mCloseDrawable = Util.resolveResId(this.mContext, C0847R.attr.mcab_close_drawable, Util.resolveResId(this.mContext, C0847R.attr.actionModeCloseDrawable, C0847R.C0849drawable.mcab_nav_back));
        Toolbar toolbar = this.mToolbar;
        if (!(toolbar == null || toolbar.getMenu() == null)) {
            this.mToolbar.getMenu().clear();
        }
        return this;
    }

    public MaterialCab start(Callback callback) {
        this.mCallback = callback;
        invalidateVisibility(attach());
        return this;
    }

    public MaterialCab setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            toolbar.setTitle(charSequence);
        }
        return this;
    }

    public MaterialCab setTitleRes(int i) {
        return setTitle(this.mContext.getResources().getText(i));
    }

    public MaterialCab setTitleRes(int i, Object... objArr) {
        return setTitle(this.mContext.getResources().getString(i, objArr));
    }

    public MaterialCab setMenu(int i) {
        this.mMenu = i;
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            if (toolbar.getMenu() != null) {
                this.mToolbar.getMenu().clear();
            }
            if (i != 0) {
                this.mToolbar.inflateMenu(i);
            }
            this.mToolbar.setOnMenuItemClickListener(this);
        }
        return this;
    }

    public MaterialCab setPopupMenuTheme(int i) {
        this.mPopupTheme = i;
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            toolbar.setPopupTheme(i);
        }
        return this;
    }

    public MaterialCab setContentInsetStart(int i) {
        this.mContentInsetStart = i;
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            toolbar.setContentInsetsRelative(i, 0);
        }
        return this;
    }

    public MaterialCab setContentInsetStartRes(int i) {
        return setContentInsetStart((int) this.mContext.getResources().getDimension(i));
    }

    public MaterialCab setContentInsetStartAttr(int i) {
        return setContentInsetStart(Util.resolveInt(this.mContext, i, 0));
    }

    public MaterialCab setBackgroundColor(int i) {
        this.mBackgroundColor = i;
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            toolbar.setBackgroundColor(i);
        }
        return this;
    }

    public MaterialCab setBackgroundColorRes(int i) {
        return setBackgroundColor(this.mContext.getResources().getColor(i));
    }

    public MaterialCab setBackgroundColorAttr(int i) {
        return setBackgroundColor(Util.resolveColor(this.mContext, i, 0));
    }

    public MaterialCab setCloseDrawableRes(int i) {
        this.mCloseDrawable = i;
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            toolbar.setNavigationIcon(i);
        }
        return this;
    }

    public Menu getMenu() {
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            return toolbar.getMenu();
        }
        return null;
    }

    public Toolbar getToolbar() {
        return this.mToolbar;
    }

    public void finish() {
        Callback callback = this.mCallback;
        invalidateVisibility(callback != null && !callback.onCabFinished(this));
    }

    private void invalidateVisibility(boolean z) {
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            toolbar.setVisibility(z ? 0 : 8);
            this.mActive = z;
        }
    }

    private boolean attach() {
        View findViewById = this.mContext.findViewById(this.mAttacherId);
        if (this.mContext.findViewById(C0847R.C0850id.mcab_toolbar) != null) {
            this.mToolbar = (Toolbar) this.mContext.findViewById(C0847R.C0850id.mcab_toolbar);
        } else if (findViewById instanceof ViewStub) {
            ViewStub viewStub = (ViewStub) findViewById;
            viewStub.setLayoutResource(C0847R.layout.mcab_toolbar);
            viewStub.setInflatedId(C0847R.C0850id.mcab_toolbar);
            this.mToolbar = (Toolbar) viewStub.inflate();
        } else if (findViewById instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) findViewById;
            Toolbar toolbar = (Toolbar) LayoutInflater.from(this.mContext).inflate(C0847R.layout.mcab_toolbar, viewGroup, false);
            this.mToolbar = toolbar;
            viewGroup.addView(toolbar);
        } else {
            throw new IllegalStateException("MaterialCab was unable to attach to your Activity, attacher stub doesn't exist.");
        }
        if (this.mToolbar == null) {
            return false;
        }
        CharSequence charSequence = this.mTitle;
        if (charSequence != null) {
            setTitle(charSequence);
        }
        int i = this.mPopupTheme;
        if (i != 0) {
            this.mToolbar.setPopupTheme(i);
        }
        int i2 = this.mMenu;
        if (i2 != 0) {
            setMenu(i2);
        }
        int i3 = this.mCloseDrawable;
        if (i3 != 0) {
            setCloseDrawableRes(i3);
        }
        setBackgroundColor(this.mBackgroundColor);
        setContentInsetStart(this.mContentInsetStart);
        this.mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MaterialCab.this.finish();
            }
        });
        Callback callback = this.mCallback;
        if (callback == null || callback.onCabCreated(this, this.mToolbar.getMenu())) {
            return true;
        }
        return false;
    }

    public void saveState(Bundle bundle) {
        bundle.putSerializable("[mcab_state]", this);
    }

    public static MaterialCab restoreState(Bundle bundle, AppCompatActivity appCompatActivity, Callback callback) {
        if (bundle == null || !bundle.containsKey("[mcab_state]")) {
            return null;
        }
        MaterialCab materialCab = (MaterialCab) bundle.getSerializable("[mcab_state]");
        if (materialCab != null) {
            materialCab.mContext = appCompatActivity;
            if (materialCab.mActive) {
                materialCab.start(callback);
            }
        }
        return materialCab;
    }
}
