package com.google.android.play.core.install;

import com.google.android.play.core.install.model.C1665a;
import com.google.android.play.core.tasks.C1787j;

public class InstallException extends C1787j {

    /* renamed from: a */
    private final int f835a;

    public InstallException(int i) {
        super(String.format("Install Error(%d): %s", new Object[]{Integer.valueOf(i), C1665a.m665a(i)}));
        if (i != 0) {
            this.f835a = i;
            return;
        }
        throw new IllegalArgumentException("errorCode should not be 0.");
    }

    public int getErrorCode() {
        return this.f835a;
    }
}
