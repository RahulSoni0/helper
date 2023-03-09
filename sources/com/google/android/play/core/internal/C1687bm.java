package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.bm */
public abstract class C1687bm extends C1703k implements C1688bn {
    public C1687bm() {
        super("com.google.android.play.core.splitinstall.protocol.ISplitInstallServiceCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo30881a(int i, Parcel parcel) throws RemoteException {
        switch (i) {
            case 2:
                mo30914i(parcel.readInt(), (Bundle) C1704l.m756a(parcel, Bundle.CREATOR));
                return true;
            case 3:
                int readInt = parcel.readInt();
                Bundle bundle = (Bundle) C1704l.m756a(parcel, Bundle.CREATOR);
                mo30916k(readInt);
                return true;
            case 4:
                mo30907b(parcel.readInt(), (Bundle) C1704l.m756a(parcel, Bundle.CREATOR));
                return true;
            case 5:
                mo30912g(parcel.readInt(), (Bundle) C1704l.m756a(parcel, Bundle.CREATOR));
                return true;
            case 6:
                mo30915j((Bundle) C1704l.m756a(parcel, Bundle.CREATOR));
                return true;
            case 7:
                mo30913h(parcel.createTypedArrayList(Bundle.CREATOR));
                return true;
            case 8:
                mo30911f((Bundle) C1704l.m756a(parcel, Bundle.CREATOR));
                return true;
            case 9:
                mo30908c((Bundle) C1704l.m756a(parcel, Bundle.CREATOR));
                return true;
            case 10:
                Bundle bundle2 = (Bundle) C1704l.m756a(parcel, Bundle.CREATOR);
                mo30918m();
                return true;
            case 11:
                Bundle bundle3 = (Bundle) C1704l.m756a(parcel, Bundle.CREATOR);
                mo30917l();
                return true;
            case 12:
                mo30909d((Bundle) C1704l.m756a(parcel, Bundle.CREATOR));
                return true;
            case 13:
                mo30910e((Bundle) C1704l.m756a(parcel, Bundle.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
