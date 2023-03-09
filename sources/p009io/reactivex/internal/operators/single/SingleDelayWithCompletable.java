package p009io.reactivex.internal.operators.single;

import java.util.concurrent.atomic.AtomicReference;
import p009io.reactivex.CompletableObserver;
import p009io.reactivex.CompletableSource;
import p009io.reactivex.Single;
import p009io.reactivex.SingleObserver;
import p009io.reactivex.SingleSource;
import p009io.reactivex.disposables.Disposable;
import p009io.reactivex.internal.disposables.DisposableHelper;
import p009io.reactivex.internal.observers.ResumeSingleObserver;

/* renamed from: io.reactivex.internal.operators.single.SingleDelayWithCompletable */
public final class SingleDelayWithCompletable<T> extends Single<T> {
    final CompletableSource other;
    final SingleSource<T> source;

    public SingleDelayWithCompletable(SingleSource<T> singleSource, CompletableSource completableSource) {
        this.source = singleSource;
        this.other = completableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.other.subscribe(new OtherObserver(singleObserver, this.source));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleDelayWithCompletable$OtherObserver */
    static final class OtherObserver<T> extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = -8565274649390031272L;
        final SingleObserver<? super T> downstream;
        final SingleSource<T> source;

        OtherObserver(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.downstream = singleObserver;
            this.source = singleSource;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onComplete() {
            this.source.subscribe(new ResumeSingleObserver(this, this.downstream));
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }
    }
}
