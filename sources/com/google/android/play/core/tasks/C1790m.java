package com.google.android.play.core.tasks;

import com.google.android.play.core.internal.C0950ax;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.tasks.m */
final class C1790m<ResultT> extends Task<ResultT> {

    /* renamed from: a */
    private final Object f1071a = new Object();

    /* renamed from: b */
    private final C1785h<ResultT> f1072b = new C1785h<>();

    /* renamed from: c */
    private boolean f1073c;

    /* renamed from: d */
    private ResultT f1074d;

    /* renamed from: e */
    private Exception f1075e;

    C1790m() {
    }

    /* renamed from: e */
    private final void m963e() {
        C0950ax.m70c(this.f1073c, "Task is not yet complete");
    }

    /* renamed from: f */
    private final void m964f() {
        C0950ax.m70c(!this.f1073c, "Task is already complete");
    }

    /* renamed from: g */
    private final void m965g() {
        synchronized (this.f1071a) {
            if (this.f1073c) {
                this.f1072b.mo31061b(this);
            }
        }
    }

    /* renamed from: a */
    public final void mo31069a(ResultT resultt) {
        synchronized (this.f1071a) {
            m964f();
            this.f1073c = true;
            this.f1074d = resultt;
        }
        this.f1072b.mo31061b(this);
    }

    public final Task<ResultT> addOnCompleteListener(OnCompleteListener<ResultT> onCompleteListener) {
        this.f1072b.mo31060a(new C1779b(TaskExecutors.MAIN_THREAD, onCompleteListener));
        m965g();
        return this;
    }

    public final Task<ResultT> addOnCompleteListener(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        this.f1072b.mo31060a(new C1779b(executor, onCompleteListener));
        m965g();
        return this;
    }

    public final Task<ResultT> addOnFailureListener(OnFailureListener onFailureListener) {
        addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
        return this;
    }

    public final Task<ResultT> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.f1072b.mo31060a(new C1781d(executor, onFailureListener));
        m965g();
        return this;
    }

    public final Task<ResultT> addOnSuccessListener(OnSuccessListener<? super ResultT> onSuccessListener) {
        addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
        return this;
    }

    public final Task<ResultT> addOnSuccessListener(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        this.f1072b.mo31060a(new C1783f(executor, onSuccessListener));
        m965g();
        return this;
    }

    /* renamed from: b */
    public final boolean mo31070b(ResultT resultt) {
        synchronized (this.f1071a) {
            if (this.f1073c) {
                return false;
            }
            this.f1073c = true;
            this.f1074d = resultt;
            this.f1072b.mo31061b(this);
            return true;
        }
    }

    /* renamed from: c */
    public final void mo31071c(Exception exc) {
        synchronized (this.f1071a) {
            m964f();
            this.f1073c = true;
            this.f1075e = exc;
        }
        this.f1072b.mo31061b(this);
    }

    /* renamed from: d */
    public final boolean mo31072d(Exception exc) {
        synchronized (this.f1071a) {
            if (this.f1073c) {
                return false;
            }
            this.f1073c = true;
            this.f1075e = exc;
            this.f1072b.mo31061b(this);
            return true;
        }
    }

    public final Exception getException() {
        Exception exc;
        synchronized (this.f1071a) {
            exc = this.f1075e;
        }
        return exc;
    }

    public final ResultT getResult() {
        ResultT resultt;
        synchronized (this.f1071a) {
            m963e();
            Exception exc = this.f1075e;
            if (exc == null) {
                resultt = this.f1074d;
            } else {
                throw new RuntimeExecutionException(exc);
            }
        }
        return resultt;
    }

    public final <X extends Throwable> ResultT getResult(Class<X> cls) throws Throwable {
        ResultT resultt;
        synchronized (this.f1071a) {
            m963e();
            if (!cls.isInstance(this.f1075e)) {
                Exception exc = this.f1075e;
                if (exc == null) {
                    resultt = this.f1074d;
                } else {
                    throw new RuntimeExecutionException(exc);
                }
            } else {
                throw ((Throwable) cls.cast(this.f1075e));
            }
        }
        return resultt;
    }

    public final boolean isComplete() {
        boolean z;
        synchronized (this.f1071a) {
            z = this.f1073c;
        }
        return z;
    }

    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.f1071a) {
            z = false;
            if (this.f1073c && this.f1075e == null) {
                z = true;
            }
        }
        return z;
    }
}
