package p009io.reactivex.subscribers;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Subscription;
import p009io.reactivex.FlowableSubscriber;
import p009io.reactivex.disposables.Disposable;
import p009io.reactivex.internal.subscriptions.SubscriptionHelper;
import p009io.reactivex.internal.util.EndConsumerHelper;

/* renamed from: io.reactivex.subscribers.DisposableSubscriber */
public abstract class DisposableSubscriber<T> implements FlowableSubscriber<T>, Disposable {
    final AtomicReference<Subscription> upstream = new AtomicReference<>();

    public final void onSubscribe(Subscription subscription) {
        if (EndConsumerHelper.setOnce(this.upstream, subscription, getClass())) {
            onStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        this.upstream.get().request(LongCompanionObject.MAX_VALUE);
    }

    /* access modifiers changed from: protected */
    public final void request(long j) {
        this.upstream.get().request(j);
    }

    /* access modifiers changed from: protected */
    public final void cancel() {
        dispose();
    }

    public final boolean isDisposed() {
        return this.upstream.get() == SubscriptionHelper.CANCELLED;
    }

    public final void dispose() {
        SubscriptionHelper.cancel(this.upstream);
    }
}
