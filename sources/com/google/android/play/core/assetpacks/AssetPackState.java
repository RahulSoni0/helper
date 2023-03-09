package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.google.android.play.core.internal.C0972i;

public abstract class AssetPackState {
    /* renamed from: c */
    public static AssetPackState m354c(String str, int i, int i2, long j, long j2, double d, int i3, String str2) {
        return new C1576az(str, i, i2, j, j2, (int) Math.rint(100.0d * d), i3, str2);
    }

    /* renamed from: d */
    static AssetPackState m355d(Bundle bundle, String str, C1592bo boVar, C1569as asVar) {
        Bundle bundle2 = bundle;
        String str2 = str;
        int a = asVar.mo30709a(bundle2.getInt(C0972i.m130e(NotificationCompat.CATEGORY_STATUS, str2)), str2);
        int i = bundle2.getInt(C0972i.m130e("error_code", str2));
        long j = bundle2.getLong(C0972i.m130e("bytes_downloaded", str2));
        long j2 = bundle2.getLong(C0972i.m130e("total_bytes_to_download", str2));
        double b = boVar.mo30775b(str2);
        long j3 = bundle2.getLong(C0972i.m130e("pack_version", str2));
        long j4 = bundle2.getLong(C0972i.m130e("pack_base_version", str2));
        int i2 = 1;
        if (!(a != 4 || j4 == 0 || j4 == j3)) {
            i2 = 2;
        }
        return m354c(str, a, i, j, j2, b, i2, bundle2.getString(C0972i.m130e("pack_version_tag", str2), ""));
    }

    /* renamed from: a */
    public abstract int mo30662a();

    /* renamed from: b */
    public abstract String mo30663b();

    public abstract long bytesDownloaded();

    public abstract int errorCode();

    public abstract String name();

    public abstract int status();

    public abstract long totalBytesToDownload();

    public abstract int transferProgressPercentage();
}
