package p009io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import p009io.reactivex.Observable;
import p009io.reactivex.ObservableSource;
import p009io.reactivex.Observer;
import p009io.reactivex.exceptions.Exceptions;
import p009io.reactivex.internal.disposables.EmptyDisposable;
import p009io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.observable.ObservableDefer */
public final class ObservableDefer<T> extends Observable<T> {
    final Callable<? extends ObservableSource<? extends T>> supplier;

    public ObservableDefer(Callable<? extends ObservableSource<? extends T>> callable) {
        this.supplier = callable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            ((ObservableSource) ObjectHelper.requireNonNull(this.supplier.call(), "null ObservableSource supplied")).subscribe(observer);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (Observer<?>) observer);
        }
    }
}
