package p009io.reactivex.internal.operators.single;

import java.util.concurrent.Callable;
import p009io.reactivex.Single;
import p009io.reactivex.SingleObserver;
import p009io.reactivex.exceptions.Exceptions;
import p009io.reactivex.internal.disposables.EmptyDisposable;
import p009io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.single.SingleError */
public final class SingleError<T> extends Single<T> {
    final Callable<? extends Throwable> errorSupplier;

    public SingleError(Callable<? extends Throwable> callable) {
        this.errorSupplier = callable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        try {
            th = (Throwable) ObjectHelper.requireNonNull(this.errorSupplier.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            Exceptions.throwIfFatal(th);
        }
        EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
    }
}
