package p009io.reactivex.internal.operators.maybe;

import p009io.reactivex.MaybeObserver;
import p009io.reactivex.MaybeSource;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeUnsafeCreate */
public final class MaybeUnsafeCreate<T> extends AbstractMaybeWithUpstream<T, T> {
    public MaybeUnsafeCreate(MaybeSource<T> maybeSource) {
        super(maybeSource);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(maybeObserver);
    }
}
