package p009io.reactivex.internal.fuseable;

import p009io.reactivex.Flowable;

/* renamed from: io.reactivex.internal.fuseable.FuseToFlowable */
public interface FuseToFlowable<T> {
    Flowable<T> fuseToFlowable();
}
