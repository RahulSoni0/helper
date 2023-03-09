package com.skydoves.powerspinner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.preference.C0573R;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.itextpdf.text.html.HtmlTags;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0014J\u0012\u0010\u0019\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u0015H\u0014Jp\u0010\u001a\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u001b2b\u0010\u001c\u001a^\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0015\u0012\u0013\u0018\u0001H\u001b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H\u001b¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u000f0\u001dJ\u001a\u0010\u001a\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u001b0%J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006'"}, mo18301d2 = {"Lcom/skydoves/powerspinner/PowerSpinnerPreference;", "Landroidx/preference/Preference;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultValue", "powerSpinnerView", "Lcom/skydoves/powerspinner/PowerSpinnerView;", "getPowerSpinnerView", "()Lcom/skydoves/powerspinner/PowerSpinnerView;", "getAttrs", "", "defStyleAttr", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "onGetDefaultValue", "", "a", "Landroid/content/res/TypedArray;", "index", "onSetInitialValue", "setOnSpinnerItemSelectedListener", "T", "block", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "oldIndex", "oldItem", "newIndex", "newItem", "onSpinnerItemSelectedListener", "Lcom/skydoves/powerspinner/OnSpinnerItemSelectedListener;", "setTypeArray", "powerspinner_release"}, mo18302k = 1, mo18303mv = {1, 4, 1})
/* compiled from: PowerSpinnerPreference.kt */
public final class PowerSpinnerPreference extends Preference {
    private int defaultValue;
    private final PowerSpinnerView powerSpinnerView;

    public PowerSpinnerPreference(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public PowerSpinnerPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PowerSpinnerPreference(android.content.Context r1, android.util.AttributeSet r2, int r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r5 = r4 & 2
            if (r5 == 0) goto L_0x0008
            r2 = 0
            r5 = r2
            android.util.AttributeSet r5 = (android.util.AttributeSet) r5
        L_0x0008:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x000e
            int r3 = androidx.preference.C0573R.attr.preferenceStyle
        L_0x000e:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.skydoves.powerspinner.PowerSpinnerPreference.<init>(android.content.Context, android.util.AttributeSet, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PowerSpinnerPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.powerSpinnerView = new PowerSpinnerView(context);
        setLayoutResource(C1867R.layout.layout_preference_power_spinner_library);
        if (attributeSet != null && i != C0573R.attr.preferenceStyle) {
            getAttrs(attributeSet, i);
        } else if (attributeSet != null) {
            getAttrs(attributeSet);
        }
    }

    public final PowerSpinnerView getPowerSpinnerView() {
        return this.powerSpinnerView;
    }

    private final void getAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1867R.styleable.PowerSpinnerView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…yleable.PowerSpinnerView)");
        try {
            setTypeArray(obtainStyledAttributes);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private final void getAttrs(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1867R.styleable.PowerSpinnerView, i, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…fStyleAttr,\n      0\n    )");
        try {
            setTypeArray(obtainStyledAttributes);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private final void setTypeArray(TypedArray typedArray) {
        this.powerSpinnerView.setShowArrow(typedArray.getBoolean(C1867R.styleable.PowerSpinnerView_spinner_arrow_show, this.powerSpinnerView.getShowArrow()));
        int integer = typedArray.getInteger(C1867R.styleable.PowerSpinnerView_spinner_arrow_gravity, this.powerSpinnerView.getArrowGravity().getValue());
        if (integer == SpinnerGravity.START.getValue()) {
            this.powerSpinnerView.setArrowGravity(SpinnerGravity.START);
        } else if (integer == SpinnerGravity.TOP.getValue()) {
            this.powerSpinnerView.setArrowGravity(SpinnerGravity.TOP);
        } else if (integer == SpinnerGravity.END.getValue()) {
            this.powerSpinnerView.setArrowGravity(SpinnerGravity.END);
        } else if (integer == SpinnerGravity.BOTTOM.getValue()) {
            this.powerSpinnerView.setArrowGravity(SpinnerGravity.BOTTOM);
        }
        this.powerSpinnerView.setArrowPadding(typedArray.getDimensionPixelSize(C1867R.styleable.PowerSpinnerView_spinner_arrow_padding, this.powerSpinnerView.getArrowPadding()));
        this.powerSpinnerView.setArrowAnimate(typedArray.getBoolean(C1867R.styleable.PowerSpinnerView_spinner_arrow_animate, this.powerSpinnerView.getArrowAnimate()));
        this.powerSpinnerView.setArrowAnimationDuration((long) typedArray.getInteger(C1867R.styleable.PowerSpinnerView_spinner_arrow_animate_duration, (int) this.powerSpinnerView.getArrowAnimationDuration()));
        this.powerSpinnerView.setShowDivider(typedArray.getBoolean(C1867R.styleable.PowerSpinnerView_spinner_divider_show, this.powerSpinnerView.getShowDivider()));
        this.powerSpinnerView.setDividerSize(typedArray.getDimensionPixelSize(C1867R.styleable.PowerSpinnerView_spinner_divider_size, this.powerSpinnerView.getDividerSize()));
        this.powerSpinnerView.setDividerColor(typedArray.getColor(C1867R.styleable.PowerSpinnerView_spinner_divider_color, this.powerSpinnerView.getDividerColor()));
        this.powerSpinnerView.setSpinnerPopupBackgroundColor(typedArray.getColor(C1867R.styleable.PowerSpinnerView_spinner_popup_background, this.powerSpinnerView.getSpinnerPopupBackgroundColor()));
        int integer2 = typedArray.getInteger(C1867R.styleable.PowerSpinnerView_spinner_popup_animation, this.powerSpinnerView.getSpinnerPopupAnimation().getValue());
        if (integer2 == SpinnerAnimation.DROPDOWN.getValue()) {
            this.powerSpinnerView.setSpinnerPopupAnimation(SpinnerAnimation.DROPDOWN);
        } else if (integer2 == SpinnerAnimation.FADE.getValue()) {
            this.powerSpinnerView.setSpinnerPopupAnimation(SpinnerAnimation.FADE);
        } else if (integer2 == SpinnerAnimation.BOUNCE.getValue()) {
            this.powerSpinnerView.setSpinnerPopupAnimation(SpinnerAnimation.BOUNCE);
        }
        this.powerSpinnerView.setSpinnerPopupAnimationStyle(typedArray.getResourceId(C1867R.styleable.PowerSpinnerView_spinner_popup_animation_style, this.powerSpinnerView.getSpinnerPopupAnimationStyle()));
        this.powerSpinnerView.setSpinnerPopupWidth(typedArray.getDimensionPixelSize(C1867R.styleable.PowerSpinnerView_spinner_popup_width, this.powerSpinnerView.getSpinnerPopupWidth()));
        this.powerSpinnerView.setSpinnerPopupHeight(typedArray.getDimensionPixelSize(C1867R.styleable.PowerSpinnerView_spinner_popup_height, this.powerSpinnerView.getSpinnerPopupHeight()));
        this.powerSpinnerView.setSpinnerPopupElevation(typedArray.getDimensionPixelSize(C1867R.styleable.PowerSpinnerView_spinner_popup_elevation, this.powerSpinnerView.getSpinnerPopupElevation()));
        int resourceId = typedArray.getResourceId(C1867R.styleable.PowerSpinnerView_spinner_item_array, -1);
        if (resourceId != -1) {
            this.powerSpinnerView.setItems(resourceId);
        }
        this.powerSpinnerView.setDismissWhenNotifiedItemSelected(typedArray.getBoolean(C1867R.styleable.PowerSpinnerView_spinner_dismiss_notified_select, this.powerSpinnerView.getDismissWhenNotifiedItemSelected()));
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        PowerSpinnerView powerSpinnerView2 = this.powerSpinnerView;
        powerSpinnerView2.selectItemByIndex(getPersistedInt(this.defaultValue));
        if (powerSpinnerView2.getSpinnerAdapter().getOnSpinnerItemSelectedListener() == null) {
            powerSpinnerView2.setOnSpinnerItemSelectedListener(new PowerSpinnerPreference$onBindViewHolder$$inlined$apply$lambda$1(this));
        }
        if (preferenceViewHolder != null) {
            View findViewById = preferenceViewHolder.findViewById(C1867R.C1870id.powerSpinner_preference);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) findViewById).addView(this.powerSpinnerView, -1, -2);
            View findViewById2 = preferenceViewHolder.findViewById(C1867R.C1870id.preference_title);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) findViewById2;
            textView.setText(getTitle());
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            PowerSpinnerView powerSpinnerView3 = this.powerSpinnerView;
            int marginStart = marginLayoutParams.getMarginStart();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            int dp2Px = ContextExtensionKt.dp2Px(context, 10);
            int marginEnd = marginLayoutParams.getMarginEnd();
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            powerSpinnerView3.setPadding(marginStart, dp2Px, marginEnd, ContextExtensionKt.dp2Px(context2, 10));
        }
    }

    public final <T> void setOnSpinnerItemSelectedListener(OnSpinnerItemSelectedListener<T> onSpinnerItemSelectedListener) {
        Intrinsics.checkNotNullParameter(onSpinnerItemSelectedListener, "onSpinnerItemSelectedListener");
        this.powerSpinnerView.setOnSpinnerItemSelectedListener(new PowerSpinnerPreference$setOnSpinnerItemSelectedListener$1(this, onSpinnerItemSelectedListener));
    }

    public final /* synthetic */ <T> void setOnSpinnerItemSelectedListener(Function4<? super Integer, ? super T, ? super Integer, ? super T, Unit> function4) {
        Intrinsics.checkNotNullParameter(function4, "block");
        this.powerSpinnerView.setOnSpinnerItemSelectedListener(new PowerSpinnerPreference$setOnSpinnerItemSelectedListener$2(this, function4));
    }

    /* access modifiers changed from: protected */
    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        Intrinsics.checkNotNullParameter(typedArray, HtmlTags.f1190A);
        return Integer.valueOf(typedArray.getInt(i, 0));
    }

    /* access modifiers changed from: protected */
    public void onSetInitialValue(Object obj) {
        super.onSetInitialValue(obj);
        if (obj instanceof Integer) {
            this.defaultValue = ((Number) obj).intValue();
        }
    }
}
