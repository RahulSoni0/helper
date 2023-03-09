package com.google.android.play.core.internal;

import android.os.Build;
import java.io.File;

/* renamed from: com.google.android.play.core.internal.ax */
public final class C0950ax {
    /* renamed from: a */
    public static C0949aw m68a() {
        if (Build.VERSION.SDK_INT >= 21) {
            switch (Build.VERSION.SDK_INT) {
                case 21:
                    return new C0953ba((byte[]) null);
                case 22:
                    return new C0953ba();
                case 23:
                    return new C0953ba((char[]) null);
                case 24:
                    return new C0953ba((short[]) null);
                case 25:
                    return new C0953ba((int[]) null);
                case 26:
                    return new C0953ba((boolean[]) null);
                case 27:
                    if (Build.VERSION.PREVIEW_SDK_INT == 0) {
                        return new C0953ba((float[]) null);
                    }
                    break;
            }
            return new C0953ba((byte[][]) null);
        }
        throw new AssertionError("Unsupported Android Version");
    }

    /* renamed from: b */
    public static String m69b(File file) {
        if (file.getName().endsWith(".apk")) {
            String str = "";
            String replaceFirst = file.getName().replaceFirst("(_\\d+)?\\.apk", str);
            if (replaceFirst.equals("base-master")) {
                return str;
            }
            String str2 = "base-";
            if (replaceFirst.startsWith(str2)) {
                str = "config.";
            } else {
                replaceFirst = replaceFirst.replace("-", ".config.");
                str2 = ".config.master";
            }
            return replaceFirst.replace(str2, str);
        }
        throw new IllegalArgumentException("Non-apk found in splits directory.");
    }

    /* renamed from: c */
    public static void m70c(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    /* renamed from: d */
    public static <T> void m71d(T t, Object obj) {
        if (t == null) {
            throw new NullPointerException((String) obj);
        }
    }
}
