package p009io.reactivex.internal.operators.single;

import p009io.reactivex.Notification;
import p009io.reactivex.Single;
import p009io.reactivex.SingleObserver;
import p009io.reactivex.internal.operators.mixed.MaterializeSingleObserver;

/* renamed from: io.reactivex.internal.operators.single.SingleMaterialize */
public final class SingleMaterialize<T> extends Single<Notification<T>> {
    final Single<T> source;

    public SingleMaterialize(Single<T> single) {
        this.source = single;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super Notification<T>> singleObserver) {
        this.source.subscribe(new MaterializeSingleObserver(singleObserver));
    }
}
