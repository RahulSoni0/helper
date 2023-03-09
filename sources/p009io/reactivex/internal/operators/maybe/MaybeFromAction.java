package p009io.reactivex.internal.operators.maybe;

import java.util.concurrent.Callable;
import p009io.reactivex.Maybe;
import p009io.reactivex.MaybeObserver;
import p009io.reactivex.disposables.Disposable;
import p009io.reactivex.disposables.Disposables;
import p009io.reactivex.exceptions.Exceptions;
import p009io.reactivex.functions.Action;
import p009io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeFromAction */
public final class MaybeFromAction<T> extends Maybe<T> implements Callable<T> {
    final Action action;

    public MaybeFromAction(Action action2) {
        this.action = action2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Disposable empty = Disposables.empty();
        maybeObserver.onSubscribe(empty);
        if (!empty.isDisposed()) {
            try {
                this.action.run();
                if (!empty.isDisposed()) {
                    maybeObserver.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (!empty.isDisposed()) {
                    maybeObserver.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }

    public T call() throws Exception {
        this.action.run();
        return null;
    }
}
