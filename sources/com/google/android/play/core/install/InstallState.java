package com.google.android.play.core.install;

public abstract class InstallState {
    /* renamed from: a */
    public static InstallState m664a(int i, long j, long j2, int i2, String str) {
        return new C1664a(i, j, j2, i2, str);
    }

    public abstract long bytesDownloaded();

    public abstract int installErrorCode();

    public abstract int installStatus();

    public abstract String packageName();

    public abstract long totalBytesToDownload();
}
