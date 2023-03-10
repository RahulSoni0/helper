package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, mo18301d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
/* compiled from: Collect.kt */
public final class FlowKt__ReduceKt$first$$inlined$collect$2 implements FlowCollector<T> {
    final /* synthetic */ Function2 $predicate$inlined;
    final /* synthetic */ Ref.ObjectRef $result$inlined;

    public FlowKt__ReduceKt$first$$inlined$collect$2(Function2 function2, Ref.ObjectRef objectRef) {
        this.$predicate$inlined = function2;
        this.$result$inlined = objectRef;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0077 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object emit(T r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collect$2.C10901
            if (r0 == 0) goto L_0x0014
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collect$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collect$2.C10901) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collect$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collect$2$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0051
            if (r2 == r4) goto L_0x0041
            if (r2 != r3) goto L_0x0039
            java.lang.Object r6 = r0.L$3
            java.lang.Object r1 = r0.L$2
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            java.lang.Object r1 = r0.L$1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collect$2 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collect$2) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0078
        L_0x0039:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0041:
            java.lang.Object r6 = r0.L$3
            java.lang.Object r2 = r0.L$2
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            java.lang.Object r2 = r0.L$1
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collect$2 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collect$2) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0075
        L_0x0051:
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r0
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            kotlin.jvm.functions.Function2 r2 = r5.$predicate$inlined
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.L$3 = r6
            r0.label = r3
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.L$3 = r6
            r0.label = r4
            java.lang.Object r7 = r2.invoke(r6, r0)
            if (r7 != r1) goto L_0x0074
            return r1
        L_0x0074:
            r0 = r5
        L_0x0075:
            if (r7 != r1) goto L_0x0078
            return r1
        L_0x0078:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x0083
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0083:
            kotlin.jvm.internal.Ref$ObjectRef r7 = r0.$result$inlined
            r7.element = r6
            kotlinx.coroutines.flow.internal.AbortFlowException r6 = new kotlinx.coroutines.flow.internal.AbortFlowException
            r6.<init>()
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collect$2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
