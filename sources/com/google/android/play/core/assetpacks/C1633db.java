package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C0971bz;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.google.android.play.core.assetpacks.db */
final class C1633db {

    /* renamed from: a */
    private static final Pattern f752a = Pattern.compile("[0-9]+-(NAM|LFH)\\.dat");

    /* renamed from: a */
    static List<File> m600a(File file, File file2) throws IOException {
        File[] fileArr;
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file2.listFiles(C1632da.f751a);
        if (listFiles == null) {
            fileArr = new File[0];
        } else {
            File[] fileArr2 = new File[r2];
            for (File file3 : listFiles) {
                int parseInt = Integer.parseInt(file3.getName().split("-")[0]);
                if (parseInt > listFiles.length || fileArr2[parseInt] != null) {
                    throw new C1588bk("Metadata folder ordering corrupt.");
                }
                fileArr2[parseInt] = file3;
            }
            fileArr = fileArr2;
        }
        for (File file4 : fileArr) {
            arrayList.add(file4);
            if (file4.getName().contains("LFH")) {
                FileInputStream fileInputStream = new FileInputStream(file4);
                try {
                    C1636de a = new C1581bd(fileInputStream).mo30758a();
                    if (a.mo30846d() != null) {
                        File file5 = new File(file, a.mo30846d());
                        if (file5.exists()) {
                            arrayList.add(file5);
                            fileInputStream.close();
                        } else {
                            throw new C1588bk(String.format("Missing asset file %s during slice reconstruction.", new Object[]{file5.getCanonicalPath()}));
                        }
                    } else {
                        throw new C1588bk("Metadata files corrupt. Could not read local file header.");
                    }
                } catch (Throwable th) {
                    C0971bz.m125a(th, th);
                }
            }
        }
        return arrayList;
        throw th;
    }
}
