package p009io.reactivex.internal.disposables;

import p009io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.disposables.ResettableConnectable */
public interface ResettableConnectable {
    void resetIf(Disposable disposable);
}
