package p009io.reactivex.internal.operators.completable;

import java.util.concurrent.atomic.AtomicReference;
import p009io.reactivex.Completable;
import p009io.reactivex.CompletableObserver;
import p009io.reactivex.CompletableSource;
import p009io.reactivex.disposables.Disposable;
import p009io.reactivex.exceptions.CompositeException;
import p009io.reactivex.exceptions.Exceptions;
import p009io.reactivex.functions.Function;
import p009io.reactivex.internal.disposables.DisposableHelper;
import p009io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.internal.operators.completable.CompletableResumeNext */
public final class CompletableResumeNext extends Completable {
    final Function<? super Throwable, ? extends CompletableSource> errorMapper;
    final CompletableSource source;

    public CompletableResumeNext(CompletableSource completableSource, Function<? super Throwable, ? extends CompletableSource> function) {
        this.source = completableSource;
        this.errorMapper = function;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        ResumeNextObserver resumeNextObserver = new ResumeNextObserver(completableObserver, this.errorMapper);
        completableObserver.onSubscribe(resumeNextObserver);
        this.source.subscribe(resumeNextObserver);
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableResumeNext$ResumeNextObserver */
    static final class ResumeNextObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 5018523762564524046L;
        final CompletableObserver downstream;
        final Function<? super Throwable, ? extends CompletableSource> errorMapper;
        boolean once;

        ResumeNextObserver(CompletableObserver completableObserver, Function<? super Throwable, ? extends CompletableSource> function) {
            this.downstream = completableObserver;
            this.errorMapper = function;
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void onError(Throwable th) {
            if (this.once) {
                this.downstream.onError(th);
                return;
            }
            this.once = true;
            try {
                ((CompletableSource) ObjectHelper.requireNonNull(this.errorMapper.apply(th), "The errorMapper returned a null CompletableSource")).subscribe(this);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.downstream.onError(new CompositeException(th, th2));
            }
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }
    }
}
