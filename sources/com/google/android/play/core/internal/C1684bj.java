package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.bj */
public final class C1684bj extends C1702j implements C1686bl {
    C1684bj(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
    }

    /* renamed from: c */
    public final void mo30899c(String str, List<Bundle> list, Bundle bundle, C1688bn bnVar) throws RemoteException {
        Parcel a = mo30947a();
        a.writeString(str);
        a.writeTypedList(list);
        C1704l.m757b(a, bundle);
        C1704l.m758c(a, bnVar);
        mo30949b(2, a);
    }

    /* renamed from: d */
    public final void mo30900d(String str, int i, Bundle bundle, C1688bn bnVar) throws RemoteException {
        Parcel a = mo30947a();
        a.writeString(str);
        a.writeInt(i);
        C1704l.m757b(a, bundle);
        C1704l.m758c(a, bnVar);
        mo30949b(4, a);
    }

    /* renamed from: e */
    public final void mo30901e(String str, int i, C1688bn bnVar) throws RemoteException {
        Parcel a = mo30947a();
        a.writeString(str);
        a.writeInt(i);
        C1704l.m758c(a, bnVar);
        mo30949b(5, a);
    }

    /* renamed from: f */
    public final void mo30902f(String str, C1688bn bnVar) throws RemoteException {
        Parcel a = mo30947a();
        a.writeString(str);
        C1704l.m758c(a, bnVar);
        mo30949b(6, a);
    }

    /* renamed from: g */
    public final void mo30903g(String str, List<Bundle> list, Bundle bundle, C1688bn bnVar) throws RemoteException {
        Parcel a = mo30947a();
        a.writeString(str);
        a.writeTypedList(list);
        C1704l.m757b(a, bundle);
        C1704l.m758c(a, bnVar);
        mo30949b(7, a);
    }

    /* renamed from: h */
    public final void mo30904h(String str, List<Bundle> list, Bundle bundle, C1688bn bnVar) throws RemoteException {
        Parcel a = mo30947a();
        a.writeString(str);
        a.writeTypedList(list);
        C1704l.m757b(a, bundle);
        C1704l.m758c(a, bnVar);
        mo30949b(8, a);
    }

    /* renamed from: i */
    public final void mo30905i(String str, List<Bundle> list, Bundle bundle, C1688bn bnVar) throws RemoteException {
        Parcel a = mo30947a();
        a.writeString(str);
        a.writeTypedList(list);
        C1704l.m757b(a, bundle);
        C1704l.m758c(a, bnVar);
        mo30949b(13, a);
    }

    /* renamed from: j */
    public final void mo30906j(String str, List<Bundle> list, Bundle bundle, C1688bn bnVar) throws RemoteException {
        Parcel a = mo30947a();
        a.writeString(str);
        a.writeTypedList(list);
        C1704l.m757b(a, bundle);
        C1704l.m758c(a, bnVar);
        mo30949b(14, a);
    }
}
