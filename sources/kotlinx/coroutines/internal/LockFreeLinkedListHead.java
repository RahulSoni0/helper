package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J-\u0010\u0006\u001a\u00020\u0007\"\u000e\b\u0000\u0010\b\u0018\u0001*\u00060\u0001j\u0002`\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00070\u000bH\bJ\u0006\u0010\f\u001a\u00020\u0004J\r\u0010\r\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u000eR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u000f"}, mo18301d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "()V", "isEmpty", "", "()Z", "forEach", "", "T", "Lkotlinx/coroutines/internal/Node;", "block", "Lkotlin/Function1;", "remove", "validate", "validate$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
/* compiled from: LockFreeLinkedList.kt */
public class LockFreeLinkedListHead extends LockFreeLinkedListNode {
    public final boolean isEmpty() {
        LockFreeLinkedListHead lockFreeLinkedListHead = this;
        return getNext() == this;
    }

    public final /* synthetic */ <T extends LockFreeLinkedListNode> void forEach(Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "block");
        Object next = getNext();
        if (next != null) {
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
            while (true) {
                LockFreeLinkedListHead lockFreeLinkedListHead = this;
                if (!Intrinsics.areEqual((Object) lockFreeLinkedListNode, (Object) this)) {
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                        function1.invoke(lockFreeLinkedListNode);
                    }
                    lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
                } else {
                    return;
                }
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }
    }

    public final boolean remove() {
        throw new UnsupportedOperationException();
    }

    public final void validate$kotlinx_coroutines_core() {
        LockFreeLinkedListNode lockFreeLinkedListNode = this;
        Object next = getNext();
        if (next != null) {
            LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) next;
            LockFreeLinkedListNode lockFreeLinkedListNode3 = lockFreeLinkedListNode;
            LockFreeLinkedListNode lockFreeLinkedListNode4 = lockFreeLinkedListNode2;
            while (true) {
                LockFreeLinkedListHead lockFreeLinkedListHead = this;
                if (!(!Intrinsics.areEqual((Object) lockFreeLinkedListNode4, (Object) this))) {
                    break;
                }
                LockFreeLinkedListNode nextNode = lockFreeLinkedListNode4.getNextNode();
                lockFreeLinkedListNode4.validateNode$kotlinx_coroutines_core(lockFreeLinkedListNode3, nextNode);
                lockFreeLinkedListNode3 = lockFreeLinkedListNode4;
                lockFreeLinkedListNode4 = nextNode;
            }
            Object next2 = getNext();
            if (next2 != null) {
                validateNode$kotlinx_coroutines_core(lockFreeLinkedListNode3, (LockFreeLinkedListNode) next2);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }
}
