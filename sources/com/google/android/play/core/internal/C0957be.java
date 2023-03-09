package com.google.android.play.core.internal;

import android.util.Log;
import java.io.File;

/* renamed from: com.google.android.play.core.internal.be */
final class C0957be implements C0951ay {

    /* renamed from: a */
    private final /* synthetic */ int f147a = 0;

    C0957be() {
    }

    C0957be(byte[] bArr) {
    }

    C0957be(char[] cArr) {
    }

    /* renamed from: a */
    public final boolean mo17068a(Object obj, File file, File file2) {
        int i = this.f147a;
        if (i == 0) {
            try {
                return !((Boolean) C0960bh.m102f(Class.forName("dalvik.system.DexFile"), Boolean.class, String.class, file.getPath())).booleanValue();
            } catch (ClassNotFoundException unused) {
                Log.e("SplitCompat", "Unexpected missing dalvik.system.DexFile.");
                return false;
            }
        } else if (i != 1) {
            return true;
        } else {
            return new File((String) C0960bh.m103g(obj.getClass(), String.class, File.class, file, File.class, file2)).exists();
        }
    }
}
