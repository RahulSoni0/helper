package kotlinx.coroutines;

import com.itextpdf.text.Annotation;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, mo18301d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext$Element;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "Key", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
/* compiled from: CoroutineExceptionHandler.kt */
public interface CoroutineExceptionHandler extends CoroutineContext.Element {
    public static final Key Key = Key.$$INSTANCE;

    @Metadata(mo18299bv = {1, 0, 3}, mo18302k = 3, mo18303mv = {1, 1, 15})
    /* compiled from: CoroutineExceptionHandler.kt */
    public static final class DefaultImpls {
        public static <R> R fold(CoroutineExceptionHandler coroutineExceptionHandler, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            Intrinsics.checkParameterIsNotNull(function2, Annotation.OPERATION);
            return CoroutineContext.Element.DefaultImpls.fold(coroutineExceptionHandler, r, function2);
        }

        public static <E extends CoroutineContext.Element> E get(CoroutineExceptionHandler coroutineExceptionHandler, CoroutineContext.Key<E> key) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            return CoroutineContext.Element.DefaultImpls.get(coroutineExceptionHandler, key);
        }

        public static CoroutineContext minusKey(CoroutineExceptionHandler coroutineExceptionHandler, CoroutineContext.Key<?> key) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            return CoroutineContext.Element.DefaultImpls.minusKey(coroutineExceptionHandler, key);
        }

        public static CoroutineContext plus(CoroutineExceptionHandler coroutineExceptionHandler, CoroutineContext coroutineContext) {
            Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
            return CoroutineContext.Element.DefaultImpls.plus(coroutineExceptionHandler, coroutineContext);
        }
    }

    void handleException(CoroutineContext coroutineContext, Throwable th);

    @Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, mo18301d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
    /* compiled from: CoroutineExceptionHandler.kt */
    public static final class Key implements CoroutineContext.Key<CoroutineExceptionHandler> {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }
}
