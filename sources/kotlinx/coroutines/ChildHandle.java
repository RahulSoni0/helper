package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, mo18301d2 = {"Lkotlinx/coroutines/ChildHandle;", "Lkotlinx/coroutines/DisposableHandle;", "childCancelled", "", "cause", "", "kotlinx-coroutines-core"}, mo18302k = 1, mo18303mv = {1, 1, 15})
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
/* compiled from: Job.kt */
public interface ChildHandle extends DisposableHandle {
    boolean childCancelled(Throwable th);
}
