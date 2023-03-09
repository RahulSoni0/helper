package com.anjlab.android.iab.p007v3;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.anjlab.android.iab.v3.TransactionDetails */
public class TransactionDetails implements Parcelable {
    public static final Parcelable.Creator<TransactionDetails> CREATOR = new Parcelable.Creator<TransactionDetails>() {
        public TransactionDetails createFromParcel(Parcel parcel) {
            return new TransactionDetails(parcel);
        }

        public TransactionDetails[] newArray(int i) {
            return new TransactionDetails[i];
        }
    };
    @Deprecated
    public final String orderId;
    @Deprecated
    public final String productId;
    public final PurchaseInfo purchaseInfo;
    @Deprecated
    public final Date purchaseTime;
    @Deprecated
    public final String purchaseToken;

    public int describeContents() {
        return 0;
    }

    public TransactionDetails(PurchaseInfo purchaseInfo2) {
        this.purchaseInfo = purchaseInfo2;
        this.productId = purchaseInfo2.purchaseData.productId;
        this.orderId = purchaseInfo2.purchaseData.orderId;
        this.purchaseToken = purchaseInfo2.purchaseData.purchaseToken;
        this.purchaseTime = purchaseInfo2.purchaseData.purchaseTime;
    }

    public String toString() {
        return String.format(Locale.US, "%s purchased at %s(%s). Token: %s, Signature: %s", new Object[]{this.productId, this.purchaseTime, this.orderId, this.purchaseToken, this.purchaseInfo.signature});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.orderId;
        String str2 = ((TransactionDetails) obj).orderId;
        if (str != null) {
            if (!str.equals(str2)) {
                return false;
            }
            return true;
        } else if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.orderId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.purchaseInfo, i);
    }

    protected TransactionDetails(Parcel parcel) {
        PurchaseInfo purchaseInfo2 = (PurchaseInfo) parcel.readParcelable(PurchaseInfo.class.getClassLoader());
        this.purchaseInfo = purchaseInfo2;
        this.productId = purchaseInfo2.purchaseData.productId;
        this.orderId = purchaseInfo2.purchaseData.orderId;
        this.purchaseToken = purchaseInfo2.purchaseData.purchaseToken;
        this.purchaseTime = purchaseInfo2.purchaseData.purchaseTime;
    }
}
