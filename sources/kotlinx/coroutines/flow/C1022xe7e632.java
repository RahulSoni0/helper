package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, mo18301d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
/* renamed from: kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$invokeSuspend$$inlined$collect$1 */
/* compiled from: Collect.kt */
public final class C1022xe7e632 implements FlowCollector<T> {
    final /* synthetic */ ProducerScope $this_produce$inlined;

    public C1022xe7e632(ProducerScope producerScope) {
        this.$this_produce$inlined = producerScope;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.C1022xe7e632.C10231
            if (r0 == 0) goto L_0x0014
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$invokeSuspend$$inlined$collect$1$1 r0 = (kotlinx.coroutines.flow.C1022xe7e632.C10231) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$invokeSuspend$$inlined$collect$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$invokeSuspend$$inlined$collect$1$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r6 = r0.L$3
            java.lang.Object r6 = r0.L$2
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            java.lang.Object r6 = r0.L$1
            java.lang.Object r6 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$invokeSuspend$$inlined$collect$1 r6 = (kotlinx.coroutines.flow.C1022xe7e632) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005d
        L_0x0036:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r0
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            kotlinx.coroutines.channels.ProducerScope r2 = r5.$this_produce$inlined
            if (r6 == 0) goto L_0x004a
            r4 = r6
            goto L_0x004c
        L_0x004a:
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL
        L_0x004c:
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.L$3 = r6
            r0.label = r3
            java.lang.Object r6 = r2.send(r4, r0)
            if (r6 != r1) goto L_0x005d
            return r1
        L_0x005d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.C1022xe7e632.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
