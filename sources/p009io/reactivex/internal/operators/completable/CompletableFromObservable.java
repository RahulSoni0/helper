package p009io.reactivex.internal.operators.completable;

import p009io.reactivex.Completable;
import p009io.reactivex.CompletableObserver;
import p009io.reactivex.ObservableSource;
import p009io.reactivex.Observer;
import p009io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.operators.completable.CompletableFromObservable */
public final class CompletableFromObservable<T> extends Completable {
    final ObservableSource<T> observable;

    public CompletableFromObservable(ObservableSource<T> observableSource) {
        this.observable = observableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.observable.subscribe(new CompletableFromObservableObserver(completableObserver));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableFromObservable$CompletableFromObservableObserver */
    static final class CompletableFromObservableObserver<T> implements Observer<T> {

        /* renamed from: co */
        final CompletableObserver f1559co;

        public void onNext(T t) {
        }

        CompletableFromObservableObserver(CompletableObserver completableObserver) {
            this.f1559co = completableObserver;
        }

        public void onSubscribe(Disposable disposable) {
            this.f1559co.onSubscribe(disposable);
        }

        public void onError(Throwable th) {
            this.f1559co.onError(th);
        }

        public void onComplete() {
            this.f1559co.onComplete();
        }
    }
}
