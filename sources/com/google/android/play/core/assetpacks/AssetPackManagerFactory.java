package com.google.android.play.core.assetpacks;

import android.content.Context;

public class AssetPackManagerFactory {
    public static synchronized AssetPackManager getInstance(Context context) {
        AssetPackManager a;
        synchronized (AssetPackManagerFactory.class) {
            a = C1615ck.m563j(context).mo30677a();
        }
        return a;
    }
}
