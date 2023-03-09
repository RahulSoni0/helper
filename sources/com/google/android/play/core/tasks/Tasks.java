package com.google.android.play.core.tasks;

import com.google.android.play.core.internal.C0950ax;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks {
    private Tasks() {
    }

    /* renamed from: a */
    public static <ResultT> Task<ResultT> m942a(ResultT resultt) {
        C1790m mVar = new C1790m();
        mVar.mo31069a(resultt);
        return mVar;
    }

    public static <ResultT> ResultT await(Task<ResultT> task) throws ExecutionException, InterruptedException {
        C0950ax.m71d(task, "Task must not be null");
        if (task.isComplete()) {
            return m944c(task);
        }
        C1791n nVar = new C1791n((byte[]) null);
        m945d(task, nVar);
        nVar.mo31073a();
        return m944c(task);
    }

    public static <ResultT> ResultT await(Task<ResultT> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        C0950ax.m71d(task, "Task must not be null");
        C0950ax.m71d(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return m944c(task);
        }
        C1791n nVar = new C1791n((byte[]) null);
        m945d(task, nVar);
        if (nVar.mo31074b(j, timeUnit)) {
            return m944c(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    /* renamed from: b */
    public static <ResultT> Task<ResultT> m943b(Exception exc) {
        C1790m mVar = new C1790m();
        mVar.mo31071c(exc);
        return mVar;
    }

    /* renamed from: c */
    private static <ResultT> ResultT m944c(Task<ResultT> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    /* renamed from: d */
    private static void m945d(Task<?> task, C1791n nVar) {
        task.addOnSuccessListener(TaskExecutors.f1050a, nVar);
        task.addOnFailureListener(TaskExecutors.f1050a, nVar);
    }
}
