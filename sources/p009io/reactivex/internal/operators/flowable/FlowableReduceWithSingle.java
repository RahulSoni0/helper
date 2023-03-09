package p009io.reactivex.internal.operators.flowable;

import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import p009io.reactivex.Single;
import p009io.reactivex.SingleObserver;
import p009io.reactivex.exceptions.Exceptions;
import p009io.reactivex.functions.BiFunction;
import p009io.reactivex.internal.disposables.EmptyDisposable;
import p009io.reactivex.internal.functions.ObjectHelper;
import p009io.reactivex.internal.operators.flowable.FlowableReduceSeedSingle;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableReduceWithSingle */
public final class FlowableReduceWithSingle<T, R> extends Single<R> {
    final BiFunction<R, ? super T, R> reducer;
    final Callable<R> seedSupplier;
    final Publisher<T> source;

    public FlowableReduceWithSingle(Publisher<T> publisher, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.source = publisher;
        this.seedSupplier = callable;
        this.reducer = biFunction;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            this.source.subscribe(new FlowableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.reducer, ObjectHelper.requireNonNull(this.seedSupplier.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, (SingleObserver<?>) singleObserver);
        }
    }
}
