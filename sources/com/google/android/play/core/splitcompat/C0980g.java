package com.google.android.play.core.splitcompat;

import android.util.Log;
import com.google.android.play.core.internal.C0971bz;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.google.android.play.core.splitcompat.g */
final class C0980g implements C0982i {

    /* renamed from: a */
    final /* synthetic */ Set f182a;

    /* renamed from: b */
    final /* synthetic */ C0990q f183b;

    /* renamed from: c */
    final /* synthetic */ ZipFile f184c;

    C0980g(Set set, C0990q qVar, ZipFile zipFile) {
        this.f182a = set;
        this.f183b = qVar;
        this.f184c = zipFile;
    }

    /* renamed from: a */
    public final void mo17113a(C0983j jVar, File file, boolean z) throws IOException {
        FileOutputStream fileOutputStream;
        this.f182a.add(file);
        if (!z) {
            Log.i("SplitCompat", String.format("NativeLibraryExtractor: split '%s' has native library '%s' that does not exist; extracting from '%s!%s' to '%s'", new Object[]{this.f183b.mo17122b(), jVar.f185a, this.f183b.mo17121a().getAbsolutePath(), jVar.f186b.getName(), file.getAbsolutePath()}));
            ZipFile zipFile = this.f184c;
            ZipEntry zipEntry = jVar.f186b;
            int i = C0984k.f187a;
            byte[] bArr = new byte[4096];
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            try {
                fileOutputStream = new FileOutputStream(file);
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                    return;
                }
                return;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th2) {
                        C0971bz.m125a(th, th2);
                    }
                }
                throw th;
            }
        } else {
            return;
        }
        throw th;
    }
}
