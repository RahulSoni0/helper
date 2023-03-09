package p009io.reactivex.internal.fuseable;

import p009io.reactivex.ObservableSource;

/* renamed from: io.reactivex.internal.fuseable.HasUpstreamObservableSource */
public interface HasUpstreamObservableSource<T> {
    ObservableSource<T> source();
}
