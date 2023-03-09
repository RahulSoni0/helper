package com.google.android.play.core.splitinstall;

import com.google.android.play.core.splitinstall.model.C1759a;
import com.google.android.play.core.tasks.C1787j;

public class SplitInstallException extends C1787j {

    /* renamed from: a */
    private final int f908a;

    public SplitInstallException(int i) {
        super(String.format("Split Install Error(%d): %s", new Object[]{Integer.valueOf(i), C1759a.m898a(i)}));
        if (i != 0) {
            this.f908a = i;
            return;
        }
        throw new IllegalArgumentException("errorCode should not be 0.");
    }

    public int getErrorCode() {
        return this.f908a;
    }
}
