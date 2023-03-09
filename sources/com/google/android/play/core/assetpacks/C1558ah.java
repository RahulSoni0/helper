package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.play.core.tasks.C1786i;

/* renamed from: com.google.android.play.core.assetpacks.ah */
final class C1558ah extends C1557ag<ParcelFileDescriptor> {
    C1558ah(C1564an anVar, C1786i<ParcelFileDescriptor> iVar) {
        super(anVar, iVar);
    }

    /* renamed from: e */
    public final void mo30683e(Bundle bundle, Bundle bundle2) throws RemoteException {
        super.mo30683e(bundle, bundle2);
        this.f463a.mo31066e((ParcelFileDescriptor) bundle.getParcelable("chunk_file_descriptor"));
    }
}
