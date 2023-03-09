package p009io.reactivex;

import p009io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.SingleObserver */
public interface SingleObserver<T> {
    void onError(Throwable th);

    void onSubscribe(Disposable disposable);

    void onSuccess(T t);
}
