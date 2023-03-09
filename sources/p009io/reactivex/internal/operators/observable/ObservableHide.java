package p009io.reactivex.internal.operators.observable;

import p009io.reactivex.ObservableSource;
import p009io.reactivex.Observer;
import p009io.reactivex.disposables.Disposable;
import p009io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.observable.ObservableHide */
public final class ObservableHide<T> extends AbstractObservableWithUpstream<T, T> {
    public ObservableHide(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new HideDisposable(observer));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableHide$HideDisposable */
    static final class HideDisposable<T> implements Observer<T>, Disposable {
        final Observer<? super T> downstream;
        Disposable upstream;

        HideDisposable(Observer<? super T> observer) {
            this.downstream = observer;
        }

        public void dispose() {
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onComplete() {
            this.downstream.onComplete();
        }
    }
}
