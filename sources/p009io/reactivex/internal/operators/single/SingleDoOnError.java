package p009io.reactivex.internal.operators.single;

import p009io.reactivex.Single;
import p009io.reactivex.SingleObserver;
import p009io.reactivex.SingleSource;
import p009io.reactivex.disposables.Disposable;
import p009io.reactivex.exceptions.CompositeException;
import p009io.reactivex.exceptions.Exceptions;
import p009io.reactivex.functions.Consumer;

/* renamed from: io.reactivex.internal.operators.single.SingleDoOnError */
public final class SingleDoOnError<T> extends Single<T> {
    final Consumer<? super Throwable> onError;
    final SingleSource<T> source;

    public SingleDoOnError(SingleSource<T> singleSource, Consumer<? super Throwable> consumer) {
        this.source = singleSource;
        this.onError = consumer;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new DoOnError(singleObserver));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleDoOnError$DoOnError */
    final class DoOnError implements SingleObserver<T> {
        private final SingleObserver<? super T> downstream;

        DoOnError(SingleObserver<? super T> singleObserver) {
            this.downstream = singleObserver;
        }

        public void onSubscribe(Disposable disposable) {
            this.downstream.onSubscribe(disposable);
        }

        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }

        public void onError(Throwable th) {
            try {
                SingleDoOnError.this.onError.accept(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                th = new CompositeException(th, th2);
            }
            this.downstream.onError(th);
        }
    }
}
