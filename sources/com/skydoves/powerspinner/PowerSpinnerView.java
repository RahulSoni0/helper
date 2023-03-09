package com.skydoves.powerspinner;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.skydoves.powerspinner.PowerSpinnerPersistence;
import com.skydoves.powerspinner.databinding.LayoutBodyPowerSpinnerLibraryBinding;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002:\u0002Á\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0014H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\b\u0010\u0001\u001a\u00030\u0001J\u001b\u0010\u0001\u001a\u00030\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0007J\u0012\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\nH\u0002J\u0015\u0010\u0001\u001a\t\u0012\u0005\u0012\u0003H\u00010\u0019\"\u0005\b\u0000\u0010\u0001J\b\u0010\u0001\u001a\u00030\u0001J\b\u0010\u0001\u001a\u00030\u0001J\u001b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\n2\b\u0010\u0001\u001a\u00030\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0007J\n\u0010\u0001\u001a\u00030\u0001H\u0014J\u0011\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\nJ\u000e\u0010C\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0014J\u0011\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0014J\u0013\u0010 \u0001\u001a\u00030\u00012\t\b\u0001\u0010¡\u0001\u001a\u00020\nJ \u0010 \u0001\u001a\u00030\u0001\"\u0005\b\u0000\u0010\u00012\u000f\u0010¢\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010£\u0001J\u0018\u0010X\u001a\u00030\u00012\u000f\u0010¤\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001J\u0001\u0010¥\u0001\u001a\u00030\u0001\"\u0005\b\u0000\u0010\u00012s\u0010¤\u0001\u001an\u0012\u0016\u0012\u00140\n¢\u0006\u000f\b§\u0001\u0012\n\b¨\u0001\u0012\u0005\b\b(©\u0001\u0012\u0019\u0012\u0017\u0018\u0001H\u0001¢\u0006\u000f\b§\u0001\u0012\n\b¨\u0001\u0012\u0005\b\b(ª\u0001\u0012\u0016\u0012\u00140\n¢\u0006\u000f\b§\u0001\u0012\n\b¨\u0001\u0012\u0005\b\b(«\u0001\u0012\u0017\u0012\u0015H\u0001¢\u0006\u000f\b§\u0001\u0012\n\b¨\u0001\u0012\u0005\b\b(¬\u0001\u0012\u0005\u0012\u00030\u00010¦\u0001J \u0010¥\u0001\u001a\u00030\u0001\"\u0005\b\u0000\u0010\u00012\u000f\u0010­\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010®\u0001J'\u0010¯\u0001\u001a\u00030\u00012\u001d\u0010¤\u0001\u001a\u0018\u0012\u0005\u0012\u00030±\u0001\u0012\u0005\u0012\u00030²\u0001\u0012\u0005\u0012\u00030\u00010°\u0001J\u001f\u0010³\u0001\u001a\u00030\u0001\"\u0005\b\u0000\u0010\u00012\u000e\u0010´\u0001\u001a\t\u0012\u0005\u0012\u0003H\u00010\u0019J\u0014\u0010µ\u0001\u001a\u00030\u00012\b\u0010¶\u0001\u001a\u00030·\u0001H\u0002J \u0010¸\u0001\u001a\u00030\u00012\t\b\u0002\u0010¹\u0001\u001a\u00020\n2\t\b\u0002\u0010º\u0001\u001a\u00020\nH\u0007J \u0010»\u0001\u001a\u00030\u00012\t\b\u0002\u0010¹\u0001\u001a\u00020\n2\t\b\u0002\u0010º\u0001\u001a\u00020\nH\u0007J\u0015\u0010¼\u0001\u001a\u00030\u00012\t\u0010½\u0001\u001a\u0004\u0018\u00010&H\u0002J\n\u0010¾\u0001\u001a\u00030\u0001H\u0002J\n\u0010¿\u0001\u001a\u00030\u0001H\u0002J\n\u0010À\u0001\u001a\u00030\u0001H\u0002R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010,\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R&\u00101\u001a\u00020\n2\b\b\u0001\u0010+\u001a\u00020\n8G@FX\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R&\u00106\u001a\u00020\n2\b\b\u0001\u0010+\u001a\u00020\n8G@FX\u000e¢\u0006\f\u001a\u0004\b7\u00103\"\u0004\b8\u00105R&\u00109\u001a\u00020\n2\b\b\u0001\u0010+\u001a\u00020\n8G@FX\u000e¢\u0006\f\u001a\u0004\b:\u00103\"\u0004\b;\u00105R\u000e\u0010<\u001a\u00020=X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010?\u001a\u00020 2\u0006\u0010>\u001a\u00020 @BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\"R\u001a\u0010A\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001c\"\u0004\bC\u0010\u001eR\u001a\u0010D\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001c\"\u0004\bF\u0010\u001eR&\u0010G\u001a\u00020\n2\b\b\u0001\u0010+\u001a\u00020\n8G@FX\u000e¢\u0006\f\u001a\u0004\bH\u00103\"\u0004\bI\u00105R&\u0010J\u001a\u00020\n2\b\b\u0001\u0010+\u001a\u00020\n8G@FX\u000e¢\u0006\f\u001a\u0004\bK\u00103\"\u0004\bL\u00105R\u001e\u0010M\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u0014@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u001cR(\u0010O\u001a\u0004\u0018\u00010N2\b\u0010+\u001a\u0004\u0018\u00010N@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001c\u0010T\u001a\u0004\u0018\u00010UX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR(\u0010[\u001a\u0004\u0018\u00010Z2\b\u0010+\u001a\u0004\u0018\u00010Z@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u000e\u0010`\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010a\u001a\u00020\n2\u0006\u0010>\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bb\u00103R$\u0010c\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u00148F@FX\u000e¢\u0006\f\u001a\u0004\bd\u0010\u001c\"\u0004\be\u0010\u001eR$\u0010f\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u00148F@FX\u000e¢\u0006\f\u001a\u0004\bg\u0010\u001c\"\u0004\bh\u0010\u001eR\u001c\u0010i\u001a\u0004\u0018\u00010jX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010o\u001a\u00020pX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001e\u0010u\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u00103\"\u0004\bw\u00105R&\u0010x\u001a\u00020\n2\b\b\u0001\u0010+\u001a\u00020\n8G@FX\u000e¢\u0006\f\u001a\u0004\by\u00103\"\u0004\bz\u00105R&\u0010{\u001a\u00020\n2\b\b\u0001\u0010+\u001a\u00020\n8G@FX\u000e¢\u0006\f\u001a\u0004\b|\u00103\"\u0004\b}\u00105R\u001b\u0010~\u001a\u00020\nX\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u00103\"\u0005\b\u0001\u00105R\u001d\u0010\u0001\u001a\u00020\nX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u00103\"\u0005\b\u0001\u00105R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006Â\u0001"}, mo18301d2 = {"Lcom/skydoves/powerspinner/PowerSpinnerView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_arrowGravity", "Lcom/skydoves/powerspinner/SpinnerGravity;", "_arrowPadding", "_arrowResource", "_arrowTint", "_dividerColor", "_dividerSize", "_showArrow", "", "_showDivider", "_spinnerPopupBackgroundColor", "_spinnerPopupElevation", "adapter", "Lcom/skydoves/powerspinner/PowerSpinnerInterface;", "arrowAnimate", "getArrowAnimate", "()Z", "setArrowAnimate", "(Z)V", "arrowAnimationDuration", "", "getArrowAnimationDuration", "()J", "setArrowAnimationDuration", "(J)V", "arrowDrawable", "Landroid/graphics/drawable/Drawable;", "getArrowDrawable", "()Landroid/graphics/drawable/Drawable;", "setArrowDrawable", "(Landroid/graphics/drawable/Drawable;)V", "value", "arrowGravity", "getArrowGravity", "()Lcom/skydoves/powerspinner/SpinnerGravity;", "setArrowGravity", "(Lcom/skydoves/powerspinner/SpinnerGravity;)V", "arrowPadding", "getArrowPadding", "()I", "setArrowPadding", "(I)V", "arrowResource", "getArrowResource", "setArrowResource", "arrowTint", "getArrowTint", "setArrowTint", "binding", "Lcom/skydoves/powerspinner/databinding/LayoutBodyPowerSpinnerLibraryBinding;", "<set-?>", "debounceDuration", "getDebounceDuration", "disableChangeTextWhenNotified", "getDisableChangeTextWhenNotified", "setDisableChangeTextWhenNotified", "dismissWhenNotifiedItemSelected", "getDismissWhenNotifiedItemSelected", "setDismissWhenNotifiedItemSelected", "dividerColor", "getDividerColor", "setDividerColor", "dividerSize", "getDividerSize", "setDividerSize", "isShowing", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "onSpinnerDismissListener", "Lcom/skydoves/powerspinner/OnSpinnerDismissListener;", "getOnSpinnerDismissListener", "()Lcom/skydoves/powerspinner/OnSpinnerDismissListener;", "setOnSpinnerDismissListener", "(Lcom/skydoves/powerspinner/OnSpinnerDismissListener;)V", "", "preferenceName", "getPreferenceName", "()Ljava/lang/String;", "setPreferenceName", "(Ljava/lang/String;)V", "previousDebounceTime", "selectedIndex", "getSelectedIndex", "showArrow", "getShowArrow", "setShowArrow", "showDivider", "getShowDivider", "setShowDivider", "spinnerOutsideTouchListener", "Lcom/skydoves/powerspinner/OnSpinnerOutsideTouchListener;", "getSpinnerOutsideTouchListener", "()Lcom/skydoves/powerspinner/OnSpinnerOutsideTouchListener;", "setSpinnerOutsideTouchListener", "(Lcom/skydoves/powerspinner/OnSpinnerOutsideTouchListener;)V", "spinnerPopupAnimation", "Lcom/skydoves/powerspinner/SpinnerAnimation;", "getSpinnerPopupAnimation", "()Lcom/skydoves/powerspinner/SpinnerAnimation;", "setSpinnerPopupAnimation", "(Lcom/skydoves/powerspinner/SpinnerAnimation;)V", "spinnerPopupAnimationStyle", "getSpinnerPopupAnimationStyle", "setSpinnerPopupAnimationStyle", "spinnerPopupBackgroundColor", "getSpinnerPopupBackgroundColor", "setSpinnerPopupBackgroundColor", "spinnerPopupElevation", "getSpinnerPopupElevation", "setSpinnerPopupElevation", "spinnerPopupHeight", "getSpinnerPopupHeight", "setSpinnerPopupHeight", "spinnerPopupWidth", "getSpinnerPopupWidth", "setSpinnerPopupWidth", "spinnerWindow", "Landroid/widget/PopupWindow;", "animateArrow", "", "shouldRotateUp", "applyWindowAnimation", "clearSelectedItem", "debounceShowOrDismiss", "action", "Lkotlin/Function0;", "dismiss", "getAttrs", "defStyleAttr", "getSpinnerAdapter", "T", "getSpinnerBodyView", "Landroid/widget/FrameLayout;", "getSpinnerRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "notifyItemSelected", "index", "changedText", "", "onDestroy", "onFinishInflate", "selectItemByIndex", "setIsFocusable", "isFocusable", "setItems", "resource", "itemList", "", "block", "setOnSpinnerItemSelectedListener", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "oldIndex", "oldItem", "newIndex", "newItem", "onSpinnerItemSelectedListener", "Lcom/skydoves/powerspinner/OnSpinnerItemSelectedListener;", "setOnSpinnerOutsideTouchListener", "Lkotlin/Function2;", "Landroid/view/View;", "Landroid/view/MotionEvent;", "setSpinnerAdapter", "powerSpinnerInterface", "setTypeArray", "a", "Landroid/content/res/TypedArray;", "show", "xOff", "yOff", "showOrDismiss", "updateCompoundDrawable", "drawable", "updateSpinnerArrow", "updateSpinnerPersistence", "updateSpinnerWindow", "Builder", "powerspinner_release"}, mo18302k = 1, mo18303mv = {1, 4, 1})
/* compiled from: PowerSpinnerView.kt */
public final class PowerSpinnerView extends AppCompatTextView implements LifecycleObserver {
    private SpinnerGravity _arrowGravity;
    private int _arrowPadding;
    private int _arrowResource;
    private int _arrowTint;
    private int _dividerColor;
    private int _dividerSize;
    private boolean _showArrow;
    private boolean _showDivider;
    private int _spinnerPopupBackgroundColor;
    private int _spinnerPopupElevation;
    /* access modifiers changed from: private */
    public PowerSpinnerInterface<?> adapter = new DefaultSpinnerAdapter(this);
    private boolean arrowAnimate = true;
    private long arrowAnimationDuration = 250;
    private Drawable arrowDrawable;
    /* access modifiers changed from: private */
    public final LayoutBodyPowerSpinnerLibraryBinding binding;
    private long debounceDuration;
    private boolean disableChangeTextWhenNotified;
    private boolean dismissWhenNotifiedItemSelected;
    /* access modifiers changed from: private */
    public boolean isShowing;
    private LifecycleOwner lifecycleOwner;
    private OnSpinnerDismissListener onSpinnerDismissListener;
    private String preferenceName;
    private long previousDebounceTime;
    private int selectedIndex = -1;
    private OnSpinnerOutsideTouchListener spinnerOutsideTouchListener;
    private SpinnerAnimation spinnerPopupAnimation;
    private int spinnerPopupAnimationStyle;
    private int spinnerPopupHeight;
    private int spinnerPopupWidth;
    /* access modifiers changed from: private */
    public final PopupWindow spinnerWindow;

    @Metadata(mo18299bv = {1, 0, 3}, mo18302k = 3, mo18303mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SpinnerGravity.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[SpinnerGravity.START.ordinal()] = 1;
            iArr[SpinnerGravity.TOP.ordinal()] = 2;
            iArr[SpinnerGravity.END.ordinal()] = 3;
            iArr[SpinnerGravity.BOTTOM.ordinal()] = 4;
            int[] iArr2 = new int[SpinnerAnimation.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[SpinnerAnimation.DROPDOWN.ordinal()] = 1;
            iArr2[SpinnerAnimation.FADE.ordinal()] = 2;
            iArr2[SpinnerAnimation.BOUNCE.ordinal()] = 3;
        }
    }

    public final void show() {
        show$default(this, 0, 0, 3, (Object) null);
    }

    public final void show(int i) {
        show$default(this, i, 0, 2, (Object) null);
    }

    public final void showOrDismiss() {
        showOrDismiss$default(this, 0, 0, 3, (Object) null);
    }

    public final void showOrDismiss(int i) {
        showOrDismiss$default(this, i, 0, 2, (Object) null);
    }

    public final boolean isShowing() {
        return this.isShowing;
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public final boolean getArrowAnimate() {
        return this.arrowAnimate;
    }

    public final void setArrowAnimate(boolean z) {
        this.arrowAnimate = z;
    }

    public final long getArrowAnimationDuration() {
        return this.arrowAnimationDuration;
    }

    public final void setArrowAnimationDuration(long j) {
        this.arrowAnimationDuration = j;
    }

    public final Drawable getArrowDrawable() {
        return this.arrowDrawable;
    }

    public final void setArrowDrawable(Drawable drawable) {
        this.arrowDrawable = drawable;
    }

    public final long getDebounceDuration() {
        return this.debounceDuration;
    }

    public final boolean getDisableChangeTextWhenNotified() {
        return this.disableChangeTextWhenNotified;
    }

    /* renamed from: setDisableChangeTextWhenNotified  reason: collision with other method in class */
    public final void m990setDisableChangeTextWhenNotified(boolean z) {
        this.disableChangeTextWhenNotified = z;
    }

    public final int getArrowResource() {
        return this._arrowResource;
    }

    public final void setArrowResource(int i) {
        this._arrowResource = i;
        updateSpinnerArrow();
    }

    public final boolean getShowArrow() {
        return this._showArrow;
    }

    public final void setShowArrow(boolean z) {
        this._showArrow = z;
        updateSpinnerArrow();
    }

    public final SpinnerGravity getArrowGravity() {
        return this._arrowGravity;
    }

    public final void setArrowGravity(SpinnerGravity spinnerGravity) {
        Intrinsics.checkNotNullParameter(spinnerGravity, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        this._arrowGravity = spinnerGravity;
        updateSpinnerArrow();
    }

    public final int getArrowPadding() {
        return this._arrowPadding;
    }

    public final void setArrowPadding(int i) {
        this._arrowPadding = i;
        updateSpinnerArrow();
    }

    public final int getArrowTint() {
        return this._arrowTint;
    }

    public final void setArrowTint(int i) {
        this._arrowTint = i;
        updateSpinnerArrow();
    }

    public final boolean getShowDivider() {
        return this._showDivider;
    }

    public final void setShowDivider(boolean z) {
        this._showDivider = z;
        updateSpinnerWindow();
    }

    public final int getDividerSize() {
        return this._dividerSize;
    }

    public final void setDividerSize(int i) {
        this._dividerSize = i;
        updateSpinnerWindow();
    }

    public final int getDividerColor() {
        return this._dividerColor;
    }

    public final void setDividerColor(int i) {
        this._dividerColor = i;
        updateSpinnerWindow();
    }

    public final int getSpinnerPopupBackgroundColor() {
        return this._spinnerPopupBackgroundColor;
    }

    public final void setSpinnerPopupBackgroundColor(int i) {
        this._spinnerPopupBackgroundColor = i;
        updateSpinnerWindow();
    }

    public final int getSpinnerPopupElevation() {
        return this._spinnerPopupElevation;
    }

    public final void setSpinnerPopupElevation(int i) {
        this._spinnerPopupElevation = i;
        updateSpinnerWindow();
    }

    public final int getSpinnerPopupAnimationStyle() {
        return this.spinnerPopupAnimationStyle;
    }

    public final void setSpinnerPopupAnimationStyle(int i) {
        this.spinnerPopupAnimationStyle = i;
    }

    public final int getSpinnerPopupWidth() {
        return this.spinnerPopupWidth;
    }

    public final void setSpinnerPopupWidth(int i) {
        this.spinnerPopupWidth = i;
    }

    public final int getSpinnerPopupHeight() {
        return this.spinnerPopupHeight;
    }

    public final void setSpinnerPopupHeight(int i) {
        this.spinnerPopupHeight = i;
    }

    public final boolean getDismissWhenNotifiedItemSelected() {
        return this.dismissWhenNotifiedItemSelected;
    }

    public final void setDismissWhenNotifiedItemSelected(boolean z) {
        this.dismissWhenNotifiedItemSelected = z;
    }

    public final OnSpinnerOutsideTouchListener getSpinnerOutsideTouchListener() {
        return this.spinnerOutsideTouchListener;
    }

    public final void setSpinnerOutsideTouchListener(OnSpinnerOutsideTouchListener onSpinnerOutsideTouchListener) {
        this.spinnerOutsideTouchListener = onSpinnerOutsideTouchListener;
    }

    public final OnSpinnerDismissListener getOnSpinnerDismissListener() {
        return this.onSpinnerDismissListener;
    }

    public final void setOnSpinnerDismissListener(OnSpinnerDismissListener onSpinnerDismissListener2) {
        this.onSpinnerDismissListener = onSpinnerDismissListener2;
    }

    public final SpinnerAnimation getSpinnerPopupAnimation() {
        return this.spinnerPopupAnimation;
    }

    public final void setSpinnerPopupAnimation(SpinnerAnimation spinnerAnimation) {
        Intrinsics.checkNotNullParameter(spinnerAnimation, "<set-?>");
        this.spinnerPopupAnimation = spinnerAnimation;
    }

    public final String getPreferenceName() {
        return this.preferenceName;
    }

    public final void setPreferenceName(String str) {
        this.preferenceName = str;
        updateSpinnerPersistence();
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public final void setLifecycleOwner(LifecycleOwner lifecycleOwner2) {
        Lifecycle lifecycle;
        this.lifecycleOwner = lifecycleOwner2;
        if (lifecycleOwner2 != null && (lifecycle = lifecycleOwner2.getLifecycle()) != null) {
            lifecycle.addObserver(this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PowerSpinnerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawable = null;
        LayoutBodyPowerSpinnerLibraryBinding inflate = LayoutBodyPowerSpinnerLibraryBinding.inflate(LayoutInflater.from(getContext()), (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutBodyPowerSpinnerLi…om(context), null, false)");
        this.binding = inflate;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        Drawable contextDrawable = ContextExtensionKt.contextDrawable(context2, C1867R.C1869drawable.arrow_power_spinner_library);
        this.arrowDrawable = contextDrawable != null ? contextDrawable.mutate() : drawable;
        this.debounceDuration = 150;
        this._arrowResource = Integer.MIN_VALUE;
        this._showArrow = true;
        this._arrowGravity = SpinnerGravity.END;
        this._arrowTint = -1;
        this._dividerSize = ContextExtensionKt.dp2Px((View) this, 0.5f);
        this._dividerColor = -1;
        this._spinnerPopupBackgroundColor = ContextExtensionKt.outRangeColor;
        this._spinnerPopupElevation = ContextExtensionKt.dp2Px((View) this, 4);
        this.spinnerPopupAnimationStyle = Integer.MIN_VALUE;
        this.spinnerPopupWidth = Integer.MIN_VALUE;
        this.spinnerPopupHeight = Integer.MIN_VALUE;
        this.dismissWhenNotifiedItemSelected = true;
        this.spinnerPopupAnimation = SpinnerAnimation.NORMAL;
        if (this.adapter instanceof RecyclerView.Adapter) {
            RecyclerView spinnerRecyclerView = getSpinnerRecyclerView();
            PowerSpinnerInterface<?> powerSpinnerInterface = this.adapter;
            Objects.requireNonNull(powerSpinnerInterface, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.Adapter<*>");
            spinnerRecyclerView.setAdapter((RecyclerView.Adapter) powerSpinnerInterface);
        }
        this.spinnerWindow = new PopupWindow(inflate.body, -1, -2);
        setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ PowerSpinnerView this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                PowerSpinnerView.showOrDismiss$default(this.this$0, 0, 0, 3, (Object) null);
            }
        });
        if (getGravity() == 0) {
            setGravity(16);
        }
        Context context3 = getContext();
        if (context3 instanceof LifecycleOwner) {
            setLifecycleOwner((LifecycleOwner) context3);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PowerSpinnerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        Drawable drawable = null;
        LayoutBodyPowerSpinnerLibraryBinding inflate = LayoutBodyPowerSpinnerLibraryBinding.inflate(LayoutInflater.from(getContext()), (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutBodyPowerSpinnerLi…om(context), null, false)");
        this.binding = inflate;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        Drawable contextDrawable = ContextExtensionKt.contextDrawable(context2, C1867R.C1869drawable.arrow_power_spinner_library);
        this.arrowDrawable = contextDrawable != null ? contextDrawable.mutate() : drawable;
        this.debounceDuration = 150;
        this._arrowResource = Integer.MIN_VALUE;
        this._showArrow = true;
        this._arrowGravity = SpinnerGravity.END;
        this._arrowTint = -1;
        this._dividerSize = ContextExtensionKt.dp2Px((View) this, 0.5f);
        this._dividerColor = -1;
        this._spinnerPopupBackgroundColor = ContextExtensionKt.outRangeColor;
        this._spinnerPopupElevation = ContextExtensionKt.dp2Px((View) this, 4);
        this.spinnerPopupAnimationStyle = Integer.MIN_VALUE;
        this.spinnerPopupWidth = Integer.MIN_VALUE;
        this.spinnerPopupHeight = Integer.MIN_VALUE;
        this.dismissWhenNotifiedItemSelected = true;
        this.spinnerPopupAnimation = SpinnerAnimation.NORMAL;
        if (this.adapter instanceof RecyclerView.Adapter) {
            RecyclerView spinnerRecyclerView = getSpinnerRecyclerView();
            PowerSpinnerInterface<?> powerSpinnerInterface = this.adapter;
            Objects.requireNonNull(powerSpinnerInterface, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.Adapter<*>");
            spinnerRecyclerView.setAdapter((RecyclerView.Adapter) powerSpinnerInterface);
        }
        this.spinnerWindow = new PopupWindow(inflate.body, -1, -2);
        setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ PowerSpinnerView this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                PowerSpinnerView.showOrDismiss$default(this.this$0, 0, 0, 3, (Object) null);
            }
        });
        if (getGravity() == 0) {
            setGravity(16);
        }
        Context context3 = getContext();
        if (context3 instanceof LifecycleOwner) {
            setLifecycleOwner((LifecycleOwner) context3);
        }
        getAttrs(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PowerSpinnerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        Drawable drawable = null;
        LayoutBodyPowerSpinnerLibraryBinding inflate = LayoutBodyPowerSpinnerLibraryBinding.inflate(LayoutInflater.from(getContext()), (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutBodyPowerSpinnerLi…om(context), null, false)");
        this.binding = inflate;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        Drawable contextDrawable = ContextExtensionKt.contextDrawable(context2, C1867R.C1869drawable.arrow_power_spinner_library);
        this.arrowDrawable = contextDrawable != null ? contextDrawable.mutate() : drawable;
        this.debounceDuration = 150;
        this._arrowResource = Integer.MIN_VALUE;
        this._showArrow = true;
        this._arrowGravity = SpinnerGravity.END;
        this._arrowTint = -1;
        this._dividerSize = ContextExtensionKt.dp2Px((View) this, 0.5f);
        this._dividerColor = -1;
        this._spinnerPopupBackgroundColor = ContextExtensionKt.outRangeColor;
        this._spinnerPopupElevation = ContextExtensionKt.dp2Px((View) this, 4);
        this.spinnerPopupAnimationStyle = Integer.MIN_VALUE;
        this.spinnerPopupWidth = Integer.MIN_VALUE;
        this.spinnerPopupHeight = Integer.MIN_VALUE;
        this.dismissWhenNotifiedItemSelected = true;
        this.spinnerPopupAnimation = SpinnerAnimation.NORMAL;
        if (this.adapter instanceof RecyclerView.Adapter) {
            RecyclerView spinnerRecyclerView = getSpinnerRecyclerView();
            PowerSpinnerInterface<?> powerSpinnerInterface = this.adapter;
            Objects.requireNonNull(powerSpinnerInterface, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.Adapter<*>");
            spinnerRecyclerView.setAdapter((RecyclerView.Adapter) powerSpinnerInterface);
        }
        this.spinnerWindow = new PopupWindow(inflate.body, -1, -2);
        setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ PowerSpinnerView this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                PowerSpinnerView.showOrDismiss$default(this.this$0, 0, 0, 3, (Object) null);
            }
        });
        if (getGravity() == 0) {
            setGravity(16);
        }
        Context context3 = getContext();
        if (context3 instanceof LifecycleOwner) {
            setLifecycleOwner((LifecycleOwner) context3);
        }
        getAttrs(attributeSet, i);
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
        int resourceId;
        SpinnerAnimation spinnerAnimation;
        SpinnerGravity spinnerGravity;
        if (typedArray.hasValue(C1867R.styleable.PowerSpinnerView_spinner_arrow_drawable)) {
            this._arrowResource = typedArray.getResourceId(C1867R.styleable.PowerSpinnerView_spinner_arrow_drawable, this._arrowResource);
        }
        if (typedArray.hasValue(C1867R.styleable.PowerSpinnerView_spinner_arrow_show)) {
            this._showArrow = typedArray.getBoolean(C1867R.styleable.PowerSpinnerView_spinner_arrow_show, this._showArrow);
        }
        if (typedArray.hasValue(C1867R.styleable.PowerSpinnerView_spinner_arrow_gravity)) {
            int integer = typedArray.getInteger(C1867R.styleable.PowerSpinnerView_spinner_arrow_gravity, this._arrowGravity.getValue());
            if (integer == SpinnerGravity.START.getValue()) {
                spinnerGravity = SpinnerGravity.START;
            } else if (integer == SpinnerGravity.TOP.getValue()) {
                spinnerGravity = SpinnerGravity.TOP;
            } else if (integer == SpinnerGravity.END.getValue()) {
                spinnerGravity = SpinnerGravity.END;
            } else if (integer == SpinnerGravity.BOTTOM.getValue()) {
                spinnerGravity = SpinnerGravity.BOTTOM;
            } else {
                throw new IllegalArgumentException("unknown argument: spinner_arrow_gravity");
            }
            this._arrowGravity = spinnerGravity;
        }
        if (typedArray.hasValue(C1867R.styleable.PowerSpinnerView_spinner_arrow_padding)) {
            this._arrowPadding = typedArray.getDimensionPixelSize(C1867R.styleable.PowerSpinnerView_spinner_arrow_padding, this._arrowPadding);
        }
        if (typedArray.hasValue(C1867R.styleable.PowerSpinnerView_spinner_arrow_tint)) {
            this._arrowTint = typedArray.getColor(C1867R.styleable.PowerSpinnerView_spinner_arrow_tint, this._arrowTint);
        }
        if (typedArray.hasValue(C1867R.styleable.PowerSpinnerView_spinner_arrow_animate)) {
            this.arrowAnimate = typedArray.getBoolean(C1867R.styleable.PowerSpinnerView_spinner_arrow_animate, this.arrowAnimate);
        }
        if (typedArray.hasValue(C1867R.styleable.PowerSpinnerView_spinner_arrow_animate_duration)) {
            this.arrowAnimationDuration = (long) typedArray.getInteger(C1867R.styleable.PowerSpinnerView_spinner_arrow_animate_duration, (int) this.arrowAnimationDuration);
        }
        if (typedArray.hasValue(C1867R.styleable.PowerSpinnerView_spinner_divider_show)) {
            this._showDivider = typedArray.getBoolean(C1867R.styleable.PowerSpinnerView_spinner_divider_show, this._showDivider);
        }
        if (typedArray.hasValue(C1867R.styleable.PowerSpinnerView_spinner_divider_size)) {
            this._dividerSize = typedArray.getDimensionPixelSize(C1867R.styleable.PowerSpinnerView_spinner_divider_size, this._dividerSize);
        }
        if (typedArray.hasValue(C1867R.styleable.PowerSpinnerView_spinner_divider_color)) {
            this._dividerColor = typedArray.getColor(C1867R.styleable.PowerSpinnerView_spinner_divider_color, this._dividerColor);
        }
        if (typedArray.hasValue(C1867R.styleable.PowerSpinnerView_spinner_popup_background)) {
            this._spinnerPopupBackgroundColor = typedArray.getColor(C1867R.styleable.PowerSpinnerView_spinner_popup_background, this._spinnerPopupBackgroundColor);
        }
        if (typedArray.hasValue(C1867R.styleable.PowerSpinnerView_spinner_popup_animation)) {
            int integer2 = typedArray.getInteger(C1867R.styleable.PowerSpinnerView_spinner_popup_animation, this.spinnerPopupAnimation.getValue());
            if (integer2 == SpinnerAnimation.DROPDOWN.getValue()) {
                spinnerAnimation = SpinnerAnimation.DROPDOWN;
            } else if (integer2 == SpinnerAnimation.FADE.getValue()) {
                spinnerAnimation = SpinnerAnimation.FADE;
            } else if (integer2 == SpinnerAnimation.BOUNCE.getValue()) {
                spinnerAnimation = SpinnerAnimation.BOUNCE;
            } else if (integer2 == SpinnerAnimation.NORMAL.getValue()) {
                spinnerAnimation = SpinnerAnimation.NORMAL;
            } else {
                throw new IllegalArgumentException("unknown argument: spinner_popup_animation");
            }
            this.spinnerPopupAnimation = spinnerAnimation;
        }
        if (typedArray.hasValue(C1867R.styleable.PowerSpinnerView_spinner_popup_animation_style)) {
            this.spinnerPopupAnimationStyle = typedArray.getResourceId(C1867R.styleable.PowerSpinnerView_spinner_popup_animation_style, this.spinnerPopupAnimationStyle);
        }
        if (typedArray.hasValue(C1867R.styleable.PowerSpinnerView_spinner_popup_width)) {
            this.spinnerPopupWidth = typedArray.getDimensionPixelSize(C1867R.styleable.PowerSpinnerView_spinner_popup_width, this.spinnerPopupWidth);
        }
        if (typedArray.hasValue(C1867R.styleable.PowerSpinnerView_spinner_popup_height)) {
            this.spinnerPopupHeight = typedArray.getDimensionPixelSize(C1867R.styleable.PowerSpinnerView_spinner_popup_height, this.spinnerPopupHeight);
        }
        if (typedArray.hasValue(C1867R.styleable.PowerSpinnerView_spinner_popup_elevation)) {
            this._spinnerPopupElevation = typedArray.getDimensionPixelSize(C1867R.styleable.PowerSpinnerView_spinner_popup_elevation, this._spinnerPopupElevation);
        }
        if (typedArray.hasValue(C1867R.styleable.PowerSpinnerView_spinner_item_array) && (resourceId = typedArray.getResourceId(C1867R.styleable.PowerSpinnerView_spinner_item_array, Integer.MIN_VALUE)) != Integer.MIN_VALUE) {
            setItems(resourceId);
        }
        if (typedArray.hasValue(C1867R.styleable.PowerSpinnerView_spinner_dismiss_notified_select)) {
            this.dismissWhenNotifiedItemSelected = typedArray.getBoolean(C1867R.styleable.PowerSpinnerView_spinner_dismiss_notified_select, this.dismissWhenNotifiedItemSelected);
        }
        if (typedArray.hasValue(C1867R.styleable.PowerSpinnerView_spinner_debounce_duration)) {
            this.debounceDuration = (long) typedArray.getInteger(C1867R.styleable.PowerSpinnerView_spinner_debounce_duration, (int) this.debounceDuration);
        }
        if (typedArray.hasValue(C1867R.styleable.PowerSpinnerView_spinner_preference_name)) {
            setPreferenceName(typedArray.getString(C1867R.styleable.PowerSpinnerView_spinner_preference_name));
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        updateSpinnerWindow();
        updateSpinnerArrow();
        updateSpinnerPersistence();
    }

    private final void updateSpinnerWindow() {
        post(new PowerSpinnerView$updateSpinnerWindow$1(this));
    }

    private final void updateSpinnerArrow() {
        if (getArrowResource() != Integer.MIN_VALUE) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Drawable contextDrawable = ContextExtensionKt.contextDrawable(context, getArrowResource());
            this.arrowDrawable = contextDrawable != null ? contextDrawable.mutate() : null;
        }
        setCompoundDrawablePadding(getArrowPadding());
        updateCompoundDrawable(this.arrowDrawable);
    }

    private final void updateCompoundDrawable(Drawable drawable) {
        if (getShowArrow()) {
            if (drawable != null) {
                Drawable mutate = DrawableCompat.wrap(drawable).mutate();
                Intrinsics.checkNotNullExpressionValue(mutate, "DrawableCompat.wrap(it).mutate()");
                DrawableCompat.setTint(mutate, getArrowTint());
                mutate.invalidateSelf();
            }
            int i = WhenMappings.$EnumSwitchMapping$0[getArrowGravity().ordinal()];
            if (i == 1) {
                setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (i == 2) {
                setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
            } else if (i == 3) {
                setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            } else if (i == 4) {
                setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, drawable);
            }
        } else {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    private final void updateSpinnerPersistence() {
        if (this.adapter.getItemCount() > 0) {
            String str = this.preferenceName;
            CharSequence charSequence = str;
            if (!(charSequence == null || charSequence.length() == 0)) {
                PowerSpinnerPersistence.Companion companion = PowerSpinnerPersistence.Companion;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                if (companion.getInstance(context).getSelectedIndex(str) != -1) {
                    PowerSpinnerInterface<?> powerSpinnerInterface = this.adapter;
                    PowerSpinnerPersistence.Companion companion2 = PowerSpinnerPersistence.Companion;
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    powerSpinnerInterface.notifyItemSelected(companion2.getInstance(context2).getSelectedIndex(str));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void applyWindowAnimation() {
        int i = this.spinnerPopupAnimationStyle;
        if (i == Integer.MIN_VALUE) {
            int i2 = WhenMappings.$EnumSwitchMapping$1[this.spinnerPopupAnimation.ordinal()];
            if (i2 == 1) {
                this.spinnerWindow.setAnimationStyle(C1867R.style.DropDown_PowerSpinner);
            } else if (i2 == 2) {
                this.spinnerWindow.setAnimationStyle(C1867R.style.Fade_PowerSpinner);
            } else if (i2 == 3) {
                this.spinnerWindow.setAnimationStyle(C1867R.style.Elastic_PowerSpinner);
            }
        } else {
            this.spinnerWindow.setAnimationStyle(i);
        }
    }

    public final RecyclerView getSpinnerRecyclerView() {
        RecyclerView recyclerView = this.binding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        return recyclerView;
    }

    public final FrameLayout getSpinnerBodyView() {
        FrameLayout frameLayout = this.binding.body;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.body");
        return frameLayout;
    }

    public final <T> void setItems(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "itemList");
        PowerSpinnerInterface<?> powerSpinnerInterface = this.adapter;
        Objects.requireNonNull(powerSpinnerInterface, "null cannot be cast to non-null type com.skydoves.powerspinner.PowerSpinnerInterface<T>");
        powerSpinnerInterface.setItems(list);
    }

    public final void setItems(int i) {
        if (this.adapter instanceof DefaultSpinnerAdapter) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String[] stringArray = context.getResources().getStringArray(i);
            Intrinsics.checkNotNullExpressionValue(stringArray, "context.resources.getStringArray(resource)");
            setItems(ArraysKt.toList((T[]) stringArray));
        }
    }

    public final <T> void setSpinnerAdapter(PowerSpinnerInterface<T> powerSpinnerInterface) {
        Intrinsics.checkNotNullParameter(powerSpinnerInterface, "powerSpinnerInterface");
        this.adapter = powerSpinnerInterface;
        if (powerSpinnerInterface instanceof RecyclerView.Adapter) {
            RecyclerView spinnerRecyclerView = getSpinnerRecyclerView();
            PowerSpinnerInterface<?> powerSpinnerInterface2 = this.adapter;
            Objects.requireNonNull(powerSpinnerInterface2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.Adapter<*>");
            spinnerRecyclerView.setAdapter((RecyclerView.Adapter) powerSpinnerInterface2);
        }
    }

    public final <T> PowerSpinnerInterface<T> getSpinnerAdapter() {
        PowerSpinnerInterface<?> powerSpinnerInterface = this.adapter;
        Objects.requireNonNull(powerSpinnerInterface, "null cannot be cast to non-null type com.skydoves.powerspinner.PowerSpinnerInterface<T>");
        return powerSpinnerInterface;
    }

    public final <T> void setOnSpinnerItemSelectedListener(OnSpinnerItemSelectedListener<T> onSpinnerItemSelectedListener) {
        Intrinsics.checkNotNullParameter(onSpinnerItemSelectedListener, "onSpinnerItemSelectedListener");
        PowerSpinnerInterface<?> powerSpinnerInterface = this.adapter;
        Objects.requireNonNull(powerSpinnerInterface, "null cannot be cast to non-null type com.skydoves.powerspinner.PowerSpinnerInterface<T>");
        powerSpinnerInterface.setOnSpinnerItemSelectedListener(onSpinnerItemSelectedListener);
    }

    public final /* synthetic */ <T> void setOnSpinnerItemSelectedListener(Function4<? super Integer, ? super T, ? super Integer, ? super T, Unit> function4) {
        Intrinsics.checkNotNullParameter(function4, "block");
        PowerSpinnerInterface<?> powerSpinnerInterface = this.adapter;
        Objects.requireNonNull(powerSpinnerInterface, "null cannot be cast to non-null type com.skydoves.powerspinner.PowerSpinnerInterface<T>");
        powerSpinnerInterface.setOnSpinnerItemSelectedListener(new PowerSpinnerView$setOnSpinnerItemSelectedListener$1(function4));
    }

    public final /* synthetic */ void setOnSpinnerOutsideTouchListener(Function2<? super View, ? super MotionEvent, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        this.spinnerOutsideTouchListener = new PowerSpinnerView$setOnSpinnerOutsideTouchListener$1(function2);
    }

    public final /* synthetic */ void setOnSpinnerDismissListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.onSpinnerDismissListener = new PowerSpinnerView$setOnSpinnerDismissListener$1(function0);
    }

    public static /* synthetic */ void show$default(PowerSpinnerView powerSpinnerView, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        powerSpinnerView.show(i, i2);
    }

    public final void show(int i, int i2) {
        debounceShowOrDismiss(new PowerSpinnerView$show$1(this, i, i2));
    }

    public final void dismiss() {
        debounceShowOrDismiss(new PowerSpinnerView$dismiss$1(this));
    }

    public static /* synthetic */ void showOrDismiss$default(PowerSpinnerView powerSpinnerView, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        powerSpinnerView.showOrDismiss(i, i2);
    }

    public final void showOrDismiss(int i, int i2) {
        RecyclerView.Adapter adapter2 = getSpinnerRecyclerView().getAdapter();
        if (adapter2 != null) {
            Intrinsics.checkNotNullExpressionValue(adapter2, "getSpinnerRecyclerView().adapter ?: return");
            if (this.isShowing || adapter2.getItemCount() <= 0) {
                dismiss();
            } else {
                show(i, i2);
            }
        }
    }

    public final PowerSpinnerView setDisableChangeTextWhenNotified(boolean z) {
        PowerSpinnerView powerSpinnerView = this;
        this.disableChangeTextWhenNotified = z;
        return this;
    }

    public final void setIsFocusable(boolean z) {
        this.spinnerWindow.setFocusable(z);
        this.onSpinnerDismissListener = new PowerSpinnerView$setIsFocusable$1(this);
    }

    private final void debounceShowOrDismiss(Function0<Unit> function0) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.previousDebounceTime > this.debounceDuration) {
            this.previousDebounceTime = currentTimeMillis;
            function0.invoke();
        }
    }

    public final void selectItemByIndex(int i) {
        this.adapter.notifyItemSelected(i);
    }

    public final void notifyItemSelected(int i, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "changedText");
        this.selectedIndex = i;
        if (!this.disableChangeTextWhenNotified) {
            setText(charSequence);
        }
        if (this.dismissWhenNotifiedItemSelected) {
            dismiss();
        }
        String str = this.preferenceName;
        CharSequence charSequence2 = str;
        if (!(charSequence2 == null || charSequence2.length() == 0)) {
            PowerSpinnerPersistence.Companion companion = PowerSpinnerPersistence.Companion;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            companion.getInstance(context).persistSelectedIndex(str, this.selectedIndex);
        }
    }

    public final void clearSelectedItem() {
        notifyItemSelected(-1, "");
    }

    /* access modifiers changed from: private */
    public final void animateArrow(boolean z) {
        if (this.arrowAnimate) {
            int i = 10000;
            int i2 = z ? 0 : 10000;
            if (!z) {
                i = 0;
            }
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this.arrowDrawable, "level", new int[]{i2, i});
            ofInt.setDuration(this.arrowAnimationDuration);
            ofInt.start();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        dismiss();
    }

    @Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\u0010J\u0010\u0010\u0014\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u0017\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\u0010J\u0010\u0010\u0018\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\u0010J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u001aJ\u0014\u0010\u001b\u001a\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u001fJp\u0010 \u001a\u00020\u0000\"\u0004\b\u0000\u0010!2b\u0010\u001c\u001a^\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u0001H!¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0013\u0012\u0011H!¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001e0\"J\u001a\u0010 \u001a\u00020\u0000\"\u0004\b\u0000\u0010!2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H!0*J \u0010+\u001a\u00020\u00002\u0018\u0010,\u001a\u0014\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u001e0-J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u000200J\u000e\u00101\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u000202J\u000e\u00103\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u00104\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u00105\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u000206J\u0010\u00107\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\u0010J\u0010\u00108\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\u0010J\u0010\u00109\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\u0010J\u0010\u0010:\u001a\u00020\u00002\b\b\u0001\u0010\u000b\u001a\u00020\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006;"}, mo18301d2 = {"Lcom/skydoves/powerspinner/PowerSpinnerView$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "powerSpinnerView", "Lcom/skydoves/powerspinner/PowerSpinnerView;", "getPowerSpinnerView", "()Lcom/skydoves/powerspinner/PowerSpinnerView;", "build", "setArrowAnimate", "value", "", "setArrowAnimationDuration", "", "setArrowDrawableResource", "", "setArrowGravity", "Lcom/skydoves/powerspinner/SpinnerGravity;", "setArrowPadding", "setArrowTint", "setDisableChangeTextWhenNotified", "setDismissWhenNotifiedItemSelected", "setDividerColor", "setDividerSize", "setLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "setOnSpinnerDismissListener", "block", "Lkotlin/Function0;", "", "Lcom/skydoves/powerspinner/OnSpinnerDismissListener;", "setOnSpinnerItemSelectedListener", "T", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "oldIndex", "oldItem", "newIndex", "newItem", "onSpinnerItemSelectedListener", "Lcom/skydoves/powerspinner/OnSpinnerItemSelectedListener;", "setOnSpinnerOutsideTouchListener", "unit", "Lkotlin/Function2;", "Landroid/view/View;", "Landroid/view/MotionEvent;", "Lcom/skydoves/powerspinner/OnSpinnerOutsideTouchListener;", "setPreferenceName", "", "setShowArrow", "setShowDivider", "setSpinnerPopupAnimation", "Lcom/skydoves/powerspinner/SpinnerAnimation;", "setSpinnerPopupAnimationStyle", "setSpinnerPopupBackgroundColor", "setSpinnerPopupHeight", "setSpinnerPopupWidth", "powerspinner_release"}, mo18302k = 1, mo18303mv = {1, 4, 1})
    @PowerSpinnerDsl
    /* compiled from: PowerSpinnerView.kt */
    public static final class Builder {
        private final PowerSpinnerView powerSpinnerView;

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.powerSpinnerView = new PowerSpinnerView(context);
        }

        public final PowerSpinnerView getPowerSpinnerView() {
            return this.powerSpinnerView;
        }

        public final Builder setArrowAnimate(boolean z) {
            Builder builder = this;
            this.powerSpinnerView.setArrowAnimate(z);
            return this;
        }

        public final Builder setArrowAnimationDuration(long j) {
            Builder builder = this;
            this.powerSpinnerView.setArrowAnimationDuration(j);
            return this;
        }

        public final Builder setArrowDrawableResource(int i) {
            Builder builder = this;
            this.powerSpinnerView.setArrowResource(i);
            return this;
        }

        public final Builder setShowArrow(boolean z) {
            Builder builder = this;
            this.powerSpinnerView.setShowArrow(z);
            return this;
        }

        public final Builder setArrowGravity(SpinnerGravity spinnerGravity) {
            Intrinsics.checkNotNullParameter(spinnerGravity, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            Builder builder = this;
            this.powerSpinnerView.setArrowGravity(spinnerGravity);
            return this;
        }

        public final Builder setArrowPadding(int i) {
            Builder builder = this;
            this.powerSpinnerView.setArrowPadding(i);
            return this;
        }

        public final Builder setArrowTint(int i) {
            Builder builder = this;
            this.powerSpinnerView.setArrowTint(i);
            return this;
        }

        public final Builder setShowDivider(boolean z) {
            Builder builder = this;
            this.powerSpinnerView.setShowDivider(z);
            return this;
        }

        public final Builder setDividerSize(int i) {
            Builder builder = this;
            this.powerSpinnerView.setDividerSize(i);
            return this;
        }

        public final Builder setDividerColor(int i) {
            Builder builder = this;
            this.powerSpinnerView.setDividerColor(i);
            return this;
        }

        public final Builder setSpinnerPopupBackgroundColor(int i) {
            Builder builder = this;
            this.powerSpinnerView.setSpinnerPopupBackgroundColor(i);
            return this;
        }

        public final Builder setDismissWhenNotifiedItemSelected(boolean z) {
            Builder builder = this;
            this.powerSpinnerView.setDismissWhenNotifiedItemSelected(z);
            return this;
        }

        public final <T> Builder setOnSpinnerItemSelectedListener(OnSpinnerItemSelectedListener<T> onSpinnerItemSelectedListener) {
            Intrinsics.checkNotNullParameter(onSpinnerItemSelectedListener, "onSpinnerItemSelectedListener");
            Builder builder = this;
            PowerSpinnerInterface access$getAdapter$p = this.powerSpinnerView.adapter;
            Objects.requireNonNull(access$getAdapter$p, "null cannot be cast to non-null type com.skydoves.powerspinner.PowerSpinnerInterface<T>");
            access$getAdapter$p.setOnSpinnerItemSelectedListener(onSpinnerItemSelectedListener);
            return this;
        }

        public final /* synthetic */ <T> Builder setOnSpinnerItemSelectedListener(Function4<? super Integer, ? super T, ? super Integer, ? super T, Unit> function4) {
            Intrinsics.checkNotNullParameter(function4, "block");
            Builder builder = this;
            PowerSpinnerInterface access$getAdapter$p = this.powerSpinnerView.adapter;
            Objects.requireNonNull(access$getAdapter$p, "null cannot be cast to non-null type com.skydoves.powerspinner.PowerSpinnerInterface<T>");
            access$getAdapter$p.setOnSpinnerItemSelectedListener(new C1862xeb280f31(function4));
            return this;
        }

        public final Builder setOnSpinnerOutsideTouchListener(OnSpinnerOutsideTouchListener onSpinnerOutsideTouchListener) {
            Intrinsics.checkNotNullParameter(onSpinnerOutsideTouchListener, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            Builder builder = this;
            this.powerSpinnerView.setSpinnerOutsideTouchListener(onSpinnerOutsideTouchListener);
            return this;
        }

        public final /* synthetic */ Builder setOnSpinnerOutsideTouchListener(Function2<? super View, ? super MotionEvent, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "unit");
            Builder builder = this;
            this.powerSpinnerView.setSpinnerOutsideTouchListener(new C1863x2fbc48fd(function2));
            return this;
        }

        public final Builder setOnSpinnerDismissListener(OnSpinnerDismissListener onSpinnerDismissListener) {
            Intrinsics.checkNotNullParameter(onSpinnerDismissListener, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            Builder builder = this;
            this.powerSpinnerView.setOnSpinnerDismissListener(onSpinnerDismissListener);
            return this;
        }

        public final /* synthetic */ Builder setOnSpinnerDismissListener(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            Builder builder = this;
            this.powerSpinnerView.setOnSpinnerDismissListener((OnSpinnerDismissListener) new C1861x85cb3115(function0));
            return this;
        }

        public final Builder setDisableChangeTextWhenNotified(boolean z) {
            Builder builder = this;
            this.powerSpinnerView.setDisableChangeTextWhenNotified(z);
            return this;
        }

        public final Builder setSpinnerPopupAnimation(SpinnerAnimation spinnerAnimation) {
            Intrinsics.checkNotNullParameter(spinnerAnimation, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            Builder builder = this;
            this.powerSpinnerView.setSpinnerPopupAnimation(spinnerAnimation);
            return this;
        }

        public final Builder setSpinnerPopupAnimationStyle(int i) {
            Builder builder = this;
            this.powerSpinnerView.setSpinnerPopupAnimationStyle(i);
            return this;
        }

        public final Builder setSpinnerPopupWidth(int i) {
            Builder builder = this;
            this.powerSpinnerView.setSpinnerPopupWidth(i);
            return this;
        }

        public final Builder setSpinnerPopupHeight(int i) {
            Builder builder = this;
            this.powerSpinnerView.setSpinnerPopupHeight(i);
            return this;
        }

        public final Builder setPreferenceName(String str) {
            Intrinsics.checkNotNullParameter(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            Builder builder = this;
            this.powerSpinnerView.setPreferenceName(str);
            return this;
        }

        public final Builder setLifecycleOwner(LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            Builder builder = this;
            this.powerSpinnerView.setLifecycleOwner(lifecycleOwner);
            return this;
        }

        public final PowerSpinnerView build() {
            return this.powerSpinnerView;
        }
    }
}
