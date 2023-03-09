package p009io.reactivex.internal.operators.maybe;

import p009io.reactivex.Maybe;
import p009io.reactivex.Notification;
import p009io.reactivex.Single;
import p009io.reactivex.SingleObserver;
import p009io.reactivex.internal.operators.mixed.MaterializeSingleObserver;

/* renamed from: io.reactivex.internal.operators.maybe.MaybeMaterialize */
public final class MaybeMaterialize<T> extends Single<Notification<T>> {
    final Maybe<T> source;

    public MaybeMaterialize(Maybe<T> maybe) {
        this.source = maybe;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.source.subscribe(new MaterializeSingleObserver(singleObserver));
    }
}
