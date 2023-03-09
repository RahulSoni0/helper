package p009io.reactivex.internal.fuseable;

import p009io.reactivex.MaybeSource;

/* renamed from: io.reactivex.internal.fuseable.HasUpstreamMaybeSource */
public interface HasUpstreamMaybeSource<T> {
    MaybeSource<T> source();
}
