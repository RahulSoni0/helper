package p009io.reactivex.internal.operators.mixed;

import p009io.reactivex.CompletableObserver;
import p009io.reactivex.MaybeObserver;
import p009io.reactivex.Notification;
import p009io.reactivex.SingleObserver;
import p009io.reactivex.disposables.Disposable;
import p009io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.mixed.MaterializeSingleObserver */
public final class MaterializeSingleObserver<T> implements SingleObserver<T>, MaybeObserver<T>, CompletableObserver, Disposable {
    final SingleObserver<? super Notification<T>> downstream;
    Disposable upstream;

    public MaterializeSingleObserver(SingleObserver<? super Notification<T>> singleObserver) {
        this.downstream = singleObserver;
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            this.downstream.onSubscribe(this);
        }
    }

    public void onComplete() {
        this.downstream.onSuccess(Notification.createOnComplete());
    }

    public void onSuccess(T t) {
        this.downstream.onSuccess(Notification.createOnNext(t));
    }

    public void onError(Throwable th) {
        this.downstream.onSuccess(Notification.createOnError(th));
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void dispose() {
        this.upstream.dispose();
    }
}
