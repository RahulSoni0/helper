package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.u */
public abstract class C1713u extends C1703k implements C1714v {
    public C1713u() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetModuleServiceCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo30881a(int i, Parcel parcel) throws RemoteException {
        switch (i) {
            case 2:
                mo30680b(parcel.readInt(), (Bundle) C1704l.m756a(parcel, Bundle.CREATOR));
                return true;
            case 3:
                int readInt = parcel.readInt();
                Bundle bundle = (Bundle) C1704l.m756a(parcel, Bundle.CREATOR);
                mo30686h(readInt);
                return true;
            case 4:
                int readInt2 = parcel.readInt();
                Bundle bundle2 = (Bundle) C1704l.m756a(parcel, Bundle.CREATOR);
                mo30688j(readInt2);
                return true;
            case 5:
                mo30681c(parcel.createTypedArrayList(Bundle.CREATOR));
                return true;
            case 6:
                Bundle bundle3 = (Bundle) C1704l.m756a(parcel, Bundle.CREATOR);
                mo30689k((Bundle) C1704l.m756a(parcel, Bundle.CREATOR));
                return true;
            case 7:
                mo30685g((Bundle) C1704l.m756a(parcel, Bundle.CREATOR));
                return true;
            case 8:
                Bundle bundle4 = (Bundle) C1704l.m756a(parcel, Bundle.CREATOR);
                mo30690l((Bundle) C1704l.m756a(parcel, Bundle.CREATOR));
                return true;
            case 10:
                Bundle bundle5 = (Bundle) C1704l.m756a(parcel, Bundle.CREATOR);
                mo30691m((Bundle) C1704l.m756a(parcel, Bundle.CREATOR));
                return true;
            case 11:
                mo30682d((Bundle) C1704l.m756a(parcel, Bundle.CREATOR), (Bundle) C1704l.m756a(parcel, Bundle.CREATOR));
                return true;
            case 12:
                mo30683e((Bundle) C1704l.m756a(parcel, Bundle.CREATOR), (Bundle) C1704l.m756a(parcel, Bundle.CREATOR));
                return true;
            case 13:
                mo30684f((Bundle) C1704l.m756a(parcel, Bundle.CREATOR), (Bundle) C1704l.m756a(parcel, Bundle.CREATOR));
                return true;
            case 14:
                Bundle bundle6 = (Bundle) C1704l.m756a(parcel, Bundle.CREATOR);
                Bundle bundle7 = (Bundle) C1704l.m756a(parcel, Bundle.CREATOR);
                mo30692n();
                return true;
            case 15:
                Bundle bundle8 = (Bundle) C1704l.m756a(parcel, Bundle.CREATOR);
                mo30687i();
                return true;
            default:
                return false;
        }
    }
}
