package p009io.reactivex.internal.operators.completable;

import p009io.reactivex.Completable;
import p009io.reactivex.CompletableObserver;
import p009io.reactivex.SingleObserver;
import p009io.reactivex.SingleSource;
import p009io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.operators.completable.CompletableFromSingle */
public final class CompletableFromSingle<T> extends Completable {
    final SingleSource<T> single;

    public CompletableFromSingle(SingleSource<T> singleSource) {
        this.single = singleSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.single.subscribe(new CompletableFromSingleObserver(completableObserver));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableFromSingle$CompletableFromSingleObserver */
    static final class CompletableFromSingleObserver<T> implements SingleObserver<T> {

        /* renamed from: co */
        final CompletableObserver f1560co;

        CompletableFromSingleObserver(CompletableObserver completableObserver) {
            this.f1560co = completableObserver;
        }

        public void onError(Throwable th) {
            this.f1560co.onError(th);
        }

        public void onSubscribe(Disposable disposable) {
            this.f1560co.onSubscribe(disposable);
        }

        public void onSuccess(T t) {
            this.f1560co.onComplete();
        }
    }
}
