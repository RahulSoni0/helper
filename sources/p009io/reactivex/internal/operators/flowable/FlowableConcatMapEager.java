package p009io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p009io.reactivex.Flowable;
import p009io.reactivex.FlowableSubscriber;
import p009io.reactivex.exceptions.Exceptions;
import p009io.reactivex.exceptions.MissingBackpressureException;
import p009io.reactivex.functions.Function;
import p009io.reactivex.internal.functions.ObjectHelper;
import p009io.reactivex.internal.fuseable.SimpleQueue;
import p009io.reactivex.internal.queue.SpscLinkedArrayQueue;
import p009io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import p009io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import p009io.reactivex.internal.subscriptions.SubscriptionHelper;
import p009io.reactivex.internal.util.AtomicThrowable;
import p009io.reactivex.internal.util.BackpressureHelper;
import p009io.reactivex.internal.util.ErrorMode;
import p009io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableConcatMapEager */
public final class FlowableConcatMapEager<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;

    public FlowableConcatMapEager(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, ErrorMode errorMode2) {
        super(flowable);
        this.mapper = function;
        this.maxConcurrency = i;
        this.prefetch = i2;
        this.errorMode = errorMode2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe(new ConcatMapEagerDelayErrorSubscriber(subscriber, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber */
    static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
        private static final long serialVersionUID = -4255299542215038287L;
        volatile boolean cancelled;
        volatile InnerQueuedSubscriber<R> current;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors = new AtomicThrowable();
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        final AtomicLong requested = new AtomicLong();
        final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> subscribers;
        Subscription upstream;

        ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, ErrorMode errorMode2) {
            this.downstream = subscriber;
            this.mapper = function;
            this.maxConcurrency = i;
            this.prefetch = i2;
            this.errorMode = errorMode2;
            this.subscribers = new SpscLinkedArrayQueue<>(Math.min(i2, i));
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                int i = this.maxConcurrency;
                subscription.request(i == Integer.MAX_VALUE ? LongCompanionObject.MAX_VALUE : (long) i);
            }
        }

        public void onNext(T t) {
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher");
                InnerQueuedSubscriber innerQueuedSubscriber = new InnerQueuedSubscriber(this, this.prefetch);
                if (!this.cancelled) {
                    this.subscribers.offer(innerQueuedSubscriber);
                    publisher.subscribe(innerQueuedSubscriber);
                    if (this.cancelled) {
                        innerQueuedSubscriber.cancel();
                        drainAndCancel();
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.upstream.cancel();
                onError(th);
            }
        }

        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                drainAndCancel();
            }
        }

        /* access modifiers changed from: package-private */
        public void drainAndCancel() {
            if (getAndIncrement() == 0) {
                do {
                    cancelAll();
                } while (decrementAndGet() != 0);
            }
        }

        /* access modifiers changed from: package-private */
        public void cancelAll() {
            InnerQueuedSubscriber<R> innerQueuedSubscriber = this.current;
            this.current = null;
            if (innerQueuedSubscriber != null) {
                innerQueuedSubscriber.cancel();
            }
            while (true) {
                InnerQueuedSubscriber poll = this.subscribers.poll();
                if (poll != null) {
                    poll.cancel();
                } else {
                    return;
                }
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public void innerNext(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r) {
            if (innerQueuedSubscriber.queue().offer(r)) {
                drain();
                return;
            }
            innerQueuedSubscriber.cancel();
            innerError(innerQueuedSubscriber, new MissingBackpressureException());
        }

        public void innerError(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable th) {
            if (this.errors.addThrowable(th)) {
                innerQueuedSubscriber.setDone();
                if (this.errorMode != ErrorMode.END) {
                    this.upstream.cancel();
                }
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void innerComplete(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
            innerQueuedSubscriber.setDone();
            drain();
        }

        public void drain() {
            InnerQueuedSubscriber<R> innerQueuedSubscriber;
            int i;
            long j;
            boolean z;
            SimpleQueue<R> queue;
            if (getAndIncrement() == 0) {
                InnerQueuedSubscriber<R> innerQueuedSubscriber2 = this.current;
                Subscriber<? super R> subscriber = this.downstream;
                ErrorMode errorMode2 = this.errorMode;
                int i2 = 1;
                while (true) {
                    long j2 = this.requested.get();
                    if (innerQueuedSubscriber2 != null) {
                        innerQueuedSubscriber = innerQueuedSubscriber2;
                    } else if (errorMode2 == ErrorMode.END || ((Throwable) this.errors.get()) == null) {
                        boolean z2 = this.done;
                        innerQueuedSubscriber = this.subscribers.poll();
                        if (z2 && innerQueuedSubscriber == null) {
                            Throwable terminate = this.errors.terminate();
                            if (terminate != null) {
                                subscriber.onError(terminate);
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        } else if (innerQueuedSubscriber != null) {
                            this.current = innerQueuedSubscriber;
                        }
                    } else {
                        cancelAll();
                        subscriber.onError(this.errors.terminate());
                        return;
                    }
                    if (innerQueuedSubscriber == null || (queue = innerQueuedSubscriber.queue()) == null) {
                        i = i2;
                        j = 0;
                        z = false;
                    } else {
                        i = i2;
                        j = 0;
                        while (true) {
                            if (j == j2) {
                                break;
                            } else if (this.cancelled) {
                                cancelAll();
                                return;
                            } else if (errorMode2 != ErrorMode.IMMEDIATE || ((Throwable) this.errors.get()) == null) {
                                boolean isDone = innerQueuedSubscriber.isDone();
                                try {
                                    R poll = queue.poll();
                                    boolean z3 = poll == null;
                                    if (isDone && z3) {
                                        this.current = null;
                                        this.upstream.request(1);
                                        innerQueuedSubscriber = null;
                                        z = true;
                                        break;
                                    } else if (z3) {
                                        break;
                                    } else {
                                        subscriber.onNext(poll);
                                        j++;
                                        innerQueuedSubscriber.requestOne();
                                    }
                                } catch (Throwable th) {
                                    Throwable th2 = th;
                                    Exceptions.throwIfFatal(th2);
                                    this.current = null;
                                    innerQueuedSubscriber.cancel();
                                    cancelAll();
                                    subscriber.onError(th2);
                                    return;
                                }
                            } else {
                                this.current = null;
                                innerQueuedSubscriber.cancel();
                                cancelAll();
                                subscriber.onError(this.errors.terminate());
                                return;
                            }
                        }
                        z = false;
                        if (j == j2) {
                            if (this.cancelled) {
                                cancelAll();
                                return;
                            } else if (errorMode2 != ErrorMode.IMMEDIATE || ((Throwable) this.errors.get()) == null) {
                                boolean isDone2 = innerQueuedSubscriber.isDone();
                                boolean isEmpty = queue.isEmpty();
                                if (isDone2 && isEmpty) {
                                    this.current = null;
                                    this.upstream.request(1);
                                    innerQueuedSubscriber = null;
                                    z = true;
                                }
                            } else {
                                this.current = null;
                                innerQueuedSubscriber.cancel();
                                cancelAll();
                                subscriber.onError(this.errors.terminate());
                                return;
                            }
                        }
                    }
                    if (!(j == 0 || j2 == LongCompanionObject.MAX_VALUE)) {
                        this.requested.addAndGet(-j);
                    }
                    if (z) {
                        innerQueuedSubscriber2 = innerQueuedSubscriber;
                        i2 = i;
                    } else {
                        i2 = addAndGet(-i);
                        if (i2 != 0) {
                            innerQueuedSubscriber2 = innerQueuedSubscriber;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }
}
