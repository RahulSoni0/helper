package p009io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p009io.reactivex.Flowable;
import p009io.reactivex.FlowableSubscriber;
import p009io.reactivex.MaybeObserver;
import p009io.reactivex.MaybeSource;
import p009io.reactivex.disposables.Disposable;
import p009io.reactivex.internal.disposables.DisposableHelper;
import p009io.reactivex.internal.fuseable.SimplePlainQueue;
import p009io.reactivex.internal.queue.SpscArrayQueue;
import p009io.reactivex.internal.subscriptions.SubscriptionHelper;
import p009io.reactivex.internal.util.AtomicThrowable;
import p009io.reactivex.internal.util.BackpressureHelper;
import p009io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe */
public final class FlowableMergeWithMaybe<T> extends AbstractFlowableWithUpstream<T, T> {
    final MaybeSource<? extends T> other;

    public FlowableMergeWithMaybe(Flowable<T> flowable, MaybeSource<? extends T> maybeSource) {
        super(flowable);
        this.other = maybeSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(subscriber);
        subscriber.onSubscribe(mergeWithObserver);
        this.source.subscribe(mergeWithObserver);
        this.other.subscribe(mergeWithObserver.otherObserver);
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe$MergeWithObserver */
    static final class MergeWithObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
        static final int OTHER_STATE_HAS_VALUE = 1;
        private static final long serialVersionUID = -4592979584110982903L;
        volatile boolean cancelled;
        int consumed;
        final Subscriber<? super T> downstream;
        long emitted;
        final AtomicThrowable error = new AtomicThrowable();
        final int limit;
        volatile boolean mainDone;
        final AtomicReference<Subscription> mainSubscription = new AtomicReference<>();
        final OtherObserver<T> otherObserver = new OtherObserver<>(this);
        volatile int otherState;
        final int prefetch;
        volatile SimplePlainQueue<T> queue;
        final AtomicLong requested = new AtomicLong();
        T singleItem;

        MergeWithObserver(Subscriber<? super T> subscriber) {
            this.downstream = subscriber;
            int bufferSize = Flowable.bufferSize();
            this.prefetch = bufferSize;
            this.limit = bufferSize - (bufferSize >> 2);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this.mainSubscription, subscription, (long) this.prefetch);
        }

        public void onNext(T t) {
            if (compareAndSet(0, 1)) {
                long j = this.emitted;
                if (this.requested.get() != j) {
                    SimplePlainQueue<T> simplePlainQueue = this.queue;
                    if (simplePlainQueue == null || simplePlainQueue.isEmpty()) {
                        this.emitted = j + 1;
                        this.downstream.onNext(t);
                        int i = this.consumed + 1;
                        if (i == this.limit) {
                            this.consumed = 0;
                            this.mainSubscription.get().request((long) i);
                        } else {
                            this.consumed = i;
                        }
                    } else {
                        simplePlainQueue.offer(t);
                    }
                } else {
                    getOrCreateQueue().offer(t);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                getOrCreateQueue().offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        public void onError(Throwable th) {
            if (this.error.addThrowable(th)) {
                SubscriptionHelper.cancel(this.mainSubscription);
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onComplete() {
            this.mainDone = true;
            drain();
        }

        public void request(long j) {
            BackpressureHelper.add(this.requested, j);
            drain();
        }

        public void cancel() {
            this.cancelled = true;
            SubscriptionHelper.cancel(this.mainSubscription);
            DisposableHelper.dispose(this.otherObserver);
            if (getAndIncrement() == 0) {
                this.queue = null;
                this.singleItem = null;
            }
        }

        /* access modifiers changed from: package-private */
        public void otherSuccess(T t) {
            if (compareAndSet(0, 1)) {
                long j = this.emitted;
                if (this.requested.get() != j) {
                    this.emitted = j + 1;
                    this.downstream.onNext(t);
                    this.otherState = 2;
                } else {
                    this.singleItem = t;
                    this.otherState = 1;
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            } else {
                this.singleItem = t;
                this.otherState = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        /* access modifiers changed from: package-private */
        public void otherError(Throwable th) {
            if (this.error.addThrowable(th)) {
                SubscriptionHelper.cancel(this.mainSubscription);
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        /* access modifiers changed from: package-private */
        public void otherComplete() {
            this.otherState = 2;
            drain();
        }

        /* access modifiers changed from: package-private */
        public SimplePlainQueue<T> getOrCreateQueue() {
            SimplePlainQueue<T> simplePlainQueue = this.queue;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(Flowable.bufferSize());
            this.queue = spscArrayQueue;
            return spscArrayQueue;
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* access modifiers changed from: package-private */
        public void drainLoop() {
            Subscriber<? super T> subscriber = this.downstream;
            long j = this.emitted;
            int i = this.consumed;
            int i2 = this.limit;
            int i3 = 1;
            int i4 = 1;
            while (true) {
                long j2 = this.requested.get();
                while (j != j2) {
                    if (this.cancelled) {
                        this.singleItem = null;
                        this.queue = null;
                        return;
                    } else if (this.error.get() != null) {
                        this.singleItem = null;
                        this.queue = null;
                        subscriber.onError(this.error.terminate());
                        return;
                    } else {
                        int i5 = this.otherState;
                        if (i5 == i3) {
                            T t = this.singleItem;
                            this.singleItem = null;
                            this.otherState = 2;
                            subscriber.onNext(t);
                            j++;
                        } else {
                            boolean z = this.mainDone;
                            SimplePlainQueue<T> simplePlainQueue = this.queue;
                            T poll = simplePlainQueue != null ? simplePlainQueue.poll() : null;
                            boolean z2 = poll == null;
                            if (z && z2 && i5 == 2) {
                                this.queue = null;
                                subscriber.onComplete();
                                return;
                            } else if (z2) {
                                break;
                            } else {
                                subscriber.onNext(poll);
                                j++;
                                i++;
                                if (i == i2) {
                                    this.mainSubscription.get().request((long) i2);
                                    i = 0;
                                }
                                i3 = 1;
                            }
                        }
                    }
                }
                if (j == j2) {
                    if (this.cancelled) {
                        this.singleItem = null;
                        this.queue = null;
                        return;
                    } else if (this.error.get() != null) {
                        this.singleItem = null;
                        this.queue = null;
                        subscriber.onError(this.error.terminate());
                        return;
                    } else {
                        boolean z3 = this.mainDone;
                        SimplePlainQueue<T> simplePlainQueue2 = this.queue;
                        boolean z4 = simplePlainQueue2 == null || simplePlainQueue2.isEmpty();
                        if (z3 && z4 && this.otherState == 2) {
                            this.queue = null;
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                this.emitted = j;
                this.consumed = i;
                i4 = addAndGet(-i4);
                if (i4 != 0) {
                    i3 = 1;
                } else {
                    return;
                }
            }
        }

        /* renamed from: io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe$MergeWithObserver$OtherObserver */
        static final class OtherObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithObserver<T> parent;

            OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.parent = mergeWithObserver;
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(T t) {
                this.parent.otherSuccess(t);
            }

            public void onError(Throwable th) {
                this.parent.otherError(th);
            }

            public void onComplete() {
                this.parent.otherComplete();
            }
        }
    }
}