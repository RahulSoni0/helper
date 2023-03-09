package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C0944ag;
import java.io.File;
import java.io.IOException;

/* renamed from: com.google.android.play.core.assetpacks.co */
final class C1619co {

    /* renamed from: a */
    private static final C0944ag f699a = new C0944ag("MergeSliceTaskHandler");

    /* renamed from: b */
    private final C1571au f700b;

    C1619co(C1571au auVar) {
        this.f700b = auVar;
    }

    /* renamed from: b */
    private static void m571b(File file, File file2) {
        if (file.isDirectory()) {
            file2.mkdirs();
            for (File file3 : file.listFiles()) {
                m571b(file3, new File(file2, file3.getName()));
            }
            if (!file.delete()) {
                String valueOf = String.valueOf(file);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
                sb.append("Unable to delete directory: ");
                sb.append(valueOf);
                throw new C1588bk(sb.toString());
            }
        } else if (file2.exists()) {
            String valueOf2 = String.valueOf(file2);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 51);
            sb2.append("File clashing with existing file from other slice: ");
            sb2.append(valueOf2);
            throw new C1588bk(sb2.toString());
        } else if (!file.renameTo(file2)) {
            String valueOf3 = String.valueOf(file);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 21);
            sb3.append("Unable to move file: ");
            sb3.append(valueOf3);
            throw new C1588bk(sb3.toString());
        }
    }

    /* renamed from: a */
    public final void mo30813a(C1618cn cnVar) {
        File i = this.f700b.mo30721i(cnVar.f655k, cnVar.f696a, cnVar.f697b, cnVar.f698c);
        if (i.exists()) {
            File j = this.f700b.mo30722j(cnVar.f655k, cnVar.f696a, cnVar.f697b);
            if (!j.exists()) {
                j.mkdirs();
            }
            m571b(i, j);
            try {
                this.f700b.mo30724l(cnVar.f655k, cnVar.f696a, cnVar.f697b, this.f700b.mo30723k(cnVar.f655k, cnVar.f696a, cnVar.f697b) + 1);
            } catch (IOException e) {
                f699a.mo17055b("Writing merge checkpoint failed with %s.", e.getMessage());
                throw new C1588bk("Writing merge checkpoint failed.", e, cnVar.f654j);
            }
        } else {
            throw new C1588bk(String.format("Cannot find verified files for slice %s.", new Object[]{cnVar.f698c}), cnVar.f654j);
        }
    }
}
