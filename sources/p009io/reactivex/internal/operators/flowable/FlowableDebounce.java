package p009io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p009io.reactivex.Flowable;
import p009io.reactivex.FlowableSubscriber;
import p009io.reactivex.disposables.Disposable;
import p009io.reactivex.exceptions.Exceptions;
import p009io.reactivex.exceptions.MissingBackpressureException;
import p009io.reactivex.functions.Function;
import p009io.reactivex.internal.disposables.DisposableHelper;
import p009io.reactivex.internal.functions.ObjectHelper;
import p009io.reactivex.internal.subscriptions.SubscriptionHelper;
import p009io.reactivex.internal.util.BackpressureHelper;
import p009io.reactivex.plugins.RxJavaPlugins;
import p009io.reactivex.subscribers.DisposableSubscriber;
import p009io.reactivex.subscribers.SerializedSubscriber;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableDebounce */
public final class FlowableDebounce<T, U> extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super T, ? extends Publisher<U>> debounceSelector;

    public FlowableDebounce(Flowable<T> flowable, Function<? super T, ? extends Publisher<U>> function) {
        super(flowable);
        this.debounceSelector = function;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new DebounceSubscriber(new SerializedSubscriber(subscriber), this.debounceSelector));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableDebounce$DebounceSubscriber */
    static final class DebounceSubscriber<T, U> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 6725975399620862591L;
        final Function<? super T, ? extends Publisher<U>> debounceSelector;
        final AtomicReference<Disposable> debouncer = new AtomicReference<>();
        boolean done;
        final Subscriber<? super T> downstream;
        volatile long index;
        Subscription upstream;

        DebounceSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<U>> function) {
            this.downstream = subscriber;
            this.debounceSelector = function;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                long j = this.index + 1;
                this.index = j;
                Disposable disposable = this.debouncer.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                try {
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.debounceSelector.apply(t), "The publisher supplied is null");
                    DebounceInnerSubscriber debounceInnerSubscriber = new DebounceInnerSubscriber(this, j, t);
                    if (this.debouncer.compareAndSet(disposable, debounceInnerSubscriber)) {
                        publisher.subscribe(debounceInnerSubscriber);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    this.downstream.onError(th);
                }
            }
        }

        public void onError(Throwable th) {
            DisposableHelper.dispose(this.debouncer);
            this.downstream.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                Disposable disposable = this.debouncer.get();
                if (!DisposableHelper.isDisposed(disposable)) {
                    ((DebounceInnerSubscriber) disposable).emit();
                    DisposableHelper.dispose(this.debouncer);
                    this.downstream.onComplete();
                }
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this, j);
            }
        }

        public void cancel() {
            this.upstream.cancel();
            DisposableHelper.dispose(this.debouncer);
        }

        /* access modifiers changed from: package-private */
        public void emit(long j, T t) {
            if (j != this.index) {
                return;
            }
            if (get() != 0) {
                this.downstream.onNext(t);
                BackpressureHelper.produced(this, 1);
                return;
            }
            cancel();
            this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }

        /* renamed from: io.reactivex.internal.operators.flowable.FlowableDebounce$DebounceSubscriber$DebounceInnerSubscriber */
        static final class DebounceInnerSubscriber<T, U> extends DisposableSubscriber<U> {
            boolean done;
            final long index;
            final AtomicBoolean once = new AtomicBoolean();
            final DebounceSubscriber<T, U> parent;
            final T value;

            DebounceInnerSubscriber(DebounceSubscriber<T, U> debounceSubscriber, long j, T t) {
                this.parent = debounceSubscriber;
                this.index = j;
                this.value = t;
            }

            public void onNext(U u) {
                if (!this.done) {
                    this.done = true;
                    cancel();
                    emit();
                }
            }

            /* access modifiers changed from: package-private */
            public void emit() {
                if (this.once.compareAndSet(false, true)) {
                    this.parent.emit(this.index, this.value);
                }
            }

            public void onError(Throwable th) {
                if (this.done) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                this.done = true;
                this.parent.onError(th);
            }

            public void onComplete() {
                if (!this.done) {
                    this.done = true;
                    emit();
                }
            }
        }
    }
}
