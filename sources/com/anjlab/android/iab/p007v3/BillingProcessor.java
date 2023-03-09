package com.anjlab.android.iab.p007v3;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: com.anjlab.android.iab.v3.BillingProcessor */
public class BillingProcessor extends BillingBase {
    private static final Date DATE_MERCHANT_LIMIT_1;
    private static final Date DATE_MERCHANT_LIMIT_2;
    private static final String LOG_TAG = "iabv3";
    private static final String MANAGED_PRODUCTS_CACHE_KEY = ".products.cache.v2_6";
    private static final int PURCHASE_FLOW_REQUEST_CODE = 32459;
    private static final String PURCHASE_PAYLOAD_CACHE_KEY = ".purchase.last.v2_6";
    private static final String RESTORE_KEY = ".products.restored.v2_6";
    private static final String SETTINGS_VERSION = ".v2_6";
    private static final String SUBSCRIPTIONS_CACHE_KEY = ".subscriptions.cache.v2_6";
    /* access modifiers changed from: private */
    public IInAppBillingService billingService;
    private BillingCache cachedProducts;
    private BillingCache cachedSubscriptions;
    private String contextPackageName;
    private String developerMerchantId;
    /* access modifiers changed from: private */
    public IBillingHandler eventHandler;
    private boolean isOneTimePurchaseExtraParamsSupported;
    private boolean isOneTimePurchasesSupported;
    private boolean isSubsUpdateSupported;
    private boolean isSubscriptionExtraParamsSupported;
    private ServiceConnection serviceConnection;
    private String signatureBase64;

    /* renamed from: com.anjlab.android.iab.v3.BillingProcessor$IBillingHandler */
    public interface IBillingHandler {
        void onBillingError(int i, Throwable th);

        void onBillingInitialized();

        void onProductPurchased(String str, TransactionDetails transactionDetails);

        void onPurchaseHistoryRestored();
    }

    static {
        Calendar instance = Calendar.getInstance();
        instance.set(2012, 11, 5);
        DATE_MERCHANT_LIMIT_1 = instance.getTime();
        instance.set(2015, 6, 21);
        DATE_MERCHANT_LIMIT_2 = instance.getTime();
    }

    /* renamed from: com.anjlab.android.iab.v3.BillingProcessor$HistoryInitializationTask */
    private class HistoryInitializationTask extends AsyncTask<Void, Void, Boolean> {
        private HistoryInitializationTask() {
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(Void... voidArr) {
            if (BillingProcessor.this.isPurchaseHistoryRestored()) {
                return false;
            }
            BillingProcessor.this.loadOwnedPurchasesFromGoogle();
            return true;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                BillingProcessor.this.setPurchaseHistoryRestored();
                if (BillingProcessor.this.eventHandler != null) {
                    BillingProcessor.this.eventHandler.onPurchaseHistoryRestored();
                }
            }
            if (BillingProcessor.this.eventHandler != null) {
                BillingProcessor.this.eventHandler.onBillingInitialized();
            }
        }
    }

    public static BillingProcessor newBillingProcessor(Context context, String str, IBillingHandler iBillingHandler) {
        return newBillingProcessor(context, str, (String) null, iBillingHandler);
    }

    public static BillingProcessor newBillingProcessor(Context context, String str, String str2, IBillingHandler iBillingHandler) {
        return new BillingProcessor(context, str, str2, iBillingHandler, false);
    }

    public BillingProcessor(Context context, String str, IBillingHandler iBillingHandler) {
        this(context, str, (String) null, iBillingHandler);
    }

    public BillingProcessor(Context context, String str, String str2, IBillingHandler iBillingHandler) {
        this(context, str, str2, iBillingHandler, true);
    }

    private BillingProcessor(Context context, String str, String str2, IBillingHandler iBillingHandler, boolean z) {
        super(context.getApplicationContext());
        this.serviceConnection = new ServiceConnection() {
            public void onServiceDisconnected(ComponentName componentName) {
                IInAppBillingService unused = BillingProcessor.this.billingService = null;
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                IInAppBillingService unused = BillingProcessor.this.billingService = IInAppBillingService.Stub.asInterface(iBinder);
                new HistoryInitializationTask().execute(new Void[0]);
            }
        };
        this.signatureBase64 = str;
        this.eventHandler = iBillingHandler;
        this.contextPackageName = getContext().getPackageName();
        this.cachedProducts = new BillingCache(getContext(), MANAGED_PRODUCTS_CACHE_KEY);
        this.cachedSubscriptions = new BillingCache(getContext(), SUBSCRIPTIONS_CACHE_KEY);
        this.developerMerchantId = str2;
        if (z) {
            bindPlayServices();
        }
    }

    public void initialize() {
        bindPlayServices();
    }

    private static Intent getBindServiceIntent() {
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        return intent;
    }

    private void bindPlayServices() {
        try {
            getContext().bindService(getBindServiceIntent(), this.serviceConnection, 1);
        } catch (Exception e) {
            Log.e(LOG_TAG, "error in bindPlayServices", e);
            reportBillingError(113, e);
        }
    }

    public static boolean isIabServiceAvailable(Context context) {
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(getBindServiceIntent(), 0);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            return false;
        }
        return true;
    }

    public void release() {
        if (isInitialized() && this.serviceConnection != null) {
            try {
                getContext().unbindService(this.serviceConnection);
            } catch (Exception e) {
                Log.e(LOG_TAG, "Error in release", e);
            }
            this.billingService = null;
        }
    }

    public boolean isInitialized() {
        return this.billingService != null;
    }

    public boolean isPurchased(String str) {
        return this.cachedProducts.includesProduct(str);
    }

    public boolean isSubscribed(String str) {
        return this.cachedSubscriptions.includesProduct(str);
    }

    public List<String> listOwnedProducts() {
        return this.cachedProducts.getContents();
    }

    public List<String> listOwnedSubscriptions() {
        return this.cachedSubscriptions.getContents();
    }

    private boolean loadPurchasesByType(String str, BillingCache billingCache) {
        if (!isInitialized()) {
            return false;
        }
        try {
            Bundle purchases = this.billingService.getPurchases(3, this.contextPackageName, str, (String) null);
            if (purchases.getInt(Constants.RESPONSE_CODE) == 0) {
                billingCache.clear();
                ArrayList<String> stringArrayList = purchases.getStringArrayList(Constants.INAPP_PURCHASE_DATA_LIST);
                ArrayList<String> stringArrayList2 = purchases.getStringArrayList(Constants.INAPP_DATA_SIGNATURE_LIST);
                if (stringArrayList == null) {
                    return true;
                }
                int i = 0;
                while (i < stringArrayList.size()) {
                    String str2 = stringArrayList.get(i);
                    if (!TextUtils.isEmpty(str2)) {
                        billingCache.put(new JSONObject(str2).getString(Constants.RESPONSE_PRODUCT_ID), str2, (stringArrayList2 == null || stringArrayList2.size() <= i) ? null : stringArrayList2.get(i));
                    }
                    i++;
                }
                return true;
            }
        } catch (Exception e) {
            reportBillingError(100, e);
            Log.e(LOG_TAG, "Error in loadPurchasesByType", e);
        }
        return false;
    }

    public boolean loadOwnedPurchasesFromGoogle() {
        return loadPurchasesByType("inapp", this.cachedProducts) && loadPurchasesByType("subs", this.cachedSubscriptions);
    }

    public boolean purchase(Activity activity, String str) {
        return purchase(activity, (List<String>) null, str, "inapp", (String) null);
    }

    public boolean subscribe(Activity activity, String str) {
        return purchase(activity, (List<String>) null, str, "subs", (String) null);
    }

    public boolean purchase(Activity activity, String str, String str2) {
        return purchase(activity, str, "inapp", str2);
    }

    public boolean subscribe(Activity activity, String str, String str2) {
        return purchase(activity, str, "subs", str2);
    }

    public boolean purchase(Activity activity, String str, String str2, Bundle bundle) {
        if (!isOneTimePurchaseWithExtraParamsSupported(bundle)) {
            return purchase(activity, str, str2);
        }
        return purchase(activity, (List<String>) null, str, "inapp", str2, bundle);
    }

    public boolean subscribe(Activity activity, String str, String str2, Bundle bundle) {
        if (!isSubscriptionWithExtraParamsSupported(bundle)) {
            bundle = null;
        }
        return purchase(activity, (List<String>) null, str, "subs", str2, bundle);
    }

    public boolean isOneTimePurchaseSupported() {
        boolean z = true;
        if (this.isOneTimePurchasesSupported) {
            return true;
        }
        try {
            if (this.billingService.isBillingSupported(3, this.contextPackageName, "inapp") != 0) {
                z = false;
            }
            this.isOneTimePurchasesSupported = z;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return this.isOneTimePurchasesSupported;
    }

    public boolean isSubscriptionUpdateSupported() {
        boolean z = true;
        if (this.isSubsUpdateSupported) {
            return true;
        }
        try {
            if (this.billingService.isBillingSupported(5, this.contextPackageName, "subs") != 0) {
                z = false;
            }
            this.isSubsUpdateSupported = z;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return this.isSubsUpdateSupported;
    }

    public boolean isSubscriptionWithExtraParamsSupported(Bundle bundle) {
        boolean z = true;
        if (this.isSubscriptionExtraParamsSupported) {
            return true;
        }
        try {
            if (this.billingService.isBillingSupportedExtraParams(7, this.contextPackageName, "subs", bundle) != 0) {
                z = false;
            }
            this.isSubscriptionExtraParamsSupported = z;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return this.isSubscriptionExtraParamsSupported;
    }

    public boolean isOneTimePurchaseWithExtraParamsSupported(Bundle bundle) {
        boolean z = true;
        if (this.isOneTimePurchaseExtraParamsSupported) {
            return true;
        }
        try {
            if (this.billingService.isBillingSupportedExtraParams(7, this.contextPackageName, "inapp", bundle) != 0) {
                z = false;
            }
            this.isOneTimePurchaseExtraParamsSupported = z;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return this.isOneTimePurchaseExtraParamsSupported;
    }

    public boolean updateSubscription(Activity activity, String str, String str2) {
        return updateSubscription(activity, str, str2, (String) null);
    }

    public boolean updateSubscription(Activity activity, String str, String str2, String str3) {
        return updateSubscription(activity, (List<String>) !TextUtils.isEmpty(str) ? Collections.singletonList(str) : null, str2, str3);
    }

    public boolean updateSubscription(Activity activity, List<String> list, String str) {
        return updateSubscription(activity, list, str, (String) null);
    }

    public boolean updateSubscription(Activity activity, List<String> list, String str, String str2) {
        if (list == null || isSubscriptionUpdateSupported()) {
            return purchase(activity, list, str, "subs", str2);
        }
        return false;
    }

    public boolean updateSubscription(Activity activity, List<String> list, String str, String str2, Bundle bundle) {
        if (list != null && !isSubscriptionUpdateSupported()) {
            return false;
        }
        if (!isSubscriptionWithExtraParamsSupported(bundle)) {
            return updateSubscription(activity, list, str, str2);
        }
        return purchase(activity, list, str, "subs", str2, bundle);
    }

    private boolean purchase(Activity activity, String str, String str2, String str3) {
        return purchase(activity, (List<String>) null, str, str2, str3);
    }

    private boolean purchase(Activity activity, List<String> list, String str, String str2, String str3) {
        return purchase(activity, list, str, str2, str3, (Bundle) null);
    }

    private boolean purchase(Activity activity, List<String> list, String str, String str2, String str3, Bundle bundle) {
        String str4;
        Bundle bundle2;
        List<String> list2 = list;
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        Bundle bundle3 = bundle;
        if (isInitialized() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String str8 = str6 + ":" + str5;
                if (!str6.equals("subs")) {
                    str8 = str8 + ":" + UUID.randomUUID().toString();
                }
                if (str7 != null) {
                    str4 = str8 + ":" + str7;
                } else {
                    str4 = str8;
                }
                savePurchasePayload(str4);
                if (list2 == null || !str6.equals("subs")) {
                    bundle2 = bundle3 == null ? this.billingService.getBuyIntent(3, this.contextPackageName, str, str2, str4) : this.billingService.getBuyIntentExtraParams(7, this.contextPackageName, str, str2, str4, bundle);
                } else if (bundle3 == null) {
                    bundle2 = this.billingService.getBuyIntentToReplaceSkus(5, this.contextPackageName, list, str, str2, str4);
                } else {
                    if (!bundle3.containsKey("skusToReplace")) {
                        bundle3.putStringArrayList("skusToReplace", new ArrayList(list2));
                    }
                    bundle2 = this.billingService.getBuyIntentExtraParams(7, this.contextPackageName, str, str2, str4, bundle);
                }
                if (bundle2 == null) {
                    return true;
                }
                int i = bundle2.getInt(Constants.RESPONSE_CODE);
                if (i == 0) {
                    PendingIntent pendingIntent = (PendingIntent) bundle2.getParcelable(Constants.BUY_INTENT);
                    if (activity == null || pendingIntent == null) {
                        reportBillingError(103, (Throwable) null);
                        return true;
                    }
                    activity.startIntentSenderForResult(pendingIntent.getIntentSender(), PURCHASE_FLOW_REQUEST_CODE, new Intent(), 0, 0, 0);
                    return true;
                } else if (i == 7) {
                    if (!isPurchased(str5) && !isSubscribed(str5)) {
                        loadOwnedPurchasesFromGoogle();
                    }
                    TransactionDetails purchaseTransactionDetails = getPurchaseTransactionDetails(str5);
                    if (!checkMerchant(purchaseTransactionDetails)) {
                        Log.i(LOG_TAG, "Invalid or tampered merchant id!");
                        reportBillingError(104, (Throwable) null);
                        return false;
                    } else if (this.eventHandler == null) {
                        return true;
                    } else {
                        if (purchaseTransactionDetails == null) {
                            purchaseTransactionDetails = getSubscriptionTransactionDetails(str5);
                        }
                        this.eventHandler.onProductPurchased(str5, purchaseTransactionDetails);
                        return true;
                    }
                } else {
                    reportBillingError(101, (Throwable) null);
                    return true;
                }
            } catch (Exception e) {
                Log.e(LOG_TAG, "Error in purchase", e);
                reportBillingError(110, e);
            }
        }
        return false;
    }

    private boolean checkMerchant(TransactionDetails transactionDetails) {
        int indexOf;
        if (this.developerMerchantId == null || transactionDetails.purchaseInfo.purchaseData.purchaseTime.before(DATE_MERCHANT_LIMIT_1) || transactionDetails.purchaseInfo.purchaseData.purchaseTime.after(DATE_MERCHANT_LIMIT_2)) {
            return true;
        }
        if (transactionDetails.purchaseInfo.purchaseData.orderId == null || transactionDetails.purchaseInfo.purchaseData.orderId.trim().length() == 0 || (indexOf = transactionDetails.purchaseInfo.purchaseData.orderId.indexOf(46)) <= 0 || transactionDetails.purchaseInfo.purchaseData.orderId.substring(0, indexOf).compareTo(this.developerMerchantId) != 0) {
            return false;
        }
        return true;
    }

    private TransactionDetails getPurchaseTransactionDetails(String str, BillingCache billingCache) {
        PurchaseInfo details = billingCache.getDetails(str);
        if (details == null || TextUtils.isEmpty(details.responseData)) {
            return null;
        }
        return new TransactionDetails(details);
    }

    public boolean consumePurchase(String str) {
        if (!isInitialized()) {
            return false;
        }
        try {
            TransactionDetails purchaseTransactionDetails = getPurchaseTransactionDetails(str, this.cachedProducts);
            if (purchaseTransactionDetails != null && !TextUtils.isEmpty(purchaseTransactionDetails.purchaseToken)) {
                int consumePurchase = this.billingService.consumePurchase(3, this.contextPackageName, purchaseTransactionDetails.purchaseToken);
                if (consumePurchase == 0) {
                    this.cachedProducts.remove(str);
                    Log.d(LOG_TAG, "Successfully consumed " + str + " purchase.");
                    return true;
                }
                reportBillingError(consumePurchase, (Throwable) null);
                Log.e(LOG_TAG, String.format("Failed to consume %s: %d", new Object[]{str, Integer.valueOf(consumePurchase)}));
            }
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error in consumePurchase", e);
            reportBillingError(111, e);
        }
        return false;
    }

    private SkuDetails getSkuDetails(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        List<SkuDetails> skuDetails = getSkuDetails((ArrayList<String>) arrayList, str2);
        if (skuDetails == null || skuDetails.size() <= 0) {
            return null;
        }
        return skuDetails.get(0);
    }

    private List<SkuDetails> getSkuDetails(ArrayList<String> arrayList, String str) {
        if (!(this.billingService == null || arrayList == null || arrayList.size() <= 0)) {
            try {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(Constants.PRODUCTS_LIST, arrayList);
                Bundle skuDetails = this.billingService.getSkuDetails(3, this.contextPackageName, str, bundle);
                int i = skuDetails.getInt(Constants.RESPONSE_CODE);
                if (i == 0) {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<String> stringArrayList = skuDetails.getStringArrayList(Constants.DETAILS_LIST);
                    if (stringArrayList != null) {
                        for (String jSONObject : stringArrayList) {
                            arrayList2.add(new SkuDetails(new JSONObject(jSONObject)));
                        }
                    }
                    return arrayList2;
                }
                reportBillingError(i, (Throwable) null);
                Log.e(LOG_TAG, String.format("Failed to retrieve info for %d products, %d", new Object[]{Integer.valueOf(arrayList.size()), Integer.valueOf(i)}));
            } catch (Exception e) {
                Log.e(LOG_TAG, "Failed to call getSkuDetails", e);
                reportBillingError(112, e);
            }
        }
        return null;
    }

    public SkuDetails getPurchaseListingDetails(String str) {
        return getSkuDetails(str, "inapp");
    }

    public SkuDetails getSubscriptionListingDetails(String str) {
        return getSkuDetails(str, "subs");
    }

    public List<SkuDetails> getPurchaseListingDetails(ArrayList<String> arrayList) {
        return getSkuDetails(arrayList, "inapp");
    }

    public List<SkuDetails> getSubscriptionListingDetails(ArrayList<String> arrayList) {
        return getSkuDetails(arrayList, "subs");
    }

    public TransactionDetails getPurchaseTransactionDetails(String str) {
        return getPurchaseTransactionDetails(str, this.cachedProducts);
    }

    public TransactionDetails getSubscriptionTransactionDetails(String str) {
        return getPurchaseTransactionDetails(str, this.cachedSubscriptions);
    }

    private String detectPurchaseTypeFromPurchaseResponseData(JSONObject jSONObject) {
        String purchasePayload = getPurchasePayload();
        if (!TextUtils.isEmpty(purchasePayload) && purchasePayload.startsWith("subs")) {
            return "subs";
        }
        if (jSONObject == null || !jSONObject.has(Constants.RESPONSE_AUTO_RENEWING)) {
            return "inapp";
        }
        return "subs";
    }

    public boolean handleActivityResult(int i, int i2, Intent intent) {
        if (i != PURCHASE_FLOW_REQUEST_CODE) {
            return false;
        }
        if (intent == null) {
            Log.e(LOG_TAG, "handleActivityResult: data is null!");
            return false;
        }
        int intExtra = intent.getIntExtra(Constants.RESPONSE_CODE, 0);
        Log.d(LOG_TAG, String.format("resultCode = %d, responseCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(intExtra)}));
        if (i2 == -1 && intExtra == 0) {
            String stringExtra = intent.getStringExtra(Constants.INAPP_PURCHASE_DATA);
            String stringExtra2 = intent.getStringExtra(Constants.RESPONSE_INAPP_SIGNATURE);
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                String string = jSONObject.getString(Constants.RESPONSE_PRODUCT_ID);
                if (verifyPurchaseSignature(string, stringExtra, stringExtra2)) {
                    (detectPurchaseTypeFromPurchaseResponseData(jSONObject).equals("subs") ? this.cachedSubscriptions : this.cachedProducts).put(string, stringExtra, stringExtra2);
                    IBillingHandler iBillingHandler = this.eventHandler;
                    if (iBillingHandler != null) {
                        iBillingHandler.onProductPurchased(string, new TransactionDetails(new PurchaseInfo(stringExtra, stringExtra2)));
                    }
                } else {
                    Log.e(LOG_TAG, "Public key signature doesn't match!");
                    reportBillingError(102, (Throwable) null);
                }
            } catch (Exception e) {
                Log.e(LOG_TAG, "Error in handleActivityResult", e);
                reportBillingError(110, e);
            }
            savePurchasePayload((String) null);
        } else {
            reportBillingError(intExtra, (Throwable) null);
        }
        return true;
    }

    private boolean verifyPurchaseSignature(String str, String str2, String str3) {
        try {
            if (TextUtils.isEmpty(this.signatureBase64) || Security.verifyPurchase(str, this.signatureBase64, str2, str3)) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isValidTransactionDetails(TransactionDetails transactionDetails) {
        return verifyPurchaseSignature(transactionDetails.productId, transactionDetails.purchaseInfo.responseData, transactionDetails.purchaseInfo.signature) && checkMerchant(transactionDetails);
    }

    /* access modifiers changed from: private */
    public boolean isPurchaseHistoryRestored() {
        return loadBoolean(getPreferencesBaseKey() + RESTORE_KEY, false);
    }

    /* access modifiers changed from: private */
    public void setPurchaseHistoryRestored() {
        saveBoolean(getPreferencesBaseKey() + RESTORE_KEY, true);
    }

    private void savePurchasePayload(String str) {
        saveString(getPreferencesBaseKey() + PURCHASE_PAYLOAD_CACHE_KEY, str);
    }

    private String getPurchasePayload() {
        return loadString(getPreferencesBaseKey() + PURCHASE_PAYLOAD_CACHE_KEY, (String) null);
    }

    private void reportBillingError(int i, Throwable th) {
        IBillingHandler iBillingHandler = this.eventHandler;
        if (iBillingHandler != null) {
            iBillingHandler.onBillingError(i, th);
        }
    }
}
