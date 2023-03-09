package androidx.work.impl.utils.futures;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: androidx.work.impl.utils.futures.AbstractFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0 */
/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class C0842x3bb65290 {
    /* renamed from: m */
    public static /* synthetic */ boolean m23m(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Object obj, Object obj2, Object obj3) {
        while (!atomicReferenceFieldUpdater.compareAndSet(obj, obj2, obj3)) {
            if (atomicReferenceFieldUpdater.get(obj) != obj2) {
                return false;
            }
        }
        return true;
    }
}
