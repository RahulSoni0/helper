package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002\u001a1\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006j\u0002`\u00072\u0014\b\u0004\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0006H\b\u001a!\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00052\u0006\u0010\u0011\u001a\u0002H\u0010H\u0000¢\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00042\b\b\u0002\u0010\u0014\u001a\u00020\tH\u0010\u001a\u0018\u0010\u0015\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0016\u001a\u00020\tH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"4\u0010\u0002\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006j\u0002`\u00070\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000*(\b\u0002\u0010\u0017\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00062\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006¨\u0006\u0018"}, mo18301d2 = {"cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionCtors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "throwableFields", "", "createConstructor", "constructor", "Ljava/lang/reflect/Constructor;", "safeCtor", "block", "tryCopyException", "E", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"}, mo18302k = 2, mo18303mv = {1, 1, 15})
/* compiled from: ExceptionsConstuctor.kt */
public final class ExceptionsConstuctorKt {
    private static final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
    private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> exceptionCtors = new WeakHashMap<>();
    private static final int throwableFields = fieldsCountOrDefault(Throwable.class, -1);

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static final <E extends java.lang.Throwable> E tryCopyException(E r9) {
        /*
            java.lang.String r0 = "exception"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            boolean r0 = r9 instanceof kotlinx.coroutines.CopyableThrowable
            r1 = 0
            if (r0 == 0) goto L_0x002d
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0017 }
            kotlinx.coroutines.CopyableThrowable r9 = (kotlinx.coroutines.CopyableThrowable) r9     // Catch:{ all -> 0x0017 }
            java.lang.Throwable r9 = r9.createCopy()     // Catch:{ all -> 0x0017 }
            java.lang.Object r9 = kotlin.Result.m1941constructorimpl(r9)     // Catch:{ all -> 0x0017 }
            goto L_0x0022
        L_0x0017:
            r9 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m1941constructorimpl(r9)
        L_0x0022:
            boolean r0 = kotlin.Result.m1947isFailureimpl(r9)
            if (r0 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r1 = r9
        L_0x002a:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            return r1
        L_0x002d:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = cacheLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r0.readLock()
            r2.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable>> r3 = exceptionCtors     // Catch:{ all -> 0x0133 }
            java.lang.Class r4 = r9.getClass()     // Catch:{ all -> 0x0133 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0133 }
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3     // Catch:{ all -> 0x0133 }
            r2.unlock()
            if (r3 == 0) goto L_0x004e
            java.lang.Object r9 = r3.invoke(r9)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            return r9
        L_0x004e:
            int r2 = throwableFields
            java.lang.Class r3 = r9.getClass()
            r4 = 0
            int r3 = fieldsCountOrDefault(r3, r4)
            if (r2 == r3) goto L_0x00a3
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r0.readLock()
            int r3 = r0.getWriteHoldCount()
            if (r3 != 0) goto L_0x006a
            int r3 = r0.getReadHoldCount()
            goto L_0x006b
        L_0x006a:
            r3 = 0
        L_0x006b:
            r5 = 0
        L_0x006c:
            if (r5 >= r3) goto L_0x0074
            r2.unlock()
            int r5 = r5 + 1
            goto L_0x006c
        L_0x0074:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable>> r5 = exceptionCtors     // Catch:{ all -> 0x0096 }
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ all -> 0x0096 }
            java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x0096 }
            kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$4$1 r6 = kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$4$1.INSTANCE     // Catch:{ all -> 0x0096 }
            r5.put(r9, r6)     // Catch:{ all -> 0x0096 }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0096 }
        L_0x008a:
            if (r4 >= r3) goto L_0x0092
            r2.lock()
            int r4 = r4 + 1
            goto L_0x008a
        L_0x0092:
            r0.unlock()
            return r1
        L_0x0096:
            r9 = move-exception
        L_0x0097:
            if (r4 >= r3) goto L_0x009f
            r2.lock()
            int r4 = r4 + 1
            goto L_0x0097
        L_0x009f:
            r0.unlock()
            throw r9
        L_0x00a3:
            r0 = r1
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            java.lang.Class r0 = r9.getClass()
            java.lang.reflect.Constructor[] r0 = r0.getConstructors()
            java.lang.String r2 = "exception.javaClass.constructors"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1 r2 = new kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1
            r2.<init>()
            java.util.Comparator r2 = (java.util.Comparator) r2
            java.util.List r0 = kotlin.collections.ArraysKt.sortedWith((T[]) r0, r2)
            java.util.Iterator r0 = r0.iterator()
            r2 = r1
        L_0x00c3:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00da
            java.lang.Object r2 = r0.next()
            java.lang.reflect.Constructor r2 = (java.lang.reflect.Constructor) r2
            java.lang.String r3 = "constructor"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            kotlin.jvm.functions.Function1 r2 = createConstructor(r2)
            if (r2 == 0) goto L_0x00c3
        L_0x00da:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = cacheLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r3 = r0.readLock()
            int r5 = r0.getWriteHoldCount()
            if (r5 != 0) goto L_0x00eb
            int r5 = r0.getReadHoldCount()
            goto L_0x00ec
        L_0x00eb:
            r5 = 0
        L_0x00ec:
            r6 = 0
        L_0x00ed:
            if (r6 >= r5) goto L_0x00f5
            r3.unlock()
            int r6 = r6 + 1
            goto L_0x00ed
        L_0x00f5:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable>> r6 = exceptionCtors     // Catch:{ all -> 0x0126 }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ all -> 0x0126 }
            java.lang.Class r7 = r9.getClass()     // Catch:{ all -> 0x0126 }
            if (r2 == 0) goto L_0x0108
            r8 = r2
            goto L_0x010c
        L_0x0108:
            kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$5$1 r8 = kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$5$1.INSTANCE     // Catch:{ all -> 0x0126 }
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8     // Catch:{ all -> 0x0126 }
        L_0x010c:
            r6.put(r7, r8)     // Catch:{ all -> 0x0126 }
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0126 }
        L_0x0111:
            if (r4 >= r5) goto L_0x0119
            r3.lock()
            int r4 = r4 + 1
            goto L_0x0111
        L_0x0119:
            r0.unlock()
            if (r2 == 0) goto L_0x0125
            java.lang.Object r9 = r2.invoke(r9)
            r1 = r9
            java.lang.Throwable r1 = (java.lang.Throwable) r1
        L_0x0125:
            return r1
        L_0x0126:
            r9 = move-exception
        L_0x0127:
            if (r4 >= r5) goto L_0x012f
            r3.lock()
            int r4 = r4 + 1
            goto L_0x0127
        L_0x012f:
            r0.unlock()
            throw r9
        L_0x0133:
            r9 = move-exception
            r2.unlock()
            goto L_0x0139
        L_0x0138:
            throw r9
        L_0x0139:
            goto L_0x0138
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ExceptionsConstuctorKt.tryCopyException(java.lang.Throwable):java.lang.Throwable");
    }

    private static final Function1<Throwable, Throwable> createConstructor(Constructor<?> constructor) {
        Class[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4(constructor);
        }
        if (length == 1) {
            Class cls = parameterTypes[0];
            if (Intrinsics.areEqual((Object) cls, (Object) Throwable.class)) {
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2(constructor);
            }
            if (Intrinsics.areEqual((Object) cls, (Object) String.class)) {
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3(constructor);
            }
            return null;
        } else if (length == 2 && Intrinsics.areEqual((Object) parameterTypes[0], (Object) String.class) && Intrinsics.areEqual((Object) parameterTypes[1], (Object) Throwable.class)) {
            return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1(constructor);
        } else {
            return null;
        }
    }

    private static final Function1<Throwable, Throwable> safeCtor(Function1<? super Throwable, ? extends Throwable> function1) {
        return new ExceptionsConstuctorKt$safeCtor$1(function1);
    }

    private static final int fieldsCountOrDefault(Class<?> cls, int i) {
        Integer num;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            Result.Companion companion = Result.Companion;
            num = Result.m1941constructorimpl(Integer.valueOf(fieldsCount$default(cls, 0, 1, (Object) null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m1941constructorimpl(ResultKt.createFailure(th));
        }
        Integer valueOf = Integer.valueOf(i);
        if (Result.m1947isFailureimpl(num)) {
            num = valueOf;
        }
        return ((Number) num).intValue();
    }

    static /* synthetic */ int fieldsCount$default(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return fieldsCount(cls, i);
    }

    private static final int fieldsCount(Class<?> cls, int i) {
        Class<? super Object> superclass;
        do {
            Field[] declaredFields = r6.getDeclaredFields();
            Intrinsics.checkExpressionValueIsNotNull(declaredFields, "declaredFields");
            int i2 = 0;
            Class<? super Object> cls2 = cls;
            for (Field field : declaredFields) {
                Intrinsics.checkExpressionValueIsNotNull(field, "it");
                if (!Modifier.isStatic(field.getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            superclass = cls2.getSuperclass();
            cls2 = superclass;
        } while (superclass != null);
        return i;
    }
}
