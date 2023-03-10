package kotlinx.coroutines.scheduling;

import kotlin.Metadata;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, mo18301d2 = {"Lkotlinx/coroutines/scheduling/NonBlockingContext;", "Lkotlinx/coroutines/scheduling/TaskContext;", "()V", "taskMode", "Lkotlinx/coroutines/scheduling/TaskMode;", "getTaskMode", "()Lkotlinx/coroutines/scheduling/TaskMode;", "afterTask", "", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
/* compiled from: Tasks.kt */
public final class NonBlockingContext implements TaskContext {
    public static final NonBlockingContext INSTANCE = new NonBlockingContext();
    private static final TaskMode taskMode = TaskMode.NON_BLOCKING;

    public void afterTask() {
    }

    private NonBlockingContext() {
    }

    public TaskMode getTaskMode() {
        return taskMode;
    }
}
