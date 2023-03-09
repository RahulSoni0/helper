package kotlinx.coroutines.internal;

import androidx.work.impl.utils.futures.C0842x3bb65290;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0019\b\u0000\u0018\u0000 2*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u000223B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0013J-\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\"\u0010#J&\u0010%\u001a\u0004\u0018\u00010\u00012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0019H\b¢\u0006\u0004\b%\u0010&J3\u0010)\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H\u0002¢\u0006\u0004\b)\u0010*R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010+R\u0013\u0010,\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010\u0013R\u0016\u0010-\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010+R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010.R\u0013\u00101\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00064"}, mo18301d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", "E", "", "capacity", "", "singleConsumer", "<init>", "(IZ)V", "element", "addLast", "(Ljava/lang/Object;)I", "", "state", "Lkotlinx/coroutines/internal/Core;", "allocateNextCopy", "(J)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "allocateOrGetNextCopy", "close", "()Z", "index", "fillPlaceholder", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "markFrozen", "()J", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "removeFirstOrNull", "()Ljava/lang/Object;", "predicate", "removeFirstOrNullIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "oldHead", "newHead", "removeSlowPath", "(II)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "I", "isEmpty", "mask", "Z", "getSize", "()I", "size", "Companion", "Placeholder", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
/* compiled from: LockFreeTaskQueue.kt */
public final class LockFreeTaskQueueCore<E> {
    public static final int ADD_CLOSED = 2;
    public static final int ADD_FROZEN = 1;
    public static final int ADD_SUCCESS = 0;
    public static final int CAPACITY_BITS = 30;
    public static final long CLOSED_MASK = 2305843009213693952L;
    public static final int CLOSED_SHIFT = 61;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long FROZEN_MASK = 1152921504606846976L;
    public static final int FROZEN_SHIFT = 60;
    public static final long HEAD_MASK = 1073741823;
    public static final int HEAD_SHIFT = 0;
    public static final int INITIAL_CAPACITY = 8;
    public static final int MAX_CAPACITY_MASK = 1073741823;
    public static final int MIN_ADD_SPIN_CAPACITY = 1024;
    public static final Symbol REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");
    public static final long TAIL_MASK = 1152921503533105152L;
    public static final int TAIL_SHIFT = 30;
    private static final AtomicReferenceFieldUpdater _next$FU;
    public static final /* synthetic */ AtomicLongFieldUpdater _state$FU$internal;
    private volatile Object _next = null;
    public volatile /* synthetic */ long _state$internal = 0;
    public /* synthetic */ AtomicReferenceArray array$internal;
    private final int capacity;
    /* access modifiers changed from: private */
    public final int mask;
    /* access modifiers changed from: private */
    public final boolean singleConsumer;

    public LockFreeTaskQueueCore(int i, boolean z) {
        this.capacity = i;
        this.singleConsumer = z;
        int i2 = i - 1;
        this.mask = i2;
        this.array$internal = new AtomicReferenceArray(i);
        boolean z2 = false;
        if (i2 <= 1073741823) {
            if (!((i & i2) == 0 ? true : z2)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final boolean isEmpty() {
        long j = this._state$internal;
        return ((int) ((HEAD_MASK & j) >> 0)) == ((int) ((j & TAIL_MASK) >> 30));
    }

    public final int getSize() {
        long j = this._state$internal;
        return 1073741823 & (((int) ((j & TAIL_MASK) >> 30)) - ((int) ((HEAD_MASK & j) >> 0)));
    }

    private final LockFreeTaskQueueCore<E> fillPlaceholder(int i, E e) {
        Object obj = this.array$internal.get(this.mask & i);
        if (!(obj instanceof Placeholder) || ((Placeholder) obj).index != i) {
            return null;
        }
        this.array$internal.set(i & this.mask, e);
        return this;
    }

    public final LockFreeTaskQueueCore<E> next() {
        return allocateOrGetNextCopy(markFrozen());
    }

    private final LockFreeTaskQueueCore<E> allocateNextCopy(long j) {
        LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = new LockFreeTaskQueueCore<>(this.capacity * 2, this.singleConsumer);
        int i = (int) ((HEAD_MASK & j) >> 0);
        int i2 = (int) ((TAIL_MASK & j) >> 30);
        while (true) {
            int i3 = this.mask;
            if ((i & i3) != (i2 & i3)) {
                Object obj = this.array$internal.get(i3 & i);
                if (obj == null) {
                    obj = new Placeholder(i);
                }
                lockFreeTaskQueueCore.array$internal.set(lockFreeTaskQueueCore.mask & i, obj);
                i++;
            } else {
                lockFreeTaskQueueCore._state$internal = Companion.mo19546wo(j, FROZEN_MASK);
                return lockFreeTaskQueueCore;
            }
        }
    }

    public final <R> List<R> map(Function1<? super E, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList(this.capacity);
        long j = this._state$internal;
        int i = (int) ((HEAD_MASK & j) >> 0);
        int i2 = (int) ((j & TAIL_MASK) >> 30);
        while (true) {
            int i3 = this.mask;
            if ((i & i3) == (i2 & i3)) {
                return arrayList;
            }
            Object obj = this.array$internal.get(i3 & i);
            if (obj != null && !(obj instanceof Placeholder)) {
                arrayList.add(function1.invoke(obj));
            }
            i++;
        }
    }

    public final boolean isClosed() {
        return (this._state$internal & CLOSED_MASK) != 0;
    }

    @Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo18301d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "(I)V", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
    /* compiled from: LockFreeTaskQueue.kt */
    public static final class Placeholder {
        public final int index;

        public Placeholder(int i) {
            this.index = i;
        }
    }

    @Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0016\u001a\u00020\u0004*\u00020\tJ\u0012\u0010\u0017\u001a\u00020\t*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0004J\u0012\u0010\u0019\u001a\u00020\t*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004JP\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0001\u0010\u001c*\u00020\t26\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u001c0\u001eH\b¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\t*\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006&"}, mo18301d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
    /* compiled from: LockFreeTaskQueue.kt */
    public static final class Companion {
        public final int addFailReason(long j) {
            return (j & LockFreeTaskQueueCore.CLOSED_MASK) != 0 ? 2 : 1;
        }

        /* renamed from: wo */
        public final long mo19546wo(long j, long j2) {
            return j & (j2 ^ -1);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long updateHead(long j, int i) {
            Companion companion = this;
            return mo19546wo(j, LockFreeTaskQueueCore.HEAD_MASK) | (((long) i) << 0);
        }

        public final long updateTail(long j, int i) {
            Companion companion = this;
            return mo19546wo(j, LockFreeTaskQueueCore.TAIL_MASK) | (((long) i) << 30);
        }

        public final <T> T withState(long j, Function2<? super Integer, ? super Integer, ? extends T> function2) {
            Intrinsics.checkParameterIsNotNull(function2, "block");
            return function2.invoke(Integer.valueOf((int) ((LockFreeTaskQueueCore.HEAD_MASK & j) >> 0)), Integer.valueOf((int) ((j & LockFreeTaskQueueCore.TAIL_MASK) >> 30)));
        }
    }

    static {
        Class<LockFreeTaskQueueCore> cls = LockFreeTaskQueueCore.class;
        _next$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_next");
        _state$FU$internal = AtomicLongFieldUpdater.newUpdater(cls, "_state$internal");
    }

    public final boolean close() {
        long j;
        do {
            j = this._state$internal;
            if ((j & CLOSED_MASK) != 0) {
                return true;
            }
            if ((FROZEN_MASK & j) != 0) {
                return false;
            }
        } while (!_state$FU$internal.compareAndSet(this, j, j | CLOSED_MASK));
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070 A[LOOP:1: B:20:0x0070->B:23:0x0082, LOOP_START, PHI: r0 
      PHI: (r0v9 kotlinx.coroutines.internal.LockFreeTaskQueueCore) = (r0v8 kotlinx.coroutines.internal.LockFreeTaskQueueCore), (r0v11 kotlinx.coroutines.internal.LockFreeTaskQueueCore) binds: [B:19:0x0065, B:23:0x0082] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int addLast(E r14) {
        /*
            r13 = this;
            java.lang.String r0 = "element"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r14, r0)
        L_0x0005:
            long r3 = r13._state$internal
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r3
            r7 = 0
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x0017
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r14 = Companion
            int r14 = r14.addFailReason(r3)
            return r14
        L_0x0017:
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r0 = Companion
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            r9 = 0
            long r1 = r1 >> r9
            int r2 = (int) r1
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r1 = 30
            long r5 = r5 >> r1
            int r10 = (int) r5
            int r11 = r13.mask
            int r1 = r10 + 2
            r1 = r1 & r11
            r5 = r2 & r11
            r6 = 1
            if (r1 != r5) goto L_0x0035
            return r6
        L_0x0035:
            boolean r1 = r13.singleConsumer
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r1 != 0) goto L_0x0054
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r13.array$internal
            r12 = r10 & r11
            java.lang.Object r1 = r1.get(r12)
            if (r1 == 0) goto L_0x0054
            int r0 = r13.capacity
            r1 = 1024(0x400, float:1.435E-42)
            if (r0 < r1) goto L_0x0053
            int r10 = r10 - r2
            r1 = r10 & r5
            int r0 = r0 >> 1
            if (r1 <= r0) goto L_0x0005
        L_0x0053:
            return r6
        L_0x0054:
            int r1 = r10 + 1
            r1 = r1 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = _state$FU$internal
            long r5 = r0.updateTail(r3, r1)
            r1 = r2
            r2 = r13
            boolean r0 = r1.compareAndSet(r2, r3, r5)
            if (r0 == 0) goto L_0x0005
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r13.array$internal
            r1 = r10 & r11
            r0.set(r1, r14)
            r0 = r13
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = (kotlinx.coroutines.internal.LockFreeTaskQueueCore) r0
            r0 = r13
        L_0x0070:
            long r1 = r0._state$internal
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x007a
            goto L_0x0085
        L_0x007a:
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = r0.next()
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = r0.fillPlaceholder(r10, r14)
            if (r0 == 0) goto L_0x0085
            goto L_0x0070
        L_0x0085:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeTaskQueueCore.addLast(java.lang.Object):int");
    }

    public final Object removeFirstOrNull() {
        Object obj;
        while (true) {
            long j = this._state$internal;
            if ((FROZEN_MASK & j) == 0) {
                Companion companion = Companion;
                int i = (int) ((HEAD_MASK & j) >> 0);
                if ((((int) ((TAIL_MASK & j) >> 30)) & this.mask) != (this.mask & i)) {
                    obj = this.array$internal.get(this.mask & i);
                    if (obj != null) {
                        if (!(obj instanceof Placeholder)) {
                            int i2 = (i + 1) & MAX_CAPACITY_MASK;
                            if (!_state$FU$internal.compareAndSet(this, j, companion.updateHead(j, i2))) {
                                if (this.singleConsumer) {
                                    LockFreeTaskQueueCore lockFreeTaskQueueCore = this;
                                    LockFreeTaskQueueCore lockFreeTaskQueueCore2 = this;
                                    do {
                                        lockFreeTaskQueueCore2 = lockFreeTaskQueueCore2.removeSlowPath(i, i2);
                                    } while (lockFreeTaskQueueCore2 != null);
                                    break;
                                }
                            } else {
                                this.array$internal.set(this.mask & i, (Object) null);
                                break;
                            }
                        } else {
                            return null;
                        }
                    } else if (this.singleConsumer) {
                        return null;
                    }
                } else {
                    return null;
                }
            } else {
                return REMOVE_FROZEN;
            }
        }
        return obj;
    }

    public final Object removeFirstOrNullIf(Function1<? super E, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        while (true) {
            long j = this._state$internal;
            if ((FROZEN_MASK & j) != 0) {
                return REMOVE_FROZEN;
            }
            Companion companion = Companion;
            int i = (int) ((HEAD_MASK & j) >> 0);
            if ((this.mask & ((int) ((TAIL_MASK & j) >> 30))) == (this.mask & i)) {
                return null;
            }
            Object obj = this.array$internal.get(this.mask & i);
            if (obj == null) {
                if (this.singleConsumer) {
                    return null;
                }
            } else if ((obj instanceof Placeholder) || !function1.invoke(obj).booleanValue()) {
                return null;
            } else {
                int i2 = (i + 1) & MAX_CAPACITY_MASK;
                if (_state$FU$internal.compareAndSet(this, j, companion.updateHead(j, i2))) {
                    this.array$internal.set(this.mask & i, (Object) null);
                    return obj;
                } else if (this.singleConsumer) {
                    LockFreeTaskQueueCore lockFreeTaskQueueCore = this;
                    LockFreeTaskQueueCore lockFreeTaskQueueCore2 = this;
                    do {
                        lockFreeTaskQueueCore2 = lockFreeTaskQueueCore2.removeSlowPath(i, i2);
                    } while (lockFreeTaskQueueCore2 != null);
                    return obj;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final LockFreeTaskQueueCore<E> removeSlowPath(int i, int i2) {
        long j;
        Companion companion;
        int i3;
        do {
            j = this._state$internal;
            companion = Companion;
            boolean z = false;
            i3 = (int) ((HEAD_MASK & j) >> 0);
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (i3 == i) {
                    z = true;
                }
                if (!z) {
                    throw new AssertionError();
                }
            }
            if ((FROZEN_MASK & j) != 0) {
                return next();
            }
        } while (!_state$FU$internal.compareAndSet(this, j, companion.updateHead(j, i2)));
        this.array$internal.set(this.mask & i3, (Object) null);
        return null;
    }

    private final long markFrozen() {
        long j;
        long j2;
        do {
            j = this._state$internal;
            if ((j & FROZEN_MASK) != 0) {
                return j;
            }
            j2 = j | FROZEN_MASK;
        } while (!_state$FU$internal.compareAndSet(this, j, j2));
        return j2;
    }

    private final LockFreeTaskQueueCore<E> allocateOrGetNextCopy(long j) {
        while (true) {
            LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = (LockFreeTaskQueueCore) this._next;
            if (lockFreeTaskQueueCore != null) {
                return lockFreeTaskQueueCore;
            }
            C0842x3bb65290.m23m(_next$FU, this, (Object) null, allocateNextCopy(j));
        }
    }
}
