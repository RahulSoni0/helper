package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.cc */
public final class C1694cc<T> implements C1696ce, C1692ca {

    /* renamed from: a */
    private static final Object f869a = new Object();

    /* renamed from: b */
    private volatile C1696ce<T> f870b;

    /* renamed from: c */
    private volatile Object f871c = f869a;

    private C1694cc(C1696ce<T> ceVar) {
        this.f870b = ceVar;
    }

    /* renamed from: b */
    public static <P extends C1696ce<T>, T> C1696ce<T> m742b(P p) {
        C0960bh.m106j(p);
        return p instanceof C1694cc ? p : new C1694cc(p);
    }

    /* renamed from: c */
    public static <P extends C1696ce<T>, T> C1692ca<T> m743c(P p) {
        if (p instanceof C1692ca) {
            return (C1692ca) p;
        }
        C0960bh.m106j(p);
        return new C1694cc(p);
    }

    /* renamed from: a */
    public final T mo30603a() {
        T t = this.f871c;
        T t2 = f869a;
        if (t == t2) {
            synchronized (this) {
                t = this.f871c;
                if (t == t2) {
                    t = this.f870b.mo30603a();
                    T t3 = this.f871c;
                    if (t3 != t2 && !(t3 instanceof C1695cd)) {
                        if (t3 != t) {
                            String valueOf = String.valueOf(t3);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.f871c = t;
                    this.f870b = null;
                }
            }
        }
        return t;
    }
}
