package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.tasks.C1786i;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.ar */
final class C1750ar extends C1752at<List<SplitInstallSessionState>> {
    C1750ar(C1753au auVar, C1786i<List<SplitInstallSessionState>> iVar) {
        super(auVar, iVar);
    }

    /* renamed from: h */
    public final void mo30913h(List<Bundle> list) throws RemoteException {
        super.mo30913h(list);
        ArrayList arrayList = new ArrayList(list.size());
        for (Bundle d : list) {
            arrayList.add(SplitInstallSessionState.m836d(d));
        }
        this.f951a.mo31066e(arrayList);
    }
}
