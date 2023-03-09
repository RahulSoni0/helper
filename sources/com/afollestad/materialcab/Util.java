package com.afollestad.materialcab;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;

public class Util {
    public static int resolveDimension(Context context, int i, int i2) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            return obtainStyledAttributes.getDimensionPixelSize(0, (int) context.getResources().getDimension(i2));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int resolveColor(Context context, int i, int i2) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            return obtainStyledAttributes.getColor(0, i2);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int resolveInt(Context context, int i, int i2) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            return obtainStyledAttributes.getInt(0, i2);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static String resolveString(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return (String) typedValue.string;
    }

    public static int resolveResId(Context context, int i, int i2) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        try {
            return obtainStyledAttributes.getResourceId(0, i2);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
