package com.google.android.play.core.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;

/* renamed from: com.google.android.play.core.internal.bg */
public final class C0959bg<T> {

    /* renamed from: a */
    private final Object f148a;

    /* renamed from: b */
    private final Field f149b;

    /* renamed from: c */
    private final Class<T> f150c;

    C0959bg(Object obj, Field field, Class<T> cls) {
        this.f148a = obj;
        this.f149b = field;
        this.f150c = cls;
    }

    C0959bg(Object obj, Field field, Class cls, byte[] bArr) {
        this(obj, field, Array.newInstance(cls, 0).getClass());
    }

    /* renamed from: f */
    private Class m91f() {
        return mo17073c().getType().getComponentType();
    }

    /* renamed from: a */
    public final T mo17071a() {
        try {
            return this.f150c.cast(this.f149b.get(this.f148a));
        } catch (Exception e) {
            throw new C0961bi(String.format("Failed to get value of field %s of type %s on object of type %s", new Object[]{this.f149b.getName(), this.f148a.getClass().getName(), this.f150c.getName()}), e);
        }
    }

    /* renamed from: b */
    public final void mo17072b(T t) {
        try {
            this.f149b.set(this.f148a, t);
        } catch (Exception e) {
            throw new C0961bi(String.format("Failed to set value of field %s of type %s on object of type %s", new Object[]{this.f149b.getName(), this.f148a.getClass().getName(), this.f150c.getName()}), e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final Field mo17073c() {
        return this.f149b;
    }

    /* renamed from: d */
    public void mo17074d(Collection collection) {
        Object[] objArr = (Object[]) mo17071a();
        int length = objArr == null ? 0 : objArr.length;
        Object[] objArr2 = (Object[]) Array.newInstance(m91f(), collection.size() + length);
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        }
        for (Object obj : collection) {
            objArr2[length] = obj;
            length++;
        }
        mo17072b(objArr2);
    }

    /* renamed from: e */
    public void mo17075e(Collection collection) {
        Object[] objArr = (Object[]) mo17071a();
        int i = 0;
        Object[] objArr2 = (Object[]) Array.newInstance(m91f(), (objArr == null ? 0 : objArr.length) + collection.size());
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, collection.size(), objArr.length);
        }
        for (Object obj : collection) {
            objArr2[i] = obj;
            i++;
        }
        mo17072b(objArr2);
    }
}
