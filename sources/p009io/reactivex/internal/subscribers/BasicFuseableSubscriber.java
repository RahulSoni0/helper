package p009io.reactivex.internal.subscribers;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p009io.reactivex.FlowableSubscriber;
import p009io.reactivex.exceptions.Exceptions;
import p009io.reactivex.internal.fuseable.QueueSubscription;
import p009io.reactivex.internal.subscriptions.SubscriptionHelper;
import p009io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.subscribers.BasicFuseableSubscriber */
public abstract class BasicFuseableSubscriber<T, R> implements FlowableSubscriber<T>, QueueSubscription<R> {
    protected boolean done;
    protected final Subscriber<? super R> downstream;

    /* renamed from: qs */
    protected QueueSubscription<T> f1628qs;
    protected int sourceMode;
    protected Subscription upstream;

    /* access modifiers changed from: protected */
    public void afterDownstream() {
    }

    /* access modifiers changed from: protected */
    public boolean beforeDownstream() {
        return true;
    }

    public BasicFuseableSubscriber(Subscriber<? super R> subscriber) {
        this.downstream = subscriber;
    }

    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            if (subscription instanceof QueueSubscription) {
                this.f1628qs = (QueueSubscription) subscription;
            }
            if (beforeDownstream()) {
                this.downstream.onSubscribe(this);
                afterDownstream();
            }
        }
    }

    public void onError(Throwable th) {
        if (this.done) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.done = true;
        this.downstream.onError(th);
    }

    /* access modifiers changed from: protected */
    public final void fail(Throwable th) {
        Exceptions.throwIfFatal(th);
        this.upstream.cancel();
        onError(th);
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.downstream.onComplete();
        }
    }

    /* access modifiers changed from: protected */
    public final int transitiveBoundaryFusion(int i) {
        QueueSubscription<T> queueSubscription = this.f1628qs;
        if (queueSubscription == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = queueSubscription.requestFusion(i);
        if (requestFusion != 0) {
            this.sourceMode = requestFusion;
        }
        return requestFusion;
    }

    public void request(long j) {
        this.upstream.request(j);
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public boolean isEmpty() {
        return this.f1628qs.isEmpty();
    }

    public void clear() {
        this.f1628qs.clear();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(R r, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
