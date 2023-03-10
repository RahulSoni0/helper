package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, mo18301d2 = {"kotlinx/coroutines/flow/internal/SafeCollectorKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
/* compiled from: SafeCollector.kt */
public final class FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 implements Flow<T> {
    final /* synthetic */ Function3 $action$inlined;
    final /* synthetic */ Flow $this_catch$inlined;

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00bb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector r9, kotlin.coroutines.Continuation r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.C10451
            if (r0 == 0) goto L_0x0014
            r0 = r10
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.C10451) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0079
            if (r2 == r5) goto L_0x0065
            if (r2 == r4) goto L_0x004d
            if (r2 != r3) goto L_0x0045
            java.lang.Object r9 = r0.L$4
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            java.lang.Object r9 = r0.L$3
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            java.lang.Object r9 = r0.L$2
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            java.lang.Object r9 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 r9 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00bc
        L_0x0045:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x004d:
            java.lang.Object r9 = r0.L$4
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            java.lang.Object r9 = r0.L$3
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            java.lang.Object r9 = r0.L$2
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            java.lang.Object r9 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 r9 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00b9
        L_0x0065:
            java.lang.Object r9 = r0.L$3
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            java.lang.Object r2 = r0.L$2
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            java.lang.Object r5 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            java.lang.Object r6 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 r6 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1) r6
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0094
        L_0x0079:
            kotlin.ResultKt.throwOnFailure(r10)
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            kotlinx.coroutines.flow.Flow r10 = r8.$this_catch$inlined
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r2
            r0.L$3 = r9
            r0.label = r5
            java.lang.Object r10 = kotlinx.coroutines.flow.FlowKt.catchImpl(r10, r9, r0)
            if (r10 != r1) goto L_0x0092
            return r1
        L_0x0092:
            r6 = r8
            r5 = r9
        L_0x0094:
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            if (r10 == 0) goto L_0x00bc
            kotlin.jvm.functions.Function3 r7 = r6.$action$inlined
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r2
            r0.L$3 = r9
            r0.L$4 = r10
            r0.label = r3
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r2
            r0.L$3 = r9
            r0.L$4 = r10
            r0.label = r4
            java.lang.Object r10 = r7.invoke(r9, r10, r0)
            if (r10 != r1) goto L_0x00b9
            return r1
        L_0x00b9:
            if (r10 != r1) goto L_0x00bc
            return r1
        L_0x00bc:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.$this_catch$inlined = flow;
        this.$action$inlined = function3;
    }
}
