package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, mo18301d2 = {"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo18302k = 3, mo18303mv = {1, 1, 15})
@DebugMetadata(mo18317c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", mo18318f = "Combine.kt", mo18319i = {0, 0, 0, 0, 0}, mo18320l = {146}, mo18321m = "invokeSuspend", mo18322n = {"$this$coroutineScope", "size", "channels", "latestValues", "isClosed"}, mo18323s = {"L$0", "I$0", "L$1", "L$2", "L$3"})
/* compiled from: Combine.kt */
final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0 $arrayFactory;
    final /* synthetic */ Flow[] $flows;
    final /* synthetic */ FlowCollector $this_combineInternal;
    final /* synthetic */ Function3 $transform;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* renamed from: p$ */
    private CoroutineScope f307p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$combineInternal$2(FlowCollector flowCollector, Flow[] flowArr, Function0 function0, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.$this_combineInternal = flowCollector;
        this.$flows = flowArr;
        this.$arrayFactory = function0;
        this.$transform = function3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$this_combineInternal, this.$flows, this.$arrayFactory, this.$transform, continuation);
        combineKt$combineInternal$2.f307p$ = (CoroutineScope) obj;
        return combineKt$combineInternal$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CombineKt$combineInternal$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0095 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            r25 = this;
            r1 = r25
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r4) goto L_0x0030
            java.lang.Object r2 = r1.L$4
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2 r2 = (kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2) r2
            java.lang.Object r2 = r1.L$3
            java.lang.Boolean[] r2 = (java.lang.Boolean[]) r2
            java.lang.Object r5 = r1.L$2
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            java.lang.Object r6 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel[] r6 = (kotlinx.coroutines.channels.ReceiveChannel[]) r6
            int r7 = r1.I$0
            java.lang.Object r8 = r1.L$0
            kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
            kotlin.ResultKt.throwOnFailure(r26)
            r10 = r1
            r14 = r2
            r15 = r5
            r13 = r6
            r12 = r7
            r11 = r8
            r2 = r0
            goto L_0x0147
        L_0x0030:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r26)
            kotlinx.coroutines.CoroutineScope r2 = r1.f307p$
            kotlinx.coroutines.flow.Flow[] r5 = r1.$flows
            int r5 = r5.length
            kotlinx.coroutines.channels.ReceiveChannel[] r6 = new kotlinx.coroutines.channels.ReceiveChannel[r5]
            r7 = 0
        L_0x0043:
            if (r7 >= r5) goto L_0x005c
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            kotlinx.coroutines.flow.Flow[] r9 = r1.$flows
            r8 = r9[r8]
            kotlinx.coroutines.channels.ReceiveChannel r8 = kotlinx.coroutines.flow.internal.CombineKt.asFairChannel(r2, r8)
            r6[r7] = r8
            int r7 = r7 + 1
            goto L_0x0043
        L_0x005c:
            java.lang.Object[] r7 = new java.lang.Object[r5]
            java.lang.Boolean[] r8 = new java.lang.Boolean[r5]
            r9 = 0
        L_0x0061:
            if (r9 >= r5) goto L_0x0075
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            java.lang.Number r10 = (java.lang.Number) r10
            r10.intValue()
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            r8[r9] = r10
            int r9 = r9 + 1
            goto L_0x0061
        L_0x0075:
            r10 = r1
            r11 = r2
            r12 = r5
            r13 = r6
            r15 = r7
            r14 = r8
            r2 = r0
        L_0x007c:
            int r0 = r14.length
            r5 = 0
        L_0x007e:
            if (r5 >= r0) goto L_0x0095
            r6 = r14[r5]
            boolean r6 = r6.booleanValue()
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L_0x0092
            r0 = 0
            goto L_0x0096
        L_0x0092:
            int r5 = r5 + 1
            goto L_0x007e
        L_0x0095:
            r0 = 1
        L_0x0096:
            if (r0 != 0) goto L_0x014b
            r10.L$0 = r11
            r10.I$0 = r12
            r10.L$1 = r13
            r10.L$2 = r15
            r10.L$3 = r14
            r10.L$4 = r10
            r10.label = r4
            r9 = r10
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            kotlinx.coroutines.selects.SelectBuilderImpl r8 = new kotlinx.coroutines.selects.SelectBuilderImpl
            r8.<init>(r9)
            r0 = r8
            kotlinx.coroutines.selects.SelectBuilder r0 = (kotlinx.coroutines.selects.SelectBuilder) r0     // Catch:{ all -> 0x0120 }
            r7 = 0
        L_0x00b2:
            if (r7 >= r12) goto L_0x0114
            r5 = r14[r7]     // Catch:{ all -> 0x0120 }
            boolean r16 = r5.booleanValue()     // Catch:{ all -> 0x0120 }
            r17 = r13[r7]     // Catch:{ all -> 0x0120 }
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1 r18 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1     // Catch:{ all -> 0x0120 }
            r19 = 0
            r5 = r18
            r6 = r7
            r20 = r7
            r7 = r19
            r3 = r8
            r8 = r10
            r21 = r9
            r9 = r12
            r22 = r10
            r10 = r14
            r23 = r11
            r11 = r13
            r24 = r12
            r12 = r15
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0112 }
            r6 = r18
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch:{ all -> 0x0112 }
            if (r16 == 0) goto L_0x00e1
            r18 = r13
            goto L_0x0100
        L_0x00e1:
            kotlinx.coroutines.selects.SelectClause1 r12 = r17.getOnReceiveOrNull()     // Catch:{ all -> 0x0112 }
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2 r16 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2     // Catch:{ all -> 0x0112 }
            r7 = 0
            r5 = r16
            r8 = r20
            r9 = r22
            r10 = r24
            r11 = r14
            r4 = r12
            r12 = r13
            r18 = r13
            r13 = r15
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0110 }
            r5 = r16
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch:{ all -> 0x0110 }
            r0.invoke(r4, r5)     // Catch:{ all -> 0x0110 }
        L_0x0100:
            int r7 = r20 + 1
            r8 = r3
            r13 = r18
            r9 = r21
            r10 = r22
            r11 = r23
            r12 = r24
            r3 = 0
            r4 = 1
            goto L_0x00b2
        L_0x0110:
            r0 = move-exception
            goto L_0x012c
        L_0x0112:
            r0 = move-exception
            goto L_0x012a
        L_0x0114:
            r3 = r8
            r21 = r9
            r22 = r10
            r23 = r11
            r24 = r12
            r18 = r13
            goto L_0x012f
        L_0x0120:
            r0 = move-exception
            r3 = r8
            r21 = r9
            r22 = r10
            r23 = r11
            r24 = r12
        L_0x012a:
            r18 = r13
        L_0x012c:
            r3.handleBuilderException(r0)
        L_0x012f:
            java.lang.Object r0 = r3.getResult()
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r3) goto L_0x013c
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r21)
        L_0x013c:
            if (r0 != r2) goto L_0x013f
            return r2
        L_0x013f:
            r13 = r18
            r10 = r22
            r11 = r23
            r12 = r24
        L_0x0147:
            r3 = 0
            r4 = 1
            goto L_0x007c
        L_0x014b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
