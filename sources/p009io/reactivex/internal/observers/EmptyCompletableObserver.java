package p009io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicReference;
import p009io.reactivex.CompletableObserver;
import p009io.reactivex.disposables.Disposable;
import p009io.reactivex.exceptions.OnErrorNotImplementedException;
import p009io.reactivex.internal.disposables.DisposableHelper;
import p009io.reactivex.observers.LambdaConsumerIntrospection;
import p009io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.observers.EmptyCompletableObserver */
public final class EmptyCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -7545121636549663526L;

    public boolean hasCustomOnError() {
        return false;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
    }

    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        RxJavaPlugins.onError(new OnErrorNotImplementedException(th));
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
