package com.android.vending.billing;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface IInAppBillingService extends IInterface {
    int consumePurchase(int i, String str, String str2) throws RemoteException;

    Bundle getBuyIntent(int i, String str, String str2, String str3, String str4) throws RemoteException;

    Bundle getBuyIntentExtraParams(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException;

    Bundle getBuyIntentToReplaceSkus(int i, String str, List<String> list, String str2, String str3, String str4) throws RemoteException;

    Bundle getPurchaseHistory(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException;

    Bundle getPurchases(int i, String str, String str2, String str3) throws RemoteException;

    Bundle getSkuDetails(int i, String str, String str2, Bundle bundle) throws RemoteException;

    int isBillingSupported(int i, String str, String str2) throws RemoteException;

    int isBillingSupportedExtraParams(int i, String str, String str2, Bundle bundle) throws RemoteException;

    int stub(int i, String str, String str2) throws RemoteException;

    public static abstract class Stub extends Binder implements IInAppBillingService {
        private static final String DESCRIPTOR = "com.android.vending.billing.IInAppBillingService";
        static final int TRANSACTION_consumePurchase = 5;
        static final int TRANSACTION_getBuyIntent = 3;
        static final int TRANSACTION_getBuyIntentExtraParams = 8;
        static final int TRANSACTION_getBuyIntentToReplaceSkus = 7;
        static final int TRANSACTION_getPurchaseHistory = 9;
        static final int TRANSACTION_getPurchases = 4;
        static final int TRANSACTION_getSkuDetails = 2;
        static final int TRANSACTION_isBillingSupported = 1;
        static final int TRANSACTION_isBillingSupportedExtraParams = 10;
        static final int TRANSACTION_stub = 6;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IInAppBillingService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IInAppBillingService)) {
                return new Proxy(iBinder);
            }
            return (IInAppBillingService) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v16, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v20, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: android.os.Bundle} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r12, android.os.Parcel r13, android.os.Parcel r14, int r15) throws android.os.RemoteException {
            /*
                r11 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                java.lang.String r1 = "com.android.vending.billing.IInAppBillingService"
                r2 = 1
                if (r12 == r0) goto L_0x01b2
                r0 = 0
                r3 = 0
                switch(r12) {
                    case 1: goto L_0x0198;
                    case 2: goto L_0x0166;
                    case 3: goto L_0x013a;
                    case 4: goto L_0x0113;
                    case 5: goto L_0x00f9;
                    case 6: goto L_0x00df;
                    case 7: goto L_0x00af;
                    case 8: goto L_0x0073;
                    case 9: goto L_0x003b;
                    case 10: goto L_0x0012;
                    default: goto L_0x000d;
                }
            L_0x000d:
                boolean r12 = super.onTransact(r12, r13, r14, r15)
                return r12
            L_0x0012:
                r13.enforceInterface(r1)
                int r12 = r13.readInt()
                java.lang.String r15 = r13.readString()
                java.lang.String r1 = r13.readString()
                int r3 = r13.readInt()
                if (r3 == 0) goto L_0x0030
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r13 = r0.createFromParcel(r13)
                r0 = r13
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0030:
                int r12 = r11.isBillingSupportedExtraParams(r12, r15, r1, r0)
                r14.writeNoException()
                r14.writeInt(r12)
                return r2
            L_0x003b:
                r13.enforceInterface(r1)
                int r5 = r13.readInt()
                java.lang.String r6 = r13.readString()
                java.lang.String r7 = r13.readString()
                java.lang.String r8 = r13.readString()
                int r12 = r13.readInt()
                if (r12 == 0) goto L_0x005d
                android.os.Parcelable$Creator r12 = android.os.Bundle.CREATOR
                java.lang.Object r12 = r12.createFromParcel(r13)
                r0 = r12
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x005d:
                r9 = r0
                r4 = r11
                android.os.Bundle r12 = r4.getPurchaseHistory(r5, r6, r7, r8, r9)
                r14.writeNoException()
                if (r12 == 0) goto L_0x006f
                r14.writeInt(r2)
                r12.writeToParcel(r14, r2)
                goto L_0x0072
            L_0x006f:
                r14.writeInt(r3)
            L_0x0072:
                return r2
            L_0x0073:
                r13.enforceInterface(r1)
                int r5 = r13.readInt()
                java.lang.String r6 = r13.readString()
                java.lang.String r7 = r13.readString()
                java.lang.String r8 = r13.readString()
                java.lang.String r9 = r13.readString()
                int r12 = r13.readInt()
                if (r12 == 0) goto L_0x0099
                android.os.Parcelable$Creator r12 = android.os.Bundle.CREATOR
                java.lang.Object r12 = r12.createFromParcel(r13)
                r0 = r12
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0099:
                r10 = r0
                r4 = r11
                android.os.Bundle r12 = r4.getBuyIntentExtraParams(r5, r6, r7, r8, r9, r10)
                r14.writeNoException()
                if (r12 == 0) goto L_0x00ab
                r14.writeInt(r2)
                r12.writeToParcel(r14, r2)
                goto L_0x00ae
            L_0x00ab:
                r14.writeInt(r3)
            L_0x00ae:
                return r2
            L_0x00af:
                r13.enforceInterface(r1)
                int r5 = r13.readInt()
                java.lang.String r6 = r13.readString()
                java.util.ArrayList r7 = r13.createStringArrayList()
                java.lang.String r8 = r13.readString()
                java.lang.String r9 = r13.readString()
                java.lang.String r10 = r13.readString()
                r4 = r11
                android.os.Bundle r12 = r4.getBuyIntentToReplaceSkus(r5, r6, r7, r8, r9, r10)
                r14.writeNoException()
                if (r12 == 0) goto L_0x00db
                r14.writeInt(r2)
                r12.writeToParcel(r14, r2)
                goto L_0x00de
            L_0x00db:
                r14.writeInt(r3)
            L_0x00de:
                return r2
            L_0x00df:
                r13.enforceInterface(r1)
                int r12 = r13.readInt()
                java.lang.String r15 = r13.readString()
                java.lang.String r13 = r13.readString()
                int r12 = r11.stub(r12, r15, r13)
                r14.writeNoException()
                r14.writeInt(r12)
                return r2
            L_0x00f9:
                r13.enforceInterface(r1)
                int r12 = r13.readInt()
                java.lang.String r15 = r13.readString()
                java.lang.String r13 = r13.readString()
                int r12 = r11.consumePurchase(r12, r15, r13)
                r14.writeNoException()
                r14.writeInt(r12)
                return r2
            L_0x0113:
                r13.enforceInterface(r1)
                int r12 = r13.readInt()
                java.lang.String r15 = r13.readString()
                java.lang.String r0 = r13.readString()
                java.lang.String r13 = r13.readString()
                android.os.Bundle r12 = r11.getPurchases(r12, r15, r0, r13)
                r14.writeNoException()
                if (r12 == 0) goto L_0x0136
                r14.writeInt(r2)
                r12.writeToParcel(r14, r2)
                goto L_0x0139
            L_0x0136:
                r14.writeInt(r3)
            L_0x0139:
                return r2
            L_0x013a:
                r13.enforceInterface(r1)
                int r5 = r13.readInt()
                java.lang.String r6 = r13.readString()
                java.lang.String r7 = r13.readString()
                java.lang.String r8 = r13.readString()
                java.lang.String r9 = r13.readString()
                r4 = r11
                android.os.Bundle r12 = r4.getBuyIntent(r5, r6, r7, r8, r9)
                r14.writeNoException()
                if (r12 == 0) goto L_0x0162
                r14.writeInt(r2)
                r12.writeToParcel(r14, r2)
                goto L_0x0165
            L_0x0162:
                r14.writeInt(r3)
            L_0x0165:
                return r2
            L_0x0166:
                r13.enforceInterface(r1)
                int r12 = r13.readInt()
                java.lang.String r15 = r13.readString()
                java.lang.String r1 = r13.readString()
                int r4 = r13.readInt()
                if (r4 == 0) goto L_0x0184
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r13 = r0.createFromParcel(r13)
                r0 = r13
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0184:
                android.os.Bundle r12 = r11.getSkuDetails(r12, r15, r1, r0)
                r14.writeNoException()
                if (r12 == 0) goto L_0x0194
                r14.writeInt(r2)
                r12.writeToParcel(r14, r2)
                goto L_0x0197
            L_0x0194:
                r14.writeInt(r3)
            L_0x0197:
                return r2
            L_0x0198:
                r13.enforceInterface(r1)
                int r12 = r13.readInt()
                java.lang.String r15 = r13.readString()
                java.lang.String r13 = r13.readString()
                int r12 = r11.isBillingSupported(r12, r15, r13)
                r14.writeNoException()
                r14.writeInt(r12)
                return r2
            L_0x01b2:
                r14.writeString(r1)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.vending.billing.IInAppBillingService.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }

        private static class Proxy implements IInAppBillingService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public int isBillingSupported(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getSkuDetails(int i, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getBuyIntent(int i, String str, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getPurchases(int i, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int consumePurchase(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int stub(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getBuyIntentToReplaceSkus(int i, String str, List<String> list, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeStringList(list);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getBuyIntentExtraParams(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getPurchaseHistory(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int isBillingSupportedExtraParams(int i, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
