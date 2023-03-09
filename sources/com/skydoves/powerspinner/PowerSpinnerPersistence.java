package com.skydoves.powerspinner;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\r"}, mo18301d2 = {"Lcom/skydoves/powerspinner/PowerSpinnerPersistence;", "", "()V", "clearAllPersistedData", "", "getSelectedIndex", "", "name", "", "persistSelectedIndex", "index", "removePersistedData", "Companion", "powerspinner_release"}, mo18302k = 1, mo18303mv = {1, 4, 1})
/* compiled from: PowerSpinnerPersistence.kt */
public final class PowerSpinnerPersistence {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String INDEX = "INDEX";
    /* access modifiers changed from: private */
    public static volatile PowerSpinnerPersistence instance;
    /* access modifiers changed from: private */
    public static SharedPreferences sharedPreferenceManager;

    @JvmStatic
    public static final PowerSpinnerPersistence getInstance(Context context) {
        return Companion.getInstance(context);
    }

    private PowerSpinnerPersistence() {
    }

    public /* synthetic */ PowerSpinnerPersistence(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final int getSelectedIndex(String str) {
        Intrinsics.checkNotNullParameter(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        SharedPreferences sharedPreferences = sharedPreferenceManager;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferenceManager");
        }
        return sharedPreferences.getInt(INDEX + str, -1);
    }

    public final void persistSelectedIndex(String str, int i) {
        Intrinsics.checkNotNullParameter(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        SharedPreferences sharedPreferences = sharedPreferenceManager;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferenceManager");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(INDEX + str, i).apply();
    }

    public final void removePersistedData(String str) {
        Intrinsics.checkNotNullParameter(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        SharedPreferences sharedPreferences = sharedPreferenceManager;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferenceManager");
        }
        sharedPreferences.edit().remove(str).apply();
    }

    public final void clearAllPersistedData() {
        SharedPreferences sharedPreferences = sharedPreferenceManager;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferenceManager");
        }
        sharedPreferences.edit().clear().apply();
    }

    @Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\f"}, mo18301d2 = {"Lcom/skydoves/powerspinner/PowerSpinnerPersistence$Companion;", "", "()V", "INDEX", "", "instance", "Lcom/skydoves/powerspinner/PowerSpinnerPersistence;", "sharedPreferenceManager", "Landroid/content/SharedPreferences;", "getInstance", "context", "Landroid/content/Context;", "powerspinner_release"}, mo18302k = 1, mo18303mv = {1, 4, 1})
    /* compiled from: PowerSpinnerPersistence.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final PowerSpinnerPersistence getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            PowerSpinnerPersistence access$getInstance$cp = PowerSpinnerPersistence.instance;
            if (access$getInstance$cp == null) {
                synchronized (this) {
                    access$getInstance$cp = PowerSpinnerPersistence.instance;
                    if (access$getInstance$cp == null) {
                        access$getInstance$cp = new PowerSpinnerPersistence((DefaultConstructorMarker) null);
                        PowerSpinnerPersistence.instance = access$getInstance$cp;
                        SharedPreferences sharedPreferences = context.getSharedPreferences("com.skydoves.powerspinenr", 0);
                        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…r\", Context.MODE_PRIVATE)");
                        PowerSpinnerPersistence.sharedPreferenceManager = sharedPreferences;
                    }
                }
            }
            return access$getInstance$cp;
        }
    }
}
