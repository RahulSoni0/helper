package kotlinx.coroutines.internal;

import androidx.core.app.NotificationCompat;
import java.io.BufferedReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000bH\u0002¢\u0006\u0002\u0010\fJ/\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000e\"\u0004\b\u0000\u0010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\u000fJ/\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000e\"\u0004\b\u0000\u0010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0011J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J,\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0019*\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u0002H\u00190\u001cH\b¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo18301d2 = {"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "()V", "PREFIX", "", "getProviderInstance", "S", "name", "loader", "Ljava/lang/ClassLoader;", "service", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "load", "", "load$kotlinx_coroutines_core", "loadProviders", "loadProviders$kotlinx_coroutines_core", "parse", "url", "Ljava/net/URL;", "parseFile", "r", "Ljava/io/BufferedReader;", "use", "R", "Ljava/util/jar/JarFile;", "block", "Lkotlin/Function1;", "(Ljava/util/jar/JarFile;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
/* compiled from: FastServiceLoader.kt */
public final class FastServiceLoader {
    public static final FastServiceLoader INSTANCE = new FastServiceLoader();
    private static final String PREFIX = "META-INF/services/";

    private FastServiceLoader() {
    }

    public final <S> List<S> load$kotlinx_coroutines_core(Class<S> cls, ClassLoader classLoader) {
        Intrinsics.checkParameterIsNotNull(cls, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkParameterIsNotNull(classLoader, "loader");
        try {
            return loadProviders$kotlinx_coroutines_core(cls, classLoader);
        } catch (Throwable unused) {
            ServiceLoader<S> load = ServiceLoader.load(cls, classLoader);
            Intrinsics.checkExpressionValueIsNotNull(load, "ServiceLoader.load(service, loader)");
            return CollectionsKt.toList(load);
        }
    }

    public final <S> List<S> loadProviders$kotlinx_coroutines_core(Class<S> cls, ClassLoader classLoader) {
        Intrinsics.checkParameterIsNotNull(cls, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkParameterIsNotNull(classLoader, "loader");
        Enumeration<URL> resources = classLoader.getResources(PREFIX + cls.getName());
        Intrinsics.checkExpressionValueIsNotNull(resources, "urls");
        ArrayList<T> list = Collections.list(resources);
        Intrinsics.checkExpressionValueIsNotNull(list, "java.util.Collections.list(this)");
        Collection arrayList = new ArrayList();
        for (T t : list) {
            FastServiceLoader fastServiceLoader = INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(t, "it");
            CollectionsKt.addAll(arrayList, fastServiceLoader.parse(t));
        }
        Set set = CollectionsKt.toSet((List) arrayList);
        if (!set.isEmpty()) {
            Iterable<String> iterable = set;
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (String providerInstance : iterable) {
                arrayList2.add(INSTANCE.getProviderInstance(providerInstance, classLoader, cls));
            }
            return (List) arrayList2;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }

    private final <S> S getProviderInstance(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        kotlin.p010io.CloseableKt.closeFinally(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0062, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0065, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0069, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006b, code lost:
        kotlin.ExceptionsKt.addSuppressed(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006e, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0093, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0094, code lost:
        kotlin.p010io.CloseableKt.closeFinally(r0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0097, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<java.lang.String> parse(java.net.URL r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.toString()
            java.lang.String r1 = "url.toString()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.String r1 = "jar"
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r0, r1, r2, r3, r4)
            if (r1 == 0) goto L_0x006f
            java.lang.String r6 = "jar:file:"
            java.lang.String r6 = kotlin.text.StringsKt.substringAfter$default((java.lang.String) r0, (java.lang.String) r6, (java.lang.String) r4, (int) r3, (java.lang.Object) r4)
            r1 = 33
            java.lang.String r6 = kotlin.text.StringsKt.substringBefore$default((java.lang.String) r6, (char) r1, (java.lang.String) r4, (int) r3, (java.lang.Object) r4)
            java.lang.String r1 = "!/"
            java.lang.String r0 = kotlin.text.StringsKt.substringAfter$default((java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r4, (int) r3, (java.lang.Object) r4)
            java.util.jar.JarFile r1 = new java.util.jar.JarFile
            r1.<init>(r6, r2)
            r6 = r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ all -> 0x0063 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0063 }
            java.util.zip.ZipEntry r3 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x0063 }
            r3.<init>(r0)     // Catch:{ all -> 0x0063 }
            java.io.InputStream r0 = r1.getInputStream(r3)     // Catch:{ all -> 0x0063 }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r0, r3)     // Catch:{ all -> 0x0063 }
            java.io.Reader r2 = (java.io.Reader) r2     // Catch:{ all -> 0x0063 }
            r6.<init>(r2)     // Catch:{ all -> 0x0063 }
            java.io.Closeable r6 = (java.io.Closeable) r6     // Catch:{ all -> 0x0063 }
            r0 = r4
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x0063 }
            r0 = r6
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0     // Catch:{ all -> 0x005c }
            kotlinx.coroutines.internal.FastServiceLoader r2 = INSTANCE     // Catch:{ all -> 0x005c }
            java.util.List r0 = r2.parseFile(r0)     // Catch:{ all -> 0x005c }
            kotlin.p010io.CloseableKt.closeFinally(r6, r4)     // Catch:{ all -> 0x0063 }
            r1.close()     // Catch:{ all -> 0x005a }
            return r0
        L_0x005a:
            r6 = move-exception
            throw r6
        L_0x005c:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x005e }
        L_0x005e:
            r2 = move-exception
            kotlin.p010io.CloseableKt.closeFinally(r6, r0)     // Catch:{ all -> 0x0063 }
            throw r2     // Catch:{ all -> 0x0063 }
        L_0x0063:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r0 = move-exception
            r1.close()     // Catch:{ all -> 0x006a }
            throw r0
        L_0x006a:
            r0 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r6, r0)
            throw r6
        L_0x006f:
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            java.io.InputStream r6 = r6.openStream()
            r1.<init>(r6)
            java.io.Reader r1 = (java.io.Reader) r1
            r0.<init>(r1)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r6 = r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r6 = r0
            java.io.BufferedReader r6 = (java.io.BufferedReader) r6     // Catch:{ all -> 0x0091 }
            kotlinx.coroutines.internal.FastServiceLoader r1 = INSTANCE     // Catch:{ all -> 0x0091 }
            java.util.List r6 = r1.parseFile(r6)     // Catch:{ all -> 0x0091 }
            kotlin.p010io.CloseableKt.closeFinally(r0, r4)
            return r6
        L_0x0091:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0093 }
        L_0x0093:
            r1 = move-exception
            kotlin.p010io.CloseableKt.closeFinally(r0, r6)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.FastServiceLoader.parse(java.net.URL):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0017, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001d, code lost:
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0020, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0021, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0022, code lost:
        kotlin.ExceptionsKt.addSuppressed(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0025, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <R> R use(java.util.jar.JarFile r3, kotlin.jvm.functions.Function1<? super java.util.jar.JarFile, ? extends R> r4) {
        /*
            r2 = this;
            r0 = 0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r0 = 1
            java.lang.Object r4 = r4.invoke(r3)     // Catch:{ all -> 0x0014 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            r3.close()     // Catch:{ all -> 0x0012 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            return r4
        L_0x0012:
            r3 = move-exception
            throw r3
        L_0x0014:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0016 }
        L_0x0016:
            r1 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            r3.close()     // Catch:{ all -> 0x0021 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            throw r1
        L_0x0021:
            r3 = move-exception
            kotlin.ExceptionsKt.addSuppressed(r4, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.FastServiceLoader.use(java.util.jar.JarFile, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    private final List<String> parseFile(BufferedReader bufferedReader) {
        boolean z;
        Set linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return CollectionsKt.toList(linkedHashSet);
            }
            String substringBefore$default = StringsKt.substringBefore$default(readLine, "#", (String) null, 2, (Object) null);
            if (substringBefore$default != null) {
                String obj = StringsKt.trim((CharSequence) substringBefore$default).toString();
                CharSequence charSequence = obj;
                boolean z2 = false;
                int i = 0;
                while (true) {
                    if (i >= charSequence.length()) {
                        z = true;
                        break;
                    }
                    char charAt = charSequence.charAt(i);
                    if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                        z = false;
                        break;
                    }
                    i++;
                }
                if (z) {
                    if (charSequence.length() > 0) {
                        z2 = true;
                    }
                    if (z2) {
                        linkedHashSet.add(obj);
                    }
                } else {
                    throw new IllegalArgumentException(("Illegal service provider class name: " + obj).toString());
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
    }
}
