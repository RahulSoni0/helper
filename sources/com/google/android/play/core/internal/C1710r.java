package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.r */
public final class C1710r extends C1702j implements C1712t {
    C1710r(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
    }

    /* renamed from: c */
    public final void mo30954c(String str, List<Bundle> list, Bundle bundle, C1714v vVar) throws RemoteException {
        Parcel a = mo30947a();
        a.writeString(str);
        a.writeTypedList(list);
        C1704l.m757b(a, bundle);
        C1704l.m758c(a, vVar);
        mo30949b(2, a);
    }

    /* renamed from: d */
    public final void mo30955d(String str, List<Bundle> list, Bundle bundle, C1714v vVar) throws RemoteException {
        Parcel a = mo30947a();
        a.writeString(str);
        a.writeTypedList(list);
        C1704l.m757b(a, bundle);
        C1704l.m758c(a, vVar);
        mo30949b(14, a);
    }

    /* renamed from: e */
    public final void mo30956e(String str, Bundle bundle, C1714v vVar) throws RemoteException {
        Parcel a = mo30947a();
        a.writeString(str);
        C1704l.m757b(a, bundle);
        C1704l.m758c(a, vVar);
        mo30949b(5, a);
    }

    /* renamed from: f */
    public final void mo30957f(String str, Bundle bundle, Bundle bundle2, C1714v vVar) throws RemoteException {
        Parcel a = mo30947a();
        a.writeString(str);
        C1704l.m757b(a, bundle);
        C1704l.m757b(a, bundle2);
        C1704l.m758c(a, vVar);
        mo30949b(6, a);
    }

    /* renamed from: g */
    public final void mo30958g(String str, Bundle bundle, Bundle bundle2, C1714v vVar) throws RemoteException {
        Parcel a = mo30947a();
        a.writeString(str);
        C1704l.m757b(a, bundle);
        C1704l.m757b(a, bundle2);
        C1704l.m758c(a, vVar);
        mo30949b(7, a);
    }

    /* renamed from: h */
    public final void mo30959h(String str, Bundle bundle, Bundle bundle2, C1714v vVar) throws RemoteException {
        Parcel a = mo30947a();
        a.writeString(str);
        C1704l.m757b(a, bundle);
        C1704l.m757b(a, bundle2);
        C1704l.m758c(a, vVar);
        mo30949b(9, a);
    }

    /* renamed from: i */
    public final void mo30960i(String str, Bundle bundle, C1714v vVar) throws RemoteException {
        Parcel a = mo30947a();
        a.writeString(str);
        C1704l.m757b(a, bundle);
        C1704l.m758c(a, vVar);
        mo30949b(10, a);
    }

    /* renamed from: j */
    public final void mo30961j(String str, Bundle bundle, Bundle bundle2, C1714v vVar) throws RemoteException {
        Parcel a = mo30947a();
        a.writeString(str);
        C1704l.m757b(a, bundle);
        C1704l.m757b(a, bundle2);
        C1704l.m758c(a, vVar);
        mo30949b(11, a);
    }

    /* renamed from: k */
    public final void mo30962k(String str, List<Bundle> list, Bundle bundle, C1714v vVar) throws RemoteException {
        Parcel a = mo30947a();
        a.writeString(str);
        a.writeTypedList(list);
        C1704l.m757b(a, bundle);
        C1704l.m758c(a, vVar);
        mo30949b(12, a);
    }

    /* renamed from: l */
    public final void mo30963l(String str, Bundle bundle, Bundle bundle2, C1714v vVar) throws RemoteException {
        Parcel a = mo30947a();
        a.writeString(str);
        C1704l.m757b(a, bundle);
        C1704l.m757b(a, bundle2);
        C1704l.m758c(a, vVar);
        mo30949b(13, a);
    }
}
