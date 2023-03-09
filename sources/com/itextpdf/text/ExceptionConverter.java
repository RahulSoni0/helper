package com.itextpdf.text;

import java.io.PrintStream;
import java.io.PrintWriter;

public class ExceptionConverter extends RuntimeException {
    private static final long serialVersionUID = 8657630363395849399L;

    /* renamed from: ex */
    private Exception f1156ex;
    private String prefix;

    public Throwable fillInStackTrace() {
        return this;
    }

    public ExceptionConverter(Exception exc) {
        super(exc);
        this.f1156ex = exc;
        this.prefix = exc instanceof RuntimeException ? "" : "ExceptionConverter: ";
    }

    public static final RuntimeException convertException(Exception exc) {
        if (exc instanceof RuntimeException) {
            return (RuntimeException) exc;
        }
        return new ExceptionConverter(exc);
    }

    public Exception getException() {
        return this.f1156ex;
    }

    public String getMessage() {
        return this.f1156ex.getMessage();
    }

    public String getLocalizedMessage() {
        return this.f1156ex.getLocalizedMessage();
    }

    public String toString() {
        return this.prefix + this.f1156ex;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        synchronized (printStream) {
            printStream.print(this.prefix);
            this.f1156ex.printStackTrace(printStream);
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        synchronized (printWriter) {
            printWriter.print(this.prefix);
            this.f1156ex.printStackTrace(printWriter);
        }
    }
}
