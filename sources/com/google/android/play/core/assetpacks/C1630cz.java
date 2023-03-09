package com.google.android.play.core.assetpacks;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.play.core.internal.C0944ag;
import com.google.android.play.core.internal.C0971bz;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Properties;

/* renamed from: com.google.android.play.core.assetpacks.cz */
final class C1630cz {

    /* renamed from: a */
    private static final C0944ag f740a = new C0944ag("SliceMetadataManager");

    /* renamed from: b */
    private final byte[] f741b = new byte[8192];

    /* renamed from: c */
    private final C1571au f742c;

    /* renamed from: d */
    private final String f743d;

    /* renamed from: e */
    private final int f744e;

    /* renamed from: f */
    private final long f745f;

    /* renamed from: g */
    private final String f746g;

    /* renamed from: h */
    private int f747h;

    C1630cz(C1571au auVar, String str, int i, long j, String str2) {
        this.f742c = auVar;
        this.f743d = str;
        this.f744e = i;
        this.f745f = j;
        this.f746g = str2;
        this.f747h = -1;
    }

    /* renamed from: n */
    private final File m585n() {
        File o = this.f742c.mo30727o(this.f743d, this.f744e, this.f745f, this.f746g);
        if (!o.exists()) {
            o.mkdirs();
        }
        return o;
    }

    /* renamed from: o */
    private final File m586o() throws IOException {
        File m = this.f742c.mo30725m(this.f743d, this.f744e, this.f745f, this.f746g);
        m.getParentFile().mkdirs();
        m.createNewFile();
        return m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo30828a(String str, long j, long j2, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "1");
        properties.put("fileName", str);
        properties.put("fileOffset", String.valueOf(j));
        properties.put("remainingBytes", String.valueOf(j2));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f747h));
        FileOutputStream fileOutputStream = new FileOutputStream(m586o());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C0971bz.m125a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo30829b(byte[] bArr, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", ExifInterface.GPS_MEASUREMENT_2D);
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f747h));
        FileOutputStream fileOutputStream = new FileOutputStream(m586o());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            File n = this.f742c.mo30726n(this.f743d, this.f744e, this.f745f, this.f746g);
            if (n.exists()) {
                n.delete();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(n);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.close();
                return;
            } catch (Throwable th) {
                C0971bz.m125a(th, th);
            }
            throw th;
            throw th;
        } catch (Throwable th2) {
            C0971bz.m125a(th, th2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo30830c(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", ExifInterface.GPS_MEASUREMENT_3D);
        properties.put("fileOffset", String.valueOf(mo30837j().length()));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f747h));
        FileOutputStream fileOutputStream = new FileOutputStream(m586o());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C0971bz.m125a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo30831d(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "4");
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f747h));
        FileOutputStream fileOutputStream = new FileOutputStream(m586o());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C0971bz.m125a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final C1629cy mo30832e() throws IOException {
        File m = this.f742c.mo30725m(this.f743d, this.f744e, this.f745f, this.f746g);
        if (m.exists()) {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(m);
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
                if (properties.getProperty("fileStatus") == null || properties.getProperty("previousChunk") == null) {
                    throw new C1588bk("Slice checkpoint file corrupt.");
                }
                try {
                    int parseInt = Integer.parseInt(properties.getProperty("fileStatus"));
                    String property = properties.getProperty("fileName");
                    long parseLong = Long.parseLong(properties.getProperty("fileOffset", "-1"));
                    long parseLong2 = Long.parseLong(properties.getProperty("remainingBytes", "-1"));
                    int parseInt2 = Integer.parseInt(properties.getProperty("previousChunk"));
                    this.f747h = Integer.parseInt(properties.getProperty("metadataFileCounter", "0"));
                    return new C1629cy(parseInt, property, parseLong, parseLong2, parseInt2);
                } catch (NumberFormatException e) {
                    throw new C1588bk("Slice checkpoint file corrupt.", (Exception) e);
                }
            } catch (Throwable th) {
                C0971bz.m125a(th, th);
            }
        } else {
            throw new C1588bk("Slice checkpoint file does not exist.");
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final void mo30833f(InputStream inputStream, long j) throws IOException {
        int read;
        RandomAccessFile randomAccessFile = new RandomAccessFile(mo30837j(), "rw");
        try {
            randomAccessFile.seek(j);
            do {
                read = inputStream.read(this.f741b);
                if (read > 0) {
                    randomAccessFile.write(this.f741b, 0, read);
                }
            } while (read == 8192);
            randomAccessFile.close();
            return;
        } catch (Throwable th) {
            C0971bz.m125a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final void mo30834g(byte[] bArr) throws IOException {
        FileOutputStream fileOutputStream;
        this.f747h++;
        try {
            fileOutputStream = new FileOutputStream(new File(m585n(), String.format("%s-LFH.dat", new Object[]{Integer.valueOf(this.f747h)})));
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return;
        } catch (IOException e) {
            throw new C1588bk("Could not write metadata file.", (Exception) e);
        } catch (Throwable th) {
            C0971bz.m125a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final void mo30835h(byte[] bArr, InputStream inputStream) throws IOException {
        this.f747h++;
        FileOutputStream fileOutputStream = new FileOutputStream(mo30837j());
        try {
            fileOutputStream.write(bArr);
            int read = inputStream.read(this.f741b);
            while (read > 0) {
                fileOutputStream.write(this.f741b, 0, read);
                read = inputStream.read(this.f741b);
            }
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C0971bz.m125a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final void mo30836i(long j, byte[] bArr, int i, int i2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(mo30837j(), "rw");
        try {
            randomAccessFile.seek(j);
            randomAccessFile.write(bArr, i, i2);
            randomAccessFile.close();
            return;
        } catch (Throwable th) {
            C0971bz.m125a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final File mo30837j() {
        return new File(m585n(), String.format("%s-NAM.dat", new Object[]{Integer.valueOf(this.f747h)}));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public final int mo30838k() throws IOException {
        File m = this.f742c.mo30725m(this.f743d, this.f744e, this.f745f, this.f746g);
        if (!m.exists()) {
            return 0;
        }
        FileInputStream fileInputStream = new FileInputStream(m);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            if (Integer.parseInt(properties.getProperty("fileStatus", "-1")) == 4) {
                return -1;
            }
            if (properties.getProperty("previousChunk") != null) {
                return Integer.parseInt(properties.getProperty("previousChunk")) + 1;
            }
            throw new C1588bk("Slice checkpoint file corrupt.");
        } catch (Throwable th) {
            C0971bz.m125a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final boolean mo30839l() {
        FileInputStream fileInputStream;
        File m = this.f742c.mo30725m(this.f743d, this.f744e, this.f745f, this.f746g);
        if (!m.exists()) {
            return false;
        }
        try {
            fileInputStream = new FileInputStream(m);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("fileStatus") != null) {
                return Integer.parseInt(properties.getProperty("fileStatus")) == 4;
            }
            f740a.mo17055b("Slice checkpoint file corrupt while checking if extraction finished.", new Object[0]);
            return false;
        } catch (IOException e) {
            f740a.mo17055b("Could not read checkpoint while checking if extraction finished. %s", e);
            return false;
        } catch (Throwable th) {
            C0971bz.m125a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public final void mo30840m(byte[] bArr, int i) throws IOException {
        this.f747h++;
        FileOutputStream fileOutputStream = new FileOutputStream(mo30837j());
        try {
            fileOutputStream.write(bArr, 0, i);
            fileOutputStream.close();
            return;
        } catch (Throwable th) {
            C0971bz.m125a(th, th);
        }
        throw th;
    }
}
