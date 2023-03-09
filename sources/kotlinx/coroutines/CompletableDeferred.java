package kotlinx.coroutines;

import com.itextpdf.text.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, mo18301d2 = {"Lkotlinx/coroutines/CompletableDeferred;", "T", "Lkotlinx/coroutines/Deferred;", "complete", "", "value", "(Ljava/lang/Object;)Z", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
/* compiled from: CompletableDeferred.kt */
public interface CompletableDeferred<T> extends Deferred<T> {

    @Metadata(mo18299bv = {1, 0, 3}, mo18302k = 3, mo18303mv = {1, 1, 15})
    /* compiled from: CompletableDeferred.kt */
    public static final class DefaultImpls {
        public static <T, R> R fold(CompletableDeferred<T> completableDeferred, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            Intrinsics.checkParameterIsNotNull(function2, Annotation.OPERATION);
            return Deferred.DefaultImpls.fold(completableDeferred, r, function2);
        }

        public static <T, E extends CoroutineContext.Element> E get(CompletableDeferred<T> completableDeferred, CoroutineContext.Key<E> key) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            return Deferred.DefaultImpls.get(completableDeferred, key);
        }

        public static <T> CoroutineContext minusKey(CompletableDeferred<T> completableDeferred, CoroutineContext.Key<?> key) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            return Deferred.DefaultImpls.minusKey(completableDeferred, key);
        }

        public static <T> CoroutineContext plus(CompletableDeferred<T> completableDeferred, CoroutineContext coroutineContext) {
            Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
            return Deferred.DefaultImpls.plus(completableDeferred, coroutineContext);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static <T> Job plus(CompletableDeferred<T> completableDeferred, Job job) {
            Intrinsics.checkParameterIsNotNull(job, "other");
            return Deferred.DefaultImpls.plus(completableDeferred, job);
        }
    }

    boolean complete(T t);

    boolean completeExceptionally(Throwable th);
}
