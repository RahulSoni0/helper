package com.xsar.handwriter;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.SkuDetailsResponseListener;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class activity_next$$ExternalSyntheticLambda1 implements SkuDetailsResponseListener {
    public final /* synthetic */ activity_next f$0;

    public /* synthetic */ activity_next$$ExternalSyntheticLambda1(activity_next activity_next) {
        this.f$0 = activity_next;
    }

    public final void onSkuDetailsResponse(BillingResult billingResult, List list) {
        this.f$0.m1931lambda$initiatePurchase$0$comxsarhandwriteractivity_next(billingResult, list);
    }
}
