package com.google.android.play.core.splitinstall.testing;

import android.content.Context;
import com.google.android.play.core.common.LocalTestingException;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitinstall.C0997k;
import com.google.android.play.core.splitinstall.C1002p;
import java.io.File;

public class FakeSplitInstallManagerFactory {

    /* renamed from: a */
    private static FakeSplitInstallManager f1004a;

    public static FakeSplitInstallManager create(Context context) {
        try {
            File b = C0997k.m217a(context).mo17137b();
            if (b == null) {
                throw new LocalTestingException("Failed to retrieve local testing directory path");
            } else if (b.exists()) {
                return create(context, b);
            } else {
                throw new LocalTestingException(String.format("Local testing directory not found: %s", new Object[]{b}));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized FakeSplitInstallManager create(Context context, File file) {
        FakeSplitInstallManager fakeSplitInstallManager;
        synchronized (FakeSplitInstallManagerFactory.class) {
            FakeSplitInstallManager fakeSplitInstallManager2 = f1004a;
            if (fakeSplitInstallManager2 == null) {
                f1004a = createNewInstance(context, file);
            } else if (!fakeSplitInstallManager2.mo31032c().getAbsolutePath().equals(file.getAbsolutePath())) {
                throw new RuntimeException(String.format("Different module directories used to initialize FakeSplitInstallManager: '%s' and '%s'", new Object[]{f1004a.mo31032c().getAbsolutePath(), file.getAbsolutePath()}));
            }
            fakeSplitInstallManager = f1004a;
        }
        return fakeSplitInstallManager;
    }

    public static FakeSplitInstallManager createNewInstance(Context context, File file) {
        SplitCompat.install(context);
        return new FakeSplitInstallManager(context, file, new C1002p(context, context.getPackageName()));
    }
}
