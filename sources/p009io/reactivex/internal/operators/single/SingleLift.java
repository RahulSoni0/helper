package p009io.reactivex.internal.operators.single;

import p009io.reactivex.Single;
import p009io.reactivex.SingleObserver;
import p009io.reactivex.SingleOperator;
import p009io.reactivex.SingleSource;
import p009io.reactivex.exceptions.Exceptions;
import p009io.reactivex.internal.disposables.EmptyDisposable;
import p009io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.single.SingleLift */
public final class SingleLift<T, R> extends Single<R> {
    final SingleOperator<? extends R, ? super T> onLift;
    final SingleSource<T> source;

    public SingleLift(SingleSource<T> singleSource, SingleOperator<? extends R, ? super T> singleOperator) {
        this.source = singleSource;
        this.onLift = singleOperator;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            this.source.subscribe((SingleObserver) ObjectHelper.requireNonNull(this.onLift.apply(singleObserver), "The onLift returned a null SingleObserver"));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
        }
    }
}
