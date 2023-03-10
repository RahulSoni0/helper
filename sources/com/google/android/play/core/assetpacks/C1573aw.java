package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C0963br;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* renamed from: com.google.android.play.core.assetpacks.aw */
final class C1573aw extends C0963br {

    /* renamed from: a */
    private final File f507a;

    /* renamed from: b */
    private final File f508b;

    /* renamed from: c */
    private final NavigableMap<Long, File> f509c = new TreeMap();

    C1573aw(File file, File file2) throws IOException {
        this.f507a = file;
        this.f508b = file2;
        List<File> a = C1633db.m600a(file, file2);
        if (!a.isEmpty()) {
            long j = 0;
            for (File next : a) {
                this.f509c.put(Long.valueOf(j), next);
                j += next.length();
            }
            return;
        }
        throw new C1588bk(String.format("Virtualized slice archive empty for %s, %s", new Object[]{file, file2}));
    }

    /* renamed from: d */
    private final InputStream m471d(long j, Long l) throws IOException {
        FileInputStream fileInputStream = new FileInputStream((File) this.f509c.get(l));
        if (fileInputStream.skip(j - l.longValue()) == j - l.longValue()) {
            return fileInputStream;
        }
        throw new C1588bk(String.format("Virtualized slice archive corrupt, could not skip in file with key %s", new Object[]{l}));
    }

    /* renamed from: a */
    public final long mo17076a() {
        Map.Entry<Long, File> lastEntry = this.f509c.lastEntry();
        return lastEntry.getKey().longValue() + lastEntry.getValue().length();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final InputStream mo17077b(long j, long j2) throws IOException {
        if (j < 0 || j2 < 0) {
            throw new C1588bk(String.format("Invalid input parameters %s, %s", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        }
        long j3 = j + j2;
        if (j3 <= mo17076a()) {
            Long floorKey = this.f509c.floorKey(Long.valueOf(j));
            Long floorKey2 = this.f509c.floorKey(Long.valueOf(j3));
            if (floorKey.equals(floorKey2)) {
                return new C1572av(m471d(j, floorKey), j2);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(m471d(j, floorKey));
            Collection values = this.f509c.subMap(floorKey, false, floorKey2, false).values();
            if (!values.isEmpty()) {
                arrayList.add(new C1616cl(Collections.enumeration(values)));
            }
            arrayList.add(new C1572av(new FileInputStream((File) this.f509c.get(floorKey2)), j2 - (floorKey2.longValue() - j)));
            return new SequenceInputStream(Collections.enumeration(arrayList));
        }
        throw new C1588bk(String.format("Trying to access archive out of bounds. Archive ends at: %s. Tried accessing: %s", new Object[]{Long.valueOf(mo17076a()), Long.valueOf(j3)}));
    }

    public final void close() {
    }
}
